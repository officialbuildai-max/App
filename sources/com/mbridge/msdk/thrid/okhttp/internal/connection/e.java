package com.mbridge.msdk.thrid.okhttp.internal.connection;

import java.io.IOException;

/* loaded from: classes5.dex */
public final class e extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private IOException f38010a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f38011b;

    public e(IOException iOException) {
        super(iOException);
        this.f38010a = iOException;
        this.f38011b = iOException;
    }

    public IOException a() {
        return this.f38010a;
    }

    public void a(IOException iOException) {
        com.mbridge.msdk.thrid.okhttp.internal.c.a((Throwable) this.f38010a, (Throwable) iOException);
        this.f38011b = iOException;
    }

    public IOException b() {
        return this.f38011b;
    }
}
