package com.transsion.member.promotion;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.TouchDelegate;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.timepicker.TimeModel;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.member.R$drawable;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.memberapi.SkuPromotionContent;
import com.transsion.memberapi.SkuPromotionHighlight;
import com.transsion.memberapi.SkuPromotionItem;
import com.transsion.memberapi.SkuPromotionSku;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0019\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0003J\u001b\u0010*\u001a\u00020\u00002\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070(¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u00020\u00002\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070(¢\u0006\u0004\b,\u0010+J\u001b\u0010-\u001a\u00020\u00002\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070(¢\u0006\u0004\b-\u0010+J\u0017\u00100\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010=R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010=R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/transsion/member/promotion/MemberPromotionDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "", "y0", "()Ljava/lang/String;", "", "N0", "G0", "I0", "Landroid/view/View;", "closeButton", "A0", "(Landroid/view/View;)V", "x0", "z0", "", "remainingMillis", "P0", "(J)V", "Landroidx/appcompat/widget/AppCompatImageView;", "iconView", "iconUrl", "w0", "(Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/String;)V", "O0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", TmcConstants.NAVIGATION_ON_START, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "K0", "(Lkotlin/jvm/functions/Function0;)Lcom/transsion/member/promotion/MemberPromotionDialog;", "L0", "J0", "Lcom/transsion/memberapi/SkuPromotionItem;", "promotionItem", "M0", "(Lcom/transsion/memberapi/SkuPromotionItem;)Lcom/transsion/member/promotion/MemberPromotionDialog;", "Lwm/k;", "c", "Lwm/k;", "binding", "d", "Lcom/transsion/memberapi/SkuPromotionItem;", "", "e", "I", "benefitTextColor", "f", "Lkotlin/jvm/functions/Function0;", "onRenew", be.g.f16474b, "onShow", "h", "", "i", "Z", "hasRecordedShown", "Landroid/os/CountDownTimer;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Landroid/os/CountDownTimer;", "countdownTimer", CampaignEx.JSON_KEY_AD_K, "Ljava/lang/String;", "traceId", "l", "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class MemberPromotionDialog extends BaseDialog {

    /* renamed from: m, reason: collision with root package name */
    public static final int f46701m = 8;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private wm.k binding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SkuPromotionItem promotionItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int benefitTextColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function0 onRenew;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Function0 onShow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function0 onDismiss;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasRecordedShown;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer countdownTimer;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String traceId;

    /* loaded from: classes5.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemberPromotionDialog f46711a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j11, MemberPromotionDialog memberPromotionDialog) {
            super(j11, 1000L);
            this.f46711a = memberPromotionDialog;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f46711a.countdownTimer = null;
            this.f46711a.P0(0L);
            this.f46711a.z0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            this.f46711a.P0(j11);
        }
    }

    public MemberPromotionDialog() {
        super(R$layout.dialog_member_promotion);
        this.benefitTextColor = Color.parseColor("#2D3273");
        this.traceId = "";
    }

    private final void A0(final View closeButton) {
        closeButton.post(new Runnable() { // from class: com.transsion.member.promotion.e
            @Override // java.lang.Runnable
            public final void run() {
                MemberPromotionDialog.B0(MemberPromotionDialog.this, closeButton);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(MemberPromotionDialog memberPromotionDialog, View view) {
        if (!memberPromotionDialog.isAdded() || memberPromotionDialog.isDetached() || memberPromotionDialog.isRemoving()) {
            return;
        }
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 == null) {
            return;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        int i11 = -((int) (memberPromotionDialog.getResources().getDisplayMetrics().density * 12.0f));
        rect.inset(i11, i11);
        view2.setTouchDelegate(new TouchDelegate(rect, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(final MemberPromotionDialog memberPromotionDialog, View view) {
        i.f46745a.f(memberPromotionDialog.getContext(), memberPromotionDialog.promotionItem, "membership_offer_popup", memberPromotionDialog.y0(), "membership_offer_popup", memberPromotionDialog.traceId, new Function0() { // from class: com.transsion.member.promotion.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit D0;
                D0 = MemberPromotionDialog.D0(MemberPromotionDialog.this);
                return D0;
            }
        }, new Function0() { // from class: com.transsion.member.promotion.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit E0;
                E0 = MemberPromotionDialog.E0();
                return E0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(MemberPromotionDialog memberPromotionDialog) {
        memberPromotionDialog.z0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(MemberPromotionDialog memberPromotionDialog, View view) {
        memberPromotionDialog.z0();
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x02a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void G0() {
        /*
            Method dump skipped, instructions count: 707
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.promotion.MemberPromotionDialog.G0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H0(SkuPromotionHighlight it) {
        Intrinsics.h(it, "it");
        String description = it.getDescription();
        return !(description == null || StringsKt.q0(description));
    }

    private final void I0() {
        SkuPromotionContent promotionContent;
        Integer countdownHours;
        x0();
        SkuPromotionItem skuPromotionItem = this.promotionItem;
        int f11 = (skuPromotionItem == null || (promotionContent = skuPromotionItem.getPromotionContent()) == null || (countdownHours = promotionContent.getCountdownHours()) == null) ? 12 : RangesKt.f(countdownHours.intValue(), 0);
        long a11 = m.f46755a.a();
        if (a11 <= 0) {
            P0(0L);
            return;
        }
        long g11 = RangesKt.g((a11 + (f11 * 3600000)) - System.currentTimeMillis(), 0L);
        P0(g11);
        if (g11 <= 0) {
            z0();
        } else {
            this.countdownTimer = new b(g11, this).start();
        }
    }

    private final void N0() {
        SkuPromotionSku sku;
        Integer vipLevel;
        SkuPromotionItem skuPromotionItem = this.promotionItem;
        String str = (skuPromotionItem == null || (sku = skuPromotionItem.getSku()) == null || (vipLevel = sku.getVipLevel()) == null || vipLevel.intValue() != 2) ? "basic" : "pro";
        wm.k kVar = this.binding;
        if (kVar != null) {
            if (Intrinsics.c(str, "basic")) {
                kVar.f77904h.setBackgroundResource(R$drawable.member_discount_16_16_0_0_1);
                kVar.f77909m.setTextColor(Color.parseColor("#BCCAFF"));
                kVar.f77914r.setTextColor(Color.parseColor("#BCCAFF"));
                kVar.f77901e.setImageResource(R$drawable.member_discount_icon_1);
                this.benefitTextColor = Color.parseColor("#2D3273");
                kVar.f77898b.setBackgroundResource(R$drawable.member_discount_16_16_16_16_bg1);
                kVar.f77907k.setBackgroundResource(R$drawable.member_discount_vector_1);
                kVar.f77902f.setBackgroundResource(R$drawable.member_discount_equities_bg_1);
                kVar.f77906j.setGradientColors(Color.parseColor("#F1F4FF"), Color.parseColor("#F1F4FF"), Color.parseColor("#C1CDFF"));
                kVar.f77915s.setTextColor(Color.parseColor("#BCCAFF"));
                kVar.f77905i.setTextColor(Color.parseColor("#BCCAFF"));
                kVar.f77917u.setTextColor(Color.parseColor("#BCCAFF"));
                kVar.f77908l.setTextColor(Color.parseColor("#2D3273"));
                kVar.f77911o.setTextColor(Color.parseColor("#2D3273"));
                kVar.f77910n.setTextColor(Color.parseColor("#2D3273"));
                kVar.f77913q.setTextColor(Color.parseColor("#2D3273"));
                kVar.f77912p.setTextColor(Color.parseColor("#2D3273"));
                kVar.f77918v.setTextColor(Color.parseColor("#2D3273"));
                kVar.f77911o.setBackgroundResource(R$drawable.bg_member_retention_countdown_basic);
                kVar.f77913q.setBackgroundResource(R$drawable.bg_member_retention_countdown_basic);
                kVar.f77918v.setBackgroundResource(R$drawable.bg_member_retention_countdown_basic);
                kVar.f77916t.setBackgroundResource(R$drawable.member_discount_bg_pay_now_1);
            } else if (Intrinsics.c(str, "pro")) {
                kVar.f77904h.setBackgroundResource(R$drawable.member_discount_16_16_0_0_2);
                kVar.f77909m.setTextColor(Color.parseColor("#FFEBB1"));
                kVar.f77914r.setTextColor(Color.parseColor("#FFEBB1"));
                kVar.f77901e.setImageResource(R$drawable.member_discount_icon_2);
                this.benefitTextColor = Color.parseColor("#53301B");
                kVar.f77898b.setBackgroundResource(R$drawable.member_discount_16_16_16_16_bg2);
                kVar.f77907k.setBackgroundResource(R$drawable.bg_member_retention_discount);
                kVar.f77902f.setBackgroundResource(R$drawable.member_discount_equities_bg_2);
                kVar.f77906j.setGradientColors(Color.parseColor("#FFF7E0"), Color.parseColor("#FFF7E0"), Color.parseColor("#FFEAAD"));
                kVar.f77915s.setTextColor(Color.parseColor("#FFF2CB"));
                kVar.f77905i.setTextColor(Color.parseColor("#FFF2CB"));
                kVar.f77917u.setTextColor(Color.parseColor("#FFF2CB"));
                kVar.f77908l.setTextColor(Color.parseColor("#53301B"));
                kVar.f77911o.setTextColor(Color.parseColor("#53301B"));
                kVar.f77910n.setTextColor(Color.parseColor("#53301B"));
                kVar.f77913q.setTextColor(Color.parseColor("#53301B"));
                kVar.f77912p.setTextColor(Color.parseColor("#53301B"));
                kVar.f77918v.setTextColor(Color.parseColor("#53301B"));
                kVar.f77911o.setBackgroundResource(R$drawable.bg_member_retention_countdown_pro);
                kVar.f77913q.setBackgroundResource(R$drawable.bg_member_retention_countdown_pro);
                kVar.f77918v.setBackgroundResource(R$drawable.bg_member_retention_countdown_pro);
                kVar.f77916t.setBackgroundResource(R$drawable.member_discount_bg_pay_now_2);
            }
        }
        O0();
    }

    private final void O0() {
        LinearLayout linearLayout;
        wm.k kVar = this.binding;
        if (kVar == null || (linearLayout = kVar.f77899c) == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) linearLayout.getChildAt(i11).findViewById(R$id.tvBenefitTitle);
            if (appCompatTextView != null) {
                appCompatTextView.setTextColor(this.benefitTextColor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(long remainingMillis) {
        long j11 = (remainingMillis + 999) / 1000;
        long j12 = RangesKt.j(j11 / 3600, 99L);
        long j13 = (j11 % 3600) / 60;
        long j14 = j11 % 60;
        wm.k kVar = this.binding;
        if (kVar != null) {
            TextView textView = kVar.f77911o;
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j12)}, 1));
            Intrinsics.g(format, "format(...)");
            textView.setText(format);
            TextView textView2 = kVar.f77913q;
            String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j13)}, 1));
            Intrinsics.g(format2, "format(...)");
            textView2.setText(format2);
            TextView textView3 = kVar.f77918v;
            String format3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j14)}, 1));
            Intrinsics.g(format3, "format(...)");
            textView3.setText(format3);
        }
    }

    private final void w0(AppCompatImageView iconView, String iconUrl) {
        SkuPromotionSku sku;
        Integer vipLevel;
        if (iconUrl == null || StringsKt.q0(iconUrl)) {
            iconView.setVisibility(8);
            return;
        }
        iconView.setVisibility(0);
        SkuPromotionItem skuPromotionItem = this.promotionItem;
        androidx.core.widget.i.c(iconView, ColorStateList.valueOf(Color.parseColor((skuPromotionItem == null || (sku = skuPromotionItem.getSku()) == null || (vipLevel = sku.getVipLevel()) == null || vipLevel.intValue() != 1) ? "#76492B" : "#464B7E")));
        Glide.with(iconView).load2(iconUrl).into(iconView);
    }

    private final void x0() {
        CountDownTimer countDownTimer = this.countdownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countdownTimer = null;
    }

    private final String y0() {
        SkuPromotionSku sku;
        Integer vipLevel;
        SkuPromotionItem skuPromotionItem = this.promotionItem;
        int intValue = (skuPromotionItem == null || (sku = skuPromotionItem.getSku()) == null || (vipLevel = sku.getVipLevel()) == null) ? 0 : vipLevel.intValue();
        return intValue != 1 ? intValue != 2 ? "" : "pro_semi" : "basic_semi";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0() {
        if (!isAdded() || isRemoving()) {
            return;
        }
        dismissAllowingStateLoss();
    }

    public final MemberPromotionDialog J0(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.onDismiss = listener;
        return this;
    }

    public final MemberPromotionDialog K0(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.onRenew = listener;
        return this;
    }

    public final MemberPromotionDialog L0(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.onShow = listener;
        return this;
    }

    public final MemberPromotionDialog M0(SkuPromotionItem promotionItem) {
        this.promotionItem = promotionItem;
        if (this.binding != null) {
            N0();
            G0();
        }
        return this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.center_DialogStyle);
        if (savedInstanceState != null) {
            z0();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        x0();
        this.binding = null;
        super.onDestroyView();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        x0();
        super.onDismiss(dialog);
        Function0 function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hasRecordedShown) {
            return;
        }
        m.d(m.f46755a, this.promotionItem, 0L, 2, null);
        g.e(g.f46739a, 0L, 1, null);
        this.hasRecordedShown = true;
        I0();
        Function0 function0 = this.onShow;
        if (function0 != null) {
            function0.invoke();
        }
        this.traceId = ti.n.f76387a.b();
        com.transsion.baselib.helper.f fVar = com.transsion.baselib.helper.f.f43323a;
        FragmentActivity activity = getActivity();
        fVar.h(activity != null ? activity.getClass().getSimpleName() : "", "membership_offer_popup", this.traceId, "", 2);
        FragmentActivity activity2 = getActivity();
        com.transsion.baselib.helper.f.e(fVar, activity2 != null ? activity2.getClass().getSimpleName() : "", "membership_offer_popup", this.traceId, y0(), null, 16, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCancelable(false);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCanceledOnTouchOutside(false);
        }
        wm.k a11 = wm.k.a(view);
        a11.f77916t.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.promotion.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MemberPromotionDialog.C0(MemberPromotionDialog.this, view2);
            }
        });
        a11.f77900d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.promotion.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MemberPromotionDialog.F0(MemberPromotionDialog.this, view2);
            }
        });
        AppCompatImageView ivClose = a11.f77900d;
        Intrinsics.g(ivClose, "ivClose");
        A0(ivClose);
        this.binding = a11;
        N0();
        G0();
    }
}
