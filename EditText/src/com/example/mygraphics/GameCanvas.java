package com.example.mygraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GameCanvas extends View implements Runnable {

	private Paint mPaint;
	
	public GameCanvas(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mPaint = new Paint();
		
		//start thread
		new Thread(this).start();
		
	}

	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		
		canvas.drawColor(Color.BLACK);
		
		mPaint.setAntiAlias(true);
		
		//设置裁剪区域
		canvas.clipRect(10,10,280,260);
		//锁定画布
		canvas.save();
		
		canvas.rotate(45.0f);
		mPaint.setColor(Color.RED);
		canvas.drawRect(new Rect(15,15,140,70), mPaint);
		
		canvas.restore();
		
		mPaint.setColor(Color.GREEN);
		mPaint.setAntiAlias(false);
		canvas.drawRect(new Rect(150,75,260,120), mPaint);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.currentThread().isInterrupted()){
			try{
			Thread.sleep(100);
			}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
			
			postInvalidate();
		}
	}

}
