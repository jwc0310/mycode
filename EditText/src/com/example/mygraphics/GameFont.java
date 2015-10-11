package com.example.mygraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class GameFont extends View implements Runnable
{
	/* ����Paint���� */
	private Paint mPaint = null;
	private int   mICount = 0;
	
	/* ����TextUtil���� */
	private TextUtil mTextUtil = null;
	public GameFont(Context context)
	{
		super(context);
		/* �������� */
		mPaint = new Paint();
		
		String string = "�����Զ�����\n\n���������Զ�����abcdefgh\niklmnopqrst����123347465\n43756245Android\n���������Զ�����abcdefgh\niklmnopqrst����123347465\n43756245Android";
		
		/* ʵ����TextUtil */
		mTextUtil = new TextUtil(string,5,50,300,80,0x0,0xffffff,255,16);
		
		/* ��ʼ��TextUtil */
		mTextUtil.InitText(string,5,50,300,80,0x0,0xffffff,255,16);
		
		/* �����߳�  */
		new Thread(this).start();
	}
	
	public void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		
		/* ���ñ�����ɫ */
		canvas.drawColor(Color.BLACK);
		
		mPaint.setAntiAlias(true);
		
		if ( mICount < 100 )
		{
			mICount++;
		}
		
		mPaint.setColor(Color.RED);
		
		canvas.drawText("װ�ڽ��ȣ�"+mICount+"%......", 10, 20, mPaint);

		/* ����TextUtil��ʵ���Զ����� */
		mTextUtil.DrawText(canvas);
	}
	
	// �����¼�
	public boolean onTouchEvent(MotionEvent event)
	{
		return true;
	}


	// ���������¼�
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		return mTextUtil.KeyDown(keyCode, event);
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
}