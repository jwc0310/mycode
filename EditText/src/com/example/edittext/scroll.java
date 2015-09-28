package com.example.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class scroll extends Activity{
	
	private LinearLayout ll;
	private ScrollView msv;
	private final Handler handler = new Handler();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scroll);
		
		msv = (ScrollView) findViewById(R.id.sv1);
		ll = (LinearLayout) findViewById(R.id.ll1);
		
		Button b = (Button)findViewById(R.id.click);
		
		b.setOnClickListener(b_event);
		// 改变默认焦点切换
		b.setOnKeyListener(mAddButtonKeyListener);
		
	}
	
	OnClickListener b_event = new OnClickListener(){

		private int index = 1;
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			TextView tv = new TextView(scroll.this);
			tv.setText("Text View "+index);
			
			LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT
					);
			
			ll.addView(tv,p);
			
			Button b1 = new Button(scroll.this);
			b1.setText("Button "+index++);
			
			ll.addView(b1);
			
			b1.setOnKeyListener(mNewButtonKeyListener);
			handler.post(mScrollToBottom);
			
		}
		
	};
	
	OnKeyListener mAddButtonKeyListener = new OnKeyListener(){

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			
			View viewToFoucus = null;
			if(event.getAction() == KeyEvent.ACTION_DOWN){
				int iCount = ll.getChildCount();
				switch(keyCode){
				case KeyEvent.KEYCODE_DPAD_UP:
					if(iCount >0){
						viewToFoucus = ll.getChildAt(iCount-1);
					}
					break;
					
				case KeyEvent.KEYCODE_DPAD_DOWN:
					if(iCount < ll.getWeightSum()){
						viewToFoucus = ll.getChildAt(iCount+1);
					}
				default:
					break;
				}

			}
			
			if(viewToFoucus != null){
				viewToFoucus.requestFocus();
				return true;
			}else{
			
			return false;
			}
		}
		
	};
	
	OnKeyListener mNewButtonKeyListener = new OnKeyListener(){

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN && event.getAction() == KeyEvent.ACTION_DOWN &&
					v == ll.getChildAt(ll.getChildCount()-1)
					){
				findViewById(R.id.click).requestFocus();
				return true;
			}
			
			
			
			return false;
		}
		
	};
	
	private Runnable mScrollToBottom = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int off = ll.getMeasuredHeight() - msv.getHeight();
			if(off > 0){
				msv.scrollTo(0, off);
			}
		}
		
	};
	
	
	
}
