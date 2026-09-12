package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;

/* loaded from: classes3.dex */
public final class a implements cc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final cc.a f24383a = new a();

    /* renamed from: com.google.android.datatransport.runtime.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0361a implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final C0361a f24384a = new C0361a();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24385b = bc.b.a("window").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24386c = bc.b.a("logSourceMetrics").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f24387d = bc.b.a("globalMetrics").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f24388e = bc.b.a("appNamespace").b(com.google.firebase.encoders.proto.a.b().c(4).a()).a();

        private C0361a() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(v8.a aVar, bc.d dVar) {
            dVar.e(f24385b, aVar.d());
            dVar.e(f24386c, aVar.c());
            dVar.e(f24387d, aVar.b());
            dVar.e(f24388e, aVar.a());
        }
    }

    /* loaded from: classes3.dex */
    private static final class b implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final b f24389a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24390b = bc.b.a("storageMetrics").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        private b() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(v8.b bVar, bc.d dVar) {
            dVar.e(f24390b, bVar.a());
        }
    }

    /* loaded from: classes3.dex */
    private static final class c implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final c f24391a = new c();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24392b = bc.b.a("eventsDroppedCount").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24393c = bc.b.a("reason").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        private c() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogEventDropped logEventDropped, bc.d dVar) {
            dVar.a(f24392b, logEventDropped.a());
            dVar.e(f24393c, logEventDropped.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class d implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final d f24394a = new d();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24395b = bc.b.a("logSource").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24396c = bc.b.a("logEventDropped").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        private d() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(v8.c cVar, bc.d dVar) {
            dVar.e(f24395b, cVar.b());
            dVar.e(f24396c, cVar.a());
        }
    }

    /* loaded from: classes3.dex */
    private static final class e implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final e f24397a = new e();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24398b = bc.b.d("clientMetrics");

        private e() {
        }

        @Override // bc.c
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.session.c.a(obj);
            b(null, (bc.d) obj2);
        }

        public void b(m mVar, bc.d dVar) {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    private static final class f implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final f f24399a = new f();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24400b = bc.b.a("currentCacheSizeBytes").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24401c = bc.b.a("maxCacheSizeBytes").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        private f() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(v8.d dVar, bc.d dVar2) {
            dVar2.a(f24400b, dVar.a());
            dVar2.a(f24401c, dVar.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class g implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final g f24402a = new g();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24403b = bc.b.a("startMs").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24404c = bc.b.a("endMs").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        private g() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(v8.e eVar, bc.d dVar) {
            dVar.a(f24403b, eVar.b());
            dVar.a(f24404c, eVar.a());
        }
    }

    private a() {
    }

    @Override // cc.a
    public void a(cc.b bVar) {
        bVar.a(m.class, e.f24397a);
        bVar.a(v8.a.class, C0361a.f24384a);
        bVar.a(v8.e.class, g.f24402a);
        bVar.a(v8.c.class, d.f24394a);
        bVar.a(LogEventDropped.class, c.f24391a);
        bVar.a(v8.b.class, b.f24389a);
        bVar.a(v8.d.class, f.f24399a);
    }
}
