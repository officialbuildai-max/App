package com.cloud.tmc.integration.bridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.cloud.tmc.integration.LauncherMMkvStorageHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcParams;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.integration.utils.DisplayUtils;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.integration.utils.MccMncUtils;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.launcherlib.LauncherFrameworkConstants;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniutils.util.ConvertUtils;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.PathUtils;
import com.cloud.tmc.miniutils.util.SDCardUtils;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Locale;

/* loaded from: classes3.dex */
public class GetSystemInfoBridge implements BridgeExtension {
    private static final String TAG = "GetSystemInfoBridge";
    private boolean mBatteryBroadcastRegistered = false;
    private int mCachedBatteryPercentage;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class BatteryBroadcastReceiver extends BroadcastReceiver {
        private BatteryBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int parseBatteryPercentage = GetSystemInfoBridge.this.parseBatteryPercentage(intent);
            if (parseBatteryPercentage > 0) {
                GetSystemInfoBridge.this.mCachedBatteryPercentage = parseBatteryPercentage;
            }
            GetSystemInfoBridge.this.mBatteryBroadcastRegistered = false;
            context.unregisterReceiver(this);
            TmcLogger.d(GetSystemInfoBridge.TAG, "ACTION_BATTERY_CHANGED..." + GetSystemInfoBridge.this.mCachedBatteryPercentage);
        }
    }

    private int getCurrentBatteryPercentage(Context context) {
        if (this.mBatteryBroadcastRegistered) {
            return this.mCachedBatteryPercentage;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            Intent registerReceiver = context.registerReceiver(new BatteryBroadcastReceiver(), intentFilter);
            this.mBatteryBroadcastRegistered = true;
            int parseBatteryPercentage = parseBatteryPercentage(registerReceiver);
            if (parseBatteryPercentage > 0) {
                this.mCachedBatteryPercentage = parseBatteryPercentage;
            }
            return this.mCachedBatteryPercentage;
        } catch (Exception e11) {
            TmcLogger.e("getCurrentBatteryPercentage...e=" + e11);
            return this.mCachedBatteryPercentage;
        }
    }

    private int getHeight(Page page, Activity activity, float f11, DisplayMetrics displayMetrics) {
        IRender render;
        int round = displayMetrics != null ? Math.round((displayMetrics.heightPixels - DisplayUtils.getTitleAndStatusBarHeight(activity)) / f11) : 0;
        if (page == null || (render = page.getRender()) == null || render.getView() == null) {
            return round;
        }
        int round2 = render.getView() != null ? Math.round(render.getView().getHeight() / f11) : 0;
        return round2 > 0 ? round2 : round;
    }

    private static String getInternalMemorySize() {
        return ConvertUtils.byte2FitMemorySize(SDCardUtils.getInternalTotalSize(), 2);
    }

    private JsonObject getSystemInfoInner(Context context, App app, Page page) {
        float f11;
        int i11;
        JsonObject jsonObject = new JsonObject();
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Activity activity = (Activity) app.getAppContext().getContext();
        if (displayMetrics != null) {
            f11 = displayMetrics.density;
            i11 = Math.round(displayMetrics.widthPixels / f11);
            jsonObject.addProperty("screenWidth", Integer.valueOf(displayMetrics.widthPixels));
            jsonObject.addProperty("screenHeight", Integer.valueOf(displayMetrics.heightPixels));
        } else {
            f11 = 0.0f;
            i11 = 0;
        }
        jsonObject.addProperty(TmcConstants.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        jsonObject.addProperty("model", Build.MANUFACTURER + " " + Build.MODEL);
        jsonObject.addProperty("pixelRatio", Float.valueOf(f11));
        jsonObject.addProperty("windowWidth", Integer.valueOf(i11));
        jsonObject.addProperty("windowHeight", Integer.valueOf(getHeight(page, activity, f11, displayMetrics)));
        jsonObject.addProperty("system", Build.VERSION.RELEASE);
        jsonObject.addProperty(TrackingKey.PLATFORM, "Android");
        jsonObject.addProperty("apiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
        jsonObject.addProperty(PlaceTypes.STORAGE, getInternalMemorySize());
        jsonObject.addProperty("currentBattery", getCurrentBatteryPercentage(context) + "%");
        jsonObject.addProperty("brand", Build.BRAND);
        String frameworkVersion = ((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getFrameworkVersion();
        if (!TextUtils.isEmpty(frameworkVersion)) {
            jsonObject.addProperty("frameworkversion", frameworkVersion);
        }
        jsonObject.addProperty("packageName", context.getPackageName());
        jsonObject.addProperty("gaId", DeviceUtil.getGAId());
        jsonObject.addProperty("GAId", DeviceUtil.getGAId());
        jsonObject.addProperty("mcc", MccMncUtils.getMcc(context));
        jsonObject.addProperty(PlaceTypes.COUNTRY, Locale.getDefault().getCountry());
        jsonObject.addProperty("sdkVersion", ((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getSDKVersion());
        jsonObject.addProperty("brandVersion", ((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getSDKVersion());
        try {
            jsonObject.addProperty("statusBarHeight", Integer.valueOf(MiniBarUtils.getStatusHeight()));
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
        try {
            jsonObject.addProperty("isRtl", Boolean.valueOf(resources.getConfiguration().getLayoutDirection() == 1));
        } catch (Throwable th3) {
            TmcLogger.e(TAG, th3);
        }
        jsonObject.addProperty(TmcParams.CAPSULE_HEIGHT, Integer.valueOf(page.getIntValue(TmcParams.CAPSULE_HEIGHT)));
        jsonObject.addProperty(TmcParams.CAPSULE_WIDTH, Integer.valueOf(page.getIntValue(TmcParams.CAPSULE_WIDTH)));
        jsonObject.addProperty(TmcParams.CAPSULE_TRANSLATION_X, Integer.valueOf(page.getIntValue(TmcParams.CAPSULE_TRANSLATION_X)));
        jsonObject.addProperty(TmcParams.CAPSULE_TRANSLATION_Y, Integer.valueOf(page.getIntValue(TmcParams.CAPSULE_TRANSLATION_Y)));
        return jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int parseBatteryPercentage(Intent intent) {
        if (!"android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            return -1;
        }
        return (intent.getIntExtra(PermissionConstant.level, 0) * 100) / intent.getIntExtra("scale", 100);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void clearSharpNewsCommonData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            if (app == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            AppContext appContext = app.getAppContext();
            if (appContext == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                }
            } else {
                TmcLogger.d(TAG, "clearSharpNewsSyncData");
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).clear(context, TmcConstants.SHARP_NEWS_SYNC_DATA_STORAGE);
                if (bridgeCallback != null) {
                    bridgeCallback.sendSuccessResponse();
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "clearSharpNewsSyncData error", th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void getByteAppRecommendList(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("recommendList", "").build());
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void getCountryByIso(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        String countryCodeBySim = MccMncUtils.getCountryCodeBySim(app.getAppContext().getContext());
        TmcLogger.d(TAG, "countryCode:  " + countryCodeBySim);
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("countryCode", countryCodeBySim).build());
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void getCountryInfo(@BindingNode(App.class) App app, @BindingParam({"type"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        String str2;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        Context context = app.getAppContext().getContext();
        String mcc = MccMncUtils.getMcc(context);
        String mnc = MccMncUtils.getMnc(context);
        String str3 = TmcConstants.KEY_SIM;
        if (TmcConstants.KEY_SIM.equalsIgnoreCase(str)) {
            str2 = MccMncUtils.getCountryCodeBySim(context);
        } else {
            if (TmcConstants.KEY_LANGUAGE.equalsIgnoreCase(str)) {
                str2 = MccMncUtils.getCountryCodeByLang(context);
            } else {
                String countryCodeBySim = MccMncUtils.getCountryCodeBySim(context);
                if (TextUtils.isEmpty(countryCodeBySim)) {
                    str2 = MccMncUtils.getCountryCodeByLang(context);
                } else {
                    str2 = countryCodeBySim;
                }
            }
            str3 = TmcConstants.KEY_LANGUAGE;
        }
        TmcLogger.d(TAG, "CountryCode: " + str2 + " Mcc: " + mcc + " Mnc: " + mnc);
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("countryCode", str2).addProperty("mcc", mcc).addProperty("mnc", mnc).addProperty(EventConstants.KEY_SOURCE, str3).build());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0053, code lost:
    
        r5.sendFailResponse();
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getMiniappResumedStatus(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r4, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r5) {
        /*
            r3 = this;
            java.lang.String r0 = "GetSystemInfoBridge"
            if (r4 == 0) goto L51
            com.cloud.tmc.integration.structure.AppContext r1 = r4.getAppContext()     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L51
            com.cloud.tmc.integration.structure.AppContext r1 = r4.getAppContext()     // Catch: java.lang.Throwable -> L4b
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L4b
            if (r1 != 0) goto L15
            goto L51
        L15:
            com.cloud.tmc.integration.callback.ICheckMiniAppLifecycleCallback r4 = r4.getAppLifecycleCallback()     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L4d
            if (r5 == 0) goto L5d
            boolean r4 = r4.checkIsForeground()     // Catch: java.lang.Throwable -> L4b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r1.<init>()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "isResumed -> "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4b
            r1.append(r4)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4b
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r1)     // Catch: java.lang.Throwable -> L4b
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r1 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "isResumed"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L4b
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r4 = r1.addProperty(r2, r4)     // Catch: java.lang.Throwable -> L4b
            com.google.gson.JsonObject r4 = r4.build()     // Catch: java.lang.Throwable -> L4b
            r5.sendSuccessResponse(r4)     // Catch: java.lang.Throwable -> L4b
            goto L5d
        L4b:
            r4 = move-exception
            goto L57
        L4d:
            r5.sendFailResponse()     // Catch: java.lang.Throwable -> L4b
            goto L5d
        L51:
            if (r5 == 0) goto L5d
            r5.sendFailResponse()     // Catch: java.lang.Throwable -> L4b
            goto L5d
        L57:
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r4)
            r5.sendFailResponse()
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.GetSystemInfoBridge.getMiniappResumedStatus(com.cloud.tmc.integration.structure.App, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void getNewsOptionPopShow(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        AppContext appContext = app.getAppContext();
        if (appContext == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (appContext.getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        LauncherMMkvStorageHelper launcherMMkvStorageHelper = LauncherMMkvStorageHelper.INSTANCE;
        boolean newsOptionPopShow = launcherMMkvStorageHelper.getNewsOptionPopShow();
        TmcLogger.d(TAG, "getNewsOptionPopShow:" + newsOptionPopShow);
        String selectLanguage = launcherMMkvStorageHelper.getSelectLanguage();
        TmcLogger.d(TAG, "getSelectLanguage:" + selectLanguage);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("isShow", Boolean.valueOf(newsOptionPopShow));
        jsonObject.addProperty("selectLanguage", selectLanguage);
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0027, code lost:
    
        r4.sendFailResponse();
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getOdId(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r3, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L25
            com.cloud.tmc.integration.structure.AppContext r0 = r3.getAppContext()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L25
            com.cloud.tmc.integration.structure.AppContext r3 = r3.getAppContext()     // Catch: java.lang.Throwable -> L2b
            android.content.Context r3 = r3.getContext()     // Catch: java.lang.Throwable -> L2b
            if (r3 != 0) goto L13
            goto L25
        L13:
            com.google.gson.JsonObject r3 = new com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L2b
            r3.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = "odId"
            java.lang.String r1 = ""
            r3.addProperty(r0, r1)     // Catch: java.lang.Throwable -> L2b
            if (r4 == 0) goto L30
            r4.sendSuccessResponse(r3)     // Catch: java.lang.Throwable -> L2b
            goto L30
        L25:
            if (r4 == 0) goto L30
            r4.sendFailResponse()     // Catch: java.lang.Throwable -> L2b
            goto L30
        L2b:
            if (r4 == 0) goto L30
            r4.sendFailResponse()
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.GetSystemInfoBridge.getOdId(com.cloud.tmc.integration.structure.App, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void getOneId(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(app.getAppContext().getContext(), LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, TmcConstants.ATHENA_VAID);
        if (TextUtils.isEmpty(string)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("oneId", string);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public void getSdCardDownloadPath(@BindingCallback BridgeCallback bridgeCallback) {
        String externalDownloadsPath = PathUtils.getExternalDownloadsPath();
        TmcLogger.d(TAG, "getSdCardDownloadPath: " + externalDownloadsPath);
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("sdCardPath", externalDownloadsPath).build());
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public void getSdCardPath(@BindingCallback BridgeCallback bridgeCallback) {
        String externalStoragePath = PathUtils.getExternalStoragePath();
        TmcLogger.d(TAG, "getSdCardPath: " + externalStoragePath);
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("sdCardPath", externalStoragePath).build());
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void getSelectLanguage(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        AppContext appContext = app.getAppContext();
        if (appContext == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (appContext.getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        String selectLanguage = LauncherMMkvStorageHelper.INSTANCE.getSelectLanguage();
        TmcLogger.d(TAG, "from selectLanguage:" + selectLanguage);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("selectLanguage", selectLanguage);
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void getSharpNewsCommonData(@BindingNode(App.class) App app, @BindingParam({"syncKey"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            if (app == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            AppContext appContext = app.getAppContext();
            if (appContext == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            JsonObject build = JsonObjectUtils.create().addProperty("syncData", ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, TmcConstants.SHARP_NEWS_SYNC_DATA_STORAGE, str)).build();
            TmcLogger.d(TAG, "getSharpNewsSyncData" + build.toString());
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(build);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "getSharpNewsSyncData error", th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void getSharpNewsConfigToH5(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        AppContext appContext = app.getAppContext();
        if (appContext == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else if (appContext.getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            boolean configTargetBool = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_SHARP_NEWS_VIDEO, true);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(MBridgeConstans.NATIVE_VIDEO_SUPPORT, Boolean.valueOf(configTargetBool));
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void getSystemInfo(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingParam(booleanDefault = true, value = {"needCache"}) boolean z10) {
        TmcLogger.d(TAG, "getSystemInfo");
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        JsonObject systemInfoInner = getSystemInfoInner(app.getAppContext().getContext(), app, page);
        TmcLogger.e(TAG, "getSystemInfo  " + GsonUtils.toJson(systemInfoInner));
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(systemInfoInner);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void getSystemInfoAsync(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingParam(booleanDefault = true, value = {"needCache"}) boolean z10) {
        getSystemInfo(app, page, bridgeCallback, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0039, code lost:
    
        r4.sendFailResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:?, code lost:
    
        return;
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getUniqueId(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r3, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L37
            com.cloud.tmc.integration.structure.AppContext r0 = r3.getAppContext()     // Catch: java.lang.Throwable -> L3d
            if (r0 == 0) goto L37
            com.cloud.tmc.integration.structure.AppContext r0 = r3.getAppContext()     // Catch: java.lang.Throwable -> L3d
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Throwable -> L3d
            if (r0 != 0) goto L13
            goto L37
        L13:
            java.lang.String r0 = com.cloud.tmc.integration.utils.DeviceUtil.getGAId()     // Catch: java.lang.Throwable -> L3d
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L2a
            java.lang.String r3 = "GetSystemInfoBridge"
            java.lang.String r0 = "bridiegAPI getUniqueId fail: gaid is empty"
            com.cloud.tmc.kernel.log.TmcLogger.e(r3, r0)     // Catch: java.lang.Throwable -> L3d
            if (r4 == 0) goto L29
            r4.sendFailResponse()     // Catch: java.lang.Throwable -> L3d
        L29:
            return
        L2a:
            java.lang.String r3 = r3.getAppId()     // Catch: java.lang.Throwable -> L3d
            com.cloud.tmc.integration.bridge.GetSystemInfoBridge$1 r1 = new com.cloud.tmc.integration.bridge.GetSystemInfoBridge$1     // Catch: java.lang.Throwable -> L3d
            r1.<init>()     // Catch: java.lang.Throwable -> L3d
            com.cloud.tmc.integration.utils.MiniRequestUtils.getUniqueId(r0, r3, r1)     // Catch: java.lang.Throwable -> L3d
            goto L42
        L37:
            if (r4 == 0) goto L42
            r4.sendFailResponse()     // Catch: java.lang.Throwable -> L3d
            goto L42
        L3d:
            if (r4 == 0) goto L42
            r4.sendFailResponse()
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.GetSystemInfoBridge.getUniqueId(com.cloud.tmc.integration.structure.App, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void putNewsOptionPopShow(@BindingNode(App.class) App app, @BindingParam(booleanDefault = true, value = {"showStatus"}) boolean z10, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        AppContext appContext = app.getAppContext();
        if (appContext == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            if (appContext.getContext() == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            LauncherMMkvStorageHelper.INSTANCE.putNewsOptionPopShow(z10);
            TmcLogger.d(TAG, "putNewsOptionPopShow:" + z10);
            JsonObject jsonObject = new JsonObject();
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void putSelectLanguage(@BindingNode(App.class) App app, @BindingParam(stringDefault = "", value = {"selectLanguage"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        AppContext appContext = app.getAppContext();
        if (appContext == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            if (appContext.getContext() == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            LauncherMMkvStorageHelper.INSTANCE.putSelectLanguage(str);
            TmcLogger.d(TAG, "from putSelectLanguage:" + str);
            JsonObject jsonObject = new JsonObject();
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void removeSharpNewsCommonData(@BindingNode(App.class) App app, @BindingParam({"syncKey"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            if (app == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            AppContext appContext = app.getAppContext();
            if (appContext == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            TmcLogger.d(TAG, "removeSharpNewsSyncDatakey:-> " + str);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).remove(context, TmcConstants.SHARP_NEWS_SYNC_DATA_STORAGE, str);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "removeSharpNewsSyncData error", th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void updateSharpNewsCommonData(@BindingNode(App.class) App app, @BindingParam({"syncKey"}) String str, @BindingParam({"syncData"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            if (app == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            AppContext appContext = app.getAppContext();
            if (appContext == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            TmcLogger.d(TAG, "updateSharpNewsSyncDatakey:-> " + str + "syncData:-> " + str2);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, TmcConstants.SHARP_NEWS_SYNC_DATA_STORAGE, str, str2);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "updateSharpNewsSyncData error", th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }
    }
}
