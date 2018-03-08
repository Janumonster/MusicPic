package com.example.peanut.reviewmyskill.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于管理activity
 * Created by Peanut on 2018/3/7.
 */

public class ActivityCollection {

    public static List<Activity> activities=new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity:activities
             ) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
