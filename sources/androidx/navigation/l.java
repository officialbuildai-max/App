package androidx.navigation;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f13991a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f13992b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13993c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f13994d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f13995e;

    /* renamed from: f, reason: collision with root package name */
    private final int f13996f;

    /* renamed from: g, reason: collision with root package name */
    private final int f13997g;

    /* renamed from: h, reason: collision with root package name */
    private final int f13998h;

    /* renamed from: i, reason: collision with root package name */
    private final int f13999i;

    /* renamed from: j, reason: collision with root package name */
    private String f14000j;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f14001a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f14002b;

        /* renamed from: d, reason: collision with root package name */
        private String f14004d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f14005e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f14006f;

        /* renamed from: c, reason: collision with root package name */
        private int f14003c = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f14007g = -1;

        /* renamed from: h, reason: collision with root package name */
        private int f14008h = -1;

        /* renamed from: i, reason: collision with root package name */
        private int f14009i = -1;

        /* renamed from: j, reason: collision with root package name */
        private int f14010j = -1;

        public static /* synthetic */ a i(a aVar, int i11, boolean z10, boolean z11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                z11 = false;
            }
            return aVar.g(i11, z10, z11);
        }

        public final l a() {
            String str = this.f14004d;
            return str != null ? new l(this.f14001a, this.f14002b, str, this.f14005e, this.f14006f, this.f14007g, this.f14008h, this.f14009i, this.f14010j) : new l(this.f14001a, this.f14002b, this.f14003c, this.f14005e, this.f14006f, this.f14007g, this.f14008h, this.f14009i, this.f14010j);
        }

        public final a b(int i11) {
            this.f14007g = i11;
            return this;
        }

        public final a c(int i11) {
            this.f14008h = i11;
            return this;
        }

        public final a d(boolean z10) {
            this.f14001a = z10;
            return this;
        }

        public final a e(int i11) {
            this.f14009i = i11;
            return this;
        }

        public final a f(int i11) {
            this.f14010j = i11;
            return this;
        }

        public final a g(int i11, boolean z10, boolean z11) {
            this.f14003c = i11;
            this.f14004d = null;
            this.f14005e = z10;
            this.f14006f = z11;
            return this;
        }

        public final a h(String str, boolean z10, boolean z11) {
            this.f14004d = str;
            this.f14003c = -1;
            this.f14005e = z10;
            this.f14006f = z11;
            return this;
        }

        public final a j(boolean z10) {
            this.f14002b = z10;
            return this;
        }
    }

    public l(boolean z10, boolean z11, int i11, boolean z12, boolean z13, int i12, int i13, int i14, int i15) {
        this.f13991a = z10;
        this.f13992b = z11;
        this.f13993c = i11;
        this.f13994d = z12;
        this.f13995e = z13;
        this.f13996f = i12;
        this.f13997g = i13;
        this.f13998h = i14;
        this.f13999i = i15;
    }

    public l(boolean z10, boolean z11, String str, boolean z12, boolean z13, int i11, int i12, int i13, int i14) {
        this(z10, z11, NavDestination.f13911j.a(str).hashCode(), z12, z13, i11, i12, i13, i14);
        this.f14000j = str;
    }

    public final int a() {
        return this.f13996f;
    }

    public final int b() {
        return this.f13997g;
    }

    public final int c() {
        return this.f13998h;
    }

    public final int d() {
        return this.f13999i;
    }

    public final int e() {
        return this.f13993c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(l.class, obj.getClass())) {
            return false;
        }
        l lVar = (l) obj;
        return this.f13991a == lVar.f13991a && this.f13992b == lVar.f13992b && this.f13993c == lVar.f13993c && Intrinsics.c(this.f14000j, lVar.f14000j) && this.f13994d == lVar.f13994d && this.f13995e == lVar.f13995e && this.f13996f == lVar.f13996f && this.f13997g == lVar.f13997g && this.f13998h == lVar.f13998h && this.f13999i == lVar.f13999i;
    }

    public final boolean f() {
        return this.f13994d;
    }

    public final boolean g() {
        return this.f13991a;
    }

    public final boolean h() {
        return this.f13995e;
    }

    public int hashCode() {
        int i11 = (((((g() ? 1 : 0) * 31) + (i() ? 1 : 0)) * 31) + this.f13993c) * 31;
        String str = this.f14000j;
        return ((((((((((((i11 + (str == null ? 0 : str.hashCode())) * 31) + (f() ? 1 : 0)) * 31) + (h() ? 1 : 0)) * 31) + this.f13996f) * 31) + this.f13997g) * 31) + this.f13998h) * 31) + this.f13999i;
    }

    public final boolean i() {
        return this.f13992b;
    }
}
