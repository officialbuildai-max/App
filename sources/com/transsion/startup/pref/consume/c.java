package com.transsion.startup.pref.consume;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import hj.i;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static long f54584b;

    /* renamed from: c, reason: collision with root package name */
    private static long f54585c;

    /* renamed from: d, reason: collision with root package name */
    private static long f54586d;

    /* renamed from: e, reason: collision with root package name */
    private static long f54587e;

    /* renamed from: f, reason: collision with root package name */
    private static long f54588f;

    /* renamed from: g, reason: collision with root package name */
    private static long f54589g;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f54591i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f54592j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f54593k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f54594l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f54595m;

    /* renamed from: a, reason: collision with root package name */
    public static final c f54583a = new c();

    /* renamed from: h, reason: collision with root package name */
    private static boolean f54590h = true;

    /* loaded from: classes6.dex */
    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f54596a;

        a(View view) {
            this.f54596a = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver;
            View view = this.f54596a;
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            c cVar = c.f54583a;
            c.f54588f = SystemClock.elapsedRealtime();
            long j11 = c.f54588f - c.f54584b;
            long h11 = c.f54583a.h();
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.l(c0856a, "AppStartup", "🚀 [Phase 3] MainActivity TTID:", false, 4, null);
            a.C0856a.l(c0856a, "AppStartup", "   ├─ 总耗时 (含广告等待): " + j11 + "ms", false, 4, null);
            a.C0856a.l(c0856a, "AppStartup", "   ├─ 广告等待时长: " + h11 + "ms", false, 4, null);
            a.C0856a.l(c0856a, "AppStartup", "   └─ 真实启动时间 (TTID): " + (j11 - h11) + "ms", false, 4, null);
            c.f54592j = true;
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f54597a;

        b(View view) {
            this.f54597a = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver;
            View view = this.f54597a;
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            c cVar = c.f54583a;
            c.f54585c = SystemClock.elapsedRealtime();
            long j11 = c.f54585c - c.f54584b;
            a.C0856a.l(lg.a.f68962a, "AppStartup", "🚀 [Phase 1] Splash TTID: " + j11 + "ms (进程启动 → Splash首帧)", false, 4, null);
            c.f54591i = true;
            return true;
        }
    }

    private c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:
    
        if (r10 > 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        if (r10 > 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        r10 = r8 - r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void n() {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.startup.pref.consume.c.n():void");
    }

    private final void p() {
        f54585c = 0L;
        f54586d = 0L;
        f54587e = 0L;
        f54588f = 0L;
        f54589g = 0L;
        f54590h = true;
        f54591i = false;
        f54592j = false;
        f54593k = false;
        f54594l = false;
        f54595m = false;
    }

    public final long h() {
        boolean z10 = f54595m;
        if (z10) {
            long j11 = f54587e;
            long j12 = f54586d;
            if (j11 > j12) {
                return j11 - j12;
            }
        }
        if (z10 && f54594l) {
            return SystemClock.elapsedRealtime() - f54586d;
        }
        return 0L;
    }

    public final com.transsion.startup.pref.consume.b i() {
        long h11 = h();
        long j11 = f54589g;
        long j12 = j11 > 0 ? j11 - f54584b : 0L;
        long j13 = f54585c;
        long j14 = j13 > 0 ? j13 - f54584b : 0L;
        long j15 = f54588f;
        return new com.transsion.startup.pref.consume.b(j14, h11, j15 > 0 ? (j15 - f54584b) - h11 : 0L, j12, j12 - h11, f54595m);
    }

    public final void j() {
        f54584b = Build.VERSION.SDK_INT >= 24 ? Process.getStartElapsedRealtime() : SystemClock.elapsedRealtime();
        p();
        a.C0856a.l(lg.a.f68962a, "AppStartup", "📍 [Phase 0] App Process Started at: " + f54584b, false, 4, null);
    }

    public final void k(Activity activity) {
        View findViewById;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.h(activity, "activity");
        if (!f54590h || f54592j || (findViewById = activity.findViewById(R.id.content)) == null || (viewTreeObserver = findViewById.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnPreDrawListener(new a(findViewById));
    }

    public final void l(Activity activity) {
        View findViewById;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.h(activity, "activity");
        if (!f54590h || f54591i || (findViewById = activity.findViewById(R.id.content)) == null || (viewTreeObserver = findViewById.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnPreDrawListener(new b(findViewById));
    }

    public final void m() {
        if (!f54590h || f54594l) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        f54586d = elapsedRealtime;
        f54594l = true;
        f54595m = true;
        long j11 = elapsedRealtime - f54584b;
        a.C0856a.l(lg.a.f68962a, "AppStartup", "⏸️ [Phase 2] Paused for Ad at: " + f54586d + " (已运行 " + j11 + "ms)", false, 4, null);
    }

    public final void o(Activity activity) {
        if (!f54590h || f54593k) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        f54589g = elapsedRealtime;
        long j11 = elapsedRealtime - f54584b;
        long h11 = h();
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.l(c0856a, "AppStartup", "✅ [Phase 4] TTFD (Full Display):", false, 4, null);
        a.C0856a.l(c0856a, "AppStartup", "   ├─ 总耗时 (含广告等待): " + j11 + "ms", false, 4, null);
        a.C0856a.l(c0856a, "AppStartup", "   ├─ 广告等待时长: " + h11 + "ms", false, 4, null);
        a.C0856a.l(c0856a, "AppStartup", "   └─ 真实启动时间 (TTFD): " + (j11 - h11) + "ms", false, 4, null);
        n();
        com.transsion.startup.pref.consume.b i11 = i();
        i.f64628a.s("app_startup_stat_ab_new", "app_perf", MapsKt.l(TuplesKt.a("splash_ttid", String.valueOf(i11.e())), TuplesKt.a("ad_wait_duration", String.valueOf(i11.a())), TuplesKt.a("main_activity_ttid", String.valueOf(i11.c())), TuplesKt.a("total_ttfd", String.valueOf(i11.f())), TuplesKt.a("real_ttfd", String.valueOf(i11.d())), TuplesKt.a("has_ad", String.valueOf(i11.b()))));
        f54593k = true;
        f54590h = false;
    }

    public final void q() {
        if (f54590h && f54594l) {
            f54587e = SystemClock.elapsedRealtime();
            f54594l = false;
            long h11 = h();
            a.C0856a.l(lg.a.f68962a, "AppStartup", "▶️ [Phase 2] Resumed after Ad, Wait Duration: " + h11 + "ms (广告等待时间，已从统计中排除)", false, 4, null);
        }
    }

    public final void r() {
        if (f54590h) {
            if (f54594l) {
                a.C0856a.l(lg.a.f68962a, "AppStartup", "⏭️ [Phase 2] Ad Skipped - No ad shown, resuming timer", false, 4, null);
            }
            f54594l = false;
            f54595m = false;
            f54586d = 0L;
            f54587e = 0L;
        }
    }
}
