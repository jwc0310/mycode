package com.example.fragment;

import com.example.edittext.R;
import com.example.fragment.LoginDialogFragment.LoginInputListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MyDialogFragment extends Activity implements View.OnClickListener, LoginInputListener {
	private Button confirm,edit,login,diff;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_fragment);
		
		confirm = (Button)findViewById(R.id.dialog_fragment_1);
		edit = (Button)findViewById(R.id.dialog_fragment_2);
		login = (Button)findViewById(R.id.dialog_fragment_3);
		diff = (Button)findViewById(R.id.dialog_fragment_4);
		
		edit.setOnClickListener(this);
		login.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.dialog_fragment_1:
			
			break;
		case R.id.dialog_fragment_2:
			showEditDialog(v);
			break;
		case R.id.dialog_fragment_3:
			showLoginDialog(v);
			break;
		case R.id.dialog_fragment_4:
			break;
		}
	}
	
	private void showEditDialog(View view){
		EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
		editNameDialog.show(getFragmentManager(), "EditNameDialog");
	}
	private void showLoginDialog(View view){
		LoginDialogFragment loginDialog = new LoginDialogFragment();
		loginDialog.show(getFragmentManager(), "LoginDialog");
	}

	@Override
	public void onLoginInputComplete(String username, String password) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "’À∫≈£∫"+username+", √‹¬Î£∫"+password, Toast.LENGTH_SHORT).show();
	}
	
	
}
