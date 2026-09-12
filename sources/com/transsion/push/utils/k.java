package com.transsion.push.utils;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import com.meituan.android.walle.ChannelReader;
import com.therouter.TheRouter;
import com.transsion.lib.push.R$mipmap;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.push.api.IPushProvider;
import com.transsion.sunflower.FSNConfig;
import com.transsion.sunflower.FSNManager;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    private static FSNConfig f50990b;

    /* renamed from: a, reason: collision with root package name */
    public static final k f50989a = new k();

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f50991c = LazyKt.b(new Function0() { // from class: com.transsion.push.utils.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            FSNManager k11;
            k11 = k.k();
            return k11;
        }
    });

    private k() {
    }

    private final Intent f(String str) {
        Object m1185constructorimpl;
        if (str == null) {
            return null;
        }
        IPushProvider iPushProvider = (IPushProvider) TheRouter.d(IPushProvider.class, new Object[0]);
        if (iPushProvider != null) {
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            Intent a12 = iPushProvider.a(a11);
            a12.addFlags(603979776);
            a12.setAction("android.intent.action.VIEW");
            a12.setData(Uri.parse(str).buildUpon().appendQueryParameter(ChannelReader.CHANNEL_KEY, "alive").build());
            return a12;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Uri parse = Uri.parse(str);
            Intrinsics.g(parse, "parse(...)");
            m1185constructorimpl = Result.m1185constructorimpl(ak.k.m(parse).n());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return (Intent) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
    }

    private final void g() {
        if (f50990b == null) {
            j().t(h());
        }
    }

    private final FSNConfig h() {
        String str;
        Object m1185constructorimpl;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_dauupupup_config", true);
        if (c11 == null || (str = c11.getValue()) == null) {
            str = "";
        }
        a.C0856a.f(lg.a.f68962a, "qqqq", "getAppConfig: json:" + str, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl((FSNConfig) com.blankj.utilcode.util.o.e(str, com.blankj.utilcode.util.o.h(FSNConfig.class, new Type[0])));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        FSNConfig fSNConfig = null;
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        FSNConfig fSNConfig2 = (FSNConfig) m1185constructorimpl;
        FSNConfig i11 = i();
        if (fSNConfig2 != null && i11 != null) {
            fSNConfig2.setEnable(i11.getEnable() && fSNConfig2.getEnable());
            fSNConfig = fSNConfig2;
        }
        f50990b = fSNConfig;
        return fSNConfig;
    }

    private final FSNConfig i() {
        String str;
        ConfigBean c11 = sm.f.f75530c.a().c("dauupupup_config", true);
        if (c11 == null || (str = c11.getValue()) == null) {
            str = "";
        }
        a.C0856a.f(lg.a.f68962a, "qqqq", "getAppConfigB: json:" + str, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            return (FSNConfig) com.blankj.utilcode.util.o.e(str, com.blankj.utilcode.util.o.h(FSNConfig.class, new Type[0]));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            return (FSNConfig) m1185constructorimpl;
        }
    }

    private final FSNManager j() {
        return (FSNManager) f50991c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FSNManager k() {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        com.transsion.sunflower.d dVar = new com.transsion.sunflower.d(a11);
        dVar.n(R$mipmap.ic_notification_logo);
        dVar.m(com.blankj.utilcode.util.c.j());
        dVar.k(new Function0() { // from class: com.transsion.push.utils.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean l11;
                l11 = k.l();
                return Boolean.valueOf(l11);
            }
        });
        dVar.q(new Function0() { // from class: com.transsion.push.utils.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean m11;
                m11 = k.m();
                return Boolean.valueOf(m11);
            }
        });
        k kVar = f50989a;
        dVar.l(kVar.h());
        FSNConfig b11 = dVar.b();
        dVar.r(kVar.f(b11 != null ? b11.getDeepLink() : null));
        dVar.o(new Function1() { // from class: com.transsion.push.utils.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n11;
                n11 = k.n((String) obj);
                return n11;
            }
        });
        dVar.p(new Function1() { // from class: com.transsion.push.utils.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o11;
                o11 = k.o((String) obj);
                return o11;
            }
        });
        return dVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l() {
        return com.transsion.baselib.report.l.f43413a.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m() {
        return com.transsion.baselib.report.l.f43413a.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(String msg) {
        Intrinsics.h(msg, "msg");
        a.C0856a.f(lg.a.f68962a, "qqqq", "sendFSI failed- msg:" + msg, false, 4, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(String msg) {
        Intrinsics.h(msg, "msg");
        a.C0856a.f(lg.a.f68962a, "qqqq", "sendFSI show- msg:" + msg, false, 4, null);
        com.transsion.push.helper.g.f50917a.a(msg);
        return Unit.f67184a;
    }

    public final void p(String str) {
        g();
        j().n(str);
    }

    public final void q() {
        g();
        j().o();
    }
}
