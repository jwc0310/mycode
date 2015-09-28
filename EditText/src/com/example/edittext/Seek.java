package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Seek extends Activity implements SeekBar.OnSeekBarChangeListener, OnClickListener {
	
	private SeekBar m_seek;
	private TextView tv1,tv2;
	Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seek);
		
		m_seek = (SeekBar)findViewById(R.id.seek);
		tv1 = (TextView)findViewById(R.id.progress);
		tv2 = (TextView)findViewById(R.id.tracking);
		b = (Button)findViewById(R.id.button01);
		
		m_seek.setOnSeekBarChangeListener(this);
		b.setOnClickListener(this);
		
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		tv1.setText("the Current value is "+progress);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		tv2.setText("Changing...");
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		tv2.setText("stop change");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(Seek.this,MainActivity.class);
		startActivity(intent);
		Seek.this.finish();
	}
}
