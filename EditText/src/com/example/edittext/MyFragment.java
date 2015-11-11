package com.example.edittext;

import com.example.fragment.MyFirstFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MyFragment extends Activity implements View.OnClickListener {
	
	private Button firstFrag;
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.myfragment);
		initWidget();
	}
	private void initWidget(){
		firstFrag = (Button)findViewById(R.id.firstfrag);
		firstFrag.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.firstfrag:
			startActivity(new Intent(MyFragment.this,MyFirstFragment.class));
			break;
		}
	}
}
