package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurView extends SurfaceView implements SurfaceHolder.Callback,Runnable {

	//control loop
	boolean mbLoop = false;
	
	//def SurfaceHolder obj
	SurfaceHolder mSurfaceHolder = null;
	int miCount = 0;
	int y = 50;
	
	public GameSurView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		mSurfaceHolder = this.getHolder();
		
		mSurfaceHolder.addCallback(this);
		this.setFocusable(true);
		mbLoop = true;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(mbLoop){
			try{
				Thread.sleep(200);
			}catch(Exception e){
				
			}
			
			synchronized(mSurfaceHolder){
				Draw();
			}
			
			
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		new Thread(this).start();
	}

	//when the size changed
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mbLoop = false;
	}

	public void Draw(){
		Canvas canvas = mSurfaceHolder.lockCanvas();
		
		if(mSurfaceHolder == null || canvas == null){
			return;
		}
		
		if(miCount < 100){
			miCount++;
		}else{
			miCount = 0;
		}
		
		//Log.i("Andy", Integer.toString(miCount));
		//»æÍ¼
		Paint mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.BLACK);
		
		//clear screen
		canvas.drawRect(0, 0,320,480,mPaint);
		
		switch(miCount%4){
		case 0:
			mPaint.setColor(Color.RED);
			break;
		case 1:
			mPaint.setColor(Color.GREEN);
			break;
		case 2:
			mPaint.setColor(Color.BLUE);
			break;
		case 3:
			mPaint.setColor(Color.YELLOW);
			break;
		default:
			mPaint.setColor(Color.WHITE);
			break;
		
		}
		
		canvas.drawCircle((320-25)/2, y, 50, mPaint);
		mSurfaceHolder.unlockCanvasAndPost(canvas);
		
		
	}
	
	
}
