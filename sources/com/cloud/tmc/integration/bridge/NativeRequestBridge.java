package com.cloud.tmc.integration.bridge;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.IAbortCallback;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniutils.constant.PermissionConstants;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NativeRequestBridge implements BridgeExtension {
    public static final String KEY_CALLBACK_ID = "callbackId";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_FILE_PATH = "tempFilePath";
    public static final String KEY_TIME_OUT = "m-timeout";
    public static final String KEY_X_BYTE_APPID = "x-byte-appid";
    private static final String TAG = "NativeRequestBridge";
    private final String[] requestMethods = {"GET", "POST", "POST_JSON", "POST_MULTIPART", "PUT", "DELETE"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cloud.tmc.integration.bridge.NativeRequestBridge$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements PermissionUtils.SimpleCallback {
        final /* synthetic */ App val$app;
        final /* synthetic */ BridgeCallback val$callback;
        final /* synthetic */ String val$callbackId;
        final /* synthetic */ String val$filePath;
        final /* synthetic */ String val$header;
        final /* synthetic */ String val$saveName;
        final /* synthetic */ Long val$timeout;
        final /* synthetic */ String val$url;

        AnonymousClass4(String str, Long l11, App app, String str2, String str3, String str4, BridgeCallback bridgeCallback, String str5) {
            this.val$header = str;
            this.val$timeout = l11;
            this.val$app = app;
            this.val$url = str2;
            this.val$saveName = str3;
            this.val$filePath = str4;
            this.val$callback = bridgeCallback;
            this.val$callbackId = str5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0073 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0008, B:5:0x0013, B:7:0x0019, B:10:0x0026, B:13:0x0031, B:14:0x0049, B:16:0x0073, B:18:0x007c, B:19:0x0081, B:22:0x008b, B:24:0x0097, B:26:0x00ca, B:29:0x00e8, B:33:0x00f9, B:35:0x00ff, B:38:0x0127, B:41:0x00c5, B:43:0x0044), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0097 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0008, B:5:0x0013, B:7:0x0019, B:10:0x0026, B:13:0x0031, B:14:0x0049, B:16:0x0073, B:18:0x007c, B:19:0x0081, B:22:0x008b, B:24:0x0097, B:26:0x00ca, B:29:0x00e8, B:33:0x00f9, B:35:0x00ff, B:38:0x0127, B:41:0x00c5, B:43:0x0044), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00f9 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0008, B:5:0x0013, B:7:0x0019, B:10:0x0026, B:13:0x0031, B:14:0x0049, B:16:0x0073, B:18:0x007c, B:19:0x0081, B:22:0x008b, B:24:0x0097, B:26:0x00ca, B:29:0x00e8, B:33:0x00f9, B:35:0x00ff, B:38:0x0127, B:41:0x00c5, B:43:0x0044), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00c5 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0008, B:5:0x0013, B:7:0x0019, B:10:0x0026, B:13:0x0031, B:14:0x0049, B:16:0x0073, B:18:0x007c, B:19:0x0081, B:22:0x008b, B:24:0x0097, B:26:0x00ca, B:29:0x00e8, B:33:0x00f9, B:35:0x00ff, B:38:0x0127, B:41:0x00c5, B:43:0x0044), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$onGranted$0(java.lang.String r17, java.lang.Long r18, final com.cloud.tmc.integration.structure.App r19, java.lang.String r20, java.lang.String r21, final java.lang.String r22, final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r23, java.lang.String r24) {
            /*
                Method dump skipped, instructions count: 375
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NativeRequestBridge.AnonymousClass4.lambda$onGranted$0(java.lang.String, java.lang.Long, com.cloud.tmc.integration.structure.App, java.lang.String, java.lang.String, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback, java.lang.String):void");
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
        public void onDenied() {
            BridgeCallback bridgeCallback = this.val$callback;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(NativeRequestBridge.this.createFailResponse("D009", "Download Fail, no permission:D009", this.val$callbackId));
                this.val$callback.close();
            }
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
        public void onGranted() {
            ExecutorType executorType = ExecutorType.NETWORK;
            final String str = this.val$header;
            final Long l11 = this.val$timeout;
            final App app = this.val$app;
            final String str2 = this.val$url;
            final String str3 = this.val$saveName;
            final String str4 = this.val$filePath;
            final BridgeCallback bridgeCallback = this.val$callback;
            final String str5 = this.val$callbackId;
            ExecutorUtils.execute(executorType, new Runnable() { // from class: com.cloud.tmc.integration.bridge.i
                @Override // java.lang.Runnable
                public final void run() {
                    NativeRequestBridge.AnonymousClass4.this.lambda$onGranted$0(str, l11, app, str2, str3, str4, bridgeCallback, str5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JsonObject createFailResponse(String str, String str2, String str3) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("callbackId", str3);
        jsonObject.addProperty(NativeComponentConstants.KEY_COMPONENT_ERRCODE, str);
        jsonObject.addProperty(NotificationCompat.CATEGORY_MESSAGE, str2);
        return jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JsonObject createSuccessResponse(String str, String str2, Map<String, String> map, List<Cookie> list, String str3) {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.addProperty("statusCode", str);
            jsonObject.addProperty("response", str2);
            jsonObject.addProperty("headers", GsonUtils.toJson(map));
            jsonObject.addProperty("cookies", GsonUtils.toJson(list));
            jsonObject.addProperty("callbackId", str3);
        } catch (Throwable unused) {
        }
        return jsonObject;
    }

    private HashMap<String, String> jsonObjectToHashMap(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, jSONObject.getString(next));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return hashMap;
    }

    @ActionFilter
    @ThreadType(ExecutorType.NETWORK)
    public void abortDownloadRequest(@BindingParam(name = {"callbackId"}) final String str, @BindingCallback final BridgeCallback bridgeCallback) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).cancelDownloadCall(str, new IAbortCallback() { // from class: com.cloud.tmc.integration.bridge.NativeRequestBridge.11
                    @Override // com.cloud.tmc.kernel.proxy.network.IAbortCallback
                    public void fail(String str2) {
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendFailResponse(NativeRequestBridge.this.createFailResponse("D011", "Download Abort Fail," + str2 + ":D011", str));
                        }
                    }

                    @Override // com.cloud.tmc.kernel.proxy.network.IAbortCallback
                    public void success() {
                        if (bridgeCallback != null) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("callbackId", str);
                            bridgeCallback.sendSuccessResponse(jsonObject);
                        }
                    }
                });
            } else if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(createFailResponse("D009", "Download Abort Fail,callbackId is empty:D009", ""));
            }
        } catch (Throwable th2) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(createFailResponse("D010", "Download Abort Fail,Exception_" + th2.toString() + ":D010", ""));
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.NETWORK)
    public void abortHttpRequest(@BindingParam(name = {"callbackId"}) final String str, @BindingCallback final BridgeCallback bridgeCallback) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).cancelHttpRequest(str, new IAbortCallback() { // from class: com.cloud.tmc.integration.bridge.NativeRequestBridge.3
                    @Override // com.cloud.tmc.kernel.proxy.network.IAbortCallback
                    public void fail(String str2) {
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendFailResponse(NativeRequestBridge.this.createFailResponse("R007", "Http Request Abort Fail, " + str2 + ": R007", str));
                        }
                    }

                    @Override // com.cloud.tmc.kernel.proxy.network.IAbortCallback
                    public void success() {
                        if (bridgeCallback != null) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("callbackId", str);
                            bridgeCallback.sendSuccessResponse(jsonObject);
                        }
                    }
                });
            } else if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(createFailResponse("R006", "Http Request Abort Fail, callbackId is empty: R006", ""));
            }
        } catch (Throwable th2) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(createFailResponse("R008", "Http Request Abort Fail,Exception_" + th2.toString() + ":R008", str));
                bridgeCallback.close();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.NETWORK)
    public void abortUploadRequest(@BindingParam(name = {"callbackId"}) final String str, @BindingCallback final BridgeCallback bridgeCallback) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).cancelUploadCall(str, new IAbortCallback() { // from class: com.cloud.tmc.integration.bridge.NativeRequestBridge.12
                    @Override // com.cloud.tmc.kernel.proxy.network.IAbortCallback
                    public void fail(String str2) {
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendFailResponse(NativeRequestBridge.this.createFailResponse("U009", "UploadFile Abort Fail," + str2 + ":U009", str));
                        }
                    }

                    @Override // com.cloud.tmc.kernel.proxy.network.IAbortCallback
                    public void success() {
                        if (bridgeCallback != null) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("callbackId", str);
                            bridgeCallback.sendSuccessResponse(jsonObject);
                        }
                    }
                });
            } else if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(createFailResponse("U007", "UploadFile Abort Fail,callbackId is empty:U007", ""));
            }
        } catch (Throwable th2) {
            bridgeCallback.sendFailResponse(createFailResponse("U008", "UploadFile Abort Fail,Exception_" + th2.toString() + ":U008", ""));
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0091 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x000a, B:6:0x0014, B:7:0x0026, B:10:0x002a, B:12:0x0035, B:14:0x003b, B:17:0x0044, B:20:0x004f, B:21:0x0067, B:23:0x0091, B:25:0x009a, B:26:0x009f, B:29:0x00a9, B:31:0x00b5, B:32:0x00e5, B:34:0x00eb, B:37:0x0113, B:42:0x0062), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x000a, B:6:0x0014, B:7:0x0026, B:10:0x002a, B:12:0x0035, B:14:0x003b, B:17:0x0044, B:20:0x004f, B:21:0x0067, B:23:0x0091, B:25:0x009a, B:26:0x009f, B:29:0x00a9, B:31:0x00b5, B:32:0x00e5, B:34:0x00eb, B:37:0x0113, B:42:0x0062), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x000a, B:6:0x0014, B:7:0x0026, B:10:0x002a, B:12:0x0035, B:14:0x003b, B:17:0x0044, B:20:0x004f, B:21:0x0067, B:23:0x0091, B:25:0x009a, B:26:0x009f, B:29:0x00a9, B:31:0x00b5, B:32:0x00e5, B:34:0x00eb, B:37:0x0113, B:42:0x0062), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8  */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.NETWORK)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void downloadFile(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"url"}) java.lang.String r17, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"saveName"}) java.lang.String r18, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"header"}) java.lang.String r19, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"filePath"}) final java.lang.String r20, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"timeout"}) java.lang.Long r21, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"callbackId"}) java.lang.String r22, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback(isSticky = true) final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r23, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) final com.cloud.tmc.integration.structure.App r24) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NativeRequestBridge.downloadFile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback, com.cloud.tmc.integration.structure.App):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.NETWORK)
    public void innerAbortDownloadRequest(@BindingParam(name = {"callbackId"}) final String str, @BindingCallback final BridgeCallback bridgeCallback) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).cancelDownloadCall(str, new IAbortCallback() { // from class: com.cloud.tmc.integration.bridge.NativeRequestBridge.10
                    @Override // com.cloud.tmc.kernel.proxy.network.IAbortCallback
                    public void fail(String str2) {
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendFailResponse(NativeRequestBridge.this.createFailResponse("D011", "Download Abort Fail," + str2 + ":D011", str));
                        }
                    }

                    @Override // com.cloud.tmc.kernel.proxy.network.IAbortCallback
                    public void success() {
                        if (bridgeCallback != null) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("callbackId", str);
                            bridgeCallback.sendSuccessResponse(jsonObject);
                        }
                    }
                });
            } else if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(createFailResponse("D009", "Download Abort Fail,callbackId is empty:D009", ""));
            }
        } catch (Throwable th2) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(createFailResponse("D010", "Download Abort Fail,Exception_" + th2.toString() + ":D010", ""));
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void innerDownloadFile(@BindingParam(name = {"url"}) String str, @BindingParam(name = {"saveName"}) String str2, @BindingParam(name = {"header"}) String str3, @BindingParam(name = {"filePath"}) String str4, @BindingParam(name = {"timeout"}) Long l11, @BindingParam(name = {"callbackId"}) String str5, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback, @BindingNode(App.class) App app) {
        try {
            PermissionUtils.permissionGroup(PermissionConstants.STORAGE_WRITE).callback(new AnonymousClass4(str3, l11, app, str, str2, str4, bridgeCallback, str5)).request();
        } catch (Throwable th2) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(createFailResponse("D002", "Download Fail,Exception_" + th2.toString() + ":D002", str5));
                bridgeCallback.close();
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x009b A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01be A[Catch: all -> 0x0020, TRY_LEAVE, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ef A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f7 A[Catch: all -> 0x0020, TRY_LEAVE, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.NETWORK)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void request(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"url"}) java.lang.String r16, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"dataJson"}) java.lang.String r17, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"header"}) java.lang.String r18, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"method"}) java.lang.String r19, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"timeout"}) java.lang.Long r20, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"callbackId"}) java.lang.String r21, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r22, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r23) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NativeRequestBridge.request(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback, com.cloud.tmc.integration.structure.App):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009b A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01be A[Catch: all -> 0x0020, TRY_LEAVE, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ef A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f7 A[Catch: all -> 0x0020, TRY_LEAVE, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0009, B:6:0x0011, B:8:0x0016, B:12:0x0024, B:16:0x0030, B:18:0x0037, B:19:0x003c, B:22:0x0044, B:24:0x0050, B:26:0x005b, B:27:0x0055, B:30:0x0062, B:33:0x006d, B:34:0x0087, B:36:0x009b, B:38:0x00a7, B:40:0x00b2, B:41:0x00ac, B:42:0x00b5, B:43:0x00c3, B:54:0x0112, B:55:0x0137, B:57:0x0153, B:59:0x0169, B:61:0x017f, B:63:0x0194, B:65:0x01a9, B:67:0x01be, B:69:0x00c7, B:72:0x00d1, B:75:0x00db, B:78:0x00e5, B:81:0x00ef, B:84:0x00f7, B:87:0x0082), top: B:2:0x0009 }] */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.NETWORK)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void requestV2(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"url"}) java.lang.String r16, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"dataJson"}) java.lang.String r17, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"header"}) java.lang.String r18, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"method"}) java.lang.String r19, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"timeout"}) java.lang.Long r20, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"callbackId"}) java.lang.String r21, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r22, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r23) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NativeRequestBridge.requestV2(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback, com.cloud.tmc.integration.structure.App):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0148, code lost:
    
        r25.sendFailResponse(createFailResponse("U003", "UploadFile fail,file:" + r0 + " is not exist:U003", r24));
        r25.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x016a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016d, code lost:
    
        r25.sendFailResponse(createFailResponse("U001", "UploadFile fail,url is not startsWith http:U001", r24));
        r25.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x017b, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.util.Map] */
    @com.cloud.tmc.kernel.annotation.ActionFilter("")
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void uploadFile(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"url"}) java.lang.String r18, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"filePath"}) java.lang.String r19, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"name"}) java.lang.String r20, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"header"}) java.lang.String r21, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"formData"}) java.lang.String r22, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"timeout"}) java.lang.Long r23, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"callbackId"}) java.lang.String r24, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback(isSticky = true) final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r25, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r26) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NativeRequestBridge.uploadFile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback, com.cloud.tmc.integration.structure.App):void");
    }
}
