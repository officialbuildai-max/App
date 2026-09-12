package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final b f6461c;

    /* renamed from: d, reason: collision with root package name */
    private static final g f6462d;

    /* renamed from: a, reason: collision with root package name */
    private final float f6463a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6464b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0058a f6465a = new C0058a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final float f6466b = c(0.0f);

        /* renamed from: c, reason: collision with root package name */
        private static final float f6467c = c(0.5f);

        /* renamed from: d, reason: collision with root package name */
        private static final float f6468d = c(-1.0f);

        /* renamed from: e, reason: collision with root package name */
        private static final float f6469e = c(1.0f);

        /* renamed from: androidx.compose.ui.text.style.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0058a {
            private C0058a() {
            }

            public /* synthetic */ C0058a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final float a() {
                return a.f6467c;
            }

            public final float b() {
                return a.f6468d;
            }
        }

        public static float c(float f11) {
            if ((0.0f > f11 || f11 > 1.0f) && f11 != -1.0f) {
                throw new IllegalStateException("topRatio should be in [0..1] range or -1");
            }
            return f11;
        }

        public static final boolean d(float f11, float f12) {
            return Float.compare(f11, f12) == 0;
        }

        public static int e(float f11) {
            return Float.floatToIntBits(f11);
        }

        public static String f(float f11) {
            if (f11 == f6466b) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f11 == f6467c) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f11 == f6468d) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f11 == f6469e) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f11 + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a() {
            return g.f6462d;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6470a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f6471b = c(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f6472c = c(16);

        /* renamed from: d, reason: collision with root package name */
        private static final int f6473d = c(17);

        /* renamed from: e, reason: collision with root package name */
        private static final int f6474e = c(0);

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return c.f6473d;
            }

            public final int b() {
                return c.f6474e;
            }
        }

        private static int c(int i11) {
            return i11;
        }

        public static final boolean d(int i11, int i12) {
            return i11 == i12;
        }

        public static int e(int i11) {
            return i11;
        }

        public static final boolean f(int i11) {
            return (i11 & 1) > 0;
        }

        public static final boolean g(int i11) {
            return (i11 & 16) > 0;
        }

        public static String h(int i11) {
            return i11 == f6471b ? "LineHeightStyle.Trim.FirstLineTop" : i11 == f6472c ? "LineHeightStyle.Trim.LastLineBottom" : i11 == f6473d ? "LineHeightStyle.Trim.Both" : i11 == f6474e ? "LineHeightStyle.Trim.None" : "Invalid";
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f6461c = new b(defaultConstructorMarker);
        f6462d = new g(a.f6465a.b(), c.f6470a.a(), defaultConstructorMarker);
    }

    private g(float f11, int i11) {
        this.f6463a = f11;
        this.f6464b = i11;
    }

    public /* synthetic */ g(float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, i11);
    }

    public final float b() {
        return this.f6463a;
    }

    public final int c() {
        return this.f6464b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a.d(this.f6463a, gVar.f6463a) && c.d(this.f6464b, gVar.f6464b);
    }

    public int hashCode() {
        return (a.e(this.f6463a) * 31) + c.e(this.f6464b);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) a.f(this.f6463a)) + ", trim=" + ((Object) c.h(this.f6464b)) + ')';
    }
}
