package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.data.bean.inapp.ApkInfo;
import com.cloud.hisavana.sdk.data.bean.inapp.DefaultAdDTO;
import com.cloud.hisavana.sdk.data.bean.inapp.PsAppInfo;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.gson.reflect.TypeToken;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f21765a = new b0();

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/cloud/hisavana/sdk/b0$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final class a extends TypeToken<List<? extends String>> {
        a() {
        }
    }

    private b0() {
    }

    private final int a(PsAppInfo psAppInfo) {
        List<ApkInfo> apkList;
        if (!i(i7.c.f(), psAppInfo.getModelWhite(), psAppInfo.getModelBlack(), true)) {
            return 1111;
        }
        List<ApkInfo> apkList2 = psAppInfo.getApkList();
        if (apkList2 != null && !apkList2.isEmpty() && (apkList = psAppInfo.getApkList()) != null) {
            for (ApkInfo apkInfo : apkList) {
                if (apkInfo != null) {
                    b0 b0Var = f21765a;
                    if (b0Var.i(DeviceUtil.d(), apkInfo.getCountryCodes(), null, false)) {
                        int g11 = i7.c.g();
                        Integer sysVersionCode = apkInfo.getSysVersionCode();
                        Intrinsics.g(sysVersionCode, "getSysVersionCode(...)");
                        if (g11 >= sysVersionCode.intValue() && b0Var.i(i7.c.h(), apkInfo.getAndroidSupportVersion(), null, false) && b0Var.i(i7.c.a(), apkInfo.getBrand(), null, true) && b0Var.i(i7.c.f(), apkInfo.getModel(), apkInfo.getNonModel(), true) && b0Var.l(i7.c.b(), apkInfo.getCpus())) {
                            return 0;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return 1112;
    }

    private final String f(String str) {
        String e11 = str != null ? DiskLruCacheUtil.e(str, 4) : null;
        return e11 == null ? "" : e11;
    }

    private final boolean h(String str, String str2, String str3) {
        if ((str2 == null || str2.length() == 0) && (str3 == null || str3.length() == 0)) {
            return true;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.g(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (str2 != null && str2.length() != 0) {
            Locale locale2 = Locale.getDefault();
            Intrinsics.g(locale2, "getDefault(...)");
            String lowerCase2 = str2.toLowerCase(locale2);
            Intrinsics.g(lowerCase2, "toLowerCase(...)");
            return StringsKt.S0(lowerCase2, new String[]{","}, false, 0, 6, null).contains(lowerCase);
        }
        if (str3 != null && str3.length() != 0) {
            Locale locale3 = Locale.getDefault();
            Intrinsics.g(locale3, "getDefault(...)");
            String lowerCase3 = str3.toLowerCase(locale3);
            Intrinsics.g(lowerCase3, "toLowerCase(...)");
            if (!StringsKt.S0(lowerCase3, new String[]{","}, false, 0, 6, null).contains(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean i(java.lang.String r12, java.lang.String r13, java.lang.String r14, boolean r15) {
        /*
            r11 = this;
            r0 = 0
            if (r13 == 0) goto L9
            int r1 = r13.length()
            if (r1 != 0) goto Lc
        L9:
            if (r15 != 0) goto Lc
            return r0
        Lc:
            if (r12 == 0) goto L92
            int r15 = r12.length()
            if (r15 != 0) goto L16
            goto L92
        L16:
            java.util.Locale r15 = java.util.Locale.getDefault()
            java.lang.String r1 = "getDefault(...)"
            kotlin.jvm.internal.Intrinsics.g(r15, r1)
            java.lang.String r12 = r12.toLowerCase(r15)
            java.lang.String r15 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.g(r12, r15)
            java.lang.String r2 = ","
            r3 = 1
            if (r13 == 0) goto L5f
            int r4 = r13.length()
            if (r4 != 0) goto L34
            goto L5f
        L34:
            java.lang.String r4 = "all"
            boolean r4 = kotlin.text.StringsKt.H(r13, r4, r3)
            if (r4 != 0) goto L5f
            java.util.Locale r4 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.g(r4, r1)
            java.lang.String r5 = r13.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.g(r5, r15)
            java.lang.String[] r6 = new java.lang.String[]{r2}
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            java.util.List r13 = kotlin.text.StringsKt.S0(r5, r6, r7, r8, r9, r10)
            boolean r13 = r13.contains(r12)
            if (r13 == 0) goto L5d
            goto L5f
        L5d:
            r13 = r0
            goto L60
        L5f:
            r13 = r3
        L60:
            if (r14 == 0) goto L8c
            int r4 = r14.length()
            if (r4 != 0) goto L69
            goto L8c
        L69:
            java.util.Locale r4 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.g(r4, r1)
            java.lang.String r5 = r14.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.g(r5, r15)
            java.lang.String[] r6 = new java.lang.String[]{r2}
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            java.util.List r14 = kotlin.text.StringsKt.S0(r5, r6, r7, r8, r9, r10)
            boolean r12 = r14.contains(r12)
            if (r12 != 0) goto L8a
            goto L8c
        L8a:
            r12 = r0
            goto L8d
        L8c:
            r12 = r3
        L8d:
            if (r13 == 0) goto L92
            if (r12 == 0) goto L92
            r0 = r3
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.b0.i(java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    private final boolean k(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date parse = simpleDateFormat.parse(str);
            if (parse == null) {
                parse = new Date();
            }
            Date parse2 = simpleDateFormat.parse(str2);
            if (parse2 == null) {
                parse2 = new Date();
            }
            return parse.compareTo(parse2) > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean l(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        List S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(CollectionsKt.v(S0, 10));
        Iterator it = S0.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.n1((String) it.next()).toString());
        }
        Set W0 = CollectionsKt.W0(arrayList);
        List S02 = StringsKt.S0(str2, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(S02, 10));
        Iterator it2 = S02.iterator();
        while (it2.hasNext()) {
            arrayList2.add(StringsKt.n1((String) it2.next()).toString());
        }
        return !CollectionsKt.o0(W0, CollectionsKt.W0(arrayList2)).isEmpty();
    }

    public final int b(String str, DefaultAdDTO ad2, String str2, PsAppInfo psAppInfo) {
        Intrinsics.h(ad2, "ad");
        try {
            if (!h(DeviceUtil.d(), ad2.getCountryWhite(), ad2.getCountryBlack())) {
                return 1107;
            }
            if (!h(i7.c.a(), ad2.getBrandWhite(), ad2.getBrandBlack())) {
                return 1108;
            }
            if (k(str, ad2.getEndDate())) {
                return 1101;
            }
            if (k(ad2.getStartDate(), str)) {
                return 1102;
            }
            if (ad2.getShowMaxOfDay() <= 0) {
                return 1109;
            }
            String displayedDate = ad2.getDisplayedDate();
            if (displayedDate != null && displayedDate.length() != 0 && TextUtils.equals(ad2.getDisplayedDate(), str) && ad2.getDisplayedTimes() >= ad2.getShowMaxOfDay()) {
                return 1103;
            }
            int a11 = com.cloud.hisavana.sdk.common.util.d0.a(ad2.getPullNewestLive(), str2, null);
            if (a11 != 0) {
                return a11 == 1 ? 1105 : 1106;
            }
            if ((ad2.getPullNewestLive() == 1 || ad2.getPullNewestLive() == 2) && psAppInfo != null) {
                return f21765a.a(psAppInfo);
            }
            return 0;
        } catch (Exception e11) {
            e4.b().w("DefaultAdUtil", "check ad validity error: " + e11.getMessage());
            return Integer.MAX_VALUE;
        }
    }

    public final AdsDTO c(DefaultAdDTO ad2, boolean z10) {
        Intrinsics.h(ad2, "ad");
        AdsDTO adsDTO = new AdsDTO();
        AdxImpBean adxImpBean = new AdxImpBean();
        adxImpBean.pmid = ad2.getCodeSeatId();
        adxImpBean.adt = ad2.getAdType();
        adsDTO.setImpBeanRequest(adxImpBean);
        adsDTO.setAdCreativeId(ad2.getAdCreativeId());
        adsDTO.setFirstPrice(ad2.getFirstPrice());
        adsDTO.setSettlementRatio(ad2.getSettlementRatio());
        adsDTO.setMaterialStyle(ad2.getMaterialStyle());
        NativeBean nativeBean = new NativeBean();
        NativeBean.TitleDTO titleDTO = new NativeBean.TitleDTO(ad2.getTitle());
        NativeBean.DescriptDTO descriptDTO = new NativeBean.DescriptDTO(ad2.getDescription());
        NativeBean.ButtonDTO buttonDTO = new NativeBean.ButtonDTO(ad2.getButton());
        NativeBean.LogoDTO logoDTO = z10 ? new NativeBean.LogoDTO(f(ad2.getLogoUrl())) : new NativeBean.LogoDTO(ad2.getLogoUrl());
        ArrayList arrayList = new ArrayList();
        arrayList.add(z10 ? new NativeBean.MainImagesDTO(f(ad2.getMainIngUrl())) : new NativeBean.MainImagesDTO(ad2.getMainIngUrl()));
        nativeBean.setTitle(titleDTO);
        nativeBean.setDescript(descriptDTO);
        nativeBean.setLogo(logoDTO);
        nativeBean.setButton(buttonDTO);
        nativeBean.setMainImages(arrayList);
        adsDTO.setAdChoiceImageUrl(z10 ? f(ad2.getAdChoiceImageUrl()) : ad2.getAdChoiceImageUrl());
        adsDTO.setNativeObject(nativeBean);
        adsDTO.setAdLaunchTypes(4);
        adsDTO.setExpiredDate(ad2.getEndDate());
        String pageUrl = ad2.getPageUrl();
        Intrinsics.g(pageUrl, "getPageUrl(...)");
        if (StringsKt.c0(pageUrl, AgentPageJsBridge.AGENT_PAGE_INFO, false, 2, null) && z10) {
            String pageUrl2 = ad2.getPageUrl();
            Intrinsics.g(pageUrl2, "getPageUrl(...)");
            if (StringsKt.c0(pageUrl2, UrlUtils.QUESTION_MARK, false, 2, null)) {
                ad2.setPageUrl(ad2.getPageUrl() + "&htmlfromlocal=true");
            } else {
                ad2.setPageUrl(ad2.getPageUrl() + "?htmlfromlocal=true");
            }
        }
        adsDTO.setClickUrl(ad2.getPageUrl());
        adsDTO.setCampaignname(ad2.getCampaignname());
        Integer materialType = ad2.getMaterialType();
        Intrinsics.g(materialType, "getMaterialType(...)");
        adsDTO.setDefaultMaterialType(materialType.intValue());
        adsDTO.setFromLocal(z10);
        adsDTO.setShowTime(ad2.getShowTime());
        adsDTO.setShowTrackingSecretKey(ad2.getShowTrackingSecretKey());
        if (ad2.getAppInfo() != null) {
            adsDTO.setAppInfo(ad2.getAppInfo());
            adsDTO.setPslinkInfo(N0.F(adsDTO));
        }
        adsDTO.setDeepLinkUrl(ad2.getDeepLinkUrl());
        if (ad2.getClickUrls() != null) {
            try {
                adsDTO.setStoreDeeplink((ArrayList) GsonUtil.b(ad2.getClickUrls(), new a().getType()));
            } catch (Exception unused) {
            }
        }
        adsDTO.setPullNewestLive(Integer.valueOf(ad2.getPullNewestLive()));
        AdsProtocolBean.Ext ext = new AdsProtocolBean.Ext();
        if (ad2.getPullNewestLive() == 1 || ad2.getPullNewestLive() == 2) {
            ext.setStoreFlag(1);
            ext.setStoreTitle(com.cloud.sdk.commonutil.util.e.a().getString(R$string.download_by_pamlstore));
        }
        ext.setDwellTime(ad2.getAdActivationRewardTime());
        adsDTO.setExt(ext);
        adsDTO.setMaterialWith(ad2.getMaterialWidth());
        adsDTO.setMaterialHeight(ad2.getMaterialHeight());
        adsDTO.setPackageName(ad2.getPackageName());
        adsDTO.setClickTrackingUrls(ad2.getClickTrackingUrls());
        adsDTO.setShowTrackingUrls(ad2.getShowTrackingUrls());
        adsDTO.setPsClickTrackingUrls(ad2.getPsClickTrackingUrls());
        adsDTO.setTrackType(Integer.valueOf(ad2.getTrackType()));
        NativeBean nativeObject = adsDTO.getNativeObject();
        if (nativeObject != null) {
            nativeObject.setRating(Integer.valueOf(ad2.getRating()));
        }
        adsDTO.setScale(ad2.getScale());
        adsDTO.setRewardDuration(Integer.valueOf(ad2.getRewardDuration()));
        adsDTO.setDefaultAdSupportNetType(ad2.getSupportNetType());
        adsDTO.setDownloadArea(ad2.getDownloadArea());
        adsDTO.setAutoRetentionTime(ad2.getAutoRetentionTime());
        return adsDTO;
    }

    public final String d() {
        try {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());
            return format == null ? "" : format;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String e(AdsDTO ad2) {
        Intrinsics.h(ad2, "ad");
        if (ad2.getAdType() == 6) {
            return null;
        }
        if (ad2.getAdType() == 2 && (TextUtils.equals(ad2.getMaterialStyle(), "B20301") || TextUtils.equals(ad2.getMaterialStyle(), "B20302") || TextUtils.equals(ad2.getMaterialStyle(), "B20303"))) {
            return null;
        }
        return ad2.getLogoUrl();
    }

    public final boolean g(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            Iterator it = (TextUtils.isEmpty(str2) ? CollectionsKt.l() : StringsKt.S0(str2, new String[]{","}, false, 0, 6, null)).iterator();
            while (it.hasNext()) {
                if (StringsKt.a0(str, (String) it.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String j(AdsDTO ad2) {
        Intrinsics.h(ad2, "ad");
        if (ad2.getAdType() == 6 || (ad2.getAdType() == 2 && (TextUtils.equals(ad2.getMaterialStyle(), "B20301") || TextUtils.equals(ad2.getMaterialStyle(), "B20302") || TextUtils.equals(ad2.getMaterialStyle(), "B20303")))) {
            String logoUrl = ad2.getLogoUrl();
            Intrinsics.e(logoUrl);
            return logoUrl;
        }
        String adImgUrl = ad2.getAdImgUrl();
        Intrinsics.e(adImgUrl);
        return adImgUrl;
    }
}
