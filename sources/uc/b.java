package uc;

import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public final class b extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final OutputStream f76843a;

    /* renamed from: b, reason: collision with root package name */
    private final Timer f76844b;

    /* renamed from: c, reason: collision with root package name */
    i f76845c;

    /* renamed from: d, reason: collision with root package name */
    long f76846d = -1;

    public b(OutputStream outputStream, i iVar, Timer timer) {
        this.f76843a = outputStream;
        this.f76845c = iVar;
        this.f76844b = timer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j11 = this.f76846d;
        if (j11 != -1) {
            this.f76845c.j(j11);
        }
        this.f76845c.n(this.f76844b.getDurationMicros());
        try {
            this.f76843a.close();
        } catch (IOException e11) {
            this.f76845c.o(this.f76844b.getDurationMicros());
            f.d(this.f76845c);
            throw e11;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            this.f76843a.flush();
        } catch (IOException e11) {
            this.f76845c.o(this.f76844b.getDurationMicros());
            f.d(this.f76845c);
            throw e11;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i11) {
        try {
            this.f76843a.write(i11);
            long j11 = this.f76846d + 1;
            this.f76846d = j11;
            this.f76845c.j(j11);
        } catch (IOException e11) {
            this.f76845c.o(this.f76844b.getDurationMicros());
            f.d(this.f76845c);
            throw e11;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        try {
            this.f76843a.write(bArr);
            long length = this.f76846d + bArr.length;
            this.f76846d = length;
            this.f76845c.j(length);
        } catch (IOException e11) {
            this.f76845c.o(this.f76844b.getDurationMicros());
            f.d(this.f76845c);
            throw e11;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) {
        try {
            this.f76843a.write(bArr, i11, i12);
            long j11 = this.f76846d + i12;
            this.f76846d = j11;
            this.f76845c.j(j11);
        } catch (IOException e11) {
            this.f76845c.o(this.f76844b.getDurationMicros());
            f.d(this.f76845c);
            throw e11;
        }
    }
}
