package com.example.playtab;

import com.example.playtab.fragment.CommonUIFragment;
import com.example.playtab.fragment.LaunchUIFragment;
import com.example.playtab.view.SyncHorizontalScorllView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;

import com.example.edittext.R;

public class MainTabActivity extends FragmentActivity {

	public static final String ARGUMENTS_NAME = "Andy";
	
	private RelativeLayout rl_nav;
	private SyncHorizontalScorllView mHsv;
	private RadioGroup rg_nav_content;
	
	private ImageView iv_indicator,left,right;
	
	private ViewPager mViewPager;
	private int indicatorWidth;
	public static String[] tabTitle = {"选项1","选项2","选项3","选项4","选项5"};
	
	private LayoutInflater mInflater;
	
	private TabFragmentPagerAdapter mAdapter;
	
	private int currentIndicatorLeft = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintab_activity);
		
		findViewById();
		initView();
		setListener();
	}
	private void initView(){
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		indicatorWidth = dm.widthPixels / 4;
		
		LayoutParams cursor_Params = iv_indicator.getLayoutParams();
		cursor_Params.width = indicatorWidth;// 初始化滑动下标的宽
		iv_indicator.setLayoutParams(cursor_Params);
		
		mHsv.setSomeParam(rl_nav, left, right, this);
		
		//获取布局填充器
		mInflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);

		//另一种方式获取
//		LayoutInflater mInflater = LayoutInflater.from(this);  
		
		initNavigationHSV();
		
		mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
	}
	private void initNavigationHSV() {
		
		rg_nav_content.removeAllViews();
		
		for(int i=0;i<tabTitle.length;i++){
			
			RadioButton rb = (RadioButton) mInflater.inflate(R.layout.nav_radiogroup_item, null);
			rb.setId(i);
			rb.setText(tabTitle[i]);
			rb.setLayoutParams(new LayoutParams(indicatorWidth,
					LayoutParams.MATCH_PARENT));
			
			rg_nav_content.addView(rb);
		}
		
	}
	
	private void setListener(){
		
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
				Log.i("Andy", "onPageSelected()");
				// TODO Auto-generated method stub
				if(rg_nav_content!=null && rg_nav_content.getChildCount()>arg0){
					((RadioButton)rg_nav_content.getChildAt(arg0)).performClick(); 
				}
			}
			
		});
		
		
		
		rg_nav_content.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				Log.i("Andy", "onCheckedChanged()");
				// TODO Auto-generated method stub
				if(rg_nav_content.getChildAt(checkedId)!=null){
					TranslateAnimation animation = new TranslateAnimation(currentIndicatorLeft ,
							((RadioButton) rg_nav_content.getChildAt(checkedId)).getLeft(), 0f, 0f);
					animation.setInterpolator(new LinearInterpolator());
					animation.setDuration(100);
					animation.setFillAfter(true);
					
					
					//执行位移动画
					iv_indicator.startAnimation(animation);
					
					mViewPager.setCurrentItem(checkedId);	//ViewPager 跟随一起 切换
					
					//记录当前 下标的距最左侧的 距离
					currentIndicatorLeft = ((RadioButton) rg_nav_content.getChildAt(checkedId)).getLeft();
					
					mHsv.smoothScrollTo(
							(checkedId > 1 ? ((RadioButton) rg_nav_content.getChildAt(checkedId)).getLeft() : 0) - ((RadioButton) rg_nav_content.getChildAt(2)).getLeft(), 0);
					
					
					
				}
			}
			
		});
		
		
		
		
		
	}
	private void findViewById(){
		rl_nav = (RelativeLayout)findViewById(R.id.rl_tab);
		mHsv = (SyncHorizontalScorllView) findViewById(R.id.mHsv);
		rg_nav_content = (RadioGroup)findViewById(R.id.rg_nav_content);
		iv_indicator = (ImageView) findViewById(R.id.iv_nav_indicator);  
        left = (ImageView) findViewById(R.id.iv_nav_left);  
        right = (ImageView) findViewById(R.id.iv_nav_right);  
          
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);  
	}
	
	
	public static class TabFragmentPagerAdapter extends FragmentPagerAdapter{

		public TabFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			Fragment ft = null;
			switch(arg0){
			case 0:
				ft = new LaunchUIFragment();
				break;
			case 1:
				ft = new CommonUIFragment();
				Bundle args = new Bundle();
				args.putString(ARGUMENTS_NAME, tabTitle[arg0]);
				ft.setArguments(args);
				break;
				
				
				
			}
			
			return ft;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return tabTitle.length;
		}
		
	}
	
}
