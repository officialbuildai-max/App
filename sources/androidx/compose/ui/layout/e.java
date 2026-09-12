package androidx.compose.ui.layout;

/* loaded from: classes.dex */
public interface e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5251a = a.f5252a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f5252a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final e f5253b = new C0051a();

        /* renamed from: c, reason: collision with root package name */
        private static final e f5254c = new C0052e();

        /* renamed from: d, reason: collision with root package name */
        private static final e f5255d = new c();

        /* renamed from: e, reason: collision with root package name */
        private static final e f5256e = new d();

        /* renamed from: f, reason: collision with root package name */
        private static final e f5257f = new f();

        /* renamed from: g, reason: collision with root package name */
        private static final g f5258g = new g(1.0f);

        /* renamed from: h, reason: collision with root package name */
        private static final e f5259h = new b();

        /* renamed from: androidx.compose.ui.layout.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0051a implements e {
            C0051a() {
            }

            @Override // androidx.compose.ui.layout.e
            public long a(long j11, long j12) {
                float f11;
                f11 = androidx.compose.ui.layout.f.f(j11, j12);
                return m0.a(f11, f11);
            }
        }

        /* loaded from: classes.dex */
        public static final class b implements e {
            b() {
            }

            @Override // androidx.compose.ui.layout.e
            public long a(long j11, long j12) {
                float h11;
                float e11;
                h11 = androidx.compose.ui.layout.f.h(j11, j12);
                e11 = androidx.compose.ui.layout.f.e(j11, j12);
                return m0.a(h11, e11);
            }
        }

        /* loaded from: classes.dex */
        public static final class c implements e {
            c() {
            }

            @Override // androidx.compose.ui.layout.e
            public long a(long j11, long j12) {
                float e11;
                e11 = androidx.compose.ui.layout.f.e(j11, j12);
                return m0.a(e11, e11);
            }
        }

        /* loaded from: classes.dex */
        public static final class d implements e {
            d() {
            }

            @Override // androidx.compose.ui.layout.e
            public long a(long j11, long j12) {
                float h11;
                h11 = androidx.compose.ui.layout.f.h(j11, j12);
                return m0.a(h11, h11);
            }
        }

        /* renamed from: androidx.compose.ui.layout.e$a$e, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0052e implements e {
            C0052e() {
            }

            @Override // androidx.compose.ui.layout.e
            public long a(long j11, long j12) {
                float g11;
                g11 = androidx.compose.ui.layout.f.g(j11, j12);
                return m0.a(g11, g11);
            }
        }

        /* loaded from: classes.dex */
        public static final class f implements e {
            f() {
            }

            @Override // androidx.compose.ui.layout.e
            public long a(long j11, long j12) {
                float g11;
                if (y.m.i(j11) <= y.m.i(j12) && y.m.g(j11) <= y.m.g(j12)) {
                    return m0.a(1.0f, 1.0f);
                }
                g11 = androidx.compose.ui.layout.f.g(j11, j12);
                return m0.a(g11, g11);
            }
        }

        private a() {
        }

        public final e a() {
            return f5254c;
        }

        public final e b() {
            return f5257f;
        }
    }

    long a(long j11, long j12);
}
