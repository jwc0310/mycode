package com.example.binderservice;

import com.example.edittext.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class BinderService extends Activity {

	static final String TAG = "Andy - BinderService";
	ServiceConnection mSc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_binder);
		
		
		mSc = new ServiceConnection(){

			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				Log.i(TAG, "onServiceConnected");
				
				LocalService ss = ((LocalService.LocalBinder)service).getService();
				ss.sayHelloWorld();
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				
				
				Log.i(TAG, "onServiceDisconnected");
			}
			
		};
		
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		
		Log.d(TAG, this.getApplicationContext().getPackageCodePath());
		Intent service = new Intent(this.getApplicationContext(),LocalService.class);
		this.bindService(service, mSc, Context.BIND_AUTO_CREATE);
		
		
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		this.unbindService(mSc);//在onStop中解除绑定，否则会造成内存泄露
		Log.d(TAG, "unbindService");
	}
	
	
	
}
