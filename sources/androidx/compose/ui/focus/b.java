package androidx.compose.ui.focus;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4312b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4313c = j(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4314d = j(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f4315e = j(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f4316f = j(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f4317g = j(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f4318h = j(6);

    /* renamed from: i, reason: collision with root package name */
    private static final int f4319i = j(7);

    /* renamed from: j, reason: collision with root package name */
    private static final int f4320j = j(8);

    /* renamed from: a, reason: collision with root package name */
    private final int f4321a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return b.f4318h;
        }

        public final int b() {
            return b.f4319i;
        }

        public final int c() {
            return b.f4320j;
        }

        public final int d() {
            return b.f4315e;
        }

        public final int e() {
            return b.f4313c;
        }

        public final int f() {
            return b.f4314d;
        }

        public final int g() {
            return b.f4316f;
        }

        public final int h() {
            return b.f4317g;
        }
    }

    private /* synthetic */ b(int i11) {
        this.f4321a = i11;
    }

    public static final /* synthetic */ b i(int i11) {
        return new b(i11);
    }

    public static int j(int i11) {
        return i11;
    }

    public static boolean k(int i11, Object obj) {
        return (obj instanceof b) && i11 == ((b) obj).o();
    }

    public static final boolean l(int i11, int i12) {
        return i11 == i12;
    }

    public static int m(int i11) {
        return i11;
    }

    public static String n(int i11) {
        return l(i11, f4313c) ? "Next" : l(i11, f4314d) ? "Previous" : l(i11, f4315e) ? "Left" : l(i11, f4316f) ? "Right" : l(i11, f4317g) ? "Up" : l(i11, f4318h) ? "Down" : l(i11, f4319i) ? "Enter" : l(i11, f4320j) ? "Exit" : "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return k(this.f4321a, obj);
    }

    public int hashCode() {
        return m(this.f4321a);
    }

    public final /* synthetic */ int o() {
        return this.f4321a;
    }

    public String toString() {
        return n(this.f4321a);
    }
}
