package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6335a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f6336b = e(-1);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6337c = e(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6338d = e(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f6339e = e(2);

    /* renamed from: f, reason: collision with root package name */
    private static final int f6340f = e(3);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return t.f6338d;
        }

        public final int b() {
            return t.f6337c;
        }

        public final int c() {
            return t.f6340f;
        }

        public final int d() {
            return t.f6339e;
        }
    }

    private static int e(int i11) {
        return i11;
    }

    public static final boolean f(int i11, int i12) {
        return i11 == i12;
    }

    public static int g(int i11) {
        return i11;
    }

    public static String h(int i11) {
        return f(i11, f6336b) ? "Unspecified" : f(i11, f6337c) ? "None" : f(i11, f6338d) ? "Characters" : f(i11, f6339e) ? "Words" : f(i11, f6340f) ? "Sentences" : "Invalid";
    }
}
