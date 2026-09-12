package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ActivityRecreator {

    /* renamed from: a, reason: collision with root package name */
    protected static final Class f8008a;

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f8009b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f8010c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f8011d;

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f8012e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f8013f;

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f8014g = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        Object f8015a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f8016b;

        /* renamed from: c, reason: collision with root package name */
        private final int f8017c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f8018d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f8019e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f8020f = false;

        a(Activity activity) {
            this.f8016b = activity;
            this.f8017c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f8016b == activity) {
                this.f8016b = null;
                this.f8019e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f8019e || this.f8020f || this.f8018d || !ActivityRecreator.h(this.f8015a, this.f8017c, activity)) {
                return;
            }
            this.f8020f = true;
            this.f8015a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f8016b == activity) {
                this.f8018d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class a11 = a();
        f8008a = a11;
        f8009b = b();
        f8010c = f();
        f8011d = d(a11);
        f8012e = c(a11);
        f8013f = e(a11);
    }

    private static Class a() {
        try {
            return Class.forName(ProcessUtils.ACTIVITY_THREAD);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 == 26 || i11 == 27;
    }

    protected static boolean h(Object obj, int i11, Activity activity) {
        try {
            final Object obj2 = f8010c.get(activity);
            if (obj2 == obj && activity.hashCode() == i11) {
                final Object obj3 = f8009b.get(activity);
                f8014g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.ActivityRecreator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Method method = ActivityRecreator.f8011d;
                            if (method != null) {
                                method.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                            } else {
                                ActivityRecreator.f8012e.invoke(obj3, obj2, Boolean.FALSE);
                            }
                        } catch (RuntimeException e11) {
                            if (e11.getClass() == RuntimeException.class && e11.getMessage() != null && e11.getMessage().startsWith("Unable to stop")) {
                                throw e11;
                            }
                        } catch (Throwable th2) {
                            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f8013f == null) {
            return false;
        }
        if (f8012e == null && f8011d == null) {
            return false;
        }
        try {
            final Object obj2 = f8010c.get(activity);
            if (obj2 == null || (obj = f8009b.get(activity)) == null) {
                return false;
            }
            final Application application = activity.getApplication();
            final a aVar = new a(activity);
            application.registerActivityLifecycleCallbacks(aVar);
            Handler handler = f8014g;
            handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f8015a = obj2;
                }
            });
            try {
                if (g()) {
                    Method method = f8013f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                return true;
            } catch (Throwable th2) {
                f8014g.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                throw th2;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
