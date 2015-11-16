package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.edittext.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class TraditionalViewpager extends Activity {
	//ViewPager
		private ViewPager mViewPager;
		//ViewPager的适配器
		private PagerAdapter mAdapter;
		private List<View> mViews;
		private LayoutInflater mInflater;
		private int currentIndex;
		
		//底部四个按钮
		private LinearLayout mTabBtnWeixin;
		private LinearLayout mTabBtnFrd;
		private LinearLayout mTabBtnAddress;
		private LinearLayout mTabBtnSettings; 
		
		@Override
		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.traditional_viewpager);
			
			mInflater = LayoutInflater.from(this);
			mViewPager = (ViewPager)findViewById(R.id.id_viewpager);
			
			initView();
			
			mViewPager.setAdapter(mAdapter);
			mViewPager.setOnPageChangeListener(new OnPageChangeListener(){

				@Override
				public void onPageScrollStateChanged(int arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onPageSelected(int arg0) {
					// TODO Auto-generated method stub
					resetTabBtn();
					Log.i("Andy", "arg0 "+arg0);
					switch(arg0){
					case 0:
						((ImageButton)mTabBtnWeixin.findViewById(R.id.imageButton1)).setImageResource(R.drawable.tab_weixin_pressed);  
						break;
					case 1:
						((ImageButton)mTabBtnFrd.findViewById(R.id.imageButton2)).setImageResource(R.drawable.tab_find_frd_pressed);  
						break;
					case 2:
						((ImageButton)mTabBtnAddress.findViewById(R.id.imageButton3)).setImageResource(R.drawable.tab_address_pressed);  
						break;
					case 3:
						((ImageButton)mTabBtnSettings.findViewById(R.id.imageButton4)).setImageResource(R.drawable.tab_settings_pressed);  
						break;
					}
					currentIndex = arg0;
				}
				
			});
			
		}

		 protected void resetTabBtn()  
		    {  
		        ((ImageButton)mTabBtnWeixin.findViewById(R.id.imageButton1)).setImageResource(R.drawable.tab_weixin_normal);  
		        ((ImageButton)mTabBtnFrd.findViewById(R.id.imageButton2)).setImageResource(R.drawable.tab_find_frd_normal);  
		        ((ImageButton)mTabBtnAddress.findViewById(R.id.imageButton3)).setImageResource(R.drawable.tab_address_normal);  
		        ((ImageButton)mTabBtnSettings.findViewById(R.id.imageButton4)).setImageResource(R.drawable.tab_settings_normal);  
		    }
		
		private void initView(){
			mTabBtnWeixin = (LinearLayout)findViewById(R.id.id_tab_bottom_weixin);
			mTabBtnFrd = (LinearLayout)findViewById(R.id.id_tab_bottom_friend);
			mTabBtnAddress=(LinearLayout)findViewById(R.id.id_tab_bottom_contact);
			mTabBtnSettings = (LinearLayout)findViewById(R.id.id_tab_bottom_setting);
			
			mViews = new ArrayList<View>();
			View first = mInflater.inflate(R.layout.main_tab_01, null);
			View second = mInflater.inflate(R.layout.main_tab_02, null);
			View third = mInflater.inflate(R.layout.main_tab_03, null);
			View forth = mInflater.inflate(R.layout.main_tab_04, null);
			
			mViews.add(first);
			mViews.add(second);
			mViews.add(third);
			mViews.add(forth);
			
			mAdapter = new PagerAdapter(){

				@Override
				public void destroyItem(ViewGroup container, int position, Object object){
					container.removeView(mViews.get(position));
				}
				
				@Override
				public Object instantiateItem(ViewGroup container, int position){
					View view = mViews.get(position);
					container.addView(view);
					return view;
				}
				
				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return mViews.size();
				}

				@Override
				public boolean isViewFromObject(View arg0, Object arg1) {
					// TODO Auto-generated method stub
					return arg0 == arg1;
				}
				
			};
		}
		
		
		
}
