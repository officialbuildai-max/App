package y1;

import android.util.SparseArray;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.r;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public interface c {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f78733a;

        /* renamed from: b, reason: collision with root package name */
        public final androidx.media3.common.e0 f78734b;

        /* renamed from: c, reason: collision with root package name */
        public final int f78735c;

        /* renamed from: d, reason: collision with root package name */
        public final r.b f78736d;

        /* renamed from: e, reason: collision with root package name */
        public final long f78737e;

        /* renamed from: f, reason: collision with root package name */
        public final androidx.media3.common.e0 f78738f;

        /* renamed from: g, reason: collision with root package name */
        public final int f78739g;

        /* renamed from: h, reason: collision with root package name */
        public final r.b f78740h;

        /* renamed from: i, reason: collision with root package name */
        public final long f78741i;

        /* renamed from: j, reason: collision with root package name */
        public final long f78742j;

        public a(long j11, androidx.media3.common.e0 e0Var, int i11, r.b bVar, long j12, androidx.media3.common.e0 e0Var2, int i12, r.b bVar2, long j13, long j14) {
            this.f78733a = j11;
            this.f78734b = e0Var;
            this.f78735c = i11;
            this.f78736d = bVar;
            this.f78737e = j12;
            this.f78738f = e0Var2;
            this.f78739g = i12;
            this.f78740h = bVar2;
            this.f78741i = j13;
            this.f78742j = j14;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f78733a == aVar.f78733a && this.f78735c == aVar.f78735c && this.f78737e == aVar.f78737e && this.f78739g == aVar.f78739g && this.f78741i == aVar.f78741i && this.f78742j == aVar.f78742j && Objects.equals(this.f78734b, aVar.f78734b) && Objects.equals(this.f78736d, aVar.f78736d) && Objects.equals(this.f78738f, aVar.f78738f) && Objects.equals(this.f78740h, aVar.f78740h);
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f78733a), this.f78734b, Integer.valueOf(this.f78735c), this.f78736d, Long.valueOf(this.f78737e), this.f78738f, Integer.valueOf(this.f78739g), this.f78740h, Long.valueOf(this.f78741i), Long.valueOf(this.f78742j));
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.media3.common.p f78743a;

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray f78744b;

        public b(androidx.media3.common.p pVar, SparseArray sparseArray) {
            this.f78743a = pVar;
            SparseArray sparseArray2 = new SparseArray(pVar.d());
            for (int i11 = 0; i11 < pVar.d(); i11++) {
                int c11 = pVar.c(i11);
                sparseArray2.append(c11, (a) androidx.media3.common.util.a.e((a) sparseArray.get(c11)));
            }
            this.f78744b = sparseArray2;
        }

        public boolean a(int i11) {
            return this.f78743a.a(i11);
        }

        public int b(int i11) {
            return this.f78743a.c(i11);
        }

        public a c(int i11) {
            return (a) androidx.media3.common.util.a.e((a) this.f78744b.get(i11));
        }

        public int d() {
            return this.f78743a.d();
        }
    }

    void A(a aVar);

    void B(a aVar);

    void D(a aVar, PlaybackException playbackException);

    void E(a aVar, androidx.media3.exoplayer.j jVar);

    void F(a aVar, a0.e eVar, a0.e eVar2, int i11);

    void G(a aVar, Object obj, long j11);

    void I(a aVar, g2.i iVar, g2.j jVar);

    void J(a aVar, int i11, long j11, long j12);

    void K(a aVar, androidx.media3.exoplayer.j jVar);

    void L(a aVar, int i11);

    void M(a aVar, boolean z10);

    void N(a aVar, int i11, long j11, long j12);

    void O(a aVar, boolean z10, int i11);

    void P(a aVar, androidx.media3.common.z zVar);

    void Q(a aVar);

    void R(a aVar, String str, long j11, long j12);

    void S(a aVar, androidx.media3.common.m0 m0Var);

    void T(a aVar, long j11, int i11);

    void U(a aVar, int i11);

    void V(a aVar, int i11);

    void W(a aVar, String str, long j11);

    void X(a aVar, Exception exc);

    void Y(a aVar, AudioSink.a aVar2);

    void Z(a aVar, String str);

    void a(a aVar, androidx.media3.exoplayer.j jVar);

    void a0(a aVar, String str);

    void b(a aVar, float f11);

    void b0(a aVar, boolean z10, int i11);

    void c(a aVar, PlaybackException playbackException);

    void c0(a aVar, a0.b bVar);

    void d(a aVar, int i11);

    void d0(androidx.media3.common.a0 a0Var, b bVar);

    void e0(a aVar, boolean z10);

    void f(a aVar, int i11, int i12, boolean z10);

    void f0(a aVar, int i11, int i12, int i13, float f11);

    void g(a aVar, boolean z10);

    void g0(a aVar, androidx.media3.common.v vVar);

    void h(a aVar, int i11, long j11);

    void h0(a aVar, Exception exc);

    void i(a aVar, u1.b bVar);

    void i0(a aVar, androidx.media3.common.r rVar, androidx.media3.exoplayer.k kVar);

    void j(a aVar, g2.j jVar);

    void j0(a aVar, long j11);

    void k(a aVar);

    void k0(a aVar, g2.i iVar, g2.j jVar, int i11);

    void l0(a aVar, int i11);

    void m(a aVar, androidx.media3.common.x xVar);

    void m0(a aVar, boolean z10);

    void n(a aVar, boolean z10);

    void n0(a aVar, Exception exc);

    void o(a aVar, Exception exc);

    void o0(a aVar, androidx.media3.exoplayer.j jVar);

    void p(a aVar);

    void p0(a aVar, int i11, int i12);

    void q(a aVar, String str, long j11, long j12);

    void q0(a aVar);

    void r(a aVar, g2.i iVar, g2.j jVar);

    void r0(a aVar, List list);

    void s(a aVar, AudioSink.a aVar2);

    void s0(a aVar, int i11, boolean z10);

    void t(a aVar);

    void t0(a aVar, androidx.media3.common.t tVar, int i11);

    void u(a aVar, androidx.media3.common.m mVar);

    void u0(a aVar, androidx.media3.common.h0 h0Var);

    void v(a aVar, g2.i iVar, g2.j jVar, IOException iOException, boolean z10);

    void v0(a aVar, g2.j jVar);

    void w(a aVar, String str, long j11);

    void w0(a aVar, int i11);

    void x(a aVar, androidx.media3.common.r rVar, androidx.media3.exoplayer.k kVar);

    void x0(a aVar, g2.i iVar, g2.j jVar);

    void y(a aVar, androidx.media3.common.i0 i0Var);

    void z(a aVar, int i11);
}
