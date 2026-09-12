package bw;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f17021a;

    /* renamed from: b, reason: collision with root package name */
    public static long f17022b;

    public static void a(String msg) {
        Intrinsics.h("UpgradeSdkManager", "tag");
        Intrinsics.h(msg, "msg");
        c();
        boolean z10 = yv.f.f79190o.a().f79195d;
    }

    public static void b(String tag, String msg) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(msg, "msg");
        c();
        boolean z10 = yv.f.f79190o.a().f79195d;
    }

    public static boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z10 = f17021a;
        if (z10 || currentTimeMillis - f17022b < 5000) {
            return z10;
        }
        f17022b = currentTimeMillis;
        if (Log.isLoggable("upgradeSdkLog", 3)) {
            f17021a = true;
        }
        return f17021a;
    }
}
