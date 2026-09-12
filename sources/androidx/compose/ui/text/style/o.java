package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6508c;

    /* renamed from: d, reason: collision with root package name */
    private static final o f6509d;

    /* renamed from: e, reason: collision with root package name */
    private static final o f6510e;

    /* renamed from: a, reason: collision with root package name */
    private final int f6511a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f6512b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o a() {
            return o.f6509d;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6513a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f6514b = d(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f6515c = d(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f6516d = d(3);

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f6515c;
            }

            public final int b() {
                return b.f6514b;
            }

            public final int c() {
                return b.f6516d;
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
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f6508c = new a(defaultConstructorMarker);
        b.a aVar = b.f6513a;
        f6509d = new o(aVar.a(), false, defaultConstructorMarker);
        f6510e = new o(aVar.b(), true, defaultConstructorMarker);
    }

    private o(int i11, boolean z10) {
        this.f6511a = i11;
        this.f6512b = z10;
    }

    public /* synthetic */ o(int i11, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, z10);
    }

    public final int b() {
        return this.f6511a;
    }

    public final boolean c() {
        return this.f6512b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return b.e(this.f6511a, oVar.f6511a) && this.f6512b == oVar.f6512b;
    }

    public int hashCode() {
        return (b.f(this.f6511a) * 31) + androidx.compose.foundation.e.a(this.f6512b);
    }

    public String toString() {
        return Intrinsics.c(this, f6509d) ? "TextMotion.Static" : Intrinsics.c(this, f6510e) ? "TextMotion.Animated" : "Invalid";
    }
}
