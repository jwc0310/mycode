package com.example.fragment;

import com.example.edittext.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class TitleFragment extends  Fragment{

	private ImageButton mLeftButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		
		View view = inflater.inflate(R.layout.titlefragment, container,false);
		mLeftButton = (ImageButton)view.findViewById(R.id.id_title_left_btn);
		mLeftButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "I am ImageButton in TitleFragment !", Toast.LENGTH_SHORT).show();
			}
			
		});
		return view;
	}
	
}
