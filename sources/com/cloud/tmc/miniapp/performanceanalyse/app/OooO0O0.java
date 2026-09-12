package com.cloud.tmc.miniapp.performanceanalyse.app;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.GsonUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO0O0 {
    public static final OooO0O0 OooO00o = new OooO0O0();
    public static final Map<String, OooO00o> OooO0O0 = new LinkedHashMap();

    public final int OooO00o(int i11, int i12) {
        if (i11 == 2) {
            return i11;
        }
        if (i11 == 0) {
            return i12;
        }
        return 0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:7|(5:(20:16|17|(10:20|(1:22)(1:41)|23|(1:25)(1:40)|26|(1:28)(1:39)|29|(1:(2:32|33)(2:35|36))(2:37|38)|34|18)|42|43|44|45|(1:86)(1:49)|(3:78|79|(11:81|(3:72|73|(1:75))|53|54|(1:56)|57|(1:59)|61|(1:63)(1:(1:68)(1:69))|64|66))|51|(0)|53|54|(0)|57|(0)|61|(0)(0)|64|66)|61|(0)(0)|64|66)|88|17|(1:18)|42|43|44|45|(1:47)|86|(0)|51|(0)|53|54|(0)|57|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0138, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076 A[Catch: all -> 0x0049, TryCatch #3 {all -> 0x0049, blocks: (B:3:0x002a, B:7:0x002f, B:9:0x003a, B:11:0x003e, B:13:0x0042, B:17:0x004d, B:20:0x0076, B:22:0x0084, B:23:0x008b, B:25:0x0095, B:26:0x009c, B:28:0x00a6, B:29:0x00ad, B:34:0x00c7, B:43:0x00c9, B:56:0x013f, B:59:0x014a), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013f A[Catch: all -> 0x0049, TRY_ENTER, TryCatch #3 {all -> 0x0049, blocks: (B:3:0x002a, B:7:0x002f, B:9:0x003a, B:11:0x003e, B:13:0x0042, B:17:0x004d, B:20:0x0076, B:22:0x0084, B:23:0x008b, B:25:0x0095, B:26:0x009c, B:28:0x00a6, B:29:0x00ad, B:34:0x00c7, B:43:0x00c9, B:56:0x013f, B:59:0x014a), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014a A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #3 {all -> 0x0049, blocks: (B:3:0x002a, B:7:0x002f, B:9:0x003a, B:11:0x003e, B:13:0x0042, B:17:0x004d, B:20:0x0076, B:22:0x0084, B:23:0x008b, B:25:0x0095, B:26:0x009c, B:28:0x00a6, B:29:0x00ad, B:34:0x00c7, B:43:0x00c9, B:56:0x013f, B:59:0x014a), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0151 A[Catch: all -> 0x01bc, TRY_ENTER, TryCatch #4 {all -> 0x01bc, blocks: (B:63:0x0151, B:64:0x0193, B:68:0x0169, B:69:0x017f), top: B:61:0x014f }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO00o(com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o r23, android.os.Bundle r24) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO00o(com.cloud.tmc.miniapp.performanceanalyse.app.OooO00o, android.os.Bundle):void");
    }

    public final boolean OooO00o(String str) {
        OooO00o oooO00o;
        if (str == null || (oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str)) == null) {
            return false;
        }
        return oooO00o.OooOOO0;
    }

    public final boolean OooO00o(String str, Bundle data) {
        long j11;
        OooO00o oooO00o;
        String str2 = "false";
        Intrinsics.h(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordAppStageFail =======> appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            j11 = data.containsKey(ChainPoint.TIME) ? data.getLong(ChainPoint.TIME) : System.currentTimeMillis();
        } catch (Throwable unused) {
        }
        if (str == null || (oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str)) == null) {
            return true;
        }
        data.putString("openMiniAppResult", "false");
        Iterator<Map.Entry<String, Long>> it = oooO00o.OooO0OO.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!oooO00o.OooO0Oo.containsKey(key)) {
                oooO00o.OooO0Oo.put(key, Long.valueOf(j11));
                Map<String, Long> map = oooO00o.OooO0o0;
                Long l11 = oooO00o.OooO0Oo.get(key);
                Intrinsics.e(l11);
                long longValue = l11.longValue();
                Long l12 = oooO00o.OooO0OO.get(key);
                Intrinsics.e(l12);
                map.put(key, Long.valueOf(longValue - l12.longValue()));
                str2 = "true";
            }
        }
        data.putString("isExitInStage", str2);
        OooO0O0 oooO0O0 = OooO00o;
        data.putInt("syncType", oooO0O0.OooO00o(oooO0O0.OooO00o(oooO0O0.OooO00o(oooO0O0.OooO00o(0, oooO00o.OooO0oO), oooO00o.OooO0oo), oooO00o.OooOO0), oooO00o.OooO));
        int size = oooO00o.OooO0OO.size();
        data.putInt("maxStage", size);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (1 <= size) {
            int i11 = 1;
            while (true) {
                String valueOf = String.valueOf(i11);
                Long l13 = oooO00o.OooO0OO.get(valueOf);
                long longValue2 = l13 != null ? l13.longValue() : 0L;
                Long l14 = oooO00o.OooO0Oo.get(valueOf);
                long longValue3 = l14 != null ? l14.longValue() : 0L;
                Long l15 = oooO00o.OooO0o0.get(valueOf);
                linkedHashMap.put(valueOf, Long.valueOf(l15 != null ? l15.longValue() : 0L));
                linkedHashMap2.put(valueOf, new long[]{longValue2, longValue3});
                if (i11 == size) {
                    break;
                }
                i11++;
            }
        }
        data.putString("stageCostTime", GsonUtils.toJson(linkedHashMap));
        data.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap2));
        data.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(oooO00o.OooO0O0));
        MiniAppLaunch.INSTANCE.trackCommonResPoint(str, data);
        data.remove(ChainPoint.PAGE_PATH);
        data.remove(ChainPoint.PAGE_ID);
        ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(oooO00o.OooO00o, "mini_app_open", data);
        oooO00o.OooOO0o = true;
        if (!oooO00o.OooOO0O) {
            com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0 oooO0O02 = com.cloud.tmc.miniapp.performanceanalyse.page.OooO0O0.OooO00o;
            Bundle bundle = new Bundle();
            bundle.putString("isExitInStage", str2);
            Unit unit = Unit.f67184a;
            oooO0O02.OooO00o(oooO00o, (com.cloud.tmc.miniapp.performanceanalyse.page.OooO00o) null, bundle);
        }
        return true;
    }

    public final boolean OooO00o(String stage, String str, Bundle data) {
        Intrinsics.h(stage, "stage");
        Intrinsics.h(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordAppStageEnd =======> stage:");
        sb2.append(stage);
        sb2.append(", appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            long j11 = data.containsKey(ChainPoint.TIME) ? data.getLong(ChainPoint.TIME) : System.currentTimeMillis();
            if (str != null) {
                OooO0O0 oooO0O0 = OooO00o;
                OooO00o oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str);
                if (oooO00o == null || !oooO00o.OooO0OO.containsKey(stage) || oooO00o.OooO0Oo.containsKey(stage)) {
                    return true;
                }
                oooO00o.OooO0Oo.put(stage, Long.valueOf(j11));
                Map<String, Long> map = oooO00o.OooO0o0;
                Long l11 = oooO00o.OooO0Oo.get(stage);
                Intrinsics.e(l11);
                long longValue = l11.longValue();
                Long l12 = oooO00o.OooO0OO.get(stage);
                Intrinsics.e(l12);
                map.put(stage, Long.valueOf(longValue - l12.longValue()));
                if (Intrinsics.c(stage, ChainPoint.PageDrawView)) {
                    oooO0O0.OooO00o(oooO00o, data);
                }
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final boolean OooO0O0(String str, Bundle data) {
        Intrinsics.h(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordAppStageFinish =======> appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        if (str != null) {
            try {
                OooO0O0 oooO0O0 = OooO00o;
                Map<String, OooO00o> map = OooO0O0;
                OooO00o oooO00o = (OooO00o) ((LinkedHashMap) map).get(str);
                if (oooO00o == null) {
                    return true;
                }
                if (oooO00o.OooOO0o) {
                    map.remove(str);
                    return true;
                }
                data.putString(ChainPoint.OPEN_MINI_APP_FAILED_REASON, "小程序关闭");
                oooO0O0.OooO00o(str, data);
                map.remove(str);
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final boolean OooO0O0(String stage, String str, Bundle data) {
        long j11;
        Intrinsics.h(stage, "stage");
        Intrinsics.h(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordAppStageStart =======> stage:");
        sb2.append(stage);
        sb2.append(", appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            j11 = data.containsKey(ChainPoint.TIME) ? data.getLong(ChainPoint.TIME) : System.currentTimeMillis();
        } catch (Throwable unused) {
        }
        if (str == null) {
            return true;
        }
        if (Intrinsics.c(stage, ChainPoint.AppSetupStep)) {
            Map<String, OooO00o> map = OooO0O0;
            if (map.containsKey(str)) {
                map.remove(str);
            }
            map.put(str, new OooO00o(str, null, MapsKt.m(TuplesKt.a(stage, Long.valueOf(j11))), new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap(), 0, 0, 0, 0, false, false, false));
        } else {
            OooO00o oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str);
            if (oooO00o == null || oooO00o.OooO0OO.containsKey(stage)) {
                return true;
            }
            oooO00o.OooO0OO.put(stage, Long.valueOf(j11));
            if (Intrinsics.c(stage, ChainPoint.PageCreateContainer)) {
                oooO00o.OooOO0O = true;
                oooO00o.OooO0O0 = data.getString(ChainPoint.PAGE_PATH, "");
            }
        }
        return true;
    }

    public final boolean OooO0OO(String str, Bundle data) {
        Intrinsics.h(data, "data");
        if (str != null) {
            try {
                OooO00o oooO00o = (OooO00o) ((LinkedHashMap) OooO0O0).get(str);
                if (oooO00o == null) {
                    return true;
                }
                int i11 = data.getInt(ChainPoint.UPDATE_FRAMEWORK_MODE, -1);
                if (i11 != -1) {
                    oooO00o.OooO0oo = i11;
                }
                int i12 = data.getInt(ChainPoint.UPDATE_APP_MODE, -1);
                if (i12 != -1) {
                    oooO00o.OooO0oO = i12;
                }
                int i13 = data.getInt(ChainPoint.DOWNLOAD_FRAMEWORK_MODE, -1);
                if (i13 != -1) {
                    oooO00o.OooOO0 = i13;
                }
                int i14 = data.getInt(ChainPoint.DOWNLOAD_APP_MODE, -1);
                if (i14 != -1) {
                    oooO00o.OooO = i14;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("recordAppStageInsert ==> updateFrameworkMode:");
                sb2.append(i11);
                sb2.append(", updateAppMode:");
                sb2.append(i12);
                sb2.append(", downloadFrameworkMode:");
                sb2.append(i13);
                sb2.append(", downloadAppMode:");
                sb2.append(i14);
            } catch (Throwable unused) {
            }
        }
        return true;
    }
}
