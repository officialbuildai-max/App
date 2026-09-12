package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class f4 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4514b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4515c = g(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4516d = g(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f4517e = g(2);

    /* renamed from: f, reason: collision with root package name */
    private static final int f4518f = g(3);

    /* renamed from: g, reason: collision with root package name */
    private static final int f4519g = g(4);

    /* renamed from: a, reason: collision with root package name */
    private final int f4520a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return f4.f4516d;
        }

        public final int b() {
            return f4.f4515c;
        }

        public final int c() {
            return f4.f4518f;
        }

        public final int d() {
            return f4.f4519g;
        }

        public final int e() {
            return f4.f4517e;
        }
    }

    private /* synthetic */ f4(int i11) {
        this.f4520a = i11;
    }

    public static final /* synthetic */ f4 f(int i11) {
        return new f4(i11);
    }

    public static int g(int i11) {
        return i11;
    }

    public static boolean h(int i11, Object obj) {
        return (obj instanceof f4) && i11 == ((f4) obj).l();
    }

    public static final boolean i(int i11, int i12) {
        return i11 == i12;
    }

    public static int j(int i11) {
        return i11;
    }

    public static String k(int i11) {
        return i(i11, f4515c) ? "Argb8888" : i(i11, f4516d) ? "Alpha8" : i(i11, f4517e) ? "Rgb565" : i(i11, f4518f) ? "F16" : i(i11, f4519g) ? "Gpu" : "Unknown";
    }

    public boolean equals(Object obj) {
        return h(this.f4520a, obj);
    }

    public int hashCode() {
        return j(this.f4520a);
    }

    public final /* synthetic */ int l() {
        return this.f4520a;
    }

    public String toString() {
        return k(this.f4520a);
    }
}
