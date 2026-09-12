package com.cloud.hisavana.sdk.common.util;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.common.bean.VideoMask;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes3.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22255a = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: com.cloud.hisavana.sdk.common.util.q0$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0312a extends DrawableResponseListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f22256b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22257c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22258d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22259e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22260f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ b f22261g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22262h;

            C0312a(String str, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Ref.BooleanRef booleanRef4, b bVar, Ref.BooleanRef booleanRef5) {
                this.f22256b = str;
                this.f22257c = booleanRef;
                this.f22258d = booleanRef2;
                this.f22259e = booleanRef3;
                this.f22260f = booleanRef4;
                this.f22261g = bVar;
                this.f22262h = booleanRef5;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                e4 b11 = e4.b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onRequestError ");
                sb2.append(taErrorCode);
                sb2.append(' ');
                sb2.append(taErrorCode != null ? Integer.valueOf(taErrorCode.getErrorCode()) : null);
                sb2.append(' ');
                sb2.append(taErrorCode != null ? taErrorCode.getErrorMessage() : null);
                sb2.append(" url ");
                sb2.append(this.f22256b);
                sb2.append(')');
                b11.e("VastMaterialDownloadUtil", sb2.toString());
                this.f22257c.element = true;
                q0.f22255a.b(true, this.f22258d.element, this.f22259e.element, this.f22260f.element, this.f22261g, this.f22262h.element);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                e4.b().d("VastMaterialDownloadUtil", "onRequestSuccess " + i11);
                if (i11 == 250) {
                    this.f22262h.element = false;
                } else {
                    this.f22262h.element = true;
                }
                Ref.BooleanRef booleanRef = this.f22257c;
                booleanRef.element = true;
                this.f22260f.element = true;
                q0.f22255a.b(booleanRef.element, this.f22258d.element, this.f22259e.element, true, this.f22261g, this.f22262h.element);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends DrawableResponseListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22263b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22264c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22265d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22266e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f22267f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22268g;

            b(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Ref.BooleanRef booleanRef4, b bVar, Ref.BooleanRef booleanRef5) {
                this.f22263b = booleanRef;
                this.f22264c = booleanRef2;
                this.f22265d = booleanRef3;
                this.f22266e = booleanRef4;
                this.f22267f = bVar;
                this.f22268g = booleanRef5;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                this.f22263b.element = true;
                q0.f22255a.b(this.f22264c.element, true, this.f22265d.element, this.f22266e.element, this.f22267f, this.f22268g.element);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                this.f22263b.element = true;
                q0.f22255a.b(this.f22264c.element, true, this.f22265d.element, this.f22266e.element, this.f22267f, this.f22268g.element);
            }
        }

        /* loaded from: classes3.dex */
        public static final class c extends DrawableResponseListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22269b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22270c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22271d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22272e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f22273f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f22274g;

            c(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.BooleanRef booleanRef3, Ref.BooleanRef booleanRef4, b bVar, Ref.BooleanRef booleanRef5) {
                this.f22269b = booleanRef;
                this.f22270c = booleanRef2;
                this.f22271d = booleanRef3;
                this.f22272e = booleanRef4;
                this.f22273f = bVar;
                this.f22274g = booleanRef5;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                this.f22269b.element = true;
                q0.f22255a.b(this.f22270c.element, this.f22271d.element, true, this.f22272e.element, this.f22273f, this.f22274g.element);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                this.f22269b.element = true;
                q0.f22255a.b(this.f22270c.element, this.f22271d.element, true, this.f22272e.element, this.f22273f, this.f22274g.element);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(boolean z10, boolean z11, boolean z12, boolean z13, b bVar, boolean z14) {
            if (z12 && z11 && z10) {
                if (z13) {
                    int i11 = z14 ? 0 : 250;
                    if (bVar != null) {
                        bVar.b(i11);
                        return;
                    }
                    return;
                }
                if (bVar != null) {
                    TaErrorCode MAIN_VIDEO_DOWNLOAD_FAIL_ERROR = TaErrorCode.MAIN_VIDEO_DOWNLOAD_FAIL_ERROR;
                    Intrinsics.g(MAIN_VIDEO_DOWNLOAD_FAIL_ERROR, "MAIN_VIDEO_DOWNLOAD_FAIL_ERROR");
                    bVar.a(MAIN_VIDEO_DOWNLOAD_FAIL_ERROR);
                }
            }
        }

        public final void c(b bVar, AdsDTO adsDTO) {
            Ref.BooleanRef booleanRef;
            String str;
            boolean z10;
            Ref.BooleanRef booleanRef2;
            VideoMask videoMask;
            VastIcon icon;
            VastMedia mainAd;
            if (adsDTO == null) {
                if (bVar != null) {
                    TaErrorCode ERROR_AD_VAST_MATERIAL_DOWNLOAD_IS_NULL = TaErrorCode.ERROR_AD_VAST_MATERIAL_DOWNLOAD_IS_NULL;
                    Intrinsics.g(ERROR_AD_VAST_MATERIAL_DOWNLOAD_IS_NULL, "ERROR_AD_VAST_MATERIAL_DOWNLOAD_IS_NULL");
                    bVar.a(ERROR_AD_VAST_MATERIAL_DOWNLOAD_IS_NULL);
                    return;
                }
                return;
            }
            VastData videoInfo = adsDTO.getVideoInfo();
            String str2 = null;
            String mediaResource = (videoInfo == null || (mainAd = videoInfo.getMainAd()) == null) ? null : mainAd.getMediaResource();
            String iconResource = (videoInfo == null || (icon = videoInfo.getIcon()) == null) ? null : icon.getIconResource();
            if (videoInfo != null && (videoMask = videoInfo.getVideoMask()) != null) {
                str2 = videoMask.getResource();
            }
            String str3 = str2;
            Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef5 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef6 = new Ref.BooleanRef();
            Ref.BooleanRef booleanRef7 = new Ref.BooleanRef();
            if (TextUtils.isEmpty(mediaResource)) {
                if (bVar != null) {
                    TaErrorCode NO_MAIN_VIDEO_DATA_ERROR = TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR;
                    Intrinsics.g(NO_MAIN_VIDEO_DATA_ERROR, "NO_MAIN_VIDEO_DATA_ERROR");
                    bVar.a(NO_MAIN_VIDEO_DATA_ERROR);
                    return;
                }
                return;
            }
            if (mediaResource == null) {
                booleanRef = booleanRef6;
                str = str3;
                z10 = true;
                booleanRef4.element = true;
                booleanRef2 = booleanRef7;
                booleanRef2.element = false;
            } else if (adsDTO.getSource() == 1 && Constants.a(adsDTO.getAdType())) {
                booleanRef4.element = true;
                booleanRef6.element = true;
                booleanRef7.element = false;
                e4.b().d("VastMaterialDownloadUtil", "jump for real-time ad, do not download video, adId=" + adsDTO.getAdCreativeId() + ", url=" + mediaResource);
                booleanRef = booleanRef6;
                str = str3;
                z10 = true;
                booleanRef2 = booleanRef7;
            } else {
                str = str3;
                z10 = true;
                booleanRef = booleanRef6;
                booleanRef2 = booleanRef7;
                DownLoadRequest.l(mediaResource, adsDTO, true, new C0312a(mediaResource, booleanRef4, booleanRef3, booleanRef5, booleanRef6, bVar, booleanRef2));
            }
            if (iconResource != null) {
                DownLoadRequest.k(iconResource, adsDTO, 11, z10, new b(booleanRef3, booleanRef4, booleanRef5, booleanRef, bVar, booleanRef2));
            } else {
                booleanRef3.element = z10;
            }
            if (str != null) {
                DownLoadRequest.k(str, adsDTO, 12, z10, new c(booleanRef5, booleanRef4, booleanRef3, booleanRef, bVar, booleanRef2));
            } else {
                booleanRef5.element = z10;
                b(booleanRef4.element, booleanRef3.element, true, booleanRef.element, bVar, booleanRef2.element);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(TaErrorCode taErrorCode);

        void b(int i11);
    }
}
