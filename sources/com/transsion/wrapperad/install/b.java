package com.transsion.wrapperad.install;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.view.e;
import androidx.view.f;
import androidx.view.g0;
import androidx.view.u;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final b f58298a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static Context f58299b;

    /* renamed from: c, reason: collision with root package name */
    private static AppChangeReceiver f58300c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f58301d;

    private b() {
    }

    private final String a() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final void c() {
        if (f58301d) {
            return;
        }
        f58300c = new AppChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        Context context = null;
        if (Build.VERSION.SDK_INT >= 33) {
            Context context2 = f58299b;
            if (context2 == null) {
                Intrinsics.z("appContext");
            } else {
                context = context2;
            }
            context.registerReceiver(f58300c, intentFilter, 4);
        } else {
            Context context3 = f58299b;
            if (context3 == null) {
                Intrinsics.z("appContext");
            } else {
                context = context3;
            }
            context.registerReceiver(f58300c, intentFilter);
        }
        f58301d = true;
    }

    private final void d() {
        if (f58301d) {
            AppChangeReceiver appChangeReceiver = f58300c;
            if (appChangeReceiver != null) {
                try {
                    Context context = f58299b;
                    if (context == null) {
                        Intrinsics.z("appContext");
                        context = null;
                    }
                    context.unregisterReceiver(appChangeReceiver);
                } catch (IllegalArgumentException unused) {
                }
            }
            f58300c = null;
            f58301d = false;
        }
    }

    public final void b(Application application) {
        Intrinsics.h(application, "application");
        f58299b = application.getApplicationContext();
        g0.f9674i.a().getLifecycle().a(this);
        a.f58297a.a(a() + " --> init() --> 初始化成功");
    }

    @Override // androidx.view.f
    public /* synthetic */ void onCreate(u uVar) {
        e.a(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onDestroy(u uVar) {
        e.b(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onPause(u uVar) {
        e.c(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onResume(u uVar) {
        e.d(this, uVar);
    }

    @Override // androidx.view.f
    public void onStart(u owner) {
        Intrinsics.h(owner, "owner");
        d();
        c();
    }

    @Override // androidx.view.f
    public void onStop(u owner) {
        Intrinsics.h(owner, "owner");
        d();
    }
}
