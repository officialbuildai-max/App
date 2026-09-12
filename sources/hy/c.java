package hy;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.ps.installed.AppInstallManager;
import com.transsion.wrapperad.install.appinfo.AppChangeInfo;
import com.transsion.wrapperad.install.ui.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f64968a = new c();

    private c() {
    }

    public final void a(Context context, AppChangeInfo info) {
        Object m1185constructorimpl;
        Intrinsics.h(context, "context");
        Intrinsics.h(info, "info");
        try {
            Result.Companion companion = Result.INSTANCE;
            yx.a aVar = yx.a.f79208a;
            if (aVar.m()) {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(info.getPackageName());
                if (launchIntentForPackage == null) {
                    return;
                }
                launchIntentForPackage.addFlags(ASTNode.DEOP);
                com.transsion.wrapperad.install.a.f58297a.a("AppLaunchNotifier --> launchDirect() --> 拉起应用 " + info.getAppName());
                context.startActivity(launchIntentForPackage);
                AppInstallManager appInstallManager = AppInstallManager.f42250a;
                Application a11 = Utils.a();
                Intrinsics.g(a11, "getApp(...)");
                appInstallManager.f(a11, info.getPackageName());
            } else if (!aVar.n()) {
                com.transsion.wrapperad.install.a.f58297a.a("AppLaunchNotifier --> launchDirect() --> isShowInstalledGuideTipView == false");
            } else if (b.f64967a.a(context)) {
                d.f58322a.c(info);
            } else {
                com.transsion.wrapperad.install.a.f58297a.a("AppLaunchNotifier --> launchDirect() --> isShowInstalledGuideTipView == false -- 不在前台");
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            com.transsion.wrapperad.install.a.f58297a.a("AppLaunchNotifier --> launchDirect() --> it = " + m1188exceptionOrNullimpl);
        }
    }
}
