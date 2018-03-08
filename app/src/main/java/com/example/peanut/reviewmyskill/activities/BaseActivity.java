package com.example.peanut.reviewmyskill.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.peanut.reviewmyskill.util.ActivityCollection;

/**
 * 所有activity的基类，操作可作用于全部activity
 * Created by Peanut on 2018/3/7.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        ActivityCollection.activities.add(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollection.activities.remove(this);
    }
}
