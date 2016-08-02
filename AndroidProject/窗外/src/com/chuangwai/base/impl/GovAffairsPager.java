package com.chuangwai.base.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chuangwai.base.TabBasePager;


/**
 * @author hanrychen
 *�����ҳ��
 */
public class GovAffairsPager extends TabBasePager {

	public GovAffairsPager(Context mContext) {
		super(mContext);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initData() {
		System.out.println("�����ʼ����");
		tvTitle.setText("�˿ڹ���");
		ibMenu.setVisibility(View.VISIBLE);
		
		TextView tv = new TextView(mContext);
		tv.setText("����");
		tv.setTextColor(Color.RED);
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		flContent.addView(tv);
		
	}
}
