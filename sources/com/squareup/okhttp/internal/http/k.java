package com.squareup.okhttp.internal.http;

import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* loaded from: classes5.dex */
public final class k implements Sink {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40583a;

    /* renamed from: b, reason: collision with root package name */
    private final int f40584b;

    /* renamed from: c, reason: collision with root package name */
    private final Buffer f40585c;

    public k() {
        this(-1);
    }

    public k(int i11) {
        this.f40585c = new Buffer();
        this.f40584b = i11;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f40583a) {
            return;
        }
        this.f40583a = true;
        if (this.f40585c.size() >= this.f40584b) {
            return;
        }
        throw new ProtocolException("content-length promised " + this.f40584b + " bytes, but received " + this.f40585c.size());
    }

    public long d() {
        return this.f40585c.size();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    public void h(Sink sink) {
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.f40585c;
        buffer2.copyTo(buffer, 0L, buffer2.size());
        sink.write(buffer, buffer.size());
    }

    @Override // okio.Sink
    /* renamed from: timeout */
    public Timeout getThis$0() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j11) {
        if (this.f40583a) {
            throw new IllegalStateException("closed");
        }
        com.squareup.okhttp.internal.g.a(buffer.size(), 0L, j11);
        if (this.f40584b == -1 || this.f40585c.size() <= this.f40584b - j11) {
            this.f40585c.write(buffer, j11);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.f40584b + " bytes");
    }
}
