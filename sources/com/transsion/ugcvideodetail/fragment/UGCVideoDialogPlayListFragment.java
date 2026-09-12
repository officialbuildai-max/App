package com.transsion.ugcvideodetail.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import com.transsion.ugcvideodetail.hepler.UGCVideoPlayFrom;
import com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel;
import com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import lg.a;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0004J\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002¢\u0006\u0004\b'\u0010(J1\u0010*\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0)2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b-\u0010.J%\u00101\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\fH\u0002¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\fH\u0002¢\u0006\u0004\b4\u0010\u0004J\u0019\u00106\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b6\u0010.R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010GR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010Z\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010UR\u0014\u0010\\\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010U¨\u0006^"}, d2 = {"Lcom/transsion/ugcvideodetail/fragment/UGCVideoDialogPlayListFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lqv/l;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "u0", "(Landroid/view/LayoutInflater;)Lqv/l;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "", "receiveArguments", "initViewData", "s0", "K0", "initViewModel", "initListener", "retryLoadData", "onPause", "", "hidden", "onHiddenChanged", "(Z)V", "showLoading", "hideLoading", "initExposureHelper", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoList;", "playList", "x0", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideoList;)V", "", "Llj/i1;", "items", "G0", "(Ljava/util/List;)Z", "isLoadDown", "hasMore", "w0", "(ZZ)V", "", "N0", "(ZLjava/util/List;Lcom/transsion/ugcvideodetail/api/bean/UGCVideoList;)V", "clickedVideoId", "L0", "(Ljava/lang/String;)V", "videoId", "previousVideoId", "O0", "(Ljava/lang/String;Ljava/lang/String;)V", "J0", "M0", "ugcVideoId", "H0", "Lcom/transsion/ugcvideodetail/viewmodel/UGCVideoDetailViewModel;", "a", "Lkotlin/Lazy;", "v0", "()Lcom/transsion/ugcvideodetail/viewmodel/UGCVideoDetailViewModel;", "viewModel", "Lcom/transsion/ugcvideodetail/viewmodel/UGCLocalVideoDetailViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "t0", "()Lcom/transsion/ugcvideodetail/viewmodel/UGCLocalVideoDetailViewModel;", "localViewModel", "Lcom/transsion/ugcvideodetail/adapter/g;", "c", "Lcom/transsion/ugcvideodetail/adapter/g;", "playListAdapter", "d", "Ljava/lang/String;", "currentPlayingId", "Lcom/transsion/ugcvideodetail/hepler/UGCVideoPlayFrom;", "e", "Lcom/transsion/ugcvideodetail/hepler/UGCVideoPlayFrom;", "videoPlayFrom", "Lsj/b;", "f", "Lsj/b;", "exposureHelper", be.g.f16474b, "pageName", "", "h", "I", "tabIndex", "i", "tabStartPosition", com.mbridge.msdk.foundation.same.report.j.f35620b, "tabEndPosition", CampaignEx.JSON_KEY_AD_K, "scrollOffset", "l", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UGCVideoDialogPlayListFragment extends PageStatusFragment<qv.l> {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ugcvideodetail.adapter.g playListAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String currentPlayingId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private sj.b exposureHelper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int tabIndex;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCVideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListFragment$special$$inlined$activityViewModels$default$2
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
    private final Lazy localViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCLocalVideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListFragment$special$$inlined$activityViewModels$default$4
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
    private UGCVideoPlayFrom videoPlayFrom = UGCVideoPlayFrom.ON_LINE_VIDEO;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int tabStartPosition = 1;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int tabEndPosition = 50;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int scrollOffset = (com.blankj.utilcode.util.y.e() / 2) - dk.a.b(80);

    /* renamed from: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCVideoDialogPlayListFragment a(int i11, int i12, int i13, UGCVideoPlayFrom videoFrom) {
            Intrinsics.h(videoFrom, "videoFrom");
            UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment = new UGCVideoDialogPlayListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("tab_index", i11);
            bundle.putInt("tab_start_position", i12);
            bundle.putInt("tab_end_position", i13);
            bundle.putInt("video_from", videoFrom.getValue());
            uGCVideoDialogPlayListFragment.setArguments(bundle);
            return uGCVideoDialogPlayListFragment;
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56306a;

        static {
            int[] iArr = new int[UGCVideoPlayFrom.values().length];
            try {
                iArr[UGCVideoPlayFrom.LOCAL_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UGCVideoPlayFrom.ON_LINE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f56306a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f56307a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f56307a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f56307a;
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
            this.f56307a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment) {
        uGCVideoDialogPlayListFragment.J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment) {
        if (nh.m.f70597a.e()) {
            uGCVideoDialogPlayListFragment.M0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment, List list) {
        String ugcVideoId;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return Unit.f67184a;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            int playListPosition = ((UGCVideo) obj).getPlayListPosition();
            int i11 = uGCVideoDialogPlayListFragment.tabStartPosition;
            if (playListPosition <= uGCVideoDialogPlayListFragment.tabEndPosition && i11 <= playListPosition) {
                arrayList.add(obj);
            }
        }
        com.transsion.ugcvideodetail.adapter.g gVar = uGCVideoDialogPlayListFragment.playListAdapter;
        List<Object> data = gVar != null ? gVar.getData() : null;
        if ((data == null || data.isEmpty()) && !arrayList.isEmpty()) {
            com.transsion.ugcvideodetail.adapter.g gVar2 = uGCVideoDialogPlayListFragment.playListAdapter;
            if (gVar2 != null) {
                gVar2.n1(CollectionsKt.U0(arrayList));
            }
            UGCVideo uGCVideo = (UGCVideo) uGCVideoDialogPlayListFragment.v0().G().f();
            if (uGCVideo != null && (ugcVideoId = uGCVideo.getUgcVideoId()) != null) {
                P0(uGCVideoDialogPlayListFragment, ugcVideoId, null, 2, null);
                uGCVideoDialogPlayListFragment.H0(ugcVideoId);
            }
            uGCVideoDialogPlayListFragment.hideLoading();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment, UGCVideoList uGCVideoList) {
        if (uGCVideoList != null) {
            uGCVideoDialogPlayListFragment.x0(uGCVideoList);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment, List list) {
        String ugcVideoId;
        Integer ugcVideoPosition;
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                DownloadBean downloadBean = (DownloadBean) obj;
                int i11 = 0;
                if (downloadBean != null && (ugcVideoPosition = downloadBean.getUgcVideoPosition()) != null) {
                    i11 = ugcVideoPosition.intValue();
                }
                int i12 = uGCVideoDialogPlayListFragment.tabStartPosition;
                if (i11 <= uGCVideoDialogPlayListFragment.tabEndPosition && i12 <= i11) {
                    arrayList.add(obj);
                }
            }
            com.transsion.ugcvideodetail.adapter.g gVar = uGCVideoDialogPlayListFragment.playListAdapter;
            if (gVar != null) {
                List U0 = CollectionsKt.U0(arrayList);
                Intrinsics.f(U0, "null cannot be cast to non-null type kotlin.collections.MutableList<com.transsion.baselib.db.download.UGCVideoPlayable>");
                gVar.n1(TypeIntrinsics.c(U0));
            }
            DownloadBean downloadBean2 = (DownloadBean) uGCVideoDialogPlayListFragment.t0().i().f();
            if (downloadBean2 != null && (ugcVideoId = downloadBean2.getUgcVideoId()) != null) {
                P0(uGCVideoDialogPlayListFragment, ugcVideoId, null, 2, null);
                uGCVideoDialogPlayListFragment.H0(ugcVideoId);
            }
            uGCVideoDialogPlayListFragment.hideLoading();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment, DownloadBean downloadBean) {
        String ugcVideoId;
        if (downloadBean != null && (ugcVideoId = downloadBean.getUgcVideoId()) != null) {
            P0(uGCVideoDialogPlayListFragment, ugcVideoId, null, 2, null);
            uGCVideoDialogPlayListFragment.H0(ugcVideoId);
        }
        return Unit.f67184a;
    }

    private final boolean G0(List items) {
        if (items.isEmpty()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((lj.i1) it.next()).videoUGCPosition()));
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        Integer num = (Integer) CollectionsKt.y0(arrayList);
        int intValue = num != null ? num.intValue() : 0;
        Integer num2 = (Integer) CollectionsKt.w0(arrayList);
        int intValue2 = num2 != null ? num2.intValue() : 0;
        int i11 = this.tabEndPosition;
        boolean z10 = intValue <= i11 && intValue2 >= this.tabStartPosition;
        a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "isDataForCurrentTab: data range[" + intValue + "-" + intValue2 + "], tab range[" + this.tabStartPosition + "-" + i11 + "], hasIntersection=" + z10, false, 4, null);
        return z10;
    }

    private final void H0(final String ugcVideoId) {
        qv.l mViewBinding;
        RecyclerView recyclerView;
        if (ugcVideoId == null || ugcVideoId.length() == 0 || getMViewBinding() == null || this.playListAdapter == null || (mViewBinding = getMViewBinding()) == null || (recyclerView = mViewBinding.f73921c) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.ugcvideodetail.fragment.o1
            @Override // java.lang.Runnable
            public final void run() {
                UGCVideoDialogPlayListFragment.I0(UGCVideoDialogPlayListFragment.this, ugcVideoId);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment, String str) {
        RecyclerView recyclerView;
        List<Object> data;
        List<Object> data2;
        com.transsion.ugcvideodetail.adapter.g gVar = uGCVideoDialogPlayListFragment.playListAdapter;
        int i11 = -1;
        if (gVar != null && (data2 = gVar.getData()) != null) {
            Iterator<Object> it = data2.iterator();
            int i12 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(((lj.i1) it.next()).videoUGCId(), str)) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
        }
        a.C0856a c0856a = lg.a.f68962a;
        com.transsion.ugcvideodetail.adapter.g gVar2 = uGCVideoDialogPlayListFragment.playListAdapter;
        a.C0856a.f(c0856a, "UGCVideoDialogPlayListFragment", "listScrollToPosition id:" + str + ", position:" + i11 + ", dataSize:" + ((gVar2 == null || (data = gVar2.getData()) == null) ? 0 : data.size()), false, 4, null);
        if (i11 < 0) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            qv.l mViewBinding = uGCVideoDialogPlayListFragment.getMViewBinding();
            Unit unit = null;
            RecyclerView.m layoutManager = (mViewBinding == null || (recyclerView = mViewBinding.f73921c) == null) ? null : recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null) {
                int i13 = uGCVideoDialogPlayListFragment.scrollOffset;
                linearLayoutManager.scrollToPositionWithOffset(i11, i13 > 0 ? i13 : 0);
                unit = Unit.f67184a;
            }
            Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final void J0() {
        List<Object> l11;
        r6.f h02;
        r6.f h03;
        String str = (String) v0().B().f();
        if (str == null) {
            return;
        }
        com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
        if (gVar == null || (l11 = gVar.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        lj.i1 i1Var = (lj.i1) CollectionsKt.v0(l11);
        int playListPosition = i1Var != null ? i1Var instanceof UGCVideo ? ((UGCVideo) i1Var).getPlayListPosition() : 0 : this.tabStartPosition - 1;
        int i11 = this.tabEndPosition;
        if (playListPosition >= i11) {
            com.transsion.ugcvideodetail.adapter.g gVar2 = this.playListAdapter;
            if (gVar2 != null && (h03 = gVar2.h0()) != null) {
                r6.f.u(h03, false, 1, null);
            }
            com.transsion.ugcvideodetail.adapter.g gVar3 = this.playListAdapter;
            if (gVar3 != null && (h02 = gVar3.h0()) != null) {
                h02.z(false);
            }
            a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "loadMoreData: reached tab end position " + this.tabEndPosition + ", stop loading", false, 4, null);
            return;
        }
        int i12 = playListPosition + 1;
        int min = Math.min(playListPosition + 9, i11);
        a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "loadMoreData: tabIndex=" + this.tabIndex + ", startPosition=" + i12 + ", endPosition=" + min + ", tabRange=[" + this.tabStartPosition + "-" + this.tabEndPosition + "]", false, 4, null);
        v0().X(str, i12, min, true);
    }

    private final void L0(String clickedVideoId) {
        List<Object> l11;
        if (clickedVideoId == null || clickedVideoId.length() == 0) {
            a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "syncTabDataToDetailPlayList: clickedVideoId is empty, skipping sync", false, 4, null);
            return;
        }
        com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
        if (gVar == null || (l11 = gVar.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        if (l11.isEmpty()) {
            a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "syncTabDataToDetailPlayList: Tab data is empty, skipping sync", false, 4, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = l11.iterator();
        while (it.hasNext()) {
            lj.i1 i1Var = (lj.i1) it.next();
            UGCVideo uGCVideo = i1Var instanceof UGCVideo ? (UGCVideo) i1Var : null;
            if (uGCVideo != null) {
                arrayList.add(uGCVideo);
            }
        }
        if (arrayList.isEmpty()) {
            a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "syncTabDataToDetailPlayList: No UGCVideo items, skipping sync", false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "syncTabDataToDetailPlayList: Syncing " + arrayList.size() + " items from tab[" + this.tabStartPosition + "-" + this.tabEndPosition + "] to detail play list via ViewModel for video " + clickedVideoId, false, 4, null);
        v0().i0(arrayList, clickedVideoId);
    }

    private final void M0() {
        List<Object> l11;
        r6.g o02;
        r6.g o03;
        r6.g o04;
        String str = (String) v0().B().f();
        if (str == null) {
            return;
        }
        com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
        if (gVar == null || (l11 = gVar.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        lj.i1 i1Var = (lj.i1) CollectionsKt.k0(l11);
        int playListPosition = i1Var != null ? i1Var instanceof UGCVideo ? ((UGCVideo) i1Var).getPlayListPosition() : 0 : this.tabStartPosition;
        if (playListPosition <= this.tabStartPosition) {
            com.transsion.ugcvideodetail.adapter.g gVar2 = this.playListAdapter;
            if (gVar2 != null && (o04 = gVar2.o0()) != null) {
                o04.d(false);
            }
            a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "upFetchData: reached tab start position " + this.tabStartPosition + ", stop loading", false, 4, null);
            return;
        }
        if (playListPosition <= 1) {
            com.transsion.ugcvideodetail.adapter.g gVar3 = this.playListAdapter;
            if (gVar3 == null || (o03 = gVar3.o0()) == null) {
                return;
            }
            o03.d(false);
            return;
        }
        com.transsion.ugcvideodetail.adapter.g gVar4 = this.playListAdapter;
        if (gVar4 != null && (o02 = gVar4.o0()) != null) {
            o02.e(true);
        }
        int i11 = playListPosition - 1;
        int max = Math.max(playListPosition - 9, this.tabStartPosition);
        a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "upFetchData: tabIndex=" + this.tabIndex + ", startPosition=" + max + ", endPosition=" + i11 + ", tabRange=[" + this.tabStartPosition + "-" + this.tabEndPosition + "]", false, 4, null);
        v0().X(str, max, i11, false);
    }

    private final void N0(boolean isLoadDown, List items, UGCVideoList playList) {
        String str;
        r6.g o02;
        r6.f h02;
        r6.f h03;
        r6.f h04;
        Pager pager;
        com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
        List<Object> data = gVar != null ? gVar.getData() : null;
        if ((data == null || data.isEmpty()) && (str = this.currentPlayingId) != null) {
            P0(this, str, null, 2, null);
        }
        if (isLoadDown) {
            if ((playList == null || (pager = playList.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.TRUE)) {
                com.transsion.ugcvideodetail.adapter.g gVar2 = this.playListAdapter;
                if (gVar2 != null && (h04 = gVar2.h0()) != null) {
                    h04.s();
                }
            } else {
                com.transsion.ugcvideodetail.adapter.g gVar3 = this.playListAdapter;
                if (gVar3 != null && (h03 = gVar3.h0()) != null) {
                    r6.f.u(h03, false, 1, null);
                }
                com.transsion.ugcvideodetail.adapter.g gVar4 = this.playListAdapter;
                if (gVar4 != null && (h02 = gVar4.h0()) != null) {
                    h02.z(false);
                }
            }
            com.transsion.ugcvideodetail.adapter.g gVar5 = this.playListAdapter;
            if (gVar5 != null) {
                gVar5.q(items);
            }
        } else {
            com.transsion.ugcvideodetail.adapter.g gVar6 = this.playListAdapter;
            if (gVar6 != null) {
                gVar6.o(0, items);
            }
            com.transsion.ugcvideodetail.adapter.g gVar7 = this.playListAdapter;
            if (gVar7 != null && (o02 = gVar7.o0()) != null) {
                o02.e(false);
            }
        }
        if (!items.isEmpty()) {
            hideLoading();
        }
        if (this.videoPlayFrom == UGCVideoPlayFrom.ON_LINE_VIDEO) {
            ArrayList arrayList = new ArrayList();
            Iterator it = items.iterator();
            while (it.hasNext()) {
                lj.i1 i1Var = (lj.i1) it.next();
                UGCVideo uGCVideo = i1Var instanceof UGCVideo ? (UGCVideo) i1Var : null;
                if (uGCVideo != null) {
                    arrayList.add(uGCVideo);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            v0().u(arrayList, isLoadDown);
        }
    }

    private final void O0(String videoId, String previousVideoId) {
        if (previousVideoId == null) {
            int i11 = b.f56306a[this.videoPlayFrom.ordinal()];
            if (i11 == 1) {
                previousVideoId = this.currentPlayingId;
            } else {
                if (i11 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                previousVideoId = v0().E();
            }
        }
        int i12 = b.f56306a[this.videoPlayFrom.ordinal()];
        if (i12 == 1) {
            t0().f().q(videoId);
        } else {
            if (i12 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            v0().f0(videoId);
        }
        this.currentPlayingId = videoId;
        com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
        if (gVar != null) {
            gVar.E1(videoId, previousVideoId);
        }
    }

    static /* synthetic */ void P0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        uGCVideoDialogPlayListFragment.O0(str, str2);
    }

    private final void hideLoading() {
        ProgressBar progressBar;
        qv.l mViewBinding = getMViewBinding();
        if (mViewBinding == null || (progressBar = mViewBinding.f73920b) == null) {
            return;
        }
        jg.c.g(progressBar);
    }

    private final void initExposureHelper() {
        sj.b a11;
        if (this.videoPlayFrom != UGCVideoPlayFrom.ON_LINE_VIDEO || getMViewBinding() == null) {
            return;
        }
        Fragment parentFragment = getParentFragment();
        UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment = parentFragment instanceof UGCVideoDetailBaseFragment ? (UGCVideoDetailBaseFragment) parentFragment : null;
        com.transsion.ugcvideodetail.hepler.g gVar = com.transsion.ugcvideodetail.hepler.g.f56482a;
        qv.l mViewBinding = getMViewBinding();
        Intrinsics.e(mViewBinding);
        RecyclerView recyclerView = mViewBinding.f73921c;
        Intrinsics.g(recyclerView, "recyclerView");
        a11 = gVar.a(recyclerView, v0(), this.pageName, new Function1() { // from class: com.transsion.ugcvideodetail.fragment.n1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCVideo y02;
                y02 = UGCVideoDialogPlayListFragment.y0(UGCVideoDialogPlayListFragment.this, ((Integer) obj).intValue());
                return y02;
            }
        }, (r21 & 16) != 0 ? null : uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getTrackId() : null, (r21 & 32) != 0 ? null : uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getPreviousTrackId() : null, (r21 & 64) != 0 ? null : uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getPreviousPageVideoId() : null, (r21 & 128) != 0 ? null : null);
        this.exposureHelper = a11;
    }

    private final void showLoading() {
        ProgressBar progressBar;
        qv.l mViewBinding = getMViewBinding();
        if (mViewBinding == null || (progressBar = mViewBinding.f73920b) == null) {
            return;
        }
        jg.c.k(progressBar);
    }

    private final UGCLocalVideoDetailViewModel t0() {
        return (UGCLocalVideoDetailViewModel) this.localViewModel.getValue();
    }

    private final UGCVideoDetailViewModel v0() {
        return (UGCVideoDetailViewModel) this.viewModel.getValue();
    }

    private final void w0(boolean isLoadDown, boolean hasMore) {
        r6.f h02;
        r6.f h03;
        r6.f h04;
        if (isLoadDown) {
            if (hasMore) {
                com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
                if (gVar == null || (h04 = gVar.h0()) == null) {
                    return;
                }
                h04.s();
                return;
            }
            a.C0856a.v(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "handleLoadMoreState false", false, 4, null);
            com.transsion.ugcvideodetail.adapter.g gVar2 = this.playListAdapter;
            if (gVar2 != null && (h03 = gVar2.h0()) != null) {
                r6.f.u(h03, false, 1, null);
            }
            com.transsion.ugcvideodetail.adapter.g gVar3 = this.playListAdapter;
            if (gVar3 == null || (h02 = gVar3.h0()) == null) {
                return;
            }
            h02.z(false);
        }
    }

    private final void x0(UGCVideoList playList) {
        List<Object> l11;
        List<UGCVideo> items = playList.getItems();
        if (items == null) {
            return;
        }
        com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
        if (gVar == null || (l11 = gVar.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        if (items.isEmpty()) {
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.v(c0856a, "UGCVideoDialogPlayListFragment", "handlePlayListData isEmpty", false, 4, null);
            if (!G0(items)) {
                a.C0856a.f(c0856a, "UGCVideoDialogPlayListFragment", "handlePlayListData: Empty data not for current tab, ignoring", false, 4, null);
                return;
            }
            boolean isLoadDown = playList.getIsLoadDown();
            Pager pager = playList.getPager();
            w0(isLoadDown, pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false);
            return;
        }
        if (!G0(items)) {
            a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "handlePlayListData: Data not for current tab (tab range: " + this.tabStartPosition + "-" + this.tabEndPosition + "), ignoring", false, 4, null);
            return;
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        UGCVideo uGCVideo = (UGCVideo) CollectionsKt.k0(items);
        a.C0856a.v(c0856a2, "UGCVideoDialogPlayListFragment", "handlePlayListData playListPosition:" + (uGCVideo != null ? Integer.valueOf(uGCVideo.getPlayListPosition()) : null), false, 4, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            int videoUGCPosition = ((UGCVideo) obj).videoUGCPosition();
            int i11 = this.tabStartPosition;
            if (videoUGCPosition <= this.tabEndPosition && i11 <= videoUGCPosition) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            a.C0856a.v(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "当前 tab 没有新数据，只处理 loadmore 状态", false, 4, null);
            boolean isLoadDown2 = playList.getIsLoadDown();
            Pager pager2 = playList.getPager();
            w0(isLoadDown2, pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.TRUE) : false);
            return;
        }
        if (l11.isEmpty()) {
            N0(playList.getIsLoadDown(), CollectionsKt.U0(arrayList), playList);
            hideLoading();
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = l11.iterator();
        while (it.hasNext()) {
            String videoUGCId = ((lj.i1) it.next()).videoUGCId();
            if (videoUGCId != null) {
                arrayList2.add(videoUGCId);
            }
        }
        Set W0 = CollectionsKt.W0(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!CollectionsKt.b0(W0, ((UGCVideo) obj2).videoUGCId())) {
                arrayList3.add(obj2);
            }
        }
        if (!arrayList3.isEmpty()) {
            N0(playList.getIsLoadDown(), CollectionsKt.U0(arrayList3), playList);
            hideLoading();
        } else {
            boolean isLoadDown3 = playList.getIsLoadDown();
            Pager pager3 = playList.getPager();
            w0(isLoadDown3, pager3 != null ? Intrinsics.c(pager3.getHasMore(), Boolean.TRUE) : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideo y0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment, int i11) {
        List<Object> data;
        com.transsion.ugcvideodetail.adapter.g gVar = uGCVideoDialogPlayListFragment.playListAdapter;
        lj.i1 i1Var = (gVar == null || (data = gVar.getData()) == null) ? null : (lj.i1) CollectionsKt.l0(data, i11);
        if (i1Var instanceof UGCVideo) {
            return (UGCVideo) i1Var;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(UGCVideoDialogPlayListFragment uGCVideoDialogPlayListFragment, com.transsion.ugcvideodetail.adapter.g gVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        com.transsion.ugcvideodetail.adapter.g gVar2;
        List<Object> data;
        lj.i1 i1Var;
        String str;
        String str2;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L) || (gVar2 = uGCVideoDialogPlayListFragment.playListAdapter) == null || (data = gVar2.getData()) == null || (i1Var = (lj.i1) CollectionsKt.l0(data, i11)) == null) {
            return;
        }
        String videoUGCId = i1Var.videoUGCId();
        UGCVideoPlayFrom uGCVideoPlayFrom = uGCVideoDialogPlayListFragment.videoPlayFrom;
        int[] iArr = b.f56306a;
        int i12 = iArr[uGCVideoPlayFrom.ordinal()];
        if (i12 == 1) {
            str = uGCVideoDialogPlayListFragment.currentPlayingId;
        } else {
            if (i12 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = uGCVideoDialogPlayListFragment.v0().E();
        }
        if (!Intrinsics.c(videoUGCId, str) || videoUGCId == null || videoUGCId.length() == 0) {
            Fragment parentFragment = uGCVideoDialogPlayListFragment.getParentFragment();
            UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment = parentFragment instanceof UGCVideoDetailBaseFragment ? (UGCVideoDetailBaseFragment) parentFragment : null;
            if (str != null && str.length() != 0 && uGCVideoDetailBaseFragment != null) {
                uGCVideoDetailBaseFragment.M0();
            }
            int i13 = iArr[uGCVideoDialogPlayListFragment.videoPlayFrom.ordinal()];
            if (i13 == 1) {
                String videoResourceId = i1Var.videoResourceId();
                if (videoResourceId != null) {
                    uGCVideoDialogPlayListFragment.t0().h(videoResourceId);
                }
            } else {
                if (i13 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                UGCVideoDetailViewModel v02 = uGCVideoDialogPlayListFragment.v0();
                String videoUGCId2 = i1Var.videoUGCId();
                if (videoUGCId2 == null) {
                    videoUGCId2 = "";
                }
                v02.c0(videoUGCId2, (String) uGCVideoDialogPlayListFragment.v0().B().f());
                if (i1Var instanceof UGCVideo) {
                    com.transsion.ugcvideodetail.hepler.g.f56482a.c((UGCVideo) i1Var, i11, uGCVideoDialogPlayListFragment.pageName, uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getTrackId() : null, uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getPreviousTrackId() : null, uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getPreviousPageVideoId() : null);
                }
            }
            int i14 = iArr[uGCVideoDialogPlayListFragment.videoPlayFrom.ordinal()];
            if (i14 == 1) {
                str2 = uGCVideoDialogPlayListFragment.currentPlayingId;
            } else {
                if (i14 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = uGCVideoDialogPlayListFragment.v0().E();
            }
            gVar.E1(i1Var.videoUGCId(), str2);
            String videoUGCId3 = i1Var.videoUGCId();
            if (videoUGCId3 != null) {
                uGCVideoDialogPlayListFragment.H0(videoUGCId3);
            }
            if (uGCVideoDialogPlayListFragment.videoPlayFrom == UGCVideoPlayFrom.ON_LINE_VIDEO) {
                uGCVideoDialogPlayListFragment.L0(i1Var.videoUGCId());
            }
        }
    }

    public final void K0() {
        String ugcVideoId;
        List<Object> l11;
        int i11 = b.f56306a[this.videoPlayFrom.ordinal()];
        if (i11 == 1) {
            DownloadBean downloadBean = (DownloadBean) t0().i().f();
            if (downloadBean != null) {
                ugcVideoId = downloadBean.getUgcVideoId();
            }
            ugcVideoId = null;
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            UGCVideo uGCVideo = (UGCVideo) v0().G().f();
            if (uGCVideo != null) {
                ugcVideoId = uGCVideo.getUgcVideoId();
            }
            ugcVideoId = null;
        }
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            return;
        }
        com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
        if (gVar == null || (l11 = gVar.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        if (l11.isEmpty()) {
            return;
        }
        List<Object> list = l11;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.c(((lj.i1) it.next()).videoUGCId(), ugcVideoId)) {
                P0(this, ugcVideoId, null, 2, null);
                H0(ugcVideoId);
                return;
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        RecyclerView recyclerView;
        final com.transsion.ugcvideodetail.adapter.g gVar = new com.transsion.ugcvideodetail.adapter.g(true);
        gVar.w1(new p6.d() { // from class: com.transsion.ugcvideodetail.fragment.k1
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCVideoDialogPlayListFragment.z0(UGCVideoDialogPlayListFragment.this, gVar, baseQuickAdapter, view, i11);
            }
        });
        if (this.videoPlayFrom == UGCVideoPlayFrom.ON_LINE_VIDEO) {
            gVar.h0().z(true);
            gVar.h0().y(true);
            gVar.h0().E(3);
            gVar.h0().D(new p6.f() { // from class: com.transsion.ugcvideodetail.fragment.l1
                @Override // p6.f
                public final void a() {
                    UGCVideoDialogPlayListFragment.A0(UGCVideoDialogPlayListFragment.this);
                }
            });
            gVar.o0().d(true);
            gVar.o0().c(2);
            gVar.o0().b(new p6.g() { // from class: com.transsion.ugcvideodetail.fragment.m1
                @Override // p6.g
                public final void a() {
                    UGCVideoDialogPlayListFragment.B0(UGCVideoDialogPlayListFragment.this);
                }
            });
        }
        this.playListAdapter = gVar;
        qv.l mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f73921c) != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
            recyclerView.setAdapter(this.playListAdapter);
        }
        initExposureHelper();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        int i11 = b.f56306a[this.videoPlayFrom.ordinal()];
        if (i11 == 1) {
            t0().k().j(this, new c(new Function1() { // from class: com.transsion.ugcvideodetail.fragment.i1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit E0;
                    E0 = UGCVideoDialogPlayListFragment.E0(UGCVideoDialogPlayListFragment.this, (List) obj);
                    return E0;
                }
            }));
            t0().i().j(this, new c(new Function1() { // from class: com.transsion.ugcvideodetail.fragment.j1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit F0;
                    F0 = UGCVideoDialogPlayListFragment.F0(UGCVideoDialogPlayListFragment.this, (DownloadBean) obj);
                    return F0;
                }
            }));
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            v0().C().j(this, new c(new Function1() { // from class: com.transsion.ugcvideodetail.fragment.g1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit C0;
                    C0 = UGCVideoDialogPlayListFragment.C0(UGCVideoDialogPlayListFragment.this, (List) obj);
                    return C0;
                }
            }));
            v0().M().j(this, new c(new Function1() { // from class: com.transsion.ugcvideodetail.fragment.h1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit D0;
                    D0 = UGCVideoDialogPlayListFragment.D0(UGCVideoDialogPlayListFragment.this, (UGCVideoList) obj);
                    return D0;
                }
            }));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        sj.b bVar;
        super.onHiddenChanged(hidden);
        if (!hidden || (bVar = this.exposureHelper) == null) {
            return;
        }
        bVar.f();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        Fragment parentFragment;
        super.receiveArguments();
        Bundle arguments = getArguments();
        this.tabIndex = arguments != null ? arguments.getInt("tab_index", 0) : 0;
        Bundle arguments2 = getArguments();
        this.tabStartPosition = arguments2 != null ? arguments2.getInt("tab_start_position", 1) : 1;
        Bundle arguments3 = getArguments();
        this.tabEndPosition = arguments3 != null ? arguments3.getInt("tab_end_position", 50) : 50;
        Bundle arguments4 = getArguments();
        int i11 = arguments4 != null ? arguments4.getInt("video_from") : UGCVideoPlayFrom.ON_LINE_VIDEO.getValue();
        UGCVideoPlayFrom uGCVideoPlayFrom = UGCVideoPlayFrom.ON_LINE_VIDEO;
        if (i11 != uGCVideoPlayFrom.getValue()) {
            uGCVideoPlayFrom = UGCVideoPlayFrom.LOCAL_VIDEO;
        }
        this.videoPlayFrom = uGCVideoPlayFrom;
        Fragment parentFragment2 = getParentFragment();
        String str = null;
        if (parentFragment2 != null && (parentFragment = parentFragment2.getParentFragment()) != null && (parentFragment instanceof UGCVideoDetailBaseFragment)) {
            str = ((UGCVideoDetailBaseFragment) parentFragment).getPAGE_NAME();
        }
        this.pageName = str;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }

    public final void s0() {
        List<Object> l11;
        if (this.videoPlayFrom != UGCVideoPlayFrom.ON_LINE_VIDEO) {
            return;
        }
        com.transsion.ugcvideodetail.adapter.g gVar = this.playListAdapter;
        if (gVar == null || (l11 = gVar.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        if (!l11.isEmpty()) {
            hideLoading();
            return;
        }
        List list = (List) v0().C().f();
        if (list == null) {
            list = CollectionsKt.l();
        }
        List list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                int playListPosition = ((UGCVideo) it.next()).getPlayListPosition();
                int i11 = this.tabStartPosition;
                if (playListPosition <= this.tabEndPosition && i11 <= playListPosition) {
                    hideLoading();
                    return;
                }
            }
        }
        showLoading();
        String str = (String) v0().B().f();
        if (str == null) {
            return;
        }
        int min = Math.min(this.tabStartPosition + 8, this.tabEndPosition);
        a.C0856a.f(lg.a.f68962a, "UGCVideoDialogPlayListFragment", "checkAndLoadDataIfNeeded: tabIndex=" + this.tabIndex + ", requesting data range=[" + this.tabStartPosition + "-" + min + "]", false, 4, null);
        v0().X(str, this.tabStartPosition, min, true);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public qv.l getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qv.l c11 = qv.l.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
