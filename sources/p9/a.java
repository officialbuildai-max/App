package p9;

import com.google.android.exoplayer2.util.p0;
import g9.b0;
import g9.c0;
import g9.m;
import g9.o;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    private final f f72455a;

    /* renamed from: b, reason: collision with root package name */
    private final long f72456b;

    /* renamed from: c, reason: collision with root package name */
    private final long f72457c;

    /* renamed from: d, reason: collision with root package name */
    private final i f72458d;

    /* renamed from: e, reason: collision with root package name */
    private int f72459e;

    /* renamed from: f, reason: collision with root package name */
    private long f72460f;

    /* renamed from: g, reason: collision with root package name */
    private long f72461g;

    /* renamed from: h, reason: collision with root package name */
    private long f72462h;

    /* renamed from: i, reason: collision with root package name */
    private long f72463i;

    /* renamed from: j, reason: collision with root package name */
    private long f72464j;

    /* renamed from: k, reason: collision with root package name */
    private long f72465k;

    /* renamed from: l, reason: collision with root package name */
    private long f72466l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class b implements b0 {
        private b() {
        }

        @Override // g9.b0
        public long getDurationUs() {
            return a.this.f72458d.b(a.this.f72460f);
        }

        @Override // g9.b0
        public b0.a getSeekPoints(long j11) {
            return new b0.a(new c0(j11, p0.r((a.this.f72456b + ((a.this.f72458d.c(j11) * (a.this.f72457c - a.this.f72456b)) / a.this.f72460f)) - 30000, a.this.f72456b, a.this.f72457c - 1)));
        }

        @Override // g9.b0
        public boolean isSeekable() {
            return true;
        }
    }

    public a(i iVar, long j11, long j12, long j13, long j14, boolean z10) {
        com.google.android.exoplayer2.util.a.a(j11 >= 0 && j12 > j11);
        this.f72458d = iVar;
        this.f72456b = j11;
        this.f72457c = j12;
        if (j13 == j12 - j11 || z10) {
            this.f72460f = j14;
            this.f72459e = 4;
        } else {
            this.f72459e = 0;
        }
        this.f72455a = new f();
    }

    private long g(m mVar) {
        if (this.f72463i == this.f72464j) {
            return -1L;
        }
        long position = mVar.getPosition();
        if (!this.f72455a.d(mVar, this.f72464j)) {
            long j11 = this.f72463i;
            if (j11 != position) {
                return j11;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f72455a.a(mVar, false);
        mVar.resetPeekPosition();
        long j12 = this.f72462h;
        f fVar = this.f72455a;
        long j13 = fVar.f72485c;
        long j14 = j12 - j13;
        int i11 = fVar.f72490h + fVar.f72491i;
        if (0 <= j14 && j14 < 72000) {
            return -1L;
        }
        if (j14 < 0) {
            this.f72464j = position;
            this.f72466l = j13;
        } else {
            this.f72463i = mVar.getPosition() + i11;
            this.f72465k = this.f72455a.f72485c;
        }
        long j15 = this.f72464j;
        long j16 = this.f72463i;
        if (j15 - j16 < 100000) {
            this.f72464j = j16;
            return j16;
        }
        long position2 = mVar.getPosition() - (i11 * (j14 <= 0 ? 2L : 1L));
        long j17 = this.f72464j;
        long j18 = this.f72463i;
        return p0.r(position2 + ((j14 * (j17 - j18)) / (this.f72466l - this.f72465k)), j18, j17 - 1);
    }

    private void i(m mVar) {
        while (true) {
            this.f72455a.c(mVar);
            this.f72455a.a(mVar, false);
            f fVar = this.f72455a;
            if (fVar.f72485c > this.f72462h) {
                mVar.resetPeekPosition();
                return;
            } else {
                mVar.skipFully(fVar.f72490h + fVar.f72491i);
                this.f72463i = mVar.getPosition();
                this.f72465k = this.f72455a.f72485c;
            }
        }
    }

    @Override // p9.g
    public long a(m mVar) {
        int i11 = this.f72459e;
        if (i11 == 0) {
            long position = mVar.getPosition();
            this.f72461g = position;
            this.f72459e = 1;
            long j11 = this.f72457c - 65307;
            if (j11 > position) {
                return j11;
            }
        } else if (i11 != 1) {
            if (i11 == 2) {
                long g11 = g(mVar);
                if (g11 != -1) {
                    return g11;
                }
                this.f72459e = 3;
            } else if (i11 != 3) {
                if (i11 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            i(mVar);
            this.f72459e = 4;
            return -(this.f72465k + 2);
        }
        this.f72460f = h(mVar);
        this.f72459e = 4;
        return this.f72461g;
    }

    @Override // p9.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b createSeekMap() {
        if (this.f72460f != 0) {
            return new b();
        }
        return null;
    }

    long h(m mVar) {
        this.f72455a.b();
        if (!this.f72455a.c(mVar)) {
            throw new EOFException();
        }
        this.f72455a.a(mVar, false);
        f fVar = this.f72455a;
        mVar.skipFully(fVar.f72490h + fVar.f72491i);
        long j11 = this.f72455a.f72485c;
        while (true) {
            f fVar2 = this.f72455a;
            if ((fVar2.f72484b & 4) == 4 || !fVar2.c(mVar) || mVar.getPosition() >= this.f72457c || !this.f72455a.a(mVar, true)) {
                break;
            }
            f fVar3 = this.f72455a;
            if (!o.e(mVar, fVar3.f72490h + fVar3.f72491i)) {
                break;
            }
            j11 = this.f72455a.f72485c;
        }
        return j11;
    }

    @Override // p9.g
    public void startSeek(long j11) {
        this.f72462h = p0.r(j11, 0L, this.f72460f - 1);
        this.f72459e = 2;
        this.f72463i = this.f72456b;
        this.f72464j = this.f72457c;
        this.f72465k = 0L;
        this.f72466l = this.f72460f;
    }
}
