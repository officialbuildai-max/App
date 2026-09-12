package com.transsion.shorttv.ui.widget;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    public static final a f53617f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final View f53618a;

    /* renamed from: b, reason: collision with root package name */
    private final b f53619b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f53620c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f53621d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f53622e;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        qs.d a();

        String b();

        boolean c();

        void d();
    }

    public c(View bubbleView, b conditionProvider) {
        Intrinsics.h(bubbleView, "bubbleView");
        Intrinsics.h(conditionProvider, "conditionProvider");
        this.f53618a = bubbleView;
        this.f53619b = conditionProvider;
        this.f53620c = new Handler(Looper.getMainLooper());
        this.f53621d = new Runnable() { // from class: com.transsion.shorttv.ui.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                c.k(c.this);
            }
        };
        this.f53622e = new Runnable() { // from class: com.transsion.shorttv.ui.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                c.g(c.this);
            }
        };
    }

    private final long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception e11) {
            a.C0856a.l(lg.a.f68962a, "DownloadGuideBubble", "getAvailableStorageBytes error: " + e11.getMessage(), false, 4, null);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(c cVar) {
        cVar.f();
    }

    private final void j() {
        this.f53619b.d();
        a.C0856a.f(lg.a.f68962a, "DownloadGuideBubble", "showBubble: UI restored, showing bubble", false, 4, null);
        yr.b.e(this.f53618a);
        this.f53620c.removeCallbacks(this.f53622e);
        this.f53620c.postDelayed(this.f53622e, 6000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c cVar) {
        cVar.l();
    }

    private final void l() {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "DownloadGuideBubble", "tryShowBubble: checking conditions...", false, 4, null);
        if (!this.f53619b.c()) {
            a.C0856a.f(c0856a, "DownloadGuideBubble", "tryShowBubble: SKIP - not buffering", false, 4, null);
            return;
        }
        com.transsion.shorttv.utils.h hVar = com.transsion.shorttv.utils.h.f53707a;
        if (!hVar.c()) {
            a.C0856a.f(c0856a, "DownloadGuideBubble", "tryShowBubble: SKIP - fatigue control (shown within 3 days)", false, 4, null);
            return;
        }
        long e11 = e();
        if (e11 < 524288000) {
            long j11 = 1024;
            a.C0856a.f(c0856a, "DownloadGuideBubble", "tryShowBubble: SKIP - storage insufficient (" + ((e11 / j11) / j11) + "MB < 500MB)", false, 4, null);
            return;
        }
        String b11 = this.f53619b.b();
        qs.d a11 = this.f53619b.a();
        if ((a11 != null ? a11.g(b11) : null) == null) {
            a.C0856a.f(c0856a, "DownloadGuideBubble", "tryShowBubble: ALL conditions met, showing bubble!", false, 4, null);
            hVar.f();
            j();
        } else {
            a.C0856a.f(c0856a, "DownloadGuideBubble", "tryShowBubble: SKIP - video already in download list (resourceId=" + b11 + ")", false, 4, null);
        }
    }

    public final void c() {
        this.f53620c.removeCallbacksAndMessages(null);
        a.C0856a.f(lg.a.f68962a, "DownloadGuideBubble", "destroy: all callbacks cleared", false, 4, null);
    }

    public final void d() {
        this.f53620c.removeCallbacks(this.f53621d);
        f();
        a.C0856a.f(lg.a.f68962a, "DownloadGuideBubble", "dismiss: timer cancelled + bubble hidden", false, 4, null);
    }

    public final void f() {
        this.f53620c.removeCallbacks(this.f53622e);
        if (this.f53618a.getVisibility() == 0) {
            a.C0856a.f(lg.a.f68962a, "DownloadGuideBubble", "hide: bubble hidden", false, 4, null);
        }
        yr.b.b(this.f53618a);
    }

    public final void h() {
        this.f53620c.removeCallbacks(this.f53621d);
        a.C0856a.f(lg.a.f68962a, "DownloadGuideBubble", "onBufferingEnd: timer cancelled", false, 4, null);
    }

    public final void i() {
        this.f53620c.removeCallbacks(this.f53621d);
        this.f53620c.postDelayed(this.f53621d, 5000L);
        a.C0856a.f(lg.a.f68962a, "DownloadGuideBubble", "onBufferingStart: timer started (5000ms)", false, 4, null);
    }
}
