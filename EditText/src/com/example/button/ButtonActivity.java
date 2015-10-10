package com.example.button;

import com.example.button.PieButtonLayout.OnItemClickListener;
import com.example.edittext.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout;

public class ButtonActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);
		
		LinearLayout layout = (LinearLayout)findViewById(R.id.main_layout);
		PieButtonLayout pie = new PieButtonLayout(this);
		
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT
				);
		
		DisplayMetrics dm = getResources().getDisplayMetrics();
		
		pie.setCenter(dm.widthPixels / 2, dm.heightPixels / 2);
		pie.setLayoutParams(lp);
		pie.addItem(pie.makeItem(R.drawable.main_icon_file, 0));
		pie.addItem(pie.makeItem(R.drawable.main_icon_live, 0));
		pie.addItem(pie.makeItem(R.drawable.main_icon_manager, 0));
		pie.addItem(pie.makeItem(R.drawable.main_icon_setting, 0));

		pie.addItem(pie.makeItem(R.drawable.main_icon_file, 1));
		pie.addItem(pie.makeItem(R.drawable.main_icon_live, 1));
		pie.addItem(pie.makeItem(R.drawable.main_icon_manager, 1));
		pie.addItem(pie.makeItem(R.drawable.main_icon_setting, 1));
		
		
		pie.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(PieItem item) {
				// TODO Auto-generated method stub
				Log.i("Andy", "item click"+item);
			}
			
		});
		
		layout.addView(pie);
		
		
	}
	
}
