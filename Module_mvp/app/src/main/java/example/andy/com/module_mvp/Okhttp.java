package example.andy.com.module_mvp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import example.andy.com.module_mvp.base.BaseActivity;

/**
 * Created by chenjianwei on 16/5/9.
 */
public class Okhttp extends BaseActivity implements View.OnClickListener{

    private TextView tv;
    private Button get;

    OkHttpClient okHttpClient;

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
        Request request = new Request.Builder()
                .url("http://139.196.80.65:56520/user/info/other/milestone?userId=204354&pageInvertedIndex=0&pageSize=30")
//                .url("http://www.baidu.com")
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
                if (response.isSuccessful())
                    Log.e("Andy","Okhttp is successful");
                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    Log.e("Andy",responseHeaders.name(i) + ": " + responseHeaders.value(i));

                }
                Log.e("Andy","\n\n"+response.body().string());

            }
        });



    }
}
