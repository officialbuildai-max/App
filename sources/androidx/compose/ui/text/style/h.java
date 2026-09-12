package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6475b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6476c = i(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6477d = i(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f6478e = i(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f6479f = i(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f6480g = i(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f6481h = i(6);

    /* renamed from: i, reason: collision with root package name */
    private static final int f6482i = i(Integer.MIN_VALUE);

    /* renamed from: a, reason: collision with root package name */
    private final int f6483a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return h.f6478e;
        }

        public final int b() {
            return h.f6481h;
        }

        public final int c() {
            return h.f6479f;
        }

        public final int d() {
            return h.f6476c;
        }

        public final int e() {
            return h.f6477d;
        }

        public final int f() {
            return h.f6480g;
        }

        public final int g() {
            return h.f6482i;
        }
    }

    private /* synthetic */ h(int i11) {
        this.f6483a = i11;
    }

    public static final /* synthetic */ h h(int i11) {
        return new h(i11);
    }

    public static int i(int i11) {
        return i11;
    }

    public static boolean j(int i11, Object obj) {
        return (obj instanceof h) && i11 == ((h) obj).n();
    }

    public static final boolean k(int i11, int i12) {
        return i11 == i12;
    }

    public static int l(int i11) {
        return i11;
    }

    public static String m(int i11) {
        return k(i11, f6476c) ? "Left" : k(i11, f6477d) ? "Right" : k(i11, f6478e) ? "Center" : k(i11, f6479f) ? "Justify" : k(i11, f6480g) ? "Start" : k(i11, f6481h) ? "End" : k(i11, f6482i) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return j(this.f6483a, obj);
    }

    public int hashCode() {
        return l(this.f6483a);
    }

    public final /* synthetic */ int n() {
        return this.f6483a;
    }

    public String toString() {
        return m(this.f6483a);
    }
}
