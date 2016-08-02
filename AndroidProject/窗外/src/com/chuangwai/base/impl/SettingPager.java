package com.chuangwai.base.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chuangwai.base.TabBasePager;


/**
 * @author hanrychen
 *设置的页面
 */
public class SettingPager extends TabBasePager {

	public SettingPager(Context mContext) {
		super(mContext);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initData() {
		System.out.println("设置初始化了");
		tvTitle.setText("设置");
		ibMenu.setVisibility(View.GONE);
		
		TextView tv = new TextView(mContext);
		tv.setText("设置");
		tv.setTextColor(Color.RED);
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		flContent.addView(tv);
		
	}
}
