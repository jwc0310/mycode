package com.example.fragment;

import com.example.edittext.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOne extends Fragment implements OnClickListener {
	private Button mBtn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		View view = inflater.inflate(R.layout.fragment_one, container, false);
		mBtn = (Button)view.findViewById(R.id.fragment_button_one);
		mBtn.setOnClickListener(this);
		return view;
	}
	
	public interface FOneBtnClickListener{
		void onFOneBtnClick();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(getActivity() instanceof FOneBtnClickListener){
			((FOneBtnClickListener)getActivity()).onFOneBtnClick();
		}
	}
	
}
