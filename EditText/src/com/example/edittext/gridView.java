package com.example.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class gridView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
		
		
		GridView gv = (GridView)findViewById(R.id.gridview);
		gv.setAdapter(new ImageAdapter1(this));
		
		
		gv.setBackgroundResource(R.drawable.b);
		
		gv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				DisplayToast(Integer.toString(position+1));
			}

		});
		
	}
	
	
	private void DisplayToast(String str){
		Toast.makeText(gridView.this, "you selected number:"+str+"pic", Toast.LENGTH_SHORT).show();
	}
}
