package example.andy.com.module_mvp.bean;

import java.util.UUID;

/**
 * Created by chenjianwei on 16/5/9.
 */
public class TestBean {
    private String id;
    private String content;

    public TestBean(String content) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }
}
