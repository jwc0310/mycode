package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class learnSpinner extends Activity {
	
	private static final String[] m_Contries = { "O","A","B","AB","OTHER" };
	private ArrayAdapter<String> adapter;
	
	private TextView tv;
	private Spinner spi;
	private Button b;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		
		tv = (TextView)findViewById(R.id.textView1);
		spi = (Spinner)findViewById(R.id.spinner1);
		b = (Button)findViewById(R.id.button1);
		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m_Contries);
		
		spi.setAdapter(adapter);
		
		
		spi.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				tv.setText("your select is: "+m_Contries[position]);
				view.setVisibility(View.VISIBLE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent bac = new Intent();
				bac.setClass(learnSpinner.this, MainActivity.class);
				startActivity(bac);
				learnSpinner.this.finish();
			}
			
		});
		
		
	}
}
