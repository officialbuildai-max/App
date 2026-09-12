package com.transsion.usercenter.kids;

import ak.o;
import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import be.g;
import com.bumptech.glide.Glide;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.common.Scopes;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.noober.background.view.BLConstraintLayout;
import com.therouter.TheRouter;
import com.tn.lib.dialog.BaseDialog;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.kids.KidsAccountManager;
import com.transsion.baselib.kids.KidsProfile;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.kids.AccountSwitchDialog;
import com.transsion.usercenter.kids.CreateKidsProfileDialog;
import com.transsion.usercenter.kids.PinInputDialog;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import hj.i;
import java.io.File;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-¨\u00062"}, d2 = {"Lcom/transsion/usercenter/kids/AccountSwitchDialog;", "Lcom/tn/lib/dialog/BaseDialog;", "<init>", "()V", "", "p0", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "i0", "(Landroid/view/View;)V", "t0", "v0", "s0", "", "moduleName", "r0", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", TmcConstants.NAVIGATION_ON_START, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/transsnet/loginapi/ILoginApi;", "a", "Lkotlin/Lazy;", "getMLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "pageName", "", "c", "Z", "recordDismissOnClose", "d", "isAdultSelected", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "ringAdult", "f", "ringKids", g.f16474b, "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class AccountSwitchDialog extends BaseDialog {

    /* renamed from: g */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy mLoginApi;

    /* renamed from: b */
    private String pageName;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean recordDismissOnClose;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isAdultSelected;

    /* renamed from: e, reason: from kotlin metadata */
    private FrameLayout ringAdult;

    /* renamed from: f, reason: from kotlin metadata */
    private FrameLayout ringKids;

    /* renamed from: com.transsion.usercenter.kids.AccountSwitchDialog$a */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AccountSwitchDialog b(Companion companion, boolean z10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z10 = false;
            }
            return companion.a(z10);
        }

        public final AccountSwitchDialog a(boolean z10) {
            AccountSwitchDialog accountSwitchDialog = new AccountSwitchDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean("arg_record_dismiss_on_close", z10);
            accountSwitchDialog.setArguments(bundle);
            return accountSwitchDialog;
        }
    }

    public AccountSwitchDialog() {
        super(R$layout.dialog_account_switch);
        this.mLoginApi = LazyKt.b(new Function0() { // from class: pw.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi mLoginApi_delegate$lambda$0;
                mLoginApi_delegate$lambda$0 = AccountSwitchDialog.mLoginApi_delegate$lambda$0();
                return mLoginApi_delegate$lambda$0;
            }
        });
        this.pageName = "";
        this.isAdultSelected = true;
    }

    private final ILoginApi getMLoginApi() {
        return (ILoginApi) this.mLoginApi.getValue();
    }

    private final void i0(View r18) {
        Object m1185constructorimpl;
        Unit unit;
        ImageView imageView = (ImageView) r18.findViewById(R$id.ivAdultAvatar);
        TnTextView tnTextView = (TnTextView) r18.findViewById(R$id.tvAdultName);
        ImageView imageView2 = (ImageView) r18.findViewById(R$id.ivAdultLoginArrow);
        LinearLayout linearLayout = (LinearLayout) r18.findViewById(R$id.layoutAdultAccount);
        LinearLayout linearLayout2 = (LinearLayout) r18.findViewById(R$id.layoutKidsAccount);
        ImageView imageView3 = (ImageView) r18.findViewById(R$id.ivKidsAvatar);
        TnTextView tnTextView2 = (TnTextView) r18.findViewById(R$id.tvKidsName);
        LinearLayout linearLayout3 = (LinearLayout) r18.findViewById(R$id.layoutAddKids);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) r18.findViewById(R$id.layoutAddBtn);
        View findViewById = r18.findViewById(R$id.tvManageProfiles);
        ILoginApi mLoginApi = getMLoginApi();
        UserInfo i11 = mLoginApi != null ? mLoginApi.i() : null;
        ILoginApi mLoginApi2 = getMLoginApi();
        boolean a11 = mLoginApi2 != null ? mLoginApi2.a() : false;
        final String nickname = i11 != null ? i11.getNickname() : null;
        final String avatar = i11 != null ? i11.getAvatar() : null;
        f.a aVar = f.f62005a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        f.b i12 = aVar.m(requireContext).g(avatar).i(R$drawable.ic_default_avatar);
        Intrinsics.e(imageView);
        i12.d(imageView);
        if (a11) {
            if (tnTextView != null) {
                tnTextView.setText(nickname == null ? "" : nickname);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: pw.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AccountSwitchDialog.j0(AccountSwitchDialog.this, view);
                    }
                });
            }
        } else {
            if (tnTextView != null) {
                tnTextView.setText(getString(R$string.profile_setting_log_in));
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: pw.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountSwitchDialog.k0(AccountSwitchDialog.this, view);
                }
            });
            if (tnTextView != null) {
                tnTextView.setOnClickListener(new View.OnClickListener() { // from class: pw.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AccountSwitchDialog.l0(AccountSwitchDialog.this, view);
                    }
                });
            }
        }
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: pw.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountSwitchDialog.m0(AccountSwitchDialog.this, nickname, avatar, view);
                }
            });
        }
        this.isAdultSelected = !o.f721a.i();
        v0();
        final KidsProfile f11 = KidsAccountManager.f43340a.f();
        if (f11 == null) {
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            if (bLConstraintLayout != null) {
                bLConstraintLayout.setOnClickListener(new View.OnClickListener() { // from class: pw.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AccountSwitchDialog.o0(AccountSwitchDialog.this, view);
                    }
                });
                return;
            }
            return;
        }
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        String avatarLocalPath = f11.getAvatarLocalPath();
        if (avatarLocalPath == null || avatarLocalPath.length() == 0) {
            try {
                Result.Companion companion = Result.INSTANCE;
                if (imageView3 != null) {
                    imageView3.setImageResource(R$drawable.ic_kids_avatar);
                    unit = Unit.f67184a;
                } else {
                    unit = null;
                }
                m1185constructorimpl = Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        } else {
            Intrinsics.e(Glide.with(requireContext()).load2(new File(avatarLocalPath)).into(imageView3));
        }
        if (tnTextView2 != null) {
            tnTextView2.setText(f11.getName());
        }
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: pw.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountSwitchDialog.n0(AccountSwitchDialog.this, f11, view);
            }
        });
    }

    public static final void j0(AccountSwitchDialog accountSwitchDialog, View view) {
        accountSwitchDialog.t0();
    }

    public static final void k0(AccountSwitchDialog accountSwitchDialog, View view) {
        accountSwitchDialog.t0();
    }

    public static final void l0(AccountSwitchDialog accountSwitchDialog, View view) {
        Context requireContext = accountSwitchDialog.requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        accountSwitchDialog.dismissAllowingStateLoss();
        a.C0856a.f(a.f68962a, "AccountSwitchDialog", "login adult account.", false, 4, null);
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        if (iLoginApi != null) {
            iLoginApi.j(requireContext);
        }
    }

    public static final void m0(AccountSwitchDialog accountSwitchDialog, String str, String str2, View view) {
        a.C0856a.f(a.f68962a, "AccountSwitchDialog", "enter manage profile.", false, 4, null);
        accountSwitchDialog.dismissAllowingStateLoss();
        accountSwitchDialog.r0("manage_profile");
        ManageProfilesActivity.INSTANCE.a(str, str2);
    }

    public static final ILoginApi mLoginApi_delegate$lambda$0() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    public static final void n0(AccountSwitchDialog accountSwitchDialog, KidsProfile kidsProfile, View view) {
        a.C0856a.f(a.f68962a, "AccountSwitchDialog", "switch to kids.", false, 4, null);
        if (o.f721a.i()) {
            accountSwitchDialog.dismissAllowingStateLoss();
            return;
        }
        accountSwitchDialog.isAdultSelected = false;
        accountSwitchDialog.v0();
        KidsAccountManager.f43340a.c(kidsProfile);
        accountSwitchDialog.dismissAllowingStateLoss();
        accountSwitchDialog.r0(Scopes.PROFILE);
    }

    public static final void o0(AccountSwitchDialog accountSwitchDialog, View view) {
        a.C0856a.f(a.f68962a, "AccountSwitchDialog", "start create kids account.", false, 4, null);
        FragmentActivity requireActivity = accountSwitchDialog.requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        accountSwitchDialog.dismissAllowingStateLoss();
        CreateKidsProfileDialog.Companion.b(CreateKidsProfileDialog.INSTANCE, false, false, false, 7, null).X(requireActivity, "CreateKidsProfileDialog");
    }

    private final void p0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setGravity(80);
    }

    public static final void q0(AccountSwitchDialog accountSwitchDialog, View view) {
        if (accountSwitchDialog.recordDismissOnClose) {
            KidsAccountManager.f43340a.l();
        }
        accountSwitchDialog.dismissAllowingStateLoss();
        accountSwitchDialog.r0("close");
    }

    private final void r0(String moduleName) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", "profile_select");
        hashMap.put("module_name", moduleName);
        i.f64628a.p(this.pageName, hashMap);
    }

    private final void s0() {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", "profile_select");
        i.f64628a.s(this.pageName, "dialog_show", hashMap);
    }

    private final void t0() {
        String kidsId;
        a.C0856a.f(a.f68962a, "AccountSwitchDialog", "switch to adult.", false, 4, null);
        r0(Scopes.PROFILE);
        if (!o.f721a.i()) {
            dismissAllowingStateLoss();
            return;
        }
        this.isAdultSelected = true;
        v0();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        KidsAccountManager kidsAccountManager = KidsAccountManager.f43340a;
        KidsProfile f11 = kidsAccountManager.f();
        if (f11 == null || (kidsId = f11.getKidsId()) == null) {
            return;
        }
        dismissAllowingStateLoss();
        if (kidsAccountManager.i()) {
            PinInputDialog.Companion.d(PinInputDialog.INSTANCE, kidsId, false, new Function0() { // from class: pw.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit u02;
                    u02 = AccountSwitchDialog.u0();
                    return u02;
                }
            }, 2, null).X(requireActivity, "PinInputDialog");
        } else {
            kidsAccountManager.d();
        }
    }

    public static final Unit u0() {
        KidsAccountManager.f43340a.d();
        return Unit.f67184a;
    }

    private final void v0() {
        FrameLayout frameLayout = this.ringAdult;
        if (frameLayout != null) {
            frameLayout.setSelected(this.isAdultSelected);
        }
        FrameLayout frameLayout2 = this.ringKids;
        if (frameLayout2 != null) {
            frameLayout2.setSelected(!this.isAdultSelected);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.h(context, "context");
        super.onAttach(context);
        String simpleName = requireActivity().getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        this.pageName = simpleName;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a.C0856a.f(a.f68962a, "AccountSwitchDialog", "dialog show.", false, 4, null);
        setStyle(2, 0);
        Bundle arguments = getArguments();
        this.recordDismissOnClose = arguments != null ? arguments.getBoolean("arg_record_dismiss_on_close") : false;
        s0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(R.color.transparent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r22, Bundle savedInstanceState) {
        Intrinsics.h(r22, "view");
        super.onViewCreated(r22, savedInstanceState);
        this.ringAdult = (FrameLayout) r22.findViewById(R$id.ringAdult);
        this.ringKids = (FrameLayout) r22.findViewById(R$id.ringKids);
        p0();
        i0(r22);
        ImageView imageView = (ImageView) r22.findViewById(R$id.ivClose);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: pw.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountSwitchDialog.q0(AccountSwitchDialog.this, view);
                }
            });
        }
    }
}
