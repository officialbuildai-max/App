package gx;

import android.app.Activity;
import ck.u;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.upgradesdk.bean.UpgradeInfo;
import com.transsion.upgradesdk.manager.UpgradeDialogCallback;
import com.transsion.upgradesdk.manager.UpgradeInfoCallback;
import com.transsion.upgradesdk.manager.UpgradeSdkManager;
import com.transsion.version.update.UpdateManager;
import com.transsion.version.update.e;
import com.transsion.web.api.WebConstants;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f64149a = new a();

    /* renamed from: gx.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0801a implements UpgradeInfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f64150a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f64151b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f64152c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f64153d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f64154e;

        /* renamed from: gx.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0802a implements UpgradeDialogCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f64155a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f64156b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f64157c;

            C0802a(String str, boolean z10, String str2) {
                this.f64155a = str;
                this.f64156b = z10;
                this.f64157c = str2;
            }

            @Override // com.transsion.upgradesdk.manager.UpgradeDialogCallback
            public void onDialogClick(int i11) {
                a.C0856a.l(lg.a.f68962a, "update", "ps_dialog 点击ps弹窗 " + i11, false, 4, null);
                if (i11 != 1) {
                    e.f57661a.a(this.f64155a, false, "ps");
                    return;
                }
                e eVar = e.f57661a;
                eVar.a(this.f64155a, true, "ps");
                eVar.b(MapsKt.l(TuplesKt.a(EventConstants.KEY_ACTION, "jump"), TuplesKt.a("action_result", "true"), TuplesKt.a("dialog_type", "ps"), TuplesKt.a(NativeComponentConstants.KEY_COMPONENT_TYPE, PlaceTypes.STORE), TuplesKt.a("manual", String.valueOf(this.f64156b)), TuplesKt.a(WebConstants.PAGE_FROM, this.f64155a)));
            }

            @Override // com.transsion.upgradesdk.manager.UpgradeDialogCallback
            public void onDialogDismiss() {
                a.C0856a.l(lg.a.f68962a, "update", "ps弹窗消失 onDialogDismiss", false, 4, null);
            }

            @Override // com.transsion.upgradesdk.manager.UpgradeDialogCallback
            public void onDialogShow() {
                e.d(e.f57661a, this.f64155a, this.f64156b, "ps", null, 8, null);
                if (!this.f64156b) {
                    UpdateManager.f57641f.a().h(this.f64157c);
                }
                a.C0856a.l(lg.a.f68962a, "update", "ps弹窗展示 onDialogShow", false, 4, null);
            }
        }

        C0801a(Function1 function1, Activity activity, String str, boolean z10, String str2) {
            this.f64150a = function1;
            this.f64151b = activity;
            this.f64152c = str;
            this.f64153d = z10;
            this.f64154e = str2;
        }

        @Override // com.transsion.upgradesdk.manager.UpgradeInfoCallback
        public void onRequestFail(String error) {
            Intrinsics.h(error, "error");
            a.C0856a.l(lg.a.f68962a, "update", "ps 请求失败 " + error, false, 4, null);
            Function1 function1 = this.f64150a;
            if (function1 != null) {
                function1.invoke(error);
            }
        }

        @Override // com.transsion.upgradesdk.manager.UpgradeInfoCallback
        public void onRequestSuccess(UpgradeInfo upgradeInfo) {
            Intrinsics.h(upgradeInfo, "upgradeInfo");
            a.C0856a.l(lg.a.f68962a, "update", "ps 请求成功 " + upgradeInfo.getVersionName() + " " + upgradeInfo.isNewVersion() + " " + upgradeInfo.getShowUpgradeDialog() + " " + upgradeInfo, false, 4, null);
            if (upgradeInfo.getShowUpgradeDialog()) {
                UpgradeSdkManager.DialogParams dialogParams = new UpgradeSdkManager.DialogParams(this.f64151b, true, new C0802a(this.f64152c, this.f64153d, this.f64154e));
                dialogParams.dialogStyle = 0;
                UpgradeSdkManager.getInstance().showUpgradeDialog(dialogParams);
                return;
            }
            Function1 function1 = this.f64150a;
            if (function1 != null) {
                function1.invoke("showUpgradeDialog false");
            }
        }
    }

    private a() {
    }

    public final void a(String fromPage, boolean z10, Activity activity, String configVersionName, Function1 function1) {
        Intrinsics.h(fromPage, "fromPage");
        Intrinsics.h(activity, "activity");
        Intrinsics.h(configVersionName, "configVersionName");
        if (z10 || !u.f17345a.b()) {
            UpgradeSdkManager.getInstance().checkUpgradeTask(new C0801a(function1, activity, fromPage, z10, configVersionName));
            return;
        }
        a.C0856a.l(lg.a.f68962a, "update", "ps 弹窗被拦截  " + fromPage, false, 4, null);
    }
}
