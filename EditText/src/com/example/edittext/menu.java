package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menumain);
		
		
	}
	//create menu
	public boolean onCreateOptionsMenu(Menu menu){
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		Log.i("Andy", "menu show!");
		return true;
	}
	
	// deal with menu event
	public boolean onOptionsItemSelected(MenuItem item){
		// TODO Auto-generated method stub 
		switch(item.getItemId()){
		
		case R.id.about:
			Intent intent = new Intent();
			intent.setClass(menu.this, menu1.class);
			startActivity(intent);
			menu.this.finish();
			
			break;
		case R.id.exit:
			menu.this.finish();
			
			break;
		}
		return true;
	}
	
	
}
