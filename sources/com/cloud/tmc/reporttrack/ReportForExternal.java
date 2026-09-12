package com.cloud.tmc.reporttrack;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.reporttrack.utils.AthenaDataBean;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/cloud/tmc/reporttrack/ReportForExternal;", "", "()V", "APP_ID", "", "TAG", "", "athenaReport", "", "tag", "athenaAppId", "data", "Landroid/os/Bundle;", "report", "bundle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReportForExternal {
    private static final int APP_ID = 3755;
    public static final ReportForExternal INSTANCE = new ReportForExternal();
    public static final String TAG = "ExternalAthenaUtil";

    private ReportForExternal() {
    }

    private final void athenaReport(String tag, int athenaAppId, Bundle data) {
        if (TextUtils.isEmpty(tag)) {
            return;
        }
        new yi.a(tag, athenaAppId).c(data, null).b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(android.os.Looper.myLooper(), android.os.Looper.getMainLooper()) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        com.cloud.tmc.reporttrack.utils.Utils.mThreadPoolExecutor.execute(new com.cloud.tmc.reporttrack.a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        com.cloud.tmc.reporttrack.utils.Utils.getInitAthenaStatus();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void report(java.lang.String r5, int r6, android.os.Bundle r7) {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = com.cloud.tmc.reporttrack.utils.Utils.delayStatus     // Catch: java.lang.Throwable -> Lfa
            int r0 = r0.get()     // Catch: java.lang.Throwable -> Lfa
            r1 = -1
            r2 = 1
            if (r0 == r1) goto L24
            java.util.concurrent.atomic.AtomicBoolean r0 = com.cloud.tmc.reporttrack.utils.Utils.currentProcessIsInitAthena     // Catch: java.lang.Throwable -> Lfa
            boolean r0 = r0.get()     // Catch: java.lang.Throwable -> Lfa
            if (r0 == 0) goto L1a
            java.util.concurrent.atomic.AtomicBoolean r0 = com.cloud.tmc.reporttrack.utils.Utils.mainProcessIsInitAthena     // Catch: java.lang.Throwable -> Lfa
            boolean r0 = r0.get()     // Catch: java.lang.Throwable -> Lfa
            if (r0 != 0) goto L23
        L1a:
            java.util.concurrent.atomic.AtomicInteger r0 = com.cloud.tmc.reporttrack.utils.Utils.delayStatus     // Catch: java.lang.Throwable -> Lfa
            int r0 = r0.get()     // Catch: java.lang.Throwable -> Lfa
            if (r0 != r2) goto L23
            goto L24
        L23:
            r2 = 0
        L24:
            if (r2 == 0) goto L42
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> Lfa
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> Lfa
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r1)     // Catch: java.lang.Throwable -> Lfa
            if (r0 == 0) goto L3f
            java.util.concurrent.ThreadPoolExecutor r0 = com.cloud.tmc.reporttrack.utils.Utils.mThreadPoolExecutor     // Catch: java.lang.Throwable -> Lfa
            com.cloud.tmc.reporttrack.a r1 = new com.cloud.tmc.reporttrack.a     // Catch: java.lang.Throwable -> Lfa
            r1.<init>()     // Catch: java.lang.Throwable -> Lfa
            r0.execute(r1)     // Catch: java.lang.Throwable -> Lfa
            goto L42
        L3f:
            com.cloud.tmc.reporttrack.utils.Utils.getInitAthenaStatus()     // Catch: java.lang.Throwable -> Lfa
        L42:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfa
            r0.<init>()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r1 = "report -> isNeedGetAthenaStatus:"
            r0.append(r1)     // Catch: java.lang.Throwable -> Lfa
            r0.append(r2)     // Catch: java.lang.Throwable -> Lfa
            if (r2 != 0) goto Lf0
            com.cloud.tmc.reporttrack.utils.AthenaDataCache r0 = com.cloud.tmc.reporttrack.utils.AthenaDataCache.INSTANCE     // Catch: java.lang.Throwable -> Lfa
            java.util.List r1 = r0.getAthenaData()     // Catch: java.lang.Throwable -> Lfa
            r0.clearAthenaData()     // Catch: java.lang.Throwable -> Lfa
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> Lfa
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r2 = ", tag = "
            if (r0 != 0) goto Ld9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfa
            r0.<init>()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r3 = "report -> exist cache, post all size = "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lfa
            int r3 = r1.size()     // Catch: java.lang.Throwable -> Lfa
            r0.append(r3)     // Catch: java.lang.Throwable -> Lfa
            com.cloud.tmc.reporttrack.utils.AthenaDataBean r0 = new com.cloud.tmc.reporttrack.utils.AthenaDataBean     // Catch: java.lang.Throwable -> Lfa
            r0.<init>(r6, r5, r7)     // Catch: java.lang.Throwable -> Lfa
            r1.add(r0)     // Catch: java.lang.Throwable -> Lfa
            android.os.Looper r5 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> Lfa
            android.os.Looper r6 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> Lfa
            boolean r5 = kotlin.jvm.internal.Intrinsics.c(r5, r6)     // Catch: java.lang.Throwable -> Lfa
            if (r5 == 0) goto L9a
            java.lang.Thread r5 = new java.lang.Thread     // Catch: java.lang.Throwable -> Lfa
            com.cloud.tmc.reporttrack.b r6 = new com.cloud.tmc.reporttrack.b     // Catch: java.lang.Throwable -> Lfa
            r6.<init>()     // Catch: java.lang.Throwable -> Lfa
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lfa
            r5.start()     // Catch: java.lang.Throwable -> Lfa
            goto Lfa
        L9a:
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> Lfa
            java.util.Iterator r5 = r1.iterator()     // Catch: java.lang.Throwable -> Lfa
        La0:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> Lfa
            if (r6 == 0) goto Lfa
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> Lfa
            com.cloud.tmc.reporttrack.utils.AthenaDataBean r6 = (com.cloud.tmc.reporttrack.utils.AthenaDataBean) r6     // Catch: java.lang.Throwable -> Lfa
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfa
            r7.<init>()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r0 = "report -> cache, post, athenaAppId = "
            r7.append(r0)     // Catch: java.lang.Throwable -> Lfa
            int r0 = r6.getAthenaAppId()     // Catch: java.lang.Throwable -> Lfa
            r7.append(r0)     // Catch: java.lang.Throwable -> Lfa
            r7.append(r2)     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r0 = r6.getEvent()     // Catch: java.lang.Throwable -> Lfa
            r7.append(r0)     // Catch: java.lang.Throwable -> Lfa
            com.cloud.tmc.reporttrack.ReportForExternal r7 = com.cloud.tmc.reporttrack.ReportForExternal.INSTANCE     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r0 = r6.getEvent()     // Catch: java.lang.Throwable -> Lfa
            int r1 = r6.getAthenaAppId()     // Catch: java.lang.Throwable -> Lfa
            android.os.Bundle r6 = r6.getData()     // Catch: java.lang.Throwable -> Lfa
            r7.athenaReport(r0, r1, r6)     // Catch: java.lang.Throwable -> Lfa
            goto La0
        Ld9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfa
            r0.<init>()     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r1 = "report -> no cache, post only current, athenaAppId = "
            r0.append(r1)     // Catch: java.lang.Throwable -> Lfa
            r0.append(r6)     // Catch: java.lang.Throwable -> Lfa
            r0.append(r2)     // Catch: java.lang.Throwable -> Lfa
            r0.append(r5)     // Catch: java.lang.Throwable -> Lfa
            r4.athenaReport(r5, r6, r7)     // Catch: java.lang.Throwable -> Lfa
            goto Lfa
        Lf0:
            com.cloud.tmc.reporttrack.utils.AthenaDataCache r0 = com.cloud.tmc.reporttrack.utils.AthenaDataCache.INSTANCE     // Catch: java.lang.Throwable -> Lfa
            com.cloud.tmc.reporttrack.utils.AthenaDataBean r1 = new com.cloud.tmc.reporttrack.utils.AthenaDataBean     // Catch: java.lang.Throwable -> Lfa
            r1.<init>(r6, r5, r7)     // Catch: java.lang.Throwable -> Lfa
            r0.setAthenaData(r1)     // Catch: java.lang.Throwable -> Lfa
        Lfa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.reporttrack.ReportForExternal.report(java.lang.String, int, android.os.Bundle):void");
    }

    public static /* synthetic */ void report$default(ReportForExternal reportForExternal, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bundle = null;
        }
        reportForExternal.report(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report$lambda$3(List dataCaches) {
        Intrinsics.h(dataCaches, "$dataCaches");
        Iterator it = dataCaches.iterator();
        while (it.hasNext()) {
            AthenaDataBean athenaDataBean = (AthenaDataBean) it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("report -> cache, post, athenaAppId = ");
            sb2.append(athenaDataBean.getAthenaAppId());
            sb2.append(", tag = ");
            sb2.append(athenaDataBean.getEvent());
            INSTANCE.athenaReport(athenaDataBean.getEvent(), athenaDataBean.getAthenaAppId(), athenaDataBean.getData());
        }
    }

    public final void report(String tag, Bundle bundle) {
        if (tag != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            INSTANCE.report(tag, 3755, bundle2);
        }
    }
}
