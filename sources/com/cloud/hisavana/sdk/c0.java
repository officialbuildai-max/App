package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.c0;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.a;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.hisavana.sdk.common.util.g;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AbTestDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdResponseBody;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.k0;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f21790a;

    /* renamed from: b, reason: collision with root package name */
    private List f21791b;

    /* renamed from: c, reason: collision with root package name */
    private ConfigCodeSeatDTO f21792c;

    /* renamed from: d, reason: collision with root package name */
    private int f21793d;

    /* renamed from: e, reason: collision with root package name */
    androidx.collection.b f21794e;

    /* renamed from: f, reason: collision with root package name */
    private final k0.c f21795f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements k0.c {
        a() {
        }

        private void c() {
            HSScopeHelper.f23249a.g(new Runnable() { // from class: com.cloud.hisavana.sdk.a0
                @Override // java.lang.Runnable
                public final void run() {
                    c0.a.this.d();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            String[] list;
            String str = com.cloud.hisavana.sdk.common.util.m.b(com.cloud.sdk.commonutil.util.e.a()) + File.separator + "offline_zip";
            File file = new File(str);
            try {
                if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
                    for (String str2 : list) {
                        boolean B = com.cloud.hisavana.sdk.d.f22404a.B(str2);
                        File file2 = new File(str + File.separator + str2);
                        if (!B && file2.exists()) {
                            if (file2.isDirectory()) {
                                com.cloud.hisavana.sdk.common.util.m.a(file2);
                            } else {
                                file2.delete();
                            }
                            if (a7.c.p()) {
                                e4.b().d("OfflineAdManager", "clearZipFile，delete file:" + str2);
                            }
                        }
                    }
                }
            } catch (Exception e11) {
                e4.b().e("OfflineAdManager", "clear zip file error: " + e11.getMessage());
            }
            e4.b().d("OfflineAdManager", "clearZipFile，ad download logic is done.");
            c0.this.f21790a.set(false);
        }

        @Override // com.cloud.hisavana.sdk.k0.c
        public void a(AdxImpBean adxImpBean, List list, TaErrorCode taErrorCode) {
            if (list == null || list.isEmpty()) {
                AthenaTracker.h0(null, taErrorCode, adxImpBean, 0, c0.this.f21794e);
            } else {
                AthenaTracker.h0(list, taErrorCode, adxImpBean, list.size(), c0.this.f21794e);
            }
            a(null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        
            com.cloud.hisavana.sdk.d.f22404a.z(r1);
         */
        @Override // com.cloud.hisavana.sdk.k0.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(java.util.List r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L4a
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r4)
                boolean r4 = r0.isEmpty()
                if (r4 != 0) goto L4a
                r4 = 0
            Le:
                int r1 = r0.size()     // Catch: java.lang.Exception -> L27
                if (r4 >= r1) goto L4a
                java.lang.Object r1 = r0.get(r4)     // Catch: java.lang.Exception -> L27
                com.cloud.hisavana.sdk.data.bean.response.AdsDTO r1 = (com.cloud.hisavana.sdk.data.bean.response.AdsDTO) r1     // Catch: java.lang.Exception -> L27
                r2 = 1
                boolean r2 = com.cloud.hisavana.sdk.common.util.g.e(r1, r2)     // Catch: java.lang.Exception -> L27
                if (r2 == 0) goto L29
                com.cloud.hisavana.sdk.d r4 = com.cloud.hisavana.sdk.d.f22404a     // Catch: java.lang.Exception -> L27
                r4.z(r1)     // Catch: java.lang.Exception -> L27
                goto L4a
            L27:
                r4 = move-exception
                goto L2c
            L29:
                int r4 = r4 + 1
                goto Le
            L2c:
                com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "deleteOldOfflineAd error "
                r1.append(r2)
                java.lang.String r4 = android.util.Log.getStackTraceString(r4)
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                java.lang.String r1 = "OfflineAdManager"
                r0.e(r1, r4)
            L4a:
                com.cloud.hisavana.sdk.c0 r4 = com.cloud.hisavana.sdk.c0.this
                java.util.List r4 = com.cloud.hisavana.sdk.c0.h(r4)
                if (r4 == 0) goto L81
                com.cloud.hisavana.sdk.c0 r4 = com.cloud.hisavana.sdk.c0.this
                java.util.List r4 = com.cloud.hisavana.sdk.c0.h(r4)
                com.cloud.hisavana.sdk.c0 r0 = com.cloud.hisavana.sdk.c0.this
                com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO r0 = com.cloud.hisavana.sdk.c0.G(r0)
                r4.remove(r0)
                com.cloud.hisavana.sdk.c0 r4 = com.cloud.hisavana.sdk.c0.this
                java.util.List r4 = com.cloud.hisavana.sdk.c0.h(r4)
                boolean r4 = r4.isEmpty()
                if (r4 != 0) goto L73
                com.cloud.hisavana.sdk.c0 r4 = com.cloud.hisavana.sdk.c0.this
                com.cloud.hisavana.sdk.c0.K(r4)
                goto L81
            L73:
                com.cloud.hisavana.sdk.c0 r4 = com.cloud.hisavana.sdk.c0.this
                r0 = 0
                com.cloud.hisavana.sdk.c0.i(r4, r0)
                com.cloud.hisavana.sdk.c0 r4 = com.cloud.hisavana.sdk.c0.this
                com.cloud.hisavana.sdk.c0.f(r4, r0)
                r3.c()
            L81:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.c0.a.a(java.util.List):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends CommonResponseListener<AdResponseBody> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConfigCodeSeatDTO f21797b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdxImpBean f21798c;

        b(ConfigCodeSeatDTO configCodeSeatDTO, AdxImpBean adxImpBean) {
            this.f21797b = configCodeSeatDTO;
            this.f21798c = adxImpBean;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            c0.this.u(this.f21797b, true);
            if (taErrorCode != null) {
                e4.b().d("OfflineAdManager", "load ad error adError=" + taErrorCode.getErrorMessage());
            }
            c0.this.f21795f.a(this.f21798c, null, taErrorCode);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(int i11, AdResponseBody adResponseBody) {
            com.cloud.hisavana.sdk.common.http.e.a(adResponseBody);
            c0.this.u(this.f21797b, false);
            if (adResponseBody == null || adResponseBody.getCode().intValue() != 0) {
                c0.this.n(adResponseBody, this.f21798c);
            } else {
                c0.this.p(adResponseBody, this.f21797b, this.f21798c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(List list, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final c0 f21800a = new c0(null);
    }

    private c0() {
        this.f21790a = new AtomicBoolean(false);
        this.f21794e = new androidx.collection.b();
        this.f21795f = new a();
    }

    /* synthetic */ c0(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void J(List list, ConfigCodeSeatDTO configCodeSeatDTO) {
        if (list == null || list.isEmpty() || configCodeSeatDTO == null) {
            this.f21795f.a(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            if (!g.e(adsDTO, true)) {
                arrayList.add(adsDTO);
            }
        }
        if (arrayList.isEmpty()) {
            this.f21795f.a(list);
            return;
        }
        e4.b().d("OfflineAdManager", "current code seat is " + configCodeSeatDTO.getCodeSeatId());
        k0.b().j(arrayList, this.f21795f);
    }

    private boolean C(AdResponseBody adResponseBody, ConfigCodeSeatDTO configCodeSeatDTO, AdxImpBean adxImpBean, List list) {
        if (!TextUtils.equals(adResponseBody.getData().getCodeSeatId(), configCodeSeatDTO.getCodeSeatId())) {
            e4.b().d("OfflineAdManager", "response pmid is different with request's");
            this.f21795f.a(adxImpBean, list, TaErrorCode.ERROR_AD_OFFLINE_PLACEMENT_ID_MISMATCH);
            return true;
        }
        if (configCodeSeatDTO.getCodeSeatType().equals(adResponseBody.getData().getCodeSeatType())) {
            return false;
        }
        e4.b().d("OfflineAdManager", "response adt is different with request's");
        this.f21795f.a(adxImpBean, list, TaErrorCode.ERROR_AD_OFFLINE_TYPE_MISMATCH);
        return true;
    }

    private boolean D(ConfigCodeSeatDTO configCodeSeatDTO) {
        if (configCodeSeatDTO == null) {
            return true;
        }
        if (Boolean.TRUE.equals(configCodeSeatDTO.isPriorityH5Ad()) && com.cloud.hisavana.sdk.common.util.p0.f(configCodeSeatDTO.getH5AdUrl())) {
            d0.f22409a.e(configCodeSeatDTO.getH5AdUrl());
        }
        v(configCodeSeatDTO.getCodeSeatId());
        if (configCodeSeatDTO.isOfflineAdEnable()) {
            return false;
        }
        w(configCodeSeatDTO.getCodeSeatId(), 3);
        return true;
    }

    private boolean E(List list, List list2, AdsDTO adsDTO) {
        if (adsDTO == null || !adsDTO.isOfflineAd()) {
            e4.b().d("OfflineAdManager", "ad is null or ad is not offline,remove from list");
            return true;
        }
        int a11 = com.cloud.hisavana.sdk.common.util.d0.a(adsDTO.getPullNewestLive().intValue(), adsDTO.getPsPackageName(), adsDTO.getPackageName());
        if (a11 == 1 || a11 == 2) {
            list.add(adsDTO.getAdCreativeId());
            list2.add(Integer.valueOf(a11 == 1 ? 1 : 2));
            return true;
        }
        if (adsDTO.getCodeSeatType().intValue() != 1 || adsDTO.isVastTypeAd() || (adsDTO.getNativeObject() != null && adsDTO.getNativeObject().getMainImages() != null && !adsDTO.getNativeObject().getMainImages().isEmpty() && !TextUtils.isEmpty(adsDTO.getNativeObject().getMainImages().get(0).getUrl()))) {
            return false;
        }
        e4.b().d("OfflineAdManager", "Native ad's image is empty,remove from list");
        return true;
    }

    public static c0 F() {
        return d.f21800a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(ConfigCodeSeatDTO configCodeSeatDTO) {
        t(configCodeSeatDTO, com.cloud.hisavana.sdk.d.f22404a.i(configCodeSeatDTO.getCodeSeatId(), true, null, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ConfigCodeSeatDTO configCodeSeatDTO, List list) {
        if (!configCodeSeatDTO.getLastOfflineAdEnable().booleanValue()) {
            J(list, configCodeSeatDTO);
            w(configCodeSeatDTO.getCodeSeatId(), 4);
            return;
        }
        if (this.f21793d == 3) {
            J(list, configCodeSeatDTO);
            return;
        }
        if (!list.isEmpty()) {
            J(list, configCodeSeatDTO);
            w(configCodeSeatDTO.getCodeSeatId(), 5);
            return;
        }
        long intValue = (configCodeSeatDTO.isAdRequestFail() ? configCodeSeatDTO.getOfflineAdRequestTimeInterval() : configCodeSeatDTO.getOfflineAdRequestTimeIntervalNoAd()).intValue();
        if (intValue <= 0) {
            intValue = 60;
        }
        if (System.currentTimeMillis() - configCodeSeatDTO.getLastRequestAdTime() <= intValue * 1000) {
            J(list, configCodeSeatDTO);
            w(configCodeSeatDTO.getCodeSeatId(), 6);
        } else {
            w(configCodeSeatDTO.getCodeSeatId(), 1);
            s(this.f21792c, this.f21793d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(final ConfigCodeSeatDTO configCodeSeatDTO) {
        final List i11 = com.cloud.hisavana.sdk.d.f22404a.i(configCodeSeatDTO.getCodeSeatId(), true, null, true);
        HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.x
            @Override // java.lang.Runnable
            public final void run() {
                c0.this.J(i11, configCodeSeatDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        List list = this.f21791b;
        if (list == null || list.isEmpty()) {
            this.f21795f.a(null);
            return;
        }
        Iterator it = this.f21791b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            final ConfigCodeSeatDTO configCodeSeatDTO = (ConfigCodeSeatDTO) it.next();
            if (!D(configCodeSeatDTO)) {
                this.f21792c = configCodeSeatDTO;
                HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.this.H(configCodeSeatDTO);
                    }
                });
                break;
            }
            it.remove();
        }
        List list2 = this.f21791b;
        if (list2 == null || !list2.isEmpty()) {
            return;
        }
        this.f21795f.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AdResponseBody adResponseBody, AdxImpBean adxImpBean) {
        TaErrorCode taErrorCode;
        if (adResponseBody != null) {
            e4.b().d("OfflineAdManager", "offline loadAd error, response is :" + adResponseBody.getCode() + ", " + adResponseBody.getMessage());
            taErrorCode = new TaErrorCode(adResponseBody.getCode().intValue(), adResponseBody.getMessage());
        } else {
            e4.b().d("OfflineAdManager", "offline loadAd error, response is null");
            taErrorCode = new TaErrorCode(-1, "response is null");
        }
        this.f21795f.a(adxImpBean, null, taErrorCode);
    }

    private void o(AdResponseBody adResponseBody, AdxImpBean adxImpBean, List list, List list2, List list3, int i11) {
        Iterator it = list.iterator();
        List<String> scales = adResponseBody.getData().getScales();
        List<AbTestDTO> abTest = adResponseBody.getData().getAbTest();
        String extInfo = adResponseBody.getData().getExtInfo();
        String adSeatType = adResponseBody.getData().getAdSeatType();
        Boolean testResponse = adResponseBody.getData().getTestResponse();
        testResponse.booleanValue();
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            if (E(list2, list3, adsDTO)) {
                it.remove();
            } else {
                if (!TextUtils.isEmpty(adsDTO.getOfflineH5Url())) {
                    adsDTO.setFilePath(com.cloud.hisavana.sdk.common.util.a0.c(adsDTO.getOfflineH5Url()));
                }
                adsDTO.setFill_ts(Long.valueOf(System.currentTimeMillis()));
                adsDTO.setAbTest(abTest);
                adsDTO.setExtInfo(extInfo);
                adsDTO.setImpBeanRequest(adxImpBean);
                adsDTO.setTestResponse(testResponse);
                adsDTO.setAdSeatType(adSeatType);
                adsDTO.setAdRequestVer(i11);
                String e11 = com.cloud.hisavana.sdk.common.util.b.f22230a.e(adsDTO, 0);
                adsDTO.setUuid(e11);
                adsDTO.setScales(scales);
                r(adsDTO, e11);
                if (v2.a(adsDTO) == -1) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(AdResponseBody adResponseBody, final ConfigCodeSeatDTO configCodeSeatDTO, AdxImpBean adxImpBean) {
        if (adResponseBody.getData() == null || adResponseBody.getData().getAds() == null || adResponseBody.getData().getAds().isEmpty() || Boolean.FALSE.equals(adResponseBody.getData().getOfflineAd())) {
            e4.b().d("OfflineAdManager", "ads list is empty");
            this.f21795f.a(adxImpBean, null, TaErrorCode.ERROR_AD_OFFLINE_AD_IS_NULL);
            return;
        }
        List<AdsDTO> ads = adResponseBody.getData().getAds();
        if (C(adResponseBody, configCodeSeatDTO, adxImpBean, ads)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int adRequestVer = configCodeSeatDTO.getAdRequestVer() + 1;
        configCodeSeatDTO.setAdRequestVer(adRequestVer);
        P.g().j(configCodeSeatDTO);
        o(adResponseBody, adxImpBean, ads, arrayList, arrayList2, adRequestVer);
        if (!arrayList.isEmpty() && adxImpBean != null) {
            AthenaTracker.x(adxImpBean.requestId, adxImpBean.triggerId, adxImpBean.pmid, arrayList, arrayList2, true, 2);
        }
        if (ads.isEmpty()) {
            this.f21795f.a(adxImpBean, null, TaErrorCode.ERROR_ADS_OFFLINE_ARE_FILTERED);
            return;
        }
        AthenaTracker.h0(ads, null, adxImpBean, ads.size(), this.f21794e);
        e4.b().d("OfflineAdManager", "download ad before" + ads.size());
        configCodeSeatDTO.setLocalOfflineAdCacheCount(ads.size());
        F().A(ads);
        HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.w
            @Override // java.lang.Runnable
            public final void run() {
                c0.this.L(configCodeSeatDTO);
            }
        });
    }

    private void r(AdsDTO adsDTO, String str) {
        try {
            if (TextUtils.isEmpty(adsDTO.getAppInfo())) {
                return;
            }
            PslinkInfo pslinkInfo = (PslinkInfo) GsonUtil.a(adsDTO.getAppInfo(), PslinkInfo.class);
            if (pslinkInfo != null) {
                pslinkInfo.setGaid(DeviceUtil.e());
                pslinkInfo.setShowId(str);
                pslinkInfo.setAppPackageName(com.transsion.core.utils.a.a());
                pslinkInfo.setOfflineAd(adsDTO.isOfflineAd());
                pslinkInfo.setShowTrackingSecretKey(adsDTO.getShowTrackingSecretKey());
            }
            adsDTO.setPslinkInfo(pslinkInfo);
        } catch (Exception e11) {
            e4.b().e("OfflineAdManager", "load ad extAppInfo error =" + e11.getMessage());
        }
    }

    private void s(ConfigCodeSeatDTO configCodeSeatDTO, int i11) {
        if (configCodeSeatDTO == null) {
            this.f21795f.a(null);
            return;
        }
        e4.b().d("OfflineAdManager", "requestAds config id " + configCodeSeatDTO.getCodeSeatId());
        final AdxImpBean adxImpBean = new AdxImpBean();
        adxImpBean.adt = configCodeSeatDTO.getCodeSeatType().intValue();
        adxImpBean.pmid = configCodeSeatDTO.getCodeSeatId();
        adxImpBean.mAdCount = configCodeSeatDTO.getOfflineAdCacheCount().intValue();
        adxImpBean.requestId = DeviceUtil.o();
        adxImpBean.offlineAd = true;
        adxImpBean.triggerId = com.cloud.hisavana.sdk.common.util.m0.b();
        adxImpBean.offlineAdEnable = configCodeSeatDTO.isOfflineAdEnable();
        adxImpBean.cacheAdCount = configCodeSeatDTO.getLocalOfflineAdCacheCount();
        if (i11 == 1) {
            adxImpBean.requestType = 5;
        } else if (i11 == 2) {
            adxImpBean.requestType = 6;
        } else if (i11 == 3) {
            adxImpBean.requestType = 7;
        }
        new com.cloud.hisavana.sdk.common.http.a().m(new b(configCodeSeatDTO, adxImpBean)).o(new a.b() { // from class: com.cloud.hisavana.sdk.v
            @Override // com.cloud.hisavana.sdk.common.http.a.b
            public final String a() {
                String c11;
                c11 = l1.c(AdxImpBean.this);
                return c11;
            }
        }).k(a7.c.p()).q(k1.o().q()).n(adxImpBean.pmid).l(true).j(adxImpBean).b();
    }

    private void t(final ConfigCodeSeatDTO configCodeSeatDTO, final List list) {
        HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.u
            @Override // java.lang.Runnable
            public final void run() {
                c0.this.I(configCodeSeatDTO, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(ConfigCodeSeatDTO configCodeSeatDTO, boolean z10) {
        if (configCodeSeatDTO == null) {
            return;
        }
        configCodeSeatDTO.setLastRequestAdTime(System.currentTimeMillis());
        configCodeSeatDTO.setAdRequestFail(z10);
        P.g().j(configCodeSeatDTO);
    }

    private void v(String str) {
        int i11 = this.f21793d;
        if (i11 == 3) {
            return;
        }
        AthenaTracker.j0(str, i11);
    }

    private void w(String str, int i11) {
        int i12 = this.f21793d;
        if (i12 == 3) {
            return;
        }
        AthenaTracker.Y(str, i12, i11);
    }

    public void A(List list) {
        com.cloud.hisavana.sdk.d.f22404a.y(list);
    }

    public void q(AdsDTO adsDTO) {
        com.cloud.hisavana.sdk.d.f22404a.H(adsDTO);
    }

    public void x(String str, int i11, boolean z10, List list, ConcurrentHashMap concurrentHashMap, c cVar) {
        com.cloud.hisavana.sdk.d.f22404a.o(str, i11, z10, list, concurrentHashMap, cVar);
    }

    public void y(String str, boolean z10) {
        com.cloud.hisavana.sdk.d.f22404a.r(str, z10);
    }

    public void z(Collection collection, int i11) {
        if (e4.c()) {
            e4.b().d("OfflineAdManager", "startDownloadAd triggerType " + i11 + ", isDownloading " + this.f21790a.get() + ", config list size: " + collection.size());
        }
        if (collection == null || collection.isEmpty() || this.f21790a.get()) {
            return;
        }
        this.f21791b = new ArrayList(collection);
        this.f21790a.set(true);
        this.f21793d = i11;
        j();
    }
}
