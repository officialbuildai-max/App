package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
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
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.JsonObjectUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.dialog.o00oO0o;
import com.cloud.tmc.miniapp.dialog.o0OOO0o;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.miniutils.util.EmptyUtils;
import com.cloud.tmc.miniutils.util.StringUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.push.PushConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PermissionScopeBridge implements BridgeExtension {
    public static final int ERROR_CODE_HAPPENED_EXCEPTION = 500;
    public static final int ERROR_CODE_SCOPE_NAME_IS_EMPTY = 601;
    public static final int ERROR_CODE_SCOPE_NAME_NOT_FOUND = 602;
    public static final String ERROR_MSG_SCOPE_NAME_IS_EMPTY = "scopeName is empty";
    public static final String ERROR_MSG_SCOPE_NAME_NOT_FOUND = "No specified scopeName found";
    public static final String TAG = "PermissionScopeBridge::";
    public static final OooO00o Companion = new OooO00o();
    public static final ConcurrentHashMap<String, o00oO0o> OooO00o = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public static final class OooO00o {
        public final boolean OooO00o(String str) {
            if (str != null) {
                try {
                    if (str.length() != 0 && PermissionScopeBridge.OooO00o.containsKey(str)) {
                        return ((o00oO0o) PermissionScopeBridge.OooO00o.get(str)) != null;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 implements o0OOO0o {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ Ref.BooleanRef OooO0O0;

        public OooO0O0(BridgeCallback bridgeCallback, Ref.BooleanRef booleanRef) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = booleanRef;
        }

        @Override // com.cloud.tmc.miniapp.dialog.o0OOO0o
        public void OooO00o(int i11) {
            TmcLogger.d(PermissionScopeBridge.TAG, "onClick postion = " + i11);
            this.OooO00o.sendSuccessResponse(JsonObjectUtils.create().addProperty("click", Integer.valueOf(i11)).addProperty("isClickNotShowAgain", Boolean.valueOf(this.OooO0O0.element)).build());
        }

        @Override // com.cloud.tmc.miniapp.dialog.o0OOO0o
        public void clickNotShowAgagin(boolean z10) {
            TmcLogger.d(PermissionScopeBridge.TAG, "clickNotShowAgagin status = " + z10);
            this.OooO0O0.element = z10;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void checkScopePermissionAuthStatus(@BindingNode(App.class) App app, @BindingParam({"scopeName"}) String scopeName, @BindingCallback BridgeCallback callback) {
        Context context;
        Intrinsics.h(scopeName, "scopeName");
        Intrinsics.h(callback, "callback");
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    if (EmptyUtils.textIsEmpty(scopeName)) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("code", Integer.valueOf(ERROR_CODE_SCOPE_NAME_IS_EMPTY));
                        jsonObject.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_IS_EMPTY);
                        callback.sendFailResponse(jsonObject);
                    } else {
                        ConcurrentHashMap<String, ScopeModel> concurrentHashMap = com.cloud.tmc.miniapp.defaultimpl.OooO0O0.OooO0Oo;
                        if (concurrentHashMap.containsKey(scopeName)) {
                            ScopeModel scopeModel = concurrentHashMap.get(scopeName);
                            if (scopeModel != null) {
                                ScopeUtils scopeUtils = ScopeUtils.OooO00o;
                                long validityTime = scopeModel.getValidityTime();
                                String appId = app.getAppId();
                                Intrinsics.g(appId, "app.appId");
                                boolean OooO00o2 = scopeUtils.OooO00o(context, scopeName, validityTime, appId);
                                JsonObject jsonObject2 = new JsonObject();
                                jsonObject2.addProperty(TmcConstants.KEY_CHECK_SCOPE_AUTH_RESULT, Boolean.valueOf(OooO00o2));
                                callback.sendSuccessResponse(jsonObject2);
                            } else {
                                JsonObject jsonObject3 = new JsonObject();
                                jsonObject3.addProperty("code", Integer.valueOf(ERROR_CODE_SCOPE_NAME_NOT_FOUND));
                                jsonObject3.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_NOT_FOUND);
                                callback.sendFailResponse(jsonObject3);
                            }
                        } else {
                            JsonObject jsonObject4 = new JsonObject();
                            jsonObject4.addProperty("code", Integer.valueOf(ERROR_CODE_SCOPE_NAME_NOT_FOUND));
                            jsonObject4.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_NOT_FOUND);
                            callback.sendFailResponse(jsonObject4);
                        }
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, th2);
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty("code", (Number) 500);
                jsonObject5.addProperty("errMsg", th2.getMessage());
                callback.sendFailResponse(jsonObject5);
                return;
            }
        }
        callback.sendFailResponse();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0019 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:18:0x000b, B:20:0x0011, B:7:0x001a, B:9:0x002a, B:11:0x005d, B:16:0x0030), top: B:17:0x000b }] */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void getTempUniqueId(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r8, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r9) {
        /*
            r7 = this;
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r0 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.String r1 = "tempUniqueId"
            java.lang.String r2 = "callback"
            kotlin.jvm.internal.Intrinsics.h(r9, r2)
            if (r8 == 0) goto L16
            com.cloud.tmc.integration.structure.AppContext r2 = r8.getAppContext()     // Catch: java.lang.Throwable -> L6d
            if (r2 == 0) goto L16
            android.content.Context r2 = r2.getContext()     // Catch: java.lang.Throwable -> L6d
            goto L17
        L16:
            r2 = 0
        L17:
            if (r2 != 0) goto L1a
            return
        L1a:
            java.lang.Object r3 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)     // Catch: java.lang.Throwable -> L6d
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r3 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r3     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = r8.getAppId()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = r3.getString(r2, r4, r1)     // Catch: java.lang.Throwable -> L6d
            if (r3 == 0) goto L30
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L6d
            if (r4 != 0) goto L5d
        L30:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r5 = r8.getAppId()     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r6.<init>()     // Catch: java.lang.Throwable -> L6d
            r6.append(r3)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = "_"
            r6.append(r3)     // Catch: java.lang.Throwable -> L6d
            r6.append(r5)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = com.cloud.tmc.miniutils.util.EncryptUtils.encryptMD5ToString(r3)     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)     // Catch: java.lang.Throwable -> L6d
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r0 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r0     // Catch: java.lang.Throwable -> L6d
            java.lang.String r8 = r8.getAppId()     // Catch: java.lang.Throwable -> L6d
            r0.putString(r2, r8, r1, r3)     // Catch: java.lang.Throwable -> L6d
        L5d:
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r8 = com.cloud.tmc.kernel.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L6d
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r8 = r8.addProperty(r1, r3)     // Catch: java.lang.Throwable -> L6d
            com.google.gson.JsonObject r8 = r8.build()     // Catch: java.lang.Throwable -> L6d
            r9.sendSuccessResponse(r8)     // Catch: java.lang.Throwable -> L6d
            goto L70
        L6d:
            r9.sendFailResponse()
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.PermissionScopeBridge.getTempUniqueId(com.cloud.tmc.integration.structure.App, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void listScope(@BindingCallback BridgeCallback callback) {
        Intrinsics.h(callback, "callback");
        try {
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            Set<Map.Entry<String, ScopeModel>> entrySet = com.cloud.tmc.miniapp.defaultimpl.OooO0O0.OooO0Oo.entrySet();
            Intrinsics.g(entrySet, "SHOW_SCOPE_MAP.entries");
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getValue() != null) {
                    Object value = entry.getValue();
                    Intrinsics.g(value, "it.value");
                    jsonArray.add(TmcGsonUtilsKt.toJson(value));
                }
            }
            Unit unit = Unit.f67184a;
            jsonObject.addProperty("data", TmcGsonUtilsKt.toJson(jsonArray));
            callback.sendSuccessResponse(jsonObject);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("code", (Number) 500);
            jsonObject2.addProperty("errMsg", th2.getMessage());
            callback.sendFailResponse(jsonObject2);
        }
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

    /* JADX WARN: Removed duplicated region for block: B:5:0x001e A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:11:0x000e, B:13:0x0014, B:5:0x001e, B:8:0x0022), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022 A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #0 {all -> 0x0019, blocks: (B:11:0x000e, B:13:0x0014, B:5:0x001e, B:8:0x0022), top: B:10:0x000e }] */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void queryAddScreenNotShowAgainStatus(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r4, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"miniappId"}) java.lang.String r5, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r6) {
        /*
            r3 = this;
            java.lang.String r0 = "miniappId"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.h(r6, r0)
            java.lang.String r0 = "timestamp"
            if (r4 == 0) goto L1b
            com.cloud.tmc.integration.structure.AppContext r4 = r4.getAppContext()     // Catch: java.lang.Throwable -> L19
            if (r4 == 0) goto L1b
            android.content.Context r4 = r4.getContext()     // Catch: java.lang.Throwable -> L19
            goto L1c
        L19:
            r4 = move-exception
            goto L44
        L1b:
            r4 = 0
        L1c:
            if (r4 != 0) goto L22
            r6.sendFailResponse()     // Catch: java.lang.Throwable -> L19
            return
        L22:
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r1 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.Object r1 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r1)     // Catch: java.lang.Throwable -> L19
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r1 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r1     // Catch: java.lang.Throwable -> L19
            java.lang.String r2 = "miniAddHomeNotShowAgainTime"
            long r4 = r1.getLong(r4, r5, r2)     // Catch: java.lang.Throwable -> L19
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r1 = com.cloud.tmc.kernel.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L19
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L19
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r4 = r1.addProperty(r0, r4)     // Catch: java.lang.Throwable -> L19
            com.google.gson.JsonObject r4 = r4.build()     // Catch: java.lang.Throwable -> L19
            r6.sendSuccessResponse(r4)     // Catch: java.lang.Throwable -> L19
            goto L5e
        L44:
            java.lang.String r5 = "PermissionScopeBridge::"
            com.cloud.tmc.kernel.log.TmcLogger.e(r5, r4)
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r4 = com.cloud.tmc.kernel.utils.JsonObjectUtils.create()
            r1 = 0
            java.lang.Long r5 = java.lang.Long.valueOf(r1)
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r4 = r4.addProperty(r0, r5)
            com.google.gson.JsonObject r4 = r4.build()
            r6.sendSuccessResponse(r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.PermissionScopeBridge.queryAddScreenNotShowAgainStatus(com.cloud.tmc.integration.structure.App, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void queryDynamicScopeConfig(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Intrinsics.h(callback, "callback");
        try {
            callback.sendSuccessResponse(JsonObjectUtils.create().addProperty(LauncherMiniAppConfigHelper.KEY_MINI_SCOPE_CONFIG, MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_SCOPE_CONFIG, "{}")).build());
        } catch (Throwable unused) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void queryEnableDevUserAgreement(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Intrinsics.h(callback, "callback");
        try {
            callback.sendSuccessResponse(JsonObjectUtils.create().addProperty(OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, Boolean.valueOf(MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_DEV_USER_AGREEMENT, false))).build());
        } catch (Throwable unused) {
            callback.sendFailResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void queryEnableduaWhitlist(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Intrinsics.h(callback, "callback");
        try {
            callback.sendSuccessResponse(JsonObjectUtils.create().addProperty("duaWhitlist", MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_ENABLE_DUA_WHITLIST, "[]")).build());
        } catch (Throwable unused) {
            callback.sendFailResponse();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0020 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:11:0x0010, B:13:0x0016, B:5:0x0020, B:8:0x0024), top: B:10:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:11:0x0010, B:13:0x0016, B:5:0x0020, B:8:0x0024), top: B:10:0x0010 }] */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void queryMsgNotShowAgainStatus(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r6, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"miniappId"}) java.lang.String r7, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r8) {
        /*
            r5 = this;
            java.lang.String r0 = "miniappId"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            java.lang.String r0 = "timestamp"
            java.lang.String r1 = "PermissionScopeBridge::"
            if (r6 == 0) goto L1d
            com.cloud.tmc.integration.structure.AppContext r6 = r6.getAppContext()     // Catch: java.lang.Throwable -> L1b
            if (r6 == 0) goto L1d
            android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> L1b
            goto L1e
        L1b:
            r6 = move-exception
            goto L70
        L1d:
            r6 = 0
        L1e:
            if (r6 != 0) goto L24
            r8.sendFailResponse()     // Catch: java.lang.Throwable -> L1b
            return
        L24:
            com.cloud.tmc.miniapp.utils.ScopeUtils r2 = com.cloud.tmc.miniapp.utils.ScopeUtils.OooO00o     // Catch: java.lang.Throwable -> L1b
            kotlin.Pair r6 = r2.OooO00o(r6, r7)     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r7 = r6.getFirst()     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r2 = r6.getSecond()     // Catch: java.lang.Throwable -> L1b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b
            r3.<init>()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "msgStatusPair,-> "
            r3.append(r4)     // Catch: java.lang.Throwable -> L1b
            r3.append(r7)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r7 = ","
            r3.append(r7)     // Catch: java.lang.Throwable -> L1b
            r3.append(r2)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L1b
            com.cloud.tmc.kernel.log.TmcLogger.d(r1, r7)     // Catch: java.lang.Throwable -> L1b
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r7 = com.cloud.tmc.kernel.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r2 = "notShowAgain"
            java.lang.Object r3 = r6.getFirst()     // Catch: java.lang.Throwable -> L1b
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> L1b
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r7 = r7.addProperty(r2, r3)     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r6 = r6.getSecond()     // Catch: java.lang.Throwable -> L1b
            java.lang.Number r6 = (java.lang.Number) r6     // Catch: java.lang.Throwable -> L1b
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r6 = r7.addProperty(r0, r6)     // Catch: java.lang.Throwable -> L1b
            com.google.gson.JsonObject r6 = r6.build()     // Catch: java.lang.Throwable -> L1b
            r8.sendSuccessResponse(r6)     // Catch: java.lang.Throwable -> L1b
            goto L88
        L70:
            com.cloud.tmc.kernel.log.TmcLogger.e(r1, r6)
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.kernel.utils.JsonObjectUtils.create()
            r1 = 0
            java.lang.Long r7 = java.lang.Long.valueOf(r1)
            com.cloud.tmc.kernel.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r0, r7)
            com.google.gson.JsonObject r6 = r6.build()
            r8.sendSuccessResponse(r6)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.PermissionScopeBridge.queryMsgNotShowAgainStatus(com.cloud.tmc.integration.structure.App, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void queryScopeContentConfig(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        Intrinsics.h(callback, "callback");
        try {
            JsonObject jsonObject = new JsonObject();
            for (String str : ScopeUtils.OooO0O0) {
                jsonObject.addProperty(str, ScopeUtils.OooO00o.OooO0O0(str, ""));
            }
            callback.sendSuccessResponse(JsonObjectUtils.create().addProperty("scope", TmcGsonUtilsKt.toJson(jsonObject)).build());
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(43:12|(1:14)(1:134)|15|(1:17)|18|19|20|(1:22)|24|(3:125|126|(33:128|(1:130)(1:131)|29|30|31|32|33|34|35|36|37|38|(3:83|84|(19:86|(1:88)(8:89|90|(1:92)|93|94|95|96|97)|44|45|46|(1:48)(1:79)|49|50|51|(1:53)(1:77)|54|(2:(1:74)(1:76)|75)(1:56)|57|(1:59)(1:72)|(1:61)(1:71)|62|(1:67)|69|70))|40|41|(1:43)|44|45|46|(0)(0)|49|50|51|(0)(0)|54|(0)(0)|57|(0)(0)|(0)(0)|62|(2:64|67)|69|70))|26|(1:28)(1:124)|29|30|31|32|33|34|35|36|37|38|(0)|40|41|(0)|44|45|46|(0)(0)|49|50|51|(0)(0)|54|(0)(0)|57|(0)(0)|(0)(0)|62|(0)|69|70) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x012f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0130, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e(r15.OooO00o, "setBtnThree:-> ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x011c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x011d, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e(r15.OooO00o, "setBtnTwo:-> ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0105, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0106, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e(r15.OooO00o, "setBtnOne:-> ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ac, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e(r15.OooO00o, "setAppName", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01bc A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:51:0x01b4, B:53:0x01bc, B:54:0x01c2, B:57:0x01d6, B:59:0x01de, B:62:0x01ed, B:64:0x01f3, B:67:0x01fa, B:71:0x01e7, B:75:0x01d3), top: B:50:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01de A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:51:0x01b4, B:53:0x01bc, B:54:0x01c2, B:57:0x01d6, B:59:0x01de, B:62:0x01ed, B:64:0x01f3, B:67:0x01fa, B:71:0x01e7, B:75:0x01d3), top: B:50:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f3 A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:51:0x01b4, B:53:0x01bc, B:54:0x01c2, B:57:0x01d6, B:59:0x01de, B:62:0x01ed, B:64:0x01f3, B:67:0x01fa, B:71:0x01e7, B:75:0x01d3), top: B:50:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e7 A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:51:0x01b4, B:53:0x01bc, B:54:0x01c2, B:57:0x01d6, B:59:0x01de, B:62:0x01ed, B:64:0x01f3, B:67:0x01fa, B:71:0x01e7, B:75:0x01d3), top: B:50:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a7 A[Catch: all -> 0x01ab, TRY_LEAVE, TryCatch #4 {all -> 0x01ab, blocks: (B:46:0x019c, B:79:0x01a7), top: B:45:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.UI)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showScopePermissionDialog(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r25, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"logo"}) java.lang.String r26, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"title"}) java.lang.String r27, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"titleTips"}) java.lang.String r28, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"scopeName"}) java.lang.String r29, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"customContent"}) java.lang.String r30, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"button1"}) com.google.gson.JsonObject r31, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"button2"}) com.google.gson.JsonObject r32, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"button3"}) com.google.gson.JsonObject r33, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"notShowAgain"}) com.google.gson.JsonObject r34, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r35) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.PermissionScopeBridge.showScopePermissionDialog(com.cloud.tmc.integration.structure.App, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.gson.JsonObject, com.google.gson.JsonObject, com.google.gson.JsonObject, com.google.gson.JsonObject, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void userAgreementDialogShow(@BindingNode(App.class) App app, @BindingParam({"titleMode"}) JsonObject config, @BindingParam({"content"}) String content, @BindingParam({"agreementContent"}) String agreementContent, @BindingParam({"privacyPolicyTv"}) String privacyPolicyTv, @BindingParam({"userAgreementTv"}) String userAgreementTv, @BindingParam({"privacyPolicyUrl"}) String privacyPolicyUrl, @BindingParam({"userAgreementUrl"}) String userAgreementUrl, @BindingParam({"btnBgColor"}) String btnBgColor, @BindingParam({"agreeBtn"}) String agreeBtn, @BindingParam({"cancelBtn"}) JsonObject cancelBtn, @BindingCallback(isSticky = true) BridgeCallback callback) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        Intrinsics.h(config, "titleMode");
        Intrinsics.h(content, "content");
        Intrinsics.h(agreementContent, "agreementContent");
        Intrinsics.h(privacyPolicyTv, "privacyPolicyTv");
        Intrinsics.h(userAgreementTv, "userAgreementTv");
        Intrinsics.h(privacyPolicyUrl, "privacyPolicyUrl");
        Intrinsics.h(userAgreementUrl, "userAgreementUrl");
        Intrinsics.h(btnBgColor, "btnBgColor");
        Intrinsics.h(agreeBtn, "agreeBtn");
        Intrinsics.h(cancelBtn, "cancelBtn");
        Intrinsics.h(callback, "callback");
        TmcLogger.d(TAG, "userAgreementDialogShow titleMode = " + config);
        String appId = app != null ? app.getAppId() : null;
        if (appId == null) {
            TmcLogger.d(TAG, "app is null");
            return;
        }
        AppContext appContext = app.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null) {
            TmcLogger.d(TAG, "context is null");
            return;
        }
        ConcurrentHashMap<String, o00oO0o> concurrentHashMap = OooO00o;
        if (concurrentHashMap.containsKey(appId)) {
            TmcLogger.d(TAG, "dialog is exist remove it");
            o00oO0o o00oo0o = concurrentHashMap.get(appId);
            if (o00oo0o != null) {
                o00oo0o.dismiss();
            }
            concurrentHashMap.remove(appId);
        }
        o00oO0o o00oo0o2 = new o00oO0o(context);
        Intrinsics.h(appId, "appId");
        o00oo0o2.OooO0oo = appId;
        AppModel appModel = app.getAppModel();
        String name = appModel != null ? appModel.getName() : null;
        Intrinsics.h(config, "config");
        JsonElement jsonElement3 = config.get(o00oo0o2.OooO);
        String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
        if (asString == null) {
            asString = "1";
        } else {
            Intrinsics.g(asString, "config.get(KEY_MODE)?.asString ?: \"1\"");
        }
        JsonElement jsonElement4 = config.get(o00oo0o2.OooOO0);
        String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
        if (asString2 == null) {
            asString2 = "";
        } else {
            Intrinsics.g(asString2, "config.get(KEY_TEXT)?.asString ?: \"\"");
        }
        if (asString2.length() > 0) {
            TextView textView = (TextView) o00oo0o2.OooO0OO.getValue();
            if (textView != null) {
                textView.setText(asString2);
            }
        } else {
            TextView textView2 = (TextView) o00oo0o2.OooO0OO.getValue();
            if (textView2 != null) {
                textView2.setText(Intrinsics.c(asString, o00oo0o2.OooOO0o) ? o00oo0o2.getString(R.string.mini_dau_title_notice) : Intrinsics.c(asString, o00oo0o2.OooOOO0) ? StringUtils.format(o00oo0o2.getString(R.string.mini_dau_title_welcome), name) : o00oo0o2.getString(R.string.mini_dau_title_notice));
            }
        }
        if (content == null || content.length() <= 0) {
            TextView OooO0Oo = o00oo0o2.OooO0Oo();
            if (OooO0Oo != null) {
                OooO0Oo.setText(o00oo0o2.getString(R.string.mini_dau_content));
            }
            TextView OooO0Oo2 = o00oo0o2.OooO0Oo();
            if (OooO0Oo2 != null) {
                OooO0Oo2.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        } else {
            TextView OooO0Oo3 = o00oo0o2.OooO0Oo();
            if (OooO0Oo3 != null) {
                OooO0Oo3.setText(content);
            }
        }
        Intrinsics.h(callback, "callback");
        o00oo0o2.OooO0O0 = callback;
        String name2 = app.getAppModel().getName();
        o00oO0o OooO00o2 = o00oo0o2.OooO00o(name2 == null ? "" : name2, agreementContent, privacyPolicyTv, userAgreementTv, privacyPolicyUrl, userAgreementUrl, btnBgColor).OooO00o(btnBgColor, agreeBtn);
        String asString3 = (cancelBtn == null || (jsonElement2 = cancelBtn.get(OooO00o2.OooOO0)) == null) ? null : jsonElement2.getAsString();
        if (asString3 == null) {
            asString3 = "";
        } else {
            Intrinsics.g(asString3, "config?.get(KEY_TEXT)?.asString ?: \"\"");
        }
        String asString4 = (cancelBtn == null || (jsonElement = cancelBtn.get(OooO00o2.OooO)) == null) ? null : jsonElement.getAsString();
        if (asString4 == null) {
            asString4 = "";
        } else {
            Intrinsics.g(asString4, "config?.get(KEY_MODE)?.asString ?: \"\"");
        }
        TextView textView3 = (TextView) OooO00o2.OooO0oO.getValue();
        if (textView3 != null) {
            if (asString3.length() <= 0) {
                asString3 = Intrinsics.c(asString4, OooO00o2.OooOOO) ? OooO00o2.getString(R.string.mini_can_open_exit) : Intrinsics.c(asString4, OooO00o2.OooOOOO) ? OooO00o2.getString(R.string.mini_dau_guest_mode) : OooO00o2.getString(R.string.mini_can_open_exit);
            }
            textView3.setText(asString3);
        }
        OooO00o2.show();
        try {
            concurrentHashMap.put(appId, o00oo0o2);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, PushConstants.PUSH_SERVICE_TYPE_SHOW);
            callback.sendSuccessResponse(jsonObject);
        } catch (Throwable unused) {
            callbackFail(callback, "", Boolean.TRUE);
        }
    }
}
