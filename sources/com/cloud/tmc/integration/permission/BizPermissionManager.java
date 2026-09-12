package com.cloud.tmc.integration.permission;

import com.google.gson.JsonObject;

/* loaded from: classes3.dex */
public interface BizPermissionManager {
    boolean checkBizParamPermission(String str, String str2, JsonObject jsonObject);
}
