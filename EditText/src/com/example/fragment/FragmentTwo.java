package com.example.fragment;

import com.example.edittext.R;
import com.example.fragment.FragmentOne.FOneBtnClickListener;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTwo extends Fragment implements OnClickListener {
	private Button mBtn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		View view = inflater.inflate(R.layout.fragment_two, container, false);
		mBtn = (Button)view.findViewById(R.id.fragment_button_two);
		mBtn.setOnClickListener(this);
		return view;
	}
	
	private FTwoBtnClickListener fTwoBtnClickListener;
	
	public interface FTwoBtnClickListener{
		void onFTwoBtnClick();
	}
	//设置回调接口
	public void setFTwoBtnClickListener(FTwoBtnClickListener fTwoBtnClickListener){
		this.fTwoBtnClickListener = fTwoBtnClickListener;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(getActivity() instanceof FTwoBtnClickListener){
			((FTwoBtnClickListener)getActivity()).onFTwoBtnClick();
		}
	}
}
