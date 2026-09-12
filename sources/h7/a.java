package h7;

import android.text.TextUtils;
import android.view.View;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.P;
import com.cloud.hisavana.sdk.Z;
import com.cloud.hisavana.sdk.api.listener.e;
import com.cloud.hisavana.sdk.c0;
import com.cloud.hisavana.sdk.c1;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.j3;
import com.cloud.hisavana.sdk.r2;
import com.cloud.hisavana.sdk.u0;
import com.cloud.hisavana.sdk.y;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: h7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0803a extends com.cloud.hisavana.sdk.common.tranmeasure.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f64504b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TaNativeInfo f64505c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AdsDTO f64506d;

        C0803a(e eVar, TaNativeInfo taNativeInfo, AdsDTO adsDTO) {
            this.f64504b = eVar;
            this.f64505c = taNativeInfo;
            this.f64506d = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            super.a(adsDTO);
            e eVar = this.f64504b;
            if (eVar != null) {
                eVar.a(this.f64505c);
            }
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null) {
                return;
            }
            P.g().k(adsDTO.getImpBeanRequest().pmid);
            if (adsDTO.getSource() == 4) {
                Z.f21623a.q(adsDTO.getAdCreativeId(), adsDTO.getCodeSeatId());
            } else if (!adsDTO.isOfflineAd()) {
                u0.f23073a.a(this.f64506d);
            } else {
                adsDTO.setShowNum(Integer.valueOf(adsDTO.getShowNum().intValue() + 1));
                c0.F().q(this.f64506d);
            }
        }
    }

    public static void a(TaNativeInfo taNativeInfo) {
        if (taNativeInfo != null && taNativeInfo.isRegister()) {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(taNativeInfo);
            taNativeInfo.setRegister(false);
        }
    }

    public static void b(TaNativeInfo taNativeInfo) {
        if (taNativeInfo == null) {
            return;
        }
        c(taNativeInfo.getAdItem());
    }

    public static void c(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        adsDTO.setClickid(j3.a());
        c1.h(new DownUpPointBean(0.0f, 0.0f, 0.0f, 0.0f, adsDTO.getImageWidth().intValue(), adsDTO.getImageHeight().intValue()), adsDTO, null);
        N0.U(adsDTO);
        AthenaTracker.W(adsDTO);
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c((AdsDTO) GsonUtil.a(str, AdsDTO.class));
        } catch (Throwable th2) {
            e4.b().w("LUtil", "handleClick error: " + th2.getMessage());
        }
    }

    public static void e(TaNativeInfo taNativeInfo) {
        AdsDTO adItem;
        if (taNativeInfo == null || (adItem = taNativeInfo.getAdItem()) == null) {
            return;
        }
        DownUpPointBean downUpPointBean = new DownUpPointBean(0.0f, 0.0f, 0.0f, 0.0f, adItem.getImageWidth().intValue(), adItem.getImageHeight().intValue());
        adItem.setClickid(j3.a());
        c1.o(adItem.getShowTrackingUrls(), adItem, downUpPointBean);
        y yVar = y.f23172a;
        yVar.C(adItem);
        yVar.Q();
        adItem.setShowReportTimeType(1);
        r2.a(adItem);
        try {
            AdsDTO m679clone = adItem.m679clone();
            m679clone.setShowReportTimeType(2);
            r2.b(m679clone);
        } catch (Throwable th2) {
            e4.b().w("LUtil", "handleShow error:" + th2.getMessage());
        }
        if (adItem.getImpBeanRequest() != null) {
            P.g().k(adItem.getImpBeanRequest().pmid);
            if (adItem.getSource() == 4) {
                Z.f21623a.q(adItem.getAdCreativeId(), adItem.getCodeSeatId());
            } else if (adItem.isOfflineAd()) {
                adItem.setShowNum(Integer.valueOf(adItem.getShowNum().intValue() + 1));
                c0.F().q(adItem);
            } else if (taNativeInfo.isAdShowed()) {
                return;
            } else {
                u0.f23073a.a(adItem);
            }
        }
        taNativeInfo.setAdShowed(true);
    }

    public static void f(TaNativeInfo taNativeInfo, View view, e eVar) {
        AdsDTO adItem;
        if (taNativeInfo == null || (adItem = taNativeInfo.getAdItem()) == null) {
            return;
        }
        C0803a c0803a = new C0803a(eVar, taNativeInfo, adItem);
        taNativeInfo.setRegister(true);
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(adItem, view, c0803a);
    }
}
