package com.cloud.tmc.integration.performance.innerworker;

import android.content.Context;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.model.PrepareCallbackParam;
import com.cloud.tmc.integration.performance.WarmUpCallback;
import com.cloud.tmc.integration.point.WarmupPoint;
import com.cloud.tmc.integration.structure.WarmupNode;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.worker.JSI;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ*\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0012"}, d2 = {"Lcom/cloud/tmc/integration/performance/innerworker/InnerWorkerWarmupManager;", "", "()V", "preWarmup", "", "context", "Landroid/content/Context;", "warmupType", "", "warmup", EventConstants.ADDRESS_WORKER, "Lcom/cloud/tmc/kernel/worker/JSI;", "param", "Lcom/cloud/tmc/integration/model/PrepareCallbackParam;", "warmUpCallback", "Lcom/cloud/tmc/integration/performance/WarmUpCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/cloud/tmc/integration/performance/innerworker/InnerWorkerListener;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class InnerWorkerWarmupManager {
    public final void preWarmup(Context context, int warmupType) {
        Intrinsics.h(context, "context");
        ((WarmupPoint) ExtensionPoint.as(WarmupPoint.class).create()).start(context, warmupType);
    }

    public final void warmup(JSI worker, PrepareCallbackParam param, WarmUpCallback warmUpCallback, InnerWorkerListener listener) {
        Intrinsics.h(worker, "worker");
        Intrinsics.h(warmUpCallback, "warmUpCallback");
        worker.setFrameworkVersion(param != null ? param.getFrameworkVersion() : null);
        WarmupNode warmupNode = (WarmupNode) TmcProxy.get(WarmupNode.class);
        String workerId = worker.getWorkerId();
        Intrinsics.g(workerId, "worker.workerId");
        k.d(o0.a(y0.b()), null, null, new InnerWorkerWarmupManager$warmup$1(worker, warmupNode.getNode(workerId), listener, warmUpCallback, null), 3, null);
    }
}
