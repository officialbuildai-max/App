package com.cloud.hisavana.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.c0;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class g0 extends l4 {

    /* renamed from: e, reason: collision with root package name */
    private q3 f22533e;

    /* renamed from: f, reason: collision with root package name */
    private AdxImpBean f22534f;

    /* loaded from: classes3.dex */
    class a implements c0.c {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.c0.c
        public void a(List list, String str) {
            if (list == null || list.isEmpty()) {
                g0.this.k(TaErrorCode.ERROR_AD_OFFLINE_DATA_IS_NULL, str);
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((AdsDTO) it.next()).setImpBeanRequest(g0.this.f22534f);
            }
            g0.this.m(list, str);
        }
    }

    private List g(List list) {
        ArrayList arrayList = new ArrayList();
        q3 q3Var = this.f22533e;
        int e11 = q3Var != null ? q3Var.e() : 0;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            if (v2.c(adsDTO, e11)) {
                e4.b().d("OfflineAdNode", "ExoPlayer unavailable, remove video ad: " + adsDTO.getAdCreativeId());
            } else {
                arrayList.add(adsDTO);
            }
        }
        return arrayList;
    }

    private void j(TaErrorCode taErrorCode) {
        try {
            q3 q3Var = this.f22533e;
            if (q3Var != null) {
                ConcurrentHashMap p11 = SSPTrackingHelper.f22035a.p(q3Var.n());
                com.cloud.hisavana.sdk.common.util.g0.e(p11, "s_offline_status", 2);
                if (taErrorCode != null) {
                    com.cloud.hisavana.sdk.common.util.g0.e(p11, "s_offline_failed_reason", taErrorCode.getErrorCode());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(TaErrorCode taErrorCode, String str) {
        l("offline ad fetch failed, error=" + taErrorCode);
        this.f22708b = 3;
        j(taErrorCode);
        if (this.f22707a != null) {
            Bundle bundle = new Bundle();
            com.cloud.hisavana.sdk.common.util.g0.g(bundle, "offline_ad_status", str);
            this.f22707a.a(taErrorCode, bundle);
        }
    }

    private void l(String str) {
        if (!a7.c.p() || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f22533e == null) {
            e4.b().d("OfflineAdNode", str);
            return;
        }
        e4.b().d("OfflineAdNode", str + ", codeSeatId=" + this.f22533e.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(List list, String str) {
        this.f22708b = 3;
        if (a7.c.p() && list != null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("offline ad fetch succeed: ");
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
                l(sb2.toString());
            } catch (Exception unused) {
            }
        }
        o();
        if (this.f22707a != null) {
            Bundle bundle = new Bundle();
            com.cloud.hisavana.sdk.common.util.g0.g(bundle, "offline_ad_status", str);
            if (!d4.f22454a.b()) {
                list = g(list);
            }
            if (list == null || list.isEmpty()) {
                this.f22707a.a(TaErrorCode.ERROR_AD_OFFLINE_DATA_IS_NULL, bundle);
            } else {
                this.f22707a.b(list, bundle);
            }
        }
    }

    private AdxImpBean n(q3 q3Var) {
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

    private void o() {
        try {
            q3 q3Var = this.f22533e;
            if (q3Var != null) {
                com.cloud.hisavana.sdk.common.util.g0.e(SSPTrackingHelper.f22035a.p(q3Var.n()), "s_offline_status", 1);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.hisavana.sdk.c4
    public void a(q3 q3Var) {
        ConcurrentHashMap concurrentHashMap;
        this.f22708b = 2;
        this.f22533e = q3Var;
        this.f22534f = n(q3Var);
        if (a7.c.p()) {
            com.cloud.sdk.commonutil.util.q.b(com.cloud.sdk.commonutil.util.e.a().getString(com.cloud.sdk.commonutil.R$string.ssp_log_msg10), 2);
            l("start load offline ad.");
        }
        q3 q3Var2 = this.f22533e;
        if (q3Var2 != null) {
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            sSPTrackingHelper.z(q3Var2.n(), "3");
            concurrentHashMap = sSPTrackingHelper.p(this.f22533e.n());
        } else {
            concurrentHashMap = null;
        }
        ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
        if (this.f22533e != null && a7.c.p()) {
            c0.F().y(this.f22533e.i(), this.f22533e.o() == 1);
        }
        c0.F().x(q3Var.i(), this.f22710d, q3Var.o() == 1, null, concurrentHashMap2, new a());
    }
}
