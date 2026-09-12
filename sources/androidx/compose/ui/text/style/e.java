package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6441a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f6442b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f6443c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f6444d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f6445e;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e.f6442b;
        }

        public final int b() {
            return e.f6445e;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6446a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f6447b = d(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f6448c = d(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f6449d = d(3);

        /* renamed from: e, reason: collision with root package name */
        private static final int f6450e = d(0);

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f6449d;
            }

            public final int b() {
                return b.f6448c;
            }

            public final int c() {
                return b.f6447b;
            }
        }

        public static int d(int i11) {
            return i11;
        }

        public static final boolean e(int i11, int i12) {
            return i11 == i12;
        }

        public static String f(int i11) {
            return e(i11, f6447b) ? "Strategy.Simple" : e(i11, f6448c) ? "Strategy.HighQuality" : e(i11, f6449d) ? "Strategy.Balanced" : e(i11, f6450e) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6451a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f6452b = e(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f6453c = e(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f6454d = e(3);

        /* renamed from: e, reason: collision with root package name */
        private static final int f6455e = e(4);

        /* renamed from: f, reason: collision with root package name */
        private static final int f6456f = e(0);

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return c.f6452b;
            }

            public final int b() {
                return c.f6453c;
            }

            public final int c() {
                return c.f6454d;
            }

            public final int d() {
                return c.f6455e;
            }
        }

        public static int e(int i11) {
            return i11;
        }

        public static final boolean f(int i11, int i12) {
            return i11 == i12;
        }

        public static String g(int i11) {
            return f(i11, f6452b) ? "Strictness.None" : f(i11, f6453c) ? "Strictness.Loose" : f(i11, f6454d) ? "Strictness.Normal" : f(i11, f6455e) ? "Strictness.Strict" : f(i11, f6456f) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6457a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f6458b = c(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f6459c = c(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f6460d = c(0);

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return d.f6458b;
            }

            public final int b() {
                return d.f6459c;
            }
        }

        public static int c(int i11) {
            return i11;
        }

        public static final boolean d(int i11, int i12) {
            return i11 == i12;
        }

        public static String e(int i11) {
            return d(i11, f6458b) ? "WordBreak.None" : d(i11, f6459c) ? "WordBreak.Phrase" : d(i11, f6460d) ? "WordBreak.Unspecified" : "Invalid";
        }
    }

    static {
        int e11;
        int e12;
        int e13;
        b.a aVar = b.f6446a;
        int c11 = aVar.c();
        c.a aVar2 = c.f6451a;
        int c12 = aVar2.c();
        d.a aVar3 = d.f6457a;
        e11 = f.e(c11, c12, aVar3.a());
        f6442b = c(e11);
        e12 = f.e(aVar.a(), aVar2.b(), aVar3.b());
        f6443c = c(e12);
        e13 = f.e(aVar.b(), aVar2.d(), aVar3.a());
        f6444d = c(e13);
        f6445e = c(0);
    }

    private static int c(int i11) {
        return i11;
    }

    public static final boolean d(int i11, int i12) {
        return i11 == i12;
    }

    public static final int e(int i11) {
        int f11;
        f11 = f.f(i11);
        return b.d(f11);
    }

    public static final int f(int i11) {
        int g11;
        g11 = f.g(i11);
        return c.e(g11);
    }

    public static final int g(int i11) {
        int h11;
        h11 = f.h(i11);
        return d.c(h11);
    }

    public static int h(int i11) {
        return i11;
    }

    public static String i(int i11) {
        return "LineBreak(strategy=" + ((Object) b.f(e(i11))) + ", strictness=" + ((Object) c.g(f(i11))) + ", wordBreak=" + ((Object) d.e(g(i11))) + ')';
    }
}
