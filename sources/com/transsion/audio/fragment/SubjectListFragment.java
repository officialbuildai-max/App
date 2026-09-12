package com.transsion.audio.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.c0;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.audio.adapter.SubjectListAdapter;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.audio.viewmodel.SubjectListViewModel;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.room.api.IAudioApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.bean.DownloadListBean;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J)\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J!\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u0005J\u0019\u0010.\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J!\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b2\u00103J!\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u0002042\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b6\u00107J\u0019\u00108\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b8\u0010/R\u0018\u0010;\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010:R\u0018\u0010B\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010:R\u0018\u0010D\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010:R$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010S\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010NR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010NR\u0016\u0010Z\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010NR\u001b\u0010`\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010]\u001a\u0004\bc\u0010dR\u001d\u0010j\u001a\u0004\u0018\u00010f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010]\u001a\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010:R\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006r"}, d2 = {"Lcom/transsion/audio/fragment/SubjectListFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lbj/c;", "Lcom/transsion/player/orplayer/f;", "<init>", "()V", "", "loadMore", "u0", "", "", "page", "perPage", "E0", "(ZII)V", "Lcom/transsnet/downloader/bean/DownloadListBean;", "bean", "I0", "(Lcom/transsnet/downloader/bean/DownloadListBean;)V", "", "subjectId", "subjectType", "y0", "(Ljava/lang/String;I)V", "Lcom/transsion/moviedetailapi/DownloadItem;", "download", "Lcom/transsion/baselib/db/audio/AudioBean;", WebConstants.FIELD_ITEM, "H0", "(Lcom/transsion/moviedetailapi/DownloadItem;Lcom/transsion/baselib/db/audio/AudioBean;)V", "Landroid/view/LayoutInflater;", "inflater", "x0", "(Landroid/view/LayoutInflater;)Lbj/c;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "onResume", "onPause", "Lao/e;", "mediaSource", "onPrepare", "(Lao/e;)V", "", NotificationCompat.CATEGORY_PROGRESS, "onProgress", "(JLao/e;)V", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lao/e;)V", "onCompletion", "a", "Ljava/lang/String;", "subjectCover", "Lcom/transsion/audio/adapter/SubjectListAdapter;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/audio/adapter/SubjectListAdapter;", "mAdapter", "c", "d", "groupId", "e", "subjectTitle", "Lcom/transsion/audio/fragment/AudioBottomSheetFragment;", "f", "Lcom/transsion/audio/fragment/AudioBottomSheetFragment;", "getParent", "()Lcom/transsion/audio/fragment/AudioBottomSheetFragment;", "setParent", "(Lcom/transsion/audio/fragment/AudioBottomSheetFragment;)V", "parent", be.g.f16474b, "I", "getTotalEpisode", "()I", "setTotalEpisode", "(I)V", "totalEpisode", "h", "currentPage", "i", com.mbridge.msdk.foundation.same.report.j.f35620b, "currentPageUp", CampaignEx.JSON_KEY_AD_K, "currentPageDown", "Lcom/transsion/audio/viewmodel/SubjectListViewModel;", "l", "Lkotlin/Lazy;", "w0", "()Lcom/transsion/audio/viewmodel/SubjectListViewModel;", "subjectListViewModel", "Ljj/a;", "m", "v0", "()Ljj/a;", "audioDao", "Lcom/transsion/room/api/IAudioApi;", "n", "getMAudioApi", "()Lcom/transsion/room/api/IAudioApi;", "mAudioApi", "o", "previousUrl", "Ljava/util/concurrent/atomic/AtomicBoolean;", TtmlNode.TAG_P, "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsStop", CampaignEx.JSON_KEY_AD_Q, "Audio_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class SubjectListFragment extends BaseFragment<bj.c> implements com.transsion.player.orplayer.f {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: r, reason: collision with root package name */
    private static final String f42914r = "SubjectListFragment";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private SubjectListAdapter mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AudioBottomSheetFragment parent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int totalEpisode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy subjectListViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy audioDao;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Lazy mAudioApi;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String previousUrl;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean mIsStop;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String subjectCover = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String subjectId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String groupId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String subjectTitle = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentPage = 1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int perPage = 8;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int currentPageUp = 1;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int currentPageDown = 1;

    /* renamed from: com.transsion.audio.fragment.SubjectListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return SubjectListFragment.f42914r;
        }

        public final SubjectListFragment b(String str) {
            SubjectListFragment subjectListFragment = new SubjectListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("subjectId", str);
            subjectListFragment.setArguments(bundle);
            return subjectListFragment;
        }
    }

    /* loaded from: classes5.dex */
    static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f42931a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f42931a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f42931a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f42931a.invoke(obj);
        }
    }

    public SubjectListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.subjectListViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(SubjectListViewModel.class), new Function0<x0>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$3
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
        this.audioDao = LazyKt.b(new Function0() { // from class: com.transsion.audio.fragment.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                jj.a t02;
                t02 = SubjectListFragment.t0();
                return t02;
            }
        });
        this.mAudioApi = LazyKt.b(new Function0() { // from class: com.transsion.audio.fragment.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IAudioApi G0;
                G0 = SubjectListFragment.G0();
                return G0;
            }
        });
        this.previousUrl = "";
        this.mIsStop = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(SubjectListFragment subjectListFragment, DownloadListBean downloadListBean) {
        subjectListFragment.I0(downloadListBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(SubjectListFragment subjectListFragment) {
        subjectListFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof DownloadItem) {
            DownloadItem downloadItem = (DownloadItem) item;
            if (TextUtils.isEmpty(downloadItem.getPostId())) {
                uh.b.f76876a.e("This page is unavailable");
            } else {
                ak.k.p(TheRouter.c("/post/detail").K(WebConstants.PAGE_FROM, "audio_list").K("id", downloadItem.getPostId()).K("media_type", MediaType.AUDIO.getValue()).z("video_load_more", true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(SubjectListFragment subjectListFragment) {
        subjectListFragment.u0();
    }

    private final void E0(boolean loadMore, int page, int perPage) {
        SubjectListViewModel.h(w0(), loadMore, this.subjectId, String.valueOf(page), perPage, 0, 0, 0, 48, null);
    }

    static /* synthetic */ void F0(SubjectListFragment subjectListFragment, boolean z10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i12 = 8;
        }
        subjectListFragment.E0(z10, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAudioApi G0() {
        return (IAudioApi) TheRouter.d(IAudioApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(DownloadItem download, AudioBean item) {
        List<Object> data;
        SubjectListAdapter subjectListAdapter;
        SubjectListAdapter subjectListAdapter2 = this.mAdapter;
        if (subjectListAdapter2 != null && (data = subjectListAdapter2.getData()) != null) {
            int i11 = 0;
            for (Object obj : data) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.u();
                }
                if (Intrinsics.c(download, (DownloadItem) obj) && (subjectListAdapter = this.mAdapter) != null) {
                    subjectListAdapter.notifyItemChanged(i11, download);
                }
                i11 = i12;
            }
        }
        Long readProcess = item.getReadProcess();
        long longValue = readProcess != null ? readProcess.longValue() : 0L;
        String url = download.getUrl();
        String url2 = download.getUrl();
        if (url2 == null) {
            url2 = "";
        }
        onProgress(longValue, new ao.e(url, url2, 0, null, null, 28, null));
    }

    private final void I0(final DownloadListBean bean) {
        String str;
        r6.f h02;
        List<Object> l11;
        SwipeRefreshLayout swipeRefreshLayout;
        bj.c mViewBinding;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        SubjectListAdapter subjectListAdapter;
        r6.f h03;
        r6.f h04;
        SubjectListAdapter subjectListAdapter2;
        r6.f h05;
        String nextPage;
        List<Object> data;
        AppCompatTextView appCompatTextView;
        LinearLayoutCompat linearLayoutCompat;
        Cover cover;
        if (bean == null || (cover = bean.getCover()) == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        bj.c mViewBinding2 = getMViewBinding();
        ShapeableImageView shapeableImageView = mViewBinding2 != null ? mViewBinding2.f16641c : null;
        Context context = getContext();
        if (context != null && !TextUtils.isEmpty(str) && shapeableImageView != null) {
            ej.f.f62005a.m(context).g(str).d(shapeableImageView);
        }
        bj.c mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (linearLayoutCompat = mViewBinding3.f16642d) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.fragment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectListFragment.J0(SubjectListFragment.this, bean, view);
                }
            });
        }
        bj.c mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatTextView = mViewBinding4.f16645g) != null) {
            appCompatTextView.setText(bean != null ? bean.getSubjectTitle() : null);
        }
        List<DownloadItem> items = bean != null ? bean.getItems() : null;
        if (items == null || items.isEmpty()) {
            SubjectListAdapter subjectListAdapter3 = this.mAdapter;
            if (subjectListAdapter3 == null || (h02 = subjectListAdapter3.h0()) == null) {
                return;
            }
            r6.f.u(h02, false, 1, null);
            return;
        }
        SubjectListAdapter subjectListAdapter4 = this.mAdapter;
        if (subjectListAdapter4 != null && (data = subjectListAdapter4.getData()) != null && data.isEmpty()) {
            SubjectListAdapter subjectListAdapter5 = this.mAdapter;
            if (subjectListAdapter5 != null) {
                subjectListAdapter5.n1(items);
                return;
            }
            return;
        }
        SubjectListAdapter subjectListAdapter6 = this.mAdapter;
        if (subjectListAdapter6 == null || (l11 = subjectListAdapter6.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (!l11.contains((DownloadItem) obj)) {
                arrayList.add(obj);
            }
        }
        if (bean.getLoadMore()) {
            SubjectListAdapter subjectListAdapter7 = this.mAdapter;
            if (subjectListAdapter7 != null) {
                subjectListAdapter7.q(arrayList);
            }
            Pager pager = bean.getPager();
            this.currentPageUp = (pager == null || (nextPage = pager.getNextPage()) == null) ? 1 : Integer.parseInt(nextPage);
            SubjectListAdapter subjectListAdapter8 = this.mAdapter;
            if (subjectListAdapter8 != null && (h04 = subjectListAdapter8.h0()) != null && h04.r() && (subjectListAdapter2 = this.mAdapter) != null && (h05 = subjectListAdapter2.h0()) != null) {
                h05.s();
            }
        } else {
            SubjectListAdapter subjectListAdapter9 = this.mAdapter;
            if (subjectListAdapter9 != null) {
                subjectListAdapter9.o(0, arrayList);
            }
            bj.c mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (recyclerView = mViewBinding5.f16643e) != null) {
                recyclerView.scrollToPosition(arrayList.size() - 1);
            }
            bj.c mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (swipeRefreshLayout = mViewBinding6.f16644f) != null && swipeRefreshLayout.isRefreshing() && (mViewBinding = getMViewBinding()) != null && (swipeRefreshLayout2 = mViewBinding.f16644f) != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
            this.currentPageDown--;
        }
        Pager pager2 = bean.getPager();
        if (!(pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.FALSE) : false) || (subjectListAdapter = this.mAdapter) == null || (h03 = subjectListAdapter.h0()) == null) {
            return;
        }
        r6.f.u(h03, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(SubjectListFragment subjectListFragment, DownloadListBean downloadListBean, View view) {
        subjectListFragment.y0(subjectListFragment.subjectId, downloadListBean != null ? downloadListBean.getSubjectType() : SubjectType.MOVIE.getValue());
    }

    private final IAudioApi getMAudioApi() {
        return (IAudioApi) this.mAudioApi.getValue();
    }

    private final void loadMore() {
        F0(this, true, this.currentPageUp, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jj.a t0() {
        Application a11 = Utils.a();
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Intrinsics.e(a11);
        return companion.b(a11).o1();
    }

    private final void u0() {
        if (this.currentPage < 1) {
            return;
        }
        F0(this, false, this.currentPageDown, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jj.a v0() {
        return (jj.a) this.audioDao.getValue();
    }

    private final SubjectListViewModel w0() {
        return (SubjectListViewModel) this.subjectListViewModel.getValue();
    }

    private final void y0(String subjectId, int subjectType) {
        ak.k.p(TheRouter.c("/movie/detail").F("subject_type", subjectType).K("id", subjectId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(SubjectListFragment subjectListFragment, DownloadListBean downloadListBean) {
        SubjectListAdapter subjectListAdapter;
        r6.f h02;
        bj.c mViewBinding;
        SwipeRefreshLayout swipeRefreshLayout;
        if (downloadListBean != null) {
            Integer totalEpisode = downloadListBean.getTotalEpisode();
            subjectListFragment.totalEpisode = totalEpisode != null ? totalEpisode.intValue() : 0;
            Cover cover = downloadListBean.getCover();
            subjectListFragment.subjectCover = cover != null ? cover.getUrl() : null;
            subjectListFragment.groupId = downloadListBean.getGroupId();
            subjectListFragment.subjectTitle = downloadListBean.getSubjectTitle();
            subjectListFragment.I0(downloadListBean);
            Integer position = downloadListBean.getPosition();
            int intValue = position != null ? (position.intValue() / subjectListFragment.perPage) + 1 : 1;
            subjectListFragment.currentPage = intValue;
            subjectListFragment.currentPageDown = intValue - 1;
            subjectListFragment.currentPageUp = intValue + 1;
            if (intValue < 1 && (mViewBinding = subjectListFragment.getMViewBinding()) != null && (swipeRefreshLayout = mViewBinding.f16644f) != null) {
                swipeRefreshLayout.setEnabled(false);
            }
            Pager pager = downloadListBean.getPager();
            if ((pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.FALSE) : false) && (subjectListAdapter = subjectListFragment.mAdapter) != null && (h02 = subjectListAdapter.h0()) != null) {
                r6.f.u(h02, false, 1, null);
            }
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        HistoryListManager.f43015e.b().v().j(this, new b(new Function1() { // from class: com.transsion.audio.fragment.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z02;
                z02 = SubjectListFragment.z0(SubjectListFragment.this, (DownloadListBean) obj);
                return z02;
            }
        }));
        w0().f().j(this, new b(new Function1() { // from class: com.transsion.audio.fragment.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit A0;
                A0 = SubjectListFragment.A0(SubjectListFragment.this, (DownloadListBean) obj);
                return A0;
            }
        }));
        Bundle arguments = getArguments();
        this.subjectId = arguments != null ? arguments.getString("subjectId") : null;
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout2;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.h(view, "view");
        Fragment parentFragment = getParentFragment();
        Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.audio.fragment.AudioBottomSheetFragment");
        this.parent = (AudioBottomSheetFragment) parentFragment;
        bj.c mViewBinding = getMViewBinding();
        if (mViewBinding != null && (swipeRefreshLayout2 = mViewBinding.f16644f) != null && (layoutParams = swipeRefreshLayout2.getLayoutParams()) != null) {
            AudioBottomSheetFragment audioBottomSheetFragment = this.parent;
            layoutParams.height = audioBottomSheetFragment != null ? audioBottomSheetFragment.D0() - a0.a(104.0f) : 0;
        }
        bj.c mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (recyclerView2 = mViewBinding2.f16643e) != null) {
            recyclerView2.setLayoutManager(new NpaLinearLayoutManager(getContext()));
        }
        SubjectListAdapter subjectListAdapter = new SubjectListAdapter(new ArrayList());
        subjectListAdapter.h0().z(true);
        subjectListAdapter.h0().D(new p6.f() { // from class: com.transsion.audio.fragment.h
            @Override // p6.f
            public final void a() {
                SubjectListFragment.B0(SubjectListFragment.this);
            }
        });
        subjectListAdapter.w1(new p6.d() { // from class: com.transsion.audio.fragment.i
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                SubjectListFragment.C0(baseQuickAdapter, view2, i11);
            }
        });
        subjectListAdapter.J1(new SubjectListAdapter.a() { // from class: com.transsion.audio.fragment.SubjectListFragment$initView$1$3
            @Override // com.transsion.audio.adapter.SubjectListAdapter.a
            public void a(DownloadItem download) {
                Intrinsics.h(download, "download");
                kotlinx.coroutines.j.b(null, new SubjectListFragment$initView$1$3$onPlayItem$1(download, SubjectListFragment.this, null), 1, null);
            }
        });
        this.mAdapter = subjectListAdapter;
        bj.c mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (swipeRefreshLayout = mViewBinding3.f16644f) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.audio.fragment.j
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    SubjectListFragment.D0(SubjectListFragment.this);
                }
            });
        }
        bj.c mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (recyclerView = mViewBinding4.f16643e) == null) {
            return;
        }
        recyclerView.setAdapter(this.mAdapter);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        f.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e mediaSource) {
        f.a.e(this, mediaSource);
        kotlinx.coroutines.j.b(null, new SubjectListFragment$onCompletion$1(mediaSource, this, null), 1, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        f.a.h(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e eVar) {
        f.a.i(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e eVar) {
        f.a.k(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        f.a.o(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IAudioApi mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.removePlayerListener(this);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        f.a.q(this, errorInfo, mediaSource);
        uh.b.f76876a.e(String.valueOf(errorInfo.getErrorMessage()));
        kotlinx.coroutines.j.b(null, new SubjectListFragment$onPlayError$1(this, null), 1, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        f.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        f.a.v(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e mediaSource) {
        f.a.w(this, mediaSource);
        a.C0856a.f(lg.a.f68962a, f42914r, "onPrepare  " + (!TextUtils.equals(this.previousUrl, mediaSource != null ? mediaSource.k() : null)) + "  previousUrl " + this.previousUrl + " url " + (mediaSource != null ? mediaSource.k() : null), false, 4, null);
        kotlinx.coroutines.j.b(null, new SubjectListFragment$onPrepare$1(mediaSource, this, null), 1, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long progress, ao.e mediaSource) {
        f.a.y(this, progress, mediaSource);
        kotlinx.coroutines.j.b(null, new SubjectListFragment$onProgress$1(mediaSource, this, progress, null), 1, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        f.a.A(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IAudioApi mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.addPlayerListener(this);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        f.a.C(this, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c cVar) {
        f.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        f.a.E(this, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(ao.e eVar) {
        f.a.F(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        f.a.I(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public bj.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        bj.c c11 = bj.c.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
