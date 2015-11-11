package com.example.fragment;

import com.example.edittext.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MyFirstFragment extends Activity {
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainfragment);
	}
}
