package com.chuangwai.activity;

import java.util.ArrayList;
import java.util.List;

import com.chuangwai.Utils.CacheUtils;
import com.hanry.chuangwai.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

public class GuideActivity extends Activity implements OnPageChangeListener, OnClickListener{
	
	private List<ImageView> imageViewList;  //viewpager������
	private LinearLayout llPointGroup; //�����
    private View mSelectPointView; //ѡ�е��view����
    private int basicWidth; //��֮��ľ���
    private Button btnStartExperience;  //��ʼ���鰴ť
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  //ȥ���⣬��Ҫ��setContentView֮ǰ����
		setContentView(R.layout.guide);
		
		initView();
	}

	/**
	 * ��ʼ���ؼ�
	 * */
	private void initView() {
		ViewPager mViewPager =(ViewPager)findViewById(R.id.vp_guide);
	    btnStartExperience = (Button) findViewById(R.id.btn_guide_start_experience);
		llPointGroup = (LinearLayout) findViewById(R.id.ll_guide_point_group);
	    mSelectPointView = findViewById(R.id.select_point);
		
		initData();
		
		GuideAdapter mAdapter = new GuideAdapter();
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);
		btnStartExperience.setOnClickListener(this);
		
		//view�������̣�measure -> layout -> draw
		//����mSelectPointView�ؼ�layout
		
		//�����ͼ���Ĺ۲��ߣ�����ȫ�����ֵĻص�
		mSelectPointView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				// ִֻ��һ�Σ��ѵ�ǰ���¼�����ͼ���Ĺ۲������Ƴ���
				mSelectPointView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
			   
				//ȡ��������֮��Ŀ��
				basicWidth = llPointGroup.getChildAt(1).getLeft() - llPointGroup.getChildAt(0).getLeft();
			}
		});
	}
	
	/*
	 * ��ʼ������
	 * */
	private void initData() {
		int[] imageResIDs = {
				R.drawable.guide_1,
				R.drawable.guide_2,
				R.drawable.guide_3,
		};
		
		//ctrl + 2 ����ͣ�� L
		
		imageViewList = new ArrayList<ImageView>();
		ImageView iv;
		View view;
		LayoutParams params;
		for(int i = 0;i < imageResIDs.length;i++){
			iv = new ImageView(this);
			iv.setBackgroundResource(imageResIDs[i]);
			imageViewList.add(iv);
			
			//����ͼƬ�ĸ�����ÿѭ��һ����LinearLayout�����һ����
			view = new View(this);
			view.setBackgroundColor(R.drawable.point_normal);
			params = new LayoutParams(10, 10);  
			if(i != 0){
				params.leftMargin = 10;
			}
			view.setLayoutParams(params);//���õ�Ĵ�С
			llPointGroup.addView(view);  //��ӵ�
		}
		
	}

	class GuideAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return imageViewList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView iv = imageViewList.get(position);
			//1.��ViewPager�����һ��view����
			container.addView(iv);
			//2.���ص�ǰ��ӵ�view����
			return iv;
		}
		
	}

	/*
	 * ��ҳ�����ڹ���ʱ
	 * position ��ǰѡ�е����ĸ�ҳ��
	 * positionOffset ����
	 * positionOffsetPixels  ƫ������
	 * */
	
	/*
	 * LayoutParams�൱��һ��Layout����Ϣ����
	 * ����װ��Layout��λ�á��ߡ������Ϣ��
	 * ��������Ļ��һ����������һ��Layoutռ��ģ�
	 * �����һ��View��ӵ�һ��Layout�У�
	 * ��ø���Layout�û������Ĳ��ַ�ʽ��
	 * Ҳ���ǽ�һ���Ͽɵ�layoutParams���ݽ�ȥ��
	 * */
	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
		System.out.println("position:" + position + ",positionOffset:" + positionOffset);
		//20*(1 + 0.99) = 38
		int leftMargin = (int) (basicWidth * (position + positionOffset));
		RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) 
				mSelectPointView.getLayoutParams();  //���ѡ�е����Ϣ���߿�ȣ�
		params.leftMargin = leftMargin;  //ƫ�ƵĴ�С
		mSelectPointView.setLayoutParams(params);
		
	}

	/*
	 * ��ҳ�汻ѡ��
	 * */
	@Override
	public void onPageSelected(int position) {
		if(position == imageViewList.size() - 1){
			btnStartExperience.setVisibility(View.VISIBLE);
		}else{
			btnStartExperience.setVisibility(View.GONE);
		}
		
	}

	/*
	 * ��ҳ�����״̬�ı�
	 * */
	@Override
	public void onPageScrollStateChanged(int state) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public void onClick(View v) {
		//��IS_OPEN_MAIN_PAGER�����ڻ����д洢һ��true
		CacheUtils.putBoolean(this, WelcomeActivity.IS_OPEN_MAIN_PAGER, true);
		
		//����ҳ��
		startActivity(new Intent(this,MainActivity.class));
		
		finish();
	}

}
