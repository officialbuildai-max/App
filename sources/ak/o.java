package ak;

import com.tencent.mmkv.MMKV;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yg.b;

/* loaded from: classes5.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    private static String f722b;

    /* renamed from: a, reason: collision with root package name */
    public static final o f721a = new o();

    /* renamed from: c, reason: collision with root package name */
    private static String f723c = "All";

    /* renamed from: d, reason: collision with root package name */
    private static String f724d = "UN_GRADE";

    private o() {
    }

    private final boolean h() {
        String value;
        Boolean m12;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_key_kid_mode_ad_switch", false);
        if (c11 == null || (value = c11.getValue()) == null || (m12 = StringsKt.m1(value)) == null) {
            return false;
        }
        return m12.booleanValue();
    }

    private final void k(String str) {
        f722b = str == null ? "" : str;
        MMKV b11 = com.transsion.baselib.report.launch.b.f43424a.b();
        if (str == null) {
            str = "";
        }
        b11.putString("k_kids_mode_current_kid_id", str);
        n();
    }

    public final void a(String kidId) {
        Intrinsics.h(kidId, "kidId");
        if (!i()) {
            com.transsion.baselib.report.launch.b.f43424a.b().putInt("k_kids_mode_ugc_snapshot", g.f714a.b() ? 1 : 0);
        }
        if (!h()) {
            hi.b.f64589a.d(true);
        }
        g.f714a.e(true);
        k(kidId);
        n nVar = new n(kidId);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = n.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, nVar, 0L);
    }

    public final void b() {
        hi.b.f64589a.d(false);
        k(null);
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        int i11 = bVar.b().getInt("k_kids_mode_ugc_snapshot", -1);
        if (i11 != -1) {
            g.f714a.e(i11 == 1);
            bVar.b().putInt("k_kids_mode_ugc_snapshot", -1);
        }
        n nVar = new n(null);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = n.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, nVar, 0L);
    }

    public final String c() {
        return String.valueOf(w.f730a.b());
    }

    public final String d() {
        if (f722b == null) {
            String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("k_kids_mode_current_kid_id", "");
            f722b = string != null ? string : "";
        }
        String str = f722b;
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    public final String e() {
        return f724d;
    }

    public final String f() {
        return f723c;
    }

    public final boolean g() {
        return !h() && i();
    }

    public final boolean i() {
        String d11 = d();
        return !(d11 == null || d11.length() == 0);
    }

    public final boolean j() {
        String value;
        Boolean m12;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_key_kid_mode_feature_enable", true);
        if (c11 == null || (value = c11.getValue()) == null || (m12 = StringsKt.m1(value)) == null) {
            return false;
        }
        return m12.booleanValue();
    }

    public final void l(String str) {
        Intrinsics.h(str, "<set-?>");
        f724d = str;
    }

    public final void m(String str) {
        Intrinsics.h(str, "<set-?>");
        f723c = str;
    }

    public final void n() {
        b.a aVar = yg.b.f79132a;
        String d11 = d();
        if (d11 == null) {
            d11 = "";
        }
        aVar.b("X-Child-UID", d11);
    }
}
