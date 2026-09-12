package g3;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.l0;
import l2.m0;
import l2.s;
import l2.s0;
import l2.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class i {

    /* renamed from: b, reason: collision with root package name */
    private s0 f63435b;

    /* renamed from: c, reason: collision with root package name */
    private t f63436c;

    /* renamed from: d, reason: collision with root package name */
    private g f63437d;

    /* renamed from: e, reason: collision with root package name */
    private long f63438e;

    /* renamed from: f, reason: collision with root package name */
    private long f63439f;

    /* renamed from: g, reason: collision with root package name */
    private long f63440g;

    /* renamed from: h, reason: collision with root package name */
    private int f63441h;

    /* renamed from: i, reason: collision with root package name */
    private int f63442i;

    /* renamed from: k, reason: collision with root package name */
    private long f63444k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f63445l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f63446m;

    /* renamed from: a, reason: collision with root package name */
    private final e f63434a = new e();

    /* renamed from: j, reason: collision with root package name */
    private b f63443j = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        r f63447a;

        /* renamed from: b, reason: collision with root package name */
        g f63448b;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c implements g {
        private c() {
        }

        @Override // g3.g
        public long a(s sVar) {
            return -1L;
        }

        @Override // g3.g
        public m0 createSeekMap() {
            return new m0.b(C.TIME_UNSET);
        }

        @Override // g3.g
        public void startSeek(long j11) {
        }
    }

    private void a() {
        androidx.media3.common.util.a.i(this.f63435b);
        a1.i(this.f63436c);
    }

    private boolean i(s sVar) {
        while (this.f63434a.d(sVar)) {
            this.f63444k = sVar.getPosition() - this.f63439f;
            if (!h(this.f63434a.c(), this.f63439f, this.f63443j)) {
                return true;
            }
            this.f63439f = sVar.getPosition();
        }
        this.f63441h = 3;
        return false;
    }

    private int j(s sVar) {
        if (!i(sVar)) {
            return -1;
        }
        r rVar = this.f63443j.f63447a;
        this.f63442i = rVar.F;
        if (!this.f63446m) {
            this.f63435b.c(rVar);
            this.f63446m = true;
        }
        g gVar = this.f63443j.f63448b;
        if (gVar != null) {
            this.f63437d = gVar;
        } else if (sVar.getLength() == -1) {
            this.f63437d = new c();
        } else {
            f b11 = this.f63434a.b();
            this.f63437d = new g3.a(this, this.f63439f, sVar.getLength(), b11.f63427h + b11.f63428i, b11.f63422c, (b11.f63421b & 4) != 0);
        }
        this.f63441h = 2;
        this.f63434a.f();
        return 0;
    }

    private int k(s sVar, l0 l0Var) {
        long a11 = this.f63437d.a(sVar);
        if (a11 >= 0) {
            l0Var.f68743a = a11;
            return 1;
        }
        if (a11 < -1) {
            e(-(a11 + 2));
        }
        if (!this.f63445l) {
            m0 m0Var = (m0) androidx.media3.common.util.a.i(this.f63437d.createSeekMap());
            this.f63436c.f(m0Var);
            this.f63435b.f(m0Var.getDurationUs());
            this.f63445l = true;
        }
        if (this.f63444k <= 0 && !this.f63434a.d(sVar)) {
            this.f63441h = 3;
            return -1;
        }
        this.f63444k = 0L;
        j0 c11 = this.f63434a.c();
        long f11 = f(c11);
        if (f11 >= 0) {
            long j11 = this.f63440g;
            if (j11 + f11 >= this.f63438e) {
                long b11 = b(j11);
                this.f63435b.b(c11, c11.g());
                this.f63435b.d(b11, 1, c11.g(), 0, null);
                this.f63438e = -1L;
            }
        }
        this.f63440g += f11;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b(long j11) {
        return (j11 * 1000000) / this.f63442i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long c(long j11) {
        return (this.f63442i * j11) / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(t tVar, s0 s0Var) {
        this.f63436c = tVar;
        this.f63435b = s0Var;
        l(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(long j11) {
        this.f63440g = j11;
    }

    protected abstract long f(j0 j0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int g(s sVar, l0 l0Var) {
        a();
        int i11 = this.f63441h;
        if (i11 == 0) {
            return j(sVar);
        }
        if (i11 == 1) {
            sVar.skipFully((int) this.f63439f);
            this.f63441h = 2;
            return 0;
        }
        if (i11 == 2) {
            a1.i(this.f63437d);
            return k(sVar, l0Var);
        }
        if (i11 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    protected abstract boolean h(j0 j0Var, long j11, b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(boolean z10) {
        if (z10) {
            this.f63443j = new b();
            this.f63439f = 0L;
            this.f63441h = 0;
        } else {
            this.f63441h = 1;
        }
        this.f63438e = -1L;
        this.f63440g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(long j11, long j12) {
        this.f63434a.e();
        if (j11 == 0) {
            l(!this.f63445l);
        } else if (this.f63441h != 0) {
            this.f63438e = c(j12);
            ((g) a1.i(this.f63437d)).startSeek(this.f63438e);
            this.f63441h = 2;
        }
    }
}
