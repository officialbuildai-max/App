package com.transsion.subroom.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.cloud.hisavana.sdk.common.util.l0;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout;
import com.transsion.wrapperad.view.secondfloor.SecondFloorArcCoverView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class SecondFloorHelper {
    private Function0 A;

    /* renamed from: a, reason: collision with root package name */
    private au.a f54641a;

    /* renamed from: b, reason: collision with root package name */
    private final long f54642b;

    /* renamed from: c, reason: collision with root package name */
    private final long f54643c;

    /* renamed from: d, reason: collision with root package name */
    private final String f54644d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f54645e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f54646f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f54647g;

    /* renamed from: h, reason: collision with root package name */
    private AnimatorSet f54648h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f54649i;

    /* renamed from: j, reason: collision with root package name */
    private Function1 f54650j;

    /* renamed from: k, reason: collision with root package name */
    private String f54651k;

    /* renamed from: l, reason: collision with root package name */
    private final n0 f54652l;

    /* renamed from: m, reason: collision with root package name */
    private t1 f54653m;

    /* renamed from: n, reason: collision with root package name */
    private t1 f54654n;

    /* renamed from: o, reason: collision with root package name */
    private t1 f54655o;

    /* renamed from: p, reason: collision with root package name */
    private t1 f54656p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f54657q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f54658r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f54659s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f54660t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f54661u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f54662v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f54663w;

    /* renamed from: x, reason: collision with root package name */
    private final String f54664x;

    /* renamed from: y, reason: collision with root package name */
    private int f54665y;

    /* renamed from: z, reason: collision with root package name */
    private final Lazy f54666z;

    /* loaded from: classes6.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f54668b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f54669c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f54670d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f54671e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f54672f;

        a(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
            this.f54668b = z10;
            this.f54669c = z11;
            this.f54670d = z12;
            this.f54671e = z13;
            this.f54672f = z14;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.h(animation, "animation");
            super.onAnimationCancel(animation);
            SecondFloorHelper.this.f54662v = false;
            SecondFloorHelper.this.P(this.f54668b, this.f54669c, this.f54670d, this.f54671e, this.f54672f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
            super.onAnimationEnd(animation);
            SecondFloorHelper.this.f54662v = false;
            SecondFloorHelper.this.P(this.f54668b, this.f54669c, this.f54670d, this.f54671e, this.f54672f);
        }
    }

    public SecondFloorHelper(au.a viewBinding) {
        Intrinsics.h(viewBinding, "viewBinding");
        this.f54641a = viewBinding;
        this.f54642b = 400L;
        this.f54643c = 500L;
        this.f54644d = "TrendingTwoLevelloftScene";
        this.f54645e = LazyKt.b(new Function0() { // from class: com.transsion.subroom.activity.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float A;
                A = SecondFloorHelper.A(SecondFloorHelper.this);
                return Float.valueOf(A);
            }
        });
        this.f54646f = LazyKt.b(new Function0() { // from class: com.transsion.subroom.activity.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float B;
                B = SecondFloorHelper.B(SecondFloorHelper.this);
                return Float.valueOf(B);
            }
        });
        this.f54647g = LazyKt.b(new Function0() { // from class: com.transsion.subroom.activity.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long R;
                R = SecondFloorHelper.R(SecondFloorHelper.this);
                return Long.valueOf(R);
            }
        });
        this.f54651k = CustomSwipeRefreshLayout.IDLE;
        this.f54652l = o0.a(y0.c().plus(l2.b(null, 1, null)));
        this.f54664x = "show_guide";
        this.f54666z = LazyKt.b(new Function0() { // from class: com.transsion.subroom.activity.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int O;
                O = SecondFloorHelper.O(SecondFloorHelper.this);
                return Integer.valueOf(O);
            }
        });
        this.f54641a.f16218k.setLoadCallback(new Function1() { // from class: com.transsion.subroom.activity.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g11;
                g11 = SecondFloorHelper.g(SecondFloorHelper.this, ((Boolean) obj).booleanValue());
                return g11;
            }
        });
        this.f54641a.f16218k.setClickCallback(new Function0() { // from class: com.transsion.subroom.activity.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit h11;
                h11 = SecondFloorHelper.h(SecondFloorHelper.this);
                return h11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float A(SecondFloorHelper secondFloorHelper) {
        return (secondFloorHelper.f54641a.getRoot().getContext().getResources().getDisplayMetrics().widthPixels * 9) / 16.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float B(SecondFloorHelper secondFloorHelper) {
        return ((secondFloorHelper.f54641a.getRoot().getContext().getResources().getDisplayMetrics().widthPixels * 9) / 16) / 2.0f;
    }

    private final void C() {
        t1 t1Var = this.f54654n;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        t1 t1Var2 = this.f54655o;
        if (t1Var2 != null) {
            t1.a.b(t1Var2, null, 1, null);
        }
        t1 t1Var3 = this.f54656p;
        if (t1Var3 != null) {
            t1.a.b(t1Var3, null, 1, null);
        }
        t1 t1Var4 = this.f54653m;
        if (t1Var4 != null) {
            t1.a.b(t1Var4, null, 1, null);
        }
        this.f54654n = null;
        this.f54655o = null;
        this.f54656p = null;
        this.f54653m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        f0();
        d0(this, J(), true, false, false, true, false, 44, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        f0();
        d0(this, K(), true, false, true, false, false, 52, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(boolean z10) {
        if (this.f54641a.f16211d.getTranslationY() <= 0.0f) {
            SecondFloorArcCoverView arcCover = this.f54641a.f16209b;
            Intrinsics.g(arcCover, "arcCover");
            jg.c.g(arcCover);
        } else {
            if (this.f54662v) {
                return;
            }
            this.f54662v = true;
            f0();
            d0(this, 0.0f, true, true, false, false, z10, 24, null);
            this.f54641a.f16218k.idleTrigger();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void H(SecondFloorHelper secondFloorHelper, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        secondFloorHelper.G(z10);
    }

    private final void I() {
        f0();
        d0(this, J(), false, false, false, false, false, 62, null);
    }

    private final float J() {
        return ((Number) this.f54645e.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float K() {
        return ((Number) this.f54646f.getValue()).floatValue();
    }

    private final int L() {
        return ((Number) this.f54666z.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long M() {
        return ((Number) this.f54647g.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int O(SecondFloorHelper secondFloorHelper) {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b(secondFloorHelper.f54644d);
        if (b11 == null || (jsonElement = b11.get("guideShowMax")) == null) {
            return 1;
        }
        return jsonElement.getAsInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        if (z10) {
            this.f54641a.f16209b.setAlpha(0.0f);
            SecondFloorArcCoverView arcCover = this.f54641a.f16209b;
            Intrinsics.g(arcCover, "arcCover");
            jg.c.g(arcCover);
        }
        if (z11) {
            Y(CustomSwipeRefreshLayout.IDLE);
            ii.b.f65371a.e(this.f54644d, this.f54661u);
            this.f54661u = false;
            if (z14) {
                W();
            } else if (this.f54660t) {
                this.f54641a.f16218k.resetAd();
                this.f54660t = false;
                V(this, false, true, 1, null);
            }
        }
        if (z12) {
            Y(CustomSwipeRefreshLayout.HOVER_HALF);
        }
        if (z13) {
            Y(CustomSwipeRefreshLayout.HOVER_FULL);
        }
        this.f54649i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long R(SecondFloorHelper secondFloorHelper) {
        int e11 = com.transsion.ad.scene.a.f42255a.e(secondFloorHelper.f54644d);
        if (e11 > 0) {
            return e11 * 1000;
        }
        return 5000L;
    }

    public static /* synthetic */ void V(SecondFloorHelper secondFloorHelper, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        secondFloorHelper.U(z10, z11);
    }

    private final void c0(float f11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        AnimatorSet animatorSet = this.f54649i;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f54641a.f16211d, "translationY", f11);
        ofFloat.setDuration(this.f54642b);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f54641a.f16209b, "alpha", z10 ? 0.0f : 1.0f);
        ofFloat2.setDuration(this.f54642b);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f54641a.f16209b, "translationY", f11);
        ofFloat3.setDuration(this.f54642b);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ofFloat2, ofFloat3);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(ofFloat, animatorSet2);
        animatorSet3.addListener(new a(z10, z11, z12, z13, z14));
        this.f54649i = animatorSet3;
        animatorSet3.start();
    }

    static /* synthetic */ void d0(SecondFloorHelper secondFloorHelper, float f11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
        secondFloorHelper.c0(f11, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12, (i11 & 16) != 0 ? false : z13, (i11 & 32) == 0 ? z14 : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f54641a.f16211d, "translationY", K());
        ofFloat.setDuration(this.f54643c);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f54641a.f16209b, "translationY", K());
        ofFloat2.setDuration(this.f54643c);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        this.f54641a.f16209b.setAlpha(0.0f);
        SecondFloorArcCoverView arcCover = this.f54641a.f16209b;
        Intrinsics.g(arcCover, "arcCover");
        jg.c.k(arcCover);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f54641a.f16209b, "alpha", 1.0f);
        ofFloat3.setDuration(this.f54643c);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ofFloat, animatorSet);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.transsion.subroom.activity.SecondFloorHelper$startGuideAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                n0 n0Var;
                t1 d11;
                Intrinsics.h(animation, "animation");
                super.onAnimationEnd(animation);
                SecondFloorHelper.this.f54648h = null;
                SecondFloorHelper secondFloorHelper = SecondFloorHelper.this;
                n0Var = secondFloorHelper.f54652l;
                d11 = kotlinx.coroutines.k.d(n0Var, null, null, new SecondFloorHelper$startGuideAnimation$1$1$onAnimationEnd$1(SecondFloorHelper.this, null), 3, null);
                secondFloorHelper.f54653m = d11;
            }
        });
        this.f54648h = animatorSet2;
        animatorSet2.start();
    }

    private final void f0() {
        AnimatorSet animatorSet = this.f54648h;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f54648h = null;
        AnimatorSet animatorSet2 = this.f54649i;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.f54649i = null;
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(SecondFloorHelper secondFloorHelper, boolean z10) {
        if (z10) {
            secondFloorHelper.b0();
        } else {
            ii.b.d(ii.b.f65371a, secondFloorHelper.f54644d, false, 2, null);
            if (secondFloorHelper.f54657q) {
                secondFloorHelper.W();
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(SecondFloorHelper secondFloorHelper) {
        secondFloorHelper.f54663w = true;
        secondFloorHelper.Y(CustomSwipeRefreshLayout.IDLE);
        H(secondFloorHelper, false, 1, null);
        return Unit.f67184a;
    }

    public final void D() {
        ii.b.f65371a.e(this.f54644d, false);
        this.f54661u = false;
        o0.d(this.f54652l, null, 1, null);
        f0();
        this.f54641a.f16218k.destroy();
        this.A = null;
    }

    public final void N() {
        this.f54665y++;
        com.transsion.baselib.report.launch.b.f43424a.b().putInt(this.f54664x, this.f54665y);
    }

    public final boolean Q() {
        return this.f54641a.f16218k.hasAd();
    }

    public final boolean S() {
        int i11 = T() ? 0 : com.transsion.baselib.report.launch.b.f43424a.b().getInt(this.f54664x, 0);
        this.f54665y = i11;
        boolean z10 = i11 < L();
        if (!z10) {
            ii.b.d(ii.b.f65371a, this.f54644d, false, 2, null);
        }
        return z10;
    }

    public final boolean T() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        long j11 = bVar.b().getLong("zero_clock_timestamp_SecondFloorGuide", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z10 = currentTimeMillis - j11 >= 86400000;
        if (z10) {
            bVar.b().putLong("zero_clock_timestamp_SecondFloorGuide", l0.c(currentTimeMillis));
        }
        return z10;
    }

    public final void U(boolean z10, boolean z11) {
        this.f54657q = z10;
        this.f54641a.f16218k.loadAd(z11);
    }

    public final void W() {
        Function0 function0;
        if (this.f54663w || (function0 = this.A) == null) {
            return;
        }
        function0.invoke();
        this.A = null;
    }

    public final void X(String action, float f11, float f12) {
        t1 d11;
        t1 d12;
        t1 d13;
        Intrinsics.h(action, "action");
        switch (action.hashCode()) {
            case -1435393951:
                if (action.equals(CustomSwipeRefreshLayout.SECOND_FLOOR)) {
                    this.f54641a.f16218k.adClick();
                    this.f54660t = true;
                    d11 = kotlinx.coroutines.k.d(this.f54652l, null, null, new SecondFloorHelper$onAction$4(this, null), 3, null);
                    this.f54656p = d11;
                    return;
                }
                return;
            case -1294619603:
                if (action.equals(CustomSwipeRefreshLayout.IDLE_TRIGGER)) {
                    this.f54641a.f16209b.idleTrigger();
                    return;
                }
                return;
            case -659833836:
                if (action.equals(CustomSwipeRefreshLayout.REFRESH_TRIGGER)) {
                    this.f54641a.f16209b.refreshTrigger();
                    return;
                }
                return;
            case 2715:
                if (action.equals(CustomSwipeRefreshLayout.UP)) {
                    this.f54659s = false;
                    return;
                }
                return;
            case 2104482:
                if (action.equals(CustomSwipeRefreshLayout.DOWN)) {
                    f0();
                    return;
                }
                return;
            case 2242516:
                if (action.equals(CustomSwipeRefreshLayout.IDLE)) {
                    this.f54658r = true;
                    H(this, false, 1, null);
                    ii.b.d(ii.b.f65371a, this.f54644d, false, 2, null);
                    return;
                }
                return;
            case 2372561:
                if (action.equals(CustomSwipeRefreshLayout.MOVE)) {
                    if (!this.f54659s) {
                        ii.b bVar = ii.b.f65371a;
                        if (bVar.a(this.f54644d)) {
                            this.f54641a.f16218k.showAd();
                            ii.b.g(bVar, this.f54644d, null, 2, null);
                            this.f54661u = true;
                            this.f54659s = true;
                        }
                    }
                    this.f54641a.f16211d.setTranslationY(f11);
                    SecondFloorArcCoverView secondFloorArcCoverView = this.f54641a.f16209b;
                    secondFloorArcCoverView.setAbMode(CustomSwipeRefreshLayout.INSTANCE.b());
                    secondFloorArcCoverView.setTranslationY(f11);
                    secondFloorArcCoverView.setAlpha(f12);
                    Intrinsics.e(secondFloorArcCoverView);
                    jg.c.k(secondFloorArcCoverView);
                    return;
                }
                return;
            case 351156154:
                if (action.equals(CustomSwipeRefreshLayout.SECOND_FLOOR_TRIGGER)) {
                    this.f54641a.f16209b.secondFloorTrigger();
                    return;
                }
                return;
            case 784487378:
                if (action.equals(CustomSwipeRefreshLayout.HOVER_FULL)) {
                    d12 = kotlinx.coroutines.k.d(this.f54652l, null, null, new SecondFloorHelper$onAction$3(this, null), 3, null);
                    this.f54654n = d12;
                    return;
                }
                return;
            case 784527734:
                if (action.equals(CustomSwipeRefreshLayout.HOVER_HALF)) {
                    d13 = kotlinx.coroutines.k.d(this.f54652l, null, null, new SecondFloorHelper$onAction$2(this, null), 3, null);
                    this.f54654n = d13;
                    return;
                }
                return;
            case 1803427515:
                if (action.equals(CustomSwipeRefreshLayout.REFRESH)) {
                    this.f54660t = true;
                    I();
                    this.f54641a.f16209b.refreshing();
                    this.f54641a.f16218k.refreshing();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void Y(String state) {
        Intrinsics.h(state, "state");
        this.f54651k = state;
        Function1 function1 = this.f54650j;
        if (function1 != null) {
            function1.invoke(state);
        }
    }

    public final void Z(Function0 function0) {
        this.A = function0;
    }

    public final void a0(Function1 function1) {
        this.f54650j = function1;
    }

    public final void b0() {
        t1 d11;
        if (this.f54657q) {
            if (!ii.b.f65371a.a(this.f54644d)) {
                W();
                return;
            }
            t1 t1Var = this.f54653m;
            if (t1Var != null) {
                t1.a.b(t1Var, null, 1, null);
            }
            d11 = kotlinx.coroutines.k.d(this.f54652l, null, null, new SecondFloorHelper$showGuide$1(this, null), 3, null);
            this.f54653m = d11;
        }
    }
}
