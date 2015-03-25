/* Functions screen (preprogrammed movements) of the App
 * Project Delta Fountains
 */

package com.deltafountains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private static final String SERVER_IP = "192.168.0.27";
	private static int value = 0;
    PrintWriter out = null;
    BufferedReader in = null;
	
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
        		out.println(value);
        	}
        });
	}

	class ClientThread implements Runnable {

        @Override
        public void run() {

            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket(serverAddr, SERVERPORT);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
                Toast.makeText(getApplicationContext(), "Don't know host: " + SERVER_IP, Toast.LENGTH_SHORT).show();
            } catch (IOException e1) {
                e1.printStackTrace();
                Toast.makeText(getApplicationContext(), "Couldn't get IO for the connection to: " + SERVER_IP, Toast.LENGTH_SHORT).show();
            }
        }
    }
	
	protected void onDestroy(){
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
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
