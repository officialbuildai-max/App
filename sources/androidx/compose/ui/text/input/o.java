package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6315b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6316c = j(-1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6317d = j(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f6318e = j(0);

    /* renamed from: f, reason: collision with root package name */
    private static final int f6319f = j(2);

    /* renamed from: g, reason: collision with root package name */
    private static final int f6320g = j(3);

    /* renamed from: h, reason: collision with root package name */
    private static final int f6321h = j(4);

    /* renamed from: i, reason: collision with root package name */
    private static final int f6322i = j(5);

    /* renamed from: j, reason: collision with root package name */
    private static final int f6323j = j(6);

    /* renamed from: k, reason: collision with root package name */
    private static final int f6324k = j(7);

    /* renamed from: a, reason: collision with root package name */
    private final int f6325a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return o.f6317d;
        }

        public final int b() {
            return o.f6324k;
        }

        public final int c() {
            return o.f6319f;
        }

        public final int d() {
            return o.f6323j;
        }

        public final int e() {
            return o.f6318e;
        }

        public final int f() {
            return o.f6322i;
        }

        public final int g() {
            return o.f6320g;
        }

        public final int h() {
            return o.f6321h;
        }
    }

    private /* synthetic */ o(int i11) {
        this.f6325a = i11;
    }

    public static final /* synthetic */ o i(int i11) {
        return new o(i11);
    }

    private static int j(int i11) {
        return i11;
    }

    public static boolean k(int i11, Object obj) {
        return (obj instanceof o) && i11 == ((o) obj).o();
    }

    public static final boolean l(int i11, int i12) {
        return i11 == i12;
    }

    public static int m(int i11) {
        return i11;
    }

    public static String n(int i11) {
        return l(i11, f6316c) ? "Unspecified" : l(i11, f6318e) ? "None" : l(i11, f6317d) ? "Default" : l(i11, f6319f) ? "Go" : l(i11, f6320g) ? "Search" : l(i11, f6321h) ? "Send" : l(i11, f6322i) ? "Previous" : l(i11, f6323j) ? "Next" : l(i11, f6324k) ? "Done" : "Invalid";
    }

    public boolean equals(Object obj) {
        return k(this.f6325a, obj);
    }

    public int hashCode() {
        return m(this.f6325a);
    }

    public final /* synthetic */ int o() {
        return this.f6325a;
    }

    public String toString() {
        return n(this.f6325a);
    }
}
