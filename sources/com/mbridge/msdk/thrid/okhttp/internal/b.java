package com.mbridge.msdk.thrid.okhttp.internal;

/* loaded from: classes5.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected final String f37954a;

    public b(String str, Object... objArr) {
        this.f37954a = c.a(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f37954a);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
