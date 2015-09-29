package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class get extends Activity implements OnClickListener {

	Button b1,back;
	TextView tv1;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		
		b1 = (Button)findViewById(R.id.button1);
		back = (Button)findViewById(R.id.button2);
		tv1 = (TextView)findViewById(R.id.textView2);
		
		b1.setOnClickListener(this);
		back.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button1:
			Display dis = getWindowManager().getDefaultDisplay();
			Point size = new Point();
			dis.getSize(size);
			tv1.setText("Screen x is "+size.x+"Screen y is "+size.y);
			break;
		case R.id.button2:
			Intent toMain = new Intent(get.this,MainActivity.class);
			startActivity(toMain);
			get.this.finish();
			break;
		}
	}

}
