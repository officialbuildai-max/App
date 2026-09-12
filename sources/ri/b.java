package ri;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.MBAd;
import com.transsion.ad.strategy.AppManager;
import com.transsion.ga.AthenaAnalytics;
import hj.i;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f74656a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f74657b = new AtomicBoolean(false);

    private b() {
    }

    public final void a(String event, Map map, String str) {
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        if (!a.f74654a.a()) {
            oi.a.g(oi.a.f71145a, "Report_ad", "AdReportManager --> onReport() --> 业务线关闭埋点上报，不上报", 0, false, 4, null);
            return;
        }
        if (com.transsion.ad.scene.b.f42256a.i()) {
            oi.a.g(oi.a.f71145a, "Report_ad", "AdReportManager --> onReport() --> 广告数据上报链路已关闭，不上报", 0, false, 4, null);
            return;
        }
        AtomicBoolean atomicBoolean = f74657b;
        if (!atomicBoolean.get()) {
            Application a11 = Utils.a();
            MBAd.a c11 = MBAd.f41805a.c();
            AthenaAnalytics.Q(a11, "mb_ad", 6525, c11 != null ? c11.l() : false, false);
            atomicBoolean.set(true);
            oi.a.c(oi.a.f71145a, "AdReportManager --> onReport() --> 广告埋点Athena初始化完成", 0, false, 6, null);
        }
        map.put("ad_vn", "4.3.3_2");
        map.put("biz_pkg", com.blankj.utilcode.util.c.e());
        map.put("biz_vc", Integer.valueOf(com.blankj.utilcode.util.c.f()));
        map.put("biz_vn", com.blankj.utilcode.util.c.h());
        i iVar = i.f64628a;
        if (str == null) {
            str = "";
        }
        iVar.v(event, map, str, 6525, AppManager.f42271a.a());
    }
}
