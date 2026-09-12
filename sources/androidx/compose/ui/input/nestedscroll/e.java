package androidx.compose.ui.input.nestedscroll;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5014a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f5015b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f5016c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f5017d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f5018e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f5019f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f5020g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e.f5016c;
        }

        public final int b() {
            return e.f5015b;
        }
    }

    static {
        int c11 = c(1);
        f5015b = c11;
        int c12 = c(2);
        f5016c = c12;
        f5017d = c11;
        f5018e = c12;
        f5019f = c(3);
        f5020g = c11;
    }

    public static int c(int i11) {
        return i11;
    }

    public static final boolean d(int i11, int i12) {
        return i11 == i12;
    }
}
