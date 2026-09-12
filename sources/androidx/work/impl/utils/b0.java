package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16026a;

    static {
        String i11 = androidx.work.t.i("WakeLocks");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f16026a = i11;
    }

    public static final PowerManager.WakeLock a(Context context, String tag) {
        Intrinsics.h(context, "context");
        Intrinsics.h(tag, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String str = "WorkManager: " + tag;
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, str);
        c0 c0Var = c0.f16030a;
        synchronized (c0Var) {
        }
        Intrinsics.e(newWakeLock);
        return newWakeLock;
    }
}
