package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6218b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6219c = f(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6220d = f(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f6221e = f(2);

    /* renamed from: f, reason: collision with root package name */
    private static final int f6222f = f(3);

    /* renamed from: a, reason: collision with root package name */
    private final int f6223a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return o.f6220d;
        }

        public final int b() {
            return o.f6219c;
        }

        public final int c() {
            return o.f6222f;
        }

        public final int d() {
            return o.f6221e;
        }
    }

    private /* synthetic */ o(int i11) {
        this.f6223a = i11;
    }

    public static final /* synthetic */ o e(int i11) {
        return new o(i11);
    }

    public static int f(int i11) {
        return i11;
    }

    public static boolean g(int i11, Object obj) {
        return (obj instanceof o) && i11 == ((o) obj).k();
    }

    public static final boolean h(int i11, int i12) {
        return i11 == i12;
    }

    public static int i(int i11) {
        return i11;
    }

    public static String j(int i11) {
        return h(i11, f6219c) ? "None" : h(i11, f6220d) ? "All" : h(i11, f6221e) ? "Weight" : h(i11, f6222f) ? "Style" : "Invalid";
    }

    public boolean equals(Object obj) {
        return g(this.f6223a, obj);
    }

    public int hashCode() {
        return i(this.f6223a);
    }

    public final /* synthetic */ int k() {
        return this.f6223a;
    }

    public String toString() {
        return j(this.f6223a);
    }
}
