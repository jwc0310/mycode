package com.example.media;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.example.edittext.R;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
public class MyRecorder extends ListActivity implements View.OnClickListener {
	//Button
	private Button start,stop;
	// 录制的音频文件
	private File mRecAudioFile;
	private File mRecAudioPath;
	//MediaRecorder obj
	MediaRecorder mMediaRecorder;
	//录音文件列表
	private List<String> mMusicList = new ArrayList<String>();
	//临时文件前缀
	private String strTempFile = "recaudio_";
	
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.myrecorder);
		
		start = (Button)findViewById(R.id.start);
		stop = (Button)findViewById(R.id.stop);
		
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		
		//check whether it has SD card
		if(Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			Toast.makeText(this, "SD卡存在", Toast.LENGTH_SHORT);
			mRecAudioPath = Environment.getExternalStorageDirectory();
			Log.i("Andy", "SD card exist ! and Path is " + mRecAudioPath);
			
			musicList();
			
		}else{
			Toast.makeText(this, "没有SD卡存在", Toast.LENGTH_SHORT);
			Log.i("Andy", "SD card doesn't exist !");
		}
		
		
	}

	private void musicList(){
		//获取指定位置的文件显示到播放列表
		File home = mRecAudioPath;
		if(home.listFiles(new MusicFilter()).length >0){
			for(File file : home.listFiles(new MusicFilter())){
				mMusicList.add(file.getName());
			}
			
			ArrayAdapter<String>musicList = new ArrayAdapter<String>(this,R.layout.myrecorder_list,mMusicList);
			setListAdapter(musicList);
		}
	}
	//播放录音文件
	private void playMusic(File file){
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		//设置文件类型
		intent.setDataAndType(Uri.fromFile(file), "audio");
		startActivity(intent);
	}
	@Override
	protected void onListItemClick(ListView l, View v,int position, long id){
		//得到被点击的文件
		File playfile = new File(mRecAudioPath.getAbsoluteFile()+File.separator+mMusicList.get(position));
		playMusic(playfile);
	}
	
	//过滤文件类型
	class MusicFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String filename) {
			// TODO Auto-generated method stub
			return (filename.endsWith(".amr"));
		}
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.start:
			try{
				//创建录音文件
				mRecAudioFile = File.createTempFile(strTempFile, ".amr", mRecAudioPath);
				//实例化MediaRecorder对象
				mMediaRecorder = new MediaRecorder();
				//设置MIC
				mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				//设置输出文件的格式
				mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
				//设置音频文件的编码
				mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
				//设置文件的输出路径
				mMediaRecorder.setOutputFile(mRecAudioFile.getAbsolutePath());
				//准备
				mMediaRecorder.prepare();
				//开始
				mMediaRecorder.start();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case R.id.stop:
			if(mRecAudioFile != null){
				//停止录音
				mMediaRecorder.stop();
				//add to list
				mMusicList.add(mRecAudioFile.getName());
				ArrayAdapter<String> musicList = new ArrayAdapter<String>(this, R.layout.myrecorder_list, mMusicList);
				setListAdapter(musicList);
				/* 释放MediaRecorder */
				mMediaRecorder.release();
				mMediaRecorder = null;
			}
			
			break;
		}
	}
}
