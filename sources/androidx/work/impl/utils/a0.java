package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.work.WorkManager;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16023a;

    static {
        String i11 = androidx.work.t.i("ProcessUtils");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f16023a = i11;
    }

    private static final String a(Context context) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f16022a.a();
        }
        try {
            Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD, false, WorkManager.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Intrinsics.e(invoke);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th2) {
            androidx.work.t.e().b(f16023a, "Unable to check ActivityThread for processName", th2);
        }
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        Iterator<T> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ActivityManager.RunningAppProcessInfo) obj).pid == myPid) {
                break;
            }
        }
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
        if (runningAppProcessInfo != null) {
            return runningAppProcessInfo.processName;
        }
        return null;
    }

    public static final boolean b(Context context, androidx.work.b configuration) {
        Intrinsics.h(context, "context");
        Intrinsics.h(configuration, "configuration");
        String a11 = a(context);
        String c11 = configuration.c();
        return (c11 == null || c11.length() == 0) ? Intrinsics.c(a11, context.getApplicationInfo().processName) : Intrinsics.c(a11, configuration.c());
    }
}
