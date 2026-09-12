package com.transsion.player.longvideo.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.transsion.mb.config.manager.ConfigBean;
import ej.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class u {

    /* renamed from: l, reason: collision with root package name */
    public static final a f48072l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final ho.j f48073a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f48074b;

    /* renamed from: c, reason: collision with root package name */
    private b f48075c;

    /* renamed from: d, reason: collision with root package name */
    private ho.e f48076d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f48077e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f48078f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f48079g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f48080h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f48081i;

    /* renamed from: j, reason: collision with root package name */
    private final Handler f48082j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f48083k;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u(ho.j viewBinding, Function0 continuePlaCallback) {
        String value;
        Object m1185constructorimpl;
        Intrinsics.h(viewBinding, "viewBinding");
        Intrinsics.h(continuePlaCallback, "continuePlaCallback");
        this.f48073a = viewBinding;
        this.f48074b = continuePlaCallback;
        this.f48080h = new Handler(Looper.getMainLooper());
        this.f48081i = new Handler(Looper.getMainLooper());
        this.f48082j = new Handler(Looper.getMainLooper());
        this.f48083k = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.helper.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long A;
                A = u.A();
                return Long.valueOf(A);
            }
        });
        ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), "sa_data_operator_config", false, 2, null);
        if (d11 != null && (value = d11.getValue()) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.f48075c = (b) com.blankj.utilcode.util.o.d(value, b.class);
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
        b bVar = this.f48075c;
        if (bVar != null) {
            ho.f fVar = this.f48073a.f64741h.f64777s;
            fVar.f64704e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.y(u.this, view);
                }
            });
            fVar.f64702c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.z(u.this, view);
                }
            });
            String l11 = bVar.l();
            if (l11 != null) {
                fVar.f64706g.setText(l11);
            }
            String k11 = bVar.k();
            if (k11 != null) {
                fVar.f64705f.setText(k11);
            }
            String a11 = bVar.a();
            if (a11 != null) {
                fVar.f64703d.setText(a11);
            }
            String b11 = bVar.b();
            if (b11 != null) {
                f.a aVar = ej.f.f62005a;
                Context context = fVar.f64701b.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b c11 = aVar.m(context).g(b11).m(dk.a.b(16)).c(dk.a.b(16));
                AppCompatImageView ivMore = fVar.f64701b;
                Intrinsics.g(ivMore, "ivMore");
                c11.d(ivMore);
            }
            ho.f fVar2 = this.f48073a.f64742i.f64797m;
            fVar2.f64704e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.w(u.this, view);
                }
            });
            fVar2.f64702c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.x(u.this, view);
                }
            });
            String l12 = bVar.l();
            if (l12 != null) {
                fVar2.f64706g.setText(l12);
            }
            String k12 = bVar.k();
            if (k12 != null) {
                fVar2.f64705f.setText(k12);
            }
            String a12 = bVar.a();
            if (a12 != null) {
                fVar2.f64703d.setText(a12);
            }
            String b12 = bVar.b();
            if (b12 != null) {
                f.a aVar2 = ej.f.f62005a;
                Context context2 = fVar2.f64701b.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b c12 = aVar2.m(context2).g(b12).m(dk.a.b(16)).c(dk.a.b(16));
                AppCompatImageView ivMore2 = fVar2.f64701b;
                Intrinsics.g(ivMore2, "ivMore");
                c12.d(ivMore2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A() {
        String value;
        Long x10;
        ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), "sa_data_switch", false, 2, null);
        if (d11 == null || (value = d11.getValue()) == null || (x10 = StringsKt.x(value)) == null) {
            return 720L;
        }
        return x10.longValue();
    }

    private final void B() {
        String h11;
        t();
        a.C0856a c0856a = lg.a.f68962a;
        b bVar = this.f48075c;
        a.C0856a.f(c0856a, "LongVodMobileData", "onOperatorClick link:" + (bVar != null ? bVar.h() : null), false, 4, null);
        b bVar2 = this.f48075c;
        if (bVar2 != null && (h11 = bVar2.h()) != null) {
            ak.k.h(h11, null, 1, null);
        }
        com.transsion.baselib.report.launch.b.f43424a.b().putLong("key_video_operator_last_open_time", System.currentTimeMillis());
    }

    private final void F(boolean z10) {
        try {
            Result.Companion companion = Result.INSTANCE;
            a.C0856a.f(lg.a.f68962a, "LongVodMobileData", "showOperatorLayout", false, 4, null);
            if (z10) {
                BLLinearLayout root = this.f48073a.f64741h.f64777s.getRoot();
                Intrinsics.g(root, "getRoot(...)");
                jg.c.k(root);
            } else {
                BLLinearLayout root2 = this.f48073a.f64742i.f64797m.getRoot();
                Intrinsics.g(root2, "getRoot(...)");
                jg.c.k(root2);
            }
            b bVar = this.f48075c;
            int j11 = bVar != null ? bVar.j() : 10;
            this.f48082j.removeCallbacksAndMessages(null);
            Result.m1185constructorimpl(Boolean.valueOf(this.f48082j.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.t
                @Override // java.lang.Runnable
                public final void run() {
                    u.G(u.this);
                }
            }, j11 * 1000)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(u uVar) {
        try {
            Result.Companion companion = Result.INSTANCE;
            uVar.t();
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final void k() {
        ConstraintLayout root;
        ho.e eVar = this.f48076d;
        if (eVar != null && (root = eVar.getRoot()) != null && root.getVisibility() == 0) {
            a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "checkFullscreenPageShowOperator, mobile ui show~~", false, 4, null);
            return;
        }
        if (this.f48078f) {
            a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "checkFullscreenPageShowOperator shown return", false, 4, null);
            return;
        }
        if (!u()) {
            a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "checkFullscreenPageShowOperator intercept--", false, 4, null);
            return;
        }
        this.f48078f = true;
        b bVar = this.f48075c;
        int d11 = bVar != null ? bVar.d() : 3;
        a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "checkFullscreenPageShowOperator delay show:" + d11 + "s", false, 4, null);
        this.f48080h.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.l
            @Override // java.lang.Runnable
            public final void run() {
                u.l(u.this);
            }
        }, ((long) d11) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(u uVar) {
        uVar.F(true);
    }

    private final void m() {
        if (this.f48079g) {
            return;
        }
        if (this.f48077e) {
            a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "checkMiddlePageShowOperator shown return", false, 4, null);
            return;
        }
        if (!u()) {
            a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "checkMiddlePageShowOperator config--", false, 4, null);
            return;
        }
        this.f48077e = true;
        b bVar = this.f48075c;
        int i11 = bVar != null ? bVar.i() : 3;
        a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "checkMiddlePageShowOperator delay show:" + i11 + "s", false, 4, null);
        this.f48081i.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.k
            @Override // java.lang.Runnable
            public final void run() {
                u.n(u.this);
            }
        }, ((long) i11) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(u uVar) {
        uVar.F(false);
    }

    private final void o() {
        if (this.f48079g) {
            k();
        } else {
            m();
        }
    }

    private final long p() {
        return ((Number) this.f48083k.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(u uVar, View view) {
        a.C0856a.f(lg.a.f68962a, "LongVodMobileData", "click-- play with mobile data", false, 4, null);
        io.a.f65396a.c(true);
        uVar.f48074b.invoke();
        uVar.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(u uVar, View view) {
        a.C0856a.f(lg.a.f68962a, "LongVodMobileData", "click-- page openDeeplink", false, 4, null);
        uVar.B();
    }

    private final void t() {
        a.C0856a.f(lg.a.f68962a, "LongVodMobileData", "hideOperatorLayout", false, 4, null);
        BLLinearLayout root = this.f48073a.f64741h.f64777s.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.g(root);
        BLLinearLayout root2 = this.f48073a.f64742i.f64797m.getRoot();
        Intrinsics.g(root2, "getRoot(...)");
        jg.c.g(root2);
    }

    private final boolean u() {
        b bVar = this.f48075c;
        if (bVar != null) {
            String h11 = bVar != null ? bVar.h() : null;
            if (h11 != null && h11.length() != 0) {
                long currentTimeMillis = System.currentTimeMillis() - com.transsion.baselib.report.launch.b.f43424a.b().getLong("key_video_operator_last_open_time", 0L);
                b bVar2 = this.f48075c;
                boolean z10 = currentTimeMillis >= ((long) ((bVar2 != null ? bVar2.c() : 0) * TimeConstants.HOUR));
                lg.a.f68962a.c("LongVodMobileData", "isShowDataOperator time :" + z10, true);
                return z10;
            }
        }
        a.C0856a.f(lg.a.f68962a, "LongVodMobileData", "isShowDataOperator config is null", false, 4, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(u uVar, View view) {
        uVar.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(u uVar, View view) {
        a.C0856a.f(lg.a.f68962a, "LongVodMobileData", "click-- float openDeeplink", false, 4, null);
        uVar.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(u uVar, View view) {
        uVar.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(u uVar, View view) {
        a.C0856a.f(lg.a.f68962a, "LongVodMobileData", "click-- float openDeeplink", false, 4, null);
        uVar.B();
    }

    public final void C(boolean z10) {
        this.f48079g = z10;
        t();
        if (z10) {
            this.f48081i.removeCallbacksAndMessages(null);
            a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "onScreenChange enter full", false, 4, null);
            k();
        } else {
            this.f48080h.removeCallbacksAndMessages(null);
            a.C0856a.v(lg.a.f68962a, "LongVodMobileData", "onScreenChange exit full to middle page", false, 4, null);
            m();
        }
    }

    public final void D() {
        a.C0856a.f(lg.a.f68962a, "LongVodMobileData", "onVideoStart", false, 4, null);
        o();
    }

    public final void E() {
        ConstraintLayout root;
        ho.e eVar = this.f48076d;
        if (eVar == null || (root = eVar.getRoot()) == null) {
            return;
        }
        jg.c.g(root);
    }

    public final void q() {
        BLTextView bLTextView;
        BLTextView bLTextView2;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        ho.e eVar;
        AppCompatTextView appCompatTextView3;
        BLTextView bLTextView3;
        AppCompatTextView appCompatTextView4;
        ConstraintLayout root;
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c("LongVodMobileData", "onPrepare2PlayVideo, is mobile , pause video. show layout", true);
        if (this.f48076d == null) {
            this.f48076d = ho.e.a(this.f48073a.f64756w.inflate());
        }
        com.transsion.baselib.report.launch.b.f43424a.b().putLong("key_mobile_data_switch_time", System.currentTimeMillis());
        ho.e eVar2 = this.f48076d;
        if (eVar2 != null && (root = eVar2.getRoot()) != null) {
            jg.c.k(root);
        }
        ho.e eVar3 = this.f48076d;
        if (eVar3 != null) {
            if (eVar3 != null && (appCompatTextView4 = eVar3.f64698d) != null) {
                jg.c.g(appCompatTextView4);
            }
            ho.e eVar4 = this.f48076d;
            if (eVar4 != null && (bLTextView3 = eVar4.f64696b) != null) {
                jg.c.g(bLTextView3);
            }
            if (u()) {
                a.C0856a.f(c0856a, "LongVodMobileData", "mobile data layout, show operator ui--------", false, 4, null);
                b bVar = this.f48075c;
                if (bVar != null) {
                    String g11 = bVar.g();
                    if (g11 != null && (eVar = this.f48076d) != null && (appCompatTextView3 = eVar.f64699e) != null) {
                        appCompatTextView3.setText(g11);
                    }
                    String f11 = bVar.f();
                    if (f11 != null) {
                        ho.e eVar5 = this.f48076d;
                        if (eVar5 != null && (appCompatTextView2 = eVar5.f64698d) != null) {
                            appCompatTextView2.setText(f11);
                        }
                        ho.e eVar6 = this.f48076d;
                        if (eVar6 != null && (appCompatTextView = eVar6.f64698d) != null) {
                            jg.c.k(appCompatTextView);
                        }
                    }
                    String e11 = bVar.e();
                    if (e11 != null) {
                        ho.e eVar7 = this.f48076d;
                        if (eVar7 != null && (bLTextView2 = eVar7.f64696b) != null) {
                            bLTextView2.setText(e11);
                        }
                        ho.e eVar8 = this.f48076d;
                        if (eVar8 != null && (bLTextView = eVar8.f64696b) != null) {
                            jg.c.k(bLTextView);
                        }
                    }
                }
            }
            eVar3.f64697c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.r(u.this, view);
                }
            });
            BLTextView longVdTvOperator = eVar3.f64696b;
            Intrinsics.g(longVdTvOperator, "longVdTvOperator");
            longVdTvOperator.setVisibility(u() ? 0 : 8);
            eVar3.f64696b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.s(u.this, view);
                }
            });
        }
    }

    public final boolean v() {
        long j11 = 60;
        return System.currentTimeMillis() - com.transsion.baselib.report.launch.b.f43424a.b().getLong("key_mobile_data_switch_time", 0L) >= ((p() * j11) * j11) * ((long) 1000);
    }
}
