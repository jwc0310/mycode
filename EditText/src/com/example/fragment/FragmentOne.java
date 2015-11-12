package com.example.fragment;

import com.example.edittext.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentOne extends Fragment implements OnClickListener {
	private static final String TAG = "FragmentOne";
	
	private Button mBtn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		Log.i(TAG, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_one, container, false);
		mBtn = (Button)view.findViewById(R.id.fragment_button_one);
		mBtn.setOnClickListener(this);
		return view;
	}
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		Log.i(TAG, "onCreate");
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onDestroyView(){
		super.onDestroyView();
		Log.i(TAG, "onDestroyView");
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
		inflater.inflate(R.menu.menu, menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.action_settings:
			Toast.makeText(getActivity(), "FragmentMenuItem1-settings", Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
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
