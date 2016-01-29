#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#define NELEM(x) sizeof(x)/(sizeof(x[0]))

extern "C" {
	JNIEXPORT jstring JNICALL Java_com_andy_jni_JNI_stringFromJNI(JNIEnv* env,jobject thiz);
}

JNIEXPORT jstring JNICALL Java_com_andy_jni_JNI_stringFromJNI(JNIEnv* env,jobject thiz){
	return env->NewStringUTF("I am come from JNI !");
}

const char* JNIT_CALSS = "com/andy/jni/JNI";

static jint Java_com_andy_jni_JNI_nadd(JNIEnv* env, jobject obj,jint param1,jint param2){
	return param1+param2;
}

static JNINativeMethod gMethods[] = {
		{"nadd","(II)I",(void*)Java_com_andy_jni_JNI_nadd},
};

static jint registerNativeMethods(JNIEnv* env,const char* classname,JNINativeMethod* gMethods,jint gMethodsNum){
	jclass clazz;
	clazz = env->FindClass(classname);

	if(clazz == NULL){
		return JNI_FALSE;
	}

	if(env->RegisterNatives(clazz,gMethods,gMethodsNum) < 0){
		return JNI_FALSE;
	}

	return JNI_TRUE;
}

static jint register_android_native_methods(JNIEnv *env){
	return registerNativeMethods(env,JNIT_CALSS,gMethods,NELEM(gMethods));
}

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved){

	JNIEnv *env = NULL;
	if(vm->GetEnv((void**)&env, JNI_VERSION_1_4) != JNI_OK){
		printf("Error GetEnv\n");
		return -1;
	}

	assert(env != NULL);

	if(register_android_native_methods(env) < 0){
		printf("register_android_native_methods\n");
	}

	return JNI_VERSION_1_4;

}



