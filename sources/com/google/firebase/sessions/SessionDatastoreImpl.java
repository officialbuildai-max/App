package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.c;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;

/* loaded from: classes4.dex */
public final class SessionDatastoreImpl implements s {

    /* renamed from: f, reason: collision with root package name */
    private static final a f32635f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final ReadOnlyProperty f32636g = PreferenceDataStoreDelegateKt.b(r.f32746a.a(), new j1.b(new Function1<CorruptionException, androidx.datastore.preferences.core.c>() { // from class: com.google.firebase.sessions.SessionDatastoreImpl$Companion$dataStore$2
        @Override // kotlin.jvm.functions.Function1
        public final androidx.datastore.preferences.core.c invoke(CorruptionException ex2) {
            Intrinsics.h(ex2, "ex");
            Log.w("FirebaseSessionsRepo", "CorruptionException in sessions DataStore in " + q.f32745a.e() + '.', ex2);
            return androidx.datastore.preferences.core.d.a();
        }
    }), null, null, 12, null);

    /* renamed from: b, reason: collision with root package name */
    private final Context f32637b;

    /* renamed from: c, reason: collision with root package name */
    private final CoroutineContext f32638c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReference f32639d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.flow.b f32640e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", l = {TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1$a */
        /* loaded from: classes4.dex */
        public static final class a implements kotlinx.coroutines.flow.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ SessionDatastoreImpl f32645a;

            a(SessionDatastoreImpl sessionDatastoreImpl) {
                this.f32645a = sessionDatastoreImpl;
            }

            @Override // kotlinx.coroutines.flow.c
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(i iVar, Continuation continuation) {
                this.f32645a.f32639d.set(iVar);
                return Unit.f67184a;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = SessionDatastoreImpl.this.f32640e;
                a aVar = new a(SessionDatastoreImpl.this);
                this.label = 1;
                if (bVar.a(aVar, this) == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f32646a = {Reflection.j(new PropertyReference2Impl(a.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final androidx.datastore.core.f b(Context context) {
            return (androidx.datastore.core.f) SessionDatastoreImpl.f32636g.a(context, f32646a[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f32647a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final c.a f32648b = androidx.datastore.preferences.core.e.g("session_id");

        private b() {
        }

        public final c.a a() {
            return f32648b;
        }
    }

    public SessionDatastoreImpl(Context context, CoroutineContext backgroundDispatcher) {
        Intrinsics.h(context, "context");
        Intrinsics.h(backgroundDispatcher, "backgroundDispatcher");
        this.f32637b = context;
        this.f32638c = backgroundDispatcher;
        this.f32639d = new AtomicReference();
        final kotlinx.coroutines.flow.b f11 = kotlinx.coroutines.flow.d.f(f32635f.b(context).getData(), new SessionDatastoreImpl$firebaseSessionDataFlow$1(null));
        this.f32640e = new kotlinx.coroutines.flow.b() { // from class: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1

            /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 implements kotlinx.coroutines.flow.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.c f32643a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ SessionDatastoreImpl f32644b;

                @Metadata(k = 3, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
                @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2", f = "SessionDatastore.kt", l = {Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                @SourceDebugExtension
                /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(kotlinx.coroutines.flow.c cVar, SessionDatastoreImpl sessionDatastoreImpl) {
                    this.f32643a = cVar;
                    this.f32644b = sessionDatastoreImpl;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = (com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = new com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.c r6 = r4.f32643a
                        androidx.datastore.preferences.core.c r5 = (androidx.datastore.preferences.core.c) r5
                        com.google.firebase.sessions.SessionDatastoreImpl r2 = r4.f32644b
                        com.google.firebase.sessions.i r5 = com.google.firebase.sessions.SessionDatastoreImpl.h(r2, r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r5 = kotlin.Unit.f67184a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.b
            public Object a(kotlinx.coroutines.flow.c cVar, Continuation continuation) {
                Object a11 = kotlinx.coroutines.flow.b.this.a(new AnonymousClass2(cVar, this), continuation);
                return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
            }
        };
        kotlinx.coroutines.k.d(o0.a(backgroundDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i i(androidx.datastore.preferences.core.c cVar) {
        return new i((String) cVar.b(b.f32647a.a()));
    }

    @Override // com.google.firebase.sessions.s
    public String a() {
        i iVar = (i) this.f32639d.get();
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }

    @Override // com.google.firebase.sessions.s
    public void b(String sessionId) {
        Intrinsics.h(sessionId, "sessionId");
        kotlinx.coroutines.k.d(o0.a(this.f32638c), null, null, new SessionDatastoreImpl$updateSessionId$1(this, sessionId, null), 3, null);
    }
}
