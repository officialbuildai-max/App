package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class c5 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4393a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f4394b = d(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4395c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4396d = d(2);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return c5.f4394b;
        }

        public final int b() {
            return c5.f4395c;
        }

        public final int c() {
            return c5.f4396d;
        }
    }

    public static int d(int i11) {
        return i11;
    }

    public static final boolean e(int i11, int i12) {
        return i11 == i12;
    }

    public static int f(int i11) {
        return i11;
    }

    public static String g(int i11) {
        return e(i11, f4394b) ? "Butt" : e(i11, f4395c) ? "Round" : e(i11, f4396d) ? "Square" : "Unknown";
    }
}
