package com.cloud.tmc.integration.utils;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J&\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0007J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/cloud/tmc/integration/utils/MiniAppConfigUtils;", "", "()V", "forceCapsuleViewBgColor", "", "forceTabBarBean", "Lcom/cloud/tmc/integration/model/MiniAppConfigModel$TabBarBean;", "getDefaultTabBarConfig", "getDefaultWindowConfig", "Lcom/cloud/tmc/integration/model/MiniAppConfigModel$WindowBean;", "getTabBar", "tabBar", TmcConstants.EXTRA_APP_LOAD_RESULT, "Lcom/cloud/tmc/integration/structure/AppLoadResult;", "force", "", "getTitleBarNodeMode", "", "()Ljava/lang/Integer;", "getWindowConfig", "appWindowConfig", "pageWindowConfig", "customPageWindowConfig", "getWindowOptimalConfiguration", FrameworkConstants.GLOBAL_DATA_KEY_PAGE_PATH, "navigationBarAction", EventConstants.KEY_ACTION, "setCapsuleViewBgColor", "", TtmlNode.ATTR_TTS_COLOR, "setupTabBarConfig", "default", "target", "setupWindowConfig", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MiniAppConfigUtils {
    public static final MiniAppConfigUtils INSTANCE = new MiniAppConfigUtils();
    private static String forceCapsuleViewBgColor = "";
    private static MiniAppConfigModel.TabBarBean forceTabBarBean;

    private MiniAppConfigUtils() {
    }

    private final MiniAppConfigModel.TabBarBean getDefaultTabBarConfig() {
        MiniAppConfigModel.TabBarBean tabBarBean = new MiniAppConfigModel.TabBarBean();
        tabBarBean.setBorderStyle("black");
        tabBarBean.setPosition(IntegrationConstants.TAB_BAR_POSITION_DEFAULT);
        tabBarBean.setCustom(Boolean.FALSE);
        return tabBarBean;
    }

    private final MiniAppConfigModel.WindowBean getDefaultWindowConfig() {
        MiniAppConfigModel.WindowBean windowBean = new MiniAppConfigModel.WindowBean();
        Boolean bool = Boolean.FALSE;
        windowBean.setEnablePullDownRefresh(bool);
        windowBean.setEnablePullUpRefresh(bool);
        windowBean.setRefreshHeaderStyle("default");
        Boolean bool2 = Boolean.TRUE;
        windowBean.setRefreshHeaderCustomTextEnable(bool2);
        windowBean.setRefreshHeaderTranslationContent(bool2);
        windowBean.setEnableTransparentStatusBar(bool);
        windowBean.setEnableNavigationBarLoading(bool2);
        windowBean.setNavigationStyle("default");
        windowBean.setNavigationBarBackgroundColor(IntegrationConstants.NAVIGATION_BAR_BACKGROUND_COLOR_DEFAULT);
        windowBean.setNavigationBarTextStyle("black");
        windowBean.setNavigationBarIconStyle("black");
        windowBean.setNavigationBarHomeAction(IntegrationConstants.NAVIGATION_BAR_HOME_ACTION_DEFAULT);
        windowBean.setHandleWebviewPreload("manual");
        windowBean.setEnablePageLoading(bool);
        windowBean.setEnableTabBarAdjustPan(bool);
        windowBean.setLimitTextZoom(bool);
        return windowBean;
    }

    @JvmStatic
    public static final MiniAppConfigModel.TabBarBean getTabBar(MiniAppConfigModel.TabBarBean tabBar, AppLoadResult appLoadResult, boolean force) {
        MiniAppConfigModel.TabBarBean tabBarBean;
        if (!force && (tabBarBean = forceTabBarBean) != null) {
            Intrinsics.e(tabBarBean);
            return tabBarBean;
        }
        MiniAppConfigUtils miniAppConfigUtils = INSTANCE;
        MiniAppConfigModel.TabBarBean defaultTabBarConfig = miniAppConfigUtils.getDefaultTabBarConfig();
        if (!force && tabBar != null) {
            miniAppConfigUtils.setupTabBarConfig(defaultTabBarConfig, tabBar);
        }
        MiniAppConfigModel.TabBarBean queryMiniappCustomTabBar = AppUtils.INSTANCE.queryMiniappCustomTabBar(appLoadResult);
        if (queryMiniappCustomTabBar != null) {
            miniAppConfigUtils.setupTabBarConfig(defaultTabBarConfig, queryMiniappCustomTabBar);
        }
        if (force && tabBar != null) {
            miniAppConfigUtils.setupTabBarConfig(defaultTabBarConfig, tabBar);
            forceTabBarBean = defaultTabBarConfig;
        }
        return defaultTabBarConfig;
    }

    @JvmStatic
    public static final MiniAppConfigModel.TabBarBean getTabBar(MiniAppConfigModel.TabBarBean tabBar, boolean force) {
        MiniAppConfigModel.TabBarBean tabBarBean;
        if (!force && (tabBarBean = forceTabBarBean) != null) {
            Intrinsics.e(tabBarBean);
            return tabBarBean;
        }
        MiniAppConfigUtils miniAppConfigUtils = INSTANCE;
        MiniAppConfigModel.TabBarBean defaultTabBarConfig = miniAppConfigUtils.getDefaultTabBarConfig();
        if (!force && tabBar != null) {
            miniAppConfigUtils.setupTabBarConfig(defaultTabBarConfig, tabBar);
        }
        MiniAppConfigModel.TabBarBean queryMiniappCustomTabBar = AppUtils.INSTANCE.queryMiniappCustomTabBar();
        if (queryMiniappCustomTabBar != null) {
            miniAppConfigUtils.setupTabBarConfig(defaultTabBarConfig, queryMiniappCustomTabBar);
        }
        if (force && tabBar != null) {
            miniAppConfigUtils.setupTabBarConfig(defaultTabBarConfig, tabBar);
            forceTabBarBean = defaultTabBarConfig;
        }
        return defaultTabBarConfig;
    }

    @JvmStatic
    public static final MiniAppConfigModel.TabBarBean getTabBar(AppLoadResult appLoadResult) {
        MiniAppConfigModel miniAppConfigModel;
        return getTabBar((appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null) ? null : miniAppConfigModel.tabBar, appLoadResult, false);
    }

    public static /* synthetic */ MiniAppConfigModel.TabBarBean getTabBar$default(MiniAppConfigModel.TabBarBean tabBarBean, AppLoadResult appLoadResult, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return getTabBar(tabBarBean, appLoadResult, z10);
    }

    public static /* synthetic */ MiniAppConfigModel.TabBarBean getTabBar$default(MiniAppConfigModel.TabBarBean tabBarBean, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return getTabBar(tabBarBean, z10);
    }

    @JvmStatic
    public static final Integer getTitleBarNodeMode() {
        if (forceCapsuleViewBgColor.length() == 0) {
            return null;
        }
        return Integer.valueOf(!Intrinsics.c("white", forceCapsuleViewBgColor) ? 1 : 0);
    }

    @JvmStatic
    public static final MiniAppConfigModel.WindowBean getWindowConfig(MiniAppConfigModel.WindowBean appWindowConfig, MiniAppConfigModel.WindowBean pageWindowConfig, MiniAppConfigModel.WindowBean customPageWindowConfig) {
        MiniAppConfigUtils miniAppConfigUtils = INSTANCE;
        MiniAppConfigModel.WindowBean defaultWindowConfig = miniAppConfigUtils.getDefaultWindowConfig();
        if (appWindowConfig != null) {
            miniAppConfigUtils.setupWindowConfig(defaultWindowConfig, appWindowConfig);
        }
        if (pageWindowConfig != null) {
            miniAppConfigUtils.setupWindowConfig(defaultWindowConfig, pageWindowConfig);
        }
        if (customPageWindowConfig != null) {
            miniAppConfigUtils.setupWindowConfig(defaultWindowConfig, customPageWindowConfig);
        }
        return defaultWindowConfig;
    }

    @JvmStatic
    public static final MiniAppConfigModel.WindowBean getWindowOptimalConfiguration(AppLoadResult appLoadResult, String pagePath) {
        MiniAppConfigModel miniAppConfigModel;
        HashMap<String, MiniAppConfigModel.PagesBean> hashMap;
        if (appLoadResult != null) {
            try {
                miniAppConfigModel = appLoadResult.appConfigModel;
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        } else {
            miniAppConfigModel = null;
        }
        MiniAppConfigModel.WindowBean window = miniAppConfigModel != null ? miniAppConfigModel.getWindow() : null;
        MiniAppConfigModel.PagesBean pagesBean = (miniAppConfigModel == null || (hashMap = miniAppConfigModel.launchParams) == null) ? null : hashMap.get(UrlUtils.getPath(pagePath));
        MiniAppConfigModel.WindowBean window2 = pagesBean != null ? pagesBean.getWindow() : null;
        HashMap<String, MiniAppConfigModel.PagesBean> queryMiniappCustomLaunchParams = AppUtils.INSTANCE.queryMiniappCustomLaunchParams(appLoadResult);
        MiniAppConfigModel.PagesBean pagesBean2 = queryMiniappCustomLaunchParams != null ? queryMiniappCustomLaunchParams.get(UrlUtils.getPath(pagePath)) : null;
        return getWindowConfig(window, window2, pagesBean2 != null ? pagesBean2.getWindow() : null);
    }

    @JvmStatic
    public static final int navigationBarAction(String action) {
        Intrinsics.h(action, "action");
        if (Intrinsics.c(action, "back")) {
            return 1;
        }
        return Intrinsics.c(action, IntegrationConstants.NAVIGATION_BAR_ALL_ACTION) ? 2 : 0;
    }

    @JvmStatic
    public static final void setCapsuleViewBgColor(String color) {
        Intrinsics.h(color, "color");
        forceCapsuleViewBgColor = color;
    }

    private final void setupTabBarConfig(MiniAppConfigModel.TabBarBean r22, MiniAppConfigModel.TabBarBean target) {
        String takeIfNotEmpty = StringExtKt.takeIfNotEmpty(target.getColor());
        if (takeIfNotEmpty != null) {
            r22.setColor(takeIfNotEmpty);
        }
        String takeIfNotEmpty2 = StringExtKt.takeIfNotEmpty(target.getSelectedColor());
        if (takeIfNotEmpty2 != null) {
            r22.setSelectedColor(takeIfNotEmpty2);
        }
        String takeIfNotEmpty3 = StringExtKt.takeIfNotEmpty(target.getBackgroundColor());
        if (takeIfNotEmpty3 != null) {
            r22.setBackgroundColor(takeIfNotEmpty3);
        }
        String takeIfNotEmpty4 = StringExtKt.takeIfNotEmpty(target.getBorderStyle());
        if (takeIfNotEmpty4 != null) {
            r22.setBorderStyle(takeIfNotEmpty4);
        }
        List<MiniAppConfigModel.TabBarBean.ListBean> list = target.list;
        if (list != null) {
            r22.list = list;
        }
        String takeIfNotEmpty5 = StringExtKt.takeIfNotEmpty(target.getPosition());
        if (takeIfNotEmpty5 != null) {
            r22.setPosition(takeIfNotEmpty5);
        }
        if (target.getCustom() != null) {
            r22.setCustom(target.getCustom());
        }
    }

    private final MiniAppConfigModel.WindowBean setupWindowConfig(MiniAppConfigModel.WindowBean r22, MiniAppConfigModel.WindowBean target) {
        Boolean enablePullDownRefresh = target.getEnablePullDownRefresh();
        if (enablePullDownRefresh != null) {
            r22.setEnablePullDownRefresh(enablePullDownRefresh);
        }
        Boolean enablePullUpRefresh = target.getEnablePullUpRefresh();
        if (enablePullUpRefresh != null) {
            r22.setEnablePullUpRefresh(enablePullUpRefresh);
        }
        Boolean enableTransparentStatusBar = target.getEnableTransparentStatusBar();
        if (enableTransparentStatusBar != null) {
            r22.setEnableTransparentStatusBar(enableTransparentStatusBar);
        }
        Boolean enableNavigationBarLoading = target.getEnableNavigationBarLoading();
        if (enableNavigationBarLoading != null) {
            r22.setEnableNavigationBarLoading(enableNavigationBarLoading);
        }
        String navigationBarTitleText = target.getNavigationBarTitleText();
        if (navigationBarTitleText != null) {
            r22.setNavigationBarTitleText(navigationBarTitleText);
        }
        String navigationStyle = target.getNavigationStyle();
        if (navigationStyle != null) {
            r22.setNavigationStyle(navigationStyle);
        }
        String navigationBarBackgroundColor = target.getNavigationBarBackgroundColor();
        if (navigationBarBackgroundColor != null) {
            r22.setNavigationBarBackgroundColor(navigationBarBackgroundColor);
        }
        String navigationBarTextStyle = target.getNavigationBarTextStyle();
        if (navigationBarTextStyle != null) {
            r22.setNavigationBarTextStyle(navigationBarTextStyle);
        }
        String navigationBarIconStyle = target.getNavigationBarIconStyle();
        if (navigationBarIconStyle != null) {
            r22.setNavigationBarIconStyle(navigationBarIconStyle);
        }
        String navigationBarHomeAction = target.getNavigationBarHomeAction();
        if (navigationBarHomeAction != null) {
            r22.setNavigationBarHomeAction(navigationBarHomeAction);
        }
        String refreshHeaderStyle = target.getRefreshHeaderStyle();
        if (refreshHeaderStyle != null) {
            r22.setRefreshHeaderStyle(refreshHeaderStyle);
        }
        Boolean refreshHeaderCustomTextEnable = target.getRefreshHeaderCustomTextEnable();
        if (refreshHeaderCustomTextEnable != null) {
            r22.setRefreshHeaderCustomTextEnable(refreshHeaderCustomTextEnable);
        }
        String refreshHeaderCustomLoading = target.getRefreshHeaderCustomLoading();
        if (refreshHeaderCustomLoading != null) {
            r22.setRefreshHeaderCustomLoading(refreshHeaderCustomLoading);
        }
        String refreshHeaderCustomLoadingGif = target.getRefreshHeaderCustomLoadingGif();
        if (refreshHeaderCustomLoadingGif != null) {
            r22.setRefreshHeaderCustomLoadingGif(refreshHeaderCustomLoadingGif);
        }
        String refreshHeaderCustomSuccess = target.getRefreshHeaderCustomSuccess();
        if (refreshHeaderCustomSuccess != null) {
            r22.setRefreshHeaderCustomSuccess(refreshHeaderCustomSuccess);
        }
        String refreshHeaderCustomSuccessGif = target.getRefreshHeaderCustomSuccessGif();
        if (refreshHeaderCustomSuccessGif != null) {
            r22.setRefreshHeaderCustomSuccessGif(refreshHeaderCustomSuccessGif);
        }
        Boolean refreshHeaderTranslationContent = target.getRefreshHeaderTranslationContent();
        if (refreshHeaderTranslationContent != null) {
            r22.setRefreshHeaderTranslationContent(refreshHeaderTranslationContent);
        }
        String refreshHeaderAccentColor = target.getRefreshHeaderAccentColor();
        if (refreshHeaderAccentColor != null) {
            r22.setRefreshHeaderAccentColor(refreshHeaderAccentColor);
        }
        String refreshHeaderBackgroundColor = target.getRefreshHeaderBackgroundColor();
        if (refreshHeaderBackgroundColor != null) {
            r22.setRefreshHeaderBackgroundColor(refreshHeaderBackgroundColor);
        }
        Integer refreshHeaderDelayed = target.getRefreshHeaderDelayed();
        if (refreshHeaderDelayed != null) {
            r22.setRefreshHeaderDelayed(Integer.valueOf(refreshHeaderDelayed.intValue()));
        }
        String refreshFooterAccentColor = target.getRefreshFooterAccentColor();
        if (refreshFooterAccentColor != null) {
            r22.setRefreshFooterAccentColor(refreshFooterAccentColor);
        }
        String refreshFooterBackgroundColor = target.getRefreshFooterBackgroundColor();
        if (refreshFooterBackgroundColor != null) {
            r22.setRefreshFooterBackgroundColor(refreshFooterBackgroundColor);
        }
        Integer refreshFooterDelayed = target.getRefreshFooterDelayed();
        if (refreshFooterDelayed != null) {
            r22.setRefreshFooterDelayed(Integer.valueOf(refreshFooterDelayed.intValue()));
        }
        String contentBackgroundColor = target.getContentBackgroundColor();
        if (contentBackgroundColor != null) {
            r22.setContentBackgroundColor(contentBackgroundColor);
        }
        String handleWebviewPreload = target.getHandleWebviewPreload();
        if (handleWebviewPreload != null) {
            r22.setHandleWebviewPreload(handleWebviewPreload);
        }
        Boolean enablePageLoading = target.getEnablePageLoading();
        if (enablePageLoading != null) {
            r22.setEnablePageLoading(enablePageLoading);
        }
        Boolean enableTabBarAdjustPan = target.getEnableTabBarAdjustPan();
        if (enableTabBarAdjustPan != null) {
            r22.setEnableTabBarAdjustPan(enableTabBarAdjustPan);
        }
        String darkModeNavigationBarBackgroundColor = target.getDarkModeNavigationBarBackgroundColor();
        if (darkModeNavigationBarBackgroundColor != null) {
            r22.setDarkModeNavigationBarBackgroundColor(darkModeNavigationBarBackgroundColor);
        }
        String darkModeNavigationBarTextStyle = target.getDarkModeNavigationBarTextStyle();
        if (darkModeNavigationBarTextStyle != null) {
            r22.setDarkModeNavigationBarTextStyle(darkModeNavigationBarTextStyle);
        }
        String darkModeNavigationBarIconStyle = target.getDarkModeNavigationBarIconStyle();
        if (darkModeNavigationBarIconStyle != null) {
            r22.setDarkModeNavigationBarIconStyle(darkModeNavigationBarIconStyle);
        }
        String darkModeContentBackgroundColor = target.getDarkModeContentBackgroundColor();
        if (darkModeContentBackgroundColor != null) {
            r22.setDarkModeContentBackgroundColor(darkModeContentBackgroundColor);
        }
        Boolean limitTextZoom = target.getLimitTextZoom();
        if (limitTextZoom != null) {
            r22.setLimitTextZoom(limitTextZoom);
        }
        return r22;
    }
}
