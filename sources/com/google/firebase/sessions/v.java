package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f32790a = new v();

    /* renamed from: b, reason: collision with root package name */
    private static final bc.a f32791b;

    static {
        bc.a i11 = new dc.d().j(c.f32697a).k(true).i();
        Intrinsics.g(i11, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        f32791b = i11;
    }

    private v() {
    }

    private final DataCollectionState d(SessionSubscriber sessionSubscriber) {
        return sessionSubscriber == null ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : sessionSubscriber.a() ? DataCollectionState.COLLECTION_ENABLED : DataCollectionState.COLLECTION_DISABLED;
    }

    public final u a(com.google.firebase.f firebaseApp, t sessionDetails, SessionsSettings sessionsSettings, Map subscribers, String firebaseInstallationId, String firebaseAuthenticationToken) {
        Intrinsics.h(firebaseApp, "firebaseApp");
        Intrinsics.h(sessionDetails, "sessionDetails");
        Intrinsics.h(sessionsSettings, "sessionsSettings");
        Intrinsics.h(subscribers, "subscribers");
        Intrinsics.h(firebaseInstallationId, "firebaseInstallationId");
        Intrinsics.h(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        return new u(EventType.SESSION_START, new x(sessionDetails.b(), sessionDetails.a(), sessionDetails.c(), sessionDetails.d(), new d(d((SessionSubscriber) subscribers.get(SessionSubscriber.Name.PERFORMANCE)), d((SessionSubscriber) subscribers.get(SessionSubscriber.Name.CRASHLYTICS)), sessionsSettings.b()), firebaseInstallationId, firebaseAuthenticationToken), b(firebaseApp));
    }

    public final b b(com.google.firebase.f firebaseApp) {
        String valueOf;
        long longVersionCode;
        Intrinsics.h(firebaseApp, "firebaseApp");
        Context k11 = firebaseApp.k();
        Intrinsics.g(k11, "firebaseApp.applicationContext");
        String packageName = k11.getPackageName();
        PackageInfo packageInfo = k11.getPackageManager().getPackageInfo(packageName, 0);
        if (Build.VERSION.SDK_INT >= 28) {
            longVersionCode = packageInfo.getLongVersionCode();
            valueOf = String.valueOf(longVersionCode);
        } else {
            valueOf = String.valueOf(packageInfo.versionCode);
        }
        String str = valueOf;
        String c11 = firebaseApp.n().c();
        Intrinsics.g(c11, "firebaseApp.options.applicationId");
        String MODEL = Build.MODEL;
        Intrinsics.g(MODEL, "MODEL");
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.g(RELEASE, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        Intrinsics.g(packageName, "packageName");
        String str2 = packageInfo.versionName;
        String str3 = str2 == null ? str : str2;
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.g(MANUFACTURER, "MANUFACTURER");
        q qVar = q.f32745a;
        Context k12 = firebaseApp.k();
        Intrinsics.g(k12, "firebaseApp.applicationContext");
        p d11 = qVar.d(k12);
        Context k13 = firebaseApp.k();
        Intrinsics.g(k13, "firebaseApp.applicationContext");
        return new b(c11, MODEL, "2.0.7", RELEASE, logEnvironment, new a(packageName, str3, str, MANUFACTURER, d11, qVar.c(k13)));
    }

    public final bc.a c() {
        return f32791b;
    }
}
