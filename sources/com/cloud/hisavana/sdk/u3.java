package com.cloud.hisavana.sdk;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.hisavana.sdk.manager.VideoMeasureManager;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class u3 extends G implements z3 {

    /* renamed from: i, reason: collision with root package name */
    private f f23096i;

    /* renamed from: j, reason: collision with root package name */
    private b f23097j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicInteger f23098k;

    /* loaded from: classes3.dex */
    class a implements Preconditions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaNativeInfo f23099a;

        a(TaNativeInfo taNativeInfo) {
            this.f23099a = taNativeInfo;
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            u3.this.U(this.f23099a);
            VideoMeasureManager.INSTANCE.f(this.f23099a.getAdItem());
            u3.this.X(this.f23099a);
            k4.f22682a.j(this.f23099a.getUuid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends com.cloud.hisavana.sdk.common.tranmeasure.a {

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference f23101b;

        public b(u3 u3Var) {
            this.f23101b = new WeakReference(u3Var);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(TaNativeInfo taNativeInfo) {
            super.a(taNativeInfo);
            e4.b().d("TranNative", "onViewImpressed: start impression report");
            u3 u3Var = (u3) this.f23101b.get();
            if (u3Var == null || u3Var.f23096i == null || taNativeInfo == null) {
                return;
            }
            u3Var.f23096i.f(taNativeInfo);
        }
    }

    public u3(q3 q3Var) {
        super(q3Var);
        this.f23098k = new AtomicInteger(1);
    }

    private void I(int i11) {
        if (i11 == 0) {
            i11 = 1;
        }
        this.f23098k.set(i11);
    }

    private void J(Bundle bundle) {
        try {
            AdCallback adCallback = this.f21586e;
            if (adCallback != null) {
                adCallback.v(TaErrorCode.ERROR_AD_BIDDING_AD_IS_NULL, this, bundle);
            }
        } catch (Throwable unused) {
        }
    }

    private void K(View view, TaNativeInfo taNativeInfo) {
        e4.b().d("ssp", "current native did not showed...");
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(taNativeInfo, view, this.f23097j);
    }

    private void L(ViewGroup viewGroup, List list, TaNativeInfo taNativeInfo) {
        e4.b().d("ssp", "registerClickAndImpression");
        Preconditions.a();
        if (this.f23096i == null || taNativeInfo == null) {
            return;
        }
        AdsDTO f11 = N0.f(taNativeInfo);
        if (f11 == null) {
            e4.b().d("ssp", "adItem is null");
            return;
        }
        f11.setSecondPrice(taNativeInfo.getSecondPrice());
        K(viewGroup, taNativeInfo);
        AthenaTracker.A(f11);
        this.f23096i.e(viewGroup, list, taNativeInfo, f11);
        e4.b().d("ssp", "Native Ad start registered");
        if (viewGroup == null || 8 != viewGroup.getVisibility()) {
            return;
        }
        viewGroup.setVisibility(0);
    }

    private void N(List list, Bundle bundle) {
        AdsDTO adsDTO = (AdsDTO) list.get(0);
        BidInfo bidInfo = new BidInfo();
        bidInfo.setPrice(adsDTO.getFirstPrice());
        bidInfo.setCodeSeatId(this.f21583b.i());
        bidInfo.setAdCreativeId(adsDTO.getAdCreativeId());
        bidInfo.setBiddingToken(this.f21583b.n());
        bidInfo.setCurrency(Constants.CURRENCY.USD);
        this.f21585d = bidInfo;
        this.f21586e.w(bidInfo, this, bundle);
    }

    private void O(List list, Bundle bundle, List list2) {
        if (this.f21584c) {
            this.f21587f = list;
            if (bundle.getBoolean("s_rec_temp_data", false)) {
                J(bundle);
                return;
            } else {
                N(list, bundle);
                return;
            }
        }
        this.f21587f = list;
        List<TaNativeInfo> G = N0.G(list);
        if (G == null) {
            G = new ArrayList();
        }
        if (G.isEmpty()) {
            G.add(new TaNativeInfo());
        }
        for (TaNativeInfo taNativeInfo : G) {
            if (taNativeInfo != null) {
                taNativeInfo.setNativeBridge(this);
            }
        }
        I(G.size());
        try {
            if (!G.isEmpty()) {
                TaNativeInfo taNativeInfo2 = (TaNativeInfo) G.get(0);
                taNativeInfo2.setUseRecommend(true);
                taNativeInfo2.setRecommendInfos(list2);
            }
            e4.b().d("TranNative", "use recommendInfo");
            bundle.putInt("s_recommend_req", 1);
        } catch (Throwable unused) {
        }
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.r(this, G, bundle);
        }
        k1.o().n(3);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void P(java.util.List r7, android.os.Bundle r8, java.util.List r9, com.cloud.hisavana.sdk.data.bean.request.AdxImpBean r10) {
        /*
            r6 = this;
            if (r9 == 0) goto L99
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto La
            goto L99
        La:
            java.lang.String r0 = "TranNative"
            if (r7 == 0) goto L76
            boolean r1 = r7.isEmpty()
            if (r1 != 0) goto L76
            r10 = 0
            java.lang.Object r10 = r7.get(r10)
            com.cloud.hisavana.sdk.data.bean.response.AdsDTO r10 = (com.cloud.hisavana.sdk.data.bean.response.AdsDTO) r10
            java.lang.String r1 = r10.getMaterialStyle()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L32
            com.cloud.hisavana.sdk.e4 r9 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r10 = "materialStyle is not empty not use recommend"
            r9.d(r0, r10)
            r6.T(r7, r8)
            return
        L32:
            java.lang.Double r10 = r10.getFirstPrice()
            com.cloud.hisavana.sdk.data.bean.response.ccofig.CommonConfigDTO r1 = com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigManager.getCommonConfigData()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L47
            java.lang.Integer r1 = r1.getShowWebLetterAdPrice()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L47
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L47
            goto L49
        L47:
            r1 = 10
        L49:
            double r2 = r10.doubleValue()
            double r4 = (double) r1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L95
            com.cloud.hisavana.sdk.e4 r9 = com.cloud.hisavana.sdk.e4.b()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "high price ,not use recommend -> firstPrice:"
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = ",showWebLetterAdPrice -> "
            r2.append(r10)
            r2.append(r1)
            java.lang.String r10 = r2.toString()
            r9.d(r0, r10)
            r6.T(r7, r8)
            return
        L76:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.cloud.hisavana.sdk.data.bean.response.AdsDTO r1 = new com.cloud.hisavana.sdk.data.bean.response.AdsDTO
            r1.<init>()
            r1.setImpBeanRequest(r10)     // Catch: java.lang.Throwable -> L92
            com.cloud.hisavana.sdk.e4 r10 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = "adsdto is empty,creat a new adsdto data"
            r10.d(r0, r2)     // Catch: java.lang.Throwable -> L92
            java.lang.String r10 = "s_rec_temp_data"
            r0 = 1
            r8.putBoolean(r10, r0)     // Catch: java.lang.Throwable -> L92
        L92:
            r7.add(r1)
        L95:
            r6.O(r7, r8, r9)
            goto L9c
        L99:
            r6.T(r7, r8)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.u3.P(java.util.List, android.os.Bundle, java.util.List, com.cloud.hisavana.sdk.data.bean.request.AdxImpBean):void");
    }

    private void T(List list, Bundle bundle) {
        if (this.f21584c) {
            this.f21587f = list;
            N(list, bundle);
            return;
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f21587f = list;
        List<TaNativeInfo> G = N0.G(list);
        for (TaNativeInfo taNativeInfo : G) {
            if (taNativeInfo != null) {
                taNativeInfo.setNativeBridge(this);
            }
        }
        I(G.size());
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.r(this, G, bundle);
        }
        k1.o().n(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(TaNativeInfo taNativeInfo) {
        if (taNativeInfo != null) {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(taNativeInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(TaNativeInfo taNativeInfo) {
        f fVar = this.f23096i;
        if (fVar != null) {
            fVar.k(taNativeInfo);
        }
    }

    private void Y() {
        f fVar = this.f23096i;
        if (fVar == null || fVar.j() == null) {
            return;
        }
        Iterator it = this.f23096i.j().iterator();
        while (it.hasNext()) {
            U((TaNativeInfo) it.next());
        }
    }

    private void a0() {
        this.f23096i = new f(this);
        this.f23097j = new b(this);
    }

    public AdChoicesView G(Context context, TaNativeInfo taNativeInfo) {
        return N0.e(context, N0.f(taNativeInfo), null);
    }

    public AdCloseView H(Context context) {
        AdCloseView adCloseView = new AdCloseView(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R$dimen.ad_badge_height);
        adCloseView.setLayoutParams(new RelativeLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset));
        return adCloseView;
    }

    public void Q(ViewGroup viewGroup, List list, TaNativeInfo taNativeInfo) {
        Preconditions.a();
        a0();
        if (viewGroup != null && (viewGroup instanceof TNativeView)) {
            ((TNativeView) viewGroup).setupViews(taNativeInfo);
        }
        L(viewGroup, list, taNativeInfo);
    }

    public void R(TaNativeInfo taNativeInfo) {
        e4.b().d("ssp", "native close ad ----》");
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.o(taNativeInfo, SSPTrackingHelper.f22035a.m(this));
        }
    }

    public int V(TaNativeInfo taNativeInfo) {
        AdsDTO f11 = N0.f(taNativeInfo);
        int l11 = l(f11);
        if (a7.c.p()) {
            e4.b().i("TranNative", "isReady(), adId=" + v2.d(f11) + ", isReady=" + l11);
        }
        return l11;
    }

    public void W(TaNativeInfo taNativeInfo) {
        if (taNativeInfo != null) {
            try {
                if (taNativeInfo.isAdShowed()) {
                    e4.b().d("TranNative", "ad has been showed");
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (taNativeInfo != null) {
            h(taNativeInfo.getAdItem());
            taNativeInfo.setAdShowed(true);
        }
        Z().z(taNativeInfo);
    }

    public AdCallback Z() {
        return this.f21586e;
    }

    @Override // com.cloud.hisavana.sdk.z3
    public void a(TaNativeInfo taNativeInfo) {
        Preconditions.d(new a(taNativeInfo));
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void c(List list, List list2, Bundle bundle, AdxImpBean adxImpBean) {
        P(list, bundle, list2, adxImpBean);
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void d(List list, Bundle bundle) {
        P(list, bundle, null, null);
    }

    @Override // com.cloud.hisavana.sdk.G
    public void m() {
        super.m();
        Y();
        f fVar = this.f23096i;
        if (fVar != null) {
            fVar.d();
        }
    }
}
