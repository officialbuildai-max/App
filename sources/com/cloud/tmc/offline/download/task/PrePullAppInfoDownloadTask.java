package com.cloud.tmc.offline.download.task;

import android.util.Log;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.utils.GenerateIdUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.model.TaskResult;
import com.cloud.tmc.offline.download.task.base.BaseTask;
import com.cloud.tmc.offline.download.task.base.ITask;
import com.cloud.tmc.offline.download.utils.NetworkUtils;
import com.cloud.tmc.offline.download.utils.PrePullAppInfoUtils;
import com.cloud.tmc.offline.download.utils.TrackReportUtils;
import com.transsion.mpush.core.config.MsgShowStatus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJV\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00152(\b\u0002\u0010\u0016\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017H\u0002J\"\u0010\u0019\u001a\u00020\b2\u0018\u0010\u001a\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u001bH\u0016R2\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/cloud/tmc/offline/download/task/PrePullAppInfoDownloadTask;", "Lcom/cloud/tmc/offline/download/task/base/BaseTask;", "previousStep", "", "onResult", "Lkotlin/Function2;", "Lcom/cloud/tmc/offline/download/task/base/ITask;", "Lcom/cloud/tmc/offline/download/model/TaskResult;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getOnResult", "()Lkotlin/jvm/functions/Function2;", "setOnResult", "(Lkotlin/jvm/functions/Function2;)V", "trigger", "getTrigger", "()Ljava/lang/String;", "downloadFile", "downloadUrl", NativeRequestBridge.KEY_FILE_PATH, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, "Lkotlin/Function0;", "error", "Lkotlin/Function3;", "Ljava/io/IOException;", "run", "block", "Lkotlin/Function1;", "Companion", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class PrePullAppInfoDownloadTask extends BaseTask {
    private static final String TAG = "PrePullAppInfoDownloadTask";
    private Function2<? super ITask, ? super TaskResult<?>, Unit> onResult;
    private final String previousStep;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrePullAppInfoDownloadTask(String previousStep, Function2<? super ITask, ? super TaskResult<?>, Unit> function2) {
        super(TAG, 0L, 2, null);
        Intrinsics.h(previousStep, "previousStep");
        this.previousStep = previousStep;
        this.onResult = function2;
    }

    private final void downloadFile(String downloadUrl, String filePath, Function0<Unit> success, Function3<? super String, ? super String, ? super IOException, Unit> error) {
        if (downloadUrl != null) {
            try {
                if (downloadUrl.length() != 0) {
                    String generateRandomId = GenerateIdUtils.INSTANCE.generateRandomId();
                    ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).downloadPackage(generateRandomId, downloadUrl, filePath, new HashMap(), generateRandomId, new PrePullAppInfoDownloadTask$downloadFile$1(downloadUrl, error, success, this, filePath));
                    return;
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, th2);
                return;
            }
        }
        TmcLogger.d(TAG, "下载链接为 null");
        if (error != null) {
            error.invoke("101", "下载链接为 null", null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void downloadFile$default(PrePullAppInfoDownloadTask prePullAppInfoDownloadTask, String str, String str2, Function0 function0, Function3 function3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        if ((i11 & 8) != 0) {
            function3 = null;
        }
        prePullAppInfoDownloadTask.downloadFile(str, str2, function0, function3);
    }

    @Override // com.cloud.tmc.offline.download.task.base.BaseTask, com.cloud.tmc.offline.download.task.base.ITask
    public Function2<ITask, TaskResult<?>, Unit> getOnResult() {
        return this.onResult;
    }

    @Override // com.cloud.tmc.offline.download.task.base.ITask
    public String getTrigger() {
        return OfflineConstantsKt.TRIGGER_IDLE;
    }

    @Override // com.cloud.tmc.offline.download.task.base.ITask
    public void run(final Function1<? super TaskResult<?>, Unit> block) {
        TmcLogger.d(TAG, "previousStep: " + this.previousStep);
        if (!NetworkUtils.isConnected()) {
            TmcLogger.d(TAG, "Network is not connected");
            return;
        }
        PrePullAppInfoUtils prePullAppInfoUtils = PrePullAppInfoUtils.INSTANCE;
        final OffPkgConfig generatePrePullAppInfoOffPkgConfig = prePullAppInfoUtils.generatePrePullAppInfoOffPkgConfig();
        File generateDownloadFile = prePullAppInfoUtils.generateDownloadFile(generatePrePullAppInfoOffPkgConfig);
        if (generateDownloadFile == null) {
            TmcLogger.d(TAG, "Generating download file failed");
            return;
        }
        String pkgUrl = generatePrePullAppInfoOffPkgConfig.getPkgUrl();
        String absolutePath = generateDownloadFile.getAbsolutePath();
        Intrinsics.g(absolutePath, "targetFile.absolutePath");
        downloadFile(pkgUrl, absolutePath, new Function0<Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoDownloadTask$run$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m724invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m724invoke() {
                String str;
                PrePullAppInfoUtils.INSTANCE.setZipDownloadStatus(new OfflineZipDownloadInfo(OffPkgConfig.this.getPkgUrl(), null, 2, null, 10, null));
                TrackReportUtils trackReportUtils = TrackReportUtils.INSTANCE;
                str = this.previousStep;
                trackReportUtils.trackPrePullCdnRecord(OfflineConstantsKt.PRE_PULL_APPINFO_STEP_DOWNLOAD, str, 1, OffPkgConfig.this.getPkgUrl(), MsgShowStatus.STATUS_OK, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS);
                Function1<TaskResult<?>, Unit> function1 = block;
                if (function1 != null) {
                    function1.invoke(new TaskResult.Success(OfflineConstantsKt.PRE_PULL_APPINFO_STEP_UNZIP, false, 2, null));
                }
            }
        }, new Function3<String, String, IOException, Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoDownloadTask$run$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((String) obj, (String) obj2, (IOException) obj3);
                return Unit.f67184a;
            }

            public final void invoke(String str, String str2, IOException iOException) {
                String str3;
                String str4;
                PrePullAppInfoUtils.INSTANCE.setZipDownloadStatus(new OfflineZipDownloadInfo(OffPkgConfig.this.getPkgUrl(), null, 0, null, 10, null));
                String stackTraceString = Log.getStackTraceString(iOException);
                Intrinsics.g(stackTraceString, "getStackTraceString(e)");
                if (stackTraceString.length() == 0) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    str3 = str2;
                } else {
                    str3 = stackTraceString;
                }
                TrackReportUtils trackReportUtils = TrackReportUtils.INSTANCE;
                str4 = this.previousStep;
                trackReportUtils.trackPrePullCdnRecord(OfflineConstantsKt.PRE_PULL_APPINFO_STEP_DOWNLOAD, str4, 0, OffPkgConfig.this.getPkgUrl(), str, str3);
                trackReportUtils.reportPrePullCdnRecord();
            }
        });
    }

    @Override // com.cloud.tmc.offline.download.task.base.BaseTask, com.cloud.tmc.offline.download.task.base.ITask
    public void setOnResult(Function2<? super ITask, ? super TaskResult<?>, Unit> function2) {
        this.onResult = function2;
    }
}
