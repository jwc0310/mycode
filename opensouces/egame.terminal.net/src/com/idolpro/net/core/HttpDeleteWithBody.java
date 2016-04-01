/*
 * FileName:	HttpDeleteWithBody.java
 * Copyright:	炫彩互动网络科技有限公司
 * Author: 		yaoyuan
 * Description:	<文件描述>
 * History:		2015年10月9日 1.00 初始版本
 */
package com.idolpro.net.core;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/**
 * <功能简述> <Br>
 * <功能详细描述> <Br>
 * 
 * @author  yaoyuan
 */
class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public String getMethod() {
        return METHOD_NAME;
    }

    public HttpDeleteWithBody(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    public HttpDeleteWithBody(final URI uri) {
        super();
        setURI(uri);
    }

    public HttpDeleteWithBody() {
        super();
    }
}
