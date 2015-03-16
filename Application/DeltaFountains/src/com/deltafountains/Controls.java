/* Controls Screen (joystick) of the App
 * Project Delta Fountains
 */

package com.deltafountains;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Controls extends Activity {

	RelativeLayout layout_joystick;
	ImageView image_joystick, image_border;
	TextView xAxisValue, yAxisValue, angleValue, distanceValue, directionValue;
	
	JoyStickClass js;
	
	private Socket socket;

    private static final int SERVERPORT = 43000;
    private static final String SERVER_IP = "192.168.0.1";
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);

        new Thread(new ClientThread()).start();
        
        xAxisValue = (TextView)findViewById(R.id.textView1);
        yAxisValue = (TextView)findViewById(R.id.textView2);
        angleValue = (TextView)findViewById(R.id.textView3);
        distanceValue = (TextView)findViewById(R.id.textView4);
        directionValue = (TextView)findViewById(R.id.textView5);
        
	    layout_joystick = (RelativeLayout)findViewById(R.id.layout_joystick);

        js = new JoyStickClass(getApplicationContext()
        		, layout_joystick, R.drawable.image_button);
	    js.setStickSize(150, 150);
	    js.setLayoutSize(500, 500);
	    js.setLayoutAlpha(150);
	    js.setStickAlpha(100);
	    js.setOffset(90);
	    js.setMinimumDistance(50);
	    
	    layout_joystick.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View arg0, MotionEvent arg1) {
				js.drawStick(arg1);
				if(arg1.getAction() == MotionEvent.ACTION_DOWN
						|| arg1.getAction() == MotionEvent.ACTION_MOVE) {
					xAxisValue.setText("X: " + String.valueOf(js.getX()));
					yAxisValue.setText("Y: " + String.valueOf(js.getY()));
					angleValue.setText("Angle: " + String.valueOf(js.getAngle()));
					distanceValue.setText("Distance: " + String.valueOf(js.getDistance()));
					
					//Get the position the user has moved the joystick to
					int direction = js.get8Direction();
					if(direction == JoyStickClass.STICK_UP) { //North
						directionValue.setText("Direction: North");
						sendSignal("North");
					} else if(direction == JoyStickClass.STICK_UPRIGHT) { //North-East
						directionValue.setText("Direction: North-East");
						sendSignal("North-East");
					} else if(direction == JoyStickClass.STICK_RIGHT) { //East
						directionValue.setText("Direction: East");
						sendSignal("South");
					} else if(direction == JoyStickClass.STICK_DOWNRIGHT) { //South-East
						directionValue.setText("Direction: South-East");
						sendSignal("South-East");
					} else if(direction == JoyStickClass.STICK_DOWN) { //South
						directionValue.setText("Direction: South");
						sendSignal("South");
					} else if(direction == JoyStickClass.STICK_DOWNLEFT) { //South-West
						directionValue.setText("Direction: South-West");
						sendSignal("South-West");
					} else if(direction == JoyStickClass.STICK_LEFT) { //West
						directionValue.setText("Direction: West");
						sendSignal("West");
					} else if(direction == JoyStickClass.STICK_UPLEFT) { //North-West
						directionValue.setText("Direction: North-West");
						sendSignal("North-West");
					} else if(direction == JoyStickClass.STICK_NONE) { //Centre
						directionValue.setText("Direction: Centre");
						sendSignal("Centre");
					}
				} else if(arg1.getAction() == MotionEvent.ACTION_UP) {
					xAxisValue.setText("X: ");
					yAxisValue.setText("Y: ");
					angleValue.setText("Angle: ");
					distanceValue.setText("Distance: ");
					directionValue.setText("Direction: ");
				}
				return true;
			}
        });
    }
    
    void sendSignal(String bearing){
    	try{
    		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
    		out.println(bearing);
    		out.flush();
    		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		String read = in.readLine();
    		System.out.println("MSG: " + read);
    	} catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    	
    }
    
    class ClientThread implements Runnable {

        @Override
        public void run() {

            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket(serverAddr, SERVERPORT);

            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.controls, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}