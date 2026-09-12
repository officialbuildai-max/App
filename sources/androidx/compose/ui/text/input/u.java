package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6341a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f6342b = j(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6343c = j(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6344d = j(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f6345e = j(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f6346f = j(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f6347g = j(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f6348h = j(6);

    /* renamed from: i, reason: collision with root package name */
    private static final int f6349i = j(7);

    /* renamed from: j, reason: collision with root package name */
    private static final int f6350j = j(8);

    /* renamed from: k, reason: collision with root package name */
    private static final int f6351k = j(9);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return u.f6344d;
        }

        public final int b() {
            return u.f6351k;
        }

        public final int c() {
            return u.f6348h;
        }

        public final int d() {
            return u.f6345e;
        }

        public final int e() {
            return u.f6350j;
        }

        public final int f() {
            return u.f6349i;
        }

        public final int g() {
            return u.f6346f;
        }

        public final int h() {
            return u.f6343c;
        }

        public final int i() {
            return u.f6347g;
        }
    }

    private static int j(int i11) {
        return i11;
    }

    public static final boolean k(int i11, int i12) {
        return i11 == i12;
    }

    public static int l(int i11) {
        return i11;
    }

    public static String m(int i11) {
        return k(i11, f6342b) ? "Unspecified" : k(i11, f6343c) ? "Text" : k(i11, f6344d) ? "Ascii" : k(i11, f6345e) ? "Number" : k(i11, f6346f) ? "Phone" : k(i11, f6347g) ? "Uri" : k(i11, f6348h) ? "Email" : k(i11, f6349i) ? "Password" : k(i11, f6350j) ? "NumberPassword" : k(i11, f6351k) ? "Decimal" : "Invalid";
    }
}
