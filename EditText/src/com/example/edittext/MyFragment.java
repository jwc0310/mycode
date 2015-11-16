package com.example.edittext;

import com.example.fragment.ManagerFragment;
import com.example.fragment.MyDialogFragment;
import com.example.fragment.MyFirstFragment;
import com.example.fragment.TabFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MyFragment extends Activity implements View.OnClickListener {
	
	private Button firstFrag,managerFrag;
	private Button dialogFrag,tabFrag;
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.myfragment);
		initWidget();
	}
	private void initWidget(){
		firstFrag = (Button)findViewById(R.id.firstfrag);
		firstFrag.setOnClickListener(this);
		managerFrag = (Button)findViewById(R.id.managerfragment);
		managerFrag.setOnClickListener(this);
		dialogFrag = (Button)findViewById(R.id.dialog_frag);
		dialogFrag.setOnClickListener(this);
		tabFrag = (Button)findViewById(R.id.tab_fragment);
		tabFrag.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.firstfrag:
			startActivity(new Intent(MyFragment.this,MyFirstFragment.class));
			break;
		case R.id.managerfragment:
			startActivity(new Intent(MyFragment.this,ManagerFragment.class));
			break;
		case R.id.dialog_frag:
			startActivity(new Intent(MyFragment.this,MyDialogFragment.class));
			break;
		case R.id.tab_fragment:
			startActivity(new Intent(MyFragment.this,TabFragment.class));
			break;
		}
	}
}
