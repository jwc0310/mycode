package com.example.edittext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ListViewWithAnimation extends Activity implements View.OnClickListener {
	
	private ListView mListView;
	private Button mButton;
	private List<Integer> mList = new ArrayList<Integer>();
	private int item = 0;

	MyAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_with);
		initView();
		initData();
		adapter = new MyAdapter(this);
		mListView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		
	}
	
	private void initView(){
		mListView = (ListView)findViewById(R.id.listwithAnimation);
		mButton = (Button)findViewById(R.id.buttonwihtAnimation);
		mButton.setOnClickListener(this);
	}
	private void initData(){
		mList.add(item);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if(id == R.id.buttonwihtAnimation){
			item++;
			mList.add(item);
			adapter.notifyDataSetChanged();
			
		}
	}
	
	private class MyAdapter extends BaseAdapter {
		
		LayoutInflater inflater;
		Context mContext;
		Animation mAnimation;
		public MyAdapter(Context context){
			mContext = context;
			inflater = LayoutInflater.from(mContext);
			mAnimation = AnimationUtils.loadAnimation(mContext, R.anim.listview_anim);
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			if(convertView == null){
				convertView = inflater.inflate(R.layout.listview_item, null);
				holder = new ViewHolder();
				holder.tv1 = (TextView)convertView.findViewById(R.id.textView_1);
				holder.tv2 = (TextView)convertView.findViewById(R.id.textView_2);
				Log.i("Andy", "new one");
				convertView.startAnimation(mAnimation);
				convertView.setTag(holder);
			}else{
				Log.i("Andy", "old one");
				holder = (ViewHolder)convertView.getTag();
			}
			
			holder.tv1.setText("Test case ：");
			holder.tv2.setText(" "+mList.get(position)+" ");
			
			return convertView;
		}
		
	}
	private class ViewHolder{
		TextView tv1,tv2;
		public ViewHolder(){
			
		}
	}
	
}
