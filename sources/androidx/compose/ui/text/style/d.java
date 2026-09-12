package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6437a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f6438b = d(1);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6439c = d(2);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6440d = d(Integer.MIN_VALUE);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return d.f6439c;
        }

        public final int b() {
            return d.f6438b;
        }

        public final int c() {
            return d.f6440d;
        }
    }

    private static int d(int i11) {
        return i11;
    }

    public static final boolean e(int i11, int i12) {
        return i11 == i12;
    }

    public static int f(int i11) {
        return i11;
    }

    public static String g(int i11) {
        return e(i11, f6438b) ? "Hyphens.None" : e(i11, f6439c) ? "Hyphens.Auto" : e(i11, f6440d) ? "Hyphens.Unspecified" : "Invalid";
    }
}
