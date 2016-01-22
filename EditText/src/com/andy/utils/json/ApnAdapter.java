package com.andy.utils.json;

import java.util.List;

import com.andy.utils.LG;
import com.andy.utils.parsexml.Apn;
import com.example.edittext.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ApnAdapter extends BaseAdapter {

	private List<Apn> apn;
	private Context context;
	
	public ApnAdapter(Context context,List<Apn> apn){
		this.apn = apn;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		LG.i(getClass(), Integer.toString(apn.size()));
		return apn.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		LG.i(getClass(), apn.get(position).toString());
		return apn.get(position);
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
		Apn a = apn.get(position);
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(this.context).inflate(R.layout.apn_list, null);
			holder.tv = (TextView)convertView.findViewById(R.id.apn);
			convertView.setTag(holder);
			
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		LG.i(getClass(), a.toString());
		holder.tv.setText(a.toString());
		
		return convertView;
	}
	
	private class ViewHolder{
		TextView tv;
	}

}
