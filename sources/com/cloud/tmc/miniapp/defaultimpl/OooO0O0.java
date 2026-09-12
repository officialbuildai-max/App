package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.callback.LocalAuthPermissionWithNotShowAgainCallback;
import com.cloud.tmc.integration.callback.PrivacyCallback;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.model.PermissionDialogModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.MiniForceAddHomeManager;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.helper.BridgeResponseHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class OooO0O0 implements PrivacyCallback {
    public static final ConcurrentHashMap<String, String> OooO0OO = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, ScopeModel> OooO0Oo = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, List<PermissionDialogModel>> OooO0o0 = new ConcurrentHashMap<>();
    public Context OooO00o;
    public ConcurrentHashMap<String, List<C0325OooO0O0>> OooO0O0 = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public class OooO00o implements LocalAuthPermissionWithNotShowAgainCallback {
        public boolean OooO00o = false;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ String OooO0Oo;
        public final /* synthetic */ String OooO0o;
        public final /* synthetic */ String OooO0o0;
        public final /* synthetic */ Page OooO0oO;

        public OooO00o(String str, String str2, String str3, String str4, String str5, Page page) {
            this.OooO0O0 = str;
            this.OooO0OO = str2;
            this.OooO0Oo = str3;
            this.OooO0o0 = str4;
            this.OooO0o = str5;
            this.OooO0oO = page;
        }

        @Override // com.cloud.tmc.integration.callback.LocalAuthPermissionWithNotShowAgainCallback
        public void clickNotShowAgagin(boolean z10) {
            this.OooO00o = z10;
        }

        @Override // com.cloud.tmc.integration.callback.LocalAuthPermissionCallback
        public void onDenied() {
            OooO0O0.this.OooO0O0(this.OooO0O0, this.OooO0OO);
            TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkShowPermissionDialog...cancel");
            ScopeUtils scopeUtils = ScopeUtils.OooO00o;
            Context context = OooO0O0.this.OooO00o;
            String scopeName = this.OooO0OO;
            String appId = this.OooO0Oo;
            String str = this.OooO0o0;
            String str2 = this.OooO0o;
            Intrinsics.h(context, "context");
            Intrinsics.h(scopeName, "scopeName");
            Intrinsics.h(appId, "appId");
            scopeUtils.OooO00o(context, scopeName, appId, false, str, str2, true, false);
            OooO0O0.this.OooO0O0.remove(this.OooO0OO);
            Context context2 = OooO0O0.this.OooO00o;
            String str3 = this.OooO0Oo;
            boolean z10 = this.OooO00o;
            if (this.OooO0OO.equals("notifyMessage") && z10) {
                scopeUtils.OooO00o(context2, str3, z10);
            }
        }

        @Override // com.cloud.tmc.integration.callback.LocalAuthPermissionCallback
        public void onGranted(@Nullable Object obj) {
            ScopeUtils scopeUtils = ScopeUtils.OooO00o;
            Context context = OooO0O0.this.OooO00o;
            String scopeName = this.OooO0OO;
            String appId = this.OooO0Oo;
            String str = this.OooO0o0;
            String str2 = this.OooO0o;
            Intrinsics.h(context, "context");
            Intrinsics.h(scopeName, "scopeName");
            Intrinsics.h(appId, "appId");
            scopeUtils.OooO00o(context, scopeName, appId, true, str, str2, true, false);
            OooO0O0 oooO0O0 = OooO0O0.this;
            Page page = this.OooO0oO;
            String str3 = this.OooO0O0;
            String str4 = this.OooO0OO;
            oooO0O0.getClass();
            if (page != null && page.getApp() != null && page.getApp().getEngineProxy() != null) {
                List<C0325OooO0O0> list = oooO0O0.OooO0O0.get(str4);
                oooO0O0.OooO0O0.remove(str4);
                if (list != null) {
                    for (C0325OooO0O0 c0325OooO0O0 : list) {
                        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "sendResult...action=" + str3);
                        try {
                            page.getApp().getEngineProxy().getBridge().sendToNative(c0325OooO0O0.OooO00o, c0325OooO0O0.OooO0O0.getInnerBridgeResponse(), false);
                        } catch (Exception e11) {
                            StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("use local permission send result error:\t");
                            OooO00o.append(e11.getMessage());
                            TmcLogger.e("Tmcintegration:LocalAuthPermissionManager", OooO00o.toString());
                        }
                    }
                }
            }
            Context context2 = OooO0O0.this.OooO00o;
            String str5 = this.OooO0Oo;
            boolean z10 = this.OooO00o;
            if (this.OooO0OO.equals("notifyMessage") && z10) {
                ScopeUtils.OooO00o.OooO00o(context2, str5, z10);
            }
        }
    }

    /* renamed from: com.cloud.tmc.miniapp.defaultimpl.OooO0O0$OooO0O0, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0325OooO0O0 {
        public NativeCallContext OooO00o;
        public BridgeResponseHelper OooO0O0;

        public C0325OooO0O0(OooO0O0 oooO0O0, String str, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
            this.OooO00o = nativeCallContext;
            this.OooO0O0 = bridgeResponseHelper;
        }
    }

    public OooO0O0(Context context) {
        this.OooO00o = context;
        ScopeUtils.OooO00o.OooO00o(OooO0Oo, OooO0OO);
        ((PermissionDialogPoint) ExtensionPoint.as(PermissionDialogPoint.class).create()).registerCallback(this);
    }

    public final String OooO00o(String str) {
        String str2 = OooO0OO.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public final String OooO00o(String str, String str2) {
        return "_" + str + "_" + str2.substring(str2.indexOf(".") + 1, str2.length());
    }

    public final void OooO00o(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0325OooO0O0(this, str, nativeCallContext, bridgeResponseHelper));
        this.OooO0O0.put(str2, arrayList);
        try {
            nativeCallContext.getRender().getAppId();
        } catch (Throwable th2) {
            TmcLogger.e("Tmcintegration:LocalAuthPermissionManager", "cancelAuth", th2);
        }
        OooO0O0(str, str2);
        this.OooO0O0.remove(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005a, code lost:
    
        if (r3 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ed, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkRealShowPermissionDialog -> 添加入缓存, appId: " + r23 + ", scope: " + r1 + ", startToken: " + r0.getStartToken());
        r5.add(new com.cloud.tmc.integration.model.PermissionDialogModel(r22, r23, r24, r25, r26, r27, r0.getStartToken()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean OooO00o(com.cloud.tmc.integration.structure.Page r22, java.lang.String r23, java.lang.String r24, com.cloud.tmc.kernel.bridge.NativeCallContext r25, com.cloud.tmc.kernel.helper.BridgeResponseHelper r26, com.cloud.tmc.kernel.model.permission.PermissionModel r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.defaultimpl.OooO0O0.OooO00o(com.cloud.tmc.integration.structure.Page, java.lang.String, java.lang.String, com.cloud.tmc.kernel.bridge.NativeCallContext, com.cloud.tmc.kernel.helper.BridgeResponseHelper, com.cloud.tmc.kernel.model.permission.PermissionModel, boolean):boolean");
    }

    public final void OooO0O0(String str, String str2) {
        List<C0325OooO0O0> list = this.OooO0O0.get(str2);
        if (list != null) {
            for (C0325OooO0O0 c0325OooO0O0 : list) {
                if (c0325OooO0O0.OooO0O0 != null) {
                    TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "cancelAuth...action=" + str);
                    c0325OooO0O0.OooO0O0.sendNotGrantPermission();
                }
            }
        }
    }

    @Override // com.cloud.tmc.integration.callback.PrivacyCallback
    public void privacyDismiss(String str, long j11) {
        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> appId:" + str + " , startToken:" + j11);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ConcurrentHashMap<String, List<PermissionDialogModel>> concurrentHashMap = OooO0o0;
            List<PermissionDialogModel> list = concurrentHashMap.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator<PermissionDialogModel> it = list.iterator();
                if (it.hasNext()) {
                    PermissionDialogModel next = it.next();
                    if (next == null) {
                        it.remove();
                        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> permissionDialogModel == null, continue");
                        privacyDismiss(str, j11);
                        return;
                    }
                    if (next.getStartToken() != j11) {
                        it.remove();
                        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "privacyDismiss -> cacheStartToken: " + next.getStartToken() + " 不匹配, continue");
                        privacyDismiss(str, j11);
                        return;
                    }
                    String callbackId = next.getResponseHelper().getCallbackId();
                    next.getPage().getApp().updateInterectCallbackId(callbackId);
                    TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "update currentCallbackId -> " + callbackId);
                    OooO00o(next.getPage(), next.getAppId(), next.getAction(), next.getBridgeContext(), next.getResponseHelper(), next.getModel(), true);
                    it.remove();
                }
                if (it.hasNext()) {
                    return;
                }
                concurrentHashMap.remove(str);
                MiniForceAddHomeManager.INSTANCE.removeInterectMFAH(str, true);
                return;
            }
            concurrentHashMap.remove(str);
            MiniForceAddHomeManager.INSTANCE.removeInterectMFAH(str, true);
        } catch (Throwable th2) {
            TmcLogger.e("Tmcintegration:LocalAuthPermissionManager", OooO0O0.class.getSimpleName(), th2);
        }
    }
}
