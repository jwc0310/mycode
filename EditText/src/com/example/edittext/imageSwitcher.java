package com.example.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher.ViewFactory;

public class imageSwitcher extends Activity implements OnClickListener,ViewFactory {
	
	private Integer[] imageList = {
			R.drawable.ic,
			R.drawable.ic_cancel_holo_light,
			R.drawable.ic_dialer_fork_current_call,
			R.drawable.ic_launcher,
			R.drawable.ic_menu_all_contacts_dk,
			R.drawable.ic_vm_sound_off_dk,
			R.drawable.ic_vm_sound_on_dk,
	};
	
	private ImageSwitcher m_switcher;
	private static int index = 0;
	
	//object id
	private static final int BUTTON_DOWN_ID = 0x123456;
	private static final int BUTTON_UP_ID = 0x123457;
	private static final int SWITCHER_ID = 0x123458;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		
		//create linearlayout
		LinearLayout main_view = new LinearLayout(this);
		m_switcher = new ImageSwitcher(this);
		main_view.addView(m_switcher);
		m_switcher.setId(SWITCHER_ID);
		m_switcher.setFactory(this);
		m_switcher.setImageResource(imageList[index]);
		
		setContentView(main_view);
	
		Button next = new Button(this);
		next.setId(BUTTON_DOWN_ID);
		next.setText("下一张");
		next.setOnClickListener(this);
		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(100,100);
		main_view.addView(next,param);
		
		Button up = new Button(this);
		up.setId(BUTTON_UP_ID);
		up.setText("上一张");
		up.setOnClickListener(this);
		main_view.addView(up,param);
	
	}

	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		return new ImageView(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case BUTTON_DOWN_ID:
			index++;
			if(index>=imageList.length){
				index = 0;
			}
			m_switcher.setImageResource(imageList[index]);
			
			break;
		case BUTTON_UP_ID:
			index--;
			if(index <0){
				index = imageList.length-1;
			}
			
			m_switcher.setImageResource(imageList[index]);
			break;
		}
		
		
		
	}
}
