package com.google.firebase.perf.session.gauges;

import android.app.ActivityManager;
import android.content.Context;
import com.google.firebase.perf.util.StorageUnit;

/* loaded from: classes4.dex */
class i {

    /* renamed from: e, reason: collision with root package name */
    private static final sc.a f32400e = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final Runtime f32401a;

    /* renamed from: b, reason: collision with root package name */
    private final ActivityManager f32402b;

    /* renamed from: c, reason: collision with root package name */
    private final ActivityManager.MemoryInfo f32403c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f32404d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this(Runtime.getRuntime(), context);
    }

    i(Runtime runtime, Context context) {
        this.f32401a = runtime;
        this.f32404d = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f32402b = activityManager;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.f32403c = memoryInfo;
        activityManager.getMemoryInfo(memoryInfo);
    }

    public int a() {
        return com.google.firebase.perf.util.k.c(StorageUnit.BYTES.toKilobytes(this.f32403c.totalMem));
    }

    public int b() {
        return com.google.firebase.perf.util.k.c(StorageUnit.BYTES.toKilobytes(this.f32401a.maxMemory()));
    }

    public int c() {
        return com.google.firebase.perf.util.k.c(StorageUnit.MEGABYTES.toKilobytes(this.f32402b.getMemoryClass()));
    }
}
