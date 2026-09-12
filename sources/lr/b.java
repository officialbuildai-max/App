package lr;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final C0860b f69144e = new C0860b(null);

    /* renamed from: f, reason: collision with root package name */
    private static final b f69145f = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f69146a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f69147b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f69148c;

    /* renamed from: d, reason: collision with root package name */
    private final d f69149d;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        private boolean f69152c;

        /* renamed from: a, reason: collision with root package name */
        private boolean f69150a = true;

        /* renamed from: b, reason: collision with root package name */
        private boolean f69151b = true;

        /* renamed from: d, reason: collision with root package name */
        private d f69153d = new c();

        public final b a() {
            return new b(this, null);
        }

        public final boolean b() {
            return this.f69152c;
        }

        public final boolean c() {
            return this.f69150a;
        }

        public final boolean d() {
            return this.f69151b;
        }

        public final d e() {
            return this.f69153d;
        }
    }

    /* renamed from: lr.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0860b {
        private C0860b() {
        }

        public /* synthetic */ C0860b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return b.f69145f;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements d {
        @Override // lr.b.d
        public boolean a() {
            return d.a.c(this);
        }

        @Override // lr.b.d
        public boolean b() {
            return d.a.d(this);
        }

        @Override // lr.b.d
        public boolean c() {
            return d.a.b(this);
        }

        @Override // lr.b.d
        public int d() {
            return d.a.a(this);
        }
    }

    /* loaded from: classes7.dex */
    public interface d {

        /* loaded from: classes7.dex */
        public static final class a {
            public static int a(d dVar) {
                return 40;
            }

            public static boolean b(d dVar) {
                return false;
            }

            public static boolean c(d dVar) {
                return false;
            }

            public static boolean d(d dVar) {
                return false;
            }
        }

        boolean a();

        boolean b();

        boolean c();

        int d();
    }

    private b(a aVar) {
        this.f69146a = aVar.c();
        this.f69147b = aVar.d();
        this.f69148c = aVar.b();
        this.f69149d = aVar.e();
    }

    public /* synthetic */ b(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final boolean b() {
        return this.f69148c;
    }

    public final boolean c() {
        return this.f69146a;
    }

    public final d d() {
        return this.f69149d;
    }
}
