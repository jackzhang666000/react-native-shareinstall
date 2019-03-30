package com.shareinstall.shareinstallibrary;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

import com.sh.sdk.shareinstall.ShareInstall;
import com.sh.sdk.shareinstall.listener.AppGetInfoListener;

public class RNShareinstallModule extends ReactContextBaseJavaModule{
    ReactContext  context;

    public RNShareinstallModule(final ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }

    @ReactMethod
    public void getWakeUp(final Callback successBack){
         Activity currentActivity = getCurrentActivity();
         Intent intent= currentActivity.getIntent();

      ShareInstall.getInstance().getInfo(intent, new AppGetInfoListener() {
      @Override
      public void onGetInfoFinish(String appData) {
        if (appData != null) {
          Log.d("RNShareinstallModule", "getWakeUp : wakeupData = " + appData);
          String data = appData;
          WritableMap params = Arguments.createMap();
          params.putString("data", data);
          successBack.invoke(params);
        } 
      }
    });
    }

    @Override
    public void initialize() {
        super.initialize();
        ShareInstall.getInstance().init(getCurrentActivity());
     
    }

    @Override
    public String getName() {
        return "RNShareinstallModule";
    }

    @ReactMethod
    public void getInstall(Integer time,final Callback  callback ){
      Activity currentActivity = getCurrentActivity();
      Intent intent= currentActivity.getIntent();

      ShareInstall.getInstance().getInfo(intent,new AppGetInfoListener() {
        @Override
        public void onGetInfoFinish(String appData) {
          try {
          //Log.d(TAG, "onInstallFinish # " + (appData == null ? "AppData is null" :appData));
          Log.d("Install", "getInstall : data = " + appData);
          WritableMap params = Arguments.createMap();
                        //params.putString("channel",channelCode);
                        params.putString("data",appData);
                        callback.invoke(params);
          }catch (Exception e){
                        callback.invoke(e);
          }
        }
      });//,time*1000

    }

    @ReactMethod
    public void reportRegister(){
      ShareInstall.getInstance().reportRegister();
    }

}
