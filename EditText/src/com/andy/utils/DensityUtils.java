package com.andy.utils;

import android.content.Context;
import android.util.TypedValue;

/*
 ��androidԴ���TypedValue.java�У����ǿ����º�����

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

	   �ú������ܣ��ǰѸ���λ����Ϊ���ء�
	
	   metrics.density��Ĭ��ֵΪDENSITY_DEVICE / (float) DENSITY_DEFAULT;
	
	   metrics.scaledDensity��Ĭ��ֵΪDENSITY_DEVICE / (float) DENSITY_DEFAULT;
	
	   metrics.xdpi��Ĭ��ֵΪDENSITY_DEVICE;
	
	   DENSITY_DEVICE��Ϊ��Ļ�ܶ�
	
	   DENSITY_DEFAULT��Ĭ��ֵΪ160
 */


/**
 * ���õ�λת��������
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
     * pxתdp 
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
     * pxתsp 
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
