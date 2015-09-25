package com.example.edittext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{

	private Context mContext;
	private Integer[] mImageIds = {
			R.drawable.ic,
			R.drawable.ic_cancel_holo_light,
			R.drawable.ic_dialer_fork_current_call,
			R.drawable.ic_launcher,
			R.drawable.ic_menu_all_contacts_dk,
			R.drawable.ic_vm_sound_off_dk,
			R.drawable.ic_vm_sound_on_dk,
	};
	
	
	public ImageAdapter(Context c){
		mContext = c;
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mImageIds.length;
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
		ImageView imageview = new ImageView(mContext);
		imageview.setImageResource(mImageIds[position]);
		imageview.setLayoutParams(new Gallery.LayoutParams(120,120));
		imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
		return imageview;
	}

	
}
