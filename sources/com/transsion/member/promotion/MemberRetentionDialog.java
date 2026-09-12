package com.transsion.member.promotion;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.timepicker.TimeModel;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.member.R$layout;
import com.transsion.memberapi.SkuPromotionContent;
import com.transsion.memberapi.SkuPromotionItem;
import com.transsion.memberapi.SkuPromotionSku;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0003¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010\u0003J\u001b\u0010'\u001a\u00020\u00002\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0%¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u00002\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0%¢\u0006\u0004\b)\u0010(J\u0017\u0010,\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/transsion/member/promotion/MemberRetentionDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "", "t0", "()Ljava/lang/String;", "Landroid/view/Window;", "window", "", "u0", "(Landroid/view/Window;)V", "z0", "y0", "s0", "v0", "", "remainingMillis", "D0", "(J)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", TmcConstants.NAVIGATION_ON_START, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "B0", "(Lkotlin/jvm/functions/Function0;)Lcom/transsion/member/promotion/MemberRetentionDialog;", "A0", "Lcom/transsion/memberapi/SkuPromotionItem;", "promotionItem", "C0", "(Lcom/transsion/memberapi/SkuPromotionItem;)Lcom/transsion/member/promotion/MemberRetentionDialog;", "Lwm/l;", "c", "Lwm/l;", "binding", "d", "Lcom/transsion/memberapi/SkuPromotionItem;", "e", "Lkotlin/jvm/functions/Function0;", "onShow", "f", "", be.g.f16474b, "Z", "hasDispatchedShow", "Landroid/os/CountDownTimer;", "h", "Landroid/os/CountDownTimer;", "countdownTimer", "i", "Ljava/lang/String;", "traceId", com.mbridge.msdk.foundation.same.report.j.f35620b, "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class MemberRetentionDialog extends BaseDialog {

    /* renamed from: k, reason: collision with root package name */
    public static final int f46713k = 8;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private wm.l binding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SkuPromotionItem promotionItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function0 onShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function0 onDismiss;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasDispatchedShow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer countdownTimer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String traceId;

    /* loaded from: classes5.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemberRetentionDialog f46721a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j11, MemberRetentionDialog memberRetentionDialog) {
            super(j11, 1000L);
            this.f46721a = memberRetentionDialog;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f46721a.countdownTimer = null;
            this.f46721a.D0(0L);
            this.f46721a.v0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            this.f46721a.D0(j11);
        }
    }

    public MemberRetentionDialog() {
        super(R$layout.dialog_member_retention);
        this.traceId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(long remainingMillis) {
        long j11 = (remainingMillis + 999) / 1000;
        long j12 = RangesKt.j(j11 / 3600, 99L);
        long j13 = (j11 % 3600) / 60;
        long j14 = j11 % 60;
        wm.l lVar = this.binding;
        if (lVar != null) {
            TextView textView = lVar.f77926h;
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j12)}, 1));
            Intrinsics.g(format, "format(...)");
            textView.setText(format);
            TextView textView2 = lVar.f77928j;
            String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j13)}, 1));
            Intrinsics.g(format2, "format(...)");
            textView2.setText(format2);
            TextView textView3 = lVar.f77932n;
            String format3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j14)}, 1));
            Intrinsics.g(format3, "format(...)");
            textView3.setText(format3);
        }
    }

    private final void s0() {
        CountDownTimer countDownTimer = this.countdownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countdownTimer = null;
    }

    private final String t0() {
        SkuPromotionSku sku;
        Integer vipLevel;
        SkuPromotionItem skuPromotionItem = this.promotionItem;
        int intValue = (skuPromotionItem == null || (sku = skuPromotionItem.getSku()) == null || (vipLevel = sku.getVipLevel()) == null) ? 0 : vipLevel.intValue();
        return intValue != 1 ? intValue != 2 ? "" : "pro_semi" : "basic_semi";
    }

    private final void u0(Window window) {
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(201326592);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT >= 29) {
            window.setStatusBarContrastEnforced(false);
            window.setNavigationBarContrastEnforced(false);
        }
        window.setLayout(-1, -1);
        window.setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        window.setAttributes(attributes);
        window.addFlags(2);
        View decorView = window.getDecorView();
        decorView.setBackground(new ColorDrawable(0));
        decorView.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = null;
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            viewGroup.setClipToPadding(false);
        }
        View findViewById = decorView.findViewById(R.id.content);
        if (findViewById != null) {
            findViewById.setBackground(new ColorDrawable(0));
            Object parent = findViewById.getParent();
            View view = parent instanceof View ? (View) parent : null;
            if (view != null) {
                view.setBackground(new ColorDrawable(0));
            }
            findViewById.setPadding(0, 0, 0, 0);
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = -1;
            } else {
                layoutParams2 = null;
            }
            findViewById.setLayoutParams(layoutParams2);
        }
        View view2 = getView();
        if (view2 != null) {
            view2.setBackground(new ColorDrawable(0));
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.height = -1;
                layoutParams = layoutParams3;
            }
            view2.setLayoutParams(layoutParams);
            view2.setPadding(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        if (!isAdded() || isRemoving()) {
            return;
        }
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(MemberRetentionDialog memberRetentionDialog, View view) {
        i.f46745a.f(memberRetentionDialog.getContext(), memberRetentionDialog.promotionItem, "membership_retention_popup", memberRetentionDialog.t0(), "membership_retention_popup", memberRetentionDialog.traceId, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(MemberRetentionDialog memberRetentionDialog, View view) {
        memberRetentionDialog.v0();
    }

    private final void y0() {
        SkuPromotionContent promotionContent;
        Integer countdownHours;
        s0();
        SkuPromotionItem skuPromotionItem = this.promotionItem;
        int f11 = (skuPromotionItem == null || (promotionContent = skuPromotionItem.getPromotionContent()) == null || (countdownHours = promotionContent.getCountdownHours()) == null) ? 12 : RangesKt.f(countdownHours.intValue(), 0);
        long a11 = m.f46755a.a();
        if (a11 <= 0) {
            D0(0L);
            return;
        }
        long g11 = RangesKt.g((a11 + (f11 * 3600000)) - System.currentTimeMillis(), 0L);
        D0(g11);
        if (g11 != 0) {
            this.countdownTimer = new b(g11, this).start();
        } else {
            a.C0856a.f(lg.a.f68962a, "premium_discount", "MemberRetentionDialog --> renderCountdown() --> 弹窗重新打开时若活动已到期，无需展示 00:00:00，直接关闭。", false, 4, null);
            v0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z0() {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.promotion.MemberRetentionDialog.z0():void");
    }

    public final MemberRetentionDialog A0(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.onDismiss = listener;
        return this;
    }

    public final MemberRetentionDialog B0(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.onShow = listener;
        return this;
    }

    public final MemberRetentionDialog C0(SkuPromotionItem promotionItem) {
        this.promotionItem = promotionItem;
        z0();
        return this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BottomDialogTheme);
        if (savedInstanceState != null) {
            v0();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            u0(window);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        s0();
        this.binding = null;
        super.onDestroyView();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        s0();
        super.onDismiss(dialog);
        Function0 function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            u0(window);
        }
        if (this.hasDispatchedShow) {
            return;
        }
        m.d(m.f46755a, this.promotionItem, 0L, 2, null);
        this.hasDispatchedShow = true;
        Function0 function0 = this.onShow;
        if (function0 != null) {
            function0.invoke();
        }
        this.traceId = ti.n.f76387a.b();
        com.transsion.baselib.helper.f fVar = com.transsion.baselib.helper.f.f43323a;
        FragmentActivity activity = getActivity();
        fVar.h(activity != null ? activity.getClass().getSimpleName() : "", "membership_retention_popup", this.traceId, "", 2);
        FragmentActivity activity2 = getActivity();
        com.transsion.baselib.helper.f.e(fVar, activity2 != null ? activity2.getClass().getSimpleName() : "", "membership_retention_popup", this.traceId, t0(), null, 16, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        wm.l a11 = wm.l.a(view);
        a11.f77931m.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.promotion.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MemberRetentionDialog.w0(MemberRetentionDialog.this, view2);
            }
        });
        a11.f77927i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.promotion.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MemberRetentionDialog.x0(MemberRetentionDialog.this, view2);
            }
        });
        this.binding = a11;
        z0();
    }
}
