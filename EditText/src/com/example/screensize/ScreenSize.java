package com.example.screensize;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenSize {
	
	public int width;
	public int height;
	
	private DisplayMetrics dm;
	
	public ScreenSize(Activity activity){
		
		dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		width = dm.widthPixels;
		height = dm.heightPixels;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
