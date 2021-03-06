package com.example.fragment;

import com.example.edittext.R;
import com.example.fragment.FragmentOne.FOneBtnClickListener;
import com.example.fragment.FragmentTwo.FTwoBtnClickListener;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

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
        
        //解决旋转是Fragment多次创建问题
        if(savedInstanceState == null){
        	 FragmentManager fm = getFragmentManager();
             FragmentTransaction ft = fm.beginTransaction();
             ft.add(R.id.id_manager_content, new FragmentOne(), "ONE");
             ft.commit();
        }
       
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		//getMenuInflater().inflate(R.menu.menu, menu);
		return true;
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
    public boolean onOptionsItemSelected(MenuItem item)  
    {  
        switch (item.getItemId())  
        {  
        case R.id.action_settings:  
            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();  
            return true;  
        default:  
            //如果希望Fragment自己处理MenuItem点击事件，一定不要忘了调用super.xxx  
            return super.onOptionsItemSelected(item);  
        }  
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
