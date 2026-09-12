package com.mbridge.msdk.thrid.okio;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes5.dex */
public final class k implements s {

    /* renamed from: a, reason: collision with root package name */
    private final e f38501a;

    /* renamed from: b, reason: collision with root package name */
    private final Inflater f38502b;

    /* renamed from: c, reason: collision with root package name */
    private int f38503c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f38504d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f38501a = eVar;
        this.f38502b = inflater;
    }

    private void h() throws IOException {
        int i11 = this.f38503c;
        if (i11 == 0) {
            return;
        }
        int remaining = i11 - this.f38502b.getRemaining();
        this.f38503c -= remaining;
        this.f38501a.skip(remaining);
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public long b(c cVar, long j11) throws IOException {
        boolean d11;
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        if (this.f38504d) {
            throw new IllegalStateException("closed");
        }
        if (j11 == 0) {
            return 0L;
        }
        do {
            d11 = d();
            try {
                o b11 = cVar.b(1);
                int inflate = this.f38502b.inflate(b11.f38518a, b11.f38520c, (int) Math.min(j11, 8192 - b11.f38520c));
                if (inflate > 0) {
                    b11.f38520c += inflate;
                    long j12 = inflate;
                    cVar.f38486b += j12;
                    return j12;
                }
                if (!this.f38502b.finished() && !this.f38502b.needsDictionary()) {
                }
                h();
                if (b11.f38519b != b11.f38520c) {
                    return -1L;
                }
                cVar.f38485a = b11.b();
                p.a(b11);
                return -1L;
            } catch (DataFormatException e11) {
                throw new IOException(e11);
            }
        } while (!d11);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public t b() {
        return this.f38501a.b();
    }

    @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f38504d) {
            return;
        }
        this.f38502b.end();
        this.f38504d = true;
        this.f38501a.close();
    }

    public final boolean d() throws IOException {
        if (!this.f38502b.needsInput()) {
            return false;
        }
        h();
        if (this.f38502b.getRemaining() != 0) {
            throw new IllegalStateException(UrlUtils.QUESTION_MARK);
        }
        if (this.f38501a.f()) {
            return true;
        }
        o oVar = this.f38501a.a().f38485a;
        int i11 = oVar.f38520c;
        int i12 = oVar.f38519b;
        int i13 = i11 - i12;
        this.f38503c = i13;
        this.f38502b.setInput(oVar.f38518a, i12, i13);
        return false;
    }
}
