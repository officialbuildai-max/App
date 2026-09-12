package com.transsion.wrapperad.install.ui;

import android.os.Handler;
import android.os.Looper;
import com.transsion.wrapperad.install.appinfo.AppChangeInfo;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private static AppChangeInfo f58323b;

    /* renamed from: e, reason: collision with root package name */
    private static a f58326e;

    /* renamed from: a, reason: collision with root package name */
    public static final d f58322a = new d();

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f58324c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentLinkedQueue f58325d = new ConcurrentLinkedQueue();

    /* renamed from: f, reason: collision with root package name */
    private static final Handler f58327f = new Handler(Looper.getMainLooper());

    private d() {
    }

    private final void e(AppChangeInfo appChangeInfo) {
        if (appChangeInfo == null) {
            com.transsion.wrapperad.install.a.f58297a.a(k() + " --> displayTask() --> info == null");
            return;
        }
        AtomicBoolean atomicBoolean = f58324c;
        if (atomicBoolean.get()) {
            com.transsion.wrapperad.install.a.f58297a.a(k() + " --> displayTask() --> isTaskShowing == true");
            return;
        }
        atomicBoolean.set(true);
        f58323b = appChangeInfo;
        final int l11 = yx.a.f79208a.l();
        Handler handler = f58327f;
        handler.post(new Runnable() { // from class: com.transsion.wrapperad.install.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                d.f(l11);
            }
        });
        handler.postDelayed(new Runnable() { // from class: com.transsion.wrapperad.install.ui.c
            @Override // java.lang.Runnable
            public final void run() {
                d.g();
            }
        }, l11 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i11) {
        a aVar = f58326e;
        if (aVar != null) {
            aVar.onAppInstalledTipStart();
        }
        com.transsion.wrapperad.install.a aVar2 = com.transsion.wrapperad.install.a.f58297a;
        String k11 = f58322a.k();
        a aVar3 = f58326e;
        aVar2.a(k11 + " --> displayTask() --> listener = " + (aVar3 != null ? Integer.valueOf(aVar3.hashCode()) : null) + " --> items = " + i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        f58323b = null;
        com.transsion.wrapperad.install.a aVar = com.transsion.wrapperad.install.a.f58297a;
        d dVar = f58322a;
        aVar.a(dVar.k() + " --> displayTask() --> 时间到自动关闭");
        a aVar2 = f58326e;
        if (aVar2 != null) {
            aVar2.onAppInstalledTipEnd();
        }
        f58324c.set(false);
        aVar.a(dVar.k() + " --> displayTask() --> isTaskShowing = false");
        i(dVar, false, 1, null);
    }

    public static /* synthetic */ void i(d dVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        dVar.h(z10);
    }

    private final String k() {
        String simpleName = f58322a.getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void c(AppChangeInfo info) {
        Intrinsics.h(info, "info");
        f58325d.add(info);
        com.transsion.wrapperad.install.a.f58297a.a(k() + " --> addAppChangeInfo() --> " + info.getPackageName());
        i(this, false, 1, null);
    }

    public final void d() {
        f58326e = null;
        f58327f.removeCallbacksAndMessages(null);
    }

    public final void h(boolean z10) {
        if (f58323b != null) {
            com.transsion.wrapperad.install.a aVar = com.transsion.wrapperad.install.a.f58297a;
            String k11 = k();
            AppChangeInfo appChangeInfo = f58323b;
            aVar.a(k11 + " --> doNextTask() --> 正在展示 pkg = " + (appChangeInfo != null ? appChangeInfo.getPackageName() : null) + "--> 返回 ");
            return;
        }
        AppChangeInfo appChangeInfo2 = (AppChangeInfo) f58325d.poll();
        com.transsion.wrapperad.install.a.f58297a.a(k() + " --> doNextTask() --> " + (appChangeInfo2 != null ? appChangeInfo2.getPackageName() : null) + " --> 消息清空");
        e(appChangeInfo2);
    }

    public final AppChangeInfo j() {
        AppChangeInfo appChangeInfo = f58323b;
        if (appChangeInfo != null) {
            return appChangeInfo;
        }
        i(this, false, 1, null);
        return f58323b;
    }

    public final void l(a aVar) {
        f58326e = aVar;
    }
}
