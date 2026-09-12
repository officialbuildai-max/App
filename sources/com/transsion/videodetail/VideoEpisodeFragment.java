package com.transsion.videodetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetail.fragment.ResourceDetectorDialogFragment;
import com.transsion.moviedetail.fragment.VideoDetailSeasonsSelectFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.ranges.IntRange;
import lg.a;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u001f\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u0016J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b)\u0010*J!\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u0007H\u0016¢\u0006\u0004\b,\u0010\u0004J2\u00103\u001a\u00020\u00072#\u00102\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u0007\u0018\u00010-¢\u0006\u0004\b3\u00104R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u00107\u001a\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR3\u0010Z\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u0007\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010NR\u0016\u0010a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010VR\u0016\u0010c\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010\\R\u0014\u0010e\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010\\¨\u0006g"}, d2 = {"Lcom/transsion/videodetail/VideoEpisodeFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Ljx/d;", "<init>", "()V", "", "showGrid", "", "C0", "(Z)V", "Lcom/transsion/moviedetailapi/bean/ResourcesSeasonList;", "seasonsList", "u0", "(Lcom/transsion/moviedetailapi/bean/ResourcesSeasonList;)V", "R0", "", "Lcom/transsion/videodetail/bean/VideoDetailMediaSource;", "list", "S0", "(Ljava/util/List;)V", WebConstants.FIELD_ITEM, "M0", "(Lcom/transsion/videodetail/bean/VideoDetailMediaSource;)V", "", RequestParameters.POSITION, "O0", "(I)V", "season", "N0", "playingSource", "Q0", "Landroid/view/LayoutInflater;", "inflater", "t0", "(Landroid/view/LayoutInflater;)Ljx/d;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "Lkotlin/Function1;", "Lcom/transsion/moviedetailapi/bean/DubsInfo;", "Lkotlin/ParameterName;", "name", "info", "callback", "P0", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "a", "Lkotlin/Lazy;", "q0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "Lcom/transsion/videodetail/VideoDetailViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "s0", "()Lcom/transsion/videodetail/VideoDetailViewModel;", "videoDetailViewModel", "Lcom/transsion/videodetail/adapter/b;", "c", "Lcom/transsion/videodetail/adapter/b;", "videoDetailEpisodeAdapter", "Lcom/transsion/moviedetailapi/bean/Subject;", "d", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "", "e", "J", "lastClickTime", "", "f", "Ljava/lang/String;", "moduleName", "Lcom/transsion/player/longvideo/helper/o0;", be.g.f16474b, "r0", "()Lcom/transsion/player/longvideo/helper/o0;", "subtitleViewModel", "h", "Z", "isAudioDubs", "i", "Lkotlin/jvm/functions/Function1;", "audioSelectCallback", com.mbridge.msdk.foundation.same.report.j.f35620b, "I", "curSeason", CampaignEx.JSON_KEY_AD_K, "curEpTabTitle", "l", "isSeasonTab", "m", "seasonsCount", "n", "scrollOffset", "o", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class VideoEpisodeFragment extends BaseFragment<jx.d> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.transsion.videodetail.adapter.b videoDetailEpisodeAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAudioDubs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1 audioSelectCallback;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy videoDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$4
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
    private final Lazy subtitleViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.helper.o0.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$5
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$6
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

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String curEpTabTitle = "1-50";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isSeasonTab = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int seasonsCount = 1;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int scrollOffset = (com.blankj.utilcode.util.y.e() / 2) - com.blankj.utilcode.util.a0.a(88.0f);

    /* loaded from: classes7.dex */
    static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57796a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57796a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57796a;
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
            this.f57796a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(VideoEpisodeFragment videoEpisodeFragment, Pair pair) {
        BLTextView bLTextView;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "VideoDetailEpisode", "字幕选择了, name:" + pair.getFirst() + ", " + pair.getSecond(), false, 4, null);
        if (videoEpisodeFragment.isAudioDubs) {
            a.C0856a.f(c0856a, "VideoDetailEpisode", "字幕选择了, 是多配音，不展示字幕", false, 4, null);
            return Unit.f67184a;
        }
        if (Intrinsics.c(pair.getFirst(), BucketVersioningConfiguration.OFF)) {
            a.C0856a.f(c0856a, "VideoDetailEpisode", "关闭了字幕，文案不更改", false, 4, null);
            return Unit.f67184a;
        }
        jx.d mViewBinding = videoEpisodeFragment.getMViewBinding();
        if (mViewBinding != null && (bLTextView = mViewBinding.f66480i) != null) {
            bLTextView.setText((CharSequence) pair.getFirst());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(VideoEpisodeFragment videoEpisodeFragment, List list) {
        BLTextView bLTextView;
        BLTextView bLTextView2;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            jx.d mViewBinding = videoEpisodeFragment.getMViewBinding();
            if (mViewBinding != null && (bLTextView = mViewBinding.f66480i) != null) {
                jg.c.g(bLTextView);
            }
            return Unit.f67184a;
        }
        jx.d mViewBinding2 = videoEpisodeFragment.getMViewBinding();
        if (mViewBinding2 != null && (bLTextView2 = mViewBinding2.f66480i) != null) {
            jg.c.k(bLTextView2);
        }
        return Unit.f67184a;
    }

    private final void C0(boolean showGrid) {
        RecyclerView recyclerView;
        Integer subjectType;
        jx.d mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f66479h) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new ig.e(8.0f, 0.0f, showGrid ? 0.0f : 4.0f, 12.0f, 2, null));
        Subject subject = this.mMovieDetailBean;
        final com.transsion.videodetail.adapter.b bVar = new com.transsion.videodetail.adapter.b((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue(), showGrid, R$layout.item_video_detail_episode);
        bVar.w1(new p6.d() { // from class: com.transsion.videodetail.i1
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                VideoEpisodeFragment.D0(VideoEpisodeFragment.this, bVar, baseQuickAdapter, view, i11);
            }
        });
        this.videoDetailEpisodeAdapter = bVar;
        recyclerView.setAdapter(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(VideoEpisodeFragment videoEpisodeFragment, com.transsion.videodetail.adapter.b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        if (videoEpisodeFragment.lastClickTime == 0 || System.currentTimeMillis() - videoEpisodeFragment.lastClickTime > 1000) {
            videoEpisodeFragment.lastClickTime = System.currentTimeMillis();
            videoEpisodeFragment.s0().C((VideoDetailMediaSource) bVar.f0(i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(final VideoEpisodeFragment videoEpisodeFragment, View view) {
        String subjectId;
        Fragment parentFragment;
        a.C0856a.f(lg.a.f68962a, "VideoEpisodeFragment", "innerTvTitle click then switch audio track", false, 4, null);
        Subject subject = videoEpisodeFragment.mMovieDetailBean;
        if (subject == null || (subjectId = subject.getSubjectId()) == null || (parentFragment = videoEpisodeFragment.getParentFragment()) == null) {
            return;
        }
        VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog = new VideoDetailAudioTrackSelectDialog();
        videoDetailAudioTrackSelectDialog.A0(subjectId);
        videoDetailAudioTrackSelectDialog.n0(parentFragment, R$id.fl_bottom_dialog_container);
        videoDetailAudioTrackSelectDialog.z0(new Function1() { // from class: com.transsion.videodetail.j1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = VideoEpisodeFragment.F0(VideoEpisodeFragment.this, (DubsInfo) obj);
                return F0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(VideoEpisodeFragment videoEpisodeFragment, DubsInfo it) {
        Intrinsics.h(it, "it");
        Function1 function1 = videoEpisodeFragment.audioSelectCallback;
        if (function1 != null) {
            function1.invoke(it);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(final VideoEpisodeFragment videoEpisodeFragment, View view) {
        Fragment parentFragment = videoEpisodeFragment.getParentFragment();
        if (parentFragment != null) {
            VideoDetailSeasonsSelectFragment.Companion companion = VideoDetailSeasonsSelectFragment.INSTANCE;
            ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) videoEpisodeFragment.s0().z().f();
            Subject subject = videoEpisodeFragment.mMovieDetailBean;
            VideoDetailSeasonsSelectFragment a11 = companion.a(resourcesSeasonList, subject != null ? subject.getSubjectType() : null);
            a11.x0(videoEpisodeFragment.curSeason);
            a11.n0(parentFragment, R$id.fl_bottom_dialog_container);
            a11.w0(new Function1() { // from class: com.transsion.videodetail.h1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit H0;
                    H0 = VideoEpisodeFragment.H0(VideoEpisodeFragment.this, ((Integer) obj).intValue());
                    return H0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(VideoEpisodeFragment videoEpisodeFragment, int i11) {
        a.C0856a.f(lg.a.f68962a, "VideoDetailEpisode", "setSeasonSelectCallback, season:" + i11, false, 4, null);
        videoEpisodeFragment.curSeason = i11;
        videoEpisodeFragment.N0(i11);
        videoEpisodeFragment.R0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(final VideoEpisodeFragment videoEpisodeFragment, View view) {
        Fragment parentFragment;
        Subject subject = videoEpisodeFragment.mMovieDetailBean;
        if (subject == null || (parentFragment = videoEpisodeFragment.getParentFragment()) == null) {
            return;
        }
        VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment = new VideoDetailAllEpisodesFragment();
        videoDetailAllEpisodesFragment.H0(subject, videoEpisodeFragment.curSeason, (ResourcesSeasonList) videoEpisodeFragment.s0().z().f());
        videoDetailAllEpisodesFragment.n0(parentFragment, R$id.fl_bottom_dialog_container);
        videoDetailAllEpisodesFragment.I0(new Function1() { // from class: com.transsion.videodetail.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J0;
                J0 = VideoEpisodeFragment.J0(VideoEpisodeFragment.this, (VideoDetailMediaSource) obj);
                return J0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(VideoEpisodeFragment videoEpisodeFragment, VideoDetailMediaSource videoDetailMediaSource) {
        if (videoEpisodeFragment.lastClickTime == 0 || System.currentTimeMillis() - videoEpisodeFragment.lastClickTime > 1000) {
            videoEpisodeFragment.lastClickTime = System.currentTimeMillis();
            videoEpisodeFragment.M0(videoDetailMediaSource);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(VideoEpisodeFragment videoEpisodeFragment, View view) {
        List<ResourceDetectors> resourceDetectors;
        ResourceDetectors resourceDetectors2;
        String str;
        Subject subject = videoEpisodeFragment.mMovieDetailBean;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || (resourceDetectors2 = (ResourceDetectors) CollectionsKt.k0(resourceDetectors)) == null) {
            return;
        }
        ResourceDetectorDialogFragment.Companion companion = ResourceDetectorDialogFragment.INSTANCE;
        Subject subject2 = videoEpisodeFragment.mMovieDetailBean;
        if (subject2 == null || (str = subject2.getTitle()) == null) {
            str = "";
        }
        ResourceDetectorDialogFragment a11 = companion.a(str, resourceDetectors2);
        FragmentManager childFragmentManager = videoEpisodeFragment.getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        a11.show(childFragmentManager, "ResourceDetectorFragment --> ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(VideoEpisodeFragment videoEpisodeFragment, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = videoEpisodeFragment.mMovieDetailBean;
        Navigator.x(K.K("subject_id", subject != null ? subject.getSubjectId() : null), videoEpisodeFragment.getContext(), null, 2, null);
    }

    private final void M0(VideoDetailMediaSource item) {
        List<Object> data;
        s0().C(item);
        com.transsion.videodetail.adapter.b bVar = this.videoDetailEpisodeAdapter;
        int i11 = -1;
        if (bVar != null && (data = bVar.getData()) != null) {
            Iterator<Object> it = data.iterator();
            int i12 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) it.next();
                if (item != null && videoDetailMediaSource.getSe() == item.getSe() && videoDetailMediaSource.getEp() == item.getEp()) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
        }
        if (i11 >= 0) {
            com.transsion.videodetail.adapter.b bVar2 = this.videoDetailEpisodeAdapter;
            if (i11 < (bVar2 != null ? bVar2.getItemCount() : 0)) {
                O0(i11);
            }
        }
    }

    private final void N0(int season) {
        this.curSeason = season;
        q0().K().q(Integer.valueOf(season));
        com.transsion.videodetail.adapter.b bVar = this.videoDetailEpisodeAdapter;
        if (bVar != null) {
            bVar.n1(com.transsion.videodetail.util.d.f58003a.a(s0(), season));
        }
    }

    private final void O0(int position) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (position < 0) {
            return;
        }
        try {
            jx.d mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView2 = mViewBinding.f66479h) != null) {
                recyclerView2.scrollToPosition(position);
            }
            jx.d mViewBinding2 = getMViewBinding();
            RecyclerView.m layoutManager = (mViewBinding2 == null || (recyclerView = mViewBinding2.f66479h) == null) ? null : recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int i11 = this.scrollOffset;
                if (i11 <= 0) {
                    i11 = 0;
                }
                linearLayoutManager.scrollToPositionWithOffset(position, i11);
            }
        } catch (Throwable unused) {
        }
    }

    private final void Q0(VideoDetailMediaSource playingSource) {
        List<ResourcesSeason> seasons;
        com.transsion.videodetail.adapter.b bVar = this.videoDetailEpisodeAdapter;
        if (bVar != null) {
            bVar.F1(playingSource);
        }
        a.C0856a.f(lg.a.f68962a, "VideoDetailEpisode", "setPlayingItem,--------, se:" + (playingSource != null ? Integer.valueOf(playingSource.getSe()) : null) + ", ep:" + (playingSource != null ? Integer.valueOf(playingSource.getEp()) : null), false, 4, null);
        int i11 = 0;
        if (!this.isSeasonTab) {
            Map map = (Map) s0().t().f();
            if (map != null) {
                int i12 = 0;
                for (Map.Entry entry : map.entrySet()) {
                    if (!((Collection) entry.getValue()).isEmpty()) {
                        IntRange intRange = new IntRange(((VideoDetailMediaSource) CollectionsKt.i0((List) entry.getValue())).getEp(), ((VideoDetailMediaSource) CollectionsKt.u0((List) entry.getValue())).getEp());
                        Integer valueOf = playingSource != null ? Integer.valueOf(playingSource.getEp()) : null;
                        if (valueOf != null && intRange.o(valueOf.intValue())) {
                            String str = (String) entry.getKey();
                            this.curEpTabTitle = str;
                            a.C0856a.f(lg.a.f68962a, "VideoDetailEpisode", "setPlayingItem,index:" + i12 + ", EpTabTitle:" + str, false, 4, null);
                        }
                    }
                    i12++;
                }
                return;
            }
            return;
        }
        ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) s0().z().f();
        if (resourcesSeasonList != null && (seasons = resourcesSeasonList.getSeasons()) != null) {
            Iterator<ResourcesSeason> it = seasons.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                ResourcesSeason next = it.next();
                if (playingSource != null && next.getSe() == playingSource.getSe()) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        if (i11 > 0) {
            int se2 = playingSource != null ? playingSource.getSe() : 1;
            this.curSeason = se2;
            a.C0856a.f(lg.a.f68962a, "VideoDetailEpisode", "setPlayingItem,  curSeason：" + se2, false, 4, null);
            N0(this.curSeason);
        }
    }

    private final void R0() {
        jx.d mViewBinding;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        Subject subject = this.mMovieDetailBean;
        if (subject != null && subject.isTvType()) {
            jx.d mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (bLTextView2 = mViewBinding2.f66477f) == null) {
                return;
            }
            Context context = getContext();
            bLTextView2.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, jn.f.a(this.curSeason)) : null);
            return;
        }
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 == null || !subject2.isEduType() || (mViewBinding = getMViewBinding()) == null || (bLTextView = mViewBinding.f66477f) == null) {
            return;
        }
        Context context2 = getContext();
        bLTextView.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, jn.f.a(this.curSeason)) : null);
    }

    private final void S0(List list) {
        BLTextView bLTextView;
        Subject subject;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        if (list.size() > 1 && (subject = this.mMovieDetailBean) != null && subject.isMovieType()) {
            jx.d mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView2 = mViewBinding.f66479h) != null && recyclerView2.getItemDecorationCount() > 0) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    recyclerView2.removeItemDecorationAt(0);
                    Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m1185constructorimpl(ResultKt.a(th2));
                }
            }
            jx.d mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f66479h) != null) {
                recyclerView.addItemDecoration(new ig.e(8.0f, 0.0f, 12.0f, list.size() > 6 ? 12.0f : 0.0f, 2, null));
            }
        }
        jx.d mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (bLTextView = mViewBinding3.f66481j) != null) {
            bLTextView.setVisibility(list.size() > 6 ? 0 : 8);
        }
        VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) CollectionsKt.k0(list);
        if (videoDetailMediaSource != null && videoDetailMediaSource.getSe() == 0 && videoDetailMediaSource.getEp() == 0) {
            Subject subject2 = this.mMovieDetailBean;
            videoDetailMediaSource.setName(subject2 != null ? subject2.getTitle() : null);
        }
        com.transsion.videodetail.adapter.b bVar = this.videoDetailEpisodeAdapter;
        if (bVar != null) {
            bVar.n1(com.transsion.videodetail.util.d.f58003a.a(s0(), this.curSeason));
        }
    }

    private final MovieDetailViewModel q0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    private final com.transsion.player.longvideo.helper.o0 r0() {
        return (com.transsion.player.longvideo.helper.o0) this.subtitleViewModel.getValue();
    }

    private final VideoDetailViewModel s0() {
        return (VideoDetailViewModel) this.videoDetailViewModel.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void u0(com.transsion.moviedetailapi.bean.ResourcesSeasonList r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L10
            java.util.List r0 = r7.getSeasons()
            if (r0 == 0) goto L10
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 != r1) goto L10
            return
        L10:
            if (r7 == 0) goto L5a
            java.util.List r7 = r7.getSeasons()
            if (r7 == 0) goto L5a
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L54
            java.lang.Object r0 = r7.next()
            boolean r1 = r7.hasNext()
            if (r1 != 0) goto L2f
            goto L4b
        L2f:
            r1 = r0
            com.transsion.moviedetailapi.bean.ResourcesSeason r1 = (com.transsion.moviedetailapi.bean.ResourcesSeason) r1
            int r1 = r1.getSe()
        L36:
            java.lang.Object r2 = r7.next()
            r3 = r2
            com.transsion.moviedetailapi.bean.ResourcesSeason r3 = (com.transsion.moviedetailapi.bean.ResourcesSeason) r3
            int r3 = r3.getSe()
            if (r1 <= r3) goto L45
            r0 = r2
            r1 = r3
        L45:
            boolean r2 = r7.hasNext()
            if (r2 != 0) goto L36
        L4b:
            com.transsion.moviedetailapi.bean.ResourcesSeason r0 = (com.transsion.moviedetailapi.bean.ResourcesSeason) r0
            if (r0 == 0) goto L5a
            int r7 = r0.getSe()
            goto L5c
        L54:
            java.util.NoSuchElementException r7 = new java.util.NoSuchElementException
            r7.<init>()
            throw r7
        L5a:
            int r7 = r6.curSeason
        L5c:
            lg.a$a r0 = lg.a.f68962a
            int r1 = r6.curSeason
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "initCurSeason, minSeason:"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = "， curSeason："
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "VideoDetailEpisode"
            r3 = 0
            lg.a.C0856a.f(r0, r1, r2, r3, r4, r5)
            int r0 = r6.curSeason
            if (r0 >= r7) goto L8a
            r6.curSeason = r7
            r6.R0()
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.VideoEpisodeFragment.u0(com.transsion.moviedetailapi.bean.ResourcesSeasonList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(VideoEpisodeFragment videoEpisodeFragment, ResourcesSeasonList resourcesSeasonList) {
        Subject subject;
        videoEpisodeFragment.u0(resourcesSeasonList);
        videoEpisodeFragment.hideLoading();
        Subject subject2 = videoEpisodeFragment.mMovieDetailBean;
        boolean z10 = true;
        if ((subject2 == null || !subject2.isTvType()) && ((subject = videoEpisodeFragment.mMovieDetailBean) == null || !subject.isEduType())) {
            z10 = false;
        }
        videoEpisodeFragment.C0(z10);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(VideoEpisodeFragment videoEpisodeFragment, List list) {
        videoEpisodeFragment.S0(list);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(VideoEpisodeFragment videoEpisodeFragment, VideoDetailMediaSource videoDetailMediaSource) {
        videoEpisodeFragment.Q0(videoDetailMediaSource);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(VideoEpisodeFragment videoEpisodeFragment, Integer num) {
        videoEpisodeFragment.R0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(VideoEpisodeFragment videoEpisodeFragment, ResourcesSeasonList resourcesSeasonList) {
        BLTextView bLTextView;
        BLTextView bLTextView2;
        BLTextView bLTextView3;
        List<ResourcesSeason> seasons;
        int size = (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) ? 1 : seasons.size();
        videoEpisodeFragment.seasonsCount = size;
        jx.d mViewBinding = videoEpisodeFragment.getMViewBinding();
        if (mViewBinding != null && (bLTextView = mViewBinding.f66477f) != null && bLTextView.getVisibility() == 0) {
            if (size == 1) {
                jx.d mViewBinding2 = videoEpisodeFragment.getMViewBinding();
                if (mViewBinding2 != null && (bLTextView3 = mViewBinding2.f66477f) != null) {
                    jg.c.g(bLTextView3);
                }
            } else {
                jx.d mViewBinding3 = videoEpisodeFragment.getMViewBinding();
                if (mViewBinding3 != null && (bLTextView2 = mViewBinding3.f66477f) != null) {
                    jg.c.k(bLTextView2);
                }
            }
        }
        return Unit.f67184a;
    }

    public final void P0(Function1 callback) {
        this.audioSelectCallback = callback;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Subject subject;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        Object obj;
        BLTextView bLTextView3;
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        s0().z().j(this, new b(new Function1() { // from class: com.transsion.videodetail.o1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit v02;
                v02 = VideoEpisodeFragment.v0(VideoEpisodeFragment.this, (ResourcesSeasonList) obj2);
                return v02;
            }
        }));
        s0().s().j(this, new b(new Function1() { // from class: com.transsion.videodetail.p1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit w02;
                w02 = VideoEpisodeFragment.w0(VideoEpisodeFragment.this, (List) obj2);
                return w02;
            }
        }));
        s0().x().j(this, new b(new Function1() { // from class: com.transsion.videodetail.q1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit x02;
                x02 = VideoEpisodeFragment.x0(VideoEpisodeFragment.this, (VideoDetailMediaSource) obj2);
                return x02;
            }
        }));
        q0().K().j(this, new b(new Function1() { // from class: com.transsion.videodetail.r1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit y02;
                y02 = VideoEpisodeFragment.y0(VideoEpisodeFragment.this, (Integer) obj2);
                return y02;
            }
        }));
        s0().z().j(this, new b(new Function1() { // from class: com.transsion.videodetail.s1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit z02;
                z02 = VideoEpisodeFragment.z0(VideoEpisodeFragment.this, (ResourcesSeasonList) obj2);
                return z02;
            }
        }));
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 != null) {
            String subjectId = subject2.getSubjectId();
            List<DubsInfo> dubs = subject2.getDubs();
            this.isAudioDubs = dubs != null && (dubs.isEmpty() ^ true) && dubs.size() > 1;
            if (dubs != null) {
                Iterator<T> it = dubs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.c(((DubsInfo) obj).getSubjectId(), subjectId)) {
                            break;
                        }
                    }
                }
                DubsInfo dubsInfo = (DubsInfo) obj;
                if (dubsInfo != null && this.isAudioDubs) {
                    dubsInfo.setSelected(true);
                    jx.d mViewBinding = getMViewBinding();
                    if (mViewBinding != null && (bLTextView3 = mViewBinding.f66480i) != null) {
                        bLTextView3.setText(dubsInfo.getLanName());
                    }
                }
            }
        }
        Subject subject3 = this.mMovieDetailBean;
        if ((subject3 == null || !subject3.isMovieType()) && ((subject = this.mMovieDetailBean) == null || !subject.isTvType())) {
            jx.d mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (bLTextView = mViewBinding2.f66480i) != null) {
                jg.c.g(bLTextView);
            }
        } else {
            jx.d mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (bLTextView2 = mViewBinding3.f66480i) != null) {
                bLTextView2.setVisibility(this.isAudioDubs ? 0 : 8);
            }
        }
        r0().d().j(this, new b(new Function1() { // from class: com.transsion.videodetail.e1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit A0;
                A0 = VideoEpisodeFragment.A0(VideoEpisodeFragment.this, (Pair) obj2);
                return A0;
            }
        }));
        r0().c().j(this, new b(new Function1() { // from class: com.transsion.videodetail.f1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit B0;
                B0 = VideoEpisodeFragment.B0(VideoEpisodeFragment.this, (List) obj2);
                return B0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        BLTextView bLTextView;
        BLTextView bLTextView2;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        List<ResourceDetectors> resourceDetectors;
        ResourceDetectors resourceDetectors2;
        jx.d mViewBinding;
        AppCompatTextView appCompatTextView3;
        BLTextView bLTextView3;
        Intrinsics.h(view, "view");
        jx.d mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (bLTextView3 = mViewBinding2.f66481j) != null) {
            bLTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.d1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEpisodeFragment.I0(VideoEpisodeFragment.this, view2);
                }
            });
        }
        Subject subject = this.mMovieDetailBean;
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && (resourceDetectors2 = (ResourceDetectors) CollectionsKt.k0(resourceDetectors)) != null && (mViewBinding = getMViewBinding()) != null && (appCompatTextView3 = mViewBinding.f66475d) != null) {
            appCompatTextView3.setText(resourceDetectors2.getUploadBy());
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.transsion.videodetail.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoEpisodeFragment.K0(VideoEpisodeFragment.this, view2);
            }
        };
        jx.d mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appCompatTextView2 = mViewBinding3.f66474c) != null) {
            appCompatTextView2.setOnClickListener(onClickListener);
        }
        jx.d mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatTextView = mViewBinding4.f66475d) != null) {
            appCompatTextView.setOnClickListener(onClickListener);
        }
        jx.d mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (appCompatImageView = mViewBinding5.f66473b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.l1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEpisodeFragment.L0(VideoEpisodeFragment.this, view2);
                }
            });
        }
        jx.d mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (bLTextView2 = mViewBinding6.f66480i) != null) {
            bLTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEpisodeFragment.E0(VideoEpisodeFragment.this, view2);
                }
            });
        }
        jx.d mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (bLTextView = mViewBinding7.f66477f) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.n1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEpisodeFragment.G0(VideoEpisodeFragment.this, view2);
                }
            });
        }
        jx.d mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null) {
            Subject subject2 = this.mMovieDetailBean;
            if (subject2 != null && subject2.isTvType()) {
                BLTextView ivSeasons = mViewBinding8.f66477f;
                Intrinsics.g(ivSeasons, "ivSeasons");
                jg.c.k(ivSeasons);
                BLTextView bLTextView4 = mViewBinding8.f66477f;
                Context context = getContext();
                bLTextView4.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, jn.f.a(this.curSeason)) : null);
                return;
            }
            Subject subject3 = this.mMovieDetailBean;
            if (subject3 == null || !subject3.isEduType()) {
                BLTextView ivSeasons2 = mViewBinding8.f66477f;
                Intrinsics.g(ivSeasons2, "ivSeasons");
                jg.c.g(ivSeasons2);
            } else {
                BLTextView ivSeasons3 = mViewBinding8.f66477f;
                Intrinsics.g(ivSeasons3, "ivSeasons");
                jg.c.k(ivSeasons3);
                BLTextView bLTextView5 = mViewBinding8.f66477f;
                Context context2 = getContext();
                bLTextView5.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, jn.f.a(this.curSeason)) : null);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.mMovieDetailBean = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.moduleName = arguments2 != null ? arguments2.getString("module_name") : null;
        Bundle arguments3 = getArguments();
        this.curSeason = arguments3 != null ? arguments3.getInt("season") : 1;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public jx.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        jx.d c11 = jx.d.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
