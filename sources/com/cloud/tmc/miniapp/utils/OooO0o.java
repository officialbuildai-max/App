package com.cloud.tmc.miniapp.utils;

import android.content.Context;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO0o {
    public static final OooO0o OooO00o = new OooO0o();
    public static ConcurrentHashMap<String, JsonObject> OooO0O0;

    /* JADX WARN: Multi-variable type inference failed */
    public final ConcurrentHashMap<String, JsonObject> OooO00o(Context context) {
        if (OooO0O0 == null) {
            OooO0O0 = new ConcurrentHashMap<>();
            String[] mMKVFileAllKeys = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getMMKVFileAllKeys(context, "miniMsgChangedProvider");
            Intrinsics.g(mMKVFileAllKeys, "get(KVStorageProxy::clas…KEY_CHANGED_MSG_PROVIDER)");
            for (String it : mMKVFileAllKeys) {
                Intrinsics.g(it, "it");
                if (StringsKt.W(it, "change_msg_switch_", false, 2, null)) {
                    String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgChangedProvider", it);
                    if (string == null) {
                        string = "";
                    }
                    Intrinsics.g(string, "TmcProxy.get(KVStoragePr…D_MSG_PROVIDER, it) ?: \"\"");
                    ConcurrentHashMap<String, JsonObject> concurrentHashMap = OooO0O0;
                    if (concurrentHashMap != 0) {
                    }
                }
            }
        }
        return OooO0O0;
    }

    public final void OooO00o(Context context, long j11) {
        Set<Map.Entry<String, JsonObject>> entrySet;
        long currentTimeMillis;
        JsonElement jsonElement;
        String asString;
        Intrinsics.h(context, "context");
        try {
            ConcurrentHashMap<String, JsonObject> OooO00o2 = OooO00o(context);
            if (OooO00o2 == null || (entrySet = OooO00o2.entrySet()) == null) {
                return;
            }
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                JsonObject jsonObject = (JsonObject) entry.getValue();
                if (jsonObject == null || (jsonElement = jsonObject.get("appSwitchTimestamp")) == null || (asString = jsonElement.getAsString()) == null) {
                    currentTimeMillis = System.currentTimeMillis();
                } else {
                    Intrinsics.g(asString, "asString");
                    currentTimeMillis = Long.parseLong(asString);
                }
                TmcLogger.d("MiniappMsgDataProvider", "clearChangedMsgSwitchList timestamp->" + j11 + ",appSwitchTimestamp=" + currentTimeMillis);
                if (j11 >= currentTimeMillis) {
                    TmcLogger.d("MiniappMsgDataProvider", "clearChangedMsgSwitchList remove key->" + entry.getKey());
                    OooO00o2.remove(entry.getKey());
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).remove(context, "miniMsgChangedProvider", "change_msg_switch_" + entry.getKey());
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e("MiniappMsgDataProvider", "clearChangedMsgSwitchList", th2);
        }
    }

    public final void OooO00o(Context context, String appId, String status) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(status, "status");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(TmcConstants.KEY_MINI_APPID, appId);
        jsonObject.addProperty("appSwitchStatus", status);
        jsonObject.addProperty("appSwitchTimestamp", String.valueOf(System.currentTimeMillis()));
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "msgObj.toString()");
        TmcLogger.d("MiniappMsgDataProvider", "changeMsgSwitchStatus msgStr = " + jsonElement);
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "msg_switch_" + appId, jsonElement);
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgChangedProvider", "change_msg_switch_" + appId, jsonElement);
        ConcurrentHashMap<String, JsonObject> OooO00o2 = OooO00o(context);
        if (OooO00o2 != null) {
            OooO00o2.put("change_msg_switch_" + appId, jsonObject);
        }
    }

    public final boolean OooO00o(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        if (!Intrinsics.c(OooO0o0(context).getFirst(), "1")) {
            TmcLogger.d("MiniappMsgDataProvider", "main switch is closed");
            return false;
        }
        String OooO0O02 = OooO0O0(context, appId);
        if (OooO0O02.length() <= 0) {
            TmcLogger.d("MiniappMsgDataProvider", "msgSwitch " + appId + " empty,status is closed");
            return false;
        }
        JsonElement jsonElement = ((JsonObject) GsonUtils.fromJson(OooO0O02, JsonObject.class)).get("appSwitchStatus");
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        if (asString == null) {
            asString = "";
        }
        if (Intrinsics.c(asString, "1")) {
            return true;
        }
        TmcLogger.d("MiniappMsgDataProvider", "msgSwitch " + appId + " status is closed");
        return false;
    }

    public final JsonArray OooO0O0(Context context) {
        Set<Map.Entry<String, JsonObject>> entrySet;
        Intrinsics.h(context, "context");
        JsonArray jsonArray = new JsonArray();
        ConcurrentHashMap<String, JsonObject> OooO00o2 = OooO00o(context);
        if (OooO00o2 != null && (entrySet = OooO00o2.entrySet()) != null) {
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                jsonArray.add((JsonElement) ((Map.Entry) it.next()).getValue());
            }
        }
        TmcLogger.d("MiniappMsgDataProvider", "getChangedMsgSwitchList-> " + jsonArray);
        return jsonArray;
    }

    public final String OooO0O0(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "msg_switch_" + appId);
        return string == null ? "" : string;
    }

    public final String OooO0OO(Context context) {
        Intrinsics.h(context, "context");
        try {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "miniLatestUnreadMsg");
            if (string != null) {
                return string;
            }
            TmcLogger.d("MiniappMsgDataProvider", "getLatestUnreadMsg -> ");
            return "";
        } catch (Throwable th2) {
            TmcLogger.e("MiniappMsgDataProvider", th2);
            return "";
        }
    }

    public final void OooO0OO(Context context, String msgStr) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgStr, "msgStr");
        try {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, "miniMsgProvider", "miniLatestUnreadMsg", msgStr);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, TmcConstants.KEY_MSG_ID, TmcConstants.KEY_MINI_NEW_MESSAGE_STATUS, !Intrinsics.c(msgStr, ""));
        } catch (Throwable th2) {
            TmcLogger.e("MiniappMsgDataProvider", th2);
        }
    }

    public final JsonObject OooO0Oo(Context context) {
        Intrinsics.h(context, "context");
        try {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "miniMsgUnreadData");
            TmcLogger.d("MiniappMsgDataProvider", "getMsgUnreadNumber-> " + string);
            JsonObject jsonObject = (string == null || string.length() <= 0) ? new JsonObject() : (JsonObject) GsonUtils.fromJson(string, JsonObject.class);
            Intrinsics.g(jsonObject, "{\n            val unread…)\n            }\n        }");
            return jsonObject;
        } catch (Throwable th2) {
            TmcLogger.e("MiniappMsgDataProvider", th2);
            return new JsonObject();
        }
    }

    public final void OooO0Oo(Context context, String unreadMsgData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(unreadMsgData, "unreadMsgData");
        try {
            TmcLogger.d("MiniappMsgDataProvider", "updateMsgUnreadNumber unreadMsgData:" + unreadMsgData);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "miniMsgUnreadData");
        } catch (Throwable th2) {
            TmcLogger.e("MiniappMsgDataProvider", th2);
        }
    }

    public final Pair<String, String> OooO0o0(Context context) {
        String str;
        String str2;
        String string;
        Intrinsics.h(context, "context");
        str = "";
        try {
            string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, "miniMsgProvider", "mainMsgSwitch");
        } catch (Throwable unused) {
        }
        if (string != null && string.length() > 0) {
            JsonObject jsonObject = (JsonObject) GsonUtils.fromJson(string, JsonObject.class);
            JsonElement jsonElement = jsonObject.get("mainSwitchStatus");
            String asString = jsonElement != null ? jsonElement.getAsString() : null;
            if (asString == null) {
                asString = "";
            }
            JsonElement jsonElement2 = jsonObject.get("mainSwitchTimestamp");
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            str2 = asString2 != null ? asString2 : "";
            str = asString;
            return TuplesKt.a(str, str2);
        }
        str2 = "";
        return TuplesKt.a(str, str2);
    }
}
