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
	private Button radio,checkbox,spin,auto,data;
	private Button exit,menu,dialog,imageButton;
	private Button gallery,switcher,grid,scroll;
	private Button proBar,seekBar,notify;
	
	
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
        data = (Button)findViewById(R.id.date);
        exit = (Button)findViewById(R.id.exit);
        menu = (Button)findViewById(R.id.menu);
        dialog = (Button)findViewById(R.id.dialog);
        imageButton = (Button)findViewById(R.id.imageButton);
        gallery = (Button)findViewById(R.id.gallery);
        switcher = (Button)findViewById(R.id.switcher);
        grid = (Button)findViewById(R.id.gridView01);
        scroll = (Button)findViewById(R.id.scrollView);
        proBar = (Button)findViewById(R.id.ProgressBar);
        seekBar = (Button)findViewById(R.id.SeekBar);
        notify = (Button)findViewById(R.id.Notify);
        
        radio.setOnClickListener(button);
        checkbox.setOnClickListener(button);
        spin.setOnClickListener(button);
        auto.setOnClickListener(button);
        data.setOnClickListener(button);
        exit.setOnClickListener(button);
        menu.setOnClickListener(button);
        dialog.setOnClickListener(button);
        imageButton.setOnClickListener(button);
        gallery.setOnClickListener(button);
        switcher.setOnClickListener(button);
        grid.setOnClickListener(button);
        scroll.setOnClickListener(button);
        proBar.setOnClickListener(button);
        seekBar.setOnClickListener(button);
        notify.setOnClickListener(button);
        
        
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
			case R.id.date:
				Intent toData = new Intent();
				toData.setClass(MainActivity.this, date.class);
				startActivity(toData);
				MainActivity.this.finish();
			
			case R.id.exit:
				MainActivity.this.finish();
				break;
			case R.id.menu:
				Intent toMenu = new Intent();
				toMenu.setClass(MainActivity.this, menu.class);
				startActivity(toMenu);
				MainActivity.this.finish();
				break;
			case R.id.dialog:
				Intent toDialog = new Intent();
				toDialog.setClass(MainActivity.this, LearnDialog.class);
				startActivity(toDialog);
				MainActivity.this.finish();
				
				break;
				
			case R.id.imageButton:
				Intent toImagebutton = new Intent();
				toImagebutton.setClass(MainActivity.this, LearnImagebutton.class);
				startActivity(toImagebutton);
				MainActivity.this.finish();
				
				break;
				
			case R.id.gallery:
				Intent togallery = new Intent();
				togallery.setClass(MainActivity.this, gallery.class);
				startActivity(togallery);
				MainActivity.this.finish();
				
				break;
				
			case R.id.switcher:
				Intent toswitcher = new Intent();
				toswitcher.setClass(MainActivity.this, imageSwitcher.class);
				startActivity(toswitcher);
				MainActivity.this.finish();
				
				break;
			case R.id.gridView01:
				Intent toGrid = new Intent();
				toGrid.setClass(MainActivity.this, gridView.class);
				startActivity(toGrid);
				MainActivity.this.finish();
				
				break;
				
			case R.id.scrollView:
				Intent toScroll = new Intent();
				toScroll.setClass(MainActivity.this, scroll.class);
				startActivity(toScroll);
				MainActivity.this.finish();
				
				break;
				
			case R.id.ProgressBar:
				Intent toPro = new Intent();
				toPro.setClass(MainActivity.this, Probar.class);
				startActivity(toPro);
				MainActivity.this.finish();
				break;
				
			case R.id.SeekBar:
				Intent toSeek = new Intent();
				toSeek.setClass(MainActivity.this, Seek.class);
				startActivity(toSeek);
				MainActivity.this.finish();
				break;
				
			case R.id.Notify:
				Intent toNotify = new Intent();
				toNotify.setClass(MainActivity.this, Notify.class);
				startActivity(toNotify);
				MainActivity.this.finish();
				break;
				
			default:
				break;
			}
		}
		
	};
    
    
    
    
}
