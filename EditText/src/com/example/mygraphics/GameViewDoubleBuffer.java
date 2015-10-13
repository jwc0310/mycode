package com.example.mygraphics;

import com.example.edittext.R;
import com.example.screensize.ScreenSize;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.drawable.BitmapDrawable;

public class GameViewDoubleBuffer extends View implements Runnable {

	Bitmap mBitQQ = null;
	Paint mPaint = null;
	
	//创建一个缓冲区
	Bitmap mSCBitmap = null;
	
	Canvas canvas = null;
	
	DisplayMetrics dm = null;
	
	private int ScreenWidth,ScreenHeight;
	
	private ScreenSize ss;
	
	public GameViewDoubleBuffer(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		mBitQQ = ((BitmapDrawable) getResources().getDrawable(R.drawable.qq)).getBitmap();
		
		//ss = new ScreenSize(activity);
		
		
		mSCBitmap = Bitmap.createBitmap(320,540,Config.ARGB_8888);
		
		canvas = new Canvas();
		
		//设置将内容绘制在mSCBitmap上
		canvas.setBitmap(mSCBitmap);
		
		mPaint = new Paint();
		
		canvas.drawBitmap(mBitQQ, 0, 0, mPaint);
		
		new Thread(this).start();
		
	}

	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		
		canvas.drawBitmap(mSCBitmap, 0, 0, mPaint);
		
	}
	
	//触笔事件
	public boolean onTouchEvent(MotionEvent event){
		Log.i("Andy", "[GameViewDoubleBuffer]:onTouchEvent()");
		return true;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.currentThread().isInterrupted()){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
			postInvalidate();
		}
	}

}
