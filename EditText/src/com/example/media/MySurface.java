package com.example.media;

import com.example.edittext.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.media.MediaPlayer;

public class MySurface extends Activity implements OnBufferingUpdateListener,
				OnCompletionListener,
				MediaPlayer.OnPreparedListener,
				SurfaceHolder.Callback{
	private static final String TAG = "Andy";
	private int mVideoWidth;
	private int mVideoHeight;
	private MediaPlayer mMediaPlayer;
	private SurfaceView mPreview;
	private SurfaceHolder holder;
	private String path;
	
	@Override
	protected void onCreate(Bundle save){
		super.onCreate(save);
		setContentView(R.layout.mysurface);
		mPreview = (SurfaceView)findViewById(R.id.surfaceView1);
		//get SurfaceHolder obj
		holder = mPreview.getHolder();
		//set Callback func
		holder.addCallback(this);
		//set style
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	private void playVideo(){
		try{
			path = "/storage/emulated/legacy/一次就好.mp4";
			mMediaPlayer = new MediaPlayer();
			mMediaPlayer.setDataSource(path);
			mMediaPlayer.setDisplay(holder);
			mMediaPlayer.prepare();
			mMediaPlayer.setOnBufferingUpdateListener(this);
			mMediaPlayer.setOnCompletionListener(this);
			mMediaPlayer.setOnPreparedListener(this);
			mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.d(TAG, "surfaceCreated called");
		playVideo();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		Log.d(TAG, "surfaceChanged called");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.d(TAG, "surfaceDestroyed called");
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onPrepared called");
		mVideoWidth = mMediaPlayer.getVideoWidth();
		mVideoHeight = mMediaPlayer.getVideoHeight();
		if (mVideoWidth != 0 && mVideoHeight != 0)
		{
			/* 设置视频的宽度和高度 */
			holder.setFixedSize(mVideoWidth, mVideoHeight);
			/* 开始播放 */
			mMediaPlayer.start();
		}
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onCompletion called");
	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onBufferingUpdate percent:" + percent);
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
		if (mMediaPlayer != null)
		{
			mMediaPlayer.release();
			mMediaPlayer = null;
		}
	}
}
