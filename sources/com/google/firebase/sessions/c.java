package com.google.firebase.sessions;

/* loaded from: classes4.dex */
public final class c implements cc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final cc.a f32697a = new c();

    /* loaded from: classes4.dex */
    private static final class a implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final a f32698a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32699b = bc.b.d("packageName");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f32700c = bc.b.d("versionName");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f32701d = bc.b.d("appBuildVersion");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f32702e = bc.b.d("deviceManufacturer");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f32703f = bc.b.d("currentProcessDetails");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f32704g = bc.b.d("appProcessDetails");

        private a() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.google.firebase.sessions.a aVar, bc.d dVar) {
            dVar.e(f32699b, aVar.e());
            dVar.e(f32700c, aVar.f());
            dVar.e(f32701d, aVar.a());
            dVar.e(f32702e, aVar.d());
            dVar.e(f32703f, aVar.c());
            dVar.e(f32704g, aVar.b());
        }
    }

    /* loaded from: classes4.dex */
    private static final class b implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final b f32705a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32706b = bc.b.d("appId");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f32707c = bc.b.d("deviceModel");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f32708d = bc.b.d("sessionSdkVersion");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f32709e = bc.b.d("osVersion");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f32710f = bc.b.d("logEnvironment");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f32711g = bc.b.d("androidAppInfo");

        private b() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.google.firebase.sessions.b bVar, bc.d dVar) {
            dVar.e(f32706b, bVar.b());
            dVar.e(f32707c, bVar.c());
            dVar.e(f32708d, bVar.f());
            dVar.e(f32709e, bVar.e());
            dVar.e(f32710f, bVar.d());
            dVar.e(f32711g, bVar.a());
        }
    }

    /* renamed from: com.google.firebase.sessions.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0451c implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final C0451c f32712a = new C0451c();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32713b = bc.b.d("performance");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f32714c = bc.b.d("crashlytics");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f32715d = bc.b.d("sessionSamplingRate");

        private C0451c() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.google.firebase.sessions.d dVar, bc.d dVar2) {
            dVar2.e(f32713b, dVar.b());
            dVar2.e(f32714c, dVar.a());
            dVar2.c(f32715d, dVar.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class d implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final d f32716a = new d();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32717b = bc.b.d("processName");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f32718c = bc.b.d("pid");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f32719d = bc.b.d("importance");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f32720e = bc.b.d("defaultProcess");

        private d() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(p pVar, bc.d dVar) {
            dVar.e(f32717b, pVar.c());
            dVar.b(f32718c, pVar.b());
            dVar.b(f32719d, pVar.a());
            dVar.d(f32720e, pVar.d());
        }
    }

    /* loaded from: classes4.dex */
    private static final class e implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final e f32721a = new e();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32722b = bc.b.d("eventType");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f32723c = bc.b.d("sessionData");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f32724d = bc.b.d("applicationInfo");

        private e() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u uVar, bc.d dVar) {
            dVar.e(f32722b, uVar.b());
            dVar.e(f32723c, uVar.c());
            dVar.e(f32724d, uVar.a());
        }
    }

    /* loaded from: classes4.dex */
    private static final class f implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final f f32725a = new f();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32726b = bc.b.d("sessionId");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f32727c = bc.b.d("firstSessionId");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f32728d = bc.b.d("sessionIndex");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f32729e = bc.b.d("eventTimestampUs");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f32730f = bc.b.d("dataCollectionStatus");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f32731g = bc.b.d("firebaseInstallationId");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f32732h = bc.b.d("firebaseAuthenticationToken");

        private f() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(x xVar, bc.d dVar) {
            dVar.e(f32726b, xVar.f());
            dVar.e(f32727c, xVar.e());
            dVar.b(f32728d, xVar.g());
            dVar.a(f32729e, xVar.b());
            dVar.e(f32730f, xVar.a());
            dVar.e(f32731g, xVar.d());
            dVar.e(f32732h, xVar.c());
        }
    }

    private c() {
    }

    @Override // cc.a
    public void a(cc.b bVar) {
        bVar.a(u.class, e.f32721a);
        bVar.a(x.class, f.f32725a);
        bVar.a(com.google.firebase.sessions.d.class, C0451c.f32712a);
        bVar.a(com.google.firebase.sessions.b.class, b.f32705a);
        bVar.a(com.google.firebase.sessions.a.class, a.f32698a);
        bVar.a(p.class, d.f32716a);
    }
}
