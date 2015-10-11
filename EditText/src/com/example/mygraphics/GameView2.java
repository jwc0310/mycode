package com.example.mygraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

public class GameView2 extends View{

	ShapeDrawable mShapeDrawable = null;
	
	public GameView2(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public void DrawShape(Canvas canvas){
		
		mShapeDrawable = new ShapeDrawable(new RectShape());
		
		mShapeDrawable.getPaint().setColor(Color.RED);
		
		Rect bounds = new Rect(5+300,250+300,55+300,280+300);
		
		//设置图像显示的区域
		mShapeDrawable.setBounds(bounds);
		mShapeDrawable.draw(canvas);
		
		
		mShapeDrawable.getPaint().setColor(Color.GREEN);
		mShapeDrawable.setBounds(70+300, 250+300, 150+300, 280+300);
		mShapeDrawable.draw(canvas);
		
		Path path1 = new Path();
		path1.moveTo(300+150+5, 300+80+50);
		path1.lineTo(300+150+45, 300+80+50);
		path1.lineTo(300+150+30, 300+120+50);
		path1.lineTo(300+150+20, 300+120+50);
		path1.close();
		
		mShapeDrawable = new ShapeDrawable(new PathShape(path1,150,150));
		mShapeDrawable.getPaint().setColor(Color.BLUE);
		mShapeDrawable.setBounds(100+300, 170+300, 200+300, 280+300);
		mShapeDrawable.draw(canvas);
		
		
	}

}
