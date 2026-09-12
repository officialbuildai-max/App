package j9;

import android.net.Uri;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import g9.a0;
import g9.b0;
import g9.e0;
import g9.l;
import g9.m;
import g9.n;
import g9.q;
import g9.r;
import g9.s;
import g9.t;
import g9.u;
import g9.v;
import java.util.Map;

/* loaded from: classes4.dex */
public final class d implements l {

    /* renamed from: o, reason: collision with root package name */
    public static final r f66080o = new r() { // from class: j9.c
        @Override // g9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // g9.r
        public final l[] createExtractors() {
            l[] i11;
            i11 = d.i();
            return i11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f66081a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f66082b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f66083c;

    /* renamed from: d, reason: collision with root package name */
    private final s.a f66084d;

    /* renamed from: e, reason: collision with root package name */
    private n f66085e;

    /* renamed from: f, reason: collision with root package name */
    private e0 f66086f;

    /* renamed from: g, reason: collision with root package name */
    private int f66087g;

    /* renamed from: h, reason: collision with root package name */
    private Metadata f66088h;

    /* renamed from: i, reason: collision with root package name */
    private v f66089i;

    /* renamed from: j, reason: collision with root package name */
    private int f66090j;

    /* renamed from: k, reason: collision with root package name */
    private int f66091k;

    /* renamed from: l, reason: collision with root package name */
    private b f66092l;

    /* renamed from: m, reason: collision with root package name */
    private int f66093m;

    /* renamed from: n, reason: collision with root package name */
    private long f66094n;

    public d() {
        this(0);
    }

    public d(int i11) {
        this.f66081a = new byte[42];
        this.f66082b = new d0(new byte[32768], 0);
        this.f66083c = (i11 & 1) != 0;
        this.f66084d = new s.a();
        this.f66087g = 0;
    }

    private long e(d0 d0Var, boolean z10) {
        boolean z11;
        com.google.android.exoplayer2.util.a.e(this.f66089i);
        int e11 = d0Var.e();
        while (e11 <= d0Var.f() - 16) {
            d0Var.P(e11);
            if (s.d(d0Var, this.f66089i, this.f66091k, this.f66084d)) {
                d0Var.P(e11);
                return this.f66084d.f63578a;
            }
            e11++;
        }
        if (!z10) {
            d0Var.P(e11);
            return -1L;
        }
        while (e11 <= d0Var.f() - this.f66090j) {
            d0Var.P(e11);
            try {
                z11 = s.d(d0Var, this.f66089i, this.f66091k, this.f66084d);
            } catch (IndexOutOfBoundsException unused) {
                z11 = false;
            }
            if (d0Var.e() <= d0Var.f() ? z11 : false) {
                d0Var.P(e11);
                return this.f66084d.f63578a;
            }
            e11++;
        }
        d0Var.P(d0Var.f());
        return -1L;
    }

    private void f(m mVar) {
        this.f66091k = t.b(mVar);
        ((n) p0.j(this.f66085e)).d(g(mVar.getPosition(), mVar.getLength()));
        this.f66087g = 5;
    }

    private b0 g(long j11, long j12) {
        com.google.android.exoplayer2.util.a.e(this.f66089i);
        v vVar = this.f66089i;
        if (vVar.f63592k != null) {
            return new u(vVar, j11);
        }
        if (j12 == -1 || vVar.f63591j <= 0) {
            return new b0.b(vVar.f());
        }
        b bVar = new b(vVar, this.f66091k, j11, j12);
        this.f66092l = bVar;
        return bVar.b();
    }

    private void h(m mVar) {
        byte[] bArr = this.f66081a;
        mVar.peekFully(bArr, 0, bArr.length);
        mVar.resetPeekPosition();
        this.f66087g = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] i() {
        return new l[]{new d()};
    }

    private void j() {
        ((e0) p0.j(this.f66086f)).d((this.f66094n * 1000000) / ((v) p0.j(this.f66089i)).f63586e, 1, this.f66093m, 0, null);
    }

    private int k(m mVar, a0 a0Var) {
        boolean z10;
        com.google.android.exoplayer2.util.a.e(this.f66086f);
        com.google.android.exoplayer2.util.a.e(this.f66089i);
        b bVar = this.f66092l;
        if (bVar != null && bVar.d()) {
            return this.f66092l.c(mVar, a0Var);
        }
        if (this.f66094n == -1) {
            this.f66094n = s.i(mVar, this.f66089i);
            return 0;
        }
        int f11 = this.f66082b.f();
        if (f11 < 32768) {
            int read = mVar.read(this.f66082b.d(), f11, 32768 - f11);
            z10 = read == -1;
            if (!z10) {
                this.f66082b.O(f11 + read);
            } else if (this.f66082b.a() == 0) {
                j();
                return -1;
            }
        } else {
            z10 = false;
        }
        int e11 = this.f66082b.e();
        int i11 = this.f66093m;
        int i12 = this.f66090j;
        if (i11 < i12) {
            d0 d0Var = this.f66082b;
            d0Var.Q(Math.min(i12 - i11, d0Var.a()));
        }
        long e12 = e(this.f66082b, z10);
        int e13 = this.f66082b.e() - e11;
        this.f66082b.P(e11);
        this.f66086f.c(this.f66082b, e13);
        this.f66093m += e13;
        if (e12 != -1) {
            j();
            this.f66093m = 0;
            this.f66094n = e12;
        }
        if (this.f66082b.a() < 16) {
            int a11 = this.f66082b.a();
            System.arraycopy(this.f66082b.d(), this.f66082b.e(), this.f66082b.d(), 0, a11);
            this.f66082b.P(0);
            this.f66082b.O(a11);
        }
        return 0;
    }

    private void l(m mVar) {
        this.f66088h = t.d(mVar, !this.f66083c);
        this.f66087g = 1;
    }

    private void m(m mVar) {
        t.a aVar = new t.a(this.f66089i);
        boolean z10 = false;
        while (!z10) {
            z10 = t.e(mVar, aVar);
            this.f66089i = (v) p0.j(aVar.f63579a);
        }
        com.google.android.exoplayer2.util.a.e(this.f66089i);
        this.f66090j = Math.max(this.f66089i.f63584c, 6);
        ((e0) p0.j(this.f66086f)).e(this.f66089i.g(this.f66081a, this.f66088h));
        this.f66087g = 4;
    }

    private void n(m mVar) {
        t.i(mVar);
        this.f66087g = 3;
    }

    @Override // g9.l
    public void b(n nVar) {
        this.f66085e = nVar;
        this.f66086f = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // g9.l
    public int c(m mVar, a0 a0Var) {
        int i11 = this.f66087g;
        if (i11 == 0) {
            l(mVar);
            return 0;
        }
        if (i11 == 1) {
            h(mVar);
            return 0;
        }
        if (i11 == 2) {
            n(mVar);
            return 0;
        }
        if (i11 == 3) {
            m(mVar);
            return 0;
        }
        if (i11 == 4) {
            f(mVar);
            return 0;
        }
        if (i11 == 5) {
            return k(mVar, a0Var);
        }
        throw new IllegalStateException();
    }

    @Override // g9.l
    public boolean d(m mVar) {
        t.c(mVar, false);
        return t.a(mVar);
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f66087g = 0;
        } else {
            b bVar = this.f66092l;
            if (bVar != null) {
                bVar.h(j12);
            }
        }
        this.f66094n = j12 != 0 ? -1L : 0L;
        this.f66093m = 0;
        this.f66082b.L(0);
    }
}
