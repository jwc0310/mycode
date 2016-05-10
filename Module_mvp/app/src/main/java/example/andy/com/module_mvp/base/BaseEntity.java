package example.andy.com.module_mvp.base;

import java.io.Serializable;

/**
 * Created by chenjianwei on 16/5/10.
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
