package com.example.mygraphics;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.example.edittext.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public class GameViewGif extends View implements Runnable {

	Context mContext = null;
	
	//GifFrame
	GifFrame mGifFrame = null;
	
	public GameViewGif(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext = context;
		mGifFrame = GifFrame.CreateGifImage(fileConnect(this.getResources().openRawResource(R.drawable.gif1)));
	
		new Thread(this).start();
	
	}

	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		mGifFrame.nextFrame();
		
		Bitmap b=mGifFrame.getImage();
		if(b!=null)
			canvas.drawBitmap(b, 10, 10,null);
	}
	
	@Override
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
	
	/* ��ȡ�ļ� */
	public byte[] fileConnect(InputStream is)
	{
		try
		{					    
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int ch = 0;
			while( (ch = is.read()) != -1) 
			{
				baos.write(ch);
			}			      
			byte[] datas = baos.toByteArray();
			baos.close(); 
			baos = null;
			is.close();
			is = null;
			return datas;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
