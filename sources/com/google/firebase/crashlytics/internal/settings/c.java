package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f31791a;

    /* renamed from: b, reason: collision with root package name */
    public final a f31792b;

    /* renamed from: c, reason: collision with root package name */
    public final long f31793c;

    /* renamed from: d, reason: collision with root package name */
    public final int f31794d;

    /* renamed from: e, reason: collision with root package name */
    public final int f31795e;

    /* renamed from: f, reason: collision with root package name */
    public final double f31796f;

    /* renamed from: g, reason: collision with root package name */
    public final double f31797g;

    /* renamed from: h, reason: collision with root package name */
    public final int f31798h;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f31799a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f31800b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f31801c;

        public a(boolean z10, boolean z11, boolean z12) {
            this.f31799a = z10;
            this.f31800b = z11;
            this.f31801c = z12;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f31802a;

        /* renamed from: b, reason: collision with root package name */
        public final int f31803b;

        public b(int i11, int i12) {
            this.f31802a = i11;
            this.f31803b = i12;
        }
    }

    public c(long j11, b bVar, a aVar, int i11, int i12, double d11, double d12, int i13) {
        this.f31793c = j11;
        this.f31791a = bVar;
        this.f31792b = aVar;
        this.f31794d = i11;
        this.f31795e = i12;
        this.f31796f = d11;
        this.f31797g = d12;
        this.f31798h = i13;
    }

    public boolean a(long j11) {
        return this.f31793c < j11;
    }
}
