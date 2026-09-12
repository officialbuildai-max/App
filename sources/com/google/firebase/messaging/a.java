package com.google.firebase.messaging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.hisavana.common.tracking.TrackingKey;

/* loaded from: classes4.dex */
public final class a implements cc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final cc.a f32070a = new a();

    /* renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0446a implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final C0446a f32071a = new C0446a();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32072b = bc.b.a("projectNumber").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f32073c = bc.b.a("messageId").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f32074d = bc.b.a("instanceId").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f32075e = bc.b.a("messageType").b(com.google.firebase.encoders.proto.a.b().c(4).a()).a();

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f32076f = bc.b.a("sdkPlatform").b(com.google.firebase.encoders.proto.a.b().c(5).a()).a();

        /* renamed from: g, reason: collision with root package name */
        private static final bc.b f32077g = bc.b.a("packageName").b(com.google.firebase.encoders.proto.a.b().c(6).a()).a();

        /* renamed from: h, reason: collision with root package name */
        private static final bc.b f32078h = bc.b.a("collapseKey").b(com.google.firebase.encoders.proto.a.b().c(7).a()).a();

        /* renamed from: i, reason: collision with root package name */
        private static final bc.b f32079i = bc.b.a(TrackingKey.PRIORITY).b(com.google.firebase.encoders.proto.a.b().c(8).a()).a();

        /* renamed from: j, reason: collision with root package name */
        private static final bc.b f32080j = bc.b.a("ttl").b(com.google.firebase.encoders.proto.a.b().c(9).a()).a();

        /* renamed from: k, reason: collision with root package name */
        private static final bc.b f32081k = bc.b.a("topic").b(com.google.firebase.encoders.proto.a.b().c(10).a()).a();

        /* renamed from: l, reason: collision with root package name */
        private static final bc.b f32082l = bc.b.a("bulkId").b(com.google.firebase.encoders.proto.a.b().c(11).a()).a();

        /* renamed from: m, reason: collision with root package name */
        private static final bc.b f32083m = bc.b.a(NotificationCompat.CATEGORY_EVENT).b(com.google.firebase.encoders.proto.a.b().c(12).a()).a();

        /* renamed from: n, reason: collision with root package name */
        private static final bc.b f32084n = bc.b.a("analyticsLabel").b(com.google.firebase.encoders.proto.a.b().c(13).a()).a();

        /* renamed from: o, reason: collision with root package name */
        private static final bc.b f32085o = bc.b.a("campaignId").b(com.google.firebase.encoders.proto.a.b().c(14).a()).a();

        /* renamed from: p, reason: collision with root package name */
        private static final bc.b f32086p = bc.b.a("composerLabel").b(com.google.firebase.encoders.proto.a.b().c(15).a()).a();

        private C0446a() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MessagingClientEvent messagingClientEvent, bc.d dVar) {
            dVar.a(f32072b, messagingClientEvent.l());
            dVar.e(f32073c, messagingClientEvent.h());
            dVar.e(f32074d, messagingClientEvent.g());
            dVar.e(f32075e, messagingClientEvent.i());
            dVar.e(f32076f, messagingClientEvent.m());
            dVar.e(f32077g, messagingClientEvent.j());
            dVar.e(f32078h, messagingClientEvent.d());
            dVar.b(f32079i, messagingClientEvent.k());
            dVar.b(f32080j, messagingClientEvent.o());
            dVar.e(f32081k, messagingClientEvent.n());
            dVar.a(f32082l, messagingClientEvent.b());
            dVar.e(f32083m, messagingClientEvent.f());
            dVar.e(f32084n, messagingClientEvent.a());
            dVar.a(f32085o, messagingClientEvent.c());
            dVar.e(f32086p, messagingClientEvent.e());
        }
    }

    /* loaded from: classes4.dex */
    private static final class b implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final b f32087a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32088b = bc.b.a("messagingClientEvent").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        private b() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(nc.a aVar, bc.d dVar) {
            dVar.e(f32088b, aVar.a());
        }
    }

    /* loaded from: classes4.dex */
    private static final class c implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final c f32089a = new c();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f32090b = bc.b.d("messagingClientEventExtension");

        private c() {
        }

        @Override // bc.c
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.session.c.a(obj);
            b(null, (bc.d) obj2);
        }

        public void b(l0 l0Var, bc.d dVar) {
            throw null;
        }
    }

    private a() {
    }

    @Override // cc.a
    public void a(cc.b bVar) {
        bVar.a(l0.class, c.f32089a);
        bVar.a(nc.a.class, b.f32087a);
        bVar.a(MessagingClientEvent.class, C0446a.f32071a);
    }
}
