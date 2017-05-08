package com.example.s.myapplication;

import android.app.Application;
import android.content.pm.PackageManager;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * Created by s on 16/10/30.
 */
public class MyApplication extends Application {
    public static PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化patch管理类
        mPatchManager = new PatchManager(this);

        // 初始化patch版本
        String appVersion = "1.0";
        try {
            appVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;//获取app版本号
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mPatchManager.init(appVersion);

        // 加载已经添加到PatchManager中的patch
        mPatchManager.loadPatch();

    }
}