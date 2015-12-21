package com.andy.utils;

import android.util.Log;

/**
 * 对Log级别进行管理
 * currentLogLevel 设置级别
 * @author	Andy
 * @email	jwc0310@163.com
 */

public class LG {

	private final static String TAG_GLOBAL = "Andy";

	/**
     * Priority constant for the println method; use Log.v.
     *
    public static final int VERBOSE = 2;

     *
     * Priority constant for the println method; use Log.d.
     *
    public static final int DEBUG = 3;

     *
     * Priority constant for the println method; use Log.i.
     *
    public static final int INFO = 4;

     *
     * Priority constant for the println method; use Log.w.
     *
    public static final int WARN = 5;

	 *
     * Priority constant for the println method; use Log.e.
     *
    public static final int ERROR = 6;
    
	 *
     * Priority constant for the println method.
     *
    public static final int ASSERT = 7;
    *
	*/
	
	/**
	 * log level
	 * Log
	 */

	public static int currentLogLevel = Log.VERBOSE; 
	/**
	 * Verbose
	 * @param clazz
	 * @param msg
	 */
	public static void v(Class<?> clazz, String msg){
		if(currentLogLevel > Log.VERBOSE){
			return;
		}
		Log.v(TAG_GLOBAL, "["+clazz.getSimpleName()+"]: "+msg);
	}

	/**
	 * Debug
	 * @param clazz
	 * @param msg
	 */
	public static void d(Class<?> clazz, String msg){
		if(currentLogLevel > Log.DEBUG){
			return;
		}
		Log.d(TAG_GLOBAL, "["+clazz.getSimpleName()+"]: "+msg);
	}

	/**
	 * Info
	 * @param clazz
	 * @param msg
	 */
	public static void i(Class<?> clazz, String msg){
		if(currentLogLevel > Log.INFO){
			return;
		}
		Log.i(TAG_GLOBAL, "["+clazz.getSimpleName()+"]: "+msg);
	}

	/**
	 * Warning
	 * @param clazz
	 * @param msg
	 */
	public static void w(Class<?> clazz, String msg){
		if(currentLogLevel > Log.WARN){
			return;
		}
		Log.w(TAG_GLOBAL, "["+clazz.getSimpleName()+"]: "+msg);
	}
	
	/**
	 * Error
	 * @param clazz
	 * @param msg
	 */
	public static void e(Class<?> clazz, String msg){
		if(currentLogLevel > Log.ERROR){
			return;
		}
		Log.e(TAG_GLOBAL, "["+clazz.getSimpleName()+"]: "+msg);
	}
	
	private LG(){
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}
	
	
}
