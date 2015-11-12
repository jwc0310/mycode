package com.example.fragment;

import com.example.edittext.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.View;
import android.widget.LinearLayout;

public class MyFirstFragment extends Activity implements View.OnClickListener {
	
	private LinearLayout mLayoutWeixin;
	private LinearLayout mLayoutFriend;
	
	private ContentFragment mWeixin;
	private FriendFragment mFriend;
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainfragment);
		mLayoutWeixin = (LinearLayout)findViewById(R.id.id_tab_bottom_weixin);
		mLayoutFriend = (LinearLayout)findViewById(R.id.id_tab_bottom_friend);
		mLayoutWeixin.setOnClickListener(this);
		mLayoutFriend.setOnClickListener(this);
		
		setDefaultFragment();
	}

	private void setDefaultFragment(){
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		mWeixin = new ContentFragment();
		transaction.replace(R.id.id_fragment_content, mWeixin);
		transaction.commit();
		Log.i("Andy","setDefaultFragment()");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		FragmentManager fm = getFragmentManager();
		//开启Fragment事物
		FragmentTransaction transaction = fm.beginTransaction();
		Log.i("Andy", "-----"+v.getId());
		switch(v.getId()){
		case R.id.id_tab_bottom_weixin:
			Log.i("Andy", "weixin");
			if(mWeixin == null){
				mWeixin = new ContentFragment();
			}
			transaction.replace(R.id.id_fragment_content, mWeixin);
			break;
		case R.id.id_tab_bottom_friend:
			Log.i("Andy", "friend");
			if(mFriend == null){
				mFriend = new FriendFragment();
			}
			transaction.replace(R.id.id_fragment_content, mFriend);
			break;
		}
		
		//事物提交
		transaction.commit();
	}
	
}
