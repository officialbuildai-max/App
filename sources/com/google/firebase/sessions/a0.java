package com.google.firebase.sessions;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a0 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f32683a = new a0();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f32684b;

    /* renamed from: c, reason: collision with root package name */
    private static SessionLifecycleClient f32685c;

    private a0() {
    }

    public final void a(SessionLifecycleClient sessionLifecycleClient) {
        f32685c = sessionLifecycleClient;
        if (sessionLifecycleClient == null || !f32684b) {
            return;
        }
        f32684b = false;
        sessionLifecycleClient.k();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.h(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = f32685c;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.h();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Unit unit;
        Intrinsics.h(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = f32685c;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.k();
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        if (unit == null) {
            f32684b = true;
        }
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
