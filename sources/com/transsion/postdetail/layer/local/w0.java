package com.transsion.postdetail.layer.local;

import android.animation.Animator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mmkv.MMKV;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class w0 implements Animator.AnimatorListener {

    /* renamed from: b, reason: collision with root package name */
    public static final a f49188b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f49189c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.v0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = w0.c();
            return c11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final so.a0 f49190a;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public w0(so.a0 bind) {
        Intrinsics.h(bind, "bind");
        this.f49190a = bind;
        bind.f75542b.addAnimatorListener(this);
        bind.f75543c.addAnimatorListener(this);
    }

    private final void b() {
        so.a0 a0Var = this.f49190a;
        VideoDoubleClickBackgroundView vDoubleClick = a0Var.f75546f;
        Intrinsics.g(vDoubleClick, "vDoubleClick");
        jg.c.g(vDoubleClick);
        AppCompatTextView tvDoubleClickLeft = a0Var.f75544d;
        Intrinsics.g(tvDoubleClickLeft, "tvDoubleClickLeft");
        jg.c.g(tvDoubleClickLeft);
        AppCompatTextView tvDoubleClickRight = a0Var.f75545e;
        Intrinsics.g(tvDoubleClickRight, "tvDoubleClickRight");
        jg.c.g(tvDoubleClickRight);
        LottieAnimationView lottieDoubleClickLeft = a0Var.f75542b;
        Intrinsics.g(lottieDoubleClickLeft, "lottieDoubleClickLeft");
        jg.c.g(lottieDoubleClickLeft);
        LottieAnimationView lottieDoubleClickRight = a0Var.f75543c;
        Intrinsics.g(lottieDoubleClickRight, "lottieDoubleClickRight");
        jg.c.g(lottieDoubleClickRight);
        a0Var.f75542b.pauseAnimation();
        a0Var.f75543c.pauseAnimation();
        ConstraintLayout root = a0Var.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.g(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("kv_video_double");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final void d(boolean z10) {
        so.a0 a0Var = this.f49190a;
        VideoDoubleClickBackgroundView vDoubleClick = a0Var.f75546f;
        Intrinsics.g(vDoubleClick, "vDoubleClick");
        jg.c.k(vDoubleClick);
        a0Var.f75546f.setLeftStyle(!z10);
        if (z10) {
            AppCompatTextView tvDoubleClickRight = a0Var.f75545e;
            Intrinsics.g(tvDoubleClickRight, "tvDoubleClickRight");
            jg.c.k(tvDoubleClickRight);
            LottieAnimationView lottieDoubleClickRight = a0Var.f75543c;
            Intrinsics.g(lottieDoubleClickRight, "lottieDoubleClickRight");
            jg.c.k(lottieDoubleClickRight);
            a0Var.f75543c.playAnimation();
        } else {
            AppCompatTextView tvDoubleClickLeft = a0Var.f75544d;
            Intrinsics.g(tvDoubleClickLeft, "tvDoubleClickLeft");
            jg.c.k(tvDoubleClickLeft);
            LottieAnimationView lottieDoubleClickLeft = a0Var.f75542b;
            Intrinsics.g(lottieDoubleClickLeft, "lottieDoubleClickLeft");
            jg.c.k(lottieDoubleClickLeft);
            a0Var.f75542b.playAnimation();
        }
        ConstraintLayout root = a0Var.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.k(root);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.h(animation, "animation");
        b();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.h(animation, "animation");
        b();
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
