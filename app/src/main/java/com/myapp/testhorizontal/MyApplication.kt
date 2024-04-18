package com.myapp.testhorizontal

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.MobileAds

class MyApplication: Application(), Application.ActivityLifecycleCallbacks, LifecycleEventObserver {
    private val appOpenAdManager by lazy { AppOpenAdManager() }
    private var currentActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
        MobileAds.initialize(this) {}
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
        if (!appOpenAdManager.isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityResumed(activity: Activity) {
        if (!appOpenAdManager.isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityPaused(p0: Activity) {
    }

    override fun onActivityStopped(p0: Activity) {
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
    }

    override fun onActivityDestroyed(p0: Activity) {
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.v("tag111", "StateChange $event $currentActivity")
        when(event) {
            Lifecycle.Event.ON_START -> {
//                Log.v("tag111", "StateChange start")
                currentActivity?.let {
                    Handler(Looper.getMainLooper()).postDelayed({
                        appOpenAdManager.showAdIfAvailable(it)
                    }, 100)
                }
            }

            else -> {}
        }
    }
}