package com.cloud.hisavana.sdk.common.tranmeasure;

import com.cloud.hisavana.sdk.c1;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.tranmeasure.d;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.j3;
import com.cloud.hisavana.sdk.k4;
import com.cloud.hisavana.sdk.y;

/* loaded from: classes3.dex */
public class a implements d.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f22174a = "AdImpressionListenerImpl";

    private void b(AdsDTO adsDTO) {
        if (!com.cloud.hisavana.sdk.common.util.b.f22230a.g(adsDTO)) {
            adsDTO.setPreloadStatus(1);
            return;
        }
        com.cloud.hisavana.sdk.manager.a aVar = com.cloud.hisavana.sdk.manager.a.f22735a;
        int b02 = aVar.b0();
        e4.b().w("AdImpressionListenerImpl", "preloadLandingPage: ccTabTestCode is " + b02);
        if (b02 != 7018 && b02 != 7019) {
            k4.f22682a.l(com.cloud.sdk.commonutil.util.e.a(), adsDTO);
        } else if (aVar.c(adsDTO) == 7016) {
            adsDTO.setPreloadStatus(4);
        } else {
            aVar.s(com.cloud.sdk.commonutil.util.e.a(), adsDTO, true);
        }
    }

    @Override // com.cloud.hisavana.sdk.common.tranmeasure.d.b
    public void a(Object obj) {
        e4.b().d("ssp", "-------------------------> onViewImpressed");
        AdsDTO adItem = obj instanceof AdsDTO ? (AdsDTO) obj : obj instanceof TaNativeInfo ? ((TaNativeInfo) obj).getAdItem() : null;
        if (adItem != null) {
            DownUpPointBean downUpPointBean = new DownUpPointBean(0.0f, 0.0f, 0.0f, 0.0f, adItem.getImageWidth().intValue(), adItem.getImageHeight().intValue());
            adItem.setClickid(j3.a());
            c1.o(adItem.getShowTrackingUrls(), adItem, downUpPointBean);
            y.f23172a.C(adItem);
            b(adItem);
        }
        y.f23172a.Q();
    }
}
