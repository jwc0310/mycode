package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class learnCheckBox extends Activity {

	private Button submit,back;
	private CheckBox cb1,cb2,cb3,cb4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkbox);
		
		submit = (Button)findViewById(R.id.submit);
		back = (Button)findViewById(R.id.back);
		
		cb1 = (CheckBox)findViewById(R.id.checkBox1);
		cb2 = (CheckBox)findViewById(R.id.checkBox2);
		cb3 = (CheckBox)findViewById(R.id.checkBox3);
		cb4 = (CheckBox)findViewById(R.id.checkBox4);
		
		
		
		
		submit.setOnClickListener(bc);
		back.setOnClickListener(bc);
		
		
		cb1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(cb1.isChecked()){
					DisplayToast("you selected "+cb1.getText());
				}
			}
			
		});
		
		cb2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(cb2.isChecked()){
					DisplayToast("you selected "+cb2.getText());
				}
			}
			
		});
		cb3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(cb3.isChecked()){
					DisplayToast("you selected "+cb3.getText());
				}
			}
			
		});
		cb4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(cb4.isChecked()){
					DisplayToast("you selected "+cb4.getText());
				}
			}
			
		});
		
		
		
		
	}
	
	
	OnClickListener bc = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.submit:
				int num=0;
				if(cb1.isChecked())
					num++;
				if(cb2.isChecked())
					num++;
				if(cb3.isChecked())
					num++;
				if(cb4.isChecked())
					num++;
				DisplayToast("你一共选择了"+num+"项");
				break;
			case R.id.back:
				Intent bac = new Intent();
				bac.setClass(learnCheckBox.this, MainActivity.class);
				startActivity(bac);
				learnCheckBox.this.finish();
				break;
			default:
				break;
			}
		}
		
	};
	
	private void DisplayToast(String str){
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
	}
	
	
	
}
