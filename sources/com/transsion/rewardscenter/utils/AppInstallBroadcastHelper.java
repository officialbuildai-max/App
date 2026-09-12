package com.transsion.rewardscenter.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class AppInstallBroadcastHelper {

    /* renamed from: b, reason: collision with root package name */
    private static BroadcastReceiver f51343b;

    /* renamed from: a, reason: collision with root package name */
    public static final AppInstallBroadcastHelper f51342a = new AppInstallBroadcastHelper();

    /* renamed from: c, reason: collision with root package name */
    public static final int f51344c = 8;

    private AppInstallBroadcastHelper() {
    }

    public final void a(Context context, final Function1 callback) {
        Object m1185constructorimpl;
        Intrinsics.h(context, "context");
        Intrinsics.h(callback, "callback");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        BroadcastReceiver broadcastReceiver = f51343b;
        if (broadcastReceiver != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                context.unregisterReceiver(broadcastReceiver);
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
        f51343b = null;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.transsion.rewardscenter.utils.AppInstallBroadcastHelper$registerAppInstallReceiver$2$receiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    Intrinsics.h(context2, "context");
                    Intrinsics.h(intent, "intent");
                    if (Intrinsics.c(intent.getAction(), "android.intent.action.PACKAGE_ADDED") || Intrinsics.c(intent.getAction(), "android.intent.action.PACKAGE_REPLACED")) {
                        Uri data = intent.getData();
                        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
                        if (schemeSpecificPart != null) {
                            Function1.this.invoke(schemeSpecificPart);
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(broadcastReceiver2, intentFilter);
            f51343b = broadcastReceiver2;
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th3));
        }
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        BroadcastReceiver broadcastReceiver = f51343b;
        if (broadcastReceiver != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                context.unregisterReceiver(broadcastReceiver);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
            f51343b = null;
        }
    }
}
