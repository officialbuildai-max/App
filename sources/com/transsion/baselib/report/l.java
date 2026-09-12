package com.transsion.baselib.report;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes.dex */
public final class l implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public static final l f43413a = new l();

    /* renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList f43414b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f43415c = LazyKt.b(new Function0() { // from class: com.transsion.baselib.report.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            CopyOnWriteArrayList i11;
            i11 = l.i();
            return i11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static int f43416d;

    /* renamed from: e, reason: collision with root package name */
    private static long f43417e;

    /* renamed from: f, reason: collision with root package name */
    private static int f43418f;

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f43419g;

    /* loaded from: classes5.dex */
    public interface a {
        void onBackgroundStatusChange(boolean z10);
    }

    private l() {
    }

    private final void c(Activity activity) {
        int i11 = f43416d + 1;
        f43416d = i11;
        if (i11 == 1) {
            j(false, activity);
        }
        Log.e("yy", "onActivityStarted  activity:" + activity + "  resumedActivityCount " + f43416d);
    }

    static /* synthetic */ void d(l lVar, Activity activity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            activity = null;
        }
        lVar.c(activity);
    }

    private final void e(Activity activity) {
        int i11 = f43416d - 1;
        f43416d = i11;
        if (i11 == 0) {
            j(true, activity);
            f43417e = System.currentTimeMillis();
        }
        Log.e("yy", "onActivityStopped  activity:" + activity + " resumedActivityCount " + f43416d);
    }

    static /* synthetic */ void f(l lVar, Activity activity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            activity = null;
        }
        lVar.e(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyOnWriteArrayList i() {
        return new CopyOnWriteArrayList();
    }

    private final void j(boolean z10, Activity activity) {
        h.f43402a.f(z10);
        yg.b.f79132a.j(Boolean.valueOf(z10));
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((a) it.next()).onBackgroundStatusChange(z10);
        }
    }

    private final void k() {
        try {
            Iterator it = f43414b.iterator();
            Intrinsics.g(it, "iterator(...)");
            int i11 = 0;
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                try {
                } catch (Exception e11) {
                    lg.a.f68962a.x("RoomActivityLifecycleCallbacks", "check activity state failed, remove it: " + e11.getMessage(), true);
                    it.remove();
                }
                if (!activity.isDestroyed() && !activity.isFinishing()) {
                }
                lg.a.f68962a.c("RoomActivityLifecycleCallbacks", "cleanup destroyed activity: " + activity.getClass().getSimpleName(), true);
                it.remove();
                i11++;
            }
            if (i11 > 0) {
                lg.a.f68962a.c("RoomActivityLifecycleCallbacks", "cleaned " + i11 + " destroyed activities", true);
            }
        } catch (Exception e12) {
            lg.a.f68962a.i("RoomActivityLifecycleCallbacks", "cleanupDestroyedActivities failed: " + e12.getMessage(), true);
        }
    }

    private final List n() {
        return (List) f43415c.getValue();
    }

    public final int b() {
        return f43414b.size();
    }

    public final boolean g(a listener) {
        Intrinsics.h(listener, "listener");
        if (n().contains(listener)) {
            return false;
        }
        return n().add(listener);
    }

    public final void h() {
        d(this, null, 1, null);
    }

    public final void l() {
        CopyOnWriteArrayList copyOnWriteArrayList = f43414b;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        Intrinsics.g(it, "iterator(...)");
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                try {
                    activity.finish();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        f43414b.clear();
    }

    public final List m() {
        return f43414b;
    }

    public final Activity o() {
        return p(0);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityCreated  activity:" + activity);
        if (activity instanceof f) {
            return;
        }
        f43414b.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityDestroyed  activity:" + activity);
        if (activity instanceof f) {
            return;
        }
        try {
            f43414b.remove(activity);
        } catch (Exception e11) {
            lg.a.f68962a.i("RoomActivityLifecycleCallbacks", "remove activity from stack failed: " + e11.getMessage(), true);
            Iterator it = f43414b.iterator();
            Intrinsics.g(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() == activity) {
                    it.remove();
                    break;
                }
            }
        }
        k();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityPaused  activity:" + activity);
        if (f43414b.size() > 10) {
            k();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityResumed  activity:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (activity instanceof f) {
            return;
        }
        c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (activity instanceof f) {
            return;
        }
        e(activity);
    }

    public final Activity p(int i11) {
        CopyOnWriteArrayList copyOnWriteArrayList = f43414b;
        if (copyOnWriteArrayList.isEmpty()) {
            return null;
        }
        int size = copyOnWriteArrayList.size();
        int i12 = (size - 1) - i11;
        if (i12 < 0 || i12 >= size) {
            return null;
        }
        return (Activity) copyOnWriteArrayList.get(i12);
    }

    public final boolean q() {
        return f43416d == 0;
    }

    public final boolean r() {
        int i11 = f43418f;
        if (i11 == 1) {
            return true;
        }
        if (i11 != 2) {
            return q();
        }
        return false;
    }

    public final boolean s() {
        return com.transsion.baselib.report.launch.b.f43424a.b().getLong("record_latest_foreground_time", 0L) == 0;
    }

    public final void t(String str) {
        if (Intrinsics.c(str, "android.intent.action.SCREEN_OFF")) {
            if (f43418f == 0) {
                f43418f = System.currentTimeMillis() - f43417e >= 1000 ? q() : false ? 1 : 2;
            }
        } else if (Intrinsics.c(str, "android.intent.action.USER_PRESENT")) {
            f43418f = 0;
        }
    }

    public final boolean u(a listener) {
        Intrinsics.h(listener, "listener");
        return n().remove(listener);
    }

    public final void v() {
        f(this, null, 1, null);
    }

    public final boolean w() {
        String value;
        Long x10;
        Boolean bool = f43419g;
        if (bool != null) {
            return Intrinsics.c(bool, Boolean.TRUE);
        }
        long j11 = com.transsion.baselib.report.launch.b.f43424a.b().getLong("record_latest_foreground_time", 0L);
        ConfigBean c11 = sm.f.f75530c.a().c("pull_notification_deadline", true);
        long longValue = (c11 == null || (value = c11.getValue()) == null || (x10 = StringsKt.x(value)) == null) ? 0L : x10.longValue();
        long currentTimeMillis = (System.currentTimeMillis() - j11) / TimeConstants.DAY;
        a.C0856a.f(lg.a.f68962a, "Report", "latestForegroundTime=" + j11 + " sleepDays=" + currentTimeMillis + " notificationDeadlineDays=" + longValue, false, 4, null);
        Boolean valueOf = Boolean.valueOf(j11 > 0 && currentTimeMillis > longValue);
        f43419g = valueOf;
        return Intrinsics.c(valueOf, Boolean.TRUE);
    }

    public final void x(int i11, Activity activity) {
        Intrinsics.h(activity, "activity");
        try {
            CopyOnWriteArrayList copyOnWriteArrayList = f43414b;
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                if (Intrinsics.c(((Activity) obj).getClass(), activity.getClass())) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size() - i11;
            if (size <= 0) {
                return;
            }
            for (int i12 = 0; i12 < size; i12++) {
                ((Activity) arrayList.get(i12)).finish();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
