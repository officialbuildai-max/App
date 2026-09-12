package com.cloud.tmc.kernel.bridge;

import com.google.gson.JsonObject;
import java.util.HashMap;

/* loaded from: classes3.dex */
public interface SendToNativeCallback {
    public static final String KEY_CODE = "error";
    public static final String KEY_MESSAGE = "errorMessage";

    void onCallback(JsonObject jsonObject, boolean z10, boolean z11);

    void onCallback(HashMap<String, Object> hashMap, boolean z10, boolean z11);
}
