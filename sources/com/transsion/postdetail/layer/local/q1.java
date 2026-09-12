package com.transsion.postdetail.layer.local;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mmkv.MMKV;
import com.transsion.postdetail.layer.local.q1;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class q1 implements Animator.AnimatorListener {

    /* renamed from: b, reason: collision with root package name */
    public static final a f49151b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f49152c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.k1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV d11;
            d11 = q1.d();
            return d11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final ho.c f49153a;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(View view) {
            q1.f49151b.l(view);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(View view, final Function0 function0, View view2) {
            q1.f49151b.l(view);
            view.removeCallbacks(new Runnable() { // from class: com.transsion.postdetail.layer.local.o1
                @Override // java.lang.Runnable
                public final void run() {
                    q1.a.i(Function0.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Function0 function0) {
            function0.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(Function0 function0) {
            function0.invoke();
        }

        private final void l(final View view) {
            ViewPropertyAnimator animate = view.animate();
            animate.setDuration(300L);
            animate.alpha(0.0f);
            animate.withEndAction(new Runnable() { // from class: com.transsion.postdetail.layer.local.p1
                @Override // java.lang.Runnable
                public final void run() {
                    q1.a.m(view);
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(View view) {
            jg.c.g(view);
        }

        public final void f(ho.j jVar) {
            final View inflate;
            ho.l lVar;
            ViewStub viewStub;
            if (k().getBoolean("video_show_guide", false)) {
                return;
            }
            if (((jVar == null || (lVar = jVar.f64742i) == null || (viewStub = lVar.f64800p) == null) ? null : viewStub.getParent()) == null || (inflate = jVar.f64742i.f64800p.inflate()) == null) {
                return;
            }
            q1.f49151b.k().putBoolean("video_show_guide", true);
            final Function0 function0 = new Function0() { // from class: com.transsion.postdetail.layer.local.l1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit g11;
                    g11 = q1.a.g(inflate);
                    return g11;
                }
            };
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q1.a.h(inflate, function0, view);
                }
            });
            inflate.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.n1
                @Override // java.lang.Runnable
                public final void run() {
                    q1.a.j(Function0.this);
                }
            }, 3000L);
        }

        public final MMKV k() {
            return (MMKV) q1.f49152c.getValue();
        }
    }

    public q1(ho.c bind) {
        Intrinsics.h(bind, "bind");
        this.f49153a = bind;
        bind.f64686b.addAnimatorListener(this);
        bind.f64687c.addAnimatorListener(this);
    }

    private final void c() {
        ho.c cVar = this.f49153a;
        VideoDoubleClickBackgroundView vDoubleClick = cVar.f64690f;
        Intrinsics.g(vDoubleClick, "vDoubleClick");
        jg.c.g(vDoubleClick);
        AppCompatTextView tvDoubleClickLeft = cVar.f64688d;
        Intrinsics.g(tvDoubleClickLeft, "tvDoubleClickLeft");
        jg.c.g(tvDoubleClickLeft);
        AppCompatTextView tvDoubleClickRight = cVar.f64689e;
        Intrinsics.g(tvDoubleClickRight, "tvDoubleClickRight");
        jg.c.g(tvDoubleClickRight);
        LottieAnimationView lottieDoubleClickLeft = cVar.f64686b;
        Intrinsics.g(lottieDoubleClickLeft, "lottieDoubleClickLeft");
        jg.c.g(lottieDoubleClickLeft);
        LottieAnimationView lottieDoubleClickRight = cVar.f64687c;
        Intrinsics.g(lottieDoubleClickRight, "lottieDoubleClickRight");
        jg.c.g(lottieDoubleClickRight);
        cVar.f64686b.pauseAnimation();
        cVar.f64687c.pauseAnimation();
        ConstraintLayout root = cVar.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.g(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("kv_video_double");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final void e(boolean z10) {
        ho.c cVar = this.f49153a;
        VideoDoubleClickBackgroundView vDoubleClick = cVar.f64690f;
        Intrinsics.g(vDoubleClick, "vDoubleClick");
        jg.c.k(vDoubleClick);
        boolean f11 = jg.c.f();
        cVar.f64690f.setLeftStyle(f11 ? z10 : !z10);
        if (z10) {
            if (f11) {
                cVar.f64687c.setScaleX(-1.0f);
            }
            AppCompatTextView tvDoubleClickRight = cVar.f64689e;
            Intrinsics.g(tvDoubleClickRight, "tvDoubleClickRight");
            jg.c.k(tvDoubleClickRight);
            LottieAnimationView lottieDoubleClickRight = cVar.f64687c;
            Intrinsics.g(lottieDoubleClickRight, "lottieDoubleClickRight");
            jg.c.k(lottieDoubleClickRight);
            cVar.f64687c.playAnimation();
        } else {
            if (f11) {
                cVar.f64686b.setScaleX(-1.0f);
            }
            AppCompatTextView tvDoubleClickLeft = cVar.f64688d;
            Intrinsics.g(tvDoubleClickLeft, "tvDoubleClickLeft");
            jg.c.k(tvDoubleClickLeft);
            LottieAnimationView lottieDoubleClickLeft = cVar.f64686b;
            Intrinsics.g(lottieDoubleClickLeft, "lottieDoubleClickLeft");
            jg.c.k(lottieDoubleClickLeft);
            cVar.f64686b.playAnimation();
        }
        ConstraintLayout root = cVar.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.k(root);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.h(animation, "animation");
        c();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.h(animation, "animation");
        c();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.h(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.h(animation, "animation");
    }
}
