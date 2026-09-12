package com.transsion.ad.view.native_ad;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.TAdNativeView;
import com.hisavana.mediation.ad.TNativeAd;
import com.hisavana.mediation.ad.ViewBinder;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.base.u;
import com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider;
import com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import z6.d;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ-\u0010\u0016\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0018\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J-\u0010\u001c\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001e\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J-\u0010$\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b$\u0010\u0017J/\u0010&\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b&\u0010'J9\u0010(\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00101R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00103¨\u00064"}, d2 = {"Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getClassTag", "()Ljava/lang/String;", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "maxEcpmObject", "", "e", "(Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)Z", "f", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adManager", "Lcom/transsion/ad/bidding/base/r;", "adLayoutProvider", "", "a", "(Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;Lcom/transsion/ad/bidding/base/r;Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)V", "c", "Lcom/transsion/ad/bidding/nativead/BiddingSspNativeManager;", "Lcom/transsion/ad/bidding/base/u;", "layoutProvider", "d", "(Lcom/transsion/ad/bidding/nativead/BiddingSspNativeManager;Lcom/transsion/ad/bidding/base/u;Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/transsion/ad/bidding/nativead/BiddingSspNativeManager;Lcom/transsion/ad/bidding/base/r;Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)V", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "bindNativeView", "sspLayoutProvider", "simulatingClick", "(Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;Lcom/transsion/ad/bidding/base/r;Lcom/transsion/ad/bidding/base/u;)V", "bindSspNativeView", "(Lcom/transsion/ad/bidding/nativead/BiddingSspNativeManager;Lcom/transsion/ad/bidding/base/r;Lcom/transsion/ad/bidding/base/u;Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)V", "Lcom/transsion/ad/view/native_ad/BiddingBuyOutNativeView;", "Lcom/transsion/ad/view/native_ad/BiddingBuyOutNativeView;", "buyoutNativeView", "Lcom/hisavana/mediation/ad/TAdNativeView;", "Lcom/hisavana/mediation/ad/TAdNativeView;", "hiNativeView", "Lcom/cloud/hisavana/sdk/api/view/TNativeView;", "Lcom/cloud/hisavana/sdk/api/view/TNativeView;", "hiSspNativeView", "Landroid/widget/ImageView$ScaleType;", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class NativeWrapperAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private BiddingBuyOutNativeView buyoutNativeView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TAdNativeView hiNativeView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private TNativeView hiSspNativeView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView.ScaleType scaleType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public NativeWrapperAdView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeWrapperAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.scaleType = ImageView.ScaleType.FIT_CENTER;
    }

    public /* synthetic */ NativeWrapperAdView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(BiddingNativeManager adManager, r adLayoutProvider, BiddingIntermediateMaterialBean maxEcpmObject) {
        Boolean isExpend;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (this.buyoutNativeView == null) {
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            BiddingBuyOutNativeView biddingBuyOutNativeView = new BiddingBuyOutNativeView(context, objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0);
            this.buyoutNativeView = biddingBuyOutNativeView;
            addView(biddingBuyOutNativeView);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView2 = this.buyoutNativeView;
        if (biddingBuyOutNativeView2 != null) {
            biddingBuyOutNativeView2.isReportAdDisplay((maxEcpmObject == null || (isExpend = maxEcpmObject.isExpend()) == null) ? false : isExpend.booleanValue());
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView3 = this.buyoutNativeView;
        if (biddingBuyOutNativeView3 != null) {
            biddingBuyOutNativeView3.setEcpmObject(maxEcpmObject);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView4 = this.buyoutNativeView;
        if (biddingBuyOutNativeView4 != null) {
            biddingBuyOutNativeView4.setSceneId(adManager != null ? adManager.getMSceneId() : null);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView5 = this.buyoutNativeView;
        if (biddingBuyOutNativeView5 != null) {
            biddingBuyOutNativeView5.setScaleType(this.scaleType);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView6 = this.buyoutNativeView;
        if (biddingBuyOutNativeView6 != null) {
            biddingBuyOutNativeView6.bindNativeView(adLayoutProvider);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView7 = this.buyoutNativeView;
        if (biddingBuyOutNativeView7 != null) {
            biddingBuyOutNativeView7.setListener(adManager);
        }
        if (adManager != null) {
            adManager.S0(this.buyoutNativeView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b(BiddingSspNativeManager adManager, r adLayoutProvider, BiddingIntermediateMaterialBean maxEcpmObject) {
        Boolean isExpend;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (this.buyoutNativeView == null) {
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            BiddingBuyOutNativeView biddingBuyOutNativeView = new BiddingBuyOutNativeView(context, objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0);
            this.buyoutNativeView = biddingBuyOutNativeView;
            addView(biddingBuyOutNativeView);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView2 = this.buyoutNativeView;
        if (biddingBuyOutNativeView2 != null) {
            biddingBuyOutNativeView2.isReportAdDisplay((maxEcpmObject == null || (isExpend = maxEcpmObject.isExpend()) == null) ? false : isExpend.booleanValue());
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView3 = this.buyoutNativeView;
        if (biddingBuyOutNativeView3 != null) {
            biddingBuyOutNativeView3.setEcpmObject(maxEcpmObject);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView4 = this.buyoutNativeView;
        if (biddingBuyOutNativeView4 != null) {
            biddingBuyOutNativeView4.setSceneId(adManager != null ? adManager.getMSceneId() : null);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView5 = this.buyoutNativeView;
        if (biddingBuyOutNativeView5 != null) {
            biddingBuyOutNativeView5.setScaleType(this.scaleType);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView6 = this.buyoutNativeView;
        if (biddingBuyOutNativeView6 != null) {
            biddingBuyOutNativeView6.bindNativeView(adLayoutProvider);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView7 = this.buyoutNativeView;
        if (biddingBuyOutNativeView7 != null) {
            biddingBuyOutNativeView7.setListener(adManager);
        }
        if (adManager != null) {
            adManager.V0(this.buyoutNativeView);
        }
    }

    public static /* synthetic */ void bindNativeView$default(NativeWrapperAdView nativeWrapperAdView, BiddingNativeManager biddingNativeManager, r rVar, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            rVar = null;
        }
        nativeWrapperAdView.bindNativeView(biddingNativeManager, rVar, biddingIntermediateMaterialBean);
    }

    public static /* synthetic */ void bindSspNativeView$default(NativeWrapperAdView nativeWrapperAdView, BiddingSspNativeManager biddingSspNativeManager, r rVar, u uVar, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            rVar = null;
        }
        if ((i11 & 4) != 0) {
            uVar = null;
        }
        nativeWrapperAdView.bindSspNativeView(biddingSspNativeManager, rVar, uVar, biddingIntermediateMaterialBean);
    }

    private final void c(BiddingNativeManager adManager, r adLayoutProvider, BiddingIntermediateMaterialBean maxEcpmObject) {
        if (this.hiNativeView == null) {
            TAdNativeView tAdNativeView = new TAdNativeView(getContext());
            this.hiNativeView = tAdNativeView;
            addView(tAdNativeView);
        }
        if (adManager != null) {
            adManager.T0(this.hiNativeView);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TAdNativeInfo nativeInfo = maxEcpmObject != null ? maxEcpmObject.getNativeInfo() : null;
            if (this.hiNativeView != null && adLayoutProvider != null && nativeInfo != null) {
                ViewBinder q11 = adLayoutProvider.q(adLayoutProvider.g(), maxEcpmObject.getNativeInfo());
                BiddingHiSavanaNativeProvider b11 = BiddingHiSavanaNativeProvider.f42037j.b(adManager != null ? adManager.getMSceneId() : null);
                TNativeAd l11 = b11 != null ? b11.l() : null;
                if (l11 != null) {
                    TAdNativeView tAdNativeView2 = this.hiNativeView;
                    Intrinsics.e(tAdNativeView2);
                    l11.bindNativeView(tAdNativeView2, nativeInfo, q11);
                }
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final void d(BiddingSspNativeManager adManager, u layoutProvider, BiddingIntermediateMaterialBean maxEcpmObject) {
        Object m1185constructorimpl;
        Unit unit = null;
        TaNativeInfo sspNativeInfo = maxEcpmObject != null ? maxEcpmObject.getSspNativeInfo() : null;
        if (this.hiSspNativeView == null) {
            TNativeView tNativeView = new TNativeView(getContext());
            this.hiSspNativeView = tNativeView;
            addView(tNativeView);
        }
        if (adManager != null) {
            adManager.W0(this.hiSspNativeView);
        }
        TNativeView tNativeView2 = this.hiSspNativeView;
        if (tNativeView2 == null || layoutProvider == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BiddingHiSspNativeProvider b11 = BiddingHiSspNativeProvider.f42045h.b(adManager != null ? adManager.getMSceneId() : null);
            d k11 = b11 != null ? b11.k() : null;
            Intrinsics.e(sspNativeInfo);
            List d11 = layoutProvider.d(tNativeView2, sspNativeInfo);
            if (k11 != null) {
                k11.y(tNativeView2, d11, sspNativeInfo);
                unit = Unit.f67184a;
            }
            m1185constructorimpl = Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            oi.a.o(oi.a.f71145a, getClassTag(), "-----> bindNativeView --> error: " + m1188exceptionOrNullimpl.getMessage(), 0, false, 12, null);
        }
        Result.m1184boximpl(m1185constructorimpl);
    }

    private final boolean e(BiddingIntermediateMaterialBean maxEcpmObject) {
        return (maxEcpmObject != null ? maxEcpmObject.getNativeInfo() : null) != null;
    }

    private final boolean f(BiddingIntermediateMaterialBean maxEcpmObject) {
        return (maxEcpmObject != null ? maxEcpmObject.getSspNativeInfo() : null) != null;
    }

    private final String getClassTag() {
        String simpleName = NativeWrapperAdView.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public static /* synthetic */ void simulatingClick$default(NativeWrapperAdView nativeWrapperAdView, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, r rVar, u uVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            rVar = null;
        }
        if ((i11 & 4) != 0) {
            uVar = null;
        }
        nativeWrapperAdView.simulatingClick(biddingIntermediateMaterialBean, rVar, uVar);
    }

    public final void bindNativeView(BiddingNativeManager adManager, r adLayoutProvider, BiddingIntermediateMaterialBean maxEcpmObject) {
        if (adManager == null || maxEcpmObject == null || adLayoutProvider == null) {
            oi.a.o(oi.a.f71145a, "ad_n", getClassTag() + " --> bindNativeView() --> 参数为空 --> maxEcpmObject = " + maxEcpmObject + " --> adLayoutProvider = " + adLayoutProvider, 6, false, 8, null);
            return;
        }
        if (e(maxEcpmObject)) {
            c(adManager, adLayoutProvider, maxEcpmObject);
            BiddingBuyOutNativeView biddingBuyOutNativeView = this.buyoutNativeView;
            if (biddingBuyOutNativeView != null) {
                biddingBuyOutNativeView.setVisibility(8);
            }
            TNativeView tNativeView = this.hiSspNativeView;
            if (tNativeView != null) {
                tNativeView.setVisibility(8);
            }
            TAdNativeView tAdNativeView = this.hiNativeView;
            if (tAdNativeView != null) {
                tAdNativeView.setVisibility(0);
                return;
            }
            return;
        }
        a(adManager, adLayoutProvider, maxEcpmObject);
        BiddingBuyOutNativeView biddingBuyOutNativeView2 = this.buyoutNativeView;
        if (biddingBuyOutNativeView2 != null) {
            biddingBuyOutNativeView2.setVisibility(0);
        }
        TAdNativeView tAdNativeView2 = this.hiNativeView;
        if (tAdNativeView2 != null) {
            tAdNativeView2.setVisibility(8);
        }
        TNativeView tNativeView2 = this.hiSspNativeView;
        if (tNativeView2 != null) {
            tNativeView2.setVisibility(8);
        }
    }

    public final void bindSspNativeView(BiddingSspNativeManager adManager, r adLayoutProvider, u sspLayoutProvider, BiddingIntermediateMaterialBean maxEcpmObject) {
        if (adManager == null || maxEcpmObject == null) {
            oi.a.o(oi.a.f71145a, "ad_n", getClassTag() + " --> bindSspNativeView() --> 参数为空 --> maxEcpmObject = " + maxEcpmObject, 6, false, 8, null);
            return;
        }
        if (f(maxEcpmObject)) {
            d(adManager, sspLayoutProvider, maxEcpmObject);
            BiddingBuyOutNativeView biddingBuyOutNativeView = this.buyoutNativeView;
            if (biddingBuyOutNativeView != null) {
                biddingBuyOutNativeView.setVisibility(8);
            }
            TAdNativeView tAdNativeView = this.hiNativeView;
            if (tAdNativeView != null) {
                tAdNativeView.setVisibility(8);
            }
            TNativeView tNativeView = this.hiSspNativeView;
            if (tNativeView != null) {
                tNativeView.setVisibility(0);
                return;
            }
            return;
        }
        b(adManager, adLayoutProvider, maxEcpmObject);
        BiddingBuyOutNativeView biddingBuyOutNativeView2 = this.buyoutNativeView;
        if (biddingBuyOutNativeView2 != null) {
            biddingBuyOutNativeView2.setVisibility(0);
        }
        TAdNativeView tAdNativeView2 = this.hiNativeView;
        if (tAdNativeView2 != null) {
            tAdNativeView2.setVisibility(8);
        }
        TNativeView tNativeView2 = this.hiSspNativeView;
        if (tNativeView2 != null) {
            tNativeView2.setVisibility(8);
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        Intrinsics.h(scaleType, "scaleType");
        this.scaleType = scaleType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r3 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void simulatingClick(com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r3, com.transsion.ad.bidding.base.r r4, com.transsion.ad.bidding.base.u r5) {
        /*
            r2 = this;
            boolean r0 = r2.e(r3)
            r1 = 0
            if (r0 == 0) goto L41
            com.hisavana.mediation.ad.TAdNativeView r3 = r2.hiNativeView
            r5 = 0
            if (r3 == 0) goto L23
            if (r4 == 0) goto L19
            java.lang.Integer r0 = r4.v()
            if (r0 == 0) goto L19
            int r0 = r0.intValue()
            goto L1a
        L19:
            r0 = r5
        L1a:
            android.view.View r3 = r3.findViewById(r0)
            com.hisavana.mediation.ad.TMediaView r3 = (com.hisavana.mediation.ad.TMediaView) r3
            if (r3 == 0) goto L23
            goto L3b
        L23:
            com.hisavana.mediation.ad.TAdNativeView r3 = r2.hiNativeView
            if (r3 == 0) goto L3a
            if (r4 == 0) goto L33
            java.lang.Integer r4 = r4.s()
            if (r4 == 0) goto L33
            int r5 = r4.intValue()
        L33:
            android.view.View r3 = r3.findViewById(r5)
            r1 = r3
            com.hisavana.mediation.ad.TIconView r1 = (com.hisavana.mediation.ad.TIconView) r1
        L3a:
            r3 = r1
        L3b:
            if (r3 == 0) goto L64
            r3.performClick()
            goto L64
        L41:
            boolean r3 = r2.f(r3)
            if (r3 == 0) goto L5d
            if (r5 == 0) goto L50
            com.cloud.hisavana.sdk.api.view.MediaView r3 = r5.g()
            if (r3 == 0) goto L50
            goto L57
        L50:
            if (r5 == 0) goto L56
            android.widget.ImageView r1 = r5.f()
        L56:
            r3 = r1
        L57:
            if (r3 == 0) goto L64
            r3.performClick()
            goto L64
        L5d:
            com.transsion.ad.view.native_ad.BiddingBuyOutNativeView r3 = r2.buyoutNativeView
            if (r3 == 0) goto L64
            r3.onAdClick()
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.view.native_ad.NativeWrapperAdView.simulatingClick(com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean, com.transsion.ad.bidding.base.r, com.transsion.ad.bidding.base.u):void");
    }
}
