package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.launcherlib.LauncherFrameworkConstants;
import com.cloud.tmc.miniapp.ui.AppBrandProfileActivity;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AppManagerDataProviderBridge implements BridgeExtension {
    public final String OooO00o = "AppManagerDataProviderBridge";
    public final String OooO0O0 = "appList";

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changeAutoUpdateStatus(@BindingNode(App.class) App app, @BindingParam({"status"}) boolean z10, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_AUTO_UPDATE_STATUS, z10);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changeMiniappPermission(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String miniappId, @BindingParam({"scopeName"}) String scopeName, @BindingParam({"status"}) boolean z10, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        Intrinsics.h(miniappId, "miniappId");
        Intrinsics.h(scopeName, "scopeName");
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ScopeUtils.OooO00o.OooO00o(context, scopeName, miniappId, z10, "", "", false, true);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changeMsgSwitchStatus(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String miniappId, @BindingParam({"appSwitchStatus"}) String appSwitchStatus, @BindingCallback BridgeCallback bridgeCallback) {
        AppContext appContext;
        Context context;
        Unit unit;
        Intrinsics.h(miniappId, "miniappId");
        Intrinsics.h(appSwitchStatus, "appSwitchStatus");
        if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
            com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO00o(context, miniappId, appSwitchStatus);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changePrefetchState(@BindingNode(App.class) App app, @BindingParam({"status"}) int i11, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_PREFETCH_STATE, i11);
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_PREFETCH_TIMESTAMP, System.currentTimeMillis());
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void changeTotalMsgStatus(@BindingNode(App.class) App app, @BindingParam({"mainSwitchStatus"}) String status, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(status, "status");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("mainSwitchStatus", status);
            jsonObject.addProperty("mainSwitchTimestamp", String.valueOf(System.currentTimeMillis()));
            TmcLogger.d(this.OooO00o, "changeTotalMsgStatus: " + jsonObject);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "mainMsgSwitch", jsonObject.toString());
            callback.sendSuccessResponse();
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void clearAllMiniAppCacheData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            FileUtil.INSTANCE.clearAllMiniAppCacheData(context);
            callback.sendSuccessResponse(new JsonObject());
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void clearAllMiniAppData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            FileUtil.INSTANCE.clearAllMiniAppData(context);
            callback.sendSuccessResponse(new JsonObject());
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void clearCacheMsgData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    TmcLogger.d(this.OooO00o, "clearCacheMsgData");
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).clear(context, "miniMsgCacheData");
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void clearChangedMsgSwitchList(@BindingNode(App.class) App app, @BindingParam({"timestamp"}) long j11, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO00o(context, j11);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getAutoUpdateStatus(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    boolean z10 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_AUTO_UPDATE_STATUS, false);
                    if (bridgeCallback != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, Boolean.valueOf(z10));
                        bridgeCallback.sendSuccessResponse(jsonObject);
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getCacheMsgData(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonArray jsonArray = new JsonArray();
                    KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
                    String[] mMKVFileAllKeys = kVStorageProxy.getMMKVFileAllKeys(context, "miniMsgCacheData");
                    Intrinsics.g(mMKVFileAllKeys, "storageProxy.getMMKVFile…vider.KEY_MSG_CACHE_DATA)");
                    Iterator it = ArraysKt.B0(mMKVFileAllKeys).iterator();
                    while (it.hasNext()) {
                        jsonArray.add((JsonObject) JsonUtil.INSTANCE.fromJson(kVStorageProxy.getString(context, "miniMsgCacheData", (String) it.next()), JsonObject.class));
                    }
                    String jsonElement = jsonArray.toString();
                    Intrinsics.g(jsonElement, "msgDataArray.toString()");
                    TmcLogger.d(this.OooO00o, "getCacheMsgData msgCacheObj = " + jsonElement);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("msgData", jsonElement).build());
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getChangedMsgSwitchList(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonArray OooO0O0 = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO0O0(context);
                    if (bridgeCallback != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.add(this.OooO0O0, OooO0O0);
                        bridgeCallback.sendSuccessResponse(jsonObject);
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getLatestAppListMsgSwitch(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        AppContext appContext;
        Context context;
        if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
            JsonArray jsonArray = new JsonArray();
            List<AppStoreInfo> latestUseApps = LatestUseUtils.getLatestUseApps();
            Unit unit = null;
            if (latestUseApps != null) {
                Intrinsics.g(latestUseApps, "getLatestUseApps()");
                for (AppStoreInfo appStoreInfo : latestUseApps) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty(TmcConstants.KEY_MINI_APPID, appStoreInfo.getAppId());
                    jsonObject.addProperty("miniappName", appStoreInfo.getName());
                    jsonObject.addProperty("miniappLogo", appStoreInfo.getLogo());
                    com.cloud.tmc.miniapp.utils.OooO0o oooO0o = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o;
                    String appId = appStoreInfo.getAppId();
                    if (appId == null) {
                        appId = "";
                    }
                    String OooO0O0 = oooO0o.OooO0O0(context, appId);
                    if (OooO0O0.length() > 0) {
                        JsonObject jsonObject2 = (JsonObject) GsonUtils.fromJson(OooO0O0, JsonObject.class);
                        JsonElement jsonElement = jsonObject2.get("appSwitchStatus");
                        String asString = jsonElement != null ? jsonElement.getAsString() : null;
                        if (asString == null) {
                            asString = "";
                        }
                        jsonObject.addProperty("appSwitchStatus", asString);
                        JsonElement jsonElement2 = jsonObject2.get("appSwitchTimestamp");
                        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                        jsonObject.addProperty("appSwitchTimestamp", asString2 != null ? asString2 : "");
                    }
                    jsonArray.add(jsonObject);
                }
            }
            TmcLogger.d(this.OooO00o, jsonArray.toString());
            if (bridgeCallback != null) {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.add(this.OooO0O0, jsonArray);
                bridgeCallback.sendSuccessResponse(jsonObject3);
                unit = Unit.f67184a;
            }
            if (unit != null) {
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMiniAppCacheSize(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String appId, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long miniAppCacheSize = FileUtil.getMiniAppCacheSize(context, appId);
            TmcLogger.d(this.OooO00o, "getMiniAppCacheSize: " + miniAppCacheSize);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("cacheSize", Long.valueOf(miniAppCacheSize));
            callback.sendSuccessResponse(jsonObject);
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMiniAppFileSize(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String appId, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long miniAppFileSize = FileUtil.getMiniAppFileSize(context, appId);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalSize", Long.valueOf(miniAppFileSize));
            callback.sendSuccessResponse(jsonObject);
            TmcLogger.d(this.OooO00o, "getMiniAppFileSize: " + miniAppFileSize);
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMiniAppTotalCacheSize(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String appId, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long allMiniAppCacheSize = FileUtil.getAllMiniAppCacheSize(context);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalCacheSize", Long.valueOf(allMiniAppCacheSize));
            callback.sendSuccessResponse(jsonObject);
            TmcLogger.d(this.OooO00o, "getAllMiniAppCacheSize: " + allMiniAppCacheSize);
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMiniAppTotalSize(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long allMiniAppFileSize = FileUtil.getAllMiniAppFileSize(context);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalSize", Long.valueOf(allMiniAppFileSize));
            callback.sendSuccessResponse(jsonObject);
            TmcLogger.d(this.OooO00o, "getMiniAppTotalSize: " + allMiniAppFileSize);
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @com.cloud.tmc.kernel.annotation.ActionFilter("")
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void getMiniappPermissionList(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r6, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"miniappId"}) java.lang.String r7, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r8) {
        /*
            r5 = this;
            java.lang.String r0 = "miniappId"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            if (r6 == 0) goto Lc6
            com.cloud.tmc.integration.structure.AppContext r6 = r6.getAppContext()     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto Lc6
            android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto Lc6
            com.cloud.tmc.miniapp.utils.ScopeUtils r0 = com.cloud.tmc.miniapp.utils.ScopeUtils.OooO00o     // Catch: java.lang.Throwable -> L4e
            java.lang.String r6 = r0.OooO0O0(r6, r7)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = r5.OooO00o     // Catch: java.lang.Throwable -> L4e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r0.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = "permissionMiniappScopeData: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L4e
            r0.append(r6)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r0)     // Catch: java.lang.Throwable -> L4e
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r0 = "isAuthorized"
            if (r7 != 0) goto L51
            if (r8 == 0) goto Lc3
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L4e
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r0, r7)     // Catch: java.lang.Throwable -> L4e
            com.google.gson.JsonObject r6 = r6.build()     // Catch: java.lang.Throwable -> L4e
            r8.sendSuccessResponse(r6)     // Catch: java.lang.Throwable -> L4e
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L4e
            goto Lc4
        L4e:
            r6 = move-exception
            goto Lce
        L51:
            com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge$getMiniappPermissionList$1$authList$1 r7 = new com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge$getMiniappPermissionList$1$authList$1     // Catch: java.lang.Throwable -> L66
            r7.<init>()     // Catch: java.lang.Throwable -> L66
            java.lang.reflect.Type r7 = r7.getType()     // Catch: java.lang.Throwable -> L66
            java.lang.Object r6 = com.cloud.tmc.miniutils.util.GsonUtils.fromJson(r6, r7)     // Catch: java.lang.Throwable -> L66
            java.lang.String r7 = "{\n                      …  )\n                    }"
            kotlin.jvm.internal.Intrinsics.g(r6, r7)     // Catch: java.lang.Throwable -> L66
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L66
            goto L6b
        L66:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
            r6.<init>()     // Catch: java.lang.Throwable -> L4e
        L6b:
            java.util.Iterator r7 = r6.iterator()     // Catch: java.lang.Throwable -> L4e
        L6f:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L8d
            java.lang.Object r1 = r7.next()     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.integration.model.PermissionInfoModel r1 = (com.cloud.tmc.integration.model.PermissionInfoModel) r1     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.miniapp.utils.ScopeUtils r2 = com.cloud.tmc.miniapp.utils.ScopeUtils.OooO00o     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = r1.getScopeName()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r4 = r1.getScopeName()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = r2.OooO0O0(r3, r4)     // Catch: java.lang.Throwable -> L4e
            r1.setScopeDescription(r2)     // Catch: java.lang.Throwable -> L4e
            goto L6f
        L8d:
            java.lang.String r6 = com.cloud.tmc.kernel.utils.TmcGsonUtilsKt.toJson(r6)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = r5.OooO00o     // Catch: java.lang.Throwable -> L4e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r1.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "miniScopeData:-> "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4e
            r1.append(r6)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r1)     // Catch: java.lang.Throwable -> L4e
            if (r8 == 0) goto Lc3
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r7 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L4e
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r7 = r7.addProperty(r0, r1)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r0 = "permissionList"
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r7.addProperty(r0, r6)     // Catch: java.lang.Throwable -> L4e
            com.google.gson.JsonObject r6 = r6.build()     // Catch: java.lang.Throwable -> L4e
            r8.sendSuccessResponse(r6)     // Catch: java.lang.Throwable -> L4e
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L4e
            goto Lc4
        Lc3:
            r6 = 0
        Lc4:
            if (r6 != 0) goto Ld8
        Lc6:
            if (r8 == 0) goto Ld8
            r8.sendFailResponse()     // Catch: java.lang.Throwable -> L4e
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L4e
            goto Ld8
        Lce:
            java.lang.String r7 = r5.OooO00o
            com.cloud.tmc.kernel.log.TmcLogger.e(r7, r6)
            if (r8 == 0) goto Ld8
            r8.sendFailResponse()
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge.getMiniappPermissionList(com.cloud.tmc.integration.structure.App, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMsgListInfo(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "MsgListData");
            TmcLogger.d(this.OooO00o, "getMsgListInfo: " + string);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("msgList", string);
            callback.sendSuccessResponse(jsonObject);
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMsgSwitchStatus(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String miniappId, @BindingCallback BridgeCallback callback) {
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(miniappId, "miniappId");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        Unit unit = null;
        unit = null;
        if (appContext != null && (context = appContext.getContext()) != null) {
            JsonObject jsonObject = new JsonObject();
            String OooO0O0 = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO0O0(context, miniappId);
            if (OooO0O0.length() > 0) {
                JsonObject jsonObject2 = (JsonObject) GsonUtils.fromJson(OooO0O0, JsonObject.class);
                JsonElement jsonElement = jsonObject2.get("appSwitchStatus");
                String asString = jsonElement != null ? jsonElement.getAsString() : null;
                String str = "";
                if (asString == null) {
                    asString = "";
                } else {
                    Intrinsics.g(asString, "msgProvider[MiniappMsgDa…H_STATUS]?.asString ?: \"\"");
                }
                jsonObject.addProperty("appSwitchStatus", asString);
                JsonElement jsonElement2 = jsonObject2.get("appSwitchTimestamp");
                String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                if (asString2 != null) {
                    Intrinsics.g(asString2, "msgProvider[MiniappMsgDa…IMESTAMP]?.asString ?: \"\"");
                    str = asString2;
                }
                jsonObject.addProperty("appSwitchTimestamp", str);
            }
            callback.sendSuccessResponse(jsonObject);
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getMsgWithReadStatusListInfo(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "MsgListWithReadStatusData");
            TmcLogger.d(this.OooO00o, "getMsgWithReadStatusListInfo: " + string);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("msgList", string);
            callback.sendSuccessResponse(jsonObject);
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @com.cloud.tmc.kernel.annotation.ActionFilter("")
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void getPermissionStatus(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r6, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"miniappId"}) java.lang.String r7, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"scopeName"}) java.lang.String r8, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r9) {
        /*
            r5 = this;
            java.lang.String r0 = "miniappId"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            java.lang.String r0 = "scopeName"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            if (r6 == 0) goto Lf4
            com.cloud.tmc.integration.structure.AppContext r6 = r6.getAppContext()     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto Lf4
            android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto Lf4
            com.cloud.tmc.miniapp.utils.ScopeUtils r1 = com.cloud.tmc.miniapp.utils.ScopeUtils.OooO00o     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = r1.OooO0O0(r6, r7)     // Catch: java.lang.Throwable -> L4d
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L4d
            r2 = 0
            java.lang.String r3 = "scopeDescription"
            java.lang.String r4 = "isAuthorized"
            if (r7 != 0) goto L50
            if (r9 == 0) goto Lf2
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L4d
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r4, r7)     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r0, r8)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r7 = r1.OooO0O0(r8, r8)     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r3, r7)     // Catch: java.lang.Throwable -> L4d
            com.google.gson.JsonObject r6 = r6.build()     // Catch: java.lang.Throwable -> L4d
            r9.sendSuccessResponse(r6)     // Catch: java.lang.Throwable -> L4d
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L4d
        L4a:
            r2 = r6
            goto Lf2
        L4d:
            r6 = move-exception
            goto Lfc
        L50:
            com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge$getPermissionStatus$1$authList$1 r7 = new com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge$getPermissionStatus$1$authList$1     // Catch: java.lang.Throwable -> L65
            r7.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.reflect.Type r7 = r7.getType()     // Catch: java.lang.Throwable -> L65
            java.lang.Object r6 = com.cloud.tmc.miniutils.util.GsonUtils.fromJson(r6, r7)     // Catch: java.lang.Throwable -> L65
            java.lang.String r7 = "{\n                      …  )\n                    }"
            kotlin.jvm.internal.Intrinsics.g(r6, r7)     // Catch: java.lang.Throwable -> L65
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L65
            goto L6a
        L65:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4d
            r6.<init>()     // Catch: java.lang.Throwable -> L4d
        L6a:
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L4d
        L6e:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> L4d
            if (r7 == 0) goto L86
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L4d
            r1 = r7
            com.cloud.tmc.integration.model.PermissionInfoModel r1 = (com.cloud.tmc.integration.model.PermissionInfoModel) r1     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = r1.getScopeName()     // Catch: java.lang.Throwable -> L4d
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r8)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L6e
            goto L87
        L86:
            r7 = r2
        L87:
            com.cloud.tmc.integration.model.PermissionInfoModel r7 = (com.cloud.tmc.integration.model.PermissionInfoModel) r7     // Catch: java.lang.Throwable -> L4d
            if (r7 != 0) goto Laf
            if (r9 == 0) goto Lf2
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L4d
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r4, r7)     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r0, r8)     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.miniapp.utils.ScopeUtils r7 = com.cloud.tmc.miniapp.utils.ScopeUtils.OooO00o     // Catch: java.lang.Throwable -> L4d
            java.lang.String r7 = r7.OooO0O0(r8, r8)     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r3, r7)     // Catch: java.lang.Throwable -> L4d
            com.google.gson.JsonObject r6 = r6.build()     // Catch: java.lang.Throwable -> L4d
            r9.sendSuccessResponse(r6)     // Catch: java.lang.Throwable -> L4d
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L4d
            goto L4a
        Laf:
            if (r9 == 0) goto Lf2
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L4d
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r4, r1)     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r0, r8)     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.miniapp.utils.ScopeUtils r0 = com.cloud.tmc.miniapp.utils.ScopeUtils.OooO00o     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = r0.OooO0O0(r8, r8)     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r3, r8)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "authStatus"
            java.lang.Boolean r0 = r7.getAuthStatus()     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r8, r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "authTimeStamp"
            java.lang.Long r0 = r7.getAuthTimeStamp()     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r8, r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "validityTime"
            java.lang.Long r7 = r7.getValidityTime()     // Catch: java.lang.Throwable -> L4d
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r8, r7)     // Catch: java.lang.Throwable -> L4d
            com.google.gson.JsonObject r6 = r6.build()     // Catch: java.lang.Throwable -> L4d
            r9.sendSuccessResponse(r6)     // Catch: java.lang.Throwable -> L4d
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L4d
            goto L4a
        Lf2:
            if (r2 != 0) goto L106
        Lf4:
            if (r9 == 0) goto L106
            r9.sendFailResponse()     // Catch: java.lang.Throwable -> L4d
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L4d
            goto L106
        Lfc:
            java.lang.String r7 = r5.OooO00o
            com.cloud.tmc.kernel.log.TmcLogger.e(r7, r6)
            if (r9 == 0) goto L106
            r9.sendFailResponse()
        L106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge.getPermissionStatus(com.cloud.tmc.integration.structure.App, java.lang.String, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getPrefetchState(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    int i11 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getInt(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_PREFETCH_STATE);
                    long j11 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, LauncherFrameworkConstants.KEY_MINI_PREFETCH_TIMESTAMP);
                    if (bridgeCallback != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i11));
                        jsonObject.addProperty(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(j11));
                        bridgeCallback.sendSuccessResponse(jsonObject);
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getTotalMsgStatus(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String str;
        Context context;
        Object obj;
        String string;
        str = "";
        Intrinsics.h(app, "app");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext != null && (context = appContext.getContext()) != null) {
            try {
                Intrinsics.h(context, "context");
                try {
                    string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "mainMsgSwitch");
                } catch (Throwable unused) {
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
            }
            if (string != null && string.length() > 0) {
                JsonObject jsonObject = (JsonObject) GsonUtils.fromJson(string, JsonObject.class);
                JsonElement jsonElement = jsonObject.get("mainSwitchStatus");
                Object asString = jsonElement != null ? jsonElement.getAsString() : null;
                if (asString == null) {
                    asString = "";
                }
                JsonElement jsonElement2 = jsonObject.get("mainSwitchTimestamp");
                r3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                obj = r3 != null ? r3 : "";
                str = asString;
                Pair a11 = TuplesKt.a(str, obj);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("mainSwitchStatus", (String) a11.getFirst());
                jsonObject2.addProperty("mainSwitchTimestamp", (String) a11.getSecond());
                callback.sendSuccessResponse(jsonObject2);
                r3 = Unit.f67184a;
            }
            obj = "";
            Pair a112 = TuplesKt.a(str, obj);
            JsonObject jsonObject22 = new JsonObject();
            jsonObject22.addProperty("mainSwitchStatus", (String) a112.getFirst());
            jsonObject22.addProperty("mainSwitchTimestamp", (String) a112.getSecond());
            callback.sendSuccessResponse(jsonObject22);
            r3 = Unit.f67184a;
        }
        if (r3 == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void getUnreadMsgNum(@BindingNode(App.class) App app, @BindingParam(stringDefault = "", value = {"miniappId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonObject OooO0Oo = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO0Oo(context);
                    if (str != null && str.length() > 0) {
                        JsonElement jsonElement = OooO0Oo.get(str);
                        int asInt = jsonElement != null ? jsonElement.getAsInt() : 0;
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(str, Integer.valueOf(asInt));
                        OooO0Oo = jsonObject;
                    }
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("unreadMsgData", OooO0Oo.toString()).build());
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void launcherMiniappBrandPage(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String miniappId, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        Intrinsics.h(miniappId, "miniappId");
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    AppBrandProfileActivity.Companion.launch$default(AppBrandProfileActivity.Companion, context, miniappId, null, 4, null);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
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

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void removeMiniAppFile(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String appId, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "removeMiniAppFile: ");
            FileUtil.removeMiniAppFile(context, appId);
            callback.sendSuccessResponse(new JsonObject());
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void removeMiniAppFileCache(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String appId, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "removeMiniAppFileCache: ");
            FileUtil.removeMiniAppFileCache(context, appId);
            callback.sendSuccessResponse(new JsonObject());
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void requestSendMsgPermission(@BindingNode(App.class) App app, @BindingParam({"miniappId"}) String miniappId, @BindingCallback BridgeCallback bridgeCallback) {
        Unit unit;
        Intrinsics.h(miniappId, "miniappId");
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && appContext.getContext() != null) {
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void saveMsgListInfo(@BindingNode(App.class) App app, @BindingParam({"msgList"}) String msgList, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(msgList, "msgList");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "saveMsgListInfo: " + msgList);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "MsgListData", msgList);
            callback.sendSuccessResponse();
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void saveMsgWithReadStatusListInfo(@BindingNode(App.class) App app, @BindingParam({"msgList"}) String msgList, @BindingCallback BridgeCallback callback) {
        Unit unit;
        Context context;
        Intrinsics.h(app, "app");
        Intrinsics.h(msgList, "msgList");
        Intrinsics.h(callback, "callback");
        AppContext appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.d(this.OooO00o, "saveMsgWithReadStatusListInfo: " + msgList);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "MsgListWithReadStatusData", msgList);
            callback.sendSuccessResponse();
            unit = Unit.f67184a;
        }
        if (unit == null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter("")
    @ThreadType(ExecutorType.IO)
    public final void updateUnreadMsgNum(@BindingNode(App.class) App app, @BindingParam({"unreadMsgData"}) JsonObject unreadMsgData, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Unit unit;
        Intrinsics.h(unreadMsgData, "unreadMsgData");
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonObject OooO0Oo = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o.OooO0Oo(context);
                    Set<String> keySet = unreadMsgData.keySet();
                    Intrinsics.g(keySet, "unreadMsgData.keySet()");
                    for (String str : keySet) {
                        OooO0Oo.addProperty(str, Integer.valueOf(unreadMsgData.get(str).getAsInt()));
                    }
                    com.cloud.tmc.miniapp.utils.OooO0o oooO0o = com.cloud.tmc.miniapp.utils.OooO0o.OooO00o;
                    String jsonElement = OooO0Oo.toString();
                    Intrinsics.g(jsonElement, "msgUnreadNumberData.toString()");
                    oooO0o.OooO0Oo(context, jsonElement);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, th2);
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
            Unit unit2 = Unit.f67184a;
        }
    }
}
