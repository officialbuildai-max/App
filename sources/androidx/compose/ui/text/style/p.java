package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6517a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f6518b = d(1);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6519c = d(2);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6520d = d(3);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return p.f6518b;
        }

        public final int b() {
            return p.f6519c;
        }

        public final int c() {
            return p.f6520d;
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
        return e(i11, f6518b) ? "Clip" : e(i11, f6519c) ? "Ellipsis" : e(i11, f6520d) ? "Visible" : "Invalid";
    }
}
