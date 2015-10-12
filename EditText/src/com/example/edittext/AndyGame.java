package com.example.edittext;

import com.example.button.ButtonActivity;
import com.example.game.GameSurViewActivity;
import com.example.game.GameViewActivity;
import com.example.mygraphics.GameCanvas;
import com.example.mygraphics.GameCanvasActivity;
import com.example.mygraphics.GameFontActivity;
import com.example.mygraphics.GameView1Activity;
import com.example.mygraphics.GameViewBitmapActivity;
import com.example.playtab.MainTabActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndyGame extends Activity {
	
	private Button gameView,gameSurface,tab,own,canvas,graphics,font;
	private Button bitmap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.andygame);
		
		defAndBindEvent();
	}
	
	private void defAndBindEvent(){
		gameView = (Button)findViewById(R.id.gameview);
		gameView.setOnClickListener(buttonEvent);
		
		gameSurface = (Button)findViewById(R.id.gamesurfaceview);
		gameSurface.setOnClickListener(buttonEvent);
		
		tab = (Button)findViewById(R.id.tablearn);
		tab.setOnClickListener(buttonEvent);
		
		own = (Button)findViewById(R.id.ownbutton);
		own.setOnClickListener(buttonEvent);
		
		canvas = (Button)findViewById(R.id.canvas);
		canvas.setOnClickListener(buttonEvent);
		
		graphics = (Button)findViewById(R.id.graphics);
		graphics.setOnClickListener(buttonEvent);
		
		font = (Button)findViewById(R.id.font);
		font.setOnClickListener(buttonEvent);
		
		bitmap = (Button)findViewById(R.id.bitmap);
		bitmap.setOnClickListener(buttonEvent);
		
		
	}
	
	OnClickListener buttonEvent = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.gameview:
				Intent toGameView = new Intent(AndyGame.this,GameViewActivity.class);
				startActivity(toGameView);
				//AndyGame.this.finish();
				break;
			case R.id.gamesurfaceview:
				Intent toGameSur = new Intent(AndyGame.this,GameSurViewActivity.class);
				startActivity(toGameSur);
				break;
			case R.id.tablearn:
				Intent toTab = new Intent(AndyGame.this,MainTabActivity.class);
				startActivity(toTab);
				break;	
			
			case R.id.ownbutton:
				Intent toOwn = new Intent(AndyGame.this,ButtonActivity.class);
				startActivity(toOwn);
				break;	
				
			case R.id.canvas:
				Intent toCan = new Intent(AndyGame.this,GameCanvasActivity.class);
				startActivity(toCan);
				break;
				
			case R.id.graphics:
				Intent toGra = new Intent(AndyGame.this,GameView1Activity.class);
				startActivity(toGra);
				break;
				
			case R.id.font:
				Intent toFont = new Intent(AndyGame.this,GameFontActivity.class);
				startActivity(toFont);
				break;
				
			case R.id.bitmap:
				Intent toBit = new Intent(AndyGame.this,GameViewBitmapActivity.class);
				startActivity(toBit);
				break;
				
			default:
				Log.i("Andy", "default");
				break;
			}
		}
		
	};
	
}
