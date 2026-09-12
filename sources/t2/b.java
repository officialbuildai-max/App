package t2;

import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.common.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import f3.n;
import i3.s;
import java.util.List;
import l2.l0;
import l2.m0;
import l2.q;
import l2.r;
import l2.s;
import l2.t;

/* loaded from: classes2.dex */
final class b implements r {

    /* renamed from: b, reason: collision with root package name */
    private t f76115b;

    /* renamed from: c, reason: collision with root package name */
    private int f76116c;

    /* renamed from: d, reason: collision with root package name */
    private int f76117d;

    /* renamed from: e, reason: collision with root package name */
    private int f76118e;

    /* renamed from: g, reason: collision with root package name */
    private a3.a f76120g;

    /* renamed from: h, reason: collision with root package name */
    private s f76121h;

    /* renamed from: i, reason: collision with root package name */
    private d f76122i;

    /* renamed from: j, reason: collision with root package name */
    private n f76123j;

    /* renamed from: a, reason: collision with root package name */
    private final j0 f76114a = new j0(6);

    /* renamed from: f, reason: collision with root package name */
    private long f76119f = -1;

    private void a(s sVar) {
        this.f76114a.S(2);
        sVar.peekFully(this.f76114a.e(), 0, 2);
        sVar.advancePeekPosition(this.f76114a.P() - 2);
    }

    private void g() {
        ((t) androidx.media3.common.util.a.e(this.f76115b)).endTracks();
        this.f76115b.f(new m0.b(C.TIME_UNSET));
        this.f76116c = 6;
    }

    private static a3.a h(String str, long j11) {
        c a11;
        if (j11 == -1 || (a11 = f.a(str)) == null) {
            return null;
        }
        return a11.a(j11);
    }

    private void i(a3.a aVar) {
        ((t) androidx.media3.common.util.a.e(this.f76115b)).track(1024, 4).c(new r.b().U("image/jpeg").n0(new x(aVar)).N());
    }

    private int j(s sVar) {
        this.f76114a.S(2);
        sVar.peekFully(this.f76114a.e(), 0, 2);
        return this.f76114a.P();
    }

    private void k(s sVar) {
        this.f76114a.S(2);
        sVar.readFully(this.f76114a.e(), 0, 2);
        int P = this.f76114a.P();
        this.f76117d = P;
        if (P == 65498) {
            if (this.f76119f != -1) {
                this.f76116c = 4;
                return;
            } else {
                g();
                return;
            }
        }
        if ((P < 65488 || P > 65497) && P != 65281) {
            this.f76116c = 1;
        }
    }

    private void l(s sVar) {
        String B;
        if (this.f76117d == 65505) {
            j0 j0Var = new j0(this.f76118e);
            sVar.readFully(j0Var.e(), 0, this.f76118e);
            if (this.f76120g == null && "http://ns.adobe.com/xap/1.0/".equals(j0Var.B()) && (B = j0Var.B()) != null) {
                a3.a h11 = h(B, sVar.getLength());
                this.f76120g = h11;
                if (h11 != null) {
                    this.f76119f = h11.f215d;
                }
            }
        } else {
            sVar.skipFully(this.f76118e);
        }
        this.f76116c = 0;
    }

    private void m(s sVar) {
        this.f76114a.S(2);
        sVar.readFully(this.f76114a.e(), 0, 2);
        this.f76118e = this.f76114a.P() - 2;
        this.f76116c = 2;
    }

    private void n(s sVar) {
        if (!sVar.peekFully(this.f76114a.e(), 0, 1, true)) {
            g();
            return;
        }
        sVar.resetPeekPosition();
        if (this.f76123j == null) {
            this.f76123j = new n(s.a.f65046a, 8);
        }
        d dVar = new d(sVar, this.f76119f);
        this.f76122i = dVar;
        if (!this.f76123j.d(dVar)) {
            g();
        } else {
            this.f76123j.b(new e(this.f76119f, (t) androidx.media3.common.util.a.e(this.f76115b)));
            o();
        }
    }

    private void o() {
        i((a3.a) androidx.media3.common.util.a.e(this.f76120g));
        this.f76116c = 5;
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f76115b = tVar;
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        int i11 = this.f76116c;
        if (i11 == 0) {
            k(sVar);
            return 0;
        }
        if (i11 == 1) {
            m(sVar);
            return 0;
        }
        if (i11 == 2) {
            l(sVar);
            return 0;
        }
        if (i11 == 4) {
            long position = sVar.getPosition();
            long j11 = this.f76119f;
            if (position != j11) {
                l0Var.f68743a = j11;
                return 1;
            }
            n(sVar);
            return 0;
        }
        if (i11 != 5) {
            if (i11 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f76122i == null || sVar != this.f76121h) {
            this.f76121h = sVar;
            this.f76122i = new d(sVar, this.f76119f);
        }
        int c11 = ((n) androidx.media3.common.util.a.e(this.f76123j)).c(this.f76122i, l0Var);
        if (c11 == 1) {
            l0Var.f68743a += this.f76119f;
        }
        return c11;
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        if (j(sVar) != 65496) {
            return false;
        }
        int j11 = j(sVar);
        this.f76117d = j11;
        if (j11 == 65504) {
            a(sVar);
            this.f76117d = j(sVar);
        }
        if (this.f76117d != 65505) {
            return false;
        }
        sVar.advancePeekPosition(2);
        this.f76114a.S(6);
        sVar.peekFully(this.f76114a.e(), 0, 6);
        return this.f76114a.J() == 1165519206 && this.f76114a.P() == 0;
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return q.a(this);
    }

    @Override // l2.r
    public void release() {
        n nVar = this.f76123j;
        if (nVar != null) {
            nVar.release();
        }
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f76116c = 0;
            this.f76123j = null;
        } else if (this.f76116c == 5) {
            ((n) androidx.media3.common.util.a.e(this.f76123j)).seek(j11, j12);
        }
    }
}
