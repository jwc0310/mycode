package example.andy.com.module_mvp.view;

import android.os.Bundle;

import example.andy.com.module_mvp.R;
import example.andy.com.module_mvp.base.BaseActivity;

/**
 * Created by chenjianwei on 16/5/9.
 */
public class OkhttpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);
    }
}
