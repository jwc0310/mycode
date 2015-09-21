package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class menu1 extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menumain1);
		
	}
	
	
	
	//create menu
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(0,0,0,R.string.ok);
		menu.add(0,1,1,R.string.back);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case 0:
		case 1:
			
			Intent intent = new Intent();
			intent.setClass(menu1.this, menu.class);
			startActivity(intent);
			menu1.this.finish();
			
			
			break;
			
		}
		return true;
	}
	
	
	
}
