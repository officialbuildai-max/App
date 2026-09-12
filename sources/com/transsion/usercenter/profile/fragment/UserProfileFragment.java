package com.transsion.usercenter.profile.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.palette.graphics.a;
import androidx.view.Lifecycle;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.gms.common.Scopes;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.publish.api.IPublishApi;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.view.UploadView;
import com.transsion.push.PushConstants;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$mipmap;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.profile.ProfileSubjectListViewModel;
import com.transsion.usercenter.profile.bean.BffUserProfileData;
import com.transsion.usercenter.profile.fragment.UserProfileFragment;
import com.transsion.usercenter.profile.fragment.UserProfileVideoFragment;
import com.transsion.usercenter.profile.viewmodel.UserProfileViewModel;
import com.transsion.usercenter.profile.widget.UserProfileTabTitleView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import fw.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010!\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0096\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J!\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010 \u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00050\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH\u0002¢\u0006\u0004\b#\u0010$J%\u0010(\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070%2\u0006\u0010'\u001a\u00020\u001cH\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0002¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u0010\u0004J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0005H\u0002¢\u0006\u0004\b4\u0010\u0004J\u0017\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001cH\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0005H\u0002¢\u0006\u0004\b=\u0010\u0004J\u0017\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0007H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0005H\u0016¢\u0006\u0004\bG\u0010\u0004J\u000f\u0010H\u001a\u00020\u0005H\u0016¢\u0006\u0004\bH\u0010\u0004J\u000f\u0010I\u001a\u00020\u0005H\u0016¢\u0006\u0004\bI\u0010\u0004J\u000f\u0010J\u001a\u00020\u0005H\u0016¢\u0006\u0004\bJ\u0010\u0004J\u0017\u0010M\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010YR\u0016\u0010]\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010PR\u0016\u0010_\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010PR\u0016\u0010b\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010aR\u0016\u0010h\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010aR\u0016\u0010j\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010aR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001c0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010p\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010aR\u0014\u0010r\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010aR\u0014\u0010t\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010aR\u0014\u0010v\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010aR\u0014\u0010x\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010aR\u0014\u0010z\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010aR\u0014\u0010|\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010aR\u0014\u0010~\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010aR\u0015\u0010\u0080\u0001\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010aR\u0016\u0010\u0082\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010aR\u0018\u0010\u0084\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010PR\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008d\u0001\u0010T\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0091\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0092\u0001\u0010T\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/transsion/usercenter/profile/fragment/UserProfileFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lfw/q0;", "<init>", "()V", "", "S0", "", "targetUserId", "Lcom/transsion/usercenter/profile/fragment/UserProfileVideoFragment;", "V0", "(Ljava/lang/String;)Lcom/transsion/usercenter/profile/fragment/UserProfileVideoFragment;", "Landroidx/fragment/app/Fragment;", "U0", "()Landroidx/fragment/app/Fragment;", "l1", "m1", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "indicator", "T0", "(Landroidx/viewpager2/widget/ViewPager2;Lnet/lucode/hackware/magicindicator/MagicIndicator;)V", "Lcom/transsion/usercenter/profile/bean/BffUserProfileData;", Scopes.PROFILE, "P0", "(Lcom/transsion/usercenter/profile/bean/BffUserProfileData;)V", "imageUrl", "", "fallbackColor", "Lkotlin/Function1;", "onColorReady", "W0", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "inputColor", "R0", "(I)I", "", "avatarUrls", "finalBfColor", "v1", "(Ljava/util/List;I)V", "", "subscribed", "x1", "(Z)V", "n1", "j1", "Landroid/content/Context;", "context", "w1", "(Landroid/content/Context;)V", "z1", "", "collapsePercentage", "O0", "(F)V", "verticalOffset", "totalScrollRange", "y1", "(II)V", "p1", "Landroid/view/LayoutInflater;", "inflater", "a1", "(Landroid/view/LayoutInflater;)Lfw/q0;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "initViewData", "initViewModel", "retryLoadData", "initListener", "Lcom/transsion/publish/bean/PublishResult;", NotificationCompat.CATEGORY_EVENT, "t1", "(Lcom/transsion/publish/bean/PublishResult;)V", "a", "Z", "isSubscribed", "Lcom/transsion/usercenter/profile/viewmodel/UserProfileViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "X0", "()Lcom/transsion/usercenter/profile/viewmodel/UserProfileViewModel;", "mViewModel", "c", "Ljava/lang/String;", "d", "fromOptId", "e", "lastSubscribeBeforeToggle", "f", "shouldShowSubscribeToast", be.g.f16474b, "I", "statusBarFixedHeight", "h", "titleBarFixedHeight", "i", "topContentExpandedHeight", com.mbridge.msdk.foundation.same.report.j.f35620b, "lastAppBarOffset", CampaignEx.JSON_KEY_AD_K, "lastAppBarTotalScrollRange", "", "l", "Ljava/util/List;", "tabTitleResIds", "m", "dp22", "n", "initialCoverSize", "o", "finalCoverSize", TtmlNode.TAG_P, "finalHeaderSize", CampaignEx.JSON_KEY_AD_Q, "finalMarginStart", CampaignEx.JSON_KEY_AD_R, "initialMarginStart", "s", "finalMarginTop", "t", "initialMarginTop", TmcStartParams.KEY_URL_SHORT, "collapsedTitlePaddingEnd", "v", "expandedTitlePaddingEnd", "w", "hasMarkLoadResult", "x", "Lcom/transsion/publish/bean/PublishResult;", "publishEventBean", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "y", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "firstUgcVideo", "Lcom/transsion/moviedetailapi/IMovieDetailService;", "z", "Y0", "()Lcom/transsion/moviedetailapi/IMovieDetailService;", "movieDetailService", "Lcom/transsion/publish/api/IPublishApi;", "A", "Z0", "()Lcom/transsion/publish/api/IPublishApi;", "publishedApi", "B", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UserProfileFragment extends PageStatusFragment<q0> {

    /* renamed from: B, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private final Lazy publishedApi;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isSubscribed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy mViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String targetUserId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String fromOptId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean lastSubscribeBeforeToggle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean shouldShowSubscribeToast;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int statusBarFixedHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int titleBarFixedHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int topContentExpandedHeight;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int lastAppBarOffset;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int lastAppBarTotalScrollRange;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final List tabTitleResIds;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int dp22;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int initialCoverSize;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int finalCoverSize;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int finalHeaderSize;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final int finalMarginStart;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final int initialMarginStart;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final int finalMarginTop;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final int initialMarginTop;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final int collapsedTitlePaddingEnd;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final int expandedTitlePaddingEnd;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean hasMarkLoadResult;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private PublishResult publishEventBean;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private UGCVideo firstUgcVideo;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final Lazy movieDetailService;

    /* renamed from: com.transsion.usercenter.profile.fragment.UserProfileFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserProfileFragment a(String str, String fromOptId) {
            Intrinsics.h(fromOptId, "fromOptId");
            UserProfileFragment userProfileFragment = new UserProfileFragment();
            Bundle bundle = new Bundle();
            bundle.putString("userId", str);
            bundle.putString("fromOptId", fromOptId);
            userProfileFragment.setArguments(bundle);
            return userProfileFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends FragmentStateAdapter {
        b() {
            super(UserProfileFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            if (i11 != 0) {
                Fragment U0 = UserProfileFragment.this.U0();
                if (U0 != null) {
                    return U0;
                }
                UserProfileFragment userProfileFragment = UserProfileFragment.this;
                return userProfileFragment.V0(userProfileFragment.targetUserId);
            }
            if (UserProfileFragment.this.tabTitleResIds.size() != 1) {
                UserProfileFragment userProfileFragment2 = UserProfileFragment.this;
                return userProfileFragment2.V0(userProfileFragment2.targetUserId);
            }
            Fragment U02 = UserProfileFragment.this.U0();
            if (U02 != null) {
                return U02;
            }
            UserProfileFragment userProfileFragment3 = UserProfileFragment.this;
            return userProfileFragment3.V0(userProfileFragment3.targetUserId);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UserProfileFragment.this.tabTitleResIds.size();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends ik.a {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f57290c;

        c(ViewPager2 viewPager2) {
            this.f57290c = viewPager2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(ViewPager2 viewPager2, int i11, View view) {
            viewPager2.setCurrentItem(i11, true);
        }

        @Override // j00.a
        public int a() {
            return UserProfileFragment.this.tabTitleResIds.size();
        }

        @Override // j00.a
        public j00.c b(Context context) {
            Intrinsics.h(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(2);
            linePagerIndicator.setLineHeight(0.0f);
            linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            linePagerIndicator.setColors(Integer.valueOf(androidx.core.content.b.getColor(context, R$color.transparent)));
            return linePagerIndicator;
        }

        @Override // j00.a
        public j00.d c(Context context, final int i11) {
            Intrinsics.h(context, "context");
            UserProfileTabTitleView userProfileTabTitleView = new UserProfileTabTitleView(context);
            UserProfileFragment userProfileFragment = UserProfileFragment.this;
            final ViewPager2 viewPager2 = this.f57290c;
            userProfileTabTitleView.setTextById(((Number) userProfileFragment.tabTitleResIds.get(i11)).intValue());
            userProfileTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.fragment.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserProfileFragment.c.j(ViewPager2.this, i11, view);
                }
            });
            return userProfileTabTitleView;
        }

        @Override // ik.a
        public LinearLayout.LayoutParams h(Context context, int i11) {
            Intrinsics.h(context, "context");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int a11 = com.blankj.utilcode.util.a0.a(6.0f);
            layoutParams.setMargins(a11, 0, a11, 0);
            return layoutParams;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MagicIndicator f57291a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UserProfileFragment f57292b;

        d(MagicIndicator magicIndicator, UserProfileFragment userProfileFragment) {
            this.f57291a = magicIndicator;
            this.f57292b = userProfileFragment;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            MagicIndicator magicIndicator = this.f57291a;
            if (magicIndicator != null) {
                magicIndicator.onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            MagicIndicator magicIndicator = this.f57291a;
            if (magicIndicator != null) {
                magicIndicator.onPageScrolled(i11, f11, i12);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            HashMap g11;
            super.onPageSelected(i11);
            MagicIndicator magicIndicator = this.f57291a;
            if (magicIndicator != null) {
                magicIndicator.onPageSelected(i11);
            }
            if (i11 < this.f57292b.tabTitleResIds.size()) {
                UserProfileFragment userProfileFragment = this.f57292b;
                String string = userProfileFragment.getString(((Number) userProfileFragment.tabTitleResIds.get(i11)).intValue());
                Intrinsics.g(string, "getString(...)");
                hj.b logViewConfig = this.f57292b.getLogViewConfig();
                if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements UserProfileVideoFragment.b {
        e() {
        }

        @Override // com.transsion.usercenter.profile.fragment.UserProfileVideoFragment.b
        public void a(Long l11, String str, UGCVideo uGCVideo) {
            HashMap g11;
            HashMap g12;
            String str2;
            if (UserProfileFragment.this.hasMarkLoadResult) {
                return;
            }
            UserProfileFragment.this.firstUgcVideo = uGCVideo;
            UserProfileFragment.this.hasMarkLoadResult = true;
            hj.b logViewConfig = UserProfileFragment.this.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            hj.b logViewConfig2 = UserProfileFragment.this.getLogViewConfig();
            if (logViewConfig2 != null && (g12 = logViewConfig2.g()) != null) {
                if (l11 == null || (str2 = l11.toString()) == null) {
                    str2 = "";
                }
            }
            hj.b logViewConfig3 = UserProfileFragment.this.getLogViewConfig();
            if (logViewConfig3 == null || (g11 = logViewConfig3.g()) == null) {
                return;
            }
            if (str == null) {
                str = "";
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends CustomTarget {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f57294a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UserProfileFragment f57295b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f57296c;

        f(Function1 function1, UserProfileFragment userProfileFragment, int i11) {
            this.f57294a = function1;
            this.f57295b = userProfileFragment;
            this.f57296c = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i11, Function1 function1, UserProfileFragment userProfileFragment, androidx.palette.graphics.a aVar) {
            a.e eVar;
            if (aVar == null || (eVar = aVar.i()) == null) {
                eVar = null;
                a.e o11 = aVar != null ? aVar.o() : null;
                if (o11 == null) {
                    o11 = aVar != null ? aVar.m() : null;
                    if (o11 == null) {
                        o11 = aVar != null ? aVar.g() : null;
                        if (o11 == null) {
                            o11 = aVar != null ? aVar.k() : null;
                            if (o11 == null) {
                                o11 = aVar != null ? aVar.f() : null;
                                if (o11 == null) {
                                    if (aVar != null) {
                                        eVar = aVar.j();
                                    }
                                }
                            }
                        }
                    }
                }
                eVar = o11;
            }
            if (eVar != null) {
                i11 = eVar.e();
            } else if (aVar != null) {
                i11 = aVar.h(i11);
            }
            function1.invoke(Integer.valueOf(userProfileFragment.R0(i11)));
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            this.f57294a.invoke(Integer.valueOf(this.f57295b.R0(this.f57296c)));
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Bitmap resource, Transition transition) {
            Intrinsics.h(resource, "resource");
            try {
                a.b a11 = androidx.palette.graphics.a.b(resource).a();
                final int i11 = this.f57296c;
                final Function1 function1 = this.f57294a;
                final UserProfileFragment userProfileFragment = this.f57295b;
                Intrinsics.e(a11.b(new a.d() { // from class: com.transsion.usercenter.profile.fragment.q
                    @Override // androidx.palette.graphics.a.d
                    public final void a(androidx.palette.graphics.a aVar) {
                        UserProfileFragment.f.b(i11, function1, userProfileFragment, aVar);
                    }
                }));
            } catch (Exception unused) {
                this.f57294a.invoke(Integer.valueOf(this.f57295b.R0(this.f57296c)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements ExpandView.c {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(UserProfileFragment userProfileFragment) {
            userProfileFragment.z1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(UserProfileFragment userProfileFragment) {
            userProfileFragment.y1(userProfileFragment.lastAppBarOffset, userProfileFragment.lastAppBarTotalScrollRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(UserProfileFragment userProfileFragment) {
            userProfileFragment.z1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(UserProfileFragment userProfileFragment) {
            userProfileFragment.y1(userProfileFragment.lastAppBarOffset, userProfileFragment.lastAppBarTotalScrollRange);
        }

        @Override // com.tn.lib.view.expand.ExpandView.c
        public void a(ExpandView expandView) {
            ConstraintLayout root;
            ExpandView expandView2;
            q0 mViewBinding = UserProfileFragment.this.getMViewBinding();
            if (mViewBinding != null && (expandView2 = mViewBinding.f62983d) != null) {
                final UserProfileFragment userProfileFragment = UserProfileFragment.this;
                expandView2.post(new Runnable() { // from class: com.transsion.usercenter.profile.fragment.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        UserProfileFragment.g.i(UserProfileFragment.this);
                    }
                });
            }
            q0 mViewBinding2 = UserProfileFragment.this.getMViewBinding();
            if (mViewBinding2 == null || (root = mViewBinding2.getRoot()) == null) {
                return;
            }
            final UserProfileFragment userProfileFragment2 = UserProfileFragment.this;
            root.post(new Runnable() { // from class: com.transsion.usercenter.profile.fragment.s
                @Override // java.lang.Runnable
                public final void run() {
                    UserProfileFragment.g.j(UserProfileFragment.this);
                }
            });
        }

        @Override // com.tn.lib.view.expand.ExpandView.c
        public void b(ExpandView expandView) {
            ConstraintLayout root;
            ExpandView expandView2;
            q0 mViewBinding = UserProfileFragment.this.getMViewBinding();
            if (mViewBinding != null && (expandView2 = mViewBinding.f62983d) != null) {
                final UserProfileFragment userProfileFragment = UserProfileFragment.this;
                expandView2.post(new Runnable() { // from class: com.transsion.usercenter.profile.fragment.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        UserProfileFragment.g.g(UserProfileFragment.this);
                    }
                });
            }
            q0 mViewBinding2 = UserProfileFragment.this.getMViewBinding();
            if (mViewBinding2 == null || (root = mViewBinding2.getRoot()) == null) {
                return;
            }
            final UserProfileFragment userProfileFragment2 = UserProfileFragment.this;
            root.post(new Runnable() { // from class: com.transsion.usercenter.profile.fragment.u
                @Override // java.lang.Runnable
                public final void run() {
                    UserProfileFragment.g.h(UserProfileFragment.this);
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends androidx.activity.u {
        h() {
            super(true);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            UserProfileFragment.this.l1();
        }
    }

    public UserProfileFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.profile.fragment.UserProfileFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UserProfileViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.profile.fragment.UserProfileFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.profile.fragment.UserProfileFragment$special$$inlined$viewModels$default$3
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
        this.tabTitleResIds = new ArrayList();
        this.dp22 = dk.a.b(24);
        this.initialCoverSize = dk.a.b(52);
        this.finalCoverSize = dk.a.b(24);
        this.finalHeaderSize = dk.a.b(28);
        this.finalMarginStart = dk.a.b(48);
        this.initialMarginStart = dk.a.b(12);
        this.finalMarginTop = dk.a.b(12);
        this.initialMarginTop = dk.a.b(54);
        this.collapsedTitlePaddingEnd = dk.a.b(105);
        this.movieDetailService = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.fragment.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IMovieDetailService i12;
                i12 = UserProfileFragment.i1();
                return i12;
            }
        });
        this.publishedApi = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.fragment.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IPublishApi o12;
                o12 = UserProfileFragment.o1();
                return o12;
            }
        });
    }

    private final void O0(float collapsePercentage) {
        AppCompatTextView appCompatTextView;
        RoomJoinAnimationView roomJoinAnimationView;
        q0 mViewBinding;
        RoomJoinAnimationView roomJoinAnimationView2;
        RoomJoinAnimationView roomJoinAnimationView3;
        q0 mViewBinding2;
        RoomJoinAnimationView roomJoinAnimationView4;
        RoomJoinAnimationView roomJoinAnimationView5;
        RoomJoinAnimationView roomJoinAnimationView6;
        ExpandView expandView;
        AppCompatImageView appCompatImageView;
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i11 = this.initialCoverSize;
        float f11 = i11 - ((i11 - this.finalCoverSize) * collapsePercentage);
        float f12 = i11 - ((i11 - this.finalHeaderSize) * collapsePercentage);
        float f13 = this.initialMarginStart - ((r0 - this.finalMarginStart) * collapsePercentage);
        float f14 = this.initialMarginTop - ((r0 - this.finalMarginTop) * collapsePercentage);
        q0 mViewBinding3 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = (mViewBinding3 == null || (linearLayout2 = mViewBinding3.f62992m) == null) ? null : linearLayout2.getLayoutParams();
        Intrinsics.f(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams.setMarginStart((int) f13);
        marginLayoutParams.topMargin = (int) f14;
        marginLayoutParams.height = (int) f12;
        q0 mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (linearLayout = mViewBinding4.f62992m) != null) {
            linearLayout.setLayoutParams(marginLayoutParams);
        }
        q0 mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (shapeableImageView2 = mViewBinding5.f62988i) != null) {
            layoutParams = shapeableImageView2.getLayoutParams();
        }
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int i12 = (int) f11;
        layoutParams.width = i12;
        layoutParams.height = i12;
        q0 mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (shapeableImageView = mViewBinding6.f62988i) != null) {
            shapeableImageView.setLayoutParams(layoutParams);
        }
        float f15 = 2 * collapsePercentage;
        if (f15 > 1.0f) {
            f15 = 1.0f;
        }
        q0 mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (appCompatImageView = mViewBinding7.f62989j) != null) {
            appCompatImageView.setAlpha(1 - f15);
        }
        q0 mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (expandView = mViewBinding8.f62983d) != null) {
            expandView.setAlpha(1 - f15);
        }
        if (!Intrinsics.c(X0().q().f(), Boolean.TRUE)) {
            q0 mViewBinding9 = getMViewBinding();
            if (mViewBinding9 != null && (roomJoinAnimationView6 = mViewBinding9.f62998s) != null) {
                roomJoinAnimationView6.setAlpha(1 - f15);
            }
            boolean z10 = ((float) 1) - f15 > 0.0f;
            q0 mViewBinding10 = getMViewBinding();
            if (((mViewBinding10 == null || (roomJoinAnimationView5 = mViewBinding10.f62998s) == null || roomJoinAnimationView5.getVisibility() != 0) ? false : true) != z10 && (mViewBinding2 = getMViewBinding()) != null && (roomJoinAnimationView4 = mViewBinding2.f62998s) != null) {
                roomJoinAnimationView4.setVisibility((!z10 || ak.o.f721a.i()) ? 8 : 0);
            }
            boolean z11 = collapsePercentage > 0.5f && !this.isSubscribed;
            q0 mViewBinding11 = getMViewBinding();
            if (((mViewBinding11 == null || (roomJoinAnimationView3 = mViewBinding11.f62999t) == null || roomJoinAnimationView3.getVisibility() != 0) ? false : true) != z11 && (mViewBinding = getMViewBinding()) != null && (roomJoinAnimationView2 = mViewBinding.f62999t) != null) {
                roomJoinAnimationView2.setVisibility((!z11 || ak.o.f721a.i()) ? 8 : 0);
            }
        }
        q0 mViewBinding12 = getMViewBinding();
        int i13 = (mViewBinding12 == null || (roomJoinAnimationView = mViewBinding12.f62999t) == null || roomJoinAnimationView.getVisibility() != 0) ? this.expandedTitlePaddingEnd : this.collapsedTitlePaddingEnd;
        q0 mViewBinding13 = getMViewBinding();
        if (mViewBinding13 == null || (appCompatTextView = mViewBinding13.f62997r) == null) {
            return;
        }
        appCompatTextView.setPaddingRelative(appCompatTextView.getPaddingStart(), appCompatTextView.getPaddingTop(), i13, appCompatTextView.getPaddingBottom());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
    
        if (r3 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void P0(com.transsion.usercenter.profile.bean.BffUserProfileData r10) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.profile.fragment.UserProfileFragment.P0(com.transsion.usercenter.profile.bean.BffUserProfileData):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(UserProfileFragment userProfileFragment, List list, q0 q0Var, int i11) {
        userProfileFragment.v1(list, i11);
        q0Var.getRoot().findViewById(R$id.v_top_bg_color).setBackgroundColor(i11);
        q0Var.f62985f.setBackgroundColor(i11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R0(int inputColor) {
        float[] fArr = new float[3];
        Color.colorToHSV(inputColor, fArr);
        return Color.HSVToColor(new float[]{fArr[0], fArr[1], RangesKt.h(fArr[2], 0.6f)});
    }

    private final void S0() {
        ViewPager2 viewPager2;
        q0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (viewPager2 = mViewBinding.f63003x) == null) {
            return;
        }
        viewPager2.setAdapter(new b());
        q0 mViewBinding2 = getMViewBinding();
        T0(viewPager2, mViewBinding2 != null ? mViewBinding2.f62993n : null);
    }

    private final void T0(ViewPager2 viewPager, MagicIndicator indicator) {
        if (indicator != null) {
            ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(requireContext());
            oRCommonNavigator.setFollowTouch(true);
            oRCommonNavigator.setAdapter(new c(viewPager));
            indicator.setNavigator(oRCommonNavigator);
        }
        viewPager.registerOnPageChangeCallback(new d(indicator, this));
        if (indicator != null) {
            indicator.onPageSelected(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment U0() {
        Bundle bundle = new Bundle();
        bundle.putInt(EventConstants.KEY_SOURCE, 0);
        bundle.putString("userId", this.targetUserId);
        IMovieDetailService Y0 = Y0();
        if (Y0 != null) {
            return Y0.e(bundle, ProfileSubjectListViewModel.class);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserProfileVideoFragment V0(String targetUserId) {
        UserProfileVideoFragment a11 = UserProfileVideoFragment.INSTANCE.a(targetUserId);
        a11.m0(new e());
        return a11;
    }

    private final void W0(String imageUrl, int fallbackColor, Function1 onColorReady) {
        if (imageUrl == null || StringsKt.q0(imageUrl)) {
            onColorReady.invoke(Integer.valueOf(R0(fallbackColor)));
        } else {
            Glide.with(requireContext()).asBitmap().load2(imageUrl).into((RequestBuilder<Bitmap>) new f(onColorReady, this, fallbackColor));
        }
    }

    private final UserProfileViewModel X0() {
        return (UserProfileViewModel) this.mViewModel.getValue();
    }

    private final IMovieDetailService Y0() {
        return (IMovieDetailService) this.movieDetailService.getValue();
    }

    private final IPublishApi Z0() {
        return (IPublishApi) this.publishedApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(UserProfileFragment userProfileFragment, View view) {
        userProfileFragment.m1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(UserProfileFragment userProfileFragment, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        FragmentActivity activity = userProfileFragment.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(UserProfileFragment userProfileFragment, View view) {
        userProfileFragment.m1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(UserProfileFragment userProfileFragment, AppBarLayout appBarLayout, int i11) {
        userProfileFragment.lastAppBarOffset = i11;
        userProfileFragment.lastAppBarTotalScrollRange = appBarLayout.getTotalScrollRange();
        userProfileFragment.O0(Math.abs(i11) / appBarLayout.getTotalScrollRange());
        userProfileFragment.y1(i11, appBarLayout.getTotalScrollRange());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(UserProfileFragment userProfileFragment, View view) {
        userProfileFragment.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(UserProfileFragment userProfileFragment, View view) {
        lg.a.f68962a.c("Userpage", "click iv_publish", false);
        userProfileFragment.n1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMovieDetailService i1() {
        return (IMovieDetailService) TheRouter.d(IMovieDetailService.class, new Object[0]);
    }

    private final void j1() {
        Object context = getContext();
        if (context instanceof ComponentActivity) {
            Function1 function1 = new Function1() { // from class: com.transsion.usercenter.profile.fragment.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k12;
                    k12 = UserProfileFragment.k1(UserProfileFragment.this, (PublishResult) obj);
                    return k12;
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishResult.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.observeEvent((androidx.view.u) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(UserProfileFragment userProfileFragment, PublishResult evt) {
        Intrinsics.h(evt, "evt");
        userProfileFragment.t1(evt);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void m1() {
        String str;
        RoomJoinAnimationView roomJoinAnimationView;
        RoomJoinAnimationView roomJoinAnimationView2;
        UserInfo i11;
        if (com.transsion.baseui.util.c.f43558a.a(2, 2000L) || (str = this.targetUserId) == null || Intrinsics.c(X0().q().f(), Boolean.TRUE)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", PushConstants.TOPIC_SUBSCRIBE);
        hashMap.put("page_tab_name", getString(R$string.profile_video));
        String str2 = this.targetUserId;
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        hashMap.put("uploader_type", Intrinsics.c(str2, (iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId()) ? "me" : "others");
        com.transsion.baselib.helper.a.f43316a.f("Userpage", hashMap);
        boolean z10 = this.isSubscribed;
        this.lastSubscribeBeforeToggle = z10;
        boolean z11 = !z10;
        q0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (roomJoinAnimationView2 = mViewBinding.f62998s) != null) {
            roomJoinAnimationView2.setStatus(RoomJoinStatus.LOADING);
        }
        q0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (roomJoinAnimationView = mViewBinding2.f62999t) != null) {
            roomJoinAnimationView.setStatus(RoomJoinStatus.LOADING);
        }
        this.shouldShowSubscribeToast = true;
        lg.a.f68962a.c("Userpage", "click subscribe toggle -> " + z11, false);
        X0().u(str, z11);
    }

    private final void n1() {
        IPublishApi Z0;
        Context context = getContext();
        if (context == null || (Z0 = Z0()) == null) {
            return;
        }
        Z0.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPublishApi o1() {
        return (IPublishApi) TheRouter.d(IPublishApi.class, new Object[0]);
    }

    private final void p1() {
        X0().q().j(getViewLifecycleOwner(), new v(new Function1() { // from class: com.transsion.usercenter.profile.fragment.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q12;
                q12 = UserProfileFragment.q1(UserProfileFragment.this, (Boolean) obj);
                return q12;
            }
        }));
        X0().n().j(getViewLifecycleOwner(), new v(new Function1() { // from class: com.transsion.usercenter.profile.fragment.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r12;
                r12 = UserProfileFragment.r1(UserProfileFragment.this, (Boolean) obj);
                return r12;
            }
        }));
        X0().o().j(getViewLifecycleOwner(), new v(new Function1() { // from class: com.transsion.usercenter.profile.fragment.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s12;
                s12 = UserProfileFragment.s1(UserProfileFragment.this, (BffUserProfileData) obj);
                return s12;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(UserProfileFragment userProfileFragment, Boolean bool) {
        AppCompatImageView appCompatImageView;
        RoomJoinAnimationView roomJoinAnimationView;
        RoomJoinAnimationView roomJoinAnimationView2;
        q0 mViewBinding = userProfileFragment.getMViewBinding();
        if (mViewBinding != null && (roomJoinAnimationView2 = mViewBinding.f62998s) != null) {
            roomJoinAnimationView2.setVisibility((Intrinsics.c(bool, Boolean.TRUE) || ak.o.f721a.i()) ? 8 : 0);
        }
        q0 mViewBinding2 = userProfileFragment.getMViewBinding();
        if (mViewBinding2 != null && (roomJoinAnimationView = mViewBinding2.f62999t) != null) {
            roomJoinAnimationView.setVisibility((Intrinsics.c(bool, Boolean.TRUE) || ak.o.f721a.i()) ? 8 : 0);
        }
        q0 mViewBinding3 = userProfileFragment.getMViewBinding();
        if (mViewBinding3 != null && (appCompatImageView = mViewBinding3.f62987h) != null) {
            appCompatImageView.setVisibility(Intrinsics.c(bool, Boolean.TRUE) ? 0 : 8);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        if (r7 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit r1(com.transsion.usercenter.profile.fragment.UserProfileFragment r6, java.lang.Boolean r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L43
            boolean r7 = r7.booleanValue()
            r6.x1(r7)
            java.lang.String r1 = r6.targetUserId
            if (r1 == 0) goto L40
            ov.d r2 = new ov.d
            r2.<init>(r1, r7)
            com.transsnet.flow.event.AppScopeVMlProvider r1 = com.transsnet.flow.event.AppScopeVMlProvider.INSTANCE
            java.lang.Class<com.transsnet.flow.event.FlowEventBus> r3 = com.transsnet.flow.event.FlowEventBus.class
            androidx.lifecycle.t0 r1 = r1.getApplicationScopeViewModel(r3)
            com.transsnet.flow.event.FlowEventBus r1 = (com.transsnet.flow.event.FlowEventBus) r1
            java.lang.Class<ov.d> r3 = ov.d.class
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            r4 = 0
            r1.postEvent(r3, r2, r4)
            boolean r1 = r6.shouldShowSubscribeToast
            if (r1 == 0) goto L3d
            if (r7 == 0) goto L36
            int r7 = com.transsion.baseui.R$string.ugc_video_detail_followed
            goto L38
        L36:
            int r7 = com.transsion.baseui.R$string.ugc_video_detail_unfollowed
        L38:
            com.transsion.baseui.util.m.c(r7)
            r6.shouldShowSubscribeToast = r0
        L3d:
            kotlin.Unit r7 = kotlin.Unit.f67184a
            goto L41
        L40:
            r7 = 0
        L41:
            if (r7 != 0) goto L4a
        L43:
            boolean r7 = r6.lastSubscribeBeforeToggle
            r6.x1(r7)
            r6.shouldShowSubscribeToast = r0
        L4a:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.profile.fragment.UserProfileFragment.r1(com.transsion.usercenter.profile.fragment.UserProfileFragment, java.lang.Boolean):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(UserProfileFragment userProfileFragment, BffUserProfileData bffUserProfileData) {
        if (bffUserProfileData != null) {
            userProfileFragment.P0(bffUserProfileData);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(UserProfileFragment userProfileFragment) {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        userProfileFragment.w1(a11);
    }

    private final void v1(List avatarUrls, int finalBfColor) {
        q0 mViewBinding;
        if (!isAdded() || isDetached() || isRemoving() || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        PileLayout plMemberIc = mViewBinding.f62994o;
        Intrinsics.g(plMemberIc, "plMemberIc");
        plMemberIc.removeAllViews();
        int i11 = this.dp22;
        ColorStateList valueOf = ColorStateList.valueOf(finalBfColor);
        Intrinsics.g(valueOf, "valueOf(...)");
        ab.n m11 = ab.n.a().q(0, 10.0f).p(ab.n.f601m).m();
        Intrinsics.g(m11, "build(...)");
        for (String str : CollectionsKt.K0(avatarUrls, 8)) {
            ShapeableImageView shapeableImageView = new ShapeableImageView(requireContext());
            shapeableImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            shapeableImageView.setShapeAppearanceModel(m11);
            shapeableImageView.setStrokeWidth(dk.a.b(2));
            shapeableImageView.setStrokeColor(valueOf);
            int b11 = dk.a.b(1);
            shapeableImageView.setPadding(b11, b11, b11, b11);
            f.a aVar = ej.f.f62005a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            aVar.m(requireContext).g(str).i(R$mipmap.profile_visitor_avatar).m(i11).c(i11).d(shapeableImageView);
            plMemberIc.addView(shapeableImageView, i11, i11);
        }
        if (avatarUrls.size() > 8) {
            FrameLayout frameLayout = new FrameLayout(requireContext());
            View view = new View(requireContext());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(valueOf.getDefaultColor());
            view.setBackground(gradientDrawable);
            ShapeableImageView shapeableImageView2 = new ShapeableImageView(requireContext());
            shapeableImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            shapeableImageView2.setShapeAppearanceModel(m11);
            shapeableImageView2.setStrokeWidth(dk.a.b(2));
            shapeableImageView2.setStrokeColor(valueOf);
            int b12 = dk.a.b(1);
            shapeableImageView2.setPadding(b12, b12, b12, b12);
            shapeableImageView2.setImageResource(R$drawable.ic_member_more);
            frameLayout.addView(view, new FrameLayout.LayoutParams(i11, i11));
            frameLayout.addView(shapeableImageView2, new FrameLayout.LayoutParams(i11, i11));
            plMemberIc.addView(frameLayout, i11, i11);
        }
    }

    private final void w1(Context context) {
        UploadView uploadView = new UploadView(context);
        uploadView.setPageName("Userpage");
        if (!uploadView.getIsShow()) {
            uploadView.setVisibility(0);
            uploadView.setAlpha(1.0f);
            Activity b11 = com.blankj.utilcode.util.a.b();
            if (b11 == null || b11.isFinishing() || b11.isDestroyed()) {
                b11 = com.blankj.utilcode.util.a.b();
            }
            if (b11 == null || b11.isFinishing() || b11.isDestroyed()) {
                return;
            } else {
                uploadView.show(b11);
            }
        }
        uploadView.showFloatView(this.publishEventBean);
    }

    private final void x1(boolean subscribed) {
        RoomJoinAnimationView roomJoinAnimationView;
        RoomJoinAnimationView roomJoinAnimationView2;
        this.isSubscribed = subscribed;
        RoomJoinStatus roomJoinStatus = subscribed ? RoomJoinStatus.JOINED : RoomJoinStatus.JOIN;
        q0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (roomJoinAnimationView2 = mViewBinding.f62998s) != null) {
            roomJoinAnimationView2.setStatus(roomJoinStatus);
        }
        q0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (roomJoinAnimationView = mViewBinding2.f62999t) == null) {
            return;
        }
        roomJoinAnimationView.setStatus(roomJoinStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(int verticalOffset, int totalScrollRange) {
        q0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && totalScrollRange >= 0) {
            mViewBinding.f62991l.setAlpha(1.0f - (totalScrollRange == 0 ? 0.0f : Math.abs(verticalOffset) / totalScrollRange));
            if (this.statusBarFixedHeight == 0 || this.topContentExpandedHeight == 0) {
                this.statusBarFixedHeight = mViewBinding.f62990k.getHeight();
                this.titleBarFixedHeight = mViewBinding.f63000u.getHeight();
                this.topContentExpandedHeight = mViewBinding.f62982c.getHeight();
            }
            int i11 = this.topContentExpandedHeight;
            if (i11 == 0) {
                return;
            }
            int f11 = this.statusBarFixedHeight + this.titleBarFixedHeight + RangesKt.f(i11 - Math.abs(verticalOffset), 0);
            View findViewById = mViewBinding.getRoot().findViewById(R$id.v_top_bg_color);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (((ViewGroup.MarginLayoutParams) bVar).height != f11) {
                ((ViewGroup.MarginLayoutParams) bVar).height = f11 + 300;
                findViewById.setLayoutParams(bVar);
            }
            ViewGroup.LayoutParams layoutParams2 = mViewBinding.f62991l.getLayoutParams();
            Intrinsics.f(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
            if (((ViewGroup.MarginLayoutParams) bVar2).height != f11) {
                ((ViewGroup.MarginLayoutParams) bVar2).height = f11;
                mViewBinding.f62991l.setLayoutParams(bVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1() {
        final q0 mViewBinding = getMViewBinding();
        if (mViewBinding == null) {
            return;
        }
        mViewBinding.getRoot().post(new Runnable() { // from class: com.transsion.usercenter.profile.fragment.UserProfileFragment$updateTopMaskHeight$tryUpdate$1
            @Override // java.lang.Runnable
            public void run() {
                int height = q0.this.f62990k.getHeight();
                int height2 = q0.this.f63000u.getHeight();
                int height3 = q0.this.f62982c.getHeight();
                int i11 = height + height2 + height3;
                if (i11 <= 0) {
                    q0.this.getRoot().post(this);
                    return;
                }
                this.statusBarFixedHeight = height;
                this.titleBarFixedHeight = height2;
                this.topContentExpandedHeight = height3;
                View findViewById = q0.this.getRoot().findViewById(R$id.v_top_bg_color);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).height = i11 + 300;
                findViewById.setLayoutParams(bVar);
                ViewGroup.LayoutParams layoutParams2 = q0.this.f62991l.getLayoutParams();
                Intrinsics.f(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
                ((ViewGroup.MarginLayoutParams) bVar2).height = i11;
                q0.this.f62991l.setLayoutParams(bVar2);
                View ivTopBg = q0.this.f62990k;
                Intrinsics.g(ivTopBg, "ivTopBg");
                jg.c.e(ivTopBg);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public q0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        q0 c11 = q0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        RoomJoinAnimationView roomJoinAnimationView;
        RoomJoinAnimationView roomJoinAnimationView2;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        q0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView2 = mViewBinding.f62986g) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserProfileFragment.c1(UserProfileFragment.this, view);
                }
            });
        }
        q0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f62989j) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.fragment.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserProfileFragment.d1(view);
                }
            });
        }
        q0 mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (roomJoinAnimationView2 = mViewBinding3.f62998s) != null) {
            roomJoinAnimationView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserProfileFragment.e1(UserProfileFragment.this, view);
                }
            });
        }
        q0 mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (roomJoinAnimationView = mViewBinding4.f62999t) == null) {
            return;
        }
        roomJoinAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.fragment.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserProfileFragment.b1(UserProfileFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        AppCompatImageView appCompatImageView;
        OnBackPressedDispatcher onBackPressedDispatcher;
        AppCompatImageView appCompatImageView2;
        AppBarLayout appBarLayout;
        View view;
        ExpandView expandView;
        q0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (expandView = mViewBinding.f62983d) != null) {
            expandView.setExpandListener(new g());
        }
        q0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (view = mViewBinding2.f62990k) != null) {
            jg.c.e(view);
        }
        q0 mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appBarLayout = mViewBinding3.f62981b) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.usercenter.profile.fragment.b
                @Override // com.google.android.material.appbar.AppBarLayout.b
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i11) {
                    UserProfileFragment.f1(UserProfileFragment.this, appBarLayout2, i11);
                }
            });
        }
        q0 mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView2 = mViewBinding4.f62986g) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.fragment.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UserProfileFragment.g1(UserProfileFragment.this, view2);
                }
            });
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            androidx.view.u viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.g(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            onBackPressedDispatcher.i(viewLifecycleOwner, new h());
        }
        z1();
        q0 mViewBinding5 = getMViewBinding();
        if (mViewBinding5 == null || (appCompatImageView = mViewBinding5.f62987h) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserProfileFragment.h1(UserProfileFragment.this, view2);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        String userId;
        UserInfo i11;
        HashMap g11;
        HashMap g12;
        UserInfo i12;
        HashMap g13;
        HashMap g14;
        hj.b logViewConfig;
        HashMap g15;
        Bundle arguments = getArguments();
        String str = null;
        if (arguments == null || (userId = arguments.getString("userId")) == null) {
            ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
            userId = (iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId();
        }
        this.targetUserId = userId;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("fromOptId") : null;
        this.fromOptId = string;
        if (string != null && (logViewConfig = getLogViewConfig()) != null && (g15 = logViewConfig.g()) != null) {
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g14 = logViewConfig2.g()) != null) {
        }
        hj.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g13 = logViewConfig3.g()) != null) {
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g12 = logViewConfig4.g()) != null) {
            String str2 = this.targetUserId;
            ILoginApi iLoginApi2 = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
            if (iLoginApi2 != null && (i12 = iLoginApi2.i()) != null) {
                str = i12.getUserId();
            }
        }
        if (!this.tabTitleResIds.isEmpty()) {
            String string2 = getString(((Number) this.tabTitleResIds.get(0)).intValue());
            Intrinsics.g(string2, "getString(...)");
            hj.b logViewConfig5 = getLogViewConfig();
            if (logViewConfig5 != null && (g11 = logViewConfig5.g()) != null) {
            }
        }
        p1();
        X0().p(this.targetUserId);
        j1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("Userpage", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        UserProfileViewModel X0 = X0();
        String str = this.targetUserId;
        if (str == null) {
            str = "";
        }
        X0.p(str);
    }

    public final void t1(PublishResult event) {
        q0 mViewBinding;
        AppCompatImageView appCompatImageView;
        this.publishEventBean = event;
        Integer valueOf = event != null ? Integer.valueOf(event.getState()) : null;
        if (valueOf == null || valueOf.intValue() != 0 || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f62987h) == null) {
            return;
        }
        appCompatImageView.postDelayed(new Runnable() { // from class: com.transsion.usercenter.profile.fragment.f
            @Override // java.lang.Runnable
            public final void run() {
                UserProfileFragment.u1(UserProfileFragment.this);
            }
        }, 1500L);
    }
}
