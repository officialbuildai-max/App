package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6167b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f6168c = e(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f6169d = e(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f6170e = e(2);

    /* renamed from: a, reason: collision with root package name */
    private final int f6171a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e.f6170e;
        }

        public final int b() {
            return e.f6168c;
        }

        public final int c() {
            return e.f6169d;
        }
    }

    private /* synthetic */ e(int i11) {
        this.f6171a = i11;
    }

    public static final /* synthetic */ e d(int i11) {
        return new e(i11);
    }

    private static int e(int i11) {
        return i11;
    }

    public static boolean f(int i11, Object obj) {
        return (obj instanceof e) && i11 == ((e) obj).j();
    }

    public static final boolean g(int i11, int i12) {
        return i11 == i12;
    }

    public static int h(int i11) {
        return i11;
    }

    public static String i(int i11) {
        if (i11 == f6168c) {
            return "EmojiSupportMatch.Default";
        }
        if (i11 == f6169d) {
            return "EmojiSupportMatch.None";
        }
        if (i11 == f6170e) {
            return "EmojiSupportMatch.All";
        }
        return "Invalid(value=" + i11 + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f6171a, obj);
    }

    public int hashCode() {
        return h(this.f6171a);
    }

    public final /* synthetic */ int j() {
        return this.f6171a;
    }

    public String toString() {
        return i(this.f6171a);
    }
}
