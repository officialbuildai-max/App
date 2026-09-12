package com.cloud.sdk.commonutil.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference f23289a = new WeakReference(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f23290b = false;

    /* renamed from: c, reason: collision with root package name */
    private static b f23291c = null;

    /* loaded from: classes3.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            m.f23289a.clear();
            WeakReference unused = m.f23289a = new WeakReference(activity);
            try {
                if (m.f23291c == null || activity == null) {
                    return;
                }
                m.f23291c.a(activity.getClass().getSimpleName());
            } catch (Throwable unused2) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);
    }

    private static List d() {
        Object e11;
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            e11 = e();
        } catch (Exception e12) {
            c.Log().e("LifecycleUtil", "getActivitiesByReflect: " + e12.getMessage());
        }
        if (e11 == null) {
            return linkedList;
        }
        Field declaredField = e11.getClass().getDeclaredField("mActivities");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(e11);
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
                    linkedList.add(activity2);
                } else {
                    activity = activity2;
                }
            } else {
                linkedList.add(activity2);
            }
        }
        if (activity != null) {
            linkedList.addFirst(activity);
        }
        return linkedList;
    }

    private static Object e() {
        Object f11 = f();
        return f11 != null ? f11 : g();
    }

    private static Object f() {
        try {
            Field declaredField = Class.forName(ProcessUtils.ACTIVITY_THREAD).getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e11) {
            c.Log().e("LifecycleUtil", "getActivityThreadInActivityThreadStaticField: " + e11.getMessage());
            return null;
        }
    }

    private static Object g() {
        try {
            return Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, null).invoke(null, null);
        } catch (Exception e11) {
            c.Log().e("LifecycleUtil", "getActivityThreadInActivityThreadStaticMethod: " + e11.getMessage());
            return null;
        }
    }

    public static Activity h() {
        WeakReference weakReference = f23289a;
        Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
        if (i(activity)) {
            c.Log().i("LifecycleUtil", "topActivity = " + activity.getClass().getSimpleName());
            return activity;
        }
        c.Log().i("LifecycleUtil", "getActivitiesByReflect");
        for (Activity activity2 : d()) {
            if (i(activity2)) {
                c.Log().i("LifecycleUtil", "getActivitiesByReflect topActivity = " + activity2.getClass().getSimpleName());
                return activity2;
            }
        }
        c.Log().i("LifecycleUtil", "Did not get topActivity");
        return null;
    }

    private static boolean i(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static void j(Application application) {
        if (application == null || f23290b) {
            return;
        }
        f23290b = true;
        application.registerActivityLifecycleCallbacks(new a());
    }

    public static void k(b bVar) {
        f23291c = bVar;
    }
}
