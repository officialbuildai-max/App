package com.cloud.tmc.miniapp.dialog;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.ext.SpannableExtKt;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.bridge.PrivacyBridge;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniutils.util.BarUtils;
import com.cloud.tmc.miniutils.util.SizeUtils;
import com.google.gson.JsonObject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.mvel2.ast.ASTNode;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class o0O0O00 extends OooO0O0.OooO00o<oo0o0Oo> {
    public final App OooO00o;
    public final BridgeCallback OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;
    public final Lazy OooO0o;
    public final Lazy OooO0o0;
    public final Lazy OooO0oO;

    /* loaded from: classes3.dex */
    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o0O0O00.this.findViewById(R.id.tv_privacy_agreement_title);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o implements OooO0O0.Oooo000 {
        public OooO00o() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = o0O0O00.this.OooO00o;
            String appId = app != null ? app.getAppId() : null;
            Bundle bundle = new Bundle();
            App app2 = o0O0O00.this.OooO00o;
            bundle.putString("miniappid", app2 != null ? app2.getAppId() : null);
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.recordForCommon(appId, "miniapp_agree_popup_ex", bundle);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 implements OooO0O0.OooOOO0 {
        public OooO0O0() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOOO0
        public void OooO00o(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            AppContext appContext;
            try {
                App app = o0O0O00.this.OooO00o;
                Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
                MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
                if (miniAppActivity != null) {
                    miniAppActivity.capsuleSetOnRightClick(true);
                }
            } catch (Throwable th2) {
                TmcLogger.e("PrivacyAgreementSimpleDialog", th2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o0O0O00.this.findViewById(R.id.tv_privacy_agree);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o0O0O00.this.findViewById(R.id.tv_privacy_agreement_please_read);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o0O0O00.this.findViewById(R.id.tv_privacy_cancel);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0O extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o0O0O00 OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooOO0O(String str, o0O0O00 o0o0o00) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o0o0o00;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            View it = (View) obj;
            Intrinsics.h(it, "it");
            WebViewActivity.Companion.launch$default(WebViewActivity.Companion, this.OooO0O0.getContext(), UrlKt.appendCommonParamUrl(TextUtils.isEmpty(this.OooO00o) ? UrlKt.AGREEMENT_URL : this.OooO00o, this.OooO0O0.getContext()), null, null, 12, null);
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOOO extends Lambda implements Function0<View> {
        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return o0O0O00.this.findViewById(R.id.view_navigetion_bar);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOOO0 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o0O0O00 OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooOOO0(String str, o0O0O00 o0o0o00) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o0o0o00;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            View it = (View) obj;
            Intrinsics.h(it, "it");
            WebViewActivity.Companion.launch$default(WebViewActivity.Companion, this.OooO0O0.getContext(), UrlKt.appendCommonParamUrl(TextUtils.isEmpty(this.OooO00o) ? UrlKt.PRIVACY_URL : this.OooO00o, this.OooO0O0.getContext()), null, null, 12, null);
            return Unit.f67184a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0O0O00(Context context, App app, BridgeCallback bridgeCallback) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO00o = app;
        this.OooO0O0 = bridgeCallback;
        this.OooO0OO = LazyKt.b(new OooO());
        this.OooO0Oo = LazyKt.b(new OooO0o());
        this.OooO0o0 = LazyKt.b(new OooOO0());
        this.OooO0o = LazyKt.b(new OooO0OO());
        this.OooO0oO = LazyKt.b(new OooOOO());
        try {
            setContentView(R.layout.mini_layout_privacy_agreement_smiple_dialog);
            setBackgroundDimEnabled(true);
            setCancelable(true);
            TextView OooO00o2 = OooO00o();
            if (OooO00o2 != null) {
                OooO00o2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o0O0O00.OooO00o(o0O0O00.this, view);
                    }
                });
            }
            TextView OooO0OO2 = OooO0OO();
            if (OooO0OO2 != null) {
                OooO0OO2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o0O0O00.OooO0O0(o0O0O00.this, view);
                    }
                });
            }
            addOnShowListener(new OooO00o());
            addOnCancelListener(new OooO0O0());
        } catch (Throwable th2) {
            TmcLogger.e("PrivacyAgreementSimpleDialog", "updateDialogLayout", th2);
        }
    }

    public static final void OooO00o(o0O0O00 this$0, View view) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Intrinsics.h(this$0, "this$0");
        App app = this$0.OooO00o;
        BridgeCallback bridgeCallback = this$0.OooO0O0;
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        try {
            try {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(app != null ? app.getAppId() : null, "privacy_click", new Bundle());
                DeviceUtil.INSTANCE.updateIsNewUserStatus("");
            } catch (Throwable th2) {
                TmcLogger.e("PrivacyAgreementSimpleDialog", th2);
            }
            if (app != null) {
                try {
                    AppContext appContext = app.getAppContext();
                    if (appContext != null && appContext.getContext() != null) {
                        PrivacyBridge.Companion.getClass();
                        concurrentHashMap = PrivacyBridge.OooO0OO;
                        if (concurrentHashMap.containsKey(app.getAppId())) {
                            concurrentHashMap2 = PrivacyBridge.OooO0OO;
                            concurrentHashMap2.remove(app.getAppId());
                            PermissionDialogPoint permissionDialogPoint = (PermissionDialogPoint) ExtensionPoint.as(PermissionDialogPoint.class).create();
                            String appId = app.getAppId();
                            Intrinsics.g(appId, "app.appId");
                            permissionDialogPoint.privacyDialogDismiss(appId, app.getStartToken());
                        }
                    }
                } catch (Throwable th3) {
                    TmcLogger.e("PrivacyAgreementSimpleDialog", "privacyDialogDismiss", th3);
                }
            }
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, "agreeClick");
                jsonObject.addProperty("clickBtn", "1");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
            if (bridgeCallback != null) {
                bridgeCallback.close();
            }
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String appId2 = app != null ? app.getAppId() : null;
            Bundle bundle = new Bundle();
            bundle.putString("miniappid", app != null ? app.getAppId() : null);
            bundle.putString("content", "1");
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.recordForCommon(appId2, "miniapp_agree_popup_click", bundle);
        } catch (Throwable th4) {
            try {
                TmcLogger.e("PrivacyAgreementSimpleDialog", "callback error", th4);
            } finally {
                this$0.dismiss();
            }
        }
    }

    public static final void OooO0O0(o0O0O00 this$0, View view) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Intrinsics.h(this$0, "this$0");
        try {
            BridgeCallback bridgeCallback = this$0.OooO0O0;
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, "cancel");
                jsonObject.addProperty("clickBtn", "2");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
            BridgeCallback bridgeCallback2 = this$0.OooO0O0;
            if (bridgeCallback2 != null) {
                bridgeCallback2.close();
            }
            try {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                App app = this$0.OooO00o;
                String appId = app != null ? app.getAppId() : null;
                Bundle bundle = new Bundle();
                App app2 = this$0.OooO00o;
                bundle.putString("miniappid", app2 != null ? app2.getAppId() : null);
                bundle.putString("content", "0");
                Unit unit = Unit.f67184a;
                performanceAnalyseProxy.recordForCommon(appId, "miniapp_agree_popup_click", bundle);
            } catch (Throwable unused) {
            }
            this$0.dismiss();
            PrivacyBridge.Companion.getClass();
            concurrentHashMap = PrivacyBridge.OooO0OO;
            App app3 = this$0.OooO00o;
            if (concurrentHashMap.containsKey(app3 != null ? app3.getAppId() : null)) {
                concurrentHashMap2 = PrivacyBridge.OooO0OO;
                App app4 = this$0.OooO00o;
                TypeIntrinsics.d(concurrentHashMap2).remove(app4 != null ? app4.getAppId() : null);
            }
        } catch (Throwable th2) {
            TmcLogger.e("PrivacyAgreementSimpleDialog", "tvPrivacyCancel error", th2);
        }
    }

    public final TextView OooO00o() {
        return (TextView) this.OooO0o.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
    
        if (r26.length() <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        r0 = OooO0OO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        r0.setText(r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
    
        if (r2 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x009e, code lost:
    
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0085, code lost:
    
        if (r1 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.cloud.tmc.miniapp.dialog.o0O0O00 OooO00o(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.dialog.o0O0O00.OooO00o(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, boolean):com.cloud.tmc.miniapp.dialog.o0O0O00");
    }

    public final void OooO00o(Window window) {
        Intrinsics.h(window, "window");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        window.clearFlags(ASTNode.NOJIT);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 512);
        window.setNavigationBarColor(0);
        Object systemService = getContext().getSystemService("uimode");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
        ((UiModeManager) systemService).getNightMode();
        Intrinsics.h(window, "window");
        if (i11 >= 26) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 16);
        }
    }

    public final void OooO00o(String str, int i11, String str2, String str3, int i12, int i13, String str4, String str5, int i14) {
        TextView OooO0O02 = OooO0O0();
        if (OooO0O02 == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(str.subSequence(0, i11));
        SpannableExtKt.appendClickable(spannableStringBuilder, (CharSequence) BidiFormatter.getInstance().unicodeWrap(str4), Integer.valueOf(getColor(R.color.mini_color_primary)), false, (Function1<? super View, Unit>) new OooOO0O(str5, this));
        try {
            spannableStringBuilder.setSpan(new StyleSpan(1), i11, str4.length() + i11, 33);
        } catch (Throwable unused) {
        }
        try {
            spannableStringBuilder.append(str.subSequence(i12 + 1, i13));
        } catch (Throwable unused2) {
        }
        SpannableExtKt.appendClickable(spannableStringBuilder, (CharSequence) BidiFormatter.getInstance().unicodeWrap(str2), Integer.valueOf(getColor(R.color.mini_color_primary)), false, (Function1<? super View, Unit>) new OooOOO0(str3, this));
        try {
            int length = (i13 + str4.length()) - 4;
            spannableStringBuilder.setSpan(new StyleSpan(1), length, str2.length() + length, 33);
        } catch (Throwable unused3) {
        }
        try {
            spannableStringBuilder.append(str.subSequence(i14 + 1, str.length()));
        } catch (Throwable unused4) {
        }
        OooO0O02.setText(new SpannedString(spannableStringBuilder));
    }

    public final TextView OooO0O0() {
        return (TextView) this.OooO0Oo.getValue();
    }

    public final TextView OooO0OO() {
        return (TextView) this.OooO0o0.getValue();
    }

    public final void OooO0Oo() {
        Window window;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                int navBarHeight = BarUtils.getNavBarHeight();
                if (navBarHeight <= 50) {
                    SizeUtils.dp2px(28.0f);
                    return;
                }
                com.cloud.tmc.miniapp.dialog.OooO0O0 dialog = getDialog();
                if (dialog == null || (window = dialog.getWindow()) == null) {
                    return;
                }
                OooO00o(window);
                View view = (View) this.OooO0oO.getValue();
                ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
                int dp2px = navBarHeight + SizeUtils.dp2px(16.0f);
                if (layoutParams != null) {
                    layoutParams.height = dp2px;
                }
                View view2 = (View) this.OooO0oO.getValue();
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e("PrivacyAgreementSimpleDialog", th2);
        }
    }
}
