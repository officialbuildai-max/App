package com.cloud.tmc.worker;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEvent;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.proxy.renderprocess.IRenderProcessListener;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.worker.IWorker;
import com.cloud.tmc.kernel.worker.JSI;
import com.cloud.tmc.kernel.worker.SendToWorkerCallback;
import com.cloud.tmc.kernel.worker.WorkerCallback;
import com.cloud.tmc.kernel.worker.WorkerLifeCycle;
import com.cloud.tmc.worker.WorkerManager;
import com.cloud.tmc.worker.debug.DefaultWebViewClient;
import com.cloud.tmc.worker.debug.WebviewWorker;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.meituan.android.walle.ChannelReader;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 S2\u00020\u0001:\u0003STUB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001c\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\r\u0010 \u001a\u00020\nH\u0016¢\u0006\u0002\u0010!J\r\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010)\u001a\u00020\nH\u0016J\u000f\u0010*\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010!J\b\u0010+\u001a\u00020\nH\u0016J\u001c\u0010,\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010.\u001a\u00020\u001aH\u0002J\u001c\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0017J&\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u00010\u00042\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000405H\u0016J(\u00106\u001a\u00020\u001a2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040505H\u0016J\u0012\u00108\u001a\u00020\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u00109\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010\u001e2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J&\u00109\u001a\u00020\u001a2\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J:\u00109\u001a\u00020\u001a2&\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>\u0018\u0001`?2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J0\u0010@\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010A\u001a\u0004\u0018\u00010\u00042\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0017J\u0012\u0010C\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010D\u001a\u00020\u001a2\b\u0010E\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010F\u001a\u00020\u001a2\b\u0010G\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010H\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010I\u001a\u00020\u001aH\u0016J\u0012\u0010J\u001a\u00020\u001a2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020\u0014H\u0016J\b\u0010O\u001a\u00020\u001aH\u0016J\u0012\u0010P\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\r\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0002\u0010!J\b\u0010Q\u001a\u00020\u001aH\u0016J\b\u0010R\u001a\u00020\u0014H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/cloud/tmc/worker/WorkerManager;", "Lcom/cloud/tmc/kernel/worker/JSI;", "()V", "appId", "", "callbackMap", "", "Lcom/cloud/tmc/kernel/worker/SendToWorkerCallback;", "frameworkVersion", "fromWarmup", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/cloud/tmc/kernel/worker/JSI$WorkerReadyListener;", "mGetPackageFileStatus", "mainHandler", "Landroid/os/Handler;", "node", "Lcom/cloud/tmc/kernel/node/Node;", "pendingCreateWorkerFail", "warmupChannel", "", "warmupSuccess", EventConstants.ADDRESS_WORKER, "Lcom/cloud/tmc/kernel/worker/IWorker;", "workerId", "debugRefresh", "", PushConstants.PROVIDER_FIELD_DESTROY, "execJsCallback", "resultObj", "Lcom/google/gson/JsonObject;", "callbackId", "firstGetPackageFileStatus", "()Ljava/lang/Boolean;", "getFirstPackageFileSuccess", TmcConstants.EXTRA_APP_ID, "getFrameworkVersion", "getNode", "getWarmupChannel", "getWorkerHandler", "getWorkerId", "isDestroyed", "isRenderProcessGone", "isWorkerReady", "loadJS", "vUrl", "postCreateWorkerEvent", "postMessage", "message", "callBack", "registerObject", "key", "map", "", "registerObjects", "mapMap", "registerWorkerReadyListener", "sendJsonToWorker", "messageObject", "messageObjectStr", "messageObjectMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sendMessageToWorker", "messageId", "workerCallback", "setAppId", "setCommonresId", TmcConstants.KEY_MINI_COMMONRES_ID, "setFrameworkVersion", "version", "setNode", "setRenderReady", "setStartupParams", "params", "Landroid/os/Bundle;", "setWarmup", ChannelReader.CHANNEL_KEY, "setWarmupSuccess", "setWorkerId", EventConstants.EVENT_WORKER_ON_MSG_READY, FrameworkConstants.GLOBAL_DATA_KEY_WORKER_TYPE, "Companion", "MyWorkCall", "MyWorkLifeCycle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class WorkerManager implements JSI {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EVENT_RESEND_PAGE_ENTER = "resend_page_enter";
    private String appId;
    private Map<String, SendToWorkerCallback> callbackMap = new HashMap();
    private String frameworkVersion;
    private boolean fromWarmup;
    private JSI.WorkerReadyListener listener;
    private boolean mGetPackageFileStatus;
    private Handler mainHandler;
    private Node node;
    private boolean pendingCreateWorkerFail;
    private int warmupChannel;
    private boolean warmupSuccess;
    private IWorker worker;
    private String workerId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/cloud/tmc/worker/WorkerManager$Companion;", "", "()V", "EVENT_RESEND_PAGE_ENTER", "", "getEVENT_RESEND_PAGE_ENTER", "()Ljava/lang/String;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getEVENT_RESEND_PAGE_ENTER() {
            return WorkerManager.EVENT_RESEND_PAGE_ENTER;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/cloud/tmc/worker/WorkerManager$MyWorkCall;", "Lcom/cloud/tmc/kernel/worker/WorkerCallback;", "(Lcom/cloud/tmc/worker/WorkerManager;)V", "onCallBack", "", "resultObj", "Lcom/google/gson/JsonObject;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public final class MyWorkCall implements WorkerCallback {
        public MyWorkCall() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0040 A[Catch: Exception -> 0x0014, TRY_LEAVE, TryCatch #0 {Exception -> 0x0014, blocks: (B:15:0x0007, B:17:0x000f, B:4:0x0017, B:6:0x001f, B:8:0x0035, B:9:0x0038, B:12:0x0040), top: B:14:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x001f A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:15:0x0007, B:17:0x000f, B:4:0x0017, B:6:0x001f, B:8:0x0035, B:9:0x0038, B:12:0x0040), top: B:14:0x0007 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void onCallBack$lambda$0(com.google.gson.JsonObject r2, com.cloud.tmc.worker.WorkerManager r3) {
            /*
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.Intrinsics.h(r3, r0)
                if (r2 == 0) goto L16
                java.lang.String r0 = "abilityName"
                com.google.gson.JsonElement r0 = r2.get(r0)     // Catch: java.lang.Exception -> L14
                if (r0 == 0) goto L16
                java.lang.String r0 = r0.getAsString()     // Catch: java.lang.Exception -> L14
                goto L17
            L14:
                r2 = move-exception
                goto L4c
            L16:
                r0 = 0
            L17:
                java.lang.String r1 = "callback"
                boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r1)     // Catch: java.lang.Exception -> L14
                if (r0 == 0) goto L40
                java.lang.String r0 = "callbackId"
                com.google.gson.JsonElement r0 = r2.get(r0)     // Catch: java.lang.Exception -> L14
                java.lang.String r0 = r0.getAsString()     // Catch: java.lang.Exception -> L14
                java.util.Map r1 = com.cloud.tmc.worker.WorkerManager.access$getCallbackMap$p(r3)     // Catch: java.lang.Exception -> L14
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Exception -> L14
                com.cloud.tmc.kernel.worker.SendToWorkerCallback r1 = (com.cloud.tmc.kernel.worker.SendToWorkerCallback) r1     // Catch: java.lang.Exception -> L14
                if (r1 == 0) goto L38
                r1.onCallBack(r2)     // Catch: java.lang.Exception -> L14
            L38:
                java.util.Map r2 = com.cloud.tmc.worker.WorkerManager.access$getCallbackMap$p(r3)     // Catch: java.lang.Exception -> L14
                r2.remove(r0)     // Catch: java.lang.Exception -> L14
                goto L67
            L40:
                java.lang.Class<com.cloud.tmc.kernel.bridge.IMsgDispatcher> r0 = com.cloud.tmc.kernel.bridge.IMsgDispatcher.class
                java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)     // Catch: java.lang.Exception -> L14
                com.cloud.tmc.kernel.bridge.IMsgDispatcher r0 = (com.cloud.tmc.kernel.bridge.IMsgDispatcher) r0     // Catch: java.lang.Exception -> L14
                r0.handleMsgFromWorker(r3, r2)     // Catch: java.lang.Exception -> L14
                goto L67
            L4c:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = "Worker send message to Native/Render fail: "
                r3.append(r0)
                r3.append(r2)
                java.lang.String r2 = " ; "
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                java.lang.String r3 = "TmcWorker"
                com.cloud.tmc.kernel.log.TmcLogger.e(r3, r2)
            L67:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.worker.WorkerManager.MyWorkCall.onCallBack$lambda$0(com.google.gson.JsonObject, com.cloud.tmc.worker.WorkerManager):void");
        }

        @Override // com.cloud.tmc.kernel.worker.WorkerCallback
        public void onCallBack(final JsonObject resultObj) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(WorkerManager.this.appId, WorkerAnalyseType.SEND_TO_NATIVE, new Gson().toJson((JsonElement) resultObj));
            Handler handler = WorkerManager.this.mainHandler;
            final WorkerManager workerManager = WorkerManager.this;
            handler.post(new Runnable() { // from class: com.cloud.tmc.worker.b
                @Override // java.lang.Runnable
                public final void run() {
                    WorkerManager.MyWorkCall.onCallBack$lambda$0(JsonObject.this, workerManager);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/cloud/tmc/worker/WorkerManager$MyWorkLifeCycle;", "Lcom/cloud/tmc/kernel/worker/WorkerLifeCycle;", "(Lcom/cloud/tmc/worker/WorkerManager;)V", "onCreate", "", "onDestroy", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public final class MyWorkLifeCycle implements WorkerLifeCycle {
        public MyWorkLifeCycle() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCreate$lambda$0(WorkerManager this$0) {
            Intrinsics.h(this$0, "this$0");
            JSI.WorkerReadyListener workerReadyListener = this$0.listener;
            if (workerReadyListener != null) {
                workerReadyListener.onWorkerReady();
            }
        }

        @Override // com.cloud.tmc.kernel.worker.WorkerLifeCycle
        public void onCreate() {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(WorkerManager.this.appId, WorkerAnalyseType.CREATE_END, null);
            Handler handler = WorkerManager.this.mainHandler;
            final WorkerManager workerManager = WorkerManager.this;
            handler.post(new Runnable() { // from class: com.cloud.tmc.worker.c
                @Override // java.lang.Runnable
                public final void run() {
                    WorkerManager.MyWorkLifeCycle.onCreate$lambda$0(WorkerManager.this);
                }
            });
        }

        @Override // com.cloud.tmc.kernel.worker.WorkerLifeCycle
        public void onDestroy() {
            WorkerManager.this.listener = null;
        }
    }

    public WorkerManager() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.e(mainLooper);
        this.mainHandler = new Handler(mainLooper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execJsCallback$lambda$0(WorkerManager this$0, String str, JsonObject jsonObject) {
        Intrinsics.h(this$0, "this$0");
        try {
            SendToWorkerCallback sendToWorkerCallback = this$0.callbackMap.get(str);
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(jsonObject);
            }
            TypeIntrinsics.d(this$0.callbackMap).remove(str);
        } catch (Exception e11) {
            TmcLogger.e(TmcConstants.WORKER_TAG, "Worker send message to Native/Render fail: " + e11 + " ; ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postCreateWorkerEvent() {
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
        IEvent createEvent = iEventCenterFactory.createEvent(String.valueOf(this.workerId));
        IEventCenter eventCenterInstance = iEventCenterFactory.getEventCenterInstance(this.node);
        if (eventCenterInstance != null) {
            eventCenterInstance.postEvent("create_miniapp_worker_fail", createEvent);
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void debugRefresh() {
        Object obj = this.worker;
        if (obj == null || !(obj instanceof WebView)) {
            return;
        }
        ((WebView) obj).loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void destroy() {
        this.listener = null;
        this.callbackMap.clear();
        IWorker iWorker = this.worker;
        if (iWorker != null) {
            iWorker.destroy();
        }
        this.node = null;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void execJsCallback(final JsonObject resultObj, final String callbackId) {
        this.mainHandler.post(new Runnable() { // from class: com.cloud.tmc.worker.a
            @Override // java.lang.Runnable
            public final void run() {
                WorkerManager.execJsCallback$lambda$0(WorkerManager.this, callbackId, resultObj);
            }
        });
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public Boolean firstGetPackageFileStatus() {
        return Boolean.valueOf(this.mGetPackageFileStatus);
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public Boolean fromWarmup() {
        return Boolean.valueOf(this.fromWarmup);
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void getFirstPackageFileSuccess(String miniAppId) {
        this.mGetPackageFileStatus = true;
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
        IEvent createEvent = iEventCenterFactory.createEvent(miniAppId);
        IEventCenter eventCenterInstance = iEventCenterFactory.getEventCenterInstance(this.node);
        if (eventCenterInstance != null) {
            eventCenterInstance.postEvent(EVENT_RESEND_PAGE_ENTER, createEvent);
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public String getFrameworkVersion() {
        return this.frameworkVersion;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public Node getNode() {
        return this.node;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public int getWarmupChannel() {
        return this.warmupChannel;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    /* renamed from: getWorkerHandler, reason: from getter */
    public Handler getMainHandler() {
        return this.mainHandler;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public String getWorkerId() {
        return this.workerId;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public boolean isDestroyed() {
        IWorker iWorker = this.worker;
        Boolean isDestroy = iWorker != null ? iWorker.isDestroy() : null;
        if (isDestroy == null) {
            return true;
        }
        return isDestroy.booleanValue();
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public Boolean isRenderProcessGone() {
        IWorker iWorker = this.worker;
        IRenderProcessListener iRenderProcessListener = iWorker instanceof IRenderProcessListener ? (IRenderProcessListener) iWorker : null;
        if (iRenderProcessListener != null) {
            return iRenderProcessListener.isRenderProcessGone();
        }
        return null;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public boolean isWorkerReady() {
        IWorker iWorker = this.worker;
        Boolean isLoad = iWorker != null ? iWorker.isLoad() : null;
        if (isLoad == null) {
            return false;
        }
        return isLoad.booleanValue();
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void loadJS(String appId, String vUrl) {
        try {
            String filePath = ((IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class)).getFilePath(appId, vUrl);
            IWorker iWorker = this.worker;
            if (iWorker != null) {
                iWorker.loadJS(filePath);
            }
        } catch (Exception e11) {
            TmcLogger.w(TmcConstants.WORKER_TAG, "parse appLoadResult fail:" + e11);
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    @Deprecated
    public void postMessage(String message, SendToWorkerCallback callBack) {
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void registerObject(String key, Map<String, String> map) {
        Intrinsics.h(map, "map");
        IWorker iWorker = this.worker;
        if (iWorker != null) {
            iWorker.registerObject(key, map);
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void registerObjects(Map<String, ? extends Map<String, String>> mapMap) {
        Intrinsics.h(mapMap, "mapMap");
        IWorker iWorker = this.worker;
        if (iWorker != null) {
            iWorker.registerObjects(mapMap);
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void registerWorkerReadyListener(JSI.WorkerReadyListener listener) {
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.appId, WorkerAnalyseType.INIT, null);
        this.listener = listener;
        k.d(o0.a(y0.c()), null, null, new WorkerManager$registerWorkerReadyListener$1(this, null), 3, null);
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void sendJsonToWorker(JsonObject messageObject, SendToWorkerCallback callBack) {
        JsonElement jsonElement = messageObject != null ? messageObject.get("callbackId") : null;
        if (jsonElement != null && callBack != null) {
            this.callbackMap.put(String.valueOf(jsonElement), callBack);
        }
        IWorker iWorker = this.worker;
        if (iWorker != null) {
            iWorker.execute(messageObject);
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void sendJsonToWorker(String messageObjectStr, String callbackId, SendToWorkerCallback callBack) {
        IWorker iWorker = this.worker;
        if (iWorker != null) {
            iWorker.execute(messageObjectStr);
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void sendJsonToWorker(HashMap<String, Object> messageObjectMap, SendToWorkerCallback callBack) {
        Object obj = messageObjectMap != null ? messageObjectMap.get("callbackId") : null;
        if (obj != null && callBack != null) {
            this.callbackMap.put(String.valueOf(obj), callBack);
        }
        IWorker iWorker = this.worker;
        if (iWorker != null) {
            iWorker.execute(messageObjectMap);
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    @Deprecated
    public void sendMessageToWorker(String appId, String messageId, String message, SendToWorkerCallback workerCallback) {
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setCommonresId(String commonresId) {
        DefaultWebViewClient mWebViewClient;
        try {
            IWorker iWorker = this.worker;
            WebviewWorker webviewWorker = iWorker instanceof WebviewWorker ? (WebviewWorker) iWorker : null;
            if (webviewWorker == null || (mWebViewClient = webviewWorker.getMWebViewClient()) == null) {
                return;
            }
            if (commonresId == null) {
                commonresId = "";
            }
            mWebViewClient.setCommonresId(commonresId);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setFrameworkVersion(String version) {
        this.frameworkVersion = version;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setNode(Node node) {
        this.node = node;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setRenderReady() {
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setStartupParams(Bundle params) {
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setWarmup(int channel) {
        this.fromWarmup = true;
        this.warmupChannel = channel;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setWarmupSuccess() {
        this.warmupSuccess = true;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void setWorkerId(String workerId) {
        String str;
        if (this.worker == null && (str = this.workerId) != null && str != null && StringsKt.W(str, FrameworkConstants.TMP_WARMUP_WORKER_ID_PREFIX, false, 2, null) && this.pendingCreateWorkerFail) {
            this.pendingCreateWorkerFail = false;
            postCreateWorkerEvent();
        }
        this.workerId = workerId;
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public Boolean warmupSuccess() {
        return Boolean.valueOf(this.warmupSuccess);
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public void workerOnMessageReady() {
        IWorker iWorker = this.worker;
        if (iWorker == null || iWorker.type() != 3) {
            return;
        }
        IWorker iWorker2 = this.worker;
        WebviewWorker webviewWorker = iWorker2 instanceof WebviewWorker ? (WebviewWorker) iWorker2 : null;
        if (webviewWorker != null) {
            webviewWorker.registerWorkerMessageChannel();
        }
    }

    @Override // com.cloud.tmc.kernel.worker.JSI
    public int workerType() {
        IWorker iWorker = this.worker;
        if (iWorker != null) {
            return iWorker.type();
        }
        return 0;
    }
}
