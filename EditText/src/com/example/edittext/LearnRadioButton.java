package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
	private Button b1;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radiobutton);
		
		tv1 = (TextView)findViewById(R.id.textView1);
		rg1 = (RadioGroup)findViewById(R.id.RadioGroup1);
		rb1 = (RadioButton)findViewById(R.id.RadioButton1);
		rb2 = (RadioButton)findViewById(R.id.RadioButton2);
		rb3 = (RadioButton)findViewById(R.id.RadioButton3);
		rb4 = (RadioButton)findViewById(R.id.RadioButton4);
		b1 = (Button)findViewById(R.id.button1);
		
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
