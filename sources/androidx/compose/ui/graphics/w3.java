package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class w3 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4949a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f4950b = d(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4951c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4952d = d(2);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return w3.f4950b;
        }

        public final int b() {
            return w3.f4952d;
        }

        public final int c() {
            return w3.f4951c;
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
        return "CompositingStrategy(value=" + i11 + ')';
    }
}
