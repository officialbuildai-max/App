package com.google.firebase.sessions.settings;

import androidx.datastore.core.f;
import androidx.datastore.preferences.core.c;
import androidx.datastore.preferences.core.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.n0;

/* loaded from: classes4.dex */
public final class SettingsCache {

    /* renamed from: c, reason: collision with root package name */
    private static final a f32768c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final c.a f32769d = e.a("firebase_sessions_enabled");

    /* renamed from: e, reason: collision with root package name */
    private static final c.a f32770e = e.c("firebase_sessions_sampling_rate");

    /* renamed from: f, reason: collision with root package name */
    private static final c.a f32771f = e.e("firebase_sessions_restart_timeout");

    /* renamed from: g, reason: collision with root package name */
    private static final c.a f32772g = e.e("firebase_sessions_cache_duration");

    /* renamed from: h, reason: collision with root package name */
    private static final c.a f32773h = e.f("firebase_sessions_cache_updated_time");

    /* renamed from: a, reason: collision with root package name */
    private final f f32774a;

    /* renamed from: b, reason: collision with root package name */
    private c f32775b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

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
            SettingsCache settingsCache;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                kotlinx.coroutines.flow.b data = settingsCache2.f32774a.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object p11 = kotlinx.coroutines.flow.d.p(data, this);
                if (p11 == f11) {
                    return f11;
                }
                settingsCache = settingsCache2;
                obj = p11;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = (SettingsCache) this.L$0;
                ResultKt.b(obj);
            }
            settingsCache.l(((androidx.datastore.preferences.core.c) obj).d());
            return Unit.f67184a;
        }
    }

    /* loaded from: classes4.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SettingsCache(f dataStore) {
        Intrinsics.h(dataStore, "dataStore");
        this.f32774a = dataStore;
        j.b(null, new AnonymousClass1(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        android.util.Log.w("SettingsCache", "Failed to update cache config value: " + r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(androidx.datastore.preferences.core.c.a r6, java.lang.Object r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            if (r0 == 0) goto L13
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.io.IOException -> L29
            goto L5d
        L29:
            r6 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.b(r8)
            androidx.datastore.core.f r8 = r5.f32774a     // Catch: java.io.IOException -> L29
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch: java.io.IOException -> L29
            r0.label = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r8, r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5d
            return r1
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L5d:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.h(androidx.datastore.preferences.core.c$a, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(androidx.datastore.preferences.core.c cVar) {
        this.f32775b = new c((Boolean) cVar.b(f32769d), (Double) cVar.b(f32770e), (Integer) cVar.b(f32771f), (Integer) cVar.b(f32772g), (Long) cVar.b(f32773h));
    }

    public final boolean d() {
        c cVar = this.f32775b;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.z("sessionConfigs");
            cVar = null;
        }
        Long b11 = cVar.b();
        c cVar3 = this.f32775b;
        if (cVar3 == null) {
            Intrinsics.z("sessionConfigs");
        } else {
            cVar2 = cVar3;
        }
        Integer a11 = cVar2.a();
        return b11 == null || a11 == null || (System.currentTimeMillis() - b11.longValue()) / ((long) 1000) >= ((long) a11.intValue());
    }

    public final Integer e() {
        c cVar = this.f32775b;
        if (cVar == null) {
            Intrinsics.z("sessionConfigs");
            cVar = null;
        }
        return cVar.d();
    }

    public final Double f() {
        c cVar = this.f32775b;
        if (cVar == null) {
            Intrinsics.z("sessionConfigs");
            cVar = null;
        }
        return cVar.e();
    }

    public final Boolean g() {
        c cVar = this.f32775b;
        if (cVar == null) {
            Intrinsics.z("sessionConfigs");
            cVar = null;
        }
        return cVar.c();
    }

    public final Object i(Double d11, Continuation continuation) {
        Object h11 = h(f32770e, d11, continuation);
        return h11 == IntrinsicsKt.f() ? h11 : Unit.f67184a;
    }

    public final Object j(Integer num, Continuation continuation) {
        Object h11 = h(f32772g, num, continuation);
        return h11 == IntrinsicsKt.f() ? h11 : Unit.f67184a;
    }

    public final Object k(Long l11, Continuation continuation) {
        Object h11 = h(f32773h, l11, continuation);
        return h11 == IntrinsicsKt.f() ? h11 : Unit.f67184a;
    }

    public final Object m(Integer num, Continuation continuation) {
        Object h11 = h(f32771f, num, continuation);
        return h11 == IntrinsicsKt.f() ? h11 : Unit.f67184a;
    }

    public final Object n(Boolean bool, Continuation continuation) {
        Object h11 = h(f32769d, bool, continuation);
        return h11 == IntrinsicsKt.f() ? h11 : Unit.f67184a;
    }
}
