package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageConfig;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AddHomeCustomTopTipView extends LinearLayout {
    public static final /* synthetic */ int OooOO0o = 0;
    public long OooO;
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;
    public final String OooO0Oo;
    public final String OooO0o;
    public final String OooO0o0;
    public MiniAppAutoPopover OooO0oO;
    public boolean OooO0oo;
    public final Lazy OooOO0;
    public final OooO0o OooOO0O;

    /* loaded from: classes3.dex */
    public static final class OooO extends Lambda implements Function0<View> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return AddHomeCustomTopTipView.this.findViewById(R.id.view_click_close);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o extends Lambda implements Function0<ActivityHelper> {
        public final /* synthetic */ Context OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(Context context) {
            super(0);
            this.OooO00o = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            Context context = this.OooO00o;
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity != null) {
                return miniAppActivity.getMActivityHelper();
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) AddHomeCustomTopTipView.this.findViewById(R.id.add_home_toast);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function0<ImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (ImageView) AddHomeCustomTopTipView.this.findViewById(R.id.iv_images);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o implements PopWindowManager.IPopWindowManagerController {
        public OooO0o() {
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.IPopWindowManagerController
        public void onRefresh(PopWindowManager.PopWindowData bean) {
            Intrinsics.h(bean, "bean");
            Context context = AddHomeCustomTopTipView.this.getContext();
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity == null) {
                return;
            }
            TmcLogger.d(AddHomeCustomTopTipView.this.OooO0o, "onRefresh:" + (System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()));
            miniAppActivity.showPopUpWindowRunnable(bean.getDelayTime() - (System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()));
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.cloud.tmc.integration.utils.PopWindowManager.IPopWindowManagerController
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void show(java.lang.String r12) {
            /*
                Method dump skipped, instructions count: 337
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.popupview.AddHomeCustomTopTipView.OooO0o.show(java.lang.String):void");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AddHomeCustomTopTipView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddHomeCustomTopTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.OooO00o = LazyKt.b(new OooO0O0());
        this.OooO0O0 = LazyKt.b(new OooO0OO());
        this.OooO0OO = LazyKt.b(new OooO());
        this.OooO0Oo = "key_latest_show_top_toast_time";
        this.OooO0o0 = "key_show_top_toast_num";
        this.OooO0o = "AddHomeCustomTopTipView";
        this.OooOO0 = LazyKt.b(new OooO00o(context));
        LayoutInflater.from(context).inflate(R.layout.mini_layout_custom_addhome_top_tip_view, this);
        if (!isInEditMode()) {
            setTranslationY(getTranslationY() + MiniBarUtils.getStatusHeight());
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustomTopTipView.OooO00o(AddHomeCustomTopTipView.this, view);
            }
        });
        this.OooOO0O = new OooO0o();
    }

    public /* synthetic */ AddHomeCustomTopTipView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void OooO00o(AddHomeCustomTopTipView this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        this$0.getClass();
        ViewExtKt.toGone(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityHelper getActivityHelper() {
        return (ActivityHelper) this.OooOO0.getValue();
    }

    private final TextView getAddHomeToast() {
        return (TextView) this.OooO00o.getValue();
    }

    private final ImageView getIvImages() {
        return (ImageView) this.OooO0O0.getValue();
    }

    private final View getViewClickClose() {
        return (View) this.OooO0OO.getValue();
    }

    public final int OooO00o(Context context, String str) {
        return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0o0 + "_" + str);
    }

    public final void OooO00o() {
        try {
            if (ViewExtKt.getVisible(this)) {
                startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mini_view_toast_exit));
                ViewExtKt.toInvisible(this);
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0o, "toAddCustomTopTopVisible error", th2);
        }
    }

    public final void OooO00o(Context context, String appId, boolean z10) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        if (z10) {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0o0 + "_" + appId, 0);
            return;
        }
        int OooO00o2 = OooO00o(context, appId);
        TmcLogger.d(this.OooO0o, "updateShowNum->" + OooO00o2);
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0o0 + "_" + appId, OooO00o2 + 1);
    }

    public final void OooO00o(String miniappId, MiniAppAutoPopover miniAppAutoPopover, long j11) {
        Long delayDuration;
        MiniAppMultiLanguageModel en2;
        MiniAppMultiLanguageModel id2;
        MiniAppMultiLanguageModel ru2;
        MiniAppMultiLanguageModel ar2;
        MiniAppMultiLanguageModel fr2;
        MiniAppMultiLanguageModel en3;
        MiniAppMultiLanguageModel zh2;
        Intrinsics.h(miniappId, "miniappId");
        Context context = getContext();
        String str = null;
        MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
        if (miniAppActivity == null) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.g(context2, "context");
        if (OooO00o(context2, miniappId, miniAppAutoPopover)) {
            if (miniAppAutoPopover != null) {
                this.OooO0oO = miniAppAutoPopover;
                MiniAppMultiLanguageConfig configs = miniAppAutoPopover.getConfigs();
                String language = Locale.getDefault().getLanguage();
                if (Intrinsics.c(language, Locale.CHINESE.getLanguage())) {
                    if (configs != null && (zh2 = configs.getZh()) != null) {
                        str = zh2.getTitle();
                    }
                } else if (Intrinsics.c(language, Locale.ENGLISH.getLanguage())) {
                    if (configs != null && (en3 = configs.getEn()) != null) {
                        str = en3.getTitle();
                    }
                } else if (Intrinsics.c(language, Locale.FRANCE.getLanguage())) {
                    if (configs != null && (fr2 = configs.getFr()) != null) {
                        str = fr2.getTitle();
                    }
                } else if (Intrinsics.c(language, new Locale("ar").getLanguage())) {
                    if (configs != null && (ar2 = configs.getAr()) != null) {
                        str = ar2.getTitle();
                    }
                } else if (Intrinsics.c(language, new Locale("ru").getLanguage())) {
                    if (configs != null && (ru2 = configs.getRu()) != null) {
                        str = ru2.getTitle();
                    }
                } else if (Intrinsics.c(language, new Locale("in").getLanguage())) {
                    if (configs != null && (id2 = configs.getId()) != null) {
                        str = id2.getTitle();
                    }
                } else if (configs != null && (en2 = configs.getEn()) != null) {
                    str = en2.getTitle();
                }
                String string = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string, "context.getString(R.stri…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty = StringExtKt.orDefaultAndCheckEmpty(str, string);
                TextView addHomeToast = getAddHomeToast();
                if (addHomeToast != null) {
                    addHomeToast.setText(orDefaultAndCheckEmpty);
                }
            }
            PopWindowManager popWindowManager = PopWindowManager.INSTANCE;
            String miniAppPopWindowToken = miniAppActivity.getMiniAppPopWindowToken();
            if (j11 == 0) {
                j11 = (miniAppAutoPopover == null || (delayDuration = miniAppAutoPopover.getDelayDuration()) == null) ? MBInterstitialActivity.WEB_LOAD_TIME : delayDuration.longValue();
            }
            popWindowManager.addPopWindow(miniAppPopWindowToken, new PopWindowManager.PopWindowData(miniappId, j11, 1, this.OooOO0O, true));
        }
    }

    public final boolean OooO00o(Context context, String str, MiniAppAutoPopover miniAppAutoPopover) {
        if (miniAppAutoPopover != null) {
            try {
                if (!Intrinsics.c(miniAppAutoPopover.getStatus(), Boolean.FALSE)) {
                    if (!MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_ADD_HOME_CUSTOM_TOP_TIP, true)) {
                        TmcLogger.d(this.OooO0o, "checkAddHomeTopTipIsNeedShow: topTipsEnable is false");
                        return false;
                    }
                    if (AppUtils.INSTANCE.queryShortcutExist(context, str)) {
                        TmcLogger.d(this.OooO0o, "checkAddHomeTopTipIsNeedShow addhomeStatus is true");
                        return false;
                    }
                    long j11 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0Oo + "_" + str);
                    long intValue = (miniAppAutoPopover.getPerXDay() != null ? r4.intValue() : 1) * 86400 * 1000;
                    int OooO00o2 = OooO00o(context, str);
                    if (System.currentTimeMillis() - j11 > intValue) {
                        OooO00o(context, str, true);
                    } else {
                        Integer displayFrequency = miniAppAutoPopover.getDisplayFrequency();
                        if (OooO00o2 >= (displayFrequency != null ? displayFrequency.intValue() : 1)) {
                            String str2 = this.OooO0o;
                            Integer displayFrequency2 = miniAppAutoPopover.getDisplayFrequency();
                            TmcLogger.d(str2, "checkAddHomeTopTipIsNeedShow showNum is " + OooO00o2 + " >=" + (displayFrequency2 != null ? displayFrequency2.intValue() : 1));
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO0o, "checkAddHomeTopTipIsNeedShow error", th2);
                return true;
            }
        }
        TmcLogger.d(this.OooO0o, "checkAddHomeTopTipIsNeedShow: bean is null or status is false");
        return false;
    }

    public final void OooO0O0() {
        App app;
        try {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mini_view_toast_enter));
            ViewExtKt.toVisible(this);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            ActivityHelper activityHelper = getActivityHelper();
            performanceAnalyseProxy.recordForCommon((activityHelper == null || (app = activityHelper.getApp()) == null) ? null : app.getAppId(), "upper_pop_ex", new Bundle());
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0o, "toAddCustomTopTopVisible error", th2);
        }
    }

    public final void OooO0O0(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0Oo + "_" + appId, System.currentTimeMillis());
    }

    public final MiniAppAutoPopover getMMiniAppAutoPopover() {
        return this.OooO0oO;
    }

    public final long getShowAddHomeTopTipsDelayTime() {
        return this.OooO;
    }

    public final boolean getShowAddHomeTopTipsStatus() {
        return this.OooO0oo;
    }

    public final void setMMiniAppAutoPopover(MiniAppAutoPopover miniAppAutoPopover) {
        this.OooO0oO = miniAppAutoPopover;
    }

    public final void setShowAddHomeTopTipsDelayTime(long j11) {
        this.OooO = j11;
    }

    public final void setShowAddHomeTopTipsStatus(boolean z10) {
        this.OooO0oo = z10;
    }
}
