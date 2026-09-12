package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.TnTextView;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.g;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.control.SubjectVideoPagerChangeControl;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoader;
import com.transsion.postdetail.ui.view.ImmVideoLoadMoreView;
import com.transsion.postdetail.ui.view.ImmVideoNoNetworkView;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import nh.n;
import uh.b;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0087\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001BB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0005J\u0017\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J!\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\u0005J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0005J\u0017\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0006H\u0016¢\u0006\u0004\b=\u0010\u0005J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020)H\u0016¢\u0006\u0004\b?\u0010,J\u000f\u0010@\u001a\u00020\u0006H\u0016¢\u0006\u0004\b@\u0010\u0005R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010I\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010R\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010C\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010CR\u0016\u0010V\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010HR\u0016\u0010X\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010KR\u001b\u0010^\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010KR\u0016\u0010v\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010KR\u0016\u0010x\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010KR\u0016\u0010z\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010HR%\u0010\u0082\u0001\u001a\u00020{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/ShortTvVideoFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lso/u;", "Lzm/e;", "<init>", "()V", "", "initPlayer", "initAdapter", "initViewModel", "initBack", "observeRemoveVideo", "Lcom/transsion/moviedetailapi/bean/ShortTVRespData;", "subjectBean", "K0", "(Lcom/transsion/moviedetailapi/bean/ShortTVRespData;)V", "showNotNetError", "showEmpty", "Landroid/content/Context;", "context", "Landroid/view/View;", "getEmptyView", "(Landroid/content/Context;)Landroid/view/View;", "getNotNetErrorView", "hideProgress", "showProgress", "loadMore", "loadData", "doLoadData", "", "it", "scrollToPosition", "(I)V", "initAd", "I0", "(Landroid/content/Context;)V", "initNonAd", "Landroid/view/LayoutInflater;", "inflater", "x0", "(Landroid/view/LayoutInflater;)Lso/u;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "onResume", "onPause", "", "hidden", "onHiddenChanged", "(Z)V", "logPause", "logResume", "onDestroy", "outState", "onSaveInstanceState", "onMemberStateChange", "", "a", "Ljava/lang/String;", "mPostId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "mItemType", "c", "I", "mTabId", "d", "Z", "fromComment", "e", "getTran_ops", "()Ljava/lang/String;", "setTran_ops", "(Ljava/lang/String;)V", "tran_ops", "f", "mNextPage", be.g.f16474b, "mPerPage", "h", "videoLoadMore", "Lcom/transsion/postdetail/viewmodel/x;", "i", "Lkotlin/Lazy;", "u0", "()Lcom/transsion/postdetail/viewmodel/x;", "mVideoViewModel", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "mPagerLayoutManager", "Lcom/transsion/postdetail/control/SubjectVideoPagerChangeControl;", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/postdetail/control/SubjectVideoPagerChangeControl;", "mPagerChangeControl", "Lcom/transsion/postdetail/ui/adapter/l;", "l", "Lcom/transsion/postdetail/ui/adapter/l;", "mAdapter", "Lcom/transsion/player/orplayer/g;", "m", "Lcom/transsion/player/orplayer/g;", "mOrPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "n", "Lcom/transsion/player/ui/ORPlayerView;", "mOrPlayerView", "o", "isLoadingData", TtmlNode.TAG_P, "isFirstLoadMore", CampaignEx.JSON_KEY_AD_Q, "attachToMain", CampaignEx.JSON_KEY_AD_R, "savedCurrentIndex", "", "s", "J", "getResumeTimeStamp", "()J", "setResumeTimeStamp", "(J)V", "resumeTimeStamp", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "t", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", TmcStartParams.KEY_URL_SHORT, "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvVideoFragment extends BaseFragment<so.u> implements zm.e {

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mTabId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean fromComment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String tran_ops;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean videoLoadMore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy mVideoViewModel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private PagerLayoutManager mPagerLayoutManager;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private SubjectVideoPagerChangeControl mPagerChangeControl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.transsion.postdetail.ui.adapter.l mAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.transsion.player.orplayer.g mOrPlayer;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ORPlayerView mOrPlayerView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingData;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstLoadMore;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean attachToMain;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int savedCurrentIndex;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private BiddingListManager v3ListManager;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mPostId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mItemType = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mNextPage = "1";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mPerPage = 5;

    /* renamed from: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvVideoFragment a(Context context, String str, String str2, Integer num, boolean z10, boolean z11, String str3, boolean z12) {
            String str4;
            Intrinsics.h(context, "context");
            ShortTvVideoFragment shortTvVideoFragment = new ShortTvVideoFragment();
            shortTvVideoFragment.I0(context);
            ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
            immVideoRequestEntity.setPage("1");
            immVideoRequestEntity.setPerPage(5);
            immVideoRequestEntity.setSessionId(yg.b.f79132a.h());
            Uri c11 = com.transsion.baselib.report.h.f43402a.c();
            if (c11 == null || (str4 = c11.toString()) == null) {
                str4 = "";
            }
            immVideoRequestEntity.setDeepLink(str4);
            immVideoRequestEntity.setUserPrefer("");
            immVideoRequestEntity.setLatest_events(new wj.a(wj.b.f77816a.e()));
            immVideoRequestEntity.setPostId("0");
            immVideoRequestEntity.setTabId(num != null ? num.intValue() : 0);
            immVideoRequestEntity.setImmersiveRecType(1);
            shortTvVideoFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("id", str), TuplesKt.a("item_type", str2), TuplesKt.a("tab_id", num), TuplesKt.a("video_load_more", Boolean.valueOf(z10)), TuplesKt.a("from_comment", Boolean.valueOf(z11)), TuplesKt.a("rec_ops", str3), TuplesKt.a("attach_to_main", Boolean.valueOf(z12)), TuplesKt.a("yy_preload_id", Integer.valueOf(qm.e.f73767a.c(new VideoImmersiveDataLoader(immVideoRequestEntity))))));
            return shortTvVideoFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends androidx.activity.u {
        b() {
            super(true);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            FragmentActivity activity = ShortTvVideoFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements nh.n {
        c() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            r6.f h02;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (((ShortTVRespData) ShortTvVideoFragment.this.u0().l().f()) == null) {
                ShortTvVideoFragment.this.loadData();
                return;
            }
            com.transsion.postdetail.ui.adapter.l lVar = ShortTvVideoFragment.this.mAdapter;
            if (((lVar == null || (h02 = lVar.h0()) == null) ? null : h02.i()) == LoadMoreStatus.Fail) {
                ShortTvVideoFragment.this.loadMore();
            }
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f49693a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f49693a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f49693a;
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
            this.f49693a.invoke(obj);
        }
    }

    public ShortTvVideoFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.mVideoViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.postdetail.viewmodel.x.class), new Function0<androidx.view.x0>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$3
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
        this.isFirstLoadMore = true;
        this.savedCurrentIndex = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(ShortTvVideoFragment shortTvVideoFragment) {
        shortTvVideoFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ShortTvVideoFragment shortTvVideoFragment) {
        r6.f h02;
        shortTvVideoFragment.isLoadingData = false;
        com.transsion.postdetail.ui.adapter.l lVar = shortTvVideoFragment.mAdapter;
        if (lVar == null || (h02 = lVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(ShortTvVideoFragment shortTvVideoFragment, View view) {
        shortTvVideoFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(ShortTvVideoFragment shortTvVideoFragment, ShortTVRespData shortTVRespData) {
        r6.f h02;
        com.transsion.postdetail.ui.adapter.l lVar;
        r6.f h03;
        List<Object> data;
        shortTvVideoFragment.isLoadingData = false;
        if (shortTVRespData == null) {
            com.transsion.postdetail.ui.adapter.l lVar2 = shortTvVideoFragment.mAdapter;
            if (lVar2 == null || (data = lVar2.getData()) == null || data.size() != 0) {
                com.transsion.postdetail.ui.adapter.l lVar3 = shortTvVideoFragment.mAdapter;
                if (lVar3 != null && (h02 = lVar3.h0()) != null && h02.r() && (lVar = shortTvVideoFragment.mAdapter) != null && (h03 = lVar.h0()) != null) {
                    h03.v();
                }
            } else if (nh.m.f70597a.e()) {
                shortTvVideoFragment.showEmpty();
            } else {
                shortTvVideoFragment.showNotNetError();
            }
        } else {
            shortTvVideoFragment.K0(shortTVRespData);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(ShortTvVideoFragment shortTvVideoFragment, String str) {
        if (TextUtils.equals("0", str)) {
            ty.b.f76540a.a().e(shortTvVideoFragment.mPostId);
            FragmentActivity activity = shortTvVideoFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            b.a aVar = uh.b.f76876a;
            FragmentActivity activity2 = shortTvVideoFragment.getActivity();
            aVar.e(activity2 != null ? activity2.getString(R$string.delete_post_failed) : null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(ShortTvVideoFragment shortTvVideoFragment, List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            shortTvVideoFragment.showProgress();
            shortTvVideoFragment.loadData();
        } else {
            shortTvVideoFragment.K0(new ShortTVRespData(CollectionsKt.U0(list2), null, false));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(final ShortTvVideoFragment shortTvVideoFragment, final Integer num) {
        RecyclerView recyclerView;
        try {
            if (num.intValue() >= 0) {
                SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = shortTvVideoFragment.mPagerChangeControl;
                if (subjectVideoPagerChangeControl != null) {
                    subjectVideoPagerChangeControl.r();
                }
                com.transsion.postdetail.ui.adapter.l lVar = shortTvVideoFragment.mAdapter;
                if (lVar != null) {
                    Intrinsics.e(num);
                    lVar.G0(num.intValue());
                }
                so.u mViewBinding = shortTvVideoFragment.getMViewBinding();
                if (mViewBinding != null && (recyclerView = mViewBinding.f75851d) != null) {
                    recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.l5
                        @Override // java.lang.Runnable
                        public final void run() {
                            ShortTvVideoFragment.H0(ShortTvVideoFragment.this, num);
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(ShortTvVideoFragment shortTvVideoFragment, Integer num) {
        RecyclerView.b0 b0Var;
        RecyclerView recyclerView;
        Integer num2;
        so.u mViewBinding = shortTvVideoFragment.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f75851d) == null) {
            b0Var = null;
        } else {
            com.transsion.postdetail.ui.adapter.l lVar = shortTvVideoFragment.mAdapter;
            if (lVar != null) {
                int a02 = lVar.a0();
                Intrinsics.e(num);
                num2 = Integer.valueOf(a02 + num.intValue());
            } else {
                num2 = num;
            }
            Intrinsics.e(num2);
            b0Var = recyclerView.findViewHolderForAdapterPosition(num2.intValue());
        }
        SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = shortTvVideoFragment.mPagerChangeControl;
        if (subjectVideoPagerChangeControl != null) {
            Intrinsics.e(num);
            subjectVideoPagerChangeControl.f(num.intValue(), true, b0Var != null ? b0Var.itemView : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(Context context) {
        ShortTvImmVideoHelper.f48908k.a().v(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(ShortTvVideoFragment shortTvVideoFragment, int i11) {
        PagerLayoutManager pagerLayoutManager = shortTvVideoFragment.mPagerLayoutManager;
        if (pagerLayoutManager != null) {
            View T = pagerLayoutManager.T();
            if (T != null) {
                a.C0856a.r(lg.a.f68962a, "ShortTvImmVideoPlayer", new String[]{"initView2， scrollToPosition ：" + i11}, false, 4, null);
                SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = shortTvVideoFragment.mPagerChangeControl;
                if (subjectVideoPagerChangeControl != null) {
                    subjectVideoPagerChangeControl.f(i11, true, T);
                    return;
                }
                return;
            }
            int childCount = pagerLayoutManager.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = pagerLayoutManager.getChildAt(i12);
                if (childAt != null && pagerLayoutManager.getPosition(childAt) == i11) {
                    a.C0856a.r(lg.a.f68962a, "ShortTvImmVideoPlayer", new String[]{"initView， scrollToPosition ：" + i11}, false, 4, null);
                    SubjectVideoPagerChangeControl subjectVideoPagerChangeControl2 = shortTvVideoFragment.mPagerChangeControl;
                    if (subjectVideoPagerChangeControl2 != null) {
                        subjectVideoPagerChangeControl2.f(i11, true, childAt);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private final void K0(ShortTVRespData subjectBean) {
        String str;
        com.transsion.postdetail.ui.adapter.l lVar;
        r6.f h02;
        r6.f h03;
        com.transsion.postdetail.ui.adapter.l lVar2;
        r6.f h04;
        String url;
        Media video;
        hideProgress();
        Pager pager = subjectBean.getPager();
        if (pager == null || (str = pager.getNextPage()) == null) {
            str = "1";
        }
        this.mNextPage = str;
        List<Subject> items = subjectBean.getItems();
        if (items != null) {
            Iterator<Subject> it = items.iterator();
            while (it.hasNext()) {
                Subject next = it.next();
                ShortTVItem shortTVFirstEp = next.getShortTVFirstEp();
                if (((shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress()) != null) {
                    ShortTVItem shortTVFirstEp2 = next.getShortTVFirstEp();
                    Media video2 = shortTVFirstEp2 != null ? shortTVFirstEp2.getVideo() : null;
                    Intrinsics.e(video2);
                    Video videoAddress = video2.getVideoAddress();
                    if (videoAddress != null && (url = videoAddress.getUrl()) != null && url.length() == 0) {
                    }
                }
                it.remove();
            }
            com.transsion.postdetail.ui.adapter.l lVar3 = this.mAdapter;
            List<Object> data = lVar3 != null ? lVar3.getData() : null;
            ArrayList arrayList = new ArrayList();
            if (data == null || !(!data.isEmpty())) {
                arrayList.addAll(items);
            } else {
                Iterator<Subject> it2 = items.iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.mPagerChangeControl;
            if (subjectVideoPagerChangeControl != null) {
                subjectVideoPagerChangeControl.g(arrayList);
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl2 = this.mPagerChangeControl;
            if (subjectVideoPagerChangeControl2 != null) {
                subjectVideoPagerChangeControl2.o();
            }
            if (this.attachToMain) {
                ShortTvImmVideoHelper a11 = ShortTvImmVideoHelper.f48908k.a();
                com.transsion.postdetail.ui.adapter.l lVar4 = this.mAdapter;
                a11.z(lVar4 != null ? lVar4.getData() : null);
            }
        }
        com.transsion.postdetail.ui.adapter.l lVar5 = this.mAdapter;
        if (lVar5 != null && (h03 = lVar5.h0()) != null && h03.r() && (lVar2 = this.mAdapter) != null && (h04 = lVar2.h0()) != null) {
            h04.s();
        }
        Pager pager2 = subjectBean.getPager();
        if ((pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.FALSE) : false) && (lVar = this.mAdapter) != null && (h02 = lVar.h0()) != null) {
            r6.f.u(h02, false, 1, null);
        }
        int i11 = this.savedCurrentIndex;
        if (i11 >= 0) {
            scrollToPosition(i11);
            this.savedCurrentIndex = -1;
        }
    }

    private final void doLoadData() {
        if (this.isLoadingData) {
            return;
        }
        this.isLoadingData = true;
        u0().k(this.mPostId, this.mTabId, this.mNextPage, this.mPerPage, 1);
    }

    private final View getEmptyView(Context context) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        defaultView.setGravity(17);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(R$mipmap.ic_no_content);
        String string = context.getString(com.tn.lib.widget.R$string.no_content);
        Intrinsics.g(string, "getString(...)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.r5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvVideoFragment.t0(ShortTvVideoFragment.this, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    private final View getNotNetErrorView(Context context) {
        final ImmVideoNoNetworkView immVideoNoNetworkView = new ImmVideoNoNetworkView(context);
        jg.c.e(immVideoNoNetworkView);
        immVideoNoNetworkView.retry(new Function0() { // from class: com.transsion.postdetail.ui.fragment.o5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit v02;
                v02 = ShortTvVideoFragment.v0(ImmVideoNoNetworkView.this, this);
                return v02;
            }
        });
        immVideoNoNetworkView.goToSetting(new Function0() { // from class: com.transsion.postdetail.ui.fragment.p5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit w02;
                w02 = ShortTvVideoFragment.w0();
                return w02;
            }
        });
        com.tn.lib.view.r.a("shorttv_detail_video");
        return immVideoNoNetworkView;
    }

    private final void hideProgress() {
    }

    private final void initAd() {
        BiddingListManager biddingListManager = new BiddingListManager();
        this.v3ListManager = biddingListManager;
        so.u mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f75851d : null);
        BiddingListManager biddingListManager2 = this.v3ListManager;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.view.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.v3ListManager;
        if (biddingListManager3 != null) {
            biddingListManager3.G("VideoForYouListScene");
        }
        BiddingListManager biddingListManager4 = this.v3ListManager;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2() { // from class: com.transsion.postdetail.ui.fragment.s5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y02;
                    y02 = ShortTvVideoFragment.y0(ShortTvVideoFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                    return y02;
                }
            });
        }
    }

    private final void initAdapter() {
        com.transsion.postdetail.ui.adapter.l lVar = new com.transsion.postdetail.ui.adapter.l(new ArrayList(), this, this.mPostId, this.mItemType, this.attachToMain);
        lVar.h0().z(this.videoLoadMore);
        if (this.videoLoadMore) {
            lVar.h0().C(new ImmVideoLoadMoreView());
            lVar.h0().z(true);
            lVar.h0().y(true);
            lVar.h0().E(2);
            lVar.h0().D(new p6.f() { // from class: com.transsion.postdetail.ui.fragment.u5
                @Override // p6.f
                public final void a() {
                    ShortTvVideoFragment.z0(ShortTvVideoFragment.this);
                }
            });
        }
        this.mAdapter = lVar;
    }

    private final void initBack() {
        AppCompatImageView appCompatImageView;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView2;
        ConstraintLayout constraintLayout;
        so.u mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (constraintLayout = mViewBinding.f75852e) == null) ? null : constraintLayout.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        if (this.mPostId.length() == 0) {
            so.u mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (appCompatImageView2 = mViewBinding2.f75849b) == null) {
                return;
            }
            jg.c.g(appCompatImageView2);
            return;
        }
        so.u mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (tnTextView = mViewBinding3.f75853f) != null) {
            jg.c.g(tnTextView);
        }
        so.u mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView = mViewBinding4.f75849b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.t5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTvVideoFragment.C0(ShortTvVideoFragment.this, view);
                }
            });
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new b());
    }

    private final void initNonAd() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initPlayer() {
        com.transsion.player.orplayer.g a11;
        ap.b bVar = ap.b.f16171a;
        int i11 = 1;
        if (bVar.b()) {
            a11 = new lo.e(null, i11, 0 == true ? 1 : 0);
            a11.setLooping(true);
            a11.prepare();
            a11.play();
        } else {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            a11 = new g.a(requireContext).b(new bo.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, true, false, false, false, null, 126975, null)).a();
        }
        this.mOrPlayer = a11;
        if (bVar.b()) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            ORPlayerView oRPlayerView = new ORPlayerView(requireActivity, RenderType.SURFACE_VIEW);
            this.mOrPlayerView = oRPlayerView;
            com.transsion.player.orplayer.g gVar = this.mOrPlayer;
            if (gVar != null) {
                gVar.setSurfaceView(oRPlayerView.getSurface());
            }
        } else {
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.g(requireActivity2, "requireActivity(...)");
            ORPlayerView oRPlayerView2 = new ORPlayerView(requireActivity2, RenderType.TEXTURE_VIEW);
            this.mOrPlayerView = oRPlayerView2;
            com.transsion.player.orplayer.g gVar2 = this.mOrPlayer;
            if (gVar2 != null) {
                gVar2.setTextureView(oRPlayerView2.getTextureView());
            }
        }
        com.transsion.player.orplayer.g gVar3 = this.mOrPlayer;
        if (gVar3 != null) {
            gVar3.setLooping(true);
        }
    }

    private final void initViewModel() {
        u0().l().j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.h5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D0;
                D0 = ShortTvVideoFragment.D0(ShortTvVideoFragment.this, (ShortTVRespData) obj);
                return D0;
            }
        }));
        u0().j().j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.m5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E0;
                E0 = ShortTvVideoFragment.E0(ShortTvVideoFragment.this, (String) obj);
                return E0;
            }
        }));
        if (this.attachToMain) {
            ShortTvImmVideoHelper.f48908k.a().n().j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.n5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit F0;
                    F0 = ShortTvVideoFragment.F0(ShortTvVideoFragment.this, (List) obj);
                    return F0;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        doLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore() {
        loadData();
    }

    private final void observeRemoveVideo() {
        u0().o().j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.q5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G0;
                G0 = ShortTvVideoFragment.G0(ShortTvVideoFragment.this, (Integer) obj);
                return G0;
            }
        }));
    }

    private final void scrollToPosition(final int it) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<Object> data;
        com.transsion.postdetail.ui.adapter.l lVar = this.mAdapter;
        if (((lVar == null || (data = lVar.getData()) == null) ? 0 : data.size()) <= it) {
            return;
        }
        so.u mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView2 = mViewBinding.f75851d) != null) {
            recyclerView2.scrollToPosition(it);
        }
        so.u mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f75851d) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.i5
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvVideoFragment.J0(ShortTvVideoFragment.this, it);
            }
        });
    }

    private final void showEmpty() {
        com.transsion.postdetail.ui.adapter.l lVar;
        List<Object> data;
        hideProgress();
        com.transsion.postdetail.ui.adapter.l lVar2 = this.mAdapter;
        if (lVar2 == null || (data = lVar2.getData()) == null || !(!data.isEmpty())) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            View emptyView = getEmptyView(requireContext);
            if (emptyView == null || (lVar = this.mAdapter) == null) {
                return;
            }
            lVar.Y0(emptyView);
        }
    }

    private final void showNotNetError() {
        com.transsion.postdetail.ui.adapter.l lVar;
        List<Object> data;
        hideProgress();
        com.transsion.postdetail.ui.adapter.l lVar2 = this.mAdapter;
        if (lVar2 == null || (data = lVar2.getData()) == null || !(!data.isEmpty())) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            View notNetErrorView = getNotNetErrorView(requireContext);
            if (notNetErrorView == null || (lVar = this.mAdapter) == null) {
                return;
            }
            lVar.Y0(notNetErrorView);
        }
    }

    private final void showProgress() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ShortTvVideoFragment shortTvVideoFragment, DefaultView defaultView, View view) {
        shortTvVideoFragment.loadData();
        defaultView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.postdetail.viewmodel.x u0() {
        return (com.transsion.postdetail.viewmodel.x) this.mVideoViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(ImmVideoNoNetworkView immVideoNoNetworkView, ShortTvVideoFragment shortTvVideoFragment) {
        jg.c.g(immVideoNoNetworkView);
        shortTvVideoFragment.showProgress();
        shortTvVideoFragment.loadData();
        com.tn.lib.view.r.b("shorttv_detail_video");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0() {
        com.tn.lib.view.r.c("shorttv_detail_video");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(ShortTvVideoFragment shortTvVideoFragment, int i11, BiddingNativeManager current) {
        List<Object> data;
        Intrinsics.h(current, "current");
        if (current != null) {
            Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -1, 134217727, null);
            subject.setNonAdDelegate(current);
            com.transsion.postdetail.ui.adapter.l lVar = shortTvVideoFragment.mAdapter;
            int size = (lVar == null || (data = lVar.getData()) == null) ? 0 : data.size();
            if (i11 <= size) {
                com.transsion.postdetail.ui.adapter.l lVar2 = shortTvVideoFragment.mAdapter;
                if (lVar2 != null) {
                    lVar2.n(i11, subject);
                }
            } else {
                com.transsion.postdetail.ui.adapter.l lVar3 = shortTvVideoFragment.mAdapter;
                if (lVar3 != null) {
                    lVar3.n(size, subject);
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(final ShortTvVideoFragment shortTvVideoFragment) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (!nh.m.f70597a.e()) {
            so.u mViewBinding = shortTvVideoFragment.getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f75851d) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.k5
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvVideoFragment.B0(ShortTvVideoFragment.this);
                }
            }, 500L);
            return;
        }
        if (shortTvVideoFragment.isFirstLoadMore) {
            shortTvVideoFragment.isFirstLoadMore = false;
            shortTvVideoFragment.loadMore();
            return;
        }
        so.u mViewBinding2 = shortTvVideoFragment.getMViewBinding();
        if (mViewBinding2 == null || (recyclerView2 = mViewBinding2.f75851d) == null) {
            return;
        }
        recyclerView2.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.j5
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvVideoFragment.A0(ShortTvVideoFragment.this);
            }
        }, 500L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if (r1 == null) goto L11;
     */
    @Override // com.transsion.baseui.fragment.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initData(android.view.View r1, android.os.Bundle r2) {
        /*
            r0 = this;
            java.lang.String r2 = "view"
            kotlin.jvm.internal.Intrinsics.h(r1, r2)
            com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$c r1 = new com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$c
            r1.<init>()
            r0.setNetListener(r1)
            r0.initViewModel()
            com.transsion.postdetail.viewmodel.x r1 = r0.u0()
            com.transsion.moviedetailapi.bean.ShortTVRespData r1 = r1.n()
            if (r1 == 0) goto L30
            com.transsion.moviedetailapi.bean.Pager r2 = r1.getPager()
            if (r2 == 0) goto L26
            java.lang.String r2 = r2.getNextPage()
            if (r2 != 0) goto L28
        L26:
            java.lang.String r2 = "1"
        L28:
            r0.mNextPage = r2
            java.util.List r1 = r1.getItems()
            if (r1 != 0) goto L3a
        L30:
            com.transsion.postdetail.helper.ShortTvImmVideoHelper$a r1 = com.transsion.postdetail.helper.ShortTvImmVideoHelper.f48908k
            com.transsion.postdetail.helper.ShortTvImmVideoHelper r1 = r1.a()
            java.util.List r1 = r1.k()
        L3a:
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L55
            boolean r1 = r0.attachToMain
            if (r1 == 0) goto L4e
            com.transsion.postdetail.helper.ShortTvImmVideoHelper$a r1 = com.transsion.postdetail.helper.ShortTvImmVideoHelper.f48908k
            com.transsion.postdetail.helper.ShortTvImmVideoHelper r1 = r1.a()
            r1.t()
            goto L5c
        L4e:
            r0.showProgress()
            r0.loadData()
            goto L5c
        L55:
            com.transsion.postdetail.control.SubjectVideoPagerChangeControl r2 = r0.mPagerChangeControl
            if (r2 == 0) goto L5c
            r2.g(r1)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment.initData(android.view.View, android.os.Bundle):void");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Intrinsics.h(view, "view");
        int i11 = savedInstanceState != null ? savedInstanceState.getInt("CURRENT_INDEX") : -1;
        this.savedCurrentIndex = i11;
        a.C0856a.r(lg.a.f68962a, "ShortTvImmVideoPlayer", new String[]{"initView， savedCurrentIndex ：" + i11}, false, 4, null);
        initAd();
        initNonAd();
        initAdapter();
        initPlayer();
        initBack();
        observeRemoveVideo();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        this.mPagerLayoutManager = new PagerLayoutManager(requireActivity);
        SubjectVideoPagerChangeControl aVar = ap.b.f16171a.b() ? new com.transsion.postdetail.control.a(this, this.mAdapter, this.mOrPlayer, this.mOrPlayerView, this.mPagerLayoutManager) : new SubjectVideoPagerChangeControl(this, this.mAdapter, this.mOrPlayer, this.mOrPlayerView, this.mPagerLayoutManager);
        this.mPagerChangeControl = aVar;
        PagerLayoutManager pagerLayoutManager = this.mPagerLayoutManager;
        if (pagerLayoutManager != null) {
            pagerLayoutManager.X(aVar);
        }
        so.u mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f75851d) != null) {
            recyclerView.setLayoutManager(this.mPagerLayoutManager);
            recyclerView.setAdapter(this.mAdapter);
            recyclerView.setHasFixedSize(true);
        }
        ShortTvImmVideoHelper a11 = ShortTvImmVideoHelper.f48908k.a();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.g(requireActivity2, "requireActivity(...)");
        a11.p(requireActivity2);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            com.transsion.baselib.report.e.f43398a.n("shorttv_detail_video", Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return new hj.b("shorttv_detail_video", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        HashMap g11;
        HashMap g12;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = arguments.getString("id")) == null) {
            str = "";
        }
        this.mPostId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("item_type")) != null) {
            str2 = string;
        }
        this.mItemType = str2;
        Bundle arguments3 = getArguments();
        this.mTabId = arguments3 != null ? arguments3.getInt("tab_id") : 0;
        Bundle arguments4 = getArguments();
        this.videoLoadMore = arguments4 != null ? arguments4.getBoolean("video_load_more", true) : true;
        Bundle arguments5 = getArguments();
        this.fromComment = arguments5 != null ? arguments5.getBoolean("from_comment") : false;
        Bundle arguments6 = getArguments();
        this.tran_ops = arguments6 != null ? arguments6.getString("rec_ops") : null;
        Bundle arguments7 = getArguments();
        this.attachToMain = arguments7 != null ? arguments7.getBoolean("attach_to_main") : false;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g12 = logViewConfig.g()) != null) {
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
        }
        com.transsion.postdetail.viewmodel.x u02 = u0();
        if (u02 != null) {
            Bundle arguments8 = getArguments();
            u02.q(arguments8 != null ? Integer.valueOf(arguments8.getInt("yy_preload_id")) : null);
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.E(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.player.orplayer.g gVar = this.mOrPlayer;
        this.mOrPlayer = null;
        if (gVar != null) {
            gVar.release();
        }
        ShortTvImmVideoHelper.f48908k.a().j();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.t(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                com.transsion.player.orplayer.g gVar = this.mOrPlayer;
                if (gVar != null) {
                    gVar.pause();
                }
                logPause();
            } else {
                com.transsion.player.orplayer.g gVar2 = this.mOrPlayer;
                if (gVar2 != null) {
                    gVar2.play();
                }
                logResume();
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.mPagerChangeControl;
            if (subjectVideoPagerChangeControl != null) {
                subjectVideoPagerChangeControl.p(hidden);
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // zm.e
    public void onMemberStateChange() {
        a.C0856a.f(lg.a.f68962a, "co_mem", "VideoFragment --> onMemberStateChange() --> refresh list", false, 4, null);
        com.transsion.postdetail.ui.adapter.l lVar = this.mAdapter;
        if (lVar != null) {
            lVar.n1(null);
        }
        loadData();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible(), 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.mPagerChangeControl;
        outState.putInt("CURRENT_INDEX", subjectVideoPagerChangeControl != null ? subjectVideoPagerChangeControl.i() : 0);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public so.u getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        so.u c11 = so.u.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
