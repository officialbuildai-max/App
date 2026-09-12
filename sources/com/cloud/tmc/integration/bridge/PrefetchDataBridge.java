package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0011\u001a\u00020\u00122\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u00042\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016Jy\u0010\u001c\u001a\u00020\u00122\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010%J*\u0010&\u001a\u00020\u00122\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u00042\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006("}, d2 = {"Lcom/cloud/tmc/integration/bridge/PrefetchDataBridge;", "Lcom/cloud/tmc/kernel/extension/BridgeExtension;", "()V", "KEY_RESPONSE_PREFETCHDATA", "", "KEY_RESPONSE_PREFETCH_EXPIRED_TIME", "KEY_RESPONSE_PREFETCH_PREFETCH_TIME", "KEY_RESPONSE_PREFETCH_TOKEN", "KEY_STORAGE_PREFETCH_DATA", "TAG", "getTAG", "()Ljava/lang/String;", "mTempDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/cloud/tmc/integration/bridge/PrefetchDataBridge$MiniPrefetchData;", "getMTempDataMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getPrefetchData", "", "app", "Lcom/cloud/tmc/integration/structure/App;", "prefetchToken", "callback", "Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "onFinalized", "onInitialized", "permit", "Lcom/cloud/tmc/kernel/security/Permission;", "prefetchAndSaveToTemp", "url", "method", "requestHeader", "requestParam", "requestTimeout", "", "prefetchExpiredTime", "callbackId", "(Lcom/cloud/tmc/integration/structure/App;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;)V", "removePrefetchData", "MiniPrefetchData", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class PrefetchDataBridge implements BridgeExtension {
    private final String TAG = "PrefetchDataBridge";
    private final ConcurrentHashMap<String, MiniPrefetchData> mTempDataMap = new ConcurrentHashMap<>();
    private final String KEY_STORAGE_PREFETCH_DATA = "mini_PrefetchData";
    private final String KEY_RESPONSE_PREFETCHDATA = "prefetchData";
    private final String KEY_RESPONSE_PREFETCH_TOKEN = "prefetchToken";
    private final String KEY_RESPONSE_PREFETCH_EXPIRED_TIME = "expiredTime";
    private final String KEY_RESPONSE_PREFETCH_PREFETCH_TIME = "prefetchTime";

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/cloud/tmc/integration/bridge/PrefetchDataBridge$MiniPrefetchData;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "expiredTime", "", "callback", "Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "callbackId", "", "(JLcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;Ljava/lang/String;)V", "getCallback", "()Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "setCallback", "(Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;)V", "getCallbackId", "()Ljava/lang/String;", "setCallbackId", "(Ljava/lang/String;)V", "getExpiredTime", "()J", "setExpiredTime", "(J)V", "component1", "component2", "component3", "copy", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "", "toString", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final /* data */ class MiniPrefetchData extends BaseBean {
        private BridgeCallback callback;
        private String callbackId;
        private long expiredTime;

        public MiniPrefetchData(long j11, BridgeCallback bridgeCallback, String str) {
            this.expiredTime = j11;
            this.callback = bridgeCallback;
            this.callbackId = str;
        }

        public static /* synthetic */ MiniPrefetchData copy$default(MiniPrefetchData miniPrefetchData, long j11, BridgeCallback bridgeCallback, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = miniPrefetchData.expiredTime;
            }
            if ((i11 & 2) != 0) {
                bridgeCallback = miniPrefetchData.callback;
            }
            if ((i11 & 4) != 0) {
                str = miniPrefetchData.callbackId;
            }
            return miniPrefetchData.copy(j11, bridgeCallback, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getExpiredTime() {
            return this.expiredTime;
        }

        /* renamed from: component2, reason: from getter */
        public final BridgeCallback getCallback() {
            return this.callback;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCallbackId() {
            return this.callbackId;
        }

        public final MiniPrefetchData copy(long expiredTime, BridgeCallback callback, String callbackId) {
            return new MiniPrefetchData(expiredTime, callback, callbackId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MiniPrefetchData)) {
                return false;
            }
            MiniPrefetchData miniPrefetchData = (MiniPrefetchData) other;
            return this.expiredTime == miniPrefetchData.expiredTime && Intrinsics.c(this.callback, miniPrefetchData.callback) && Intrinsics.c(this.callbackId, miniPrefetchData.callbackId);
        }

        public final BridgeCallback getCallback() {
            return this.callback;
        }

        public final String getCallbackId() {
            return this.callbackId;
        }

        public final long getExpiredTime() {
            return this.expiredTime;
        }

        public int hashCode() {
            int a11 = androidx.collection.s.a(this.expiredTime) * 31;
            BridgeCallback bridgeCallback = this.callback;
            int hashCode = (a11 + (bridgeCallback == null ? 0 : bridgeCallback.hashCode())) * 31;
            String str = this.callbackId;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public final void setCallback(BridgeCallback bridgeCallback) {
            this.callback = bridgeCallback;
        }

        public final void setCallbackId(String str) {
            this.callbackId = str;
        }

        public final void setExpiredTime(long j11) {
            this.expiredTime = j11;
        }

        public String toString() {
            return "MiniPrefetchData(expiredTime=" + this.expiredTime + ", callback=" + this.callback + ", callbackId=" + this.callbackId + ")";
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    public final ConcurrentHashMap<String, MiniPrefetchData> getMTempDataMap() {
        return this.mTempDataMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x015e, code lost:
    
        if (r1 == null) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: all -> 0x0016, TRY_ENTER, TryCatch #0 {all -> 0x0016, blocks: (B:45:0x000b, B:47:0x0011, B:8:0x001e, B:12:0x0039, B:14:0x004e, B:16:0x0067, B:19:0x006f, B:22:0x008a, B:24:0x0096, B:25:0x009c, B:27:0x00a6, B:28:0x00aa, B:30:0x00f4, B:32:0x010c, B:36:0x0126, B:38:0x0143, B:41:0x0160, B:43:0x017d), top: B:44:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void getPrefetchData(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r12, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"prefetchToken"}) java.lang.String r13, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r14) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.PrefetchDataBridge.getPrefetchData(com.cloud.tmc.integration.structure.App, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    public final String getTAG() {
        return this.TAG;
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b A[Catch: all -> 0x0018, TRY_ENTER, TryCatch #1 {all -> 0x0018, blocks: (B:37:0x000d, B:39:0x0013, B:7:0x0020, B:11:0x003b, B:14:0x0048, B:17:0x0063, B:19:0x008f, B:20:0x0096, B:27:0x00b9, B:29:0x00c7, B:30:0x012a), top: B:36:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.NETWORK)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void prefetchAndSaveToTemp(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r17, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"url"}) java.lang.String r18, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"method"}) java.lang.String r19, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"requestHeader"}) java.lang.String r20, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"requestParam"}) java.lang.String r21, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"requestTimeout"}) java.lang.Long r22, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"prefetchExpiredTime"}) java.lang.Long r23, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"callbackId"}) java.lang.String r24, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r25) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.PrefetchDataBridge.prefetchAndSaveToTemp(com.cloud.tmc.integration.structure.App, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[Catch: all -> 0x0015, TRY_ENTER, TryCatch #0 {all -> 0x0015, blocks: (B:17:0x000a, B:19:0x0010, B:7:0x001c, B:11:0x0037, B:13:0x004b), top: B:16:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001a  */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void removePrefetchData(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r4, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"prefetchToken"}) java.lang.String r5, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r6) {
        /*
            r3 = this;
            java.lang.String r0 = "prefetchToken"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.cloud.tmc.integration.bridge.PrefetchDataBridge$MiniPrefetchData> r0 = r3.mTempDataMap
            monitor-enter(r0)
            if (r4 == 0) goto L17
            com.cloud.tmc.integration.structure.AppContext r4 = r4.getAppContext()     // Catch: java.lang.Throwable -> L15
            if (r4 == 0) goto L17
            android.content.Context r4 = r4.getContext()     // Catch: java.lang.Throwable -> L15
            goto L18
        L15:
            r4 = move-exception
            goto L60
        L17:
            r4 = 0
        L18:
            if (r4 != 0) goto L37
            if (r6 == 0) goto L35
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r4 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L15
            java.lang.String r1 = r3.KEY_RESPONSE_PREFETCH_TOKEN     // Catch: java.lang.Throwable -> L15
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r4 = r4.addProperty(r1, r5)     // Catch: java.lang.Throwable -> L15
            java.lang.String r5 = "errMsg"
            java.lang.String r1 = "Failed Prefetch data, context is null: PD001"
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r4 = r4.addProperty(r5, r1)     // Catch: java.lang.Throwable -> L15
            com.google.gson.JsonObject r4 = r4.build()     // Catch: java.lang.Throwable -> L15
            r6.sendFailResponse(r4)     // Catch: java.lang.Throwable -> L15
        L35:
            monitor-exit(r0)
            return
        L37:
            java.lang.String r1 = "app?.appContext?.context…     return\n            }"
            kotlin.jvm.internal.Intrinsics.g(r4, r1)     // Catch: java.lang.Throwable -> L15
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r1 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.Object r1 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r1)     // Catch: java.lang.Throwable -> L15
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r1 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r1     // Catch: java.lang.Throwable -> L15
            java.lang.String r2 = r3.KEY_STORAGE_PREFETCH_DATA     // Catch: java.lang.Throwable -> L15
            r1.remove(r4, r2, r5)     // Catch: java.lang.Throwable -> L15
            if (r6 == 0) goto L5e
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r4 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L15
            java.lang.String r1 = r3.KEY_RESPONSE_PREFETCH_TOKEN     // Catch: java.lang.Throwable -> L15
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r4 = r4.addProperty(r1, r5)     // Catch: java.lang.Throwable -> L15
            com.google.gson.JsonObject r4 = r4.build()     // Catch: java.lang.Throwable -> L15
            r6.sendSuccessResponse(r4)     // Catch: java.lang.Throwable -> L15
            kotlin.Unit r4 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L15
        L5e:
            monitor-exit(r0)
            return
        L60:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.PrefetchDataBridge.removePrefetchData(com.cloud.tmc.integration.structure.App, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }
}
