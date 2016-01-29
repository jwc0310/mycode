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
	
	//����֪ͨ��Ϣ������
	NotificationManager m_notifyManager;
	Intent m_intent;
	PendingIntent m_pending;
	
	//����Notification����
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
		
		//���֪ͨʱת������
		m_intent = new Intent(Notify.this,Notify2.class);
		//��Ҫ�����õ��֪ͨʱ��ʾ���ݵ���
		m_pending = PendingIntent.getActivity(Notify.this, 0, m_intent, 0);
		//����Notification����
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
			m_notify.setLatestEventInfo(Notify.this, "Button2", "Button2֪ͨ"+String.valueOf(new JNI().nadd(11, 12)), m_pending);
			m_notifyManager.notify(0,m_notify);
			
			break;
		case R.id.button3:
			m_notify.icon = R.drawable.ic_launcher;
			m_notify.tickerText = "Button3֪ͨ������......";
			m_notify.defaults = Notification.DEFAULT_LIGHTS;
			m_notify.setLatestEventInfo(Notify.this, "Button3", "Button3֪ͨ", m_pending);
			m_notifyManager.notify(0,m_notify);
			break;
		case R.id.button4:
			m_notify.icon = R.drawable.ic_dialer_fork_current_call;
			m_notify.tickerText = "Button4֪ͨ������......";
			m_notify.defaults = Notification.DEFAULT_ALL;
			m_notify.setLatestEventInfo(Notify.this, "Button4", "Button4֪ͨ", m_pending);
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
