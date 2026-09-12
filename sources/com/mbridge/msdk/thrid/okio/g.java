package com.mbridge.msdk.thrid.okio;

import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class g implements r {

    /* renamed from: a, reason: collision with root package name */
    private final r f38493a;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f38493a = rVar;
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public void a(c cVar, long j11) throws IOException {
        this.f38493a.a(cVar, j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public t b() {
        return this.f38493a.b();
    }

    @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38493a.close();
    }

    @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
    public void flush() throws IOException {
        this.f38493a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f38493a.toString() + ")";
    }
}
