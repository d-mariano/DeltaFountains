/* Functions screen (preprogrammed movements) of the App
 * Project Delta Fountains
 */

package com.deltafountains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class Functions extends Activity {
	private ListView list;
	private String listview_array[] = { "Small Spiral (CLW)", "Medium Spiral (CLW)", "Large Spiral (CLW)", 
										"Small Spiral (CCLW)", "Medium Spiral (CCLW)", "Large Spiral (CCLW)",
										"Small Zig-Zag (N/S)", "Medium Zig-Zag (N/S)", "Large Zig-Zag (N/S)", 
										"Small Zig-Zag (E/W)", "Medium Zig-Zag (E/W)", "Large Zig-Zag (E/W)" };
	
	private Socket socket;
	private final int SERVERPORT = Settings.portValue;
	private final String SERVER_IP = Settings.ipValue;
	private static int value = 0;
    PrintWriter out = null;
    BufferedReader in = null;
	
    ImageButton back;
    
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
        
		back = (ImageButton) findViewById(R.id.backButtonFunctions);
        back.setOnClickListener(new View.OnClickListener(){ //Back to main
        	@Override
        	public void onClick(View v){
        		try {
        			socket.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        		finish();
        	}
        });
	}

	class ClientThread implements Runnable {
        @Override
        public void run() {
            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket();
                socket.setSoTimeout(250);
                socket.connect(new InetSocketAddress(serverAddr, SERVERPORT), 250);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
                finish();
            } catch (IOException e1) {
                e1.printStackTrace();
                finish();
            }
        }
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
