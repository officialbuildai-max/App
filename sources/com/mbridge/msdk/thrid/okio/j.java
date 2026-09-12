package com.mbridge.msdk.thrid.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes5.dex */
public final class j implements s {

    /* renamed from: b, reason: collision with root package name */
    private final e f38497b;

    /* renamed from: c, reason: collision with root package name */
    private final Inflater f38498c;

    /* renamed from: d, reason: collision with root package name */
    private final k f38499d;

    /* renamed from: a, reason: collision with root package name */
    private int f38496a = 0;

    /* renamed from: e, reason: collision with root package name */
    private final CRC32 f38500e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f38498c = inflater;
        e a11 = l.a(sVar);
        this.f38497b = a11;
        this.f38499d = new k(a11, inflater);
    }

    private void a(c cVar, long j11, long j12) {
        o oVar = cVar.f38485a;
        while (true) {
            long j13 = oVar.f38520c - oVar.f38519b;
            if (j11 < j13) {
                break;
            }
            j11 -= j13;
            oVar = oVar.f38523f;
        }
        while (j12 > 0) {
            int min = (int) Math.min(oVar.f38520c - r6, j12);
            this.f38500e.update(oVar.f38518a, (int) (oVar.f38519b + j11), min);
            j12 -= min;
            oVar = oVar.f38523f;
            j11 = 0;
        }
    }

    private void a(String str, int i11, int i12) throws IOException {
        if (i12 != i11) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i12), Integer.valueOf(i11)));
        }
    }

    private void d() throws IOException {
        this.f38497b.e(10L);
        byte f11 = this.f38497b.a().f(3L);
        boolean z10 = ((f11 >> 1) & 1) == 1;
        if (z10) {
            a(this.f38497b.a(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f38497b.readShort());
        this.f38497b.skip(8L);
        if (((f11 >> 2) & 1) == 1) {
            this.f38497b.e(2L);
            if (z10) {
                a(this.f38497b.a(), 0L, 2L);
            }
            long g11 = this.f38497b.a().g();
            this.f38497b.e(g11);
            if (z10) {
                a(this.f38497b.a(), 0L, g11);
            }
            this.f38497b.skip(g11);
        }
        if (((f11 >> 3) & 1) == 1) {
            long a11 = this.f38497b.a((byte) 0);
            if (a11 == -1) {
                throw new EOFException();
            }
            if (z10) {
                a(this.f38497b.a(), 0L, a11 + 1);
            }
            this.f38497b.skip(a11 + 1);
        }
        if (((f11 >> 4) & 1) == 1) {
            long a12 = this.f38497b.a((byte) 0);
            if (a12 == -1) {
                throw new EOFException();
            }
            if (z10) {
                a(this.f38497b.a(), 0L, a12 + 1);
            }
            this.f38497b.skip(a12 + 1);
        }
        if (z10) {
            a("FHCRC", this.f38497b.g(), (short) this.f38500e.getValue());
            this.f38500e.reset();
        }
    }

    private void h() throws IOException {
        a("CRC", this.f38497b.e(), (int) this.f38500e.getValue());
        a("ISIZE", this.f38497b.e(), (int) this.f38498c.getBytesWritten());
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public long b(c cVar, long j11) throws IOException {
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        if (j11 == 0) {
            return 0L;
        }
        if (this.f38496a == 0) {
            d();
            this.f38496a = 1;
        }
        if (this.f38496a == 1) {
            long j12 = cVar.f38486b;
            long b11 = this.f38499d.b(cVar, j11);
            if (b11 != -1) {
                a(cVar, j12, b11);
                return b11;
            }
            this.f38496a = 2;
        }
        if (this.f38496a == 2) {
            h();
            this.f38496a = 3;
            if (!this.f38497b.f()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public t b() {
        return this.f38497b.b();
    }

    @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38499d.close();
    }
}
