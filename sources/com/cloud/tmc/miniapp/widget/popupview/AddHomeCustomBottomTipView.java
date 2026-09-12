package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageConfig;
import com.cloud.tmc.integration.model.MiniAppMultiLanguageModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.CreateShortCutUtils;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniutils.util.SizeUtils;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AddHomeCustomBottomTipView extends LinearLayout {
    public static final /* synthetic */ int OooOOO0 = 0;
    public MiniAppAutoPopover OooO;
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;
    public final String OooO0o;
    public final String OooO0o0;
    public final String OooO0oO;
    public final Lazy OooO0oo;
    public boolean OooOO0;
    public long OooOO0O;
    public final OooO0o OooOO0o;

    /* loaded from: classes3.dex */
    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) AddHomeCustomBottomTipView.this.findViewById(R.id.btn_add_home);
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
    public static final class OooO0O0 extends Lambda implements Function0<AppCompatImageView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (AppCompatImageView) AddHomeCustomBottomTipView.this.findViewById(R.id.iv_mini_logo);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function0<ImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (ImageView) AddHomeCustomBottomTipView.this.findViewById(R.id.iv_mini_tips_x);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o implements PopWindowManager.IPopWindowManagerController {
        public final /* synthetic */ Context OooO0O0;

        public OooO0o(Context context) {
            this.OooO0O0 = context;
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.IPopWindowManagerController
        public void onRefresh(PopWindowManager.PopWindowData bean) {
            Intrinsics.h(bean, "bean");
            Context context = this.OooO0O0;
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity == null) {
                return;
            }
            TmcLogger.d(AddHomeCustomBottomTipView.this.OooO0oO, "onRefresh:" + (System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()));
            miniAppActivity.showPopUpWindowRunnable(bean.getDelayTime() - (System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()));
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.IPopWindowManagerController
        public void show(String appId) {
            App app;
            Long delayDuration;
            Intrinsics.h(appId, "appId");
            TmcLogger.d(AddHomeCustomBottomTipView.this.OooO0oO, "showAddHomeBottomTipsController");
            Context context = this.OooO0O0;
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity == null || CreateShortCutUtils.INSTANCE.getAddHomeStatus(context, appId)) {
                return;
            }
            try {
                MiniAppAutoPopover mMiniAppAutoPopover = AddHomeCustomBottomTipView.this.getMMiniAppAutoPopover();
                long longValue = (mMiniAppAutoPopover == null || (delayDuration = mMiniAppAutoPopover.getDelayDuration()) == null) ? MBInterstitialActivity.WEB_LOAD_TIME : delayDuration.longValue();
                long currentTimeMillis = miniAppActivity.getMiniappResumeTimestamp() > miniAppActivity.getOnPauseStopTimeStamp() ? (System.currentTimeMillis() - miniAppActivity.getMiniappResumeTimestamp()) + miniAppActivity.getMiniappForegroundTime() : miniAppActivity.getMiniappForegroundTime();
                TmcLogger.d(AddHomeCustomBottomTipView.this.OooO0oO, "currentForegroundTime:->" + currentTimeMillis);
                if (!miniAppActivity.getResumed()) {
                    AddHomeCustomBottomTipView.this.setShowAddHomeBottomTipsStatus(true);
                    AddHomeCustomBottomTipView.this.setShowAddHomeBottomTipsDelayTime(((System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()) + longValue) - currentTimeMillis);
                    return;
                }
                if (currentTimeMillis <= longValue) {
                    AddHomeCustomBottomTipView addHomeCustomBottomTipView = AddHomeCustomBottomTipView.this;
                    addHomeCustomBottomTipView.OooO00o(appId, addHomeCustomBottomTipView.getMMiniAppAutoPopover(), ((System.currentTimeMillis() - miniAppActivity.getMiniappStartTime()) + longValue) - currentTimeMillis);
                    return;
                }
                AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.INSTANCE;
                ActivityHelper mActivityHelper = miniAppActivity.getMActivityHelper();
                if (addHomeToScreenUtils.checkAddhomeShowStatus(82, mActivityHelper != null ? mActivityHelper.getApp() : null)) {
                    TmcLogger.d(AddHomeCustomBottomTipView.this.OooO0oO, "not allow show, return");
                    return;
                }
                if (PermissionScopeBridge.Companion.OooO00o(appId)) {
                    TmcLogger.d(AddHomeCustomBottomTipView.this.OooO0oO, "dev dialog is showing, return");
                    return;
                }
                AddHomeCustomBottomTipView.this.OooO00o();
                AddHomeCustomBottomTipView.this.OooO00o(this.OooO0O0, appId, false);
                AddHomeCustomBottomTipView.this.OooO0O0(this.OooO0O0, appId);
                ActivityHelper activityHelper = AddHomeCustomBottomTipView.this.getActivityHelper();
                if (activityHelper == null || (app = activityHelper.getApp()) == null) {
                    return;
                }
                app.updateAddHomeShowStatus(82);
            } catch (Throwable th2) {
                TmcLogger.e(AddHomeCustomBottomTipView.this.OooO0oO, th2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) AddHomeCustomBottomTipView.this.findViewById(R.id.tv_content_info);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AddHomeCustomBottomTipView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddHomeCustomBottomTipView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.OooO00o = LazyKt.b(new OooO0O0());
        this.OooO0O0 = LazyKt.b(new OooOO0());
        this.OooO0OO = LazyKt.b(new OooO());
        this.OooO0Oo = LazyKt.b(new OooO0OO());
        this.OooO0o0 = "key_latest_show_bottom_toast_time";
        this.OooO0o = "key_show_bottom_toast_num";
        this.OooO0oO = "AddHomeCustomBottomTipView";
        this.OooO0oo = LazyKt.b(new OooO00o(context));
        LayoutInflater.from(context).inflate(R.layout.mini_layout_custom_addhome_bottom_tip_view, this);
        if (!isInEditMode()) {
            setTranslationY(getTranslationY() + MiniBarUtils.getStatusHeight());
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustomBottomTipView.OooO00o(AddHomeCustomBottomTipView.this, view);
            }
        });
        getTvAddHome().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustomBottomTipView.OooO00o(AddHomeCustomBottomTipView.this, context, view);
            }
        });
        getIvMiniTipsX().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.popupview.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustomBottomTipView.OooO0O0(AddHomeCustomBottomTipView.this, view);
            }
        });
        this.OooOO0o = new OooO0o(context);
    }

    public /* synthetic */ AddHomeCustomBottomTipView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void OooO00o(AddHomeCustomBottomTipView this$0, Context context, View view) {
        App app;
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(context, "$context");
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        ActivityHelper activityHelper = this$0.getActivityHelper();
        String appId = (activityHelper == null || (app = activityHelper.getApp()) == null) ? null : app.getAppId();
        Bundle bundle = new Bundle();
        bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, "14");
        Unit unit = Unit.f67184a;
        performanceAnalyseProxy.recordForCommon(appId, "bottom_banner_click", bundle);
        MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
        if (miniAppActivity != null) {
            miniAppActivity.addScreen("14");
        }
    }

    public static final void OooO00o(AddHomeCustomBottomTipView this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        TmcLogger.d(this$0.OooO0oO, "AddHomeCustomBottomTipView click");
    }

    public static final void OooO0O0(AddHomeCustomBottomTipView this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        this$0.getClass();
        ViewExtKt.toGone(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityHelper getActivityHelper() {
        return (ActivityHelper) this.OooO0oo.getValue();
    }

    private final AppCompatImageView getIvMiniLogo() {
        Object value = this.OooO00o.getValue();
        Intrinsics.g(value, "<get-ivMiniLogo>(...)");
        return (AppCompatImageView) value;
    }

    private final ImageView getIvMiniTipsX() {
        Object value = this.OooO0Oo.getValue();
        Intrinsics.g(value, "<get-ivMiniTipsX>(...)");
        return (ImageView) value;
    }

    private final TextView getTvAddHome() {
        Object value = this.OooO0OO.getValue();
        Intrinsics.g(value, "<get-tvAddHome>(...)");
        return (TextView) value;
    }

    private final TextView getTvContentInfo() {
        Object value = this.OooO0O0.getValue();
        Intrinsics.g(value, "<get-tvContentInfo>(...)");
        return (TextView) value;
    }

    public final int OooO00o(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0o + "_" + appId);
    }

    public final AddHomeCustomBottomTipView OooO00o(MiniAppMultiLanguageConfig miniAppMultiLanguageConfig) {
        String language;
        MiniAppMultiLanguageModel en2;
        String buttonText;
        MiniAppMultiLanguageModel id2;
        MiniAppMultiLanguageModel ru2;
        MiniAppMultiLanguageModel ar2;
        MiniAppMultiLanguageModel fr2;
        MiniAppMultiLanguageModel en3;
        MiniAppMultiLanguageModel zh2;
        try {
            language = Locale.getDefault().getLanguage();
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0oO, th2);
        }
        if (Intrinsics.c(language, Locale.CHINESE.getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (zh2 = miniAppMultiLanguageConfig.getZh()) != null) {
                buttonText = zh2.getButtonText();
                String string = getContext().getString(R.string.mini_addhome_dialog_btn_add);
                Intrinsics.g(string, "context.getString(R.stri…i_addhome_dialog_btn_add)");
                String orDefaultAndCheckEmpty = StringExtKt.orDefaultAndCheckEmpty(buttonText, string);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty);
                getTvAddHome().setText(orDefaultAndCheckEmpty);
                return this;
            }
            buttonText = null;
            String string2 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
            Intrinsics.g(string2, "context.getString(R.stri…i_addhome_dialog_btn_add)");
            String orDefaultAndCheckEmpty2 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string2);
            TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2);
            getTvAddHome().setText(orDefaultAndCheckEmpty2);
            return this;
        }
        if (Intrinsics.c(language, Locale.ENGLISH.getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (en3 = miniAppMultiLanguageConfig.getEn()) != null) {
                buttonText = en3.getButtonText();
                String string22 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
                Intrinsics.g(string22, "context.getString(R.stri…i_addhome_dialog_btn_add)");
                String orDefaultAndCheckEmpty22 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string22);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty22);
                getTvAddHome().setText(orDefaultAndCheckEmpty22);
                return this;
            }
            buttonText = null;
            String string222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
            Intrinsics.g(string222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
            String orDefaultAndCheckEmpty222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string222);
            TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty222);
            getTvAddHome().setText(orDefaultAndCheckEmpty222);
            return this;
        }
        if (Intrinsics.c(language, Locale.FRANCE.getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (fr2 = miniAppMultiLanguageConfig.getFr()) != null) {
                buttonText = fr2.getButtonText();
                String string2222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
                Intrinsics.g(string2222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
                String orDefaultAndCheckEmpty2222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string2222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2222);
                getTvAddHome().setText(orDefaultAndCheckEmpty2222);
                return this;
            }
            buttonText = null;
            String string22222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
            Intrinsics.g(string22222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
            String orDefaultAndCheckEmpty22222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string22222);
            TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty22222);
            getTvAddHome().setText(orDefaultAndCheckEmpty22222);
            return this;
        }
        if (Intrinsics.c(language, new Locale("ar").getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (ar2 = miniAppMultiLanguageConfig.getAr()) != null) {
                buttonText = ar2.getButtonText();
                String string222222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
                Intrinsics.g(string222222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
                String orDefaultAndCheckEmpty222222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty222222);
                getTvAddHome().setText(orDefaultAndCheckEmpty222222);
                return this;
            }
            buttonText = null;
            String string2222222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
            Intrinsics.g(string2222222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
            String orDefaultAndCheckEmpty2222222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string2222222);
            TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2222222);
            getTvAddHome().setText(orDefaultAndCheckEmpty2222222);
            return this;
        }
        if (Intrinsics.c(language, new Locale("ru").getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (ru2 = miniAppMultiLanguageConfig.getRu()) != null) {
                buttonText = ru2.getButtonText();
                String string22222222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
                Intrinsics.g(string22222222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
                String orDefaultAndCheckEmpty22222222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string22222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty22222222);
                getTvAddHome().setText(orDefaultAndCheckEmpty22222222);
                return this;
            }
            buttonText = null;
            String string222222222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
            Intrinsics.g(string222222222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
            String orDefaultAndCheckEmpty222222222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string222222222);
            TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty222222222);
            getTvAddHome().setText(orDefaultAndCheckEmpty222222222);
            return this;
        }
        if (Intrinsics.c(language, new Locale("in").getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (id2 = miniAppMultiLanguageConfig.getId()) != null) {
                buttonText = id2.getButtonText();
                String string2222222222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
                Intrinsics.g(string2222222222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
                String orDefaultAndCheckEmpty2222222222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string2222222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2222222222);
                getTvAddHome().setText(orDefaultAndCheckEmpty2222222222);
                return this;
            }
            buttonText = null;
            String string22222222222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
            Intrinsics.g(string22222222222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
            String orDefaultAndCheckEmpty22222222222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string22222222222);
            TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty22222222222);
            getTvAddHome().setText(orDefaultAndCheckEmpty22222222222);
            return this;
        }
        if (miniAppMultiLanguageConfig != null && (en2 = miniAppMultiLanguageConfig.getEn()) != null) {
            buttonText = en2.getButtonText();
            String string222222222222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
            Intrinsics.g(string222222222222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
            String orDefaultAndCheckEmpty222222222222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string222222222222);
            TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty222222222222);
            getTvAddHome().setText(orDefaultAndCheckEmpty222222222222);
            return this;
        }
        buttonText = null;
        String string2222222222222 = getContext().getString(R.string.mini_addhome_dialog_btn_add);
        Intrinsics.g(string2222222222222, "context.getString(R.stri…i_addhome_dialog_btn_add)");
        String orDefaultAndCheckEmpty2222222222222 = StringExtKt.orDefaultAndCheckEmpty(buttonText, string2222222222222);
        TmcLogger.d(this.OooO0oO, "setAddHomeBtnInfo: " + orDefaultAndCheckEmpty2222222222222);
        getTvAddHome().setText(orDefaultAndCheckEmpty2222222222222);
        return this;
    }

    public final void OooO00o() {
        App app;
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            ActivityHelper activityHelper = getActivityHelper();
            performanceAnalyseProxy.recordForCommon((activityHelper == null || (app = activityHelper.getApp()) == null) ? null : app.getAppId(), "bottom_banner_ex", new Bundle());
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mini_view_toast_enter));
            ViewExtKt.toVisible(this);
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0oO, "toAddCustomBottomVisible error", th2);
        }
    }

    public final void OooO00o(Context context, String appId, boolean z10) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        if (z10) {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0o + "_" + appId, 0);
            return;
        }
        int OooO00o2 = OooO00o(context, appId);
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putInt(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0o + "_" + appId, OooO00o2 + 1);
    }

    public final void OooO00o(String miniappId, MiniAppAutoPopover miniAppAutoPopover, long j11) {
        Long delayDuration;
        App app;
        AppModel appModel;
        Intrinsics.h(miniappId, "miniappId");
        Context context = getContext();
        MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
        if (miniAppActivity == null) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.g(context2, "context");
        boolean OooO00o2 = OooO00o(context2, miniappId, miniAppAutoPopover);
        TmcLogger.d(this.OooO0oO, "showAddHomeBottomTips enableShowStatus->" + OooO00o2);
        if (OooO00o2) {
            if (miniAppAutoPopover != null) {
                this.OooO = miniAppAutoPopover;
                OooO0O0(miniAppAutoPopover.getConfigs());
                try {
                    ActivityHelper activityHelper = getActivityHelper();
                    String logo = (activityHelper == null || (app = activityHelper.getApp()) == null || (appModel = app.getAppModel()) == null) ? null : appModel.getLogo();
                    if (logo != null && logo.length() != 0) {
                        ((ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class)).loadImgRoundCorners(getContext(), logo, getIvMiniLogo(), SizeUtils.dp2px(6.0f));
                    }
                } catch (Throwable th2) {
                    TmcLogger.e(this.OooO0oO, th2);
                }
                OooO00o(miniAppAutoPopover.getConfigs());
                String buttonBackgroundColor = miniAppAutoPopover.getButtonBackgroundColor();
                if (buttonBackgroundColor == null) {
                    buttonBackgroundColor = "";
                }
                String buttonTextColor = miniAppAutoPopover.getButtonTextColor();
                String str = buttonTextColor != null ? buttonTextColor : "";
                try {
                    if (buttonBackgroundColor.length() > 0) {
                        Drawable background = getTvAddHome().getBackground();
                        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                        if (gradientDrawable != null) {
                            gradientDrawable.setColor(Color.parseColor(buttonBackgroundColor));
                        }
                    }
                } catch (Throwable th3) {
                    TmcLogger.e(this.OooO0oO, th3);
                }
                try {
                    if (str.length() > 0) {
                        getTvAddHome().setTextColor(Color.parseColor(str));
                    }
                } catch (Throwable th4) {
                    TmcLogger.e(this.OooO0oO, th4);
                }
            }
            PopWindowManager popWindowManager = PopWindowManager.INSTANCE;
            String miniAppPopWindowToken = miniAppActivity.getMiniAppPopWindowToken();
            if (j11 == 0) {
                j11 = (miniAppAutoPopover == null || (delayDuration = miniAppAutoPopover.getDelayDuration()) == null) ? DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT : delayDuration.longValue();
            }
            popWindowManager.addPopWindow(miniAppPopWindowToken, new PopWindowManager.PopWindowData(miniappId, j11, 1, this.OooOO0o, true));
        }
    }

    public final boolean OooO00o(Context context, String appId, MiniAppAutoPopover miniAppAutoPopover) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        if (miniAppAutoPopover != null) {
            try {
                if (!Intrinsics.c(miniAppAutoPopover.getStatus(), Boolean.FALSE)) {
                    if (!MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_ADD_HOME_CUSTOM_BOTTOM_TIP, true)) {
                        TmcLogger.d(this.OooO0oO, "checkAddHomeBottomTipIsNeedShow: bottomTipsEnable is false");
                        return false;
                    }
                    if (AppUtils.INSTANCE.queryShortcutExist(context, appId)) {
                        TmcLogger.d(this.OooO0oO, "checkAddHomeBottomTipIsNeedShow addhomeStatus is true");
                        return false;
                    }
                    long j11 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0o0 + "_" + appId);
                    long intValue = (miniAppAutoPopover.getPerXDay() != null ? r4.intValue() : 1) * 86400 * 1000;
                    int OooO00o2 = OooO00o(context, appId);
                    if (System.currentTimeMillis() - j11 > intValue) {
                        OooO00o(context, appId, true);
                    } else {
                        Integer displayFrequency = miniAppAutoPopover.getDisplayFrequency();
                        if (OooO00o2 >= (displayFrequency != null ? displayFrequency.intValue() : 1)) {
                            String str = this.OooO0oO;
                            Integer displayFrequency2 = miniAppAutoPopover.getDisplayFrequency();
                            TmcLogger.d(str, "checkAddHomeBottomTipIsNeedShow showNum is " + OooO00o2 + " >=" + (displayFrequency2 != null ? displayFrequency2.intValue() : 1));
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO0oO, "checkAddHomeTopTipIsNeedShow error", th2);
                return true;
            }
        }
        TmcLogger.d(this.OooO0oO, "checkAddHomeBottomTipIsNeedShow: bean is null or status is false");
        return false;
    }

    public final AddHomeCustomBottomTipView OooO0O0(MiniAppMultiLanguageConfig miniAppMultiLanguageConfig) {
        String language;
        MiniAppMultiLanguageModel en2;
        String title;
        MiniAppMultiLanguageModel id2;
        MiniAppMultiLanguageModel ru2;
        MiniAppMultiLanguageModel ar2;
        MiniAppMultiLanguageModel fr2;
        MiniAppMultiLanguageModel en3;
        MiniAppMultiLanguageModel zh2;
        try {
            language = Locale.getDefault().getLanguage();
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0oO, th2);
        }
        if (Intrinsics.c(language, Locale.CHINESE.getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (zh2 = miniAppMultiLanguageConfig.getZh()) != null) {
                title = zh2.getTitle();
                String string = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string, "context.getString(R.stri…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty = StringExtKt.orDefaultAndCheckEmpty(title, string);
                TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty);
                getTvContentInfo().setText(orDefaultAndCheckEmpty);
                return this;
            }
            title = null;
            String string2 = getContext().getString(R.string.mini_add_home_tips_default);
            Intrinsics.g(string2, "context.getString(R.stri…ni_add_home_tips_default)");
            String orDefaultAndCheckEmpty2 = StringExtKt.orDefaultAndCheckEmpty(title, string2);
            TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty2);
            getTvContentInfo().setText(orDefaultAndCheckEmpty2);
            return this;
        }
        if (Intrinsics.c(language, Locale.ENGLISH.getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (en3 = miniAppMultiLanguageConfig.getEn()) != null) {
                title = en3.getTitle();
                String string22 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string22, "context.getString(R.stri…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty22 = StringExtKt.orDefaultAndCheckEmpty(title, string22);
                TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty22);
                getTvContentInfo().setText(orDefaultAndCheckEmpty22);
                return this;
            }
            title = null;
            String string222 = getContext().getString(R.string.mini_add_home_tips_default);
            Intrinsics.g(string222, "context.getString(R.stri…ni_add_home_tips_default)");
            String orDefaultAndCheckEmpty222 = StringExtKt.orDefaultAndCheckEmpty(title, string222);
            TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty222);
            getTvContentInfo().setText(orDefaultAndCheckEmpty222);
            return this;
        }
        if (Intrinsics.c(language, Locale.FRANCE.getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (fr2 = miniAppMultiLanguageConfig.getFr()) != null) {
                title = fr2.getTitle();
                String string2222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string2222, "context.getString(R.stri…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty2222 = StringExtKt.orDefaultAndCheckEmpty(title, string2222);
                TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty2222);
                getTvContentInfo().setText(orDefaultAndCheckEmpty2222);
                return this;
            }
            title = null;
            String string22222 = getContext().getString(R.string.mini_add_home_tips_default);
            Intrinsics.g(string22222, "context.getString(R.stri…ni_add_home_tips_default)");
            String orDefaultAndCheckEmpty22222 = StringExtKt.orDefaultAndCheckEmpty(title, string22222);
            TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty22222);
            getTvContentInfo().setText(orDefaultAndCheckEmpty22222);
            return this;
        }
        if (Intrinsics.c(language, new Locale("ar").getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (ar2 = miniAppMultiLanguageConfig.getAr()) != null) {
                title = ar2.getTitle();
                String string222222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string222222, "context.getString(R.stri…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty222222 = StringExtKt.orDefaultAndCheckEmpty(title, string222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty222222);
                getTvContentInfo().setText(orDefaultAndCheckEmpty222222);
                return this;
            }
            title = null;
            String string2222222 = getContext().getString(R.string.mini_add_home_tips_default);
            Intrinsics.g(string2222222, "context.getString(R.stri…ni_add_home_tips_default)");
            String orDefaultAndCheckEmpty2222222 = StringExtKt.orDefaultAndCheckEmpty(title, string2222222);
            TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty2222222);
            getTvContentInfo().setText(orDefaultAndCheckEmpty2222222);
            return this;
        }
        if (Intrinsics.c(language, new Locale("ru").getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (ru2 = miniAppMultiLanguageConfig.getRu()) != null) {
                title = ru2.getTitle();
                String string22222222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string22222222, "context.getString(R.stri…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty22222222 = StringExtKt.orDefaultAndCheckEmpty(title, string22222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty22222222);
                getTvContentInfo().setText(orDefaultAndCheckEmpty22222222);
                return this;
            }
            title = null;
            String string222222222 = getContext().getString(R.string.mini_add_home_tips_default);
            Intrinsics.g(string222222222, "context.getString(R.stri…ni_add_home_tips_default)");
            String orDefaultAndCheckEmpty222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string222222222);
            TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty222222222);
            getTvContentInfo().setText(orDefaultAndCheckEmpty222222222);
            return this;
        }
        if (Intrinsics.c(language, new Locale("in").getLanguage())) {
            if (miniAppMultiLanguageConfig != null && (id2 = miniAppMultiLanguageConfig.getId()) != null) {
                title = id2.getTitle();
                String string2222222222 = getContext().getString(R.string.mini_add_home_tips_default);
                Intrinsics.g(string2222222222, "context.getString(R.stri…ni_add_home_tips_default)");
                String orDefaultAndCheckEmpty2222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string2222222222);
                TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty2222222222);
                getTvContentInfo().setText(orDefaultAndCheckEmpty2222222222);
                return this;
            }
            title = null;
            String string22222222222 = getContext().getString(R.string.mini_add_home_tips_default);
            Intrinsics.g(string22222222222, "context.getString(R.stri…ni_add_home_tips_default)");
            String orDefaultAndCheckEmpty22222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string22222222222);
            TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty22222222222);
            getTvContentInfo().setText(orDefaultAndCheckEmpty22222222222);
            return this;
        }
        if (miniAppMultiLanguageConfig != null && (en2 = miniAppMultiLanguageConfig.getEn()) != null) {
            title = en2.getTitle();
            String string222222222222 = getContext().getString(R.string.mini_add_home_tips_default);
            Intrinsics.g(string222222222222, "context.getString(R.stri…ni_add_home_tips_default)");
            String orDefaultAndCheckEmpty222222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string222222222222);
            TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty222222222222);
            getTvContentInfo().setText(orDefaultAndCheckEmpty222222222222);
            return this;
        }
        title = null;
        String string2222222222222 = getContext().getString(R.string.mini_add_home_tips_default);
        Intrinsics.g(string2222222222222, "context.getString(R.stri…ni_add_home_tips_default)");
        String orDefaultAndCheckEmpty2222222222222 = StringExtKt.orDefaultAndCheckEmpty(title, string2222222222222);
        TmcLogger.d(this.OooO0oO, "setAddHomeContentInfo: " + orDefaultAndCheckEmpty2222222222222);
        getTvContentInfo().setText(orDefaultAndCheckEmpty2222222222222);
        return this;
    }

    public final void OooO0O0(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, TmcConstants.KEY_MINIAPP_ADD_HOME_TOAST_DATA, this.OooO0o0 + "_" + appId, System.currentTimeMillis());
    }

    public final MiniAppAutoPopover getMMiniAppAutoPopover() {
        return this.OooO;
    }

    public final long getShowAddHomeBottomTipsDelayTime() {
        return this.OooOO0O;
    }

    public final boolean getShowAddHomeBottomTipsStatus() {
        return this.OooOO0;
    }

    public final void setMMiniAppAutoPopover(MiniAppAutoPopover miniAppAutoPopover) {
        this.OooO = miniAppAutoPopover;
    }

    public final void setShowAddHomeBottomTipsDelayTime(long j11) {
        this.OooOO0O = j11;
    }

    public final void setShowAddHomeBottomTipsStatus(boolean z10) {
        this.OooOO0 = z10;
    }
}
