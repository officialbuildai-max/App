package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6214b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6215c = d(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6216d = d(1);

    /* renamed from: a, reason: collision with root package name */
    private final int f6217a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return n.f6216d;
        }

        public final int b() {
            return n.f6215c;
        }
    }

    private /* synthetic */ n(int i11) {
        this.f6217a = i11;
    }

    public static final /* synthetic */ n c(int i11) {
        return new n(i11);
    }

    public static int d(int i11) {
        return i11;
    }

    public static boolean e(int i11, Object obj) {
        return (obj instanceof n) && i11 == ((n) obj).i();
    }

    public static final boolean f(int i11, int i12) {
        return i11 == i12;
    }

    public static int g(int i11) {
        return i11;
    }

    public static String h(int i11) {
        return f(i11, f6215c) ? "Normal" : f(i11, f6216d) ? "Italic" : "Invalid";
    }

    public boolean equals(Object obj) {
        return e(this.f6217a, obj);
    }

    public int hashCode() {
        return g(this.f6217a);
    }

    public final /* synthetic */ int i() {
        return this.f6217a;
    }

    public String toString() {
        return h(this.f6217a);
    }
}
