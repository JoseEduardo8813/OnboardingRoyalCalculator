package com.royalcaribbean.jose.calculator.mvp.views;

import android.app.Activity;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public class ActivityView {
    private WeakReference<Activity> activityRef;

    public ActivityView(Activity activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public Activity getActivity() {
        return activityRef.get();
    }
}
