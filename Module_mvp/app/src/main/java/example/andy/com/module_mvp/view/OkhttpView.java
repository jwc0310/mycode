package example.andy.com.module_mvp.view;

/**
 * Created by chenjianwei on 16/5/9.
 */
public interface OkhttpView {

    String getUsername();
    String getPassword();

    void clearUsername();
    void clearPassword();

    void showMsg(String msg);
}
