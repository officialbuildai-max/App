package com.cloud.tmc.integration.permission;

import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.permission.config.ApiPermissionHelper;
import com.cloud.tmc.kernel.extension.bridge.BridgePermission;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.JSONUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class PermissionConfig {
    public static final String GROUPS = "groups";
    private static final String TAG = "Tmcintegration:PermissionConfig";
    public static final String WHITELIST = "whitelist";
    private static PermissionConfig instance;
    private static boolean isInit;
    private Map<String, Map<String, Permission>> groupPermissionMap = new HashMap();
    private Map<String, List<String>> permissionWhiteList = new HashMap();
    private Set<String> allPermission = new HashSet();

    private PermissionConfig() {
        initConfig();
    }

    public static PermissionConfig getInstance() {
        PermissionConfig permissionConfig = instance;
        if (permissionConfig != null) {
            return permissionConfig;
        }
        synchronized (PermissionConfig.class) {
            try {
                if (instance == null) {
                    instance = new PermissionConfig();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return instance;
    }

    private void putConfig(String str) {
        JsonObject jsonObject;
        if (TextUtils.isEmpty(str)) {
            TmcLogger.d(TAG, "permissionConfig is empty");
            return;
        }
        try {
            jsonObject = JSONUtils.parseObject(str);
        } catch (Exception e11) {
            TmcLogger.e(TAG, e11);
            jsonObject = null;
        }
        if (jsonObject == null || jsonObject.size() == 0) {
            TmcLogger.d(TAG, "permissionConfig json object is empty");
            return;
        }
        for (String str2 : jsonObject.keySet()) {
            if (TextUtils.isEmpty(str2) || !(jsonObject.get(str2) instanceof JsonObject)) {
                TmcLogger.d(TAG, jsonObject.get(str2) + " is not JsonObject ");
            } else {
                JsonObject jsonObject2 = (JsonObject) jsonObject.get(str2);
                if (jsonObject2 == null || jsonObject2.size() == 0) {
                    TmcLogger.d(TAG, jsonObject.get(str2) + " json object is empty ");
                } else {
                    Iterator<JsonElement> it = JSONUtils.getJsonArray(jsonObject2, GROUPS, new JsonArray()).iterator();
                    while (it.hasNext()) {
                        String asString = it.next().getAsString();
                        BridgePermission bridgePermission = new BridgePermission(str2, str2);
                        Map<String, Permission> map = this.groupPermissionMap.get(asString);
                        if (map == null) {
                            map = new HashMap<>();
                            this.groupPermissionMap.put(asString, map);
                        }
                        map.put(str2, bridgePermission);
                        this.allPermission.add(str2);
                    }
                }
            }
        }
    }

    private void setWhitelist(String str, JsonObject jsonObject) {
        JsonArray jsonArray;
        if (jsonObject == null || TextUtils.isEmpty(str) || (jsonArray = JSONUtils.getJsonArray(jsonObject, "whitelist", null)) == null || jsonArray.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                arrayList.add((String) next);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        List<String> list = this.permissionWhiteList.get(str);
        if (list == null) {
            this.permissionWhiteList.put(str, arrayList);
        } else {
            list.addAll(arrayList);
        }
    }

    public Map<String, Map<String, Permission>> getGroupPermissionMap() {
        return this.groupPermissionMap;
    }

    public void initConfig() {
        if (isInit) {
            return;
        }
        isInit = true;
        String presetPermissionStr = ApiPermissionHelper.getPresetPermissionStr();
        long[] jArr = {System.currentTimeMillis()};
        putConfig(presetPermissionStr);
        TmcLogger.d(TAG, "put OFFLINE config speed time:" + (System.currentTimeMillis() - jArr[0]));
        ConfigService configService = (ConfigService) TmcProxy.get(ConfigService.class);
        if (configService != null) {
            String configString = configService.getConfigString("jsapiPermission", MiniAppConfigHelper.DEFAULT_JS_API_PERMISSION);
            if (!TextUtils.isEmpty(configString)) {
                jArr[0] = System.currentTimeMillis();
                putConfig(configString);
                TmcLogger.d(TAG, "put ONLINE config speed time:" + (System.currentTimeMillis() - jArr[0]));
            }
            TmcLogger.debug(TAG, "from online config  " + configString);
        }
    }

    public boolean isNeedCheckPermission(Permission permission) {
        return this.allPermission.contains(permission.authority()) || "rpc".equalsIgnoreCase(permission.authority());
    }
}
