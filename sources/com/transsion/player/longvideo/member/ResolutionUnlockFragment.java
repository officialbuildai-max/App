package com.transsion.player.longvideo.member;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.v;
import com.cloud.config.utils.XLogUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.memberapi.AdModule;
import com.transsion.memberapi.LotteryDisableModule;
import com.transsion.memberapi.LotteryModule;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberModule;
import com.transsion.memberapi.OrModule;
import com.transsion.memberapi.PayModule;
import com.transsion.memberapi.ThreeInOnePopup;
import com.transsion.memberapi.ThreeInOnePopupTitle;
import com.transsion.player.longvideo.R$id;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ok.b;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\u0004R\u0018\u0010$\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/transsion/player/longvideo/member/ResolutionUnlockFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lho/b;", "<init>", "()V", "", "getClassTag", "()Ljava/lang/String;", "", "dismiss", "h0", "j0", "Lcom/transsion/memberapi/MemberCheckResult;", "memberCheckResult", "k0", "(Lcom/transsion/memberapi/MemberCheckResult;)V", "n0", "o0", "r0", "p0", "l0", "Landroid/view/LayoutInflater;", "inflater", "g0", "(Landroid/view/LayoutInflater;)Lho/b;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initView", "lazyLoadData", "onDestroy", "a", "Ljava/lang/String;", "genre", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/memberapi/MemberCheckResult;", "Lgo/b;", "c", "Lgo/b;", XLogUtil.TAG, "d", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@Deprecated
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ResolutionUnlockFragment extends BaseFragment<ho.b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String genre;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MemberCheckResult memberCheckResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private go.b config;

    /* loaded from: classes6.dex */
    public static final class b implements ok.b {
        b() {
        }

        @Override // ok.b
        public void a(boolean z10) {
            b.a.a(this, z10);
        }

        @Override // ok.b
        public void onFail() {
        }

        @Override // ok.b
        public void onSuccess() {
            ResolutionUnlockFragment.this.h0();
        }
    }

    private final void dismiss() {
        getParentFragmentManager().F1("resolution_unlock_dismiss", new Bundle());
        j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = ResolutionUnlockFragment.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        Bundle bundle = new Bundle();
        go.b bVar = this.config;
        bundle.putString("config_content", bVar != null ? bVar.d() : null);
        getParentFragmentManager().F1("resolution_unlock_success", bundle);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(ResolutionUnlockFragment resolutionUnlockFragment, View view) {
        resolutionUnlockFragment.dismiss();
    }

    private final void j0() {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (isAdded()) {
                getParentFragmentManager().p().r(this).j();
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final void k0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        List<String> moduleOrder;
        String str;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (moduleOrder = threeInOnePopup.getModuleOrder()) == null) {
            return;
        }
        for (String str2 : moduleOrder) {
            switch (str2.hashCode()) {
                case -2108817340:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_PAY)) {
                        r0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case -1373222562:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_MEMBER)) {
                        p0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case -1334275730:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_LOTTERY_DISABLE)) {
                        o0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case -1141281069:
                    str = ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_UNSPECIFIED;
                    break;
                case -214437659:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_LOTTERY)) {
                        n0(memberCheckResult);
                        break;
                    } else {
                        continue;
                    }
                case 1733088487:
                    if (str2.equals(ThreeInOnePopup.THREE_IN_ONE_MODULE_TYPE_AD)) {
                        l0(memberCheckResult);
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

    private final void l0(final MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        AdModule adModule;
        final ResolutionAdView resolutionAdView;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (adModule = threeInOnePopup.getAdModule()) == null || Intrinsics.c(adModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typeAd() --> genre = " + this.genre);
        ho.b mViewBinding = getMViewBinding();
        if (mViewBinding == null || (resolutionAdView = mViewBinding.f64666b) == null) {
            return;
        }
        resolutionAdView.setListener(new b());
        resolutionAdView.setGenre(this.genre);
        resolutionAdView.setAdCallback(new Function1() { // from class: com.transsion.player.longvideo.member.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m02;
                m02 = ResolutionUnlockFragment.m0(ResolutionAdView.this, memberCheckResult, this, ((Boolean) obj).booleanValue());
                return m02;
            }
        });
        resolutionAdView.setAdModule(adModule);
        resolutionAdView.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(ResolutionAdView resolutionAdView, MemberCheckResult memberCheckResult, ResolutionUnlockFragment resolutionUnlockFragment, boolean z10) {
        OrModule orModule;
        ho.b mViewBinding;
        LinearLayout linearLayout;
        if (z10) {
            resolutionAdView.setVisibility(0);
            ThreeInOnePopup threeInOnePopup = memberCheckResult.getThreeInOnePopup();
            if (threeInOnePopup != null && (orModule = threeInOnePopup.getOrModule()) != null && !Intrinsics.c(orModule.getEnable(), Boolean.FALSE) && (mViewBinding = resolutionUnlockFragment.getMViewBinding()) != null && (linearLayout = mViewBinding.f64672h) != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            ok.c.f71157a.a(resolutionUnlockFragment.getClassTag() + " --> typeAd() --> 广告加载失败");
        }
        return Unit.f67184a;
    }

    private final void n0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        LotteryModule lotteryModule;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        String str;
        String highlightText;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (lotteryModule = threeInOnePopup.getLotteryModule()) == null || Intrinsics.c(lotteryModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typeLottery() --> 开始渲染");
        ho.b mViewBinding = getMViewBinding();
        if (mViewBinding == null || (linearLayout = mViewBinding.f64673i) == null) {
            return;
        }
        linearLayout.setVisibility(0);
        ho.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (textView2 = mViewBinding2.f64679o) != null) {
            textView2.setVisibility(0);
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
            textView2.setText(cVar.a(str, str2, Color.parseColor("#59D440")));
        }
        ho.b mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (textView = mViewBinding3.f64680p) == null) {
            return;
        }
        textView.setVisibility(0);
        ThreeInOnePopupTitle secondTitle = lotteryModule.getSecondTitle();
        textView.setText(secondTitle != null ? secondTitle.getText() : null);
    }

    private final void o0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        LotteryDisableModule lotteryDisableModule;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        String str;
        String highlightText;
        AppCompatImageView appCompatImageView;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (lotteryDisableModule = threeInOnePopup.getLotteryDisableModule()) == null || Intrinsics.c(lotteryDisableModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typeLotteryDisable() --> 开始渲染");
        ho.b mViewBinding = getMViewBinding();
        if (mViewBinding == null || (linearLayout = mViewBinding.f64674j) == null) {
            return;
        }
        linearLayout.setVisibility(0);
        ho.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f64671g) != null) {
            appCompatImageView.setVisibility(0);
            f.a aVar = ej.f.f62005a;
            Context context = appCompatImageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(lotteryDisableModule.getBannerUrl()).d(appCompatImageView);
        }
        ho.b mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (textView2 = mViewBinding3.f64681q) != null) {
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
        ho.b mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (textView = mViewBinding4.f64682r) == null) {
            return;
        }
        textView.setVisibility(0);
        ThreeInOnePopupTitle secondTitle = lotteryDisableModule.getSecondTitle();
        textView.setText(secondTitle != null ? secondTitle.getText() : null);
    }

    private final void p0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        MemberModule memberModule;
        ConstraintLayout constraintLayout;
        TextView textView;
        AppCompatImageView appCompatImageView;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (memberModule = threeInOnePopup.getMemberModule()) == null || Intrinsics.c(memberModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typeMember() --> 开始渲染");
        ho.b mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayout = mViewBinding.f64667c) == null) {
            return;
        }
        constraintLayout.setVisibility(0);
        ho.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f64670f) != null) {
            f.a aVar = ej.f.f62005a;
            Context context = appCompatImageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(memberModule.getIconUrl()).d(appCompatImageView);
        }
        ho.b mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (textView = mViewBinding3.f64678n) != null) {
            ThreeInOnePopupTitle text = memberModule.getText();
            textView.setText(text != null ? text.getText() : null);
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResolutionUnlockFragment.q0(ResolutionUnlockFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(ResolutionUnlockFragment resolutionUnlockFragment, View view) {
        kotlinx.coroutines.k.d(v.a(resolutionUnlockFragment), null, null, new ResolutionUnlockFragment$typeMember$1$1$2$1(resolutionUnlockFragment, null), 3, null);
    }

    private final void r0(MemberCheckResult memberCheckResult) {
        ThreeInOnePopup threeInOnePopup;
        final PayModule payModule;
        ConstraintLayout constraintLayout;
        TextView textView;
        TextView textView2;
        if (memberCheckResult == null || (threeInOnePopup = memberCheckResult.getThreeInOnePopup()) == null || (payModule = threeInOnePopup.getPayModule()) == null || Intrinsics.c(payModule.getEnable(), Boolean.FALSE)) {
            return;
        }
        ok.c.f71157a.a(getClassTag() + " --> typePay() --> 开始渲染");
        ho.b mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayout = mViewBinding.f64668d) == null) {
            return;
        }
        constraintLayout.setVisibility(0);
        ho.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (textView2 = mViewBinding2.f64676l) != null) {
            textView2.setText(payModule.getMoney());
        }
        ho.b mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (textView = mViewBinding3.f64675k) != null) {
            ThreeInOnePopupTitle text = payModule.getText();
            textView.setText(text != null ? text.getText() : null);
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResolutionUnlockFragment.s0(PayModule.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(PayModule payModule, ResolutionUnlockFragment resolutionUnlockFragment, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("sku_id", payModule.getSkuId());
        go.b bVar = resolutionUnlockFragment.config;
        bundle.putString("config_content", bVar != null ? bVar.d() : null);
        resolutionUnlockFragment.getParentFragmentManager().F1("resolution_pay", bundle);
        resolutionUnlockFragment.dismiss();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public ho.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        ho.b c11 = ho.b.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        k0(this.memberCheckResult);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ResolutionAdView resolutionAdView;
        super.onDestroy();
        ho.b mViewBinding = getMViewBinding();
        if (mViewBinding == null || (resolutionAdView = mViewBinding.f64666b) == null) {
            return;
        }
        resolutionAdView.onDestroy();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R$id.ivClose);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResolutionUnlockFragment.i0(ResolutionUnlockFragment.this, view2);
                }
            });
        }
    }
}
