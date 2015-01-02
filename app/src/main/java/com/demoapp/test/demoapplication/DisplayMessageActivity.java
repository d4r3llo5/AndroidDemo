package com.demoapp.test.demoapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_display_message);	// Removed by tutorial code
		// Added by tutorial
		Intent intent = getIntent();

		/*
			This code is a bit wonky,
			we created a static data structure dictonary element with key EXTRA_MESSAGE
			and now we're extracting the value of the key (in this case the string message)
		 */
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

		// Set this as the active layout? Demo version
		/*TextView textView = new TextView(this);		// Create a text view for this activity
		textView.setTextSize(40);
		textView.setText(message);

		setContentView(textView);*/
		setContentView(R.layout.activity_display_message);		// Re-added to set it this way
		TextView textView = (TextView) findViewById(R.id.disp_messages);	// find our cute TextView
		textView.setText(message);		// Set the text message to the thing we just added
	}

/*
	Removed in the Demo code (LOL)
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_display_message, menu);
		return true;
	}
*/

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
