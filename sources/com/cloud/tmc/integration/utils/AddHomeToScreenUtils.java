package com.cloud.tmc.integration.utils;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.hisavana.sdk.o5;
import com.cloud.hisavana.sdk.r5;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.R;
import com.cloud.tmc.integration.broadcast.ShortCutBroadcast;
import com.cloud.tmc.integration.callback.LocalAuthPermissionCallback;
import com.cloud.tmc.integration.model.AddToHomeScreenStore;
import com.cloud.tmc.integration.model.MiniAddHomeDataModel;
import com.cloud.tmc.integration.model.MiniAddHomeModel;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.proxy.ITaskQueueProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.CreateShortCutUtils;
import com.cloud.tmc.integration.utils.ext.FileExtKt;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniutils.util.EncryptUtils;
import com.cloud.tmc.miniutils.util.ImageUtils;
import com.cloud.tmc.miniutils.util.ResourceUtils;
import com.google.gson.JsonObject;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ<\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J2\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J \u0010\u0018\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J>\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ&\u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0002J*\u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001a\u0010)\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J<\u0010*\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\bH\u0003J<\u0010.\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010-\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010\"\u001a\u00020\bH\u0002JB\u0010/\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u00100\u001a\u0002012\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0003J\u001a\u00102\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u0002052\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J0\u00106\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/cloud/tmc/integration/utils/AddHomeToScreenUtils;", "", "()V", "TAG", "", "miniAppIconSet", "", "checkAddhomeShowStatus", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "app", "Lcom/cloud/tmc/integration/structure/App;", "checkAndDownloadIcon", "", "context", "Landroid/content/Context;", "appId", MiniAppIpcConfig.IPC_ADDHOME_APP_NAME, "appLogoUrl", "currentLogoUrlMd5", "callback", "Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "checkAndUpdateScreenIcon", "checkAppLogoIsChanged", "checkAppNameIsChanged", "createIconBitmap", "Landroid/graphics/Bitmap;", "path", "createShortcutByLogoUrl", "bean", "Lcom/cloud/tmc/integration/model/MiniAddHomeDataModel;", "fromLocation", "showConfirmDialog", "showSuccessToast", "downloadMiniAppIconFile", "miniAppIconCallback", "Lcom/cloud/tmc/integration/utils/CreateShortCutUtils$MiniAppIconCallback;", "downloadMiniAppLogo", "appModel", "miniAppIconPath", "getBadgeLogo", "postApi26CreateShortcut", "scClass", "Ljava/lang/Class;", "addHomeType", "requestAddHome", "requestUpdateAddhomeIcon", "sm", "Landroid/content/pm/ShortcutManager;", "saveAddHomeStatus", "setExtra", "intent", "Landroid/content/Intent;", "updateAddHomeNameAndIcon", "appLogoMd5", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AddHomeToScreenUtils {
    public static final AddHomeToScreenUtils INSTANCE = new AddHomeToScreenUtils();
    private static final String TAG = "AddHomeToScreenUtils";
    private static final Set<String> miniAppIconSet = new CopyOnWriteArraySet();

    private AddHomeToScreenUtils() {
    }

    public static /* synthetic */ void checkAndDownloadIcon$default(AddHomeToScreenUtils addHomeToScreenUtils, Context context, String str, String str2, String str3, String str4, BridgeCallback bridgeCallback, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            bridgeCallback = null;
        }
        addHomeToScreenUtils.checkAndDownloadIcon(context, str, str2, str3, str4, bridgeCallback);
    }

    public static /* synthetic */ void checkAndUpdateScreenIcon$default(AddHomeToScreenUtils addHomeToScreenUtils, Context context, String str, String str2, String str3, BridgeCallback bridgeCallback, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            bridgeCallback = null;
        }
        addHomeToScreenUtils.checkAndUpdateScreenIcon(context, str, str2, str3, bridgeCallback);
    }

    private final boolean checkAppLogoIsChanged(Context context, String appId, String currentLogoUrlMd5) {
        try {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, TmcConstants.KEY_STORAGE_ADD_HOME, "addHomeLogo_" + appId);
            if (string == null) {
                string = "";
            }
            boolean z10 = !Intrinsics.c(currentLogoUrlMd5, string);
            TmcLogger.d(TAG, "checkAppLogoIsChanged return " + z10);
            return z10;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "checkAppLogoIsChanged:", th2);
            return false;
        }
    }

    private final boolean checkAppNameIsChanged(Context context, String appId, String r82) {
        try {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, TmcConstants.KEY_STORAGE_ADD_HOME, "addHomeName_" + appId);
            if (string == null) {
                string = "";
            }
            boolean z10 = !Intrinsics.c(string, r82);
            TmcLogger.d(TAG, "checkAppNameIsChanged -> return " + z10);
            return z10;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "checkAppNameIsChanged", th2);
            return false;
        }
    }

    public final Bitmap createIconBitmap(String path) {
        return ImageUtils.getBitmap(path);
    }

    public static /* synthetic */ void createShortcutByLogoUrl$default(AddHomeToScreenUtils addHomeToScreenUtils, Context context, MiniAddHomeDataModel miniAddHomeDataModel, String str, boolean z10, boolean z11, App app, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        boolean z12 = z10;
        if ((i11 & 16) != 0) {
            z11 = true;
        }
        boolean z13 = z11;
        if ((i11 & 32) != 0) {
            app = null;
        }
        addHomeToScreenUtils.createShortcutByLogoUrl(context, miniAddHomeDataModel, str, z12, z13, app);
    }

    private final void downloadMiniAppIconFile(final Context context, final MiniAddHomeDataModel bean, final CreateShortCutUtils.MiniAppIconCallback miniAppIconCallback) {
        try {
            if (bean == null) {
                if (miniAppIconCallback != null) {
                    miniAppIconCallback.onFail();
                    return;
                }
                return;
            }
            String lastPathSegment = Uri.parse(bean.getAppLogoUrl()).getLastPathSegment();
            final String str = ((PathProxy) TmcProxy.get(PathProxy.class)).getBaseMiniAppPath(bean.getAppId()) + File.separator + lastPathSegment;
            if (new File(str).exists()) {
                if (miniAppIconCallback != null) {
                    miniAppIconCallback.onSuccess(str);
                    return;
                }
                return;
            }
            if (bean.getAppId().length() == 0) {
                if (miniAppIconCallback != null) {
                    miniAppIconCallback.onFail();
                    return;
                }
                return;
            }
            Set<String> set = miniAppIconSet;
            if (set.contains(bean.getAppId())) {
                return;
            }
            set.add(bean.getAppId());
            if (MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_SHOW_ADD_HOME_USE_ASSETS, true)) {
                ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.utils.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AddHomeToScreenUtils.downloadMiniAppIconFile$lambda$6(MiniAddHomeDataModel.this, str, miniAppIconCallback, context);
                    }
                });
                return;
            }
            TmcLogger.d(TAG, "Not the default appId, download icon ->" + bean.getAppId());
            downloadMiniAppLogo(context, bean, str, miniAppIconCallback);
        } catch (Exception e11) {
            TmcLogger.e(TAG, "Download icon file fail", e11);
            if (miniAppIconCallback != null) {
                miniAppIconCallback.onFail();
            }
        }
    }

    static /* synthetic */ void downloadMiniAppIconFile$default(AddHomeToScreenUtils addHomeToScreenUtils, Context context, MiniAddHomeDataModel miniAddHomeDataModel, CreateShortCutUtils.MiniAppIconCallback miniAppIconCallback, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            miniAppIconCallback = null;
        }
        addHomeToScreenUtils.downloadMiniAppIconFile(context, miniAddHomeDataModel, miniAppIconCallback);
    }

    public static final void downloadMiniAppIconFile$lambda$6(MiniAddHomeDataModel miniAddHomeDataModel, String miniAppIconPath, CreateShortCutUtils.MiniAppIconCallback miniAppIconCallback, Context context) {
        Intrinsics.h(miniAppIconPath, "$miniAppIconPath");
        Intrinsics.h(context, "$context");
        String encryptMD5ToString = EncryptUtils.encryptMD5ToString(miniAddHomeDataModel.getAppLogoUrl());
        Intrinsics.g(encryptMD5ToString, "encryptMD5ToString(bean.appLogoUrl)");
        String lowerCase = encryptMD5ToString.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        try {
            if (ResourceUtils.copyFileFromAssets("mini_offline/miniapp_addhome/" + CreateShortCutUtils.INSTANCE.getKEY_ADD_HOME_FILE_PREFIX() + lowerCase + ".png", miniAppIconPath)) {
                TmcLogger.d(TAG, "use assets icon ->" + miniAddHomeDataModel.getAppId());
                miniAppIconSet.remove(miniAddHomeDataModel.getAppId());
                if (miniAppIconCallback != null) {
                    miniAppIconCallback.onSuccess(miniAppIconPath);
                    return;
                }
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
        TmcLogger.d(TAG, "download icon ->" + miniAddHomeDataModel.getAppId());
        INSTANCE.downloadMiniAppLogo(context, miniAddHomeDataModel, miniAppIconPath, miniAppIconCallback);
    }

    private final void downloadMiniAppLogo(final Context context, final MiniAddHomeDataModel appModel, final String miniAppIconPath, final CreateShortCutUtils.MiniAppIconCallback miniAppIconCallback) {
        ExecutorUtils.execute(ExecutorType.NETWORK, new Runnable() { // from class: com.cloud.tmc.integration.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                AddHomeToScreenUtils.downloadMiniAppLogo$lambda$9(context, appModel, miniAppIconCallback, miniAppIconPath);
            }
        });
    }

    public static final void downloadMiniAppLogo$lambda$9(Context context, MiniAddHomeDataModel appModel, CreateShortCutUtils.MiniAppIconCallback miniAppIconCallback, String miniAppIconPath) {
        Unit unit;
        Intrinsics.h(context, "$context");
        Intrinsics.h(appModel, "$appModel");
        Intrinsics.h(miniAppIconPath, "$miniAppIconPath");
        boolean useDefaultAddScreenLogo = CreateShortCutUtils.INSTANCE.useDefaultAddScreenLogo(context, StringExtKt.orDefault(appModel.getAppLogoUrl(), ""), miniAppIconCallback);
        try {
            try {
                File loadImgFile = ((ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class)).loadImgFile(context, StringExtKt.orDefault(appModel.getAppLogoUrl(), ""));
                if (loadImgFile != null) {
                    boolean moveTo$default = FileExtKt.moveTo$default(loadImgFile, new File(miniAppIconPath), false, false, 6, null);
                    if (!useDefaultAddScreenLogo) {
                        if (moveTo$default) {
                            if (miniAppIconCallback != null) {
                                miniAppIconCallback.onSuccess(miniAppIconPath);
                            }
                        } else if (miniAppIconCallback != null) {
                            miniAppIconCallback.onFail();
                        }
                    }
                    unit = Unit.f67184a;
                } else {
                    unit = null;
                }
                if (unit == null && !useDefaultAddScreenLogo && miniAppIconCallback != null) {
                    miniAppIconCallback.onFail();
                }
                Set<String> set = miniAppIconSet;
                if (set.contains(appModel.getAppId())) {
                    set.remove(appModel.getAppId());
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "downloadMiniAppIconFile", th2);
            }
        } catch (Throwable th3) {
            try {
                TmcLogger.e(TAG, "downloadMiniAppIconFile", th3);
                if (!useDefaultAddScreenLogo && miniAppIconCallback != null) {
                    miniAppIconCallback.onFail();
                }
                Set<String> set2 = miniAppIconSet;
                if (set2.contains(appModel.getAppId())) {
                    set2.remove(appModel.getAppId());
                }
            } catch (Throwable th4) {
                try {
                    Set<String> set3 = miniAppIconSet;
                    if (set3.contains(appModel.getAppId())) {
                        set3.remove(appModel.getAppId());
                    }
                } catch (Throwable th5) {
                    TmcLogger.e(TAG, "downloadMiniAppIconFile", th5);
                }
                throw th4;
            }
        }
    }

    public final String getBadgeLogo(Context context, String r22) {
        return r22;
    }

    private final void postApi26CreateShortcut(final Context context, Class<?> scClass, final MiniAddHomeDataModel bean, final int addHomeType, final String fromLocation, final boolean showSuccessToast) {
        final ShortcutManager a11;
        boolean isRequestPinShortcutSupported;
        AddToHomeScreenStore addToHomeScreenStore;
        HashMap<String, BridgeCallback> store;
        BridgeCallback remove;
        final String appId = bean.getAppId();
        if (Build.VERSION.SDK_INT < 26 || (a11 = com.bytedance.sdk.openadsdk.api.init.b.a(context.getSystemService(com.bytedance.sdk.openadsdk.api.init.a.a()))) == null) {
            return;
        }
        isRequestPinShortcutSupported = a11.isRequestPinShortcutSupported();
        if (isRequestPinShortcutSupported) {
            AppUtils appUtils = AppUtils.INSTANCE;
            if (!appUtils.queytShortcutBySystemApi(context, appId)) {
                final Intent intent = new Intent("com.cloud.tmc.miniapp.shortcut");
                intent.setComponent(new ComponentName(context, (Class<?>) ShortCutBroadcast.class));
                intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, "approve");
                intent.putExtra(TmcConstants.EXTRA_APP_ID, bean.getAppId());
                final boolean checkShowCustomAddhomeDialog$default = AppUtils.checkShowCustomAddhomeDialog$default(appUtils, context, false, 2, null);
                final Intent intent2 = new Intent(context, scClass);
                intent2.setAction(appId);
                setExtra(intent2, bean.getAppId());
                downloadMiniAppIconFile(context, bean, new CreateShortCutUtils.MiniAppIconCallback() { // from class: com.cloud.tmc.integration.utils.AddHomeToScreenUtils$postApi26CreateShortcut$2
                    @Override // com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback
                    public void onFail() {
                        String str;
                        AddToHomeScreenStore addToHomeScreenStore2;
                        HashMap<String, BridgeCallback> store2;
                        BridgeCallback remove2;
                        String str2;
                        ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_create_fail_no_icon));
                        CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
                        createShortCutUtils.mobCreateShortcutEvent(appId, 2, "trigger failed");
                        try {
                            App app = createShortCutUtils.getAppMap().get(bean.getAppId());
                            if (app == null || (addToHomeScreenStore2 = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) == null || (store2 = addToHomeScreenStore2.getStore()) == null || (remove2 = store2.remove(bean.getAppId())) == null) {
                                return;
                            }
                            JsonObject jsonObject = new JsonObject();
                            Context context2 = context;
                            String str3 = appId;
                            str2 = AddHomeToScreenUtils.TAG;
                            TmcLogger.d(str2, "发送 addHomeToScreen callback received");
                            jsonObject.addProperty(TmcConstants.KEY_STORAGE_ADD_HOME_IS_EXIST, Boolean.valueOf(AppUtils.INSTANCE.queryShortcutExist(context2, str3)));
                            remove2.sendSuccessResponse(jsonObject);
                        } catch (Throwable th2) {
                            str = AddHomeToScreenUtils.TAG;
                            TmcLogger.e(str, "", th2);
                        }
                    }

                    @Override // com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback
                    public void onSuccess(String path) {
                        String str;
                        String str2;
                        AddToHomeScreenStore addToHomeScreenStore2;
                        HashMap<String, BridgeCallback> store2;
                        BridgeCallback remove2;
                        String str3;
                        ShortcutInfo.Builder shortLabel;
                        Bitmap createIconBitmap;
                        ShortcutInfo.Builder icon;
                        String badgeLogo;
                        ShortcutInfo.Builder longLabel;
                        ShortcutInfo.Builder intent3;
                        ShortcutInfo.Builder extras;
                        ShortcutInfo build;
                        String str4;
                        Intrinsics.h(path, "path");
                        try {
                            r5.a();
                            ShortcutInfo.Builder a12 = o5.a(context, appId);
                            String appName = bean.getAppName();
                            String str5 = "";
                            if (appName == null) {
                                appName = "";
                            }
                            shortLabel = a12.setShortLabel(appName);
                            AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.INSTANCE;
                            createIconBitmap = addHomeToScreenUtils.createIconBitmap(path);
                            icon = shortLabel.setIcon(Icon.createWithBitmap(createIconBitmap));
                            Context context2 = context;
                            String appName2 = bean.getAppName();
                            if (appName2 != null) {
                                str5 = appName2;
                            }
                            badgeLogo = addHomeToScreenUtils.getBadgeLogo(context2, str5);
                            longLabel = icon.setLongLabel(badgeLogo);
                            intent3 = longLabel.setIntent(intent2);
                            PersistableBundle persistableBundle = new PersistableBundle();
                            MiniAddHomeDataModel miniAddHomeDataModel = bean;
                            int i11 = addHomeType;
                            boolean z10 = checkShowCustomAddhomeDialog$default;
                            String str6 = fromLocation;
                            boolean z11 = showSuccessToast;
                            persistableBundle.putString("appId", miniAddHomeDataModel.getAppId());
                            persistableBundle.putString("scene_id", TmcConstants.SHORTCUT_SCENE_ID);
                            persistableBundle.putInt(TmcConstants.EXTRA_ADD_HOME_TYPE, i11);
                            persistableBundle.putBoolean(TmcConstants.EXTRA_ADD_HOME_SHOW_SYSTEM_DIALOG, !z10);
                            persistableBundle.putString(TmcConstants.EXTRA_ADD_HOME_LOCATION, str6);
                            persistableBundle.putBoolean(TmcConstants.EXTRA_ADD_HOME_SHOW_SUCCESS_TOAST, z11);
                            extras = intent3.setExtras(persistableBundle);
                            build = extras.build();
                            Intrinsics.g(build, "Builder(context, appId)\n…               }).build()");
                            a11.requestPinShortcut(build, PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, ASTNode.PCTX_STORED).getIntentSender());
                            boolean isLauncher = AppUtils.INSTANCE.isLauncher(context);
                            str4 = AddHomeToScreenUtils.TAG;
                            TmcLogger.d(str4, "添加桌面快捷方式，是否为 isLauncher: " + isLauncher);
                            if (!isLauncher && showSuccessToast) {
                                ITaskQueueProxy iTaskQueueProxy = (ITaskQueueProxy) TmcProxy.get(ITaskQueueProxy.class);
                                final Context context3 = context;
                                iTaskQueueProxy.addAppTask("addHomeToScreen", new Function0<Unit>() { // from class: com.cloud.tmc.integration.utils.AddHomeToScreenUtils$postApi26CreateShortcut$2$onSuccess$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m694invoke();
                                        return Unit.f67184a;
                                    }

                                    /* renamed from: invoke, reason: collision with other method in class */
                                    public final void m694invoke() {
                                        ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context3.getResources().getString(R.string.smallapp_create_success));
                                    }
                                });
                            }
                            CreateShortCutUtils.INSTANCE.mobCreateShortcutEvent(appId, 1, "trigger success");
                        } catch (Throwable th2) {
                            CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
                            createShortCutUtils.mobCreateShortcutEvent(appId, 3, "trigger happened exception:" + th2);
                            str = AddHomeToScreenUtils.TAG;
                            TmcLogger.e(str, "downloadMiniAppIconFile ->" + th2);
                            try {
                                App app = createShortCutUtils.getAppMap().get(appId);
                                if (app == null || (addToHomeScreenStore2 = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) == null || (store2 = addToHomeScreenStore2.getStore()) == null || (remove2 = store2.remove(appId)) == null) {
                                    return;
                                }
                                JsonObject jsonObject = new JsonObject();
                                Context context4 = context;
                                String str7 = appId;
                                str3 = AddHomeToScreenUtils.TAG;
                                TmcLogger.d(str3, "发送 addHomeToScreen callback received");
                                jsonObject.addProperty(TmcConstants.KEY_STORAGE_ADD_HOME_IS_EXIST, Boolean.valueOf(AppUtils.INSTANCE.queryShortcutExist(context4, str7)));
                                remove2.sendSuccessResponse(jsonObject);
                            } catch (Throwable th3) {
                                str2 = AddHomeToScreenUtils.TAG;
                                TmcLogger.e(str2, "onDenied", th3);
                            }
                        }
                    }
                });
                return;
            }
            ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_already_exist, bean.getAppName()));
            App app = CreateShortCutUtils.INSTANCE.getAppMap().get(bean.getAppId());
            if (app == null || (addToHomeScreenStore = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) == null || (store = addToHomeScreenStore.getStore()) == null || (remove = store.remove(bean.getAppId())) == null) {
                return;
            }
            JsonObject jsonObject = new JsonObject();
            TmcLogger.d(TAG, "发送 addHomeToScreen callback received");
            jsonObject.addProperty(TmcConstants.KEY_STORAGE_ADD_HOME_IS_EXIST, Boolean.TRUE);
            remove.sendSuccessResponse(jsonObject);
        }
    }

    public final void requestAddHome(MiniAddHomeDataModel bean, String fromLocation, int addHomeType, Context context, Class<?> scClass, boolean showSuccessToast) {
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String appId = bean.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_SHORT_CUT;
            Bundle bundle = new Bundle();
            bundle.putString("object_id", "14");
            bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, fromLocation);
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
            CreateShortCutUtils.INSTANCE.getAddHomeData().put(bean.getAppId(), new MiniAddHomeModel(fromLocation, addHomeType, showSuccessToast));
            saveAddHomeStatus(context, bean.getAppId());
            if (Build.VERSION.SDK_INT >= 26) {
                postApi26CreateShortcut(context, scClass, bean, addHomeType, fromLocation, showSuccessToast);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "createShortcut ->" + th2);
        }
    }

    public final void requestUpdateAddhomeIcon(Context context, String appId, String r11, String path, ShortcutManager sm2, String currentLogoUrlMd5, BridgeCallback callback) {
        ShortcutInfo.Builder shortLabel;
        ShortcutInfo.Builder icon;
        ShortcutInfo.Builder longLabel;
        ShortcutInfo.Builder intent;
        ShortcutInfo.Builder extras;
        ShortcutInfo build;
        Class<?> launcherShortCutActivity = ((StartActivityProxy) TmcProxy.get(StartActivityProxy.class)).getLauncherShortCutActivity();
        Intrinsics.g(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
        Intent intent2 = new Intent(context, launcherShortCutActivity);
        intent2.setAction(appId);
        setExtra(intent2, appId);
        shortLabel = o5.a(context, appId).setShortLabel(r11);
        icon = shortLabel.setIcon(Icon.createWithBitmap(createIconBitmap(path)));
        longLabel = icon.setLongLabel(getBadgeLogo(context, r11));
        intent = longLabel.setIntent(intent2);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("appId", appId);
        persistableBundle.putString("scene_id", TmcConstants.SHORTCUT_SCENE_ID);
        persistableBundle.putBoolean(TmcConstants.EXTRA_ADD_HOME_SHOW_SYSTEM_DIALOG, false);
        extras = intent.setExtras(persistableBundle);
        build = extras.build();
        Intrinsics.g(build, "Builder(context, appId)\n… )\n            }).build()");
        if (Build.VERSION.SDK_INT >= 26) {
            sm2.updateShortcuts(CollectionsKt.h(build));
            updateAddHomeNameAndIcon$default(this, context, appId, r11, currentLogoUrlMd5, null, 16, null);
            if (callback != null) {
                callback.sendSuccessResponse();
            }
        }
    }

    private final void saveAddHomeStatus(Context context, String appId) {
        if (AppUtils.INSTANCE.isLauncher(context) || appId == null || appId.length() == 0) {
            return;
        }
        try {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, appId, TmcConstants.KEY_SHOW_ADD_HOME, true);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    private final void setExtra(Intent intent, String appId) {
        intent.putExtra("appId", appId);
        intent.putExtra("scene_id", TmcConstants.SHORTCUT_SCENE_ID);
    }

    public static /* synthetic */ void updateAddHomeNameAndIcon$default(AddHomeToScreenUtils addHomeToScreenUtils, Context context, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str4 = "";
        }
        addHomeToScreenUtils.updateAddHomeNameAndIcon(context, str, str2, str3, str4);
    }

    public static final void updateAddHomeNameAndIcon$lambda$14(String appId, String appLogoMd5, String appName, Context context, String appLogoUrl) {
        Intrinsics.h(appId, "$appId");
        Intrinsics.h(appLogoMd5, "$appLogoMd5");
        Intrinsics.h(appName, "$appName");
        Intrinsics.h(context, "$context");
        Intrinsics.h(appLogoUrl, "$appLogoUrl");
        try {
            if (appId.length() == 0) {
                TmcLogger.d(TAG, "updateAddHomeNameAndIcon appId is empty");
                return;
            }
            if (appLogoMd5.length() == 0) {
                appLogoMd5 = EncryptUtils.encryptMD5ToString(appLogoUrl);
            }
            TmcLogger.d(TAG, "updateAddHomeNameAndIcon -> appid: " + appId + ",appName:" + appName + ",appLogoMd5:" + appLogoMd5);
            KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addHomeName_");
            sb2.append(appId);
            kVStorageProxy.putString(context, TmcConstants.KEY_STORAGE_ADD_HOME, sb2.toString(), appName);
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, TmcConstants.KEY_STORAGE_ADD_HOME, "addHomeLogo_" + appId, appLogoMd5);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "updateAddHomeNameAndIcon", th2);
        }
    }

    public final boolean checkAddhomeShowStatus(int r62, App app) {
        if (app == null) {
            return false;
        }
        boolean addHomeShowStatus = r62 <= 100 ? app.getAddHomeShowStatus(100) : false;
        if (addHomeShowStatus) {
            return true;
        }
        if (r62 <= 90) {
            addHomeShowStatus = app.getAddHomeShowStatus(90);
        }
        if (addHomeShowStatus) {
            return true;
        }
        if (r62 <= 83) {
            addHomeShowStatus = app.getAddHomeShowStatus(83);
        }
        if (addHomeShowStatus) {
            return true;
        }
        if (r62 <= 82) {
            addHomeShowStatus = app.getAddHomeShowStatus(82);
        }
        if (addHomeShowStatus) {
            return true;
        }
        if (r62 <= 81) {
            addHomeShowStatus = app.getAddHomeShowStatus(82);
        }
        return addHomeShowStatus;
    }

    public final void checkAndDownloadIcon(final Context context, final String appId, final String r14, String appLogoUrl, final String currentLogoUrlMd5, final BridgeCallback callback) {
        boolean isRequestPinShortcutSupported;
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(r14, "appName");
        Intrinsics.h(appLogoUrl, "appLogoUrl");
        Intrinsics.h(currentLogoUrlMd5, "currentLogoUrlMd5");
        final ShortcutManager a11 = com.bytedance.sdk.openadsdk.api.init.b.a(context.getSystemService(com.bytedance.sdk.openadsdk.api.init.a.a()));
        if (a11 != null) {
            isRequestPinShortcutSupported = a11.isRequestPinShortcutSupported();
            if (isRequestPinShortcutSupported) {
                String lastPathSegment = Uri.parse(appLogoUrl).getLastPathSegment();
                String str = ((PathProxy) TmcProxy.get(PathProxy.class)).getBaseMiniAppPath(appId) + File.separator + lastPathSegment;
                if (new File(str).exists()) {
                    requestUpdateAddhomeIcon(context, appId, r14, str, a11, currentLogoUrlMd5, callback);
                    return;
                } else {
                    downloadMiniAppLogo(context, new MiniAddHomeDataModel(appId, r14, appLogoUrl), str, new CreateShortCutUtils.MiniAppIconCallback() { // from class: com.cloud.tmc.integration.utils.AddHomeToScreenUtils$checkAndDownloadIcon$1
                        @Override // com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback
                        public void onFail() {
                            String str2;
                            str2 = AddHomeToScreenUtils.TAG;
                            TmcLogger.d(str2, "add shortcut fail,appId:" + appId);
                            BridgeCallback bridgeCallback = callback;
                            if (bridgeCallback != null) {
                                bridgeCallback.sendFailResponse();
                            }
                        }

                        @Override // com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback
                        public void onSuccess(String path) {
                            Intrinsics.h(path, "path");
                            AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.INSTANCE;
                            Context context2 = context;
                            String str2 = appId;
                            String str3 = r14;
                            ShortcutManager sm2 = a11;
                            Intrinsics.g(sm2, "sm");
                            addHomeToScreenUtils.requestUpdateAddhomeIcon(context2, str2, str3, path, sm2, currentLogoUrlMd5, callback);
                        }
                    });
                    return;
                }
            }
        }
        TmcLogger.d(TAG, "checkAndUpdateScreenIcon: not support");
        if (callback != null) {
            callback.sendFailResponse();
        }
    }

    public final void checkAndUpdateScreenIcon(Context context, String appId, String r102, String appLogoUrl, BridgeCallback callback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(r102, "appName");
        Intrinsics.h(appLogoUrl, "appLogoUrl");
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 26) {
                TmcLogger.d(TAG, "checkAndUpdateScreenIcon: api < 26");
                if (callback != null) {
                    callback.sendFailResponse();
                    return;
                }
                return;
            }
            if (!AppUtils.INSTANCE.queytShortcutBySystemApi(context, appId)) {
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, TmcConstants.KEY_STORAGE_ADD_HOME, "addHomeStatus_" + appId, false);
                if (callback != null) {
                    callback.sendFailResponse();
                }
                TmcLogger.d(TAG, "checkAndUpdateScreenIcon -> " + appId + " is not add to home screen");
                return;
            }
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, TmcConstants.KEY_STORAGE_ADD_HOME, "addHomeStatus_" + appId, true);
            if (!MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_UPDATE_ADD_HOME_ICON, true)) {
                TmcLogger.d(TAG, "updateScreenIcon: enable is false, return");
                if (callback != null) {
                    callback.sendFailResponse();
                    return;
                }
                return;
            }
            if (appId.length() == 0) {
                if (callback != null) {
                    callback.sendFailResponse();
                }
                TmcLogger.d(TAG, "checkAndUpdateScreenIcon -> appId is null");
                return;
            }
            String currentLogoUrlMd5 = EncryptUtils.encryptMD5ToString(appLogoUrl);
            if (r102.length() != 0 && appLogoUrl.length() != 0) {
                if (!checkAppNameIsChanged(context, appId, r102)) {
                    Intrinsics.g(currentLogoUrlMd5, "currentLogoUrlMd5");
                    if (!checkAppLogoIsChanged(context, appId, currentLogoUrlMd5)) {
                        return;
                    }
                }
                if (i11 >= 26) {
                    Intrinsics.g(currentLogoUrlMd5, "currentLogoUrlMd5");
                    checkAndDownloadIcon(context, appId, r102, appLogoUrl, currentLogoUrlMd5, callback);
                    return;
                }
                return;
            }
            TmcLogger.d(TAG, "checkAndUpdateScreenIcon -> appName or logo is null,appName->" + r102 + ",appLogoUrl->" + appLogoUrl);
            if (callback != null) {
                callback.sendFailResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "checkAndUpdateScreenIcon", th2);
        }
    }

    public final void createShortcutByLogoUrl(final Context context, final MiniAddHomeDataModel bean, final String fromLocation, boolean showConfirmDialog, final boolean showSuccessToast, App app) {
        AddToHomeScreenStore addToHomeScreenStore;
        HashMap<String, BridgeCallback> store;
        BridgeCallback remove;
        Intrinsics.h(context, "context");
        Intrinsics.h(bean, "bean");
        Intrinsics.h(fromLocation, "fromLocation");
        AppUtils appUtils = AppUtils.INSTANCE;
        boolean checkShowCustomAddhomeDialog = appUtils.checkShowCustomAddhomeDialog(context, showConfirmDialog);
        String str = TAG;
        TmcLogger.d(str, "showAddHomeCustomDialog = " + checkShowCustomAddhomeDialog);
        final Class<?> launcherShortCutActivity = ((StartActivityProxy) TmcProxy.get(StartActivityProxy.class)).getLauncherShortCutActivity();
        Intrinsics.g(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
        final int i11 = -1;
        if (!checkShowCustomAddhomeDialog) {
            requestAddHome(bean, fromLocation, -1, context, launcherShortCutActivity, showSuccessToast);
            return;
        }
        if (!checkAddhomeShowStatus(90, app)) {
            ((DialogProxy) TmcProxy.get(DialogProxy.class)).showAddHomeConfirmDialog(context, bean.getAppName(), bean.getAppLogoUrl(), bean.getAppId(), fromLocation, new LocalAuthPermissionCallback() { // from class: com.cloud.tmc.integration.utils.AddHomeToScreenUtils$createShortcutByLogoUrl$2
                @Override // com.cloud.tmc.integration.callback.LocalAuthPermissionCallback
                public void onDenied() {
                    String str2;
                    AddToHomeScreenStore addToHomeScreenStore2;
                    HashMap<String, BridgeCallback> store2;
                    BridgeCallback remove2;
                    String str3;
                    try {
                        App app2 = CreateShortCutUtils.INSTANCE.getAppMap().get(MiniAddHomeDataModel.this.getAppId());
                        if (app2 == null || (addToHomeScreenStore2 = (AddToHomeScreenStore) app2.getData(AddToHomeScreenStore.class)) == null || (store2 = addToHomeScreenStore2.getStore()) == null || (remove2 = store2.remove(MiniAddHomeDataModel.this.getAppId())) == null) {
                            return;
                        }
                        JsonObject jsonObject = new JsonObject();
                        Context context2 = context;
                        MiniAddHomeDataModel miniAddHomeDataModel = MiniAddHomeDataModel.this;
                        str3 = AddHomeToScreenUtils.TAG;
                        TmcLogger.d(str3, "发送 addHomeToScreen callback received");
                        jsonObject.addProperty(TmcConstants.KEY_STORAGE_ADD_HOME_IS_EXIST, Boolean.valueOf(AppUtils.INSTANCE.queryShortcutExist(context2, miniAddHomeDataModel.getAppId())));
                        remove2.sendSuccessResponse(jsonObject);
                    } catch (Throwable th2) {
                        str2 = AddHomeToScreenUtils.TAG;
                        TmcLogger.e(str2, th2);
                    }
                }

                @Override // com.cloud.tmc.integration.callback.LocalAuthPermissionCallback
                public void onGranted(Object obj) {
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                    String appId = MiniAddHomeDataModel.this.getAppId();
                    Bundle bundle = new Bundle();
                    bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, fromLocation);
                    Unit unit = Unit.f67184a;
                    performanceAnalyseProxy.recordForCommon(appId, "second_add_cl", bundle);
                    AddHomeToScreenUtils.INSTANCE.requestAddHome(MiniAddHomeDataModel.this, fromLocation, i11, context, launcherShortCutActivity, showSuccessToast);
                }
            });
            if (app != null) {
                app.updateAddHomeShowStatus(90);
                return;
            }
            return;
        }
        App app2 = CreateShortCutUtils.INSTANCE.getAppMap().get(bean.getAppId());
        if (app2 == null || (addToHomeScreenStore = (AddToHomeScreenStore) app2.getData(AddToHomeScreenStore.class)) == null || (store = addToHomeScreenStore.getStore()) == null || (remove = store.remove(bean.getAppId())) == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        TmcLogger.d(str, "发送 addHomeToScreen callback received");
        jsonObject.addProperty(TmcConstants.KEY_STORAGE_ADD_HOME_IS_EXIST, Boolean.valueOf(appUtils.queryShortcutExist(context, bean.getAppId())));
        remove.sendSuccessResponse(jsonObject);
    }

    public final void updateAddHomeNameAndIcon(final Context context, final String appId, final String r11, final String appLogoMd5, final String appLogoUrl) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(r11, "appName");
        Intrinsics.h(appLogoMd5, "appLogoMd5");
        Intrinsics.h(appLogoUrl, "appLogoUrl");
        try {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    AddHomeToScreenUtils.updateAddHomeNameAndIcon$lambda$14(appId, appLogoMd5, r11, context, appLogoUrl);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "updateAddHomeNameAndIcon", th2);
        }
    }
}
