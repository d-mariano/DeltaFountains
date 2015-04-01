/* Home screen of the App
 * Project Delta Fountains
 */

package com.deltafountains;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	Button controls, functions, settings;
	ImageButton support;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		controls = (Button) findViewById(R.id.controlsButton);
		functions = (Button) findViewById(R.id.functionsButton);
		settings = (Button) findViewById(R.id.settingsButton);
		support = (ImageButton) findViewById(R.id.questionImageButton);
		
		controls.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getApplicationContext(), Controls.class);
        		startActivity(intent);
        	}
        });
		
		functions.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				Intent intent = new Intent(getApplicationContext(),Functions.class);
				startActivity(intent);
			}
		});
		
		support.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				Intent intent = new Intent(getApplicationContext(), Support.class);
				startActivity(intent);
			}
		});
		
		settings.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				Intent intent = new Intent(getApplicationContext(), Settings.class);
				startActivity(intent);
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
