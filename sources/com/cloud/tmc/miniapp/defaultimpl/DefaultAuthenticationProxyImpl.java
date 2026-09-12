package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.integration.extension.IgnorePermissionPoint;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppInfoScene;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.permission.ApiPermissionCheckResult;
import com.cloud.tmc.integration.permission.AppPermissionUtils;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.cloud.tmc.integration.permission.model.ApiPermissionInfo;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.bridge.BridgePermission;
import com.cloud.tmc.kernel.helper.BridgeResponseHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import com.cloud.tmc.kernel.model.permission.ScopesV2Bean;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.DefaultPermission;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.JSONUtils;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class DefaultAuthenticationProxyImpl implements AuthenticationProxy {
    public static String OooO0o = "Tmcintegration:DefaultAuthenticationProxyImpl";
    public Context OooO00o;
    public OooO0O0 OooO0o0;
    public String OooO0Oo = "";
    public Map<String, ApiPermissionInfo> OooO0O0 = new ConcurrentHashMap();
    public Map<String, PermissionModel> OooO0OO = new ConcurrentHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tel");
        arrayList.add("mailto");
        arrayList.add("sms");
        arrayList.add("geo");
    }

    public DefaultAuthenticationProxyImpl(Context context) {
        this.OooO00o = context;
        this.OooO0o0 = new OooO0O0(context);
    }

    public final boolean OooO00o(ApiPermissionInfo apiPermissionInfo, String str, String str2) {
        if (!TextUtils.equals(str2, PermissionConstant.VALID_SUB_RES_MIME_LIST) && !str2.startsWith(PermissionConstant.JS_API_SP_CONFIG) && !TextUtils.equals(str2, PermissionConstant.EVENT_LIST) && !TextUtils.equals(str2, PermissionConstant.HTTP_LINK_SUB_RES_MIME_LIST) && !str2.startsWith(PermissionConstant.WEB_VIEW_CONFIG) && !TextUtils.equals(str2, PermissionConstant.VALID_DOMAIN)) {
            return apiPermissionInfo.getApiLevelList(str2).contains(str);
        }
        List<String> apiLevelList = apiPermissionInfo.getApiLevelList(str2);
        if (apiLevelList == null || apiLevelList.isEmpty()) {
            return false;
        }
        Iterator<String> it = apiLevelList.iterator();
        while (it.hasNext()) {
            try {
            } catch (Exception e11) {
                TmcLogger.e(OooO0o, "hasPermission Regex Exception", e11);
            }
            if (Pattern.compile(it.next()).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean checkEventPermission(String str, String str2, Page page) {
        if (this.OooO0O0.containsKey(str)) {
            return hasPermission(str, str2, PermissionConstant.EVENT_LIST, page);
        }
        return true;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app) {
        String str = OooO0o;
        StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("checkJSApi,page i新日志##########");
        OooO00o.append(nativeCallContext.getSource());
        TmcLogger.d(str, OooO00o.toString());
        if (app == null) {
            TmcLogger.d(OooO0o, "checkJSApi,page is null");
            return ApiPermissionCheckResult.DENY;
        }
        IgnorePermissionPoint ignorePermissionPoint = (IgnorePermissionPoint) ExtensionPoint.as(IgnorePermissionPoint.class).node(app).create();
        if (ignorePermissionPoint != null && ignorePermissionPoint.ignoreAppPermission(app.getAppId())) {
            TmcLogger.d(OooO0o, "checkJSApi,IgnorePermissionPoint ignoreAppPermission");
            return ApiPermissionCheckResult.IGNORE;
        }
        AppModel appModel = app.getAppModel();
        if (appModel != null) {
            boolean isDevSource = AppInfoScene.isDevSource(app.getStartParams());
            String string = JSONUtils.getString(appModel.getExtendInfos(), "checkPermission", "YES");
            if (isDevSource && "NO".equalsIgnoreCase(string)) {
                TmcLogger.d(OooO0o, "checkJSApi, KEY_CHECK_PERMISSION ignoreAppPermission");
                return ApiPermissionCheckResult.IGNORE;
            }
        }
        String appId = app.getAppId();
        PermissionModel permissionModel = this.OooO0OO.get(appId);
        if (permission == null || permission == DefaultPermission.ALL || permissionModel == null) {
            TmcLogger.d(OooO0o, String.format("%s not have permission file", appId));
            return ApiPermissionCheckResult.IGNORE;
        }
        permissionModel.getJsapiList();
        return ScopeUtils.OooO00o.OooO00o(permission);
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean checkSPJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app) {
        return true;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean checkShowPermissionDialog(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, Page page) {
        PermissionModel permissionModel = this.OooO0OO.get(page.getApp().getAppId());
        if (permission == null || permission == DefaultPermission.ALL || permissionModel == null) {
            TmcLogger.d(OooO0o, "checkShowPermissionDialog permsionModel is null");
            return false;
        }
        OooO0O0 oooO0O0 = this.OooO0o0;
        oooO0O0.getClass();
        if (page.getApp() != null) {
            AppModel appModel = page.getApp().getAppModel();
            PermissionModel permissions = appModel.getPermissions();
            String appId = page.getApp().getAppId();
            String authority = permission.authority();
            if ("0".equals(((ConfigService) TmcProxy.get(ConfigService.class)).getConfig("ta_permissionDialogSwitch", "1"))) {
                TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "checkShowPermissionDialog...dialogSwitch closed");
            } else {
                String scopeName = oooO0O0.OooO00o(authority);
                ScopeModel scopeModel = OooO0O0.OooO0Oo.get(scopeName);
                if (scopeModel != null) {
                    ScopeUtils scopeUtils = ScopeUtils.OooO00o;
                    ArrayList<ScopesV2Bean> OooO00o = scopeUtils.OooO00o(page);
                    long validityTime = scopeModel.getValidityTime();
                    boolean userAuthorization = scopeModel.getUserAuthorization();
                    if (OooO00o != null) {
                        ScopesV2Bean OooO00o2 = scopeUtils.OooO00o(scopeName, OooO00o);
                        if (OooO00o2 == null) {
                            oooO0O0.OooO00o(nativeCallContext, bridgeResponseHelper, authority, scopeName);
                            ExecutorUtils.execute(ExecutorType.NORMAL, new OooO00o(oooO0O0, scopeName, appId, appModel));
                            return true;
                        }
                        userAuthorization = OooO00o2.getUserAuthorization();
                        long validityTime2 = OooO00o2.getValidityTime();
                        scopeModel.setUserAuthorization(userAuthorization);
                        scopeModel.setValidityTime(validityTime2);
                        validityTime = validityTime2;
                    }
                    if (userAuthorization && !scopeUtils.OooO00o(oooO0O0.OooO00o, scopeName, validityTime, appId)) {
                        Context context = oooO0O0.OooO00o;
                        Intrinsics.h(context, "context");
                        Intrinsics.h(scopeName, "scopeName");
                        Intrinsics.h(appId, "appId");
                        if (!Intrinsics.c(scopeName, "userLogin") && scopeUtils.OooO0O0(context, scopeName, appId) >= 3) {
                            if (System.currentTimeMillis() - scopeUtils.OooO0o0(context, scopeName, appId) <= 86400000) {
                                oooO0O0.OooO00o(nativeCallContext, bridgeResponseHelper, authority, scopeName);
                                return true;
                            }
                        }
                        if ("notifyMessage".equals(scopeName)) {
                            Pair<Boolean, Long> OooO00o3 = scopeUtils.OooO00o(oooO0O0.OooO00o, appId);
                            if (Boolean.TRUE.equals(OooO00o3.getFirst())) {
                                Long second = OooO00o3.getSecond();
                                if (System.currentTimeMillis() - second.longValue() < 604800000 && second.longValue() != 0) {
                                    TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "notifyMsg scope not show again" + second);
                                    oooO0O0.OooO00o(nativeCallContext, bridgeResponseHelper, authority, scopeName);
                                    return true;
                                }
                            }
                        }
                        return oooO0O0.OooO00o(page, appId, authority, nativeCallContext, bridgeResponseHelper, permissions, false);
                    }
                }
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public void clearPermissionModel(String str) {
        if (this.OooO0O0.get(str) != null) {
            this.OooO0O0.get(str).clear();
            this.OooO0O0.remove(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00fe, code lost:
    
        if (android.text.TextUtils.equals(((com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) com.cloud.tmc.kernel.proxy.TmcProxy.get(com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class)).getString(r11.OooO00o, r12, r11.OooO00o(r13, r2)), "1") != false) goto L32;
     */
    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map<java.lang.String, java.lang.Boolean> getAllPermissions(java.lang.String r11, java.lang.String r12, @androidx.annotation.Nullable com.cloud.tmc.integration.model.AppModel r13) {
        /*
            r10 = this;
            com.cloud.tmc.miniapp.defaultimpl.OooO0O0 r11 = r10.OooO0o0
            if (r11 != 0) goto Ld
            com.cloud.tmc.miniapp.defaultimpl.OooO0O0 r11 = new com.cloud.tmc.miniapp.defaultimpl.OooO0O0
            android.content.Context r0 = r10.OooO00o
            r11.<init>(r0)
            r10.OooO0o0 = r11
        Ld:
            com.cloud.tmc.miniapp.defaultimpl.OooO0O0 r11 = r10.OooO0o0
            r11.getClass()
            java.lang.Class<com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager> r0 = com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager.class
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)
            com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager r0 = (com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager) r0
            if (r13 != 0) goto L26
            android.content.Context r13 = r11.OooO00o
            com.cloud.tmc.integration.model.AppInfoQuery r1 = com.cloud.tmc.integration.model.AppInfoQuery.make(r12)
            com.cloud.tmc.integration.model.AppModel r13 = r0.getAppModel(r13, r1)
        L26:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r13 == 0) goto L10c
            com.cloud.tmc.kernel.model.permission.PermissionModel r1 = r13.getPermissions()
            if (r1 == 0) goto L10c
            com.cloud.tmc.kernel.model.permission.PermissionModel r1 = r13.getPermissions()
            com.google.gson.JsonObject r1 = r1.getNativeApiScopeConfig()
            if (r1 != 0) goto L3f
            goto L10c
        L3f:
            com.cloud.tmc.kernel.model.permission.PermissionModel r1 = r13.getPermissions()
            com.google.gson.JsonObject r1 = r1.getNativeApiScopeConfig()
            java.lang.String r13 = com.cloud.tmc.integration.permission.AppPermissionUtils.getAggregationMainAppId(r13)
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L53:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L10c
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = r11.OooO00o(r12, r2)
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r4 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.Object r5 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r4)
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r5 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r5
            android.content.Context r6 = r11.OooO00o
            java.lang.String r5 = r5.getString(r6, r12, r3)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isThePermissionApplied,key: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = ",value: "
            r6.append(r3)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "Tmcintegration:LocalAuthPermissionManager"
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto Lab
            boolean r6 = android.text.TextUtils.isEmpty(r13)
            if (r6 != 0) goto Lab
            java.lang.String r5 = r11.OooO00o(r13, r2)
            java.lang.Object r6 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r4)
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r6 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r6
            android.content.Context r8 = r11.OooO00o
            java.lang.String r5 = r6.getString(r8, r12, r5)
        Lab:
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L53
            java.lang.String r5 = r11.OooO00o(r12, r2)
            java.lang.Object r6 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r4)
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r6 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r6
            android.content.Context r8 = r11.OooO00o
            java.lang.String r6 = r6.getString(r8, r12, r5)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "getPermissionByKey,key: "
            r8.append(r9)
            r8.append(r5)
            r8.append(r3)
            r8.append(r6)
            java.lang.String r3 = r8.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r3)
            java.lang.String r3 = "1"
            boolean r5 = android.text.TextUtils.equals(r6, r3)
            if (r5 == 0) goto Le4
            goto L100
        Le4:
            boolean r5 = android.text.TextUtils.isEmpty(r13)
            if (r5 != 0) goto L102
            java.lang.String r5 = r11.OooO00o(r13, r2)
            java.lang.Object r4 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r4)
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r4 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r4
            android.content.Context r6 = r11.OooO00o
            java.lang.String r4 = r4.getString(r6, r12, r5)
            boolean r3 = android.text.TextUtils.equals(r4, r3)
            if (r3 == 0) goto L102
        L100:
            r3 = 1
            goto L103
        L102:
            r3 = 0
        L103:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r0.put(r2, r3)
            goto L53
        L10c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.defaultimpl.DefaultAuthenticationProxyImpl.getAllPermissions(java.lang.String, java.lang.String, com.cloud.tmc.integration.model.AppModel):java.util.Map");
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public PermissionModel getPermissionModel(String str) {
        return this.OooO0OO.get(str);
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public List<Permission> getPermissions(String str) {
        List<String> jsapiList;
        PermissionModel permissionModel = this.OooO0OO.get(str);
        if (permissionModel == null || (jsapiList = permissionModel.getJsapiList()) == null || jsapiList.size() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jsapiList.size());
        for (String str2 : jsapiList) {
            arrayList.add(new BridgePermission(str2, str2));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00db, code lost:
    
        return r8.startsWith(com.cloud.tmc.integration.permission.PermissionConstant.JS_API_SP_CONFIG);
     */
    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean hasPermission(java.lang.String r6, java.lang.String r7, java.lang.String r8, com.cloud.tmc.integration.structure.Page r9) {
        /*
            r5 = this;
            java.lang.String r0 = com.cloud.tmc.miniapp.defaultimpl.DefaultAuthenticationProxyImpl.OooO0o
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "hasPermission "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " "
            r1.append(r2)
            r1.append(r7)
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r1)
            java.lang.Class<com.cloud.tmc.integration.extension.IgnorePermissionPoint> r0 = com.cloud.tmc.integration.extension.IgnorePermissionPoint.class
            com.cloud.tmc.integration.invoke.extension.ExtensionPoint r0 = com.cloud.tmc.integration.invoke.extension.ExtensionPoint.as(r0)
            com.cloud.tmc.integration.structure.App r9 = r9.getApp()
            com.cloud.tmc.integration.invoke.extension.ExtensionPoint r9 = r0.node(r9)
            com.cloud.tmc.kernel.extension.Extension r9 = r9.create()
            com.cloud.tmc.integration.extension.IgnorePermissionPoint r9 = (com.cloud.tmc.integration.extension.IgnorePermissionPoint) r9
            r0 = 1
            if (r9 == 0) goto L58
            boolean r9 = r9.ignoreAppPermission(r6)
            if (r9 == 0) goto L58
            java.lang.String r7 = com.cloud.tmc.miniapp.defaultimpl.DefaultAuthenticationProxyImpl.OooO0o
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "ignore hasPermission appid\t "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r6)
            return r0
        L58:
            java.lang.String r9 = r5.OooO0Oo     // Catch: java.lang.Exception -> L80
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> L80
            r1 = 0
            if (r9 != 0) goto L8d
            java.lang.String r9 = r5.OooO0Oo     // Catch: java.lang.Exception -> L80
            com.google.gson.JsonObject r9 = com.cloud.tmc.kernel.utils.JSONUtils.parseObject(r9)     // Catch: java.lang.Exception -> L80
            com.google.gson.JsonObject r2 = com.cloud.tmc.kernel.utils.JSONUtils.getJsonObject(r9, r6, r1)     // Catch: java.lang.Exception -> L80
            java.lang.String r3 = "yes"
            if (r2 == 0) goto L82
            int r4 = r2.size()     // Catch: java.lang.Exception -> L80
            if (r4 == 0) goto L82
            java.lang.String r9 = com.cloud.tmc.kernel.utils.JSONUtils.getString(r2, r8)     // Catch: java.lang.Exception -> L80
            boolean r9 = r3.equalsIgnoreCase(r9)     // Catch: java.lang.Exception -> L80
            if (r9 == 0) goto L8d
            return r0
        L80:
            r6 = move-exception
            goto Le1
        L82:
            java.lang.String r9 = com.cloud.tmc.kernel.utils.JSONUtils.getString(r9, r8)     // Catch: java.lang.Exception -> L80
            boolean r9 = r3.equalsIgnoreCase(r9)     // Catch: java.lang.Exception -> L80
            if (r9 == 0) goto L8d
            return r0
        L8d:
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L80
            if (r9 != 0) goto Ld3
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L80
            if (r9 != 0) goto Ld3
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> L80
            if (r9 != 0) goto Ld3
            java.util.Map<java.lang.String, com.cloud.tmc.integration.permission.model.ApiPermissionInfo> r9 = r5.OooO0O0     // Catch: java.lang.Exception -> L80
            if (r9 == 0) goto Ld3
            java.lang.Object r9 = r9.get(r6)     // Catch: java.lang.Exception -> L80
            if (r9 == 0) goto Ld3
            java.util.Map<java.lang.String, com.cloud.tmc.integration.permission.model.ApiPermissionInfo> r9 = r5.OooO0O0     // Catch: java.lang.Exception -> L80
            java.lang.Object r9 = r9.get(r6)     // Catch: java.lang.Exception -> L80
            com.cloud.tmc.integration.permission.model.ApiPermissionInfo r9 = (com.cloud.tmc.integration.permission.model.ApiPermissionInfo) r9     // Catch: java.lang.Exception -> L80
            java.util.List r9 = r9.getApiLevelList(r8)     // Catch: java.lang.Exception -> L80
            if (r9 == 0) goto Ld3
            java.util.Map<java.lang.String, com.cloud.tmc.integration.permission.model.ApiPermissionInfo> r9 = r5.OooO0O0     // Catch: java.lang.Exception -> L80
            java.lang.Object r9 = r9.get(r6)     // Catch: java.lang.Exception -> L80
            com.cloud.tmc.integration.permission.model.ApiPermissionInfo r9 = (com.cloud.tmc.integration.permission.model.ApiPermissionInfo) r9     // Catch: java.lang.Exception -> L80
            java.util.List r9 = r9.getApiLevelList(r8)     // Catch: java.lang.Exception -> L80
            boolean r9 = r9.isEmpty()     // Catch: java.lang.Exception -> L80
            if (r9 == 0) goto Lca
            goto Ld3
        Lca:
            java.util.Map<java.lang.String, com.cloud.tmc.integration.permission.model.ApiPermissionInfo> r9 = r5.OooO0O0     // Catch: java.lang.Exception -> L80
            java.lang.Object r6 = r9.get(r6)     // Catch: java.lang.Exception -> L80
            r1 = r6
            com.cloud.tmc.integration.permission.model.ApiPermissionInfo r1 = (com.cloud.tmc.integration.permission.model.ApiPermissionInfo) r1     // Catch: java.lang.Exception -> L80
        Ld3:
            if (r1 != 0) goto Ldc
            java.lang.String r6 = "JSAPI_SP_Config"
            boolean r6 = r8.startsWith(r6)     // Catch: java.lang.Exception -> L80
            return r6
        Ldc:
            boolean r6 = r5.OooO00o(r1, r7, r8)     // Catch: java.lang.Exception -> L80
            return r6
        Le1:
            java.lang.String r7 = com.cloud.tmc.miniapp.defaultimpl.DefaultAuthenticationProxyImpl.OooO0o
            java.lang.String r8 = "hasPermission Exception!"
            com.cloud.tmc.kernel.log.TmcLogger.e(r7, r8, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.defaultimpl.DefaultAuthenticationProxyImpl.hasPermission(java.lang.String, java.lang.String, java.lang.String, com.cloud.tmc.integration.structure.Page):boolean");
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean hasPermissionModel(String str, Page page) {
        if (TextUtils.isEmpty(str)) {
            str = page.getApp().getAppId();
        }
        return this.OooO0OO.containsKey(str);
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public void setPermissionModel(String str, PermissionModel permissionModel) {
        this.OooO0OO.put(str, permissionModel);
        this.OooO0O0.put(str, AppPermissionUtils.convert2ApiPermissionInfo(permissionModel));
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public void setPermissionState(String str, String str2, String str3, boolean z10) {
        if (this.OooO0o0 == null) {
            this.OooO0o0 = new OooO0O0(this.OooO00o);
        }
        AppModel appModel = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModel(this.OooO00o, AppInfoQuery.make(str2));
        OooO0O0 oooO0O0 = this.OooO0o0;
        String aggregationMainAppId = AppPermissionUtils.getAggregationMainAppId(appModel);
        oooO0O0.getClass();
        if ("userLogin".equals(str3)) {
            return;
        }
        String OooO00o = TextUtils.isEmpty(aggregationMainAppId) ? oooO0O0.OooO00o(str2, str3) : oooO0O0.OooO00o(aggregationMainAppId, str3);
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(oooO0O0.OooO00o, str2, OooO00o, z10 ? "1" : "0");
        TmcLogger.d("Tmcintegration:LocalAuthPermissionManager", "changePermissionState,key: " + OooO00o + ",opened: " + z10);
    }
}
