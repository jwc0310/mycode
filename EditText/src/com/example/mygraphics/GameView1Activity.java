package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameView1Activity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		GameView1 mGameView1 = new GameView1(this);
		setContentView(mGameView1);
	}
	
}
