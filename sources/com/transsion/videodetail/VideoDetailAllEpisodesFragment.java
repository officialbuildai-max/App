package com.transsion.videodetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.moviedetail.fragment.VideoDetailSeasonsSelectFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004J4\u0010'\u001a\u00020\u00052%\u0010&\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"¢\u0006\u0004\b'\u0010(R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR5\u0010G\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/transsion/videodetail/VideoDetailAllEpisodesFragment;", "Lcom/transsion/play/detail/fragment/BaseBottomDialogFragment;", "Ljx/b;", "<init>", "()V", "", "K0", "", "season", "G0", "(I)V", "Lcom/transsion/videodetail/bean/VideoDetailMediaSource;", "playingSource", "J0", "(Lcom/transsion/videodetail/bean/VideoDetailMediaSource;)V", "y0", "Landroid/view/LayoutInflater;", "inflater", "x0", "(Landroid/view/LayoutInflater;)Ljx/b;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "Lcom/transsion/moviedetailapi/bean/Subject;", "mSubject", "curSeason", "Lcom/transsion/moviedetailapi/bean/ResourcesSeasonList;", "seasonList", "H0", "(Lcom/transsion/moviedetailapi/bean/Subject;ILcom/transsion/moviedetailapi/bean/ResourcesSeasonList;)V", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", WebConstants.FIELD_ITEM, "callback", "I0", "(Lkotlin/jvm/functions/Function1;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/moviedetailapi/bean/Subject;", "c", "I", "d", "Lcom/transsion/moviedetailapi/bean/ResourcesSeasonList;", "Lcom/transsion/videodetail/adapter/b;", "e", "Lcom/transsion/videodetail/adapter/b;", "videoDetailEpisodeAdapter", "Lcom/transsion/videodetail/VideoDetailViewModel;", "f", "Lkotlin/Lazy;", "w0", "()Lcom/transsion/videodetail/VideoDetailViewModel;", "videoDetailViewModel", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", be.g.f16474b, "v0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "", "h", "J", "lastClickTime", "i", "Ljava/lang/Integer;", "seasonsCount", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lkotlin/jvm/functions/Function1;", "episodeSelectCallback", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class VideoDetailAllEpisodesFragment extends BaseBottomDialogFragment<jx.b> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Subject mSubject;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ResourcesSeasonList seasonList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.transsion.videodetail.adapter.b videoDetailEpisodeAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Integer seasonsCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Function1 episodeSelectCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy videoDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$special$$inlined$activityViewModels$default$2
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
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$special$$inlined$activityViewModels$default$4
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

    /* loaded from: classes7.dex */
    static final class a implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57749a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57749a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57749a;
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
            this.f57749a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment, View view) {
        videoDetailAllEpisodesFragment.l0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment, com.transsion.videodetail.adapter.b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        if (videoDetailAllEpisodesFragment.lastClickTime == 0 || System.currentTimeMillis() - videoDetailAllEpisodesFragment.lastClickTime > 1000) {
            videoDetailAllEpisodesFragment.lastClickTime = System.currentTimeMillis();
            VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) bVar.f0(i11);
            Function1 function1 = videoDetailAllEpisodesFragment.episodeSelectCallback;
            if (function1 != null) {
                function1.invoke(videoDetailMediaSource);
            }
            BaseBottomDialogFragment.m0(videoDetailAllEpisodesFragment, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(final VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment, View view) {
        Integer num = videoDetailAllEpisodesFragment.seasonsCount;
        if (num == null) {
            Subject subject = videoDetailAllEpisodesFragment.mSubject;
            num = subject != null ? subject.getSeNum() : null;
        }
        if (num != null) {
            VideoDetailSeasonsSelectFragment.Companion companion = VideoDetailSeasonsSelectFragment.INSTANCE;
            ResourcesSeasonList resourcesSeasonList = videoDetailAllEpisodesFragment.seasonList;
            Subject subject2 = videoDetailAllEpisodesFragment.mSubject;
            VideoDetailSeasonsSelectFragment a11 = companion.a(resourcesSeasonList, subject2 != null ? subject2.getSubjectType() : null);
            a11.x0(videoDetailAllEpisodesFragment.curSeason);
            a11.n0(videoDetailAllEpisodesFragment, R$id.fl_season_container);
            a11.w0(new Function1() { // from class: com.transsion.videodetail.s0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit D0;
                    D0 = VideoDetailAllEpisodesFragment.D0(VideoDetailAllEpisodesFragment.this, ((Integer) obj).intValue());
                    return D0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment, int i11) {
        videoDetailAllEpisodesFragment.curSeason = i11;
        videoDetailAllEpisodesFragment.G0(i11);
        videoDetailAllEpisodesFragment.K0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit E0(VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment, ResourcesSeasonList resourcesSeasonList) {
        AppCompatTextView appCompatTextView;
        BLTextView bLTextView;
        AppCompatTextView appCompatTextView2;
        BLTextView bLTextView2;
        List<ResourcesSeason> seasons;
        Integer valueOf = (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) ? 1 : Integer.valueOf(seasons.size());
        videoDetailAllEpisodesFragment.seasonsCount = valueOf;
        if (valueOf.intValue() == 1) {
            jx.b bVar = (jx.b) videoDetailAllEpisodesFragment.getMViewBinding();
            if (bVar != null && (bLTextView2 = bVar.f66465h) != null) {
                jg.c.h(bLTextView2);
            }
            jx.b bVar2 = (jx.b) videoDetailAllEpisodesFragment.getMViewBinding();
            if (bVar2 != null && (appCompatTextView2 = bVar2.f66464g) != null) {
                jg.c.k(appCompatTextView2);
            }
        } else {
            jx.b bVar3 = (jx.b) videoDetailAllEpisodesFragment.getMViewBinding();
            if (bVar3 != null && (bLTextView = bVar3.f66465h) != null) {
                jg.c.k(bLTextView);
            }
            jx.b bVar4 = (jx.b) videoDetailAllEpisodesFragment.getMViewBinding();
            if (bVar4 != null && (appCompatTextView = bVar4.f66464g) != null) {
                jg.c.h(appCompatTextView);
            }
        }
        videoDetailAllEpisodesFragment.K0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment, VideoDetailMediaSource videoDetailMediaSource) {
        videoDetailAllEpisodesFragment.J0(videoDetailMediaSource);
        return Unit.f67184a;
    }

    private final void G0(int season) {
        this.curSeason = season;
        v0().K().q(Integer.valueOf(season));
        com.transsion.videodetail.adapter.b bVar = this.videoDetailEpisodeAdapter;
        if (bVar != null) {
            bVar.n1(com.transsion.videodetail.util.d.f58003a.a(w0(), season));
        }
    }

    private final void J0(VideoDetailMediaSource playingSource) {
        int i11;
        List<ResourcesSeason> seasons;
        com.transsion.videodetail.adapter.b bVar = this.videoDetailEpisodeAdapter;
        if (bVar != null) {
            bVar.F1(playingSource);
        }
        a.C0856a.f(lg.a.f68962a, "VideoDetailEpisode", "setPlayingItem,--------, se:" + (playingSource != null ? Integer.valueOf(playingSource.getSe()) : null) + ", ep:" + (playingSource != null ? Integer.valueOf(playingSource.getEp()) : null), false, 4, null);
        ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) w0().z().f();
        if (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) {
            i11 = 0;
        } else {
            Iterator<ResourcesSeason> it = seasons.iterator();
            i11 = 0;
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
            this.curSeason = playingSource != null ? playingSource.getSe() : 1;
        }
        Map map = (Map) w0().t().f();
        if (map != null) {
            int i12 = 0;
            for (Map.Entry entry : map.entrySet()) {
                if (!((Collection) entry.getValue()).isEmpty()) {
                    IntRange intRange = new IntRange(((VideoDetailMediaSource) CollectionsKt.i0((List) entry.getValue())).getEp(), ((VideoDetailMediaSource) CollectionsKt.u0((List) entry.getValue())).getEp());
                    Integer valueOf = playingSource != null ? Integer.valueOf(playingSource.getEp()) : null;
                    if (valueOf != null && intRange.o(valueOf.intValue())) {
                        a.C0856a.f(lg.a.f68962a, "VideoDetailEpisode", "setPlayingItem,index:" + i12 + ", EpTabTitle:" + entry.getKey(), false, 4, null);
                    }
                }
                i12++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K0() {
        AppCompatTextView appCompatTextView;
        BLTextView bLTextView;
        AppCompatTextView appCompatTextView2;
        BLTextView bLTextView2;
        Subject subject = this.mSubject;
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.EDUCATION.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                jx.b bVar = (jx.b) getMViewBinding();
                if (bVar != null && (bLTextView2 = bVar.f66465h) != null) {
                    Context context = getContext();
                    bLTextView2.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, jn.f.a(this.curSeason)) : null);
                }
                jx.b bVar2 = (jx.b) getMViewBinding();
                if (bVar2 == null || (appCompatTextView2 = bVar2.f66464g) == null) {
                    return;
                }
                appCompatTextView2.setText(Utils.a().getString(com.transsnet.downloader.R$string.download_series_all_lessons));
                return;
            }
        }
        jx.b bVar3 = (jx.b) getMViewBinding();
        if (bVar3 != null && (bLTextView = bVar3.f66465h) != null) {
            Context context2 = getContext();
            bLTextView.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, jn.f.a(this.curSeason)) : null);
        }
        jx.b bVar4 = (jx.b) getMViewBinding();
        if (bVar4 == null || (appCompatTextView = bVar4.f66464g) == null) {
            return;
        }
        appCompatTextView.setText(Utils.a().getString(com.transsnet.downloader.R$string.download_series_all_episodes));
    }

    private final MovieDetailViewModel v0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    private final VideoDetailViewModel w0() {
        return (VideoDetailViewModel) this.videoDetailViewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y0() {
        ProgressBar progressBar;
        a.C0856a.f(lg.a.f68962a, "VideoDetailEpisode", "initFirstData,--------", false, 4, null);
        jx.b bVar = (jx.b) getMViewBinding();
        if (bVar != null && (progressBar = bVar.f66462e) != null) {
            jg.c.g(progressBar);
        }
        com.transsion.videodetail.adapter.b bVar2 = this.videoDetailEpisodeAdapter;
        if (bVar2 != null) {
            bVar2.n1(com.transsion.videodetail.util.d.f58003a.a(w0(), this.curSeason));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment, Integer num) {
        videoDetailAllEpisodesFragment.K0();
        return Unit.f67184a;
    }

    public final void H0(Subject mSubject, int curSeason, ResourcesSeasonList seasonList) {
        Intrinsics.h(mSubject, "mSubject");
        this.mSubject = mSubject;
        this.curSeason = curSeason;
        this.seasonList = seasonList;
    }

    public final void I0(Function1 callback) {
        this.episodeSelectCallback = callback;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        jx.b bVar = (jx.b) getMViewBinding();
        if (bVar != null) {
            bVar.f66461d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoDetailAllEpisodesFragment.A0(VideoDetailAllEpisodesFragment.this, view);
                }
            });
            BLTextView bLTextView = bVar.f66465h;
            Context context = getContext();
            bLTextView.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, jn.f.a(this.curSeason)) : null);
            RecyclerView recyclerView = bVar.f66463f;
            int a11 = com.blankj.utilcode.util.a0.a(4.0f);
            recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 6));
            int i11 = a11 * 2;
            recyclerView.addItemDecoration(new ig.b(a11, a11, i11, i11));
            final com.transsion.videodetail.adapter.b bVar2 = new com.transsion.videodetail.adapter.b(SubjectType.TV.getValue(), false, R$layout.item_video_detail_episode);
            bVar2.w1(new p6.d() { // from class: com.transsion.videodetail.n0
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    VideoDetailAllEpisodesFragment.B0(VideoDetailAllEpisodesFragment.this, bVar2, baseQuickAdapter, view, i12);
                }
            });
            this.videoDetailEpisodeAdapter = bVar2;
            bVar.f66463f.setAdapter(bVar2);
            y0();
            bVar.f66465h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.o0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoDetailAllEpisodesFragment.C0(VideoDetailAllEpisodesFragment.this, view);
                }
            });
        }
        w0().z().j(this, new a(new Function1() { // from class: com.transsion.videodetail.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E0;
                E0 = VideoDetailAllEpisodesFragment.E0(VideoDetailAllEpisodesFragment.this, (ResourcesSeasonList) obj);
                return E0;
            }
        }));
        w0().x().j(this, new a(new Function1() { // from class: com.transsion.videodetail.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = VideoDetailAllEpisodesFragment.F0(VideoDetailAllEpisodesFragment.this, (VideoDetailMediaSource) obj);
                return F0;
            }
        }));
        v0().K().j(this, new a(new Function1() { // from class: com.transsion.videodetail.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z02;
                z02 = VideoDetailAllEpisodesFragment.z0(VideoDetailAllEpisodesFragment.this, (Integer) obj);
                return z02;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public jx.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        jx.b c11 = jx.b.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
