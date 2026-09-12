package com.cloud.tmc.integration.bridge;

import com.cloud.tmc.integration.proxy.IRefreshProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.app.TmcAppContext;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.security.Permission;

/* loaded from: classes3.dex */
public class PullRefreshBridge implements BridgeExtension {
    private static final String TAG = "PullRefreshBridge";

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void enableLoadMore(@BindingNode(App.class) App app, @BindingParam(name = {"enable"}) Boolean bool, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        TmcFragment findFragmentForPage = ((TmcAppContext) app.getAppContext()).getFragmentManager().findFragmentForPage(app.getActivePage());
        if (findFragmentForPage == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            ((IRefreshProxy) TmcProxy.get(IRefreshProxy.class)).enableLoadMore(findFragmentForPage, bool.booleanValue());
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void enableRefresh(@BindingNode(App.class) App app, @BindingParam(name = {"enable"}) Boolean bool, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        TmcFragment findFragmentForPage = ((TmcAppContext) app.getAppContext()).getFragmentManager().findFragmentForPage(app.getActivePage());
        if (findFragmentForPage == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            ((IRefreshProxy) TmcProxy.get(IRefreshProxy.class)).enableRefresh(findFragmentForPage, bool.booleanValue());
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
        TmcLogger.d(TAG, "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
        TmcLogger.d(TAG, "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void startPullDownRefresh(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        TmcFragment findFragmentForPage = ((TmcAppContext) app.getAppContext()).getFragmentManager().findFragmentForPage(app.getActivePage());
        if (findFragmentForPage == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        boolean startPullDownRefresh = ((IRefreshProxy) TmcProxy.get(IRefreshProxy.class)).startPullDownRefresh(findFragmentForPage);
        if (bridgeCallback != null) {
            if (startPullDownRefresh) {
                bridgeCallback.sendSuccessResponse();
            } else {
                bridgeCallback.sendFailResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void stopPullDownRefresh(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        TmcFragment findFragmentForPage = ((TmcAppContext) app.getAppContext()).getFragmentManager().findFragmentForPage(app.getActivePage());
        if (findFragmentForPage == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        boolean stopPullDownRefresh = ((IRefreshProxy) TmcProxy.get(IRefreshProxy.class)).stopPullDownRefresh(findFragmentForPage);
        if (bridgeCallback != null) {
            if (stopPullDownRefresh) {
                bridgeCallback.sendSuccessResponse();
            } else {
                bridgeCallback.sendFailResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void stopPullUpRefresh(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        TmcFragment findFragmentForPage = ((TmcAppContext) app.getAppContext()).getFragmentManager().findFragmentForPage(app.getActivePage());
        if (findFragmentForPage == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        boolean stopPullUpRefresh = ((IRefreshProxy) TmcProxy.get(IRefreshProxy.class)).stopPullUpRefresh(findFragmentForPage);
        if (bridgeCallback != null) {
            if (stopPullUpRefresh) {
                bridgeCallback.sendSuccessResponse();
            } else {
                bridgeCallback.sendFailResponse();
            }
        }
    }
}
