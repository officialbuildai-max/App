package g3;

import androidx.media3.common.util.a1;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import l2.m0;
import l2.n0;
import l2.s;
import l2.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    private final f f63392a;

    /* renamed from: b, reason: collision with root package name */
    private final long f63393b;

    /* renamed from: c, reason: collision with root package name */
    private final long f63394c;

    /* renamed from: d, reason: collision with root package name */
    private final i f63395d;

    /* renamed from: e, reason: collision with root package name */
    private int f63396e;

    /* renamed from: f, reason: collision with root package name */
    private long f63397f;

    /* renamed from: g, reason: collision with root package name */
    private long f63398g;

    /* renamed from: h, reason: collision with root package name */
    private long f63399h;

    /* renamed from: i, reason: collision with root package name */
    private long f63400i;

    /* renamed from: j, reason: collision with root package name */
    private long f63401j;

    /* renamed from: k, reason: collision with root package name */
    private long f63402k;

    /* renamed from: l, reason: collision with root package name */
    private long f63403l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b implements m0 {
        private b() {
        }

        @Override // l2.m0
        public long getDurationUs() {
            return a.this.f63395d.b(a.this.f63397f);
        }

        @Override // l2.m0
        public m0.a getSeekPoints(long j11) {
            return new m0.a(new n0(j11, a1.q((a.this.f63393b + BigInteger.valueOf(a.this.f63395d.c(j11)).multiply(BigInteger.valueOf(a.this.f63394c - a.this.f63393b)).divide(BigInteger.valueOf(a.this.f63397f)).longValue()) - 30000, a.this.f63393b, a.this.f63394c - 1)));
        }

        @Override // l2.m0
        public boolean isSeekable() {
            return true;
        }
    }

    public a(i iVar, long j11, long j12, long j13, long j14, boolean z10) {
        androidx.media3.common.util.a.a(j11 >= 0 && j12 > j11);
        this.f63395d = iVar;
        this.f63393b = j11;
        this.f63394c = j12;
        if (j13 == j12 - j11 || z10) {
            this.f63397f = j14;
            this.f63396e = 4;
        } else {
            this.f63396e = 0;
        }
        this.f63392a = new f();
    }

    private long g(s sVar) {
        if (this.f63400i == this.f63401j) {
            return -1L;
        }
        long position = sVar.getPosition();
        if (!this.f63392a.d(sVar, this.f63401j)) {
            long j11 = this.f63400i;
            if (j11 != position) {
                return j11;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f63392a.a(sVar, false);
        sVar.resetPeekPosition();
        long j12 = this.f63399h;
        f fVar = this.f63392a;
        long j13 = fVar.f63422c;
        long j14 = j12 - j13;
        int i11 = fVar.f63427h + fVar.f63428i;
        if (0 <= j14 && j14 < 72000) {
            return -1L;
        }
        if (j14 < 0) {
            this.f63401j = position;
            this.f63403l = j13;
        } else {
            this.f63400i = sVar.getPosition() + i11;
            this.f63402k = this.f63392a.f63422c;
        }
        long j15 = this.f63401j;
        long j16 = this.f63400i;
        if (j15 - j16 < 100000) {
            this.f63401j = j16;
            return j16;
        }
        long position2 = sVar.getPosition() - (i11 * (j14 <= 0 ? 2L : 1L));
        long j17 = this.f63401j;
        long j18 = this.f63400i;
        return a1.q(position2 + ((j14 * (j17 - j18)) / (this.f63403l - this.f63402k)), j18, j17 - 1);
    }

    private void i(s sVar) {
        while (true) {
            this.f63392a.c(sVar);
            this.f63392a.a(sVar, false);
            f fVar = this.f63392a;
            if (fVar.f63422c > this.f63399h) {
                sVar.resetPeekPosition();
                return;
            } else {
                sVar.skipFully(fVar.f63427h + fVar.f63428i);
                this.f63400i = sVar.getPosition();
                this.f63402k = this.f63392a.f63422c;
            }
        }
    }

    @Override // g3.g
    public long a(s sVar) {
        int i11 = this.f63396e;
        if (i11 == 0) {
            long position = sVar.getPosition();
            this.f63398g = position;
            this.f63396e = 1;
            long j11 = this.f63394c - 65307;
            if (j11 > position) {
                return j11;
            }
        } else if (i11 != 1) {
            if (i11 == 2) {
                long g11 = g(sVar);
                if (g11 != -1) {
                    return g11;
                }
                this.f63396e = 3;
            } else if (i11 != 3) {
                if (i11 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            i(sVar);
            this.f63396e = 4;
            return -(this.f63402k + 2);
        }
        this.f63397f = h(sVar);
        this.f63396e = 4;
        return this.f63398g;
    }

    @Override // g3.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b createSeekMap() {
        if (this.f63397f != 0) {
            return new b();
        }
        return null;
    }

    long h(s sVar) {
        this.f63392a.b();
        if (!this.f63392a.c(sVar)) {
            throw new EOFException();
        }
        this.f63392a.a(sVar, false);
        f fVar = this.f63392a;
        sVar.skipFully(fVar.f63427h + fVar.f63428i);
        long j11 = this.f63392a.f63422c;
        while (true) {
            f fVar2 = this.f63392a;
            if ((fVar2.f63421b & 4) == 4 || !fVar2.c(sVar) || sVar.getPosition() >= this.f63394c || !this.f63392a.a(sVar, true)) {
                break;
            }
            f fVar3 = this.f63392a;
            if (!u.e(sVar, fVar3.f63427h + fVar3.f63428i)) {
                break;
            }
            j11 = this.f63392a.f63422c;
        }
        return j11;
    }

    @Override // g3.g
    public void startSeek(long j11) {
        this.f63399h = a1.q(j11, 0L, this.f63397f - 1);
        this.f63396e = 2;
        this.f63400i = this.f63393b;
        this.f63401j = this.f63394c;
        this.f63402k = 0L;
        this.f63403l = this.f63397f;
    }
}
