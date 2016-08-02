package com.chuangwai.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author hanrychen
 * 缓存类，所有的数据都是采用ShareedPreferences方式存储和获取。
 */

public class CacheUtils {
	
	public static final String CACHE_FILE_NAME = "surround";
	public static SharedPreferences mSharedPreferences;
	
	/*
	 * @param context
	 * @param key 要取的数据的键
	 * @param defValue 缺省值
	 * @return 
	 * */
	
	public static boolean getBoolean(Context context,String key,boolean defValue){
		if(mSharedPreferences == null){
			mSharedPreferences = context.getSharedPreferences(CACHE_FILE_NAME, Context.MODE_PRIVATE);
		}
		return mSharedPreferences.getBoolean(key, defValue);
	}
	
	/*
	 * 存储一个boolean类型
	 * @param context
	 * @param key 要取的数据的键
	 * @param value
	 * */
	public static void putBoolean(Context context,String key,boolean value){
		if(mSharedPreferences == null){
			mSharedPreferences = context.getSharedPreferences(CACHE_FILE_NAME, Context.MODE_PRIVATE);
		}
		mSharedPreferences.edit().putBoolean(key, value).commit();
	}

}
