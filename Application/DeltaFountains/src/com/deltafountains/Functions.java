/* Functions screen (preprogrammed movements) of the App
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
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Functions extends Activity {
	private ListView list;
	private String listview_array[] = { "Small Spiral (CLW)", "Medium Spiral (CLW)", "Large Spiral (CLW)", 
										"Small Spiral (CCLW)", "Medium Spiral (CCLW)", "Large Spiral (CCLW)",
										"Small Zig-Zag (N/S)", "Medium Zig-Zag (N/S)", "Large Zig-Zag (N/S)", 
										"Small Zig-Zag (E/W)", "Medium Zig-Zag (E/W)", "Large Zig-Zag (E/W)" };
	
	
	private Socket socket;
	private static final int SERVERPORT = 43000;
	private static final String SERVER_IP = "192.168.1.1";
	private static int value = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_functions);
		
		new Thread(new ClientThread()).start();
		
		list = (ListView) findViewById(R.id.listView);
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listview_array));
        
        list.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        		value = position;
        	}
        });
	}

/*	int callFunction(int position){
		Toast.makeText(getApplicationContext(), "Function: " + listview_array[position], Toast.LENGTH_SHORT).show();
		
		if (position == 0){ //Small Spiral(CLW)
			
		}else if (position == 1){ //Medium Spiral(CLW)
			
		}else if (position == 2){ //Large Spiral(CLW)
			
		}else if (position == 3){ //Small Spiral(CCLW)
			
		}else if (position == 4){ //Medium Spiral(CCLW)
			
		}else if (position == 5){ //Large Spiral(CCLW)
			
		}else if (position == 6){ //Small Zig-Zag(N/S)
			
		}else if (position == 7){ //Medium Zig-Zag(N/S)
			
		}else if (position == 8){ //Large Zig-Zag(N/S)
			
		}else if (position == 9){ //Small Zig-Zag(E/W)
			
		}else if (position == 10){ //Medium Zig-Zag(E/W)
			
		}else if (position == 11){ //Large Zig-Zag(E/W)
			
		}else{
			Toast.makeText(getApplicationContext(), "Well that didn't work", Toast.LENGTH_LONG).show();
		}
		
		return position;
	}
*/	
    public void onClick(View view) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),
                    true);
            out.flush();
            BufferedReader  in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String read = in.readLine();
            System.out.println("MSG:" + read + "\t\t" + value);  

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
		getMenuInflater().inflate(R.menu.functions, menu);
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
