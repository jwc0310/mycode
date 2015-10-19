package com.example.net;

import com.example.edittext.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NetUI extends Activity implements OnClickListener {
	private Button b_http,b_get,b_post;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.netui);
		b_http = (Button)findViewById(R.id.button1_http);
		b_get = (Button)findViewById(R.id.button2_get);
		b_post = (Button)findViewById(R.id.button3_post);
		
		b_http.setOnClickListener(this);
		b_get.setOnClickListener(this);
		b_post.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button1_http:
			startActivity(new Intent(NetUI.this,Activity02.class));
			break;
		case R.id.button2_get:
			startActivity(new Intent(NetUI.this,Activity03.class));
			break;
		case R.id.button3_post:
			startActivity(new Intent(NetUI.this,Activity04.class));
			break;
		}
	}
}
