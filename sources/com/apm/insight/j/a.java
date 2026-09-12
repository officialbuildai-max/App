package com.apm.insight.j;

import android.os.Handler;

/* loaded from: classes2.dex */
public abstract class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Handler f19648a;

    /* renamed from: b, reason: collision with root package name */
    private final long f19649b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final long f19650c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Handler handler, long j11) {
        this.f19648a = handler;
        this.f19650c = j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f19648a.post(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j11) {
        if (j11 > 0) {
            this.f19648a.postDelayed(this, j11);
        } else {
            this.f19648a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long b() {
        return this.f19650c;
    }
}
