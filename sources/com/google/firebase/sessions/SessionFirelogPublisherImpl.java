package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;

/* loaded from: classes4.dex */
public final class SessionFirelogPublisherImpl implements w {

    /* renamed from: g, reason: collision with root package name */
    public static final a f32649g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final double f32650h = Math.random();

    /* renamed from: b, reason: collision with root package name */
    private final com.google.firebase.f f32651b;

    /* renamed from: c, reason: collision with root package name */
    private final jc.e f32652c;

    /* renamed from: d, reason: collision with root package name */
    private final SessionsSettings f32653d;

    /* renamed from: e, reason: collision with root package name */
    private final g f32654e;

    /* renamed from: f, reason: collision with root package name */
    private final CoroutineContext f32655f;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionFirelogPublisherImpl(com.google.firebase.f firebaseApp, jc.e firebaseInstallations, SessionsSettings sessionSettings, g eventGDTLogger, CoroutineContext backgroundDispatcher) {
        Intrinsics.h(firebaseApp, "firebaseApp");
        Intrinsics.h(firebaseInstallations, "firebaseInstallations");
        Intrinsics.h(sessionSettings, "sessionSettings");
        Intrinsics.h(eventGDTLogger, "eventGDTLogger");
        Intrinsics.h(backgroundDispatcher, "backgroundDispatcher");
        this.f32651b = firebaseApp;
        this.f32652c = firebaseInstallations;
        this.f32653d = sessionSettings;
        this.f32654e = eventGDTLogger;
        this.f32655f = backgroundDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(u uVar) {
        try {
            this.f32654e.a(uVar);
        } catch (RuntimeException e11) {
            Log.e("SessionFirelogPublisher", "Error logging Session Start event to DataTransport: ", e11);
        }
    }

    private final boolean h() {
        return f32650h <= this.f32653d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            if (r0 == 0) goto L13
            r0 = r5
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = new com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.google.firebase.sessions.SessionFirelogPublisherImpl r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r0
            kotlin.ResultKt.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            com.google.firebase.sessions.settings.SessionsSettings r5 = r4.f32653d
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.g(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            com.google.firebase.sessions.settings.SessionsSettings r5 = r0.f32653d
            boolean r5 = r5.d()
            r1 = 0
            if (r5 != 0) goto L54
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r1)
            return r5
        L54:
            boolean r5 = r0.h()
            if (r5 != 0) goto L5f
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r1)
            return r5
        L5f:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.w
    public void a(t sessionDetails) {
        Intrinsics.h(sessionDetails, "sessionDetails");
        kotlinx.coroutines.k.d(o0.a(this.f32655f), null, null, new SessionFirelogPublisherImpl$logSession$1(this, sessionDetails, null), 3, null);
    }
}
