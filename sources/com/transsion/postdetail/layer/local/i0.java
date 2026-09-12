package com.transsion.postdetail.layer.local;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.postdetail.ui.view.AdCountDownView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lg.a;

/* loaded from: classes6.dex */
public final class i0 {

    /* renamed from: v, reason: collision with root package name */
    public static final a f49093v = new a(null);

    /* renamed from: w, reason: collision with root package name */
    private static final Lazy f49094w = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.d0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            i0 j11;
            j11 = i0.j();
            return j11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private long f49095a;

    /* renamed from: b, reason: collision with root package name */
    private long f49096b;

    /* renamed from: c, reason: collision with root package name */
    private int f49097c;

    /* renamed from: d, reason: collision with root package name */
    private int f49098d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f49099e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f49100f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f49101g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f49102h;

    /* renamed from: i, reason: collision with root package name */
    private int f49103i;

    /* renamed from: j, reason: collision with root package name */
    private AdCountDownView f49104j;

    /* renamed from: k, reason: collision with root package name */
    private AppCompatImageView f49105k;

    /* renamed from: l, reason: collision with root package name */
    private Function1 f49106l;

    /* renamed from: m, reason: collision with root package name */
    private Function0 f49107m;

    /* renamed from: q, reason: collision with root package name */
    private int f49111q;

    /* renamed from: n, reason: collision with root package name */
    private int f49108n = 15;

    /* renamed from: o, reason: collision with root package name */
    private int f49109o = 15;

    /* renamed from: p, reason: collision with root package name */
    private long f49110p = 180000;

    /* renamed from: r, reason: collision with root package name */
    private Handler f49112r = new Handler(Looper.getMainLooper());

    /* renamed from: s, reason: collision with root package name */
    private int f49113s = 1;

    /* renamed from: t, reason: collision with root package name */
    private int f49114t = 1;

