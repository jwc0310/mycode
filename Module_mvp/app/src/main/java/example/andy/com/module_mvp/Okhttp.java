package example.andy.com.module_mvp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import example.andy.com.module_mvp.base.BaseActivity;
import example.andy.com.module_mvp.bean.OtherUserEntity;

/**
 * Created by chenjianwei on 16/5/9.
 */
public class Okhttp extends BaseActivity implements View.OnClickListener{

    private TextView tv;
    private Button get;

    OkHttpClient okHttpClient;

    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg){
            if (msg.what == 0x01){
                ResponseBody rb = (ResponseBody) msg.obj;
                String str = "klsdjflksd";
                tv.setText(str);
            }
        }
    };

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.okhttp);

        tv = (TextView) findViewById(R.id.netwrap);
        get = (Button) findViewById(R.id.netget);

        get.setOnClickListener(this);
        initOkhttp();
    }

    private void initOkhttp(){
        okHttpClient = new OkHttpClient();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        final Request request = new Request.Builder()
//                .url("http://139.196.80.65:56520/user/info/other/milestone?userId=204354&pageInvertedIndex=0&pageSize=30")
                .url("http://139.196.80.65:56520/user/info/other/detail?userId=210888&token=d4f9f6ab2e0f41a1b0e920df78634399")
                .header("User-Agent","Okhttp Headers.java")
                .addHeader("Accept","application/json; q=0.5")
                .addHeader("Accept","application/vnd.github.v3+json")
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e("Andy","Okhttp is failure");
                e.printStackTrace();

            }

            @Override
            public void onResponse(Response response) throws IOException {
                //if (response.isSuccessful())
                    Log.e("Andy","Okhttp is successful");
//                Headers responseHeaders = response.headers();
//                for (int i = 0; i < responseHeaders.size(); i++) {
//                    //System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                    Log.e("Andy",responseHeaders.name(i) + ": " + responseHeaders.value(i));
//
//                }

//                Log.e("Andy","Server: " + response.header("Server"));
//                Log.e("Andy","Date: " + response.header("Date"));
//                Log.e("Andy","Vary: " + response.headers("Vary"));
//
//                Log.e("Andy","\n\n"+response.body().string());

                try{

                    OtherUserEntity fromJson = new Gson().fromJson(response.body().charStream(),OtherUserEntity.class);

                    Log.e("Andy","\n\n"+fromJson.getCode());
                    Log.e("Andy","\n\n"+fromJson.getDesc());
                    Log.e("Andy","\n\n"+fromJson.getData().toString());

                }catch (Exception e){
                    e.printStackTrace();
                }


                Message msg = new Message();
                msg.what = 0x01;
                msg.obj = response.body();

                handler.sendMessage(msg);

            }
        });

    }
}
