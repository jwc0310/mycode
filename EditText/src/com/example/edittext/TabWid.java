package com.example.edittext;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class TabWid extends TabActivity {

	TabHost mTabHost;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabwid);
		
		mTabHost = getTabHost();
		
		//ΪTabHost��ӱ�ǩ
		//�½�һ��newTabSpec(newTabSpec)
		//�������ǩ��ͼ��(setIndicator)
		//��������(setContent)
		mTabHost.addTab(mTabHost.newTabSpec("tab_test1")
				.setIndicator("TAB 1",getResources().getDrawable(R.drawable.ic_vm_sound_off_dk))
				.setContent(R.id.tv1));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test2")
				.setIndicator("TAB 2",getResources().getDrawable(R.drawable.ic_vm_sound_on_dk))
				.setContent(R.id.tv2));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test3")
				.setIndicator("TAB 3",getResources().getDrawable(R.drawable.ic_menu_all_contacts_dk))
				.setContent(R.id.tv3));
		mTabHost.addTab(mTabHost.newTabSpec("tab_andy1")
				.setIndicator("Andy 1",null)
				.setContent(R.id.viewPager1));
		
		//set TabHost background color
		mTabHost.setBackgroundColor(Color.argb(150, 22, 70, 150));
		//set TabHost background pic
		mTabHost.setBackgroundResource(R.drawable.bg2);
		
		//set current tab
		mTabHost.setCurrentTab(0);
		
		//set tab deal with event
		mTabHost.setOnTabChangedListener(new OnTabChangeListener(){

			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				Dialog dialog = new AlertDialog.Builder(TabWid.this)
						.setTitle("��ʾ")
						.setMessage("��ǰѡ�У�"+tabId+"��ǩ")
						.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								dialog.cancel();
							}
						}).create();
				
				dialog.show();
			}
			
		});
		
		
		
	}
	
}
