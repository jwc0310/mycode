package com.example.edittext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter1 extends BaseAdapter
{
	// ����Context
	private Context		mContext;
	// ������������ ��ͼƬԴ
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

	// ��ȡͼƬ�ĸ���
	public int getCount()
	{
		return mImageIds.length;
	}

	// ��ȡͼƬ�ڿ��е�λ��
	public Object getItem(int position)
	{
		return position;
	}


	// ��ȡͼƬID
	public long getItemId(int position)
	{
		return position;
	}


	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView imageView;
		if (convertView == null)
		{
			// ��ImageView������Դ
			imageView = new ImageView(mContext);
			// ���ò��� ͼƬ120��120��ʾ
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			// ������ʾ��������
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

