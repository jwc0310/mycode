package com.andy.dialog;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GiftDialog extends Dialog {

	private static final String tag = "GiftDialog";
	private Context mContext;
	
	private Button gift_cancel_b,gift_send_b;
	private TextView giftDesc,giftPrice;
	private TextView my_dou_show;
	
	private List<GiftData> giftList = new ArrayList<GiftData>();
	private int count = 0; //纪录选中礼物豆数
	private int myCount = 100; //我的拥有的豆数
	private boolean isRecharge = false; //是否需要充值，默认不需要 fasle，
	public GiftDialog(Context context) {
		//super(context);
		super(context,R.style.giftDialog);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}
	
	public GiftDialog(Context context, int theme){
		super(context,theme);
		this.mContext = context;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_select_gift);
		initGiftData();
		initView();
	}
	
	private void initView(){
		gift_cancel_b = (Button)findViewById(R.id.gift_cancel_b);
		gift_send_b = (Button)findViewById(R.id.gift_send_b);
		giftDesc = (TextView)findViewById(R.id.giftDesc);
		giftPrice = (TextView)findViewById(R.id.giftPrice);
		my_dou_show = (TextView)findViewById(R.id.my_dou_count);
		
		//礼物添加
		LinearLayout rootView = (LinearLayout)findViewById(R.id.idolpro_diag_gift_ll);
		rootView.removeAllViews();
		for(int i = rootView.getChildCount();i<giftList.size();i++){
			View item = getLayoutInflater().inflate(R.layout.activity_gift_list,null);
			ImageView imageView = (ImageView) item
					.findViewById(R.id.activity_gift_img);
			TextView tv = (TextView)item.findViewById(R.id.giftname);
			
			final GiftData tmp = giftList.get(i);
			
			//imageView.setId(i);
			
			imageView.setImageResource(giftList.get(i).getId());
			tv.setText(giftList.get(i).getName());
			
			imageView.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View v) {
					LogUtil.e(tag, Integer.toString(v.getId()));
					clearSelectedMark();
					((ImageView)v).setImageResource(R.drawable.gift_m_sele);
					giftDesc.setText(tmp.getDesc());
					giftPrice.setText(tmp.getPrice()+"豆");
					count = tmp.getPrice();
					
					//重新选择礼物时，重置send按钮，及其复位判断充值标记位isRecharge
					gift_send_b.setText("送!");
					isRecharge = false;
					my_dou_show.setText("我的余额:  "+myCount+"豆");
				}
			});
			
			LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT);
			if (i == 0)
				lp1.setMargins(20, 0, 0, 0);

			rootView.addView(item, lp1);
		}
		View item1 = getLayoutInflater().inflate(R.layout.activity_gift_list, null);
		LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		ImageView imageView = (ImageView) item1
				.findViewById(R.id.activity_gift_img);
		TextView tv = (TextView)item1.findViewById(R.id.giftname);
		imageView.setBackgroundResource(R.drawable.gift_qidai);
		tv.setText("");
		lp2.setMargins(0, 0, 20, 0);
		rootView.addView(item1,lp2);
		
		gift_cancel_b.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LogUtil.e(tag, "cancel button clicked");
				dismiss();
				//clearSelectedMark();
			}
		});
		
		gift_send_b.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LogUtil.e(tag, "send button clicked");
				if(!isRecharge){		//
					if(count != 0){
						LogUtil.e(tag, "gift's price is : "+count);
						if(myCount < count){
							LogUtil.e(tag, "余额不足，请充值！");
							my_dou_show.setText(Html.fromHtml("我的余额:  "+myCount+"豆"+"   "+"<font color=\"#ffd600\">爱豆不足!</font>"));
							
							//修改send 按钮显示内容，并设置判断设否需要充值isRecharge
							gift_send_b.setText("去充值!");
							isRecharge = true;
							
						}else{
							myCount = myCount - count;
							my_dou_show.setText("我的余额:  "+myCount+"豆");
							
						}
					}else{
						LogUtil.e(tag, "pls select one gift");
						
					}
				}else{
					//复位按钮和标记 及其它一些信息
					gift_send_b.setText("送!");
					isRecharge = false;
					my_dou_show.setText("我的余额:  "+myCount+"豆");
					
					LogUtil.e(tag, "进入爱豆充值页面，后续补充");
					//tiaozhuan......
				}
				
					
			}
		});
		
		gift_cancel_b.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_UP){
					LogUtil.e(tag, "cancel button ---> up");
					gift_cancel_b.setBackgroundResource(R.drawable.btn_cancel);
				}
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					LogUtil.e(tag, "cancel button ---> down");
					gift_cancel_b.setBackgroundResource(R.drawable.btn_cancel_pressed);
				}
				return false;
			}
		});
		gift_send_b.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_UP){
					LogUtil.e(tag, "send button ---> up");
					gift_send_b.setBackgroundResource(R.drawable.btn_done_red);
				}
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					LogUtil.e(tag, "send button ---> down");
					gift_send_b.setBackgroundResource(R.drawable.btn_done_red_pressed);
				}
				return false;
			}
		});
		
	}
	//实现单选功能
	private void clearSelectedMark(){
		LinearLayout rootView = (LinearLayout)findViewById(R.id.idolpro_diag_gift_ll);
		for(int i=0;i<rootView.getChildCount()-1;i++)
			((ImageView)rootView.getChildAt(i).findViewById(R.id.activity_gift_img)).setImageResource(R.drawable.gift_m);
	}
	
	private void initGiftData(){
		GiftData bang = new GiftData();
		bang.setName("应援棒");
		bang.setId(R.drawable.gift_m);
		bang.setPrice(100);
		bang.setDesc("传说中的偶像用过的应援棒，据说拥有它的idol能唱出美丽的歌曲");
		
		GiftData mic = new GiftData();
		mic.setName("神奇话筒");
		mic.setId(R.drawable.gift_m);
		mic.setPrice(2000);
		mic.setDesc("传说中的偶像用过的神奇话筒，据说拥有它的idol能唱出美丽的歌曲");
		
		GiftData fudai = new GiftData();
		fudai.setName("人品福袋");
		fudai.setId(R.drawable.gift_m);
		fudai.setPrice(1000);
		fudai.setDesc("传说中的偶像用过的福袋，据说拥有它的idol能唱出美丽的歌曲");
		
		giftList.add(bang);
		giftList.add(mic);
		giftList.add(fudai);
	}

}
