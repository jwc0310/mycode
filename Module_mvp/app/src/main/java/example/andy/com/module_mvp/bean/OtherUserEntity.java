package example.andy.com.module_mvp.bean;

import example.andy.com.module_mvp.base.BaseEntity;

/**
 * Created by chenjianwei on 16/5/10.
 */
public class OtherUserEntity extends BaseEntity {

    private OtherUserData data;


    public OtherUserData getData() {
        return data;
    }

    public void setData(OtherUserData data) {
        this.data = data;
    }
}
