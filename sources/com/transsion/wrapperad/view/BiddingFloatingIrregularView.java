package com.transsion.wrapperad.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
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

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005*\u00015\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\nJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/transsion/wrapperad/view/BiddingFloatingIrregularView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "d", "()V", "f", be.g.f16474b, "loadAd", "showAd", PushConstants.PROVIDER_FIELD_DESTROY, "", "a", "Ljava/lang/String;", "sceneId", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "nativeWrapperAdView", "Lcom/transsion/ad/bidding/base/r;", "c", "Lcom/transsion/ad/bidding/base/r;", "nativeViewBinder", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "mMaxEcpmObject", "", "e", "Z", "hiSceneOff", "hiPlacementNon", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "closeImg", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "h", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adManager", "", "i", "J", "lastRefreshTime", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lkotlin/Lazy;", "getLoadInterval", "()I", "loadInterval", "com/transsion/wrapperad/view/BiddingFloatingIrregularView$a", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/wrapperad/view/BiddingFloatingIrregularView$a;", "adListener", "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class BiddingFloatingIrregularView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final NativeWrapperAdView nativeWrapperAdView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private r nativeViewBinder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BiddingIntermediateMaterialBean mMaxEcpmObject;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hiSceneOff;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hiPlacementNon;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ImageView closeImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager adManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long lastRefreshTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy loadInterval;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final a adListener;

    /* loaded from: classes7.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            BiddingFloatingIrregularView.this.g();
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularView.this.mMaxEcpmObject = biddingIntermediateMaterialBean;
            BiddingFloatingIrregularView.this.showAd();
        }

        @Override // di.a
        public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.l(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularView.this.mMaxEcpmObject = null;
            BiddingFloatingIrregularView.this.lastRefreshTime = 0L;
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularView.this.g();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BiddingFloatingIrregularView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BiddingFloatingIrregularView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.sceneId = "TrendingFloatIrregularAd";
        NativeWrapperAdView nativeWrapperAdView = new NativeWrapperAdView(context, null, 2, null);
        this.nativeWrapperAdView = nativeWrapperAdView;
        this.hiSceneOff = true;
        this.hiPlacementNon = true;
        this.closeImg = new ImageView(context);
        this.loadInterval = LazyKt.b(new Function0() { // from class: com.transsion.wrapperad.view.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int h11;
                h11 = BiddingFloatingIrregularView.h(BiddingFloatingIrregularView.this);
                return Integer.valueOf(h11);
            }
        });
        this.adListener = new a();
        this.hiSceneOff = com.transsion.ad.scene.c.b(com.transsion.ad.scene.c.f42257a, "TrendingFloatIrregularAd", false, 2, null);
        this.hiPlacementNon = TextUtils.isEmpty(com.transsion.ad.scene.a.f42255a.h("TrendingFloatIrregularAd"));
        addView(nativeWrapperAdView, new FrameLayout.LayoutParams(-1, -1));
        d();
    }

    public /* synthetic */ BiddingFloatingIrregularView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final void d() {
        this.closeImg.setImageResource(R$mipmap.ad_irregular_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(16.0f), a0.a(16.0f));
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        this.closeImg.setVisibility(8);
        this.closeImg.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.wrapperad.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingFloatingIrregularView.e(BiddingFloatingIrregularView.this, view);
            }
        });
        q.f76390a.a(this.closeImg);
        addView(this.closeImg, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BiddingFloatingIrregularView biddingFloatingIrregularView, View view) {
        biddingFloatingIrregularView.destroy();
        biddingFloatingIrregularView.lastRefreshTime = 0L;
    }

    private final void f() {
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.adManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.mMaxEcpmObject = null;
        setVisibility(8);
        this.closeImg.setVisibility(8);
    }

    private final int getLoadInterval() {
        return ((Number) this.loadInterval.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(BiddingFloatingIrregularView biddingFloatingIrregularView) {
        return com.transsion.ad.scene.a.f42255a.n(biddingFloatingIrregularView.sceneId) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BiddingFloatingIrregularView biddingFloatingIrregularView) {
        biddingFloatingIrregularView.closeImg.setVisibility(0);
    }

    public final void destroy() {
        f();
        g();
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
        f();
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
        kotlinx.coroutines.k.d(a11, null, null, new BiddingFloatingIrregularView$loadAd$1(this, null), 3, null);
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
            r8 = this;
            com.transsion.ad.bidding.nativead.BiddingNativeManager r0 = r8.adManager
            r1 = 0
            if (r0 == 0) goto La
            boolean r0 = r0.U0()
            goto Lb
        La:
            r0 = r1
        Lb:
            if (r0 == 0) goto L3a
            com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r2 = r8.mMaxEcpmObject
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
            com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r2 = r8.mMaxEcpmObject
            if (r2 == 0) goto L34
            com.hisavana.common.bean.TAdNativeInfo r2 = r2.getNativeInfo()
            if (r2 == 0) goto L34
            com.hisavana.common.bean.TAdNativeInfo$Image r2 = r2.getIcon()
            if (r2 == 0) goto L34
            java.lang.String r3 = r2.getUrl()
        L34:
            if (r3 != 0) goto L3a
        L36:
            r8.g()
            return
        L3a:
            com.transsion.ad.bidding.base.r r2 = r8.nativeViewBinder
            if (r2 != 0) goto L51
            cy.b r2 = cy.b.f61063a
            android.content.Context r3 = r8.getContext()
            java.lang.String r4 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            java.lang.String r4 = r8.sceneId
            com.transsion.ad.bidding.base.r r2 = r2.a(r3, r4)
            r8.nativeViewBinder = r2
        L51:
            com.transsion.ad.view.native_ad.NativeWrapperAdView r2 = r8.nativeWrapperAdView
            com.transsion.ad.bidding.nativead.BiddingNativeManager r3 = r8.adManager
            com.transsion.ad.bidding.base.r r4 = r8.nativeViewBinder
            com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r5 = r8.mMaxEcpmObject
            r2.bindNativeView(r3, r4, r5)
            if (r0 == 0) goto L6e
            com.transsion.ad.view.native_ad.NativeWrapperAdView r0 = r8.nativeWrapperAdView
            int r2 = com.transsion.wrapperad.R$id.ad_media
            android.view.View r0 = r0.findViewById(r2)
            com.hisavana.mediation.ad.TMediaView r0 = (com.hisavana.mediation.ad.TMediaView) r0
            if (r0 == 0) goto L7d
            jg.c.g(r0)
            goto L7d
        L6e:
            com.transsion.ad.view.native_ad.NativeWrapperAdView r0 = r8.nativeWrapperAdView
            int r2 = com.transsion.wrapperad.R$id.ad_icon
            android.view.View r0 = r0.findViewById(r2)
            com.hisavana.mediation.ad.TIconView r0 = (com.hisavana.mediation.ad.TIconView) r0
            if (r0 == 0) goto L7d
            jg.c.g(r0)
        L7d:
            com.transsion.ad.scene.a r0 = com.transsion.ad.scene.a.f42255a
            java.lang.String r2 = r8.sceneId
            int r0 = r0.e(r2)
            android.widget.ImageView r2 = r8.closeImg
            com.transsion.wrapperad.view.g r3 = new com.transsion.wrapperad.view.g
            r3.<init>()
            long r4 = (long) r0
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            r2.postDelayed(r3, r4)
            r8.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.wrapperad.view.BiddingFloatingIrregularView.showAd():void");
    }
}
