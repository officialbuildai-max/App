package com.cloud.hisavana.sdk.common.util;

import com.cloud.hisavana.sdk.common.bean.VastClick;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ViewJson;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.tmc.ad.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f22230a = new b();

    private b() {
    }

    public final String a(AdsDTO adsDTO) {
        String adImgUrl;
        VastMedia mainAd;
        if (adsDTO == null || !adsDTO.isVastTypeAd()) {
            adImgUrl = adsDTO != null ? adsDTO.getAdImgUrl() : null;
        } else {
            VastData videoInfo = adsDTO.getVideoInfo();
            if (videoInfo == null || (mainAd = videoInfo.getMainAd()) == null || (adImgUrl = mainAd.getMediaResource()) == null) {
                adImgUrl = "";
            }
        }
        e4.b().d("AdMediaUtil", "getAdMainUrl ---->  " + adImgUrl);
        return adImgUrl;
    }

    public final int b(AdsDTO adsDTO) {
        String str;
        VastMedia mainAd;
        int i11 = 0;
        if (adsDTO != null && adsDTO.isVastTypeAd()) {
            VastData videoInfo = adsDTO.getVideoInfo();
            if (videoInfo == null || (mainAd = videoInfo.getMainAd()) == null || (str = mainAd.getType()) == null) {
                str = "";
            }
            i11 = StringsKt.W(str, "video/", false, 2, null) ? 1 : StringsKt.W(str, "image/", false, 2, null) ? 2 : -1;
        }
        e4.b().d("AdMediaUtil", "getAdMediaType ---->  " + i11);
        return i11;
    }

    public final List c(AdsDTO adsDTO, int i11) {
        VastData videoInfo;
        VastClick vastClick;
        List<String> clickTrack;
        VastData videoInfo2;
        VastIcon icon;
        List<String> iconClickTracking;
        return i11 == 1 ? (adsDTO == null || (videoInfo2 = adsDTO.getVideoInfo()) == null || (icon = videoInfo2.getIcon()) == null || (iconClickTracking = icon.getIconClickTracking()) == null) ? new ArrayList() : iconClickTracking : (adsDTO == null || (videoInfo = adsDTO.getVideoInfo()) == null || (vastClick = videoInfo.getVastClick()) == null || (clickTrack = vastClick.getClickTrack()) == null) ? new ArrayList() : clickTrack;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r3 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004b, code lost:
    
        if (r3 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d(com.cloud.hisavana.sdk.data.bean.response.AdsDTO r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            java.lang.String r1 = ""
            if (r4 != r0) goto L39
            if (r3 == 0) goto L19
            com.cloud.hisavana.sdk.common.bean.VastData r4 = r3.getVideoInfo()
            if (r4 == 0) goto L19
            com.cloud.hisavana.sdk.common.bean.VastIcon r4 = r4.getIcon()
            if (r4 == 0) goto L19
            java.lang.String r4 = r4.getIconClick()
            if (r4 != 0) goto L1a
        L19:
            r4 = r1
        L1a:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L37
            if (r3 == 0) goto L4d
            com.cloud.hisavana.sdk.common.bean.VastData r3 = r3.getVideoInfo()
            if (r3 == 0) goto L4d
            com.cloud.hisavana.sdk.common.bean.VastClick r3 = r3.getVastClick()
            if (r3 == 0) goto L4d
            java.lang.String r3 = r3.getVideoClick()
            if (r3 != 0) goto L35
            goto L4d
        L35:
            r1 = r3
            goto L4d
        L37:
            r1 = r4
            goto L4d
        L39:
            if (r3 == 0) goto L4d
            com.cloud.hisavana.sdk.common.bean.VastData r3 = r3.getVideoInfo()
            if (r3 == 0) goto L4d
            com.cloud.hisavana.sdk.common.bean.VastClick r3 = r3.getVastClick()
            if (r3 == 0) goto L4d
            java.lang.String r3 = r3.getVideoClick()
            if (r3 != 0) goto L35
        L4d:
            com.cloud.hisavana.sdk.e4 r3 = com.cloud.hisavana.sdk.e4.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "getClickUrl is ---> getClickUrl = "
            r4.append(r0)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "AdMediaUtil"
            r3.d(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.util.b.d(com.cloud.hisavana.sdk.data.bean.response.AdsDTO, int):java.lang.String");
    }

    public final String e(AdsDTO ad2, int i11) {
        Intrinsics.h(ad2, "ad");
        int i12 = ad2.getSource() == 4 ? 2 : ad2.isOfflineAd() ? 1 : 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("s_");
        String o11 = DeviceUtil.o();
        Intrinsics.g(o11, "getUUID(...)");
        sb2.append(new Regex("-").replace(o11, ""));
        sb2.append(",n_");
        sb2.append(i11);
        sb2.append(",t_");
        sb2.append(i12);
        return sb2.toString();
    }

    public final boolean f(AdsDTO adsDTO) {
        String psPackageName;
        String packageName;
        ViewJson.DialogJson dialogJson;
        String formPath;
        String url;
        ViewJson viewJsonData = adsDTO != null ? adsDTO.getViewJsonData() : null;
        Integer dialogType = viewJsonData != null ? viewJsonData.getDialogType() : null;
        if (dialogType != null && dialogType.intValue() == 1 && (!((dialogJson = viewJsonData.getDialogJson()) == null || (url = dialogJson.getUrl()) == null || url.length() <= 0) || ((formPath = viewJsonData.getFormPath()) != null && formPath.length() > 0))) {
            e4.b().d("AdMediaUtil", "checkAdIsJumpTOLandingPage: from ad");
            return false;
        }
        if ((adsDTO != null ? adsDTO.getStoreDeeplink() : null) != null && (!r1.isEmpty())) {
            e4.b().d("AdMediaUtil", "checkAdIsJumpTOLandingPage: storedeeplink page");
            return false;
        }
        String deepLinkUrl = adsDTO != null ? adsDTO.getDeepLinkUrl() : null;
        if (deepLinkUrl != null && deepLinkUrl.length() > 0) {
            e4.b().d("AdMediaUtil", "checkAdIsJumpTOLandingPage: deepLinkUrl page");
            return false;
        }
        if ((adsDTO == null || (packageName = adsDTO.getPackageName()) == null || packageName.length() <= 0) && (adsDTO == null || (psPackageName = adsDTO.getPsPackageName()) == null || psPackageName.length() <= 0)) {
            return true;
        }
        e4.b().d("AdMediaUtil", "checkAdIsJumpTOLandingPage: packageName or psPackageName");
        return false;
    }

    public final boolean g(AdsDTO adsDTO) {
        Integer dspType;
        String realLandUrl;
        if (adsDTO != null) {
            Boolean preloadEnable = adsDTO.getPreloadEnable();
            Intrinsics.g(preloadEnable, "getPreloadEnable(...)");
            if (preloadEnable.booleanValue() && !adsDTO.isOfflineAd() && adsDTO.getSource() != 4 && (dspType = adsDTO.getDspType()) != null && dspType.intValue() == 1 && (realLandUrl = adsDTO.getRealLandUrl()) != null && realLandUrl.length() != 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return (StringsKt.W(str, "http://", false, 2, null) || StringsKt.W(str, "https://", false, 2, null)) && !StringsKt.c0(str, Constants.GP_DEEPLINK, false, 2, null);
    }
}
