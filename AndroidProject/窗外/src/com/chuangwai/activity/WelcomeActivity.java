package com.chuangwai.activity;

import com.chuangwai.Utils.CacheUtils;
import com.hanry.chuangwai.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

public class WelcomeActivity extends Activity implements AnimationListener {
	
	public static final String IS_OPEN_MAIN_PAGER = "IS_OPEN_MAIN_PAGER";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		
		init();
	}

	private void init(){
		View rootView = findViewById(R.id.rl_welcome_root);
		
		//Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f
		//x,y 0.5 ������ ��ת
		RotateAnimation rotateAnima = new RotateAnimation(
				0, 360, 
				Animation.RELATIVE_TO_SELF,0.5f,
				Animation.RELATIVE_TO_SELF,0.5f	);
		rotateAnima.setDuration(1000);
		rotateAnima.setFillAfter(true);  //���ö���ִ�����ʱ��ͣ������ϵ�״̬�¡�
		
		ScaleAnimation scaleAnima = new ScaleAnimation(
				0, 1, 
				0, 1, 
				Animation.RELATIVE_TO_SELF,0.5f,
				Animation.RELATIVE_TO_SELF,0.5f	);
		
		scaleAnima.setDuration(1000);
		scaleAnima.setFillAfter(true);
		
		//����
		AlphaAnimation alphaAnima = new AlphaAnimation(0, 1);
		alphaAnima.setDuration(2000);
		alphaAnima.setFillAfter(true);
		
		//��������������һ�����һ�����϶���
		AnimationSet setAnima = new AnimationSet(false);
		setAnima.addAnimation(rotateAnima);
		setAnima.addAnimation(scaleAnima);
		setAnima.addAnimation(alphaAnima);
		setAnima.setAnimationListener(this);
		
		rootView.startAnimation(setAnima);
		
		
		}

	@Override
	public void onAnimationStart(Animation animation) {
		
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		//ȥ�ļ���ȡ�Ƿ�򿪹������ֵ
		boolean isOpenMainPager = CacheUtils.getBoolean(WelcomeActivity.this, IS_OPEN_MAIN_PAGER, false);
		Intent intent = new Intent();
		if(isOpenMainPager){
			// �Ѿ��򿪹�һ�������棬ֱ�ӽ��������档
			intent.setClass(WelcomeActivity.this,MainActivity.class);
		}else{
			//û�д򿪹������棬��������ҳ�档
			intent.setClass(WelcomeActivity.this,GuideActivity.class);
		}
		startActivity(intent);
		
		//�رջ�ӭҳ��
		finish();
		
		
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}
}
