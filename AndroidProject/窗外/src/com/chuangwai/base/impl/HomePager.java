package com.chuangwai.base.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chuangwai.base.TabBasePager;


/**
 * @author hanrychen
 *首页的页面
 */
public class HomePager extends TabBasePager {

	public HomePager(Context mContext) {
		super(mContext);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initData() {
		System.out.println("首页初始化了");
		tvTitle.setText("智慧校园");
		ibMenu.setVisibility(View.GONE);
		
		TextView tv = new TextView(mContext);
		tv.setText("首页");
		tv.setTextColor(Color.RED);
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		flContent.addView(tv);
		
	}
}
