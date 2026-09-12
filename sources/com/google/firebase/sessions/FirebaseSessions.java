package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;

/* loaded from: classes4.dex */
public final class FirebaseSessions {

    /* renamed from: c, reason: collision with root package name */
    public static final a f32629c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final com.google.firebase.f f32630a;

    /* renamed from: b, reason: collision with root package name */
    private final SessionsSettings f32631b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {45, Sdk$SDKMetric.SDKMetricType.AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.google.firebase.sessions.FirebaseSessions$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $backgroundDispatcher;
        final /* synthetic */ y $lifecycleServiceBinder;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineContext coroutineContext, y yVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$backgroundDispatcher = coroutineContext;
            this.$lifecycleServiceBinder = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$backgroundDispatcher, this.$lifecycleServiceBinder, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0074  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r5)
                goto L67
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.b(r5)
                goto L2c
            L1e:
                kotlin.ResultKt.b(r5)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r5 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f32686a
                r4.label = r3
                java.lang.Object r5 = r5.c(r4)
                if (r5 != r0) goto L2c
                return r0
            L2c:
                java.util.Map r5 = (java.util.Map) r5
                java.util.Collection r5 = r5.values()
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                boolean r1 = r5 instanceof java.util.Collection
                if (r1 == 0) goto L42
                r1 = r5
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L42
                goto L93
            L42:
                java.util.Iterator r5 = r5.iterator()
            L46:
                boolean r1 = r5.hasNext()
                if (r1 == 0) goto L93
                java.lang.Object r1 = r5.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.a()
                if (r1 == 0) goto L46
                com.google.firebase.sessions.FirebaseSessions r5 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r5 = com.google.firebase.sessions.FirebaseSessions.b(r5)
                r4.label = r2
                java.lang.Object r5 = r5.g(r4)
                if (r5 != r0) goto L67
                return r0
            L67:
                com.google.firebase.sessions.FirebaseSessions r5 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r5 = com.google.firebase.sessions.FirebaseSessions.b(r5)
                boolean r5 = r5.d()
                if (r5 != 0) goto L74
                goto L93
            L74:
                com.google.firebase.sessions.SessionLifecycleClient r5 = new com.google.firebase.sessions.SessionLifecycleClient
                kotlin.coroutines.CoroutineContext r0 = r4.$backgroundDispatcher
                r5.<init>(r0)
                com.google.firebase.sessions.y r0 = r4.$lifecycleServiceBinder
                r5.i(r0)
                com.google.firebase.sessions.a0 r0 = com.google.firebase.sessions.a0.f32683a
                r0.a(r5)
                com.google.firebase.sessions.FirebaseSessions r5 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.f r5 = com.google.firebase.sessions.FirebaseSessions.a(r5)
                com.google.firebase.sessions.h r0 = new com.google.firebase.sessions.h
                r0.<init>()
                r5.h(r0)
            L93:
                kotlin.Unit r5 = kotlin.Unit.f67184a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FirebaseSessions(com.google.firebase.f firebaseApp, SessionsSettings settings, CoroutineContext backgroundDispatcher, y lifecycleServiceBinder) {
        Intrinsics.h(firebaseApp, "firebaseApp");
        Intrinsics.h(settings, "settings");
        Intrinsics.h(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.h(lifecycleServiceBinder, "lifecycleServiceBinder");
        this.f32630a = firebaseApp;
        this.f32631b = settings;
        Context applicationContext = firebaseApp.k().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(a0.f32683a);
            kotlinx.coroutines.k.d(o0.a(backgroundDispatcher), null, null, new AnonymousClass1(backgroundDispatcher, lifecycleServiceBinder, null), 3, null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }
}
