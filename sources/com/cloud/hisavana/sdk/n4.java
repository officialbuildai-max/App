package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.util.q0;
import com.cloud.hisavana.sdk.common.util.z;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class n4 extends l0 {

    /* renamed from: d, reason: collision with root package name */
    private AdsDTO f22833d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f22834e;

    /* renamed from: f, reason: collision with root package name */
    private r3 f22835f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f22836g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f22837h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements q0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22838a;

        a(AdsDTO adsDTO) {
            this.f22838a = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.util.q0.b
        public void a(TaErrorCode taErrorCode) {
            n4.this.i(this.f22838a, false);
            n4.this.g(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.util.q0.b
        public void b(int i11) {
            n4.this.i(this.f22838a, true);
            n4.this.e(i11);
            n4.this.w();
            N0.M(this.f22838a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22840b;

        b(AdsDTO adsDTO) {
            this.f22840b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            e4.b().e("SplashLoadManager", "load store url error," + taErrorCode);
            n4.this.g(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            n4.this.f(i11);
            n4.this.h(this.f22840b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22842b;

        /* loaded from: classes3.dex */
        class a implements com.cloud.hisavana.sdk.common.util.n {
            a() {
            }

            @Override // com.cloud.hisavana.sdk.common.util.n
            public void a(boolean z10) {
                if (!z10) {
                    n4.this.g(TaErrorCode.ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED);
                } else {
                    c cVar = c.this;
                    n4.this.h(cVar.f22842b);
                }
            }
        }

        c(AdsDTO adsDTO) {
            this.f22842b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (n4.this.f22833d.isInteractiveAd()) {
                AthenaTracker.S(n4.this.f22833d, 1);
            }
            n4.this.g(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            n4.this.b(i11);
            if (!this.f22842b.isInteractiveAd()) {
                n4.this.h(this.f22842b);
                return;
            }
            AthenaTracker.S(n4.this.f22833d, 0);
            if (adImage != null) {
                z.f22292a.h(this.f22842b, adImage.getFilePath(), new a());
            } else {
                n4.this.g(TaErrorCode.ERROR_ZIP_MATERIAL_TAKE_FAILED);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends DrawableResponseListener {
        d() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            e4.b().e("SplashLoadManager", "load store url error," + taErrorCode);
            n4.this.g(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            n4.this.f(i11);
            n4 n4Var = n4.this;
            n4Var.h(n4Var.f22833d);
        }
    }

    public n4(AdsDTO adsDTO, int i11, r3 r3Var) {
        this.f22833d = adsDTO;
        this.f22837h = i11;
        this.f22835f = r3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(TaErrorCode taErrorCode) {
        this.f22836g = false;
        r3 r3Var = this.f22835f;
        if (r3Var != null) {
            r3Var.a(taErrorCode, this.f22693a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(AdsDTO adsDTO) {
        e4 b11 = e4.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calculateDownloadCount imageCounter ");
        AtomicInteger atomicInteger = this.f22834e;
        sb2.append(atomicInteger == null ? "null" : Integer.valueOf(atomicInteger.get()));
        b11.d("SplashLoadManager", sb2.toString());
        AtomicInteger atomicInteger2 = this.f22834e;
        if (atomicInteger2 == null || atomicInteger2.decrementAndGet() > 0) {
            return;
        }
        d();
        w();
        N0.M(adsDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AdsDTO adsDTO, boolean z10) {
        VastData videoInfo = adsDTO.getVideoInfo();
        if (videoInfo != null) {
            videoInfo.setCached(Boolean.valueOf(z10));
        }
    }

    private void s() {
        e4.b().d("SplashLoadManager", "interstitial loadAdmAd");
        if (!NetStateManager.checkNetworkState(true)) {
            this.f22835f.a(TaErrorCode.ERROR_DOWNLOAD_NO_NETWORK, this.f22693a);
            return;
        }
        AdsDTO adsDTO = this.f22833d;
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getAdm())) {
            this.f22835f.a(TaErrorCode.ERROR_MATERIAL_DOWNLOAD_LOCAL_BEAN_NULL, this.f22693a);
            return;
        }
        if (this.f22833d.getExt() == null || this.f22833d.getExt().getStoreFlag().intValue() <= 0) {
            a();
            w();
            return;
        }
        AdsProtocolBean.Ext ext = this.f22833d.getExt();
        if (ext == null || ext.getStoreFlag().intValue() <= 0) {
            return;
        }
        this.f22834e = new AtomicInteger(1);
        if (TextUtils.isEmpty(ext.getStoreImageurl())) {
            g(TaErrorCode.ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY);
        } else {
            DownLoadRequest.k(ext.getStoreImageurl(), this.f22833d, 6, false, new d());
        }
    }

    private void u() {
        AdsProtocolBean.Ext ext;
        e4.b().d("SplashLoadManager", "interstitial loadNormalAd");
        AdsDTO adsDTO = this.f22833d;
        if (adsDTO == null) {
            return;
        }
        if (TextUtils.isEmpty(adsDTO.getAdImgUrl())) {
            g(TaErrorCode.ERROR_ADM_URL_IS_EMPTY);
            return;
        }
        this.f22834e = new AtomicInteger(1);
        if (adsDTO.getExt() != null && adsDTO.getExt().getStoreFlag().intValue() > 0 && (ext = adsDTO.getExt()) != null && ext.getStoreFlag().intValue() > 0) {
            this.f22834e.addAndGet(1);
            if (TextUtils.isEmpty(ext.getStoreImageurl())) {
                g(TaErrorCode.ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY);
                return;
            }
            DownLoadRequest.k(ext.getStoreImageurl(), this.f22833d, 6, false, new b(adsDTO));
        }
        DownLoadRequest.k(adsDTO.getAdImgUrl(), adsDTO, adsDTO.isInteractiveAd() ? 8 : 2, adsDTO.isInteractiveAd(), new c(adsDTO));
    }

    private void v() {
        e4.b().d("SplashLoadManager", "interstitial loadVastAd");
        AdsDTO adsDTO = this.f22833d;
        if (adsDTO == null) {
            g(TaErrorCode.ERROR_AD_INTERSTITIAL_MATERIAL_IS_NULL);
        } else {
            com.cloud.hisavana.sdk.common.util.q0.f22255a.c(new a(adsDTO), adsDTO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        AdsDTO adsDTO;
        this.f22836g = false;
        r3 r3Var = this.f22835f;
        if (r3Var != null && (adsDTO = this.f22833d) != null) {
            r3Var.b(adsDTO, this.f22693a);
        }
        if (this.f22837h == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f22833d);
            u0.f23073a.b(arrayList);
        }
    }

    public void q() {
        AdsDTO adsDTO = this.f22833d;
        if (adsDTO == null) {
            g(TaErrorCode.ERROR_AD_INTERSTITIAL_MATERIAL_IS_NULL);
            return;
        }
        if (this.f22836g) {
            return;
        }
        this.f22836g = true;
        int i11 = this.f22837h;
        if (i11 == 3 || i11 == 2) {
            a();
            w();
        } else if (adsDTO.isVastTypeAd()) {
            v();
        } else if (TextUtils.isEmpty(this.f22833d.getAdm())) {
            u();
        } else {
            s();
        }
    }
}
