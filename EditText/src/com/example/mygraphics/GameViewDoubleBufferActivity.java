package com.example.mygraphics;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class GameViewDoubleBufferActivity extends Activity {

	private GameViewDoubleBuffer mGvdb = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//�����ޱ�����
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//����ȫ��ģʽ
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//����Ϊ����
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		mGvdb = new GameViewDoubleBuffer(this);
		
		setContentView(mGvdb);
		
		
	}
	
}
