package com.transsion.member;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.android.material.imageview.ShapeableImageView;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.member.premium.PremiumContentController;
import com.transsion.member.view.PremiumContentView;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.MembershipDetailType;
import com.transsion.memberapi.PointInfo;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.RewardsCenterData;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import dz.a;
import ej.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \u0080\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001HB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0007J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0007J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0007J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u0007J\u001f\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010\u0007J\u0011\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\nH\u0016¢\u0006\u0004\b.\u0010\u001bJ\u000f\u0010/\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u0010\u0007J\u0019\u00102\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\bH\u0016¢\u0006\u0004\b4\u0010\u0007J\u000f\u00105\u001a\u00020\bH\u0016¢\u0006\u0004\b5\u0010\u0007J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\nH\u0016¢\u0006\u0004\b7\u0010\rJ\r\u00108\u001a\u00020\b¢\u0006\u0004\b8\u0010\u0007J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u0010\u0011J\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010\u0007J\u0017\u0010<\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000eH\u0016¢\u0006\u0004\b<\u0010\u0011J\u0015\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u001d¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\bH\u0016¢\u0006\u0004\b@\u0010\u0007J\u000f\u0010A\u001a\u00020\bH\u0016¢\u0006\u0004\bA\u0010\u0007J\u0019\u0010D\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\bH\u0016¢\u0006\u0004\bF\u0010\u0007J\u000f\u0010G\u001a\u00020\bH\u0016¢\u0006\u0004\bG\u0010\u0007R$\u0010M\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010LR$\u0010Q\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010I\u001a\u0004\bO\u0010)\"\u0004\bP\u0010LR$\u0010U\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010I\u001a\u0004\bS\u0010)\"\u0004\bT\u0010LR$\u0010Y\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010I\u001a\u0004\bW\u0010)\"\u0004\bX\u0010LR\u0016\u0010[\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010IR\u0018\u0010^\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u001b\u0010f\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001e\u0010k\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001d\u0010p\u001a\u0004\u0018\u00010l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010c\u001a\u0004\bn\u0010oR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010w\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010y\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010IR\u0016\u0010{\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010vR\u0016\u0010}\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010vR\u0016\u0010\u007f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010v¨\u0006\u0081\u0001"}, d2 = {"Lcom/transsion/member/MemberPremiumFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lwm/o;", "Landroid/view/View$OnClickListener;", "Ldz/a;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", "", "G0", "", "expanded", "O0", "(Z)V", "Lcom/transsnet/loginapi/bean/UserInfo;", "userInfo", "Q0", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "Lcom/transsion/memberapi/MemberDetail;", "memberDetail", "I0", "(Lcom/transsion/memberapi/MemberDetail;)V", "S0", "H0", "y0", "v0", "E0", "()Z", "t0", "", TtmlNode.ATTR_TTS_COLOR, "", "fraction", "s0", "(IF)I", "Landroid/view/LayoutInflater;", "inflater", "x0", "(Landroid/view/LayoutInflater;)Lwm/o;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "isShowPageStateLayoutTitle", "initViewModel", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "onResume", "hidden", "onHiddenChanged", "u0", "user", "onLogin", "onLogout", "onUpdateUserInfo", "points", "N0", "(I)V", "initListener", "retryLoadData", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "logResume", "onDestroy", "a", "Ljava/lang/String;", "getSource", "K0", "(Ljava/lang/String;)V", EventConstants.KEY_SOURCE, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getSceneId", "J0", "sceneId", "c", "getTraceId", "M0", "traceId", "d", "getSubjectId", "L0", "subjectId", "e", "orderId", "f", "Lcom/transsnet/loginapi/bean/UserInfo;", "mUserInfo", be.g.f16474b, "Lcom/transsion/memberapi/MemberDetail;", "Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "h", "Lkotlin/Lazy;", "w0", "()Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "mLoadingDialog", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "i", "Landroidx/activity/result/b;", "loginLaunch", "Lcom/transsnet/loginapi/ILoginApi;", com.mbridge.msdk.foundation.same.report.j.f35620b, "getMLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", "Lcom/transsion/member/premium/PremiumContentController;", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/member/premium/PremiumContentController;", "premiumContentController", "l", "Z", "isFirstResume", "m", "oldUid", "n", "shouldRefreshPurchasedInfo", "o", "isPremium", TtmlNode.TAG_P, "isSelf", CampaignEx.JSON_KEY_AD_Q, "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class MemberPremiumFragment extends PageStatusFragment<wm.o> implements View.OnClickListener, dz.a, com.transsion.baselib.report.g {

    /* renamed from: q */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: r */
    public static final int f46375r = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private String com.cloud.tmc.integration.event.EventConstants.KEY_SOURCE java.lang.String;

    /* renamed from: d, reason: from kotlin metadata */
    private String subjectId;

    /* renamed from: f, reason: from kotlin metadata */
    private UserInfo mUserInfo;

    /* renamed from: g */
    private MemberDetail memberDetail;

    /* renamed from: i, reason: from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: k */
    private PremiumContentController premiumContentController;

    /* renamed from: m, reason: from kotlin metadata */
    private String oldUid;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean shouldRefreshPurchasedInfo;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isPremium;

    /* renamed from: p */
    private boolean isSelf;

    /* renamed from: b */
    private String sceneId = "";

    /* renamed from: c, reason: from kotlin metadata */
    private String traceId = "";

    /* renamed from: e, reason: from kotlin metadata */
    private String orderId = "";

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy mLoadingDialog = LazyKt.b(new Function0() { // from class: com.transsion.member.g0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            BaseMemberLoadingDialog F0;
            F0 = MemberPremiumFragment.F0();
            return F0;
        }
    });

    /* renamed from: j */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.member.h0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi mLoginApi_delegate$lambda$1;
            mLoginApi_delegate$lambda$1 = MemberPremiumFragment.mLoginApi_delegate$lambda$1();
            return mLoginApi_delegate$lambda$1;
        }
    });

    /* renamed from: l, reason: from kotlin metadata */
    private boolean isFirstResume = true;

    /* renamed from: com.transsion.member.MemberPremiumFragment$a */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MemberPremiumFragment b(Companion companion, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                str4 = null;
            }
            return companion.a(str, str2, str3, str4);
        }

        public final MemberPremiumFragment a(String str, String str2, String str3, String str4) {
            MemberPremiumFragment memberPremiumFragment = new MemberPremiumFragment();
            memberPremiumFragment.K0(str);
            memberPremiumFragment.J0(str2);
            memberPremiumFragment.M0(str3);
            if (str4 != null && str4.length() != 0) {
                memberPremiumFragment.L0(str4);
            }
            return memberPremiumFragment;
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f46392a;

        static {
            int[] iArr = new int[MembershipDetailType.values().length];
            try {
                iArr[MembershipDetailType.TRIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MembershipDetailType.FINANCIAL_MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MembershipDetailType.SUBSCRIPTION_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MembershipDetailType.EXPIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MembershipDetailType.GUEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f46392a = iArr;
        }
    }

    public static final void A0(ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() == -1) {
            a.C0856a.f(lg.a.f68962a, "loginStatus", "登录成功", false, 4, null);
        } else {
            a.C0856a.f(lg.a.f68962a, "loginStatus", "登录失败或者取消", false, 4, null);
        }
    }

    public static final void B0(wm.o oVar, MemberPremiumFragment memberPremiumFragment, View view, int i11, int i12, int i13, int i14) {
        PremiumContentView premiumContentView;
        oVar.f77970j.setBackgroundColor(memberPremiumFragment.s0(Color.rgb(18, 20, 28), RangesKt.l(i12 / 100.0f, 0.0f, 1.0f)));
        wm.o mViewBinding = memberPremiumFragment.getMViewBinding();
        if (mViewBinding == null || (premiumContentView = mViewBinding.f77969i) == null) {
            return;
        }
        premiumContentView.checkVisible();
    }

    public static final Unit C0(MemberPremiumFragment memberPremiumFragment, MemberDetail it) {
        Intrinsics.h(it, "it");
        memberPremiumFragment.memberDetail = it;
        hj.b logViewConfig = memberPremiumFragment.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        memberPremiumFragment.I0(it);
        memberPremiumFragment.Q0(it.getUserInfo());
        return Unit.f67184a;
    }

    public static final Unit D0(MemberPremiumFragment memberPremiumFragment) {
        memberPremiumFragment.u0();
        return Unit.f67184a;
    }

    /* renamed from: E0, reason: from getter */
    private final boolean getIsSelf() {
        return this.isSelf;
    }

    public static final BaseMemberLoadingDialog F0() {
        return new BaseMemberLoadingDialog();
    }

    private final void G0() {
        PremiumContentController premiumContentController = this.premiumContentController;
        if (premiumContentController != null) {
            premiumContentController.I();
        }
    }

    private final void H0() {
        if (this.shouldRefreshPurchasedInfo) {
            y0();
            this.shouldRefreshPurchasedInfo = false;
        }
    }

    private final void I0(MemberDetail memberDetail) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        AppCompatTextView appCompatTextView6;
        AppCompatImageView appCompatImageView5;
        AppCompatTextView appCompatTextView7;
        AppCompatTextView appCompatTextView8;
        AppCompatImageView appCompatImageView6;
        AppCompatTextView appCompatTextView9;
        PointInfo pointInfo;
        a.C0856a.g(lg.a.f68962a, "member detail is " + memberDetail, false, 2, null);
        int point = (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) ? 0 : pointInfo.getPoint();
        int i11 = b.f46392a[(memberDetail != null ? MembershipDetailType.INSTANCE.a(memberDetail.getMemberInfo()) : MembershipDetailType.GUEST).ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            if (getContext() != null) {
                MemberInfo memberInfo = memberDetail != null ? memberDetail.getMemberInfo() : null;
                wm.o mViewBinding = getMViewBinding();
                if (mViewBinding != null && (appCompatTextView7 = mViewBinding.f77966f) != null) {
                    appCompatTextView7.setVisibility(8);
                }
                wm.o mViewBinding2 = getMViewBinding();
                if (mViewBinding2 != null && (appCompatImageView5 = mViewBinding2.f77963c) != null) {
                    appCompatImageView5.setVisibility(8);
                }
                wm.o mViewBinding3 = getMViewBinding();
                if (mViewBinding3 != null && (appCompatTextView6 = mViewBinding3.f77972l) != null) {
                    appCompatTextView6.setVisibility(8);
                }
                if (memberInfo != null) {
                    int vipLevel = memberInfo.getVipLevel();
                    if (vipLevel == 0) {
                        wm.o mViewBinding4 = getMViewBinding();
                        if (mViewBinding4 != null && (appCompatTextView = mViewBinding4.f77966f) != null) {
                            appCompatTextView.setVisibility(0);
                        }
                    } else if (vipLevel == 1) {
                        wm.o mViewBinding5 = getMViewBinding();
                        if (mViewBinding5 != null && (appCompatImageView2 = mViewBinding5.f77963c) != null) {
                            appCompatImageView2.setImageResource(R$mipmap.icon_premium_vip);
                        }
                        wm.o mViewBinding6 = getMViewBinding();
                        if (mViewBinding6 != null && (appCompatImageView = mViewBinding6.f77963c) != null) {
                            appCompatImageView.setVisibility(0);
                        }
                        wm.o mViewBinding7 = getMViewBinding();
                        if (mViewBinding7 != null && (appCompatTextView3 = mViewBinding7.f77972l) != null) {
                            appCompatTextView3.setText(getString(R$string.member_date_left, memberInfo.getExpiryDate()));
                        }
                        wm.o mViewBinding8 = getMViewBinding();
                        if (mViewBinding8 != null && (appCompatTextView2 = mViewBinding8.f77972l) != null) {
                            appCompatTextView2.setVisibility(0);
                        }
                    } else if (vipLevel == 2) {
                        wm.o mViewBinding9 = getMViewBinding();
                        if (mViewBinding9 != null && (appCompatImageView4 = mViewBinding9.f77963c) != null) {
                            appCompatImageView4.setImageResource(R$mipmap.icon_premium_svip);
                        }
                        wm.o mViewBinding10 = getMViewBinding();
                        if (mViewBinding10 != null && (appCompatImageView3 = mViewBinding10.f77963c) != null) {
                            appCompatImageView3.setVisibility(0);
                        }
                        wm.o mViewBinding11 = getMViewBinding();
                        if (mViewBinding11 != null && (appCompatTextView5 = mViewBinding11.f77972l) != null) {
                            appCompatTextView5.setText(getString(R$string.member_date_left, memberInfo.getExpiryDate()));
                        }
                        wm.o mViewBinding12 = getMViewBinding();
                        if (mViewBinding12 != null && (appCompatTextView4 = mViewBinding12.f77972l) != null) {
                            appCompatTextView4.setVisibility(0);
                        }
                    }
                }
            }
        } else {
            if (i11 != 4 && i11 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            if (getContext() != null) {
                wm.o mViewBinding13 = getMViewBinding();
                if (mViewBinding13 != null && (appCompatTextView9 = mViewBinding13.f77966f) != null) {
                    appCompatTextView9.setVisibility(0);
                }
                wm.o mViewBinding14 = getMViewBinding();
                if (mViewBinding14 != null && (appCompatImageView6 = mViewBinding14.f77963c) != null) {
                    appCompatImageView6.setVisibility(8);
                }
                wm.o mViewBinding15 = getMViewBinding();
                if (mViewBinding15 != null && (appCompatTextView8 = mViewBinding15.f77972l) != null) {
                    appCompatTextView8.setVisibility(8);
                }
            }
        }
        S0();
        N0(point);
        H0();
    }

    private final void O0(boolean expanded) {
        final AppCompatTextView appCompatTextView;
        wm.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatTextView = mViewBinding.f77968h) == null) {
            return;
        }
        Object parent = appCompatTextView.getParent();
        final View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        if (expanded) {
            appCompatTextView.post(new Runnable() { // from class: com.transsion.member.l0
                @Override // java.lang.Runnable
                public final void run() {
                    MemberPremiumFragment.P0(AppCompatTextView.this, view);
                }
            });
        } else {
            view.setTouchDelegate(null);
        }
    }

    public static final void P0(AppCompatTextView appCompatTextView, View view) {
        if (!appCompatTextView.hasOnClickListeners()) {
            view.setTouchDelegate(null);
            return;
        }
        Rect rect = new Rect();
        appCompatTextView.getHitRect(rect);
        int max = Math.max(rect.height(), gk.b.a(48));
        int height = view.getHeight();
        int m11 = RangesKt.m(rect.centerY() - (max / 2), 0, RangesKt.f(height - max, 0));
        rect.top = m11;
        rect.bottom = RangesKt.i(m11 + max, height);
        view.setTouchDelegate(new TouchDelegate(rect, appCompatTextView));
    }

    private final void Q0(UserInfo userInfo) {
        wm.o mViewBinding;
        ConstraintLayout.b bVar;
        if (userInfo == null || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        if (userInfo.getUserType() == 1) {
            View avatarBg = mViewBinding.f77962b;
            Intrinsics.g(avatarBg, "avatarBg");
            avatarBg.setVisibility(0);
            ShapeableImageView ivAvatarPremium = mViewBinding.f77964d;
            Intrinsics.g(ivAvatarPremium, "ivAvatarPremium");
            ivAvatarPremium.setVisibility(0);
            f.a aVar = ej.f.f62005a;
            Context context = mViewBinding.f77964d.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b i11 = aVar.m(context).g(userInfo.getAvatar()).i(com.tn.lib.widget.R$mipmap.profile_default_avatar);
            ShapeableImageView ivAvatarPremium2 = mViewBinding.f77964d;
            Intrinsics.g(ivAvatarPremium2, "ivAvatarPremium");
            i11.d(ivAvatarPremium2);
            mViewBinding.f77968h.setText(androidx.core.text.a.c().m(userInfo.getNickname(), androidx.core.text.u.f8333a));
            mViewBinding.f77968h.setOnClickListener(null);
            O0(false);
            mViewBinding.f77968h.setCompoundDrawablesRelative(null, null, null, null);
            ViewGroup.LayoutParams layoutParams = mViewBinding.f77968h.getLayoutParams();
            ConstraintLayout.b bVar2 = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar2 != null) {
                bVar2.setMarginStart(gk.b.a(8));
            }
            mViewBinding.f77968h.requestLayout();
            ViewGroup.LayoutParams layoutParams2 = mViewBinding.f77972l.getLayoutParams();
            bVar = layoutParams2 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams2 : null;
            if (bVar != null) {
                bVar.setMarginStart(gk.b.a(4));
            }
            mViewBinding.f77972l.requestLayout();
            return;
        }
        View avatarBg2 = mViewBinding.f77962b;
        Intrinsics.g(avatarBg2, "avatarBg");
        avatarBg2.setVisibility(8);
        ShapeableImageView ivAvatarPremium3 = mViewBinding.f77964d;
        Intrinsics.g(ivAvatarPremium3, "ivAvatarPremium");
        ivAvatarPremium3.setVisibility(8);
        AppCompatTextView appCompatTextView = mViewBinding.f77968h;
        Context context2 = getContext();
        appCompatTextView.setText(context2 != null ? context2.getString(R$string.member_login) : null);
        AppCompatTextView appCompatTextView2 = mViewBinding.f77968h;
        Context context3 = getContext();
        appCompatTextView2.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, context3 != null ? context3.getDrawable(com.tn.lib.widget.R$mipmap.ic_arrow_right_for_member) : null, (Drawable) null);
        mViewBinding.f77968h.setCompoundDrawablePadding(0);
        AppCompatTextView ivName = mViewBinding.f77968h;
        Intrinsics.g(ivName, "ivName");
        jg.c.c(ivName, 0L, new Function1() { // from class: com.transsion.member.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = MemberPremiumFragment.R0(MemberPremiumFragment.this, (View) obj);
                return R0;
            }
        }, 1, null);
        O0(true);
        ViewGroup.LayoutParams layoutParams3 = mViewBinding.f77968h.getLayoutParams();
        ConstraintLayout.b bVar3 = layoutParams3 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams3 : null;
        if (bVar3 != null) {
            bVar3.setMarginStart(gk.b.a(8));
        }
        mViewBinding.f77968h.requestLayout();
        ViewGroup.LayoutParams layoutParams4 = mViewBinding.f77972l.getLayoutParams();
        bVar = layoutParams4 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams4 : null;
        if (bVar != null) {
            bVar.setMarginStart(gk.b.a(4));
        }
        mViewBinding.f77972l.requestLayout();
    }

    public static final Unit R0(MemberPremiumFragment memberPremiumFragment, View it) {
        Intrinsics.h(it, "it");
        ILoginApi mLoginApi = memberPremiumFragment.getMLoginApi();
        if (mLoginApi != null) {
            mLoginApi.g(memberPremiumFragment);
        }
        ILoginApi mLoginApi2 = memberPremiumFragment.getMLoginApi();
        if (mLoginApi2 != null) {
            Context requireContext = memberPremiumFragment.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            mLoginApi2.j(requireContext);
        }
        return Unit.f67184a;
    }

    private final void S0() {
        Lottery lottery;
        IRewardsCenterApi iRewardsCenterApi = (IRewardsCenterApi) TheRouter.d(IRewardsCenterApi.class, new Object[0]);
        RewardsCenterData a11 = iRewardsCenterApi != null ? iRewardsCenterApi.a() : null;
        if (a11 == null || (lottery = a11.getLottery()) == null) {
            return;
        }
        lottery.getActivityId();
    }

    private final ILoginApi getMLoginApi() {
        return (ILoginApi) this.mLoginApi.getValue();
    }

    public static final ILoginApi mLoginApi_delegate$lambda$1() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    private final int s0(int r42, float fraction) {
        return Color.argb((int) (Color.alpha(r42) * fraction), Color.red(r42), Color.green(r42), Color.blue(r42));
    }

    private final void t0() {
        ImmersionBar.with(this).statusBarDarkFont(false).init();
    }

    private final void v0() {
        FragmentActivity activity = getActivity();
        MemberActivity memberActivity = activity instanceof MemberActivity ? (MemberActivity) activity : null;
        if (memberActivity != null) {
            memberActivity.w0();
        }
    }

    private final BaseMemberLoadingDialog w0() {
        return (BaseMemberLoadingDialog) this.mLoadingDialog.getValue();
    }

    private final void y0() {
        String string;
        String string2;
        if (this.isPremium) {
            Context context = getContext();
            if (context != null) {
                string = context.getString(R$string.member_successfully_renewed);
            }
            string = null;
        } else {
            Context context2 = getContext();
            if (context2 != null) {
                string = context2.getString(R$string.member_successfully_upgraded_to_premium);
            }
            string = null;
        }
        String str = this.com.cloud.tmc.integration.event.EventConstants.KEY_SOURCE java.lang.String;
        if (Intrinsics.c(str, MemberSource.SOURCE_LANDSCAPE_PLAY.getValue())) {
            Context context3 = getContext();
            if (context3 != null) {
                string2 = context3.getString(R$string.member_back_to_watch);
            }
            string2 = null;
        } else if (Intrinsics.c(str, MemberSource.SOURCE_HDDL.getValue())) {
            Context context4 = getContext();
            if (context4 != null) {
                string2 = context4.getString(R$string.member_back);
            }
            string2 = null;
        } else if (Intrinsics.c(str, MemberSource.SOURCE_AD_DIALOG.getValue()) || Intrinsics.c(str, MemberSource.SOURCE_DOWNLOAD_DIALOG.getValue()) || Intrinsics.c(str, MemberSource.SOURCE_OTHER_DOWNLOAD_DIALOG.getValue()) || Intrinsics.c(str, MemberSource.SOURCE_MULTI_DL.getValue())) {
            Context context5 = getContext();
            if (context5 != null) {
                string2 = context5.getString(R$string.member_back_to_download);
            }
            string2 = null;
        } else if (getActivity() instanceof MemberActivity) {
            Context context6 = getContext();
            if (context6 != null) {
                string2 = context6.getString(R$string.member_back);
            }
            string2 = null;
        } else {
            Context context7 = getContext();
            if (context7 != null) {
                string2 = context7.getString(R$string.member_explore_now);
            }
            string2 = null;
        }
        a.C0856a.g(lg.a.f68962a, "The source is " + this.com.cloud.tmc.integration.event.EventConstants.KEY_SOURCE java.lang.String + ", title: " + string + ", buttonTitle: " + string2, false, 2, null);
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new MemberPremiumFragment$handlePurchaseSucceed$1(this, string, string2, null), 3, null);
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            IMemberApi.a.a(iMemberApi, null, 1, null);
        }
        ObserveLoginAction.f46454c.a().i();
    }

    public static final void z0(MemberPremiumFragment memberPremiumFragment, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        FragmentActivity activity = memberPremiumFragment.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.l();
    }

    public final void J0(String str) {
        this.sceneId = str;
    }

    public final void K0(String str) {
        this.com.cloud.tmc.integration.event.EventConstants.KEY_SOURCE java.lang.String = str;
    }

    public final void L0(String str) {
        this.subjectId = str;
    }

    public final void M0(String str) {
        this.traceId = str;
    }

    public final void N0(int points) {
        PointInfo pointInfo;
        MemberDetail memberDetail = this.memberDetail;
        if (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) {
            return;
        }
        pointInfo.setPoint(points);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        wm.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f77965e) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberPremiumFragment.z0(MemberPremiumFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        NestedScrollView nestedScrollView;
        ILoginApi mLoginApi;
        v0();
        if (getIsSelf() && (mLoginApi = getMLoginApi()) != null) {
            mLoginApi.g(this);
        }
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.member.i0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                MemberPremiumFragment.A0((ActivityResult) obj);
            }
        });
        final wm.o mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            if (getActivity() instanceof MemberActivity) {
                mViewBinding.f77965e.setVisibility(0);
            } else {
                mViewBinding.f77965e.setVisibility(8);
            }
            t0();
            wm.o mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (nestedScrollView = mViewBinding2.f77971k) == null) {
                return;
            }
            nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.transsion.member.j0
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
                    MemberPremiumFragment.B0(wm.o.this, this, view, i11, i12, i13, i14);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        PremiumContentView premiumContentView;
        wm.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (premiumContentView = mViewBinding.f77969i) == null) {
            return;
        }
        premiumContentView.setActivity(true);
        String str = this.sceneId;
        if (str == null) {
            str = "";
        }
        String str2 = this.traceId;
        premiumContentView.setTrackerInfo(str, "memberdetail", str2 != null ? str2 : "", this.subjectId);
        androidx.view.u viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.g(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        PremiumContentController premiumContentController = new PremiumContentController(this, viewLifecycleOwner, premiumContentView, new PremiumContentController.a(new Function1() { // from class: com.transsion.member.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = MemberPremiumFragment.C0(MemberPremiumFragment.this, (MemberDetail) obj);
                return C0;
            }
        }, null, new Function0() { // from class: com.transsion.member.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit D0;
                D0 = MemberPremiumFragment.D0(MemberPremiumFragment.this);
                return D0;
            }
        }, 2, null));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        premiumContentController.t(requireActivity);
        this.premiumContentController = premiumContentController;
        Q0(this.mUserInfo);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void logResume() {
        super.logResume();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("memberdetail", false, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v11) {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onCreate(r3)
            com.transsnet.loginapi.ILoginApi r3 = r2.getMLoginApi()
            r0 = 0
            if (r3 == 0) goto Lf
            com.transsnet.loginapi.bean.UserInfo r3 = r3.i()
            goto L10
        Lf:
            r3 = r0
        L10:
            r2.mUserInfo = r3
            if (r3 == 0) goto L19
            java.lang.String r3 = r3.getUserId()
            goto L1a
        L19:
            r3 = r0
        L1a:
            r2.oldUid = r3
            com.transsnet.loginapi.bean.UserInfo r3 = r2.mUserInfo
            if (r3 == 0) goto L25
            java.lang.String r3 = r3.getUserId()
            goto L26
        L25:
            r3 = r0
        L26:
            if (r3 == 0) goto L52
            int r3 = r3.length()
            if (r3 != 0) goto L2f
            goto L52
        L2f:
            com.transsnet.loginapi.bean.UserInfo r3 = r2.mUserInfo
            if (r3 == 0) goto L38
            java.lang.String r3 = r3.getUserId()
            goto L39
        L38:
            r3 = r0
        L39:
            com.transsnet.loginapi.ILoginApi r1 = r2.getMLoginApi()
            if (r1 == 0) goto L49
            com.transsnet.loginapi.bean.UserInfo r1 = r1.i()
            if (r1 == 0) goto L49
            java.lang.String r0 = r1.getUserId()
        L49:
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r3, r0)
            if (r3 == 0) goto L50
            goto L52
        L50:
            r3 = 0
            goto L53
        L52:
            r3 = 1
        L53:
            r2.isSelf = r3
            hj.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto L6b
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto L6b
            java.lang.String r0 = "scene_id"
            java.lang.String r1 = r2.sceneId
            java.lang.Object r3 = r3.put(r0, r1)
            java.lang.String r3 = (java.lang.String) r3
        L6b:
            java.lang.String r3 = r2.com.cloud.tmc.integration.event.EventConstants.KEY_SOURCE java.lang.String
            java.lang.String r0 = "source"
            if (r3 == 0) goto L86
            hj.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto Lb7
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto Lb7
            java.lang.String r1 = r2.com.cloud.tmc.integration.event.EventConstants.KEY_SOURCE java.lang.String
            java.lang.Object r3 = r3.put(r0, r1)
            java.lang.String r3 = (java.lang.String) r3
            goto Lb7
        L86:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            boolean r3 = r3 instanceof com.transsion.member.MemberActivity
            if (r3 == 0) goto La3
            hj.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto Lb7
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto Lb7
            java.lang.String r1 = "OTHER"
            java.lang.Object r3 = r3.put(r0, r1)
            java.lang.String r3 = (java.lang.String) r3
            goto Lb7
        La3:
            hj.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto Lb7
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto Lb7
            java.lang.String r1 = "TAB"
            java.lang.Object r3 = r3.put(r0, r1)
            java.lang.String r3 = (java.lang.String) r3
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberPremiumFragment.onCreate(android.os.Bundle):void");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ILoginApi mLoginApi = getMLoginApi();
        if (mLoginApi != null) {
            mLoginApi.p(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                G0();
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // dz.a
    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        a.C0761a.a(this, user);
        G0();
    }

    @Override // dz.a
    public void onLogout() {
        a.C0761a.b(this);
        G0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        G0();
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible(), 1, null);
        if (this.isFirstResume) {
            this.isFirstResume = false;
        }
    }

    @Override // dz.a
    public void onUpdateUserInfo(UserInfo user) {
        Intrinsics.h(user, "user");
        if (getIsSelf()) {
            Q0(user);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            IMemberApi.a.a(iMemberApi, null, 1, null);
        }
    }

    public final void u0() {
        if (w0().isAdded()) {
            w0().dismissAllowingStateLoss();
        } else {
            a.C0856a.g(lg.a.f68962a, "Dialog not is added", false, 2, null);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: x0 */
    public wm.o getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wm.o c11 = wm.o.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
