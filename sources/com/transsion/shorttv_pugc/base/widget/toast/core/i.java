package com.transsion.shorttv_pugc.base.widget.toast.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class i implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private Activity f54027a;

    /* renamed from: b, reason: collision with root package name */
    private ToastImpl f54028b;

    public i(Activity activity) {
        this.f54027a = activity;
    }

    public final Activity a() {
        return this.f54027a;
    }

    public final void b(ToastImpl toastImpl) {
        this.f54028b = toastImpl;
        Activity activity = this.f54027a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Intrinsics.e(activity);
            activity.registerActivityLifecycleCallbacks(this);
        } else {
            Intrinsics.e(activity);
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    public final void c() {
        this.f54028b = null;
        Activity activity = this.f54027a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Intrinsics.e(activity);
            activity.unregisterActivityLifecycleCallbacks(this);
        } else {
            Intrinsics.e(activity);
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (this.f54027a != activity) {
            return;
        }
        ToastImpl toastImpl = this.f54028b;
        if (toastImpl != null) {
            Intrinsics.e(toastImpl);
            toastImpl.e();
        }
        c();
        this.f54027a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ToastImpl toastImpl;
        Intrinsics.h(activity, "activity");
        if (this.f54027a == activity && (toastImpl = this.f54028b) != null) {
            Intrinsics.e(toastImpl);
            toastImpl.e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.h(activity, "activity");
    }
}
