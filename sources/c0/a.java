package c0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0164a f17049b = new C0164a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f17050c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f17051d = d(2);

    /* renamed from: a, reason: collision with root package name */
    private final int f17052a;

    /* renamed from: c0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0164a {
        private C0164a() {
        }

        public /* synthetic */ C0164a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return a.f17051d;
        }

        public final int b() {
            return a.f17050c;
        }
    }

    private /* synthetic */ a(int i11) {
        this.f17052a = i11;
    }

    public static final /* synthetic */ a c(int i11) {
        return new a(i11);
    }

    public static int d(int i11) {
        return i11;
    }

    public static boolean e(int i11, Object obj) {
        return (obj instanceof a) && i11 == ((a) obj).i();
    }

    public static final boolean f(int i11, int i12) {
        return i11 == i12;
    }

    public static int g(int i11) {
        return i11;
    }

    public static String h(int i11) {
        return f(i11, f17050c) ? "Touch" : f(i11, f17051d) ? "Keyboard" : "Error";
    }

    public boolean equals(Object obj) {
        return e(this.f17052a, obj);
    }

    public int hashCode() {
        return g(this.f17052a);
    }

    public final /* synthetic */ int i() {
        return this.f17052a;
    }

    public String toString() {
        return h(this.f17052a);
    }
}
