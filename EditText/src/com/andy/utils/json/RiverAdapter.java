package com.andy.utils.json;

import java.util.List;

import com.andy.utils.parsexml.River;
import com.example.edittext.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RiverAdapter extends BaseAdapter {

	private Context context;
	private List<River> rivers;
	public RiverAdapter(Context context, List<River> rivers){
		this.context = context;
		this.rivers = rivers;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return rivers.size();
	}

	@Override
	public River getItem(int position) {
		// TODO Auto-generated method stub
		return rivers.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		River r = rivers.get(position);
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(this.context).inflate(R.layout.json_adapter,null);
			holder.name = (TextView)convertView.findViewById(R.id.river_name);
			holder.length = (TextView)convertView.findViewById(R.id.river_length);
			holder.content = (TextView)convertView.findViewById(R.id.river_content);
			holder.url = (TextView)convertView.findViewById(R.id.river_image);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		
		
		return null;
	}
	
	private class ViewHolder{
		TextView name;
		TextView length;
		TextView content;
		TextView url;
	}

}
