package com.cloud.hisavana.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class p2 extends l4 {

    /* renamed from: e, reason: collision with root package name */
    private q3 f22910e;

    /* renamed from: f, reason: collision with root package name */
    private AdxImpBean f22911f;

    private List g(List list) {
        ArrayList arrayList = new ArrayList();
        q3 q3Var = this.f22910e;
        int e11 = q3Var != null ? q3Var.e() : 0;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            if (v2.c(adsDTO, e11)) {
                e4.b().d("DefaultAdNode", "ExoPlayer unavailable, remove video ad: " + adsDTO.getAdCreativeId());
            } else {
                arrayList.add(adsDTO);
            }
        }
        return arrayList;
    }

    private void h(TaErrorCode taErrorCode) {
        try {
            q3 q3Var = this.f22910e;
            if (q3Var != null) {
                ConcurrentHashMap p11 = SSPTrackingHelper.f22035a.p(q3Var.n());
                com.cloud.hisavana.sdk.common.util.g0.e(p11, "s_default_status", 2);
                if (taErrorCode != null) {
                    com.cloud.hisavana.sdk.common.util.g0.e(p11, "s_default_failed_reason", taErrorCode.getErrorCode());
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void i(TaErrorCode taErrorCode, String str) {
        try {
            this.f22708b = 3;
            if (a7.c.p()) {
                j("offline ad fetch failed, error=" + taErrorCode);
            }
            h(taErrorCode);
            if (this.f22707a != null) {
                Bundle bundle = new Bundle();
                com.cloud.hisavana.sdk.common.util.g0.g(bundle, "default_ad_status", str);
                this.f22707a.a(taErrorCode, bundle);
            }
        } catch (Throwable unused) {
        }
    }

    private void j(String str) {
        if (a7.c.p() && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                if (this.f22910e != null) {
                    sb2.append(", codeSeatId=");
                    sb2.append(this.f22910e.i());
                }
                e4.b().d("DefaultAdNode", sb2.toString());
            } catch (Exception unused) {
            }
        }
    }

    private void k(List list, String str) {
        this.f22708b = 3;
        if (a7.c.p() && list != null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("default ad fetch succeed: ");
                sb2.append("\n");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    AdsDTO adsDTO = (AdsDTO) it.next();
                    if (adsDTO != null) {
                        sb2.append("adCreativeId: ");
                        sb2.append(adsDTO.getAdCreativeId());
                        sb2.append("，is_offline_ad: ");
                        sb2.append(adsDTO.isOfflineAd());
                        sb2.append(", source:");
                        sb2.append(adsDTO.getSource());
                        sb2.append("\n");
                    }
                }
                j(sb2.toString());
            } catch (Exception unused) {
            }
        }
        m();
        if (this.f22707a != null) {
            Bundle bundle = new Bundle();
            com.cloud.hisavana.sdk.common.util.g0.g(bundle, "default_ad_status", str);
            if (!d4.f22454a.b()) {
                list = g(list);
            }
            if (list == null || list.isEmpty()) {
                this.f22707a.a(TaErrorCode.ERROR_AD_DEFAULT_DATA_IS_NULL, bundle);
            } else {
                this.f22707a.b(list, bundle);
            }
        }
    }

    private AdxImpBean l(q3 q3Var) {
        AdxImpBean adxImpBean = new AdxImpBean();
        adxImpBean.adt = q3Var.e();
        adxImpBean.pmid = q3Var.i();
        adxImpBean.mAdCount = q3Var.a();
        adxImpBean.requestId = q3Var.j();
        adxImpBean.requestType = q3Var.k();
        adxImpBean.triggerId = q3Var.n();
        if (q3Var.l() != null) {
            adxImpBean.gameName = q3Var.l().b();
            adxImpBean.gameScene = q3Var.l().c();
            adxImpBean.extInfo = q3Var.l().a();
        }
        adxImpBean.supportEw = q3Var.y();
        adxImpBean.requestTs = Long.valueOf(System.currentTimeMillis());
        adxImpBean.isAutoPlayVideoAd = q3Var.q();
        adxImpBean.offlineAdEnable = q3Var.f().isOfflineAdEnable();
        adxImpBean.cacheAdCount = q3Var.a();
        adxImpBean.mTriggerNetState = q3Var.o();
        return adxImpBean;
    }

    private void m() {
        try {
            q3 q3Var = this.f22910e;
            if (q3Var != null) {
                com.cloud.hisavana.sdk.common.util.g0.e(SSPTrackingHelper.f22035a.p(q3Var.n()), "s_default_status", 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(List list, String str) {
        if (list == null || list.isEmpty()) {
            i(TaErrorCode.ERROR_AD_DEFAULT_DATA_IS_NULL, str);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            adsDTO.setFirstPrice(Double.valueOf(com.cloud.hisavana.sdk.common.util.o0.b(adsDTO.getFirstPrice())));
            adsDTO.setImpBeanRequest(this.f22911f);
        }
        k(list, str);
    }

    @Override // com.cloud.hisavana.sdk.c4
    public void a(q3 q3Var) {
        ConcurrentHashMap concurrentHashMap;
        if (a7.c.p()) {
            com.cloud.sdk.commonutil.util.q.b(com.cloud.sdk.commonutil.util.e.a().getString(com.cloud.sdk.commonutil.R$string.ssp_log_msg13), 2);
            j("start load default ad.");
        }
        this.f22708b = 2;
        this.f22910e = q3Var;
        this.f22911f = l(q3Var);
        q3 q3Var2 = this.f22910e;
        if (q3Var2 != null) {
            String n11 = q3Var2.n();
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            sSPTrackingHelper.z(n11, "1");
            concurrentHashMap = sSPTrackingHelper.p(n11);
        } else {
            concurrentHashMap = null;
        }
        ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
        String i11 = q3Var.i();
        int e11 = q3Var.e();
        boolean u11 = q3Var.u();
        q3 q3Var3 = this.f22910e;
        if (q3Var3 != null) {
            Z.f21623a.j(e11, i11, this.f22710d, u11, q3Var3.o(), concurrentHashMap2, new t0() { // from class: com.cloud.hisavana.sdk.o2
                @Override // com.cloud.hisavana.sdk.t0
                public final void a(List list, String str) {
                    p2.this.n(list, str);
                }
            });
        }
    }
}
