package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.r;

/* loaded from: classes2.dex */
public interface u2 {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final y1.f4 f13010a;

        /* renamed from: b, reason: collision with root package name */
        public final androidx.media3.common.e0 f13011b;

        /* renamed from: c, reason: collision with root package name */
        public final r.b f13012c;

        /* renamed from: d, reason: collision with root package name */
        public final long f13013d;

        /* renamed from: e, reason: collision with root package name */
        public final long f13014e;

        /* renamed from: f, reason: collision with root package name */
        public final float f13015f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f13016g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f13017h;

        /* renamed from: i, reason: collision with root package name */
        public final long f13018i;

        /* renamed from: j, reason: collision with root package name */
        public final long f13019j;

        public a(y1.f4 f4Var, androidx.media3.common.e0 e0Var, r.b bVar, long j11, long j12, float f11, boolean z10, boolean z11, long j13, long j14) {
            this.f13010a = f4Var;
            this.f13011b = e0Var;
            this.f13012c = bVar;
            this.f13013d = j11;
            this.f13014e = j12;
            this.f13015f = f11;
            this.f13016g = z10;
            this.f13017h = z11;
            this.f13018i = j13;
            this.f13019j = j14;
        }
    }

    boolean a(a aVar);

    void b(y1.f4 f4Var);

    void c(y1.f4 f4Var);

    void d(y1.f4 f4Var);

    boolean e(androidx.media3.common.e0 e0Var, r.b bVar, long j11);

    boolean f(a aVar);

    void g(a aVar, g2.z zVar, j2.z[] zVarArr);

    androidx.media3.exoplayer.upstream.b getAllocator();

    long h(y1.f4 f4Var);

    boolean i(y1.f4 f4Var);
}
