package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes7.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private OutputStream f71714a;

    /* renamed from: b, reason: collision with root package name */
    private int f71715b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f71716c;

    /* renamed from: d, reason: collision with root package name */
    private long f71717d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class a extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private boolean f71718a;

        private a() {
            this.f71718a = false;
            synchronized (m.this) {
                m.a(m.this);
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m.this.h(this);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            synchronized (m.this) {
                m.this.f();
                m.this.f71714a.flush();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i11) {
            synchronized (m.this) {
                m.this.f();
                m.this.f71714a.write(i11);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            synchronized (m.this) {
                m.this.f();
                m.this.f71714a.write(bArr);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i11, int i12) {
            synchronized (m.this) {
                m.this.f();
                m.this.f71714a.write(bArr, i11, i12);
            }
        }
    }

    public m(OutputStream outputStream, long j11) {
        if (outputStream == null) {
            throw new IllegalArgumentException("OutputStreamFunneler.<init>:  out == null");
        }
        this.f71714a = outputStream;
        this.f71716c = false;
        i(j11);
    }

    static /* synthetic */ int a(m mVar) {
        int i11 = mVar.f71715b + 1;
        mVar.f71715b = i11;
        return i11;
    }

    private synchronized void e() {
        try {
            f();
            this.f71714a.close();
        } finally {
            this.f71716c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (this.f71716c) {
            throw new IOException("The funneled OutputStream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(a aVar) {
        try {
            if (!aVar.f71718a) {
                try {
                    long j11 = this.f71717d;
                    if (j11 > 0) {
                        try {
                            wait(j11);
                        } catch (InterruptedException unused) {
                        }
                    }
                    int i11 = this.f71715b - 1;
                    this.f71715b = i11;
                    if (i11 == 0) {
                        e();
                    }
                    aVar.f71718a = true;
                } catch (Throwable th2) {
                    aVar.f71718a = true;
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public synchronized OutputStream g() {
        f();
        try {
        } finally {
            notifyAll();
        }
        return new a();
    }

    public synchronized void i(long j11) {
        this.f71717d = j11;
    }
}
