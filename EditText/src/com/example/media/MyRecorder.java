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
	// ¼�Ƶ���Ƶ�ļ�
	private File mRecAudioFile;
	private File mRecAudioPath;
	//MediaRecorder obj
	MediaRecorder mMediaRecorder;
	//¼���ļ��б�
	private List<String> mMusicList = new ArrayList<String>();
	//��ʱ�ļ�ǰ׺
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
			Toast.makeText(this, "SD������", Toast.LENGTH_SHORT);
			mRecAudioPath = Environment.getExternalStorageDirectory();
			Log.i("Andy", "SD card exist ! and Path is " + mRecAudioPath);
			
			musicList();
			
		}else{
			Toast.makeText(this, "û��SD������", Toast.LENGTH_SHORT);
			Log.i("Andy", "SD card doesn't exist !");
		}
		
		
	}

	private void musicList(){
		//��ȡָ��λ�õ��ļ���ʾ�������б�
		File home = mRecAudioPath;
		if(home.listFiles(new MusicFilter()).length >0){
			for(File file : home.listFiles(new MusicFilter())){
				mMusicList.add(file.getName());
			}
			
			ArrayAdapter<String>musicList = new ArrayAdapter<String>(this,R.layout.myrecorder_list,mMusicList);
			setListAdapter(musicList);
		}
	}
	//����¼���ļ�
	private void playMusic(File file){
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		//�����ļ�����
		intent.setDataAndType(Uri.fromFile(file), "audio");
		startActivity(intent);
	}
	@Override
	protected void onListItemClick(ListView l, View v,int position, long id){
		//�õ���������ļ�
		File playfile = new File(mRecAudioPath.getAbsoluteFile()+File.separator+mMusicList.get(position));
		playMusic(playfile);
	}
	
	//�����ļ�����
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
				//����¼���ļ�
				mRecAudioFile = File.createTempFile(strTempFile, ".amr", mRecAudioPath);
				//ʵ����MediaRecorder����
				mMediaRecorder = new MediaRecorder();
				//����MIC
				mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				//��������ļ��ĸ�ʽ
				mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
				//������Ƶ�ļ��ı���
				mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
				//�����ļ������·��
				mMediaRecorder.setOutputFile(mRecAudioFile.getAbsolutePath());
				//׼��
				mMediaRecorder.prepare();
				//��ʼ
				mMediaRecorder.start();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case R.id.stop:
			if(mRecAudioFile != null){
				//ֹͣ¼��
				mMediaRecorder.stop();
				//add to list
				mMusicList.add(mRecAudioFile.getName());
				ArrayAdapter<String> musicList = new ArrayAdapter<String>(this, R.layout.myrecorder_list, mMusicList);
				setListAdapter(musicList);
				/* �ͷ�MediaRecorder */
				mMediaRecorder.release();
				mMediaRecorder = null;
			}
			
			break;
		}
	}
}
