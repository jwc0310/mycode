package com.example.chatsimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private final String TAG = this.getClass().getName();
	
	//Server ip/port
	private static final String SERVERIP = "10.253.164.49";
	private static final int SERVERPORT =54321;
	
	private Thread mThread=null;
	private Socket mSocket = null;
	private Button mButton_In = null;
	private Button mButton_Send = null;
	private EditText mET1 = null;
	private EditText mET2 = null;
	
	private BufferedReader mBufferedReader = null;
	private PrintWriter mPrintWriter = null;
	private String mStrMSG = "welcome:";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()  
            .detectDiskReads().detectDiskWrites().detectNetwork()  
            .penaltyLog().build());  
  
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()  
            .detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()  
            .build());
		}
        
        mButton_In = (Button)findViewById(R.id.button1);
        mButton_Send = (Button)findViewById(R.id.button2);
        mET1 = (EditText)findViewById(R.id.editText1);
        mET2 = (EditText)findViewById(R.id.editText2);
        
        mButton_In.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					mSocket = new Socket(SERVERIP,SERVERPORT);
					Log.i(TAG, "Connect0");
					//get input/output stream
					mBufferedReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
					mPrintWriter = new PrintWriter(mSocket.getOutputStream(),true);
					Log.i(TAG, "Connect1");
					
					mThread = new Thread(mRunnable);
					mThread.start();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Log.i(TAG, "mButton_In.setOnClickListener IOException");
					e.printStackTrace();
				}
			}
        	
        });
        mButton_Send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					String str=mET2.getText().toString() + "\n";
					mPrintWriter.print(str);
					mPrintWriter.flush();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Log.i(TAG, "mButton_Send.setOnClickListener IOException");
					e.printStackTrace();
					
				}
			}
        	
        });
        
        
    }
    
    private Runnable mRunnable = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try{
					 if(mBufferedReader == null)
					 {
						 Log.i(TAG, "Runnable()2");
						 Thread.yield();
					 }
					if((mStrMSG = mBufferedReader.readLine()) != null){
						Log.i(TAG, "Runnable()1");
						mStrMSG+="\n";
						mHandler.sendMessage(mHandler.obtainMessage());
					}
				}catch(Exception e){
					Log.i(TAG, "Runnable()");
					e.printStackTrace();
				}
			}
			
		}
    	
    };
    
    Handler mHandler = new Handler(){
    	public void handleMessage(Message msg){
    		super.handleMessage(msg);
    		//Ë¢ÐÂ
    		try{
    			mET2.append(mStrMSG);
    		}catch(Exception e){
    			Log.i(TAG, "Handler()");
    			e.printStackTrace();
    		}
    	}
    };
    
    
}
