package androidx.media3.extractor.flv;

import android.net.Uri;
import androidx.media3.common.util.j0;
import androidx.media3.extractor.flv.b;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.List;
import java.util.Map;
import l2.l0;
import l2.m0;
import l2.q;
import l2.r;
import l2.t;
import l2.w;
import l2.x;

/* loaded from: classes2.dex */
public final class b implements r {

    /* renamed from: q, reason: collision with root package name */
    public static final x f13488q = new x() { // from class: r2.a
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
            r[] i11;
            i11 = b.i();
            return i11;
        }

        @Override // l2.x
        public /* synthetic */ x d(boolean z10) {
            return w.c(this, z10);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private t f13494f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13496h;

    /* renamed from: i, reason: collision with root package name */
    private long f13497i;

    /* renamed from: j, reason: collision with root package name */
    private int f13498j;

    /* renamed from: k, reason: collision with root package name */
    private int f13499k;

    /* renamed from: l, reason: collision with root package name */
    private int f13500l;

    /* renamed from: m, reason: collision with root package name */
    private long f13501m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13502n;

    /* renamed from: o, reason: collision with root package name */
    private a f13503o;

    /* renamed from: p, reason: collision with root package name */
    private d f13504p;

    /* renamed from: a, reason: collision with root package name */
    private final j0 f13489a = new j0(4);

    /* renamed from: b, reason: collision with root package name */
    private final j0 f13490b = new j0(9);

    /* renamed from: c, reason: collision with root package name */
    private final j0 f13491c = new j0(11);

    /* renamed from: d, reason: collision with root package name */
    private final j0 f13492d = new j0();

    /* renamed from: e, reason: collision with root package name */
    private final c f13493e = new c();

    /* renamed from: g, reason: collision with root package name */
    private int f13495g = 1;

    private void g() {
        if (this.f13502n) {
            return;
        }
        this.f13494f.f(new m0.b(C.TIME_UNSET));
        this.f13502n = true;
    }

    private long h() {
        if (this.f13496h) {
            return this.f13497i + this.f13501m;
        }
        if (this.f13493e.d() == C.TIME_UNSET) {
            return 0L;
        }
        return this.f13501m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r[] i() {
        return new r[]{new b()};
    }

    private j0 j(l2.s sVar) {
        if (this.f13500l > this.f13492d.b()) {
            j0 j0Var = this.f13492d;
            j0Var.U(new byte[Math.max(j0Var.b() * 2, this.f13500l)], 0);
        } else {
            this.f13492d.W(0);
        }
        this.f13492d.V(this.f13500l);
        sVar.readFully(this.f13492d.e(), 0, this.f13500l);
        return this.f13492d;
    }

    private boolean k(l2.s sVar) {
        if (!sVar.readFully(this.f13490b.e(), 0, 9, true)) {
            return false;
        }
        this.f13490b.W(0);
        this.f13490b.X(4);
        int H = this.f13490b.H();
        boolean z10 = (H & 4) != 0;
        boolean z11 = (H & 1) != 0;
        if (z10 && this.f13503o == null) {
            this.f13503o = new a(this.f13494f.track(8, 1));
        }
        if (z11 && this.f13504p == null) {
            this.f13504p = new d(this.f13494f.track(9, 2));
        }
        this.f13494f.endTracks();
        this.f13498j = this.f13490b.q() - 5;
        this.f13495g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean l(l2.s r10) {
        /*
            r9 = this;
            long r0 = r9.h()
            int r2 = r9.f13499k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            androidx.media3.extractor.flv.a r3 = r9.f13503o
            if (r3 == 0) goto L23
            r9.g()
            androidx.media3.extractor.flv.a r2 = r9.f13503o
            androidx.media3.common.util.j0 r10 = r9.j(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = r6
            goto L75
        L23:
            r3 = 9
            if (r2 != r3) goto L39
            androidx.media3.extractor.flv.d r3 = r9.f13504p
            if (r3 == 0) goto L39
            r9.g()
            androidx.media3.extractor.flv.d r2 = r9.f13504p
            androidx.media3.common.util.j0 r10 = r9.j(r10)
            boolean r10 = r2.a(r10, r0)
            goto L21
        L39:
            r3 = 18
            if (r2 != r3) goto L6e
            boolean r2 = r9.f13502n
            if (r2 != 0) goto L6e
            androidx.media3.extractor.flv.c r2 = r9.f13493e
            androidx.media3.common.util.j0 r10 = r9.j(r10)
            boolean r10 = r2.a(r10, r0)
            androidx.media3.extractor.flv.c r0 = r9.f13493e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            l2.t r2 = r9.f13494f
            l2.h0 r3 = new l2.h0
            androidx.media3.extractor.flv.c r7 = r9.f13493e
            long[] r7 = r7.e()
            androidx.media3.extractor.flv.c r8 = r9.f13493e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.f(r3)
            r9.f13502n = r6
            goto L21
        L6e:
            int r0 = r9.f13500l
            r10.skipFully(r0)
            r10 = 0
            r0 = r10
        L75:
            boolean r1 = r9.f13496h
            if (r1 != 0) goto L8f
            if (r10 == 0) goto L8f
            r9.f13496h = r6
            androidx.media3.extractor.flv.c r10 = r9.f13493e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L8b
            long r1 = r9.f13501m
            long r1 = -r1
            goto L8d
        L8b:
            r1 = 0
        L8d:
            r9.f13497i = r1
        L8f:
            r10 = 4
            r9.f13498j = r10
            r10 = 2
            r9.f13495g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.flv.b.l(l2.s):boolean");
    }

    private boolean m(l2.s sVar) {
        if (!sVar.readFully(this.f13491c.e(), 0, 11, true)) {
            return false;
        }
        this.f13491c.W(0);
        this.f13499k = this.f13491c.H();
        this.f13500l = this.f13491c.K();
        this.f13501m = this.f13491c.K();
        this.f13501m = ((this.f13491c.H() << 24) | this.f13501m) * 1000;
        this.f13491c.X(3);
        this.f13495g = 4;
        return true;
    }

    private void n(l2.s sVar) {
        sVar.skipFully(this.f13498j);
        this.f13498j = 0;
        this.f13495g = 3;
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f13494f = tVar;
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        androidx.media3.common.util.a.i(this.f13494f);
        while (true) {
            int i11 = this.f13495g;
            if (i11 != 1) {
                if (i11 == 2) {
                    n(sVar);
                } else if (i11 != 3) {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    if (l(sVar)) {
                        return 0;
                    }
                } else if (!m(sVar)) {
                    return -1;
                }
            } else if (!k(sVar)) {
                return -1;
            }
        }
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        sVar.peekFully(this.f13489a.e(), 0, 3);
        this.f13489a.W(0);
        if (this.f13489a.K() != 4607062) {
            return false;
        }
        sVar.peekFully(this.f13489a.e(), 0, 2);
        this.f13489a.W(0);
        if ((this.f13489a.P() & 250) != 0) {
            return false;
        }
        sVar.peekFully(this.f13489a.e(), 0, 4);
        this.f13489a.W(0);
        int q11 = this.f13489a.q();
        sVar.resetPeekPosition();
        sVar.advancePeekPosition(q11);
        sVar.peekFully(this.f13489a.e(), 0, 4);
        this.f13489a.W(0);
        return this.f13489a.q() == 0;
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
            this.f13495g = 1;
            this.f13496h = false;
        } else {
            this.f13495g = 3;
        }
        this.f13498j = 0;
    }
}
