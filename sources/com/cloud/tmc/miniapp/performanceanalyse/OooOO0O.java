package com.cloud.tmc.miniapp.performanceanalyse;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.model.ForegroundTime;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ICommunicationTimeProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.miniapp.base.BaseActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooOO0O {
    public long OooO00o;
    public long OooO0O0;
    public boolean OooO0OO;
    public final Map<String, com.cloud.tmc.miniapp.performanceanalyse.OooO0O0> OooO0Oo = new LinkedHashMap();
    public static final OooO00o OooO0o0 = new OooO00o();
    public static final AtomicLong OooO0o = new AtomicLong(1);

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class OooO0O0 {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[PointAnalyseType.values().length];
            try {
                iArr[PointAnalyseType.POINT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointAnalyseType.POINT_JS_BRIDGE_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CREATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_T1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PointAnalyseType.POINT_RENDER_T2.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PointAnalyseType.POINT_WORKER_READY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PointAnalyseType.POINT_SDK_PV.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_PV.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PointAnalyseType.POINT_EXIT_CLICK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PointAnalyseType.POINT_EXIT_MINIAPP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PointAnalyseType.POINT_NAV_HOME_PRESSED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PointAnalyseType.POINT_MORE_ENTER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PointAnalyseType.POINT_MORE_EXIT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHORT_CUT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE_URL.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[PointAnalyseType.POINT_SHARE_SAVE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[PointAnalyseType.POINT_REFRESH.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[PointAnalyseType.POINT_ENTER_DEVELOP.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_AUTH.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_MESSAGE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_WIDGET.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_WHATSAPP.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_TELEGRAM.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_ICON_SHARE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[PointAnalyseType.POINT_CLICK_MC.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[PointAnalyseType.POINT_LAUNCH_MINIAPP_START.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[PointAnalyseType.POINT_LAUNCH_MINIAPP_HOT_OPEN.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_START.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_SUCCESS.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[PointAnalyseType.POINT_DOWNLOAD_V8_FAIL.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHECK_WHITESCREEN.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[PointAnalyseType.POINT_FPS.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_START.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_END.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_INSERT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[PointAnalyseType.POINT_CHAIN_CLEAR.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[PointAnalyseType.POINT_H5_PAGE_ONFINISHED.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[PointAnalyseType.POINT_LOG_ERROR.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_AGREEMENT.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_PACKAGE_FILE.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_START.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr[PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_START.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_END.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_START.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_END.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_CLEAR.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_CLEAR.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_INSERT.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr[PointAnalyseType.POINT_APP_CHAIN_FAIL.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr[PointAnalyseType.POINT_PAGE_CHAIN_FAIL.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr[PointAnalyseType.POINT_MINIAPP_FOREGROUND_TIME.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ODID.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr[PointAnalyseType.POINT_HOT_RELOAD.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr[PointAnalyseType.POINT_OPEN_PAGE_ACTION.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_EX.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_CLICK.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_BANNER_EX.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_BANNER_CLICK.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_ADD_MC_CLICK.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr[PointAnalyseType.POINT_PIN_FOR_LATER_ADD_MC_EX.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_EX.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr[PointAnalyseType.POINT_PRIVACY_CLICK.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr[PointAnalyseType.ADD_MINI_APP_TO_DESKTOP.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr[PointAnalyseType.PRE_REQUEST_HTML.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                iArr[PointAnalyseType.PRE_REQUEST_HTML_RET.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr[PointAnalyseType.GET_PRE_HTML.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr[PointAnalyseType.GET_PRE_HTML_HIT.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr[PointAnalyseType.POINT_OPEN_BROWSER.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                iArr[PointAnalyseType.PRE_STRATEGY_FAIL.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_EX.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_APP_EX.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr[PointAnalyseType.POINT_LATER_OFFLINE_CLICK.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_EX.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_TOAST_ADD_EX.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_CLICK.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr[PointAnalyseType.POINT_GET_ADD_NOSHOW.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            OooO00o = iArr;
        }
    }

    public final void OooO00o() {
        try {
            com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO00o();
        } catch (Throwable th2) {
            TmcLogger.e("PointTrack", "tryInitAthena failed!", th2);
        }
    }

    public final void OooO00o(Bundle bundle) {
        Map<String, Long> map;
        Long l11;
        String string = bundle.getString(ChainPoint.CHAIN_ID, "");
        String string2 = bundle.getString(ChainPoint.PAGE_PATH, "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || !this.OooO0Oo.containsKey(string)) {
            return;
        }
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0 = this.OooO0Oo.get(string);
        if (oooO0O0 != null) {
            if (Intrinsics.c(oooO0O0.OooO0O0, string2)) {
                bundle.putString("openType", "app");
                long currentTimeMillis = System.currentTimeMillis();
                Long l12 = oooO0O0.OooO0OO.get("18");
                bundle.putLong("openAppTime", currentTimeMillis - (l12 != null ? l12.longValue() : currentTimeMillis));
                Long l13 = oooO0O0.OooO0OO.get("17");
                bundle.putLong("openPageTime", currentTimeMillis - (l13 != null ? l13.longValue() : currentTimeMillis));
            } else {
                bundle.putString("openType", "page");
                long currentTimeMillis2 = System.currentTimeMillis();
                OooOO0 oooOO0 = oooO0O0.OooO0o0.get(string2);
                bundle.putLong("openPageTime", currentTimeMillis2 - ((oooOO0 == null || (map = oooOO0.OooO0OO) == null || (l11 = map.get("17")) == null) ? currentTimeMillis2 : l11.longValue()));
            }
        }
        bundle.remove(ChainPoint.TYPE);
        bundle.remove(ChainPoint.CHAIN_ID);
        bundle.remove(ChainPoint.PAGE_PATH);
    }

    public final void OooO00o(Bundle bundle, String str) {
        AppContext appContext;
        Context context;
        if (str != null) {
            try {
                App findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
                if (findApp == null || (appContext = findApp.getAppContext()) == null || (context = appContext.getContext()) == null) {
                    return;
                }
                Intrinsics.g(context, "context");
                bundle.putString("queryShortcutExist", String.valueOf(AppUtils.INSTANCE.queryShortcutExist(context, str)));
            } catch (Throwable th2) {
                TmcLogger.e("PointTrack", "queryShortcutStatus failed!", th2);
            }
        }
    }

    public final void OooO00o(String str) {
        App findApp;
        if (str != null) {
            try {
                App findApp2 = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
                if ((findApp2 != null ? (ForegroundTime) findApp2.getData(ForegroundTime.class) : null) != null || (findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str)) == null) {
                    return;
                }
                ForegroundTime foregroundTime = new ForegroundTime();
                foregroundTime.setStartTime();
                foregroundTime.resetStartCount();
                foregroundTime.addStartCount();
                Unit unit = Unit.f67184a;
                findApp.setData(ForegroundTime.class, foregroundTime);
            } catch (Throwable th2) {
                TmcLogger.e("PointTrack", "startRecordForegroundTime failed!", th2);
            }
        }
    }

    public final void OooO00o(String str, Bundle bundle) {
        String str2;
        String pagePath;
        Map<String, Long> map;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0;
        Map<String, Long> map2;
        Map<String, Long> map3;
        Map<String, Long> map4;
        Map<String, OooOO0> map5;
        OooOO0 oooOO0;
        Map<String, OooOO0> map6;
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02;
        Map<String, Long> map7;
        Map<String, Long> map8;
        String string = bundle.getString(ChainPoint.TYPE, "");
        String appId = bundle.getString(ChainPoint.CHAIN_ID, "");
        String string2 = bundle.getString(ChainPoint.PAGE_PATH, "");
        TmcLogger.d("oldChain", "chainStart -> msg:" + str + ", type:" + string + ", pagePath:" + string2);
        if (this.OooO0Oo.containsKey(appId)) {
            str2 = string2;
        } else {
            Map<String, com.cloud.tmc.miniapp.performanceanalyse.OooO0O0> map9 = this.OooO0Oo;
            Intrinsics.g(appId, "appId");
            str2 = string2;
            map9.put(appId, new com.cloud.tmc.miniapp.performanceanalyse.OooO0O0(appId, null, new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap(), 0, 0, 0, 0, false, "", "", "", "", false));
        }
        if (Intrinsics.c("app", string)) {
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O03 = this.OooO0Oo.get(appId);
            if ((oooO0O03 != null && (map8 = oooO0O03.OooO0OO) != null && map8.containsKey(str)) || (oooO0O02 = this.OooO0Oo.get(appId)) == null || (map7 = oooO0O02.OooO0OO) == null) {
                return;
            }
            map7.put(str, Long.valueOf(System.currentTimeMillis()));
            return;
        }
        if (!Intrinsics.c("page", string) || (pagePath = str2) == null || pagePath.length() == 0) {
            return;
        }
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O04 = this.OooO0Oo.get(appId);
        Map<String, OooOO0> map10 = oooO0O04 != null ? oooO0O04.OooO0o0 : null;
        if ((map10 == null || !map10.containsKey(pagePath)) && map10 != null) {
            Intrinsics.g(pagePath, "pagePath");
            map10.put(pagePath, new OooOO0(pagePath, "", new LinkedHashMap(), new LinkedHashMap(), "", "", ""));
        }
        if (Intrinsics.c(ChainPoint.CreateRender, str)) {
            String renderId = bundle.getString(ChainPoint.RENDER_ID, "");
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O05 = this.OooO0Oo.get(appId);
            OooOO0 oooOO02 = (oooO0O05 == null || (map6 = oooO0O05.OooO0o0) == null) ? null : map6.get(pagePath);
            if (oooOO02 != null) {
                Intrinsics.g(renderId, "renderId");
                Intrinsics.h(renderId, "<set-?>");
                oooOO02.OooO0O0 = renderId;
            }
        }
        if (Intrinsics.c(ChainPoint.ROUTE_PAGE, str)) {
            String string3 = bundle.getString("navigationType");
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O06 = this.OooO0Oo.get(appId);
            if (oooO0O06 != null && (map5 = oooO0O06.OooO0o0) != null && (oooOO0 = map5.get(pagePath)) != null) {
                if (string3 == null) {
                    string3 = "";
                }
                Intrinsics.h(string3, "<set-?>");
                oooOO0.OooO0oO = string3;
            }
        }
        OooOO0 oooOO03 = map10 != null ? map10.get(pagePath) : null;
        if ((oooOO03 == null || (map4 = oooOO03.OooO0OO) == null || !map4.containsKey(str)) && oooOO03 != null && (map = oooOO03.OooO0OO) != null) {
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O07 = this.OooO0Oo.get(appId);
        if ((oooO0O07 != null ? oooO0O07.OooO0O0 : null) == null) {
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O08 = this.OooO0Oo.get(appId);
            if (oooO0O08 != null) {
                oooO0O08.OooO0O0 = pagePath;
            }
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O09 = this.OooO0Oo.get(appId);
            if (oooO0O09 != null) {
                String string4 = bundle.getString(TmcConstants.KEY_PAGE_RANDOM_ID);
                if (string4 == null) {
                    string4 = "";
                }
                Intrinsics.h(string4, "<set-?>");
                oooO0O09.OooOOO = string4;
            }
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O010 = this.OooO0Oo.get(appId);
            if (oooO0O010 != null) {
                String string5 = bundle.getString("navigationType");
                String str3 = string5 != null ? string5 : "";
                Intrinsics.h(str3, "<set-?>");
                oooO0O010.OooOOO0 = str3;
            }
        }
        com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O011 = this.OooO0Oo.get(appId);
        if (Intrinsics.c(pagePath, oooO0O011 != null ? oooO0O011.OooO0O0 : null)) {
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O012 = this.OooO0Oo.get(appId);
            if ((oooO0O012 != null && (map3 = oooO0O012.OooO0OO) != null && map3.containsKey(str)) || (oooO0O0 = this.OooO0Oo.get(appId)) == null || (map2 = oooO0O0.OooO0OO) == null) {
                return;
            }
            map2.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0099. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0d75  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0d93  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03c6 A[Catch: all -> 0x061f, TryCatch #4 {all -> 0x061f, blocks: (B:143:0x0228, B:146:0x0273, B:148:0x0279, B:150:0x0283, B:151:0x028a, B:153:0x0294, B:154:0x029b, B:156:0x02a5, B:158:0x02ae, B:161:0x02b9, B:163:0x02c1, B:165:0x02d1, B:167:0x02d7, B:169:0x02df, B:170:0x02e3, B:172:0x02ef, B:175:0x0329, B:177:0x0333, B:178:0x033e, B:180:0x034b, B:181:0x0356, B:183:0x0363, B:184:0x036e, B:186:0x037b, B:187:0x037f, B:189:0x0390, B:193:0x039e, B:195:0x03ab, B:199:0x03b9, B:201:0x03c6, B:202:0x03d0, B:204:0x03db, B:206:0x03e5, B:207:0x03ec, B:209:0x03ef, B:211:0x03f9, B:212:0x03fd, B:214:0x05fc, B:228:0x040d, B:230:0x0423, B:232:0x042d, B:233:0x0434, B:235:0x043a, B:237:0x0444, B:239:0x044a, B:243:0x0452, B:245:0x045c, B:247:0x0462, B:249:0x046a, B:250:0x0471, B:252:0x047b, B:254:0x0481, B:256:0x0489, B:258:0x0492, B:261:0x04a1, B:263:0x04a9, B:265:0x04b9, B:267:0x04bf, B:269:0x04c7, B:270:0x04cb, B:272:0x04da, B:274:0x04e0, B:278:0x04ec, B:284:0x0524, B:286:0x052e, B:287:0x0535, B:289:0x0544, B:291:0x054a, B:293:0x0552, B:295:0x055a, B:297:0x0569, B:299:0x056f, B:301:0x0577, B:303:0x057f, B:305:0x058c, B:306:0x0593, B:308:0x05a0, B:309:0x05ab, B:311:0x05b8, B:312:0x05bc, B:314:0x05cd, B:316:0x05d3, B:318:0x05db, B:319:0x05df, B:321:0x05f0, B:323:0x05f6), top: B:142:0x0228 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03db A[Catch: all -> 0x061f, TryCatch #4 {all -> 0x061f, blocks: (B:143:0x0228, B:146:0x0273, B:148:0x0279, B:150:0x0283, B:151:0x028a, B:153:0x0294, B:154:0x029b, B:156:0x02a5, B:158:0x02ae, B:161:0x02b9, B:163:0x02c1, B:165:0x02d1, B:167:0x02d7, B:169:0x02df, B:170:0x02e3, B:172:0x02ef, B:175:0x0329, B:177:0x0333, B:178:0x033e, B:180:0x034b, B:181:0x0356, B:183:0x0363, B:184:0x036e, B:186:0x037b, B:187:0x037f, B:189:0x0390, B:193:0x039e, B:195:0x03ab, B:199:0x03b9, B:201:0x03c6, B:202:0x03d0, B:204:0x03db, B:206:0x03e5, B:207:0x03ec, B:209:0x03ef, B:211:0x03f9, B:212:0x03fd, B:214:0x05fc, B:228:0x040d, B:230:0x0423, B:232:0x042d, B:233:0x0434, B:235:0x043a, B:237:0x0444, B:239:0x044a, B:243:0x0452, B:245:0x045c, B:247:0x0462, B:249:0x046a, B:250:0x0471, B:252:0x047b, B:254:0x0481, B:256:0x0489, B:258:0x0492, B:261:0x04a1, B:263:0x04a9, B:265:0x04b9, B:267:0x04bf, B:269:0x04c7, B:270:0x04cb, B:272:0x04da, B:274:0x04e0, B:278:0x04ec, B:284:0x0524, B:286:0x052e, B:287:0x0535, B:289:0x0544, B:291:0x054a, B:293:0x0552, B:295:0x055a, B:297:0x0569, B:299:0x056f, B:301:0x0577, B:303:0x057f, B:305:0x058c, B:306:0x0593, B:308:0x05a0, B:309:0x05ab, B:311:0x05b8, B:312:0x05bc, B:314:0x05cd, B:316:0x05d3, B:318:0x05db, B:319:0x05df, B:321:0x05f0, B:323:0x05f6), top: B:142:0x0228 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0da9  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03f9 A[Catch: all -> 0x061f, TryCatch #4 {all -> 0x061f, blocks: (B:143:0x0228, B:146:0x0273, B:148:0x0279, B:150:0x0283, B:151:0x028a, B:153:0x0294, B:154:0x029b, B:156:0x02a5, B:158:0x02ae, B:161:0x02b9, B:163:0x02c1, B:165:0x02d1, B:167:0x02d7, B:169:0x02df, B:170:0x02e3, B:172:0x02ef, B:175:0x0329, B:177:0x0333, B:178:0x033e, B:180:0x034b, B:181:0x0356, B:183:0x0363, B:184:0x036e, B:186:0x037b, B:187:0x037f, B:189:0x0390, B:193:0x039e, B:195:0x03ab, B:199:0x03b9, B:201:0x03c6, B:202:0x03d0, B:204:0x03db, B:206:0x03e5, B:207:0x03ec, B:209:0x03ef, B:211:0x03f9, B:212:0x03fd, B:214:0x05fc, B:228:0x040d, B:230:0x0423, B:232:0x042d, B:233:0x0434, B:235:0x043a, B:237:0x0444, B:239:0x044a, B:243:0x0452, B:245:0x045c, B:247:0x0462, B:249:0x046a, B:250:0x0471, B:252:0x047b, B:254:0x0481, B:256:0x0489, B:258:0x0492, B:261:0x04a1, B:263:0x04a9, B:265:0x04b9, B:267:0x04bf, B:269:0x04c7, B:270:0x04cb, B:272:0x04da, B:274:0x04e0, B:278:0x04ec, B:284:0x0524, B:286:0x052e, B:287:0x0535, B:289:0x0544, B:291:0x054a, B:293:0x0552, B:295:0x055a, B:297:0x0569, B:299:0x056f, B:301:0x0577, B:303:0x057f, B:305:0x058c, B:306:0x0593, B:308:0x05a0, B:309:0x05ab, B:311:0x05b8, B:312:0x05bc, B:314:0x05cd, B:316:0x05d3, B:318:0x05db, B:319:0x05df, B:321:0x05f0, B:323:0x05f6), top: B:142:0x0228 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0dc4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0e1e  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0818 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x086e A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0a25 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0a56 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0a93 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0ab9 A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0adc  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0add A[Catch: all -> 0x0af9, TryCatch #2 {all -> 0x0af9, blocks: (B:344:0x065b, B:347:0x06b0, B:349:0x06b6, B:351:0x06c0, B:353:0x06c6, B:355:0x06cd, B:357:0x06d7, B:359:0x06dd, B:361:0x06eb, B:363:0x06f1, B:365:0x06f9, B:366:0x0700, B:369:0x0810, B:371:0x0818, B:373:0x0822, B:374:0x0829, B:376:0x082f, B:377:0x0ae1, B:383:0x0859, B:385:0x086e, B:387:0x0878, B:388:0x087f, B:390:0x0885, B:392:0x088f, B:394:0x0898, B:396:0x08bc, B:398:0x08fc, B:400:0x0902, B:401:0x090a, B:403:0x0910, B:405:0x093b, B:407:0x0945, B:409:0x094a, B:411:0x0958, B:413:0x095e, B:414:0x0965, B:416:0x0969, B:418:0x0970, B:419:0x097b, B:423:0x0986, B:425:0x0997, B:426:0x09a1, B:428:0x09ae, B:429:0x09b9, B:431:0x09c6, B:432:0x09d1, B:434:0x09de, B:435:0x09e9, B:437:0x09f6, B:438:0x09fa, B:440:0x0a0b, B:444:0x0a18, B:446:0x0a25, B:450:0x0a32, B:452:0x0a56, B:454:0x0a5c, B:456:0x0a64, B:457:0x0a6b, B:459:0x0a93, B:461:0x0a99, B:463:0x0aa1, B:464:0x0aa8, B:466:0x0ab9, B:468:0x0abf, B:470:0x0ac7, B:471:0x0acb, B:474:0x0add, B:488:0x070f, B:490:0x0715, B:492:0x071f, B:494:0x0725, B:496:0x072d, B:498:0x0733, B:500:0x073a, B:502:0x0744, B:504:0x074a, B:506:0x0752, B:508:0x0758, B:510:0x0766, B:512:0x076c, B:514:0x0774, B:516:0x077a, B:518:0x0782, B:519:0x0789, B:521:0x0795, B:523:0x079f, B:524:0x07a6, B:526:0x07ac, B:528:0x07b6, B:530:0x07bc, B:532:0x07c3, B:534:0x07cd, B:536:0x07d3, B:538:0x07e1, B:540:0x07e7, B:542:0x07ef, B:544:0x07f5, B:546:0x07fd, B:547:0x0804), top: B:343:0x065b }] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0af9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0e7a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0de5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0dc0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void OooO00o(java.lang.String r50, com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType r51, java.lang.String r52, android.os.Bundle r53) {
        /*
            Method dump skipped, instructions count: 3890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.performanceanalyse.OooOO0O.OooO00o(java.lang.String, com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType, java.lang.String, android.os.Bundle):void");
    }

    public final void OooO00o(String str, String str2, Bundle bundle, String str3, String str4) {
        String str5;
        Map<String, OooOO0> map;
        OooOO0 oooOO0;
        Map<String, OooOO0> map2;
        OooOO0 oooOO02;
        Map<String, OooOO0> map3;
        OooOO0 oooOO03;
        Map<String, OooOO0> map4;
        OooOO0 oooOO04;
        String str6;
        Map<String, OooOO0> map5;
        OooOO0 oooOO05;
        AppContext appContext;
        Map<String, OooOO0> map6;
        OooOO0 oooOO06;
        Map<String, Long> map7;
        TmcLogger.d("oldChain", "reportPage -> appId:" + str + ", pagePath:" + str2 + ", miniappId:" + str3 + ", reportPagePath:" + str4);
        try {
            OooO00o(str3);
            OooO00o(bundle, str3);
            try {
                com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO00o();
            } catch (Throwable th2) {
                TmcLogger.e("PointTrack", "tryInitAthena failed!", th2);
            }
            bundle.putString("object_id", "300");
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0 = this.OooO0Oo.get(str);
            if (oooO0O0 != null && (map6 = oooO0O0.OooO0o0) != null && (oooOO06 = map6.get(str2)) != null && (map7 = oooOO06.OooO0Oo) != null) {
                for (Map.Entry<String, Long> entry : map7.entrySet()) {
                    bundle.putLong("chain_id_" + ((Object) entry.getKey()), entry.getValue().longValue());
                }
            }
            bundle.putString(PointConstants.POINT_PAGE_PATH, str4);
            bundle.putString("open_page_status", "true");
            String str7 = null;
            if (str3 != null) {
                App findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str3);
                Context context = (findApp == null || (appContext = findApp.getAppContext()) == null) ? null : appContext.getContext();
                BaseActivity baseActivity = context instanceof BaseActivity ? (BaseActivity) context : null;
                bundle.putString(IntegrationConstants.IS_FOREGROUND, String.valueOf(baseActivity != null ? Boolean.valueOf(baseActivity.getMStarted()) : null));
            }
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02 = this.OooO0Oo.get(str);
            bundle.putInt("downloadFrameworkMode", oooO0O02 != null ? oooO0O02.OooO0o : -1);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O03 = this.OooO0Oo.get(str);
            String str8 = "";
            if (oooO0O03 == null || (map5 = oooO0O03.OooO0o0) == null || (oooOO05 = map5.get(str2)) == null || (str5 = oooOO05.OooO0o0) == null) {
                str5 = "";
            }
            bundle.putString("pageH5ProgressStatus", str5);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O04 = this.OooO0Oo.get(str);
            if (oooO0O04 != null && (map4 = oooO0O04.OooO0o0) != null && (oooOO04 = map4.get(str2)) != null && (str6 = oooOO04.OooO0o) != null) {
                str8 = str6;
            }
            bundle.putString("pageDomContentLoadedStatus", str8);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O05 = this.OooO0Oo.get(str);
            bundle.putInt("downloadAppMode", oooO0O05 != null ? oooO0O05.OooO0oO : -1);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O06 = this.OooO0Oo.get(str);
            bundle.putInt("zipFrameworkMode", oooO0O06 != null ? oooO0O06.OooO0oo : -1);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O07 = this.OooO0Oo.get(str);
            bundle.putInt("zipAppMode", oooO0O07 != null ? oooO0O07.OooO : -1);
            String str9 = "chain_id_" + ChainPoint.TotalCommunicationTime;
            ICommunicationTimeProxy iCommunicationTimeProxy = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O08 = this.OooO0Oo.get(str);
            bundle.putLong(str9, iCommunicationTimeProxy.getTotalTime((oooO0O08 == null || (map3 = oooO0O08.OooO0o0) == null || (oooOO03 = map3.get(str2)) == null) ? null : oooOO03.OooO0O0));
            String str10 = "chain_id_" + ChainPoint.TotalCommunicationNum;
            ICommunicationTimeProxy iCommunicationTimeProxy2 = (ICommunicationTimeProxy) TmcProxy.get(ICommunicationTimeProxy.class);
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O09 = this.OooO0Oo.get(str);
            bundle.putInt(str10, iCommunicationTimeProxy2.getTotalNum((oooO0O09 == null || (map2 = oooO0O09.OooO0o0) == null || (oooOO02 = map2.get(str2)) == null) ? null : oooOO02.OooO0O0));
            com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O010 = this.OooO0Oo.get(str);
            if (oooO0O010 != null && (map = oooO0O010.OooO0o0) != null && (oooOO0 = map.get(str2)) != null) {
                str7 = oooOO0.OooO0oO;
            }
            bundle.putString("navigationType", str7);
        } catch (Throwable unused) {
        }
    }

    public final void OooO0O0(Bundle bundle) {
        Map<String, OooOO0> map;
        OooOO0 oooOO0;
        try {
            String string = bundle.getString(ChainPoint.TYPE, "");
            String string2 = bundle.getString(ChainPoint.CHAIN_ID, "");
            if (this.OooO0Oo.containsKey(string2)) {
                if (Intrinsics.c("app", string)) {
                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O0 = this.OooO0Oo.get(string2);
                    if (oooO0O0 != null) {
                        if (bundle.containsKey(ChainPoint.DOWNLOAD_FRAMEWORK_MODE)) {
                            oooO0O0.OooO0o = bundle.getInt(ChainPoint.DOWNLOAD_FRAMEWORK_MODE, 0);
                        } else if (bundle.containsKey(ChainPoint.DOWNLOAD_APP_MODE)) {
                            oooO0O0.OooO0oO = bundle.getInt(ChainPoint.DOWNLOAD_APP_MODE, 0);
                        } else if (bundle.containsKey(ChainPoint.ZIP_FRAMEWORK_MODE)) {
                            oooO0O0.OooO0oo = bundle.getInt(ChainPoint.ZIP_FRAMEWORK_MODE, 0);
                        } else if (bundle.containsKey(ChainPoint.ZIP_APP_MODE)) {
                            oooO0O0.OooO = bundle.getInt(ChainPoint.ZIP_APP_MODE, 0);
                        } else if (bundle.containsKey(ChainPoint.APP_H5_PROGRESS_STATUS)) {
                            String string3 = bundle.getString(ChainPoint.APP_H5_PROGRESS_STATUS, "");
                            Intrinsics.g(string3, "bundle.getString(APP_H5_PROGRESS_STATUS, \"\")");
                            Intrinsics.h(string3, "<set-?>");
                            oooO0O0.OooOO0O = string3;
                        } else if (bundle.containsKey(ChainPoint.APP_DOMCONTENTLOADED_STATUS)) {
                            String string4 = bundle.getString(ChainPoint.APP_DOMCONTENTLOADED_STATUS, "");
                            Intrinsics.g(string4, "bundle.getString(APP_DOMCONTENTLOADED_STATUS, \"\")");
                            Intrinsics.h(string4, "<set-?>");
                            oooO0O0.OooOO0o = string4;
                        } else if (bundle.containsKey(ChainPoint.APP_OFF_SCREEN_RENDER)) {
                            oooO0O0.OooOOOO = bundle.getBoolean(ChainPoint.APP_OFF_SCREEN_RENDER, false);
                        }
                    }
                } else if (Intrinsics.c("page", string)) {
                    String string5 = bundle.getString(ChainPoint.PAGE_PATH, "");
                    com.cloud.tmc.miniapp.performanceanalyse.OooO0O0 oooO0O02 = this.OooO0Oo.get(string2);
                    if (oooO0O02 != null && (map = oooO0O02.OooO0o0) != null && (oooOO0 = map.get(string5)) != null) {
                        if (bundle.containsKey(ChainPoint.PAGE_H5_PROGRESS_STATUS)) {
                            String string6 = bundle.getString(ChainPoint.PAGE_H5_PROGRESS_STATUS, "");
                            Intrinsics.g(string6, "bundle.getString(PAGE_H5_PROGRESS_STATUS, \"\")");
                            Intrinsics.h(string6, "<set-?>");
                            oooOO0.OooO0o0 = string6;
                        } else if (bundle.containsKey(ChainPoint.PAGE_DOMCONTENTLOADED_STATUS)) {
                            String string7 = bundle.getString(ChainPoint.PAGE_DOMCONTENTLOADED_STATUS, "");
                            Intrinsics.g(string7, "bundle.getString(PAGE_DOMCONTENTLOADED_STATUS, \"\")");
                            Intrinsics.h(string7, "<set-?>");
                            oooOO0.OooO0o = string7;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e("chainInsert fail:" + th2);
        }
    }
}
