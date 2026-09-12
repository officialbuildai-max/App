package androidx.compose.ui.semantics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6039b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6040c = i(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6041d = i(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f6042e = i(2);

    /* renamed from: f, reason: collision with root package name */
    private static final int f6043f = i(3);

    /* renamed from: g, reason: collision with root package name */
    private static final int f6044g = i(4);

    /* renamed from: h, reason: collision with root package name */
    private static final int f6045h = i(5);

    /* renamed from: i, reason: collision with root package name */
    private static final int f6046i = i(6);

    /* renamed from: a, reason: collision with root package name */
    private final int f6047a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return f.f6040c;
        }

        public final int b() {
            return f.f6041d;
        }

        public final int c() {
            return f.f6046i;
        }

        public final int d() {
            return f.f6045h;
        }

        public final int e() {
            return f.f6043f;
        }

        public final int f() {
            return f.f6042e;
        }

        public final int g() {
            return f.f6044g;
        }
    }

    private /* synthetic */ f(int i11) {
        this.f6047a = i11;
    }

    public static final /* synthetic */ f h(int i11) {
        return new f(i11);
    }

    private static int i(int i11) {
        return i11;
    }

    public static boolean j(int i11, Object obj) {
        return (obj instanceof f) && i11 == ((f) obj).n();
    }

    public static final boolean k(int i11, int i12) {
        return i11 == i12;
    }

    public static int l(int i11) {
        return i11;
    }

    public static String m(int i11) {
        return k(i11, f6040c) ? "Button" : k(i11, f6041d) ? "Checkbox" : k(i11, f6042e) ? "Switch" : k(i11, f6043f) ? "RadioButton" : k(i11, f6044g) ? "Tab" : k(i11, f6045h) ? "Image" : k(i11, f6046i) ? "DropdownList" : "Unknown";
    }

    public boolean equals(Object obj) {
        return j(this.f6047a, obj);
    }

    public int hashCode() {
        return l(this.f6047a);
    }

    public final /* synthetic */ int n() {
        return this.f6047a;
    }

    public String toString() {
        return m(this.f6047a);
    }
}
