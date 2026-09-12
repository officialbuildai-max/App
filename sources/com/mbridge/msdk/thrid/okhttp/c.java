package com.mbridge.msdk.thrid.okhttp;

import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: n, reason: collision with root package name */
    public static final c f37829n = new a().b().a();

    /* renamed from: o, reason: collision with root package name */
    public static final c f37830o = new a().c().a(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f37831a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f37832b;

    /* renamed from: c, reason: collision with root package name */
    private final int f37833c;

    /* renamed from: d, reason: collision with root package name */
    private final int f37834d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f37835e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f37836f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f37837g;

    /* renamed from: h, reason: collision with root package name */
    private final int f37838h;

    /* renamed from: i, reason: collision with root package name */
    private final int f37839i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f37840j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f37841k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f37842l;

    /* renamed from: m, reason: collision with root package name */
    String f37843m;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f37844a;

        /* renamed from: b, reason: collision with root package name */
        boolean f37845b;

        /* renamed from: c, reason: collision with root package name */
        int f37846c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f37847d = -1;

        /* renamed from: e, reason: collision with root package name */
        int f37848e = -1;

        /* renamed from: f, reason: collision with root package name */
        boolean f37849f;

        /* renamed from: g, reason: collision with root package name */
        boolean f37850g;

        /* renamed from: h, reason: collision with root package name */
        boolean f37851h;

        public a a(int i11, TimeUnit timeUnit) {
            if (i11 >= 0) {
                long seconds = timeUnit.toSeconds(i11);
                this.f37847d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i11);
        }

        public c a() {
            return new c(this);
        }

        public a b() {
            this.f37844a = true;
            return this;
        }

        public a c() {
            this.f37849f = true;
            return this;
        }
    }

    c(a aVar) {
        this.f37831a = aVar.f37844a;
        this.f37832b = aVar.f37845b;
        this.f37833c = aVar.f37846c;
        this.f37834d = -1;
        this.f37835e = false;
        this.f37836f = false;
        this.f37837g = false;
        this.f37838h = aVar.f37847d;
        this.f37839i = aVar.f37848e;
        this.f37840j = aVar.f37849f;
        this.f37841k = aVar.f37850g;
        this.f37842l = aVar.f37851h;
    }

    private c(boolean z10, boolean z11, int i11, int i12, boolean z12, boolean z13, boolean z14, int i13, int i14, boolean z15, boolean z16, boolean z17, String str) {
        this.f37831a = z10;
        this.f37832b = z11;
        this.f37833c = i11;
        this.f37834d = i12;
        this.f37835e = z12;
        this.f37836f = z13;
        this.f37837g = z14;
        this.f37838h = i13;
        this.f37839i = i14;
        this.f37840j = z15;
        this.f37841k = z16;
        this.f37842l = z17;
        this.f37843m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.mbridge.msdk.thrid.okhttp.c a(com.mbridge.msdk.thrid.okhttp.p r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.c.a(com.mbridge.msdk.thrid.okhttp.p):com.mbridge.msdk.thrid.okhttp.c");
    }

    private String a() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f37831a) {
            sb2.append("no-cache, ");
        }
        if (this.f37832b) {
            sb2.append("no-store, ");
        }
        if (this.f37833c != -1) {
            sb2.append("max-age=");
            sb2.append(this.f37833c);
            sb2.append(", ");
        }
        if (this.f37834d != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.f37834d);
            sb2.append(", ");
        }
        if (this.f37835e) {
            sb2.append("private, ");
        }
        if (this.f37836f) {
            sb2.append("public, ");
        }
        if (this.f37837g) {
            sb2.append("must-revalidate, ");
        }
        if (this.f37838h != -1) {
            sb2.append("max-stale=");
            sb2.append(this.f37838h);
            sb2.append(", ");
        }
        if (this.f37839i != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.f37839i);
            sb2.append(", ");
        }
        if (this.f37840j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f37841k) {
            sb2.append("no-transform, ");
        }
        if (this.f37842l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    public boolean b() {
        return this.f37835e;
    }

    public boolean c() {
        return this.f37836f;
    }

    public int d() {
        return this.f37833c;
    }

    public int e() {
        return this.f37838h;
    }

    public int f() {
        return this.f37839i;
    }

    public boolean g() {
        return this.f37837g;
    }

    public boolean h() {
        return this.f37831a;
    }

    public boolean i() {
        return this.f37832b;
    }

    public boolean j() {
        return this.f37840j;
    }

    public String toString() {
        String str = this.f37843m;
        if (str != null) {
            return str;
        }
        String a11 = a();
        this.f37843m = a11;
        return a11;
    }
}
