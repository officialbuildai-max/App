package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.util.VastDomParseUtil;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigTotalDTO;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public abstract class v2 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f23109a = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(AdsDTO adsDTO, VastData vastData) {
            Integer dspType = adsDTO.getDspType();
            if (dspType != null && dspType.intValue() == 2) {
                List<String> showTrackingUrls = adsDTO.getShowTrackingUrls();
                List<String> list = showTrackingUrls;
                if (showTrackingUrls == null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    adsDTO.setShowTrackingUrls(arrayList);
                    list = arrayList;
                }
                List<String> impression = vastData.getImpression();
                if (impression != null) {
                    list.addAll(impression);
                }
                com.cloud.hisavana.sdk.common.util.b bVar = com.cloud.hisavana.sdk.common.util.b.f22230a;
                List c11 = bVar.c(adsDTO, 0);
                List<String> clickTrackingUrls = adsDTO.getClickTrackingUrls();
                if (clickTrackingUrls == null) {
                    clickTrackingUrls = new ArrayList<>();
                    adsDTO.setClickTrackingUrls(clickTrackingUrls);
                }
                clickTrackingUrls.addAll(c11);
                String d11 = bVar.d(adsDTO, 0);
                if (!TextUtils.isEmpty(d11)) {
                    if (!StringsKt.W(d11, "https", false, 2, null) && !StringsKt.W(d11, "http", false, 2, null)) {
                        adsDTO.setDeepLinkUrl(d11);
                    } else if (StringsKt.c0(d11, "https://play.google.com/store/apps/", false, 2, null) || StringsKt.c0(d11, "http://play.google.com/store/apps/", false, 2, null)) {
                        ArrayList<String> storeDeeplink = adsDTO.getStoreDeeplink();
                        if (storeDeeplink == null) {
                            storeDeeplink = new ArrayList<>();
                            adsDTO.setStoreDeeplink(storeDeeplink);
                        }
                        storeDeeplink.add(d11);
                    } else {
                        adsDTO.setClickUrl(d11);
                    }
                }
                adsDTO.setOmSdkVerifications(vastData.getAdVerifications());
            }
            NativeBean nativeObject = adsDTO.getNativeObject();
            if (nativeObject == null) {
                nativeObject = new NativeBean();
                adsDTO.setNativeObject(nativeObject);
            }
            if (!TextUtils.isEmpty(vastData.getTitle())) {
                nativeObject.setTitle(new NativeBean.TitleDTO(vastData.getTitle()));
            }
            if (!TextUtils.isEmpty(vastData.getButtonTxt())) {
                nativeObject.setButton(new NativeBean.ButtonDTO(vastData.getButtonTxt()));
            }
            if (!TextUtils.isEmpty(vastData.getDescription())) {
                nativeObject.setDescript(new NativeBean.DescriptDTO(vastData.getDescription()));
            }
            VastIcon icon = vastData.getIcon();
            if (icon != null && !TextUtils.isEmpty(icon.getIconResource())) {
                nativeObject.setLogo(new NativeBean.LogoDTO(icon.getIconResource()));
            }
            if (vastData.getMainAd() != null) {
                VastMedia mainAd = vastData.getMainAd();
                Intrinsics.e(mainAd);
                adsDTO.setMaterialWith(mainAd.getWidth());
                VastMedia mainAd2 = vastData.getMainAd();
                Intrinsics.e(mainAd2);
                adsDTO.setMaterialHeight(mainAd2.getHeight());
            }
        }

        public final int a(AdsDTO adsDTO) {
            String rtbAdm;
            if (adsDTO == null || (rtbAdm = adsDTO.getRtbAdm()) == null) {
                return 0;
            }
            if (rtbAdm.length() <= 0) {
                rtbAdm = null;
            }
            if (rtbAdm == null) {
                return 0;
            }
            VastData o11 = VastDomParseUtil.f22228a.o(rtbAdm, adsDTO);
            if (o11 == null) {
                e4.b().e("AdDataUtils", "formatVideoData: parse vast data failed");
                return -1;
            }
            if (o11.getMainAd() == null) {
                e4.b().e("AdDataUtils", "formatVideoData: mainAd is empty");
                AthenaTracker.k0(adsDTO, TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR, 3, o11.getVersion());
                return -1;
            }
            Integer materialType = adsDTO.getMaterialType();
            if (materialType != null && materialType.intValue() == 3) {
                adsDTO.setVastTypeAd(true);
                adsDTO.setVideoInfo(o11);
                c(adsDTO, o11);
                adsDTO.setRtbAdm(null);
                return 1;
            }
            e4.b().e("AdDataUtils", "formatVideoData: ad is not video type, creativeId " + adsDTO.getAdCreativeId());
            AthenaTracker.k0(adsDTO, TaErrorCode.MATERIAL_TYPE_IS_NOT_VIDEO_ERROR, 3, o11.getVersion());
            return -1;
        }

        public final String b(float f11) {
            float f12 = 10;
            String format = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(((float) Math.floor(f11 * f12)) / f12)}, 1));
            Intrinsics.g(format, "format(...)");
            return format;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
        
            if (r4.isInteractiveAd() != false) goto L19;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0005. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean d(com.cloud.hisavana.sdk.data.bean.response.AdsDTO r4, int r5) {
            /*
                r3 = this;
                r0 = 0
                if (r4 != 0) goto L4
                return r0
            L4:
                r1 = 1
                switch(r5) {
                    case 1: goto L29;
                    case 2: goto L28;
                    case 3: goto L17;
                    case 4: goto L9;
                    case 5: goto L17;
                    case 6: goto L29;
                    case 7: goto L17;
                    default: goto L8;
                }
            L8:
                goto L30
            L9:
                boolean r5 = r4.isVastTypeAd()
                if (r5 == 0) goto L10
                return r1
            L10:
                boolean r5 = r4.isInteractiveAd()
                if (r5 == 0) goto L30
                return r0
            L17:
                java.lang.String r5 = r4.getAdm()
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 != 0) goto L22
                return r0
            L22:
                boolean r5 = r4.isInteractiveAd()
                if (r5 == 0) goto L30
            L28:
                return r0
            L29:
                boolean r5 = r4.isInteractiveAd()
                if (r5 == 0) goto L30
                return r0
            L30:
                int r5 = r4.getSource()
                r2 = 4
                if (r2 != r5) goto L40
                int r4 = r4.getDefaultMaterialType()
                r5 = 2
                if (r4 != r5) goto L44
                r0 = r1
                goto L44
            L40:
                boolean r0 = r4.isVastTypeAd()
            L44:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.v2.a.d(com.cloud.hisavana.sdk.data.bean.response.AdsDTO, int):boolean");
        }

        public final String e(AdsDTO adsDTO) {
            String adCreativeId = adsDTO != null ? adsDTO.getAdCreativeId() : null;
            return adCreativeId == null ? "" : adCreativeId;
        }

        public final int f(AdsDTO adsDTO) {
            PslinkInfo pslinkInfo;
            if (adsDTO == null || (pslinkInfo = adsDTO.getPslinkInfo()) == null) {
                return 0;
            }
            return pslinkInfo.getDownloadCount();
        }

        public final String g(AdsDTO adsDTO) {
            if (adsDTO != null) {
                return v2.f23109a.q(adsDTO) ? adsDTO.getLogoUrl() : adsDTO.getAdImgUrl();
            }
            return null;
        }

        public final String h(AdsDTO adsDTO) {
            if (adsDTO != null) {
                return adsDTO.isVastTypeAd() ? v2.f23109a.k(adsDTO) : v2.f23109a.g(adsDTO);
            }
            return null;
        }

        public final String i(AdsDTO adsDTO) {
            String scale = adsDTO != null ? adsDTO.getScale() : null;
            return scale == null ? "" : scale;
        }

        public final float j(AdsDTO adsDTO) {
            NativeBean nativeObject;
            Integer rating;
            PslinkInfo pslinkInfo;
            String score;
            Float t11;
            float f11 = 0.0f;
            float floatValue = (adsDTO == null || (pslinkInfo = adsDTO.getPslinkInfo()) == null || (score = pslinkInfo.getScore()) == null || (t11 = StringsKt.t(score)) == null) ? 0.0f : t11.floatValue();
            if (adsDTO != null && (nativeObject = adsDTO.getNativeObject()) != null && (rating = nativeObject.getRating()) != null) {
                f11 = rating.intValue();
            }
            return Math.max(floatValue, f11);
        }

        public final String k(AdsDTO adsDTO) {
            VastData videoInfo;
            VastMedia mainAd;
            if (adsDTO == null || (videoInfo = adsDTO.getVideoInfo()) == null || (mainAd = videoInfo.getMainAd()) == null) {
                return null;
            }
            return mainAd.getMediaResource();
        }

        public final String l(AdsDTO adsDTO) {
            if (adsDTO == null) {
                return null;
            }
            int source = adsDTO.getSource();
            if (source == 1 || source == 2) {
                String e11 = N0.O(k(adsDTO), 3) ? DiskLruCacheUtil.e(k(adsDTO), 3) : k(adsDTO);
                String str = adsDTO.getSource() == 2 ? "online cache" : "real-time request";
                e4.b().d("AdDataUtils", "getVideoPlayURL, adId=" + adsDTO.getAdCreativeId() + ", ad source=" + str + " ad, \nurl=" + e11);
                return e11;
            }
            if (source == 3) {
                String e12 = N0.O(k(adsDTO), 3) ? DiskLruCacheUtil.e(k(adsDTO), 3) : k(adsDTO);
                e4.b().d("AdDataUtils", "getVideoPlayURL, adId=" + adsDTO.getAdCreativeId() + ", ad source=offline cache ad, \nurl=" + e12);
                return e12;
            }
            if (source != 4) {
                String k11 = k(adsDTO);
                e4.b().d("AdDataUtils", "getVideoPlayURL, adId=" + adsDTO.getAdCreativeId() + ", ad source=null, \nurl=" + k11);
                return k11;
            }
            if (adsDTO.isFromLocal()) {
                String adImgUrl = adsDTO.getAdImgUrl();
                e4.b().d("AdDataUtils", "getVideoPlayURL, adId=" + adsDTO.getAdCreativeId() + ", ad source=internal ad, fromlocal=true, \nurl=" + adImgUrl);
                return adImgUrl;
            }
            String e13 = N0.O(adsDTO.getAdImgUrl(), 4) ? DiskLruCacheUtil.e(adsDTO.getAdImgUrl(), 4) : adsDTO.getAdImgUrl();
            e4.b().d("AdDataUtils", "getVideoPlayURL, adId=" + adsDTO.getAdCreativeId() + ", ad source=internal ad, fromlocal=false, \nurl=" + e13);
            return e13;
        }

        public final int m(AdsDTO adsDTO) {
            VastData videoInfo;
            VastMedia mainAd;
            if (adsDTO == null || (videoInfo = adsDTO.getVideoInfo()) == null || (mainAd = videoInfo.getMainAd()) == null) {
                return 0;
            }
            return mainAd.getHeight();
        }

        public final int n(AdsDTO adsDTO) {
            VastData videoInfo;
            VastMedia mainAd;
            if (adsDTO == null || (videoInfo = adsDTO.getVideoInfo()) == null || (mainAd = videoInfo.getMainAd()) == null) {
                return 0;
            }
            return mainAd.getWidth();
        }

        public final boolean o(AdsDTO adsDTO) {
            ConfigTotalDTO.ExtInfo m11 = k1.o().m();
            return m11 != null && ((long) f(adsDTO)) >= m11.getDownloadCount();
        }

        public final boolean p(AdsDTO adsDTO) {
            ConfigTotalDTO.ExtInfo m11 = k1.o().m();
            return m11 != null && j(adsDTO) >= m11.getScoreCount();
        }

        public final boolean q(AdsDTO adsDTO) {
            if (adsDTO == null) {
                return false;
            }
            int adType = adsDTO.getAdType();
            return adType != 2 ? adType == 6 : Intrinsics.c(adsDTO.getMaterialStyle(), "B20301") || Intrinsics.c(adsDTO.getMaterialStyle(), "B20302") || Intrinsics.c(adsDTO.getMaterialStyle(), "B20303");
        }
    }

    public static final int a(AdsDTO adsDTO) {
        return f23109a.a(adsDTO);
    }

    public static final String b(float f11) {
        return f23109a.b(f11);
    }

    public static final boolean c(AdsDTO adsDTO, int i11) {
        return f23109a.d(adsDTO, i11);
    }

    public static final String d(AdsDTO adsDTO) {
        return f23109a.e(adsDTO);
    }

    public static final int e(AdsDTO adsDTO) {
        return f23109a.f(adsDTO);
    }

    public static final String f(AdsDTO adsDTO) {
        return f23109a.g(adsDTO);
    }

    public static final String g(AdsDTO adsDTO) {
        return f23109a.h(adsDTO);
    }

    public static final String h(AdsDTO adsDTO) {
        return f23109a.i(adsDTO);
    }

    public static final float i(AdsDTO adsDTO) {
        return f23109a.j(adsDTO);
    }

    public static final String j(AdsDTO adsDTO) {
        return f23109a.k(adsDTO);
    }

    public static final String k(AdsDTO adsDTO) {
        return f23109a.l(adsDTO);
    }

    public static final int l(AdsDTO adsDTO) {
        return f23109a.m(adsDTO);
    }

    public static final int m(AdsDTO adsDTO) {
        return f23109a.n(adsDTO);
    }

    public static final boolean n(AdsDTO adsDTO) {
        return f23109a.o(adsDTO);
    }

    public static final boolean o(AdsDTO adsDTO) {
        return f23109a.p(adsDTO);
    }

    public static final boolean p(AdsDTO adsDTO) {
        return f23109a.q(adsDTO);
    }
}
