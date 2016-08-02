package com.chuangwai.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author hanrychen
 * �����࣬���е����ݶ��ǲ���ShareedPreferences��ʽ�洢�ͻ�ȡ��
 */

public class CacheUtils {
	
	public static final String CACHE_FILE_NAME = "surround";
	public static SharedPreferences mSharedPreferences;
	
	/*
	 * @param context
	 * @param key Ҫȡ�����ݵļ�
	 * @param defValue ȱʡֵ
	 * @return 
	 * */
	
	public static boolean getBoolean(Context context,String key,boolean defValue){
		if(mSharedPreferences == null){
			mSharedPreferences = context.getSharedPreferences(CACHE_FILE_NAME, Context.MODE_PRIVATE);
		}
		return mSharedPreferences.getBoolean(key, defValue);
	}
	
	/*
	 * �洢һ��boolean����
	 * @param context
	 * @param key Ҫȡ�����ݵļ�
	 * @param value
	 * */
	public static void putBoolean(Context context,String key,boolean value){
		if(mSharedPreferences == null){
			mSharedPreferences = context.getSharedPreferences(CACHE_FILE_NAME, Context.MODE_PRIVATE);
		}
		mSharedPreferences.edit().putBoolean(key, value).commit();
	}

}
