package com.deltafountains;

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_functions);
		
		list = (ListView) findViewById(R.id.listView);
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listview_array));
        
        list.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        		callFunction(position);
        	}
        });
	}

	void callFunction(int position){
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
