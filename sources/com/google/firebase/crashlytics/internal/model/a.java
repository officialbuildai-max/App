package com.google.firebase.crashlytics.internal.model;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes4.dex */
public final class a implements cc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final cc.a f31365a = new a();

    /* renamed from: com.google.firebase.crashlytics.internal.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0439a implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final C0439a f31366a = new C0439a();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31367b = bc.b.d("arch");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31368c = bc.b.d("libraryName");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31369d = bc.b.d("buildId");

        private C0439a() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.a.AbstractC0421a abstractC0421a, bc.d dVar) {
            dVar.e(f31367b, abstractC0421a.b());
            dVar.e(f31368c, abstractC0421a.d());
            dVar.e(f31369d, abstractC0421a.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class b implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final b f31370a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31371b = bc.b.d("pid");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31372c = bc.b.d("processName");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31373d = bc.b.d("reasonCode");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31374e = bc.b.d("importance");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31375f = bc.b.d("pss");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f31376g = bc.b.d("rss");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f31377h = bc.b.d(CampaignEx.JSON_KEY_TIMESTAMP);

        /* renamed from: i, reason: collision with root package name */
        private static final bc.b f31378i = bc.b.d("traceFile");

        /* renamed from: j, reason: collision with root package name */
        private static final bc.b f31379j = bc.b.d("buildIdMappingForArch");

        private b() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.a aVar, bc.d dVar) {
            dVar.b(f31371b, aVar.d());
            dVar.e(f31372c, aVar.e());
            dVar.b(f31373d, aVar.g());
            dVar.b(f31374e, aVar.c());
            dVar.a(f31375f, aVar.f());
            dVar.a(f31376g, aVar.h());
            dVar.a(f31377h, aVar.i());
            dVar.e(f31378i, aVar.j());
            dVar.e(f31379j, aVar.b());
        }
    }

    /* loaded from: classes4.dex */
    private static final class c implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final c f31380a = new c();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31381b = bc.b.d("key");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31382c = bc.b.d(AppMeasurementSdk.ConditionalUserProperty.VALUE);

        private c() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.c cVar, bc.d dVar) {
            dVar.e(f31381b, cVar.b());
            dVar.e(f31382c, cVar.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class d implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final d f31383a = new d();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31384b = bc.b.d("sdkVersion");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31385c = bc.b.d("gmpAppId");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31386d = bc.b.d(TrackingKey.PLATFORM);

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31387e = bc.b.d("installationUuid");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31388f = bc.b.d("firebaseInstallationId");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f31389g = bc.b.d("firebaseAuthenticationToken");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f31390h = bc.b.d("appQualitySessionId");

        /* renamed from: i, reason: collision with root package name */
        private static final bc.b f31391i = bc.b.d("buildVersion");

        /* renamed from: j, reason: collision with root package name */
        private static final bc.b f31392j = bc.b.d("displayVersion");

        /* renamed from: k, reason: collision with root package name */
        private static final bc.b f31393k = bc.b.d("session");

        /* renamed from: l, reason: collision with root package name */
        private static final bc.b f31394l = bc.b.d("ndkPayload");

        /* renamed from: m, reason: collision with root package name */
        private static final bc.b f31395m = bc.b.d("appExitInfo");

        private d() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport crashlyticsReport, bc.d dVar) {
            dVar.e(f31384b, crashlyticsReport.m());
            dVar.e(f31385c, crashlyticsReport.i());
            dVar.b(f31386d, crashlyticsReport.l());
            dVar.e(f31387e, crashlyticsReport.j());
            dVar.e(f31388f, crashlyticsReport.h());
            dVar.e(f31389g, crashlyticsReport.g());
            dVar.e(f31390h, crashlyticsReport.d());
            dVar.e(f31391i, crashlyticsReport.e());
            dVar.e(f31392j, crashlyticsReport.f());
            dVar.e(f31393k, crashlyticsReport.n());
            dVar.e(f31394l, crashlyticsReport.k());
            dVar.e(f31395m, crashlyticsReport.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class e implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final e f31396a = new e();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31397b = bc.b.d("files");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31398c = bc.b.d("orgId");

        private e() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.d dVar, bc.d dVar2) {
            dVar2.e(f31397b, dVar.b());
            dVar2.e(f31398c, dVar.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class f implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final f f31399a = new f();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31400b = bc.b.d("filename");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31401c = bc.b.d("contents");

        private f() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.d.b bVar, bc.d dVar) {
            dVar.e(f31400b, bVar.c());
            dVar.e(f31401c, bVar.b());
        }
    }

    /* loaded from: classes4.dex */
    private static final class g implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final g f31402a = new g();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31403b = bc.b.d("identifier");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31404c = bc.b.d("version");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31405d = bc.b.d("displayVersion");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31406e = bc.b.d("organization");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31407f = bc.b.d("installationUuid");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f31408g = bc.b.d("developmentPlatform");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f31409h = bc.b.d("developmentPlatformVersion");

        private g() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.a aVar, bc.d dVar) {
            dVar.e(f31403b, aVar.e());
            dVar.e(f31404c, aVar.h());
            dVar.e(f31405d, aVar.d());
            dVar.e(f31406e, aVar.g());
            dVar.e(f31407f, aVar.f());
            dVar.e(f31408g, aVar.b());
            dVar.e(f31409h, aVar.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class h implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final h f31410a = new h();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31411b = bc.b.d("clsId");

        private h() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.a.b bVar, bc.d dVar) {
            dVar.e(f31411b, bVar.a());
        }
    }

    /* loaded from: classes4.dex */
    private static final class i implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final i f31412a = new i();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31413b = bc.b.d("arch");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31414c = bc.b.d("model");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31415d = bc.b.d("cores");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31416e = bc.b.d("ram");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31417f = bc.b.d("diskSpace");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f31418g = bc.b.d("simulator");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f31419h = bc.b.d("state");

        /* renamed from: i, reason: collision with root package name */
        private static final bc.b f31420i = bc.b.d("manufacturer");

        /* renamed from: j, reason: collision with root package name */
        private static final bc.b f31421j = bc.b.d("modelClass");

        private i() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.c cVar, bc.d dVar) {
            dVar.b(f31413b, cVar.b());
            dVar.e(f31414c, cVar.f());
            dVar.b(f31415d, cVar.c());
            dVar.a(f31416e, cVar.h());
            dVar.a(f31417f, cVar.d());
            dVar.d(f31418g, cVar.j());
            dVar.b(f31419h, cVar.i());
            dVar.e(f31420i, cVar.e());
            dVar.e(f31421j, cVar.g());
        }
    }

    /* loaded from: classes4.dex */
    private static final class j implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final j f31422a = new j();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31423b = bc.b.d("generator");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31424c = bc.b.d("identifier");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31425d = bc.b.d("appQualitySessionId");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31426e = bc.b.d("startedAt");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31427f = bc.b.d("endedAt");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f31428g = bc.b.d("crashed");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f31429h = bc.b.d("app");

        /* renamed from: i, reason: collision with root package name */
        private static final bc.b f31430i = bc.b.d("user");

        /* renamed from: j, reason: collision with root package name */
        private static final bc.b f31431j = bc.b.d("os");

        /* renamed from: k, reason: collision with root package name */
        private static final bc.b f31432k = bc.b.d("device");

        /* renamed from: l, reason: collision with root package name */
        private static final bc.b f31433l = bc.b.d("events");

        /* renamed from: m, reason: collision with root package name */
        private static final bc.b f31434m = bc.b.d("generatorType");

        private j() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e eVar, bc.d dVar) {
            dVar.e(f31423b, eVar.g());
            dVar.e(f31424c, eVar.j());
            dVar.e(f31425d, eVar.c());
            dVar.a(f31426e, eVar.l());
            dVar.e(f31427f, eVar.e());
            dVar.d(f31428g, eVar.n());
            dVar.e(f31429h, eVar.b());
            dVar.e(f31430i, eVar.m());
            dVar.e(f31431j, eVar.k());
            dVar.e(f31432k, eVar.d());
            dVar.e(f31433l, eVar.f());
            dVar.b(f31434m, eVar.h());
        }
    }

    /* loaded from: classes4.dex */
    private static final class k implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final k f31435a = new k();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31436b = bc.b.d("execution");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31437c = bc.b.d("customAttributes");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31438d = bc.b.d("internalKeys");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31439e = bc.b.d("background");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31440f = bc.b.d("currentProcessDetails");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f31441g = bc.b.d("appProcessDetails");

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f31442h = bc.b.d("uiOrientation");

        private k() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a aVar, bc.d dVar) {
            dVar.e(f31436b, aVar.f());
            dVar.e(f31437c, aVar.e());
            dVar.e(f31438d, aVar.g());
            dVar.e(f31439e, aVar.c());
            dVar.e(f31440f, aVar.d());
            dVar.e(f31441g, aVar.b());
            dVar.b(f31442h, aVar.h());
        }
    }

    /* loaded from: classes4.dex */
    private static final class l implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final l f31443a = new l();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31444b = bc.b.d("baseAddress");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31445c = bc.b.d("size");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31446d = bc.b.d("name");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31447e = bc.b.d("uuid");

        private l() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.AbstractC0425a abstractC0425a, bc.d dVar) {
            dVar.a(f31444b, abstractC0425a.b());
            dVar.a(f31445c, abstractC0425a.d());
            dVar.e(f31446d, abstractC0425a.c());
            dVar.e(f31447e, abstractC0425a.f());
        }
    }

    /* loaded from: classes4.dex */
    private static final class m implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final m f31448a = new m();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31449b = bc.b.d("threads");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31450c = bc.b.d("exception");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31451d = bc.b.d("appExitInfo");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31452e = bc.b.d("signal");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31453f = bc.b.d("binaries");

        private m() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b bVar, bc.d dVar) {
            dVar.e(f31449b, bVar.f());
            dVar.e(f31450c, bVar.d());
            dVar.e(f31451d, bVar.b());
            dVar.e(f31452e, bVar.e());
            dVar.e(f31453f, bVar.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class n implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final n f31454a = new n();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31455b = bc.b.d(NativeComponentConstants.KEY_COMPONENT_TYPE);

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31456c = bc.b.d("reason");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31457d = bc.b.d(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31458e = bc.b.d("causedBy");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31459f = bc.b.d("overflowCount");

        private n() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.c cVar, bc.d dVar) {
            dVar.e(f31455b, cVar.f());
            dVar.e(f31456c, cVar.e());
            dVar.e(f31457d, cVar.c());
            dVar.e(f31458e, cVar.b());
            dVar.b(f31459f, cVar.d());
        }
    }

    /* loaded from: classes4.dex */
    private static final class o implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final o f31460a = new o();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31461b = bc.b.d("name");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31462c = bc.b.d("code");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31463d = bc.b.d(PlaceTypes.ADDRESS);

        private o() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.AbstractC0429d abstractC0429d, bc.d dVar) {
            dVar.e(f31461b, abstractC0429d.d());
            dVar.e(f31462c, abstractC0429d.c());
            dVar.a(f31463d, abstractC0429d.b());
        }
    }

    /* loaded from: classes4.dex */
    private static final class p implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final p f31464a = new p();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31465b = bc.b.d("name");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31466c = bc.b.d("importance");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31467d = bc.b.d(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);

        private p() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.AbstractC0431e abstractC0431e, bc.d dVar) {
            dVar.e(f31465b, abstractC0431e.d());
            dVar.b(f31466c, abstractC0431e.c());
            dVar.e(f31467d, abstractC0431e.b());
        }
    }

    /* loaded from: classes4.dex */
    private static final class q implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final q f31468a = new q();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31469b = bc.b.d("pc");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31470c = bc.b.d("symbol");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31471d = bc.b.d(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE);

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31472e = bc.b.d("offset");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31473f = bc.b.d("importance");

        private q() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b abstractC0433b, bc.d dVar) {
            dVar.a(f31469b, abstractC0433b.e());
            dVar.e(f31470c, abstractC0433b.f());
            dVar.e(f31471d, abstractC0433b.b());
            dVar.a(f31472e, abstractC0433b.d());
            dVar.b(f31473f, abstractC0433b.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class r implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final r f31474a = new r();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31475b = bc.b.d("processName");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31476c = bc.b.d("pid");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31477d = bc.b.d("importance");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31478e = bc.b.d("defaultProcess");

        private r() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.c cVar, bc.d dVar) {
            dVar.e(f31475b, cVar.d());
            dVar.b(f31476c, cVar.c());
            dVar.b(f31477d, cVar.b());
            dVar.d(f31478e, cVar.e());
        }
    }

    /* loaded from: classes4.dex */
    private static final class s implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final s f31479a = new s();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31480b = bc.b.d("batteryLevel");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31481c = bc.b.d("batteryVelocity");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31482d = bc.b.d("proximityOn");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31483e = bc.b.d("orientation");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31484f = bc.b.d("ramUsed");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f31485g = bc.b.d("diskUsed");

        private s() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.c cVar, bc.d dVar) {
            dVar.e(f31480b, cVar.b());
            dVar.b(f31481c, cVar.c());
            dVar.d(f31482d, cVar.g());
            dVar.b(f31483e, cVar.e());
            dVar.a(f31484f, cVar.f());
            dVar.a(f31485g, cVar.d());
        }
    }

    /* loaded from: classes4.dex */
    private static final class t implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final t f31486a = new t();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31487b = bc.b.d(CampaignEx.JSON_KEY_TIMESTAMP);

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31488c = bc.b.d(NativeComponentConstants.KEY_COMPONENT_TYPE);

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31489d = bc.b.d("app");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31490e = bc.b.d("device");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f31491f = bc.b.d("log");

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f31492g = bc.b.d("rollouts");

        private t() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d dVar, bc.d dVar2) {
            dVar2.a(f31487b, dVar.f());
            dVar2.e(f31488c, dVar.g());
            dVar2.e(f31489d, dVar.b());
            dVar2.e(f31490e, dVar.c());
            dVar2.e(f31491f, dVar.d());
            dVar2.e(f31492g, dVar.e());
        }
    }

    /* loaded from: classes4.dex */
    private static final class u implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final u f31493a = new u();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31494b = bc.b.d("content");

        private u() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.AbstractC0436d abstractC0436d, bc.d dVar) {
            dVar.e(f31494b, abstractC0436d.b());
        }
    }

    /* loaded from: classes4.dex */
    private static final class v implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final v f31495a = new v();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31496b = bc.b.d("rolloutVariant");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31497c = bc.b.d("parameterKey");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31498d = bc.b.d("parameterValue");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31499e = bc.b.d("templateVersion");

        private v() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.AbstractC0437e abstractC0437e, bc.d dVar) {
            dVar.e(f31496b, abstractC0437e.d());
            dVar.e(f31497c, abstractC0437e.b());
            dVar.e(f31498d, abstractC0437e.c());
            dVar.a(f31499e, abstractC0437e.e());
        }
    }

    /* loaded from: classes4.dex */
    private static final class w implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final w f31500a = new w();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31501b = bc.b.d("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31502c = bc.b.d("variantId");

        private w() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.AbstractC0437e.b bVar, bc.d dVar) {
            dVar.e(f31501b, bVar.b());
            dVar.e(f31502c, bVar.c());
        }
    }

    /* loaded from: classes4.dex */
    private static final class x implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final x f31503a = new x();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31504b = bc.b.d("assignments");

        private x() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.f fVar, bc.d dVar) {
            dVar.e(f31504b, fVar.b());
        }
    }

    /* loaded from: classes4.dex */
    private static final class y implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final y f31505a = new y();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31506b = bc.b.d(TrackingKey.PLATFORM);

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f31507c = bc.b.d("version");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f31508d = bc.b.d("buildVersion");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f31509e = bc.b.d("jailbroken");

        private y() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.AbstractC0438e abstractC0438e, bc.d dVar) {
            dVar.b(f31506b, abstractC0438e.c());
            dVar.e(f31507c, abstractC0438e.d());
            dVar.e(f31508d, abstractC0438e.b());
            dVar.d(f31509e, abstractC0438e.e());
        }
    }

    /* loaded from: classes4.dex */
    private static final class z implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final z f31510a = new z();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f31511b = bc.b.d("identifier");

        private z() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.f fVar, bc.d dVar) {
            dVar.e(f31511b, fVar.b());
        }
    }

    private a() {
    }

    @Override // cc.a
    public void a(cc.b bVar) {
        d dVar = d.f31383a;
        bVar.a(CrashlyticsReport.class, dVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.b.class, dVar);
        j jVar = j.f31422a;
        bVar.a(CrashlyticsReport.e.class, jVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.h.class, jVar);
        g gVar = g.f31402a;
        bVar.a(CrashlyticsReport.e.a.class, gVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.i.class, gVar);
        h hVar = h.f31410a;
        bVar.a(CrashlyticsReport.e.a.b.class, hVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.j.class, hVar);
        z zVar = z.f31510a;
        bVar.a(CrashlyticsReport.e.f.class, zVar);
        bVar.a(a0.class, zVar);
        y yVar = y.f31505a;
        bVar.a(CrashlyticsReport.e.AbstractC0438e.class, yVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.z.class, yVar);
        i iVar = i.f31412a;
        bVar.a(CrashlyticsReport.e.c.class, iVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.k.class, iVar);
        t tVar = t.f31486a;
        bVar.a(CrashlyticsReport.e.d.class, tVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.l.class, tVar);
        k kVar = k.f31435a;
        bVar.a(CrashlyticsReport.e.d.a.class, kVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.m.class, kVar);
        m mVar = m.f31448a;
        bVar.a(CrashlyticsReport.e.d.a.b.class, mVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.n.class, mVar);
        p pVar = p.f31464a;
        bVar.a(CrashlyticsReport.e.d.a.b.AbstractC0431e.class, pVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.r.class, pVar);
        q qVar = q.f31468a;
        bVar.a(CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.class, qVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.s.class, qVar);
        n nVar = n.f31454a;
        bVar.a(CrashlyticsReport.e.d.a.b.c.class, nVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.p.class, nVar);
        b bVar2 = b.f31370a;
        bVar.a(CrashlyticsReport.a.class, bVar2);
        bVar.a(com.google.firebase.crashlytics.internal.model.c.class, bVar2);
        C0439a c0439a = C0439a.f31366a;
        bVar.a(CrashlyticsReport.a.AbstractC0421a.class, c0439a);
        bVar.a(com.google.firebase.crashlytics.internal.model.d.class, c0439a);
        o oVar = o.f31460a;
        bVar.a(CrashlyticsReport.e.d.a.b.AbstractC0429d.class, oVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.q.class, oVar);
        l lVar = l.f31443a;
        bVar.a(CrashlyticsReport.e.d.a.b.AbstractC0425a.class, lVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.o.class, lVar);
        c cVar = c.f31380a;
        bVar.a(CrashlyticsReport.c.class, cVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.e.class, cVar);
        r rVar = r.f31474a;
        bVar.a(CrashlyticsReport.e.d.a.c.class, rVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.t.class, rVar);
        s sVar = s.f31479a;
        bVar.a(CrashlyticsReport.e.d.c.class, sVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.u.class, sVar);
        u uVar = u.f31493a;
        bVar.a(CrashlyticsReport.e.d.AbstractC0436d.class, uVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.v.class, uVar);
        x xVar = x.f31503a;
        bVar.a(CrashlyticsReport.e.d.f.class, xVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.y.class, xVar);
        v vVar = v.f31495a;
        bVar.a(CrashlyticsReport.e.d.AbstractC0437e.class, vVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.w.class, vVar);
        w wVar = w.f31500a;
        bVar.a(CrashlyticsReport.e.d.AbstractC0437e.b.class, wVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.x.class, wVar);
        e eVar = e.f31396a;
        bVar.a(CrashlyticsReport.d.class, eVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.f.class, eVar);
        f fVar = f.f31399a;
        bVar.a(CrashlyticsReport.d.b.class, fVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.g.class, fVar);
    }
}
