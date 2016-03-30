package com.andy.custom.views;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.andy.utils.DensityUtils;
import com.andy.utils.T;
import com.example.edittext.R;

public class CustomViews extends Activity implements View.OnClickListener {

	private Button popWindow;
	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.customviews);
		initView();
	}
	
	private void initView(){
		popWindow = (Button)findViewById(R.id.popWindow);
		popWindow.setOnClickListener(this);
	}
	private void showPopWindow(View view){
		View contentView = LayoutInflater.from(mContext).inflate(R.layout.popwindow_tips, null);
		Button jump = (Button)contentView.findViewById(R.id.popwindow_tips_button);
		jump.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				T.showShort(mContext, "popwindow is show");
			}
		});
		TextView content = (TextView)contentView.findViewById(R.id.popwindow_tips_content);
		
		final PopupWindow pop = new PopupWindow(contentView, LayoutParams.MATCH_PARENT,
				DensityUtils.dp2px(mContext, 150), true);
		pop.setTouchable(true);
		pop.setTouchInterceptor(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				T.showShort(mContext, "onTouch :");
				return false;
			}
		});
		pop.setBackgroundDrawable(getResources().getDrawable(R.drawable.a1));
		pop.showAsDropDown(view);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if(id == R.id.popWindow){
			showPopWindow(v);
		}
	}

}
