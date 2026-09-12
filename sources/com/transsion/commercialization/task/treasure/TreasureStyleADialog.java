package com.transsion.commercialization.task.treasure;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.view.v;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercialization.R$layout;
import com.transsion.memberapi.AdModule;
import com.transsion.memberapi.LotteryDisableModule;
import com.transsion.memberapi.LotteryModule;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberModule;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.OrModule;
import com.transsion.memberapi.PayModule;
import com.transsion.memberapi.ThreeInOnePopup;
import com.transsion.memberapi.ThreeInOnePopupTitle;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\"\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "", "v0", "D0", "E0", "H0", "F0", "B0", "u0", "", "moduleName", "t0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroy", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/transsion/memberapi/MemberCheckResult;", "memberCheckResult", "z0", "(Lcom/transsion/memberapi/MemberCheckResult;)Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "genre", "x0", "(Ljava/lang/String;)Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "Lok/b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "y0", "(Lok/b;)Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "Lcom/transsion/memberapi/MemberSceneType;", "sceneType", "A0", "(Lcom/transsion/memberapi/MemberSceneType;)Lcom/transsion/commercialization/task/treasure/TreasureStyleADialog;", "Lkk/e;", "c", "Lkk/e;", "bind", "d", "Lcom/transsion/memberapi/MemberCheckResult;", "e", "Ljava/lang/String;", "f", "Lok/b;", be.g.f16474b, "Lcom/transsion/memberapi/MemberSceneType;", "", "h", "Z", "isDisplayed", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class TreasureStyleADialog extends BaseDialog {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private kk.e bind;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MemberCheckResult memberCheckResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String genre;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ok.b listener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private MemberSceneType sceneType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isDisplayed;

    /* loaded from: classes5.dex */
    public static final class a implements c {
        a() {
        }

        @Override // com.transsion.commercialization.task.treasure.c
        public void a() {
            ok.b bVar = TreasureStyleADialog.this.listener;
            if (bVar != null) {
                bVar.onSuccess();
            }
            TreasureStyleADialog.this.dismissAllowingStateLoss();
            TreasureStyleADialog.this.t0("typeAdInstall");
        }

        @Override // com.transsion.commercialization.task.treasure.c
        public void b() {
            TreasureStyleADialog.this.t0("typeAdChange");
        }
    }

    public TreasureStyleADialog() {
        super(R$layout.dialog_treasure_intercept_layout);
    }

    private final void B0() {
        ThreeInOnePopup threeInOnePopup;
        AdModule adModule;
        final TreasureAdView treasureAdView;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (adModule = threeInOnePopup.getAdModule()) == null || Intrinsics.c(adModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typeAd() --> 开始渲染 --> genre = " + this.genre);
        kk.e eVar = this.bind;
        if (eVar == null || (treasureAdView = eVar.f66960b) == null) {
            return;
        }
        treasureAdView.setListener(new a());
        treasureAdView.setGenre(this.genre);
        treasureAdView.setAdCallback(new Function1() { // from class: com.transsion.commercialization.task.treasure.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = TreasureStyleADialog.C0(TreasureAdView.this, this, ((Boolean) obj).booleanValue());
                return C0;
            }
        });
        treasureAdView.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(TreasureAdView treasureAdView, TreasureStyleADialog treasureStyleADialog, boolean z10) {
        ThreeInOnePopup threeInOnePopup;
        OrModule orModule;
        kk.e eVar;
        LinearLayout linearLayout;
        if (z10) {
            treasureAdView.setVisibility(0);
            MemberCheckResult memberCheckResult = treasureStyleADialog.memberCheckResult;
            if (memberCheckResult != null && (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) != null && (orModule = threeInOnePopup.getOrModule()) != null && !Intrinsics.c(orModule.getEnable(), Boolean.FALSE) && (eVar = treasureStyleADialog.bind) != null && (linearLayout = eVar.f66968j) != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            ok.c.f71157a.a(treasureStyleADialog.getClassTag() + " --> typeAd() --> 广告加载失败");
        }
        return Unit.f67184a;
    }

    private final void D0() {
        ThreeInOnePopup threeInOnePopup;
        LotteryModule lotteryModule;
        TextView textView;
        TextView textView2;
        TextView textView3;
        String str;
        String highlightText;
        ShapeableImageView shapeableImageView;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (lotteryModule = threeInOnePopup.getLotteryModule()) == null || Intrinsics.c(lotteryModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typeLottery() --> 开始渲染");
        kk.e eVar = this.bind;
        if (eVar != null && (shapeableImageView = eVar.f66966h) != null) {
            shapeableImageView.setVisibility(0);
            f.a aVar = ej.f.f62005a;
            Context context = shapeableImageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(lotteryModule.getBannerUrl()).d(shapeableImageView);
        }
        kk.e eVar2 = this.bind;
        if (eVar2 != null && (textView3 = eVar2.f66973o) != null) {
            textView3.setVisibility(0);
            ui.c cVar = ui.c.f76882a;
            ThreeInOnePopupTitle firstTitle = lotteryModule.getFirstTitle();
            String str2 = "";
            if (firstTitle == null || (str = firstTitle.getText()) == null) {
                str = "";
            }
            ThreeInOnePopupTitle firstTitle2 = lotteryModule.getFirstTitle();
            if (firstTitle2 != null && (highlightText = firstTitle2.getHighlightText()) != null) {
                str2 = highlightText;
            }
            textView3.setText(cVar.a(str, str2, Color.parseColor("#59D440")));
        }
        kk.e eVar3 = this.bind;
        if (eVar3 != null && (textView2 = eVar3.f66974p) != null) {
            textView2.setVisibility(0);
            ThreeInOnePopupTitle secondTitle = lotteryModule.getSecondTitle();
            textView2.setText(secondTitle != null ? secondTitle.getText() : null);
        }
        kk.e eVar4 = this.bind;
        if (eVar4 == null || (textView = eVar4.f66975q) == null) {
            return;
        }
        textView.setVisibility(0);
        ThreeInOnePopupTitle thirdTitle = lotteryModule.getThirdTitle();
        textView.setText(thirdTitle != null ? thirdTitle.getText() : null);
    }

    private final void E0() {
        ThreeInOnePopup threeInOnePopup;
        LotteryDisableModule lotteryDisableModule;
        TextView textView;
        TextView textView2;
        String str;
        String highlightText;
        AppCompatImageView appCompatImageView;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (lotteryDisableModule = threeInOnePopup.getLotteryDisableModule()) == null || Intrinsics.c(lotteryDisableModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typeLotteryDisable() --> 开始渲染");
        kk.e eVar = this.bind;
        if (eVar != null && (appCompatImageView = eVar.f66964f) != null) {
            appCompatImageView.setVisibility(0);
            f.a aVar = ej.f.f62005a;
            Context context = appCompatImageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(lotteryDisableModule.getBannerUrl()).d(appCompatImageView);
        }
        kk.e eVar2 = this.bind;
        if (eVar2 != null && (textView2 = eVar2.f66973o) != null) {
            textView2.setVisibility(0);
            ui.c cVar = ui.c.f76882a;
            ThreeInOnePopupTitle firstTitle = lotteryDisableModule.getFirstTitle();
            String str2 = "";
            if (firstTitle == null || (str = firstTitle.getText()) == null) {
                str = "";
            }
            ThreeInOnePopupTitle firstTitle2 = lotteryDisableModule.getFirstTitle();
            if (firstTitle2 != null && (highlightText = firstTitle2.getHighlightText()) != null) {
                str2 = highlightText;
            }
            textView2.setText(cVar.a(str, str2, Color.parseColor("#59D440")));
        }
        kk.e eVar3 = this.bind;
        if (eVar3 == null || (textView = eVar3.f66974p) == null) {
            return;
        }
        textView.setVisibility(0);
        ThreeInOnePopupTitle secondTitle = lotteryDisableModule.getSecondTitle();
        textView.setText(secondTitle != null ? secondTitle.getText() : null);
    }

    private final void F0() {
        ThreeInOnePopup threeInOnePopup;
        MemberModule memberModule;
        TextView textView;
        AppCompatImageView appCompatImageView;
        ConstraintLayout constraintLayout;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (memberModule = threeInOnePopup.getMemberModule()) == null || Intrinsics.c(memberModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typeMember() --> 开始渲染");
        kk.e eVar = this.bind;
        if (eVar != null && (constraintLayout = eVar.f66961c) != null) {
            constraintLayout.setVisibility(0);
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.treasure.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TreasureStyleADialog.G0(TreasureStyleADialog.this, view);
                }
            });
        }
        kk.e eVar2 = this.bind;
        if (eVar2 != null && (appCompatImageView = eVar2.f66965g) != null) {
            f.a aVar = ej.f.f62005a;
            Context context = appCompatImageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(memberModule.getIconUrl()).d(appCompatImageView);
        }
        kk.e eVar3 = this.bind;
        if (eVar3 == null || (textView = eVar3.f66972n) == null) {
            return;
        }
        ThreeInOnePopupTitle text = memberModule.getText();
        textView.setText(text != null ? text.getText() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(TreasureStyleADialog treasureStyleADialog, View view) {
        treasureStyleADialog.t0("typeMember");
        kotlinx.coroutines.k.d(v.a(treasureStyleADialog), null, null, new TreasureStyleADialog$typeMember$1$1$1$1(treasureStyleADialog, null), 3, null);
    }

    private final void H0() {
        ThreeInOnePopup threeInOnePopup;
        final PayModule payModule;
        ConstraintLayout constraintLayout;
        TextView textView;
        TextView textView2;
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (payModule = threeInOnePopup.getPayModule()) == null || Intrinsics.c(payModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typePay() --> 开始渲染");
        kk.e eVar = this.bind;
        if (eVar == null || (constraintLayout = eVar.f66962d) == null) {
            return;
        }
        if (eVar != null && constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        kk.e eVar2 = this.bind;
        if (eVar2 != null && (textView2 = eVar2.f66970l) != null) {
            textView2.setText(payModule.getMoney());
        }
        kk.e eVar3 = this.bind;
        if (eVar3 != null && (textView = eVar3.f66969k) != null) {
            ThreeInOnePopupTitle text = payModule.getText();
            textView.setText(text != null ? text.getText() : null);
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.treasure.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TreasureStyleADialog.I0(TreasureStyleADialog.this, payModule, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(final TreasureStyleADialog treasureStyleADialog, PayModule payModule, View view) {
        treasureStyleADialog.t0("typePay");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("activity", "lottery");
        FragmentActivity activity = treasureStyleADialog.getActivity();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (appCompatActivity != null) {
            com.transsion.payment.lib.f a11 = com.transsion.payment.lib.f.f47848b.a();
            String skuId = payModule.getSkuId();
            if (skuId == null) {
                skuId = "";
            }
            com.transsion.payment.lib.f.f(a11, appCompatActivity, skuId, null, null, false, linkedHashMap, new com.transsion.payment.lib.b() { // from class: com.transsion.commercialization.task.treasure.TreasureStyleADialog$typePay$1$1$2$1$1
                @Override // com.transsion.payment.lib.b
                public void a(Integer num, String str, boolean z10, String str2) {
                    ok.c.f71157a.a(TreasureStyleADialog.this.getClassTag() + " --> error(支付失败) --> Payment failed " + str + ", " + num);
                }

                @Override // com.transsion.payment.lib.b
                public void b(boolean z10) {
                }

                @Override // com.transsion.payment.lib.b
                public void c(int i11, String balance, String str) {
                    Intrinsics.h(balance, "balance");
                    ok.c.f71157a.a(TreasureStyleADialog.this.getClassTag() + " --> success(支付成功) --> 1.激励任务完成 -- 2. 支付成功，请求大转盘信息");
                    ok.b bVar = TreasureStyleADialog.this.listener;
                    if (bVar != null) {
                        bVar.onSuccess();
                    }
                    kotlinx.coroutines.k.d(v.a(TreasureStyleADialog.this), null, null, new TreasureStyleADialog$typePay$1$1$2$1$1$success$1(str, TreasureStyleADialog.this, null), 3, null);
                }
            }, null, 148, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(String moduleName) {
        String str;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_name", "3_in_1");
            hashMap.put("module_name", moduleName);
            MemberSceneType memberSceneType = this.sceneType;
            if (memberSceneType == null || (str = memberSceneType.getValue()) == null) {
                str = "sceneType == null";
            }
            hashMap.put(EventConstants.KEY_SOURCE, str);
            hj.i iVar = hj.i.f64628a;
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            iVar.p(simpleName, hashMap);
        }
    }

    private final void u0() {
        String str;
        if (this.isDisplayed) {
            return;
        }
        this.isDisplayed = true;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_name", "3_in_1");
            MemberSceneType memberSceneType = this.sceneType;
            if (memberSceneType == null || (str = memberSceneType.getValue()) == null) {
                str = "sceneType == null";
            }
            hashMap.put(EventConstants.KEY_SOURCE, str);
            hj.i iVar = hj.i.f64628a;
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            iVar.r(simpleName, hashMap);
        }
    }

    private final void v0() {
        ThreeInOnePopup threeInOnePopup;
        List<String> moduleOrder;
        String str;
        AppCompatImageView appCompatImageView;
        kk.e eVar = this.bind;
        if (eVar != null && (appCompatImageView = eVar.f66963e) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.treasure.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TreasureStyleADialog.w0(TreasureStyleADialog.this, view);
                }
            });
        }
        MemberCheckResult memberCheckResult = this.memberCheckResult;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (moduleOrder = threeInOnePopup.getModuleOrder()) == null) {
            return;
        }
        for (String str2 : moduleOrder) {
            switch (str2.hashCode()) {
                case -2108817340:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_PAY)) {
                        H0();
                        break;
                    } else {
                        continue;
                    }
                case -1373222562:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_MEMBER)) {
                        F0();
                        break;
                    } else {
                        continue;
                    }
                case -1334275730:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_LOTTERY_DISABLE)) {
                        E0();
                        break;
                    } else {
                        continue;
                    }
                case -1141281069:
                    str = ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_UNSPECIFIED;
                    break;
                case -214437659:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_LOTTERY)) {
                        D0();
                        break;
                    } else {
                        continue;
                    }
                case 1733088487:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_AD)) {
                        B0();
                        break;
                    } else {
                        continue;
                    }
                case 1733088935:
                    str = ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_OR;
                    break;
            }
            str2.equals(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(TreasureStyleADialog treasureStyleADialog, View view) {
        treasureStyleADialog.t0("ivClose");
        treasureStyleADialog.dismissAllowingStateLoss();
    }

    public final TreasureStyleADialog A0(MemberSceneType sceneType) {
        this.sceneType = sceneType;
        return this;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        TreasureAdView treasureAdView;
        super.onDestroy();
        kk.e eVar = this.bind;
        if (eVar == null || (treasureAdView = eVar.f66960b) == null) {
            return;
        }
        treasureAdView.onDestroy();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        u0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        this.bind = kk.e.a(view);
        v0();
    }

    public final TreasureStyleADialog x0(String genre) {
        this.genre = genre;
        return this;
    }

    public final TreasureStyleADialog y0(ok.b listener) {
        this.listener = listener;
        return this;
    }

    public final TreasureStyleADialog z0(MemberCheckResult memberCheckResult) {
        this.memberCheckResult = memberCheckResult;
        return this;
    }
}
