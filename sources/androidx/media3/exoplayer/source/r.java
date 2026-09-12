package androidx.media3.exoplayer.source;

import android.os.Handler;
import i3.s;
import y1.f4;

/* loaded from: classes2.dex */
public interface r {

    /* loaded from: classes2.dex */
    public interface a {
        a a(s.a aVar);

        a b(int i11);

        a c(boolean z10);

        r d(androidx.media3.common.t tVar);

        a e(androidx.media3.exoplayer.drm.w wVar);

        a f(androidx.media3.exoplayer.upstream.m mVar);
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Object f12965a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12966b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12967c;

        /* renamed from: d, reason: collision with root package name */
        public final long f12968d;

        /* renamed from: e, reason: collision with root package name */
        public final int f12969e;

        public b(Object obj) {
            this(obj, -1L);
        }

        public b(Object obj, int i11, int i12, long j11) {
            this(obj, i11, i12, j11, -1);
        }

        private b(Object obj, int i11, int i12, long j11, int i13) {
            this.f12965a = obj;
            this.f12966b = i11;
            this.f12967c = i12;
            this.f12968d = j11;
            this.f12969e = i13;
        }

        public b(Object obj, long j11) {
            this(obj, -1, -1, j11, -1);
        }

        public b(Object obj, long j11, int i11) {
            this(obj, -1, -1, j11, i11);
        }

        public b a(Object obj) {
            return this.f12965a.equals(obj) ? this : new b(obj, this.f12966b, this.f12967c, this.f12968d, this.f12969e);
        }

        public boolean b() {
            return this.f12966b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12965a.equals(bVar.f12965a) && this.f12966b == bVar.f12966b && this.f12967c == bVar.f12967c && this.f12968d == bVar.f12968d && this.f12969e == bVar.f12969e;
        }

        public int hashCode() {
            return ((((((((527 + this.f12965a.hashCode()) * 31) + this.f12966b) * 31) + this.f12967c) * 31) + ((int) this.f12968d)) * 31) + this.f12969e;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(r rVar, androidx.media3.common.e0 e0Var);
    }

    androidx.media3.common.t a();

    boolean b();

    androidx.media3.common.e0 c();

    void d(Handler handler, s sVar);

    void e(s sVar);

    q g(b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11);

    void h(Handler handler, androidx.media3.exoplayer.drm.r rVar);

    void i(androidx.media3.exoplayer.drm.r rVar);

    void j(q qVar);

    void k(c cVar);

    void l(androidx.media3.common.t tVar);

    void m(c cVar, w1.n nVar, f4 f4Var);

    void maybeThrowSourceInfoRefreshError();

    void n(c cVar);

    void o(c cVar);

    boolean q(androidx.media3.common.t tVar);
}
