package com.example.mygraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

public class GameViewFrame extends View {

	private AnimationDrawable frameAni = null;
	Context mContext = null;
	
	Drawable mBitAnimation = null;
	
	public GameViewFrame(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext = context;
		
		frameAni = new AnimationDrawable();
		
		for(int i=1;i<=15;i++){
			int id=getResources().getIdentifier("a"+i, "drawable", mContext.getPackageName());
			
			mBitAnimation = getResources().getDrawable(id);
			
			frameAni.addFrame(mBitAnimation, 500);
		
		}
		
		frameAni.setOneShot(false);
		
		this.setBackgroundDrawable(frameAni);
		
		frameAni.start();
		
	}
	
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
	}
	
	
}
