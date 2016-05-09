package example.andy.com.module_mvp.presenter;

import example.andy.com.module_mvp.bean.UserBean;
import example.andy.com.module_mvp.listener.OnLoginListener;
import example.andy.com.module_mvp.module.UserBiz;
import example.andy.com.module_mvp.module.UserBizImpl;
import example.andy.com.module_mvp.view.OkhttpView;

/**
 * Created by chenjianwei on 16/5/9.
 */
public class OkhttpPresenterImpl implements OkhttpPresenter , OnLoginListener{

    private UserBiz userBiz;
    private OkhttpView loginView;

    public OkhttpPresenterImpl(OkhttpView loginView){
        this.loginView = loginView;
        userBiz = new UserBizImpl(this);
    }

    @Override
    public void login() {
        UserBean login = new UserBean();
        login.setUsername(loginView.getUsername());
        login.setPassword(loginView.getPassword());

        userBiz.login(login);
    }

    @Override
    public void clear() {
        loginView.clearPassword();
        loginView.clearUsername();
    }

    @Override
    public void start() {

    }

    @Override
    public void loginStatus(boolean status) {
        String msg;
        if (status)
            msg = "login succeed";
        else
            msg = "login failed";
        loginView.showMsg(msg);
    }
}
