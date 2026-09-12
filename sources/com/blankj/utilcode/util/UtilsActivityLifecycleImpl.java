package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.view.Lifecycle;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class UtilsActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g, reason: collision with root package name */
    static final UtilsActivityLifecycleImpl f20156g = new UtilsActivityLifecycleImpl();

    /* renamed from: h, reason: collision with root package name */
    private static final Activity f20157h = new Activity();

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList f20158a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private final List f20159b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Map f20160c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private int f20161d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f20162e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20163f = false;

    /* renamed from: com.blankj.utilcode.util.UtilsActivityLifecycleImpl$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Activity val$activity;

        AnonymousClass2(Activity activity) {
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            UtilsActivityLifecycleImpl.this.f20160c.remove(this.val$activity);
        }
    }

    UtilsActivityLifecycleImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Activity activity, Utils.a aVar) {
        List list = (List) this.f20160c.get(activity);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.f20160c.put(activity, list);
        } else if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    private void g(Activity activity, Lifecycle.Event event) {
        h(activity, event, (List) this.f20160c.get(activity));
        h(activity, event, (List) this.f20160c.get(f20157h));
    }

    private void h(Activity activity, Lifecycle.Event event, List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Utils.a aVar = (Utils.a) it.next();
            aVar.g(activity, event);
            if (event.equals(Lifecycle.Event.ON_CREATE)) {
                aVar.a(activity);
            } else if (event.equals(Lifecycle.Event.ON_START)) {
                aVar.e(activity);
            } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                aVar.d(activity);
            } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                aVar.c(activity);
            } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                aVar.f(activity);
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                aVar.b(activity);
            }
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.f20160c.remove(activity);
        }
    }

    private List i() {
        Object k11;
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            k11 = k();
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e11.getMessage());
        }
        if (k11 == null) {
            return linkedList;
        }
        Field declaredField = k11.getClass().getDeclaredField("mActivities");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(k11);
        if (!(obj instanceof Map)) {
            return linkedList;
        }
        for (Object obj2 : ((Map) obj).values()) {
            Class<?> cls = obj2.getClass();
            Field declaredField2 = cls.getDeclaredField("activity");
            declaredField2.setAccessible(true);
            Activity activity2 = (Activity) declaredField2.get(obj2);
            if (activity == null) {
                Field declaredField3 = cls.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                if (declaredField3.getBoolean(obj2)) {
                    linkedList.addFirst(activity2);
                } else {
                    activity = activity2;
                }
            } else {
                linkedList.addFirst(activity2);
            }
        }
        if (activity != null) {
            linkedList.addFirst(activity);
        }
        return linkedList;
    }

    private Object k() {
        Object l11 = l();
        return l11 != null ? l11 : m();
    }

    private Object l() {
        try {
            Field declaredField = Class.forName(ProcessUtils.ACTIVITY_THREAD).getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e11.getMessage());
            return null;
        }
    }

    private Object m() {
        try {
            return Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, null).invoke(null, null);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e11.getMessage());
            return null;
        }
    }

    private void r(Activity activity, boolean z10) {
        if (this.f20159b.isEmpty()) {
            return;
        }
        Iterator it = this.f20159b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    private void s(final Activity activity, boolean z10) {
        try {
            if (z10) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } else {
                final Object tag = activity.getWindow().getDecorView().getTag(-123);
                if (!(tag instanceof Integer)) {
                } else {
                    e0.K(new Runnable() { // from class: com.blankj.utilcode.util.UtilsActivityLifecycleImpl.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Window window2 = activity.getWindow();
                                if (window2 != null) {
                                    window2.setSoftInputMode(((Integer) tag).intValue());
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }, 100L);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Activity activity, Utils.a aVar) {
        List list = (List) this.f20160c.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    private static void w() {
        boolean areAnimatorsEnabled;
        if (Build.VERSION.SDK_INT >= 26) {
            areAnimatorsEnabled = ValueAnimator.areAnimatorsEnabled();
            if (areAnimatorsEnabled) {
                return;
            }
        }
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                declaredField.set(null, Float.valueOf(1.0f));
            }
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
        } catch (NoSuchFieldException e12) {
            e12.printStackTrace();
        }
    }

    private void x(Activity activity) {
        if (!this.f20158a.contains(activity)) {
            this.f20158a.addFirst(activity);
        } else {
            if (((Activity) this.f20158a.getFirst()).equals(activity)) {
                return;
            }
            this.f20158a.remove(activity);
            this.f20158a.addFirst(activity);
        }
    }

    void d(final Activity activity, final Utils.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        e0.J(new Runnable() { // from class: com.blankj.utilcode.util.UtilsActivityLifecycleImpl.1
            @Override // java.lang.Runnable
            public void run() {
                UtilsActivityLifecycleImpl.this.f(activity, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Utils.a aVar) {
        d(f20157h, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List j() {
        if (!this.f20158a.isEmpty()) {
            return new LinkedList(this.f20158a);
        }
        this.f20158a.addAll(i());
        return new LinkedList(this.f20158a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Application n() {
        Object invoke;
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Object k11 = k();
            if (k11 == null || (invoke = cls.getMethod("getApplication", null).invoke(k11, null)) == null) {
                return null;
            }
            return (Application) invoke;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity o() {
        for (Activity activity : j()) {
            if (e0.w(activity)) {
                return activity;
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f20158a.size() == 0) {
            r(activity, true);
        }
        LanguageUtils.a(activity);
        w();
        x(activity);
        g(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.f20158a.remove(activity);
        e0.f(activity);
        g(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        g(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        x(activity);
        if (this.f20163f) {
            this.f20163f = false;
            r(activity, true);
        }
        s(activity, false);
        g(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (!this.f20163f) {
            x(activity);
        }
        int i11 = this.f20162e;
        if (i11 < 0) {
            this.f20162e = i11 + 1;
        } else {
            this.f20161d++;
        }
        g(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f20162e--;
        } else {
            int i11 = this.f20161d - 1;
            this.f20161d = i11;
            if (i11 <= 0) {
                this.f20163f = true;
                r(activity, false);
            }
        }
        s(activity, true);
        g(activity, Lifecycle.Event.ON_STOP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return !this.f20163f;
    }

    void t(final Activity activity, final Utils.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        e0.J(new Runnable() { // from class: com.blankj.utilcode.util.UtilsActivityLifecycleImpl.3
            @Override // java.lang.Runnable
            public void run() {
                UtilsActivityLifecycleImpl.this.v(activity, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(Utils.a aVar) {
        t(f20157h, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(Application application) {
        this.f20158a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }
}
