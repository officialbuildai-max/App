package com.google.firebase.installations.remote;

import com.google.firebase.installations.h;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
class d {

    /* renamed from: d, reason: collision with root package name */
    private static final long f32000d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e, reason: collision with root package name */
    private static final long f32001e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a, reason: collision with root package name */
    private final h f32002a = h.c();

    /* renamed from: b, reason: collision with root package name */
    private long f32003b;

    /* renamed from: c, reason: collision with root package name */
    private int f32004c;

    private synchronized long a(int i11) {
        if (c(i11)) {
            return (long) Math.min(Math.pow(2.0d, this.f32004c) + this.f32002a.e(), f32001e);
        }
        return f32000d;
    }

    private static boolean c(int i11) {
        return i11 == 429 || (i11 >= 500 && i11 < 600);
    }

    private static boolean d(int i11) {
        return (i11 >= 200 && i11 < 300) || i11 == 401 || i11 == 404;
    }

    private synchronized void e() {
        this.f32004c = 0;
    }

    public synchronized boolean b() {
        boolean z10;
        if (this.f32004c != 0) {
            z10 = this.f32002a.a() > this.f32003b;
        }
        return z10;
    }

    public synchronized void f(int i11) {
        if (d(i11)) {
            e();
            return;
        }
        this.f32004c++;
        this.f32003b = this.f32002a.a() + a(i11);
    }
}
