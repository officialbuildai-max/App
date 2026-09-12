package com.transsion.usercenter.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.ViewModelLazy;
import androidx.view.v0;
import androidx.view.x0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ClientABTestDTOKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.util.networkinfo.NetworkType;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.R$string;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.laboratory.LaboratoryActivity;
import com.transsion.usercenter.profile.ProfileViewModel;
import com.transsion.usercenter.profile.bean.FissionState;
import com.transsion.usercenter.profile.bean.ProfileInfo;
import com.transsion.usercenter.setting.bean.UserSettingType;
import com.transsion.usercenter.setting.dialog.LocaleLanguageListDialog;
import com.transsion.usercenterapi.UpdateResultEvent;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import com.transsnet.downloader.dialog.DownloadConfirmDialog;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import dz.a;
import fw.h1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \u0084\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001CB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)H\u0014¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0006¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020.H\u0016¢\u0006\u0004\b1\u00100J\u000f\u00102\u001a\u00020\u0006H\u0014¢\u0006\u0004\b2\u0010\u0005J\u0017\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0014H\u0016¢\u0006\u0004\b4\u0010\u0017J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u00107J)\u0010=\u001a\u00020\u00062\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002082\b\u0010<\u001a\u0004\u0018\u00010;H\u0014¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010@\u001a\u00020\rH\u0016¢\u0006\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001b0J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u001b\u0010Z\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010SR\u0016\u0010^\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010SR\u001d\u0010c\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010W\u001a\u0004\ba\u0010bR\u001b\u0010g\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010W\u001a\u0004\be\u0010fR\u001b\u0010j\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010W\u001a\u0004\bi\u0010fR\u001b\u0010m\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010W\u001a\u0004\bl\u0010fR\u001b\u0010r\u001a\u00020n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010W\u001a\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010SR\u001b\u0010w\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010W\u001a\u0004\bv\u0010fR\u0014\u0010z\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u001b\u0010}\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010W\u001a\u0004\b|\u0010fR\u001c\u0010\u0080\u0001\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u0010W\u001a\u0004\b\u007f\u0010fR\u001e\u0010\u0083\u0001\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010W\u001a\u0005\b\u0082\u0001\u0010f¨\u0006\u0085\u0001"}, d2 = {"Lcom/transsion/usercenter/setting/SettingActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lfw/h1;", "Ldz/a;", "<init>", "()V", "", "h1", "b1", "C0", "initData", "", "size", "", "N0", "(J)Ljava/lang/String;", "r1", "q1", "showLoading", "H0", "Lcom/transsnet/loginapi/bean/UserInfo;", "userInfo", "B0", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "a1", "E0", "A0", "Lvw/b;", WebConstants.FIELD_ITEM, "t1", "(Lvw/b;)V", "Z0", "D0", "d1", "G0", "X0", "W0", "c1", "Lkotlinx/coroutines/t1;", "F0", "()Lkotlinx/coroutines/t1;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", "", "isStatusDark", "()Z", "isTranslucent", "onDestroy", "user", "onLogin", "onLogout", "V0", "()Lfw/h1;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onResume", "getPageName", "()Ljava/lang/String;", "Lcom/transsion/usercenter/setting/adapter/d;", "a", "Lcom/transsion/usercenter/setting/adapter/d;", "mAdapter", "Lcom/transsion/usercenter/setting/b0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/usercenter/setting/b0;", "mUserSettingViewModel", "", "c", "Ljava/util/List;", "mDataList", "Lck/h;", "d", "Lck/h;", "mBaseLoadingDialog", "e", "Z", "darkModeFollowSys", "Lcom/transsion/usercenter/profile/ProfileViewModel;", "f", "Lkotlin/Lazy;", "R0", "()Lcom/transsion/usercenter/profile/ProfileViewModel;", "mProfileViewModel", be.g.f16474b, "isRequestBatteryPermission", "h", "isOpenPip", "Lcom/transsnet/loginapi/ILoginApi;", "i", "P0", "()Lcom/transsnet/loginapi/ILoginApi;", "loginApi", com.mbridge.msdk.foundation.same.report.j.f35620b, "Q0", "()Lvw/b;", "logoutEntity", CampaignEx.JSON_KEY_AD_K, "U0", "userAgreement", "l", "M0", "fissionStateEntity", "Lcom/transsnet/downloader/dialog/DownloadConfirmDialog;", "m", "S0", "()Lcom/transsnet/downloader/dialog/DownloadConfirmDialog;", "mUserSettingLogoutDialog", "n", "haveBatteryPermission", "o", "L0", "familyModeItem", TtmlNode.TAG_P, "Lvw/b;", "downItem", CampaignEx.JSON_KEY_AD_Q, "K0", "autoplayItem", CampaignEx.JSON_KEY_AD_R, "T0", "pipItem", "s", "O0", "idleDataShareItem", "t", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SettingActivity extends BaseActivity<h1> implements dz.a {

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.transsion.usercenter.setting.adapter.d mAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private b0 mUserSettingViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ck.h mBaseLoadingDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean darkModeFollowSys;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mProfileViewModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isRequestBatteryPermission;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean haveBatteryPermission;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List mDataList = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isOpenPip = true;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy loginApi = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi m12;
            m12 = SettingActivity.m1();
            return m12;
        }
    });

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy logoutEntity = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vw.b n12;
            n12 = SettingActivity.n1();
            return n12;
        }
    });

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy userAgreement = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vw.b u12;
            u12 = SettingActivity.u1();
            return u12;
        }
    });

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy fissionStateEntity = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vw.b J0;
            J0 = SettingActivity.J0();
            return J0;
        }
    });

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy mUserSettingLogoutDialog = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadConfirmDialog o12;
            o12 = SettingActivity.o1(SettingActivity.this);
            return o12;
        }
    });

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy familyModeItem = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vw.b I0;
            I0 = SettingActivity.I0(SettingActivity.this);
            return I0;
        }
    });

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final vw.b downItem = new vw.b(R$string.download_in_background, UserSettingType.DOWNLOAD_SWITCH, null, Integer.valueOf(R$color.white_6), 3, null, false, false, false, false, 996, null);

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Lazy autoplayItem = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vw.b z02;
            z02 = SettingActivity.z0(SettingActivity.this);
            return z02;
        }
    });

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Lazy pipItem = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vw.b p12;
            p12 = SettingActivity.p1(SettingActivity.this);
            return p12;
        }
    });

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Lazy idleDataShareItem = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vw.b Y0;
            Y0 = SettingActivity.Y0();
            return Y0;
        }
    });

    /* renamed from: com.transsion.usercenter.setting.SettingActivity$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, FissionState fissionState) {
            Intrinsics.h(context, "context");
            Intent intent = new Intent(context, (Class<?>) SettingActivity.class);
            intent.setFlags(ASTNode.DEOP);
            intent.putExtra("fissionState", fissionState);
            context.startActivity(intent);
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57479a;

        static {
            int[] iArr = new int[UserSettingType.values().length];
            try {
                iArr[UserSettingType.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UserSettingType.ABOUT_US.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UserSettingType.PRIVACY_POLICY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UserSettingType.USER_AGREEMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UserSettingType.LOGOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UserSettingType.LANGUAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[UserSettingType.INVITATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[UserSettingType.DEBUG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[UserSettingType.NOTIFICATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[UserSettingType.FAMILY_MODE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[UserSettingType.DOWNLOAD_SWITCH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[UserSettingType.PIP_SWITCH.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[UserSettingType.AUTOPLAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[UserSettingType.WATCH_OPTION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[UserSettingType.PRIVACY_DATA_SETTING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            f57479a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57480a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57480a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57480a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f57480a.invoke(obj);
        }
    }

    public SettingActivity() {
        final Function0 function0 = null;
        this.mProfileViewModel = new ViewModelLazy(Reflection.b(ProfileViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.setting.SettingActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.setting.SettingActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<p1.a>() { // from class: com.transsion.usercenter.setting.SettingActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final p1.a invoke() {
                p1.a aVar;
                Function0 function02 = Function0.this;
                return (function02 == null || (aVar = (p1.a) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    private final void A0() {
        if (this.isRequestBatteryPermission) {
            this.isRequestBatteryPermission = false;
            boolean j11 = com.transsnet.downloader.util.d.f60047a.j(this);
            this.haveBatteryPermission = j11;
            this.downItem.p(j11);
            t1(this.downItem);
            uy.a aVar = new uy.a();
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = uy.a.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, aVar, 0L);
        }
    }

    private final void B0(UserInfo userInfo) {
        R0().k(userInfo != null ? userInfo.getUserId() : null);
    }

    private final void C0() {
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new SettingActivity$checkUpdateByUser$1(this, null), 3, null);
    }

    private final void D0() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        boolean z10 = !bVar.b().getBoolean("k_UGC_VIDEO_AUTO_PLAY", false);
        K0().p(z10);
        bVar.b().putBoolean("k_UGC_VIDEO_AUTO_PLAY", z10);
        t1(K0());
    }

    private final void E0() {
        this.isRequestBatteryPermission = true;
        if (this.haveBatteryPermission) {
            com.transsnet.downloader.util.d.f60047a.k(this);
        } else {
            com.transsnet.downloader.util.d.m(com.transsnet.downloader.util.d.f60047a, this, getPageName(), null, 4, null);
        }
    }

    private final t1 F0() {
        t1 d11;
        d11 = kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new SettingActivity$clickFamilyMode$1(this, null), 3, null);
        return d11;
    }

    private final void G0() {
        this.isOpenPip = !this.isOpenPip;
        T0().p(this.isOpenPip);
        com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("k_pip_enable", this.isOpenPip);
        t1(T0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        ck.h hVar;
        try {
            ck.h hVar2 = this.mBaseLoadingDialog;
            if (hVar2 == null || !hVar2.isShowing() || (hVar = this.mBaseLoadingDialog) == null) {
                return;
            }
            hVar.dismiss();
        } catch (Exception e11) {
            Log.e("error", "e " + e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vw.b I0(SettingActivity settingActivity) {
        return new vw.b(R$string.family_mode, UserSettingType.FAMILY_MODE, settingActivity.getString(R$string.family_mode_tips), Integer.valueOf(R$color.white_6), 3, null, false, false, false, false, 992, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vw.b J0() {
        return new vw.b(com.transsion.usercenter.R$string.user_setting_invitation_code, UserSettingType.INVITATION, null, Integer.valueOf(R$color.white_6), 0, null, false, false, false, false, 1012, null);
    }

    private final vw.b K0() {
        return (vw.b) this.autoplayItem.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final vw.b L0() {
        return (vw.b) this.familyModeItem.getValue();
    }

    private final vw.b M0() {
        return (vw.b) this.fissionStateEntity.getValue();
    }

    private final String N0(long size) {
        double d11 = size / 1024.0d;
        if (d11 < 0.0d) {
            d11 = 0.0d;
        }
        String[] strArr = {" KB", " MB", " GB"};
        for (int i11 = 0; i11 < 3; i11++) {
            String str = strArr[i11];
            if (d11 < 1024.0d) {
                return MathKt.c(d11) + str;
            }
            d11 /= 1024.0d;
        }
        return MathKt.c(d11) + " GB";
    }

    private final vw.b O0() {
        return (vw.b) this.idleDataShareItem.getValue();
    }

    private final ILoginApi P0() {
        return (ILoginApi) this.loginApi.getValue();
    }

    private final vw.b Q0() {
        return (vw.b) this.logoutEntity.getValue();
    }

    private final ProfileViewModel R0() {
        return (ProfileViewModel) this.mProfileViewModel.getValue();
    }

    private final DownloadConfirmDialog S0() {
        return (DownloadConfirmDialog) this.mUserSettingLogoutDialog.getValue();
    }

    private final vw.b T0() {
        return (vw.b) this.pipItem.getValue();
    }

    private final vw.b U0() {
        return (vw.b) this.userAgreement.getValue();
    }

    private final void W0() {
        Navigator.x(TheRouter.c("/profile/setting_privacy_data"), this, null, 2, null);
    }

    private final void X0() {
        Navigator.x(TheRouter.c("/profile/watch_option"), this, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vw.b Y0() {
        return new vw.b(com.transsion.usercenter.R$string.privacy_settings, UserSettingType.PRIVACY_DATA_SETTING, null, Integer.valueOf(R$drawable.bg_radius_bottom_6_color_white_6p), 0, null, false, false, false, false, 1012, null);
    }

    private final void Z0() {
        K0().p(com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_UGC_VIDEO_AUTO_PLAY", false));
    }

    private final void a1() {
        boolean j11 = com.transsnet.downloader.util.d.f60047a.j(this);
        this.haveBatteryPermission = j11;
        this.downItem.p(j11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b1() {
        UserInfo i11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.blankj.utilcode.util.c.h() + "-" + com.blankj.utilcode.util.c.f());
        ILoginApi P0 = P0();
        sb2.append(" | " + ((P0 == null || (i11 = P0.i()) == null) ? null : i11.getUserId()));
        sb2.append(" | " + Build.VERSION.RELEASE);
        sb2.append(" | " + Build.MODEL);
        NetworkType c11 = nh.m.f70597a.c();
        sb2.append(" | " + (c11 != null ? c11.name() : null));
        com.transsion.transfer.wifi.util.c cVar = com.transsion.transfer.wifi.util.c.f56087a;
        sb2.append(" | " + cVar.c(this));
        sb2.append(" | " + cVar.b());
        ((h1) getMViewBinding()).f62806c.setText(sb2.toString());
    }

    private final native void c1();

    private final void d1() {
        this.isOpenPip = com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_pip_enable", true);
        T0().p(this.isOpenPip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(SettingActivity settingActivity, View view) {
        ILoginApi P0 = settingActivity.P0();
        if (P0 != null) {
            P0.j(settingActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(SettingActivity settingActivity, UpdateResultEvent it) {
        Object obj;
        Intrinsics.h(it, "it");
        if (it.getHasUpdate()) {
            Iterator it2 = settingActivity.mDataList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((vw.b) obj).j() == UserSettingType.UPDATE) {
                    break;
                }
            }
            vw.b bVar = (vw.b) obj;
            if (bVar != null) {
                bVar.q(settingActivity.getString(com.transsion.usercenter.R$string.text_diff_new_version_ready));
            }
            com.transsion.usercenter.setting.adapter.d dVar = settingActivity.mAdapter;
            if (dVar != null) {
                dVar.notifyItemChanged(0);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(SettingActivity settingActivity, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = adapter.getItem(i11);
        if (item instanceof vw.b) {
            UserSettingType j11 = ((vw.b) item).j();
            switch (j11 == null ? -1 : b.f57479a[j11.ordinal()]) {
                case 1:
                    if (!nh.m.f70597a.e()) {
                        uh.b.f76876a.d(com.transsion.usercenter.R$string.base_net_err);
                        return;
                    } else {
                        settingActivity.showLoading();
                        settingActivity.C0();
                        return;
                    }
                case 2:
                    settingActivity.startActivity(new Intent(settingActivity, (Class<?>) SettingAboutUsActivity.class));
                    return;
                case 3:
                    Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", "https://h5-static.aoneroom.com/spa/html/moviebox-privacy-policy.html"), settingActivity, null, 2, null);
                    return;
                case 4:
                    Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", "https://h5-static.aoneroom.com/spa/html/moviebox-terms-of-use.html"), settingActivity, null, 2, null);
                    return;
                case 5:
                    settingActivity.r1();
                    return;
                case 6:
                    settingActivity.q1();
                    return;
                case 7:
                    Navigator.w(TheRouter.c("/fission/invitation_code").K("url", "https://h5-static.aoneroom.com/spa/html/moviebox-privacy-policy.html"), settingActivity, 4097, null, 4, null);
                    return;
                case 8:
                    settingActivity.startActivity(new Intent(settingActivity, (Class<?>) LaboratoryActivity.class));
                    return;
                case 9:
                    Navigator.x(TheRouter.c("/profile/setting_notice"), settingActivity, null, 2, null);
                    return;
                case 10:
                    settingActivity.F0();
                    return;
                case 11:
                    settingActivity.E0();
                    return;
                case 12:
                    settingActivity.G0();
                    return;
                case 13:
                    settingActivity.D0();
                    return;
                case 14:
                    settingActivity.X0();
                    return;
                case 15:
                    settingActivity.W0();
                    return;
                default:
                    return;
            }
        }
    }

    private final void h1() {
        b0 b0Var = (b0) new v0(this).a(b0.class);
        b0Var.f().j(this, new c(new Function1() { // from class: com.transsion.usercenter.setting.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i12;
                i12 = SettingActivity.i1(SettingActivity.this, (Long) obj);
                return i12;
            }
        }));
        b0Var.g().j(this, new c(new Function1() { // from class: com.transsion.usercenter.setting.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j12;
                j12 = SettingActivity.j1(SettingActivity.this, (String) obj);
                return j12;
            }
        }));
        b0Var.h().j(this, new c(new Function1() { // from class: com.transsion.usercenter.setting.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k12;
                k12 = SettingActivity.k1((Boolean) obj);
                return k12;
            }
        }));
        this.mUserSettingViewModel = b0Var;
        R0().p().j(this, new c(new Function1() { // from class: com.transsion.usercenter.setting.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l12;
                l12 = SettingActivity.l1(SettingActivity.this, (ProfileInfo) obj);
                return l12;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(SettingActivity settingActivity, Long l11) {
        vw.b bVar = (vw.b) settingActivity.mDataList.get(1);
        Intrinsics.e(l11);
        bVar.m(settingActivity.N0(l11.longValue()));
        bVar.n(false);
        com.transsion.usercenter.setting.adapter.d dVar = settingActivity.mAdapter;
        if (dVar != null) {
            dVar.notifyItemChanged(1);
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x017b, code lost:
    
        if (r1.a() == true) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void initData() {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.setting.SettingActivity.initData():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(SettingActivity settingActivity, String str) {
        settingActivity.H0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(Boolean bool) {
        uh.b.f76876a.d(com.transsion.usercenter.R$string.user_setting_clear_cache_success);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(SettingActivity settingActivity, ProfileInfo profileInfo) {
        String boundInviteCode;
        FissionState fissionState = profileInfo != null ? profileInfo.getFissionState() : null;
        ILoginApi P0 = settingActivity.P0();
        if (P0 != null && P0.a() && fissionState != null && fissionState.isNew() && (((boundInviteCode = fissionState.getBoundInviteCode()) == null || boundInviteCode.length() == 0) && settingActivity.mDataList.size() > 1 && !Intrinsics.c(settingActivity.mDataList.get(1), settingActivity.M0()))) {
            settingActivity.mDataList.add(1, settingActivity.M0());
            com.transsion.usercenter.setting.adapter.d dVar = settingActivity.mAdapter;
            if (dVar != null) {
                dVar.notifyItemInserted(1);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi m1() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vw.b n1() {
        return new vw.b(com.transsion.usercenter.R$string.logout, UserSettingType.LOGOUT, null, Integer.valueOf(R$drawable.bg_radius_bottom_6_color_white_6p), 0, null, false, false, false, false, 1012, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadConfirmDialog o1(SettingActivity settingActivity) {
        return DownloadConfirmDialog.Companion.b(DownloadConfirmDialog.INSTANCE, null, null, settingActivity.getString(com.transsion.usercenter.R$string.logout_tips), null, 11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vw.b p1(SettingActivity settingActivity) {
        return new vw.b(com.transsion.usercenter.R$string.auto_activate_miniplayer, UserSettingType.PIP_SWITCH, settingActivity.getString(com.transsion.usercenter.R$string.auto_activate_miniplayer_tips), Integer.valueOf(R$color.white_6), 3, null, false, false, false, false, 992, null);
    }

    private final void q1() {
        new LocaleLanguageListDialog().k0(this, "LocaleLanguageListDialog");
    }

    private final void r1() {
        S0().s0(new Function1() { // from class: com.transsion.usercenter.setting.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s12;
                s12 = SettingActivity.s1(SettingActivity.this, ((Boolean) obj).booleanValue());
                return s12;
            }
        });
        S0().k0(this, "LogoutDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(SettingActivity settingActivity, boolean z10) {
        ILoginApi P0;
        if (z10 && (P0 = settingActivity.P0()) != null) {
            P0.d();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading() {
        if (this.mBaseLoadingDialog == null) {
            this.mBaseLoadingDialog = new ck.h(this);
        }
        ck.h hVar = this.mBaseLoadingDialog;
        if (hVar != null) {
            hVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(vw.b item) {
        com.transsion.usercenter.setting.adapter.d dVar;
        int indexOf = this.mDataList.indexOf(item);
        if (indexOf == -1 || (dVar = this.mAdapter) == null) {
            return;
        }
        dVar.notifyItemChanged(indexOf, ClientABTestDTOKt.SWITCH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vw.b u1() {
        return new vw.b(com.transsion.usercenter.R$string.login_user_agreement, UserSettingType.USER_AGREEMENT, null, Integer.valueOf(R$drawable.bg_radius_bottom_6_color_white_6p), 0, null, false, false, false, false, 1012, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vw.b z0(SettingActivity settingActivity) {
        return new vw.b(com.transsion.usercenter.R$string.autoplay, UserSettingType.AUTOPLAY, settingActivity.getString(com.transsion.usercenter.R$string.autoplay_tips), Integer.valueOf(R$color.white_6), 3, null, false, false, false, false, 992, null);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public h1 getViewBinding() {
        h1 c11 = h1.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "setting";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initView() {
        TitleLayout toolBar = ((h1) getMViewBinding()).f62808e;
        Intrinsics.g(toolBar, "toolBar");
        jg.c.e(toolBar);
        b1();
        com.transsion.usercenter.setting.adapter.d dVar = new com.transsion.usercenter.setting.adapter.d(null, 1, null);
        dVar.w1(new p6.d() { // from class: com.transsion.usercenter.setting.i
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SettingActivity.g1(SettingActivity.this, baseQuickAdapter, view, i11);
            }
        });
        this.mAdapter = dVar;
        RecyclerView recyclerView = ((h1) getMViewBinding()).f62807d;
        recyclerView.setAdapter(this.mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((h1) getMViewBinding()).f62808e.setTitleText(com.transsion.usercenter.R$string.user_setting);
        ((h1) getMViewBinding()).f62805b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.e1(SettingActivity.this, view);
            }
        });
        Function1 function1 = new Function1() { // from class: com.transsion.usercenter.setting.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f12;
                f12 = SettingActivity.f1(SettingActivity.this, (UpdateResultEvent) obj);
                return f12;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = UpdateResultEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().q(), false, function1);
        a1();
        d1();
        c1();
        if (ak.g.f714a.b()) {
            Z0();
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return this.darkModeFollowSys && !ak.x.f733a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4097 && resultCode == -1) {
            int indexOf = this.mDataList.indexOf(M0());
            if (indexOf >= 0) {
                this.mDataList.remove(indexOf);
            }
            com.transsion.usercenter.setting.adapter.d dVar = this.mAdapter;
            if (dVar != null) {
                dVar.notifyItemRemoved(indexOf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        h1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ILoginApi P0 = P0();
        if (P0 != null) {
            P0.p(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dz.a
    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        ((h1) getMViewBinding()).f62805b.setVisibility(8);
        com.transsion.usercenter.setting.adapter.d dVar = this.mAdapter;
        if (dVar != null) {
            dVar.p(Q0());
        }
        B0(user);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dz.a
    public void onLogout() {
        ((h1) getMViewBinding()).f62805b.setVisibility(0);
        this.mDataList.remove(Q0());
        this.mDataList.remove(M0());
        com.transsion.usercenter.setting.adapter.d dVar = this.mAdapter;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
        onBackPressed();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        A0();
    }

    @Override // dz.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        a.C0761a.c(this, userInfo);
    }
}
