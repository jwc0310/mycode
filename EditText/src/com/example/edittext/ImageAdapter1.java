package com.example.edittext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter1 extends BaseAdapter
{
	// 定义Context
	private Context		mContext;
	// 定义整型数组 即图片源
	private Integer[]	mImageIds	= 
	{ 
			R.drawable.ic,
			R.drawable.ic_cancel_holo_light,
			R.drawable.ic_dialer_fork_current_call,
			R.drawable.ic_launcher,
			R.drawable.ic_menu_all_contacts_dk,
			R.drawable.ic_vm_sound_off_dk,
			R.drawable.ic_vm_sound_on_dk,
			R.drawable.ic_vm_sound_on_dk,
			R.drawable.ic_vm_sound_on_dk,
	};

	public ImageAdapter1(Context c)
	{
		mContext = c;
	}

	// 获取图片的个数
	public int getCount()
	{
		return mImageIds.length;
	}

	// 获取图片在库中的位置
	public Object getItem(int position)
	{
		return position;
	}


	// 获取图片ID
	public long getItemId(int position)
	{
		return position;
	}


	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView imageView;
		if (convertView == null)
		{
			// 给ImageView设置资源
			imageView = new ImageView(mContext);
			// 设置布局 图片120×120显示
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			// 设置显示比例类型
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		}
		else
		{
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mImageIds[position]);
		return imageView;
	}

}

