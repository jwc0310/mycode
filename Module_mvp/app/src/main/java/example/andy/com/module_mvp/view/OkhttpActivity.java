package example.andy.com.module_mvp.view;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.andy.com.module_mvp.R;
import example.andy.com.module_mvp.base.BaseActivity;
import example.andy.com.module_mvp.presenter.OkhttpPresenter;
import example.andy.com.module_mvp.presenter.OkhttpPresenterImpl;

/**
 * Created by chenjianwei on 16/5/9.
 */
public class OkhttpActivity extends BaseActivity implements View.OnClickListener,OkhttpView {

    private EditText username,password;
    private Button login,clear;
    private OkhttpPresenter okhttpPresenter;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_okhttp);

        okhttpPresenter = new OkhttpPresenterImpl(this);
        initView();

    }

    private void initView(){
        username = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login_okhttp);
        clear = (Button) findViewById(R.id.clear_okhttp);

        login.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.login_okhttp){
            Log.e("Andy","login");
            okhttpPresenter.login();
        }else if(id == R.id.clear_okhttp){
            Log.e("Andy","clear");

            okhttpPresenter.clear();
        }
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void clearUsername() {
        username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
