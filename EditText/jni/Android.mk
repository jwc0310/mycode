LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := andy_jni
LOCAL_SRC_FILES := andy_jni.cpp

include $(BUILD_SHARED_LIBRARY)
