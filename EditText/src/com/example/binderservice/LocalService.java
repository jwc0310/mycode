package com.example.binderservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class LocalService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new LocalBinder();
	}
	
	public void sayHelloWorld(){
		Toast.makeText(this.getApplicationContext(), "Hello world Local Service", Toast.LENGTH_SHORT).show();
		Log.i("Andy", "Hello world Local Service");
	}
	
	public class LocalBinder extends Binder{
		LocalService getService(){
			return LocalService.this;
		}
	}

}
