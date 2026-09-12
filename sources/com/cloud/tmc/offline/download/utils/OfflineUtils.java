package com.cloud.tmc.offline.download.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.cloud.config.utils.XLogUtil;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.proxy.IAppInfoManagerProxy;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.ext.FileExtKt;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniutils.util.FileIOUtils;
import com.cloud.tmc.miniutils.util.FileUtils;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OffPkgConfigExtParams;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.model.PackageInclude;
import com.cloud.tmc.offline.download.model.TaskResult;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy;
import com.cloud.tmc.offline.download.task.base.BaseTask;
import com.cloud.tmc.offline.download.task.base.ITask;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u001c\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ&\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\fJ\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002J.\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\bH\u0002J\u000e\u0010'\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\fJ\"\u0010'\u001a\u00020 2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010*J\u000e\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\fJ\u0010\u0010-\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u000e\u0010.\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020\fJ\u0012\u00100\u001a\u0004\u0018\u00010\f2\b\u0010)\u001a\u0004\u0018\u00010*J\u0006\u00101\u001a\u00020\bJ\u0010\u00102\u001a\u0004\u0018\u00010*2\u0006\u0010\u0012\u001a\u00020\fJ\u0016\u00103\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u00104\u001a\u00020\bJ\u0010\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0002J\u000e\u00107\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bJ\n\u00108\u001a\u0004\u0018\u000109H\u0002J\u001a\u0010:\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fH\u0002J$\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010$2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u001e\u0010>\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u001e\u0010@\u001a\u0004\u0018\u00010A2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u001c\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0014\u0010C\u001a\u00020D2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030FH\u0002J\u0010\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\fH\u0002J\u0006\u0010I\u001a\u00020\u000fJ\u000e\u0010J\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\fJ\u0010\u0010K\u001a\u0004\u0018\u00010\f2\u0006\u00104\u001a\u00020\bJ\u001a\u0010L\u001a\u00020 2\u0006\u0010L\u001a\u00020\b2\b\b\u0002\u0010M\u001a\u00020\u000fH\u0002J\u0018\u0010N\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010O\u001a\u00020PH\u0002JG\u0010Q\u001a\u00020R2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010V\u001a\u0004\u0018\u00010W¢\u0006\u0002\u0010XJ\u0018\u0010Y\u001a\u00020 2\u0006\u0010Z\u001a\u00020\u000f2\b\b\u0002\u0010[\u001a\u00020RJ\u001a\u0010\\\u001a\u0004\u0018\u00010A2\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010]\u001a\u00020\u000fJ,\u0010^\u001a\u00020 2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010V\u001a\u00020W2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030F2\u0006\u0010S\u001a\u00020\bJ\u001a\u0010_\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u001a\u0010`\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\n\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/cloud/tmc/offline/download/utils/OfflineUtils;", "", "()V", "MAX_UPDATE_TIME", "", "getMAX_UPDATE_TIME", "()J", "TAG", "", "lastGetManifestTime", "manifestMemoryCache", "Ljava/util/HashMap;", "Lcom/cloud/tmc/offline/download/model/OffPkgConfig;", "Lkotlin/collections/HashMap;", "checkMiniAppInDisableAntiShakeList", "", "appId", "checkNetwork", "offPkgConfig", "allowNetworkType", "checkOfflineLoadMiniAppLegal", "checkOfflinePackageDownloadStatus", "group", "packageName", "checkOfflinePackageVersion", "checkOfflineResourceLegal", "url", "checkParams", OfflineConstantsKt.OFFLINE_CONFIG_CHECK_VERSION_ENABLE, "oldVersion", "newVersion", "convertFile2VUrl", "", "manager", "Lcom/cloud/tmc/offline/download/resource/IOfflineResourceManagerProxy;", "files", "", "Ljava/io/File;", "path", "deleteOfflineZipUnCompressDir", "version", "updateEntity", "Lcom/cloud/h5update/bean/UpdateEntity;", "diffUpdateOfflinePkgConfig", "newOffPkgConfig", "enableVerifyServerFile", "generateDefaultZipFileInfo", "Lcom/cloud/tmc/offline/download/model/OfflineZipFileInfo;", "generateOffPkgConfig", "generateUniqueId", "generateUpdateEntity", "generateVUrl", "zipUnCompressPath", "getAllOfDigit", "s", "getAppId", "getContext", "Landroid/content/Context;", "getDiffUpdateEntity", "oldOffPkgConfig", "getOfflinePackageDownloadInfo", "Lcom/cloud/tmc/offline/download/model/ZipFileInfo;", "getOfflinePackageManifest", "getOfflinePackageManifestOrMemoryCache", "getOfflinePkgCachePath", "Lcom/cloud/tmc/offline/download/model/OfflinePkgCachePath;", "getOfflinePkgFwCachePath", "getPointTaskStatus", "Lcom/cloud/tmc/kernel/proxy/performanceanalyse/OfflineDownloadAnalyseType;", "result", "Lcom/cloud/tmc/offline/download/model/TaskResult;", "isAllowRequest", XLogUtil.TAG, "isMainThread", "isNeedDownload", "loadManifest", "log", "printStack", "metadataMatches", "response", "Lokhttp3/Response;", "pointCommonParams", "Landroid/os/Bundle;", "trigger", "isIdle", EventConstants.EVENT_CONSUME_TIME, "task", "Lcom/cloud/tmc/offline/download/task/base/ITask;", "(Lcom/cloud/tmc/offline/download/model/OffPkgConfig;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/cloud/tmc/offline/download/task/base/ITask;)Landroid/os/Bundle;", "reportOfflinePkgApiUsageStatus", "hitStatus", "bundle", "searchOfflinePkgCachePath", "useMemory", "startTaskTrack", "verifyServerFile", "verifyServerUrl", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OfflineUtils {
    public static final String TAG = "TmcOfflineDownload: OfflineUtils";
    private static long lastGetManifestTime;
    public static final OfflineUtils INSTANCE = new OfflineUtils();
    private static final HashMap<String, OffPkgConfig> manifestMemoryCache = new HashMap<>();

    private OfflineUtils() {
    }

    public static /* synthetic */ boolean checkOfflinePackageDownloadStatus$default(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.checkOfflinePackageDownloadStatus(str, str2);
    }

    public static /* synthetic */ boolean checkOfflineResourceLegal$default(OfflineUtils offlineUtils, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return offlineUtils.checkOfflineResourceLegal(str, str2, str3);
    }

    private final boolean checkVersion(String str, String str2) {
        try {
            String[] strArr = (String[]) new Regex("\\.").split(str, 0).toArray(new String[0]);
            String[] strArr2 = (String[]) new Regex("\\.").split(str2, 0).toArray(new String[0]);
            int f11 = RangesKt.f(strArr.length, strArr2.length);
            int i11 = 0;
            while (i11 < f11) {
                int parseInt = Integer.parseInt(getAllOfDigit(i11 < strArr.length ? strArr[i11] : "0"));
                int parseInt2 = Integer.parseInt(getAllOfDigit(i11 < strArr2.length ? strArr2[i11] : "0"));
                if (parseInt2 < parseInt) {
                    return false;
                }
                if (parseInt2 > parseInt) {
                    return true;
                }
                i11++;
            }
            return false;
        } catch (Exception e11) {
            TmcLogger.e(TAG, e11.getMessage());
            return true;
        }
    }

    private final void convertFile2VUrl(String appId, IOfflineResourceManagerProxy manager, List<? extends File> files, String path) {
        for (File file : files) {
            if (file.isDirectory()) {
                File[] listFiles$default = FileExtKt.listFiles$default(file, false, null, 2, null);
                convertFile2VUrl(appId, manager, CollectionsKt.o(Arrays.copyOf(listFiles$default, listFiles$default.length)), path + File.separator + file.getName());
            } else {
                String absolutePath = file.getAbsolutePath();
                Intrinsics.g(absolutePath, "file.absolutePath");
                String name = file.getName();
                Intrinsics.g(name, "file.name");
                String generateVUrl = manager.generateVUrl(absolutePath, appId, name, path, true);
                TmcLogger.d(TAG, "generateVUrl: fileName: " + file.getName() + ", vUrl: " + generateVUrl);
            }
        }
    }

    private final String getAllOfDigit(String s11) {
        StringBuilder sb2 = new StringBuilder();
        int length = s11.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.isDigit(s11.charAt(i11))) {
                sb2.append(s11.charAt(i11));
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "builder.toString()");
        return sb3;
    }

    private final Context getContext() {
        return OfflineManager.getContext$com_cloud_tmc_offline_download();
    }

    private final UpdateEntity getDiffUpdateEntity(OffPkgConfig newOffPkgConfig, OffPkgConfig oldOffPkgConfig) {
        List<PreloadResource> preloadResource;
        List<PreloadResource> preloadResource2;
        List<PreloadResource> preloadResource3;
        List<PreloadResource> preloadResource4;
        UpdateEntity generateUpdateEntity = generateUpdateEntity(newOffPkgConfig);
        UpdateEntity generateUpdateEntity2 = generateUpdateEntity(oldOffPkgConfig);
        ArrayList arrayList = new ArrayList();
        TmcLogger.d(TAG, "[getDiffUpdateEntity] newUpdateEntity:" + generateUpdateEntity);
        TmcLogger.d(TAG, "[getDiffUpdateEntity] oldUpdateEntity:" + generateUpdateEntity2);
        if (generateUpdateEntity != null && (preloadResource3 = generateUpdateEntity.getPreloadResource()) != null) {
            for (PreloadResource preloadResource5 : preloadResource3) {
                OfflineUtils offlineUtils = INSTANCE;
                String url = preloadResource5.getUrl();
                if (url == null) {
                    url = "";
                }
                String appId = offlineUtils.getAppId(url);
                if (generateUpdateEntity2 != null && (preloadResource4 = generateUpdateEntity2.getPreloadResource()) != null) {
                    for (PreloadResource preloadResource6 : preloadResource4) {
                        OfflineUtils offlineUtils2 = INSTANCE;
                        String url2 = preloadResource6.getUrl();
                        if (url2 == null) {
                            url2 = "";
                        }
                        if (Intrinsics.c(appId, offlineUtils2.getAppId(url2)) && (!Intrinsics.c(preloadResource5.getEncryptedStaticZip(), preloadResource6.getEncryptedStaticZip()) || !Intrinsics.c(preloadResource5.getStaticZipUrl(), preloadResource6.getStaticZipUrl()) || !Intrinsics.c(preloadResource5.getVersion(), preloadResource6.getVersion()))) {
                            arrayList.add(preloadResource6);
                        }
                    }
                }
            }
        }
        TmcLogger.d(TAG, "[getDiffUpdateEntity] 更新diffPreloadResource:" + arrayList);
        if (generateUpdateEntity2 != null && (preloadResource = generateUpdateEntity2.getPreloadResource()) != null) {
            for (PreloadResource preloadResource7 : preloadResource) {
                OfflineUtils offlineUtils3 = INSTANCE;
                String url3 = preloadResource7.getUrl();
                if (url3 == null) {
                    url3 = "";
                }
                String appId2 = offlineUtils3.getAppId(url3);
                boolean z10 = false;
                if (generateUpdateEntity != null && (preloadResource2 = generateUpdateEntity.getPreloadResource()) != null) {
                    for (PreloadResource preloadResource8 : preloadResource2) {
                        OfflineUtils offlineUtils4 = INSTANCE;
                        String url4 = preloadResource8.getUrl();
                        if (url4 == null) {
                            url4 = "";
                        }
                        if (Intrinsics.c(appId2, offlineUtils4.getAppId(url4))) {
                            z10 = true;
                        }
                    }
                }
                if (!z10) {
                    arrayList.add(preloadResource7);
                }
            }
        }
        TmcLogger.d(TAG, "[getDiffUpdateEntity] 最终diffPreloadResource:" + arrayList);
        UpdateEntity updateEntity = new UpdateEntity(generateUpdateEntity2 != null ? generateUpdateEntity2.getExtraConfig() : null, generateUpdateEntity2 != null ? generateUpdateEntity2.getIgnoreCachedFiles() : null, generateUpdateEntity2 != null ? generateUpdateEntity2.getPackageName() : null, arrayList, generateUpdateEntity2 != null ? generateUpdateEntity2.getUpdateMode() : null, generateUpdateEntity2 != null ? generateUpdateEntity2.getVersion() : null);
        TmcLogger.d(TAG, "[getDiffUpdateEntity] diffUpdateEntity:" + updateEntity);
        return updateEntity;
    }

    private final long getMAX_UPDATE_TIME() {
        return OfflineManager.getOfflineMaxUpdateTimeInterval$com_cloud_tmc_offline_download();
    }

    public static /* synthetic */ List getOfflinePackageDownloadInfo$default(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.getOfflinePackageDownloadInfo(str, str2);
    }

    private final OffPkgConfig getOfflinePackageManifest(String group, String packageName) {
        Context context = getContext();
        String packageName2 = context != null ? context.getPackageName() : null;
        if (packageName2 == null || packageName2.length() == 0) {
            TmcLogger.d(TAG, "No package name");
            return null;
        }
        OffPkgConfig offlinePkgConfigCache = OfflineStoreCache.INSTANCE.getOfflinePkgConfigCache(packageName == null ? packageName2 : packageName);
        if (offlinePkgConfigCache == null) {
            if (Intrinsics.c(group, packageName2)) {
                return null;
            }
            if ((packageName == null || packageName.length() == 0) && !Intrinsics.c(group, packageName)) {
                return INSTANCE.getOfflinePackageManifest(group, group);
            }
            return null;
        }
        UpdateEntity generateUpdateEntity = generateUpdateEntity(offlinePkgConfigCache);
        if (generateUpdateEntity == null) {
            if (Intrinsics.c(group, packageName2)) {
                return null;
            }
            if ((packageName == null || packageName.length() == 0) && !Intrinsics.c(group, packageName)) {
                return INSTANCE.getOfflinePackageManifest(group, group);
            }
            return null;
        }
        List<PreloadResource> preloadResource = generateUpdateEntity.getPreloadResource();
        if (preloadResource == null) {
            if (Intrinsics.c(group, packageName2)) {
                return null;
            }
            if ((packageName == null || packageName.length() == 0) && !Intrinsics.c(group, packageName)) {
                return INSTANCE.getOfflinePackageManifest(group, group);
            }
            return null;
        }
        Iterator<PreloadResource> it = preloadResource.iterator();
        while (it.hasNext()) {
            String staticZipUrl = it.next().getStaticZipUrl();
            if (staticZipUrl != null) {
                OfflineZipDownloadInfo zipDownloadStatus = OfflineStoreCache.INSTANCE.getZipDownloadStatus(offlinePkgConfigCache, staticZipUrl);
                if (zipDownloadStatus.getStatus() != 4) {
                    continue;
                } else {
                    OffPkgConfig manifest = zipDownloadStatus.getManifest();
                    if (Intrinsics.c(group, manifest != null ? manifest.getGroup() : null)) {
                        return zipDownloadStatus.getManifest();
                    }
                }
            }
        }
        if (Intrinsics.c(group, packageName2)) {
            return null;
        }
        if ((packageName == null || packageName.length() == 0) && !Intrinsics.c(group, packageName)) {
            return getOfflinePackageManifest(group, group);
        }
        return null;
    }

    static /* synthetic */ OffPkgConfig getOfflinePackageManifest$default(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.getOfflinePackageManifest(str, str2);
    }

    private final OffPkgConfig getOfflinePackageManifestOrMemoryCache(String group) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, OffPkgConfig> hashMap = manifestMemoryCache;
        OffPkgConfig offPkgConfig = hashMap.get(group);
        if (offPkgConfig != null && currentTimeMillis - lastGetManifestTime <= OfflineManager.getOfflineManifestTimeInterval$com_cloud_tmc_offline_download()) {
            return offPkgConfig;
        }
        OffPkgConfig offlinePackageManifest$default = getOfflinePackageManifest$default(this, group, null, 2, null);
        if (offlinePackageManifest$default != null) {
            hashMap.put(group, offlinePackageManifest$default);
        }
        lastGetManifestTime = currentTimeMillis;
        TmcLogger.d(TAG, "manifestCache 内存失效，从缓存中读取，" + offlinePackageManifest$default);
        return offlinePackageManifest$default;
    }

    public static /* synthetic */ OfflinePkgCachePath getOfflinePkgCachePath$default(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.getOfflinePkgCachePath(str, str2);
    }

    public static /* synthetic */ OfflinePkgCachePath getOfflinePkgFwCachePath$default(OfflineUtils offlineUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return offlineUtils.getOfflinePkgFwCachePath(str, str2);
    }

    private final OfflineDownloadAnalyseType getPointTaskStatus(TaskResult<?> result) {
        return result instanceof TaskResult.Success ? OfflineDownloadAnalyseType.TASK_FINISH : OfflineDownloadAnalyseType.TASK_FAIL;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean isAllowRequest(com.cloud.tmc.offline.download.model.OffPkgConfig r8) {
        /*
            r7 = this;
            com.cloud.tmc.offline.download.utils.OfflineStoreCache r0 = com.cloud.tmc.offline.download.utils.OfflineStoreCache.INSTANCE
            long r0 = r0.lastUpdateTime(r8)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r1 = 0
            if (r0 <= 0) goto L27
            boolean r0 = com.cloud.tmc.kernel.utils.AppDynamicBuildConfig.isAppDebugAble()
            if (r0 == 0) goto L1c
            r4 = 120000(0x1d4c0, double:5.9288E-319)
            goto L20
        L1c:
            long r4 = r7.getMAX_UPDATE_TIME()
        L20:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L25
            goto L27
        L25:
            r0 = r1
            goto L28
        L27:
            r0 = 1
        L28:
            if (r0 != 0) goto L5b
            long r4 = com.cloud.tmc.miniutils.util.TimeUtils.getNowMills()
            long r2 = r4 - r2
            r6 = 5
            java.lang.String r2 = com.cloud.tmc.miniutils.util.TimeUtils.getFitTimeSpan(r4, r2, r6)
            java.lang.String r8 = r8.getGroup()
            if (r8 != 0) goto L3d
            java.lang.String r8 = "It"
        L3d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r8)
            java.lang.String r8 = " has only been "
            r3.append(r8)
            r3.append(r2)
            java.lang.String r8 = " since the last update or check, which does not meet the 24-hour update policy"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r2 = 2
            r3 = 0
            log$default(r7, r8, r1, r2, r3)
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.offline.download.utils.OfflineUtils.isAllowRequest(com.cloud.tmc.offline.download.model.OffPkgConfig):boolean");
    }

    private final void log(String log, boolean printStack) {
        TmcLogger.d(TAG, log + " " + (printStack ? Log.getStackTraceString(new Throwable("Just Print")) : ""));
    }

    static /* synthetic */ void log$default(OfflineUtils offlineUtils, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        offlineUtils.log(str, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00af A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0003, B:7:0x002a, B:10:0x0031, B:13:0x0038, B:15:0x003f, B:17:0x004a, B:19:0x0052, B:21:0x0058, B:23:0x0060, B:25:0x0068, B:26:0x006c, B:28:0x0072, B:30:0x007f, B:32:0x0087, B:33:0x008d, B:37:0x0095, B:39:0x0099, B:41:0x009f, B:43:0x00a7, B:45:0x00af, B:46:0x00b3, B:48:0x00b9, B:50:0x00c6, B:52:0x00ce, B:53:0x00d4, B:57:0x00e8, B:59:0x00ec, B:61:0x00f4, B:63:0x00fc, B:64:0x0100), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0003, B:7:0x002a, B:10:0x0031, B:13:0x0038, B:15:0x003f, B:17:0x004a, B:19:0x0052, B:21:0x0058, B:23:0x0060, B:25:0x0068, B:26:0x006c, B:28:0x0072, B:30:0x007f, B:32:0x0087, B:33:0x008d, B:37:0x0095, B:39:0x0099, B:41:0x009f, B:43:0x00a7, B:45:0x00af, B:46:0x00b3, B:48:0x00b9, B:50:0x00c6, B:52:0x00ce, B:53:0x00d4, B:57:0x00e8, B:59:0x00ec, B:61:0x00f4, B:63:0x00fc, B:64:0x0100), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean metadataMatches(java.lang.String r9, okhttp3.Response r10) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.offline.download.utils.OfflineUtils.metadataMatches(java.lang.String, okhttp3.Response):boolean");
    }

    public static /* synthetic */ Bundle pointCommonParams$default(OfflineUtils offlineUtils, OffPkgConfig offPkgConfig, String str, Boolean bool, Long l11, ITask iTask, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            offPkgConfig = null;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            bool = null;
        }
        if ((i11 & 8) != 0) {
            l11 = null;
        }
        if ((i11 & 16) != 0) {
            iTask = null;
        }
        return offlineUtils.pointCommonParams(offPkgConfig, str, bool, l11, iTask);
    }

    public static /* synthetic */ void reportOfflinePkgApiUsageStatus$default(OfflineUtils offlineUtils, boolean z10, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bundle = new Bundle();
        }
        offlineUtils.reportOfflinePkgApiUsageStatus(z10, bundle);
    }

    public static /* synthetic */ OfflinePkgCachePath searchOfflinePkgCachePath$default(OfflineUtils offlineUtils, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return offlineUtils.searchOfflinePkgCachePath(str, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean verifyServerUrl(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.offline.download.utils.OfflineUtils.verifyServerUrl(java.lang.String, java.lang.String):boolean");
    }

    public final boolean checkMiniAppInDisableAntiShakeList(String appId) {
        String whiteListStr;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (appId == null || appId.length() == 0) {
            return false;
        }
        try {
            whiteListStr = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_MINI_OFFLINE_DOWNLOAD_DISABLE_ANTI_SHAKE, MiniAppConfigHelper.DEFAULT_MINI_OFFLINE_DOWNLOAD_DISABLE_ANTI_SHAKE);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "checkMiniAppInDisableAntiShakeList failed!", th2);
            whiteListStr = MiniAppConfigHelper.DEFAULT_MINI_OFFLINE_DOWNLOAD_DISABLE_ANTI_SHAKE;
        }
        try {
            Intrinsics.g(whiteListStr, "whiteListStr");
            Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$checkMiniAppInDisableAntiShakeList$whiteList$1
            }.getType();
            Intrinsics.g(type, "object : TypeToken<ArrayList<String>>() {}.type");
            arrayList2 = (ArrayList) TmcGsonUtils.fromJson(whiteListStr, type);
        } catch (Throwable th3) {
            TmcLogger.e(TAG, th3);
            try {
                Type type2 = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$checkMiniAppInDisableAntiShakeList$whiteList$2
                }.getType();
                Intrinsics.g(type2, "object : TypeToken<ArrayList<String>>() {}.type");
                arrayList = (ArrayList) TmcGsonUtils.fromJson(MiniAppConfigHelper.DEFAULT_MINI_OFFLINE_DOWNLOAD_DISABLE_ANTI_SHAKE, type2);
            } catch (Throwable th4) {
                TmcLogger.e(TAG, "", th4);
                arrayList = new ArrayList();
            }
            arrayList2 = arrayList;
        }
        TmcLogger.d(TAG, "checkMiniAppInDisableAntiShakeList: 当前小程序是否在禁用离线加载防抖名单中：" + arrayList2.contains(appId) + " 禁用名单：" + arrayList2);
        return arrayList2.contains(appId);
    }

    public final boolean checkNetwork(OffPkgConfig offPkgConfig) {
        Intrinsics.h(offPkgConfig, "offPkgConfig");
        return checkNetwork(offPkgConfig.getNetworkType());
    }

    public final boolean checkNetwork(String allowNetworkType) {
        Context context = getContext();
        boolean z10 = false;
        if (context == null) {
            return false;
        }
        String detailNetworkType = NetworkUtil.getDetailNetworkType(context);
        Intrinsics.g(detailNetworkType, "getDetailNetworkType(context)");
        if (allowNetworkType != null) {
            switch (allowNetworkType.hashCode()) {
                case -2069000991:
                    if (allowNetworkType.equals("onlyWifi")) {
                        z10 = Intrinsics.c(detailNetworkType, NetworkUtil.NETWORK_TYPE_WIFI);
                        break;
                    }
                    break;
                case -1078030475:
                    if (allowNetworkType.equals("medium")) {
                        z10 = Intrinsics.c(detailNetworkType, NetworkUtil.NETWORK_TYPE_3G);
                        break;
                    }
                    break;
                case -1012208801:
                    if (allowNetworkType.equals("only4g")) {
                        z10 = Intrinsics.c(detailNetworkType, NetworkUtil.NETWORK_TYPE_4G);
                        break;
                    }
                    break;
                case -1012208770:
                    if (allowNetworkType.equals("only5g")) {
                        z10 = Intrinsics.c(detailNetworkType, NetworkUtil.NETWORK_TYPE_5G);
                        break;
                    }
                    break;
                case -891980137:
                    if (allowNetworkType.equals("strong") && (Intrinsics.c(detailNetworkType, NetworkUtil.NETWORK_TYPE_4G) || Intrinsics.c(detailNetworkType, NetworkUtil.NETWORK_TYPE_5G) || Intrinsics.c(detailNetworkType, NetworkUtil.NETWORK_TYPE_WIFI))) {
                        z10 = true;
                        break;
                    }
                    break;
                case 3645304:
                    if (allowNetworkType.equals("weak")) {
                        z10 = Intrinsics.c(detailNetworkType, NetworkUtil.NETWORK_TYPE_2G);
                        break;
                    }
                    break;
            }
        }
        TmcLogger.d(TAG, "checkNetwork: current:" + detailNetworkType + " target:" + allowNetworkType + " 是否符合要求：" + (z10 ? "符合" : "不符合"));
        return z10;
    }

    public final boolean checkOfflineLoadMiniAppLegal(String appId) {
        int i11;
        OffPkgConfigExtParams extParams;
        if (appId == null || appId.length() == 0) {
            TmcLogger.d(TAG, "appId is null or empty");
            return false;
        }
        Context context = getContext();
        List<String> list = null;
        String packageName = context != null ? context.getPackageName() : null;
        if (packageName == null || packageName.length() == 0) {
            TmcLogger.d(TAG, "packageName is null or empty");
            return false;
        }
        if (Intrinsics.c(appId, packageName)) {
            return true;
        }
        OffPkgConfig offlinePkgConfigCache = OfflineStoreCache.INSTANCE.getOfflinePkgConfigCache(packageName);
        if (offlinePkgConfigCache != null && (extParams = offlinePkgConfigCache.getExtParams()) != null) {
            list = extParams.getAuthorizedMiniApp();
        }
        if (list != null) {
            Iterator<String> it = list.iterator();
            i11 = 0;
            while (it.hasNext()) {
                if (StringsKt.a0(it.next(), appId, true)) {
                    break;
                }
                i11++;
            }
        }
        i11 = -1;
        return i11 != -1;
    }

    public final boolean checkOfflinePackageDownloadStatus(String group, String packageName) {
        ZipFileInfo zipFileInfo;
        Object obj;
        if (group != null && group.length() != 0) {
            Context context$com_cloud_tmc_offline_download = OfflineManager.getContext$com_cloud_tmc_offline_download();
            String packageName2 = context$com_cloud_tmc_offline_download != null ? context$com_cloud_tmc_offline_download.getPackageName() : null;
            if (packageName2 != null && packageName2.length() != 0) {
                OfflinePkgCachePath searchOfflinePkgCachePath = searchOfflinePkgCachePath(packageName == null ? group : packageName, true);
                List<ZipFileInfo> zipFileInfo2 = searchOfflinePkgCachePath != null ? searchOfflinePkgCachePath.getZipFileInfo() : null;
                if (zipFileInfo2 != null) {
                    Iterator<T> it = zipFileInfo2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        OffPkgConfig manifest = ((ZipFileInfo) obj).getManifest();
                        if (Intrinsics.c(group, manifest != null ? manifest.getGroup() : null)) {
                            break;
                        }
                    }
                    zipFileInfo = (ZipFileInfo) obj;
                } else {
                    zipFileInfo = null;
                }
                String zipUnCompressPath = zipFileInfo != null ? zipFileInfo.getZipUnCompressPath() : null;
                if (zipUnCompressPath != null && zipUnCompressPath.length() != 0) {
                    return FileUtil.accessDir(new File(zipUnCompressPath));
                }
                if (Intrinsics.c(group, packageName2)) {
                    return false;
                }
                if ((packageName == null || packageName.length() == 0) && !Intrinsics.c(packageName, packageName2)) {
                    return checkOfflinePackageDownloadStatus(group, packageName2);
                }
                return false;
            }
        }
        return false;
    }

    public final boolean checkOfflinePackageVersion(String appId) {
        ExtendModel extend;
        String offlinePackageVersion;
        TmcLogger.d(TAG, "checkOfflinePackageVersion : appId: " + appId);
        if (appId == null || appId.length() == 0) {
            return false;
        }
        if (!OfflineManager.getCheckVersionEnable$com_cloud_tmc_offline_download()) {
            TmcLogger.d(TAG, "Checking offline package version is not enabled");
            return true;
        }
        TmcLogger.d(TAG, "Current appId is: " + appId);
        if (Intrinsics.c(appId, "100000")) {
            return true;
        }
        AppModel appModel = null;
        try {
            Context context = getContext();
            if (context != null) {
                appModel = ((IAppInfoManagerProxy) TmcProxy.get(IAppInfoManagerProxy.class)).getAppModelHasNotOffline(context, AppInfoQuery.INSTANCE.make(appId));
            }
        } catch (Exception e11) {
            TmcLogger.e(TAG, "getAppModelHasNotOffline is failed", e11);
        }
        if (appModel == null || (extend = appModel.getExtend()) == null || (offlinePackageVersion = extend.getOfflinePackageVersion()) == null) {
            TmcLogger.d(TAG, "checkOfflinePackageVersion: appInfo 中没有配置 offlinePackageVersion，则使用");
            return true;
        }
        OffPkgConfig offlinePackageManifestOrMemoryCache = getOfflinePackageManifestOrMemoryCache(appId);
        if (offlinePackageManifestOrMemoryCache == null) {
            TmcLogger.d(TAG, "checkOfflinePackageManifest: 读取不到 " + appId + " 配置的离线包 manifest，不通过");
            return false;
        }
        String version = offlinePackageManifestOrMemoryCache.getVersion();
        if (version == null) {
            TmcLogger.d(TAG, "checkOfflinePackageVersion: 离线包 manifest 中没有配置 offlinePackageVersion，则不通过");
            return false;
        }
        TmcLogger.d(TAG, "checkOfflinePackageVersion: offlinePackageVersion: " + offlinePackageVersion + " version: " + version);
        if (Intrinsics.c(offlinePackageVersion, version)) {
            return true;
        }
        return checkVersion(offlinePackageVersion, version);
    }

    public final boolean checkOfflineResourceLegal(String appId, String url, String packageName) {
        String str;
        String str2;
        int i11;
        OffPkgConfigExtParams extParams;
        if (appId == null || appId.length() == 0 || url == null || url.length() == 0) {
            TmcLogger.d(TAG, "appId or url is empty!");
            return false;
        }
        Context context = getContext();
        String packageName2 = context != null ? context.getPackageName() : null;
        if (packageName2 == null || packageName2.length() == 0) {
            TmcLogger.d(TAG, "packageName is null or empty!");
            return false;
        }
        OffPkgConfig offlinePkgConfigCacheOrMemoryCache = OfflineStoreCache.INSTANCE.getOfflinePkgConfigCacheOrMemoryCache(packageName == null ? appId : packageName);
        List<PackageInclude> packageInclude = (offlinePkgConfigCacheOrMemoryCache == null || (extParams = offlinePkgConfigCacheOrMemoryCache.getExtParams()) == null) ? null : extParams.getPackageInclude();
        boolean z10 = true;
        if (StringsKt.G(url, ".so", false, 2, null) && OfflineManager.isEnableAhaSoFormatConvert$com_cloud_tmc_offline_download()) {
            String O = StringsKt.O(url, ".so", "@===.zip", true);
            TmcLogger.d(TAG, "so file check replace success! url: " + O);
            str = O;
        } else {
            str = url;
        }
        try {
            str2 = StringExtKt.toMd5(StringsKt.Q(str, FileUtil.getVhost(appId) + "/", "", false, 4, null)).substring(0, 10);
            Intrinsics.g(str2, "this as java.lang.String…ing(startIndex, endIndex)");
        } catch (Throwable unused) {
            str2 = "";
        }
        if (packageInclude != null) {
            for (PackageInclude packageInclude2 : packageInclude) {
                String appId2 = packageInclude2.getAppId();
                if (appId2 != null && StringsKt.a0(appId2, appId, true)) {
                    List<String> paths = packageInclude2.getPaths();
                    if (paths != null) {
                        Iterator<String> it = paths.iterator();
                        i11 = 0;
                        while (it.hasNext()) {
                            if (StringsKt.H(it.next(), str2, true)) {
                                break;
                            }
                            i11++;
                        }
                    }
                    i11 = -1;
                    if (i11 != -1) {
                        TmcLogger.d(TAG, "file check success! url: " + url);
                        return true;
                    }
                }
            }
        }
        if (Intrinsics.c(appId, packageName2)) {
            return false;
        }
        if (packageName != null && packageName.length() != 0) {
            z10 = false;
        }
        if (!z10 || Intrinsics.c(packageName, packageName2)) {
            return false;
        }
        return checkOfflineResourceLegal(appId, url, packageName2);
    }

    public final boolean checkParams(OffPkgConfig offPkgConfig) {
        Intrinsics.h(offPkgConfig, "offPkgConfig");
        String group = offPkgConfig.getGroup();
        if (group == null || group.length() == 0) {
            TmcLogger.d(TAG, "No group specified for package config");
            return false;
        }
        String networkType = offPkgConfig.getNetworkType();
        if (networkType == null || networkType.length() == 0) {
            TmcLogger.d(TAG, "No networkType specified for package config");
            return false;
        }
        String pkgUrl = offPkgConfig.getPkgUrl();
        if (pkgUrl == null || pkgUrl.length() == 0) {
            TmcLogger.d(TAG, "No pkgUrl specified for package config");
            return false;
        }
        String pkgEncrypted = offPkgConfig.getPkgEncrypted();
        if (pkgEncrypted != null && pkgEncrypted.length() != 0) {
            return true;
        }
        TmcLogger.d(TAG, "No pkgEncrypted specified for package config");
        return false;
    }

    public final void deleteOfflineZipUnCompressDir(OffPkgConfig offPkgConfig) {
        Intrinsics.h(offPkgConfig, "offPkgConfig");
        UpdateEntity generateUpdateEntity = generateUpdateEntity(offPkgConfig);
        String version = offPkgConfig.getVersion();
        if (version == null) {
            version = "";
        }
        deleteOfflineZipUnCompressDir(offPkgConfig.getGroup(), version, generateUpdateEntity);
    }

    public final void deleteOfflineZipUnCompressDir(String group, String version, UpdateEntity updateEntity) {
        List<PreloadResource> preloadResource;
        String zipUnCompressPath;
        Intrinsics.h(version, "version");
        TmcLogger.i(TAG, "开始检查删除旧资源文件，group: " + group + ", version:" + version);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("开始检查删除旧资源文件，updateEntity: ");
        sb2.append(updateEntity);
        TmcLogger.i(TAG, sb2.toString());
        if (group == null || updateEntity == null || (preloadResource = updateEntity.getPreloadResource()) == null) {
            return;
        }
        Iterator<T> it = preloadResource.iterator();
        while (it.hasNext()) {
            String staticZipUrl = ((PreloadResource) it.next()).getStaticZipUrl();
            if (staticZipUrl != null) {
                OfflineZipDownloadInfo zipDownloadStatus = OfflineStoreCache.INSTANCE.getZipDownloadStatus(group, staticZipUrl);
                if (zipDownloadStatus.getStatus() > 2 && (zipUnCompressPath = zipDownloadStatus.getZipUnCompressPath()) != null && zipUnCompressPath.length() != 0) {
                    File file = new File(zipUnCompressPath);
                    if (FileUtil.access(file)) {
                        File[] listFiles$default = FileExtKt.listFiles$default(file, true, null, 2, null);
                        IOfflineResourceManagerProxy iOfflineResourceManagerProxy = (IOfflineResourceManagerProxy) TmcProxy.get(IOfflineResourceManagerProxy.class);
                        for (File file2 : listFiles$default) {
                            if (iOfflineResourceManagerProxy != null) {
                                iOfflineResourceManagerProxy.removeByFilePath(file2.getAbsolutePath(), true);
                            }
                        }
                        boolean delete = FileUtils.delete(zipDownloadStatus.getZipUnCompressPath());
                        if (delete) {
                            zipDownloadStatus.setStatus(0);
                            OfflineStoreCache.INSTANCE.setZipDownloadStatus(group, version, zipDownloadStatus);
                            TH5Update.f21320c.b(updateEntity);
                            ((OfflineAppProxy) TmcProxy.get(OfflineAppProxy.class)).scanForOfflineDownloadDelete();
                        }
                        TmcLogger.i(TAG, "删除旧的文件资源结果为：" + delete + "，文件夹路径：" + zipDownloadStatus.getZipUnCompressPath());
                    }
                }
            }
        }
    }

    public final void diffUpdateOfflinePkgConfig(OffPkgConfig newOffPkgConfig) {
        Intrinsics.h(newOffPkgConfig, "newOffPkgConfig");
        OfflineStoreCache offlineStoreCache = OfflineStoreCache.INSTANCE;
        OffPkgConfig offlinePkgConfigCache = offlineStoreCache.getOfflinePkgConfigCache(newOffPkgConfig.getGroup());
        if (offlinePkgConfigCache == null) {
            return;
        }
        TmcLogger.d(TAG, "diff update offline pkg config before, extInfo: " + offlinePkgConfigCache.getExtInfo() + " extParams: " + offlinePkgConfigCache.getExtParams());
        offlinePkgConfigCache.setExtInfo(newOffPkgConfig.getExtInfo());
        offlinePkgConfigCache.setExtParams(newOffPkgConfig.getExtParams());
        offlineStoreCache.setOfflinePkgConfigCache(offlinePkgConfigCache);
        TmcLogger.d(TAG, "diff update offline pkg config after, extInfo: " + offlinePkgConfigCache.getExtInfo() + " extParams: " + offlinePkgConfigCache.getExtParams());
    }

    public final boolean enableVerifyServerFile(String appId) {
        UpdateEntity generateUpdateEntity;
        String extraConfig;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        boolean z10 = false;
        if (appId != null && appId.length() != 0) {
            OffPkgConfig offlinePkgConfigCache = OfflineStoreCache.INSTANCE.getOfflinePkgConfigCache(appId);
            if (offlinePkgConfigCache == null || (generateUpdateEntity = generateUpdateEntity(offlinePkgConfigCache)) == null || (extraConfig = generateUpdateEntity.getExtraConfig()) == null) {
                return false;
            }
            JsonObject jsonObject = null;
            try {
                JsonElement parseString = JsonParser.parseString(extraConfig);
                if (parseString != null) {
                    jsonObject = parseString.getAsJsonObject();
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, th2);
            }
            if (jsonObject == null) {
                return false;
            }
            try {
                JsonElement jsonElement2 = jsonObject.get("extParams");
                if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null && (jsonElement = asJsonObject.get("verifyServerFile")) != null) {
                    z10 = jsonElement.getAsBoolean();
                }
            } catch (Throwable th3) {
                TmcLogger.e(TAG, th3);
            }
            TmcLogger.d(TAG, "enableVerifyServerFile: 启用验证服务器文件开关 verifyServerFile=" + z10);
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        if (r0.equals(com.cloud.tmc.offline.download.constants.OfflineConstantsKt.OFFLINE_TYPE_MINIAPP) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
    
        r0 = ((com.cloud.tmc.integration.proxy.PathProxy) com.cloud.tmc.kernel.proxy.TmcProxy.get(com.cloud.tmc.integration.proxy.PathProxy.class)).getAppBaseFilePath(r5.getGroup()) + "/temp_data";
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r0.equals("normal") == false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.cloud.tmc.offline.download.model.OfflineZipFileInfo generateDefaultZipFileInfo(com.cloud.tmc.offline.download.model.OffPkgConfig r5) {
        /*
            r4 = this;
            java.lang.String r0 = "offPkgConfig"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            java.lang.String r0 = r5.getType()
            java.lang.Class<com.cloud.tmc.integration.proxy.PathProxy> r1 = com.cloud.tmc.integration.proxy.PathProxy.class
            if (r0 == 0) goto L6b
            int r2 = r0.hashCode()
            r3 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            if (r2 == r3) goto L42
            r3 = 43564935(0x298bf87, float:2.2444324E-37)
            if (r2 == r3) goto L2a
            r3 = 1064526442(0x3f73626a, float:0.9507204)
            if (r2 == r3) goto L21
            goto L6b
        L21:
            java.lang.String r2 = "miniapp"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L4b
            goto L6b
        L2a:
            java.lang.String r2 = "miniframework"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L33
            goto L6b
        L33:
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r1)
            com.cloud.tmc.integration.proxy.PathProxy r0 = (com.cloud.tmc.integration.proxy.PathProxy) r0
            java.lang.String r1 = r5.getGroup()
            java.lang.String r0 = r0.getAppBaseDownloadPath(r1)
            goto L80
        L42:
            java.lang.String r2 = "normal"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L4b
            goto L6b
        L4b:
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r1)
            com.cloud.tmc.integration.proxy.PathProxy r0 = (com.cloud.tmc.integration.proxy.PathProxy) r0
            java.lang.String r1 = r5.getGroup()
            java.lang.String r0 = r0.getAppBaseFilePath(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "/temp_data"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L80
        L6b:
            java.lang.String r0 = "TmcOfflineDownload: OfflineUtils"
            java.lang.String r2 = "offline_pkg_manifest type is unknown"
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r2)
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r1)
            com.cloud.tmc.integration.proxy.PathProxy r0 = (com.cloud.tmc.integration.proxy.PathProxy) r0
            java.lang.String r1 = r5.getGroup()
            java.lang.String r0 = r0.getAppBaseDownloadPath(r1)
        L80:
            java.lang.String r5 = r5.getGroup()
            java.lang.String r5 = com.cloud.tmc.integration.utils.ext.StringExtKt.toMd5(r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.cloud.tmc.offline.download.model.OfflineZipFileInfo r1 = new com.cloud.tmc.offline.download.model.OfflineZipFileInfo
            java.lang.String r2 = "zipDirPath"
            kotlin.jvm.internal.Intrinsics.g(r0, r2)
            r1.<init>(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.offline.download.utils.OfflineUtils.generateDefaultZipFileInfo(com.cloud.tmc.offline.download.model.OffPkgConfig):com.cloud.tmc.offline.download.model.OfflineZipFileInfo");
    }

    public final OffPkgConfig generateOffPkgConfig(UpdateEntity updateEntity) {
        OffPkgConfig offPkgConfig = null;
        if (updateEntity != null) {
            String extraConfig = updateEntity.getExtraConfig();
            if (extraConfig != null) {
                Type type = new TypeToken<OffPkgConfig>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$generateOffPkgConfig$1$fromJson$1
                }.getType();
                Intrinsics.g(type, "object : TypeToken<OffPkgConfig>() {}.type");
                offPkgConfig = (OffPkgConfig) TmcGsonUtils.fromJson(extraConfig, type);
            }
            if (offPkgConfig != null) {
                offPkgConfig.setGroup(updateEntity.getPackageName());
            }
            if (offPkgConfig != null) {
                offPkgConfig.setVersion(String.valueOf(updateEntity.getVersion()));
            }
            if (offPkgConfig != null) {
                offPkgConfig.setExtraConfig(TmcGsonUtilsKt.toJson(updateEntity));
            }
        }
        return offPkgConfig;
    }

    public final String generateUniqueId() {
        String str = System.currentTimeMillis() + "_" + RangesKt.q(new IntRange(DefaultOggSeeker.MATCH_BYTE_RANGE, 999999), Random.INSTANCE);
        TmcLogger.d(TAG, "Generating unique id: " + str);
        return str;
    }

    public final UpdateEntity generateUpdateEntity(OffPkgConfig offPkgConfig) {
        Intrinsics.h(offPkgConfig, "offPkgConfig");
        String extraConfig = offPkgConfig.getExtraConfig();
        if (extraConfig == null) {
            return null;
        }
        try {
            Type type = new TypeToken<UpdateEntity>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$generateUpdateEntity$1
            }.getType();
            Intrinsics.g(type, "object : TypeToken<UpdateEntity>() {}.type");
            return (UpdateEntity) TmcGsonUtils.fromJson(extraConfig, type);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "Exception json parse error", th2);
            return null;
        }
    }

    public final void generateVUrl(String group, String zipUnCompressPath) {
        Intrinsics.h(group, "group");
        Intrinsics.h(zipUnCompressPath, "zipUnCompressPath");
        File[] listFiles$default = FileExtKt.listFiles$default(new File(zipUnCompressPath), false, null, 2, null);
        IOfflineResourceManagerProxy manager = (IOfflineResourceManagerProxy) TmcProxy.get(IOfflineResourceManagerProxy.class);
        Intrinsics.g(manager, "manager");
        convertFile2VUrl(group, manager, CollectionsKt.o(Arrays.copyOf(listFiles$default, listFiles$default.length)), "");
    }

    public final String getAppId(String url) {
        Intrinsics.h(url, "url");
        List S0 = StringsKt.S0(url, new String[]{"_"}, false, 0, 6, null);
        String str = "100000";
        if (!S0.contains("100000")) {
            Iterator it = S0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = "";
                    break;
                }
                str = (String) it.next();
                if (str.length() == 19 && Utils.INSTANCE.isNumeric(str)) {
                    break;
                }
            }
        }
        TmcLogger.d(TAG, "[getAppId] url:" + url + ", targetAppId:" + ((Object) str));
        return str;
    }

    public final List<ZipFileInfo> getOfflinePackageDownloadInfo(String group, String packageName) {
        ArrayList arrayList;
        if (group != null && group.length() != 0) {
            Context context$com_cloud_tmc_offline_download = OfflineManager.getContext$com_cloud_tmc_offline_download();
            String packageName2 = context$com_cloud_tmc_offline_download != null ? context$com_cloud_tmc_offline_download.getPackageName() : null;
            if (packageName2 != null && packageName2.length() != 0) {
                OfflinePkgCachePath searchOfflinePkgCachePath = searchOfflinePkgCachePath(packageName == null ? group : packageName, true);
                List<ZipFileInfo> zipFileInfo = searchOfflinePkgCachePath != null ? searchOfflinePkgCachePath.getZipFileInfo() : null;
                if (zipFileInfo != null) {
                    arrayList = new ArrayList();
                    for (ZipFileInfo zipFileInfo2 : zipFileInfo) {
                        OffPkgConfig manifest = zipFileInfo2.getManifest();
                        if (!Intrinsics.c(group, manifest != null ? manifest.getGroup() : null)) {
                            zipFileInfo2 = null;
                        }
                        if (zipFileInfo2 != null) {
                            arrayList.add(zipFileInfo2);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null && (!arrayList.isEmpty())) {
                    return arrayList;
                }
                if (Intrinsics.c(group, packageName2)) {
                    return null;
                }
                if ((packageName == null || packageName.length() == 0) && !Intrinsics.c(packageName, packageName2)) {
                    return getOfflinePackageDownloadInfo(group, packageName2);
                }
                return null;
            }
        }
        return null;
    }

    public final OfflinePkgCachePath getOfflinePkgCachePath(String group, String packageName) {
        if (group != null && group.length() != 0) {
            Context context$com_cloud_tmc_offline_download = OfflineManager.getContext$com_cloud_tmc_offline_download();
            String packageName2 = context$com_cloud_tmc_offline_download != null ? context$com_cloud_tmc_offline_download.getPackageName() : null;
            if (packageName2 != null && packageName2.length() != 0) {
                OfflinePkgCachePath searchOfflinePkgCachePath = searchOfflinePkgCachePath(packageName == null ? group : packageName, true);
                if (searchOfflinePkgCachePath != null) {
                    return searchOfflinePkgCachePath;
                }
                if (Intrinsics.c(group, packageName2)) {
                    return null;
                }
                if ((packageName == null || packageName.length() == 0) && !Intrinsics.c(packageName, packageName2)) {
                    return getOfflinePkgCachePath(group, packageName2);
                }
                return null;
            }
        }
        return null;
    }

    public final OfflinePkgCachePath getOfflinePkgFwCachePath(String appId, String packageName) {
        ZipFileInfo zipFileInfo;
        Object obj;
        Intrinsics.h(appId, "appId");
        Context context$com_cloud_tmc_offline_download = OfflineManager.getContext$com_cloud_tmc_offline_download();
        OfflinePkgCachePath offlinePkgCachePath = null;
        String packageName2 = context$com_cloud_tmc_offline_download != null ? context$com_cloud_tmc_offline_download.getPackageName() : null;
        if (packageName2 == null || packageName2.length() == 0) {
            return null;
        }
        OfflinePkgCachePath searchOfflinePkgCachePath$default = searchOfflinePkgCachePath$default(this, packageName == null ? packageName2 : packageName, false, 2, null);
        List<ZipFileInfo> zipFileInfo2 = searchOfflinePkgCachePath$default != null ? searchOfflinePkgCachePath$default.getZipFileInfo() : null;
        if (zipFileInfo2 != null) {
            Iterator<T> it = zipFileInfo2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                OffPkgConfig manifest = ((ZipFileInfo) obj).getManifest();
                if (Intrinsics.c(appId, manifest != null ? manifest.getGroup() : null)) {
                    break;
                }
            }
            zipFileInfo = (ZipFileInfo) obj;
        } else {
            zipFileInfo = null;
        }
        if (zipFileInfo != null) {
            OffPkgConfig manifest2 = zipFileInfo.getManifest();
            offlinePkgCachePath = new OfflinePkgCachePath(appId, manifest2 != null ? manifest2.getVersion() : null, CollectionsKt.q(zipFileInfo));
        }
        if (Intrinsics.c(appId, packageName2)) {
            return offlinePkgCachePath;
        }
        if ((packageName != null && packageName.length() != 0) || Intrinsics.c(appId, packageName) || offlinePkgCachePath != null) {
            return offlinePkgCachePath;
        }
        if (checkOfflineLoadMiniAppLegal(appId)) {
            return getOfflinePkgFwCachePath(appId, appId);
        }
        TmcLogger.d(TAG, "getOfflinePkgFwCachePath: " + ("appId: " + appId + " is not valid, unable search for miniapp offline pkg"));
        return offlinePkgCachePath;
    }

    public final boolean isMainThread() {
        return Intrinsics.c(Looper.myLooper(), Looper.getMainLooper());
    }

    public final boolean isNeedDownload(OffPkgConfig offPkgConfig) {
        UpdateEntity generateUpdateEntity;
        List<PreloadResource> preloadResource;
        Intrinsics.h(offPkgConfig, "offPkgConfig");
        if (!isAllowRequest(offPkgConfig)) {
            TmcLogger.d(TAG, "更新时间不满足要求，不允许更新");
            return false;
        }
        OffPkgConfig offlinePkgConfigCache = OfflineStoreCache.INSTANCE.getOfflinePkgConfigCache(offPkgConfig.getGroup());
        if (offlinePkgConfigCache == null) {
            return true;
        }
        if (Intrinsics.c(offPkgConfig.getVersion(), offlinePkgConfigCache.getVersion()) && (generateUpdateEntity = generateUpdateEntity(offPkgConfig)) != null && (preloadResource = generateUpdateEntity.getPreloadResource()) != null) {
            Iterator<T> it = preloadResource.iterator();
            while (it.hasNext()) {
                String staticZipUrl = ((PreloadResource) it.next()).getStaticZipUrl();
                if (staticZipUrl != null && staticZipUrl.length() > 0) {
                    OfflineZipDownloadInfo zipDownloadStatus = OfflineStoreCache.INSTANCE.getZipDownloadStatus(offPkgConfig, staticZipUrl);
                    if (zipDownloadStatus.getStatus() < 2) {
                        String url = zipDownloadStatus.getUrl();
                        if (url != null) {
                            staticZipUrl = url;
                        }
                        TmcLogger.d(TAG, "当前资源尚未下载，允许下载：" + staticZipUrl);
                        return true;
                    }
                }
            }
        }
        boolean c11 = Intrinsics.c(offPkgConfig.getVersion(), offlinePkgConfigCache.getVersion());
        boolean z10 = !c11;
        TmcLogger.d(TAG, "检查版本是否符合更新要求：" + (!c11 ? "符合" : "不符合"));
        if (!c11) {
            OfflineStoreCache.INSTANCE.setLastUpdateTime(offlinePkgConfigCache);
            k.d(o0.a(y0.b()), null, null, new OfflineUtils$isNeedDownload$2$1(offlinePkgConfigCache, INSTANCE.getDiffUpdateEntity(offPkgConfig, offlinePkgConfigCache), null), 3, null);
        }
        return z10;
    }

    public final OffPkgConfig loadManifest(String zipUnCompressPath) {
        Intrinsics.h(zipUnCompressPath, "zipUnCompressPath");
        if (!FileUtils.isDir(zipUnCompressPath)) {
            return null;
        }
        File file = new File(zipUnCompressPath, OfflineConstantsKt.OFFPKG_MANIFEST);
        if (!FileUtil.access(file)) {
            return null;
        }
        String readFile2String = FileIOUtils.readFile2String(file, "UTF-8");
        Intrinsics.g(readFile2String, "readFile2String(manifestFile, \"UTF-8\")");
        try {
            return (OffPkgConfig) TmcGsonUtils.fromJson(readFile2String, OffPkgConfig.class);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "parse Json fail", th2);
            return null;
        }
    }

    public final Bundle pointCommonParams(OffPkgConfig offPkgConfig, String trigger, Boolean isIdle, Long r72, ITask task) {
        Bundle bundle = new Bundle();
        if (offPkgConfig != null) {
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_VERSION, offPkgConfig.getVersion());
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_GROUP, offPkgConfig.getGroup());
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_NATION, offPkgConfig.getNation());
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_APP, offPkgConfig.getApp());
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_LANGUAGE, offPkgConfig.getLanguage());
            bundle.putInt(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_PRIORITY, offPkgConfig.getPriority());
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_TYPE, offPkgConfig.getType());
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_NETWORK_TYPE, offPkgConfig.getNetworkType());
        }
        if (isIdle != null) {
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_DOWNLOAD_MODEL, isIdle.booleanValue() ? OfflineConstantsKt.TRIGGER_IDLE : OfflineConstantsKt.TRIGGER_STARTUP);
        }
        if (r72 != null) {
            bundle.putLong(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_CONSUME_TIME, r72.longValue());
        }
        if (task instanceof BaseTask) {
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_TASK, ((BaseTask) task).toString());
        }
        if (trigger != null) {
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_TRIGGER, trigger);
        }
        return bundle;
    }

    public final void reportOfflinePkgApiUsageStatus(boolean hitStatus, Bundle bundle) {
        Intrinsics.h(bundle, "bundle");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.OFFLINE_PKG_API_USAGE_STATUS;
            bundle.putInt(offlineDownloadAnalyseType.getObjectNameEn(), hitStatus ? 1 : 0);
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(null, offlineDownloadAnalyseType, "", bundle);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    public final OfflinePkgCachePath searchOfflinePkgCachePath(String group, boolean useMemory) {
        boolean z10;
        UpdateEntity generateUpdateEntity;
        Intrinsics.h(group, "group");
        z10 = OfflineManager.isInit;
        if (!z10) {
            return null;
        }
        OffPkgConfig offlinePkgConfigCacheOrMemoryCache = useMemory ? OfflineStoreCache.INSTANCE.getOfflinePkgConfigCacheOrMemoryCache(group) : OfflineStoreCache.INSTANCE.getOfflinePkgConfigCache(group);
        if (offlinePkgConfigCacheOrMemoryCache == null || (generateUpdateEntity = generateUpdateEntity(offlinePkgConfigCacheOrMemoryCache)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PreloadResource> preloadResource = generateUpdateEntity.getPreloadResource();
        if (preloadResource == null) {
            return null;
        }
        Iterator<PreloadResource> it = preloadResource.iterator();
        while (it.hasNext()) {
            String staticZipUrl = it.next().getStaticZipUrl();
            if (staticZipUrl != null) {
                OfflineZipDownloadInfo zipDownloadStatus = OfflineStoreCache.INSTANCE.getZipDownloadStatus(offlinePkgConfigCacheOrMemoryCache, staticZipUrl);
                if (zipDownloadStatus.getStatus() == 4) {
                    ZipFileInfo zipFileInfo = new ZipFileInfo(null, null, null, 7, null);
                    String zipUnCompressPath = zipDownloadStatus.getZipUnCompressPath();
                    if (zipUnCompressPath != null) {
                        zipFileInfo.setZipUnCompressPath(zipUnCompressPath);
                    }
                    String url = zipDownloadStatus.getUrl();
                    if (url != null) {
                        zipFileInfo.setUrl(url);
                    }
                    OffPkgConfig manifest = zipDownloadStatus.getManifest();
                    if (manifest != null) {
                        zipFileInfo.setManifest(manifest);
                    }
                    arrayList.add(zipFileInfo);
                }
            }
        }
        return new OfflinePkgCachePath(offlinePkgConfigCacheOrMemoryCache.getGroup(), offlinePkgConfigCacheOrMemoryCache.getVersion(), arrayList);
    }

    public final void startTaskTrack(OffPkgConfig offPkgConfig, ITask task, TaskResult<?> result, String trigger) {
        Intrinsics.h(task, "task");
        Intrinsics.h(result, "result");
        Intrinsics.h(trigger, "trigger");
        if ((result instanceof TaskResult.Retry) || !result.getIsTrace()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - task.getStartTaskTime();
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        OfflineDownloadAnalyseType pointTaskStatus = getPointTaskStatus(result);
        String str = task + "，耗时：" + elapsedRealtime + "ms";
        Bundle pointCommonParams = pointCommonParams(offPkgConfig, trigger, Boolean.valueOf(task.getIsIdleRunTask()), Long.valueOf(elapsedRealtime), task);
        pointCommonParams.putInt(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_ERROR_CODE, result.getErrorCode());
        pointCommonParams.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_ERROR_MSG, result.getErrorMsg());
        Unit unit = Unit.f67184a;
        performanceAnalyseProxy.record(null, pointTaskStatus, str, pointCommonParams);
    }

    public final boolean verifyServerFile(final String appId, final String url) {
        boolean z10 = false;
        if (appId == null || appId.length() == 0 || url == null || url.length() == 0) {
            TmcLogger.d(TAG, "verifyServerFile: appId or url is null or empty");
            return false;
        }
        if (!com.cloud.tmc.miniutils.util.NetworkUtils.isConnected()) {
            TmcLogger.d(TAG, "verifyServerFile: 网络未连接，默认进行通过。" + url);
            return true;
        }
        if (!verifyServerUrl(appId, url)) {
            TmcLogger.d(TAG, "verifyServerFile: 该URL不在待校验的URLS内则默认进行通过。" + url);
            return true;
        }
        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$verifyServerFile$block$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                final String str = appId;
                Response execute = FirebasePerfOkHttpClient.execute(builder.addInterceptor(new Interceptor() { // from class: com.cloud.tmc.offline.download.utils.OfflineUtils$verifyServerFile$block$1$invoke$$inlined$-addInterceptor$1
                    @Override // okhttp3.Interceptor
                    public final Response intercept(Interceptor.Chain chain) {
                        boolean metadataMatches;
                        Intrinsics.h(chain, "chain");
                        Request request = chain.request();
                        Response proceed = chain.proceed(request);
                        metadataMatches = OfflineUtils.INSTANCE.metadataMatches(str, proceed);
                        return metadataMatches ? new Response.Builder().request(request).protocol(proceed.protocol()).code(Sdk$SDKError.Reason.AD_EXPIRED_VALUE).message("Not Modified").body(proceed.body()).build() : proceed;
                    }
                }).build().newCall(new Request.Builder().url(url).build()));
                boolean z11 = true;
                if (execute.code() == 304) {
                    TmcLogger.d(OfflineUtils.TAG, "verifyServerFile: 离线文件校验成功，Not Modified，url: " + url);
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                    String str2 = appId;
                    OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.OFFLINE_VERIFY_SERVER_FILE;
                    Bundle bundle = new Bundle();
                    String str3 = appId;
                    String str4 = url;
                    bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_APPID, str3);
                    bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_URL, str4);
                    bundle.putInt(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_VERIFY_SERVER_STATUS, 0);
                    Unit unit = Unit.f67184a;
                    performanceAnalyseProxy.record(str2, offlineDownloadAnalyseType, "", bundle);
                } else {
                    if (execute.isSuccessful()) {
                        TmcLogger.d(OfflineUtils.TAG, "verifyServerFile: 请求成功，未命中离线文件，文件失效，url: " + url);
                        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                        String str5 = appId;
                        OfflineDownloadAnalyseType offlineDownloadAnalyseType2 = OfflineDownloadAnalyseType.OFFLINE_VERIFY_SERVER_FILE;
                        Bundle bundle2 = new Bundle();
                        String str6 = appId;
                        String str7 = url;
                        bundle2.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_APPID, str6);
                        bundle2.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_URL, str7);
                        bundle2.putInt(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_VERIFY_SERVER_STATUS, 1);
                        Unit unit2 = Unit.f67184a;
                        performanceAnalyseProxy2.record(str5, offlineDownloadAnalyseType2, "", bundle2);
                    } else {
                        TmcLogger.d(OfflineUtils.TAG, "verifyServerFile: 请求失败，url: " + url);
                        PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                        String str8 = appId;
                        OfflineDownloadAnalyseType offlineDownloadAnalyseType3 = OfflineDownloadAnalyseType.OFFLINE_VERIFY_SERVER_FILE;
                        Bundle bundle3 = new Bundle();
                        String str9 = appId;
                        String str10 = url;
                        bundle3.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_APPID, str9);
                        bundle3.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_URL, str10);
                        bundle3.putInt(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_VERIFY_SERVER_STATUS, 2);
                        Unit unit3 = Unit.f67184a;
                        performanceAnalyseProxy3.record(str8, offlineDownloadAnalyseType3, "", bundle3);
                    }
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }
        };
        try {
            if (isMainThread()) {
                TmcLogger.e(TAG, "verifyServerFile 不支持在主线程中使用");
            } else {
                z10 = ((Boolean) function0.invoke()).booleanValue();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "verifyServerFile request fail! ", th2);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            OfflineDownloadAnalyseType offlineDownloadAnalyseType = OfflineDownloadAnalyseType.OFFLINE_VERIFY_SERVER_FILE;
            Bundle bundle = new Bundle();
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_APPID, appId);
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_URL, url);
            bundle.putString(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_ERROR_MSG, th2.getMessage());
            bundle.putInt(OfflineConstantsKt.TRACK_KEY_OFFLINE_PKG_VERIFY_SERVER_STATUS, 3);
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(appId, offlineDownloadAnalyseType, "", bundle);
        }
        return z10;
    }
}
