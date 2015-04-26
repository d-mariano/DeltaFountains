#! /usr/bin/env python

##  @package pyDeltaServer
#   A server script written in Python that sends GCode commands
#   to a delta robot.
#
#   The commands sent to the robot are determined by selections made on an 
#   Android or Web-Based client.  The delta bot will have G-code G-code 
#   compatible firmware installed on its control board.  This script uses 
#   Printrun libraries provided by kliment on GitHub.
#      
#   The server begins by waiting for a client.  When a client connects, the 
#   server will attempt to connect to a printer on /dev/ttyACM0.  If this 
#   fails, it will attempt to connect to a printer on /dev/ttyACM1; it is 
#   possible that the device name will change from either one of these.  If 
#   neither one of these attempts succeed, then the server will begin with 
#
#   no printer connection.  This is especially useful for debugging client
#   to server communication without having to connect to a control board.
#
#   Author:     Dave Mariano
#   Date:       Feb 1, 2015
#   Filename:   pyDeltaServer.py
#   Github:     github.com/d-mariano/DeltaLaser   
#
import socket
import sys
import time
import thread
import signal
import os

from printrun.printcore import printcore
from printrun.utils import setup_logging
from printrun import gcoder

## Based on client messages, send commands to the printer.
#
# Relate messages received from the client with particular
# G-code commands for the printer.  The control board can
# support SD cards, but commands can also be issued in-line.
def sendcommand( command, socket ):
    if ( command == "neutral" ):
        print command
        p.send_now("G1 Z80 Y80 X80")
    
    if ( command == "north" ):
        print command
        p.send_now("G1 Z60 Y100 X100")
        # SD Card Commands
        #print "Loading \"north.gcoode\""
        #p.send_now("M23 north.gcoode")
        #p.send_now("M24")
    elif ( command == "south" ):
        print command
        p.send_now("G1 Z100 Y60 X60")
        #print "Loading \"south.gcode\""
        #p.send_now("M23 south.gcode")
        #p.send_now("M24")
    elif ( command == "east" ):
        print command
        p.send_now("G1 Z80 Y60 X100")
        #print "Loading \"east.gcode\""
        #p.send_now("M23 east.gcode")
        #p.send_now("M24")
    elif ( command == "west" ):
        print command
        p.send_now("G1 Z80 Y100 X60")
        #print "Loading \"west.gcode\""
        #p.send_now("M23 west.gcode")
        #p.send_now("M24")

    elif ( command == "northeast" ):
        print command 
        p.send_now("G1 Z60 Y90 X110")
    elif ( command == "northwest" ):
        print command
        p.send_now("G1 Z60 Y110 X90")
    elif ( command == "southeast" ):
        print command
        p.send_now("G1 Z100 Y50 X70")
    elif ( command == "southwest" ):
        print command
        p.send_now("G1 Z100 Y70 X50")

    elif ( command == "home" ):
        p.send_now("G28")

    elif ( command == "disconnect" ):
        print command
        #print "Disconnecting from robot..."
        p.disconnect()
    else:
        socket.send("Command not found\n");

## Receiver function to handle a client's input
#
# Run this function in a separate  thread to implement 
# asynchronous client/server communication.
def receiver( socket ):
    while True:
        try:
            input = socket.recv(1024)
            # Srip string of a newline
            input = input.strip( '\n' )
            print "Recieved: %s\n" % (input)
            if ( input == "exit" ):
                p.disconnect()
                socket.close()
                print "Client gone...\n"
                return
            else:
                try:
                    sendcommand( input, socket )
                except:
                    print "Client gone...\n"
                    p.disconnect()
                    socket.close()
                    return
        except:
            print "Socket closed"
            p.disconnect()
            socket.close()
            print "Client gone...\n"
            return

        

##
# Handler for keyboard interrupt
#
def sigintHandler(signum, frame):
    p.disconnect()
    s.close()
    c.close()
    sys.exit(1)

######################################################
# Begin script with logging to stderr and binding to a 
# socket on port 43000.  If a client connects, try and
# connect to a printer.

# Initialize sigint handler
signal.signal(signal.SIGINT, sigintHandler)

# Setup logging to stderr
setup_logging(sys.stderr)

# Initialize printcore
p = printcore()

s = socket.socket()         # Create a socket object
host = '0.0.0.0' 
port = 43000              

try:
    # Setup a stream socket with the host and port specified above.
    s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    s.bind((host,port))         # Bind to the port
except Exception,e:
    print "Failed to bind socket to ", port
    print str(e)
    s.close()
    sys.exit(1)

s.listen(5)                 # Now wait for client connection
print "%s listening on port %s" % (host, port)

while True :
    c, addr = s.accept()    # Establish connection with client
    print "Got connection from ", c

    #######   Connect to the printer  #########
    try:
        p.connect('/dev/ttyACM0', 115200)
    except Exception,e:
        print str(e)
        try:
            p = printcore('/dev/ttyACM1', 115200)
        except Exception,e2:    
            print "No printer connected, now in debugging mode."

    time.sleep(2)   # Wait for printer to connect

    thread.start_new_thread( receiver, ( c, ) ) # Begin receiver thread
    c.send("Server awaiting commands...\n")
    p.send_now("G28 X Y Z")
    p.send_now("G1 Z80 Y80 X80")

