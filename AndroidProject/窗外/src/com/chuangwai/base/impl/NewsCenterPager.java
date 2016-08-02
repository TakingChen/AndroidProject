package com.chuangwai.base.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chuangwai.base.TabBasePager;


/**
 * @author hanrychen
 *新闻中心的页面
 */
public class NewsCenterPager extends TabBasePager {

	public NewsCenterPager(Context mContext) {
		super(mContext);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initData() {
		System.out.println("新闻中心初始化了");
		tvTitle.setText("新闻");
		ibMenu.setVisibility(View.VISIBLE);
		
		TextView tv = new TextView(mContext);
		tv.setText("新闻中心");
		tv.setTextColor(Color.RED);
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		flContent.addView(tv);
		
	}
}
