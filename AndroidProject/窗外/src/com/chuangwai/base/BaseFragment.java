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
 * ����fragment�Ļ���
 * */
public abstract class BaseFragment extends Fragment {
	
	public Activity mActivity;  //��fragment�󶨵��ĸ�Activity,�����Ķ�������Ǹ�Activity

	//����һ��fragment �󶨵�activityʱ  Ҫ��ȡ��activity��������
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
	 *���������Ҫ��ʼ���Լ������ݣ��Ѵ˷��������� 
	 */
	public void initData() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * �������ʵ�ִ˷���������һ��View������Ϊ��ǰFragment�Ĳ�����չʾ��
	 */
	//�����м̳иû�����඼��д��������������ó�����
	public abstract View initView(LayoutInflater inflater);
}
