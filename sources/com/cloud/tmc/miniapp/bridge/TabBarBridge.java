package com.cloud.tmc.miniapp.bridge;

import com.cloud.tmc.integration.model.TabReSelectedStore;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.p001native.NativeTabView;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.security.Permission;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TabBarBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ BridgeCallback OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(BridgeCallback bridgeCallback) {
            super(1);
            this.OooO00o = bridgeCallback;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                BridgeCallback bridgeCallback = this.OooO00o;
                if (bridgeCallback != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "ok");
                    bridgeCallback.sendSuccessResponse(jsonObject);
                }
            } else {
                BridgeCallback bridgeCallback2 = this.OooO00o;
                if (bridgeCallback2 != null) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback2);
                }
            }
            return Unit.f67184a;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void hideTabBar(@BindingNode(App.class) App app, @BindingParam({"animation"}) boolean z10, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.hideTabBar(z10)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else {
            activePage.putStringValue(TmcConstants.KEY_IS_API_SHOW_TAB_BAR_ENABLED, "hideTabBar");
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "ok");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void hideTabBarRedDot(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i11, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.hideTabBarRedDot(i11)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void hideTabBarUnreadIcon(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i11, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
                return;
            }
            return;
        }
        try {
            if (activePage.hideTabBarUnreadIcon(i11)) {
                if (bridgeCallback != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "ok");
                    bridgeCallback.sendSuccessResponse(jsonObject);
                }
            } else if (bridgeCallback != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "set tab item failed,please check the config: T10003");
                bridgeCallback.sendFailResponse(jsonObject2);
            }
        } catch (Throwable th2) {
            TmcLogger.e("TabBarBridge", th2);
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "load tab bar fail, please check the config: T10005", bridgeCallback);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.UI)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void loadTabBar(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r10, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"tabBarConfig"}) java.lang.String r11, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r12) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.TabBarBridge.loadTabBar(com.cloud.tmc.integration.structure.App, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void offTabReselected(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
            }
        } else {
            if (!activePage.isTabPage()) {
                if (bridgeCallback != null) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
                    return;
                }
                return;
            }
            TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) app.getData(TabReSelectedStore.class, true);
            BridgeCallback remove = (tabReSelectedStore == null ? new WeakHashMap<>() : tabReSelectedStore.getPageCache()).remove(activePage.getPageId());
            if (remove != null) {
                remove.close();
            }
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
        TmcLogger.d("TabBarBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
        TmcLogger.d("TabBarBridge", "onInitialized");
    }

    @ActionFilter
    @ThreadType(ExecutorType.NORMAL)
    public final void onTabReselected(@BindingNode(App.class) App app, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
            }
            if (bridgeCallback != null) {
                bridgeCallback.close();
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
            if (bridgeCallback != null) {
                bridgeCallback.close();
                return;
            }
            return;
        }
        TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) app.getData(TabReSelectedStore.class, true);
        WeakHashMap<String, BridgeCallback> weakHashMap = tabReSelectedStore == null ? new WeakHashMap<>() : tabReSelectedStore.getPageCache();
        BridgeCallback remove = weakHashMap.remove(activePage.getPageId());
        if (remove != null) {
            remove.close();
        }
        weakHashMap.put(activePage.getPageId(), bridgeCallback);
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void removeTabBarBadge(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i11, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.removeTabBarBadge(i11)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void setTabBarBadge(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i11, @BindingParam({"text"}) String text, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(text, "text");
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0 || text.length() == 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.setTabBarBadge(i11, text)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void setTabBarItem(@BindingNode(App.class) App app, @BindingParam({"index"}) int i11, @BindingParam({"text"}) String str, @BindingParam({"iconPath"}) String str2, @BindingParam({"selectedIconPath"}) String str3, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.setTabBarItem(i11, str, str2, str3)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void setTabBarItems(@BindingNode(App.class) App app, @BindingParam({"tabs"}) JsonArray jsonArray, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || jsonArray == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.setTabBarItems(jsonArray)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void setTabBarStyle(@BindingNode(App.class) App app, @BindingParam({"color"}) String color, @BindingParam({"selectedColor"}) String selectedColor, @BindingParam({"backgroundColor"}) String backgroundColor, @BindingParam({"borderStyle"}) String borderStyle, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(color, "color");
        Intrinsics.h(selectedColor, "selectedColor");
        Intrinsics.h(backgroundColor, "backgroundColor");
        Intrinsics.h(borderStyle, "borderStyle");
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.setTabBarStyle(StringExtKt.takeIfNotEmpty(color), StringExtKt.takeIfNotEmpty(selectedColor), StringExtKt.takeIfNotEmpty(backgroundColor), StringExtKt.takeIfNotEmpty(borderStyle))) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showTabBar(@BindingNode(App.class) App app, @BindingParam({"animation"}) boolean z10, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.showTabBar(z10)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else {
            activePage.putStringValue(TmcConstants.KEY_IS_API_SHOW_TAB_BAR_ENABLED, "showTabBar");
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "ok");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showTabBarRedDot(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i11, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else if (!activePage.showTabBarRedDot(i11)) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,please check the config: T10003", bridgeCallback);
            }
        } else if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void showTabBarUnreadIcon(@BindingNode(App.class) App app, @BindingParam(intDefault = -1, value = {"index"}) int i11, @BindingParam({"iconPath"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "set tab item failed,it's not tab page: T10002", bridgeCallback);
            }
        } else {
            if (str == null || str.length() == 0) {
                if (bridgeCallback != null) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", NativeTabView.ERROR_MSG_T10001, bridgeCallback);
                    return;
                }
                return;
            }
            try {
                activePage.showTabBarUnreadIcon(i11, str, new OooO0O0(bridgeCallback));
            } catch (Throwable th2) {
                TmcLogger.e("TabBarBridge", th2);
                if (bridgeCallback != null) {
                    com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "load tab bar fail, please check the config: T10005", bridgeCallback);
                }
            }
        }
    }
}
