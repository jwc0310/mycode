package com.andy.opensource.fw.imageloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.andy.opensource.fw.imageloader.Constants.Extra;
import static com.andy.opensource.fw.imageloader.Constants.IMAGES;
import com.andy.utils.LG;
import com.example.edittext.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ImageLoaderDemo extends BaseActivity {

	private static final String TEST_FILE_NAME = "Living Things @#&=+-_.,!()~'%20.jpg";
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageloaderdemo);
		
		//�����ļ�����Ŀ¼��/mnt/sdcard �ļ�����TEST_FILE_NAME
		File testImageOnSdCard = new File("/mnt/sdcard",TEST_FILE_NAME);
		if(!testImageOnSdCard.exists()){ //����ļ�������
			LG.i(getClass(), "start copy test file !");
			copyTestImageToSdCard(testImageOnSdCard);
		}else{
			LG.i(getClass(), "need not to copy !");
		}
		
	}
	
	//�������ListViewչʾ����
	public void onImageListClick(View view){
		LG.i(getClass(), "ListView");
		Intent listIntent = new Intent(this,ImageListActivity.class);
		listIntent.putExtra(Extra.IMAGES, IMAGES);
		startActivity(listIntent);
	}
	public void onImageGridClick(View view){
		
	}
	public void onImagePagerClick(View view){
	
	}
	public void onImageGalleryClick(View view){
	
	}
	
	
	/**
	 * ��һ���̰߳�assertĿ¼�µ�ͼƬ���Ƶ�SD��Ŀ¼��
	 * @param testImageOnSdCard
	 */
	private void copyTestImageToSdCard(final File testImageOnSdCard) {
		new Thread(new Runnable(){
			@Override
			public void run(){
				try {
					InputStream is = getAssets().open(TEST_FILE_NAME);
					FileOutputStream fos = new FileOutputStream(testImageOnSdCard);
					byte[] buffer = new byte[1024*8];
					int read;
					
					while((read = is.read(buffer)) != -1){
						fos.write(buffer, 0, read);
					}
					fos.flush(); //д��sd��
					fos.close();
					is.close();
					
					LG.i(getClass(), "Copy completed !");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LG.v(getClass(), "Cannot copy test image onto SD card");
				}
			}
		}).start();
	}
	
}
