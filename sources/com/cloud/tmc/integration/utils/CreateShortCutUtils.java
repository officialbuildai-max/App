package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.R;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAddHomeModel;
import com.cloud.tmc.integration.model.MiniAppCenterInfoData;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.ext.FileExtKt;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.BundleUtils;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniutils.util.EncryptUtils;
import com.cloud.tmc.miniutils.util.ImageUtils;
import com.cloud.tmc.miniutils.util.ResourceUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001DB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J6\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u001dH\u0007JJ\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u001d2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+H\u0007J0\u0010-\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0002J&\u0010-\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0002J*\u00102\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020.2\u0006\u00103\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0018\u00104\u001a\u00020+2\u0006\u0010!\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u0004J\u001a\u00106\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u00107\u001a\u00020\u0004H\u0002J \u00108\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u0004J6\u0010;\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0004H\u0003J4\u0010;\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0004H\u0003J&\u0010<\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J$\u0010<\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010)\u001a\u00020\u0016H\u0002J<\u0010=\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010,\u001a\u00020+H\u0002J\u001a\u0010>\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020A2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0018\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020A2\u0006\u0010)\u001a\u00020\u0016H\u0002J \u0010B\u001a\u00020+2\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/cloud/tmc/integration/utils/CreateShortCutUtils;", "", "()V", "KEY_ADD_HOME_FILE_PREFIX", "", "getKEY_ADD_HOME_FILE_PREFIX", "()Ljava/lang/String;", "KEY_APP_ID_MINIAPP_CENTER", "getKEY_APP_ID_MINIAPP_CENTER", "KEY_APP_ID_SHARP_NEWS", "getKEY_APP_ID_SHARP_NEWS", "TAG", "addHomeAppIdList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getAddHomeAppIdList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "addHomeData", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/cloud/tmc/integration/model/MiniAddHomeModel;", "getAddHomeData", "()Ljava/util/concurrent/ConcurrentHashMap;", "appMap", "Lcom/cloud/tmc/integration/structure/App;", "getAppMap", "miniAppIconSet", "", "createIconBitmap", "Landroid/graphics/Bitmap;", "resId", "", "path", "createShortcut", "", "context", "Landroid/content/Context;", "scClass", "Ljava/lang/Class;", "appModel", "Lcom/cloud/tmc/integration/model/MiniAppCenterInfoData;", "fromLocation", "addHomeType", "app", "showConfirmDialog", "", "showSuccessToast", "downloadMiniAppIconFile", "Lcom/cloud/tmc/integration/model/AppModel;", "addhomeIconPath", "miniAppIconCallback", "Lcom/cloud/tmc/integration/utils/CreateShortCutUtils$MiniAppIconCallback;", "downloadMiniAppLogo", "miniAppIconPath", "getAddHomeStatus", "appId", "getBadgeLogo", MiniAppIpcConfig.IPC_ADDHOME_APP_NAME, "mobCreateShortcutEvent", NotificationCompat.CATEGORY_STATUS, CampaignEx.JSON_KEY_DESC, "postApi26CreateShortcut", "preApi26CreateShortcut", "requestAddHome", "saveAddHomeStatus", "setExtra", "intent", "Landroid/content/Intent;", "useDefaultAddScreenLogo", MiniAppIpcConfig.IPC_ADDHOME_APP_LOGO, "MiniAppIconCallback", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CreateShortCutUtils {
    private static final String TAG = "CreateShortCutUtils";
    public static final CreateShortCutUtils INSTANCE = new CreateShortCutUtils();
    private static final ConcurrentHashMap<String, App> appMap = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<String> addHomeAppIdList = new CopyOnWriteArrayList<>();
    private static final Set<String> miniAppIconSet = new CopyOnWriteArraySet();
    private static final ConcurrentHashMap<String, MiniAddHomeModel> addHomeData = new ConcurrentHashMap<>();
    private static final String KEY_APP_ID_MINIAPP_CENTER = "1000886706715795456";
    private static final String KEY_APP_ID_SHARP_NEWS = "1000497027976413184";
    private static final String KEY_ADD_HOME_FILE_PREFIX = "miniapp_";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/cloud/tmc/integration/utils/CreateShortCutUtils$MiniAppIconCallback;", "", "onFail", "", "onSuccess", "path", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public interface MiniAppIconCallback {
        void onFail();

        void onSuccess(String path);
    }

    private CreateShortCutUtils() {
    }

    public final Bitmap createIconBitmap(int resId) {
        return ImageUtils.getBitmap(resId);
    }

    public final Bitmap createIconBitmap(String path) {
        return ImageUtils.getBitmap(path);
    }

    @JvmStatic
    @JvmOverloads
    public static final void createShortcut(Context context, Class<?> scClass, MiniAppCenterInfoData appModel, String fromLocation) {
        Intrinsics.h(context, "context");
        Intrinsics.h(scClass, "scClass");
        Intrinsics.h(appModel, "appModel");
        Intrinsics.h(fromLocation, "fromLocation");
        createShortcut$default(context, scClass, appModel, fromLocation, 0, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void createShortcut(Context context, Class<?> scClass, MiniAppCenterInfoData appModel, String fromLocation, int addHomeType) {
        Intrinsics.h(context, "context");
        Intrinsics.h(scClass, "scClass");
        Intrinsics.h(appModel, "appModel");
        Intrinsics.h(fromLocation, "fromLocation");
    }

    @JvmStatic
    @JvmOverloads
    public static final void createShortcut(Context context, Class<?> scClass, App app, String fromLocation) {
        Intrinsics.h(context, "context");
        Intrinsics.h(scClass, "scClass");
        Intrinsics.h(app, "app");
        Intrinsics.h(fromLocation, "fromLocation");
        createShortcut$default(context, scClass, app, fromLocation, 0, false, false, 112, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void createShortcut(Context context, Class<?> scClass, App app, String fromLocation, int i11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(scClass, "scClass");
        Intrinsics.h(app, "app");
        Intrinsics.h(fromLocation, "fromLocation");
        createShortcut$default(context, scClass, app, fromLocation, i11, false, false, 96, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void createShortcut(Context context, Class<?> scClass, App app, String fromLocation, int i11, boolean z10) {
        Intrinsics.h(context, "context");
        Intrinsics.h(scClass, "scClass");
        Intrinsics.h(app, "app");
        Intrinsics.h(fromLocation, "fromLocation");
        createShortcut$default(context, scClass, app, fromLocation, i11, z10, false, 64, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void createShortcut(Context context, Class<?> scClass, App app, String fromLocation, int addHomeType, boolean showConfirmDialog, boolean showSuccessToast) {
        Intrinsics.h(context, "context");
        Intrinsics.h(scClass, "scClass");
        Intrinsics.h(app, "app");
        Intrinsics.h(fromLocation, "fromLocation");
    }

    public static /* synthetic */ void createShortcut$default(Context context, Class cls, MiniAppCenterInfoData miniAppCenterInfoData, String str, int i11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            i11 = 0;
        }
        createShortcut(context, (Class<?>) cls, miniAppCenterInfoData, str, i11);
    }

    public static /* synthetic */ void createShortcut$default(Context context, Class cls, App app, String str, int i11, boolean z10, boolean z11, int i12, Object obj) {
        createShortcut(context, cls, app, str, (i12 & 16) != 0 ? 0 : i11, (i12 & 32) != 0 ? false : z10, (i12 & 64) != 0 ? true : z11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ae, code lost:
    
        r15.onFail();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void downloadMiniAppIconFile(final android.content.Context r12, final com.cloud.tmc.integration.model.AppModel r13, final java.lang.String r14, final com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback r15) {
        /*
            r11 = this;
            java.lang.String r0 = "CreateShortCutUtils"
            if (r13 != 0) goto Le
            if (r15 == 0) goto Ld
            r15.onFail()     // Catch: java.lang.Exception -> La
            goto Ld
        La:
            r12 = move-exception
            goto Lb2
        Ld:
            return
        Le:
            java.lang.String r1 = r13.getLogo()     // Catch: java.lang.Exception -> La
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Exception -> La
            java.lang.String r1 = r1.getLastPathSegment()     // Catch: java.lang.Exception -> La
            java.lang.Class<com.cloud.tmc.integration.proxy.PathProxy> r2 = com.cloud.tmc.integration.proxy.PathProxy.class
            java.lang.Object r2 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r2)     // Catch: java.lang.Exception -> La
            com.cloud.tmc.integration.proxy.PathProxy r2 = (com.cloud.tmc.integration.proxy.PathProxy) r2     // Catch: java.lang.Exception -> La
            java.lang.String r3 = r13.getAppId()     // Catch: java.lang.Exception -> La
            java.lang.String r2 = r2.getBaseMiniAppPath(r3)     // Catch: java.lang.Exception -> La
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Exception -> La
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La
            r4.<init>()     // Catch: java.lang.Exception -> La
            r4.append(r2)     // Catch: java.lang.Exception -> La
            r4.append(r3)     // Catch: java.lang.Exception -> La
            r4.append(r1)     // Catch: java.lang.Exception -> La
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Exception -> La
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> La
            r1.<init>(r8)     // Catch: java.lang.Exception -> La
            boolean r1 = r1.exists()     // Catch: java.lang.Exception -> La
            if (r1 == 0) goto L4f
            if (r15 == 0) goto L4e
            r15.onSuccess(r8)     // Catch: java.lang.Exception -> La
        L4e:
            return
        L4f:
            java.lang.String r1 = r13.getAppId()     // Catch: java.lang.Exception -> La
            if (r1 == 0) goto Lac
            int r1 = r1.length()     // Catch: java.lang.Exception -> La
            if (r1 != 0) goto L5c
            goto Lac
        L5c:
            java.util.Set<java.lang.String> r1 = com.cloud.tmc.integration.utils.CreateShortCutUtils.miniAppIconSet     // Catch: java.lang.Exception -> La
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Exception -> La
            java.lang.String r3 = r13.getAppId()     // Catch: java.lang.Exception -> La
            boolean r2 = kotlin.collections.CollectionsKt.b0(r2, r3)     // Catch: java.lang.Exception -> La
            if (r2 == 0) goto L6c
            return
        L6c:
            java.lang.String r2 = r13.getAppId()     // Catch: java.lang.Exception -> La
            if (r2 == 0) goto L75
            r1.add(r2)     // Catch: java.lang.Exception -> La
        L75:
            com.cloud.tmc.integration.MiniAppConfigHelper r1 = com.cloud.tmc.integration.MiniAppConfigHelper.INSTANCE     // Catch: java.lang.Exception -> La
            java.lang.String r2 = "enableAddHomeUseAssets"
            r3 = 1
            boolean r1 = r1.getConfigTargetBool(r2, r3)     // Catch: java.lang.Exception -> La
            if (r1 == 0) goto L90
            com.cloud.tmc.kernel.executor.ExecutorType r1 = com.cloud.tmc.kernel.executor.ExecutorType.IO     // Catch: java.lang.Exception -> La
            com.cloud.tmc.integration.utils.h r2 = new com.cloud.tmc.integration.utils.h     // Catch: java.lang.Exception -> La
            r5 = r2
            r6 = r14
            r7 = r13
            r9 = r15
            r10 = r12
            r5.<init>()     // Catch: java.lang.Exception -> La
            com.cloud.tmc.kernel.utils.ExecutorUtils.execute(r1, r2)     // Catch: java.lang.Exception -> La
            goto Lbc
        L90:
            java.lang.String r14 = r13.getAppId()     // Catch: java.lang.Exception -> La
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La
            r1.<init>()     // Catch: java.lang.Exception -> La
            java.lang.String r2 = "Not the default appId, download icon ->"
            r1.append(r2)     // Catch: java.lang.Exception -> La
            r1.append(r14)     // Catch: java.lang.Exception -> La
            java.lang.String r14 = r1.toString()     // Catch: java.lang.Exception -> La
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r14)     // Catch: java.lang.Exception -> La
            r11.downloadMiniAppLogo(r12, r13, r8, r15)     // Catch: java.lang.Exception -> La
            goto Lbc
        Lac:
            if (r15 == 0) goto Lb1
            r15.onFail()     // Catch: java.lang.Exception -> La
        Lb1:
            return
        Lb2:
            java.lang.String r13 = "Download icon file fail"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r13, r12)
            if (r15 == 0) goto Lbc
            r15.onFail()
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.CreateShortCutUtils.downloadMiniAppIconFile(android.content.Context, com.cloud.tmc.integration.model.AppModel, java.lang.String, com.cloud.tmc.integration.utils.CreateShortCutUtils$MiniAppIconCallback):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        r7.onFail();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void downloadMiniAppIconFile(final android.content.Context r5, final com.cloud.tmc.integration.model.MiniAppCenterInfoData r6, final com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback r7) {
        /*
            r4 = this;
            if (r6 != 0) goto Lc
            if (r7 == 0) goto Lb
            r7.onFail()     // Catch: java.lang.Exception -> L8
            goto Lb
        L8:
            r5 = move-exception
            goto L81
        Lb:
            return
        Lc:
            java.lang.String r0 = r6.getLogoUrl()     // Catch: java.lang.Exception -> L8
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> L8
            java.lang.String r0 = r0.getLastPathSegment()     // Catch: java.lang.Exception -> L8
            java.lang.Class<com.cloud.tmc.integration.proxy.PathProxy> r1 = com.cloud.tmc.integration.proxy.PathProxy.class
            java.lang.Object r1 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r1)     // Catch: java.lang.Exception -> L8
            com.cloud.tmc.integration.proxy.PathProxy r1 = (com.cloud.tmc.integration.proxy.PathProxy) r1     // Catch: java.lang.Exception -> L8
            java.lang.String r2 = r6.getAppId()     // Catch: java.lang.Exception -> L8
            java.lang.String r1 = r1.getBaseMiniAppPath(r2)     // Catch: java.lang.Exception -> L8
            java.lang.String r2 = java.io.File.separator     // Catch: java.lang.Exception -> L8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8
            r3.<init>()     // Catch: java.lang.Exception -> L8
            r3.append(r1)     // Catch: java.lang.Exception -> L8
            r3.append(r2)     // Catch: java.lang.Exception -> L8
            r3.append(r0)     // Catch: java.lang.Exception -> L8
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> L8
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L8
            r1.<init>(r0)     // Catch: java.lang.Exception -> L8
            boolean r1 = r1.exists()     // Catch: java.lang.Exception -> L8
            if (r1 == 0) goto L4d
            if (r7 == 0) goto L4c
            r7.onSuccess(r0)     // Catch: java.lang.Exception -> L8
        L4c:
            return
        L4d:
            java.lang.String r1 = r6.getAppId()     // Catch: java.lang.Exception -> L8
            if (r1 == 0) goto L7b
            int r1 = r1.length()     // Catch: java.lang.Exception -> L8
            if (r1 != 0) goto L5a
            goto L7b
        L5a:
            java.util.Set<java.lang.String> r1 = com.cloud.tmc.integration.utils.CreateShortCutUtils.miniAppIconSet     // Catch: java.lang.Exception -> L8
            java.lang.String r2 = r6.getAppId()     // Catch: java.lang.Exception -> L8
            boolean r2 = r1.contains(r2)     // Catch: java.lang.Exception -> L8
            if (r2 == 0) goto L67
            return
        L67:
            java.lang.String r2 = r6.getAppId()     // Catch: java.lang.Exception -> L8
            if (r2 == 0) goto L70
            r1.add(r2)     // Catch: java.lang.Exception -> L8
        L70:
            com.cloud.tmc.kernel.executor.ExecutorType r1 = com.cloud.tmc.kernel.executor.ExecutorType.NETWORK     // Catch: java.lang.Exception -> L8
            com.cloud.tmc.integration.utils.g r2 = new com.cloud.tmc.integration.utils.g     // Catch: java.lang.Exception -> L8
            r2.<init>()     // Catch: java.lang.Exception -> L8
            com.cloud.tmc.kernel.utils.ExecutorUtils.execute(r1, r2)     // Catch: java.lang.Exception -> L8
            goto L8d
        L7b:
            if (r7 == 0) goto L80
            r7.onFail()     // Catch: java.lang.Exception -> L8
        L80:
            return
        L81:
            java.lang.String r6 = "CreateShortCutUtils"
            java.lang.String r0 = "Download icon file fail"
            com.cloud.tmc.kernel.log.TmcLogger.e(r6, r0, r5)
            if (r7 == 0) goto L8d
            r7.onFail()
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.CreateShortCutUtils.downloadMiniAppIconFile(android.content.Context, com.cloud.tmc.integration.model.MiniAppCenterInfoData, com.cloud.tmc.integration.utils.CreateShortCutUtils$MiniAppIconCallback):void");
    }

    static /* synthetic */ void downloadMiniAppIconFile$default(CreateShortCutUtils createShortCutUtils, Context context, AppModel appModel, String str, MiniAppIconCallback miniAppIconCallback, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            miniAppIconCallback = null;
        }
        createShortCutUtils.downloadMiniAppIconFile(context, appModel, str, miniAppIconCallback);
    }

    static /* synthetic */ void downloadMiniAppIconFile$default(CreateShortCutUtils createShortCutUtils, Context context, MiniAppCenterInfoData miniAppCenterInfoData, MiniAppIconCallback miniAppIconCallback, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            miniAppIconCallback = null;
        }
        createShortCutUtils.downloadMiniAppIconFile(context, miniAppCenterInfoData, miniAppIconCallback);
    }

    public static final void downloadMiniAppIconFile$lambda$14(Context context, MiniAppCenterInfoData miniAppCenterInfoData, MiniAppIconCallback miniAppIconCallback, String miniAppIconPath) {
        Unit unit;
        Intrinsics.h(context, "$context");
        Intrinsics.h(miniAppIconPath, "$miniAppIconPath");
        boolean useDefaultAddScreenLogo = INSTANCE.useDefaultAddScreenLogo(context, StringExtKt.orDefault(miniAppCenterInfoData.getLogoUrl(), ""), miniAppIconCallback);
        try {
            try {
                File loadImgFile = ((ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class)).loadImgFile(context, StringExtKt.orDefault(miniAppCenterInfoData.getLogoUrl(), ""));
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
                if (set.contains(miniAppCenterInfoData.getAppId())) {
                    set.remove(miniAppCenterInfoData.getAppId());
                }
            } catch (Throwable th2) {
                try {
                    TmcLogger.e(TAG, "downloadMiniAppIconFile", th2);
                    if (!useDefaultAddScreenLogo && miniAppIconCallback != null) {
                        miniAppIconCallback.onFail();
                    }
                    Set<String> set2 = miniAppIconSet;
                    if (set2.contains(miniAppCenterInfoData.getAppId())) {
                        set2.remove(miniAppCenterInfoData.getAppId());
                    }
                } catch (Throwable th3) {
                    try {
                        Set<String> set3 = miniAppIconSet;
                        if (set3.contains(miniAppCenterInfoData.getAppId())) {
                            set3.remove(miniAppCenterInfoData.getAppId());
                        }
                    } catch (Throwable th4) {
                        TmcLogger.e(TAG, "downloadMiniAppIconFile", th4);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            TmcLogger.e(TAG, "downloadMiniAppIconFile", th5);
        }
    }

    public static final void downloadMiniAppIconFile$lambda$6(String str, AppModel appModel, String miniAppIconPath, MiniAppIconCallback miniAppIconCallback, Context context) {
        Intrinsics.h(miniAppIconPath, "$miniAppIconPath");
        Intrinsics.h(context, "$context");
        String takeIfNotEmpty = StringExtKt.takeIfNotEmpty(str);
        if (takeIfNotEmpty != null && new File(takeIfNotEmpty).exists()) {
            TmcLogger.d(TAG, "use miniapp package resouces icon ->" + appModel.getAppId());
            if (miniAppIconCallback != null) {
                miniAppIconCallback.onSuccess(takeIfNotEmpty);
                return;
            }
            return;
        }
        String encryptMD5ToString = EncryptUtils.encryptMD5ToString(appModel.getLogo());
        Intrinsics.g(encryptMD5ToString, "encryptMD5ToString(appModel.logo)");
        String lowerCase = encryptMD5ToString.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        try {
            if (ResourceUtils.copyFileFromAssets("mini_offline/miniapp_addhome/" + KEY_ADD_HOME_FILE_PREFIX + lowerCase + ".png", miniAppIconPath)) {
                TmcLogger.d(TAG, "use assets icon ->" + appModel.getAppId());
                TypeIntrinsics.a(miniAppIconSet).remove(appModel.getAppId());
                if (miniAppIconCallback != null) {
                    miniAppIconCallback.onSuccess(miniAppIconPath);
                    return;
                }
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
        TmcLogger.d(TAG, "download icon ->" + appModel.getAppId());
        INSTANCE.downloadMiniAppLogo(context, appModel, miniAppIconPath, miniAppIconCallback);
    }

    private final void downloadMiniAppLogo(final Context context, final AppModel appModel, final String miniAppIconPath, final MiniAppIconCallback miniAppIconCallback) {
        ExecutorUtils.execute(ExecutorType.NETWORK, new Runnable() { // from class: com.cloud.tmc.integration.utils.i
            @Override // java.lang.Runnable
            public final void run() {
                CreateShortCutUtils.downloadMiniAppLogo$lambda$9(context, appModel, miniAppIconCallback, miniAppIconPath);
            }
        });
    }

    public static final void downloadMiniAppLogo$lambda$9(Context context, AppModel appModel, MiniAppIconCallback miniAppIconCallback, String miniAppIconPath) {
        Unit unit;
        Intrinsics.h(context, "$context");
        Intrinsics.h(appModel, "$appModel");
        Intrinsics.h(miniAppIconPath, "$miniAppIconPath");
        boolean useDefaultAddScreenLogo = INSTANCE.useDefaultAddScreenLogo(context, StringExtKt.orDefault(appModel.getLogo(), ""), miniAppIconCallback);
        try {
            try {
                File loadImgFile = ((ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class)).loadImgFile(context, StringExtKt.orDefault(appModel.getLogo(), ""));
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
                if (CollectionsKt.b0(set, appModel.getAppId())) {
                    TypeIntrinsics.a(set).remove(appModel.getAppId());
                }
            } catch (Throwable th2) {
                try {
                    TmcLogger.e(TAG, "downloadMiniAppIconFile", th2);
                    if (!useDefaultAddScreenLogo && miniAppIconCallback != null) {
                        miniAppIconCallback.onFail();
                    }
                    Set<String> set2 = miniAppIconSet;
                    if (CollectionsKt.b0(set2, appModel.getAppId())) {
                        TypeIntrinsics.a(set2).remove(appModel.getAppId());
                    }
                } catch (Throwable th3) {
                    try {
                        Set<String> set3 = miniAppIconSet;
                        if (CollectionsKt.b0(set3, appModel.getAppId())) {
                            TypeIntrinsics.a(set3).remove(appModel.getAppId());
                        }
                    } catch (Throwable th4) {
                        TmcLogger.e(TAG, "downloadMiniAppIconFile", th4);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            TmcLogger.e(TAG, "downloadMiniAppIconFile", th5);
        }
    }

    private final String getBadgeLogo(Context context, String r22) {
        return r22;
    }

    private final void postApi26CreateShortcut(Context context, Class<?> scClass, MiniAppCenterInfoData appModel, int addHomeType, String fromLocation) {
    }

    private final void postApi26CreateShortcut(Context context, Class<?> scClass, App app, int addHomeType, String fromLocation) {
    }

    private final void preApi26CreateShortcut(final Context context, Class<?> scClass, final MiniAppCenterInfoData appModel) {
        String str;
        Intent intent = new Intent(context.getApplicationContext(), scClass);
        intent.addFlags(ASTNode.DEOP);
        intent.addFlags(67108864);
        setExtra(intent, appModel);
        final Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        if (appModel == null || (str = appModel.getName()) == null) {
            str = "";
        }
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        downloadMiniAppIconFile(context, appModel, new MiniAppIconCallback() { // from class: com.cloud.tmc.integration.utils.CreateShortCutUtils$preApi26CreateShortcut$2
            @Override // com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback
            public void onFail() {
                Bitmap bitmap;
                String str2;
                try {
                    MiniAppCenterInfoData miniAppCenterInfoData = appModel;
                    if ((miniAppCenterInfoData != null ? miniAppCenterInfoData.getLogoResId() : null) != null) {
                        TmcLogger.d("CreateShortCutUtils", "pre icon path03:R.drawable.mini_ic_miniappcenter");
                        CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
                        Integer logoResId = appModel.getLogoResId();
                        bitmap = createShortCutUtils.createIconBitmap(logoResId != null ? logoResId.intValue() : 0);
                    } else {
                        MiniAppCenterInfoData miniAppCenterInfoData2 = appModel;
                        String logoPath = miniAppCenterInfoData2 != null ? miniAppCenterInfoData2.getLogoPath() : null;
                        if (logoPath != null && logoPath.length() != 0) {
                            CreateShortCutUtils createShortCutUtils2 = CreateShortCutUtils.INSTANCE;
                            MiniAppCenterInfoData miniAppCenterInfoData3 = appModel;
                            if (miniAppCenterInfoData3 == null || (str2 = miniAppCenterInfoData3.getLogoPath()) == null) {
                                str2 = "";
                            }
                            bitmap = createShortCutUtils2.createIconBitmap(str2);
                        }
                        bitmap = null;
                    }
                    intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
                    context.sendBroadcast(intent2);
                    ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_create_success));
                    CreateShortCutUtils createShortCutUtils3 = CreateShortCutUtils.INSTANCE;
                    MiniAppCenterInfoData miniAppCenterInfoData4 = appModel;
                    createShortCutUtils3.mobCreateShortcutEvent(miniAppCenterInfoData4 != null ? miniAppCenterInfoData4.getAppId() : null, 1, "trigger success");
                } catch (Exception e11) {
                    ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_create_fail_no_icon));
                    CreateShortCutUtils createShortCutUtils4 = CreateShortCutUtils.INSTANCE;
                    MiniAppCenterInfoData miniAppCenterInfoData5 = appModel;
                    createShortCutUtils4.mobCreateShortcutEvent(miniAppCenterInfoData5 != null ? miniAppCenterInfoData5.getAppId() : null, 3, "trigger happened exception:" + e11);
                }
            }

            @Override // com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback
            public void onSuccess(String path) {
                Bitmap createIconBitmap;
                Intrinsics.h(path, "path");
                try {
                    TmcLogger.d("CreateShortCutUtils", "pre icon path02:" + path);
                    Intent intent3 = intent2;
                    CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
                    createIconBitmap = createShortCutUtils.createIconBitmap(path);
                    intent3.putExtra("android.intent.extra.shortcut.ICON", createIconBitmap);
                    context.sendBroadcast(intent2);
                    ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_create_success));
                    MiniAppCenterInfoData miniAppCenterInfoData = appModel;
                    createShortCutUtils.mobCreateShortcutEvent(miniAppCenterInfoData != null ? miniAppCenterInfoData.getAppId() : null, 1, "trigger success");
                } catch (Exception e11) {
                    ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_create_fail_no_icon));
                    CreateShortCutUtils createShortCutUtils2 = CreateShortCutUtils.INSTANCE;
                    MiniAppCenterInfoData miniAppCenterInfoData2 = appModel;
                    createShortCutUtils2.mobCreateShortcutEvent(miniAppCenterInfoData2 != null ? miniAppCenterInfoData2.getAppId() : null, 3, "trigger happened exception:" + e11);
                }
            }
        });
    }

    private final void preApi26CreateShortcut(final Context context, Class<?> scClass, App app) {
        final AppModel appModel = (AppModel) BundleUtils.getParcelable(app.getSceneParams(), TmcConstants.EXTRA_APPINFO);
        Intent intent = new Intent(context.getApplicationContext(), scClass);
        intent.addFlags(ASTNode.DEOP);
        intent.addFlags(67108864);
        setExtra(intent, app);
        final Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", appModel != null ? appModel.getName() : null);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        downloadMiniAppIconFile(context, appModel, "", new MiniAppIconCallback() { // from class: com.cloud.tmc.integration.utils.CreateShortCutUtils$preApi26CreateShortcut$1
            @Override // com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback
            public void onFail() {
                ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_create_fail_no_icon));
                CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
                AppModel appModel2 = appModel;
                createShortCutUtils.mobCreateShortcutEvent(appModel2 != null ? appModel2.getAppId() : null, 2, "trigger failed");
            }

            @Override // com.cloud.tmc.integration.utils.CreateShortCutUtils.MiniAppIconCallback
            public void onSuccess(String path) {
                Bitmap createIconBitmap;
                Intrinsics.h(path, "path");
                try {
                    TmcLogger.d("CreateShortCutUtils", "pre icon path01:" + path);
                    Intent intent3 = intent2;
                    CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
                    createIconBitmap = createShortCutUtils.createIconBitmap(path);
                    intent3.putExtra("android.intent.extra.shortcut.ICON", createIconBitmap);
                    context.sendBroadcast(intent2);
                    ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_create_success));
                    AppModel appModel2 = appModel;
                    createShortCutUtils.mobCreateShortcutEvent(appModel2 != null ? appModel2.getAppId() : null, 1, "trigger success");
                } catch (Exception e11) {
                    ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast(context.getResources().getString(R.string.smallapp_create_fail_no_icon));
                    CreateShortCutUtils createShortCutUtils2 = CreateShortCutUtils.INSTANCE;
                    AppModel appModel3 = appModel;
                    createShortCutUtils2.mobCreateShortcutEvent(appModel3 != null ? appModel3.getAppId() : null, 3, "trigger happened exception:" + e11);
                }
            }
        });
    }

    private final void requestAddHome(App app, String fromLocation, int addHomeType, Context context, Class<?> scClass, boolean showSuccessToast) {
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String appId = app.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_SHORT_CUT;
            Bundle bundle = new Bundle();
            bundle.putString("object_id", "14");
            bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, fromLocation);
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
            String appId2 = app.getAppId();
            if (appId2 != null) {
                addHomeData.put(appId2, new MiniAddHomeModel(fromLocation, addHomeType, showSuccessToast));
            }
            saveAddHomeStatus(context, app.getAppId());
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "createShortcut ->" + th2);
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

    private final void setExtra(Intent intent, MiniAppCenterInfoData appModel) {
        String str;
        if (appModel == null || (str = appModel.getAppId()) == null) {
            str = "";
        }
        intent.putExtra("appId", str);
        intent.putExtra("scene_id", TmcConstants.SHORTCUT_SCENE_ID);
    }

    private final void setExtra(Intent intent, App app) {
        intent.putExtra("appId", app.getAppId());
        intent.putExtra("scene_id", TmcConstants.SHORTCUT_SCENE_ID);
    }

    public final CopyOnWriteArrayList<String> getAddHomeAppIdList() {
        return addHomeAppIdList;
    }

    public final ConcurrentHashMap<String, MiniAddHomeModel> getAddHomeData() {
        return addHomeData;
    }

    public final boolean getAddHomeStatus(Context context, String appId) {
        Intrinsics.h(context, "context");
        if (appId == null || appId.length() == 0) {
            return false;
        }
        if (!AppUtils.INSTANCE.isLauncher(context)) {
            return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, appId, TmcConstants.KEY_SHOW_ADD_HOME, false);
        }
        return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, TmcConstants.KEY_STORAGE_ADD_HOME, "addHomeStatus_" + appId, false);
    }

    public final ConcurrentHashMap<String, App> getAppMap() {
        return appMap;
    }

    public final String getKEY_ADD_HOME_FILE_PREFIX() {
        return KEY_ADD_HOME_FILE_PREFIX;
    }

    public final String getKEY_APP_ID_MINIAPP_CENTER() {
        return KEY_APP_ID_MINIAPP_CENTER;
    }

    public final String getKEY_APP_ID_SHARP_NEWS() {
        return KEY_APP_ID_SHARP_NEWS;
    }

    public final void mobCreateShortcutEvent(String appId, int r62, String r72) {
        Intrinsics.h(r72, "desc");
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.ADD_MINI_APP_TO_DESKTOP;
        Bundle bundle = new Bundle();
        bundle.putInt(ChainPoint.ADD_MINI_APP_TO_DESKTOP_STATUS, r62);
        bundle.putString(ChainPoint.ADD_MINI_APP_TO_DESKTOP_DESC, r72);
        Unit unit = Unit.f67184a;
        performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
    }

    public final boolean useDefaultAddScreenLogo(Context context, String r22, MiniAppIconCallback miniAppIconCallback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(r22, "logoUrl");
        return false;
    }
}
