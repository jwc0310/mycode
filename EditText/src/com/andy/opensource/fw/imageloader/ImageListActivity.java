package com.andy.opensource.fw.imageloader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.andy.opensource.fw.imageloader.Constants.Extra;
import com.andy.utils.LG;
import com.example.edittext.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ImageListActivity extends AbsListViewBaseActivity {
	
	DisplayImageOptions options; //DisplayImageOptions用于设置图片显示类
	
	String[] imageUrls;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_image_list);
		
		Bundle bundle = getIntent().getExtras();
		imageUrls = bundle.getStringArray(Extra.IMAGES);
		
		imageLoader.init(ImageLoaderConfiguration.createDefault(this));
		
		//使用DisplayImageOptions.Builder()创建DisplayImageOptions
		options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.ic_stub)
			.showImageForEmptyUri(R.drawable.ic_empty)
			.showImageOnFail(R.drawable.ic_error)
			.cacheInMemory(true)
			.cacheOnDisc(true)
			.displayer(new RoundedBitmapDisplayer(20))
			.build();
		
		listView = (ListView) findViewById(android.R.id.list);
		((ListView)listView).setAdapter(new ItemAdapter());
		
	}
	
	@Override
	public void onBackPressed() {
		AnimateFirstDisplayListener.displayedImages.clear();
		super.onBackPressed();
	}
	
	/**
	 * 
	 * @author c_jichen
	 *
	 */
	class ItemAdapter extends BaseAdapter {

		private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
		
		private class ViewHolder{
			public TextView tv;
			public ImageView image;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imageUrls.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = convertView;
			final ViewHolder holder;
			if(convertView == null){
				view = getLayoutInflater().inflate(R.layout.item_list_image,parent,false);
				holder = new ViewHolder();
				holder.tv = (TextView)view.findViewById(R.id.text);
				holder.image = (ImageView)view.findViewById(R.id.image);
				view.setTag(holder);
			}else{
				holder = (ViewHolder)view.getTag();
			}
			
			holder.tv.setText("item "+(position + 1));
			
			/**
			 * 显示图片
			 * para1 url
			 * para2 控件
			 * 设置
			 * 监听器
			 */
			imageLoader.displayImage(imageUrls[position], holder.image, options, animateFirstListener);
			
			return view;
		}
		
	}
	
	/**
	 * 图片加载第一次显示监听器
	 * @author Administrator
	 *
	 */
	private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
		
		static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				// 是否第一次显示
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					// 图片淡入效果
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}
	
}
