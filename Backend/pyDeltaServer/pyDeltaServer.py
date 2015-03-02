#! /usr/bin/env python
##########################################################################   
#   
#   Author:     Dave Mariano
#   Date:       Feb 1, 2015
#   Filename:   pyDeltaServer.py
#
#   A server script written in python that sends GCode commands
#   to a delta robot.  The commands sent to the robot are determined
#   by selections made on an Android or Web-Based client.  The delta bot 
#   will have G-code compatible firmware.  This script uses printrun 
#   libraries provided by kliment.
#   
#########################################################################
import socket
import sys
import time
import thread

from printrun.printcore import printcore
from printrun.utils import setup_logging
from printrun import gcoder

######################################################
# Send chosen command to the delta bot control board
# The control board uses an SD card with stored GCode
# The commands sent from the client will determine 
# which code is run
######################################################
def sendcommand( command, socket ):
    if ( command == "north" ) :
        print "Loading \"north.gco\""
        p.send_now("M23 north.gco")
        p.send_now("M24")
    elif ( command == "south" ):
        print "Loading \"south.gco\""
        p.send_now("M23 south.gco")
        p.send_now("M24")
    elif ( command == "east" ):
        print "Loading \"east.gco\""
        p.send_now("M23 east.gco")
        p.send_now("M24")
    elif ( command == "west" ):
        print "Loading \"west.gco\""
        p.send_now("M23 west.gco")
        p.send_now("M24")
    elif ( command == "disconnect" ):
        print "Disconnecting from robot..."
        p.disconnect()
    else:
        socket.send("Command not found\n");

######################################################
# Receive in a thread to implement asynchronous 
# communication.
######################################################
def receiver( socket ):
    while True:
        try:
            input = socket.recv(1024)
            # Srip string of a newline
            input = input.strip( '\n' )
        except:
            print "Socket closed"
        print "Recieved: %s\n" % (input)
        if ( input == "exit" ):
            socket.close()

        else:
            try:
                sendcommand( input, socket )
            except:
                print "Client gone...\n"
                close = True
                socket.close()
                return

#####################################################
# Begin script with logging to stderr and opening a 
# connection to the control board
#####################################################
# Setup logging to stderr
setup_logging(sys.stderr)
# Connect to robot
p = printcore('/dev/ttyUSB0', 115200)
# Initialize SD Card
p.send_now('M21')

s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 43000                # Reserve a port for your service
s.bind((host,port))         # Bind to the port

s.listen(5)                 # Now wait for client connection
print "%s listening on port %s" % (host, port)

while True :
    c, addr = s.accept()    # Establish connection with client
    print "Got connection from", addr
    thread.start_new_thread( receiver, ( c, ) ) # Begin receiver thread
    c.send("Server awaiting commands...\n")

