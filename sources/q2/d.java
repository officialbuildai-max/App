package q2;

import android.net.Uri;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.util.List;
import java.util.Map;
import l2.a0;
import l2.b0;
import l2.l0;
import l2.m0;
import l2.q;
import l2.r;
import l2.s0;
import l2.t;
import l2.w;
import l2.x;
import l2.y;
import l2.z;

/* loaded from: classes2.dex */
public final class d implements r {

    /* renamed from: o, reason: collision with root package name */
    public static final x f73180o = new x() { // from class: q2.c
        @Override // l2.x
        public /* synthetic */ x a(s.a aVar) {
            return w.d(this, aVar);
        }

        @Override // l2.x
        public /* synthetic */ x b(int i11) {
            return w.b(this, i11);
        }

        @Override // l2.x
        public /* synthetic */ r[] c(Uri uri, Map map) {
            return w.a(this, uri, map);
        }

        @Override // l2.x
        public final r[] createExtractors() {
            r[] k11;
            k11 = d.k();
            return k11;
        }

        @Override // l2.x
        public /* synthetic */ x d(boolean z10) {
            return w.c(this, z10);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f73181a;

    /* renamed from: b, reason: collision with root package name */
    private final j0 f73182b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f73183c;

    /* renamed from: d, reason: collision with root package name */
    private final y.a f73184d;

    /* renamed from: e, reason: collision with root package name */
    private t f73185e;

    /* renamed from: f, reason: collision with root package name */
    private s0 f73186f;

    /* renamed from: g, reason: collision with root package name */
    private int f73187g;

    /* renamed from: h, reason: collision with root package name */
    private androidx.media3.common.x f73188h;

    /* renamed from: i, reason: collision with root package name */
    private b0 f73189i;

    /* renamed from: j, reason: collision with root package name */
    private int f73190j;

    /* renamed from: k, reason: collision with root package name */
    private int f73191k;

    /* renamed from: l, reason: collision with root package name */
    private b f73192l;

    /* renamed from: m, reason: collision with root package name */
    private int f73193m;

    /* renamed from: n, reason: collision with root package name */
    private long f73194n;

    public d() {
        this(0);
    }

    public d(int i11) {
        this.f73181a = new byte[42];
        this.f73182b = new j0(new byte[32768], 0);
        this.f73183c = (i11 & 1) != 0;
        this.f73184d = new y.a();
        this.f73187g = 0;
    }

    private long g(j0 j0Var, boolean z10) {
        boolean z11;
        androidx.media3.common.util.a.e(this.f73189i);
        int f11 = j0Var.f();
        while (f11 <= j0Var.g() - 16) {
            j0Var.W(f11);
            if (y.d(j0Var, this.f73189i, this.f73191k, this.f73184d)) {
                j0Var.W(f11);
                return this.f73184d.f68836a;
            }
            f11++;
        }
        if (!z10) {
            j0Var.W(f11);
            return -1L;
        }
        while (f11 <= j0Var.g() - this.f73190j) {
            j0Var.W(f11);
            try {
                z11 = y.d(j0Var, this.f73189i, this.f73191k, this.f73184d);
            } catch (IndexOutOfBoundsException unused) {
                z11 = false;
            }
            if (j0Var.f() <= j0Var.g() ? z11 : false) {
                j0Var.W(f11);
                return this.f73184d.f68836a;
            }
            f11++;
        }
        j0Var.W(j0Var.g());
        return -1L;
    }

    private void h(l2.s sVar) {
        this.f73191k = z.b(sVar);
        ((t) a1.i(this.f73185e)).f(i(sVar.getPosition(), sVar.getLength()));
        this.f73187g = 5;
    }

    private m0 i(long j11, long j12) {
        androidx.media3.common.util.a.e(this.f73189i);
        b0 b0Var = this.f73189i;
        if (b0Var.f68634k != null) {
            return new a0(b0Var, j11);
        }
        if (j12 == -1 || b0Var.f68633j <= 0) {
            return new m0.b(b0Var.f());
        }
        b bVar = new b(b0Var, this.f73191k, j11, j12);
        this.f73192l = bVar;
        return bVar.b();
    }

    private void j(l2.s sVar) {
        byte[] bArr = this.f73181a;
        sVar.peekFully(bArr, 0, bArr.length);
        sVar.resetPeekPosition();
        this.f73187g = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r[] k() {
        return new r[]{new d()};
    }

    private void l() {
        ((s0) a1.i(this.f73186f)).d((this.f73194n * 1000000) / ((b0) a1.i(this.f73189i)).f68628e, 1, this.f73193m, 0, null);
    }

    private int m(l2.s sVar, l0 l0Var) {
        boolean z10;
        androidx.media3.common.util.a.e(this.f73186f);
        androidx.media3.common.util.a.e(this.f73189i);
        b bVar = this.f73192l;
        if (bVar != null && bVar.d()) {
            return this.f73192l.c(sVar, l0Var);
        }
        if (this.f73194n == -1) {
            this.f73194n = y.i(sVar, this.f73189i);
            return 0;
        }
        int g11 = this.f73182b.g();
        if (g11 < 32768) {
            int read = sVar.read(this.f73182b.e(), g11, 32768 - g11);
            z10 = read == -1;
            if (!z10) {
                this.f73182b.V(g11 + read);
            } else if (this.f73182b.a() == 0) {
                l();
                return -1;
            }
        } else {
            z10 = false;
        }
        int f11 = this.f73182b.f();
        int i11 = this.f73193m;
        int i12 = this.f73190j;
        if (i11 < i12) {
            j0 j0Var = this.f73182b;
            j0Var.X(Math.min(i12 - i11, j0Var.a()));
        }
        long g12 = g(this.f73182b, z10);
        int f12 = this.f73182b.f() - f11;
        this.f73182b.W(f11);
        this.f73186f.b(this.f73182b, f12);
        this.f73193m += f12;
        if (g12 != -1) {
            l();
            this.f73193m = 0;
            this.f73194n = g12;
        }
        int length = this.f73182b.e().length - this.f73182b.g();
        if (this.f73182b.a() < 16 && length < 16) {
            int a11 = this.f73182b.a();
            System.arraycopy(this.f73182b.e(), this.f73182b.f(), this.f73182b.e(), 0, a11);
            this.f73182b.W(0);
            this.f73182b.V(a11);
        }
        return 0;
    }

    private void n(l2.s sVar) {
        this.f73188h = z.d(sVar, !this.f73183c);
        this.f73187g = 1;
    }

    private void o(l2.s sVar) {
        z.a aVar = new z.a(this.f73189i);
        boolean z10 = false;
        while (!z10) {
            z10 = z.e(sVar, aVar);
            this.f73189i = (b0) a1.i(aVar.f68837a);
        }
        androidx.media3.common.util.a.e(this.f73189i);
        this.f73190j = Math.max(this.f73189i.f68626c, 6);
        ((s0) a1.i(this.f73186f)).c(this.f73189i.g(this.f73181a, this.f73188h).b().U(MimeTypes.AUDIO_FLAC).N());
        ((s0) a1.i(this.f73186f)).f(this.f73189i.f());
        this.f73187g = 4;
    }

    private void p(l2.s sVar) {
        z.i(sVar);
        this.f73187g = 3;
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f73185e = tVar;
        this.f73186f = tVar.track(0, 1);
        tVar.endTracks();
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        int i11 = this.f73187g;
        if (i11 == 0) {
            n(sVar);
            return 0;
        }
        if (i11 == 1) {
            j(sVar);
            return 0;
        }
        if (i11 == 2) {
            p(sVar);
            return 0;
        }
        if (i11 == 3) {
            o(sVar);
            return 0;
        }
        if (i11 == 4) {
            h(sVar);
            return 0;
        }
        if (i11 == 5) {
            return m(sVar, l0Var);
        }
        throw new IllegalStateException();
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        z.c(sVar, false);
        return z.a(sVar);
    }

    @Override // l2.r
    public /* synthetic */ r e() {
        return q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f73187g = 0;
        } else {
            b bVar = this.f73192l;
            if (bVar != null) {
                bVar.h(j12);
            }
        }
        this.f73194n = j12 != 0 ? -1L : 0L;
        this.f73193m = 0;
        this.f73182b.S(0);
    }
}
