package com.deltafountains;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Activity {

	private ImageButton back;
	private Button set;
	private EditText ip, port;
	private TextView currentIP, currentPort;
	static String ipValue = "192.168.0.12";
	static int portValue = 43000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		back = (ImageButton) findViewById(R.id.backButtonSettings);
		set = (Button) findViewById(R.id.setButton);
		ip = (EditText) findViewById(R.id.editText1);
		port = (EditText) findViewById(R.id.editText2);
		currentIP = (TextView) findViewById(R.id.current_ip);
		currentPort = (TextView) findViewById(R.id.current_port);
		
		currentIP.setText("Current IP Address: " + ipValue);
		currentPort.setText("Current Port: " + portValue);
		
		back.setOnClickListener(new View.OnClickListener(){ //Back to main
        	@Override
        	public void onClick(View v){
        		finish();
        	}
        });
		
		set.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					ipValue = ip.getText().toString();
					String portTemp = port.getText().toString();
					portValue = Integer.parseInt(portTemp);
					Toast.makeText(getApplicationContext(), "New IP Address and Port SAVED", Toast.LENGTH_SHORT).show();
					currentIP.setText("Current IP Address: " + ipValue);
					currentPort.setText("Current Port: " + portValue);
				}catch (Exception e){
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), "New IP Addres and Port NOT saved", Toast.LENGTH_SHORT).show();
				}
			}
		});
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
