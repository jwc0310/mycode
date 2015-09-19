package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

public class auto extends Activity {
	
	private static final String[] autoString = new String[] { "a2","abf","abe","abcde","abc2","abcd3","abcde2","abcd2","abcde2"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auto);
		
		Button b = (Button)findViewById(R.id.back);
		//¹ØÁª¹Ø¼ü×Ö
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,autoString);
		AutoCompleteTextView m_auto = (AutoCompleteTextView)findViewById(R.id.autoC);
		m_auto.setAdapter(adapter);
		
		MultiAutoCompleteTextView mm_auto = (MultiAutoCompleteTextView)findViewById(R.id.autoM);
		mm_auto.setAdapter(adapter);
		
		mm_auto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		
		
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent toAuto = new Intent();
				toAuto.setClass(auto.this, MainActivity.class);
				startActivity(toAuto);
				auto.this.finish();
			}
			
		});
		
		
	}
}
