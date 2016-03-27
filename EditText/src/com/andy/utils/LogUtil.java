package com.andy.utils;

import java.util.Hashtable;

import android.util.Log;

/**
 * Created by robert on 15/7/27.
 */
public class LogUtil {
    
    public static void e(String tag,String params){
        if (LOGFLAG) Log.e(tag,params);
    }
    
    
    /**鎺у埗鏄惁寮�惎log杈撳嚭*/
    public static boolean                         LOGFLAG         = true;  //璋冭瘯妯″紡  true  杩樻槸涓婄嚎妯″紡 false
    
    /**鎵撳嵃搴旂敤鐨勫悕瀛�/  
    private static String                         TAG             = "idol_Proj";  //搴旂敤鐨勫悕瀛� tag鏍囪  
    
    /**鏃ュ織鐨勭骇鍒�/
    private final static int                      LOGLEVEL        = Log.VERBOSE; //鏃ュ織绾у埆
    
    /**缂撳瓨鎵撳嵃绫荤殑闆嗗悎*/
    private static Hashtable<String, LogUtil>    sLoggerTable    = new Hashtable<String, LogUtil>();  
    
    /**绫诲悕*/
    private String                                mClassName;  
    
    /**璋冪敤杈撳嚭Log鐨勪汉鍛�/
    private static LogUtil                       Nlog;  
    
    /**寮�彂浜哄憳鍚嶅瓧*/
    private static final String                   yaoyuan          = "@Yaoyuan@";  
    private static LogUtil                       Nlog;  
    private final static int                      LOGLEVEL        = Log.VERBOSE;
    private static String                         TAG             = "idol_Proj";
      
    private LogUtil(String name)  
    {  
        mClassName = name;  
    }  
      
    /** 
     *  杩欐槸涓�釜缂撳瓨闆嗗悎锛屽皢瑕佹墦鍗扮殑绫诲悕鏀惧埌涓�釜HashMap涓�
     * @param className 
     * @return 
     */  
    @SuppressWarnings("unused")  
    private static LogUtil getLogger(String className)  
    {  
        LogUtil classLogger = (LogUtil) sLoggerTable.get(className);  
        if(classLogger == null)  
        {  
            classLogger = new LogUtil(className);  
            sLoggerTable.put(className, classLogger);  
        }  
        return classLogger;  
    }  
      
    /** 
     * 杩欐槸瀵瑰簲娴嬭瘯浜哄憳鐨勮皟鐢ㄧ殑鏂规硶
     * @return 
     */  
    public static LogUtil Nlog()  
    {   
        if(Nlog == null)  
        {   
            Nlog = new LogUtil(yaoyuan);  
        }  
        return Nlog;  
    }  
    
    
    /** 
     * 鑾峰彇褰撳墠鏂规硶鐨勮缁嗕俊鎭�
     * 鍏蜂綋鍒版柟娉曞悕銆佹柟娉曡锛屾柟娉曟墍鍦ㄧ被鐨勬枃浠跺悕
     * @return 
     */  
    private String getFunctionName()  
    {  
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();  
        if(sts == null)  
        {  
            return null;  
        }  
        for(StackTraceElement st : sts)  
        {  
            if(st.isNativeMethod())  
            {  
                //鏈湴鏂规硶native  jni
                continue;  
            }  
            if(st.getClassName().equals(Thread.class.getName()))  
            {  
                //绾跨▼  
                continue;  
            }  
            if(st.getClassName().equals(this.getClass().getName()))  
            {  
                //鏋勯�鏂规硶
                continue;  
            }  
            return "[ " + Thread.currentThread().getName() + ": "  
                    + st.getFileName() + ":" + st.getLineNumber() + " "  
                    + st.getMethodName() + " ]";  
        }  
        return null;  
    }  
      
    /** 
     * 杩欐槸i绾og鐨勬棩蹇�
     * @param str 
     */  
    public void i(Object str)  
    {  
        if(LOGFLAG)  
        {  
            if(LOGLEVEL <= Log.INFO)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.i(TAG+mClassName,  str+" - " +name);  
                }  
                else  
                {  
                    Log.i(TAG+mClassName, str.toString());  
                }  
            }  
        }  
          
    }  
      
    /** 
     * 杩欐槸d绾og鐨勬棩蹇�
     * @param str 
     */  
    public void d(Object str)  
    {  
        if(LOGFLAG)  
        {  
            if(LOGLEVEL <= Log.DEBUG)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.d(TAG+mClassName,  str+" - " +name); 
                }  
                else  
                {  
                    Log.d(TAG+mClassName, str.toString());  
                }  
            }  
        }  
    }  
      
    /** 
     * 杩欐槸v绾og鐨勬棩蹇�
     * @param str 
     */  
    public void v(Object str)  
    {  
        if(LOGFLAG)  
        {  
            if(LOGLEVEL <= Log.VERBOSE)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.v(TAG+mClassName,  str+" - " +name);  
                }  
                else  
                {  
                    Log.v(TAG+mClassName, str.toString());  
                }  
            }  
        }  
    }  
      
    /** 
     * 杩欐槸w绾og鐨勬棩蹇�
     * @param str 
     */  
    public void w(Object str)  
    {  
        if(LOGFLAG)  
        {  
            if(LOGLEVEL <= Log.WARN)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.w(TAG+mClassName,  str+" - " +name);  
                }  
                else  
                {  
                    Log.w(TAG+mClassName, str.toString());  
                }  
            }  
        }  
    }  
      
    /** 
     * 杩欐槸e绾og鐨勬棩蹇�
     * @param str 
     */  
    public void e(Object str)  
    {  
        if(LOGFLAG)  
        {  
            if(LOGLEVEL <= Log.ERROR)  
            {  
                String name = getFunctionName();  
                if(name != null)  
                {  
                    Log.e(TAG+mClassName,  str+" - " +name);  
                }  
                else  
                {  
                    Log.e(TAG+mClassName, str.toString());  
                }  
            }  
        }  
    }  
      
    /** 
     * 杩欐槸ex绾og鐨勬棩蹇�
     * @param ex 
     */  
    public void e(Exception ex)  
    {  
        if(LOGFLAG)  
        {  
            if(LOGLEVEL <= Log.ERROR)  
            {  
                Log.e(TAG+mClassName, "error", ex);  
            }  
        }  
    }  
      
    /** 
     *杩欎篃鏄痚绾х殑鏃ュ織锛岃幏鍙栨柟娉曞悕鍦ㄧ鍑犺
     * @param log 
     * @param tr 
     */  
    public void e(String log, Throwable tr)  
    {  
        if(LOGFLAG)  
        {  
            String line = getFunctionName();  
            Log.e(TAG+mClassName, "{Thread:" + Thread.currentThread().getName() + "}"  
                    + "[" + mClassName + line + ":] " + log + "\n", tr);  
        }  
    }  
    
    
    
}
