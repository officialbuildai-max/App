package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.fragment.ResourceDetectorDialogFragment;
import com.transsion.moviedetail.fragment.VideoDetailSeasonsSelectFragment;
import com.transsion.moviedetail.view.WatchModeTipsView;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.api.IStreamDetailService;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.util.DownloadUtil;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import zm.a;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 k2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J)\u0010\u001b\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J'\u0010,\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\b\u0010+\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b,\u0010-J)\u0010.\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b.\u0010/J5\u00101\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010$2\b\b\u0002\u00100\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0005H\u0002¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\u0005H\u0002¢\u0006\u0004\b4\u0010\u0004J\u000f\u00105\u001a\u00020\u0005H\u0002¢\u0006\u0004\b5\u0010\u0004J\u000f\u00106\u001a\u00020\u0005H\u0002¢\u0006\u0004\b6\u0010\u0004J\u001d\u00109\u001a\u00020\u00052\f\u00108\u001a\b\u0012\u0004\u0012\u0002070(H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u000207H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0005H\u0002¢\u0006\u0004\b>\u0010\u0004R\u0018\u0010A\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001b\u0010K\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010@R\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010@R(\u0010V\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010OR\u0016\u0010c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010OR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010H\u001a\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010O¨\u0006l"}, d2 = {"Lcom/transsion/moviedetail/fragment/ResourceDetectorFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lcn/m;", "<init>", "()V", "", "receiveArguments", "", "isMonitorNetworkState", "()Z", "isAudioShowNoNetworkLayout", "Landroid/view/LayoutInflater;", "inflater", "I0", "(Landroid/view/LayoutInflater;)Lcn/m;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lcom/transsion/moviedetailapi/bean/ResourcesSeasonList;", "seasonList", "", "Lcom/transsion/moviedetailapi/bean/ResourcesSeason;", "seasons", "e1", "(Lcom/transsion/moviedetailapi/bean/ResourcesSeasonList;Ljava/util/List;)V", CampaignEx.JSON_KEY_TITLE, "j1", "(Ljava/lang/String;)V", "V0", "k1", "c1", "J0", "", RequestParameters.POSITION, "h1", "(I)V", "", "Lcom/transsion/moviedetailapi/DownloadItem;", "downloadItem", "totalEpisode", "m1", "(Ljava/util/List;Ljava/lang/Integer;)V", "i1", "(ILcom/transsion/moviedetailapi/DownloadItem;Ljava/lang/Integer;)V", "isMultiResolution", "F0", "(Lcom/transsion/moviedetailapi/DownloadItem;Ljava/lang/Integer;II)V", "D0", "T0", "showLoading", "hideLoading", "Lcom/transsion/moviedetailapi/bean/DubsInfo;", "audioTracks", "M0", "(Ljava/util/List;)V", "info", "d1", "(Lcom/transsion/moviedetailapi/bean/DubsInfo;)V", "l1", "a", "Ljava/lang/String;", "moduleName", "Lcom/transsion/moviedetailapi/bean/Subject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "c", "Lkotlin/Lazy;", "G0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "d", "ops", "e", "Z", "autoPlay", "f", "autoPlayResourceId", "", be.g.f16474b, "Ljava/util/Map;", "resMap", "Lcom/transsion/moviedetail/adapter/n;", "h", "Lcom/transsion/moviedetail/adapter/n;", "resAdapter", "i", "I", "curSeason", com.mbridge.msdk.foundation.same.report.j.f35620b, "curResolution", CampaignEx.JSON_KEY_AD_K, "isPreloadDownloadResResponse", "l", "isSeasonResponse", "Lcom/transsion/player/longvideo/helper/o0;", "m", "H0", "()Lcom/transsion/player/longvideo/helper/o0;", "subtitleViewModel", "n", "isAudioDubs", "o", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class ResourceDetectorFragment extends PageStatusFragment<cn.m> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String autoPlayResourceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.transsion.moviedetail.adapter.n resAdapter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isPreloadDownloadResResponse;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isSeasonResponse;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isAudioDubs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Map resMap = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int curResolution = 480;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy subtitleViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.helper.o0.class), new Function0<androidx.view.x0>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$special$$inlined$activityViewModels$default$4
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* loaded from: classes5.dex */
    public static final class b implements zm.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f47113b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ DownloadItem f47114c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f47115d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.transsion.moviedetail.adapter.p f47116e;

        b(int i11, DownloadItem downloadItem, List list, com.transsion.moviedetail.adapter.p pVar) {
            this.f47113b = i11;
            this.f47114c = downloadItem;
            this.f47115d = list;
            this.f47116e = pVar;
        }

        @Override // zm.a
        public void a(MemberCheckResult memberCheckResult) {
            a.C1007a.f(this, memberCheckResult);
        }

        @Override // zm.a
        public void b(MemberCheckResult memberCheckResult) {
            a.C1007a.d(this, memberCheckResult);
        }

        @Override // zm.a
        public void c(MemberCheckResult memberCheckResult) {
            a.C1007a.g(this, memberCheckResult);
        }

        @Override // zm.a
        public void d(MemberCheckResult memberCheckResult) {
            a.C1007a.e(this, memberCheckResult);
        }

        @Override // zm.a
        public void e() {
            a.C1007a.c(this);
            if (!ResourceDetectorFragment.this.isAdded() || ResourceDetectorFragment.this.isDetached()) {
                return;
            }
            ResourceDetectorFragment.this.i1(this.f47113b, this.f47114c, ((ResourceDetectors) this.f47115d.get(0)).getTotalEpisode());
        }

        @Override // zm.a
        public void f(MemberCheckResult memberCheckResult) {
            a.C1007a.a(this, memberCheckResult);
        }

        @Override // zm.a
        public void onFail(String errorMsg) {
            String resourceId;
            Context context;
            Intrinsics.h(errorMsg, "errorMsg");
            a.C1007a.b(this, errorMsg);
            a.C0856a.f(lg.a.f68962a, "co_mem", "ResourceDetectorFragment --> immediateShowList() --> 单集多分辨率 --> " + errorMsg, false, 4, null);
            if (!nh.m.f70597a.e()) {
                uh.b.f76876a.d(R$string.no_network_toast);
            }
            if (!ResourceDetectorFragment.this.isAdded() || ResourceDetectorFragment.this.isDetached()) {
                return;
            }
            DownloadManagerApi.a aVar = DownloadManagerApi.f58521j;
            DownloadManagerApi a11 = aVar.a();
            String resourceId2 = this.f47114c.getResourceId();
            Subject mMovieDetailBean = this.f47116e.getMMovieDetailBean();
            if (!DownloadManagerApi.x0(a11, null, resourceId2, mMovieDetailBean != null ? mMovieDetailBean.isSeries() : false, false, 8, null) || (resourceId = this.f47114c.getResourceId()) == null || (context = this.f47116e.getContext()) == null) {
                return;
            }
            aVar.a().y0(null, context, "subjectdetail", resourceId);
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f47117a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f47117a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f47117a;
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
            this.f47117a.invoke(obj);
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends RecyclerView.l {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            int itemCount = adapter != null ? adapter.getItemCount() : 0;
            if (childAdapterPosition == 0) {
                outRect.left = 0;
                outRect.right = dk.a.b(4);
            } else if (childAdapterPosition == itemCount - 1) {
                outRect.left = dk.a.b(4);
                outRect.right = 0;
            } else {
                outRect.left = dk.a.b(4);
                outRect.right = dk.a.b(4);
            }
        }
    }

    private final void D0() {
        RecyclerView recyclerView;
        if (this.autoPlay) {
            this.autoPlay = false;
            cn.m mViewBinding = getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f17502k) == null) {
                return;
            }
            recyclerView.post(new Runnable() { // from class: com.transsion.moviedetail.fragment.t0
                @Override // java.lang.Runnable
                public final void run() {
                    ResourceDetectorFragment.E0(ResourceDetectorFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(ResourceDetectorFragment resourceDetectorFragment) {
        Context context;
        String str = resourceDetectorFragment.autoPlayResourceId;
        if (str == null || (context = resourceDetectorFragment.getContext()) == null) {
            return;
        }
        DownloadManagerApi.f58521j.a().y0(null, context, "subjectdetail", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0038 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ef A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fc A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0109 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0116 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0132 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013d A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014e A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0161 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016f A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0185 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0196 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ac A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b7 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ef A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0002, B:6:0x000a, B:11:0x001a, B:16:0x0027, B:20:0x0032, B:22:0x0038, B:24:0x003e, B:26:0x0048, B:27:0x0050, B:29:0x00ef, B:31:0x00f7, B:33:0x00fc, B:35:0x0104, B:37:0x0109, B:38:0x0110, B:40:0x0116, B:42:0x011c, B:43:0x0122, B:45:0x0127, B:46:0x012d, B:48:0x0132, B:49:0x0138, B:51:0x013d, B:53:0x0143, B:54:0x0149, B:56:0x014e, B:57:0x0155, B:59:0x0161, B:60:0x0168, B:62:0x016f, B:63:0x0176, B:65:0x0185, B:66:0x0189, B:68:0x0196, B:70:0x019c, B:71:0x01a7, B:73:0x01ac, B:74:0x01b0, B:76:0x01b7, B:78:0x01bd, B:80:0x01c6, B:83:0x01d8, B:85:0x01ef, B:89:0x01fa, B:96:0x01a1), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void F0(com.transsion.moviedetailapi.DownloadItem r97, java.lang.Integer r98, int r99, int r100) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetail.fragment.ResourceDetectorFragment.F0(com.transsion.moviedetailapi.DownloadItem, java.lang.Integer, int, int):void");
    }

    private final MovieDetailViewModel G0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    private final com.transsion.player.longvideo.helper.o0 H0() {
        return (com.transsion.player.longvideo.helper.o0) this.subtitleViewModel.getValue();
    }

    private final void J0() {
        final List<ResourceDetectors> resourceDetectors;
        cn.m mViewBinding;
        RecyclerView recyclerView;
        Subject subject = this.mMovieDetailBean;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || resourceDetectors.isEmpty() || (mViewBinding = getMViewBinding()) == null || (recyclerView = mViewBinding.f17502k) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new ig.j(com.blankj.utilcode.util.a0.a(8.0f)));
        if (resourceDetectors.get(0).isMultiResolution()) {
            final com.transsion.moviedetail.adapter.p pVar = new com.transsion.moviedetail.adapter.p(this.mMovieDetailBean, resourceDetectors.get(0).getResolutionList());
            Subject mMovieDetailBean = pVar.getMMovieDetailBean();
            pVar.H1(mMovieDetailBean != null ? mMovieDetailBean.getVipInfo() : null);
            pVar.l(R$id.itemRoot);
            pVar.s1(new p6.b() { // from class: com.transsion.moviedetail.fragment.u0
                @Override // p6.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    ResourceDetectorFragment.K0(com.transsion.moviedetail.adapter.p.this, this, resourceDetectors, baseQuickAdapter, view, i11);
                }
            });
            recyclerView.setAdapter(pVar);
            return;
        }
        com.transsion.moviedetail.adapter.l lVar = new com.transsion.moviedetail.adapter.l(this.mMovieDetailBean, resourceDetectors);
        Subject mMovieDetailBean2 = lVar.getMMovieDetailBean();
        lVar.H1(mMovieDetailBean2 != null ? mMovieDetailBean2.getVipInfo() : null);
        lVar.l(R$id.itemRoot);
        lVar.s1(new p6.b() { // from class: com.transsion.moviedetail.fragment.v0
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ResourceDetectorFragment.L0(ResourceDetectorFragment.this, baseQuickAdapter, view, i11);
            }
        });
        recyclerView.setAdapter(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(com.transsion.moviedetail.adapter.p pVar, ResourceDetectorFragment resourceDetectorFragment, List list, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        DownloadItem downloadItem = (DownloadItem) pVar.getData().get(i11);
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.o(downloadItem.getResolution(), new b(i11, downloadItem, list, pVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(ResourceDetectorFragment resourceDetectorFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        resourceDetectorFragment.h1(i11);
    }

    private final void M0(List audioTracks) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(ResourceDetectorFragment resourceDetectorFragment, View view) {
        List<ResourceDetectors> resourceDetectors;
        String str;
        Subject subject = resourceDetectorFragment.mMovieDetailBean;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || resourceDetectors.isEmpty()) {
            return;
        }
        ResourceDetectors resourceDetectors2 = resourceDetectors.get(0);
        ResourceDetectorDialogFragment.Companion companion = ResourceDetectorDialogFragment.INSTANCE;
        Subject subject2 = resourceDetectorFragment.mMovieDetailBean;
        if (subject2 == null || (str = subject2.getTitle()) == null) {
            str = "";
        }
        ResourceDetectorDialogFragment a11 = companion.a(str, resourceDetectors2);
        FragmentManager childFragmentManager = resourceDetectorFragment.getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        a11.show(childFragmentManager, "ResourceDetectorFragment --> ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(ResourceDetectorFragment resourceDetectorFragment, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = resourceDetectorFragment.mMovieDetailBean;
        Navigator.x(K.K("subject_id", subject != null ? subject.getSubjectId() : null), resourceDetectorFragment.requireContext(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(ResourceDetectorFragment resourceDetectorFragment, View view) {
        resourceDetectorFragment.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(final ResourceDetectorFragment resourceDetectorFragment, View view) {
        String subjectId;
        Fragment parentFragment;
        IStreamDetailService iStreamDetailService;
        a.C0856a.f(lg.a.f68962a, "VideoEpisodeFragment", "tvLanguage click then switch audio track", false, 4, null);
        Subject subject = resourceDetectorFragment.mMovieDetailBean;
        if (subject == null || (subjectId = subject.getSubjectId()) == null || (parentFragment = resourceDetectorFragment.getParentFragment()) == null || (iStreamDetailService = (IStreamDetailService) TheRouter.d(IStreamDetailService.class, new Object[0])) == null) {
            return;
        }
        iStreamDetailService.c(parentFragment, R$id.fl_bottom_dialog_container, subjectId, new Function1() { // from class: com.transsion.moviedetail.fragment.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = ResourceDetectorFragment.R0(ResourceDetectorFragment.this, (DubsInfo) obj);
                return R0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(ResourceDetectorFragment resourceDetectorFragment, DubsInfo info) {
        Intrinsics.h(info, "info");
        resourceDetectorFragment.d1(info);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(ResourceDetectorFragment resourceDetectorFragment, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = resourceDetectorFragment.mMovieDetailBean;
        Navigator.x(K.K("subject_id", subject != null ? subject.getSubjectId() : null), resourceDetectorFragment.requireContext(), null, 2, null);
    }

    private final void T0() {
        FrameLayout frameLayout;
        cn.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (frameLayout = mViewBinding.f17498g) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResourceDetectorFragment.U0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(View view) {
        uh.b.f76876a.d(com.transsion.moviedetail.R$string.movie_detail_res_loading);
    }

    private final void V0() {
        List<ResourcesSeason> seasons;
        if (this.isSeasonResponse && this.isPreloadDownloadResResponse && this.curSeason > 1) {
            k1();
            ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) G0().L().f();
            if (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) {
                return;
            }
            int t11 = DownloadUtil.f60023a.t(seasons, this.curSeason);
            if (t11 <= 0) {
                t11 = this.curResolution;
            }
            int i11 = t11;
            lg.a.f68962a.c("ResourceDetectorFragment --> ", "initOtherSe se:" + this.curSeason + " resolution:" + i11, true);
            MovieDetailViewModel G0 = G0();
            Subject subject = this.mMovieDetailBean;
            G0.x(subject != null ? subject.getSubjectId() : null, this.curSeason, 1, 3, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(ResourceDetectorFragment resourceDetectorFragment, Integer num) {
        a.C0856a.f(lg.a.f68962a, "ResourceDetectorFragment --> ", "seObserve:" + resourceDetectorFragment.curSeason, false, 4, null);
        resourceDetectorFragment.k1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(ResourceDetectorFragment resourceDetectorFragment, Pair pair) {
        BLTextView bLTextView;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "ResourceDetectorFragment --> ", "字幕选择了, name:" + pair.getFirst() + ", " + pair.getSecond(), false, 4, null);
        if (resourceDetectorFragment.isAudioDubs) {
            a.C0856a.f(c0856a, "ResourceDetectorFragment --> ", "字幕选择了, 是多配音，不展示字幕", false, 4, null);
            return Unit.f67184a;
        }
        cn.m mViewBinding = resourceDetectorFragment.getMViewBinding();
        if (mViewBinding != null && (bLTextView = mViewBinding.f17503l) != null) {
            bLTextView.setText((CharSequence) pair.getFirst());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(ResourceDetectorFragment resourceDetectorFragment, List list) {
        BLTextView bLTextView;
        BLTextView bLTextView2;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            cn.m mViewBinding = resourceDetectorFragment.getMViewBinding();
            if (mViewBinding != null && (bLTextView = mViewBinding.f17503l) != null) {
                jg.c.g(bLTextView);
            }
            return Unit.f67184a;
        }
        cn.m mViewBinding2 = resourceDetectorFragment.getMViewBinding();
        if (mViewBinding2 != null && (bLTextView2 = mViewBinding2.f17503l) != null) {
            jg.c.k(bLTextView2);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(ResourceDetectorFragment resourceDetectorFragment, ResourcesSeasonList resourcesSeasonList) {
        resourceDetectorFragment.isSeasonResponse = true;
        resourceDetectorFragment.e1(resourcesSeasonList, resourcesSeasonList != null ? resourcesSeasonList.getSeasons() : null);
        a.C0856a.f(lg.a.f68962a, "ResourceDetectorFragment --> ", "seasonListObserve:" + resourceDetectorFragment.curSeason, false, 4, null);
        resourceDetectorFragment.V0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(ResourceDetectorFragment resourceDetectorFragment, DownloadListBean downloadListBean) {
        List<DownloadItem> items;
        Integer resolution;
        a.C0856a.f(lg.a.f68962a, "ResourceDetectorFragment --> ", "downloadListPreload Observe:" + resourceDetectorFragment.curSeason, false, 4, null);
        resourceDetectorFragment.isPreloadDownloadResResponse = true;
        if (resourceDetectorFragment.c1()) {
            resourceDetectorFragment.curResolution = (downloadListBean == null || (resolution = downloadListBean.getResolution()) == null) ? 480 : resolution.intValue();
            if (downloadListBean != null && (items = downloadListBean.getItems()) != null && !items.isEmpty()) {
                resourceDetectorFragment.resMap.put(Integer.valueOf(resourceDetectorFragment.curSeason), items);
                resourceDetectorFragment.m1(items, downloadListBean.getTotalEpisode());
            }
            resourceDetectorFragment.V0();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(ResourceDetectorFragment resourceDetectorFragment, DownloadListBean downloadListBean) {
        List<DownloadItem> items;
        Integer resolution;
        resourceDetectorFragment.hideLoading();
        MovieDetailActivity.INSTANCE.a("获取到数据之后展示数据");
        if (resourceDetectorFragment.c1()) {
            resourceDetectorFragment.curResolution = (downloadListBean == null || (resolution = downloadListBean.getResolution()) == null) ? 480 : resolution.intValue();
            if (downloadListBean != null && (items = downloadListBean.getItems()) != null && !items.isEmpty()) {
                resourceDetectorFragment.resMap.put(Integer.valueOf(resourceDetectorFragment.curSeason), items);
                resourceDetectorFragment.m1(items, downloadListBean.getTotalEpisode());
            }
        }
        return Unit.f67184a;
    }

    private final boolean c1() {
        List<ResourceDetectors> resourceDetectors;
        Subject subject = this.mMovieDetailBean;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || resourceDetectors.isEmpty()) {
            return false;
        }
        return resourceDetectors.get(0).isCollection();
    }

    private final void d1(DubsInfo info) {
        G0().P().q(info);
    }

    private final void e1(final ResourcesSeasonList seasonList, final List seasons) {
        cn.m mViewBinding;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        if ((seasons != null ? seasons.size() : 0) <= 1) {
            cn.m mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (bLTextView2 = mViewBinding2.f17497f) == null) {
                return;
            }
            jg.c.g(bLTextView2);
            return;
        }
        if (seasons == null || (mViewBinding = getMViewBinding()) == null || (bLTextView = mViewBinding.f17497f) == null) {
            return;
        }
        jg.c.k(bLTextView);
        bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResourceDetectorFragment.f1(ResourcesSeasonList.this, this, seasons, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(ResourcesSeasonList resourcesSeasonList, final ResourceDetectorFragment resourceDetectorFragment, final List list, View view) {
        VideoDetailSeasonsSelectFragment.Companion companion = VideoDetailSeasonsSelectFragment.INSTANCE;
        Subject subject = resourceDetectorFragment.mMovieDetailBean;
        VideoDetailSeasonsSelectFragment a11 = companion.a(resourcesSeasonList, subject != null ? subject.getSubjectType() : null);
        a11.x0(resourceDetectorFragment.curSeason);
        Fragment parentFragment = resourceDetectorFragment.getParentFragment();
        if (parentFragment != null) {
            a11.n0(parentFragment, R$id.fl_bottom_dialog_container);
        }
        a11.w0(new Function1() { // from class: com.transsion.moviedetail.fragment.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g12;
                g12 = ResourceDetectorFragment.g1(list, resourceDetectorFragment, ((Integer) obj).intValue());
                return g12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(List list, ResourceDetectorFragment resourceDetectorFragment, int i11) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ResourcesSeason) obj).getSe() == i11) {
                break;
            }
        }
        ResourcesSeason resourcesSeason = (ResourcesSeason) obj;
        if (resourcesSeason == null) {
            return Unit.f67184a;
        }
        resourceDetectorFragment.curSeason = resourcesSeason.getSe();
        resourceDetectorFragment.k1();
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "ResourceDetectorFragment --> ", "seChange:" + resourceDetectorFragment.curSeason, false, 4, null);
        resourceDetectorFragment.G0().K().q(Integer.valueOf(resourceDetectorFragment.curSeason));
        resourceDetectorFragment.j1(com.transsion.baseui.util.n.a(resourcesSeason.getSe()));
        if (resourceDetectorFragment.resMap.containsKey(Integer.valueOf(resourcesSeason.getSe()))) {
            a.C0856a.f(c0856a, "ResourceDetectorFragment --> ", "se:" + resourceDetectorFragment.curSeason + " 已有缓存, 直接设数据", false, 4, null);
            List list2 = (List) resourceDetectorFragment.resMap.get(Integer.valueOf(resourcesSeason.getSe()));
            if (list2 != null) {
                resourceDetectorFragment.m1(list2, Integer.valueOf(resourcesSeason.getMaxEp()));
            }
        } else {
            resourceDetectorFragment.showLoading();
            int t11 = DownloadUtil.f60023a.t(list, resourceDetectorFragment.curSeason);
            if (t11 <= 0) {
                t11 = resourceDetectorFragment.curResolution;
            }
            int i12 = t11;
            c0856a.c("ResourceDetectorFragment --> ", "se:" + resourceDetectorFragment.curSeason + " 无缓存，请求数据, resolution:" + i12, true);
            MovieDetailViewModel G0 = resourceDetectorFragment.G0();
            Subject subject = resourceDetectorFragment.mMovieDetailBean;
            G0.x(subject != null ? subject.getSubjectId() : null, resourcesSeason.getSe(), 1, 3, i12);
        }
        return Unit.f67184a;
    }

    private final void h1(int position) {
        String str;
        String str2;
        boolean z10;
        List<ResourceDetectors> resourceDetectors;
        String subjectId;
        Context context;
        List<ResourceDetectors> resourceDetectors2;
        String str3;
        Subject subject = this.mMovieDetailBean;
        str = "";
        if (subject == null || (resourceDetectors2 = subject.getResourceDetectors()) == null) {
            str2 = "";
            z10 = false;
        } else {
            if (resourceDetectors2.isEmpty()) {
                str3 = "";
            } else {
                str3 = resourceDetectors2.get(0).getResourceLink();
                if (str3 == null) {
                    str3 = "";
                }
                String resourceId = resourceDetectors2.get(0).getResourceId();
                str = resourceId != null ? resourceId : "";
                if (resourceDetectors2.get(0).isMultiResolution()) {
                    z10 = true;
                    str2 = str3;
                }
            }
            z10 = false;
            str2 = str3;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.f58521j;
        DownloadManagerApi a11 = aVar.a();
        Subject subject2 = this.mMovieDetailBean;
        String subjectId2 = subject2 != null ? subject2.getSubjectId() : null;
        Subject subject3 = this.mMovieDetailBean;
        if (a11.w0(subjectId2, str, subject3 != null ? subject3.isSeries() : false, z10)) {
            Subject subject4 = this.mMovieDetailBean;
            if (subject4 == null || (subjectId = subject4.getSubjectId()) == null || (context = getContext()) == null) {
                return;
            }
            DownloadManagerApi.z0(aVar.a(), subjectId, context, "subjectdetail", null, 8, null);
            return;
        }
        Subject subject5 = this.mMovieDetailBean;
        if (subject5 == null || (resourceDetectors = subject5.getResourceDetectors()) == null || resourceDetectors.isEmpty()) {
            return;
        }
        ResourceDetectors resourceDetectors3 = resourceDetectors.get(0);
        if (resourceDetectors3 == null || !resourceDetectors3.isMultiResolution()) {
            DownloadManagerApi a12 = aVar.a();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            DownloadManagerApi.N(a12, requireActivity, this.mMovieDetailBean, "subjectdetail", null, this.ops, str2, null, this.moduleName, null, false, this.curSeason, false, 840, null);
            return;
        }
        List<DownloadItem> resolutionList = resourceDetectors3.getResolutionList();
        DownloadItem downloadItem = resolutionList != null ? resolutionList.get(position) : null;
        if (downloadItem != null) {
            F0(downloadItem, 1, 1, position);
        }
    }

    private final void hideLoading() {
        FrameLayout frameLayout;
        cn.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (frameLayout = mViewBinding.f17498g) == null) {
            return;
        }
        jg.c.g(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(int position, DownloadItem downloadItem, Integer totalEpisode) {
        List<ResourceDetectors> resourceDetectors;
        Context context;
        DownloadManagerApi.a aVar = DownloadManagerApi.f58521j;
        DownloadManagerApi a11 = aVar.a();
        String resourceId = downloadItem.getResourceId();
        Subject subject = this.mMovieDetailBean;
        if (DownloadManagerApi.x0(a11, null, resourceId, subject != null ? subject.isSeries() : false, false, 8, null)) {
            String resourceId2 = downloadItem.getResourceId();
            if (resourceId2 == null || (context = getContext()) == null) {
                return;
            }
            aVar.a().y0(null, context, "subjectdetail", resourceId2);
            return;
        }
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 == null || (resourceDetectors = subject2.getResourceDetectors()) == null || resourceDetectors.isEmpty()) {
            return;
        }
        ResourceDetectors resourceDetectors2 = resourceDetectors.get(0);
        if (resourceDetectors2 == null || !resourceDetectors2.isMultiResolution()) {
            F0(downloadItem, totalEpisode, 0, position);
            return;
        }
        List<DownloadItem> resolutionList = resourceDetectors2.getResolutionList();
        DownloadItem downloadItem2 = resolutionList != null ? resolutionList.get(position) : null;
        if (downloadItem2 != null) {
            F0(downloadItem2, totalEpisode, 1, position);
        }
    }

    private final void j1(String title) {
        hj.i iVar = hj.i.f64628a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "season_tab");
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title);
        Unit unit = Unit.f67184a;
        iVar.p("subjectdetail", linkedHashMap);
    }

    private final void k1() {
        cn.m mViewBinding;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        Subject subject = this.mMovieDetailBean;
        if (subject != null && subject.isTvType()) {
            cn.m mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (bLTextView2 = mViewBinding2.f17497f) == null) {
                return;
            }
            Context context = getContext();
            bLTextView2.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, jn.f.a(this.curSeason)) : null);
            return;
        }
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 == null || !subject2.isEduType() || (mViewBinding = getMViewBinding()) == null || (bLTextView = mViewBinding.f17497f) == null) {
            return;
        }
        Context context2 = getContext();
        bLTextView.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, jn.f.a(this.curSeason)) : null);
    }

    private final void l1() {
        List<ResourceDetectors> resourceDetectors;
        String resourceLink;
        Subject subject = this.mMovieDetailBean;
        String str = "";
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && !resourceDetectors.isEmpty() && (resourceLink = resourceDetectors.get(0).getResourceLink()) != null) {
            str = resourceLink;
        }
        DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        DownloadManagerApi.N(a11, requireActivity, this.mMovieDetailBean, "subjectdetail", null, this.ops, str, null, this.moduleName, null, false, this.curSeason, false, 840, null);
    }

    private final void m1(List downloadItem, final Integer totalEpisode) {
        RecyclerView recyclerView;
        String str;
        RecyclerView recyclerView2;
        BLTextView bLTextView;
        List arrayList = new ArrayList();
        Context context = getContext();
        int i11 = (context == null || !com.transsion.baseui.util.b.a(context)) ? 3 : 6;
        if (downloadItem.size() > i11) {
            arrayList = downloadItem.subList(0, i11);
            cn.m mViewBinding = getMViewBinding();
            if (mViewBinding != null && (bLTextView = mViewBinding.f17504m) != null) {
                jg.c.k(bLTextView);
            }
        } else {
            arrayList.addAll(downloadItem);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsion.moviedetail.adapter.n nVar = this.resAdapter;
            if (nVar != null) {
                if (nVar != null) {
                    nVar.n1(arrayList);
                    return;
                }
                return;
            }
            cn.m mViewBinding2 = getMViewBinding();
            RecyclerView recyclerView3 = null;
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f17502k) != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), i11));
                recyclerView.addItemDecoration(new d());
                Subject subject = this.mMovieDetailBean;
                if (subject == null || (str = subject.getTitle()) == null) {
                    str = "";
                }
                Subject subject2 = this.mMovieDetailBean;
                String str2 = (subject2 != null ? subject2.getDuration() : null);
                Subject subject3 = this.mMovieDetailBean;
                com.transsion.moviedetail.adapter.n nVar2 = new com.transsion.moviedetail.adapter.n(str, str2, arrayList, subject3 != null ? subject3.getSubjectType() : null);
                this.resAdapter = nVar2;
                Subject subject4 = this.mMovieDetailBean;
                nVar2.M1(subject4 != null ? subject4.getVipInfo() : null);
                nVar2.L1(this.mMovieDetailBean);
                nVar2.l(R$id.itemRoot);
                nVar2.s1(new p6.b() { // from class: com.transsion.moviedetail.fragment.s0
                    @Override // p6.b
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                        ResourceDetectorFragment.n1(ResourceDetectorFragment.this, totalEpisode, baseQuickAdapter, view, i12);
                    }
                });
                recyclerView.setAdapter(nVar2);
                cn.m mViewBinding3 = getMViewBinding();
                if (mViewBinding3 != null && (recyclerView2 = mViewBinding3.f17502k) != null) {
                    recyclerView2.setItemAnimator(null);
                }
                recyclerView3 = recyclerView;
            }
            Result.m1185constructorimpl(recyclerView3);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(ResourceDetectorFragment resourceDetectorFragment, Integer num, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (adapter.getItemCount() > i11) {
            Object f02 = adapter.f0(i11);
            DownloadItem downloadItem = f02 instanceof DownloadItem ? (DownloadItem) f02 : null;
            if (downloadItem == null) {
                return;
            }
            resourceDetectorFragment.i1(i11, downloadItem, num);
        }
    }

    private final void showLoading() {
        FrameLayout frameLayout;
        cn.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (frameLayout = mViewBinding.f17498g) == null) {
            return;
        }
        jg.c.k(frameLayout);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public cn.m getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        cn.m c11 = cn.m.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        AppCompatImageView appCompatImageView2;
        AppCompatTextView appCompatTextView;
        cn.m mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.f17494c) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.o0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorFragment.N0(ResourceDetectorFragment.this, view);
                }
            });
        }
        cn.m mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView2 = mViewBinding2.f17493b) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorFragment.O0(ResourceDetectorFragment.this, view);
                }
            });
        }
        cn.m mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (bLTextView2 = mViewBinding3.f17504m) != null) {
            bLTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorFragment.P0(ResourceDetectorFragment.this, view);
                }
            });
        }
        cn.m mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (bLTextView = mViewBinding4.f17503l) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorFragment.Q0(ResourceDetectorFragment.this, view);
                }
            });
        }
        cn.m mViewBinding5 = getMViewBinding();
        if (mViewBinding5 == null || (appCompatImageView = mViewBinding5.f17493b) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResourceDetectorFragment.S0(ResourceDetectorFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        WatchModeTipsView watchModeTipsView;
        ResourceDetectors resourceDetectors;
        cn.m mViewBinding;
        AppCompatTextView appCompatTextView;
        BLTextView bLTextView;
        List<DubsInfo> dubs;
        Object obj = null;
        if (c1()) {
            MovieDetailViewModel G0 = G0();
            Subject subject = this.mMovieDetailBean;
            G0.z(subject != null ? subject.getSubjectId() : null);
        } else {
            J0();
        }
        D0();
        T0();
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 != null && (dubs = subject2.getDubs()) != null) {
            M0(dubs);
        }
        Subject subject3 = this.mMovieDetailBean;
        if (subject3 != null) {
            String subjectId = subject3.getSubjectId();
            List<DubsInfo> dubs2 = subject3.getDubs();
            this.isAudioDubs = dubs2 != null && (dubs2.isEmpty() ^ true) && dubs2.size() > 1;
            a.C0856a.f(lg.a.f68962a, "ResourceDetectorFragment --> ", "video res-dubs size: " + (dubs2 != null ? Integer.valueOf(dubs2.size()) : null), false, 4, null);
            if (this.isAudioDubs && dubs2 != null) {
                Iterator<T> it = dubs2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.c(((DubsInfo) next).getSubjectId(), subjectId)) {
                        obj = next;
                        break;
                    }
                }
                DubsInfo dubsInfo = (DubsInfo) obj;
                if (dubsInfo != null) {
                    dubsInfo.setSelected(true);
                    cn.m mViewBinding2 = getMViewBinding();
                    if (mViewBinding2 != null && (bLTextView = mViewBinding2.f17503l) != null) {
                        bLTextView.setText(dubsInfo.getLanName());
                    }
                }
            }
            List<ResourceDetectors> resourceDetectors2 = subject3.getResourceDetectors();
            if (resourceDetectors2 != null && (resourceDetectors = (ResourceDetectors) CollectionsKt.k0(resourceDetectors2)) != null && (mViewBinding = getMViewBinding()) != null && (appCompatTextView = mViewBinding.f17495d) != null) {
                appCompatTextView.setText(resourceDetectors.getUploadBy());
            }
        }
        cn.m mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (watchModeTipsView = mViewBinding3.f17501j) == null) {
            return;
        }
        watchModeTipsView.checkShow();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        Subject subject;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        G0().L().j(this, new c(new Function1() { // from class: com.transsion.moviedetail.fragment.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Z0;
                Z0 = ResourceDetectorFragment.Z0(ResourceDetectorFragment.this, (ResourcesSeasonList) obj);
                return Z0;
            }
        }));
        G0().y().j(this, new c(new Function1() { // from class: com.transsion.moviedetail.fragment.d1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit a12;
                a12 = ResourceDetectorFragment.a1(ResourceDetectorFragment.this, (DownloadListBean) obj);
                return a12;
            }
        }));
        G0().w().j(this, new c(new Function1() { // from class: com.transsion.moviedetail.fragment.e1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit b12;
                b12 = ResourceDetectorFragment.b1(ResourceDetectorFragment.this, (DownloadListBean) obj);
                return b12;
            }
        }));
        G0().K().j(this, new c(new Function1() { // from class: com.transsion.moviedetail.fragment.f1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit W0;
                W0 = ResourceDetectorFragment.W0(ResourceDetectorFragment.this, (Integer) obj);
                return W0;
            }
        }));
        G0().K().q(Integer.valueOf(this.curSeason));
        Subject subject2 = this.mMovieDetailBean;
        if ((subject2 == null || !subject2.isMovieType()) && ((subject = this.mMovieDetailBean) == null || !subject.isTvType())) {
            cn.m mViewBinding = getMViewBinding();
            if (mViewBinding != null && (bLTextView = mViewBinding.f17503l) != null) {
                jg.c.g(bLTextView);
            }
        } else {
            cn.m mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (bLTextView2 = mViewBinding2.f17503l) != null) {
                bLTextView2.setVisibility(this.isAudioDubs ? 0 : 8);
            }
        }
        H0().d().j(this, new c(new Function1() { // from class: com.transsion.moviedetail.fragment.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = ResourceDetectorFragment.X0(ResourceDetectorFragment.this, (Pair) obj);
                return X0;
            }
        }));
        H0().c().j(this, new c(new Function1() { // from class: com.transsion.moviedetail.fragment.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = ResourceDetectorFragment.Y0(ResourceDetectorFragment.this, (List) obj);
                return Y0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.mMovieDetailBean = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.ops = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.autoPlay = arguments3 != null ? arguments3.getBoolean("auto_play") : false;
        Bundle arguments4 = getArguments();
        this.autoPlayResourceId = arguments4 != null ? arguments4.getString("auto_play_resource_id") : null;
        Bundle arguments5 = getArguments();
        this.moduleName = arguments5 != null ? arguments5.getString("module_name") : null;
        Bundle arguments6 = getArguments();
        int i11 = arguments6 != null ? arguments6.getInt("season") : 1;
        this.curSeason = i11;
        if (i11 <= 0) {
            this.curSeason = 1;
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }
}