    /* renamed from: u, reason: collision with root package name */
    private final Runnable f49115u = new Runnable() { // from class: com.transsion.postdetail.layer.local.e0
        @Override // java.lang.Runnable
        public final void run() {
            i0.i(i0.this);
        }
    };

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i0 a() {
            return (i0) i0.f49094w.getValue();
        }
    }

    private final void h() {
        this.f49112r.postDelayed(this.f49115u, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(i0 i0Var) {
        int i11;
        if (i0Var.f49111q < 1) {
            i0Var.m();
            return;
        }
        int i12 = i0Var.f49103i == 1 ? i0Var.f49113s : i0Var.f49114t;
        if (com.transsion.ad.scene.b.f42256a.l() && i0Var.f49109o - i0Var.f49111q >= i12 && ((i11 = i0Var.f49103i) == 1 || i11 == 3)) {
            AppCompatImageView appCompatImageView = i0Var.f49105k;
            if (appCompatImageView != null) {
                jg.c.k(appCompatImageView);
            }
            a.C0856a.f(lg.a.f68962a, "LocalVideoLandAdControl", "countdownRunnable, show adCloseView", false, 4, null);
        }
        AdCountDownView adCountDownView = i0Var.f49104j;
        if (adCountDownView != null) {
            int i13 = i0Var.f49111q;
            i0Var.f49111q = i13 - 1;
            adCountDownView.refreshCountDown(i13);
        }
        i0Var.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i0 j() {
        return new i0();
    }

    private final boolean l() {
        return this.f49099e;
    }

    private final void m() {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "LocalVideoLandAdControl", "onCountdownFinish, curAdType = " + this.f49103i, false, 4, null);
        int i11 = this.f49103i;
        if (i11 == 1) {
            this.f49097c = this.f49098d;
            Function0 function0 = this.f49107m;
            if (function0 != null) {
                function0.invoke();
            }
            AdCountDownView adCountDownView = this.f49104j;
            if (adCountDownView != null) {
                adCountDownView.setVisibility(8);
            }
            if (k()) {
                a.C0856a.f(c0856a, "LocalVideoLandAdControl", "onCountdownFinish, start finish, show end", false, 4, null);
                g(this.f49103i);
                v(3, new Function1() { // from class: com.transsion.postdetail.layer.local.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit n11;
                        n11 = i0.n(((Integer) obj).intValue());
                        return n11;
                    }
                });
                return;
            } else if (l()) {
                a.C0856a.f(c0856a, "LocalVideoLandAdControl", "onCountdownFinish, start finish, show pause", false, 4, null);
                g(this.f49103i);
                v(2, new Function1() { // from class: com.transsion.postdetail.layer.local.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit o11;
                        o11 = i0.o(((Integer) obj).intValue());
                        return o11;
                    }
                });
                return;
            } else {
                a.C0856a.f(c0856a, "LocalVideoLandAdControl", "onCountdownFinish, start finish now", false, 4, null);
                Function1 function1 = this.f49106l;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(this.f49103i));
                    return;
                }
                return;
            }
        }
        if (i11 == 2) {
            a.C0856a.f(c0856a, "LocalVideoLandAdControl", "onCountdownFinish, pause finish now", false, 4, null);
            Function1 function12 = this.f49106l;
            if (function12 != null) {
                function12.invoke(Integer.valueOf(this.f49103i));
                return;
            }
            return;
        }
        if (i11 != 3) {
            return;
        }
        this.f49100f = true;
        this.f49101g = false;
        AdCountDownView adCountDownView2 = this.f49104j;
        if (adCountDownView2 != null) {
            adCountDownView2.setVisibility(8);
        }
        if (l()) {
            a.C0856a.f(c0856a, "LocalVideoLandAdControl", "onCountdownFinish, end finish , show pause", false, 4, null);
            g(this.f49103i);
            v(2, new Function1() { // from class: com.transsion.postdetail.layer.local.h0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit p11;
                    p11 = i0.p(((Integer) obj).intValue());
                    return p11;
                }
            });
        } else {
            a.C0856a.f(c0856a, "LocalVideoLandAdControl", "onCountdownFinish, end finish now", false, 4, null);
            Function1 function13 = this.f49106l;
            if (function13 != null) {
                function13.invoke(Integer.valueOf(this.f49103i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(int i11) {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(int i11) {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(int i11) {
        return Unit.f67184a;
    }

    private final void q(Function1 function1) {
        w(this.f49109o);
    }

    private final void r(Function1 function1) {
        AdCountDownView adCountDownView = this.f49104j;
        if (adCountDownView != null) {
            adCountDownView.refreshCountDown(-1);
        }
        AdCountDownView adCountDownView2 = this.f49104j;
        if (adCountDownView2 != null) {
            adCountDownView2.setVisibility(0);
        }
        a.C0856a.f(lg.a.f68962a, "LocalVideoLandAdControl", "onShowPauseAd", false, 4, null);
    }

    private final void s(Function1 function1) {
        a.C0856a.f(lg.a.f68962a, "LocalVideoLandAdControl", "onShowStartAd", false, 4, null);
        w(this.f49108n);
    }

    private final void u() {
        this.f49112r.removeCallbacksAndMessages(this.f49115u);
    }

    private final void w(int i11) {
        a.C0856a.f(lg.a.f68962a, "LocalVideoLandAdControl", "startCountdown, countdownTime = " + i11, false, 4, null);
        this.f49111q = i11;
        AdCountDownView adCountDownView = this.f49104j;
        if (adCountDownView != null) {
            adCountDownView.setVisibility(0);
        }
        this.f49112r.post(this.f49115u);
    }

    public final void g(int i11) {
        a.C0856a.f(lg.a.f68962a, "LocalVideoLandAdControl", "----closeLandAd, adType = " + i11, false, 4, null);
        this.f49103i = 0;
        u();
        AppCompatImageView appCompatImageView = this.f49105k;
        if (appCompatImageView != null) {
            jg.c.g(appCompatImageView);
        }
    }

    public final boolean k() {
        if (this.f49100f || this.f49101g || this.f49095a - this.f49096b > this.f49110p) {
            return false;
        }
        if (!this.f49102h) {
            this.f49102h = true;
        }
        return true;
    }

    public final void t(long j11, long j12) {
        this.f49096b = j11;
        this.f49095a = j12;
    }

    public final void v(int i11, Function1 function1) {
        a.C0856a.f(lg.a.f68962a, "LocalVideoLandAdControl", "----showLandAd, adType = " + i11, false, 4, null);
        this.f49103i = i11;
        if (i11 == 1) {
            s(function1);
        } else if (i11 == 2) {
            r(function1);
        } else {
            if (i11 != 3) {
                return;
            }
            q(function1);
        }
    }
}
