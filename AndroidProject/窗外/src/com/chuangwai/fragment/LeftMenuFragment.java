package com.chuangwai.fragment;

import com.chuangwai.base.BaseFragment;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

/**
 * @author hanrychen
 * ���˵������fragment
 * */

public class LeftMenuFragment extends BaseFragment {

	@Override
	public View initView(LayoutInflater inflater) {
		TextView tv = new TextView(mActivity);
		tv.setText("���˵�");
		tv.setTextSize(20);
		return tv;
	}

}
