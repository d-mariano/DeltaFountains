/* Technical Support screen of the App
 * Project Delta Fountains
 */

package com.deltafountains;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Support extends Activity {

	ImageButton back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_support);
		
		back = (ImageButton) findViewById(R.id.backButtonSupport);
        back.setOnClickListener(new View.OnClickListener(){ //Back to main
        	@Override
        	public void onClick(View v){
        		finish();
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
