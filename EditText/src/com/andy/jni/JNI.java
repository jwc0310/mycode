package com.andy.jni;

public class JNI {
	static {
		System.loadLibrary("andy_jni");
	}
	
	public native int nadd(int num1,int num2);
	public native String stringFromJNI();
}
