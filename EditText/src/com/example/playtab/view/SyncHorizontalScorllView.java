package com.example.playtab.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class SyncHorizontalScorllView extends HorizontalScrollView {

	private View view;
	private ImageView leftImage,rightImage;
	private int windowWidth = 0;
	private Activity activity;
	
	public SyncHorizontalScorllView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public SyncHorizontalScorllView(Context context, AttributeSet attrs) {
		super(context,attrs);
		// TODO Auto-generated constructor stub
	}

	public void setSomeParam(View view, ImageView left,ImageView right,Activity activity){
		this.activity = activity;
		this.view = view;
		this.leftImage = left;
		this.rightImage = right;
		DisplayMetrics dm = new DisplayMetrics();
		this.activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		windowWidth = dm.widthPixels;
	}
	
	//show and hide left or right arrows
	public void showAndHideArrow(){
		if(!activity.isFinishing() && view != null){
			this.measure(0, 0);
			if(windowWidth >= this.getMeasuredWidth()){
				leftImage.setVisibility(View.GONE);
				rightImage.setVisibility(View.GONE);
			}else{
				if(this.getLeft() == 0){
					leftImage.setVisibility(View.GONE);
					rightImage.setVisibility(View.VISIBLE);
				}else if(this.getRight() == this.getMeasuredWidth() - windowWidth){
					leftImage.setVisibility(View.VISIBLE);
					rightImage.setVisibility(View.GONE);
				}else{
					leftImage.setVisibility(View.VISIBLE);
					rightImage.setVisibility(View.VISIBLE);
				}
			}
			
		}
	}
	
	
	protected void onScrollChanged(int l,int t,int oldl,int oldt){
		super.onScrollChanged(l, t, oldl, oldt);
		if(!activity.isFinishing() && view!=null &&rightImage!=null &&leftImage !=null){
			if(view.getWidth() <= windowWidth){
				leftImage.setVisibility(View.GONE);
				rightImage.setVisibility(View.GONE);
			}else{
				if(l == 0){
					leftImage.setVisibility(View.GONE);
					rightImage.setVisibility(View.VISIBLE);
				}else if(view.getWidth() -l == windowWidth){
					leftImage.setVisibility(View.VISIBLE);
					rightImage.setVisibility(View.GONE);
				}else{
					leftImage.setVisibility(View.VISIBLE);
					rightImage.setVisibility(View.VISIBLE);
				}
			}
		}
	}
	
	
	
}
