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
 *主界面
 */
public class MainActivity extends SlidingFragmentActivity{

	//左侧菜单fragment的tag
	private final String LEFT_MENU_FRAGMENT_TAG = "left_menu";
	//主界面fragment的tag
	private final String MAIN_CONTENT_FRAGMENT_TAG = "main_content";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.main_content);  //主界面布局
		setBehindContentView(R.layout.left_menu);  //左侧菜单布局
		
		SlidingMenu slidingMenu = getSlidingMenu();
		slidingMenu.setMode(SlidingMenu.LEFT);  //设置左侧菜单可用
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  //整个屏幕都可以拖拽出菜单
		slidingMenu.setBehindOffset(200);  //设置主界面留在屏幕上的宽度
		initFragment();
	
	}

	/**
	 * 初始化菜单和主界面Fragment
	 * */
	private void initFragment() {
		// 获取Fragment管理器对象
		FragmentManager fm = getSupportFragmentManager();
		
		//开启事务
		android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
		
		//替换左侧菜单布局
		ft.replace(R.id.fl_left_content, new LeftMenuFragment(), LEFT_MENU_FRAGMENT_TAG);
		//替换主界面布局
		ft.replace(R.id.fl_main_content, new MainContentFragment(), MAIN_CONTENT_FRAGMENT_TAG);
		
		//提交
		ft.commit();
		
	}

}
