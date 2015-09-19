package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv1;
	private EditText et1;
	private Button radio,checkbox,spin,auto;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv1 = (TextView)findViewById(R.id.textView1);
        et1 = (EditText)findViewById(R.id.editText1);
        et1.setHint("请输入账号：");
        
        radio = (Button)findViewById(R.id.Radio);
        checkbox = (Button)findViewById(R.id.checkbox);
        spin = (Button)findViewById(R.id.spinner);
        auto = (Button)findViewById(R.id.auto);
        
        radio.setOnClickListener(button);
        checkbox.setOnClickListener(button);
        spin.setOnClickListener(button);
        auto.setOnClickListener(button);
        
        
        
        et1.setOnKeyListener(new OnKeyListener(){

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				
				tv1.setText("文板框中内容是2："+et1.getText().toString());
				
				return false;
			}
        	
        });
        
        
        et1.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				tv1.setText("文板框中内容是3："+et1.getText().toString());
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				tv1.setText("文板框中内容是4："+et1.getText().toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				tv1.setText("文板框中内容是5："+et1.getText().toString());
			}
        	
        });
        
        
    }
    
    
    OnClickListener button = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.Radio:
				Intent toRadio = new Intent();
				toRadio.setClass(MainActivity.this, LearnRadioButton.class);
				startActivity(toRadio);
				MainActivity.this.finish();
				
				break;
			case R.id.checkbox:
				Intent toCheckbox = new Intent();
				toCheckbox.setClass(MainActivity.this, learnCheckBox.class);
				startActivity(toCheckbox);
				MainActivity.this.finish();
				break;
			
			case R.id.spinner:
				Intent toSpinner = new Intent();
				toSpinner.setClass(MainActivity.this, learnSpinner.class);
				startActivity(toSpinner);
				MainActivity.this.finish();
				
				break;
			
			case R.id.auto:
				Intent toAuto = new Intent();
				toAuto.setClass(MainActivity.this, auto.class);
				startActivity(toAuto);
				MainActivity.this.finish();
				break;
				
				
			default:
				break;
			}
		}
		
	};
    
    
    
    
}
