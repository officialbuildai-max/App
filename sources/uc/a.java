package uc;

import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f76837a;

    /* renamed from: b, reason: collision with root package name */
    private final i f76838b;

    /* renamed from: c, reason: collision with root package name */
    private final Timer f76839c;

    /* renamed from: e, reason: collision with root package name */
    private long f76841e;

    /* renamed from: d, reason: collision with root package name */
    private long f76840d = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f76842f = -1;

    public a(InputStream inputStream, i iVar, Timer timer) {
        this.f76839c = timer;
        this.f76837a = inputStream;
        this.f76838b = iVar;
        this.f76841e = iVar.c();
    }

    @Override // java.io.InputStream
    public int available() {
        try {
            return this.f76837a.available();
        } catch (IOException e11) {
            this.f76838b.o(this.f76839c.getDurationMicros());
            f.d(this.f76838b);
            throw e11;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long durationMicros = this.f76839c.getDurationMicros();
        if (this.f76842f == -1) {
            this.f76842f = durationMicros;
        }
        try {
            this.f76837a.close();
            long j11 = this.f76840d;
            if (j11 != -1) {
                this.f76838b.m(j11);
            }
            long j12 = this.f76841e;
            if (j12 != -1) {
                this.f76838b.p(j12);
            }
            this.f76838b.o(this.f76842f);
            this.f76838b.a();
        } catch (IOException e11) {
            this.f76838b.o(this.f76839c.getDurationMicros());
            f.d(this.f76838b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i11) {
        this.f76837a.mark(i11);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f76837a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            int read = this.f76837a.read();
            long durationMicros = this.f76839c.getDurationMicros();
            if (this.f76841e == -1) {
                this.f76841e = durationMicros;
            }
            if (read == -1 && this.f76842f == -1) {
                this.f76842f = durationMicros;
                this.f76838b.o(durationMicros);
                this.f76838b.a();
            } else {
                long j11 = this.f76840d + 1;
                this.f76840d = j11;
                this.f76838b.m(j11);
            }
            return read;
        } catch (IOException e11) {
            this.f76838b.o(this.f76839c.getDurationMicros());
            f.d(this.f76838b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            int read = this.f76837a.read(bArr);
            long durationMicros = this.f76839c.getDurationMicros();
            if (this.f76841e == -1) {
                this.f76841e = durationMicros;
            }
            if (read == -1 && this.f76842f == -1) {
                this.f76842f = durationMicros;
                this.f76838b.o(durationMicros);
                this.f76838b.a();
            } else {
                long j11 = this.f76840d + read;
                this.f76840d = j11;
                this.f76838b.m(j11);
            }
            return read;
        } catch (IOException e11) {
            this.f76838b.o(this.f76839c.getDurationMicros());
            f.d(this.f76838b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        try {
            int read = this.f76837a.read(bArr, i11, i12);
            long durationMicros = this.f76839c.getDurationMicros();
            if (this.f76841e == -1) {
                this.f76841e = durationMicros;
            }
            if (read == -1 && this.f76842f == -1) {
                this.f76842f = durationMicros;
                this.f76838b.o(durationMicros);
                this.f76838b.a();
            } else {
                long j11 = this.f76840d + read;
                this.f76840d = j11;
                this.f76838b.m(j11);
            }
            return read;
        } catch (IOException e11) {
            this.f76838b.o(this.f76839c.getDurationMicros());
            f.d(this.f76838b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public void reset() {
        try {
            this.f76837a.reset();
        } catch (IOException e11) {
            this.f76838b.o(this.f76839c.getDurationMicros());
            f.d(this.f76838b);
            throw e11;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j11) {
        try {
            long skip = this.f76837a.skip(j11);
            long durationMicros = this.f76839c.getDurationMicros();
            if (this.f76841e == -1) {
                this.f76841e = durationMicros;
            }
            if (skip == -1 && this.f76842f == -1) {
                this.f76842f = durationMicros;
                this.f76838b.o(durationMicros);
            } else {
                long j12 = this.f76840d + skip;
                this.f76840d = j12;
                this.f76838b.m(j12);
            }
            return skip;
        } catch (IOException e11) {
            this.f76838b.o(this.f76839c.getDurationMicros());
            f.d(this.f76838b);
            throw e11;
        }
    }
}
