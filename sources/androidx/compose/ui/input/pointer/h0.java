package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5073a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f5074b = f(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5075c = f(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5076d = f(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f5077e = f(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f5078f = f(4);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return h0.f5078f;
        }

        public final int b() {
            return h0.f5076d;
        }

        public final int c() {
            return h0.f5077e;
        }

        public final int d() {
            return h0.f5075c;
        }

        public final int e() {
            return h0.f5074b;
        }
    }

    private static int f(int i11) {
        return i11;
    }

    public static final boolean g(int i11, int i12) {
        return i11 == i12;
    }

    public static int h(int i11) {
        return i11;
    }

    public static String i(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch";
    }
}
