package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes4.dex */
public class v0 {

    /* renamed from: e, reason: collision with root package name */
    private static v0 f32222e;

    /* renamed from: a, reason: collision with root package name */
    private String f32223a = null;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f32224b = null;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f32225c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Queue f32226d = new ArrayDeque();

    private v0() {
    }

    private int a(Context context, Intent intent) {
        String f11 = f(context, intent);
        if (f11 != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Restricting intent to a specific service: ");
                sb2.append(f11);
            }
            intent.setClassName(context.getPackageName(), f11);
        }
        try {
            if ((e(context) ? e1.h(context, intent) : context.startService(intent)) != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return TTAdConstant.DEEPLINK_FALLBACK_CODE;
        } catch (IllegalStateException e11) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e11);
            return TTAdConstant.AD_ID_IS_NULL_CODE;
        } catch (SecurityException e12) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e12);
            return 401;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized v0 b() {
        v0 v0Var;
        synchronized (v0.class) {
            try {
                if (f32222e == null) {
                    f32222e = new v0();
                }
                v0Var = f32222e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return v0Var;
    }

    private synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        try {
            String str2 = this.f32223a;
            if (str2 != null) {
                return str2;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
                if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                    if (str.startsWith(".")) {
                        this.f32223a = context.getPackageName() + serviceInfo.name;
                    } else {
                        this.f32223a = serviceInfo.name;
                    }
                    return this.f32223a;
                }
                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                return null;
            }
            Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent c() {
        return (Intent) this.f32226d.poll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Context context) {
        if (this.f32225c == null) {
            this.f32225c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f32224b.booleanValue()) {
            Log.isLoggable("FirebaseMessaging", 3);
        }
        return this.f32225c.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(Context context) {
        if (this.f32224b == null) {
            this.f32224b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f32224b.booleanValue()) {
            Log.isLoggable("FirebaseMessaging", 3);
        }
        return this.f32224b.booleanValue();
    }

    public int g(Context context, Intent intent) {
        Log.isLoggable("FirebaseMessaging", 3);
        this.f32226d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
