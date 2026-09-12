package com.transsion.member.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.view.Lifecycle;
import com.bumptech.glide.Glide;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.mbridge.msdk.MBridgeConstans;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberTaskItem;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0003R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)¨\u0006-"}, d2 = {"Lcom/transsion/member/dialog/ClaimMemberDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "t0", "(Landroid/view/View;)V", "x0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", TmcConstants.NAVIGATION_ON_START, "r0", "Lcom/transsion/memberapi/MemberTaskItem;", "c", "Lcom/transsion/memberapi/MemberTaskItem;", "s0", "()Lcom/transsion/memberapi/MemberTaskItem;", "y0", "(Lcom/transsion/memberapi/MemberTaskItem;)V", "info", "", "d", "I", "getMBottomMargin", "()I", "z0", "(I)V", "mBottomMargin", "", "e", "J", "showTime", "Lkotlinx/coroutines/t1;", "f", "Lkotlinx/coroutines/t1;", "dismissJob", be.g.f16474b, "infoJob", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class ClaimMemberDialog extends BaseDialog {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private MemberTaskItem info;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mBottomMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long showTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private t1 dismissJob;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private t1 infoJob;

    public ClaimMemberDialog() {
        super(R$layout.dialog_member_claim_layout);
        this.mBottomMargin = com.blankj.utilcode.util.a0.a(50.0f);
        this.showTime = ToastStrategy.LONG_DURATION_TIMEOUT;
    }

    private final void t0(View view) {
        wm.h a11 = wm.h.a(view);
        Intrinsics.g(a11, "bind(...)");
        a11.f77881d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClaimMemberDialog.u0(ClaimMemberDialog.this, view2);
            }
        });
        a11.f77879b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClaimMemberDialog.v0(ClaimMemberDialog.this, view2);
            }
        });
        MemberTaskItem memberTaskItem = this.info;
        if (memberTaskItem != null) {
            TextView textView = a11.f77884g;
            String title = memberTaskItem.getTitle();
            if (title == null) {
                title = "";
            }
            textView.setText(title);
            TextView textView2 = a11.f77883f;
            String subTitle = memberTaskItem.getSubTitle();
            textView2.setText(subTitle != null ? subTitle : "");
            TextView textView3 = a11.f77879b;
            String buttonName = memberTaskItem.getButtonName();
            if (buttonName == null) {
                buttonName = getString(R$string.member_claim_now);
                Intrinsics.g(buttonName, "getString(...)");
            }
            textView3.setText(buttonName);
            Glide.with(requireContext()).load2(memberTaskItem.getIcon()).placeholder(R$mipmap.ic_premium_mask).error(R$mipmap.ic_premium_mask).into(a11.f77882e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ClaimMemberDialog claimMemberDialog, View view) {
        claimMemberDialog.r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(final ClaimMemberDialog claimMemberDialog, View view) {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            IMemberApi.a.b(iMemberApi, null, new Function0() { // from class: com.transsion.member.dialog.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit w02;
                    w02 = ClaimMemberDialog.w0(ClaimMemberDialog.this);
                    return w02;
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(ClaimMemberDialog claimMemberDialog) {
        claimMemberDialog.r0();
        return Unit.f67184a;
    }

    private final void x0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(true);
        }
        window.setDimAmount(0.0f);
        window.setLayout(-1, -2);
        window.setGravity(48);
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.g(attributes, "getAttributes(...)");
        attributes.flags |= 32;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.center_DialogStyle);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t1 t1Var = this.dismissJob;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        this.dismissJob = null;
        t1 t1Var2 = this.infoJob;
        if (t1Var2 != null) {
            t1.a.b(t1Var2, null, 1, null);
        }
        this.infoJob = null;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        t1 d11;
        t1 d12;
        try {
            super.onStart();
        } catch (Exception unused) {
            dismiss();
        }
        d11 = kotlinx.coroutines.k.d(androidx.view.v.a(this), y0.c(), null, new ClaimMemberDialog$onStart$1(this, null), 2, null);
        this.dismissJob = d11;
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        d12 = kotlinx.coroutines.k.d(androidx.view.v.a(this), y0.c(), null, new ClaimMemberDialog$onStart$2(iMemberApi != null ? iMemberApi.d() : null, this, null), 2, null);
        this.infoJob = d12;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        x0();
        t0(view);
    }

    public final void r0() {
        com.transsion.member.a.f46460a.a("ClaimMemberDialog lifecycle:" + getLifecycle().b());
        t1 t1Var = this.dismissJob;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        t1 t1Var2 = this.infoJob;
        if (t1Var2 != null) {
            t1.a.b(t1Var2, null, 1, null);
        }
        if (getLifecycle().b().isAtLeast(Lifecycle.State.RESUMED)) {
            try {
                dismiss();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* renamed from: s0, reason: from getter */
    public final MemberTaskItem getInfo() {
        return this.info;
    }

    public final void y0(MemberTaskItem memberTaskItem) {
        this.info = memberTaskItem;
    }

    public final void z0(int i11) {
        this.mBottomMargin = i11;
    }
}
