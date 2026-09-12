package com.journeyapps.barcodescanner.camera;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class k {

    /* renamed from: e, reason: collision with root package name */
    private static k f34052e;

    /* renamed from: a, reason: collision with root package name */
    private Handler f34053a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f34054b;

    /* renamed from: c, reason: collision with root package name */
    private int f34055c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final Object f34056d = new Object();

    private k() {
    }

    private void a() {
        synchronized (this.f34056d) {
            try {
                if (this.f34053a == null) {
                    if (this.f34055c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f34054b = handlerThread;
                    handlerThread.start();
                    this.f34053a = new Handler(this.f34054b.getLooper());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static k d() {
        if (f34052e == null) {
            f34052e = new k();
        }
        return f34052e;
    }

    private void f() {
        synchronized (this.f34056d) {
            this.f34054b.quit();
            this.f34054b = null;
            this.f34053a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        synchronized (this.f34056d) {
            try {
                int i11 = this.f34055c - 1;
                this.f34055c = i11;
                if (i11 == 0) {
                    f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Runnable runnable) {
        synchronized (this.f34056d) {
            a();
            this.f34053a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Runnable runnable) {
        synchronized (this.f34056d) {
            this.f34055c++;
            c(runnable);
        }
    }
}
