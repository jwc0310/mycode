package com.example.fragment;

import com.example.edittext.R;
import com.example.fragment.FragmentOne.FOneBtnClickListener;
import com.example.fragment.FragmentTwo.FTwoBtnClickListener;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;

public class ManagerFragment extends Activity implements FOneBtnClickListener,FTwoBtnClickListener {
	private FragmentOne mFOne;
	private FragmentTwo mFTwo;
	private FragmentThree mFThree;
	
	@Override  
    protected void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.fragment_manager); 
        
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.id_manager_content, new FragmentOne(), "ONE");
        ft.commit();
        
    }

	@Override
	public void onFTwoBtnClick() {
		// TODO Auto-generated method stub
		 if (mFThree == null)  
	        {  
	            mFThree = new FragmentThree();  
	  
	        }  
	        FragmentManager fm = getFragmentManager();  
	        FragmentTransaction tx = fm.beginTransaction();  
	        tx.hide(mFTwo);  
	        tx.add(R.id.id_manager_content, mFThree, "THREE");  
	        // tx.replace(R.id.id_content, fThree, "THREE");  
	        tx.addToBackStack(null);  
	        tx.commit();  
	}

	@Override
	public void onFOneBtnClick() {
		// TODO Auto-generated method stub
		if(mFTwo == null){
			mFTwo = new FragmentTwo();
			mFTwo.setFTwoBtnClickListener(this);
		}
		FragmentManager fm = getFragmentManager();  
        FragmentTransaction tx = fm.beginTransaction();  
        tx.replace(R.id.id_manager_content, mFTwo, "TWO");
        tx.addToBackStack(null);  
        tx.commit();  
	}
}
