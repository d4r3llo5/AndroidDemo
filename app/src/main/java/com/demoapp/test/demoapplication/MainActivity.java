package com.demoapp.test.demoapplication;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

// Imports for the Intent class
import android.content.Intent;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

	// Added define static strings
	public final static String EXTRA_MESSAGE = "com.demoapp.test.demoapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		// Add a back button to the menu, if it supports it
		if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
		//return true;

		// Start the part two code for creating our custom action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
		// Part two code
		switch (item.getItemId()) {
			case R.id.action_search:
				//openSearch();
				return true;
			case R.id.action_settings:
				//openSettings();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
    }

	// Added by tutorial code
	/*
		onClick action for the button: build up an intent object, and then
		pass it the string from the editText resource (edit_text in the XML)
	 */
	public void sendMessage(View view) {
		// User clicked the button, do something about that
		// Create an intent and tell the folks what Acivity to go to (DisplayMessage class)
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		/*
			Initially the above code will error,
			since DisplayMessageActivity (and also a view does not exist)
			Created later in the tutorial
		 */
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	/*
		Added by myself to try and create a sandbox activity (as of 1/1/2015)
			May have to create more in the future
	 */
	public void gotoSandbox(View view) {
		Intent intent = new Intent(this, SandBox.class);
		startActivity(intent);
	}
}
