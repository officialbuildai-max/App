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
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class z1 extends l0 {

    /* renamed from: d, reason: collision with root package name */
    private AdsDTO f23210d;

    /* renamed from: e, reason: collision with root package name */
    private int f23211e;

    /* renamed from: f, reason: collision with root package name */
    private r3 f23212f;

    /* renamed from: g, reason: collision with root package name */
    private final String f23213g = "Rewarded";

    /* renamed from: h, reason: collision with root package name */
    private boolean f23214h;

    /* renamed from: i, reason: collision with root package name */
    private AtomicInteger f23215i;

    /* loaded from: classes3.dex */
    public static final class a extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f23216b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ z1 f23217c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f23218d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdsDTO f23219e;

        a(int i11, z1 z1Var, boolean z10, AdsDTO adsDTO) {
            this.f23216b = i11;
            this.f23217c = z1Var;
            this.f23218d = z10;
            this.f23219e = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode adError) {
            Intrinsics.h(adError, "adError");
            e4.b().d(this.f23217c.f23213g, "downloadImg error " + adError.getErrorCode() + " | " + adError.getErrorMessage());
            if (this.f23218d) {
                AthenaTracker.S(this.f23219e, 1);
            }
            this.f23217c.m(adError);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            int i12 = this.f23216b;
            if (i12 == 6) {
                this.f23217c.f(i11);
            } else if (i12 == 2) {
                this.f23217c.b(i11);
            }
            if (!this.f23218d) {
                this.f23217c.n(this.f23219e);
            } else {
                AthenaTracker.S(this.f23219e, 0);
                this.f23217c.o(this.f23219e, adImage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements com.cloud.hisavana.sdk.common.util.n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f23221b;

        b(AdsDTO adsDTO) {
            this.f23221b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.util.n
        public void a(boolean z10) {
            if (z10) {
                z1.this.n(this.f23221b);
                return;
            }
            z1 z1Var = z1.this;
            TaErrorCode ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED = TaErrorCode.ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED;
            Intrinsics.g(ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED, "ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED");
            z1Var.m(ERROR_ZIP_MATERIAL_DECOMPRESS_FAILED);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements q0.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f23223b;

        c(AdsDTO adsDTO) {
            this.f23223b = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.util.q0.b
        public void a(TaErrorCode error) {
            Intrinsics.h(error, "error");
            z1.this.p(this.f23223b, false);
            z1.this.m(error);
        }

        @Override // com.cloud.hisavana.sdk.common.util.q0.b
        public void b(int i11) {
            z1.this.p(this.f23223b, true);
            z1.this.e(i11);
            z1.this.y();
            N0.M(this.f23223b);
        }
    }

    public z1(AdsDTO adsDTO, int i11, r3 r3Var) {
        this.f23210d = adsDTO;
        this.f23211e = i11;
        this.f23212f = r3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(TaErrorCode taErrorCode) {
        this.f23214h = false;
        r3 r3Var = this.f23212f;
        if (r3Var != null) {
            r3Var.a(taErrorCode, this.f22693a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(AdsDTO adsDTO) {
        AtomicInteger atomicInteger = null;
        if (e4.c()) {
            e4 b11 = e4.b();
            String str = this.f23213g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("calcDownloadCount imageCounter ");
            AtomicInteger atomicInteger2 = this.f23215i;
            if (atomicInteger2 == null) {
                Intrinsics.z("imageCounter");
                atomicInteger2 = null;
            }
            sb2.append(atomicInteger2.get());
            b11.i(str, sb2.toString());
        }
        AtomicInteger atomicInteger3 = this.f23215i;
        if (atomicInteger3 == null) {
            Intrinsics.z("imageCounter");
        } else {
            atomicInteger = atomicInteger3;
        }
        if (atomicInteger.decrementAndGet() <= 0) {
            y();
            N0.M(adsDTO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(AdsDTO adsDTO, AdImage adImage) {
        if (adImage == null) {
            TaErrorCode ERROR_ZIP_MATERIAL_TAKE_FAILED = TaErrorCode.ERROR_ZIP_MATERIAL_TAKE_FAILED;
            Intrinsics.g(ERROR_ZIP_MATERIAL_TAKE_FAILED, "ERROR_ZIP_MATERIAL_TAKE_FAILED");
            m(ERROR_ZIP_MATERIAL_TAKE_FAILED);
        } else {
            z zVar = z.f22292a;
            String filePath = adImage.getFilePath();
            Intrinsics.g(filePath, "getFilePath(...)");
            zVar.h(adsDTO, filePath, new b(adsDTO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(AdsDTO adsDTO, boolean z10) {
        VastData videoInfo = adsDTO.getVideoInfo();
        if (videoInfo == null) {
            return;
        }
        videoInfo.setCached(Boolean.valueOf(z10));
    }

    private final void q(String str, AdsDTO adsDTO, int i11) {
        boolean isInteractiveAd = adsDTO.isInteractiveAd();
        int i12 = isInteractiveAd ? 8 : 2;
        DownLoadRequest.k(adsDTO.getAdImgUrl(), adsDTO, i12, isInteractiveAd, new a(i12, this, isInteractiveAd, adsDTO));
    }

    private final void t(AdsDTO adsDTO) {
        AdsProtocolBean.Ext ext = adsDTO.getExt();
        if (ext == null) {
            return;
        }
        Integer storeFlag = ext.getStoreFlag();
        Intrinsics.g(storeFlag, "getStoreFlag(...)");
        if (storeFlag.intValue() <= 0) {
            e4.b().d(this.f23213g, "Store flag is not valid, skipping download");
            return;
        }
        String storeImageurl = ext.getStoreImageurl();
        if (storeImageurl == null || storeImageurl.length() == 0) {
            TaErrorCode ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY = TaErrorCode.ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY;
            Intrinsics.g(ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY, "ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY");
            m(ERROR_MATERIAL_STORE_IMG_URL_IS_EMPTY);
            return;
        }
        AtomicInteger atomicInteger = this.f23215i;
        if (atomicInteger == null) {
            Intrinsics.z("imageCounter");
            atomicInteger = null;
        }
        atomicInteger.incrementAndGet();
        String storeImageurl2 = ext.getStoreImageurl();
        Intrinsics.g(storeImageurl2, "getStoreImageurl(...)");
        q(storeImageurl2, adsDTO, 6);
    }

    private final void w() {
        Unit unit;
        AdsDTO adsDTO = this.f23210d;
        if (adsDTO != null) {
            if (TextUtils.isEmpty(adsDTO.getAdImgUrl())) {
                TaErrorCode ERROR_ADM_URL_IS_EMPTY = TaErrorCode.ERROR_ADM_URL_IS_EMPTY;
                Intrinsics.g(ERROR_ADM_URL_IS_EMPTY, "ERROR_ADM_URL_IS_EMPTY");
                m(ERROR_ADM_URL_IS_EMPTY);
            } else {
                this.f23215i = new AtomicInteger(1);
                t(adsDTO);
                String adImgUrl = adsDTO.getAdImgUrl();
                Intrinsics.g(adImgUrl, "getAdImgUrl(...)");
                q(adImgUrl, adsDTO, 2);
            }
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        if (unit == null) {
            TaErrorCode ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL = TaErrorCode.ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL;
            Intrinsics.g(ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL, "ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL");
            m(ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL);
        }
    }

    private final void x() {
        AdsDTO adsDTO = this.f23210d;
        if (adsDTO != null) {
            com.cloud.hisavana.sdk.common.util.q0.f22255a.c(new c(adsDTO), adsDTO);
            return;
        }
        TaErrorCode ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL = TaErrorCode.ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL;
        Intrinsics.g(ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL, "ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL");
        m(ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        List l11;
        r3 r3Var;
        this.f23214h = false;
        AdsDTO adsDTO = this.f23210d;
        if (adsDTO != null && (r3Var = this.f23212f) != null) {
            r3Var.b(adsDTO, this.f22693a);
        }
        if (this.f23211e == 1) {
            AdsDTO adsDTO2 = this.f23210d;
            if (adsDTO2 == null || (l11 = CollectionsKt.e(adsDTO2)) == null) {
                l11 = CollectionsKt.l();
            }
            u0.f23073a.b(CollectionsKt.U0(l11));
        }
    }

    public final void u() {
        AdsDTO adsDTO = this.f23210d;
        if (adsDTO == null) {
            TaErrorCode ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL = TaErrorCode.ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL;
            Intrinsics.g(ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL, "ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL");
            m(ERROR_AD_REWARDED_AD_MATERIAL_IS_NULL);
            return;
        }
        if (this.f23214h) {
            return;
        }
        this.f23214h = true;
        int i11 = this.f23211e;
        if (i11 == 2 || i11 == 3) {
            a();
            y();
        } else {
            if (true == adsDTO.isVastTypeAd()) {
                x();
                return;
            }
            AdsDTO adsDTO2 = this.f23210d;
            if ((adsDTO2 != null ? adsDTO2.getNativeObject() : null) != null) {
                w();
            }
        }
    }
}
