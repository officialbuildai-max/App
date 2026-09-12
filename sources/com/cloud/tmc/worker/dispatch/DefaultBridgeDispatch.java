package com.cloud.tmc.worker.dispatch;

import com.cloud.tmc.kernel.bridge.IMsgDispatcher;
import com.cloud.tmc.kernel.bridge.model.ProtocolData;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.debug.a;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.render.BuildConfig;
import com.cloud.tmc.worker.WorkerCallContext;
import com.google.gson.Gson;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0002¨\u0006\u000b"}, d2 = {"Lcom/cloud/tmc/worker/dispatch/DefaultBridgeDispatch;", "Lcom/cloud/tmc/worker/dispatch/IBridgeDispatch;", "()V", "invoke", "", "engineRouter", "Lcom/cloud/tmc/kernel/engine/EngineRouter;", "workerId", "", "renderId", "result", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class DefaultBridgeDispatch implements IBridgeDispatch {
    @Override // com.cloud.tmc.worker.dispatch.IBridgeDispatch
    public void invoke(EngineRouter engineRouter, String workerId, String renderId, String result) {
        Intrinsics.h(workerId, "workerId");
        Intrinsics.h(renderId, "renderId");
        Intrinsics.h(result, "result");
        try {
            if (StringsKt.W(result, "__TmcRenderToWorkerMsg:", false, 2, null)) {
                String Q = StringsKt.Q(result, "__TmcRenderToWorkerMsg:", "", false, 4, null);
                TraceLog.i(OfflineConstantsKt.OFFLINE_TYPE_MINIAPP, "renderSendToNative = " + Q);
                String abilityName = ((ProtocolData) new Gson().fromJson(Q, ProtocolData.class)).getAbilityName();
                if (abilityName != null) {
                    switch (abilityName.hashCode()) {
                        case -1341969888:
                            if (!abilityName.equals("DispatchEvent")) {
                                break;
                            } else {
                                TraceLog.i(TmcConstants.RENDER_TAG, "DispatchEvent");
                                ((IMsgDispatcher) TmcProxy.get(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, Q);
                                break;
                            }
                        case -1190321207:
                            if (!abilityName.equals(NativeComponentConstants.NATIVE_DISPATCH_EVENT)) {
                                break;
                            }
                            TraceLog.i(TmcConstants.RENDER_TAG, NativeComponentConstants.NATIVE_DISPATCH_COMPONENT);
                            ((IMsgDispatcher) TmcProxy.get(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, Q);
                            break;
                        case 66042:
                            if (!abilityName.equals(WorkerCallContext.ABILITY_API)) {
                                break;
                            } else {
                                TraceLog.i(TmcConstants.RENDER_TAG, WorkerCallContext.ABILITY_API);
                                ((IMsgDispatcher) TmcProxy.get(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, Q);
                                break;
                            }
                        case 229351084:
                            if (!abilityName.equals(NativeComponentConstants.NATIVE_DISPATCH_COMPONENT)) {
                                break;
                            }
                            TraceLog.i(TmcConstants.RENDER_TAG, NativeComponentConstants.NATIVE_DISPATCH_COMPONENT);
                            ((IMsgDispatcher) TmcProxy.get(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, Q);
                            break;
                        case 1672091434:
                            if (!abilityName.equals(WorkerCallContext.ABILITY_LIFECYCLE)) {
                                break;
                            } else {
                                TraceLog.i(TmcConstants.RENDER_TAG, WorkerCallContext.ABILITY_LIFECYCLE);
                                ((IMsgDispatcher) TmcProxy.get(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, Q);
                                break;
                            }
                        case 1988583688:
                            if (!abilityName.equals("debugRefresh")) {
                                break;
                            } else {
                                a.b();
                                break;
                            }
                    }
                }
            }
        } catch (Exception e11) {
            TraceLog.e(TmcConstants.RENDER_TAG, "DefaultBridgeDispatch e = " + e11);
        }
    }
}
