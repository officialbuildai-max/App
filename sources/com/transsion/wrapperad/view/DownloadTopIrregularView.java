package com.transsion.wrapperad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.gyf.immersionbar.ImmersionBar;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.ScrollDetectFrameLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import ti.q;

@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001;\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u0012\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\nJ\r\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\nR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/transsion/wrapperad/view/DownloadTopIrregularView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "d", "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "f", "e", "Landroid/view/ViewGroup;", "geminiViewGroup", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "setViewGroup", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "", "deltaX", "deltaY", "Lcom/transsion/ad/view/ScrollDetectFrameLayout$ScrollDirection;", "direction", "onScroll", "(FFLcom/transsion/ad/view/ScrollDetectFrameLayout$ScrollDirection;)V", "loadAd", "showAd", PushConstants.PROVIDER_FIELD_DESTROY, "Lkotlinx/coroutines/t1;", "a", "Lkotlinx/coroutines/t1;", "job", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "closeImg", "c", "Landroid/view/ViewGroup;", "mGeminiViewGroup", "Lcom/transsion/ad/view/ScrollDetectFrameLayout$ScrollDirection;", "currentDirection", "Landroidx/lifecycle/LifecycleCoroutineScope;", "mLifecycleScope", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "nativeWrapperAdView", "Lcom/transsion/ad/bidding/base/r;", be.g.f16474b, "Lcom/transsion/ad/bidding/base/r;", "nativeViewBinder", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "h", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "mMaxEcpmObject", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "i", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adManager", "com/transsion/wrapperad/view/DownloadTopIrregularView$a", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/wrapperad/view/DownloadTopIrregularView$a;", "adListener", "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class DownloadTopIrregularView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private t1 job;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ImageView closeImg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mGeminiViewGroup;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ScrollDetectFrameLayout.ScrollDirection currentDirection;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleCoroutineScope mLifecycleScope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final NativeWrapperAdView nativeWrapperAdView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private r nativeViewBinder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BiddingIntermediateMaterialBean mMaxEcpmObject;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager adManager;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final a adListener;

    /* loaded from: classes7.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            DownloadTopIrregularView.this.mMaxEcpmObject = null;
            DownloadTopIrregularView.this.setVisibility(8);
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            DownloadTopIrregularView.this.mMaxEcpmObject = biddingIntermediateMaterialBean;
            DownloadTopIrregularView.this.showAd();
            DownloadTopIrregularView.this.f();
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            DownloadTopIrregularView.this.mMaxEcpmObject = null;
            DownloadTopIrregularView.this.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DownloadTopIrregularView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadTopIrregularView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.closeImg = new ImageView(context);
        this.nativeWrapperAdView = new NativeWrapperAdView(context, null, 2, null);
        this.adListener = new a();
    }

    public /* synthetic */ DownloadTopIrregularView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final void b() {
        q qVar = q.f76390a;
        qVar.a(this.nativeWrapperAdView);
        addView(this.nativeWrapperAdView);
        this.closeImg.setImageResource(R$mipmap.ad_irregular_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(20.0f), a0.a(20.0f));
        layoutParams.gravity = 8388629;
        layoutParams.setMarginEnd(a0.a(12.0f));
        this.closeImg.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.wrapperad.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadTopIrregularView.c(DownloadTopIrregularView.this, view);
            }
        });
        qVar.a(this.closeImg);
        addView(this.closeImg, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DownloadTopIrregularView downloadTopIrregularView, View view) {
        downloadTopIrregularView.destroy();
    }

    private final void d() {
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.adManager = null;
    }

    private final void e() {
        int statusBarHeight = ImmersionBar.getStatusBarHeight(getContext());
        ViewGroup viewGroup = this.mGeminiViewGroup;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = statusBarHeight;
            ViewGroup viewGroup2 = this.mGeminiViewGroup;
            if (viewGroup2 != null) {
                viewGroup2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        int e11 = (y.e() * 3) / 10;
        setLayoutParams(new FrameLayout.LayoutParams(-1, e11));
        jg.c.k(this.nativeWrapperAdView);
        ViewGroup viewGroup = this.mGeminiViewGroup;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = e11;
            ViewGroup viewGroup2 = this.mGeminiViewGroup;
            if (viewGroup2 != null) {
                viewGroup2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final void destroy() {
        d();
        this.mMaxEcpmObject = null;
        removeAllViews();
        e();
    }

    public final void loadAd() {
        LifecycleCoroutineScope a11;
        if (this.mMaxEcpmObject != null) {
            return;
        }
        if (this.adManager == null) {
            BiddingNativeManager biddingNativeManager = new BiddingNativeManager();
            this.adManager = biddingNativeManager;
            biddingNativeManager.O0("TabDownloadTopIrregularScene");
            BiddingNativeManager biddingNativeManager2 = this.adManager;
            if (biddingNativeManager2 != null) {
                biddingNativeManager2.N0(this.adListener);
            }
            b();
        }
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.k.d(a11, null, null, new DownloadTopIrregularView$loadAd$1(this, null), 3, null);
    }

    public final void onScroll(float deltaX, float deltaY, ScrollDetectFrameLayout.ScrollDirection direction) {
        Intrinsics.h(direction, "direction");
        if (this.mMaxEcpmObject == null || this.currentDirection == direction) {
            return;
        }
        this.currentDirection = direction;
        t1 t1Var = this.job;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        ViewGroup viewGroup = this.mGeminiViewGroup;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return;
        }
        int statusBarHeight = ImmersionBar.getStatusBarHeight(getContext());
        int height = getHeight();
        int i11 = marginLayoutParams.topMargin;
        if (i11 <= 0) {
            return;
        }
        if (direction == ScrollDetectFrameLayout.ScrollDirection.UP) {
            LifecycleCoroutineScope lifecycleCoroutineScope = this.mLifecycleScope;
            this.job = lifecycleCoroutineScope != null ? kotlinx.coroutines.k.d(lifecycleCoroutineScope, null, null, new DownloadTopIrregularView$onScroll$1(i11, statusBarHeight, this, marginLayoutParams, null), 3, null) : null;
        } else {
            LifecycleCoroutineScope lifecycleCoroutineScope2 = this.mLifecycleScope;
            this.job = lifecycleCoroutineScope2 != null ? kotlinx.coroutines.k.d(lifecycleCoroutineScope2, null, null, new DownloadTopIrregularView$onScroll$2(this, height, i11, marginLayoutParams, null), 3, null) : null;
        }
    }

    public final void setViewGroup(ViewGroup geminiViewGroup, LifecycleCoroutineScope lifecycleScope) {
        Intrinsics.h(lifecycleScope, "lifecycleScope");
        this.mGeminiViewGroup = geminiViewGroup;
        this.mLifecycleScope = lifecycleScope;
        e();
    }

    public final void showAd() {
        if (this.nativeViewBinder == null) {
            cy.b bVar = cy.b.f61063a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            this.nativeViewBinder = bVar.a(context, "TabDownloadTopIrregularScene");
        }
        this.nativeWrapperAdView.bindNativeView(this.adManager, this.nativeViewBinder, this.mMaxEcpmObject);
    }
}
