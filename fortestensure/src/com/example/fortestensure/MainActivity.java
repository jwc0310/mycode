package com.example.fortestensure;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener{

	private Button b1;
	private Button danmu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		
	}
	
	private void initView(){
		
		b1 = (Button)findViewById(R.id.show_dialog);
		danmu = (Button)findViewById(R.id.danmu);
		
		b1.setOnClickListener(this);
		danmu.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if(id == R.id.show_dialog){
			GiftDialog dialog = new GiftDialog(this);
			dialog.show();
		}else if(id == R.id.danmu){
			Intent intent = new Intent();
			intent.setClass(this, Danmu.class);
			intent.putExtra("name", "Andy");
			startActivityForResult(intent, 1);
		}
		
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(1 == requestCode){
			
		}else if(2 == requestCode){
			
		}
	}
}
