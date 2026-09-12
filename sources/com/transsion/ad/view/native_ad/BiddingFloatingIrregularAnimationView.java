package com.transsion.ad.view.native_ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.blankj.utilcode.util.a0;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.material.card.MaterialCardView;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.bidding.base.AbsBiddingBuyOutView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import ti.g;
import ti.q;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u00013\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\nJ\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\nJ\u0017\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/transsion/ad/view/native_ad/BiddingFloatingIrregularAnimationView;", "Lcom/transsion/ad/bidding/base/AbsBiddingBuyOutView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "l", "()V", TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_Q, "o", "Landroid/widget/FrameLayout;", "getMediaContainer", "()Landroid/widget/FrameLayout;", "", "isShowVolumeIcon", "()Z", "", "getLogTag", "()Ljava/lang/String;", "onAdViewDestroy", "isCollapsed", "changeState", "(Z)V", "loadAd", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "mMaxEcpmObject", "Z", "", CampaignEx.JSON_KEY_AD_R, "F", "currentTranslationX", "s", "Landroid/widget/FrameLayout;", "mediaContainer", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "closeImg", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", TmcStartParams.KEY_URL_SHORT, "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adManager", "com/transsion/ad/view/native_ad/BiddingFloatingIrregularAnimationView$a", "v", "Lcom/transsion/ad/view/native_ad/BiddingFloatingIrregularAnimationView$a;", "adListener", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class BiddingFloatingIrregularAnimationView extends AbsBiddingBuyOutView {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private BiddingIntermediateMaterialBean mMaxEcpmObject;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isCollapsed;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private float currentTranslationX;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout mediaContainer;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final ImageView closeImg;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager adManager;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final a adListener;

    /* loaded from: classes5.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            BiddingFloatingIrregularAnimationView.this.setVisibility(8);
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularAnimationView.this.mMaxEcpmObject = biddingIntermediateMaterialBean;
            BiddingFloatingIrregularAnimationView.this.setEcpmObject(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularAnimationView.this.showMedia();
            BiddingFloatingIrregularAnimationView.this.closeImg.setVisibility(0);
            BiddingFloatingIrregularAnimationView.this.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f42479b;

        b(float f11) {
            this.f42479b = f11;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BiddingFloatingIrregularAnimationView.this.currentTranslationX = this.f42479b;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f42481b;

        c(float f11) {
            this.f42481b = f11;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BiddingFloatingIrregularAnimationView.this.currentTranslationX = this.f42481b;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BiddingFloatingIrregularAnimationView.this.currentTranslationX = 0.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends RecyclerView.r {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 == 0) {
                BiddingFloatingIrregularAnimationView.this.changeState(false);
            } else {
                if (i11 != 1) {
                    return;
                }
                BiddingFloatingIrregularAnimationView.this.changeState(true);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BiddingFloatingIrregularAnimationView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BiddingFloatingIrregularAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.mediaContainer = new FrameLayout(context);
        this.closeImg = new ImageView(context);
        this.adListener = new a();
    }

    public /* synthetic */ BiddingFloatingIrregularAnimationView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final void l() {
        q qVar = q.f76390a;
        qVar.a(this.mediaContainer);
        addView(this.mediaContainer);
        this.closeImg.setImageResource(R$mipmap.ad_irregular_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(16.0f), a0.a(16.0f));
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        this.closeImg.setVisibility(8);
        this.closeImg.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.view.native_ad.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingFloatingIrregularAnimationView.m(BiddingFloatingIrregularAnimationView.this, view);
            }
        });
        qVar.a(this.closeImg);
        addView(this.closeImg, layoutParams);
        setOnClickListener(new g(0L, new Function1() { // from class: com.transsion.ad.view.native_ad.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n11;
                n11 = BiddingFloatingIrregularAnimationView.n(BiddingFloatingIrregularAnimationView.this, (View) obj);
                return n11;
            }
        }, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, View view) {
        biddingFloatingIrregularAnimationView.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, View it) {
        Intrinsics.h(it, "it");
        if (!biddingFloatingIrregularAnimationView.isCollapsed) {
            biddingFloatingIrregularAnimationView.onAdClick();
        }
        return Unit.f67184a;
    }

    private final void o() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        float width = getWidth() + ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r0.getMarginEnd() : 0);
        TranslateAnimation translateAnimation = new TranslateAnimation(this.currentTranslationX, width, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new b(width));
        startAnimation(translateAnimation);
        destroy();
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.adManager = null;
        this.mediaContainer.removeAllViews();
        this.mMaxEcpmObject = null;
        this.isCollapsed = true;
    }

    private final void p() {
        float width = (getWidth() * 4) / 5.0f;
        TranslateAnimation translateAnimation = new TranslateAnimation(this.currentTranslationX, width, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new c(width));
        startAnimation(translateAnimation);
        this.isCollapsed = true;
        setAlpha(0.4f);
    }

    private final void q() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.currentTranslationX, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new d());
        startAnimation(translateAnimation);
        this.isCollapsed = false;
        setAlpha(1.0f);
    }

    public final void changeState(boolean isCollapsed) {
        if (this.mMaxEcpmObject == null || isCollapsed == this.isCollapsed) {
            return;
        }
        if (isCollapsed) {
            p();
        } else {
            q();
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingBuyOutView, oi.b
    public String getLogTag() {
        return "ad_fb";
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingBuyOutView
    public FrameLayout getMediaContainer() {
        return this.mediaContainer;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingBuyOutView
    /* renamed from: isShowVolumeIcon */
    public boolean getMIsShowVolumeIcon() {
        return false;
    }

    public final void loadAd() {
        LifecycleCoroutineScope a11;
        if (this.mMaxEcpmObject != null) {
            return;
        }
        if (this.adManager == null) {
            BiddingNativeManager biddingNativeManager = new BiddingNativeManager();
            this.adManager = biddingNativeManager;
            biddingNativeManager.O0(getMSceneId());
            BiddingNativeManager biddingNativeManager2 = this.adManager;
            if (biddingNativeManager2 != null) {
                biddingNativeManager2.N0(this.adListener);
            }
            setListener(this.adManager);
        }
        l();
        q();
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        k.d(a11, null, null, new BiddingFloatingIrregularAnimationView$loadAd$1(this, null), 3, null);
    }

    public final void onAdViewDestroy() {
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        removeAllViews();
        destroy();
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new e());
        }
    }
}
