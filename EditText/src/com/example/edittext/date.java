package com.example.edittext;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class date extends Activity{

	private Calendar c;
	private DatePicker m_datePicker;
	private TimePicker m_timePicker;
	private Button back,dm,tm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date);
		
		
		m_datePicker = (DatePicker)findViewById(R.id.datePicker);
		m_timePicker = (TimePicker)findViewById(R.id.timePicker);
		back = (Button)findViewById(R.id.back);
		dm = (Button)findViewById(R.id.dm);
		tm = (Button)findViewById(R.id.tm);
		
		back.setOnClickListener(buttonEvent);
		tm.setOnClickListener(buttonEvent);
		dm.setOnClickListener(buttonEvent);
		
		
		c = Calendar.getInstance();
		
		m_datePicker.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),new OnDateChangedListener(){

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				// TODO Auto-generated method stub
				// do with date changing
			}
			
		});
		
		m_timePicker.setIs24HourView(true);
		m_timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				//time changed deal with
			}
			
		});
		
		
		
	}
	
	
	OnClickListener buttonEvent = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.dm:
				Log.i("Andy", "Clicking dm");
				new DatePickerDialog(date.this,new DatePickerDialog.OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						c.set(Calendar.YEAR, year);
						c.set(Calendar.MONTH, monthOfYear);
						c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
						
						
					}
				},c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
				
				
				break;
			case R.id.tm:
				Log.i("Andy", "Clicking tm");
				new TimePickerDialog(date.this,new TimePickerDialog.OnTimeSetListener() {
					@Override		
					public void onTimeSet(TimePicker view, int hourOfDay,int minute)
							{
								//…Ë÷√ ±º‰
								c.set(Calendar.HOUR_OF_DAY,hourOfDay);
								c.set(Calendar.MINUTE,minute);
								
							}
						},c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();
				
				break;
			case R.id.back:
				Log.i("Andy", "Clicking Back");
				Intent toMain = new Intent();
				toMain.setClass(date.this, MainActivity.class);
				startActivity(toMain);
				date.this.finish();
				break;
			default:
				break;
			
			}
		}
		
	};
	
	
	
}
