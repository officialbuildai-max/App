package com.cloud.tmc.miniapp.bridge;

import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import com.tmc.network.HttpRequestor;
import com.tmc.network.INetworkCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Call;
import okhttp3.Response;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PrefetchStrategyBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();
    public static final String TAG = "PrefetchStrategyBridge";

    /* loaded from: classes3.dex */
    public static final class OooO implements INetworkCallback {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Function2<Response, BridgeCallback, Unit> OooO0O0;

        /* JADX WARN: Multi-variable type inference failed */
        public OooO(BridgeCallback bridgeCallback, Function2<? super Response, ? super BridgeCallback, Unit> function2) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = function2;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.h(e11, "e");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }

        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            this.OooO0O0.invoke(response, this.OooO00o);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function2<PrefetchConfigModel, PrefetchConfigModel, Integer> {
        public static final OooO0O0 OooO00o = new OooO0O0();

        public OooO0O0() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, Object obj2) {
            PrefetchConfigModel prefetchConfigModel = (PrefetchConfigModel) obj;
            PrefetchConfigModel prefetchConfigModel2 = (PrefetchConfigModel) obj2;
            return Integer.valueOf((prefetchConfigModel != null ? prefetchConfigModel.getPriority() : 0) - (prefetchConfigModel2 != null ? prefetchConfigModel2.getPriority() : 0));
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO implements INetworkCallback {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Function2<Response, BridgeCallback, Unit> OooO0O0;

        /* JADX WARN: Multi-variable type inference failed */
        public OooO0OO(BridgeCallback bridgeCallback, Function2<? super Response, ? super BridgeCallback, Unit> function2) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = function2;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.h(e11, "e");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }

        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            this.OooO0O0.invoke(response, this.OooO00o);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o implements INetworkCallback {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Function2<Response, BridgeCallback, Unit> OooO0O0;

        /* JADX WARN: Multi-variable type inference failed */
        public OooO0o(BridgeCallback bridgeCallback, Function2<? super Response, ? super BridgeCallback, Unit> function2) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = function2;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.h(e11, "e");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }

        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            this.OooO0O0.invoke(response, this.OooO00o);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 implements INetworkCallback {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Function2<Response, BridgeCallback, Unit> OooO0O0;

        /* JADX WARN: Multi-variable type inference failed */
        public OooOO0(BridgeCallback bridgeCallback, Function2<? super Response, ? super BridgeCallback, Unit> function2) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = function2;
        }

        @Override // com.tmc.network.INetworkCallback
        public void onFailure(Call call, Exception e11) {
            Intrinsics.h(e11, "e");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }

        @Override // com.tmc.network.INetworkCallback
        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            this.OooO0O0.invoke(response, this.OooO00o);
        }
    }

    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class OooOO0O extends Lambda implements Function2<Response, BridgeCallback, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooOO0O(String str, String str2) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:59:0x0158 A[Catch: all -> 0x0140, TRY_ENTER, TryCatch #0 {all -> 0x0140, blocks: (B:80:0x013c, B:81:0x0142, B:59:0x0158, B:61:0x015d), top: B:28:0x0081 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x015d A[Catch: all -> 0x0140, TRY_LEAVE, TryCatch #0 {all -> 0x0140, blocks: (B:80:0x013c, B:81:0x0142, B:59:0x0158, B:61:0x015d), top: B:28:0x0081 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void OooO00o(okhttp3.Response r14, com.cloud.tmc.kernel.bridge.extension.BridgeCallback r15) {
            /*
                Method dump skipped, instructions count: 381
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.PrefetchStrategyBridge.OooOO0O.OooO00o(okhttp3.Response, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            OooO00o((Response) obj, (BridgeCallback) obj2);
            return Unit.f67184a;
        }
    }

    public static final int OooO00o(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.h(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:24:0x000b, B:26:0x0011, B:7:0x001c, B:10:0x0031, B:12:0x0039, B:13:0x003d, B:15:0x0047), top: B:23:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[Catch: all -> 0x0016, TRY_LEAVE, TryCatch #0 {all -> 0x0016, blocks: (B:24:0x000b, B:26:0x0011, B:7:0x001c, B:10:0x0031, B:12:0x0039, B:13:0x003d, B:15:0x0047), top: B:23:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void changePrefetchStatus(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r9) {
        /*
            r8 = this;
            java.lang.String r0 = "prefetch_state_key"
            java.lang.String r1 = "100000_web"
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r2 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.String r3 = "PrefetchStrategyBridge"
            r4 = 0
            if (r9 == 0) goto L18
            com.cloud.tmc.integration.structure.AppContext r5 = r9.getAppContext()     // Catch: java.lang.Throwable -> L16
            if (r5 == 0) goto L18
            android.content.Context r5 = r5.getContext()     // Catch: java.lang.Throwable -> L16
            goto L19
        L16:
            r9 = move-exception
            goto L74
        L18:
            r5 = r4
        L19:
            if (r5 != 0) goto L1c
            return
        L1c:
            java.lang.Object r6 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r2)     // Catch: java.lang.Throwable -> L16
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r6 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r6     // Catch: java.lang.Throwable -> L16
            java.lang.String r6 = r6.getString(r5, r1, r0)     // Catch: java.lang.Throwable -> L16
            java.lang.Class<com.google.gson.JsonObject> r7 = com.google.gson.JsonObject.class
            java.lang.Object r6 = com.cloud.tmc.miniutils.util.GsonUtils.fromJson(r6, r7)     // Catch: java.lang.Throwable -> L16
            com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6     // Catch: java.lang.Throwable -> L16
            if (r6 != 0) goto L31
            return
        L31:
            java.lang.String r7 = "appId"
            com.google.gson.JsonElement r7 = r6.get(r7)     // Catch: java.lang.Throwable -> L16
            if (r7 == 0) goto L3d
            java.lang.String r4 = r7.getAsString()     // Catch: java.lang.Throwable -> L16
        L3d:
            java.lang.String r7 = r9.getAppId()     // Catch: java.lang.Throwable -> L16
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r4, r7)     // Catch: java.lang.Throwable -> L16
            if (r4 == 0) goto L77
            java.lang.String r9 = r9.getAppId()     // Catch: java.lang.Throwable -> L16
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L16
            r4.<init>()     // Catch: java.lang.Throwable -> L16
            r4.append(r9)     // Catch: java.lang.Throwable -> L16
            java.lang.String r9 = " destroy. change prefetch state"
            r4.append(r9)     // Catch: java.lang.Throwable -> L16
            java.lang.String r9 = r4.toString()     // Catch: java.lang.Throwable -> L16
            com.cloud.tmc.kernel.log.TmcLogger.e(r3, r9)     // Catch: java.lang.Throwable -> L16
            java.lang.String r9 = "state"
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L16
            r6.addProperty(r9, r4)     // Catch: java.lang.Throwable -> L16
            java.lang.Object r9 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r2)     // Catch: java.lang.Throwable -> L16
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r9 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r9     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L16
            r9.putString(r5, r1, r0, r2)     // Catch: java.lang.Throwable -> L16
            goto L77
        L74:
            com.cloud.tmc.kernel.log.TmcLogger.e(r3, r9)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.PrefetchStrategyBridge.changePrefetchStatus(com.cloud.tmc.integration.structure.App):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void getPreStrategy(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        String str;
        ArrayList<String> h5Url;
        String obj;
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        try {
            List<PrefetchConfigModel> R0 = CollectionsKt.R0(com.cloud.tmc.miniapp.prestrategy.OooO0o.OooO0Oo.snapshot().keySet());
            final OooO0O0 oooO0O0 = OooO0O0.OooO00o;
            Collections.sort(R0, new Comparator() { // from class: com.cloud.tmc.miniapp.bridge.a
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return PrefetchStrategyBridge.OooO00o(Function2.this, obj2, obj3);
                }
            });
            for (PrefetchConfigModel prefetchConfigModel : R0) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("sceneId", prefetchConfigModel.getSceneId());
                jsonObject2.addProperty("appId", prefetchConfigModel.getAppId());
                jsonObject2.addProperty(TrackingKey.PRIORITY, Integer.valueOf(prefetchConfigModel.getPriority()));
                jsonObject2.addProperty("dataType", prefetchConfigModel.getDataType());
                ArrayList<JsonObject> source = prefetchConfigModel.getSource();
                String str2 = "[]";
                if (source != null) {
                    str = source.toString();
                    if (str == null) {
                    }
                    jsonObject2.addProperty(EventConstants.KEY_SOURCE, str);
                    h5Url = prefetchConfigModel.getH5Url();
                    if (h5Url != null && (obj = h5Url.toString()) != null) {
                        str2 = obj;
                    }
                    jsonObject2.addProperty("h5Url", str2);
                    jsonObject2.addProperty("netType", Integer.valueOf(prefetchConfigModel.getNetType()));
                    jsonObject2.addProperty("expiredTime", Long.valueOf(prefetchConfigModel.getExpiredTime()));
                    jsonObject2.addProperty("executeTime", Long.valueOf(prefetchConfigModel.getExecuteTime()));
                    jsonArray.add(jsonObject2);
                }
                str = "[]";
                jsonObject2.addProperty(EventConstants.KEY_SOURCE, str);
                h5Url = prefetchConfigModel.getH5Url();
                if (h5Url != null) {
                    str2 = obj;
                }
                jsonObject2.addProperty("h5Url", str2);
                jsonObject2.addProperty("netType", Integer.valueOf(prefetchConfigModel.getNetType()));
                jsonObject2.addProperty("expiredTime", Long.valueOf(prefetchConfigModel.getExpiredTime()));
                jsonObject2.addProperty("executeTime", Long.valueOf(prefetchConfigModel.getExecuteTime()));
                jsonArray.add(jsonObject2);
            }
            jsonObject.add("data", jsonArray);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
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

    @ActionFilter
    @ThreadType(ExecutorType.NETWORK)
    public final void requestStrategy(@BindingNode(App.class) App app, @BindingParam({"appId"}) String str, @BindingParam({"url"}) String str2, @BindingParam({"header"}) String str3, @BindingParam({"method"}) String str4, @BindingParam({"param"}) String str5, @BindingParam({"supportCell"}) boolean z10, @BindingCallback BridgeCallback bridgeCallback) {
        Map<String, String> JsonToMapValueIsString;
        Map<String, String> JsonToMapValueIsString2;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str4 == null || str4.length() == 0) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        try {
            if (NetworkUtils.isMobileData() && !z10) {
                TmcLogger.e(TAG, "current netType is cellular");
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (str5 != null && str5.length() != 0 && (JsonToMapValueIsString2 = TmcGsonUtils.JsonToMapValueIsString(str5)) != null) {
                for (Map.Entry<String, String> entry : JsonToMapValueIsString2.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, String> commonHeader = AppPrepareUtils.INSTANCE.getCommonHeader(new LinkedHashMap(), true);
            if (str3 != null && str3.length() != 0 && (JsonToMapValueIsString = TmcGsonUtils.JsonToMapValueIsString(str5)) != null) {
                for (Map.Entry<String, String> entry2 : JsonToMapValueIsString.entrySet()) {
                    commonHeader.put(entry2.getKey(), entry2.getValue());
                }
            }
            OooOO0O oooOO0O = new OooOO0O(str2, str);
            int hashCode = str4.hashCode();
            if (hashCode != -2019344435) {
                if (hashCode == 102230) {
                    if (str4.equals("get")) {
                        HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
                        if (companion != null) {
                            companion.get(str2, commonHeader, linkedHashMap, new OooO0OO(bridgeCallback, oooOO0O));
                            return;
                        }
                        return;
                    }
                } else if (hashCode == 3446944) {
                    if (str4.equals("post")) {
                        HttpRequestor companion2 = HttpRequestor.INSTANCE.getInstance();
                        if (companion2 != null) {
                            companion2.post(str2, commonHeader, new LinkedHashMap(), linkedHashMap, new OooO(bridgeCallback, oooOO0O));
                            return;
                        }
                        return;
                    }
                } else if (hashCode == 2002678055 && str4.equals("post_json")) {
                    HttpRequestor companion3 = HttpRequestor.INSTANCE.getInstance();
                    if (companion3 != null) {
                        companion3.postJSON(str2, commonHeader, new LinkedHashMap(), linkedHashMap, new OooO0o(bridgeCallback, oooOO0O));
                        return;
                    }
                    return;
                }
            } else if (str4.equals("post_multipart")) {
                HttpRequestor companion4 = HttpRequestor.INSTANCE.getInstance();
                if (companion4 != null) {
                    companion4.postMultipart(str2, commonHeader, new LinkedHashMap(), linkedHashMap, new OooOO0(bridgeCallback, oooOO0O));
                    return;
                }
                return;
            }
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } catch (Throwable th2) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
            TmcLogger.e(TAG, th2);
        }
    }
}
