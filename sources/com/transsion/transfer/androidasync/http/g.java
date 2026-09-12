package com.transsion.transfer.androidasync.http;

/* loaded from: classes6.dex */
public interface g {

    /* loaded from: classes6.dex */
    public static class a extends e {

        /* renamed from: c, reason: collision with root package name */
        public bv.b f55475c;

        /* renamed from: d, reason: collision with root package name */
        public com.transsion.transfer.androidasync.future.a f55476d;

        /* renamed from: e, reason: collision with root package name */
        public String f55477e;
    }

    /* loaded from: classes6.dex */
    public static class b extends d {

        /* renamed from: j, reason: collision with root package name */
        public com.transsion.transfer.androidasync.p f55478j;
    }

    /* loaded from: classes6.dex */
    public static class c extends a {

        /* renamed from: f, reason: collision with root package name */
        public com.transsion.transfer.androidasync.j f55479f;

        /* renamed from: g, reason: collision with root package name */
        public i f55480g;

        /* renamed from: h, reason: collision with root package name */
        public bv.a f55481h;

        /* renamed from: i, reason: collision with root package name */
        public bv.a f55482i;
    }

    /* loaded from: classes6.dex */
    public static class d extends f {
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public com.transsion.transfer.androidasync.util.e f55483a = new com.transsion.transfer.androidasync.util.e();

        /* renamed from: b, reason: collision with root package name */
        public j f55484b;
    }

    /* loaded from: classes6.dex */
    public static class f extends c {
    }

    /* renamed from: com.transsion.transfer.androidasync.http.g$g, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0699g extends h {

        /* renamed from: k, reason: collision with root package name */
        public Exception f55485k;
    }

    /* loaded from: classes6.dex */
    public static class h extends b {
    }

    /* loaded from: classes6.dex */
    public interface i {
        com.transsion.transfer.androidasync.s H();

        int b();

        i c(int i11);

        Headers e();

        i f(com.transsion.transfer.androidasync.s sVar);

        i k(String str);

        i m(com.transsion.transfer.androidasync.p pVar);

        String protocol();

        com.transsion.transfer.androidasync.j socket();

        i u(String str);

        i y(Headers headers);
    }

    void a(e eVar);

    void b(C0699g c0699g);

    void c(f fVar);

    void d(b bVar);

    com.transsion.transfer.androidasync.future.a e(a aVar);

    boolean f(c cVar);

    void g(d dVar);

    j h(h hVar);
}
