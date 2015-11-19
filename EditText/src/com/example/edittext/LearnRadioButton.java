package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LearnRadioButton extends Activity {
	
	private TextView tv1;
	private RadioGroup rg1;
	private RadioButton rb1,rb2,rb3,rb4;
	private Button b1,testIntent,backHome;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radiobutton);
		
		Intent intent = getIntent();
		final String value = intent.getStringExtra("testIntent");
		final String one = intent.getStringExtra("One");
		final String two = intent.getStringExtra("Two");
		
		tv1 = (TextView)findViewById(R.id.textView1);
		rg1 = (RadioGroup)findViewById(R.id.RadioGroup1);
		rb1 = (RadioButton)findViewById(R.id.RadioButton1);
		rb2 = (RadioButton)findViewById(R.id.RadioButton2);
		rb3 = (RadioButton)findViewById(R.id.RadioButton3);
		rb4 = (RadioButton)findViewById(R.id.RadioButton4);
		b1 = (Button)findViewById(R.id.button1);
		testIntent = (Button)findViewById(R.id.testIntent);
		backHome = (Button)findViewById(R.id.backHome);
		
		backHome.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
			}
			
		});
		
		
		testIntent.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_GET_CONTENT);
				intent.setType("vnd.android.cursor.item/phone");//设置Intent Type属性，主要是获取通讯录的内容
				startActivity(intent);
			}
			
		});
		
		b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent backMain = new Intent();
				backMain.setClass(LearnRadioButton.this, MainActivity.class);
				startActivity(backMain);
				LearnRadioButton.this.finish();
			}
			
		});
		
		rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				Log.i("Andy", value);
				Log.i("Andy", one);
				Log.i("Andy", two);
				if(checkedId == rb2.getId()){
					DisplayToast("OK:" + rb2.getText()+"Congratulation!");
				}else{
					DisplayToast("ERROR!");
				}
				
				
			}
		});
		
		
		
		
	}
	
	
	private void DisplayToast(String str){
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
	}
}
