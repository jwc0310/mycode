package com.example.media;

import com.example.edittext.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainMediaActivity extends Activity implements OnClickListener {
	private VideoView videoView;
	private Button load,play,pause;
	private static final String VIDEO_PATH = new String("/storage/sdcard1/music/Wildlife.wmv");
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmediaui);
		
		videoView = (VideoView)findViewById(R.id.videoView1);
		load = (Button)findViewById(R.id.LoadButton);
		play = (Button)findViewById(R.id.play);
		pause = (Button)findViewById(R.id.pause);
		
		load.setOnClickListener(this);
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.LoadButton:
			videoView.setVideoPath(VIDEO_PATH);
			//设置模式-播放进度条
			videoView.setMediaController(new MediaController(MainMediaActivity.this));
			videoView.requestFocus();
			break;
		case R.id.play:
			videoView.start();
			break;
		case R.id.pause:
			videoView.pause();
			break;
		}
	}
		
}
