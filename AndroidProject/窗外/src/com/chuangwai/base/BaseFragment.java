package com.chuangwai.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author hanrychen
 * 所有fragment的基类
 * */
public abstract class BaseFragment extends Fragment {
	
	public Activity mActivity;  //把fragment绑定到哪个Activity,上下文对象就是那个Activity

	//创建一个fragment 绑定到activity时  要获取到activity的上下文
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mActivity = getActivity();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = initView(inflater);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
	}
	
	/**
	 *如果子类需要初始化自己的数据，把此方法给覆盖 
	 */
	public void initData() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 子类必须实现此方法，返回一个View对象，作为当前Fragment的布局来展示。
	 */
	//用所有继承该基类的类都重写这个方法，所以用抽象类
	public abstract View initView(LayoutInflater inflater);
}
