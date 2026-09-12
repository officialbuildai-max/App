package com.cloud.tmc.miniapp.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.ui.TabBar;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.miniapp.R;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TabBarView extends RelativeLayout implements TabBar {
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public MiniAppConfigModel.TabBarBean OooO0OO;

    /* loaded from: classes3.dex */
    public static final class OooO00o implements TabLayout.OnTabSelectedListener {
        public final void OooO00o(TabLayout.Tab tab, String str) {
            if (FastClickUtil.isFastDoubleClick() || tab == null) {
                return;
            }
            View customView = tab.getCustomView();
            Intrinsics.f(customView, "null cannot be cast to non-null type com.cloud.tmc.miniapp.widget.TabBarItemView");
            com.cloud.tmc.miniapp.widget.OooO0OO oooO0OO = (com.cloud.tmc.miniapp.widget.OooO0OO) customView;
            Page page = oooO0OO.getPage();
            if (page != null) {
                MiniAppConfigModel.TabBarBean.ListBean tabBarList = oooO0OO.getTabBarList();
                String str2 = tabBarList != null ? tabBarList.pagePath : null;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
                App app = page.getApp();
                if (app != null) {
                    app.putRouteType(str2, "switchTab");
                }
                App app2 = page.getApp();
                if (app2 != null) {
                    app2.putStringValue(TmcConstants.KEY_SWITCH_TAB_FROM_SCENE, str);
                }
                App app3 = page.getApp();
                if (app3 != null) {
                    App app4 = page.getApp();
                    Bundle startParams = app4 != null ? app4.getStartParams() : null;
                    App app5 = page.getApp();
                    app3.switchTab(str2, startParams, app5 != null ? app5.getSceneParams() : null);
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            TmcLogger.d("[TabBarView]: onTabReselected:" + (tab != null ? Integer.valueOf(tab.getPosition()) : null) + ", from:" + tab);
            OooO00o(tab, TmcConstants.KEY_FROM_TAB_RESELECTED);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            TmcLogger.d("[TabBarView]: onTabSelected:" + (tab != null ? Integer.valueOf(tab.getPosition()) : null) + ", from::" + tab);
            OooO00o(tab, TmcConstants.KEY_FROM_TAB_SELECTED);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            TmcLogger.d("[TabBarView]: onTabUnselected:" + (tab != null ? Integer.valueOf(tab.getPosition()) : null) + ", from::" + tab);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function0<TabLayout> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TabLayout) TabBarView.this.findViewById(R.id.tab_navigation);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function0<View> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return TabBarView.this.findViewById(R.id.view_line_top);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.OooO00o = LazyKt.b(new OooO0O0());
        this.OooO0O0 = LazyKt.b(new OooO0OO());
        LayoutInflater.from(context).inflate(R.layout.layout_mini_tab_bar, this);
        setGravity(80);
        getTabLayout().setTabRippleColorResource(R.color.mini_color_transparent);
        getTabLayout().setTabGravity(0);
        getTabLayout().setTabMode(1);
        getTabLayout().addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new OooO00o());
    }

    public static final void OooO00o(TabBarView this$0, ValueAnimator it) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(it, "it");
        Object animatedValue = it.getAnimatedValue();
        if (Intrinsics.b(animatedValue instanceof Float ? (Float) animatedValue : null, this$0.getHeight())) {
            ViewExtKt.toGone(this$0);
        }
    }

    private final TabLayout getTabLayout() {
        Object value = this.OooO00o.getValue();
        Intrinsics.g(value, "<get-tabLayout>(...)");
        return (TabLayout) value;
    }

    private final View getViewLineTop() {
        Object value = this.OooO0O0.getValue();
        Intrinsics.g(value, "<get-viewLineTop>(...)");
        return (View) value;
    }

    public final int OooO00o(String str) {
        if (Intrinsics.c(str, "white")) {
            return androidx.core.content.b.getColor(getContext(), R.color.default_tab_bar_title_white_color);
        }
        if (Intrinsics.c(str, "black")) {
            return androidx.core.content.b.getColor(getContext(), R.color.default_tab_bar_title_black_color);
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable th2) {
            TmcLogger.e("TabBarView", "Invalid border style", th2);
            return 0;
        }
    }

    public final boolean OooO00o(int i11) {
        if (!ViewExtKt.getVisible(this)) {
            TmcLogger.d("TabBarView", "tab not is visible");
            return false;
        }
        if (i11 >= 0 && i11 < getTabLayout().getTabCount()) {
            return true;
        }
        TmcLogger.d("TabBarView", "index out of tab count");
        return false;
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean hideTabBar(boolean z10) {
        if (getTranslationY() == getHeight()) {
            return true;
        }
        if (z10) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, getHeight());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cloud.tmc.miniapp.widget.r
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabBarView.OooO00o(TabBarView.this, valueAnimator);
                }
            });
            ofFloat.setDuration(500L);
            ofFloat.start();
        } else {
            setTranslationY(getHeight());
            ViewExtKt.toGone(this);
        }
        return true;
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean isShow() {
        return ViewExtKt.getVisible(this) && getTranslationY() == 0.0f;
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean removeTabBarBadge(int i11) {
        if (!OooO00o(i11)) {
            return false;
        }
        TabLayout.Tab tabAt = getTabLayout().getTabAt(i11);
        Unit unit = null;
        View customView = tabAt != null ? tabAt.getCustomView() : null;
        com.cloud.tmc.miniapp.widget.OooO0OO oooO0OO = customView instanceof com.cloud.tmc.miniapp.widget.OooO0OO ? (com.cloud.tmc.miniapp.widget.OooO0OO) customView : null;
        if (oooO0OO != null) {
            oooO0OO.OooO00o();
            unit = Unit.f67184a;
        }
        return unit != null;
    }

    public final void setCommonresId(String str) {
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean setTabBarBadge(int i11, String str) {
        if (!OooO00o(i11)) {
            return false;
        }
        TabLayout.Tab tabAt = getTabLayout().getTabAt(i11);
        Unit unit = null;
        View customView = tabAt != null ? tabAt.getCustomView() : null;
        com.cloud.tmc.miniapp.widget.OooO0OO oooO0OO = customView instanceof com.cloud.tmc.miniapp.widget.OooO0OO ? (com.cloud.tmc.miniapp.widget.OooO0OO) customView : null;
        if (oooO0OO != null) {
            oooO0OO.setTabBarBadge(str);
            unit = Unit.f67184a;
        }
        return unit != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        if (r3 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        if (r3 == null) goto L31;
     */
    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean setTabBarStyle(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            r6 = this;
            com.google.android.material.tabs.TabLayout r0 = r6.getTabLayout()
            int r0 = r0.getTabCount()
            r1 = 0
        L9:
            java.lang.String r2 = ""
            r3 = 0
            if (r1 >= r0) goto L57
            com.google.android.material.tabs.TabLayout r4 = r6.getTabLayout()
            com.google.android.material.tabs.TabLayout$Tab r4 = r4.getTabAt(r1)
            if (r4 == 0) goto L1d
            android.view.View r4 = r4.getCustomView()
            goto L1e
        L1d:
            r4 = r3
        L1e:
            boolean r5 = r4 instanceof com.cloud.tmc.miniapp.widget.OooO0OO
            if (r5 == 0) goto L25
            com.cloud.tmc.miniapp.widget.OooO0OO r4 = (com.cloud.tmc.miniapp.widget.OooO0OO) r4
            goto L26
        L25:
            r4 = r3
        L26:
            if (r4 == 0) goto L54
            boolean r5 = r4.getTabSelected()
            if (r5 == 0) goto L41
            if (r8 != 0) goto L3f
            com.cloud.tmc.integration.model.MiniAppConfigModel$TabBarBean r5 = r4.getTabBarConfig()
            if (r5 == 0) goto L3a
            java.lang.String r3 = r5.getSelectedColor()
        L3a:
            if (r3 != 0) goto L3d
            goto L51
        L3d:
            r2 = r3
            goto L51
        L3f:
            r2 = r8
            goto L51
        L41:
            if (r7 != 0) goto L50
            com.cloud.tmc.integration.model.MiniAppConfigModel$TabBarBean r5 = r4.getTabBarConfig()
            if (r5 == 0) goto L4d
            java.lang.String r3 = r5.getColor()
        L4d:
            if (r3 != 0) goto L3d
            goto L51
        L50:
            r2 = r7
        L51:
            r4.OooO00o(r2)
        L54:
            int r1 = r1 + 1
            goto L9
        L57:
            if (r9 != 0) goto L6a
            com.cloud.tmc.integration.model.MiniAppConfigModel$TabBarBean r7 = r6.OooO0OO     // Catch: java.lang.Exception -> L62
            if (r7 == 0) goto L64
            java.lang.String r7 = r7.getBackgroundColor()     // Catch: java.lang.Exception -> L62
            goto L65
        L62:
            r7 = move-exception
            goto L7c
        L64:
            r7 = r3
        L65:
            if (r7 != 0) goto L69
            r9 = r2
            goto L6a
        L69:
            r9 = r7
        L6a:
            int r7 = r9.length()     // Catch: java.lang.Exception -> L62
            if (r7 <= 0) goto L81
            com.google.android.material.tabs.TabLayout r7 = r6.getTabLayout()     // Catch: java.lang.Exception -> L62
            int r8 = android.graphics.Color.parseColor(r9)     // Catch: java.lang.Exception -> L62
            r7.setBackgroundColor(r8)     // Catch: java.lang.Exception -> L62
            goto L81
        L7c:
            java.lang.String r8 = "[TabBarView]: set tab background color error"
            com.cloud.tmc.kernel.log.TmcLogger.e(r8, r7)
        L81:
            android.view.View r7 = r6.getViewLineTop()
            if (r10 != 0) goto L95
            com.cloud.tmc.integration.model.MiniAppConfigModel$TabBarBean r8 = r6.OooO0OO
            if (r8 == 0) goto L91
            java.lang.String r8 = r8.getBorderStyle()
            r10 = r8
            goto L92
        L91:
            r10 = r3
        L92:
            if (r10 != 0) goto L95
            r10 = r2
        L95:
            int r8 = r6.OooO00o(r10)
            r7.setBackgroundColor(r8)
            r7 = 1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.TabBarView.setTabBarStyle(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public void setTabs(MiniAppConfigModel.TabBarBean tabBarBean, Page page, String commonresId) {
        Intrinsics.h(commonresId, "commonresId");
        if (Intrinsics.c(this.OooO0OO, tabBarBean)) {
            TmcLogger.e("[TabBarView]: same config, setTabs return.");
            return;
        }
        this.OooO0OO = tabBarBean;
        getTabLayout().removeAllTabs();
        if (tabBarBean != null) {
            if (tabBarBean.tabBarCustom()) {
                ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast("Tab bar view does not support customization");
                TmcLogger.e("[TabBarView]: Tab bar view does not support customization");
                return;
            }
            if (tabBarBean.tabBarPositionIsTop()) {
                ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast("Tab bar view does not support top position");
                TmcLogger.e("[TabBarView]: Tab bar view does not support top position");
                return;
            }
            List<MiniAppConfigModel.TabBarBean.ListBean> list = tabBarBean.list;
            if (list == null) {
                ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast("Tab bar view tabs is not null");
                TmcLogger.e("[TabBarView]: Tab bar view is not null");
                return;
            }
            int size = list.size();
            if (2 > size || size >= 6) {
                ((ToastProxy) TmcProxy.get(ToastProxy.class)).toast("Tab bar view numbers is between 2 and 5");
                TmcLogger.e("[TabBarView]: Tab bar view is between 2 and 5");
                return;
            }
            for (MiniAppConfigModel.TabBarBean.ListBean listBean : list) {
                Context context = getContext();
                Intrinsics.g(context, "context");
                String str = null;
                com.cloud.tmc.miniapp.widget.OooO0OO oooO0OO = new com.cloud.tmc.miniapp.widget.OooO0OO(context, null);
                oooO0OO.setCommonresId(commonresId);
                oooO0OO.OooO00o(tabBarBean, listBean, page);
                TabLayout tabLayout = getTabLayout();
                TabLayout.Tab customView = getTabLayout().newTab().setCustomView(oooO0OO);
                customView.setTag(listBean.pagePath);
                String str2 = listBean.pagePath;
                if (page != null) {
                    str = page.getPagePath();
                }
                tabLayout.addTab(customView, Intrinsics.c(str2, str));
            }
            String backgroundColor = tabBarBean.getBackgroundColor();
            if (backgroundColor != null) {
                try {
                    if (backgroundColor.length() > 0) {
                        getTabLayout().setBackgroundColor(Color.parseColor(backgroundColor));
                    }
                } catch (Exception e11) {
                    TmcLogger.e("[TabBarView]: set tab background color error", e11);
                }
            }
            getViewLineTop().setBackgroundColor(OooO00o(tabBarBean.getBorderStyle()));
        }
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean setUnreadIconVisible(int i11, boolean z10) {
        if (!OooO00o(i11)) {
            return false;
        }
        TabLayout.Tab tabAt = getTabLayout().getTabAt(i11);
        Unit unit = null;
        View customView = tabAt != null ? tabAt.getCustomView() : null;
        com.cloud.tmc.miniapp.widget.OooO0OO oooO0OO = customView instanceof com.cloud.tmc.miniapp.widget.OooO0OO ? (com.cloud.tmc.miniapp.widget.OooO0OO) customView : null;
        if (oooO0OO != null) {
            oooO0OO.setUnreadIconVisible(z10);
            unit = Unit.f67184a;
        }
        return unit != null;
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean setUnreadVisible(int i11, boolean z10) {
        if (!OooO00o(i11)) {
            return false;
        }
        TabLayout.Tab tabAt = getTabLayout().getTabAt(i11);
        Unit unit = null;
        View customView = tabAt != null ? tabAt.getCustomView() : null;
        com.cloud.tmc.miniapp.widget.OooO0OO oooO0OO = customView instanceof com.cloud.tmc.miniapp.widget.OooO0OO ? (com.cloud.tmc.miniapp.widget.OooO0OO) customView : null;
        if (oooO0OO != null) {
            oooO0OO.setUnreadVisible(z10);
            unit = Unit.f67184a;
        }
        return unit != null;
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean showTabBar(boolean z10) {
        ViewExtKt.toVisible(this);
        if (getTranslationY() == 0.0f) {
            return true;
        }
        if (z10) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", getHeight(), 0.0f);
            ofFloat.setDuration(500L);
            ofFloat.start();
        } else {
            setTranslationY(0.0f);
        }
        return true;
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public void showTabBarUnreadIcon(int i11, String iconPath, Page page, Function1<? super Boolean, Unit> function1) {
        Intrinsics.h(iconPath, "iconPath");
        Intrinsics.h(page, "page");
        if (!OooO00o(i11)) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        TabLayout.Tab tabAt = getTabLayout().getTabAt(i11);
        View customView = tabAt != null ? tabAt.getCustomView() : null;
        com.cloud.tmc.miniapp.widget.OooO0OO oooO0OO = customView instanceof com.cloud.tmc.miniapp.widget.OooO0OO ? (com.cloud.tmc.miniapp.widget.OooO0OO) customView : null;
        if (oooO0OO != null) {
            Intrinsics.h(iconPath, "iconPath");
            Intrinsics.h(page, "page");
            App app = page.getApp();
            oooO0OO.OooO00o(iconPath, app != null ? app.getAppId() : null, new OooO0o(function1, oooO0OO));
        }
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public void switchCurrentTab(String str) {
        TabLayout.Tab tabAt;
        int tabCount = getTabLayout().getTabCount();
        for (int i11 = 0; i11 < tabCount; i11++) {
            TabLayout.Tab tabAt2 = getTabLayout().getTabAt(i11);
            if (Intrinsics.c(tabAt2 != null ? tabAt2.getTag() : null, str)) {
                TabLayout tabLayout = getTabLayout();
                if (tabLayout.getTabCount() <= i11 || (tabAt = tabLayout.getTabAt(i11)) == null) {
                    return;
                }
                tabAt.select();
                return;
            }
        }
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean updateAllTabs(List<MiniAppConfigModel.TabBarBean.ListBean> tabs, Page page) {
        Intrinsics.h(tabs, "tabs");
        Intrinsics.h(page, "page");
        if (!ViewExtKt.getVisible(this)) {
            TmcLogger.d("TabBarView", "tab not is visible");
            return false;
        }
        if (tabs.size() != getTabLayout().getTabCount()) {
            TmcLogger.d("TabBarView", "tab size mismatch with tab count");
            return false;
        }
        int tabCount = getTabLayout().getTabCount();
        for (int i11 = 0; i11 < tabCount; i11++) {
            updateTabItem(i11, tabs.get(i11), page);
        }
        return true;
    }

    @Override // com.cloud.tmc.integration.structure.ui.TabBar
    public boolean updateTabItem(int i11, MiniAppConfigModel.TabBarBean.ListBean tab, Page page) {
        TabLayout.Tab tabAt;
        Intrinsics.h(tab, "tab");
        Intrinsics.h(page, "page");
        if (!OooO00o(i11) || (tabAt = getTabLayout().getTabAt(i11)) == null) {
            return false;
        }
        View customView = tabAt.getCustomView();
        Intrinsics.f(customView, "null cannot be cast to non-null type com.cloud.tmc.miniapp.widget.TabBarItemView");
        ((com.cloud.tmc.miniapp.widget.OooO0OO) customView).OooO00o(tab, page);
        return true;
    }
}
