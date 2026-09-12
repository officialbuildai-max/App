package com.transsion.wrapperad.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.blankj.utilcode.util.a0;
import com.google.android.material.card.MaterialCardView;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import ti.q;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0005*\u0001C\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\nJ\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\nJ\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010,R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/transsion/wrapperad/view/BiddingFloatingIrregularAnimationView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "n", "()V", "f", com.mbridge.msdk.foundation.same.report.j.f35620b, "l", "h", "o", PushConstants.PROVIDER_FIELD_DESTROY, "", "isCollapsed", "changeState", "(Z)V", "loadAd", "showAd", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "a", "Ljava/lang/String;", "sceneId", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "nativeWrapperAdView", "Lcom/transsion/ad/bidding/base/r;", "c", "Lcom/transsion/ad/bidding/base/r;", "nativeViewBinder", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "d", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "mMaxEcpmObject", "e", "Z", "hiSceneOff", be.g.f16474b, "hiPlacementNon", "", "F", "currentTranslationX", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "closeImg", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adManager", "", CampaignEx.JSON_KEY_AD_K, "J", "lastRefreshTime", "", "Lkotlin/Lazy;", "getLoadInterval", "()I", "loadInterval", "com/transsion/wrapperad/view/BiddingFloatingIrregularAnimationView$a", "m", "Lcom/transsion/wrapperad/view/BiddingFloatingIrregularAnimationView$a;", "adListener", "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class BiddingFloatingIrregularAnimationView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final NativeWrapperAdView nativeWrapperAdView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private r nativeViewBinder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BiddingIntermediateMaterialBean mMaxEcpmObject;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isCollapsed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hiSceneOff;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hiPlacementNon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float currentTranslationX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ImageView closeImg;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager adManager;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long lastRefreshTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy loadInterval;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final a adListener;

    /* loaded from: classes7.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            BiddingFloatingIrregularAnimationView.this.o();
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularAnimationView.this.mMaxEcpmObject = biddingIntermediateMaterialBean;
            BiddingFloatingIrregularAnimationView.this.showAd();
        }

        @Override // di.a
        public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.l(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularAnimationView.this.mMaxEcpmObject = null;
            BiddingFloatingIrregularAnimationView.this.lastRefreshTime = 0L;
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularAnimationView.this.o();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends RecyclerView.r {
        b() {
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
        this.sceneId = "TabDownloadIrregularFloatingScene";
        NativeWrapperAdView nativeWrapperAdView = new NativeWrapperAdView(context, null, 2, null);
        this.nativeWrapperAdView = nativeWrapperAdView;
        this.hiSceneOff = true;
        this.hiPlacementNon = true;
        this.closeImg = new ImageView(context);
        this.loadInterval = LazyKt.b(new Function0() { // from class: com.transsion.wrapperad.view.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int p11;
                p11 = BiddingFloatingIrregularAnimationView.p(BiddingFloatingIrregularAnimationView.this);
                return Integer.valueOf(p11);
            }
        });
        this.adListener = new a();
        this.hiSceneOff = com.transsion.ad.scene.c.b(com.transsion.ad.scene.c.f42257a, "TabDownloadIrregularFloatingScene", false, 2, null);
        this.hiPlacementNon = TextUtils.isEmpty(com.transsion.ad.scene.a.f42255a.h("TabDownloadIrregularFloatingScene"));
        addView(nativeWrapperAdView, new FrameLayout.LayoutParams(-1, -1));
        f();
        l();
    }

    public /* synthetic */ BiddingFloatingIrregularAnimationView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final void f() {
        this.closeImg.setImageResource(R$mipmap.ad_irregular_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(16.0f), a0.a(16.0f));
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        this.closeImg.setVisibility(8);
        this.closeImg.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.wrapperad.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingFloatingIrregularAnimationView.g(BiddingFloatingIrregularAnimationView.this, view);
            }
        });
        q.f76390a.a(this.closeImg);
        addView(this.closeImg, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, View view) {
        biddingFloatingIrregularAnimationView.h();
        biddingFloatingIrregularAnimationView.lastRefreshTime = 0L;
    }

    private final int getLoadInterval() {
        return ((Number) this.loadInterval.getValue()).intValue();
    }

    private final void h() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        final float width = getWidth() + ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r0.getMarginEnd() : 0);
        animate().translationX(width).setDuration(300L).withEndAction(new Runnable() { // from class: com.transsion.wrapperad.view.e
            @Override // java.lang.Runnable
            public final void run() {
                BiddingFloatingIrregularAnimationView.i(BiddingFloatingIrregularAnimationView.this, width);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, float f11) {
        biddingFloatingIrregularAnimationView.currentTranslationX = f11;
        biddingFloatingIrregularAnimationView.destroy();
    }

    private final void j() {
        final float width = (getWidth() * 4) / 5.0f;
        animate().translationX(width).setDuration(300L).withEndAction(new Runnable() { // from class: com.transsion.wrapperad.view.a
            @Override // java.lang.Runnable
            public final void run() {
                BiddingFloatingIrregularAnimationView.k(BiddingFloatingIrregularAnimationView.this, width);
            }
        }).start();
        this.isCollapsed = true;
        setAlpha(0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, float f11) {
        biddingFloatingIrregularAnimationView.currentTranslationX = f11;
    }

    private final void l() {
        animate().translationX(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.transsion.wrapperad.view.b
            @Override // java.lang.Runnable
            public final void run() {
                BiddingFloatingIrregularAnimationView.m(BiddingFloatingIrregularAnimationView.this);
            }
        }).start();
        this.isCollapsed = false;
        setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView) {
        biddingFloatingIrregularAnimationView.currentTranslationX = 0.0f;
    }

    private final void n() {
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.adManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.mMaxEcpmObject = null;
        setVisibility(8);
        this.closeImg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView) {
        return com.transsion.ad.scene.a.f42255a.n(biddingFloatingIrregularAnimationView.sceneId) * 1000;
    }

    public final void changeState(boolean isCollapsed) {
        if (this.mMaxEcpmObject == null || isCollapsed == this.isCollapsed) {
            return;
        }
        if (isCollapsed) {
            j();
        } else {
            l();
        }
    }

    public final void destroy() {
        n();
        o();
        this.isCollapsed = true;
    }

    public final void loadAd() {
        LifecycleCoroutineScope a11;
        if ((this.hiSceneOff || this.hiPlacementNon) && this.mMaxEcpmObject != null) {
            return;
        }
        if (System.currentTimeMillis() - this.lastRefreshTime < getLoadInterval()) {
            a.C0856a.f(lg.a.f68962a, "Floating", "--> The refresh interval has not arrived", false, 4, null);
            return;
        }
        this.lastRefreshTime = System.currentTimeMillis();
        n();
        BiddingNativeManager biddingNativeManager = new BiddingNativeManager();
        this.adManager = biddingNativeManager;
        biddingNativeManager.O0(this.sceneId);
        BiddingNativeManager biddingNativeManager2 = this.adManager;
        if (biddingNativeManager2 != null) {
            biddingNativeManager2.N0(this.adListener);
        }
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.k.d(a11, null, null, new BiddingFloatingIrregularAnimationView$loadAd$1(this, null), 3, null);
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new b());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r3 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showAd() {
        /*
            r6 = this;
            com.transsion.ad.bidding.nativead.BiddingNativeManager r0 = r6.adManager
            r1 = 0
            if (r0 == 0) goto La
            boolean r0 = r0.U0()
            goto Lb
        La:
            r0 = r1
        Lb:
            if (r0 == 0) goto L3a
            com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r2 = r6.mMaxEcpmObject
            r3 = 0
            if (r2 == 0) goto L1d
            com.hisavana.common.bean.TAdNativeInfo r2 = r2.getNativeInfo()
            if (r2 == 0) goto L1d
            com.hisavana.common.bean.TAdNativeInfo$Image r2 = r2.getIcon()
            goto L1e
        L1d:
            r2 = r3
        L1e:
            if (r2 == 0) goto L36
            com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r2 = r6.mMaxEcpmObject
            if (r2 == 0) goto L34
            com.hisavana.common.bean.TAdNativeInfo r2 = r2.getNativeInfo()
            if (r2 == 0) goto L34
            com.hisavana.common.bean.TAdNativeInfo$Image r2 = r2.getIcon()
            if (r2 == 0) goto L34
            java.lang.String r3 = r2.getUrl()
        L34:
            if (r3 != 0) goto L3a
        L36:
            r6.o()
            return
        L3a:
            com.transsion.ad.bidding.base.r r2 = r6.nativeViewBinder
            if (r2 != 0) goto L51
            cy.b r2 = cy.b.f61063a
            android.content.Context r3 = r6.getContext()
            java.lang.String r4 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            java.lang.String r4 = r6.sceneId
            com.transsion.ad.bidding.base.r r2 = r2.a(r3, r4)
            r6.nativeViewBinder = r2
        L51:
            com.transsion.ad.view.native_ad.NativeWrapperAdView r2 = r6.nativeWrapperAdView
            com.transsion.ad.bidding.nativead.BiddingNativeManager r3 = r6.adManager
            com.transsion.ad.bidding.base.r r4 = r6.nativeViewBinder
            com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r5 = r6.mMaxEcpmObject
            r2.bindNativeView(r3, r4, r5)
            if (r0 == 0) goto L6e
            com.transsion.ad.view.native_ad.NativeWrapperAdView r0 = r6.nativeWrapperAdView
            int r2 = com.transsion.wrapperad.R$id.ad_media
            android.view.View r0 = r0.findViewById(r2)
            com.hisavana.mediation.ad.TMediaView r0 = (com.hisavana.mediation.ad.TMediaView) r0
            if (r0 == 0) goto L7d
            jg.c.g(r0)
            goto L7d
        L6e:
            com.transsion.ad.view.native_ad.NativeWrapperAdView r0 = r6.nativeWrapperAdView
            int r2 = com.transsion.wrapperad.R$id.ad_icon
            android.view.View r0 = r0.findViewById(r2)
            com.hisavana.mediation.ad.TIconView r0 = (com.hisavana.mediation.ad.TIconView) r0
            if (r0 == 0) goto L7d
            jg.c.g(r0)
        L7d:
            android.widget.ImageView r0 = r6.closeImg
            r0.setVisibility(r1)
            r6.setVisibility(r1)
            boolean r0 = r6.isCollapsed
            if (r0 == 0) goto L8c
            r6.l()
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.wrapperad.view.BiddingFloatingIrregularAnimationView.showAd():void");
    }
}
