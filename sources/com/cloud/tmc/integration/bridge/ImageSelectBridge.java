package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.bridge.ImageSelectBridge;
import com.cloud.tmc.integration.callback.ISaveImgCallback;
import com.cloud.tmc.integration.callback.OnPhotoSelectListener;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.proxy.ImageSelectProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.ImageSaveUtils;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.integration.utils.RegexUtils;
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
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniutils.constant.PermissionConstants;
import com.cloud.tmc.miniutils.util.FileUtils;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.ImageUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ImageSelectBridge implements BridgeExtension {
    public static final String ERROR_MSG_CM001 = "Failed choose image from album, unknowError: CM001";
    public static final String ERROR_MSG_CM002 = "Failed take photo from camera, unknowError: CM002";
    public static final String TAG = "ImageSelectBridge";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cloud.tmc.integration.bridge.ImageSelectBridge$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements OnPhotoSelectListener {
        final /* synthetic */ App val$app;
        final /* synthetic */ BridgeCallback val$callback;

        AnonymousClass1(BridgeCallback bridgeCallback, App app) {
            this.val$callback = bridgeCallback;
            this.val$app = app;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSelected$0(ArrayList arrayList, App app, IImageResourceManager iImageResourceManager, List list, BridgeCallback bridgeCallback) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                try {
                    String str = (String) arrayList.get(i11);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(((PathProxy) TmcProxy.get(PathProxy.class)).getAppBaseFilePath(app.getAppId()));
                    char c11 = File.separatorChar;
                    sb2.append(c11);
                    sb2.append(TmcConstants.TEMP_DATA_PATH);
                    sb2.append(c11);
                    sb2.append(FileUtils.getFileByPath(str).getName());
                    String sb3 = sb2.toString();
                    FileUtils.copy(str, sb3);
                    File file = new File(sb3);
                    list.add(ImageSelectBridge.this.getMediaObject(file, iImageResourceManager.generateVUrl(file.getAbsolutePath(), app.getAppId(), file.getName(), true)));
                } catch (Throwable th2) {
                    TmcLogger.e(ImageSelectBridge.TAG, th2);
                    if (bridgeCallback != null) {
                        bridgeCallback.sendFailResponse();
                        return;
                    }
                    return;
                }
            }
            if (bridgeCallback != null) {
                JsonObject image = ImageSelectBridge.this.getImage(list);
                TmcLogger.d(ImageSelectBridge.TAG, image.toString());
                bridgeCallback.sendSuccessResponse(image);
            }
        }

        @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
        public void onAuthorized(boolean z10) {
            BridgeCallback bridgeCallback;
            if (z10 || (bridgeCallback = this.val$callback) == null) {
                return;
            }
            bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed choose image from album, no permission: CM002").build());
        }

        @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
        public void onCancel() {
            BridgeCallback bridgeCallback = this.val$callback;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed choose image from album, cencel select: CM003").build());
            }
        }

        @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
        public void onDialogClickCancel() {
        }

        @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
        public void onSelected(@NonNull final ArrayList<String> arrayList) {
            final IImageResourceManager imageResourceManagerProxy = this.val$app.getImageResourceManagerProxy();
            final ArrayList arrayList2 = new ArrayList();
            ExecutorType executorType = ExecutorType.IO;
            final App app = this.val$app;
            final BridgeCallback bridgeCallback = this.val$callback;
            ExecutorUtils.execute(executorType, new Runnable() { // from class: com.cloud.tmc.integration.bridge.h
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSelectBridge.AnonymousClass1.this.lambda$onSelected$0(arrayList, app, imageResourceManagerProxy, arrayList2, bridgeCallback);
                }
            });
        }

        @Override // com.cloud.tmc.integration.callback.OnPhotoSelectListener
        public void onSelected(@NonNull ArrayList<String> arrayList, @Nullable ArrayList<Integer> arrayList2, boolean z10) {
        }
    }

    private void chooseMediaFromAlbum(App app, int i11, BridgeCallback bridgeCallback, Context context) {
        if (app.getAppContext() == null || context == null) {
            return;
        }
        try {
            imageSelect(context, i11, app, bridgeCallback);
        } catch (Exception e11) {
            TmcLogger.e(TAG, e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JsonObject getImage(@NonNull List<HashMap<String, Object>> list) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tempFiles", GsonUtils.toJson(list));
        jsonObject.addProperty("mediaType", "image");
        return jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> getMediaObject(File file, String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(NativeRequestBridge.KEY_TEMP_FILE_PATH, str);
        hashMap.put("size", Long.valueOf(FileUtils.getLength(file)));
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int i11 = options.outHeight;
            int i12 = options.outWidth;
            hashMap.put("height", Integer.valueOf(i11));
            hashMap.put("width", Integer.valueOf(i12));
        } catch (Throwable th2) {
            hashMap.put("height", 0);
            hashMap.put("width", 0);
            TmcLogger.e(TAG, th2);
        }
        hashMap.put("fileType", "image");
        return hashMap;
    }

    private void imageSelect(Context context, int i11, App app, BridgeCallback bridgeCallback) {
        if (app == null || TextUtils.isEmpty(app.getAppId())) {
            bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", ERROR_MSG_CM001).build());
        } else {
            ((ImageSelectProxy) TmcProxy.get(ImageSelectProxy.class)).imageSelect(context, i11, new AnonymousClass1(bridgeCallback, app));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveImageToPhotosAlbum$0(final App app, final BridgeCallback bridgeCallback, final String str) {
        try {
            AppContext appContext = app.getAppContext();
            if (appContext == null) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed saved image to album, download result is empty: SA005").build());
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context != null) {
                ImageSaveUtils.saveImage(ImageUtils.getBitmap(((ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class)).loadImgFile(context, str)), new ISaveImgCallback() { // from class: com.cloud.tmc.integration.bridge.ImageSelectBridge.3
                    @Override // com.cloud.tmc.integration.callback.ISaveImgCallback
                    public void onFail(int i11, @Nullable String str2) {
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed saved image to album, download failed: SA003").build());
                        }
                    }

                    @Override // com.cloud.tmc.integration.callback.ISaveImgCallback
                    public void onSuccess(File file) {
                        app.getImageResourceManagerProxy().generateVUrl(str, app.getAppId(), file.getName());
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendSuccessResponse(new JsonObject());
                        }
                    }
                });
            } else if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed saved image to album, download result is empty: SA005").build());
            }
        } catch (Throwable unused) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed saved image to album, download failed: SA003").build());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean showPreviewImages(boolean z10, int i11, BridgeCallback bridgeCallback, Context context, JsonArray jsonArray) {
        try {
            int max = Math.max(0, i11 - 1);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<JsonElement> it = jsonArray.iterator();
            while (it.hasNext()) {
                String asString = it.next().getAsString();
                if (!TextUtils.isEmpty(asString) && RegexUtils.isURL(asString)) {
                    arrayList.add(asString);
                }
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed preview image, url is not a valid URL: PI004").build());
                }
                return true;
            }
            if (max >= arrayList.size()) {
                max = arrayList.size() - 1;
            }
            ((ImageSelectProxy) TmcProxy.get(ImageSelectProxy.class)).imagePreview(context, arrayList, z10, max, bridgeCallback);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed preview image, unknowError : PI003").build());
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void chooseMedia(@BindingNode(App.class) App app, @BindingParam(name = {"count"}) int i11, @BindingParam(name = {"mediaType"}) JsonArray jsonArray, @BindingParam(name = {"sourceType"}) JsonArray jsonArray2, @BindingParam(name = {"maxDuration"}) int i12, @BindingParam(name = {"sizeType"}) JsonArray jsonArray3, @BindingParam(name = {"camera"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", ERROR_MSG_CM001).build());
                return;
            }
            return;
        }
        AppContext appContext = app.getAppContext();
        if (appContext == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", ERROR_MSG_CM001).build());
                return;
            }
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", ERROR_MSG_CM001).build());
                return;
            }
            return;
        }
        for (int i13 = 0; i13 < jsonArray2.size(); i13++) {
            if (jsonArray2.get(i13).getAsString().equals("camera")) {
                chooseMediaFromAlbum(app, i11, bridgeCallback, context);
                return;
            }
        }
        chooseMediaFromAlbum(app, i11, bridgeCallback, context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
    
        r11.sendFailResponse(com.cloud.tmc.integration.utils.JsonObjectUtils.create().addProperty("errMsg", "Original file not exists: CI10003").build());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
    
        return;
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void compressImage(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r6, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"src"}) java.lang.String r7, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(intDefault = 80, name = {"quality"}) int r8, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"compressedWidth"}) int r9, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"compressedHeight"}) int r10, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r11) {
        /*
            r5 = this;
            java.lang.String r0 = "Parameter error: CI10001"
            java.lang.String r1 = "errMsg"
            if (r6 == 0) goto Lab
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 == 0) goto Le
            goto Lab
        Le:
            if (r8 < 0) goto L97
            r2 = 100
            if (r8 <= r2) goto L16
            goto L97
        L16:
            java.io.File r7 = com.cloud.tmc.integration.utils.FileUtil.getFile(r6, r7)     // Catch: java.lang.Throwable -> L6a
            if (r7 == 0) goto L6c
            boolean r2 = com.cloud.tmc.integration.utils.FileUtil.access(r7)     // Catch: java.lang.Throwable -> L6a
            if (r2 != 0) goto L23
            goto L6c
        L23:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r2.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.Class<com.cloud.tmc.integration.proxy.PathProxy> r3 = com.cloud.tmc.integration.proxy.PathProxy.class
            java.lang.Object r3 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r3)     // Catch: java.lang.Throwable -> L6a
            com.cloud.tmc.integration.proxy.PathProxy r3 = (com.cloud.tmc.integration.proxy.PathProxy) r3     // Catch: java.lang.Throwable -> L6a
            java.lang.String r4 = r6.getAppId()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = r3.getAppBaseFilePath(r4)     // Catch: java.lang.Throwable -> L6a
            r2.append(r3)     // Catch: java.lang.Throwable -> L6a
            char r3 = java.io.File.separatorChar     // Catch: java.lang.Throwable -> L6a
            r2.append(r3)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = "temp_data"
            r2.append(r3)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6a
            java.io.File r7 = com.cloud.tmc.integration.utils.compress.ImageCompressionUtils.compressImage(r7, r8, r9, r10, r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r6 = r6.getAppId()     // Catch: java.lang.Throwable -> L6a
            r8 = 0
            java.lang.String r6 = com.cloud.tmc.integration.utils.FileUtil.notifyNewFileGenerateVUrl(r6, r8, r7)     // Catch: java.lang.Throwable -> L6a
            if (r11 == 0) goto L96
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r7 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r8 = "tempFilePath"
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r7.addProperty(r8, r6)     // Catch: java.lang.Throwable -> L6a
            com.google.gson.JsonObject r6 = r6.build()     // Catch: java.lang.Throwable -> L6a
            r11.sendSuccessResponse(r6)     // Catch: java.lang.Throwable -> L6a
            goto L96
        L6a:
            r6 = move-exception
            goto L80
        L6c:
            if (r11 == 0) goto L7f
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r7 = "Original file not exists: CI10003"
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r1, r7)     // Catch: java.lang.Throwable -> L6a
            com.google.gson.JsonObject r6 = r6.build()     // Catch: java.lang.Throwable -> L6a
            r11.sendFailResponse(r6)     // Catch: java.lang.Throwable -> L6a
        L7f:
            return
        L80:
            java.lang.String r7 = "ImageSelectBridge"
            com.cloud.tmc.kernel.log.TmcLogger.e(r7, r6)
            if (r11 == 0) goto L96
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r1, r0)
            com.google.gson.JsonObject r6 = r6.build()
            r11.sendFailResponse(r6)
        L96:
            return
        L97:
            if (r11 == 0) goto Laa
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()
            java.lang.String r7 = "Quality must be 0..100: CI10002"
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r1, r7)
            com.google.gson.JsonObject r6 = r6.build()
            r11.sendFailResponse(r6)
        Laa:
            return
        Lab:
            if (r11 == 0) goto Lbc
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = com.cloud.tmc.integration.utils.JsonObjectUtils.create()
            com.cloud.tmc.integration.utils.JsonObjectUtils$Builder r6 = r6.addProperty(r1, r0)
            com.google.gson.JsonObject r6 = r6.build()
            r11.sendFailResponse(r6)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.ImageSelectBridge.compressImage(com.cloud.tmc.integration.structure.App, java.lang.String, int, int, int, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
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
    @ThreadType(ExecutorType.UI)
    public void previewImage(@BindingNode(App.class) App app, @BindingParam(name = {"urls"}) String str, @BindingParam(name = {"showmenu"}) final boolean z10, @BindingParam(name = {"current"}) final int i11, @BindingCallback final BridgeCallback bridgeCallback) {
        JsonArray jsonArray;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null || TextUtils.isEmpty(str)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed preview image, parameter error: PI001").build());
                return;
            }
            return;
        }
        try {
            jsonArray = JsonParser.parseString(str).getAsJsonArray();
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "Failed to parse", th2);
            jsonArray = null;
        }
        final JsonArray jsonArray2 = jsonArray;
        if (jsonArray2 != null && !jsonArray2.isEmpty()) {
            final Context context = app.getAppContext().getContext();
            PermissionUtils.permissionGroup(PermissionConstants.STORAGE_READ).callback(new PermissionUtils.SimpleCallback() { // from class: com.cloud.tmc.integration.bridge.ImageSelectBridge.2
                @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
                public void onDenied() {
                    ((DialogProxy) TmcProxy.get(DialogProxy.class)).showStoragePermissionDialog(context, null, null);
                    BridgeCallback bridgeCallback2 = bridgeCallback;
                    if (bridgeCallback2 != null) {
                        bridgeCallback2.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed preview image, no permission : PI002").build());
                    }
                }

                @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
                public void onGranted() {
                    ImageSelectBridge.showPreviewImages(z10, i11, bridgeCallback, context, jsonArray2);
                }
            }).request();
        } else if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed preview image, parameter error: PI001").build());
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public void saveImageToPhotosAlbum(@BindingNode(App.class) final App app, @BindingParam(name = {"filePath"}) final String str, @BindingCallback final BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null || str == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed saved image to album, unknown Error: SA001").build());
                return;
            }
            return;
        }
        try {
            if (!str.contains(".miniapp.transsion.com")) {
                ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageSelectBridge.this.lambda$saveImageToPhotosAlbum$0(app, bridgeCallback, str);
                    }
                });
                return;
            }
            String imagePath = app.getImageResourceManagerProxy().getImagePath(str);
            if (imagePath == null) {
                imagePath = app.getIFileResourceManager().getFilePath(app.getAppId(), str);
            }
            if (imagePath == null) {
                imagePath = ((IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class)).getFilePath(app.getAppId(), str);
            }
            if (imagePath != null) {
                ImageSaveUtils.saveImage(ImageUtils.getBitmap(new File(imagePath)), new ISaveImgCallback() { // from class: com.cloud.tmc.integration.bridge.ImageSelectBridge.4
                    @Override // com.cloud.tmc.integration.callback.ISaveImgCallback
                    public void onFail(int i11, @Nullable String str2) {
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed saved image to album, save failed: SA002").build());
                        }
                    }

                    @Override // com.cloud.tmc.integration.callback.ISaveImgCallback
                    public void onSuccess(File file) {
                        BridgeCallback bridgeCallback2 = bridgeCallback;
                        if (bridgeCallback2 != null) {
                            bridgeCallback2.sendSuccessResponse(new JsonObject());
                        }
                    }
                });
            } else if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed saved image to album, error path: SA004").build());
            }
        } catch (Exception e11) {
            TmcLogger.e("[ImageSelectBridge]: Failed saved image to Album", e11);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "Failed saved image to album, unknown Error: SA001").build());
            }
        }
    }
}
