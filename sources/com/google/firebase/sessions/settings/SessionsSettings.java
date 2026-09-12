package com.google.firebase.sessions.settings;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.f;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import com.google.firebase.l;
import com.google.firebase.sessions.q;
import com.google.firebase.sessions.r;
import jc.e;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* loaded from: classes4.dex */
public final class SessionsSettings {

    /* renamed from: c, reason: collision with root package name */
    public static final a f32763c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final ReadOnlyProperty f32764d = PreferenceDataStoreDelegateKt.b(r.f32746a.b(), new j1.b(new Function1<CorruptionException, androidx.datastore.preferences.core.c>() { // from class: com.google.firebase.sessions.settings.SessionsSettings$Companion$dataStore$2
        @Override // kotlin.jvm.functions.Function1
        public final androidx.datastore.preferences.core.c invoke(CorruptionException ex2) {
            Intrinsics.h(ex2, "ex");
            Log.w("SessionsSettings", "CorruptionException in settings DataStore in " + q.f32745a.e() + '.', ex2);
            return androidx.datastore.preferences.core.d.a();
        }
    }), null, null, 12, null);

    /* renamed from: a, reason: collision with root package name */
    private final d f32765a;

    /* renamed from: b, reason: collision with root package name */
    private final d f32766b;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f32767a = {Reflection.j(new PropertyReference2Impl(a.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f b(Context context) {
            return (f) SessionsSettings.f32764d.a(context, f32767a[0]);
        }

        public final SessionsSettings c() {
            Object j11 = l.a(com.google.firebase.c.f31123a).j(SessionsSettings.class);
            Intrinsics.g(j11, "Firebase.app[SessionsSettings::class.java]");
            return (SessionsSettings) j11;
        }
    }

    private SessionsSettings(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, e eVar, com.google.firebase.sessions.b bVar) {
        this(new b(context), new RemoteSettings(coroutineContext2, eVar, bVar, new RemoteSettingsFetcher(bVar, coroutineContext, null, 4, null), f32763c.b(context)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SessionsSettings(com.google.firebase.f r8, kotlin.coroutines.CoroutineContext r9, kotlin.coroutines.CoroutineContext r10, jc.e r11) {
        /*
            r7 = this;
            java.lang.String r0 = "firebaseApp"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            java.lang.String r0 = "blockingDispatcher"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            java.lang.String r0 = "backgroundDispatcher"
            kotlin.jvm.internal.Intrinsics.h(r10, r0)
            java.lang.String r0 = "firebaseInstallationsApi"
            kotlin.jvm.internal.Intrinsics.h(r11, r0)
            android.content.Context r2 = r8.k()
            java.lang.String r0 = "firebaseApp.applicationContext"
            kotlin.jvm.internal.Intrinsics.g(r2, r0)
            com.google.firebase.sessions.v r0 = com.google.firebase.sessions.v.f32790a
            com.google.firebase.sessions.b r6 = r0.b(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.<init>(com.google.firebase.f, kotlin.coroutines.CoroutineContext, kotlin.coroutines.CoroutineContext, jc.e):void");
    }

    public SessionsSettings(d localOverrideSettings, d remoteSettings) {
        Intrinsics.h(localOverrideSettings, "localOverrideSettings");
        Intrinsics.h(remoteSettings, "remoteSettings");
        this.f32765a = localOverrideSettings;
        this.f32766b = remoteSettings;
    }

    private final boolean e(double d11) {
        return 0.0d <= d11 && d11 <= 1.0d;
    }

    private final boolean f(long j11) {
        return Duration.E(j11) && Duration.z(j11);
    }

    public final double b() {
        Double c11 = this.f32765a.c();
        if (c11 != null) {
            double doubleValue = c11.doubleValue();
            if (e(doubleValue)) {
                return doubleValue;
            }
        }
        Double c12 = this.f32766b.c();
        if (c12 == null) {
            return 1.0d;
        }
        double doubleValue2 = c12.doubleValue();
        if (e(doubleValue2)) {
            return doubleValue2;
        }
        return 1.0d;
    }

    public final long c() {
        Duration b11 = this.f32765a.b();
        if (b11 != null) {
            long rawValue = b11.getRawValue();
            if (f(rawValue)) {
                return rawValue;
            }
        }
        Duration b12 = this.f32766b.b();
        if (b12 != null) {
            long rawValue2 = b12.getRawValue();
            if (f(rawValue2)) {
                return rawValue2;
            }
        }
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.s(30, DurationUnit.MINUTES);
    }

    public final boolean d() {
        Boolean a11 = this.f32765a.a();
        if (a11 != null) {
            return a11.booleanValue();
        }
        Boolean a12 = this.f32766b.a();
        if (a12 != null) {
            return a12.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.settings.SessionsSettings r2 = (com.google.firebase.sessions.settings.SessionsSettings) r2
            kotlin.ResultKt.b(r6)
            goto L4d
        L3c:
            kotlin.ResultKt.b(r6)
            com.google.firebase.sessions.settings.d r6 = r5.f32765a
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r2 = r5
        L4d:
            com.google.firebase.sessions.settings.d r6 = r2.f32766b
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.g(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
