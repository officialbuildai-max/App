package com.transsion.transfer.wifi.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f56087a = new c();

    private c() {
    }

    public final long a() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    public final String b() {
        return (((int) ((((((float) a()) / 1024.0f) / 1024.0f) / 1024.0f) * 10)) / 10.0f) + "GB";
    }

    public final String c(Context context) {
        Intrinsics.h(context, "context");
        return (((int) (((((float) d(context)) / 1024.0f) / 1024.0f) * 10)) / 10.0f) + "GB";
    }

    public final long d(Context context) {
        Intrinsics.h(context, "context");
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            long j11 = memoryInfo.totalMem;
            return j11 > 0 ? j11 / 1024 : j11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0L;
        }
    }

    public final boolean e() {
        String MODEL = Build.MODEL;
        Intrinsics.g(MODEL, "MODEL");
        Locale locale = Locale.getDefault();
        Intrinsics.g(locale, "getDefault(...)");
        String lowerCase = MODEL.toLowerCase(locale);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return StringsKt.W(lowerCase, "itel", false, 2, null) || StringsKt.W(lowerCase, "tecno", false, 2, null) || StringsKt.W(lowerCase, "infinix", false, 2, null) || StringsKt.W(lowerCase, "spice", false, 2, null);
    }
}
