package com.transsion.wrapperad.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u00012\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\nJ\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\nR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010-\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/transsion/wrapperad/view/BiddingRectangleIrregularView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "showAd", "()V", "Ldi/a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setIrregularAdListener", "(Ldi/a;)V", "", "sceneId", "setSceneId", "(Ljava/lang/String;)V", "onAdViewDestroy", "destroyAd", "loadAd", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "a", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "nativeWrapperAdView", "Lcom/transsion/ad/bidding/base/r;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/ad/bidding/base/r;", "nativeViewBinder", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "c", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "mMaxEcpmObject", "d", "Ljava/lang/String;", "mSceneId", "", "e", "Z", "hiSceneOff", "f", "hiPlacementNon", be.g.f16474b, "Ldi/a;", "mIrregularAdListener", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "h", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adNativeManager", "com/transsion/wrapperad/view/BiddingRectangleIrregularView$a", "i", "Lcom/transsion/wrapperad/view/BiddingRectangleIrregularView$a;", "adNativeListener", "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class BiddingRectangleIrregularView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final NativeWrapperAdView nativeWrapperAdView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private r nativeViewBinder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private BiddingIntermediateMaterialBean mMaxEcpmObject;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mSceneId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hiSceneOff;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hiPlacementNon;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private di.a mIrregularAdListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager adNativeManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final a adNativeListener;

    /* loaded from: classes7.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            BiddingRectangleIrregularView.this.mMaxEcpmObject = null;
            BiddingRectangleIrregularView.this.setVisibility(8);
            di.a aVar = BiddingRectangleIrregularView.this.mIrregularAdListener;
            if (aVar != null) {
                aVar.i(tAdErrorCode);
            }
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            BiddingRectangleIrregularView.this.mMaxEcpmObject = biddingIntermediateMaterialBean;
            BiddingRectangleIrregularView.this.showAd();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BiddingRectangleIrregularView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BiddingRectangleIrregularView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        NativeWrapperAdView nativeWrapperAdView = new NativeWrapperAdView(context, null, 2, null);
        this.nativeWrapperAdView = nativeWrapperAdView;
        this.hiSceneOff = true;
        this.hiPlacementNon = true;
        this.adNativeListener = new a();
        addView(nativeWrapperAdView);
    }

    public /* synthetic */ BiddingRectangleIrregularView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public final void destroyAd() {
        BiddingNativeManager biddingNativeManager = this.adNativeManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.adNativeManager = null;
    }

    public final void loadAd() {
        LifecycleCoroutineScope a11;
        if (((this.hiSceneOff || this.hiPlacementNon) && this.mMaxEcpmObject != null) || TextUtils.isEmpty(this.mSceneId)) {
            return;
        }
        destroyAd();
        BiddingNativeManager biddingNativeManager = new BiddingNativeManager();
        this.adNativeManager = biddingNativeManager;
        biddingNativeManager.O0(this.mSceneId);
        BiddingNativeManager biddingNativeManager2 = this.adNativeManager;
        if (biddingNativeManager2 != null) {
            biddingNativeManager2.N0(this.adNativeListener);
        }
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.k.d(a11, null, null, new BiddingRectangleIrregularView$loadAd$1(this, null), 3, null);
    }

    public final void onAdViewDestroy() {
        destroyAd();
        this.adNativeManager = null;
        this.mMaxEcpmObject = null;
        removeAllViews();
    }

    public final void setIrregularAdListener(di.a listener) {
        this.mIrregularAdListener = listener;
    }

    public final void setSceneId(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.mSceneId = sceneId;
        this.hiSceneOff = com.transsion.ad.scene.c.b(com.transsion.ad.scene.c.f42257a, sceneId, false, 2, null);
        this.hiPlacementNon = TextUtils.isEmpty(com.transsion.ad.scene.a.f42255a.h(sceneId));
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
            com.transsion.ad.bidding.nativead.BiddingNativeManager r0 = r6.adNativeManager
            r1 = 0
            if (r0 == 0) goto La
            boolean r0 = r0.U0()
            goto Lb
        La:
            r0 = r1
        Lb:
            if (r0 == 0) goto L4a
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
            if (r3 != 0) goto L4a
        L36:
            r0 = 8
            r6.setVisibility(r0)
            di.a r0 = r6.mIrregularAdListener
            if (r0 == 0) goto L49
            com.hisavana.common.bean.TAdErrorCode r2 = new com.hisavana.common.bean.TAdErrorCode
            java.lang.String r3 = "ignore hisavana adx"
            r2.<init>(r1, r3)
            r0.i(r2)
        L49:
            return
        L4a:
            com.transsion.ad.bidding.base.r r2 = r6.nativeViewBinder
            if (r2 != 0) goto L61
            cy.b r2 = cy.b.f61063a
            android.content.Context r3 = r6.getContext()
            java.lang.String r4 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            java.lang.String r4 = r6.mSceneId
            com.transsion.ad.bidding.base.r r2 = r2.a(r3, r4)
            r6.nativeViewBinder = r2
        L61:
            com.transsion.ad.view.native_ad.NativeWrapperAdView r2 = r6.nativeWrapperAdView
            com.transsion.ad.bidding.nativead.BiddingNativeManager r3 = r6.adNativeManager
            com.transsion.ad.bidding.base.r r4 = r6.nativeViewBinder
            com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r5 = r6.mMaxEcpmObject
            r2.bindNativeView(r3, r4, r5)
            if (r0 == 0) goto L7e
            com.transsion.ad.view.native_ad.NativeWrapperAdView r0 = r6.nativeWrapperAdView
            int r2 = com.transsion.wrapperad.R$id.ad_media
            android.view.View r0 = r0.findViewById(r2)
            com.hisavana.mediation.ad.TMediaView r0 = (com.hisavana.mediation.ad.TMediaView) r0
            if (r0 == 0) goto L8d
            jg.c.g(r0)
            goto L8d
        L7e:
            com.transsion.ad.view.native_ad.NativeWrapperAdView r0 = r6.nativeWrapperAdView
            int r2 = com.transsion.wrapperad.R$id.ad_icon
            android.view.View r0 = r0.findViewById(r2)
            com.hisavana.mediation.ad.TIconView r0 = (com.hisavana.mediation.ad.TIconView) r0
            if (r0 == 0) goto L8d
            jg.c.g(r0)
        L8d:
            r6.setVisibility(r1)
            di.a r0 = r6.mIrregularAdListener
            if (r0 == 0) goto L99
            com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r1 = r6.mMaxEcpmObject
            r0.j(r1)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.wrapperad.view.BiddingRectangleIrregularView.showAd():void");
    }
}
