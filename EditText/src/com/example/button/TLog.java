package com.example.button;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class TLog {
	
	private static final boolean isLogV = true;
	private static final boolean isLogI = true;
	private static final boolean isLogD = true;
	private static final boolean isLogE = true;
	private static final boolean isLogW = true;
	
	private static Toast mToast = null;
	
	public static void v(String tag, String msg){
		if(isLogV){
			Log.v(tag, msg);
		}
	}

	public static void i(String tag, String msg){
		if(isLogI){
			Log.i(tag, msg);
		}
	}
	
	public static void d(String tag, String msg){
		if(isLogD){
			Log.d(tag, msg);
		}
	}

	public static void e(String tag, String msg){
		if(isLogE){
			Log.e(tag, msg);
		}
	}
	
	public static void e(String tag, String msg, Throwable tr){
		if(isLogE){
			Log.e(tag, msg, tr);
		}
	}

	public static void a(String tag, String msg){
		if(isLogW){
			Log.w(tag, msg);
		}
	}
	
	private static final boolean isDebugToast = true;
	
	public static void debugToast(Context context, String msg){
		if(isDebugToast){
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}
	}
	
	public static void Toast(Context context, String msg){
		if(mToast != null){
			mToast.cancel();
		}
		mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
		mToast.show();
	}
	
}
