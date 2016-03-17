package com.example.fortestensure;

import java.util.Hashtable;

import android.util.Log;

/**
 * Created by robert on 15/7/27.
 */
public class LogUtil {
    
    public static void e(String tag,String params){
        if (LOGFLAG) Log.e(tag,params);
    }
    
    
    /**控制是否开启log输出*/
    public static boolean                         LOGFLAG         = true;  //调试模式  true  还是上线模式 false
    
    /**打印应用的名字*/  
    private static String                         TAG             = "idol_Proj";  //应用的名字  tag标记  
    
    /**日志的级别*/
    private final static int                      LOGLEVEL        = Log.VERBOSE; //日志级别
    
    /**缓存打印类的集合*/
    private static Hashtable<String, LogUtil>    sLoggerTable    = new Hashtable<String, LogUtil>();  
    
    /**类名*/
    private String                                mClassName;  
    
    /**调用输出Log的人员*/
    private static LogUtil                       Nlog;  
    
    /**开发人员名字*/
    private static final String                   yaoyuan          = "@Yaoyuan@";  
    
      
    private LogUtil(String name)  
    {  
        mClassName = name;  
    }  
      
    /** 
     *  这是一个缓存集合，将要打印的类名放到一个HashMap中
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
     * 这是对应测试人员的调用的方法
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
     * 获取当前方法的详细信息
     * 具体到方法名、方法行，方法所在类的文件名
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
                //本地方法native  jni
                continue;  
            }  
            if(st.getClassName().equals(Thread.class.getName()))  
            {  
                //线程  
                continue;  
            }  
            if(st.getClassName().equals(this.getClass().getName()))  
            {  
                //构造方法
                continue;  
            }  
            return "[ " + Thread.currentThread().getName() + ": "  
                    + st.getFileName() + ":" + st.getLineNumber() + " "  
                    + st.getMethodName() + " ]";  
        }  
        return null;  
    }  
      
    /** 
     * 这是i级log的日志
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
     * 这是d级log的日志
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
     * 这是v级log的日志
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
     * 这是w级log的日志
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
     * 这是e级log的日志
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
     * 这是ex级log的日志
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
     *这也是e级的日志，获取方法名在第几行
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
