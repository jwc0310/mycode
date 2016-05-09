package example.andy.com.module_mvp.contract;

import example.andy.com.module_mvp.base.BasePresenter;
import example.andy.com.module_mvp.base.BaseView;

/**
 * Created by chenjianwei on 16/5/9.
 */
public interface OkhttpContract {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter{
        void login();
        void clear();
    }

}
