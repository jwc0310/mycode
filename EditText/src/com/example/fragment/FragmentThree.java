package com.example.fragment;

import com.example.edittext.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentThree extends Fragment implements OnClickListener {
	private Button mBtn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		View view = inflater.inflate(R.layout.fragment_three, container, false);
		mBtn = (Button)view.findViewById(R.id.fragment_button_three);
		mBtn.setOnClickListener(this);
		return view;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "I am in Fragment three ", Toast.LENGTH_SHORT).show();
	}
}
