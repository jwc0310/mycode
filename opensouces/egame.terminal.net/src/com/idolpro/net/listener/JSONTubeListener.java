/*
 * FileName:	JSONTubeListener.java
 * Copyright:	炫彩互动网络科技有限公司
 * Author: 		Hein
 * Description:	<文件描述>
 * History:		2013-10-16 1.00 初始版本
 */
package com.idolpro.net.listener;

import org.json.JSONObject;

/**
 * 
 * Http请求返回类型是JSONObject的接口
 * 
 * @author Hein
 */
public interface JSONTubeListener<Result> extends TubeListener<JSONObject, Result> {

}
