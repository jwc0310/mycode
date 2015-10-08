package com.example.edittext;

import com.example.game.GameSurViewActivity;
import com.example.game.GameViewActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndyGame extends Activity {
	
	private Button gameView,gameSurface;
	
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
			default:
				Log.i("Andy", "default");
				break;
			}
		}
		
	};
	
}
