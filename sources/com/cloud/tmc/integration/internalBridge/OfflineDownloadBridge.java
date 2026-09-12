package com.cloud.tmc.integration.internalBridge;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.a;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.google.gson.JsonObject;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001e\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00062\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J(\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J(\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u00062\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lcom/cloud/tmc/integration/internalBridge/OfflineDownloadBridge;", "Lcom/cloud/tmc/kernel/extension/BridgeExtension;", "()V", "downloadPkg", "", "app", "", "group", NetworkBridge.KEY_NETWORK_TYPE, "pkgEncrypted", "pkgUrl", "paths", "callback", "Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "downloadPkgFromPlatform", "packageName", "getOfflinePkgCachePath", "getOfflineResources", "appId", "url", "onFinalized", "onInitialized", "permit", "Lcom/cloud/tmc/kernel/security/Permission;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class OfflineDownloadBridge implements BridgeExtension {
    private static final String TAG = "OfflineDownloadBridge";

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void downloadPkg(@BindingParam({"app"}) String app, @BindingParam({"group"}) String group, @BindingParam(stringDefault = "strong", value = {"networkType"}) String networkType, @BindingParam({"pkgEncrypted"}) String pkgEncrypted, @BindingParam({"pkgUrl"}) String pkgUrl, @BindingParam({"paths"}) String paths, @BindingCallback final BridgeCallback callback) {
        Intrinsics.h(app, "app");
        Intrinsics.h(group, "group");
        Intrinsics.h(networkType, "networkType");
        Intrinsics.h(pkgEncrypted, "pkgEncrypted");
        Intrinsics.h(pkgUrl, "pkgUrl");
        Intrinsics.h(paths, "paths");
        if (app.length() != 0 && group.length() != 0 && networkType.length() != 0 && pkgEncrypted.length() != 0 && pkgUrl.length() != 0 && paths.length() != 0) {
            ((IOfflineManagerProxy) TmcProxy.get(IOfflineManagerProxy.class)).downloadPkg(app, group, networkType, pkgEncrypted, pkgUrl, paths, new Function1<JsonObject, Unit>() { // from class: com.cloud.tmc.integration.internalBridge.OfflineDownloadBridge$downloadPkg$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((JsonObject) obj);
                    return Unit.f67184a;
                }

                public final void invoke(JsonObject jsonObject) {
                    if (jsonObject == null) {
                        BridgeCallback bridgeCallback = BridgeCallback.this;
                        if (bridgeCallback != null) {
                            bridgeCallback.sendFailResponse();
                            return;
                        }
                        return;
                    }
                    BridgeCallback bridgeCallback2 = BridgeCallback.this;
                    if (bridgeCallback2 != null) {
                        bridgeCallback2.sendSuccessResponse(jsonObject);
                    }
                }
            });
        } else if (callback != null) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void downloadPkgFromPlatform(@BindingParam({"packageName"}) String packageName, @BindingCallback BridgeCallback callback) {
        Intrinsics.h(packageName, "packageName");
        if (packageName.length() == 0) {
            if (callback != null) {
                callback.sendFailResponse();
            }
        } else {
            ((IOfflineManagerProxy) TmcProxy.get(IOfflineManagerProxy.class)).downloadPkgFromPlatform(packageName, false);
            if (callback != null) {
                callback.sendSuccessResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void getOfflinePkgCachePath(@BindingParam({"group"}) String group, @BindingParam({"pkgUrl"}) String pkgUrl, @BindingCallback final BridgeCallback callback) {
        Intrinsics.h(group, "group");
        Intrinsics.h(pkgUrl, "pkgUrl");
        if (group.length() != 0 && pkgUrl.length() != 0) {
            ((IOfflineManagerProxy) TmcProxy.get(IOfflineManagerProxy.class)).getOfflinePkgCachePath(group, pkgUrl, new Function1<JsonObject, Unit>() { // from class: com.cloud.tmc.integration.internalBridge.OfflineDownloadBridge$getOfflinePkgCachePath$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((JsonObject) obj);
                    return Unit.f67184a;
                }

                public final void invoke(JsonObject jsonObject) {
                    if (jsonObject == null) {
                        BridgeCallback bridgeCallback = BridgeCallback.this;
                        if (bridgeCallback != null) {
                            bridgeCallback.sendFailResponse();
                            return;
                        }
                        return;
                    }
                    BridgeCallback bridgeCallback2 = BridgeCallback.this;
                    if (bridgeCallback2 != null) {
                        bridgeCallback2.sendSuccessResponse(jsonObject);
                    }
                }
            });
        } else if (callback != null) {
            callback.sendFailResponse();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
    
        r4.sendFailResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return;
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void getOfflineResources(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"appId"}) java.lang.String r2, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"url"}) java.lang.String r3, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r4) {
        /*
            r1 = this;
            java.lang.String r0 = "appId"
            kotlin.jvm.internal.Intrinsics.h(r2, r0)
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.h(r3, r0)
            int r0 = r2.length()     // Catch: java.lang.Throwable -> L1d
            if (r0 != 0) goto L11
            goto L17
        L11:
            int r0 = r3.length()     // Catch: java.lang.Throwable -> L1d
            if (r0 != 0) goto L20
        L17:
            if (r4 == 0) goto L1f
            r4.sendFailResponse()     // Catch: java.lang.Throwable -> L1d
            goto L1f
        L1d:
            r2 = move-exception
            goto L51
        L1f:
            return
        L20:
            java.lang.Class<com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy> r0 = com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy.class
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)     // Catch: java.lang.Throwable -> L1d
            com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy r0 = (com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy) r0     // Catch: java.lang.Throwable -> L1d
            java.io.File r2 = r0.getOfflineResources(r2, r3)     // Catch: java.lang.Throwable -> L1d
            boolean r3 = com.cloud.tmc.integration.utils.FileUtil.access(r2)     // Catch: java.lang.Throwable -> L1d
            if (r3 != 0) goto L38
            if (r4 == 0) goto L37
            r4.sendFailResponse()     // Catch: java.lang.Throwable -> L1d
        L37:
            return
        L38:
            java.lang.String r2 = com.cloud.tmc.worker.utils.FileIOUtils.readFile2String(r2)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = "readFile2String(offlineResources)"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)     // Catch: java.lang.Throwable -> L1d
            if (r4 == 0) goto L5b
            com.google.gson.JsonObject r3 = new com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L1d
            r3.<init>()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r0 = "content"
            r3.addProperty(r0, r2)     // Catch: java.lang.Throwable -> L1d
            r4.sendSuccessResponse(r3)     // Catch: java.lang.Throwable -> L1d
            goto L5b
        L51:
            java.lang.String r3 = "OfflineDownloadBridge"
            com.cloud.tmc.kernel.log.TmcLogger.e(r3, r2)
            if (r4 == 0) goto L5b
            r4.sendFailResponse()
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.internalBridge.OfflineDownloadBridge.getOfflineResources(java.lang.String, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
        TmcLogger.d(TAG, "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
        TmcLogger.d(TAG, "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }
}
