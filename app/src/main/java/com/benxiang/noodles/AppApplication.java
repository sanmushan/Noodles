package com.benxiang.noodles;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;

import com.benxiang.noodles.data.DBFactory;
import com.benxiang.noodles.serialport.service.MakeNoodlesService;
import com.benxiang.noodles.utils.LogcatHelper;
import com.benxiang.noodles.utils.SpUtils;
import com.benxiang.noodles.utils.TTSHelper;
import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.litesuits.orm.db.DataBaseConfig;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.umeng.analytics.MobclickAgent;

import timber.log.Timber;

/**
 * @author LIN
 * Created by 刘圣如 on 2017/8/24.
 */

public class AppApplication extends Application {
    private static Context mContext;
    RefWatcher mRefWatcher;
    private static int sortNo = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        SpUtils.init(this, "dbLuckyDraw");
        initBlankUtil();
        initTimber();
        initUmeng();
        initDB();
        initTTS();
        if (BuildConfig.DEBUG) {
            initLeak();
        }
//        startMakeNoodlesService();
//        initSaveLog();
    }

    private void initSaveLog() {
        LogcatHelper.getInstance(this).start();
    }

    private void initBlankUtil() {
        Utils.init(this);
        //打印log到文件
        LogUtils.getConfig().setDir(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/Log");
        CrashUtils.init();
    }

    private void initLeak() {
        mRefWatcher = LeakCanary.install(this);
    }

    private void initTTS() {
        TTSHelper.init(this,TTSHelper.TTS_ENGINE_IFLYTEK);
    }

    private void initDB() {

        String sdCardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/";
        DataBaseConfig dataBaseConfig = new DataBaseConfig(this, sdCardPath+"noodles.db");

      /*  String sdCardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/";
        DataBaseConfig dataBaseConfig = new DataBaseConfig(this, sdCardPath+"noodles.db");*/

        dataBaseConfig.debugged=true;
        dataBaseConfig.dbVersion=1;
        DBFactory.initNoodle(dataBaseConfig);
    }

    public static Context getAppContext(){
        return mContext;
    }
    private void initTimber(){
//        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
//        }
    }
    private void initUmeng() {
        MobclickAgent.setCatchUncaughtExceptions(true);
    }

    public static int getSortNo() {
        return sortNo;
    }

    public static void setSortNo(int sortNo) {
        AppApplication.sortNo = sortNo;
    }

//    public static void startMakeNoodlesService() {
//        Intent intent = new Intent(getAppContext(), MakeNoodlesService.class);
//       getAppContext().startService(intent);
//    }

//    public static void stopMakeNoodleService(){
//        Intent intent = new Intent(getAppContext(), MakeNoodlesService.class);
//        getAppContext().stopService(intent);
//    }

    private static Handler mHandler;

    public static Handler getHandler(){
        if (mHandler == null){
            mHandler = new Handler();
        }
        return mHandler;
    }

}
