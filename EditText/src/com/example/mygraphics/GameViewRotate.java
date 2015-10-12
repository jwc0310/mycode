package com.example.mygraphics;

import com.example.edittext.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class GameViewRotate extends View implements Runnable
{
	/* ����Bitmap���� */
	Bitmap	mBitQQ	= null;
	int		BitQQwidth	= 0;
	int		BitQQheight	= 0;

	float   Angle	= 0.0f;

	/* ����Matrix���� */
	Matrix mMatrix = new Matrix();
	
	public GameViewRotate(Context context)
	{
		super(context);
		
		/* װ����Դ */
		mBitQQ = ((BitmapDrawable) getResources().getDrawable(R.drawable.qq)).getBitmap();

		/* �õ�ͼƬ�Ŀ�Ⱥ͸߶� */
		BitQQwidth = mBitQQ.getWidth();
		BitQQheight = mBitQQ.getHeight();
		
		/* �����߳� */
		new Thread(this).start();
	}
	
	public void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		
		/* ����mMatrix */
		mMatrix.reset();
		
		/* ������ת */
		mMatrix.setRotate(Angle);
		
		/* ��mMatrix����ת�����µ�Bitmap */
		Bitmap mBitQQ2 = Bitmap.createBitmap(mBitQQ, 0, 0, BitQQwidth,BitQQheight, mMatrix, true);

		/* ������ת֮���ͼƬ */
		GameViewRotate.drawImage(canvas, mBitQQ2, (320-BitQQwidth)/2, 10);
		
		mBitQQ2 = null;
	}
	
	// �����¼�
	public boolean onTouchEvent(MotionEvent event)
	{
		Log.i("Andy", "[GameViewRotate.java]: onTouchEvent");
		return true;
	}


	// ���������¼�
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		//�����
		if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
		{
			Angle-=10;
		}
		//�ҷ����
		else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
		{
				Angle+=10;			
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
	
	
	/**
	 * �̴߳���
	 */
	public void run()
	{
		while (!Thread.currentThread().isInterrupted())
		{
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
			//ʹ��postInvalidate����ֱ�����߳��и��½���
			postInvalidate();
		}
	}
	
	/**
	 * ����һ��Bitmap
	 * @param canvas	����
	 * @param bitmap	ͼƬ
	 * @param x			��Ļ�ϵ�x����
	 * @param y			��Ļ�ϵ�y����
	 */
	public static void drawImage(Canvas canvas, Bitmap bitmap, int x, int y)
	{
		/* ����ͼ�� */
		canvas.drawBitmap(bitmap, x, y, null);
	}
}

