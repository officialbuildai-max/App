package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f32152a;

    /* renamed from: b, reason: collision with root package name */
    private String f32153b;

    /* renamed from: c, reason: collision with root package name */
    private String f32154c;

    /* renamed from: d, reason: collision with root package name */
    private int f32155d;

    /* renamed from: e, reason: collision with root package name */
    private int f32156e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Context context) {
        this.f32152a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(com.google.firebase.f fVar) {
        String d11 = fVar.n().d();
        if (d11 != null) {
            return d11;
        }
        String c11 = fVar.n().c();
        if (!c11.startsWith("1:")) {
            return c11;
        }
        String[] split = c11.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f32152a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e11) {
            Log.w("FirebaseMessaging", "Failed to find package " + e11);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f11 = f(this.f32152a.getPackageName());
        if (f11 != null) {
            this.f32153b = Integer.toString(f11.versionCode);
            this.f32154c = f11.versionName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a() {
        try {
            if (this.f32153b == null) {
                h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f32153b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String b() {
        try {
            if (this.f32154c == null) {
                h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f32154c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int d() {
        PackageInfo f11;
        try {
            if (this.f32155d == 0 && (f11 = f("com.google.android.gms")) != null) {
                this.f32155d = f11.versionCode;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f32155d;
    }

    synchronized int e() {
        int i11 = this.f32156e;
        if (i11 != 0) {
            return i11;
        }
        PackageManager packageManager = this.f32152a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f32156e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f32156e = 2;
            return 2;
        }
        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.isAtLeastO()) {
            this.f32156e = 2;
        } else {
            this.f32156e = 1;
        }
        return this.f32156e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return e() != 0;
    }
}
