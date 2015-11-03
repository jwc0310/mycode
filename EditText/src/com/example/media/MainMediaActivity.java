package com.example.media;

import com.example.edittext.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainMediaActivity extends Activity implements OnClickListener {
	private VideoView videoView;
	private Button load,play,pause;
	private Button surface,recorder;
	private static final String VIDEO_PATH = new String("/storage/emulated/legacy/一次就好.mp4");
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmediaui);
		
		videoView = (VideoView)findViewById(R.id.videoView1);
		load = (Button)findViewById(R.id.LoadButton);
		play = (Button)findViewById(R.id.play);
		pause = (Button)findViewById(R.id.pause);
		surface = (Button)findViewById(R.id.surface);
		recorder = (Button)findViewById(R.id.recorder);
		
		load.setOnClickListener(this);
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		surface.setOnClickListener(this);
		recorder.setOnClickListener(this);
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
		case R.id.surface:
			startActivity(new Intent(this,MySurface.class));
			break;
		case R.id.recorder:
			startActivity(new Intent(this,MyRecorder.class));
			break;
			
		}
	}
		
}
