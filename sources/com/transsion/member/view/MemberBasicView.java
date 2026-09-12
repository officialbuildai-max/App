package com.transsion.member.view;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import androidx.view.y0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.member.MemberViewModel;
import com.transsion.member.R$string;
import com.transsion.member.promotion.PromotionSelectionHelper;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberFeatureData;
import com.transsion.memberapi.MemberPriceItem;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.SkuPromotionItem;
import com.transsion.memberapi.SkuPromotionSku;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.RewardsCenterData;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import dz.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0097\u00012\u00020\u00012\u00020\u0002:\u0001ZB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ[\u0010\u0019\u001a\u00020\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0017¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0017¢\u0006\u0004\b,\u0010*J\u0015\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0017¢\u0006\u0004\b.\u0010*J\u0015\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0017¢\u0006\u0004\b0\u0010*J\u0015\u00102\u001a\u00020\r2\u0006\u00101\u001a\u00020\u0017¢\u0006\u0004\b2\u0010*J\r\u00103\u001a\u00020\r¢\u0006\u0004\b3\u0010\u001eJ+\u00109\u001a\u00020\r2\f\u00106\u001a\b\u0012\u0004\u0012\u000205042\u000e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000104¢\u0006\u0004\b9\u0010:J\u001b\u0010=\u001a\u00020\r2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;04¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\r2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\rH\u0016¢\u0006\u0004\bC\u0010\u001eJ\u0017\u0010F\u001a\u00020\r2\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010\u001eJ\u000f\u0010I\u001a\u00020\rH\u0002¢\u0006\u0004\bI\u0010\u001eJ!\u0010L\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020DH\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\rH\u0002¢\u0006\u0004\bN\u0010\u001eJ\u000f\u0010O\u001a\u00020\rH\u0002¢\u0006\u0004\bO\u0010\u001eJ\u0011\u0010Q\u001a\u0004\u0018\u00010PH\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u0017H\u0002¢\u0006\u0004\bT\u0010*J+\u0010W\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u00172\b\u0010U\u001a\u0004\u0018\u00010\u00072\b\u0010V\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\bW\u0010XR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u001b\u0010b\u001a\u00020]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010dR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR*\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010oR\u0018\u0010s\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010u\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010tR\u0016\u0010w\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010vR\u001d\u0010|\u001a\u0004\u0018\u00010x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010_\u001a\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010vR\u0017\u0010\u0082\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010vR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010~R\u0017\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bT\u0010\u0083\u0001R\u0017\u0010-\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bQ\u0010\u0083\u0001R\u0018\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R\u0018\u0010/\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R\u0017\u00101\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bL\u0010\u0083\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0083\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008f\u0001\u001a\u00030\u008b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008c\u0001\u0010_\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\"\u0010\u0096\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001¨\u0006\u0098\u0001"}, d2 = {"Lcom/transsion/member/view/MemberBasicView;", "Landroid/widget/LinearLayout;", "Ldz/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/app/Activity;", "activity", "", "setActivity", "(Landroid/app/Activity;)V", "Lkotlin/Function0;", "onClose", "onPurchaseSucceed", "Lcom/transsion/memberapi/MemberSource;", EventConstants.KEY_SOURCE, "Lkotlin/Function2;", "Landroidx/fragment/app/DialogFragment;", "", "showDialog", "init", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/transsion/memberapi/MemberSource;Lkotlin/jvm/functions/Function2;)V", "getScreenState", "()I", "onDestroy", "()V", "screenState", "setScreenState", "(I)V", "setOnClose", "(Lkotlin/jvm/functions/Function0;)V", "Lzm/f;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnPurchaseListener", "(Lzm/f;)V", "traceId", "setTraceId", "(Ljava/lang/String;)V", "sceneId", "setSceneId", "moduleName", "setModuleName", "subjectId", "setSubjectId", "pageName", "setPageName", "updateZeroTreasureState", "", "Lcom/transsion/memberapi/MemberPriceItem;", "data", "Lcom/transsion/memberapi/SkuPromotionItem;", "promotionItems", "setMemberGoodsData", "(Ljava/util/List;Ljava/util/List;)V", "Lcom/transsion/memberapi/MemberFeatureData;", "featureData", "setFeatureData", "(Ljava/util/List;)V", "Lcom/transsnet/loginapi/bean/UserInfo;", "user", "onLogin", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "onLogout", "", "isVisible", "onVisibilityAggregated", "(Z)V", CampaignEx.JSON_KEY_AD_K, "h", "productId", "isSubscription", TmcStartParams.KEY_URL_SHORT, "(Ljava/lang/String;Z)V", com.mbridge.msdk.foundation.same.report.j.f35620b, "o", "Landroidx/appcompat/app/AppCompatActivity;", CampaignEx.JSON_KEY_AD_R, "()Landroidx/appcompat/app/AppCompatActivity;", "skuId", CampaignEx.JSON_KEY_AD_Q, "code", "message", TtmlNode.TAG_P, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Lwm/s;", "a", "Lwm/s;", "binding", "Lcom/transsion/member/MemberViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "getMemberViewModel", "()Lcom/transsion/member/MemberViewModel;", "memberViewModel", "c", "Lkotlin/jvm/functions/Function0;", "d", "e", "Lcom/transsion/memberapi/MemberSource;", "f", "Lkotlin/jvm/functions/Function2;", "Lcom/transsion/memberapi/MemberDetail;", be.g.f16474b, "Lcom/transsion/memberapi/MemberDetail;", "memberDetail", "Lcom/transsion/member/adapter/e;", "Lcom/transsion/member/adapter/e;", "memberGoodsInfoAdapter", "i", "Lcom/transsion/memberapi/MemberPriceItem;", "selectedSkuItem", "Lcom/transsion/memberapi/SkuPromotionItem;", "selectedPromotionItem", "Z", "countDownFinished", "Lcom/transsnet/loginapi/ILoginApi;", "l", "getMLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", "m", "I", "defaultSelectedPosition", "n", "shouldRefreshPurchasedInfo", "isPremium", "Ljava/lang/String;", "s", "t", "v", "orderId", "w", "Ljava/lang/Boolean;", "lastVisible", "Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "x", "getMLoadingDialog", "()Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "mLoadingDialog", "y", "Lzm/f;", "purchaseListener", "Ljava/lang/ref/WeakReference;", "z", "Ljava/lang/ref/WeakReference;", "hostActivity", "Companion", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class MemberBasicView extends LinearLayout implements dz.a {
    public static final int SCREEN_ALL = 0;
    public static final int SCREEN_HALF = 1;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final wm.s binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy memberViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function0 onClose;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function0 onPurchaseSucceed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberSource source;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function2 showDialog;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private MemberDetail memberDetail;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.transsion.member.adapter.e memberGoodsInfoAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MemberPriceItem selectedSkuItem;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private SkuPromotionItem selectedPromotionItem;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean countDownFinished;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoginApi;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int defaultSelectedPosition;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean shouldRefreshPurchasedInfo;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isPremium;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int screenState;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private String sceneId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private String traceId;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String subjectId;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private String orderId;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private Boolean lastVisible;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoadingDialog;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private zm.f purchaseListener;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private WeakReference hostActivity;
    public static final int $stable = 8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberBasicView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberBasicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberBasicView(final Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        wm.s c11 = wm.s.c(LayoutInflater.from(context), this, true);
        Intrinsics.g(c11, "inflate(...)");
        this.binding = c11;
        this.memberViewModel = LazyKt.b(new Function0() { // from class: com.transsion.member.view.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MemberViewModel n11;
                n11 = MemberBasicView.n(MemberBasicView.this, context);
                return n11;
            }
        });
        this.mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.member.view.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi m11;
                m11 = MemberBasicView.m();
                return m11;
            }
        });
        this.defaultSelectedPosition = -1;
        this.sceneId = "";
        this.moduleName = "";
        this.traceId = "";
        this.subjectId = "";
        this.pageName = "";
        this.orderId = "";
        this.mLoadingDialog = LazyKt.b(new Function0() { // from class: com.transsion.member.view.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                BaseMemberLoadingDialog l11;
                l11 = MemberBasicView.l();
                return l11;
            }
        });
        setOrientation(1);
    }

    public /* synthetic */ MemberBasicView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final BaseMemberLoadingDialog getMLoadingDialog() {
        return (BaseMemberLoadingDialog) this.mLoadingDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginApi getMLoginApi() {
        return (ILoginApi) this.mLoginApi.getValue();
    }

    private final MemberViewModel getMemberViewModel() {
        return (MemberViewModel) this.memberViewModel.getValue();
    }

    private final void h() {
        com.transsion.baseui.widget.GradientTextView tvPayBtn = this.binding.f77997q;
        Intrinsics.g(tvPayBtn, "tvPayBtn");
        jg.c.c(tvPayBtn, 0L, new Function1() { // from class: com.transsion.member.view.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i11;
                i11 = MemberBasicView.i(MemberBasicView.this, (View) obj);
                return i11;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(MemberBasicView memberBasicView, View it) {
        String str;
        String skuId;
        Intrinsics.h(it, "it");
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null ? iMemberApi.f() : false) {
            SkuPromotionItem skuPromotionItem = memberBasicView.selectedPromotionItem;
            str = "";
            if (skuPromotionItem == null) {
                MemberPriceItem memberPriceItem = memberBasicView.selectedSkuItem;
                if (memberPriceItem != null) {
                    String skuId2 = memberPriceItem.getSkuId();
                    v(memberBasicView, skuId2 != null ? skuId2 : "", false, 2, null);
                }
            } else if (skuPromotionItem != null) {
                SkuPromotionSku sku = skuPromotionItem.getSku();
                if (sku != null && (skuId = sku.getSkuId()) != null) {
                    str = skuId;
                }
                v(memberBasicView, str, false, 2, null);
            }
        } else {
            Navigator.x(TheRouter.c("/rewards/center").K(EventConstants.KEY_SOURCE, "memberdetail"), null, null, 3, null);
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(MemberBasicView memberBasicView, Function0 function0, Function0 function02, MemberSource memberSource, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = null;
        }
        if ((i11 & 2) != 0) {
            function02 = null;
        }
        if ((i11 & 4) != 0) {
            memberSource = null;
        }
        if ((i11 & 8) != 0) {
            function2 = null;
        }
        memberBasicView.init(function0, function02, memberSource, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        ak.k.h("oneroom://com.community.oneroom/profile/user_center_labels_feedback", null, 1, null);
    }

    private final void k() {
        try {
            Result.Companion companion = Result.INSTANCE;
            int i11 = 0;
            IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
            boolean f11 = iMemberApi != null ? iMemberApi.f() : false;
            RecyclerView ivSkuList = this.binding.f77983c;
            Intrinsics.g(ivSkuList, "ivSkuList");
            if (!f11) {
                i11 = 8;
            }
            ivSkuList.setVisibility(i11);
            this.binding.getRoot().getLayoutParams().height = f11 ? -2 : gk.b.a(250);
            this.binding.f77997q.setText(getContext().getString(f11 ? R$string.member_pay_now : R$string.member_redeem));
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseMemberLoadingDialog l() {
        return new BaseMemberLoadingDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi m() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final MemberViewModel n(MemberBasicView memberBasicView, Context context) {
        WeakReference weakReference = memberBasicView.hostActivity;
        ComponentCallbacks2 componentCallbacks2 = weakReference != null ? (Activity) weakReference.get() : null;
        y0 y0Var = componentCallbacks2 instanceof y0 ? (y0) componentCallbacks2 : null;
        if (y0Var == null) {
            y0 y0Var2 = context instanceof y0 ? (y0) context : null;
            if (y0Var2 == null) {
                throw new IllegalStateException("MemberBasicView 必须在 ViewModelStoreOwner 上下文中使用，当前 context: " + context.getClass().getSimpleName() + "。若在 Dialog 中使用请先调用 setActivity()。");
            }
            y0Var = y0Var2;
        }
        return (MemberViewModel) new v0(y0Var).a(MemberViewModel.class);
    }

    private final void o() {
        getMemberViewModel().w();
        getMemberViewModel().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String skuId, Integer code, String message) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", "pay_result");
        hashMap.put("sku_id", skuId);
        hashMap.put("fail_code", String.valueOf(code));
        if (message == null) {
            message = "";
        }
        hashMap.put("fail_message", message);
        hashMap.put("order_id", this.orderId);
        hashMap.put("trace_id", this.traceId);
        hashMap.put("result_type", "result_fail");
        hashMap.put("scene_id", this.sceneId);
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi == null || (str = iPremiumApi.m()) == null) {
            str = "non-vip";
        }
        hashMap.put("membership_status", str);
        hj.i.f64628a.s(this.pageName, "purchase", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String skuId) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", "pay_result");
        hashMap.put("sku_id", skuId);
        hashMap.put("order_id", this.orderId);
        hashMap.put("trace_id", this.traceId);
        hashMap.put("result_type", "result_success");
        hashMap.put("scene_id", this.sceneId);
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi == null || (str = iPremiumApi.m()) == null) {
            str = "non-vip";
        }
        hashMap.put("membership_status", str);
        hj.i.f64628a.s(this.pageName, "purchase", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatActivity r() {
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || appCompatActivity.isDestroyed() || appCompatActivity.isFinishing()) {
            return null;
        }
        return appCompatActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MemberBasicView memberBasicView, MemberPriceItem item, SkuPromotionItem skuPromotionItem, boolean z10, View view) {
        Intrinsics.h(item, "item");
        Intrinsics.h(view, "<unused var>");
        memberBasicView.selectedSkuItem = item;
        memberBasicView.selectedPromotionItem = skuPromotionItem;
        memberBasicView.countDownFinished = z10;
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnClose$default(MemberBasicView memberBasicView, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = null;
        }
        memberBasicView.setOnClose(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MemberBasicView memberBasicView, SkuPromotionItem it) {
        Intrinsics.h(it, "it");
        memberBasicView.countDownFinished = true;
        return Unit.f67184a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (((r0 == null || (r0 = r0.getMemberInfo()) == null || r0.getMemberType() != 2) ? false : true) != false) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void u(final java.lang.String r12, boolean r13) {
        /*
            r11 = this;
            com.transsion.memberapi.SkuPromotionItem r0 = r11.selectedPromotionItem
            r1 = 0
            if (r0 == 0) goto L1b
            boolean r0 = r11.countDownFinished
            if (r0 == 0) goto L1b
            com.tn.lib.widget.toast.core.h r12 = com.tn.lib.widget.toast.core.h.f41533a
            android.content.Context r13 = r11.getContext()
            if (r13 == 0) goto L17
            int r0 = com.transsion.member.R$string.member_promotion_end
            java.lang.String r1 = r13.getString(r0)
        L17:
            r12.l(r1)
            return
        L1b:
            com.transsion.memberapi.MemberDetail r0 = r11.memberDetail
            r2 = 0
            if (r0 == 0) goto L2b
            com.transsion.memberapi.MemberInfo r0 = r0.getMemberInfo()
            if (r0 == 0) goto L2b
            boolean r0 = r0.isActive()
            goto L2c
        L2b:
            r0 = r2
        L2c:
            r3 = 2
            if (r0 == 0) goto L46
            com.transsion.memberapi.MemberDetail r0 = r11.memberDetail
            r4 = 1
            if (r0 == 0) goto L42
            com.transsion.memberapi.MemberInfo r0 = r0.getMemberInfo()
            if (r0 == 0) goto L42
            int r0 = r0.getMemberType()
            if (r0 != r3) goto L42
            r0 = r4
            goto L43
        L42:
            r0 = r2
        L43:
            if (r0 == 0) goto L46
            goto L47
        L46:
            r4 = r2
        L47:
            r11.isPremium = r4
            lg.a$a r0 = lg.a.f68962a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "MemberLayoutView before pay isPremium: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            lg.a.C0856a.g(r0, r4, r2, r3, r1)
            com.transsion.memberapi.MemberPriceItem r0 = r11.selectedSkuItem
            if (r0 == 0) goto L68
            java.lang.Double r0 = r0.getPrice()
            goto L69
        L68:
            r0 = r1
        L69:
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            com.transsion.memberapi.SkuPromotionItem r2 = r11.selectedPromotionItem
            if (r2 == 0) goto La5
            boolean r3 = r11.countDownFinished
            if (r3 != 0) goto La5
            if (r2 == 0) goto L84
            com.transsion.memberapi.SkuPromotionSku r0 = r2.getSku()
            if (r0 == 0) goto L84
            java.lang.Double r0 = r0.getDiscountPrice()
            if (r0 != 0) goto L94
        L84:
            com.transsion.memberapi.SkuPromotionItem r0 = r11.selectedPromotionItem
            if (r0 == 0) goto L93
            com.transsion.memberapi.SkuPromotionSku r0 = r0.getSku()
            if (r0 == 0) goto L93
            java.lang.Double r0 = r0.getPrice()
            goto L94
        L93:
            r0 = r1
        L94:
            com.transsion.memberapi.SkuPromotionItem r2 = r11.selectedPromotionItem
            if (r2 == 0) goto L9e
            java.lang.String r2 = r2.getMarketingActivityId()
            if (r2 != 0) goto La0
        L9e:
            java.lang.String r2 = ""
        La0:
            java.lang.String r3 = "marketingActivityId"
            r8.put(r3, r2)
        La5:
            r5 = r0
            com.transsion.payment.lib.f$a r0 = com.transsion.payment.lib.f.f47848b
            com.transsion.payment.lib.f r2 = r0.a()
            java.lang.ref.WeakReference r0 = r11.hostActivity
            if (r0 == 0) goto Lb7
            java.lang.Object r0 = r0.get()
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
        Lb7:
            java.lang.String r0 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            kotlin.jvm.internal.Intrinsics.f(r1, r0)
            r3 = r1
            androidx.appcompat.app.AppCompatActivity r3 = (androidx.appcompat.app.AppCompatActivity) r3
            com.transsion.member.view.MemberBasicView$startPay$1 r9 = new com.transsion.member.view.MemberBasicView$startPay$1
            r9.<init>()
            com.transsion.member.view.m r10 = new com.transsion.member.view.m
            r10.<init>()
            r6 = 0
            r4 = r12
            r7 = r13
            r2.e(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.view.MemberBasicView.u(java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void v(MemberBasicView memberBasicView, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        memberBasicView.u(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(MemberBasicView memberBasicView, String str, String orderId) {
        Intrinsics.h(orderId, "orderId");
        memberBasicView.orderId = orderId;
        com.transsion.baselib.helper.f.f43323a.a(memberBasicView.pageName, memberBasicView.sceneId, orderId, memberBasicView.traceId, str, memberBasicView.moduleName);
        return Unit.f67184a;
    }

    public final int getScreenState() {
        return this.screenState;
    }

    public final void init(Function0<Unit> onClose, Function0<Unit> onPurchaseSucceed, MemberSource source, Function2<? super DialogFragment, ? super String, Unit> showDialog) {
        this.onClose = onClose;
        this.onPurchaseSucceed = onPurchaseSucceed;
        this.source = source;
        this.showDialog = showDialog;
        h();
        updateZeroTreasureState();
        k();
    }

    public final void onDestroy() {
        this.onClose = null;
        this.onPurchaseSucceed = null;
        this.showDialog = null;
    }

    @Override // dz.a
    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        o();
    }

    @Override // dz.a
    public void onLogout() {
        o();
    }

    @Override // dz.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        a.C0761a.c(this, userInfo);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        if (Intrinsics.c(this.lastVisible, Boolean.valueOf(isVisible))) {
            return;
        }
        this.lastVisible = Boolean.valueOf(isVisible);
        if (isVisible) {
            RecyclerView ivSkuList = this.binding.f77983c;
            Intrinsics.g(ivSkuList, "ivSkuList");
            if (ivSkuList.getVisibility() == 0) {
                if (TextUtils.isEmpty(this.traceId)) {
                    String uuid = UUID.randomUUID().toString();
                    Intrinsics.g(uuid, "toString(...)");
                    this.traceId = uuid;
                }
                com.transsion.baselib.helper.f.f43323a.d(this.pageName, this.sceneId, this.traceId, this.moduleName, this.subjectId);
            }
        }
    }

    public final void setActivity(Activity activity) {
        Intrinsics.h(activity, "activity");
        this.hostActivity = new WeakReference(activity);
    }

    public final void setFeatureData(List<MemberFeatureData> featureData) {
        Intrinsics.h(featureData, "featureData");
        wm.s sVar = this.binding;
        int i11 = 0;
        List o11 = CollectionsKt.o(sVar.f77990j, sVar.f77991k, sVar.f77992l, sVar.f77993m, sVar.f77994n);
        wm.s sVar2 = this.binding;
        List o12 = CollectionsKt.o(sVar2.f77985e, sVar2.f77986f, sVar2.f77987g, sVar2.f77988h, sVar2.f77989i);
        for (Object obj : featureData) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            MemberFeatureData memberFeatureData = (MemberFeatureData) obj;
            if (i11 < o11.size()) {
                Glide.with(getContext()).load2(memberFeatureData.getFeatureIcon()).override(gk.b.a(20), gk.b.a(20)).into((ImageView) o11.get(i11));
                ((TextView) o12.get(i11)).setText(memberFeatureData.getFeatureName());
            }
            i11 = i12;
        }
    }

    public final void setMemberGoodsData(List<MemberPriceItem> data, List<SkuPromotionItem> promotionItems) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object obj;
        Intrinsics.h(data, "data");
        if (data.isEmpty()) {
            return;
        }
        com.transsion.member.adapter.e eVar = this.memberGoodsInfoAdapter;
        if (eVar == null) {
            com.transsion.member.adapter.e eVar2 = new com.transsion.member.adapter.e(CollectionsKt.U0(data));
            eVar2.I1(new Function4() { // from class: com.transsion.member.view.k
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit s11;
                    s11 = MemberBasicView.s(MemberBasicView.this, (MemberPriceItem) obj2, (SkuPromotionItem) obj3, ((Boolean) obj4).booleanValue(), (View) obj5);
                    return s11;
                }
            });
            eVar2.J1(new Function1() { // from class: com.transsion.member.view.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit t11;
                    t11 = MemberBasicView.t(MemberBasicView.this, (SkuPromotionItem) obj2);
                    return t11;
                }
            });
            eVar2.L1(1);
            this.memberGoodsInfoAdapter = eVar2;
            RecyclerView recyclerView = this.binding.f77983c;
            recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new com.transsion.member.adapter.a(3, com.blankj.utilcode.util.a0.a(8.0f)));
            }
            recyclerView.setAdapter(this.memberGoodsInfoAdapter);
        } else {
            List<MemberPriceItem> list = data;
            if (Intrinsics.c(eVar != null ? eVar.getData() : null, CollectionsKt.U0(list))) {
                return;
            }
            com.transsion.member.adapter.e eVar3 = this.memberGoodsInfoAdapter;
            if (eVar3 != null) {
                eVar3.n1(list);
            }
        }
        com.transsion.member.adapter.e eVar4 = this.memberGoodsInfoAdapter;
        if (eVar4 != null) {
            eVar4.M1(promotionItems);
        }
        List<SkuPromotionItem> list2 = promotionItems;
        if (list2 == null || list2.isEmpty()) {
            Iterator<T> it = data.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    Double price = ((MemberPriceItem) next).getPrice();
                    double doubleValue = price != null ? price.doubleValue() : Double.MAX_VALUE;
                    do {
                        Object next5 = it.next();
                        Double price2 = ((MemberPriceItem) next5).getPrice();
                        double doubleValue2 = price2 != null ? price2.doubleValue() : Double.MAX_VALUE;
                        if (Double.compare(doubleValue, doubleValue2) > 0) {
                            next = next5;
                            doubleValue = doubleValue2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MemberPriceItem memberPriceItem = (MemberPriceItem) next;
            this.defaultSelectedPosition = RangesKt.f(CollectionsKt.n0(data, memberPriceItem), 0);
            this.selectedSkuItem = memberPriceItem;
            this.selectedPromotionItem = null;
        } else {
            List<MemberPriceItem> list3 = data;
            ArrayList arrayList = new ArrayList();
            for (MemberPriceItem memberPriceItem2 : list3) {
                Iterator<T> it2 = promotionItems.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    SkuPromotionSku sku = ((SkuPromotionItem) obj).getSku();
                    if (Intrinsics.c(sku != null ? sku.getSkuId() : null, memberPriceItem2.getSkuId())) {
                        break;
                    }
                }
                SkuPromotionItem skuPromotionItem = (SkuPromotionItem) obj;
                Pair a11 = skuPromotionItem != null ? TuplesKt.a(memberPriceItem2, skuPromotionItem) : null;
                if (a11 != null) {
                    arrayList.add(a11);
                }
            }
            if (arrayList.isEmpty()) {
                Iterator<T> it3 = list3.iterator();
                if (it3.hasNext()) {
                    next4 = it3.next();
                    if (it3.hasNext()) {
                        Double price3 = ((MemberPriceItem) next4).getPrice();
                        double doubleValue3 = price3 != null ? price3.doubleValue() : Double.MAX_VALUE;
                        do {
                            Object next6 = it3.next();
                            Double price4 = ((MemberPriceItem) next6).getPrice();
                            double doubleValue4 = price4 != null ? price4.doubleValue() : Double.MAX_VALUE;
                            if (Double.compare(doubleValue3, doubleValue4) > 0) {
                                next4 = next6;
                                doubleValue3 = doubleValue4;
                            }
                        } while (it3.hasNext());
                    }
                } else {
                    next4 = null;
                }
                MemberPriceItem memberPriceItem3 = (MemberPriceItem) next4;
                this.defaultSelectedPosition = RangesKt.f(CollectionsKt.n0(data, memberPriceItem3), 0);
                this.selectedSkuItem = memberPriceItem3;
                this.selectedPromotionItem = null;
            } else if (arrayList.size() == 1) {
                Pair pair = (Pair) CollectionsKt.i0(arrayList);
                MemberPriceItem memberPriceItem4 = (MemberPriceItem) pair.component1();
                SkuPromotionItem skuPromotionItem2 = (SkuPromotionItem) pair.component2();
                if (PromotionSelectionHelper.f46725a.b(skuPromotionItem2)) {
                    Iterator<T> it4 = list3.iterator();
                    if (it4.hasNext()) {
                        next3 = it4.next();
                        if (it4.hasNext()) {
                            Double price5 = ((MemberPriceItem) next3).getPrice();
                            double doubleValue5 = price5 != null ? price5.doubleValue() : Double.MAX_VALUE;
                            do {
                                Object next7 = it4.next();
                                Double price6 = ((MemberPriceItem) next7).getPrice();
                                double doubleValue6 = price6 != null ? price6.doubleValue() : Double.MAX_VALUE;
                                if (Double.compare(doubleValue5, doubleValue6) > 0) {
                                    next3 = next7;
                                    doubleValue5 = doubleValue6;
                                }
                            } while (it4.hasNext());
                        }
                    } else {
                        next3 = null;
                    }
                    MemberPriceItem memberPriceItem5 = (MemberPriceItem) next3;
                    this.defaultSelectedPosition = RangesKt.f(CollectionsKt.n0(data, memberPriceItem5), 0);
                    this.selectedSkuItem = memberPriceItem5;
                    this.selectedPromotionItem = null;
                } else {
                    this.defaultSelectedPosition = data.indexOf(memberPriceItem4);
                    this.selectedSkuItem = memberPriceItem4;
                    this.selectedPromotionItem = skuPromotionItem2;
                }
            } else {
                Pair a12 = PromotionSelectionHelper.f46725a.a(arrayList);
                if (a12 != null) {
                    MemberPriceItem memberPriceItem6 = (MemberPriceItem) a12.component1();
                    SkuPromotionItem skuPromotionItem3 = (SkuPromotionItem) a12.component2();
                    this.defaultSelectedPosition = data.indexOf(memberPriceItem6);
                    this.selectedSkuItem = memberPriceItem6;
                    this.selectedPromotionItem = skuPromotionItem3;
                } else {
                    Iterator<T> it5 = list3.iterator();
                    if (it5.hasNext()) {
                        next2 = it5.next();
                        if (it5.hasNext()) {
                            Double price7 = ((MemberPriceItem) next2).getPrice();
                            double doubleValue7 = price7 != null ? price7.doubleValue() : Double.MAX_VALUE;
                            do {
                                Object next8 = it5.next();
                                Double price8 = ((MemberPriceItem) next8).getPrice();
                                double doubleValue8 = price8 != null ? price8.doubleValue() : Double.MAX_VALUE;
                                if (Double.compare(doubleValue7, doubleValue8) > 0) {
                                    next2 = next8;
                                    doubleValue7 = doubleValue8;
                                }
                            } while (it5.hasNext());
                        }
                    } else {
                        next2 = null;
                    }
                    MemberPriceItem memberPriceItem7 = (MemberPriceItem) next2;
                    this.defaultSelectedPosition = RangesKt.f(CollectionsKt.n0(data, memberPriceItem7), 0);
                    this.selectedSkuItem = memberPriceItem7;
                    this.selectedPromotionItem = null;
                }
            }
        }
        com.transsion.member.adapter.e eVar5 = this.memberGoodsInfoAdapter;
        if (eVar5 != null) {
            eVar5.K1(this.defaultSelectedPosition);
        }
    }

    public final void setModuleName(String moduleName) {
        Intrinsics.h(moduleName, "moduleName");
        this.moduleName = moduleName;
    }

    public final void setOnClose(Function0<Unit> onClose) {
        this.onClose = onClose;
    }

    public final void setOnPurchaseListener(zm.f listener) {
        Intrinsics.h(listener, "listener");
        this.purchaseListener = listener;
    }

    public final void setPageName(String pageName) {
        Intrinsics.h(pageName, "pageName");
        this.pageName = pageName;
    }

    public final void setSceneId(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.sceneId = sceneId;
    }

    public final void setScreenState(int screenState) {
        this.screenState = screenState;
    }

    public final void setSubjectId(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        this.subjectId = subjectId;
    }

    public final void setTraceId(String traceId) {
        Intrinsics.h(traceId, "traceId");
        this.traceId = traceId;
    }

    public final void updateZeroTreasureState() {
        String str;
        Lottery lottery;
        Lottery lottery2;
        IRewardsCenterApi iRewardsCenterApi = (IRewardsCenterApi) TheRouter.d(IRewardsCenterApi.class, new Object[0]);
        r2 = null;
        String str2 = null;
        RewardsCenterData a11 = iRewardsCenterApi != null ? iRewardsCenterApi.a() : null;
        if (a11 == null || (lottery2 = a11.getLottery()) == null || (str = lottery2.getActivityId()) == null) {
            str = "0";
        }
        if (Integer.parseInt(str) > 0) {
            ImageView ivZeroTreasure = this.binding.f77984d;
            Intrinsics.g(ivZeroTreasure, "ivZeroTreasure");
            ivZeroTreasure.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.binding.f77997q.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.topMargin = gk.b.a(-20);
            }
            RequestManager with = Glide.with(getContext());
            if (a11 != null && (lottery = a11.getLottery()) != null) {
                str2 = lottery.getBgImage();
            }
            Intrinsics.e(with.load2(str2).placeholder(R$color.transparent).into(this.binding.f77984d));
        } else {
            ImageView ivZeroTreasure2 = this.binding.f77984d;
            Intrinsics.g(ivZeroTreasure2, "ivZeroTreasure");
            ivZeroTreasure2.setVisibility(8);
            ViewGroup.LayoutParams layoutParams3 = this.binding.f77997q.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
            if (layoutParams4 != null) {
                layoutParams4.topMargin = gk.b.a(16);
            }
        }
        this.binding.f77997q.requestLayout();
    }
}
