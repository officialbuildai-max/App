package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.util.z;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class m extends l0 {

    /* renamed from: d, reason: collision with root package name */
    private final AdsDTO f22712d;

    /* renamed from: e, reason: collision with root package name */
    private r3 f22713e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f22714f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f22715g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f22716h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22717b;

        a(AdsDTO adsDTO) {
            this.f22717b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            this.f22717b.setACReady(Boolean.FALSE);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            this.f22717b.setACReady(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22719b;

        b(AdsDTO adsDTO) {
            this.f22719b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            e4.b().e("BannerDownload", "onRequestError " + taErrorCode);
            m.this.k(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            m.this.f(i11);
            m.this.l(this.f22719b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f22721b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22722c;

        /* loaded from: classes3.dex */
        class a implements com.cloud.hisavana.sdk.common.util.n {
            a() {
            }

            @Override // com.cloud.hisavana.sdk.common.util.n
            public void a(boolean z10) {
                c cVar = c.this;
                m.this.l(cVar.f22722c);
            }
        }

        c(int i11, AdsDTO adsDTO) {
            this.f22721b = i11;
            this.f22722c = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (this.f22722c.isInteractiveAd()) {
                AthenaTracker.S(m.this.f22712d, 1);
            }
            m.this.k(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            m.this.b(i11);
            if (this.f22721b == 1 && m.this.f22712d.getPslinkInfo() != null && !TextUtils.isEmpty(adImage.getFilePath())) {
                m.this.f22712d.getPslinkInfo().setIconUri(com.cloud.hisavana.sdk.common.util.m.e(adImage.getFilePath()));
            }
            if (!this.f22722c.isInteractiveAd()) {
                m.this.l(this.f22722c);
                return;
            }
            AthenaTracker.S(m.this.f22712d, 0);
            if (adImage != null) {
                z.f22292a.h(this.f22722c, adImage.getFilePath(), new a());
            } else {
                m.this.k(TaErrorCode.ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED);
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
            e4.b().e("BannerDownload", "onRequestError " + taErrorCode);
            m.this.k(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            m.this.f(i11);
            m mVar = m.this;
            mVar.l(mVar.f22712d);
        }
    }

    public m(AdsDTO adsDTO, int i11, r3 r3Var) {
        this.f22712d = adsDTO;
        this.f22716h = i11;
        this.f22713e = r3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(TaErrorCode taErrorCode) {
        if (this.f22715g) {
            return;
        }
        this.f22715g = true;
        r3 r3Var = this.f22713e;
        if (r3Var != null) {
            r3Var.a(taErrorCode, this.f22693a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AdsDTO adsDTO) {
        e4 b11 = e4.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calculateDownloadCount imageCounter ");
        AtomicInteger atomicInteger = this.f22714f;
        sb2.append(atomicInteger == null ? "null" : Integer.valueOf(atomicInteger.get()));
        b11.d("BannerDownload", sb2.toString());
        AtomicInteger atomicInteger2 = this.f22714f;
        if (atomicInteger2 == null || atomicInteger2.decrementAndGet() > 0) {
            return;
        }
        d();
        r3 r3Var = this.f22713e;
        if (r3Var != null) {
            r3Var.b(adsDTO, this.f22693a);
        }
        if (this.f22716h == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(adsDTO);
            u0.f23073a.b(arrayList);
        }
        N0.M(adsDTO);
    }

    private void n() {
        AdsDTO adsDTO = this.f22712d;
        if (adsDTO == null) {
            return;
        }
        if (TextUtils.isEmpty(adsDTO.getAdChoiceImageUrl())) {
            e4.b().d("BannerDownload", "Not found adChoiceImageUrl");
        } else {
            e4.b().d("ssp", "textView impression");
            DownLoadRequest.k(adsDTO.getAdChoiceImageUrl(), adsDTO, 3, false, new a(adsDTO));
        }
    }

    private void p() {
        if (!NetStateManager.checkNetworkState(true)) {
            this.f22713e.a(TaErrorCode.ERROR_DOWNLOAD_NO_NETWORK, this.f22693a);
            return;
        }
        AdsDTO adsDTO = this.f22712d;
        if (adsDTO == null || this.f22713e == null) {
            this.f22713e.a(TaErrorCode.ERROR_MATERIAL_DOWNLOAD_LOCAL_BEAN_NULL, this.f22693a);
            return;
        }
        if (TextUtils.isEmpty(adsDTO.getAdm())) {
            e4.b().e("BannerDownload", "getAdmView,adm is null");
            k(TaErrorCode.ERROR_ADM_IS_NULL);
            return;
        }
        List<String> scales = this.f22712d.getScales();
        if (scales == null || scales.isEmpty()) {
            k(TaErrorCode.ERROR_ADM_SCALE_TAKE_FAILED);
            return;
        }
        String str = scales.get(0);
        str.hashCode();
        if (!str.equals("3:2") && !str.equals("20:3")) {
            k(TaErrorCode.ERROR_ADM_SCALE_TAKE_FAILED);
            e4.b().e("BannerDownload", "getAdmView adm scale is not fit");
            return;
        }
        if (this.f22712d.getExt() == null || this.f22712d.getExt().getStoreFlag().intValue() <= 0) {
            if (this.f22713e != null) {
                a();
                this.f22713e.b(this.f22712d, this.f22693a);
                return;
            }
            return;
        }
        AdsProtocolBean.Ext ext = this.f22712d.getExt();
        this.f22714f = new AtomicInteger(1);
        if (TextUtils.isEmpty(ext.getStoreImageurl())) {
            k(TaErrorCode.ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY);
        } else {
            DownLoadRequest.k(ext.getStoreImageurl(), this.f22712d, 6, false, new d());
        }
    }

    private void r() {
        int i11;
        boolean z10;
        AdsDTO adsDTO = this.f22712d;
        if (adsDTO == null) {
            this.f22713e.a(TaErrorCode.ERROR_MATERIAL_DOWNLOAD_LOCAL_BEAN_NULL, this.f22693a);
            return;
        }
        String adImgUrl = adsDTO.getAdImgUrl();
        if ((TextUtils.equals(adsDTO.getMaterialStyle(), "B20301") || TextUtils.equals(adsDTO.getMaterialStyle(), "B20302") || TextUtils.equals(adsDTO.getMaterialStyle(), "B20303")) && adsDTO.getNativeObject() != null) {
            adImgUrl = adsDTO.getNativeObject().getLogoUrl();
            i11 = 1;
            z10 = true;
        } else {
            z10 = false;
            i11 = 2;
        }
        if (adsDTO.isInteractiveAd()) {
            adImgUrl = adsDTO.getAdImgUrl();
            i11 = 8;
            z10 = true;
        }
        if (TextUtils.isEmpty(adImgUrl)) {
            this.f22713e.a(TaErrorCode.ERROR_MATERIAL_DOWNLOAD_URL_IS_EMPTY, this.f22693a);
            e4.b().d("BannerDownload", "Not found the render type");
            return;
        }
        AdsProtocolBean.Ext ext = adsDTO.getExt();
        if (ext == null || ext.getStoreFlag().intValue() <= 0) {
            this.f22714f = new AtomicInteger(1);
        } else {
            this.f22714f = new AtomicInteger(2);
            if (TextUtils.isEmpty(ext.getStoreImageurl())) {
                k(TaErrorCode.ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY);
                return;
            }
            DownLoadRequest.k(ext.getStoreImageurl(), adsDTO, 6, false, new b(adsDTO));
        }
        DownLoadRequest.k(adImgUrl, adsDTO, i11, z10, new c(i11, adsDTO));
        if (DownLoadRequest.f22126q) {
            return;
        }
        n();
    }

    public void q() {
        this.f22715g = false;
        AdsDTO adsDTO = this.f22712d;
        if (adsDTO != null) {
            int i11 = this.f22716h;
            if (i11 == 3 || i11 == 2) {
                if (this.f22713e != null) {
                    a();
                    this.f22713e.b(this.f22712d, this.f22693a);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(adsDTO.getAdm())) {
                r();
            } else {
                p();
            }
        }
    }
}
