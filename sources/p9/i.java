package p9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.a0;
import g9.b0;
import g9.e0;
import g9.m;
import g9.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: b, reason: collision with root package name */
    private e0 f72498b;

    /* renamed from: c, reason: collision with root package name */
    private n f72499c;

    /* renamed from: d, reason: collision with root package name */
    private g f72500d;

    /* renamed from: e, reason: collision with root package name */
    private long f72501e;

    /* renamed from: f, reason: collision with root package name */
    private long f72502f;

    /* renamed from: g, reason: collision with root package name */
    private long f72503g;

    /* renamed from: h, reason: collision with root package name */
    private int f72504h;

    /* renamed from: i, reason: collision with root package name */
    private int f72505i;

    /* renamed from: k, reason: collision with root package name */
    private long f72507k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f72508l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f72509m;

    /* renamed from: a, reason: collision with root package name */
    private final e f72497a = new e();

    /* renamed from: j, reason: collision with root package name */
    private b f72506j = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        o1 f72510a;

        /* renamed from: b, reason: collision with root package name */
        g f72511b;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c implements g {
        private c() {
        }

        @Override // p9.g
        public long a(m mVar) {
            return -1L;
        }

        @Override // p9.g
        public b0 createSeekMap() {
            return new b0.b(C.TIME_UNSET);
        }

        @Override // p9.g
        public void startSeek(long j11) {
        }
    }

    private void a() {
        com.google.android.exoplayer2.util.a.i(this.f72498b);
        p0.j(this.f72499c);
    }

    private boolean i(m mVar) {
        while (this.f72497a.d(mVar)) {
            this.f72507k = mVar.getPosition() - this.f72502f;
            if (!h(this.f72497a.c(), this.f72502f, this.f72506j)) {
                return true;
            }
            this.f72502f = mVar.getPosition();
        }
        this.f72504h = 3;
        return false;
    }

    private int j(m mVar) {
        if (!i(mVar)) {
            return -1;
        }
        o1 o1Var = this.f72506j.f72510a;
        this.f72505i = o1Var.f25564z;
        if (!this.f72509m) {
            this.f72498b.e(o1Var);
            this.f72509m = true;
        }
        g gVar = this.f72506j.f72511b;
        if (gVar != null) {
            this.f72500d = gVar;
        } else if (mVar.getLength() == -1) {
            this.f72500d = new c();
        } else {
            f b11 = this.f72497a.b();
            this.f72500d = new p9.a(this, this.f72502f, mVar.getLength(), b11.f72490h + b11.f72491i, b11.f72485c, (b11.f72484b & 4) != 0);
        }
        this.f72504h = 2;
        this.f72497a.f();
        return 0;
    }

    private int k(m mVar, a0 a0Var) {
        long a11 = this.f72500d.a(mVar);
        if (a11 >= 0) {
            a0Var.f63492a = a11;
            return 1;
        }
        if (a11 < -1) {
            e(-(a11 + 2));
        }
        if (!this.f72508l) {
            this.f72499c.d((b0) com.google.android.exoplayer2.util.a.i(this.f72500d.createSeekMap()));
            this.f72508l = true;
        }
        if (this.f72507k <= 0 && !this.f72497a.d(mVar)) {
            this.f72504h = 3;
            return -1;
        }
        this.f72507k = 0L;
        d0 c11 = this.f72497a.c();
        long f11 = f(c11);
        if (f11 >= 0) {
            long j11 = this.f72503g;
            if (j11 + f11 >= this.f72501e) {
                long b11 = b(j11);
                this.f72498b.c(c11, c11.f());
                this.f72498b.d(b11, 1, c11.f(), 0, null);
                this.f72501e = -1L;
            }
        }
        this.f72503g += f11;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b(long j11) {
        return (j11 * 1000000) / this.f72505i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long c(long j11) {
        return (this.f72505i * j11) / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(n nVar, e0 e0Var) {
        this.f72499c = nVar;
        this.f72498b = e0Var;
        l(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(long j11) {
        this.f72503g = j11;
    }

    protected abstract long f(d0 d0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int g(m mVar, a0 a0Var) {
        a();
        int i11 = this.f72504h;
        if (i11 == 0) {
            return j(mVar);
        }
        if (i11 == 1) {
            mVar.skipFully((int) this.f72502f);
            this.f72504h = 2;
            return 0;
        }
        if (i11 == 2) {
            p0.j(this.f72500d);
            return k(mVar, a0Var);
        }
        if (i11 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    protected abstract boolean h(d0 d0Var, long j11, b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(boolean z10) {
        if (z10) {
            this.f72506j = new b();
            this.f72502f = 0L;
            this.f72504h = 0;
        } else {
            this.f72504h = 1;
        }
        this.f72501e = -1L;
        this.f72503g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(long j11, long j12) {
        this.f72497a.e();
        if (j11 == 0) {
            l(!this.f72508l);
        } else if (this.f72504h != 0) {
            this.f72501e = c(j12);
            ((g) p0.j(this.f72500d)).startSeek(this.f72501e);
            this.f72504h = 2;
        }
    }
}
