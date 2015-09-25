package com.example.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;

public class gallery extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);
		
		Gallery g = (Gallery)findViewById(R.id.gallery1);
		
		g.setAdapter(new ImageAdapter(this));
		
		g.setBackgroundResource(R.drawable.b);
		
		g.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				DisplayToast(Integer.toString(position));
				
			}
			
		});
		
	}
	
	private void DisplayToast(String str){
		Toast.makeText(gallery.this, "you selected "+str+"pic", Toast.LENGTH_LONG).show();
	}
	
}
