package com.example.mygraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class GameView1 extends View implements Runnable {

	private Paint mPaint = null;
	
	public GameView1(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mPaint = new Paint();
		
		
		new Thread(this).start();
		
		
	}
	
	
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		
		canvas.drawColor(Color.BLACK);
		
		mPaint.setAntiAlias(true);
		
		//¿ÕÐÄ
		mPaint.setStyle(Paint.Style.STROKE);
		//rect
		Rect rect1 = new Rect();
		rect1.left = 100+5;
		rect1.top = 100+5;
		rect1.right = 100+25;
		rect1.bottom = 100+45;
		mPaint.setColor(Color.BLUE);
		canvas.drawRect(rect1, mPaint);
		
		mPaint.setColor(Color.RED);
		canvas.drawRect(100+50,100+5,100+90,100+25, mPaint);
		
		//circle
		canvas.drawCircle(100+40, 100+70, 30, mPaint);
		
		//oval
		RectF rectf1 = new RectF();
		rectf1.left = 100+80;
		rectf1.top = 100+30;
		rectf1.right = 100+120;
		rectf1.bottom = 100+70;
		mPaint.setColor(Color.LTGRAY);
		canvas.drawOval(rectf1, mPaint);
		
		//
		Path path1 = new Path();
		path1.moveTo(100+150+5, 100+80+50);
		path1.lineTo(100+150+45, 100+80+50);
		path1.lineTo(100+150+30, 100+120+50);
		path1.lineTo(100+150+20, 100+120+50);
		path1.close();
		mPaint.setColor(Color.GRAY);
		canvas.drawPath(path1, mPaint);
		
		//line
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(3);
		canvas.drawLine(100+5, 100+110, 100+315, 100+110, mPaint);
		
		
		
		mPaint.setStyle(Paint.Style.FILL);
		//rect
		Rect rect2 = new Rect();
		rect2.left = 100+5+200;
		rect2.top = 100+5+200;
		rect2.right = 100+25+200;
		rect2.bottom = 100+45+200;
		mPaint.setColor(Color.BLUE);
		canvas.drawRect(rect2, mPaint);
		
		mPaint.setColor(Color.RED);
		canvas.drawRect(100+50+200,100+5+200,100+90+200,100+25+200, mPaint);
		
		//circle
		canvas.drawCircle(100+40+200, 100+70+200, 30, mPaint);
		
		//oval
		RectF rectf2 = new RectF();
		rectf2.left = 100+80+200;
		rectf2.top = 100+30+200;
		rectf2.right = 100+120+200+100;
		rectf2.bottom = 100+70+200;
		mPaint.setColor(Color.LTGRAY);
		canvas.drawOval(rectf2, mPaint);
		
		//
		Path path2 = new Path();
		path2.moveTo(100+150+5+200, 100+80+50+200);
		path2.lineTo(100+150+45+200, 100+80+50+200);
		path2.lineTo(100+150+30+200, 100+120+50+200);
		path2.lineTo(100+150+20+200, 100+120+50+200);
		path2.close();
		mPaint.setColor(Color.GRAY);
		canvas.drawPath(path2, mPaint);
		
		//line
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(3);
		canvas.drawLine(100+5+200, 100+110+200, 100+315+200, 100+110+200, mPaint);
		
		
		
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
