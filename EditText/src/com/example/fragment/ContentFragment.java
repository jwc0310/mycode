package com.example.fragment;

import com.example.edittext.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContentFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater infalter, ViewGroup container, Bundle bundle){
		return infalter.inflate(R.layout.contentframent, container, false);
	}
	
}
