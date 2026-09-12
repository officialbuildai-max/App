package rm;

import android.os.Build;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.google.gson.JsonArray;
import com.transsion.mb.config.download.AppStartConfig;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceLoader;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import lz.h;
import sm.f;
import sm.g;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f74690b;

    /* renamed from: c, reason: collision with root package name */
    private static rm.b f74691c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f74692d;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f74696h;

    /* renamed from: a, reason: collision with root package name */
    public static final e f74689a = new e();

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f74693e = LazyKt.b(new Function0() { // from class: rm.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a i11;
            i11 = e.i();
            return i11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static String f74694f = "";

    /* renamed from: g, reason: collision with root package name */
    private static String f74695g = "wefeed-mobile-bff";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f74697a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f74698b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f74699c;

        a(String str, String str2, String str3) {
            this.f74697a = str;
            this.f74698b = str2;
            this.f74699c = str3;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m apply(String str) {
            rm.a k11 = e.f74689a.k();
            String str2 = this.f74697a;
            String str3 = this.f74698b;
            Intrinsics.e(str);
            return k11.a(str2, str3, str, this.f74699c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements lz.d {

        /* renamed from: a, reason: collision with root package name */
        public static final b f74700a = new b();

        b() {
        }

        @Override // lz.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final boolean a(Integer t12, Throwable th2) {
            Intrinsics.h(t12, "t1");
            Intrinsics.h(th2, "<unused var>");
            a.C0856a.f(lg.a.f68962a, "RequestConfig", "retry ing.. t1:" + t12.intValue(), false, 4, null);
            return Intrinsics.c(e.f74689a.l(), Boolean.TRUE) && t12.intValue() <= 1;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends sg.a {
        c() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            a.C0856a.f(lg.a.f68962a, "RequestConfig", "onFailure code: " + str + "  message: " + str2, false, 4, null);
            e.f74692d = false;
            rm.b bVar = e.f74691c;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(AppStartConfig appStartConfig) {
            Object m1185constructorimpl;
            Unit unit;
            super.c(appStartConfig);
            e.f74690b = true;
            e.f74692d = false;
            if (appStartConfig == null) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, "RequestConfig", "onSuccess:" + appStartConfig, false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                JsonArray items = appStartConfig.getItems();
                if (items != null) {
                    f.f75530c.a().j(items);
                }
                String version = appStartConfig.getVersion();
                if (version != null) {
                    sm.d.f75526a.g().putString("configVersion", version);
                }
                rm.b bVar = e.f74691c;
                if (bVar != null) {
                    bVar.b();
                    unit = Unit.f67184a;
                } else {
                    unit = null;
                }
                m1185constructorimpl = Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl == null) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, "RequestConfig", "fail --> it = " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rm.a i() {
        return (rm.a) zg.c.f79537e.a().h(rm.a.class);
    }

    private final String j() {
        if (f74694f.length() > 0) {
            return f74694f;
        }
        if (Build.VERSION.SDK_INT <= 23) {
            f74694f = IntegrationConstants.NAVIGATION_BAR_ALL_ACTION;
            return IntegrationConstants.NAVIGATION_BAR_ALL_ACTION;
        }
        try {
            ServiceLoader load = ServiceLoader.load(g.class);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = load.iterator();
            Intrinsics.g(it, "iterator(...)");
            while (it.hasNext()) {
                linkedHashSet.addAll(((g) it.next()).a());
            }
            f74694f = CollectionsKt.s0(linkedHashSet, ",", null, null, 0, null, null, 62, null);
        } catch (Exception e11) {
            a.C0856a c0856a = lg.a.f68962a;
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            a.C0856a.l(c0856a, "CombinedRequestParam", message, false, 4, null);
            e11.printStackTrace();
            f74694f = IntegrationConstants.NAVIGATION_BAR_ALL_ACTION;
        }
        return f74694f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rm.a k() {
        return (rm.a) f74693e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean l() {
        if (f74696h == null) {
            f74696h = Boolean.valueOf(nh.m.f70597a.e());
        }
        return f74696h;
    }

    public static /* synthetic */ void p(e eVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vg.a.f77447a.a();
        }
        if ((i11 & 2) != 0) {
            str2 = "wefeed-mobile-bff";
        }
        eVar.o(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q() {
        return f74689a.j();
    }

    public final void h() {
        if (f74690b) {
            return;
        }
        p(this, null, f74695g, 1, null);
    }

    public final void m() {
        f74696h = Boolean.TRUE;
        h();
    }

    public final void n() {
        f74696h = Boolean.FALSE;
    }

    public final void o(String host, String path) {
        Intrinsics.h(host, "host");
        Intrinsics.h(path, "path");
        f74695g = path;
        if (f74692d) {
            a.C0856a.f(lg.a.f68962a, "RequestConfig", "requestConfig ing...", false, 4, null);
            return;
        }
        f74692d = true;
        f74690b = false;
        String string = sm.d.f75526a.g().getString("configVersion", "");
        j.r(new Callable() { // from class: rm.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String q11;
                q11 = e.q();
                return q11;
            }
        }).E(qz.a.c()).n(new a(path, host, string != null ? string : "")).f(sg.d.f75472a.e()).y(b.f74700a).subscribe(new c());
    }

    public final void r(rm.b configLoadListener) {
        Intrinsics.h(configLoadListener, "configLoadListener");
        f74691c = configLoadListener;
    }
}
