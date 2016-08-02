package com.chuangwai.base.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chuangwai.base.TabBasePager;


/**
 * @author hanrychen
 *��ҳ��ҳ��
 */
public class HomePager extends TabBasePager {

	public HomePager(Context mContext) {
		super(mContext);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initData() {
		System.out.println("��ҳ��ʼ����");
		tvTitle.setText("�ǻ�У԰");
		ibMenu.setVisibility(View.GONE);
		
		TextView tv = new TextView(mContext);
		tv.setText("��ҳ");
		tv.setTextColor(Color.RED);
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		flContent.addView(tv);
		
	}
}
