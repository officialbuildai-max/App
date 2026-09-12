package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.ImgListDTO;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.util.q0;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    private c f22653a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements q0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f22654a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o4 f22655b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f22656c;

        a(AtomicInteger atomicInteger, o4 o4Var, d dVar) {
            this.f22654a = atomicInteger;
            this.f22655b = o4Var;
            this.f22656c = dVar;
        }

        @Override // com.cloud.hisavana.sdk.common.util.q0.b
        public void a(TaErrorCode taErrorCode) {
            k0.this.k(this.f22654a, this.f22655b, this.f22656c);
        }

        @Override // com.cloud.hisavana.sdk.common.util.q0.b
        public void b(int i11) {
            k0.this.k(this.f22654a, this.f22655b, this.f22656c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f22658b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22659c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f22660d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o4 f22661e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f22662f;

        b(boolean z10, String str, AtomicInteger atomicInteger, o4 o4Var, d dVar) {
            this.f22658b = z10;
            this.f22659c = str;
            this.f22660d = atomicInteger;
            this.f22661e = o4Var;
            this.f22662f = dVar;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            k0.this.k(this.f22660d, this.f22661e, this.f22662f);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (this.f22658b && adImage != null) {
                k0.this.h(adImage.getFilePath(), this.f22659c);
            }
            k0.this.k(this.f22660d, this.f22661e, this.f22662f);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(AdxImpBean adxImpBean, List list, TaErrorCode taErrorCode);

        void a(List list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final k0 f22664a = new k0(null);
    }

    private k0() {
    }

    /* synthetic */ k0(a aVar) {
        this();
    }

    public static k0 b() {
        return e.f22664a;
    }

    private void e(AdsDTO adsDTO, String str, int i11, boolean z10, o4 o4Var, AtomicInteger atomicInteger, d dVar) {
        if (TextUtils.isEmpty(str)) {
            k(atomicInteger, o4Var, dVar);
        } else {
            DownLoadRequest.k(str, adsDTO, i11, z10, new b(z10, str, atomicInteger, o4Var, dVar));
        }
    }

    private void f(o4 o4Var, d dVar) {
        if (o4Var == null) {
            dVar.a();
            return;
        }
        AdsDTO a11 = o4Var.a();
        if (a11 == null) {
            f(o4Var.c(), dVar);
            return;
        }
        if (TextUtils.isEmpty(v2.g(a11))) {
            f(o4Var.c(), dVar);
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger(3);
        l(o4Var, a11, atomicInteger, dVar);
        n(o4Var, a11, atomicInteger, dVar);
        p(o4Var, a11, atomicInteger, dVar);
        g(o4Var, a11, atomicInteger, dVar);
    }

    private void g(o4 o4Var, AdsDTO adsDTO, AtomicInteger atomicInteger, d dVar) {
        String offlineH5Url = adsDTO.getOfflineH5Url();
        if (TextUtils.isEmpty(offlineH5Url)) {
            k(atomicInteger, o4Var, dVar);
        } else {
            e(adsDTO, offlineH5Url, 5, adsDTO.isH5Zip(), o4Var, atomicInteger, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.cloud.hisavana.sdk.common.util.m.b(com.cloud.sdk.commonutil.util.e.a()));
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append("offline_zip");
        sb2.append(str3);
        sb2.append(com.cloud.hisavana.sdk.common.util.a0.c(str2));
        String sb3 = sb2.toString();
        if (new File(sb3).exists()) {
            return;
        }
        com.cloud.hisavana.sdk.common.util.s0.b(str, sb3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(List list) {
        m(list);
        o(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AtomicInteger atomicInteger, o4 o4Var, d dVar) {
        if (atomicInteger != null) {
            atomicInteger.decrementAndGet();
        }
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            f(o4Var == null ? null : o4Var.c(), dVar);
        }
    }

    private void l(o4 o4Var, AdsDTO adsDTO, AtomicInteger atomicInteger, d dVar) {
        if (adsDTO.isVastTypeAd()) {
            com.cloud.hisavana.sdk.common.util.q0.f22255a.c(new a(atomicInteger, o4Var, dVar), adsDTO);
        } else {
            e(adsDTO, v2.f(adsDTO), v2.p(adsDTO) ? 1 : 2, false, o4Var, atomicInteger, dVar);
        }
    }

    private void m(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            if (adsDTO != null) {
                if (!DownLoadRequest.f22126q && adsDTO.getAdChoiceImageUrl() != null) {
                    DownLoadRequest.k(adsDTO.getAdChoiceImageUrl(), adsDTO, 3, false, null);
                }
                String logoUrl = adsDTO.getLogoUrl();
                String materialStyle = adsDTO.getMaterialStyle();
                if (adsDTO.getImpBeanRequest() != null && adsDTO.getImpBeanRequest().adt == 2 && (TextUtils.equals(materialStyle, "B20301") || TextUtils.equals(materialStyle, "B20302") || TextUtils.equals(materialStyle, "B20303"))) {
                    return;
                } else {
                    DownLoadRequest.k(logoUrl, adsDTO, 1, false, null);
                }
            }
        }
    }

    private void n(o4 o4Var, AdsDTO adsDTO, AtomicInteger atomicInteger, d dVar) {
        if (adsDTO.getPslinkInfoStatus()) {
            String iconUrl = adsDTO.getPslinkInfo().getIconUrl();
            List<ImgListDTO> imgList = adsDTO.getPslinkInfo().getImgList();
            if (TextUtils.isEmpty(iconUrl)) {
                return;
            }
            atomicInteger.set(atomicInteger.get() + 1 + imgList.size());
            e4.b().d("OfflineDownload", "开始下载Pslink Half素材 ==" + iconUrl + " ,psImgUrl.size() == " + imgList.size());
            e(adsDTO, iconUrl, 4, false, o4Var, atomicInteger, dVar);
            for (ImgListDTO imgListDTO : imgList) {
                if (imgListDTO != null && !TextUtils.isEmpty(imgListDTO.getUrl())) {
                    e(adsDTO, imgListDTO.getUrl(), 4, false, o4Var, atomicInteger, dVar);
                }
            }
        }
    }

    private void o(List list) {
        c cVar = this.f22653a;
        if (cVar != null) {
            cVar.a(list);
        }
    }

    private void p(o4 o4Var, AdsDTO adsDTO, AtomicInteger atomicInteger, d dVar) {
        AdsProtocolBean.Ext ext = adsDTO.getExt();
        if (ext == null || ext.getStoreFlag().intValue() <= 0) {
            k(atomicInteger, o4Var, dVar);
        } else if (TextUtils.isEmpty(ext.getStoreImageurl())) {
            k(atomicInteger, o4Var, dVar);
        } else {
            e(adsDTO, ext.getStoreImageurl(), 6, false, o4Var, atomicInteger, dVar);
        }
    }

    public void j(final List list, c cVar) {
        this.f22653a = cVar;
        if (list == null || list.isEmpty()) {
            e4.b().d("OfflineDownload", "广告list为空");
            o(null);
            return;
        }
        Iterator it = list.iterator();
        o4 o4Var = null;
        o4 o4Var2 = null;
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            if (adsDTO != null) {
                o4 o4Var3 = new o4(adsDTO);
                if (o4Var2 == null) {
                    o4Var = o4Var3;
                } else {
                    o4Var2.b(o4Var3);
                }
                o4Var2 = o4Var3;
            }
        }
        if (o4Var != null) {
            f(o4Var, new d() { // from class: com.cloud.hisavana.sdk.i0
                @Override // com.cloud.hisavana.sdk.k0.d
                public final void a() {
                    k0.this.i(list);
                }
            });
        } else {
            e4.b().d("OfflineDownload", "下载失败");
            o(null);
        }
    }
}
