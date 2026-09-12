package com.google.android.datatransport.cct.internal;

import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.cloud.tmc.miniapp.BuildConfig;
import com.google.android.libraries.places.api.model.PlaceTypes;

/* loaded from: classes3.dex */
public final class b implements cc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final cc.a f24255a = new b();

    /* loaded from: classes3.dex */
    private static final class a implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final a f24256a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24257b = bc.b.d("sdkVersion");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24258c = bc.b.d("model");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f24259d = bc.b.d("hardware");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f24260e = bc.b.d("device");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f24261f = bc.b.d(BuildConfig.FLAVOR_sdkMode);

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f24262g = bc.b.d("osBuild");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f24263h = bc.b.d("manufacturer");

        /* renamed from: i, reason: collision with root package name */
        private static final bc.b f24264i = bc.b.d("fingerprint");

        /* renamed from: j, reason: collision with root package name */
        private static final bc.b f24265j = bc.b.d("locale");

        /* renamed from: k, reason: collision with root package name */
        private static final bc.b f24266k = bc.b.d(PlaceTypes.COUNTRY);

        /* renamed from: l, reason: collision with root package name */
        private static final bc.b f24267l = bc.b.d("mccMnc");

        /* renamed from: m, reason: collision with root package name */
        private static final bc.b f24268m = bc.b.d("applicationBuild");

        private a() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.google.android.datatransport.cct.internal.a aVar, bc.d dVar) {
            dVar.e(f24257b, aVar.m());
            dVar.e(f24258c, aVar.j());
            dVar.e(f24259d, aVar.f());
            dVar.e(f24260e, aVar.d());
            dVar.e(f24261f, aVar.l());
            dVar.e(f24262g, aVar.k());
            dVar.e(f24263h, aVar.h());
            dVar.e(f24264i, aVar.e());
            dVar.e(f24265j, aVar.g());
            dVar.e(f24266k, aVar.c());
            dVar.e(f24267l, aVar.i());
            dVar.e(f24268m, aVar.b());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.internal.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0360b implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final C0360b f24269a = new C0360b();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24270b = bc.b.d("logRequest");

        private C0360b() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, bc.d dVar) {
            dVar.e(f24270b, mVar.c());
        }
    }

    /* loaded from: classes3.dex */
    private static final class c implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final c f24271a = new c();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24272b = bc.b.d("clientType");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24273c = bc.b.d("androidClientInfo");

        private c() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ClientInfo clientInfo, bc.d dVar) {
            dVar.e(f24272b, clientInfo.c());
            dVar.e(f24273c, clientInfo.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class d implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final d f24274a = new d();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24275b = bc.b.d("privacyContext");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24276c = bc.b.d("productIdOrigin");

        private d() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ComplianceData complianceData, bc.d dVar) {
            dVar.e(f24275b, complianceData.b());
            dVar.e(f24276c, complianceData.c());
        }
    }

    /* loaded from: classes3.dex */
    private static final class e implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final e f24277a = new e();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24278b = bc.b.d("clearBlob");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24279c = bc.b.d("encryptedBlob");

        private e() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(n nVar, bc.d dVar) {
            dVar.e(f24278b, nVar.b());
            dVar.e(f24279c, nVar.c());
        }
    }

    /* loaded from: classes3.dex */
    private static final class f implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final f f24280a = new f();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24281b = bc.b.d("originAssociatedProductId");

        private f() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(o oVar, bc.d dVar) {
            dVar.e(f24281b, oVar.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class g implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final g f24282a = new g();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24283b = bc.b.d("prequest");

        private g() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(p pVar, bc.d dVar) {
            dVar.e(f24283b, pVar.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class h implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final h f24284a = new h();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24285b = bc.b.d("eventTimeMs");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24286c = bc.b.d("eventCode");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f24287d = bc.b.d("complianceData");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f24288e = bc.b.d("eventUptimeMs");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f24289f = bc.b.d("sourceExtension");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f24290g = bc.b.d("sourceExtensionJsonProto3");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f24291h = bc.b.d("timezoneOffsetSeconds");

        /* renamed from: i, reason: collision with root package name */
        private static final bc.b f24292i = bc.b.d("networkConnectionInfo");

        /* renamed from: j, reason: collision with root package name */
        private static final bc.b f24293j = bc.b.d("experimentIds");

        private h() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(q qVar, bc.d dVar) {
            dVar.a(f24285b, qVar.d());
            dVar.e(f24286c, qVar.c());
            dVar.e(f24287d, qVar.b());
            dVar.a(f24288e, qVar.e());
            dVar.e(f24289f, qVar.h());
            dVar.e(f24290g, qVar.i());
            dVar.a(f24291h, qVar.j());
            dVar.e(f24292i, qVar.g());
            dVar.e(f24293j, qVar.f());
        }
    }

    /* loaded from: classes3.dex */
    private static final class i implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final i f24294a = new i();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24295b = bc.b.d("requestTimeMs");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24296c = bc.b.d("requestUptimeMs");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f24297d = bc.b.d("clientInfo");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f24298e = bc.b.d("logSource");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f24299f = bc.b.d("logSourceName");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f24300g = bc.b.d("logEvent");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f24301h = bc.b.d("qosTier");

        private i() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(r rVar, bc.d dVar) {
            dVar.a(f24295b, rVar.g());
            dVar.a(f24296c, rVar.h());
            dVar.e(f24297d, rVar.b());
            dVar.e(f24298e, rVar.d());
            dVar.e(f24299f, rVar.e());
            dVar.e(f24300g, rVar.c());
            dVar.e(f24301h, rVar.f());
        }
    }

    /* loaded from: classes3.dex */
    private static final class j implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final j f24302a = new j();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f24303b = bc.b.d(NetworkBridge.KEY_NETWORK_TYPE);

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f24304c = bc.b.d("mobileSubtype");

        private j() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(NetworkConnectionInfo networkConnectionInfo, bc.d dVar) {
            dVar.e(f24303b, networkConnectionInfo.c());
            dVar.e(f24304c, networkConnectionInfo.b());
        }
    }

    private b() {
    }

    @Override // cc.a
    public void a(cc.b bVar) {
        C0360b c0360b = C0360b.f24269a;
        bVar.a(m.class, c0360b);
        bVar.a(com.google.android.datatransport.cct.internal.d.class, c0360b);
        i iVar = i.f24294a;
        bVar.a(r.class, iVar);
        bVar.a(k.class, iVar);
        c cVar = c.f24271a;
        bVar.a(ClientInfo.class, cVar);
        bVar.a(com.google.android.datatransport.cct.internal.e.class, cVar);
        a aVar = a.f24256a;
        bVar.a(com.google.android.datatransport.cct.internal.a.class, aVar);
        bVar.a(com.google.android.datatransport.cct.internal.c.class, aVar);
        h hVar = h.f24284a;
        bVar.a(q.class, hVar);
        bVar.a(com.google.android.datatransport.cct.internal.j.class, hVar);
        d dVar = d.f24274a;
        bVar.a(ComplianceData.class, dVar);
        bVar.a(com.google.android.datatransport.cct.internal.f.class, dVar);
        g gVar = g.f24282a;
        bVar.a(p.class, gVar);
        bVar.a(com.google.android.datatransport.cct.internal.i.class, gVar);
        f fVar = f.f24280a;
        bVar.a(o.class, fVar);
        bVar.a(com.google.android.datatransport.cct.internal.h.class, fVar);
        j jVar = j.f24302a;
        bVar.a(NetworkConnectionInfo.class, jVar);
        bVar.a(l.class, jVar);
        e eVar = e.f24277a;
        bVar.a(n.class, eVar);
        bVar.a(com.google.android.datatransport.cct.internal.g.class, eVar);
    }
}
