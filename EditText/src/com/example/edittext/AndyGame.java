package com.example.edittext;

import com.example.button.ButtonActivity;
import com.example.game.GameSurViewActivity;
import com.example.game.GameViewActivity;
import com.example.mygraphics.GameCanvas;
import com.example.mygraphics.GameCanvasActivity;
import com.example.mygraphics.GameFontActivity;
import com.example.mygraphics.GameView1Activity;
import com.example.mygraphics.GameViewBitmapActivity;
import com.example.mygraphics.GameViewDoubleBufferActivity;
import com.example.mygraphics.GameViewFrameActivity;
import com.example.mygraphics.GameViewGifActivity;
import com.example.mygraphics.GameViewRotateActivity;
import com.example.mygraphics.GameViewScaleActivity;
import com.example.mygraphics.GameViewShaderActivity;
import com.example.mygraphics.GameViewTweenActivity;
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
	private Button bitmap,rotate,scale,shader,douBuf,tween,frame,gif;
	
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
		
		rotate = (Button)findViewById(R.id.rotate);
		rotate.setOnClickListener(buttonEvent);
		
		scale = (Button)findViewById(R.id.scale);
		scale.setOnClickListener(buttonEvent);
		
		shader = (Button)findViewById(R.id.shader);
		shader.setOnClickListener(buttonEvent);
		
		douBuf = (Button)findViewById(R.id.doubuf);
		douBuf.setOnClickListener(buttonEvent);
		
		tween = (Button)findViewById(R.id.tween);
		tween.setOnClickListener(buttonEvent);
		
		frame = (Button)findViewById(R.id.frame);
		frame.setOnClickListener(buttonEvent);
		
		gif = (Button)findViewById(R.id.gif);
		gif.setOnClickListener(buttonEvent);
		
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
				
			case R.id.rotate:
				Intent toRotate = new Intent(AndyGame.this,GameViewRotateActivity.class);
				startActivity(toRotate);
				break;
				
			case R.id.scale:
				Intent toScale = new Intent(AndyGame.this,GameViewScaleActivity.class);
				startActivity(toScale);
				break;
				
			case R.id.shader:
				Intent toShader = new Intent(AndyGame.this,GameViewShaderActivity.class);
				startActivity(toShader);
				break;
				
			case R.id.doubuf:
				Intent toDouBuf = new Intent(AndyGame.this,GameViewDoubleBufferActivity.class);
				startActivity(toDouBuf);
				break;
				
			case R.id.tween:
				Intent toTween = new Intent(AndyGame.this,GameViewTweenActivity.class);
				startActivity(toTween);
				break;
				
			case R.id.frame:
				Intent toFrame = new Intent(AndyGame.this,GameViewFrameActivity.class);
				startActivity(toFrame);
				break;
				
			case R.id.gif:
				Intent toGif = new Intent(AndyGame.this,GameViewGifActivity.class);
				startActivity(toGif);
				break;
				
			default:
				Log.i("Andy", "default");
				break;
			}
		}
		
	};
	
}
