package com.chuangwai.base.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chuangwai.base.TabBasePager;


/**
 * @author hanrychen
 *智慧服务的页面
 */
public class SmartServicePager extends TabBasePager {

	public SmartServicePager(Context mContext) {
		super(mContext);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initData() {
		System.out.println("智慧服务初始化了");
		tvTitle.setText("生活");
		ibMenu.setVisibility(View.VISIBLE);
		TextView tv = new TextView(mContext);
		tv.setText("智慧服务");
		tv.setTextColor(Color.RED);
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		flContent.addView(tv);
		
	}
}
