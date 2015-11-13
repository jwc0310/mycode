package com.example.fragment;

import com.example.edittext.R;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class EditNameDialogFragment extends DialogFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		View view = inflater.inflate(R.layout.fragment_edit_name, container);
		return view;
	}
}
