package com.example.mygraphics;

import com.example.edittext.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class GameViewBitmap extends View implements Runnable {

	private Paint mPaint = null;
	Bitmap mBitQQ = null;
	Bitmap mBitDestTop = null;
	int miDTX = 0;
	
	
	
	public GameViewBitmap(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mPaint = new Paint();
		miDTX = 0;
		mBitQQ = ((BitmapDrawable) getResources().getDrawable(R.drawable.qq)).getBitmap();
		mBitDestTop = ((BitmapDrawable) getResources().getDrawable(R.drawable.desktop)).getBitmap();
		
		
		new Thread(this).start();
		
	}

	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		
		canvas.drawColor(Color.GRAY);
		GameViewBitmap.drawImage(canvas,mBitQQ,0,0);
		
		//��ָ��λ�ð�ָ���ü����������л�ִ
		GameViewBitmap.drawImage(canvas, mBitDestTop, miDTX, mBitQQ.getHeight(), mBitDestTop.getWidth(), mBitDestTop.getHeight()/2, 0, 0);
		
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
	
	
	public static void drawImage(Canvas canvas,Bitmap bitmap,int x,int y){
		canvas.drawBitmap(bitmap, x, y, null);
	}
	
	
	public static void drawImage(Canvas canvas, Bitmap blt,int x,int y,int w,int h,int bx,int by){
		Rect src = new Rect(); //ͼƬ
		Rect dst = new Rect(); //��Ļ
		
		dst.left = x;
		dst.top = y;
		dst.right = x + w;
		dst.bottom = y +h;
		
		
		src.left = bx;
		src.top = by;
		src.right = bx+w;
		src.bottom = by +h;
		
		canvas.drawBitmap(blt, src, dst,null);
		
		src = null;
		dst = null;
		
	}
	// �����¼�
		public boolean onTouchEvent(MotionEvent event)
		{
			Log.i("Andy", event+" hello");
			
			return true;
		}


		// ���������¼�
		public boolean onKeyDown(int keyCode, KeyEvent event)
		{
			Log.i("Andy", keyCode+" hello");
			//�����
			if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
			{
				if (miDTX > 0)
				{
					miDTX--;
				}
			}
			//�ҷ����
			else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
			{
				if (miDTX+mBitDestTop.getWidth() < 320)
				{
					miDTX++;
				}
			}
			return true;
		}


		// ���������¼�
		public boolean onKeyUp(int keyCode, KeyEvent event)
		{
			return false;
		}


		public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event)
		{
			return true;
		}
	
	
	

}
