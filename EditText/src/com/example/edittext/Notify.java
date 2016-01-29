package com.example.edittext;

import com.andy.jni.JNI;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Notify extends Activity implements OnClickListener {

	private Button m_b1,m_b2,m_b3,m_b4,back;
	
	//声明通知消息管理器
	NotificationManager m_notifyManager;
	Intent m_intent;
	PendingIntent m_pending;
	
	//声明Notification对象
	Notification m_notify;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notify01);
		
		m_notifyManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
		m_b1 = (Button)findViewById(R.id.button1);
		m_b2 = (Button)findViewById(R.id.button2);
		m_b3 = (Button)findViewById(R.id.button3);
		m_b4 = (Button)findViewById(R.id.button4);
		back = (Button)findViewById(R.id.button5);
		
		m_b1.setOnClickListener(this);
		m_b2.setOnClickListener(this);
		m_b3.setOnClickListener(this);
		m_b4.setOnClickListener(this);
		back.setOnClickListener(this);
		
		//点击通知时转移内容
		m_intent = new Intent(Notify.this,Notify2.class);
		//主要是设置点击通知时显示内容的类
		m_pending = PendingIntent.getActivity(Notify.this, 0, m_intent, 0);
		//构造Notification对象
		m_notify = new Notification();
		
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button1:
			m_notify.icon = R.drawable.ic_vm_sound_off_dk;
			m_notify.tickerText = new JNI().stringFromJNI();
			m_notify.defaults = Notification.DEFAULT_SOUND;
			m_notify.setLatestEventInfo(Notify.this, "Button1", new JNI().stringFromJNI(), m_pending);
			m_notifyManager.notify(0,m_notify);
			
			break;
		case R.id.button2:
			m_notify.icon = R.drawable.ic_vm_sound_on_dk;
			m_notify.tickerText =String.valueOf(new JNI().nadd(11, 12));
			m_notify.defaults = Notification.DEFAULT_VIBRATE;
			m_notify.setLatestEventInfo(Notify.this, "Button2", "Button2通知"+String.valueOf(new JNI().nadd(11, 12)), m_pending);
			m_notifyManager.notify(0,m_notify);
			
			break;
		case R.id.button3:
			m_notify.icon = R.drawable.ic_launcher;
			m_notify.tickerText = "Button3通知的内容......";
			m_notify.defaults = Notification.DEFAULT_LIGHTS;
			m_notify.setLatestEventInfo(Notify.this, "Button3", "Button3通知", m_pending);
			m_notifyManager.notify(0,m_notify);
			break;
		case R.id.button4:
			m_notify.icon = R.drawable.ic_dialer_fork_current_call;
			m_notify.tickerText = "Button4通知的内容......";
			m_notify.defaults = Notification.DEFAULT_ALL;
			m_notify.setLatestEventInfo(Notify.this, "Button4", "Button4通知", m_pending);
			m_notifyManager.notify(0,m_notify);
			break;
		case R.id.button5:
			Intent backMain = new Intent(Notify.this,MainActivity.class);
			startActivity(backMain);
			Notify.this.finish();
			break;
		}
	}
	
}
