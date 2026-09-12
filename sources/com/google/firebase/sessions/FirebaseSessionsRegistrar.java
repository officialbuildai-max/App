package com.google.firebase.sessions;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i0;
import mb.c;

@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\b\u001a0\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "Lmb/c;", "", "kotlin.jvm.PlatformType", "getComponents", "()Ljava/util/List;", "Companion", "a", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes4.dex */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final a Companion = new a(null);
    private static final String LIBRARY_NAME = "fire-sessions";
    private static final mb.b0 backgroundDispatcher;
    private static final mb.b0 blockingDispatcher;
    private static final mb.b0 firebaseApp;
    private static final mb.b0 firebaseInstallationsApi;
    private static final mb.b0 sessionLifecycleServiceBinder;
    private static final mb.b0 sessionsSettings;
    private static final mb.b0 transportFactory;

    /* loaded from: classes4.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        mb.b0 b11 = mb.b0.b(com.google.firebase.f.class);
        Intrinsics.g(b11, "unqualified(FirebaseApp::class.java)");
        firebaseApp = b11;
        mb.b0 b12 = mb.b0.b(jc.e.class);
        Intrinsics.g(b12, "unqualified(FirebaseInstallationsApi::class.java)");
        firebaseInstallationsApi = b12;
        mb.b0 a11 = mb.b0.a(lb.a.class, i0.class);
        Intrinsics.g(a11, "qualified(Background::cl…neDispatcher::class.java)");
        backgroundDispatcher = a11;
        mb.b0 a12 = mb.b0.a(lb.b.class, i0.class);
        Intrinsics.g(a12, "qualified(Blocking::clas…neDispatcher::class.java)");
        blockingDispatcher = a12;
        mb.b0 b13 = mb.b0.b(r8.i.class);
        Intrinsics.g(b13, "unqualified(TransportFactory::class.java)");
        transportFactory = b13;
        mb.b0 b14 = mb.b0.b(SessionsSettings.class);
        Intrinsics.g(b14, "unqualified(SessionsSettings::class.java)");
        sessionsSettings = b14;
        mb.b0 b15 = mb.b0.b(y.class);
        Intrinsics.g(b15, "unqualified(SessionLifec…erviceBinder::class.java)");
        sessionLifecycleServiceBinder = b15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessions getComponents$lambda$0(mb.e eVar) {
        Object c11 = eVar.c(firebaseApp);
        Intrinsics.g(c11, "container[firebaseApp]");
        Object c12 = eVar.c(sessionsSettings);
        Intrinsics.g(c12, "container[sessionsSettings]");
        Object c13 = eVar.c(backgroundDispatcher);
        Intrinsics.g(c13, "container[backgroundDispatcher]");
        Object c14 = eVar.c(sessionLifecycleServiceBinder);
        Intrinsics.g(c14, "container[sessionLifecycleServiceBinder]");
        return new FirebaseSessions((com.google.firebase.f) c11, (SessionsSettings) c12, (CoroutineContext) c13, (y) c14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionGenerator getComponents$lambda$1(mb.e eVar) {
        return new SessionGenerator(c0.f32733a, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w getComponents$lambda$2(mb.e eVar) {
        Object c11 = eVar.c(firebaseApp);
        Intrinsics.g(c11, "container[firebaseApp]");
        com.google.firebase.f fVar = (com.google.firebase.f) c11;
        Object c12 = eVar.c(firebaseInstallationsApi);
        Intrinsics.g(c12, "container[firebaseInstallationsApi]");
        jc.e eVar2 = (jc.e) c12;
        Object c13 = eVar.c(sessionsSettings);
        Intrinsics.g(c13, "container[sessionsSettings]");
        SessionsSettings sessionsSettings2 = (SessionsSettings) c13;
        ic.b g11 = eVar.g(transportFactory);
        Intrinsics.g(g11, "container.getProvider(transportFactory)");
        f fVar2 = new f(g11);
        Object c14 = eVar.c(backgroundDispatcher);
        Intrinsics.g(c14, "container[backgroundDispatcher]");
        return new SessionFirelogPublisherImpl(fVar, eVar2, sessionsSettings2, fVar2, (CoroutineContext) c14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionsSettings getComponents$lambda$3(mb.e eVar) {
        Object c11 = eVar.c(firebaseApp);
        Intrinsics.g(c11, "container[firebaseApp]");
        Object c12 = eVar.c(blockingDispatcher);
        Intrinsics.g(c12, "container[blockingDispatcher]");
        Object c13 = eVar.c(backgroundDispatcher);
        Intrinsics.g(c13, "container[backgroundDispatcher]");
        Object c14 = eVar.c(firebaseInstallationsApi);
        Intrinsics.g(c14, "container[firebaseInstallationsApi]");
        return new SessionsSettings((com.google.firebase.f) c11, (CoroutineContext) c12, (CoroutineContext) c13, (jc.e) c14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s getComponents$lambda$4(mb.e eVar) {
        Context k11 = ((com.google.firebase.f) eVar.c(firebaseApp)).k();
        Intrinsics.g(k11, "container[firebaseApp].applicationContext");
        Object c11 = eVar.c(backgroundDispatcher);
        Intrinsics.g(c11, "container[backgroundDispatcher]");
        return new SessionDatastoreImpl(k11, (CoroutineContext) c11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y getComponents$lambda$5(mb.e eVar) {
        Object c11 = eVar.c(firebaseApp);
        Intrinsics.g(c11, "container[firebaseApp]");
        return new z((com.google.firebase.f) c11);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<mb.c> getComponents() {
        c.b h11 = mb.c.c(FirebaseSessions.class).h(LIBRARY_NAME);
        mb.b0 b0Var = firebaseApp;
        c.b b11 = h11.b(mb.r.l(b0Var));
        mb.b0 b0Var2 = sessionsSettings;
        c.b b12 = b11.b(mb.r.l(b0Var2));
        mb.b0 b0Var3 = backgroundDispatcher;
        mb.c d11 = b12.b(mb.r.l(b0Var3)).b(mb.r.l(sessionLifecycleServiceBinder)).f(new mb.h() { // from class: com.google.firebase.sessions.j
            @Override // mb.h
            public final Object a(mb.e eVar) {
                FirebaseSessions components$lambda$0;
                components$lambda$0 = FirebaseSessionsRegistrar.getComponents$lambda$0(eVar);
                return components$lambda$0;
            }
        }).e().d();
        mb.c d12 = mb.c.c(SessionGenerator.class).h("session-generator").f(new mb.h() { // from class: com.google.firebase.sessions.k
            @Override // mb.h
            public final Object a(mb.e eVar) {
                SessionGenerator components$lambda$1;
                components$lambda$1 = FirebaseSessionsRegistrar.getComponents$lambda$1(eVar);
                return components$lambda$1;
            }
        }).d();
        c.b b13 = mb.c.c(w.class).h("session-publisher").b(mb.r.l(b0Var));
        mb.b0 b0Var4 = firebaseInstallationsApi;
        return CollectionsKt.o(d11, d12, b13.b(mb.r.l(b0Var4)).b(mb.r.l(b0Var2)).b(mb.r.n(transportFactory)).b(mb.r.l(b0Var3)).f(new mb.h() { // from class: com.google.firebase.sessions.l
            @Override // mb.h
            public final Object a(mb.e eVar) {
                w components$lambda$2;
                components$lambda$2 = FirebaseSessionsRegistrar.getComponents$lambda$2(eVar);
                return components$lambda$2;
            }
        }).d(), mb.c.c(SessionsSettings.class).h("sessions-settings").b(mb.r.l(b0Var)).b(mb.r.l(blockingDispatcher)).b(mb.r.l(b0Var3)).b(mb.r.l(b0Var4)).f(new mb.h() { // from class: com.google.firebase.sessions.m
            @Override // mb.h
            public final Object a(mb.e eVar) {
                SessionsSettings components$lambda$3;
                components$lambda$3 = FirebaseSessionsRegistrar.getComponents$lambda$3(eVar);
                return components$lambda$3;
            }
        }).d(), mb.c.c(s.class).h("sessions-datastore").b(mb.r.l(b0Var)).b(mb.r.l(b0Var3)).f(new mb.h() { // from class: com.google.firebase.sessions.n
            @Override // mb.h
            public final Object a(mb.e eVar) {
                s components$lambda$4;
                components$lambda$4 = FirebaseSessionsRegistrar.getComponents$lambda$4(eVar);
                return components$lambda$4;
            }
        }).d(), mb.c.c(y.class).h("sessions-service-binder").b(mb.r.l(b0Var)).f(new mb.h() { // from class: com.google.firebase.sessions.o
            @Override // mb.h
            public final Object a(mb.e eVar) {
                y components$lambda$5;
                components$lambda$5 = FirebaseSessionsRegistrar.getComponents$lambda$5(eVar);
                return components$lambda$5;
            }
        }).d(), xc.h.b(LIBRARY_NAME, "2.0.7"));
    }
}
