package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class d5 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4505a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f4506b = d(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4507c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4508d = d(2);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return d5.f4508d;
        }

        public final int b() {
            return d5.f4506b;
        }

        public final int c() {
            return d5.f4507c;
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
        return e(i11, f4506b) ? "Miter" : e(i11, f4507c) ? "Round" : e(i11, f4508d) ? "Bevel" : "Unknown";
    }
}
