package com.dapp.dapp;

import android.app.Application;
import android.content.Intent;

import androidx.lifecycle.LiveData;

public class MainApplication extends Application {
    public static Application instance;
    public static Application getInstance(){
        if(instance!=null){
            return instance;
        }
        else{
            return new MainApplication();
        }
    }

    @Override
    public void onCreate() {
        instance=this;
        super.onCreate();
    }
}
