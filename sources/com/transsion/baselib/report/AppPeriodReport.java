package com.transsion.baselib.report;

import android.os.SystemClock;
import android.util.Log;
import androidx.view.g0;
import androidx.view.u;
import com.transsion.mb.config.manager.ConfigBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes.dex */
public final class AppPeriodReport implements androidx.view.f {

    /* renamed from: a, reason: collision with root package name */
    public static final AppPeriodReport f43386a;

    /* renamed from: b, reason: collision with root package name */
    private static Timer f43387b;

    /* renamed from: c, reason: collision with root package name */
    private static TimerTask f43388c;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f43389d;

    /* renamed from: e, reason: collision with root package name */
    private static long f43390e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f43391f;

    /* renamed from: g, reason: collision with root package name */
    private static Long f43392g;

    /* renamed from: h, reason: collision with root package name */
    private static long f43393h;

    static {
        AppPeriodReport appPeriodReport = new AppPeriodReport();
        f43386a = appPeriodReport;
        boolean c11 = appPeriodReport.c("app_period_report_debug", 3);
        f43389d = c11;
        f43390e = c11 ? 5000L : 300000L;
        f43391f = true;
        f43393h = c11 ? 300L : 3000L;
    }

    private AppPeriodReport() {
    }

    private final boolean c(String str, int i11) {
        try {
            return Log.isLoggable(str, i11);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ void e(AppPeriodReport appPeriodReport, Long l11, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = null;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        appPeriodReport.d(l11, z10);
    }

    public final void b() {
        String value;
        Long x10;
        ConfigBean c11 = sm.f.f75530c.a().c("key_app_period_report", false);
        long longValue = (c11 == null || (value = c11.getValue()) == null || (x10 = StringsKt.x(value)) == null) ? f43390e : x10.longValue();
        if (longValue == 0) {
            longValue = f43390e;
        }
        f43390e = longValue;
        if (longValue > 0) {
            f(true);
            g0.f9674i.a().getLifecycle().a(f43386a);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "AppPeriodReport", "event close period " + f43390e + " ", false, 4, null);
        g0.f9674i.a().getLifecycle().d(f43386a);
    }

    public final void d(Long l11, boolean z10) {
        Long valueOf;
        String value;
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = f43390e;
        if (l11 != null && l11.longValue() == j11) {
            valueOf = Long.valueOf(f43390e);
        } else {
            Long l12 = f43392g;
            valueOf = l12 != null ? Long.valueOf(elapsedRealtime - l12.longValue()) : null;
        }
        f43392g = Long.valueOf(elapsedRealtime);
        if (valueOf == null || valueOf.longValue() <= f43393h) {
            return;
        }
        String str2 = z10 ? "app_background" : "app_foreground";
        String str3 = "0";
        if (z10) {
            String format = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date());
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            String string = bVar.b().getString("k_last_bg_alive_date", "");
            if (!Intrinsics.c(format, string != null ? string : "")) {
                bVar.b().putString("k_last_bg_alive_date", format);
                hj.i iVar = hj.i.f64628a;
                ConfigBean c11 = sm.f.f75530c.a().c("keyAliveOff", true);
                if (c11 == null || (str = c11.getValue()) == null) {
                    str = "0";
                }
                iVar.s("app_bg_alive", "app_perf", MapsKt.j(TuplesKt.a("alive_off", str)));
            }
        }
        a.C0856a.f(lg.a.f68962a, "AppPeriodReport", "report event " + str2 + " " + valueOf, false, 4, null);
        HashMap hashMap = new HashMap();
        ConfigBean c12 = sm.f.f75530c.a().c("keyAliveOff", true);
        if (c12 != null && (value = c12.getValue()) != null) {
            str3 = value;
        }
        hashMap.put("alive_off", str3);
        hj.i.f64628a.H("", str2, valueOf.longValue(), hashMap);
    }

    public final void f(final boolean z10) {
        if (f43390e <= 0) {
            a.C0856a.f(lg.a.f68962a, "AppPeriodReport", "close period " + f43390e + " ", false, 4, null);
            Timer timer = f43387b;
            if (timer != null) {
                timer.purge();
            }
            Timer timer2 = f43387b;
            if (timer2 != null) {
                timer2.cancel();
            }
            TimerTask timerTask = f43388c;
            if (timerTask != null) {
                timerTask.cancel();
            }
            g0.f9674i.a().getLifecycle().d(f43386a);
            return;
        }
        boolean z11 = f43391f;
        Unit unit = null;
        if (z10 != z11) {
            e(this, null, z11, 1, null);
        }
        f43391f = z10;
        TimerTask timerTask2 = f43388c;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
        f43388c = null;
        Timer timer3 = f43387b;
        if (timer3 != null) {
            timer3.cancel();
        }
        Timer timer4 = f43387b;
        if (timer4 != null) {
            timer4.purge();
        }
        f43387b = null;
        f43387b = new Timer();
        f43388c = new TimerTask() { // from class: com.transsion.baselib.report.AppPeriodReport$startTimer$$inlined$timerTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                long j11;
                long j12;
                a.C0856a c0856a = lg.a.f68962a;
                boolean z12 = z10;
                j11 = AppPeriodReport.f43390e;
                a.C0856a.f(c0856a, "AppPeriodReport", "period event " + z12 + " period " + j11 + " ", false, 4, null);
                AppPeriodReport appPeriodReport = AppPeriodReport.f43386a;
                j12 = AppPeriodReport.f43390e;
                appPeriodReport.d(Long.valueOf(j12), z10);
            }
        };
        try {
            Result.Companion companion = Result.INSTANCE;
            Timer timer5 = f43387b;
            if (timer5 != null) {
                TimerTask timerTask3 = f43388c;
                long j11 = f43390e;
                timer5.schedule(timerTask3, j11, j11);
                unit = Unit.f67184a;
            }
            Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // androidx.view.f
    public /* synthetic */ void onCreate(u uVar) {
        androidx.view.e.a(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onDestroy(u uVar) {
        androidx.view.e.b(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onPause(u uVar) {
        androidx.view.e.c(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onResume(u uVar) {
        androidx.view.e.d(this, uVar);
    }

    @Override // androidx.view.f
    public void onStart(u owner) {
        Intrinsics.h(owner, "owner");
        androidx.view.e.e(this, owner);
        a.C0856a.f(lg.a.f68962a, "AppPeriodReport", "onStart " + f43390e + " ", false, 4, null);
        if (f43392g == null) {
            f43392g = Long.valueOf(SystemClock.elapsedRealtime());
        }
        f(false);
    }

    @Override // androidx.view.f
    public void onStop(u owner) {
        Intrinsics.h(owner, "owner");
        androidx.view.e.f(this, owner);
        a.C0856a.f(lg.a.f68962a, "AppPeriodReport", "onStop " + f43390e + " ", false, 4, null);
        f(true);
    }
}
