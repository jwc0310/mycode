package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.andy.custom.views.CustomViews;
import com.andy.opensource.fw.imageloader.ImageLoaderDemo;
import com.andy.utils.LG;
import com.andy.utils.json.LearnJSON;
import com.example.binderservice.BinderService;
import com.example.media.MainMediaActivity;
import com.example.net.NetActivity;

public class MainActivity extends Activity {

	private Button radio,checkbox,spin,auto,data;
	private Button exit,menu,dialog,imageButton;
	private Button gallery,switcher,grid,scroll;
	private Button proBar,seekBar,notify,proDia;
	private Button get,tab,tabwid,chapter,chapter8;
	private Button media,fragment,binder,json;
	private Button ImageLoader,customViews;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initWidget();
    }

    OnClickListener button = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.ImageLoader:
				LG.v(getClass(), "ImageLoader");
				startActivity(new Intent(MainActivity.this,ImageLoaderDemo.class));
				break;
			case R.id.Radio:
				Intent toRadio = new Intent();
				toRadio.setClass(MainActivity.this, LearnRadioButton.class);
				toRadio.putExtra("testIntent", "I am Andy !");
				toRadio.putExtra("One", "number1");
				toRadio.putExtra("Two", "number2");
				startActivity(toRadio);
				break;
			case R.id.checkbox:
				Intent toCheckbox = new Intent();
				toCheckbox.setClass(MainActivity.this, learnCheckBox.class);
				startActivity(toCheckbox);
				//MainActivity.this.finish();
				break;
			case R.id.spinner:
				Intent toSpinner = new Intent();
				toSpinner.setClass(MainActivity.this, learnSpinner.class);
				startActivity(toSpinner);
				break;
			case R.id.auto:
				Intent toAuto = new Intent();
				toAuto.setClass(MainActivity.this, auto.class);
				startActivity(toAuto);
				break;
			case R.id.date:
				Intent toData = new Intent();
				toData.setClass(MainActivity.this, date.class);
				startActivity(toData);
				//MainActivity.this.finish();
				break;
			case R.id.exit:
//				MainActivity.this.finish();
				startActivity(new Intent(MainActivity.this,ListViewWithAnimation.class));
				break;
			case R.id.menu:
				Intent toMenu = new Intent();
				toMenu.setClass(MainActivity.this, menu.class);
				startActivity(toMenu);
				break;
			case R.id.dialog:
				Intent toDialog = new Intent();
				toDialog.setClass(MainActivity.this, LearnDialog.class);
				startActivity(toDialog);
				//MainActivity.this.finish();
				break;
				
			case R.id.imageButton:
				Intent toImagebutton = new Intent();
				toImagebutton.setClass(MainActivity.this, LearnImagebutton.class);
				startActivity(toImagebutton);
				//MainActivity.this.finish();
				break;
			case R.id.gallery:
				Intent togallery = new Intent();
				togallery.setClass(MainActivity.this, gallery.class);
				startActivity(togallery);
				//MainActivity.this.finish();
				break;
			case R.id.switcher:
				Intent toswitcher = new Intent();
				toswitcher.setClass(MainActivity.this, imageSwitcher.class);
				startActivity(toswitcher);
				//MainActivity.this.finish();
				break;
			case R.id.gridView01:
				Intent toGrid = new Intent();
				toGrid.setClass(MainActivity.this, gridView.class);
				startActivity(toGrid);
				//MainActivity.this.finish();
				break;
			case R.id.scrollView:
				Intent toScroll = new Intent();
				toScroll.setClass(MainActivity.this, scroll.class);
				startActivity(toScroll);
				//MainActivity.this.finish();
				break;
			case R.id.ProgressBar:
				Intent toPro = new Intent();
				toPro.setClass(MainActivity.this, Probar.class);
				startActivity(toPro);
				break;
			case R.id.SeekBar:
				Intent toSeek = new Intent();
				toSeek.setClass(MainActivity.this, Seek.class);
				startActivity(toSeek);
				//MainActivity.this.finish();
				break;
			case R.id.Notify:
				Intent toNotify = new Intent();
				toNotify.setClass(MainActivity.this, Notify.class);
				startActivity(toNotify);
				//MainActivity.this.finish();
				break;
			case R.id.button1:
				Log.i("Andy", "button1");
				Intent toB = new Intent();
				toB.setClass(MainActivity.this, ProDia.class);
				startActivity(toB);
				//MainActivity.this.finish();
				break;
			case R.id.get:
				Log.i("Andy", "get");
				Intent toGet = new Intent();
				toGet.setClass(MainActivity.this, get.class);
				startActivity(toGet);
				break;
			case R.id.tableLayout:
				Log.i("Andy", "tab");
				Intent toTab = new Intent();
				toTab.setClass(MainActivity.this, TabLayout.class);
				startActivity(toTab);
				break;
			case R.id.tabWidget:
				Log.i("Andy", "tabWidget");
				Intent toTabW = new Intent();
				toTabW.setClass(MainActivity.this, TabWid.class);
				startActivity(toTabW);
				break;
			case R.id.chapter5:
				Log.i("Andy", "tabWidget");
				Intent toNext = new Intent();
				toNext.setClass(MainActivity.this, AndyGame.class);
				startActivity(toNext);
				break;
			case R.id.chapter8:
				Log.i("Andy", "Net");
				startActivity(new Intent(MainActivity.this,NetActivity.class));
				//MainActivity.this.finish();
				break;
			case R.id.media:
				Log.i("Andy", "Media");
				startActivity(new Intent(MainActivity.this,MainMediaActivity.class));
				break;
			case R.id.fragment:
				Log.i("Andy", "fragment");
				startActivity(new Intent(MainActivity.this,MyFragment.class));
				break;
			case R.id.binderservice:
				Log.i("Andy", "binderservice");
				startActivity(new Intent(MainActivity.this,BinderService.class));
				break;
			case R.id.json:
				Log.i("Andy", "json");
				startActivity(new Intent(MainActivity.this,LearnJSON.class));
				break;
			case R.id.customViews:
				Log.i("Andy", "json");
				startActivity(new Intent(MainActivity.this,CustomViews.class));
				break;
			default:
				break;
			}
		}
		
	};
    
    private void initWidget(){
         
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
         proDia = (Button)findViewById(R.id.button1);
         get = (Button)findViewById(R.id.get);
         tab = (Button)findViewById(R.id.tableLayout);
         tabwid = (Button)findViewById(R.id.tabWidget);
         chapter = (Button)findViewById(R.id.chapter5);
         chapter8 = (Button)findViewById(R.id.chapter8);
         media = (Button)findViewById(R.id.media);
         fragment= (Button)findViewById(R.id.fragment);
         binder = (Button)findViewById(R.id.binderservice);
         json = (Button)findViewById(R.id.json);
         ImageLoader = (Button)findViewById(R.id.ImageLoader);
         customViews = (Button)findViewById(R.id.customViews);
         ImageLoader.setOnClickListener(button);
         customViews.setOnClickListener(button);
         
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
         proDia.setOnClickListener(button);
         get.setOnClickListener(button);
         tab.setOnClickListener(button);
         tabwid.setOnClickListener(button);
         chapter.setOnClickListener(button);
         chapter8.setOnClickListener(button);
         media.setOnClickListener(button);
         fragment.setOnClickListener(button);
         binder.setOnClickListener(button);
         json.setOnClickListener(button);
         
    }
    
    
}
