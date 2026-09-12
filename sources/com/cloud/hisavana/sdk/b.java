package com.cloud.hisavana.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.b;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VideoMask;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.util.z;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class b extends l0 {

    /* renamed from: d, reason: collision with root package name */
    private List f21745d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0305b f21746e;

    /* renamed from: g, reason: collision with root package name */
    private int f21748g;

    /* renamed from: f, reason: collision with root package name */
    private boolean f21747f = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f21749h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DownLoadRequest.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f21750a;

        a(List list) {
            this.f21750a = list;
        }

        @Override // com.cloud.hisavana.sdk.common.http.DownLoadRequest.c
        public void a(boolean z10) {
            if (z10) {
                b.this.f21749h = true;
            }
        }

        @Override // com.cloud.hisavana.sdk.common.http.DownLoadRequest.c
        public void onSuccess() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (TaNativeInfo taNativeInfo : this.f21750a) {
                if (taNativeInfo != null && (taNativeInfo.getAdItem().getExt() == null || taNativeInfo.getAdItem().getExt().getStoreFlag().intValue() <= 0 || taNativeInfo.getAdType() == 6 || b.this.o(taNativeInfo.getStore()))) {
                    if (taNativeInfo.getAdType() == 6) {
                        if (b.this.o(taNativeInfo.getIconImage())) {
                            arrayList.add(taNativeInfo);
                            arrayList2.add(taNativeInfo.getAdItem());
                        }
                    } else if (b.this.o(taNativeInfo.getImage())) {
                        arrayList.add(taNativeInfo);
                        arrayList2.add(taNativeInfo.getAdItem());
                    }
                    if (taNativeInfo.getAdItem() != null && taNativeInfo.getAdItem().getPslinkInfoStatus() && taNativeInfo.getIconImage() != null && taNativeInfo.getIconImage().isCached()) {
                        taNativeInfo.getAdItem().getPslinkInfo().setIconUri(com.cloud.hisavana.sdk.common.util.m.e(taNativeInfo.getIconImage().getFilePath()));
                        e4.b().d("ssp", "pslink half set icon uri");
                    }
                    if (taNativeInfo.getAdItem() != null && taNativeInfo.getAdItem().getVideoInfo() != null) {
                        AdsDTO adItem = taNativeInfo.getAdItem();
                        VastData videoInfo = adItem.getVideoInfo();
                        if (adItem.getDspType().intValue() == 2) {
                            if (videoInfo != null && videoInfo.checkVast()) {
                                arrayList.add(taNativeInfo);
                                arrayList2.add(taNativeInfo.getAdItem());
                            }
                        } else if (videoInfo != null && videoInfo.checkVast()) {
                            arrayList.add(taNativeInfo);
                            arrayList2.add(taNativeInfo.getAdItem());
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                b.this.i(TaErrorCode.ERROR_AD_MATERIAL_TAKE_FAILED);
                return;
            }
            N0.q(arrayList);
            b bVar = b.this;
            bVar.c(bVar.f21749h);
            b.this.k(arrayList, arrayList2);
        }
    }

    /* renamed from: com.cloud.hisavana.sdk.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0305b {
        void a(TaErrorCode taErrorCode, Bundle bundle);

        void b(List list, List list2, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private c f21752a;

        /* renamed from: b, reason: collision with root package name */
        private final TaNativeInfo f21753b;

        /* renamed from: c, reason: collision with root package name */
        private final DownLoadRequest.c f21754c;

        /* renamed from: d, reason: collision with root package name */
        private AtomicInteger f21755d = new AtomicInteger(0);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a extends DrawableResponseListener {
            a() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.d();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                if (i11 == 250) {
                    if (c.this.f21754c != null) {
                        c.this.f21754c.a(false);
                    }
                } else if (c.this.f21754c != null) {
                    c.this.f21754c.a(true);
                }
                c.this.f21753b.getImage().setCached(true);
                c.this.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.cloud.hisavana.sdk.b$c$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0306b extends DrawableResponseListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AdsDTO f21757b;

            C0306b(AdsDTO adsDTO) {
                this.f21757b = adsDTO;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.d();
                AthenaTracker.S(this.f21757b, 1);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                AthenaTracker.S(this.f21757b, 0);
                if (i11 == 250) {
                    if (c.this.f21754c != null) {
                        c.this.f21754c.a(false);
                    }
                } else if (c.this.f21754c != null) {
                    c.this.f21754c.a(true);
                }
                c.this.h(this.f21757b, adImage);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.cloud.hisavana.sdk.b$c$c, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0307c extends DrawableResponseListener {
            C0307c() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.d();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                if (i11 == 250) {
                    if (c.this.f21754c != null) {
                        c.this.f21754c.a(false);
                    }
                } else if (c.this.f21754c != null) {
                    c.this.f21754c.a(true);
                }
                AdImage iconImage = c.this.f21753b.getIconImage();
                iconImage.setCached(true);
                if (com.cloud.sdk.commonutil.util.l.a()) {
                    iconImage.setDrawable(adImage != null ? adImage.getDrawable() : null);
                } else {
                    iconImage.setFilePath(adImage != null ? adImage.getFilePath() : "");
                }
                c.this.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class d extends DrawableResponseListener {
            d() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                if (c.this.f21753b == null || c.this.f21753b.getAdItem() == null) {
                    return;
                }
                c.this.f21753b.getAdItem().setACReady(Boolean.FALSE);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                if (c.this.f21753b == null || c.this.f21753b.getAdItem() == null) {
                    return;
                }
                c.this.f21753b.getAdItem().setACReady(Boolean.TRUE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class e extends DrawableResponseListener {
            e() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.d();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                c.this.f21753b.getStore().setCached(true);
                c.this.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class f extends DrawableResponseListener {
            f() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.d();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                if (i11 == 250) {
                    if (c.this.f21754c != null) {
                        c.this.f21754c.a(false);
                    }
                } else if (c.this.f21754c != null) {
                    c.this.f21754c.a(true);
                }
                c.this.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class g extends DrawableResponseListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ VastData f21763b;

            g(VastData vastData) {
                this.f21763b = vastData;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.d();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                if (i11 == 250) {
                    if (c.this.f21754c != null) {
                        c.this.f21754c.a(false);
                    }
                } else if (c.this.f21754c != null) {
                    c.this.f21754c.a(true);
                }
                this.f21763b.setVideoCached(Boolean.TRUE);
                c.this.d();
            }
        }

        public c(TaNativeInfo taNativeInfo, DownLoadRequest.c cVar) {
            this.f21753b = taNativeInfo;
            this.f21754c = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            AtomicInteger atomicInteger = this.f21755d;
            if (atomicInteger == null || atomicInteger.decrementAndGet() > 0) {
                return;
            }
            p();
        }

        private void f(AdImage adImage, AdsDTO adsDTO, int i11, boolean z10, DrawableResponseListener drawableResponseListener) {
            if (adImage != null && !TextUtils.isEmpty(adImage.getImgUrl())) {
                DownLoadRequest.k(adImage.getImgUrl(), adsDTO, i11, z10, drawableResponseListener);
                return;
            }
            e4.b().d("NativeLoadManager", "image url is null");
            if (drawableResponseListener != null) {
                drawableResponseListener.a(TaErrorCode.ERROR_PRE_CACHE_IMG_URL_IS_EMPTY);
            }
        }

        private void g(AdsDTO adsDTO) {
            DownLoadRequest.k(adsDTO.getAdImgUrl(), adsDTO, 8, true, new C0306b(adsDTO));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(AdsDTO adsDTO, AdImage adImage) {
            if (adImage == null) {
                d();
            } else {
                z.f22292a.h(adsDTO, adImage.getFilePath(), new com.cloud.hisavana.sdk.common.util.n() { // from class: com.cloud.hisavana.sdk.c
                    @Override // com.cloud.hisavana.sdk.common.util.n
                    public final void a(boolean z10) {
                        b.c.this.i(z10);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(boolean z10) {
            AdImage image;
            if (z10 && (image = this.f21753b.getImage()) != null) {
                image.setCached(true);
            }
            d();
        }

        private boolean k() {
            TaNativeInfo taNativeInfo = this.f21753b;
            if (taNativeInfo == null || TextUtils.isEmpty(taNativeInfo.getAcImageUrl())) {
                return false;
            }
            if (!DownLoadRequest.f22126q) {
                DownLoadRequest.k(this.f21753b.getAcImageUrl(), this.f21753b.getAdItem(), 3, false, new d());
                return true;
            }
            TaNativeInfo taNativeInfo2 = this.f21753b;
            if (taNativeInfo2 == null || taNativeInfo2.getAdItem() == null) {
                return true;
            }
            this.f21753b.getAdItem().setACReady(Boolean.TRUE);
            return true;
        }

        private boolean m() {
            TaNativeInfo taNativeInfo = this.f21753b;
            if (taNativeInfo == null) {
                return false;
            }
            AdsDTO adItem = taNativeInfo.getAdItem();
            if (adItem == null || !adItem.isInteractiveAd()) {
                f(this.f21753b.getImage(), this.f21753b.getAdItem(), 2, false, new a());
                return true;
            }
            g(adItem);
            return true;
        }

        private boolean o() {
            TaNativeInfo taNativeInfo = this.f21753b;
            if (taNativeInfo == null) {
                return false;
            }
            f(taNativeInfo.getIconImage(), this.f21753b.getAdItem(), 1, true, new C0307c());
            return true;
        }

        private void p() {
            c cVar = this.f21752a;
            if (cVar != null) {
                cVar.u();
                return;
            }
            DownLoadRequest.c cVar2 = this.f21754c;
            if (cVar2 != null) {
                cVar2.onSuccess();
            }
        }

        private boolean r() {
            TaNativeInfo taNativeInfo = this.f21753b;
            if (taNativeInfo == null || taNativeInfo.getAdItem() == null) {
                e4.b().d("NativeLoadManager", "downloadStoreIcon nativeInfo of adItem is null");
                return false;
            }
            f(this.f21753b.getStore(), this.f21753b.getAdItem(), 2, false, new e());
            return true;
        }

        private boolean s() {
            VastData videoInfo;
            VastIcon icon;
            AdsDTO adItem = this.f21753b.getAdItem();
            if (adItem == null || (videoInfo = adItem.getVideoInfo()) == null || (icon = videoInfo.getIcon()) == null || icon.getIconResource() == null || TextUtils.isEmpty(icon.getIconResource())) {
                return false;
            }
            DownLoadRequest.k(icon.getIconResource(), adItem, 11, true, new f());
            return true;
        }

        private boolean t() {
            VastData videoInfo;
            VideoMask videoMask;
            AdsDTO adItem = this.f21753b.getAdItem();
            if (adItem == null || (videoInfo = adItem.getVideoInfo()) == null || (videoMask = videoInfo.getVideoMask()) == null || videoMask.getResource() == null || TextUtils.isEmpty(videoMask.getResource())) {
                return false;
            }
            DownLoadRequest.k(videoMask.getResource(), adItem, 12, true, new g(videoInfo));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u() {
            boolean z10;
            TaNativeInfo taNativeInfo = this.f21753b;
            if (taNativeInfo == null) {
                p();
                return;
            }
            AdsDTO adItem = taNativeInfo.getAdItem();
            if (adItem == null) {
                p();
                return;
            }
            if (adItem.getExt() == null || adItem.getExt().getStoreFlag().intValue() <= 0 || adItem.getAdType() == 6) {
                z10 = false;
            } else {
                String storeImageurl = adItem.getExt().getStoreImageurl();
                AdImage store = this.f21753b.getStore();
                if (store != null) {
                    store.setImgUrl(storeImageurl);
                }
                z10 = true;
            }
            if (z10) {
                this.f21755d.addAndGet(1);
            }
            if (this.f21753b.getAdType() == 1) {
                VastData videoInfo = adItem.getVideoInfo();
                this.f21755d.addAndGet(2);
                if (videoInfo == null || !videoInfo.checkVast()) {
                    if (!m()) {
                        d();
                    }
                    if (!o()) {
                        d();
                    }
                } else {
                    if (!s()) {
                        d();
                    }
                    if (!t()) {
                        d();
                    }
                }
                if (z10 && !r()) {
                    d();
                }
            } else {
                this.f21755d.addAndGet(1);
                if (!o()) {
                    d();
                }
                if (z10 && !r()) {
                    d();
                }
            }
            k();
        }
    }

    public b(List list, int i11, InterfaceC0305b interfaceC0305b) {
        this.f21745d = list;
        this.f21748g = i11;
        this.f21746e = interfaceC0305b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(TaErrorCode taErrorCode) {
        this.f21747f = false;
        InterfaceC0305b interfaceC0305b = this.f21746e;
        if (interfaceC0305b != null) {
            interfaceC0305b.a(taErrorCode, this.f22693a);
        }
    }

    private void j(List list) {
        e4.b().d("NativeLoadManager", "downloadMaterial start");
        List list2 = this.f21745d;
        if (list2 == null || list2.isEmpty()) {
            e4.b().d("NativeLoadManager", "downloadMaterial ads is null");
            i(TaErrorCode.ERROR_DOWNLOAD_MATERIAL_ADS_IS_NULL);
            return;
        }
        a aVar = new a(list);
        Iterator it = list.iterator();
        c cVar = null;
        c cVar2 = null;
        while (it.hasNext()) {
            TaNativeInfo taNativeInfo = (TaNativeInfo) it.next();
            if (cVar == null) {
                cVar2 = new c(taNativeInfo, aVar);
                cVar = cVar2;
            } else {
                cVar2.f21752a = new c(taNativeInfo, aVar);
                cVar2 = cVar2.f21752a;
            }
        }
        if (cVar != null) {
            cVar.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(List list, List list2) {
        this.f21747f = false;
        if (this.f21745d == null) {
            i(TaErrorCode.ERROR_AD_NATIVE_MATERIAL_DOWNLOAD_IS_NULL);
            return;
        }
        InterfaceC0305b interfaceC0305b = this.f21746e;
        if (interfaceC0305b != null) {
            interfaceC0305b.b(list, list2, this.f22693a);
        }
        if (this.f21748g == 1) {
            u0.f23073a.b(list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(AdImage adImage) {
        return adImage != null && adImage.isCached();
    }

    public void q() {
        if (this.f21747f) {
            return;
        }
        this.f21747f = true;
        if (!com.cloud.hisavana.sdk.common.util.i.a(this.f21745d)) {
            i(TaErrorCode.ERROR_AD_NATIVE_MATERIAL_DOWNLOAD_IS_NULL);
            return;
        }
        List G = N0.G(this.f21745d);
        int i11 = this.f21748g;
        if (i11 != 3 && i11 != 2) {
            j(G);
        } else {
            a();
            k(G, this.f21745d);
        }
    }
}
