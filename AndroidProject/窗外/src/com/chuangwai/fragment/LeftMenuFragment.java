package com.chuangwai.fragment;

import com.chuangwai.base.BaseFragment;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

/**
 * @author hanrychen
 * 左侧菜单界面的fragment
 * */

public class LeftMenuFragment extends BaseFragment {

	@Override
	public View initView(LayoutInflater inflater) {
		TextView tv = new TextView(mActivity);
		tv.setText("左侧菜单");
		tv.setTextSize(20);
		return tv;
	}

}
