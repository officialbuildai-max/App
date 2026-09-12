package com.transsion.videodetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J2\u0010\f\u001a\u00020\n2#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u0004R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R3\u00104\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/transsion/videodetail/VideoDetailAudioTrackSelectDialog;", "Lcom/transsion/play/detail/fragment/BaseBottomDialogFragment;", "Ljx/c;", "<init>", "()V", "Lkotlin/Function1;", "Lcom/transsion/moviedetailapi/bean/DubsInfo;", "Lkotlin/ParameterName;", "name", "info", "", "callback", "z0", "(Lkotlin/jvm/functions/Function1;)V", "", "subjectId", "A0", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "u0", "(Landroid/view/LayoutInflater;)Ljx/c;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "mSubjectId", "Lcom/transsion/videodetail/adapter/a;", "c", "Lcom/transsion/videodetail/adapter/a;", "adapter", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "d", "Lkotlin/Lazy;", "s0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "Lcom/transsion/player/longvideo/helper/o0;", "e", "t0", "()Lcom/transsion/player/longvideo/helper/o0;", "subtitleViewModel", "", "f", "J", "lastClickTime", be.g.f16474b, "Lkotlin/jvm/functions/Function1;", "audioSelectCallback", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class VideoDetailAudioTrackSelectDialog extends BaseBottomDialogFragment<jx.c> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mSubjectId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.transsion.videodetail.adapter.a adapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$special$$inlined$activityViewModels$default$2
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

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy subtitleViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.helper.o0.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$special$$inlined$activityViewModels$default$4
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

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Function1 audioSelectCallback;

    /* loaded from: classes7.dex */
    static final class a implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57756a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57756a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57756a;
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
            this.f57756a.invoke(obj);
        }
    }

    private final MovieDetailViewModel s0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    private final com.transsion.player.longvideo.helper.o0 t0() {
        return (com.transsion.player.longvideo.helper.o0) this.subtitleViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit v0(VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog, List list) {
        ProgressBar progressBar;
        lg.a.f68962a.c("Audio_Subtitle", "AudioTrack ---- use subtitle " + (list != null ? Integer.valueOf(list.size()) : null), true);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                eu.a aVar = (eu.a) it.next();
                DubsInfo dubsInfo = new DubsInfo(null, aVar.b().getLanName(), aVar.b().getLan(), false, 9, null);
                dubsInfo.setSelected(aVar.f());
                dubsInfo.setSubtitle(true);
                arrayList.add(dubsInfo);
            }
        }
        jx.c cVar = (jx.c) videoDetailAudioTrackSelectDialog.getMViewBinding();
        if (cVar != null && (progressBar = cVar.f66469d) != null) {
            jg.c.g(progressBar);
        }
        com.transsion.videodetail.adapter.a aVar2 = videoDetailAudioTrackSelectDialog.adapter;
        if (aVar2 != null) {
            aVar2.n1(arrayList);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit w0(VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog, Pair pair) {
        List l11;
        ProgressBar progressBar;
        List<DubsInfo> dubs;
        Subject subject = (Subject) pair.getSecond();
        if (subject == null || (dubs = subject.getDubs()) == null) {
            l11 = CollectionsKt.l();
        } else {
            List<DubsInfo> list = dubs;
            l11 = new ArrayList(CollectionsKt.v(list, 10));
            for (DubsInfo dubsInfo : list) {
                a.C0856a.g(lg.a.f68962a, "The dubsInfo.id is " + dubsInfo.getSubjectId() + ", the subjectId: $" + videoDetailAudioTrackSelectDialog.mSubjectId, false, 2, null);
                dubsInfo.setSelected(Intrinsics.c(dubsInfo.getSubjectId(), videoDetailAudioTrackSelectDialog.mSubjectId));
                l11.add(dubsInfo);
            }
        }
        if (l11.size() > 1) {
            jx.c cVar = (jx.c) videoDetailAudioTrackSelectDialog.getMViewBinding();
            if (cVar != null && (progressBar = cVar.f66469d) != null) {
                jg.c.g(progressBar);
            }
            com.transsion.videodetail.adapter.a aVar = videoDetailAudioTrackSelectDialog.adapter;
            if (aVar != null) {
                aVar.n1(l11);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog, View view) {
        BaseBottomDialogFragment.m0(videoDetailAudioTrackSelectDialog, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog, com.transsion.videodetail.adapter.a aVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        if (videoDetailAudioTrackSelectDialog.lastClickTime == 0 || System.currentTimeMillis() - videoDetailAudioTrackSelectDialog.lastClickTime > 1000) {
            videoDetailAudioTrackSelectDialog.lastClickTime = System.currentTimeMillis();
            DubsInfo dubsInfo = (DubsInfo) aVar.getItem(i11);
            if (dubsInfo.getIsSubtitle()) {
                List<eu.a> list = (List) videoDetailAudioTrackSelectDialog.t0().c().f();
                if (list != null) {
                    for (eu.a aVar2 : list) {
                        if (Intrinsics.c(aVar2.b().getLan(), dubsInfo.getLanCode())) {
                            aVar2.l(true);
                            lg.a.f68962a.c("Audio_Subtitle", "详情页 字幕选择了, name:" + aVar2.b().getLanName() + ", " + aVar2.b().getLan() + ", " + aVar2.d(), true);
                            videoDetailAudioTrackSelectDialog.t0().b().n(aVar2);
                        } else {
                            aVar2.l(false);
                        }
                    }
                }
            } else {
                Function1 function1 = videoDetailAudioTrackSelectDialog.audioSelectCallback;
                if (function1 != null) {
                    function1.invoke(aVar.getItem(i11));
                }
            }
            BaseBottomDialogFragment.m0(videoDetailAudioTrackSelectDialog, false, 1, null);
        }
    }

    public final void A0(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        this.mSubjectId = subjectId;
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
        List<DubsInfo> dubs;
        jx.c cVar = (jx.c) getMViewBinding();
        int i11 = 0;
        if (cVar != null) {
            cVar.f66468c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.t0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoDetailAudioTrackSelectDialog.x0(VideoDetailAudioTrackSelectDialog.this, view);
                }
            });
            ProgressBar pbLoading = cVar.f66469d;
            Intrinsics.g(pbLoading, "pbLoading");
            jg.c.k(pbLoading);
            RecyclerView recyclerView = cVar.f66470e;
            Context context = getContext();
            recyclerView.setLayoutManager((context == null || !com.transsion.baseui.util.b.a(context)) ? new NpaLinearLayoutManager(requireContext(), 1, false) : new NpaGridLayoutManager(requireContext(), 2));
            RecyclerView recyclerView2 = cVar.f66470e;
            final com.transsion.videodetail.adapter.a aVar = new com.transsion.videodetail.adapter.a();
            this.adapter = aVar;
            aVar.w1(new p6.d() { // from class: com.transsion.videodetail.u0
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    VideoDetailAudioTrackSelectDialog.y0(VideoDetailAudioTrackSelectDialog.this, aVar, baseQuickAdapter, view, i12);
                }
            });
            recyclerView2.setAdapter(aVar);
        }
        MovieDetailViewModel s02 = s0();
        s02.F().j(this, new a(new Function1() { // from class: com.transsion.videodetail.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w02;
                w02 = VideoDetailAudioTrackSelectDialog.w0(VideoDetailAudioTrackSelectDialog.this, (Pair) obj);
                return w02;
            }
        }));
        Pair pair = (Pair) s02.F().f();
        if (pair != null) {
            Subject subject = (Subject) pair.getSecond();
            List<DubsInfo> dubs2 = subject != null ? subject.getDubs() : null;
            if (dubs2 != null && !dubs2.isEmpty()) {
                Subject subject2 = (Subject) pair.getSecond();
                if (subject2 != null && (dubs = subject2.getDubs()) != null) {
                    i11 = dubs.size();
                }
                if (i11 > 1) {
                    return;
                }
            }
        }
        lg.a.f68962a.c("Audio_Subtitle", "AudioTrack try use subtitle~~~", true);
        t0().c().j(this, new a(new Function1() { // from class: com.transsion.videodetail.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v02;
                v02 = VideoDetailAudioTrackSelectDialog.v0(VideoDetailAudioTrackSelectDialog.this, (List) obj);
                return v02;
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
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public jx.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        jx.c c11 = jx.c.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    public final void z0(Function1 callback) {
        this.audioSelectCallback = callback;
    }
}
