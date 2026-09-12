package com.transsion.wrapperad.view.secondfloor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.strategy.AdOverridePendingTransitionManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import lg.a;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0005*\u0001X\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J;\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001aJ\r\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001aJ\r\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001aJ2\u0010$\u001a\u00020\u000f2#\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001f¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u000f2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\n¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u000f¢\u0006\u0004\b+\u0010\u001aJ\r\u0010,\u001a\u00020\u000f¢\u0006\u0004\b,\u0010\u001aR\u001b\u00101\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR3\u0010G\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010R\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010.\u001a\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006\\"}, d2 = {"Lcom/transsion/wrapperad/view/secondfloor/TrendingTwoLevelIrregularView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "targetAlpha", "", "duration", "Lkotlin/Function0;", "", "onEnd", "d", "(Landroid/view/View;FJLkotlin/jvm/functions/Function0;)V", "", "hasAd", "()Z", "ignoreInterval", "loadAd", "(Z)V", "showAd", "()V", "adClick", "resetAd", "destroyAd", PushConstants.PROVIDER_FIELD_DESTROY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, "callback", "setLoadCallback", "(Lkotlin/jvm/functions/Function1;)V", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "adHoverHalfHeight", "hoverHalfTrigger", "(F)V", "refreshing", "idleTrigger", "a", "Lkotlin/Lazy;", "getDensity", "()F", "density", "Ley/f;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ley/f;", "getBinding", "()Ley/f;", "setBinding", "(Ley/f;)V", "binding", "Lcom/transsion/ad/bidding/base/r;", "c", "Lcom/transsion/ad/bidding/base/r;", "nativeViewBinder", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "mMaxEcpmObject", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "e", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adManager", "f", "Lkotlin/jvm/functions/Function1;", "loadedCallback", be.g.f16474b, "Lkotlin/jvm/functions/Function0;", "clickCallback", "h", "Z", "isAdBind", "i", "isAdLoading", j.f35620b, "J", "lastRefreshTime", "", CampaignEx.JSON_KEY_AD_K, "getLoadInterval", "()I", "loadInterval", "com/transsion/wrapperad/view/secondfloor/TrendingTwoLevelIrregularView$a", "l", "Lcom/transsion/wrapperad/view/secondfloor/TrendingTwoLevelIrregularView$a;", "adListener", "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class TrendingTwoLevelIrregularView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy density;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ey.f binding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private r nativeViewBinder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BiddingIntermediateMaterialBean mMaxEcpmObject;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager adManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1 loadedCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Function0 clickCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAdBind;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isAdLoading;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long lastRefreshTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy loadInterval;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final a adListener;

    /* loaded from: classes7.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            TrendingTwoLevelIrregularView.this.mMaxEcpmObject = null;
            TrendingTwoLevelIrregularView.this.isAdLoading = false;
            Function1 function1 = TrendingTwoLevelIrregularView.this.loadedCallback;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            TrendingTwoLevelIrregularView.this.mMaxEcpmObject = biddingIntermediateMaterialBean;
            TrendingTwoLevelIrregularView.this.isAdLoading = false;
            Function1 function1 = TrendingTwoLevelIrregularView.this.loadedCallback;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        }

        @Override // di.a
        public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.l(biddingIntermediateMaterialBean);
            Function0 function0 = TrendingTwoLevelIrregularView.this.clickCallback;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            TrendingTwoLevelIrregularView.this.mMaxEcpmObject = null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0 f58512a;

        b(Function0 function0) {
            this.f58512a = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
            super.onAnimationEnd(animation);
            Function0 function0 = this.f58512a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public TrendingTwoLevelIrregularView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TrendingTwoLevelIrregularView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.density = LazyKt.b(new Function0() { // from class: com.transsion.wrapperad.view.secondfloor.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float f11;
                f11 = TrendingTwoLevelIrregularView.f(context);
                return Float.valueOf(f11);
            }
        });
        ey.f c11 = ey.f.c(LayoutInflater.from(context), this, true);
        Intrinsics.g(c11, "inflate(...)");
        this.binding = c11;
        this.loadInterval = LazyKt.b(new Function0() { // from class: com.transsion.wrapperad.view.secondfloor.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int h11;
                h11 = TrendingTwoLevelIrregularView.h();
                return Integer.valueOf(h11);
            }
        });
        this.adListener = new a();
    }

    public /* synthetic */ TrendingTwoLevelIrregularView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final void d(View view, float targetAlpha, long duration, Function0 onEnd) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, view.getAlpha(), targetAlpha);
        ofFloat.setDuration(duration);
        ofFloat.addListener(new b(onEnd));
        ofFloat.start();
    }

    static /* synthetic */ void e(TrendingTwoLevelIrregularView trendingTwoLevelIrregularView, View view, float f11, long j11, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j11 = 400;
        }
        long j12 = j11;
        if ((i11 & 8) != 0) {
            function0 = null;
        }
        trendingTwoLevelIrregularView.d(view, f11, j12, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(CardView cardView) {
        Intrinsics.e(cardView);
        jg.c.g(cardView);
        return Unit.f67184a;
    }

    private final float getDensity() {
        return ((Number) this.density.getValue()).floatValue();
    }

    private final int getLoadInterval() {
        return ((Number) this.loadInterval.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h() {
        return com.transsion.ad.scene.a.f42255a.n("TrendingTwoLevelloftScene") * 1000;
    }

    public static /* synthetic */ void loadAd$default(TrendingTwoLevelIrregularView trendingTwoLevelIrregularView, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        trendingTwoLevelIrregularView.loadAd(z10);
    }

    public final void adClick() {
        NativeWrapperAdView.simulatingClick$default(this.binding.f62222d, this.mMaxEcpmObject, this.nativeViewBinder, null, 4, null);
    }

    public final void destroy() {
        destroyAd();
        this.loadedCallback = null;
        this.clickCallback = null;
    }

    public final void destroyAd() {
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.adManager = null;
    }

    public final ey.f getBinding() {
        return this.binding;
    }

    public final boolean hasAd() {
        return this.mMaxEcpmObject != null;
    }

    public final void hoverHalfTrigger(float adHoverHalfHeight) {
        final CardView cardView = this.binding.f62221c;
        Intrinsics.e(cardView);
        e(this, cardView, 0.0f, 0L, new Function0() { // from class: com.transsion.wrapperad.view.secondfloor.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit g11;
                g11 = TrendingTwoLevelIrregularView.g(CardView.this);
                return g11;
            }
        }, 4, null);
        CardView cardView2 = this.binding.f62220b;
        ViewGroup.LayoutParams layoutParams = cardView2.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = (int) ((adHoverHalfHeight - ((ViewGroup.MarginLayoutParams) r0).height) - (getDensity() * 12.0f));
        cardView2.setAlpha(0.0f);
        Intrinsics.e(cardView2);
        jg.c.k(cardView2);
        e(this, cardView2, 1.0f, 0L, null, 12, null);
    }

    public final void idleTrigger() {
        CardView adDetailBtn = this.binding.f62221c;
        Intrinsics.g(adDetailBtn, "adDetailBtn");
        jg.c.g(adDetailBtn);
        CardView adDetailArrow = this.binding.f62220b;
        Intrinsics.g(adDetailArrow, "adDetailArrow");
        jg.c.g(adDetailArrow);
    }

    public final void loadAd(boolean ignoreInterval) {
        LifecycleCoroutineScope a11;
        this.isAdBind = false;
        if (this.isAdLoading || hasAd()) {
            a.C0856a.f(lg.a.f68962a, CustomSwipeRefreshLayout.TAG, "--> isAdLoading: " + this.isAdLoading + ", hasAd: " + hasAd(), false, 4, null);
            return;
        }
        if (!ignoreInterval && System.currentTimeMillis() - this.lastRefreshTime < getLoadInterval()) {
            a.C0856a.f(lg.a.f68962a, CustomSwipeRefreshLayout.TAG, "--> The refresh interval has not arrived", false, 4, null);
            return;
        }
        this.lastRefreshTime = System.currentTimeMillis();
        this.isAdLoading = true;
        destroyAd();
        BiddingNativeManager biddingNativeManager = new BiddingNativeManager();
        this.adManager = biddingNativeManager;
        biddingNativeManager.O0("TrendingTwoLevelloftScene");
        BiddingNativeManager biddingNativeManager2 = this.adManager;
        if (biddingNativeManager2 != null) {
            biddingNativeManager2.N0(this.adListener);
        }
        BiddingNativeManager biddingNativeManager3 = this.adManager;
        if (biddingNativeManager3 != null) {
            biddingNativeManager3.J0(AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum.OVERRIDE_PENDING_TRANSITION_1);
        }
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        k.d(a11, null, null, new TrendingTwoLevelIrregularView$loadAd$1(this, null), 3, null);
    }

    public final void refreshing() {
        CardView cardView = this.binding.f62221c;
        cardView.setAlpha(0.0f);
        Intrinsics.e(cardView);
        jg.c.k(cardView);
        e(this, cardView, 1.0f, 0L, null, 12, null);
        CardView adDetailArrow = this.binding.f62220b;
        Intrinsics.g(adDetailArrow, "adDetailArrow");
        jg.c.g(adDetailArrow);
    }

    public final void resetAd() {
        this.mMaxEcpmObject = null;
    }

    public final void setBinding(ey.f fVar) {
        Intrinsics.h(fVar, "<set-?>");
        this.binding = fVar;
    }

    public final void setClickCallback(Function0<Unit> callback) {
        this.clickCallback = callback;
    }

    public final void setLoadCallback(Function1<? super Boolean, Unit> callback) {
        this.loadedCallback = callback;
    }

    public final void showAd() {
        if (this.isAdBind) {
            return;
        }
        this.isAdBind = true;
        if (this.nativeViewBinder == null) {
            cy.b bVar = cy.b.f61063a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            this.nativeViewBinder = bVar.a(context, "TrendingTwoLevelloftScene");
        }
        this.binding.f62222d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.binding.f62222d.bindNativeView(this.adManager, this.nativeViewBinder, this.mMaxEcpmObject);
    }
}
