package com.transsion.baseui.util;

import android.os.SystemClock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static long f43562a;

    public static final void a(long j11, Function0 clickInvoke) {
        Intrinsics.h(clickInvoke, "clickInvoke");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f43562a > j11) {
            f43562a = elapsedRealtime;
            clickInvoke.invoke();
        }
    }

    public static /* synthetic */ void b(long j11, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = 600;
        }
        a(j11, function0);
    }
}
