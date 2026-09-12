package com.cloud.tmc.miniapp.performanceanalyse.page;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.miniapp.base.ShowPageData;
import com.cloud.tmc.miniapp.base.ShowPageStore;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniutils.util.GsonUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO0O0 {
    public static final OooO0O0 OooO00o = new OooO0O0();

    /* JADX WARN: Removed duplicated region for block: B:100:0x021e A[Catch: all -> 0x0267, LOOP:3: B:83:0x019f->B:100:0x021e, LOOP_END, TryCatch #0 {all -> 0x0267, blocks: (B:3:0x0036, B:5:0x003e, B:6:0x0049, B:8:0x005a, B:11:0x0063, B:13:0x0071, B:14:0x0078, B:16:0x0082, B:17:0x0089, B:19:0x0093, B:20:0x009a, B:22:0x00ac, B:27:0x0222, B:29:0x023d, B:30:0x0241, B:33:0x024e, B:37:0x024b, B:39:0x00ae, B:40:0x00c0, B:42:0x00c6, B:44:0x00da, B:49:0x0110, B:52:0x011a, B:54:0x0122, B:56:0x012c, B:57:0x0133, B:59:0x013d, B:60:0x0144, B:62:0x014e, B:63:0x0155, B:65:0x018b, B:69:0x015f, B:71:0x0169, B:72:0x0170, B:74:0x017a, B:76:0x0184, B:83:0x019f, B:85:0x01a7, B:87:0x01af, B:89:0x01b7, B:91:0x01c1, B:92:0x01c8, B:94:0x01d2, B:95:0x01f9, B:97:0x0203, B:98:0x020a, B:100:0x021e, B:105:0x01d7, B:107:0x01e1, B:108:0x01e8, B:110:0x01f2, B:113:0x0045), top: B:2:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0221 A[EDGE_INSN: B:101:0x0221->B:112:0x0221 BREAK  A[LOOP:3: B:83:0x019f->B:100:0x021e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0203 A[Catch: all -> 0x0267, TryCatch #0 {all -> 0x0267, blocks: (B:3:0x0036, B:5:0x003e, B:6:0x0049, B:8:0x005a, B:11:0x0063, B:13:0x0071, B:14:0x0078, B:16:0x0082, B:17:0x0089, B:19:0x0093, B:20:0x009a, B:22:0x00ac, B:27:0x0222, B:29:0x023d, B:30:0x0241, B:33:0x024e, B:37:0x024b, B:39:0x00ae, B:40:0x00c0, B:42:0x00c6, B:44:0x00da, B:49:0x0110, B:52:0x011a, B:54:0x0122, B:56:0x012c, B:57:0x0133, B:59:0x013d, B:60:0x0144, B:62:0x014e, B:63:0x0155, B:65:0x018b, B:69:0x015f, B:71:0x0169, B:72:0x0170, B:74:0x017a, B:76:0x0184, B:83:0x019f, B:85:0x01a7, B:87:0x01af, B:89:0x01b7, B:91:0x01c1, B:92:0x01c8, B:94:0x01d2, B:95:0x01f9, B:97:0x0203, B:98:0x020a, B:100:0x021e, B:105:0x01d7, B:107:0x01e1, B:108:0x01e8, B:110:0x01f2, B:113:0x0045), top: B:2:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO00o(com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o r24, com.cloud.tmc.miniapp.performanceanalyse.page.OooO00o r25, android.os.Bundle r26) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0.OooO00o(com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o, com.cloud.tmc.miniapp.performanceanalyse.page.OooO00o, android.os.Bundle):void");
    }

    public final void OooO00o(com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o, OooO00o oooO00o2, Bundle bundle, boolean z10) {
        int i11;
        App findApp;
        ShowPageStore showPageStore;
        Stack<ShowPageData> findShowPages;
        long longValue;
        long longValue2;
        long longValue3;
        long longValue4;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reportPageOpenSuccess #########> appOpenPointData:");
        sb2.append(oooO00o);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("reportPageOpenSuccess #########> pageOpenPointData:");
        sb3.append(oooO00o2);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("reportPageOpenSuccess #########> data:");
        sb4.append(bundle);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportPageOpenSuccess #########> isHomePage:");
        sb5.append(z10);
        try {
            if (oooO00o2.OooO0oo) {
                return;
            }
            bundle.putString("openPageResult", "true");
            bundle.putString(ChainPoint.OPEN_PAGE_FAILED_REASON, "");
            bundle.putInt("maxStage", 17);
            bundle.putString("isExitInStage", "");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            int i12 = 1;
            while (true) {
                if (i12 >= 12) {
                    break;
                }
                String valueOf = String.valueOf(i12);
                if (z10) {
                    Long l11 = oooO00o.OooO0OO.get(valueOf);
                    longValue3 = l11 != null ? l11.longValue() : 0L;
                    Long l12 = oooO00o.OooO0Oo.get(valueOf);
                    longValue4 = l12 != null ? l12.longValue() : 0L;
                    Long l13 = oooO00o.OooO0o0.get(valueOf);
                    linkedHashMap.put(valueOf, Long.valueOf(l13 != null ? l13.longValue() : 0L));
                } else {
                    Long l14 = oooO00o2.OooO0OO.get("12");
                    longValue3 = l14 != null ? l14.longValue() : 0L;
                    Long l15 = oooO00o2.OooO0OO.get("12");
                    longValue4 = l15 != null ? l15.longValue() : 0L;
                    linkedHashMap.put(valueOf, 0L);
                }
                linkedHashMap2.put(valueOf, new long[]{longValue3, longValue4});
                i12++;
            }
            for (i11 = 12; i11 < 18; i11++) {
                String valueOf2 = String.valueOf(i11);
                if (z10 || !(Intrinsics.c(valueOf2, PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION) || Intrinsics.c(valueOf2, "16"))) {
                    Long l16 = oooO00o2.OooO0OO.get(valueOf2);
                    longValue = l16 != null ? l16.longValue() : 0L;
                    Long l17 = oooO00o2.OooO0Oo.get(valueOf2);
                    if (l17 != null) {
                        longValue2 = l17.longValue();
                    }
                    longValue2 = 0;
                } else {
                    Long l18 = oooO00o2.OooO0Oo.get("14");
                    longValue = l18 != null ? l18.longValue() : 0L;
                    Long l19 = oooO00o2.OooO0Oo.get("14");
                    if (l19 != null) {
                        longValue2 = l19.longValue();
                    }
                    longValue2 = 0;
                }
                Long l20 = oooO00o2.OooO0o0.get(valueOf2);
                linkedHashMap.put(valueOf2, Long.valueOf(l20 != null ? l20.longValue() : 0L));
                linkedHashMap2.put(valueOf2, new long[]{longValue, longValue2});
            }
            bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap));
            bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap2));
            bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(oooO00o2.OooO00o));
            oooO00o2.OooO0oo = true;
            bundle.remove(ChainPoint.PAGE_PATH);
            bundle.remove(ChainPoint.PAGE_ID);
            if (Intrinsics.c(bundle.getString(ChainPoint.PAGE_CATEGOR_TYPE), "2") && (findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(oooO00o.OooO00o)) != null && (showPageStore = (ShowPageStore) findApp.getData(ShowPageStore.class)) != null && (findShowPages = showPageStore.findShowPages()) != null) {
                for (ShowPageData showPageData : findShowPages) {
                    if (Intrinsics.c(showPageData.getUrl(), oooO00o2.OooO00o)) {
                        bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(showPageData.getRequestUrl()));
                    }
                }
            }
            ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_page_open", bundle);
        } catch (Throwable unused) {
        }
    }

    public final boolean OooO00o(String str, Bundle data) {
        OooO00o oooO00o;
        Intrinsics.h(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordPageStageFail #########> appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        if (str != null) {
            try {
                com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o2 = (com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o) ((LinkedHashMap) com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO0O0).get(str);
                if (oooO00o2 == null) {
                    return true;
                }
                String string = data.getString(ChainPoint.PAGE_ID, "");
                if (TextUtils.isEmpty(string) || (oooO00o = oooO00o2.OooO0o.get(string)) == null || !Intrinsics.c(oooO00o.OooO0O0, string)) {
                    return true;
                }
                if (!Intrinsics.c(oooO00o.OooO00o, data.getString(ChainPoint.PAGE_PATH, ""))) {
                    return true;
                }
                OooO00o.OooO00o(oooO00o2, oooO00o, data);
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final boolean OooO00o(String stage, String str, Bundle data) {
        long j11;
        com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o;
        OooO00o oooO00o2;
        Intrinsics.h(stage, "stage");
        Intrinsics.h(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordPageStageEnd #########> stage:");
        sb2.append(stage);
        sb2.append(", appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            j11 = data.containsKey(ChainPoint.TIME) ? data.getLong(ChainPoint.TIME) : System.currentTimeMillis();
            oooO00o = (com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o) ((LinkedHashMap) com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO0O0).get(str);
        } catch (Throwable unused) {
        }
        if (oooO00o == null) {
            return true;
        }
        String string = data.getString(ChainPoint.PAGE_ID, "");
        if (TextUtils.isEmpty(string) || (oooO00o2 = oooO00o.OooO0o.get(string)) == null || !Intrinsics.c(oooO00o2.OooO0O0, string)) {
            return true;
        }
        if (!Intrinsics.c(oooO00o2.OooO00o, data.getString(ChainPoint.PAGE_PATH, "")) || !oooO00o2.OooO0OO.containsKey(stage)) {
            return true;
        }
        oooO00o2.OooO0Oo.put(stage, Long.valueOf(j11));
        Map<String, Long> map = oooO00o2.OooO0o0;
        Long l11 = oooO00o2.OooO0Oo.get(stage);
        Intrinsics.e(l11);
        long longValue = l11.longValue();
        Long l12 = oooO00o2.OooO0OO.get(stage);
        Intrinsics.e(l12);
        map.put(stage, Long.valueOf(longValue - l12.longValue()));
        if (Intrinsics.c(stage, ChainPoint.PageDrawView)) {
            OooO00o(oooO00o, oooO00o2, data, oooO00o2.OooO0o);
        }
        return true;
    }

    public final boolean OooO0O0(String str, Bundle data) {
        OooO00o oooO00o;
        Intrinsics.h(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reportPageOpenFinish #########> appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        if (str != null) {
            try {
                com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o2 = (com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o) ((LinkedHashMap) com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO0O0).get(str);
                if (oooO00o2 == null) {
                    return true;
                }
                String string = data.getString(ChainPoint.PAGE_ID, "");
                if (TextUtils.isEmpty(string) || (oooO00o = oooO00o2.OooO0o.get(string)) == null || !Intrinsics.c(oooO00o.OooO0O0, string)) {
                    return true;
                }
                if (!Intrinsics.c(oooO00o.OooO00o, data.getString(ChainPoint.PAGE_PATH, ""))) {
                    return true;
                }
                if (oooO00o.OooO0oo) {
                    oooO00o2.OooO0o.remove(string);
                    return true;
                }
                if (oooO00o.OooO0oO) {
                    oooO00o2.OooO0o.remove(string);
                    return true;
                }
                OooO00o.OooO00o(oooO00o2, oooO00o, data);
                oooO00o2.OooO0o.remove(string);
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final boolean OooO0O0(String stage, String str, Bundle data) {
        long j11;
        com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o oooO00o;
        Intrinsics.h(stage, "stage");
        Intrinsics.h(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordPageStageStart #########> stage:");
        sb2.append(stage);
        sb2.append(", appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            j11 = data.containsKey(ChainPoint.TIME) ? data.getLong(ChainPoint.TIME) : System.currentTimeMillis();
            oooO00o = (com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o) ((LinkedHashMap) com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO0O0).get(str);
        } catch (Throwable unused) {
        }
        if (oooO00o == null) {
            return true;
        }
        String pageId = data.getString(ChainPoint.PAGE_ID, "");
        if (TextUtils.isEmpty(pageId)) {
            return true;
        }
        String pagePath = data.getString(ChainPoint.PAGE_PATH, "");
        if (Intrinsics.c(stage, ChainPoint.PageCreateContainer)) {
            if (oooO00o.OooO0o.containsKey(pageId)) {
                oooO00o.OooO0o.remove(pageId);
            }
            Map m11 = MapsKt.m(TuplesKt.a(stage, Long.valueOf(j11)));
            boolean isEmpty = oooO00o.OooO0o.isEmpty();
            Map<String, OooO00o> map = oooO00o.OooO0o;
            Intrinsics.g(pageId, "pageId");
            Intrinsics.g(pagePath, "pagePath");
            map.put(pageId, new OooO00o(pagePath, pageId, m11, new LinkedHashMap(), new LinkedHashMap(), isEmpty, false, false));
        } else {
            OooO00o oooO00o2 = oooO00o.OooO0o.get(pageId);
            if (oooO00o2 == null) {
                return true;
            }
            oooO00o2.OooO0OO.put(stage, Long.valueOf(j11));
        }
        return true;
    }
}
