package com.chuangwai.base;

import com.hanry.chuangwai.R;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * @author hanrychen
 *
 */
public class TabBasePager {

	public Context mContext;
	public TextView tvTitle;
	public ImageButton ibMenu;
	public FrameLayout flContent;
	private View rootView;

	public TabBasePager(Context context) {
		super();
		this.mContext = context;
		
		rootView = initView();
	}

	private View initView() {
		View view = View.inflate(mContext, R.layout.tab_base_pager, null);
		tvTitle = (TextView) view.findViewById(R.id.tv_title_bar_title);
		ibMenu = (ImageButton) view.findViewById(R.id.ib_title_bar_menu);
		flContent = (FrameLayout) view.findViewById(R.id.fl_tab_base_pager_content);
		return view;
	}
	
	/**
	 * 获得当前页面布局对象
	 * @return
	 * */
	public View getRootView(){
		return rootView;	
	}
	
	public void initData(){
		
	}
	
}
