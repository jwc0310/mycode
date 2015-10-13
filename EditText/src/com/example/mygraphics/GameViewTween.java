package com.example.mygraphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.graphics.drawable.BitmapDrawable;

import com.example.edittext.R;

public class GameViewTween extends View implements Runnable {

	//define Alpha animation
	private Animation mAAlpha = null;
	
	//define Scale animation
	private Animation mAScale = null;
	
	//define Rotate animation
	private Animation mARotate = null;
	
	//define translate animation
	private Animation mATrans = null;
	
	
	Bitmap mBitQQ = null;
	
	//Buffer
	Bitmap mBufBitmap = null;
	
	private Canvas canvas;
	private Paint mPaint;
	
	
	public GameViewTween(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		mBitQQ = ((BitmapDrawable) getResources().getDrawable(R.drawable.qq)).getBitmap();
		
		mBufBitmap = Bitmap.createBitmap(480, 840, Config.ARGB_8888);
		
		canvas = new Canvas();
		canvas.setBitmap(mBufBitmap);
		
		mPaint = new Paint();
		canvas.drawBitmap(mBitQQ, 0, 0, mPaint);
		
		
		mAAlpha = new AlphaAnimation(0.1f,1.0f);
		
		
		
		mAAlpha = new AlphaAnimation(0.1f,1.0f);
		
		mAAlpha.setDuration(3000);

		mAScale = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
				Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f
				);
		mAScale.setDuration(3000);

		mATrans = new TranslateAnimation(10,100,10,100);
		mATrans.setDuration(3000);
		this.startAnimation(mATrans);
		
	}
	
	
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawBitmap(mBufBitmap, 0, 0, null);
	}
	
	public boolean onKeyUp(int keyCode,KeyEvent event){
		
		Log.i("Andy", "["+getClass().getName()+"]: keyCode"+keyCode);
		
		switch(keyCode){
		case KeyEvent.KEYCODE_DPAD_UP:
			mAAlpha = new AlphaAnimation(0.1f,1.0f);
			
			mAAlpha.setDuration(3000);
			this.startAnimation(mAAlpha);
			
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			mAScale = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
					Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f
					);
			mAScale.setDuration(3000);
			this.startAnimation(mAScale);
			
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			mATrans = new TranslateAnimation(10,100,10,100);
			mATrans.setDuration(3000);
			this.startAnimation(mATrans);
			
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			mARotate=new RotateAnimation(0.0f, +360.0f,
					 Animation.RELATIVE_TO_SELF,0.5f,
					 Animation.RELATIVE_TO_SELF, 0.5f);
			mARotate.setDuration(3000);
			this.startAnimation(mARotate);
			break;
			
		}
		
		return true;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(!Thread.currentThread().isInterrupted()){
			try{
				Thread.sleep(4000);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
			if(i>3){
				i=0;
			}
			if(i ==0){
				this.startAnimation(mAAlpha);
			}else if(i==1){
				this.startAnimation(mARotate);
			}else if(i ==2){
				this.startAnimation(mAScale);
			}else if(i ==3){
				this.startAnimation(mATrans);
			}
			i++;
		}
	}
	
	

}
