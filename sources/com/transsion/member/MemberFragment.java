package com.transsion.member;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.bumptech.glide.Glide;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.material.imageview.ShapeableImageView;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.member.bean.RedeemResult;
import com.transsion.member.dialog.MemberPromoCodeDialog;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberAgreement;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberTaskItemInvite;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import com.transsion.memberapi.MembershipDetailType;
import com.transsion.memberapi.PointInfo;
import com.transsion.memberapi.SkuCategory;
import com.transsion.memberapi.SkuData;
import com.transsion.memberapi.SkuItem;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.RewardsCenterData;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import dz.a;
import ej.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001gB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u0019\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0007J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0007J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0007J\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\u0007J\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\u0007J\u000f\u0010*\u001a\u00020#H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010\u0007J#\u0010/\u001a\u00020\b2\u0006\u0010-\u001a\u00020!2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\b2\u0006\u0010.\u001a\u00020!H\u0002¢\u0006\u0004\b1\u00102J+\u00106\u001a\u00020\b2\u0006\u0010.\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u0001032\b\u00105\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u001f\u0010>\u001a\u0002032\u0006\u0010<\u001a\u0002032\u0006\u0010=\u001a\u000208H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020!H\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\bH\u0016¢\u0006\u0004\bF\u0010\u0007J\u000f\u0010G\u001a\u00020\bH\u0016¢\u0006\u0004\bG\u0010\u0007J\u0011\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020#H\u0016¢\u0006\u0004\bK\u0010+J\u000f\u0010L\u001a\u00020\bH\u0016¢\u0006\u0004\bL\u0010\u0007J\u0019\u0010O\u001a\u00020\b2\b\u0010N\u001a\u0004\u0018\u00010MH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\bH\u0016¢\u0006\u0004\bQ\u0010\u0007J\u000f\u0010R\u001a\u00020\bH\u0016¢\u0006\u0004\bR\u0010\u0007J\u0017\u0010T\u001a\u00020\b2\u0006\u0010S\u001a\u00020#H\u0016¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\b¢\u0006\u0004\bV\u0010\u0007J\r\u0010W\u001a\u00020\b¢\u0006\u0004\bW\u0010\u0007J\u0017\u0010Y\u001a\u00020\b2\u0006\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\bY\u0010\rJ\u000f\u0010Z\u001a\u00020\bH\u0016¢\u0006\u0004\bZ\u0010\u0007J\u0017\u0010[\u001a\u00020\b2\u0006\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\b[\u0010\rJ\u0015\u0010]\u001a\u00020\b2\u0006\u0010\\\u001a\u000203¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\bH\u0016¢\u0006\u0004\b_\u0010\u0007J\u000f\u0010`\u001a\u00020\bH\u0016¢\u0006\u0004\b`\u0010\u0007J\u0019\u0010c\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010aH\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\bH\u0016¢\u0006\u0004\be\u0010\u0007J\u000f\u0010f\u001a\u00020\bH\u0016¢\u0006\u0004\bf\u0010\u0007R$\u0010k\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010E\"\u0004\bj\u00102R$\u0010o\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010h\u001a\u0004\bm\u0010E\"\u0004\bn\u00102R$\u0010s\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010h\u001a\u0004\bq\u0010E\"\u0004\br\u00102R$\u0010w\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010h\u001a\u0004\bu\u0010E\"\u0004\bv\u00102R\u0016\u0010y\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010hR\u0018\u0010|\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R \u0010\u0084\u0001\u001a\u00020\u007f8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R#\u0010\u0089\u0001\u001a\f\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R#\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0096\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0081\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R!\u0010\u009f\u0001\u001a\u00030\u009b\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u0081\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0019\u0010¢\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001b\u0010¥\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u0019\u0010¨\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010ª\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b©\u0001\u0010hR\u0019\u0010¬\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¡\u0001R\u0019\u0010®\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010¡\u0001R\u0019\u0010°\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010¡\u0001¨\u0006±\u0001"}, d2 = {"Lcom/transsion/member/MemberFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lwm/n;", "Landroid/view/View$OnClickListener;", "Ldz/a;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", "", "f1", "Lcom/transsnet/loginapi/bean/UserInfo;", "userInfo", "t1", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "Lcom/transsion/memberapi/SkuItem;", "skuItem", "e1", "(Lcom/transsion/memberapi/SkuItem;)V", "K0", "Lcom/transsion/memberapi/MemberDetail;", "memberDetail", "l1", "(Lcom/transsion/memberapi/MemberDetail;)V", "v1", "g1", "Lcom/transsion/memberapi/SkuData;", "data", "m1", "(Lcom/transsion/memberapi/SkuData;)V", "", "redeemList", "h1", "(Ljava/util/List;)V", "", "productId", "", "isSubscription", "q1", "(Ljava/lang/String;Z)V", "c1", "Q0", "M0", "b1", "()Z", "J0", "optType", "skuId", "i1", "(Ljava/lang/String;Ljava/lang/String;)V", "k1", "(Ljava/lang/String;)V", "", "code", "message", "j1", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "", "alpha", "s1", "(F)V", TtmlNode.ATTR_TTS_COLOR, "fraction", "I0", "(IF)I", "Landroid/view/LayoutInflater;", "inflater", "P0", "(Landroid/view/LayoutInflater;)Lwm/n;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "loadDefaultData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "isShowPageStateLayoutTitle", "initViewModel", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "onResume", "hidden", "onHiddenChanged", "(Z)V", "showLoading", "L0", "user", "onLogin", "onLogout", "onUpdateUserInfo", "points", "p1", "(I)V", "initListener", "retryLoadData", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "logResume", "onDestroy", "a", "Ljava/lang/String;", "getSourceValue", "setSourceValue", "sourceValue", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getSceneId", "setSceneId", "sceneId", "c", "getTraceId", "setTraceId", "traceId", "d", "getSubjectId", "setSubjectId", "subjectId", "e", "orderId", "f", "Lcom/transsnet/loginapi/bean/UserInfo;", "mUserInfo", be.g.f16474b, "Lcom/transsion/memberapi/MemberDetail;", "Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "h", "Lkotlin/Lazy;", "N0", "()Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "mLoadingDialog", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "i", "Landroidx/activity/result/b;", "loginLaunch", "Lcom/transsion/member/adapter/l;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/member/adapter/l;", "taskAdapter", "Lcom/transsion/member/adapter/k;", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/member/adapter/k;", "skuListAdapter", "Lcom/transsion/member/adapter/i;", "l", "Lcom/transsion/member/adapter/i;", "redeemListAdapter", "Lcom/transsnet/loginapi/ILoginApi;", "m", "getMLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", "Lcom/transsion/member/MemberViewModel;", "n", "O0", "()Lcom/transsion/member/MemberViewModel;", "memberViewModel", "o", "Z", "isFirstResume", TtmlNode.TAG_P, "Lcom/transsion/memberapi/SkuItem;", "selectedSkuItem", CampaignEx.JSON_KEY_AD_Q, "I", "defaultSelectedPosition", CampaignEx.JSON_KEY_AD_R, "oldUid", "s", "shouldRefreshPurchasedInfo", "t", "isPremium", TmcStartParams.KEY_URL_SHORT, "isSelf", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MemberFragment extends PageStatusFragment<wm.n> implements View.OnClickListener, dz.a, com.transsion.baselib.report.g {

    /* renamed from: w, reason: collision with root package name */
    public static final int f46345w = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String sourceValue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String subjectId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private UserInfo mUserInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private MemberDetail memberDetail;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private com.transsion.member.adapter.l taskAdapter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private com.transsion.member.adapter.k skuListAdapter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.transsion.member.adapter.i redeemListAdapter;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Lazy memberViewModel;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstResume;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private SkuItem selectedSkuItem;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int defaultSelectedPosition;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String oldUid;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean shouldRefreshPurchasedInfo;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean isPremium;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean isSelf;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String sceneId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String traceId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String orderId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoadingDialog = LazyKt.b(new Function0() { // from class: com.transsion.member.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            BaseMemberLoadingDialog d12;
            d12 = MemberFragment.d1();
            return d12;
        }
    });

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.member.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi mLoginApi_delegate$lambda$1;
            mLoginApi_delegate$lambda$1 = MemberFragment.mLoginApi_delegate$lambda$1();
            return mLoginApi_delegate$lambda$1;
        }
    });

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46367a;

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
            f46367a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Function0 {
        c() {
        }

        public void a() {
            MemberFragment.this.f1();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f67184a;
        }
    }

    /* loaded from: classes5.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f46369a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f46369a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f46369a;
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
            this.f46369a.invoke(obj);
        }
    }

    public MemberFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.member.MemberFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.memberViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MemberViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.member.MemberFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.MemberFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                androidx.view.m mVar = invoke instanceof androidx.view.m ? (androidx.view.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.isFirstResume = true;
        this.defaultSelectedPosition = -1;
    }

    private final int I0(int color, float fraction) {
        return Color.argb((int) (Color.alpha(color) * fraction), Color.red(color), Color.green(color), Color.blue(color));
    }

    private final void J0() {
        ImmersionBar.with(this).statusBarDarkFont(false).init();
    }

    private final void K0() {
        Intent intent;
        FragmentActivity activity;
        Intent intent2;
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent = activity2.getIntent()) == null || !intent.getBooleanExtra("extra_member_scroll_bottom", false) || (activity = getActivity()) == null || (intent2 = activity.getIntent()) == null) {
            return;
        }
        intent2.removeExtra("extra_member_scroll_bottom");
    }

    private final void M0() {
        ConstraintLayout constraintLayout;
        wm.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (constraintLayout = mViewBinding.f77954n) != null) {
            jg.c.e(constraintLayout);
        }
        FragmentActivity activity = getActivity();
        MemberActivity memberActivity = activity instanceof MemberActivity ? (MemberActivity) activity : null;
        if (memberActivity != null) {
            memberActivity.w0();
        }
    }

    private final BaseMemberLoadingDialog N0() {
        return (BaseMemberLoadingDialog) this.mLoadingDialog.getValue();
    }

    private final MemberViewModel O0() {
        return (MemberViewModel) this.memberViewModel.getValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        if (r2.equals("Multi_DL_DIALOG") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x007f, code lost:
    
        r2 = getContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0083, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
    
        r2 = r2.getString(com.transsion.member.R$string.member_back_to_download);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r2.equals("AD_DIALOG") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r2.equals("OTHER_DOWNLOAD_DIALOG") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
    
        if (r2.equals("DOWNLOAD_DIALOG") == false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Q0() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberFragment.Q0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(MemberFragment memberFragment, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        FragmentActivity activity = memberFragment.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(MemberFragment memberFragment, View it) {
        Intrinsics.h(it, "it");
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null ? iMemberApi.f() : false) {
            SkuItem skuItem = memberFragment.selectedSkuItem;
            if (skuItem != null) {
                memberFragment.q1(skuItem.getSkuId(), Intrinsics.c(skuItem.getCategory(), SkuCategory.AUTO_RENEW.getValue()));
            }
        } else {
            Navigator.x(TheRouter.c("/rewards/center").K(EventConstants.KEY_SOURCE, "memberdetail"), null, null, 3, null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(MemberFragment memberFragment, View it) {
        Intrinsics.h(it, "it");
        memberFragment.c1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() == -1) {
            a.C0856a.f(lg.a.f68962a, "loginStatus", "登录成功", false, 4, null);
        } else {
            a.C0856a.f(lg.a.f68962a, "loginStatus", "登录失败或者取消", false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(MemberFragment memberFragment, View view) {
        MemberPromoCodeDialog a11 = MemberPromoCodeDialog.INSTANCE.a(new c());
        FragmentManager childFragmentManager = memberFragment.getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        a11.show(childFragmentManager, "MemberPromoCodeDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(MemberFragment memberFragment, RedeemResult redeemResult) {
        String string;
        String str;
        if (redeemResult != null) {
            int vipDurationDays = redeemResult.getVipDurationDays();
            if (vipDurationDays == 1) {
                Context context = memberFragment.getContext();
                if (context != null) {
                    string = context.getString(R$string.member_claimed_succeed_1_day);
                    str = string;
                }
                str = null;
            } else {
                Context context2 = memberFragment.getContext();
                if (context2 != null) {
                    string = context2.getString(R$string.member_claimed_succeed_days, Integer.valueOf(vipDurationDays));
                    str = string;
                }
                str = null;
            }
            if (str != null) {
                uh.b.f76876a.g(R$layout.claim_succeed_layout, str, (r13 & 4) != 0 ? 0 : 80, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : com.blankj.utilcode.util.a0.a(66.0f));
            }
            memberFragment.f1();
            IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
            if (iMemberApi != null) {
                IMemberApi.a.a(iMemberApi, null, 1, null);
            }
        } else {
            com.tn.lib.widget.toast.core.h.f41533a.k(com.tn.lib.widget.R$string.failed_toast);
        }
        memberFragment.L0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(MemberFragment memberFragment, zm.d dVar) {
        List<Object> data;
        Object obj;
        Object obj2;
        List<MemberTaskItemInvite> inviteList;
        memberFragment.f1();
        com.transsion.member.adapter.l lVar = memberFragment.taskAdapter;
        if (lVar != null && (data = lVar.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                Integer taskSubType = ((MemberTaskItem) obj2).getTaskSubType();
                if (taskSubType != null && taskSubType.intValue() == 2) {
                    break;
                }
            }
            MemberTaskItem memberTaskItem = (MemberTaskItem) obj2;
            if (memberTaskItem != null) {
                int a11 = dVar.a();
                String d11 = dVar.d();
                MemberTaskRewardInfo b11 = dVar.b();
                if (b11 != null) {
                    if (Intrinsics.c(d11, "0")) {
                        List<MemberTaskItemInvite> inviteList2 = memberTaskItem.getInviteList();
                        if (inviteList2 != null) {
                            for (MemberTaskItemInvite memberTaskItemInvite : inviteList2) {
                                if (memberTaskItemInvite.getStatus() == 1) {
                                    memberTaskItemInvite.setStatus(2);
                                }
                            }
                        }
                    } else if (a11 >= 0 && (inviteList = memberTaskItem.getInviteList()) != null) {
                        Iterator<T> it2 = inviteList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (Intrinsics.c(d11, ((MemberTaskItemInvite) next).getRewardId())) {
                                obj = next;
                                break;
                            }
                        }
                        MemberTaskItemInvite memberTaskItemInvite2 = (MemberTaskItemInvite) obj;
                        if (memberTaskItemInvite2 != null) {
                            memberTaskItemInvite2.setStatus(2);
                        }
                    }
                    memberTaskItem.setRewardInfo(b11);
                }
                com.transsion.member.adapter.l lVar2 = memberFragment.taskAdapter;
                if (lVar2 != null) {
                    lVar2.notifyDataSetChanged();
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(MemberFragment memberFragment, Pair pair) {
        List<Object> data;
        Object obj;
        List<MemberTaskItemCheckInInfo> checkInList;
        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
        memberFragment.f1();
        com.transsion.member.adapter.l lVar = memberFragment.taskAdapter;
        if (lVar != null && (data = lVar.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Integer taskSubType = ((MemberTaskItem) obj).getTaskSubType();
                if (taskSubType != null && taskSubType.intValue() == 8) {
                    break;
                }
            }
            MemberTaskItem memberTaskItem = (MemberTaskItem) obj;
            if (memberTaskItem != null) {
                int intValue = ((Number) pair.getFirst()).intValue();
                if (((MemberTaskSubmitCheckInRes) pair.getSecond()) != null && (checkInList = memberTaskItem.getCheckInList()) != null && (memberTaskItemCheckInInfo = checkInList.get(intValue)) != null) {
                    memberTaskItemCheckInInfo.setHasCheckIn(true);
                }
                com.transsion.member.adapter.l lVar2 = memberFragment.taskAdapter;
                if (lVar2 != null) {
                    lVar2.notifyDataSetChanged();
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(MemberFragment memberFragment, MemberDetail memberDetail) {
        if (memberDetail != null) {
            memberFragment.memberDetail = memberDetail;
            hj.b logViewConfig = memberFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            memberFragment.l1(memberDetail);
            memberFragment.t1(memberDetail.getUserInfo());
        }
        if (memberDetail == null) {
            if (nh.m.f70597a.e()) {
                com.tn.lib.widget.toast.core.h.f41533a.k(com.tn.lib.widget.R$string.failed_toast);
            } else {
                uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
            }
        }
        memberFragment.L0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(MemberFragment memberFragment, SkuData skuData) {
        if (skuData != null) {
            memberFragment.m1(skuData);
        }
        memberFragment.L0();
        return Unit.f67184a;
    }

    /* renamed from: b1, reason: from getter */
    private final boolean getIsSelf() {
        return this.isSelf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1() {
        ak.k.h("oneroom://com.community.oneroom/profile/user_center_labels_feedback", null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseMemberLoadingDialog d1() {
        return new BaseMemberLoadingDialog();
    }

    private final void e1(SkuItem skuItem) {
        showLoading();
        O0().T(skuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
        O0().w();
        O0().z();
        com.transsion.member.adapter.l lVar = this.taskAdapter;
        if (lVar != null) {
            lVar.notifyDataSetChanged();
        }
        K0();
    }

    private final void g1() {
        if (this.shouldRefreshPurchasedInfo) {
            Q0();
            this.shouldRefreshPurchasedInfo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginApi getMLoginApi() {
        return (ILoginApi) this.mLoginApi.getValue();
    }

    private final void h1(List redeemList) {
    }

    private final void i1(String optType, String skuId) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", optType);
        if (skuId != null) {
            hashMap.put("skuId", skuId);
        }
        hj.i iVar = hj.i.f64628a;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (str = logViewConfig.f()) == null) {
            str = "";
        }
        iVar.p(str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(String skuId, Integer code, String message) {
        String f11;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", "pay_result");
        hashMap.put("sku_id", skuId);
        hashMap.put("fail_code", String.valueOf(code));
        String str = "";
        if (message == null) {
            message = "";
        }
        hashMap.put("fail_message", message);
        hashMap.put("order_id", this.orderId);
        String str2 = this.traceId;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("trace_id", str2);
        hashMap.put("result_type", "result_fail");
        hj.i iVar = hj.i.f64628a;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (f11 = logViewConfig.f()) != null) {
            str = f11;
        }
        iVar.s(str, "purchase", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(String skuId) {
        String f11;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", "pay_result");
        hashMap.put("sku_id", skuId);
        hashMap.put("order_id", this.orderId);
        String str = this.traceId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put("trace_id", str);
        hashMap.put("result_type", "result_success");
        hj.i iVar = hj.i.f64628a;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (f11 = logViewConfig.f()) != null) {
            str2 = f11;
        }
        iVar.s(str2, "purchase", hashMap);
    }

    private final void l1(MemberDetail memberDetail) {
        ImageView imageView;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        LinearLayout.LayoutParams layoutParams;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        ImageView imageView2;
        AppCompatTextView appCompatTextView7;
        AppCompatTextView appCompatTextView8;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        AppCompatTextView appCompatTextView9;
        AppCompatTextView appCompatTextView10;
        AppCompatTextView appCompatTextView11;
        ImageView imageView3;
        AppCompatTextView appCompatTextView12;
        AppCompatTextView appCompatTextView13;
        PointInfo pointInfo;
        boolean z10 = true;
        a.C0856a.g(lg.a.f68962a, "member detail is " + memberDetail, false, 2, null);
        int point = (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) ? 0 : pointInfo.getPoint();
        int i11 = b.f46367a[(memberDetail != null ? MembershipDetailType.INSTANCE.a(memberDetail.getMemberInfo()) : MembershipDetailType.GUEST).ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            Context context = getContext();
            if (context != null) {
                MemberInfo memberInfo = memberDetail != null ? memberDetail.getMemberInfo() : null;
                IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
                if (iMemberApi != null ? iMemberApi.f() : false) {
                    wm.n mViewBinding = getMViewBinding();
                    if (mViewBinding != null && (appCompatTextView8 = mViewBinding.f77959s) != null) {
                        appCompatTextView8.setTextColor(context.getColor(com.tn.lib.widget.R$color.yellow_dark_90));
                    }
                    wm.n mViewBinding2 = getMViewBinding();
                    if (mViewBinding2 != null && (appCompatTextView7 = mViewBinding2.f77959s) != null) {
                        appCompatTextView7.setText(getString(R$string.member_premium));
                    }
                    wm.n mViewBinding3 = getMViewBinding();
                    if (mViewBinding3 != null && (imageView2 = mViewBinding3.f77950j) != null) {
                        imageView2.setVisibility(0);
                    }
                } else {
                    wm.n mViewBinding4 = getMViewBinding();
                    if (mViewBinding4 != null && (appCompatTextView2 = mViewBinding4.f77959s) != null) {
                        appCompatTextView2.setTextColor(context.getColor(com.tn.lib.widget.R$color.white_80));
                    }
                    wm.n mViewBinding5 = getMViewBinding();
                    if (mViewBinding5 != null && (appCompatTextView = mViewBinding5.f77959s) != null) {
                        appCompatTextView.setText(getString(R$string.member_free_plan));
                    }
                    wm.n mViewBinding6 = getMViewBinding();
                    if (mViewBinding6 != null && (imageView = mViewBinding6.f77950j) != null) {
                        imageView.setVisibility(8);
                    }
                }
                wm.n mViewBinding7 = getMViewBinding();
                if (mViewBinding7 != null && (appCompatTextView6 = mViewBinding7.f77957q) != null) {
                    appCompatTextView6.setText(getString(R$string.member_date_left, memberInfo != null ? memberInfo.getExpiryDate() : null));
                }
                wm.n mViewBinding8 = getMViewBinding();
                if (mViewBinding8 != null && (appCompatTextView5 = mViewBinding8.f77957q) != null) {
                    appCompatTextView5.setVisibility(0);
                }
                wm.n mViewBinding9 = getMViewBinding();
                Object layoutParams2 = (mViewBinding9 == null || (appCompatTextView4 = mViewBinding9.f77959s) == null) ? null : appCompatTextView4.getLayoutParams();
                layoutParams = layoutParams2 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams2 : null;
                if (layoutParams != null) {
                    layoutParams.setMarginStart(com.blankj.utilcode.util.a0.a(4.0f));
                }
                wm.n mViewBinding10 = getMViewBinding();
                if (mViewBinding10 != null && (appCompatTextView3 = mViewBinding10.f77959s) != null) {
                    appCompatTextView3.requestLayout();
                }
            }
        } else {
            if (i11 != 4 && i11 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            wm.n mViewBinding11 = getMViewBinding();
            if (mViewBinding11 != null && (appCompatTextView13 = mViewBinding11.f77959s) != null) {
                appCompatTextView13.setText(getString(R$string.member_free_plan));
            }
            Context context2 = getContext();
            if (context2 != null) {
                wm.n mViewBinding12 = getMViewBinding();
                if (mViewBinding12 != null && (appCompatTextView12 = mViewBinding12.f77959s) != null) {
                    appCompatTextView12.setTextColor(context2.getColor(com.tn.lib.widget.R$color.white_80));
                }
                wm.n mViewBinding13 = getMViewBinding();
                if (mViewBinding13 != null && (imageView3 = mViewBinding13.f77950j) != null) {
                    imageView3.setVisibility(8);
                }
                wm.n mViewBinding14 = getMViewBinding();
                if (mViewBinding14 != null && (appCompatTextView11 = mViewBinding14.f77957q) != null) {
                    appCompatTextView11.setVisibility(8);
                }
                wm.n mViewBinding15 = getMViewBinding();
                Object layoutParams3 = (mViewBinding15 == null || (appCompatTextView10 = mViewBinding15.f77959s) == null) ? null : appCompatTextView10.getLayoutParams();
                layoutParams = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
                if (layoutParams != null) {
                    layoutParams.setMarginStart(com.blankj.utilcode.util.a0.a(12.0f));
                }
                wm.n mViewBinding16 = getMViewBinding();
                if (mViewBinding16 != null && (appCompatTextView9 = mViewBinding16.f77959s) != null) {
                    appCompatTextView9.requestLayout();
                }
            }
        }
        if (memberDetail != null) {
            List<MemberAgreement> memberAgreements = memberDetail.getMemberAgreements();
            if (memberAgreements != null && !memberAgreements.isEmpty()) {
                z10 = false;
            }
            if (z10) {
                wm.n mViewBinding17 = getMViewBinding();
                if (mViewBinding17 != null && (textView2 = mViewBinding17.f77956p) != null) {
                    textView2.setVisibility(8);
                }
                wm.n mViewBinding18 = getMViewBinding();
                if (mViewBinding18 != null && (textView = mViewBinding18.f77955o) != null) {
                    textView.setVisibility(8);
                }
            } else {
                wm.n mViewBinding19 = getMViewBinding();
                if (mViewBinding19 != null && (textView6 = mViewBinding19.f77956p) != null) {
                    textView6.setVisibility(0);
                }
                wm.n mViewBinding20 = getMViewBinding();
                if (mViewBinding20 != null && (textView5 = mViewBinding20.f77955o) != null) {
                    textView5.setVisibility(0);
                }
                wm.n mViewBinding21 = getMViewBinding();
                if (mViewBinding21 != null && (textView4 = mViewBinding21.f77956p) != null) {
                    List<MemberAgreement> memberAgreements2 = memberDetail.getMemberAgreements();
                    Intrinsics.e(memberAgreements2);
                    textView4.setText(memberAgreements2.get(0).getTitle());
                }
                wm.n mViewBinding22 = getMViewBinding();
                if (mViewBinding22 != null && (textView3 = mViewBinding22.f77955o) != null) {
                    List<MemberAgreement> memberAgreements3 = memberDetail.getMemberAgreements();
                    Intrinsics.e(memberAgreements3);
                    textView3.setText(memberAgreements3.get(0).getContent());
                }
            }
        }
        v1();
        p1(point);
        g1();
    }

    private final void m1(SkuData data) {
        RecyclerView recyclerView;
        PointInfo pointInfo;
        List<SkuItem> skuList = data.getSkuList();
        List K0 = skuList != null ? CollectionsKt.K0(skuList, 3) : null;
        if (K0 == null) {
            K0 = CollectionsKt.l();
        }
        List<SkuItem> skuPointList = data.getSkuPointList();
        List K02 = skuPointList != null ? CollectionsKt.K0(skuPointList, 3) : null;
        if (K02 == null) {
            K02 = CollectionsKt.l();
        }
        List<SkuItem> list = K0;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        for (SkuItem skuItem : list) {
            skuItem.setMemberDetail(this.memberDetail);
            arrayList.add(skuItem);
        }
        MemberDetail memberDetail = this.memberDetail;
        int i11 = 0;
        int point = (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) ? 0 : pointInfo.getPoint();
        List<SkuItem> list2 = K02;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list2, 10));
        for (SkuItem skuItem2 : list2) {
            skuItem2.setUserPoints(Integer.valueOf(point));
            arrayList2.add(skuItem2);
        }
        com.transsion.member.adapter.k kVar = this.skuListAdapter;
        if (Intrinsics.c(kVar != null ? kVar.getData() : null, CollectionsKt.U0(arrayList))) {
            com.transsion.member.adapter.i iVar = this.redeemListAdapter;
            if (Intrinsics.c(iVar != null ? iVar.getData() : null, CollectionsKt.U0(arrayList2))) {
                return;
            }
        }
        for (Object obj : arrayList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            SkuItem skuItem3 = (SkuItem) obj;
            String hotIcon = skuItem3.getHotIcon();
            if (hotIcon != null && hotIcon.length() != 0) {
                this.selectedSkuItem = skuItem3;
                this.defaultSelectedPosition = i11;
            }
            i11 = i12;
        }
        com.transsion.member.adapter.k kVar2 = new com.transsion.member.adapter.k(CollectionsKt.U0(arrayList));
        kVar2.l(R$id.item_root);
        kVar2.G1(this.defaultSelectedPosition);
        kVar2.F1(new Function2() { // from class: com.transsion.member.m
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                Unit n12;
                n12 = MemberFragment.n1(MemberFragment.this, (SkuItem) obj2, (View) obj3);
                return n12;
            }
        });
        this.skuListAdapter = kVar2;
        wm.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77951k) != null) {
            recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new com.transsion.member.adapter.a(3, com.blankj.utilcode.util.a0.a(12.0f)));
            }
            recyclerView.setAdapter(this.skuListAdapter);
        }
        com.transsion.member.adapter.i iVar2 = new com.transsion.member.adapter.i(CollectionsKt.U0(arrayList2));
        iVar2.l(R$id.item_root);
        iVar2.F1(new Function2() { // from class: com.transsion.member.n
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                Unit o12;
                o12 = MemberFragment.o1(MemberFragment.this, (SkuItem) obj2, (View) obj3);
                return o12;
            }
        });
        this.redeemListAdapter = iVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi mLoginApi_delegate$lambda$1() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(MemberFragment memberFragment, SkuItem item, View view) {
        Intrinsics.h(item, "item");
        Intrinsics.h(view, "view");
        memberFragment.selectedSkuItem = item;
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(MemberFragment memberFragment, SkuItem item, View view) {
        Intrinsics.h(item, "item");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L)) {
            return Unit.f67184a;
        }
        a.C0856a.g(lg.a.f68962a, "The productId and coins: " + item.getSkuId() + ", " + item.getCoin(), false, 2, null);
        String duration = item.getDuration();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(duration);
        sb2.append("_reward");
        memberFragment.i1(sb2.toString(), item.getSkuId());
        memberFragment.e1(item);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (((r0 == null || (r0 = r0.getMemberInfo()) == null || r0.getMemberType() != 2) ? false : true) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q1(final java.lang.String r10, boolean r11) {
        /*
            r9 = this;
            com.transsion.memberapi.MemberDetail r0 = r9.memberDetail
            r1 = 0
            if (r0 == 0) goto L10
            com.transsion.memberapi.MemberInfo r0 = r0.getMemberInfo()
            if (r0 == 0) goto L10
            boolean r0 = r0.isActive()
            goto L11
        L10:
            r0 = r1
        L11:
            r3 = 2
            if (r0 == 0) goto L2b
            com.transsion.memberapi.MemberDetail r0 = r9.memberDetail
            r4 = 1
            if (r0 == 0) goto L27
            com.transsion.memberapi.MemberInfo r0 = r0.getMemberInfo()
            if (r0 == 0) goto L27
            int r0 = r0.getMemberType()
            if (r0 != r3) goto L27
            r0 = r4
            goto L28
        L27:
            r0 = r1
        L28:
            if (r0 == 0) goto L2b
            goto L2c
        L2b:
            r4 = r1
        L2c:
            r9.isPremium = r4
            lg.a$a r0 = lg.a.f68962a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "before pay isPremium: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r5 = 0
            lg.a.C0856a.g(r0, r4, r1, r3, r5)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()
            boolean r3 = r1 instanceof androidx.appcompat.app.AppCompatActivity
            if (r3 == 0) goto L55
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            goto L56
        L55:
            r1 = r5
        L56:
            if (r1 == 0) goto L78
            com.transsion.payment.lib.f$a r3 = com.transsion.payment.lib.f.f47848b
            com.transsion.payment.lib.f r3 = r3.a()
            r4 = 0
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            com.transsion.member.MemberFragment$startPay$1$1 r7 = new com.transsion.member.MemberFragment$startPay$1$1
            r7.<init>()
            com.transsion.member.o r8 = new com.transsion.member.o
            r8.<init>()
            r5 = 0
            r6 = 0
            r0 = r3
            r2 = r10
            r3 = r4
            r4 = r5
            r5 = r11
            r0.e(r1, r2, r3, r4, r5, r6, r7, r8)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberFragment.q1(java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(MemberFragment memberFragment, String str, String orderId) {
        Intrinsics.h(orderId, "orderId");
        memberFragment.orderId = orderId;
        com.transsion.baselib.helper.f fVar = com.transsion.baselib.helper.f.f43323a;
        String str2 = memberFragment.sceneId;
        String str3 = memberFragment.traceId;
        if (str3 == null) {
            str3 = "";
        }
        com.transsion.baselib.helper.f.b(fVar, "memberdetail", str2, orderId, str3, str, null, 32, null);
        return Unit.f67184a;
    }

    private final void s1(float alpha) {
        wm.n mViewBinding;
        ConstraintLayout constraintLayout;
        if (!isAdded() || (mViewBinding = getMViewBinding()) == null || (constraintLayout = mViewBinding.f77954n) == null) {
            return;
        }
        constraintLayout.setBackgroundColor(I0(androidx.core.content.b.getColor(requireContext(), com.tn.lib.widget.R$color.gray_dark_00), RangesKt.h(alpha, 1.0f)));
    }

    private final void t1(UserInfo userInfo) {
        wm.n mViewBinding;
        ConstraintLayout.b bVar;
        if (userInfo == null || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        if (userInfo.getUserType() == 1) {
            View avatarBg = mViewBinding.f77942b;
            Intrinsics.g(avatarBg, "avatarBg");
            avatarBg.setVisibility(0);
            ShapeableImageView ivAvatarPremium = mViewBinding.f77945e;
            Intrinsics.g(ivAvatarPremium, "ivAvatarPremium");
            ivAvatarPremium.setVisibility(0);
            f.a aVar = ej.f.f62005a;
            Context context = mViewBinding.f77945e.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b i11 = aVar.m(context).g(userInfo.getAvatar()).i(com.tn.lib.widget.R$mipmap.profile_default_avatar);
            ShapeableImageView ivAvatarPremium2 = mViewBinding.f77945e;
            Intrinsics.g(ivAvatarPremium2, "ivAvatarPremium");
            i11.d(ivAvatarPremium2);
            mViewBinding.f77948h.setText(androidx.core.text.a.c().m(userInfo.getNickname(), androidx.core.text.u.f8333a));
            mViewBinding.f77948h.setOnClickListener(null);
            mViewBinding.f77948h.setCompoundDrawablesRelative(null, null, null, null);
            ViewGroup.LayoutParams layoutParams = mViewBinding.f77948h.getLayoutParams();
            ConstraintLayout.b bVar2 = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar2 != null) {
                bVar2.setMarginStart(gk.b.a(8));
            }
            mViewBinding.f77948h.requestLayout();
            ViewGroup.LayoutParams layoutParams2 = mViewBinding.f77957q.getLayoutParams();
            bVar = layoutParams2 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams2 : null;
            if (bVar != null) {
                bVar.setMarginStart(gk.b.a(8));
            }
            mViewBinding.f77957q.requestLayout();
            return;
        }
        View avatarBg2 = mViewBinding.f77942b;
        Intrinsics.g(avatarBg2, "avatarBg");
        avatarBg2.setVisibility(8);
        ShapeableImageView ivAvatarPremium3 = mViewBinding.f77945e;
        Intrinsics.g(ivAvatarPremium3, "ivAvatarPremium");
        ivAvatarPremium3.setVisibility(8);
        AppCompatTextView appCompatTextView = mViewBinding.f77948h;
        Context context2 = getContext();
        appCompatTextView.setText(context2 != null ? context2.getString(R$string.member_login) : null);
        AppCompatTextView appCompatTextView2 = mViewBinding.f77948h;
        Context context3 = getContext();
        appCompatTextView2.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, context3 != null ? context3.getDrawable(com.tn.lib.widget.R$mipmap.ic_arrow_right_for_member) : null, (Drawable) null);
        mViewBinding.f77948h.setCompoundDrawablePadding(0);
        AppCompatTextView ivName = mViewBinding.f77948h;
        Intrinsics.g(ivName, "ivName");
        jg.c.c(ivName, 0L, new Function1() { // from class: com.transsion.member.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u12;
                u12 = MemberFragment.u1(MemberFragment.this, (View) obj);
                return u12;
            }
        }, 1, null);
        ViewGroup.LayoutParams layoutParams3 = mViewBinding.f77948h.getLayoutParams();
        ConstraintLayout.b bVar3 = layoutParams3 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams3 : null;
        if (bVar3 != null) {
            bVar3.setMarginStart(gk.b.a(12));
        }
        mViewBinding.f77948h.requestLayout();
        ViewGroup.LayoutParams layoutParams4 = mViewBinding.f77957q.getLayoutParams();
        bVar = layoutParams4 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams4 : null;
        if (bVar != null) {
            bVar.setMarginStart(gk.b.a(12));
        }
        mViewBinding.f77957q.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(MemberFragment memberFragment, View it) {
        Intrinsics.h(it, "it");
        ILoginApi mLoginApi = memberFragment.getMLoginApi();
        if (mLoginApi != null) {
            mLoginApi.g(memberFragment);
        }
        ILoginApi mLoginApi2 = memberFragment.getMLoginApi();
        if (mLoginApi2 != null) {
            Context requireContext = memberFragment.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            mLoginApi2.j(requireContext);
        }
        return Unit.f67184a;
    }

    private final void v1() {
        String str;
        TextView textView;
        ImageView imageView;
        TextView textView2;
        TextView textView3;
        ImageView imageView2;
        Lottery lottery;
        Lottery lottery2;
        IRewardsCenterApi iRewardsCenterApi = (IRewardsCenterApi) TheRouter.d(IRewardsCenterApi.class, new Object[0]);
        RewardsCenterData a11 = iRewardsCenterApi != null ? iRewardsCenterApi.a() : null;
        if (a11 == null || (lottery2 = a11.getLottery()) == null || (str = lottery2.getActivityId()) == null) {
            str = "0";
        }
        boolean z10 = Integer.parseInt(str) > 0;
        String bgImage = (a11 == null || (lottery = a11.getLottery()) == null) ? null : lottery.getBgImage();
        if (z10) {
            wm.n mViewBinding = getMViewBinding();
            if (mViewBinding != null && (imageView2 = mViewBinding.f77952l) != null) {
                imageView2.setVisibility(0);
            }
            wm.n mViewBinding2 = getMViewBinding();
            ViewGroup.LayoutParams layoutParams = (mViewBinding2 == null || (textView3 = mViewBinding2.f77958r) == null) ? null : textView3.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.topMargin = gk.b.a(-20);
            }
            wm.n mViewBinding3 = getMViewBinding();
            ImageView imageView3 = mViewBinding3 != null ? mViewBinding3.f77952l : null;
            if (getContext() != null && imageView3 != null) {
                Glide.with(requireContext()).load2(bgImage).into(imageView3);
            }
        } else {
            wm.n mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (imageView = mViewBinding4.f77952l) != null) {
                imageView.setVisibility(8);
            }
            wm.n mViewBinding5 = getMViewBinding();
            Object layoutParams3 = (mViewBinding5 == null || (textView = mViewBinding5.f77958r) == null) ? null : textView.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
            if (layoutParams4 != null) {
                layoutParams4.topMargin = gk.b.a(16);
            }
        }
        wm.n mViewBinding6 = getMViewBinding();
        if (mViewBinding6 == null || (textView2 = mViewBinding6.f77958r) == null) {
            return;
        }
        textView2.requestLayout();
    }

    public final void L0() {
        if (N0().isAdded()) {
            N0().dismissAllowingStateLoss();
        } else {
            a.C0856a.g(lg.a.f68962a, "Dialog not is added", false, 2, null);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public wm.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wm.n c11 = wm.n.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        RelativeLayout relativeLayout;
        TextView textView;
        AppCompatImageView appCompatImageView;
        wm.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f77946f) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberFragment.R0(MemberFragment.this, view);
                }
            });
        }
        wm.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (textView = mViewBinding2.f77958r) != null) {
            jg.c.c(textView, 0L, new Function1() { // from class: com.transsion.member.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit S0;
                    S0 = MemberFragment.S0(MemberFragment.this, (View) obj);
                    return S0;
                }
            }, 1, null);
        }
        wm.n mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (relativeLayout = mViewBinding3.f77944d) == null) {
            return;
        }
        jg.c.c(relativeLayout, 0L, new Function1() { // from class: com.transsion.member.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = MemberFragment.T0(MemberFragment.this, (View) obj);
                return T0;
            }
        }, 1, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        ILoginApi mLoginApi;
        M0();
        if (getIsSelf() && (mLoginApi = getMLoginApi()) != null) {
            mLoginApi.g(this);
        }
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.member.s
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                MemberFragment.U0((ActivityResult) obj);
            }
        });
        wm.n mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            if (getActivity() instanceof MemberActivity) {
                mViewBinding.f77946f.setVisibility(0);
            } else {
                mViewBinding.f77946f.setVisibility(8);
            }
            mViewBinding.f77960t.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberFragment.V0(MemberFragment.this, view);
                }
            });
            J0();
            s1(0.0f);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        MemberViewModel O0 = O0();
        O0.D().j(getViewLifecycleOwner(), new d(new Function1() { // from class: com.transsion.member.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Z0;
                Z0 = MemberFragment.Z0(MemberFragment.this, (MemberDetail) obj);
                return Z0;
            }
        }));
        O0.K().j(getViewLifecycleOwner(), new d(new Function1() { // from class: com.transsion.member.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit a12;
                a12 = MemberFragment.a1(MemberFragment.this, (SkuData) obj);
                return a12;
            }
        }));
        O0.H().j(getViewLifecycleOwner(), new d(new Function1() { // from class: com.transsion.member.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit W0;
                W0 = MemberFragment.W0(MemberFragment.this, (RedeemResult) obj);
                return W0;
            }
        }));
        O0.M().j(getViewLifecycleOwner(), new d(new Function1() { // from class: com.transsion.member.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = MemberFragment.X0(MemberFragment.this, (zm.d) obj);
                return X0;
            }
        }));
        O0.L().j(getViewLifecycleOwner(), new d(new Function1() { // from class: com.transsion.member.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = MemberFragment.Y0(MemberFragment.this, (Pair) obj);
                return Y0;
            }
        }));
        O0().O();
        t1(this.mUserInfo);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        TextView textView;
        RecyclerView recyclerView;
        TextView textView2;
        RecyclerView recyclerView2;
        super.loadDefaultData();
        try {
            Result.Companion companion = Result.INSTANCE;
            IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
            boolean f11 = iMemberApi != null ? iMemberApi.f() : false;
            IMemberApi iMemberApi2 = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
            boolean c11 = iMemberApi2 != null ? iMemberApi2.c() : false;
            if (f11) {
                wm.n mViewBinding = getMViewBinding();
                if (mViewBinding != null && (recyclerView2 = mViewBinding.f77951k) != null) {
                    recyclerView2.setVisibility(0);
                }
                wm.n mViewBinding2 = getMViewBinding();
                if (mViewBinding2 != null && (textView2 = mViewBinding2.f77958r) != null) {
                    textView2.setText(getString(c11 ? R$string.member_renew_now : R$string.member_pay_now));
                }
            } else {
                wm.n mViewBinding3 = getMViewBinding();
                if (mViewBinding3 != null && (recyclerView = mViewBinding3.f77951k) != null) {
                    recyclerView.setVisibility(8);
                }
                wm.n mViewBinding4 = getMViewBinding();
                if (mViewBinding4 != null && (textView = mViewBinding4.f77958r) != null) {
                    textView.setText(getString(R$string.member_redeem));
                }
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
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
            java.lang.String r3 = r2.sourceValue
            java.lang.String r0 = "source"
            if (r3 == 0) goto L86
            hj.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto Lb7
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto Lb7
            java.lang.String r1 = r2.sourceValue
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
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberFragment.onCreate(android.os.Bundle):void");
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
                f1();
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // dz.a
    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        a.C0761a.a(this, user);
        f1();
        O0().y();
    }

    @Override // dz.a
    public void onLogout() {
        a.C0761a.b(this);
        f1();
        O0().y();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        RecyclerView recyclerView;
        super.onResume();
        f1();
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible(), 1, null);
        wm.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77951k) != null && recyclerView.getVisibility() == 0) {
            com.transsion.baselib.helper.f fVar = com.transsion.baselib.helper.f.f43323a;
            String str = this.sceneId;
            String str2 = str == null ? "" : str;
            String str3 = this.traceId;
            fVar.d("memberdetail", str2, str3 == null ? "" : str3, "", this.subjectId);
        }
        if (this.isFirstResume) {
            this.isFirstResume = false;
        } else {
            O0().y();
        }
    }

    @Override // dz.a
    public void onUpdateUserInfo(UserInfo user) {
        Intrinsics.h(user, "user");
        if (getIsSelf()) {
            t1(user);
        }
    }

    public final void p1(int points) {
        List<SkuItem> skuPointList;
        PointInfo pointInfo;
        MemberDetail memberDetail = this.memberDetail;
        if (memberDetail != null && (pointInfo = memberDetail.getPointInfo()) != null) {
            pointInfo.setPoint(points);
        }
        SkuData J = O0().J();
        if (J == null || (skuPointList = J.getSkuPointList()) == null) {
            return;
        }
        h1(skuPointList);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            IMemberApi.a.a(iMemberApi, null, 1, null);
        }
    }

    public final void showLoading() {
        N0().l0(this, "LoadingDialog");
    }
}
