package com.example.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理活动的集合类
 *
 * Created by lpw on 2018/5/26.
 */
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    private static final String TAG = "ActivityCollector";

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        /** 杀掉当前进程 */
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
