package com.andy.opensource.fw.imageloader;

import com.example.edittext.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends Activity {
	
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.menu_imageloader, menu);

		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.item_clear_memory_cache:
			imageLoader.clearMemoryCache();		// 清除内存缓存
			return true;
		case R.id.item_clear_disc_cache:
			imageLoader.clearDiscCache();		// 清除SD卡中的缓存
			return true;
		default:
			return false;
	}
	}
	
}
