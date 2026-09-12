package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.config.utils.ConstantsKt;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.PrivacyUtils;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.google.gson.JsonObject;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\t\u001a\u00020\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007JD\u0010\f\u001a\u00020\u00042\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007JP\u0010\u0010\u001a\u00020\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J,\u0010\u0015\u001a\u00020\u00042\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J8\u0010\u0016\u001a\u00020\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007JD\u0010\u0017\u001a\u00020\u00042\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007JP\u0010\u0019\u001a\u00020\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\u001a"}, d2 = {"Lcom/cloud/tmc/integration/bridge/GlobalStorageBridge;", "Lcom/cloud/tmc/kernel/extension/BridgeExtension;", "()V", "clearCommonResStorage", "", "app", "Lcom/cloud/tmc/integration/structure/App;", "callback", "Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "clearGlobalStorage", "globalFlag", "", "getCommonResStorage", "key", "dataType", "defaultValue", "getGlobalStorage", "onFinalized", "onInitialized", "permit", "Lcom/cloud/tmc/kernel/security/Permission;", "removeCommonResStorage", "removeGlobalStorage", "setCommonResStorage", "data", "setGlobalStorage", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class GlobalStorageBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void clearCommonResStorage(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String templateMiniappId;
        if (app != null) {
            try {
                AppModel appModel = app.getAppModel();
                if (appModel != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                    clearGlobalStorage(templateMiniappId + "_web", app, callback);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        templateMiniappId = null;
        clearGlobalStorage(templateMiniappId + "_web", app, callback);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void clearGlobalStorage(@BindingParam({"globalFlag"}) String globalFlag, @BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String valueOf;
        Context context;
        if (globalFlag == null || TextUtils.isEmpty(globalFlag)) {
            callbackFail(callback, "globalFlag is null or empty", Boolean.FALSE);
            return;
        }
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).clear(context, globalFlag);
                    if (callback != null) {
                        callback.sendSuccessResponse();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                valueOf = String.valueOf(th2.getMessage());
            }
        }
        valueOf = "app error";
        callbackFail(callback, valueOf, Boolean.FALSE);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void getCommonResStorage(@BindingParam({"key"}) String key, @BindingParam({"dataType"}) String dataType, @BindingParam({"defaultValue"}) String defaultValue, @BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String templateMiniappId;
        if (app != null) {
            try {
                AppModel appModel = app.getAppModel();
                if (appModel != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                    getGlobalStorage(templateMiniappId + "_web", key, dataType, defaultValue, app, callback);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        templateMiniappId = null;
        getGlobalStorage(templateMiniappId + "_web", key, dataType, defaultValue, app, callback);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0034. Please report as an issue. */
    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void getGlobalStorage(@BindingParam({"globalFlag"}) String globalFlag, @BindingParam({"key"}) String key, @BindingParam({"dataType"}) String dataType, @BindingParam({"defaultValue"}) String defaultValue, @BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String valueOf;
        AppContext appContext;
        Context context;
        if (globalFlag == null || TextUtils.isEmpty(globalFlag)) {
            callbackFail(callback, "globalFlag is null or empty", Boolean.FALSE);
            return;
        }
        if (key == null || TextUtils.isEmpty(key)) {
            callbackFail(callback, "key is null or empty", Boolean.FALSE);
            return;
        }
        if (dataType == null || TextUtils.isEmpty(dataType)) {
            callbackFail(callback, "dataType is null or empty", Boolean.FALSE);
            return;
        }
        if (app != null) {
            try {
                appContext = app.getAppContext();
            } catch (Throwable th2) {
                valueOf = String.valueOf(th2.getMessage());
            }
            if (appContext != null && (context = appContext.getContext()) != null) {
                switch (dataType.hashCode()) {
                    case -1808118735:
                        if (dataType.equals("String")) {
                            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, globalFlag, key);
                            if (callback != null) {
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.addProperty("data", string);
                                callback.sendSuccessResponse(jsonObject);
                                return;
                            }
                            return;
                        }
                        valueOf = "dataType is not in (String, Int, Long, Boolean)";
                        callbackFail(callback, valueOf, Boolean.FALSE);
                    case 73679:
                        if (!dataType.equals("Int")) {
                            valueOf = "dataType is not in (String, Int, Long, Boolean)";
                            callbackFail(callback, valueOf, Boolean.FALSE);
                        }
                        int i11 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getInt(context, globalFlag, key);
                        if (callback != null) {
                            JsonObject jsonObject2 = new JsonObject();
                            jsonObject2.addProperty("data", Integer.valueOf(i11));
                            callback.sendSuccessResponse(jsonObject2);
                            return;
                        }
                        return;
                    case 2374300:
                        if (!dataType.equals("Long")) {
                            valueOf = "dataType is not in (String, Int, Long, Boolean)";
                            callbackFail(callback, valueOf, Boolean.FALSE);
                        }
                        long j11 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, globalFlag, key);
                        if (callback != null) {
                            JsonObject jsonObject3 = new JsonObject();
                            jsonObject3.addProperty("data", Long.valueOf(j11));
                            callback.sendSuccessResponse(jsonObject3);
                            return;
                        }
                        return;
                    case 1729365000:
                        if (!dataType.equals("Boolean")) {
                            valueOf = "dataType is not in (String, Int, Long, Boolean)";
                            callbackFail(callback, valueOf, Boolean.FALSE);
                        }
                        boolean z10 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, globalFlag, key, defaultValue != null ? Boolean.parseBoolean(defaultValue) : false);
                        if (callback != null) {
                            JsonObject jsonObject4 = new JsonObject();
                            jsonObject4.addProperty("data", Boolean.valueOf(z10));
                            callback.sendSuccessResponse(jsonObject4);
                            return;
                        }
                        return;
                    default:
                        valueOf = "dataType is not in (String, Int, Long, Boolean)";
                        callbackFail(callback, valueOf, Boolean.FALSE);
                }
            }
        }
        valueOf = "app error";
        callbackFail(callback, valueOf, Boolean.FALSE);
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
    public final void removeCommonResStorage(@BindingParam({"key"}) String key, @BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String templateMiniappId;
        if (app != null) {
            try {
                AppModel appModel = app.getAppModel();
                if (appModel != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                    removeGlobalStorage(templateMiniappId + "_web", key, app, callback);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        templateMiniappId = null;
        removeGlobalStorage(templateMiniappId + "_web", key, app, callback);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void removeGlobalStorage(@BindingParam({"globalFlag"}) String globalFlag, @BindingParam({"key"}) String key, @BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String valueOf;
        Context context;
        if (globalFlag == null || TextUtils.isEmpty(globalFlag)) {
            callbackFail(callback, "globalFlag is null or empty", Boolean.FALSE);
            return;
        }
        if (key == null || TextUtils.isEmpty(key)) {
            callbackFail(callback, "key is null or empty", Boolean.FALSE);
            return;
        }
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).remove(context, globalFlag, key);
                    if (callback != null) {
                        callback.sendSuccessResponse();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                valueOf = String.valueOf(th2.getMessage());
            }
        }
        valueOf = "app error";
        callbackFail(callback, valueOf, Boolean.FALSE);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void setCommonResStorage(@BindingParam({"key"}) String key, @BindingParam({"data"}) String data, @BindingParam({"dataType"}) String dataType, @BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String templateMiniappId;
        if (app != null) {
            try {
                AppModel appModel = app.getAppModel();
                if (appModel != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                    setGlobalStorage(templateMiniappId + "_web", key, data, dataType, app, callback);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        templateMiniappId = null;
        setGlobalStorage(templateMiniappId + "_web", key, data, dataType, app, callback);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x003c. Please report as an issue. */
    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void setGlobalStorage(@BindingParam({"globalFlag"}) String globalFlag, @BindingParam({"key"}) String key, @BindingParam({"data"}) String data, @BindingParam({"dataType"}) String dataType, @BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String valueOf;
        AppContext appContext;
        Context context;
        if (globalFlag == null || TextUtils.isEmpty(globalFlag)) {
            callbackFail(callback, "globalFlag is null or empty", Boolean.FALSE);
            return;
        }
        if (key == null || TextUtils.isEmpty(key)) {
            callbackFail(callback, "key is null or empty", Boolean.FALSE);
            return;
        }
        if (dataType == null || TextUtils.isEmpty(dataType)) {
            callbackFail(callback, "dataType is null or empty", Boolean.FALSE);
            return;
        }
        if (data == null) {
            callbackFail(callback, ConstantsKt.ERROR_1000_MESSAGE, Boolean.FALSE);
            return;
        }
        if (app != null) {
            try {
                appContext = app.getAppContext();
            } catch (Throwable th2) {
                valueOf = String.valueOf(th2.getMessage());
            }
            if (appContext != null && (context = appContext.getContext()) != null) {
                switch (dataType.hashCode()) {
                    case -1808118735:
                        if (dataType.equals("String")) {
                            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, globalFlag, key, data);
                            if (callback != null) {
                                callback.sendSuccessResponse();
                                return;
                            }
                            return;
                        }
                        valueOf = "dataType is not in (String, Int, Long, Boolean)";
                        callbackFail(callback, valueOf, Boolean.FALSE);
                    case 73679:
                        if (!dataType.equals("Int")) {
                            valueOf = "dataType is not in (String, Int, Long, Boolean)";
                            callbackFail(callback, valueOf, Boolean.FALSE);
                        } else {
                            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, globalFlag, key, Integer.parseInt(data));
                            if (callback != null) {
                                callback.sendSuccessResponse();
                                return;
                            }
                            return;
                        }
                    case 2374300:
                        if (!dataType.equals("Long")) {
                            valueOf = "dataType is not in (String, Int, Long, Boolean)";
                            callbackFail(callback, valueOf, Boolean.FALSE);
                        } else {
                            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, globalFlag, key, Long.parseLong(data));
                            if (callback != null) {
                                callback.sendSuccessResponse();
                                return;
                            }
                            return;
                        }
                    case 1729365000:
                        if (!dataType.equals("Boolean")) {
                            valueOf = "dataType is not in (String, Int, Long, Boolean)";
                            callbackFail(callback, valueOf, Boolean.FALSE);
                        }
                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, globalFlag, key, Boolean.parseBoolean(data));
                        if (callback != null) {
                            callback.sendSuccessResponse();
                        }
                        if (Intrinsics.c("100000", globalFlag) && Intrinsics.c(TmcConstants.KEY_PRIVACY_AGREEMENT, key) && Boolean.parseBoolean(data)) {
                            PrivacyUtils.INSTANCE.tryUpdateNewUserToOldUser(context);
                            return;
                        }
                        return;
                    default:
                        valueOf = "dataType is not in (String, Int, Long, Boolean)";
                        callbackFail(callback, valueOf, Boolean.FALSE);
                }
            }
        }
        valueOf = "app error";
        callbackFail(callback, valueOf, Boolean.FALSE);
    }
}
