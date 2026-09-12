package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class x3 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4954a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f4955b = c(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4956c = c(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4957d = c(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f4958e = c(3);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return x3.f4956c;
        }

        public final int b() {
            return x3.f4955b;
        }
    }

    public static int c(int i11) {
        return i11;
    }

    public static final boolean d(int i11, int i12) {
        return i11 == i12;
    }

    public static int e(int i11) {
        return i11;
    }

    public static String f(int i11) {
        return d(i11, f4955b) ? "None" : d(i11, f4956c) ? "Low" : d(i11, f4957d) ? "Medium" : d(i11, f4958e) ? "High" : "Unknown";
    }
}
