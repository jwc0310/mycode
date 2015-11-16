package com.example.fragment;

import java.util.List;

import com.example.edittext.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TabFragment extends Activity implements View.OnClickListener {
	
	private LinearLayout mTabBtnSettings;
	
	
	private Button b1,b2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_tab);
		
		b1 = (Button)findViewById(R.id.traditional_viewpager);
		b2 = (Button)findViewById(R.id.fragmentManger_fragment);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.traditional_viewpager:
			Intent intent = new Intent();
			intent.setClass(this, TraditionalViewpager.class);
			startActivity(intent);
			break;
		case R.id.fragmentManger_fragment:
			break;
		}
	}
}
