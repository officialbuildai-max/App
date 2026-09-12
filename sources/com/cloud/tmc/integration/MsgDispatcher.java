package com.cloud.tmc.integration;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.chain.endState.DrawViewEndState;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.WarmupNode;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.integration.utils.PrivacyUtils;
import com.cloud.tmc.integration.utils.TrackPointUtils;
import com.cloud.tmc.kernel.bridge.IMsgDispatcher;
import com.cloud.tmc.kernel.bridge.NativeBridge;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.bridge.SendToNativeCallback;
import com.cloud.tmc.kernel.bridge.model.ProtocolData;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.coreimpl.eventcenter.DefaultEvent;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEvent;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.kernel.worker.JSI;
import com.cloud.tmc.kernel.worker.SendToWorkerCallback;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.worker.WorkerCallContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class MsgDispatcher implements IMsgDispatcher {
    private static final String TAG = "MsgDispatcher";

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkShowPermissionDialog(final App app, String str) {
        String interectCallbackId = app.getInterectCallbackId();
        if (interectCallbackId == null || !interectCallbackId.equals(str)) {
            return;
        }
        app.updateInterectCallbackId(null);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.integration.c
            @Override // java.lang.Runnable
            public final void run() {
                MsgDispatcher.lambda$checkShowPermissionDialog$0(App.this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void consumeTime(T t11, IRender iRender) {
        try {
            App app = (App) iRender.getPage().bubbleFindNode(App.class);
            ProtocolData.ConsumeTimeDataJson parse = ProtocolData.ConsumeTimeDataJson.parse((LinkedTreeMap) t11);
            IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
            IEvent createEvent = iEventCenterFactory.createEvent(((Page) iRender.getPage()).getPageId() + "");
            HashMap hashMap = new HashMap();
            hashMap.put(IntegrationConstants.EVENT_DATA, parse.getDataJson().get(EventConstants.KEY_TIME));
            createEvent.setData(hashMap);
            IEventCenter eventCenterInstance = iEventCenterFactory.getEventCenterInstance(app);
            if (eventCenterInstance != null) {
                eventCenterInstance.postEvent(EventConstants.EVENT_CONSUME_TIME, createEvent);
            }
        } catch (Exception unused) {
            TraceLog.i(OfflineConstantsKt.OFFLINE_TYPE_MINIAPP, "parse consumeTime from dataJson fail");
        }
    }

    @NonNull
    private String getActiveRenderId(@NonNull EngineRouter engineRouter) {
        App app;
        Page activePage;
        IRender topRender = engineRouter.getTopRender();
        return (topRender == null || (app = (App) topRender.getPage().bubbleFindNode(App.class)) == null || (activePage = app.getActivePage()) == null || activePage.getRender() == null) ? "" : activePage.getRender().getRenderId();
    }

    private boolean handleAsyncMsgFromWorker(final JSI jsi, JsonObject jsonObject) {
        ProtocolData protocolData;
        String appId;
        NativeBridge bridge;
        TmcLogger.d(TAG, "handleJSMsgFroworker msg = " + jsonObject);
        if (jsi == null) {
            TmcLogger.e("handleAsyncMsgFromWorker error !!! (worker is null)");
            return false;
        }
        EngineRouter byWorkerId = ((EngineRouterManager) TmcProxy.get(EngineRouterManager.class)).getByWorkerId(jsi.getWorkerId());
        if (byWorkerId == null) {
            TmcLogger.e("handleAsyncMsgFromWorker error !!! (engineRouter is null)");
            return false;
        }
        ProtocolData protocolData2 = (ProtocolData) JsonUtil.INSTANCE.fromJson(jsonObject.toString(), ProtocolData.class);
        if (jsi.getWorkerId() != null && jsi.getWorkerId().startsWith(FrameworkConstants.TMP_WARMUP_WORKER_ID_PREFIX) && "DispatchEvent".equals(protocolData2.getAbilityName()) && "native".equals(protocolData2.getTarget())) {
            TmcLogger.e(TAG, "handleAsyncMsgFromWorker 预热模式");
            ProtocolData.DispatchEventDataJson parse = ProtocolData.DispatchEventDataJson.parse((LinkedTreeMap) protocolData2.getDataJson());
            String eventName = parse.getEventName();
            IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
            IEvent createEvent = iEventCenterFactory.createEvent(eventName);
            HashMap hashMap = new HashMap();
            hashMap.put(IntegrationConstants.EVENT_DATA, parse.getDataJson());
            createEvent.setData(hashMap);
            Node node = ((WarmupNode) TmcProxy.get(WarmupNode.class)).getNode(jsi.getWorkerId());
            if (node == null) {
                return false;
            }
            IEventCenter eventCenterInstance = iEventCenterFactory.getEventCenterInstance(node);
            if (eventCenterInstance != null) {
                eventCenterInstance.postEvent(eventName, createEvent);
            }
            return true;
        }
        IRender renderById = byWorkerId.getRenderById(!TextUtils.isEmpty(protocolData2.getRenderId()) ? protocolData2.getRenderId() : getActiveRenderId(byWorkerId));
        if (renderById == null) {
            TmcLogger.d(TAG, "handleMsgFromJs: 找不到 render，使用 worker 兜底分发");
            App app = jsi.getNode() instanceof App ? (App) jsi.getNode() : null;
            if (app == null) {
                TmcLogger.d(TAG, "handleMsgFromJs: render is null, app is null, jsapi 无法调用");
                return false;
            }
            if (!WorkerCallContext.ABILITY_API.equals(protocolData2.getAbilityName())) {
                return false;
            }
            ProtocolData.ApiDataJson parse2 = ProtocolData.ApiDataJson.parse((LinkedTreeMap) protocolData2.getDataJson());
            final String methodName = parse2.getMethodName();
            String args = parse2.getArgs();
            JsonObject asJsonObject = !TextUtils.isEmpty(args) ? JsonParser.parseString(args).getAsJsonObject() : null;
            final String callbackId = protocolData2.getCallbackId();
            NativeCallContext build = new NativeCallContext.Builder().name(methodName).params(asJsonObject).node(app).callbackId(callbackId).id("" + System.currentTimeMillis()).build();
            IEngine engineProxy = app.getEngineProxy();
            if (engineProxy == null || (bridge = engineProxy.getBridge()) == null) {
                return false;
            }
            final App app2 = app;
            bridge.sendToNative(build, new SendToNativeCallback() { // from class: com.cloud.tmc.integration.MsgDispatcher.5
                @Override // com.cloud.tmc.kernel.bridge.SendToNativeCallback
                public void onCallback(JsonObject jsonObject2, boolean z10, boolean z11) {
                    TmcLogger.d(MsgDispatcher.TAG, "handleMsgFromJs: " + methodName + ", return " + jsonObject2);
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    JsonObject jsonObject3 = new JsonObject();
                    hashMap2.put("abilityName", "callback");
                    jsonObject3.addProperty("abilityName", "callback");
                    JsonObject jsonObject4 = new JsonObject();
                    HashMap hashMap3 = new HashMap();
                    if (z10) {
                        hashMap2.put(EventConstants.KEY_ACTION, "keepalive_active");
                        jsonObject3.addProperty(EventConstants.KEY_ACTION, "keepalive_active");
                    } else if (z11) {
                        hashMap2.put(EventConstants.KEY_ACTION, "keepalive_close");
                        jsonObject3.addProperty(EventConstants.KEY_ACTION, "keepalive_close");
                    }
                    hashMap2.put("callbackId", callbackId);
                    jsonObject3.addProperty("callbackId", callbackId);
                    hashMap2.put("dataJson", hashMap3);
                    jsonObject3.add("dataJson", jsonObject4);
                    hashMap3.put("dataJson", String.valueOf(jsonObject2));
                    jsonObject4.addProperty("dataJson", String.valueOf(jsonObject2));
                    hashMap3.put("callbackId", callbackId);
                    jsonObject4.addProperty("callbackId", callbackId);
                    if (jsi.workerType() == 1) {
                        jsi.sendJsonToWorker(hashMap2, (SendToWorkerCallback) null);
                    } else if (jsi.workerType() == 3) {
                        jsi.sendJsonToWorker(jsonObject3, (SendToWorkerCallback) null);
                    }
                    MsgDispatcher.checkShowPermissionDialog(app2, callbackId);
                }

                @Override // com.cloud.tmc.kernel.bridge.SendToNativeCallback
                public void onCallback(HashMap<String, Object> hashMap2, boolean z10, boolean z11) {
                    TmcLogger.d(MsgDispatcher.TAG, "handleMsgFromJs: " + methodName + ", return " + hashMap2);
                    HashMap<String, Object> hashMap3 = new HashMap<>();
                    JsonObject jsonObject2 = new JsonObject();
                    hashMap3.put("abilityName", "callback");
                    jsonObject2.addProperty("abilityName", "callback");
                    JsonObject jsonObject3 = new JsonObject();
                    HashMap hashMap4 = new HashMap();
                    if (z10) {
                        hashMap3.put(EventConstants.KEY_ACTION, "keepalive_active");
                        jsonObject2.addProperty(EventConstants.KEY_ACTION, "keepalive_active");
                    } else if (z11) {
                        hashMap3.put(EventConstants.KEY_ACTION, "keepalive_close");
                        jsonObject2.addProperty(EventConstants.KEY_ACTION, "keepalive_close");
                    }
                    hashMap3.put("callbackId", callbackId);
                    jsonObject2.addProperty("callbackId", callbackId);
                    hashMap3.put("dataJson", hashMap4);
                    jsonObject2.add("dataJson", jsonObject3);
                    hashMap4.put("dataJson", hashMap2);
                    jsonObject3.addProperty("dataJson", String.valueOf(hashMap2));
                    hashMap4.put("callbackId", callbackId);
                    jsonObject3.addProperty("callbackId", callbackId);
                    if (jsi.workerType() == 1) {
                        jsi.sendJsonToWorker(hashMap3, (SendToWorkerCallback) null);
                    } else if (jsi.workerType() == 3) {
                        jsi.sendJsonToWorker(jsonObject2, (SendToWorkerCallback) null);
                    }
                    MsgDispatcher.checkShowPermissionDialog(app2, callbackId);
                }
            });
            return true;
        }
        final App app3 = (App) renderById.getPage().bubbleFindNode(App.class);
        consumeTime(protocolData2.getDataJson(), renderById);
        if (WorkerCallContext.ABILITY_API.equals(protocolData2.getAbilityName())) {
            ProtocolData.ApiDataJson parse3 = ProtocolData.ApiDataJson.parse((LinkedTreeMap) protocolData2.getDataJson());
            final String methodName2 = parse3.getMethodName();
            String args2 = parse3.getArgs();
            JsonObject asJsonObject2 = !TextUtils.isEmpty(args2) ? JsonParser.parseString(args2).getAsJsonObject() : null;
            final String callbackId2 = protocolData2.getCallbackId();
            renderById.getEngineProxy().getBridge().sendToNative(new NativeCallContext.Builder().name(methodName2).params(asJsonObject2).node(renderById.getPage()).render(renderById).callbackId(callbackId2).id("" + System.currentTimeMillis()).build(), new SendToNativeCallback() { // from class: com.cloud.tmc.integration.MsgDispatcher.6
                @Override // com.cloud.tmc.kernel.bridge.SendToNativeCallback
                public void onCallback(JsonObject jsonObject2, boolean z10, boolean z11) {
                    TmcLogger.d(MsgDispatcher.TAG, "handleMsgFromJs: " + methodName2 + ", return " + jsonObject2);
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    JsonObject jsonObject3 = new JsonObject();
                    hashMap2.put("abilityName", "callback");
                    jsonObject3.addProperty("abilityName", "callback");
                    JsonObject jsonObject4 = new JsonObject();
                    HashMap hashMap3 = new HashMap();
                    if (z10) {
                        hashMap2.put(EventConstants.KEY_ACTION, "keepalive_active");
                        jsonObject3.addProperty(EventConstants.KEY_ACTION, "keepalive_active");
                    } else if (z11) {
                        hashMap2.put(EventConstants.KEY_ACTION, "keepalive_close");
                        jsonObject3.addProperty(EventConstants.KEY_ACTION, "keepalive_close");
                    }
                    hashMap2.put("callbackId", callbackId2);
                    jsonObject3.addProperty("callbackId", callbackId2);
                    hashMap2.put("dataJson", hashMap3);
                    jsonObject3.add("dataJson", jsonObject4);
                    hashMap3.put("dataJson", String.valueOf(jsonObject2));
                    jsonObject4.addProperty("dataJson", String.valueOf(jsonObject2));
                    hashMap3.put("callbackId", callbackId2);
                    jsonObject4.addProperty("callbackId", callbackId2);
                    if (jsi.workerType() == 1) {
                        jsi.sendJsonToWorker(hashMap2, (SendToWorkerCallback) null);
                    } else if (jsi.workerType() == 3) {
                        jsi.sendJsonToWorker(jsonObject3, (SendToWorkerCallback) null);
                    }
                    MsgDispatcher.checkShowPermissionDialog(app3, callbackId2);
                }

                @Override // com.cloud.tmc.kernel.bridge.SendToNativeCallback
                public void onCallback(HashMap<String, Object> hashMap2, boolean z10, boolean z11) {
                    TmcLogger.d(MsgDispatcher.TAG, "handleMsgFromJs: " + methodName2 + ", return " + hashMap2);
                    HashMap<String, Object> hashMap3 = new HashMap<>();
                    JsonObject jsonObject2 = new JsonObject();
                    hashMap3.put("abilityName", "callback");
                    jsonObject2.addProperty("abilityName", "callback");
                    JsonObject jsonObject3 = new JsonObject();
                    HashMap hashMap4 = new HashMap();
                    if (z10) {
                        hashMap3.put(EventConstants.KEY_ACTION, "keepalive_active");
                        jsonObject2.addProperty(EventConstants.KEY_ACTION, "keepalive_active");
                    } else if (z11) {
                        hashMap3.put(EventConstants.KEY_ACTION, "keepalive_close");
                        jsonObject2.addProperty(EventConstants.KEY_ACTION, "keepalive_close");
                    }
                    hashMap3.put("callbackId", callbackId2);
                    jsonObject2.addProperty("callbackId", callbackId2);
                    hashMap3.put("dataJson", hashMap4);
                    jsonObject2.add("dataJson", jsonObject3);
                    hashMap4.put("dataJson", hashMap2);
                    jsonObject3.addProperty("dataJson", String.valueOf(hashMap2));
                    hashMap4.put("callbackId", callbackId2);
                    jsonObject3.addProperty("callbackId", callbackId2);
                    if (jsi.workerType() == 1) {
                        jsi.sendJsonToWorker(hashMap3, (SendToWorkerCallback) null);
                    } else if (jsi.workerType() == 3) {
                        jsi.sendJsonToWorker(jsonObject2, (SendToWorkerCallback) null);
                    }
                    MsgDispatcher.checkShowPermissionDialog(app3, callbackId2);
                }
            });
            return true;
        }
        if ("DispatchEvent".equals(protocolData2.getAbilityName()) && "native".equals(protocolData2.getTarget())) {
            ProtocolData.DispatchEventDataJson parse4 = ProtocolData.DispatchEventDataJson.parse((LinkedTreeMap) protocolData2.getDataJson());
            String eventName2 = parse4.getEventName();
            IEventCenterFactory iEventCenterFactory2 = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
            IEvent createEvent2 = iEventCenterFactory2.createEvent(eventName2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(IntegrationConstants.EVENT_DATA, parse4.getDataJson());
            createEvent2.setData(hashMap2);
            Node node2 = app3;
            if (jsi.getNode() instanceof AppManager) {
                node2 = jsi.getNode();
            }
            IEventCenter eventCenterInstance2 = iEventCenterFactory2.getEventCenterInstance(node2);
            if (eventCenterInstance2 != null) {
                eventCenterInstance2.postEvent(eventName2, createEvent2);
            }
        } else if (EventConstants.ADDRESS_RENDER.equals(protocolData2.getTarget())) {
            if (EventConstants.EVENT_NAME_ON_PAGE_READY.equals(ProtocolData.DispatchEventDataJson.parse((LinkedTreeMap) protocolData2.getDataJson()).getEventName())) {
                ((IScreenInspectProxy) TmcProxy.get(IScreenInspectProxy.class)).checkNow(app3, ((Page) renderById.getPage()).getPagePath());
                if (app3 != null) {
                    app3.setMiniAppLoadStatus(true);
                    if (app3.getAppContext() != null && app3.getAppContext().getContext() != null) {
                        PrivacyUtils.INSTANCE.updateNewUserStatus(app3.getAppContext().getContext(), app3.getAppId());
                    }
                }
                IEventCenter eventCenterInstance3 = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance((Page) renderById.getPage());
                if (eventCenterInstance3 != null) {
                    eventCenterInstance3.postEvent(EventConstants.EVENT_NAME_ON_PAGE_READY, new DefaultEvent(EventConstants.EVENT_NAME_ON_PAGE_READY));
                }
                Bundle bundle = new Bundle();
                bundle.putString("workerFromWarmup", jsi.fromWarmup() + "");
                bundle.putString("workerFromWarmupChannel", jsi.getWarmupChannel() + "");
                bundle.putString("renderFromWarmup", renderById.getFromWarmup() + "");
                bundle.putString("renderFromWarmupChannel", renderById.getWarmupChannel() + "");
                bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, ((Page) renderById.getPage()).getPageRandomIdByGAId());
                Bundle bundle2 = new Bundle();
                bundle2.putString(ChainPoint.TYPE, "page");
                bundle2.putString(ChainPoint.CHAIN_ID, ((Page) renderById.getPage()).getApp().getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                bundle2.putString(ChainPoint.PAGE_PATH, ((Page) renderById.getPage()).getPagePath());
                bundle2.putAll(bundle);
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                if (app3 == null) {
                    protocolData = protocolData2;
                    appId = null;
                } else {
                    appId = app3.getAppId();
                    protocolData = protocolData2;
                }
                performanceAnalyseProxy.record(appId, PointAnalyseType.POINT_RENDER_T1, "页面打开", bundle);
                PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                String appId2 = app3 == null ? null : app3.getAppId();
                PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_END;
                performanceAnalyseProxy2.record(appId2, pointAnalyseType, ChainPoint.DrawView, bundle2);
                ((IUpdateLoadingStepProxy) TmcProxy.get(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(((Page) renderById.getPage()).getApp().getAppId(), LoadStepAction.STEP_FINISH_MINIAPP_LOAD);
                TrackPointUtils.pageRouteTrackEnd((Page) renderById.getPage());
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app3 == null ? null : app3.getAppId(), pointAnalyseType, ChainPoint.page, bundle2);
                Bundle bundle3 = new Bundle();
                bundle3.putString(ChainPoint.TYPE, "app");
                bundle3.putString(ChainPoint.CHAIN_ID, ((Page) renderById.getPage()).getApp().getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                bundle3.putString(ChainPoint.PAGE_PATH, ((Page) renderById.getPage()).getPagePath());
                bundle3.putAll(bundle);
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app3 == null ? null : app3.getAppId(), pointAnalyseType, ChainPoint.app, bundle3);
                Bundle bundle4 = new Bundle();
                bundle4.putString("workerFromWarmup", jsi.fromWarmup() + "");
                bundle4.putString("workerFromWarmupChannel", jsi.getWarmupChannel() + "");
                bundle4.putString("renderFromWarmup", renderById.getFromWarmup() + "");
                bundle4.putString("renderFromWarmupChannel", renderById.getWarmupChannel() + "");
                bundle4.putString(ChainPoint.PAGE_PATH, ((Page) renderById.getPage()).getPagePath());
                bundle4.putString(ChainPoint.PAGE_ID, ((Page) renderById.getPage()).getPageId());
                bundle4.putString(ChainPoint.CHAIN_DRAW_END_TYPE, "1");
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app3 == null ? null : app3.getAppId(), PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageDrawView, bundle4);
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app3 == null ? null : app3.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageDrawView, bundle4);
                if (renderById.getPage() != null && (renderById.getPage() instanceof Page)) {
                    bundle4.putString(TmcConstants.KEY_PAGE_RANDOM_ID, ((Page) renderById.getPage()).getPageRandomIdByGAId());
                    bundle4.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + ((Page) renderById.getPage()).getPageId());
                    new DrawViewEndState(bundle4).setChainContext(((Page) renderById.getPage()).getPageChainContext());
                }
            } else {
                protocolData = protocolData2;
            }
            if (TextUtils.isEmpty(protocolData.getRenderId())) {
                return false;
            }
            RenderCallContext.Builder param = RenderCallContext.newBuilder(renderById).action("message").type("call").param(jsonObject);
            if (renderById.getRenderBridge() != null) {
                renderById.getRenderBridge().sendToRender(param.build(), null);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkShowPermissionDialog$0(App app) {
        ((PermissionDialogPoint) ExtensionPoint.as(PermissionDialogPoint.class).create()).privacyDialogDismiss(app.getAppId(), app.getStartToken());
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x026a A[Catch: all -> 0x0159, TryCatch #0 {all -> 0x0159, blocks: (B:29:0x012e, B:32:0x013c, B:35:0x0152, B:38:0x0173, B:40:0x0179, B:42:0x017f, B:44:0x0187, B:45:0x0264, B:47:0x026a, B:49:0x029a, B:51:0x02a0, B:53:0x02a8, B:55:0x02b4, B:57:0x02d0, B:59:0x015c, B:61:0x0170), top: B:28:0x012e }] */
    @Override // com.cloud.tmc.kernel.bridge.IMsgDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleMsgFromRender(com.cloud.tmc.kernel.engine.EngineRouter r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.MsgDispatcher.handleMsgFromRender(com.cloud.tmc.kernel.engine.EngineRouter, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    @Override // com.cloud.tmc.kernel.bridge.IMsgDispatcher
    public boolean handleMsgFromWorker(JSI jsi, JsonObject jsonObject) {
        TmcLogger.d(TAG, "handleMsgFroworker msg = " + jsonObject);
        if (jsonObject == null) {
            return false;
        }
        return handleAsyncMsgFromWorker(jsi, jsonObject);
    }
}
