package example.andy.com.module_mvp.module;

import android.view.View;

import example.andy.com.module_mvp.bean.UserBean;
import example.andy.com.module_mvp.listener.OnLoginListener;

/**
 * Created by chenjianwei on 16/5/9.
 */
public class UserBizImpl implements UserBiz {

    private OnLoginListener onLoginListener;

    public UserBizImpl(OnLoginListener onLoginListener){
        this.onLoginListener = onLoginListener;
    }

    @Override
    public void login(UserBean login) {
        boolean status = false;
        String username = login.getUsername();
        String password = login.getPassword();

        //数据交互，访问网络接口

        if (username != null && "asdf".equals(username))
            if (password != null && "123".equals(password))
                status = true;

        onLoginListener.loginStatus(status);
    }
}
