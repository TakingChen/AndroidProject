package com.chuangwai.activity;

import com.chuangwai.fragment.LeftMenuFragment;
import com.chuangwai.fragment.MainContentFragment;
import com.hanry.chuangwai.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Window;

/**
 * alt + shift + j
 * @author hanrychen
 *
 *������
 */
public class MainActivity extends SlidingFragmentActivity{

	//���˵�fragment��tag
	private final String LEFT_MENU_FRAGMENT_TAG = "left_menu";
	//������fragment��tag
	private final String MAIN_CONTENT_FRAGMENT_TAG = "main_content";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.main_content);  //�����沼��
		setBehindContentView(R.layout.left_menu);  //���˵�����
		
		SlidingMenu slidingMenu = getSlidingMenu();
		slidingMenu.setMode(SlidingMenu.LEFT);  //�������˵�����
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  //������Ļ��������ק���˵�
		slidingMenu.setBehindOffset(200);  //����������������Ļ�ϵĿ��
		initFragment();
	
	}

	/**
	 * ��ʼ���˵���������Fragment
	 * */
	private void initFragment() {
		// ��ȡFragment����������
		FragmentManager fm = getSupportFragmentManager();
		
		//��������
		android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
		
		//�滻���˵�����
		ft.replace(R.id.fl_left_content, new LeftMenuFragment(), LEFT_MENU_FRAGMENT_TAG);
		//�滻�����沼��
		ft.replace(R.id.fl_main_content, new MainContentFragment(), MAIN_CONTENT_FRAGMENT_TAG);
		
		//�ύ
		ft.commit();
		
	}

}
