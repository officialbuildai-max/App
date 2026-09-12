package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6489b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6490c = h(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6491d = h(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f6492e = h(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f6493f = h(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f6494g = h(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f6495h = h(Integer.MIN_VALUE);

    /* renamed from: a, reason: collision with root package name */
    private final int f6496a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return j.f6492e;
        }

        public final int b() {
            return j.f6493f;
        }

        public final int c() {
            return j.f6494g;
        }

        public final int d() {
            return j.f6490c;
        }

        public final int e() {
            return j.f6491d;
        }

        public final int f() {
            return j.f6495h;
        }
    }

    private /* synthetic */ j(int i11) {
        this.f6496a = i11;
    }

    public static final /* synthetic */ j g(int i11) {
        return new j(i11);
    }

    public static int h(int i11) {
        return i11;
    }

    public static boolean i(int i11, Object obj) {
        return (obj instanceof j) && i11 == ((j) obj).m();
    }

    public static final boolean j(int i11, int i12) {
        return i11 == i12;
    }

    public static int k(int i11) {
        return i11;
    }

    public static String l(int i11) {
        return j(i11, f6490c) ? "Ltr" : j(i11, f6491d) ? "Rtl" : j(i11, f6492e) ? "Content" : j(i11, f6493f) ? "ContentOrLtr" : j(i11, f6494g) ? "ContentOrRtl" : j(i11, f6495h) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return i(this.f6496a, obj);
    }

    public int hashCode() {
        return k(this.f6496a);
    }

    public final /* synthetic */ int m() {
        return this.f6496a;
    }

    public String toString() {
        return l(this.f6496a);
    }
}
