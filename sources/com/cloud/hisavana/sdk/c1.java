package com.cloud.hisavana.sdk;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.impl.StringCallback;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.manager.g;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.tmc.ad.Constants;
import com.cloud.tmc.ad.TrackingManager;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class c1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends g.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DiskTrackingBean f21801a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g.b f21802b;

        a(DiskTrackingBean diskTrackingBean, g.b bVar) {
            this.f21801a = diskTrackingBean;
            this.f21802b = bVar;
        }

        @Override // com.cloud.hisavana.sdk.manager.g.c
        public void a(String str) {
            g.f22800d.a().j(this.f21801a);
            g.b bVar = this.f21802b;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.cloud.hisavana.sdk.manager.g.c
        public void b(String str, int i11) {
            if (i11 < 480) {
                a(str);
                return;
            }
            g.f22800d.a().d(this.f21801a);
            g.b bVar = this.f21802b;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends StringCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g.c f21803c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21804d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdsDTO f21805e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DiskTrackingBean f21806f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z10, g.c cVar, String str, AdsDTO adsDTO, DiskTrackingBean diskTrackingBean) {
            super(z10);
            this.f21803c = cVar;
            this.f21804d = str;
            this.f21805e = adsDTO;
            this.f21806f = diskTrackingBean;
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void x(int i11, String str, Throwable th2) {
            g.c cVar = this.f21803c;
            if (cVar != null) {
                if (i11 != 200) {
                    cVar.b(this.f21804d, i11);
                } else {
                    cVar.a(this.f21804d);
                }
            }
            AthenaTracker.i0(this.f21805e, this.f21806f, this.f21804d, i11, str, th2);
            e4.b().d("ssp_track", "sendRequestToServer --> onFailure --> statusCode = " + i11 + ",url " + this.f21804d + ",throwable " + th2);
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void y(int i11, String str) {
            g.c cVar = this.f21803c;
            if (cVar != null) {
                cVar.a(this.f21804d);
            }
            AthenaTracker.i0(this.f21805e, this.f21806f, this.f21804d, i11, str, null);
            e4.b().d("ssp_track", "sendRequestToServer - onSuccess - statusCode = " + i11 + " url " + this.f21804d);
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21807a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f21808b;

        c(String str, AdsDTO adsDTO) {
            this.f21807a = str;
            this.f21808b = adsDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f21807a;
            AdsDTO adsDTO = this.f21808b;
            c1.m(str, adsDTO, null, new d(adsDTO));
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends g.c {

        /* renamed from: a, reason: collision with root package name */
        private AdsDTO f21809a;

        public d(AdsDTO adsDTO) {
            this.f21809a = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.manager.g.c
        public void a(String str) {
        }

        @Override // com.cloud.hisavana.sdk.manager.g.c
        public void b(String str, int i11) {
            AdsDTO adsDTO = this.f21809a;
            if (adsDTO == null) {
                return;
            }
            if (adsDTO.getDspType().intValue() != 2) {
                if (TextUtils.isEmpty(str) || i11 < 480) {
                    return;
                }
                DiskTrackingBean diskTrackingBean = new DiskTrackingBean(str);
                diskTrackingBean.setData(this.f21809a);
                g.f22800d.a().h(diskTrackingBean);
                return;
            }
            if (TextUtils.isEmpty(str) || !this.f21809a.isDownloadAd() || i11 < 480 || !this.f21809a.getAdxAscribeRetryEnable()) {
                return;
            }
            DiskTrackingBean diskTrackingBean2 = new DiskTrackingBean(str);
            diskTrackingBean2.setData(this.f21809a);
            g.f22800d.a().h(diskTrackingBean2);
        }
    }

    public static String d(DownUpPointBean downUpPointBean, AdsDTO adsDTO, boolean z10, Boolean bool) {
        e4 b11 = e4.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TrackingManager --> processUrl --> 处理前 url = ");
        sb2.append(adsDTO == null ? "" : adsDTO.getClickUrl());
        b11.d("ssp_track", sb2.toString());
        if (adsDTO == null) {
            return null;
        }
        String clickUrl = z10 ? adsDTO.getClickUrl() : adsDTO.getImpressionUrl();
        if (TextUtils.isEmpty(clickUrl) || !clickUrl.contains(UrlUtils.QUESTION_MARK)) {
            return clickUrl;
        }
        StringBuilder sb3 = new StringBuilder();
        if (z10 && downUpPointBean != null) {
            sb3.append("xd=" + downUpPointBean.getDownX());
            sb3.append("&yd=" + downUpPointBean.getDownY());
            sb3.append("&xu=" + downUpPointBean.getUpX());
            sb3.append("&yu=" + downUpPointBean.getUpY());
        }
        sb3.append("&ai=" + a7.c.f440b);
        sb3.append("&pn=" + com.cloud.sdk.commonutil.util.e.d());
        sb3.append("&ve=" + com.cloud.sdk.commonutil.util.e.f());
        sb3.append("&sv=3.6.0.2");
        sb3.append("&ot=1");
        sb3.append("&ov=" + DeviceUtil.m());
        sb3.append("&nc=" + MitNetUtil.a(com.cloud.sdk.commonutil.util.e.a()).ordinal());
        if (i7.c.d() != null && i7.c.e() != null) {
            sb3.append("&op=" + i7.c.d() + i7.c.e());
        }
        sb3.append("&ga=" + DeviceUtil.e());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("&dt=");
        boolean z11 = true;
        sb4.append(DeviceUtil.q() ? 2 : 1);
        sb3.append(sb4.toString());
        sb3.append("&br=" + Build.BRAND);
        sb3.append("&mo=" + Build.MODEL);
        sb3.append("&ma=" + Build.MANUFACTURER);
        sb3.append("&la=" + com.cloud.sdk.commonutil.util.d.d());
        sb3.append("&lo=" + com.cloud.sdk.commonutil.util.d.f());
        if (downUpPointBean != null) {
            sb3.append("&iw=" + downUpPointBean.getImageW());
            sb3.append("&ih=" + downUpPointBean.getImageH());
        }
        sb3.append("&ci=" + adsDTO.getClickid());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&tr=");
        if (!a7.c.q() && !adsDTO.getTestResponse().booleanValue()) {
            z11 = false;
        }
        sb5.append(z11);
        sb3.append(sb5.toString());
        sb3.append("&ia=" + Integer.valueOf(adsDTO.getInstallApk()));
        if (z10) {
            sb3.append("&pt=" + adsDTO.getAdPsType());
        }
        AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
        if (impBeanRequest != null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("&gan=");
            sb6.append(TextUtils.isEmpty(impBeanRequest.gameName) ? "" : impBeanRequest.gameName);
            sb3.append(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("&gas=");
            sb7.append(TextUtils.isEmpty(impBeanRequest.gameScene) ? "" : impBeanRequest.gameScene);
            sb3.append(sb7.toString());
        }
        if (!adsDTO.isOfflineAd()) {
            sb3.append("&ta=" + DeviceUtil.f());
            sb3.append("&oi=" + DeviceUtil.j());
        }
        if (bool != null) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("&ps=");
            sb8.append(bool.booleanValue() ? "1" : "0");
            sb3.append(sb8.toString());
        }
        e4.b().d("ssp_track", "athena --> sb=" + ((Object) sb3));
        String str = clickUrl + "&p1=" + com.cloud.sdk.commonutil.util.a.a(sb3.toString()) + "&r1=" + com.cloud.sdk.commonutil.util.a.a(adsDTO.getNewPrice_Click());
        if (i7.a.h0()) {
            String m11 = i7.a.m();
            if (!TextUtils.isEmpty(m11)) {
                str = str + "&a=" + m11;
            }
        }
        e4.b().d("ssp_track", "TrackingManager --> processUrl --> process after url = " + str);
        return str;
    }

    public static String e(AdsDTO adsDTO) {
        int i11;
        String str = "";
        if (adsDTO == null) {
            return "";
        }
        if (adsDTO.getImpBeanRequest() == null || adsDTO.getImpBeanRequest().triggerId == null) {
            i11 = 0;
        } else {
            str = adsDTO.getImpBeanRequest().triggerId;
            i11 = adsDTO.getImpBeanRequest().mTriggerNetState;
        }
        return "&isOfflineAd=" + (adsDTO.isOfflineAd() ? 1 : 0) + "&clickTs=" + System.currentTimeMillis() + "&triggerId=" + str + "&adTriggerStatus=" + i11;
    }

    private static String f(String str, AdsDTO adsDTO, boolean z10) {
        String h11;
        if (TextUtils.isEmpty(str) || adsDTO == null) {
            return null;
        }
        String clickid = adsDTO.getClickid();
        if (str.contains("__CLICK_ID__") && clickid != null) {
            str = str.replace("__CLICK_ID__", clickid);
        }
        String uuid = adsDTO.getUuid();
        if (str.contains("__SHOW_ID__") && uuid != null) {
            str = str.replace("__SHOW_ID__", uuid);
        }
        if (str.contains("__CLICK_TS__")) {
            str = str.replace("__CLICK_TS__", String.valueOf(System.currentTimeMillis() - j7.a.e().h(Constants.SERVICES_TIME_DIFFERENCE_VALUE)));
        }
        if (str.contains("__AD_TRIGGER_STATUS__")) {
            str = str.replace("__AD_TRIGGER_STATUS__", String.valueOf(adsDTO.getImpBeanRequest() == null ? 0 : adsDTO.getImpBeanRequest().mTriggerNetState));
        }
        int source = adsDTO.getSource();
        String e11 = DeviceUtil.e();
        if (source == 4 && str.contains("__GAID__") && !TextUtils.isEmpty(e11)) {
            str = str.replace("__GAID__", e11);
        }
        if (str.contains("__CLICK_IP__") && (h11 = DeviceUtil.h()) != null) {
            str = str.replace("__CLICK_IP__", h11);
        }
        double doubleValue = z10 ? adsDTO.getAuctionSecondPrice().doubleValue() : 0.0d;
        String settlementRatio = z10 ? adsDTO.getSettlementRatio() : null;
        if (str.contains(TrackingManager.AUCTION_PRICE)) {
            BigDecimal valueOf = BigDecimal.valueOf(doubleValue);
            if (settlementRatio != null) {
                try {
                    BigDecimal bigDecimal = new BigDecimal(settlementRatio);
                    if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                        valueOf = valueOf.divide(bigDecimal, 0, 2).add(new BigDecimal(1));
                    }
                } catch (Exception e12) {
                    e4.b().e("ssp", "settlement ratio parse error: " + Log.getStackTraceString(e12));
                }
            }
            str = str.replace(TrackingManager.AUCTION_PRICE, String.valueOf(valueOf.divide(BigDecimal.valueOf(100L), 2, 2)));
        }
        String codeSeatId = adsDTO.getCodeSeatId();
        if (str.contains("__CODE_SEAT_ID__") && !TextUtils.isEmpty(codeSeatId)) {
            str = str.replace("__CODE_SEAT_ID__", codeSeatId);
        }
        if (str.contains("__CLICK_HALF_SCREEN_TYPE__")) {
            return str.replace("__CLICK_HALF_SCREEN_TYPE__", adsDTO.isHalfScreenAd() ? "1" : "0");
        }
        return str;
    }

    public static void g(DiskTrackingBean diskTrackingBean, g.b bVar) {
        e4 b11 = e4.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("resendUrl: ");
        sb2.append(diskTrackingBean != null ? diskTrackingBean.getTrackingUrl() : "null");
        b11.d("TrackingManager", sb2.toString());
        if (diskTrackingBean != null && !TextUtils.isEmpty(diskTrackingBean.getTrackingUrl())) {
            m(diskTrackingBean.getTrackingUrl(), null, diskTrackingBean, new a(diskTrackingBean, bVar));
        } else if (bVar != null) {
            bVar.a();
        }
    }

    public static void h(final DownUpPointBean downUpPointBean, final AdsDTO adsDTO, final Boolean bool) {
        HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.a3
            @Override // java.lang.Runnable
            public final void run() {
                c1.j(AdsDTO.this, downUpPointBean, bool);
            }
        });
    }

    public static void i(AdsDTO adsDTO, DownUpPointBean downUpPointBean, g.c cVar) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getImpressionUrl()) || downUpPointBean == null) {
            e4.b().d("ssp_track", "reportServerShow --> null == url || null == pointBean");
            return;
        }
        e4.b().d("ssp_track", "TrackingManager --> processUrl --> pointBean = " + downUpPointBean);
        m(d(downUpPointBean, adsDTO, false, null), adsDTO, null, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(AdsDTO adsDTO, DownUpPointBean downUpPointBean, Boolean bool) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getClickUrl()) || downUpPointBean == null) {
            e4.b().d("ssp_track", "reportServerClick --> null == url || null == pointBean");
            return;
        }
        e4.b().d("ssp_track", "TrackingManager --> processUrl --> pointBean = " + downUpPointBean);
        String clickUrl = adsDTO.getClickUrl();
        if (adsDTO.getDspType().intValue() != 1) {
            m(clickUrl, adsDTO, null, new d(adsDTO));
            return;
        }
        if (adsDTO.getSource() == 4) {
            return;
        }
        String d11 = d(downUpPointBean, adsDTO, true, bool);
        if (!TextUtils.isEmpty(d11) && d11.contains(UrlUtils.QUESTION_MARK)) {
            d11 = d11 + e(adsDTO);
        }
        AthenaTracker.G(d11, adsDTO, bool);
        m(d11, adsDTO, null, new d(adsDTO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(AdsDTO adsDTO, List list, DownUpPointBean downUpPointBean) {
        if (adsDTO == null) {
            return;
        }
        d dVar = new d(adsDTO);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                if (p(str)) {
                    adsDTO.setImpressionUrl(str);
                    i(adsDTO, downUpPointBean, dVar);
                } else {
                    m(f(str, adsDTO, true), adsDTO, null, dVar);
                }
            }
        }
    }

    public static void l(String str, AdsDTO adsDTO) {
        HSScopeHelper.f23249a.i(new c(str, adsDTO));
    }

    public static void m(String str, AdsDTO adsDTO, DiskTrackingBean diskTrackingBean, g.c cVar) {
        e4.b().d("ssp_track", "sendRequestToServer - url = " + str);
        if (str == null) {
            return;
        }
        RequestParams requestParams = new RequestParams();
        requestParams.i("User-Agent", com.cloud.sdk.commonutil.util.r.c());
        requestParams.i("Accept-Timezone", "UTC");
        HttpRequest.f21410a.h(str, requestParams, new b(true, cVar, str, adsDTO, diskTrackingBean));
    }

    public static void n(final List list, final AdsDTO adsDTO) {
        HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.y2
            @Override // java.lang.Runnable
            public final void run() {
                c1.r(list, adsDTO);
            }
        });
    }

    public static void o(final List list, final AdsDTO adsDTO, final DownUpPointBean downUpPointBean) {
        if (list == null || list.isEmpty() || adsDTO == null) {
            e4.b().d("ssp_track", "clickTrackingUrls || showTrackingUrls --> urls==null || urls is empty --> return ");
        } else {
            HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.z2
                @Override // java.lang.Runnable
                public final void run() {
                    c1.k(AdsDTO.this, list, downUpPointBean);
                }
            });
        }
    }

    public static boolean p(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("api.test.eagllwin.com") || str.contains("api.eagllwin.com") || str.contains("api.pre.eagllwin.com") || str.contains("api.fat1.eagllwin.com"));
    }

    public static ArrayList q(List list, AdsDTO adsDTO) {
        if (list == null || list.isEmpty() || adsDTO == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String f11 = f((String) it.next(), adsDTO, true);
            if (!TextUtils.isEmpty(f11)) {
                arrayList.add(f11);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(List list, AdsDTO adsDTO) {
        if (list == null || list.isEmpty() || adsDTO == null) {
            e4.b().d("ssp_track", "clickTrackingUrls || showTrackingUrls --> urls==null || urls is empty --> return ");
            return;
        }
        d dVar = new d(adsDTO);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                m(f(str, adsDTO, false), adsDTO, null, dVar);
            }
        }
    }
}
