package com.cloud.hisavana.protocol.okhttptransport;

import android.util.Pair;
import com.google.common.base.m;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.y;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class UploadBodyDataBroker implements Sink {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue f21539a = new ArrayBlockingQueue(1);

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f21540b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    private final AtomicReference f21541c = new AtomicReference();

    /* loaded from: classes3.dex */
    enum ReadResult {
        SUCCESS,
        END_OF_BODY
    }

    private Pair d() {
        try {
            return (Pair) this.f21539a.take();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while waiting for a read to finish!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Future b(ByteBuffer byteBuffer) {
        Throwable th2 = (Throwable) this.f21541c.get();
        if (th2 != null) {
            return Futures.e(th2);
        }
        y s11 = y.s();
        this.f21539a.add(Pair.create(byteBuffer, s11));
        Throwable th3 = (Throwable) this.f21541c.get();
        if (th3 != null) {
            s11.setException(th3);
        }
        return s11;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f21540b.set(true);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.f21540b.getAndSet(true)) {
            throw new IllegalStateException("Already closed");
        }
        ((y) d().second).set(ReadResult.END_OF_BODY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Throwable th2) {
        this.f21541c.set(th2);
        Pair pair = (Pair) this.f21539a.poll();
        if (pair != null) {
            ((y) pair.second).setException(th2);
        }
    }

    @Override // okio.Sink
    /* renamed from: timeout */
    public Timeout getTimeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j11) {
        m.u(!this.f21540b.get());
        while (j11 != 0) {
            Pair d11 = d();
            ByteBuffer byteBuffer = (ByteBuffer) d11.first;
            y yVar = (y) d11.second;
            int limit = byteBuffer.limit();
            byteBuffer.limit((int) Math.min(limit, j11));
            try {
                long read = buffer.read(byteBuffer);
                if (read == -1) {
                    IOException iOException = new IOException("The source has been exhausted but we expected more!");
                    yVar.setException(iOException);
                    throw iOException;
                }
                j11 -= read;
                byteBuffer.limit(limit);
                yVar.set(ReadResult.SUCCESS);
            } catch (IOException e11) {
                yVar.setException(e11);
                throw e11;
            }
        }
    }
}
