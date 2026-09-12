package com.google.firebase.sessions.settings;

import androidx.datastore.core.f;
import jc.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.g;

/* loaded from: classes4.dex */
public final class RemoteSettings implements d {

    /* renamed from: g, reason: collision with root package name */
    private static final a f32752g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final CoroutineContext f32753a;

    /* renamed from: b, reason: collision with root package name */
    private final e f32754b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.firebase.sessions.b f32755c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.sessions.settings.a f32756d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f32757e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlinx.coroutines.sync.a f32758f;

    /* loaded from: classes4.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteSettings(CoroutineContext backgroundDispatcher, e firebaseInstallationsApi, com.google.firebase.sessions.b appInfo, com.google.firebase.sessions.settings.a configsFetcher, final f dataStore) {
        Intrinsics.h(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.h(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.h(appInfo, "appInfo");
        Intrinsics.h(configsFetcher, "configsFetcher");
        Intrinsics.h(dataStore, "dataStore");
        this.f32753a = backgroundDispatcher;
        this.f32754b = firebaseInstallationsApi;
        this.f32755c = appInfo;
        this.f32756d = configsFetcher;
        this.f32757e = LazyKt.b(new Function0<SettingsCache>() { // from class: com.google.firebase.sessions.settings.RemoteSettings$settingsCache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SettingsCache invoke() {
                return new SettingsCache(f.this);
            }
        });
        this.f32758f = g.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsCache f() {
        return (SettingsCache) this.f32757e.getValue();
    }

    private final String g(String str) {
        return new Regex("/").replace(str, "");
    }

    @Override // com.google.firebase.sessions.settings.d
    public Boolean a() {
        return f().g();
    }

    @Override // com.google.firebase.sessions.settings.d
    public Duration b() {
        Integer e11 = f().e();
        if (e11 == null) {
            return null;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.g(DurationKt.s(e11.intValue(), DurationUnit.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.d
    public Double c() {
        return f().f();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ab, B:29:0x00b9, B:32:0x00c6, B:37:0x008a, B:39:0x0094, B:42:0x009a), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6 A[Catch: all -> 0x0051, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ab, B:29:0x00b9, B:32:0x00c6, B:37:0x008a, B:39:0x0094, B:42:0x009a), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ab, B:29:0x00b9, B:32:0x00c6, B:37:0x008a, B:39:0x0094, B:42:0x009a), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x0051, TRY_ENTER, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ab, B:29:0x00b9, B:32:0x00c6, B:37:0x008a, B:39:0x0094, B:42:0x009a), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    @Override // com.google.firebase.sessions.settings.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(kotlin.coroutines.Continuation r17) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.d(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
