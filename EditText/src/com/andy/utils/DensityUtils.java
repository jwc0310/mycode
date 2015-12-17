package com.andy.utils;

import android.content.Context;
import android.util.TypedValue;

/*
 在android源码包TypedValue.java中，我们看如下函数：

    public static float applyDimension(int unit, float value,

                        DisplayMetrics metrics)

   {

        switch (unit) {

        case COMPLEX_UNIT_PX:

            return value;

        case COMPLEX_UNIT_DIP:

            return value * metrics.density;

        case COMPLEX_UNIT_SP:

            return value * metrics.scaledDensity;

        case COMPLEX_UNIT_PT:

            return value * metrics.xdpi * (1.0f/72);

        case COMPLEX_UNIT_IN:

            return value * metrics.xdpi;

        case COMPLEX_UNIT_MM:

            return value * metrics.xdpi * (1.0f/25.4f);

        }

        return 0;

    }

	   该函数功能：是把各单位换算为像素。
	
	   metrics.density：默认值为DENSITY_DEVICE / (float) DENSITY_DEFAULT;
	
	   metrics.scaledDensity：默认值为DENSITY_DEVICE / (float) DENSITY_DEFAULT;
	
	   metrics.xdpi：默认值为DENSITY_DEVICE;
	
	   DENSITY_DEVICE：为屏幕密度
	
	   DENSITY_DEFAULT：默认值为160
 */


/**
 * 常用单位转换辅助类
 * 
 * @author Andy
 *
 */

public class DensityUtils {
	private DensityUtils(){
		/* cannot be instantiated */  
        throw new UnsupportedOperationException("cannot be instantiated"); 
	}
	
	/**
	 * dp -> px ()
	 * 
	 * px = dp * metrics.density
	 * 
	 * @param context
	 * @param dpVal
	 * @return
	 */
	
	public static int dp2px(Context context, float dpVal){
		return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
	}
	/**
	 * sp -> px()
	 * px = dp * metrics.scaledDensity
	 * @param context
	 * @param dpVal
	 * @return
	 */
	
	public static int sp2px(Context context, float dpVal){
		return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dpVal, context.getResources().getDisplayMetrics());
	}
	
	/** 
     * px转dp 
     *  
     * @param context 
     * @param pxVal 
     * @return 
     */  
    public static float px2dp(Context context, float pxVal)  
    {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (pxVal / scale);  
    }  
  
    /** 
     * px转sp 
     *  
     * @param fontScale 
     * @param pxVal 
     * @return 
     */  
    public static float px2sp(Context context, float pxVal)  
    {  
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);  
    }
	
}
