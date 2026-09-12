package com.cloud.tmc.offline.download.task;

import android.os.SystemClock;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.h5update.utils.l;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.miniutils.util.FileUtils;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.callback.OnUpdateCallback;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.model.OfflineZipFileInfo;
import com.cloud.tmc.offline.download.model.TaskResult;
import com.cloud.tmc.offline.download.task.base.BaseTask;
import com.cloud.tmc.offline.download.task.base.ITask;
import com.cloud.tmc.offline.download.utils.NetworkUtils;
import com.cloud.tmc.offline.download.utils.OfflineStoreCache;
import com.cloud.tmc.offline.download.utils.OfflineUtils;
import com.cloud.tmc.offline.download.utils.TrackReportUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012 \b\u0002\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\u0002\u0010\rJ\"\u0010\"\u001a\u00020\f2\u0018\u0010#\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010$H\u0016R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R2\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/cloud/tmc/offline/download/task/DownloadTask;", "Lcom/cloud/tmc/offline/download/task/base/BaseTask;", "offPkgConfig", "Lcom/cloud/tmc/offline/download/model/OffPkgConfig;", "trigger", "", "isIdleRunTask", "", "onResult", "Lkotlin/Function2;", "Lcom/cloud/tmc/offline/download/task/base/ITask;", "Lcom/cloud/tmc/offline/download/model/TaskResult;", "", "(Lcom/cloud/tmc/offline/download/model/OffPkgConfig;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)V", "downloadFinishTime", "Ljava/util/concurrent/ConcurrentHashMap;", "", "downloadStartTime", "()Z", "getOffPkgConfig", "()Lcom/cloud/tmc/offline/download/model/OffPkgConfig;", "getOnResult", "()Lkotlin/jvm/functions/Function2;", "setOnResult", "(Lkotlin/jvm/functions/Function2;)V", TrackingKey.PRIORITY, "", "getPriority", "()I", "setPriority", "(I)V", "retryCount", "getTrigger", "()Ljava/lang/String;", "run", "block", "Lkotlin/Function1;", "Companion", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class DownloadTask extends BaseTask {
    private static final int RETRY_DELAY_COUNT = 3;
    private static final long RETRY_DELAY_TIME = 15000;
    private static final String TAG = "TmcOfflineDownload: DownloadTask";
    private final ConcurrentHashMap<String, Long> downloadFinishTime;
    private final ConcurrentHashMap<String, Long> downloadStartTime;
    private final boolean isIdleRunTask;
    private final OffPkgConfig offPkgConfig;
    private Function2<? super ITask, ? super TaskResult<?>, Unit> onResult;
    private int priority;
    private int retryCount;
    private final String trigger;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTask(OffPkgConfig offPkgConfig, String trigger, boolean z10, Function2<? super ITask, ? super TaskResult<?>, Unit> function2) {
        super("DownloadTask-" + offPkgConfig.getGroup(), 0L, 2, null);
        Intrinsics.h(offPkgConfig, "offPkgConfig");
        Intrinsics.h(trigger, "trigger");
        this.offPkgConfig = offPkgConfig;
        this.trigger = trigger;
        this.isIdleRunTask = z10;
        this.onResult = function2;
        this.downloadStartTime = new ConcurrentHashMap<>();
        this.downloadFinishTime = new ConcurrentHashMap<>();
        this.priority = offPkgConfig.getPriority();
    }

    public /* synthetic */ DownloadTask(OffPkgConfig offPkgConfig, String str, boolean z10, Function2 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(offPkgConfig, str, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? null : function2);
    }

    public final OffPkgConfig getOffPkgConfig() {
        return this.offPkgConfig;
    }

    @Override // com.cloud.tmc.offline.download.task.base.BaseTask, com.cloud.tmc.offline.download.task.base.ITask
    public Function2<ITask, TaskResult<?>, Unit> getOnResult() {
        return this.onResult;
    }

    @Override // com.cloud.tmc.offline.download.task.base.BaseTask, com.cloud.tmc.offline.download.task.base.ITask
    /* renamed from: getPriority, reason: from getter */
    public int get_priority() {
        return this.priority;
    }

    @Override // com.cloud.tmc.offline.download.task.base.ITask
    public String getTrigger() {
        return this.trigger;
    }

    @Override // com.cloud.tmc.offline.download.task.base.BaseTask, com.cloud.tmc.offline.download.task.base.ITask
    /* renamed from: isIdleRunTask, reason: from getter */
    public boolean getIsIdleRunTask() {
        return this.isIdleRunTask;
    }

    @Override // com.cloud.tmc.offline.download.task.base.ITask
    public void run(Function1<? super TaskResult<?>, Unit> block) {
        boolean z10;
        Object failure;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long startTaskTime = elapsedRealtime - getStartTaskTime();
        OfflineUtils offlineUtils = OfflineUtils.INSTANCE;
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(null, OfflineDownloadAnalyseType.QUEUE_TIME, this + "，耗时：" + startTaskTime + "ms", offlineUtils.pointCommonParams(this.offPkgConfig, getTrigger(), Boolean.valueOf(getIsIdleRunTask()), Long.valueOf(startTaskTime), this));
        TmcLogger.d(TAG, "DownloadTask::run() " + TmcGsonUtilsKt.toJson(this.offPkgConfig));
        if (!NetworkUtils.isConnected()) {
            TmcLogger.d(TAG, "Network connection is not connected!");
            if (block != null) {
                block.invoke(new TaskResult.Failure(107, "Network connection is not connected!", true));
                return;
            }
            return;
        }
        String group = this.offPkgConfig.getGroup();
        if (group == null || group.length() == 0) {
            if (block != null) {
                String group2 = this.offPkgConfig.getGroup();
                if (group2 == null) {
                    group2 = "The";
                }
                block.invoke(new TaskResult.Failure(105, group2 + " offline package download group is empty", true));
                return;
            }
            return;
        }
        OfflineZipFileInfo generateDefaultZipFileInfo = offlineUtils.generateDefaultZipFileInfo(this.offPkgConfig);
        TmcLogger.d(TAG, "fileInfo: " + generateDefaultZipFileInfo);
        String zipCacheAbsolutePath = generateDefaultZipFileInfo.getZipCacheAbsolutePath();
        try {
            z10 = FileUtils.createOrExistsDir(zipCacheAbsolutePath);
        } catch (Exception e11) {
            TmcLogger.e(TAG, "Unable to create zip directory", e11);
            z10 = false;
        }
        if (!z10) {
            if (block != null) {
                block.invoke(new TaskResult.Failure(0, "Offline cache file deletion failed", false, 5, null));
                return;
            }
            return;
        }
        TH5Update.f21320c.o(zipCacheAbsolutePath);
        OfflineUtils offlineUtils2 = OfflineUtils.INSTANCE;
        UpdateEntity generateUpdateEntity = offlineUtils2.generateUpdateEntity(this.offPkgConfig);
        if (generateUpdateEntity == null) {
            if (block != null) {
                block.invoke(new TaskResult.Failure(0, "Offline cache extra config is null or empty", false, 5, null));
                return;
            }
            return;
        }
        List<PreloadResource> preloadResource = generateUpdateEntity.getPreloadResource();
        List<PreloadResource> list = preloadResource;
        if (list == null || list.isEmpty()) {
            if (block != null) {
                block.invoke(new TaskResult.Failure(0, "Offline resource is null or empty", false, 5, null));
                return;
            }
            return;
        }
        OfflineManager offlineManager = OfflineManager.INSTANCE;
        if (offlineManager.getOnUpdateCallback$com_cloud_tmc_offline_download() != null) {
            if (block != null) {
                block.invoke(new TaskResult.Failure(0, "Offline has downloadTask is running...", false, 5, null));
                return;
            }
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(preloadResource.size());
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        final LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        offlineManager.setOnUpdateCallback$com_cloud_tmc_offline_download(new OnUpdateCallback() { // from class: com.cloud.tmc.offline.download.task.DownloadTask$run$1
            @Override // com.cloud.tmc.offline.download.callback.OnUpdateCallback
            public void onDownloadProcess(String url, long size, long totalSize) {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                Intrinsics.h(url, "url");
                concurrentHashMap = DownloadTask.this.downloadStartTime;
                if (concurrentHashMap.containsKey(url)) {
                    return;
                }
                concurrentHashMap2 = DownloadTask.this.downloadStartTime;
                concurrentHashMap2.put(url, Long.valueOf(System.currentTimeMillis()));
            }

            @Override // com.cloud.tmc.offline.download.callback.OnUpdateCallback
            public void onError(String url, int errCode, String errMsg) {
                ConcurrentHashMap concurrentHashMap;
                Intrinsics.h(url, "url");
                Intrinsics.h(errMsg, "errMsg");
                long currentTimeMillis = System.currentTimeMillis();
                concurrentHashMap = DownloadTask.this.downloadStartTime;
                Long l11 = (Long) concurrentHashMap.remove(url);
                if (l11 == null) {
                    l11 = Long.valueOf(currentTimeMillis);
                }
                TrackReportUtils.INSTANCE.trackDownloadRecord(DownloadTask.this.getOffPkgConfig().getGroup(), url, false, Integer.valueOf(errCode), errMsg, currentTimeMillis - l11.longValue());
                OfflineStoreCache.INSTANCE.setZipDownloadStatus(DownloadTask.this.getOffPkgConfig(), new OfflineZipDownloadInfo(url, null, 0, null, 10, null));
                linkedHashSet2.add(url);
                countDownLatch.countDown();
            }

            @Override // com.cloud.tmc.offline.download.callback.OnUpdateCallback
            public void onNoNeedDownload(String url) {
                Intrinsics.h(url, "url");
                linkedHashSet.add(url);
                countDownLatch.countDown();
            }

            @Override // com.cloud.tmc.offline.download.callback.OnUpdateCallback
            public void onUnZipDownloadFinish(String url, String zipUnCompressPath, File zipFile) {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                String str;
                String logo;
                Intrinsics.h(url, "url");
                Intrinsics.h(zipUnCompressPath, "zipUnCompressPath");
                Intrinsics.h(zipFile, "zipFile");
                OfflineUtils offlineUtils3 = OfflineUtils.INSTANCE;
                OffPkgConfig loadManifest = offlineUtils3.loadManifest(zipUnCompressPath);
                if (loadManifest == null) {
                    OfflineStoreCache.INSTANCE.setZipDownloadStatus(DownloadTask.this.getOffPkgConfig(), new OfflineZipDownloadInfo(url, null, 5, null, 8, null));
                    String group3 = DownloadTask.this.getOffPkgConfig().getGroup();
                    if (group3 == null) {
                        group3 = "The";
                    }
                    TmcLogger.d("TmcOfflineDownload: DownloadTask", group3 + " downloaded offline package is not legal! zipUnCompressPath: " + zipUnCompressPath);
                    countDownLatch.countDown();
                    return;
                }
                linkedHashSet.add(url);
                OfflineStoreCache.INSTANCE.setZipDownloadStatus(DownloadTask.this.getOffPkgConfig(), new OfflineZipDownloadInfo(url, zipUnCompressPath, 4, loadManifest));
                String str2 = "";
                offlineUtils3.generateVUrl(StringExtKt.orDefault(loadManifest != null ? loadManifest.getGroup() : null, StringExtKt.orDefault(DownloadTask.this.getOffPkgConfig().getGroup(), "")), zipUnCompressPath);
                concurrentHashMap = DownloadTask.this.downloadFinishTime;
                Long l11 = (Long) concurrentHashMap.remove(url);
                if (l11 == null) {
                    l11 = Long.valueOf(System.currentTimeMillis());
                }
                long longValue = l11.longValue();
                concurrentHashMap2 = DownloadTask.this.downloadStartTime;
                Long l12 = (Long) concurrentHashMap2.remove(url);
                if (l12 == null) {
                    l12 = Long.valueOf(longValue);
                }
                TrackReportUtils.INSTANCE.trackDownloadRecord(DownloadTask.this.getOffPkgConfig().getGroup(), url, true, 200, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, longValue - l12.longValue());
                countDownLatch.countDown();
                OfflineAppProxy offlineAppProxy = (OfflineAppProxy) TmcProxy.get(OfflineAppProxy.class);
                AppInfoModel appInfo = DownloadTask.this.getOffPkgConfig().getAppInfo();
                if (appInfo == null || (str = appInfo.getAppId()) == null) {
                    str = "";
                }
                AppInfoModel appInfo2 = DownloadTask.this.getOffPkgConfig().getAppInfo();
                if (appInfo2 != null && (logo = appInfo2.getLogo()) != null) {
                    str2 = logo;
                }
                offlineAppProxy.downloadIcon(str, str2);
                ((OfflineAppProxy) TmcProxy.get(OfflineAppProxy.class)).scanForOfflineDownloadSuccess();
            }

            @Override // com.cloud.tmc.offline.download.callback.OnUpdateCallback
            public void onZipDownloadCancel(String url) {
                ConcurrentHashMap concurrentHashMap;
                Intrinsics.h(url, "url");
                long currentTimeMillis = System.currentTimeMillis();
                concurrentHashMap = DownloadTask.this.downloadStartTime;
                Long l11 = (Long) concurrentHashMap.remove(url);
                if (l11 == null) {
                    l11 = Long.valueOf(currentTimeMillis);
                }
                TrackReportUtils.INSTANCE.trackDownloadRecord(DownloadTask.this.getOffPkgConfig().getGroup(), url, false, 1000, "cancel", currentTimeMillis - l11.longValue());
                OfflineStoreCache.INSTANCE.setZipDownloadStatus(DownloadTask.this.getOffPkgConfig(), new OfflineZipDownloadInfo(url, null, 0, null, 10, null));
                linkedHashSet2.add(url);
                countDownLatch.countDown();
            }

            @Override // com.cloud.tmc.offline.download.callback.OnUpdateCallback
            public void onZipDownloadFinish(String url) {
                Intrinsics.h(url, "url");
                OfflineStoreCache.INSTANCE.setZipDownloadStatus(DownloadTask.this.getOffPkgConfig(), new OfflineZipDownloadInfo(url, null, 2, null, 10, null));
            }

            @Override // com.cloud.tmc.offline.download.callback.OnUpdateCallback
            public void onZipDownloadStart(String url) {
                ConcurrentHashMap concurrentHashMap;
                Intrinsics.h(url, "url");
                OfflineStoreCache.INSTANCE.setZipDownloadStatus(DownloadTask.this.getOffPkgConfig(), new OfflineZipDownloadInfo(url, null, 1, null, 10, null));
                concurrentHashMap = DownloadTask.this.downloadStartTime;
                concurrentHashMap.put(url, Long.valueOf(System.currentTimeMillis()));
            }

            @Override // com.cloud.tmc.offline.download.callback.OnUpdateCallback
            public void onZipDownloaded(String url) {
                ConcurrentHashMap concurrentHashMap;
                Intrinsics.h(url, "url");
                OfflineStoreCache.INSTANCE.setZipDownloadStatus(DownloadTask.this.getOffPkgConfig(), new OfflineZipDownloadInfo(url, null, 3, null, 10, null));
                concurrentHashMap = DownloadTask.this.downloadFinishTime;
                concurrentHashMap.put(url, Long.valueOf(System.currentTimeMillis()));
            }
        });
        try {
            l.f21391a.p(generateUpdateEntity);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            TmcLogger.d(TAG, "await: " + countDownLatch.await(preloadResource.size(), TimeUnit.MINUTES));
            TrackReportUtils.INSTANCE.reportDownloadRecord(this.offPkgConfig.getGroup());
            offlineManager.setOnUpdateCallback$com_cloud_tmc_offline_download(null);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(null, OfflineDownloadAnalyseType.DOWNLOAD_TIME, this + "，耗时：" + elapsedRealtime2 + "ms", offlineUtils2.pointCommonParams(this.offPkgConfig, getTrigger(), Boolean.valueOf(getIsIdleRunTask()), Long.valueOf(elapsedRealtime2), this));
            if (linkedHashSet.isEmpty()) {
                failure = new TaskResult.Failure(113, "Download failed", true);
            } else {
                failure = new TaskResult.Success("Download completed. offPkgConfig: " + TmcGsonUtilsKt.toJson(this.offPkgConfig), true);
            }
            if (block != null) {
                block.invoke(failure);
            }
        } catch (Throwable th3) {
            th = th3;
            TmcLogger.e(TAG, "Error processing update entity", th);
            if (block != null) {
                block.invoke(new TaskResult.Failure(0, th.getMessage(), true, 1, null));
            }
        }
    }

    @Override // com.cloud.tmc.offline.download.task.base.BaseTask, com.cloud.tmc.offline.download.task.base.ITask
    public void setOnResult(Function2<? super ITask, ? super TaskResult<?>, Unit> function2) {
        this.onResult = function2;
    }

    @Override // com.cloud.tmc.offline.download.task.base.BaseTask, com.cloud.tmc.offline.download.task.base.ITask
    public void setPriority(int i11) {
        this.priority = i11;
    }
}
