package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.cloud.tmc.integration.callback.LocalAuthPermissionCallback;
import com.cloud.tmc.integration.callback.LocalAuthPermissionWithNotShowAgainCallback;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.dialog.OooOo;
import com.cloud.tmc.miniapp.dialog.OooOo00;
import com.cloud.tmc.miniapp.dialog.o0OO00O;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniapp.utils.MiniDialogManager;
import com.cloud.tmc.miniutils.util.ActivityUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.cloud.tmc.miniutils.util.SizeUtils;
import com.cloud.tmc.miniutils.util.StringUtils;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes3.dex */
public final class DefaultDialogProxy implements DialogProxy {
    public static final OooO00o Companion = new OooO00o();
    public com.cloud.tmc.miniapp.dialog.OooO00o OooO00o;

    /* loaded from: classes3.dex */
    public static final class OooO implements OooOo {
        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO00o(View view) {
            Intrinsics.h(view, "view");
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO0O0(View view) {
            Intrinsics.h(view, "view");
            PermissionUtils.launchAppDetailsSettings();
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 implements OooO0O0.OooOo00 {
        public OooO0O0() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOo00
        public void onDismiss(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            com.cloud.tmc.miniapp.dialog.OooO00o addHomeDialog = DefaultDialogProxy.this.getAddHomeDialog();
            if (addHomeDialog != null) {
                addHomeDialog.OooO00o = null;
            }
            DefaultDialogProxy.this.setAddHomeDialog(null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO implements OooOo {
        public final /* synthetic */ Function0<Unit> OooO00o;
        public final /* synthetic */ Function0<Unit> OooO0O0;

        public OooO0OO(Function0<Unit> function0, Function0<Unit> function02) {
            this.OooO00o = function0;
            this.OooO0O0 = function02;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO00o(View view) {
            Intrinsics.h(view, "view");
            Function0<Unit> function0 = this.OooO00o;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO0O0(View view) {
            Unit unit;
            Intrinsics.h(view, "view");
            Function0<Unit> function0 = this.OooO0O0;
            if (function0 != null) {
                function0.invoke();
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            if (unit == null) {
                PermissionUtils.launchAppDetailsSettings();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o implements OooO0O0.Oooo000 {
        public final /* synthetic */ String OooO00o;

        public OooO0o(String str) {
            this.OooO00o = str;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            MiniDialogManager miniDialogManager = MiniDialogManager.INSTANCE;
            String str = this.OooO00o;
            if (str == null) {
                str = "";
            }
            miniDialogManager.addDialog(str, oooO0O0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 implements OooOo {
        public final /* synthetic */ Ref.BooleanRef OooO00o;

        public OooOO0(Ref.BooleanRef booleanRef) {
            this.OooO00o = booleanRef;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO00o(View view) {
            Intrinsics.h(view, "view");
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO0O0(View view) {
            Intrinsics.h(view, "view");
            this.OooO00o.element = true;
            PermissionUtils.launchAppDetailsSettings();
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0O implements OooO0O0.OooOo00 {
        public final /* synthetic */ Ref.BooleanRef OooO00o;
        public final /* synthetic */ Function0<Unit> OooO0O0;

        public OooOO0O(Ref.BooleanRef booleanRef, Function0<Unit> function0) {
            this.OooO00o = booleanRef;
            this.OooO0O0 = function0;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOo00
        public void onDismiss(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            Function0<Unit> function0;
            if (this.OooO00o.element || (function0 = this.OooO0O0) == null) {
                return;
            }
            function0.invoke();
        }
    }

    public static final void OooO00o(DefaultDialogProxy this$0, Context context, String str, String str2, String str3, String str4, LocalAuthPermissionCallback callback) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(context, "$context");
        Intrinsics.h(callback, "$callback");
        try {
            com.cloud.tmc.miniapp.dialog.OooO00o oooO00o = this$0.OooO00o;
            if (oooO00o != null) {
                oooO00o.dismiss();
                com.cloud.tmc.miniapp.dialog.OooO00o oooO00o2 = this$0.OooO00o;
                if (oooO00o2 != null) {
                    oooO00o2.OooO00o = null;
                }
                this$0.OooO00o = null;
            }
            Activity activity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (activity == null) {
                activity = ActivityUtils.getTopActivity();
            }
            Intrinsics.g(activity, "context as? MiniAppActiv…ityUtils.getTopActivity()");
            com.cloud.tmc.miniapp.dialog.OooO00o OooO00o2 = new com.cloud.tmc.miniapp.dialog.OooO00o(activity).OooO0O0(str).OooO00o(str2);
            if (str3 == null) {
                str3 = "";
            }
            try {
                OooO00o2.OooOO0O = str3;
            } catch (Throwable th2) {
                TmcLogger.e("locationType", th2);
            }
            if (str4 == null) {
                str4 = "";
            }
            try {
                OooO00o2.OooOO0o = str4;
            } catch (Throwable th3) {
                TmcLogger.e("locationType", th3);
            }
            OooO00o2.OooO00o = callback;
            com.cloud.tmc.miniapp.dialog.OooO00o addOnDismissListener = OooO00o2.addOnDismissListener(new OooO0O0());
            this$0.OooO00o = addOnDismissListener;
            if (addOnDismissListener != null) {
                addOnDismissListener.show();
            }
        } catch (Throwable th4) {
            TmcLogger.e("DefaultDialogProxy", th4);
        }
    }

    public final com.cloud.tmc.miniapp.dialog.OooO00o getAddHomeDialog() {
        return this.OooO00o;
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void hideLoadingDialog(Context context) {
        Intrinsics.h(context, "context");
        try {
            ((MiniAppActivity) context).hideLoadingDialog();
        } catch (Throwable th2) {
            TmcLogger.e("DefaultDialogProxy", th2);
        }
    }

    public final void setAddHomeDialog(com.cloud.tmc.miniapp.dialog.OooO00o oooO00o) {
        this.OooO00o = oooO00o;
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showAddHomeConfirmDialog(final Context context, final String str, final String str2, final String str3, final String str4, final LocalAuthPermissionCallback callback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(callback, "callback");
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.b
            @Override // java.lang.Runnable
            public final void run() {
                DefaultDialogProxy.OooO00o(DefaultDialogProxy.this, context, str, str2, str4, str3, callback);
            }
        });
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showCameraPermissionDialog(Context context, String str, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.h(context, "context");
        OooOo00 oooOo00 = new OooOo00(context, true);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
        String string = StringUtils.getString(R.string.mini_dialog_permission_title);
        Intrinsics.g(string, "getString(R.string.mini_dialog_permission_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{StringUtils.getString(R.string.mini_dialog_permission_camera)}, 1));
        Intrinsics.g(format, "format(format, *args)");
        OooOo00 OooO0Oo = oooOo00.OooO0Oo(format);
        String string2 = StringUtils.getString(R.string.mini_dialog_permission_content);
        Intrinsics.g(string2, "getString(R.string.mini_dialog_permission_content)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{StringUtils.getString(R.string.mini_dialog_permission_camera)}, 1));
        Intrinsics.g(format2, "format(format, *args)");
        OooO0Oo.OooO00o(format2).OooO0O0(StringUtils.getString(R.string.mini_dialog_permission_left)).OooO0O0(true).OooO0OO(StringUtils.getString(R.string.mini_dialog_permission_Right)).OooO00o(new OooO0OO(function02, function0)).addOnShowListener(new OooO0o(str)).setAnimStyle(-1).OooO00o(true).setCancelable(false).show();
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showLoadingDialog(Context context) {
        Intrinsics.h(context, "context");
        try {
            BaseActivity.showLoadingDialog$default((MiniAppActivity) context, null, 1, null);
        } catch (Throwable th2) {
            TmcLogger.e("DefaultDialogProxy", th2);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showLocationPermissionDialog(Context context) {
        Intrinsics.h(context, "context");
        OooOo00 oooOo00 = new OooOo00(context, true);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
        String string = StringUtils.getString(R.string.mini_dialog_permission_title);
        Intrinsics.g(string, "getString(R.string.mini_dialog_permission_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{StringUtils.getString(R.string.mini_dialog_permission_location)}, 1));
        Intrinsics.g(format, "format(format, *args)");
        OooOo00 OooO0Oo = oooOo00.OooO0Oo(format);
        String string2 = StringUtils.getString(R.string.mini_dialog_permission_content);
        Intrinsics.g(string2, "getString(R.string.mini_dialog_permission_content)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{StringUtils.getString(R.string.mini_dialog_permission_location)}, 1));
        Intrinsics.g(format2, "format(format, *args)");
        OooO0Oo.OooO00o(format2).OooO0O0(StringUtils.getString(R.string.mini_dialog_permission_left)).OooO0O0(true).OooO0OO(StringUtils.getString(R.string.mini_dialog_permission_Right)).OooO00o(new OooO()).setAnimStyle(-1).OooO00o(true).setCanceledOnTouchOutside(true).show();
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showPermissionDialog(Context context, String scopeName, String dialogContent, String appTitle, String appIconUrl, LocalAuthPermissionWithNotShowAgainCallback callback) {
        Group group;
        Intrinsics.h(context, "context");
        Intrinsics.h(scopeName, "scope");
        Intrinsics.h(dialogContent, "dialogContent");
        Intrinsics.h(appTitle, "appTitle");
        Intrinsics.h(appIconUrl, "appIconUrl");
        Intrinsics.h(callback, "callback");
        Activity topActivity = ActivityUtils.getTopActivity();
        Intrinsics.g(topActivity, "getTopActivity()");
        o0OO00O o0oo00o = new o0OO00O(topActivity);
        TextView textView = (TextView) o0oo00o.OooO0Oo.getValue();
        if (textView != null) {
            textView.setText(appTitle);
        }
        TextView textView2 = (TextView) o0oo00o.OooO0o.getValue();
        if (textView2 != null) {
            textView2.setText(dialogContent);
        }
        if (appIconUrl != null) {
            try {
                AppCompatImageView appCompatImageView = (AppCompatImageView) o0oo00o.OooO0O0.getValue();
                if (appCompatImageView != null) {
                    ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
                    Context context2 = o0oo00o.getContext();
                    int dp2px = SizeUtils.dp2px(4.0f);
                    int i11 = R.drawable.drawable_app_icon_place_holder;
                    imageLoaderProxy.loadImgRoundCorners(context2, appIconUrl, appCompatImageView, dp2px, i11, i11);
                }
            } catch (Throwable th2) {
                TmcLogger.e("PermissionDialog", th2);
            }
        }
        Intrinsics.h(scopeName, "scopeName");
        try {
            if (Intrinsics.c(scopeName, "notifyMessage") && (group = (Group) o0oo00o.OooO0oo.getValue()) != null) {
                group.setVisibility(0);
            }
        } catch (Throwable th3) {
            TmcLogger.e(o0oo00o.OooOO0o, th3);
        }
        o0oo00o.OooO00o = callback;
        o0oo00o.show();
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showStoragePermissionDialog(Context context, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.h(context, "context");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        OooOo00 oooOo00 = new OooOo00(context, true);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
        String string = StringUtils.getString(R.string.mini_dialog_permission_title);
        Intrinsics.g(string, "getString(R.string.mini_dialog_permission_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{StringUtils.getString(R.string.mini_dialog_permission_storage)}, 1));
        Intrinsics.g(format, "format(format, *args)");
        OooOo00 OooO0Oo = oooOo00.OooO0Oo(format);
        String string2 = StringUtils.getString(R.string.mini_dialog_permission_content);
        Intrinsics.g(string2, "getString(R.string.mini_dialog_permission_content)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{StringUtils.getString(R.string.mini_dialog_permission_storage)}, 1));
        Intrinsics.g(format2, "format(format, *args)");
        OooO0Oo.OooO00o(format2).OooO0O0(StringUtils.getString(R.string.mini_dialog_permission_left)).OooO0O0(true).OooO0OO(StringUtils.getString(R.string.mini_dialog_permission_Right)).OooO00o(new OooOO0(booleanRef)).addOnDismissListener(new OooOO0O(booleanRef, function02)).setAnimStyle(-1).OooO00o(true).setCanceledOnTouchOutside(true).show();
    }
}
