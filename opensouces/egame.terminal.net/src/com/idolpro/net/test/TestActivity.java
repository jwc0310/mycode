///*
// * FileName:	TestActivity.java
// * Copyright:	炫彩互动网络科技有限公司
// * Author: 		Hein
// * Description:	<文件描述>
// * History:		2013-10-16 1.00 初始版本
// */
//package com.idolpro.net.test;
//
//import java.io.InputStream;
//import java.util.LinkedList;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import com.idolpro.net.FastTube;
//import com.idolpro.net.core.TubeConfig;
//import com.idolpro.net.core.TubeOptions;
//import com.idolpro.net.exception.TubeException;
//import com.idolpro.net.listener.JSONTubeListener;
//import com.idolpro.net.listener.StreamTubeListener;
//import com.idolpro.net.listener.StringTubeListener;
//import com.idolpro.net.utils.Logger;
//
//import android.app.Activity;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.ScrollView;
//import android.widget.TextView;
//import cn.egame.terminal.net.R;
//
///**
// * </Br> <功能详细描述> </Br>
// * 
// * @author Hein
// * @hide
// */
//public class TestActivity extends Activity {
//
//    public static final int LOGGER = 0;
//
//    private final String testUrl1 = "http://open.play.cn/api/v2/mobile/channel/content.json?channel_id=701&terminal_id=245&current_page=0&rows_of_page=20&order_id=0";
//
////    private final String fetchHostsUrl = "http://open.play.cn:80/api/v2/egame/host.json";
//    private final String fetchHostsUrl = "http://139.196.1.25:8088/common/like/del";
//
//    private FastTube mFastTube = null;
//
//    private static final TubeOptions NORMAL_OPTIONS = new TubeOptions.Builder().setHttpMethod(TubeOptions.HTTP_METHOD_DELETE)
//            .setHostKey("TEST").setReconnectionTimes(10).create();
//
//    private TextView mLoggerView = null;
//    private ScrollView mScrollView = null;
//
//    private Handler mHandler = new Handler() {
//
//        @Override
//        public void handleMessage(Message msg) {
//
//            switch (msg.what) {
//            case LOGGER:
//                if (mLoggerView == null) {
//                    return;
//                }
//
//                mLoggerView.append((CharSequence) msg.obj);
//
//                mScrollView.post(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
//                    }
//                });
//                break;
//            default:
//                break;
//            }
//        }
//
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        // TODO Auto-generated method stub
//        Logger.register(mHandler, LOGGER);
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        mFastTube = FastTube.getInstance();
//        mFastTube.init(new TubeConfig.Builder().setThreadCount(10).create());
//
//        mLoggerView = (TextView) findViewById(R.id.logout);
//        mScrollView = (ScrollView) findViewById(R.id.scrollView);
//
//        findViewById(R.id.start).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                doTask(true);
//            }
//        });
//
//        findViewById(R.id.step1).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                doTask(false);
//            }
//        });
//
//        findViewById(R.id.step2).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                testFetchData();
//            }
//        });
//
//        Logger.v("LOGGER", "Ready!");
//        Logger.d("LOGGER", "Ready!");
//        Logger.i("LOGGER", "Ready!");
//        Logger.w("LOGGER", "Ready!");
//        Logger.e("LOGGER", "Ready!");
//
//        String url = "http://a.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f96737fc6e272dd42a2834a491.jpg";
//        FastTube.getInstance().getStream(url, new StreamTubeListener<Bitmap>() {
//
//            @Override
//            public Bitmap doInBackground(InputStream water) throws Exception {
//                // TODO Auto-generated method stub
//                return BitmapFactory.decodeStream(water);
//            }
//
//            @Override
//            public void onSuccess(Bitmap result) {
//                // TODO Auto-generated method stub
//                findViewById(R.id.root_view).setBackgroundDrawable(
//                        new BitmapDrawable(result));
//                // ViewGroup view = (ViewGroup) getWindow().getDecorView();
//                //
//                // ImageView iv = new ImageView(TestActivity.this);
//                // iv.setImageBitmap(result);
//                // ((ViewGroup) view.getChildAt(0)).addView(iv);
//                //
//                // Logger.d("wei.han",
//                // view.getClass().getSuperclass().getCanonicalName());
//
//                // ((ViewGroup) view.getChildAt(0)).getChildAt(1)
//                // .setBackgroundDrawable(new BitmapDrawable(result));
//            }
//
//            @Override
//            public void onFailed(TubeException e) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//    }
//
//    private void doTask(final boolean isAutoFecthData) {
//        mFastTube.getJSON(fetchHostsUrl,
//                new JSONTubeListener<LinkedList<String>>() {
//
//                    @Override
//                    public LinkedList<String> doInBackground(JSONObject water) {
//                        // TODO Auto-generated method stub
//                        return processData(water);
//                    }
//
//                    @Override
//                    public void onSuccess(LinkedList<String> result) {
//                        // TODO Auto-generated method stub
//                        if (result != null) {
//
//                            mFastTube.addHosts("TEST", result);
//
//                            if (isAutoFecthData) {
//                                testFetchData();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailed(TubeException e) {
//                        // TODO Auto-generated method stub
//                        Logger.e("wei.han", e.getLocalizedMessage());
//                    }
//                });
//    }
//
//    private LinkedList<String> processData(JSONObject water) {
//        LinkedList<String> hosts = new LinkedList<String>();
//        try {
//            JSONArray array = water.getJSONObject("ext").getJSONArray(
//                    "host_url");
//            for (int i = 0; i < array.length(); i++) {
//                hosts.add(array.getString(i));
//                Logger.d("wei.han", "Host" + i + ": " + array.getString(i));
//            }
//            return hosts;
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            return null;
//        }
//    }
//
//    private void testFetchData() {
//
//        // ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
//        // pairs.add(new BasicNameValuePair("is", "me"));
//        // TubeOptions opt = new
//        // TubeOptions.Builder().setPostEntity(pairs).create();
//        // mFastTube.post(testUrl1, opt, null);
//
//        mFastTube.getString(testUrl1, NORMAL_OPTIONS,
//                new StringTubeListener<JSONObject>() {
//
//                    @Override
//                    public JSONObject doInBackground(String water) {
//                        // TODO Auto-generated method stub
//                        try {
//                            return new JSONObject(water);
//                        } catch (Exception e) {
//                            // TODO: handle exception
//                            return null;
//                        }
//                    }
//
//                    @Override
//                    public void onSuccess(JSONObject result) {
//                        // TODO Auto-generated method stub
//                        if (result != null) {
//                            Logger.d("wei.han", result.toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFailed(TubeException e) {
//                        // TODO Auto-generated method stub
//                        Logger.e("wei.han", e.getLocalizedMessage());
//                    }
//                });
//    }
//
//    @Override
//    protected void onDestroy() {
//        // TODO Auto-generated method stub
//        super.onDestroy();
//        Logger.unRegister(mHandler);
//        if (mFastTube != null) {
//            mFastTube.release();
//        }
//    }
//
//}
