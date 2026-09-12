package com.transsion.wrapperad.view.cardpage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleCoroutineScope;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.google.android.material.card.MaterialCardView;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.R$color;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.wrapperad.R$drawable;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.view.cardpage.e;
import cy.o;
import cy.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes7.dex */
public final class NativeCardPageAdHelper {

    /* renamed from: o, reason: collision with root package name */
    public static final a f58410o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final LifecycleCoroutineScope f58411a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f58412b;

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f58413c;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f58414d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f58415e;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f58416f;

    /* renamed from: g, reason: collision with root package name */
    private AnimatorSet f58417g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f58418h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f58419i;

    /* renamed from: j, reason: collision with root package name */
    private NativeCardPageView f58420j;

    /* renamed from: k, reason: collision with root package name */
    private BiddingSspNativeManager f58421k;

    /* renamed from: l, reason: collision with root package name */
    private String f58422l;

    /* renamed from: m, reason: collision with root package name */
    private Map f58423m;

    /* renamed from: n, reason: collision with root package name */
    private final c f58424n;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f58425a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NativeCardPageAdHelper f58426b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f58427c;

        b(ObjectAnimator objectAnimator, NativeCardPageAdHelper nativeCardPageAdHelper, f fVar) {
            this.f58425a = objectAnimator;
            this.f58426b = nativeCardPageAdHelper;
            this.f58427c = fVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
            super.onAnimationEnd(animation);
            this.f58425a.removeAllListeners();
            this.f58426b.D(this.f58427c);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends di.a {
        c() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            NativeCardPageView nativeCardPageView = NativeCardPageAdHelper.this.f58420j;
            if (nativeCardPageView != null) {
                jg.c.g(nativeCardPageView);
            }
            a.C0856a.f(lg.a.f68962a, "NativeCardPage", "onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), false, 4, null);
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            NativeCardPageAdHelper.this.v(biddingIntermediateMaterialBean != null ? CollectionsKt.e(biddingIntermediateMaterialBean) : null);
        }

        @Override // di.a
        public void k(List list) {
            super.k(list);
            NativeCardPageAdHelper.this.v(list);
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            NativeCardPageView nativeCardPageView = NativeCardPageAdHelper.this.f58420j;
            if (nativeCardPageView != null) {
                jg.c.g(nativeCardPageView);
            }
            a.C0856a.f(lg.a.f68962a, "NativeCardPage", "onBiddingWrapperAdShowError()", false, 4, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatImageView f58429a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f58430b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ NativeCardPageAdHelper f58431c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f58432d;

        d(AppCompatImageView appCompatImageView, float f11, NativeCardPageAdHelper nativeCardPageAdHelper, FrameLayout frameLayout) {
            this.f58429a = appCompatImageView;
            this.f58430b = f11;
            this.f58431c = nativeCardPageAdHelper;
            this.f58432d = frameLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.h(animation, "animation");
            ValueAnimator valueAnimator = this.f58431c.f58414d;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
            ValueAnimator valueAnimator = this.f58431c.f58414d;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
            }
            this.f58431c.K(this.f58429a, this.f58432d, this.f58430b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.h(animation, "animation");
            this.f58429a.setTranslationX(this.f58430b);
            this.f58429a.setAlpha(0.1f);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatImageView f58433a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f58434b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FrameLayout f58435c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NativeCardPageAdHelper f58436d;

        e(AppCompatImageView appCompatImageView, float f11, FrameLayout frameLayout, NativeCardPageAdHelper nativeCardPageAdHelper) {
            this.f58433a = appCompatImageView;
            this.f58434b = f11;
            this.f58435c = frameLayout;
            this.f58436d = nativeCardPageAdHelper;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.h(animation, "animation");
            AnimatorSet animatorSet = this.f58436d.f58417g;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            ValueAnimator valueAnimator = this.f58436d.f58415e;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
            }
            ValueAnimator valueAnimator2 = this.f58436d.f58416f;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
            this.f58435c.setVisibility(8);
            AnimatorSet animatorSet = this.f58436d.f58417g;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.f58436d.A();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.h(animation, "animation");
            this.f58433a.setTranslationX(this.f58434b);
            this.f58433a.setAlpha(0.1f);
        }
    }

    public NativeCardPageAdHelper(LifecycleCoroutineScope lifecycleScope) {
        Intrinsics.h(lifecycleScope, "lifecycleScope");
        this.f58411a = lifecycleScope;
        this.f58419i = true;
        this.f58422l = "";
        this.f58423m = new LinkedHashMap();
        this.f58424n = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        ValueAnimator valueAnimator = this.f58414d;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.f58415e;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.f58416f;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllListeners();
        }
        AnimatorSet animatorSet = this.f58417g;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        ValueAnimator valueAnimator4 = this.f58414d;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
        this.f58414d = null;
        ValueAnimator valueAnimator5 = this.f58415e;
        if (valueAnimator5 != null) {
            valueAnimator5.cancel();
        }
        this.f58415e = null;
        ValueAnimator valueAnimator6 = this.f58416f;
        if (valueAnimator6 != null) {
            valueAnimator6.cancel();
        }
        this.f58416f = null;
        AnimatorSet animatorSet2 = this.f58417g;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.f58417g = null;
    }

    private final void B() {
        NativeCardPageView nativeCardPageView = this.f58420j;
        if (nativeCardPageView != null) {
            z();
            k.d(this.f58411a, y0.b(), null, new NativeCardPageAdHelper$loadBiddingAd$1$1(this, nativeCardPageView, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(final f fVar) {
        ViewPager2 viewPager;
        NativeCardPageView nativeCardPageView = this.f58420j;
        if ((nativeCardPageView == null || (viewPager = nativeCardPageView.getViewPager()) == null || viewPager.isUserInputEnabled()) && fVar.e()) {
            if (this.f58419i) {
                this.f58419i = false;
                Runnable runnable = new Runnable() { // from class: com.transsion.wrapperad.view.cardpage.NativeCardPageAdHelper$prepareSwipeGuide$1
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeCardPageAdHelper.this.I(fVar);
                        NativeCardPageView nativeCardPageView2 = NativeCardPageAdHelper.this.f58420j;
                        if (nativeCardPageView2 != null) {
                            nativeCardPageView2.postDelayed(this, 7000L);
                        }
                    }
                };
                this.f58418h = runnable;
                runnable.run();
                return;
            }
            NativeCardPageView nativeCardPageView2 = this.f58420j;
            if (nativeCardPageView2 != null) {
                nativeCardPageView2.removeCallbacks(this.f58418h);
            }
            I(fVar);
        }
    }

    private final void E(f fVar) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) fVar.d().findViewById(R$id.native_ad_action);
        if (appCompatTextView != null) {
            int color = androidx.core.content.b.getColor(appCompatTextView.getContext(), R$color.ad_white_80);
            Drawable e11 = y0.h.e(appCompatTextView.getContext().getResources(), R$drawable.ad_shape_tag, appCompatTextView.getContext().getTheme());
            appCompatTextView.setTextColor(color);
            appCompatTextView.setBackground(e11);
        }
    }

    private final void H(f fVar) {
        ImageView imageView = (ImageView) fVar.d().findViewWithTag("adVolumeImage");
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            int a11 = a0.a(8.0f);
            layoutParams2.setMarginStart(a11);
            layoutParams2.bottomMargin = a11;
            int a12 = a0.a(26.0f);
            layoutParams2.width = a12;
            layoutParams2.height = a12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(f fVar) {
        Object m1185constructorimpl;
        ViewPager2 viewPager;
        ViewPager2 viewPager2;
        A();
        NativeCardPageView nativeCardPageView = this.f58420j;
        Unit unit = null;
        View childAt = (nativeCardPageView == null || (viewPager2 = nativeCardPageView.getViewPager()) == null) ? null : viewPager2.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                NativeCardPageView nativeCardPageView2 = this.f58420j;
                RecyclerView.b0 findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition((nativeCardPageView2 == null || (viewPager = nativeCardPageView2.getViewPager()) == null) ? 0 : viewPager.getCurrentItem());
                e.a aVar = findViewHolderForAdapterPosition instanceof e.a ? (e.a) findViewHolderForAdapterPosition : null;
                if (aVar != null) {
                    final FrameLayout frameLayout = (FrameLayout) aVar.itemView.findViewById(R$id.ad_cover);
                    AppCompatImageView appCompatImageView = (AppCompatImageView) aVar.itemView.findViewById(R$id.swipe_guide);
                    if (frameLayout != null && appCompatImageView != null) {
                        fVar.h(false);
                        frameLayout.setVisibility(0);
                        frameLayout.setAlpha(0.0f);
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        this.f58414d = ofFloat;
                        if (ofFloat != null) {
                            ofFloat.setDuration(500L);
                        }
                        ValueAnimator valueAnimator = this.f58414d;
                        if (valueAnimator != null) {
                            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.wrapperad.view.cardpage.a
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                                    NativeCardPageAdHelper.J(frameLayout, valueAnimator2);
                                }
                            });
                        }
                        float a11 = a0.a(100.0f);
                        ValueAnimator valueAnimator2 = this.f58414d;
                        if (valueAnimator2 != null) {
                            valueAnimator2.addListener(new d(appCompatImageView, a11, this, frameLayout));
                        }
                        ValueAnimator valueAnimator3 = this.f58414d;
                        if (valueAnimator3 != null) {
                            valueAnimator3.start();
                        }
                    }
                    unit = Unit.f67184a;
                }
                m1185constructorimpl = Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(FrameLayout frameLayout, ValueAnimator valueAnimator) {
        Intrinsics.h(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.f(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        frameLayout.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(final AppCompatImageView appCompatImageView, FrameLayout frameLayout, float f11) {
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            A();
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("translationX", Keyframe.ofFloat(0.0f, f11), Keyframe.ofFloat(0.4f, 0.0f), Keyframe.ofFloat(0.6f, 0.0f), Keyframe.ofFloat(1.0f, f11)));
            this.f58415e = ofPropertyValuesHolder;
            if (ofPropertyValuesHolder != null) {
                ofPropertyValuesHolder.setDuration(1500L);
            }
            ValueAnimator valueAnimator = this.f58415e;
            if (valueAnimator != null) {
                valueAnimator.setRepeatCount(1);
            }
            ValueAnimator valueAnimator2 = this.f58415e;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.wrapperad.view.cardpage.c
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        NativeCardPageAdHelper.L(AppCompatImageView.this, valueAnimator3);
                    }
                });
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.1f, 1.0f, 0.1f);
            this.f58416f = ofFloat;
            if (ofFloat != null) {
                ofFloat.setDuration(1500L);
            }
            ValueAnimator valueAnimator3 = this.f58416f;
            if (valueAnimator3 != null) {
                valueAnimator3.setRepeatCount(1);
            }
            ValueAnimator valueAnimator4 = this.f58416f;
            if (valueAnimator4 != null) {
                valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.wrapperad.view.cardpage.d
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator5) {
                        NativeCardPageAdHelper.M(AppCompatImageView.this, valueAnimator5);
                    }
                });
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.f58417g = animatorSet;
            animatorSet.playTogether(this.f58415e, this.f58416f);
            AnimatorSet animatorSet2 = this.f58417g;
            if (animatorSet2 != null) {
                animatorSet2.setDuration(1500L);
            }
            AnimatorSet animatorSet3 = this.f58417g;
            if (animatorSet3 != null) {
                animatorSet3.addListener(new e(appCompatImageView, f11, frameLayout, this));
            }
            AnimatorSet animatorSet4 = this.f58417g;
            if (animatorSet4 != null) {
                animatorSet4.start();
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AppCompatImageView appCompatImageView, ValueAnimator value) {
        Intrinsics.h(value, "value");
        Object animatedValue = value.getAnimatedValue();
        Intrinsics.f(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        appCompatImageView.setTranslationX(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(AppCompatImageView appCompatImageView, ValueAnimator it) {
        Intrinsics.h(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.f(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        appCompatImageView.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AppCompatTextView appCompatTextView, NativeCardPageAdHelper nativeCardPageAdHelper, f fVar) {
        ObjectAnimator duration = ObjectAnimator.ofArgb(appCompatTextView, "textColor", androidx.core.content.b.getColor(appCompatTextView.getContext(), R$color.ad_white_80), androidx.core.content.b.getColor(appCompatTextView.getContext(), R$color.gray_dark_00)).setDuration(300L);
        Intrinsics.g(duration, "setDuration(...)");
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{y0.h.e(appCompatTextView.getContext().getResources(), R$drawable.ad_shape_tag, appCompatTextView.getContext().getTheme()), y0.h.e(appCompatTextView.getContext().getResources(), R$drawable.bg_gradient_brand_4, appCompatTextView.getContext().getTheme())});
        appCompatTextView.setBackground(transitionDrawable);
        transitionDrawable.startTransition(300);
        duration.addListener(new b(duration, nativeCardPageAdHelper, fVar));
        duration.start();
    }

    private final void y() {
        NativeCardPageView nativeCardPageView;
        NativeCardPageView nativeCardPageView2;
        ObjectAnimator objectAnimator = this.f58413c;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.f58413c;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        this.f58413c = null;
        Runnable runnable = this.f58412b;
        if (runnable != null && (nativeCardPageView2 = this.f58420j) != null) {
            nativeCardPageView2.removeCallbacks(runnable);
        }
        this.f58412b = null;
        Runnable runnable2 = this.f58418h;
        if (runnable2 != null && (nativeCardPageView = this.f58420j) != null) {
            nativeCardPageView.removeCallbacks(runnable2);
        }
        this.f58418h = null;
    }

    private final void z() {
        BiddingSspNativeManager biddingSspNativeManager = this.f58421k;
        if (biddingSspNativeManager != null) {
            biddingSspNativeManager.V();
        }
        this.f58421k = null;
    }

    public final void C() {
        NativeCardPageView nativeCardPageView = this.f58420j;
        if (nativeCardPageView != null) {
            nativeCardPageView.pauseAutoScroll();
        }
    }

    public final NativeCardPageAdHelper F(Map ctxMap) {
        Intrinsics.h(ctxMap, "ctxMap");
        this.f58423m = ctxMap;
        return this;
    }

    public final NativeCardPageAdHelper G(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.f58422l = sceneId;
        return this;
    }

    public final void s(final f pageData) {
        Object m1185constructorimpl;
        Intrinsics.h(pageData, "pageData");
        final AppCompatTextView appCompatTextView = (AppCompatTextView) pageData.d().findViewById(R$id.native_ad_action);
        if (appCompatTextView != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                y();
                Runnable runnable = new Runnable() { // from class: com.transsion.wrapperad.view.cardpage.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeCardPageAdHelper.t(AppCompatTextView.this, this, pageData);
                    }
                };
                this.f58412b = runnable;
                NativeCardPageView nativeCardPageView = this.f58420j;
                m1185constructorimpl = Result.m1185constructorimpl(nativeCardPageView != null ? Boolean.valueOf(nativeCardPageView.postDelayed(runnable, 3000L)) : null);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
    }

    public final void u(NativeCardPageView pageView) {
        Intrinsics.h(pageView, "pageView");
        this.f58420j = pageView;
        B();
    }

    public final void v(List list) {
        List<f> l11;
        NativeCardPageView scrollInterval;
        NativeCardPageView nativeCardPageView = this.f58420j;
        if (nativeCardPageView != null) {
            if (list != null) {
                List<BiddingIntermediateMaterialBean> list2 = list;
                l11 = new ArrayList<>(CollectionsKt.v(list2, 10));
                for (BiddingIntermediateMaterialBean biddingIntermediateMaterialBean : list2) {
                    Context context = nativeCardPageView.getContext();
                    Intrinsics.g(context, "getContext(...)");
                    l11.add(new f(new NativeWrapperAdView(context, null, 2, null), biddingIntermediateMaterialBean, this, false, false, 16, null));
                }
            } else {
                l11 = CollectionsKt.l();
            }
            if (l11.isEmpty()) {
                return;
            }
            NativeCardPageView nativeCardPageView2 = this.f58420j;
            if (nativeCardPageView2 != null && (scrollInterval = nativeCardPageView2.setScrollInterval(com.transsion.ad.scene.a.f42255a.n(this.f58422l) * 1000)) != null) {
                scrollInterval.setPageData(l11);
            }
            jg.c.k(nativeCardPageView);
        }
    }

    public final void w(f pageData) {
        Intrinsics.h(pageData, "pageData");
        if (pageData.b()) {
            return;
        }
        NativeCardPageView nativeCardPageView = this.f58420j;
        if (nativeCardPageView != null) {
            pageData.f(true);
            NativeWrapperAdView d11 = pageData.d();
            BiddingSspNativeManager biddingSspNativeManager = this.f58421k;
            Context context = nativeCardPageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            o oVar = new o(context);
            Context context2 = nativeCardPageView.getContext();
            Intrinsics.g(context2, "getContext(...)");
            d11.bindSspNativeView(biddingSspNativeManager, oVar, new p(context2), pageData.a());
            H(pageData);
        }
        E(pageData);
    }

    public final void x() {
        z();
        NativeCardPageView nativeCardPageView = this.f58420j;
        if (nativeCardPageView != null) {
            nativeCardPageView.destroy();
        }
        NativeCardPageView nativeCardPageView2 = this.f58420j;
        ViewParent parent = nativeCardPageView2 != null ? nativeCardPageView2.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f58420j);
        }
        NativeCardPageView nativeCardPageView3 = this.f58420j;
        if (nativeCardPageView3 != null) {
            jg.c.g(nativeCardPageView3);
        }
        y();
        A();
    }
}
