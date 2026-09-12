package com.cloud.tmc.offline.download.task;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.OnFileDownloadCallback;
import com.cloud.tmc.kernel.proxy.network.a;
import com.cloud.tmc.miniutils.util.FileUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflineZipDownloadInfo;
import com.cloud.tmc.offline.download.utils.OfflineStoreCache;
import com.cloud.tmc.offline.download.utils.PrePullAppInfoUtils;
import com.cloud.tmc.offline.download.utils.TrackReportUtils;
import com.transsion.mpush.api.LocalPushMessage;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;

@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J:\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0019\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u001a\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006!"}, d2 = {"com/cloud/tmc/offline/download/task/PrePullAppInfoDownloadTask$downloadFile$1", "Lcom/cloud/tmc/kernel/proxy/network/OnFileDownloadCallback;", "offPkgConfig", "Lcom/cloud/tmc/offline/download/model/OffPkgConfig;", "getOffPkgConfig", "()Lcom/cloud/tmc/offline/download/model/OffPkgConfig;", "serverLastModify", "", "getServerLastModify", "()Ljava/lang/String;", "setServerLastModify", "(Ljava/lang/String;)V", "contentType", "", "contextType", "Lokhttp3/MediaType;", "onCancel", "", "url", "callbackId", "onFailed", "errorCode", "errorMsg", "e", "Ljava/io/IOException;", "onFinish", "onPrepare", "onProgress", NotificationCompat.CATEGORY_PROGRESS, "", "responseHeader", "headers", "Lokhttp3/Headers;", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class PrePullAppInfoDownloadTask$downloadFile$1 implements OnFileDownloadCallback {
    final /* synthetic */ String $downloadUrl;
    final /* synthetic */ Function3<String, String, IOException, Unit> $error;
    final /* synthetic */ String $filePath;
    final /* synthetic */ Function0<Unit> $success;
    private final OffPkgConfig offPkgConfig = PrePullAppInfoUtils.INSTANCE.generatePrePullAppInfoOffPkgConfig();
    private String serverLastModify;
    final /* synthetic */ PrePullAppInfoDownloadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PrePullAppInfoDownloadTask$downloadFile$1(String str, Function3<? super String, ? super String, ? super IOException, Unit> function3, Function0<Unit> function0, PrePullAppInfoDownloadTask prePullAppInfoDownloadTask, String str2) {
        this.$downloadUrl = str;
        this.$error = function3;
        this.$success = function0;
        this.this$0 = prePullAppInfoDownloadTask;
        this.$filePath = str2;
    }

    @Override // com.cloud.tmc.kernel.proxy.network.OnFileDownloadCallback
    public boolean contentType(MediaType contextType) {
        TmcLogger.d("PrePullAppInfoDownloadTask", "contentType: " + contextType);
        return true;
    }

    public final OffPkgConfig getOffPkgConfig() {
        return this.offPkgConfig;
    }

    public final String getServerLastModify() {
        return this.serverLastModify;
    }

    @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
    public void onCancel(String url, String callbackId) {
        TmcLogger.d("PrePullAppInfoDownloadTask", "onCancel url: " + url + " callbackId: " + callbackId);
        Function3<String, String, IOException, Unit> function3 = this.$error;
        if (function3 != null) {
            function3.invoke("106", "cancel download", null);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
    public void onFailed(String url, String errorCode, String errorMsg, IOException e11, String callbackId) {
        String str;
        TmcLogger.e("PrePullAppInfoDownloadTask", "onFailed url: " + url + " errorCode: " + errorCode + " errorMsg: " + errorMsg + " callbackId: " + callbackId);
        if (!CollectionsKt.b0(CollectionsKt.o("D008", "D009"), errorCode)) {
            FileUtils.delete(this.$filePath);
            Function3<String, String, IOException, Unit> function3 = this.$error;
            if (function3 != null) {
                function3.invoke(errorCode, errorMsg, e11);
                return;
            }
            return;
        }
        OfflineStoreCache.INSTANCE.setLastUpdateTime(this.offPkgConfig);
        String stackTraceString = Log.getStackTraceString(e11);
        Intrinsics.g(stackTraceString, "getStackTraceString(e)");
        if (stackTraceString.length() == 0) {
            stackTraceString = StringExtKt.orDefault(errorMsg, "No new version available");
        }
        String str2 = stackTraceString;
        TrackReportUtils trackReportUtils = TrackReportUtils.INSTANCE;
        str = this.this$0.previousStep;
        trackReportUtils.trackPrePullCdnRecord(OfflineConstantsKt.PRE_PULL_APPINFO_STEP_DOWNLOAD, str, 2, this.offPkgConfig.getPkgUrl(), LocalPushMessage.STYLE_VERTICAL_TYPE, str2);
        trackReportUtils.reportPrePullCdnRecord();
    }

    @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
    public void onFinish(String url, String callbackId) {
        TmcLogger.d("PrePullAppInfoDownloadTask", "onFinish url: " + url + " callbackId: " + callbackId);
        String str = this.serverLastModify;
        if (str != null) {
            OfflineStoreCache.INSTANCE.setLastModify(this.offPkgConfig, str);
        }
        Function0<Unit> function0 = this.$success;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
    public void onPrepare(String url, String callbackId) {
        TmcLogger.d("PrePullAppInfoDownloadTask", "onPrepare url: " + url + " callbackId: " + callbackId);
    }

    @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
    public void onProgress(String url, int progress, String callbackId) {
        TmcLogger.d("PrePullAppInfoDownloadTask", "onProgress url: " + url + " progress: " + progress + " callbackId: " + callbackId);
    }

    @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
    public /* synthetic */ void progressUpdate(String str, int i11, String str2, long j11, long j12) {
        a.a(this, str, i11, str2, j11, j12);
    }

    @Override // com.cloud.tmc.kernel.proxy.network.OnFileDownloadCallback
    public boolean responseHeader(Headers headers) {
        Intrinsics.h(headers, "headers");
        PrePullAppInfoUtils prePullAppInfoUtils = PrePullAppInfoUtils.INSTANCE;
        boolean checkResponseHeader = prePullAppInfoUtils.checkResponseHeader(headers, new Function1<String, Unit>() { // from class: com.cloud.tmc.offline.download.task.PrePullAppInfoDownloadTask$downloadFile$1$responseHeader$isEquals$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.f67184a;
            }

            public final void invoke(String serverLastModify) {
                Intrinsics.h(serverLastModify, "serverLastModify");
                PrePullAppInfoDownloadTask$downloadFile$1.this.setServerLastModify(serverLastModify);
            }
        });
        if (!checkResponseHeader) {
            prePullAppInfoUtils.setZipDownloadStatus(new OfflineZipDownloadInfo(this.$downloadUrl, null, 1, null, 10, null));
        }
        return !checkResponseHeader;
    }

    public final void setServerLastModify(String str) {
        this.serverLastModify = str;
    }
}
