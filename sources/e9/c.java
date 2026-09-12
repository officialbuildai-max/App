package e9;

import android.util.SparseArray;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.p3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.v1;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public interface c {

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f61738a;

        /* renamed from: b, reason: collision with root package name */
        public final k3 f61739b;

        /* renamed from: c, reason: collision with root package name */
        public final int f61740c;

        /* renamed from: d, reason: collision with root package name */
        public final o.b f61741d;

        /* renamed from: e, reason: collision with root package name */
        public final long f61742e;

        /* renamed from: f, reason: collision with root package name */
        public final k3 f61743f;

        /* renamed from: g, reason: collision with root package name */
        public final int f61744g;

        /* renamed from: h, reason: collision with root package name */
        public final o.b f61745h;

        /* renamed from: i, reason: collision with root package name */
        public final long f61746i;

        /* renamed from: j, reason: collision with root package name */
        public final long f61747j;

        public a(long j11, k3 k3Var, int i11, o.b bVar, long j12, k3 k3Var2, int i12, o.b bVar2, long j13, long j14) {
            this.f61738a = j11;
            this.f61739b = k3Var;
            this.f61740c = i11;
            this.f61741d = bVar;
            this.f61742e = j12;
            this.f61743f = k3Var2;
            this.f61744g = i12;
            this.f61745h = bVar2;
            this.f61746i = j13;
            this.f61747j = j14;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f61738a == aVar.f61738a && this.f61740c == aVar.f61740c && this.f61742e == aVar.f61742e && this.f61744g == aVar.f61744g && this.f61746i == aVar.f61746i && this.f61747j == aVar.f61747j && com.google.common.base.j.a(this.f61739b, aVar.f61739b) && com.google.common.base.j.a(this.f61741d, aVar.f61741d) && com.google.common.base.j.a(this.f61743f, aVar.f61743f) && com.google.common.base.j.a(this.f61745h, aVar.f61745h);
        }

        public int hashCode() {
            return com.google.common.base.j.b(Long.valueOf(this.f61738a), this.f61739b, Integer.valueOf(this.f61740c), this.f61741d, Long.valueOf(this.f61742e), this.f61743f, Integer.valueOf(this.f61744g), this.f61745h, Long.valueOf(this.f61746i), Long.valueOf(this.f61747j));
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.m f61748a;

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray f61749b;

        public b(com.google.android.exoplayer2.util.m mVar, SparseArray sparseArray) {
            this.f61748a = mVar;
            SparseArray sparseArray2 = new SparseArray(mVar.d());
            for (int i11 = 0; i11 < mVar.d(); i11++) {
                int c11 = mVar.c(i11);
                sparseArray2.append(c11, (a) com.google.android.exoplayer2.util.a.e((a) sparseArray.get(c11)));
            }
            this.f61749b = sparseArray2;
        }

        public boolean a(int i11) {
            return this.f61748a.a(i11);
        }

        public int b(int i11) {
            return this.f61748a.c(i11);
        }

        public a c(int i11) {
            return (a) com.google.android.exoplayer2.util.a.e((a) this.f61749b.get(i11));
        }

        public int d() {
            return this.f61748a.d();
        }
    }

    void A(a aVar, Object obj, long j11);

    void B(a aVar, com.google.android.exoplayer2.o1 o1Var, com.google.android.exoplayer2.decoder.g gVar);

    void C(a aVar, String str, long j11);

    void D(a aVar, int i11, com.google.android.exoplayer2.o1 o1Var);

    void E(a aVar);

    void F(a aVar, int i11, long j11, long j12);

    void G(a aVar, long j11, int i11);

    void H(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void I(o2 o2Var, b bVar);

    void J(a aVar);

    void K(a aVar, int i11);

    void L(a aVar);

    void M(a aVar, PlaybackException playbackException);

    void N(a aVar, int i11, com.google.android.exoplayer2.decoder.e eVar);

    void O(a aVar, boolean z10);

    void P(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void R(a aVar, int i11);

    void T(a aVar, float f11);

    void U(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void V(a aVar, p3 p3Var);

    void W(a aVar, int i11, long j11);

    void X(a aVar);

    void Y(a aVar, String str, long j11);

    void Z(a aVar, int i11, String str, long j11);

    void a(a aVar, String str);

    void a0(a aVar, int i11, long j11, long j12);

    void b(a aVar, boolean z10);

    void b0(a aVar, boolean z10);

    void c(a aVar, int i11);

    void c0(a aVar, boolean z10);

    void d(a aVar, t9.h hVar, t9.i iVar);

    void d0(a aVar, int i11, boolean z10);

    void e(a aVar, com.google.android.exoplayer2.o1 o1Var, com.google.android.exoplayer2.decoder.g gVar);

    void e0(a aVar, String str, long j11, long j12);

    void f(a aVar);

    void f0(a aVar);

    void g(a aVar, boolean z10, int i11);

    void g0(a aVar, int i11, com.google.android.exoplayer2.decoder.e eVar);

    void h(a aVar, a2 a2Var);

    void h0(a aVar);

    void i(a aVar, Metadata metadata);

    void i0(a aVar, int i11);

    void j(a aVar, Exception exc);

    void j0(a aVar, String str, long j11, long j12);

    void k(a aVar, o2.e eVar, o2.e eVar2, int i11);

    void k0(a aVar, List list);

    void l(a aVar, com.google.android.exoplayer2.r rVar);

    void l0(a aVar, boolean z10);

    void m(a aVar, int i11);

    void m0(a aVar, long j11);

    void n(a aVar, String str);

    void n0(a aVar, t9.i iVar);

    void o(a aVar, v1 v1Var, int i11);

    void o0(a aVar, com.google.android.exoplayer2.o1 o1Var);

    void p(a aVar, t9.h hVar, t9.i iVar);

    void p0(a aVar, TrackSelectionParameters trackSelectionParameters);

    void q0(a aVar, n2 n2Var);

    void r(a aVar, ba.f fVar);

    void r0(a aVar, Exception exc);

    void s(a aVar, o2.b bVar);

    void s0(a aVar, int i11);

    void t(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void t0(a aVar);

    void u(a aVar, t9.h hVar, t9.i iVar, IOException iOException, boolean z10);

    void u0(a aVar, int i11, int i12, int i13, float f11);

    void v(a aVar, Exception exc);

    void v0(a aVar, com.google.android.exoplayer2.video.y yVar);

    void w(a aVar, com.google.android.exoplayer2.o1 o1Var);

    void w0(a aVar, Exception exc);

    void x0(a aVar, int i11, int i12);

    void y(a aVar, boolean z10, int i11);

    void y0(a aVar, t9.h hVar, t9.i iVar);

    void z(a aVar, t9.i iVar);

    void z0(a aVar, PlaybackException playbackException);
}
