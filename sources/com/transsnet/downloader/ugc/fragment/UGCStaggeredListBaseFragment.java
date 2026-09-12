package com.transsnet.downloader.ugc.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.view.Lifecycle;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.home.p004enum.BottomTabType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.ugc.activity.UGCMyDownloadsActivity;
import com.transsnet.downloader.ugc.adapter.UGCDownloadStaggeredAdapter;
import com.transsnet.downloader.ugc.adapter.c;
import com.transsnet.downloader.ugc.util.UGCDownloadOpenUtil;
import com.transsnet.downloader.ugc.viewmodel.UGCForYouViewModel;
import com.transsnet.downloader.ugc.widget.SafeStaggeredGridLayoutManager;
import com.transsnet.downloader.ugc.widget.UGCForyouLoadMoreView;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
import lg.a;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0011\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J'\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b(\u0010'J'\u0010)\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b)\u0010'J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0014¢\u0006\u0004\b.\u0010\u0004J'\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b1\u00102J'\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b3\u00102J\u001f\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u0002042\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0005H\u0014¢\u0006\u0004\b8\u0010\u0004J\u001f\u00109\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b9\u0010:J'\u0010;\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b;\u00102J'\u0010<\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b<\u00102J\u000f\u0010=\u001a\u00020\u0005H\u0016¢\u0006\u0004\b=\u0010\u0004J1\u0010B\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00142\u000e\u0010@\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010?2\b\b\u0002\u0010A\u001a\u00020\u0014H\u0014¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0005H\u0004¢\u0006\u0004\bD\u0010\u0004J\u001d\u0010G\u001a\u00020\u00052\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001a0EH\u0004¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0005H\u0016¢\u0006\u0004\bI\u0010\u0004J\u000f\u0010J\u001a\u00020\u0005H\u0016¢\u0006\u0004\bJ\u0010\u0004J\u0017\u0010L\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0014H\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0005H\u0016¢\u0006\u0004\bN\u0010\u0004J\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u0007H&¢\u0006\u0004\bR\u0010\tJ\r\u0010S\u001a\u00020\u0007¢\u0006\u0004\bS\u0010\tJ\u001f\u0010V\u001a\u00020\u00142\u0006\u0010%\u001a\u00020$2\u0006\u0010U\u001a\u00020TH\u0004¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\"2\u0006\u0010X\u001a\u00020\u0014H\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0005H\u0004¢\u0006\u0004\b[\u0010\u0004R\u001a\u0010_\u001a\u00020\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010\tR$\u0010e\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010-R\u001b\u0010k\u001a\u00020f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u001b\u0010p\u001a\u00020l8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bm\u0010h\u001a\u0004\bn\u0010oR\u001b\u0010u\u001a\u00020q8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\br\u0010h\u001a\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00070z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0017\u0010\u0080\u0001\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR'\u0010\u0085\u0001\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b\u0081\u0001\u0010]\u001a\u0005\b\u0082\u0001\u0010\t\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0088\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0087\u0001¨\u0006\u008b\u0001"}, d2 = {"Lcom/transsnet/downloader/ugc/fragment/UGCStaggeredListBaseFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lpy/n0;", "<init>", "()V", "", "initExposureHelper", "", "z0", "()Ljava/lang/String;", "G0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "F0", "(Landroid/view/LayoutInflater;)Lpy/n0;", "getPageStateLayoutTitle", "", "isAudioShowNoNetworkLayout", "()Z", "initViewData", "K0", "Landroidx/recyclerview/widget/DiffUtil$e;", "Lcom/transsnet/downloader/ugc/adapter/c;", "v0", "()Landroidx/recyclerview/widget/DiffUtil$e;", "J0", "Landroidx/recyclerview/widget/RecyclerView$l;", "w0", "()Landroidx/recyclerview/widget/RecyclerView$l;", WebConstants.FIELD_ITEM, "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", RequestParameters.POSITION, "U0", "(Lcom/transsnet/downloader/ugc/adapter/c;Landroid/view/View;I)V", "T0", "V0", "Lcom/transsnet/downloader/ugc/adapter/UGCDownloadStaggeredAdapter;", "adapter", "d1", "(Lcom/transsnet/downloader/ugc/adapter/UGCDownloadStaggeredAdapter;)V", "e1", "Lcom/transsion/baselib/db/download/DownloadBean;", "bean", "R0", "(Lcom/transsion/baselib/db/download/DownloadBean;Landroid/view/View;I)V", "Q0", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "video", "X0", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;I)V", "Z0", "W0", "(Lcom/transsion/baselib/db/download/DownloadBean;I)V", "Y0", "S0", "initViewModel", "hasMore", "", "videos", "isFromCache", "h1", "(ZLjava/util/List;Z)V", "b1", "", "currentList", "a1", "(Ljava/util/List;)V", "initListener", "retryLoadData", "hidden", "onHiddenChanged", "(Z)V", "onDestroyView", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "E0", "getPageName", "", NotificationCompat.CATEGORY_PROGRESS, "g1", "(IJ)Z", "isShowTitleLayout", "getEmptyView", "(Z)Landroid/view/View;", "u0", "a", "Ljava/lang/String;", "getTAG", "TAG", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsnet/downloader/ugc/adapter/UGCDownloadStaggeredAdapter;", "D0", "()Lcom/transsnet/downloader/ugc/adapter/UGCDownloadStaggeredAdapter;", "setStaggeredAdapter", "staggeredAdapter", "Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "c", "Lkotlin/Lazy;", "x0", "()Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "downloadViewModel", "Lcom/transsnet/downloader/ugc/viewmodel/UGCForYouViewModel;", "d", "B0", "()Lcom/transsnet/downloader/ugc/viewmodel/UGCForYouViewModel;", "forYouViewModel", "Lcom/transsnet/downloader/ugc/viewmodel/b;", "e", "A0", "()Lcom/transsnet/downloader/ugc/viewmodel/b;", "forYouCacheViewModel", "Lsj/b;", "f", "Lsj/b;", "exposureHelper", "", be.g.f16474b, "Ljava/util/Set;", "exposedForYouVideoIds", "h", "J", "pageLoadStartTime", "i", "C0", "c1", "(Ljava/lang/String;)V", "modeArg", com.mbridge.msdk.foundation.same.report.j.f35620b, "Z", "forYouRequested", CampaignEx.JSON_KEY_AD_K, "isLoadingForYou", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public abstract class UGCStaggeredListBaseFragment extends PageStatusFragment<py.n0> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private UGCDownloadStaggeredAdapter staggeredAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy forYouViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy forYouCacheViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private sj.b exposureHelper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Set exposedForYouVideoIds;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long pageLoadStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String modeArg;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean forYouRequested;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingForYou;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "UGCStaggered_" + getClass().getSimpleName();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment$special$$inlined$activityViewModels$default$2
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
    public static final class a extends DiffUtil.e {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(com.transsnet.downloader.ugc.adapter.c oldItem, com.transsnet.downloader.ugc.adapter.c newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            if ((oldItem instanceof c.C0717c) && (newItem instanceof c.C0717c)) {
                c.C0717c c0717c = (c.C0717c) oldItem;
                c.C0717c c0717c2 = (c.C0717c) newItem;
                if (c0717c.b().getStatus() == c0717c2.b().getStatus() && c0717c.b().getProgress() == c0717c2.b().getProgress()) {
                    return true;
                }
            } else if ((oldItem instanceof c.b) && (newItem instanceof c.b)) {
                c.b bVar = (c.b) oldItem;
                c.b bVar2 = (c.b) newItem;
                if (bVar.b().getStatus() == bVar2.b().getStatus() && bVar.b().getProgress() == bVar2.b().getProgress()) {
                    return true;
                }
            } else if ((oldItem instanceof c.e) && (newItem instanceof c.e)) {
                return Intrinsics.c(((c.e) oldItem).a().getUgcVideoId(), ((c.e) newItem).a().getUgcVideoId());
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(com.transsnet.downloader.ugc.adapter.c oldItem, com.transsnet.downloader.ugc.adapter.c newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            if ((oldItem instanceof c.C0717c) && (newItem instanceof c.C0717c)) {
                return Intrinsics.c(((c.C0717c) oldItem).b().getResourceId(), ((c.C0717c) newItem).b().getResourceId());
            }
            if ((oldItem instanceof c.b) && (newItem instanceof c.b)) {
                return Intrinsics.c(((c.b) oldItem).b().getResourceId(), ((c.b) newItem).b().getResourceId());
            }
            if ((oldItem instanceof c.e) && (newItem instanceof c.e)) {
                return Intrinsics.c(((c.e) oldItem).a().getUgcVideoId(), ((c.e) newItem).a().getUgcVideoId());
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends RecyclerView.l {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == -1) {
                return;
            }
            RecyclerView.Adapter adapter = parent.getAdapter();
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = adapter instanceof UGCDownloadStaggeredAdapter ? (UGCDownloadStaggeredAdapter) adapter : null;
            if (uGCDownloadStaggeredAdapter == null) {
                return;
            }
            int itemCount = uGCDownloadStaggeredAdapter.getItemCount();
            if (childAdapterPosition >= 0 && childAdapterPosition < itemCount) {
                try {
                    com.transsnet.downloader.ugc.adapter.c cVar = (com.transsnet.downloader.ugc.adapter.c) uGCDownloadStaggeredAdapter.getItem(childAdapterPosition);
                    if (cVar == null) {
                        return;
                    }
                    if (cVar instanceof c.e) {
                        RecyclerView.m layoutManager = parent.getLayoutManager();
                        if ((layoutManager instanceof StaggeredGridLayoutManager ? (StaggeredGridLayoutManager) layoutManager : null) == null) {
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        StaggeredGridLayoutManager.b bVar = layoutParams instanceof StaggeredGridLayoutManager.b ? (StaggeredGridLayoutManager.b) layoutParams : null;
                        if (bVar == null) {
                            return;
                        }
                        int a11 = bVar.a();
                        int b11 = dk.a.b(12);
                        int b12 = dk.a.b(8);
                        if (a11 == 0) {
                            outRect.left = b11;
                            outRect.right = b12 / 2;
                            return;
                        } else {
                            outRect.left = b12 / 2;
                            outRect.right = b11;
                            return;
                        }
                    }
                    outRect.left = 0;
                    outRect.right = 0;
                } catch (IndexOutOfBoundsException unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements sj.a {
        c() {
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            String ugcVideoId;
            try {
                UGCDownloadStaggeredAdapter staggeredAdapter = UGCStaggeredListBaseFragment.this.getStaggeredAdapter();
                if (staggeredAdapter != null && i11 >= 0 && i11 < staggeredAdapter.getItemCount()) {
                    Object item = staggeredAdapter.getItem(i11);
                    c.e eVar = item instanceof c.e ? (c.e) item : null;
                    if (eVar == null || (ugcVideoId = eVar.a().getUgcVideoId()) == null || UGCStaggeredListBaseFragment.this.exposedForYouVideoIds.contains(ugcVideoId)) {
                        return;
                    }
                    UGCStaggeredListBaseFragment.this.exposedForYouVideoIds.add(ugcVideoId);
                    com.transsnet.downloader.ugc.util.e.f59970a.a(UGCStaggeredListBaseFragment.this.getPageName(), eVar.a(), i11, j11);
                }
            } catch (Throwable th2) {
                a.C0856a.k(lg.a.f68962a, UGCStaggeredListBaseFragment.this.getTAG(), "exposure error", th2, false, 8, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59898a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59898a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59898a;
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
            this.f59898a.invoke(obj);
        }
    }

    public UGCStaggeredListBaseFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.forYouViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCForYouViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment$special$$inlined$viewModels$default$3
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
        this.forYouCacheViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.ugc.viewmodel.b.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment$special$$inlined$activityViewModels$default$4
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
        this.exposedForYouVideoIds = new LinkedHashSet();
        this.modeArg = "ugc_home";
    }

    private final void G0() {
        Function1 function1 = new Function1() { // from class: com.transsnet.downloader.ugc.fragment.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = UGCStaggeredListBaseFragment.H0(UGCStaggeredListBaseFragment.this, (LocalVideoEvent) obj);
                return H0;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LocalVideoEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.y0.c().q(), false, function1);
        Function1 function12 = new Function1() { // from class: com.transsnet.downloader.ugc.fragment.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I0;
                I0 = UGCStaggeredListBaseFragment.I0(UGCStaggeredListBaseFragment.this, (DownloadRefreshEvent) obj);
                return I0;
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = DownloadRefreshEvent.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().q(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment, LocalVideoEvent value) {
        List<Object> data;
        List<Object> data2;
        List<Object> data3;
        Intrinsics.h(value, "value");
        try {
            a.C0856a.f(lg.a.f68962a, uGCStaggeredListBaseFragment.TAG, "LocalVideoEvent resourceId:" + value.getResourceId() + ", readProgress:" + value.getReadProgress() + ", isSeries:" + value.isSeries(), false, 4, null);
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = uGCStaggeredListBaseFragment.staggeredAdapter;
            int i11 = -1;
            if (uGCDownloadStaggeredAdapter != null && (data3 = uGCDownloadStaggeredAdapter.getData()) != null) {
                Iterator<Object> it = data3.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.transsnet.downloader.ugc.adapter.c cVar = (com.transsnet.downloader.ugc.adapter.c) it.next();
                    if (cVar instanceof c.C0717c ? Intrinsics.c(((c.C0717c) cVar).b().getResourceId(), value.getResourceId()) : cVar instanceof c.b ? Intrinsics.c(((c.b) cVar).b().getResourceId(), value.getResourceId()) : false) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                }
            }
            if (i11 >= 0) {
                UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter2 = uGCStaggeredListBaseFragment.staggeredAdapter;
                if (i11 < (uGCDownloadStaggeredAdapter2 != null ? uGCDownloadStaggeredAdapter2.getItemCount() : 0)) {
                    UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter3 = uGCStaggeredListBaseFragment.staggeredAdapter;
                    com.transsnet.downloader.ugc.adapter.c cVar2 = uGCDownloadStaggeredAdapter3 != null ? (com.transsnet.downloader.ugc.adapter.c) uGCDownloadStaggeredAdapter3.getItem(i11) : null;
                    if (cVar2 instanceof c.C0717c) {
                        DownloadBean b11 = ((c.C0717c) cVar2).b();
                        if (value.getReadProgress() >= 0) {
                            b11.setReadProgress(value.getReadProgress());
                        }
                        if (value.getDuration() >= 0) {
                            b11.setDuration(Long.valueOf(value.getDuration()));
                        }
                        c.C0717c a11 = ((c.C0717c) cVar2).a(b11);
                        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter4 = uGCStaggeredListBaseFragment.staggeredAdapter;
                        if (uGCDownloadStaggeredAdapter4 != null && (data2 = uGCDownloadStaggeredAdapter4.getData()) != null) {
                        }
                        if (value.getRefreshItemAll()) {
                            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter5 = uGCStaggeredListBaseFragment.staggeredAdapter;
                            if (uGCDownloadStaggeredAdapter5 != null) {
                                uGCDownloadStaggeredAdapter5.notifyItemChanged(i11);
                            }
                        } else {
                            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter6 = uGCStaggeredListBaseFragment.staggeredAdapter;
                            if (uGCDownloadStaggeredAdapter6 != null) {
                                uGCDownloadStaggeredAdapter6.notifyItemChanged(i11, b11);
                            }
                        }
                    } else if (cVar2 instanceof c.b) {
                        DownloadBean b12 = ((c.b) cVar2).b();
                        if (value.getReadProgress() >= 0) {
                            b12.setReadProgress(value.getReadProgress());
                        }
                        if (value.getDuration() >= 0) {
                            b12.setDuration(Long.valueOf(value.getDuration()));
                        }
                        c.b a12 = ((c.b) cVar2).a(b12);
                        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter7 = uGCStaggeredListBaseFragment.staggeredAdapter;
                        if (uGCDownloadStaggeredAdapter7 != null && (data = uGCDownloadStaggeredAdapter7.getData()) != null) {
                        }
                        if (value.getRefreshItemAll()) {
                            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter8 = uGCStaggeredListBaseFragment.staggeredAdapter;
                            if (uGCDownloadStaggeredAdapter8 != null) {
                                uGCDownloadStaggeredAdapter8.notifyItemChanged(i11);
                            }
                        } else {
                            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter9 = uGCStaggeredListBaseFragment.staggeredAdapter;
                            if (uGCDownloadStaggeredAdapter9 != null) {
                                uGCDownloadStaggeredAdapter9.notifyItemChanged(i11, b12);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            a.C0856a.k(lg.a.f68962a, uGCStaggeredListBaseFragment.TAG, "LocalVideoEvent error", th2, false, 8, null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment, DownloadRefreshEvent value) {
        int i11;
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter;
        List<Object> data;
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter2;
        List<Object> data2;
        Intrinsics.h(value, "value");
        String resourceId = value.getResourceId();
        if (resourceId != null && resourceId.length() != 0) {
            try {
                String subjectId = value.getSubjectId();
                int i12 = -1;
                if (subjectId != null && subjectId.length() != 0 && (uGCDownloadStaggeredAdapter2 = uGCStaggeredListBaseFragment.staggeredAdapter) != null && (data2 = uGCDownloadStaggeredAdapter2.getData()) != null) {
                    Iterator<Object> it = data2.iterator();
                    i11 = 0;
                    while (it.hasNext()) {
                        com.transsnet.downloader.ugc.adapter.c cVar = (com.transsnet.downloader.ugc.adapter.c) it.next();
                        if (cVar instanceof c.C0717c ? Intrinsics.c(((c.C0717c) cVar).b().getSubjectId(), value.getSubjectId()) : cVar instanceof c.b ? Intrinsics.c(((c.b) cVar).b().getSubjectId(), value.getSubjectId()) : false) {
                            break;
                        }
                        i11++;
                    }
                }
                i11 = -1;
                if (i11 >= 0) {
                    UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter3 = uGCStaggeredListBaseFragment.staggeredAdapter;
                    if (uGCDownloadStaggeredAdapter3 != null) {
                        uGCDownloadStaggeredAdapter3.notifyItemChanged(i11);
                    }
                } else {
                    UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter4 = uGCStaggeredListBaseFragment.staggeredAdapter;
                    if (uGCDownloadStaggeredAdapter4 != null && (data = uGCDownloadStaggeredAdapter4.getData()) != null) {
                        Iterator<Object> it2 = data.iterator();
                        int i13 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            com.transsnet.downloader.ugc.adapter.c cVar2 = (com.transsnet.downloader.ugc.adapter.c) it2.next();
                            if (cVar2 instanceof c.C0717c ? Intrinsics.c(((c.C0717c) cVar2).b().getResourceId(), value.getResourceId()) : cVar2 instanceof c.b ? Intrinsics.c(((c.b) cVar2).b().getResourceId(), value.getResourceId()) : false) {
                                i12 = i13;
                                break;
                            }
                            i13++;
                        }
                    }
                    if (i12 >= 0 && (uGCDownloadStaggeredAdapter = uGCStaggeredListBaseFragment.staggeredAdapter) != null) {
                        uGCDownloadStaggeredAdapter.notifyItemChanged(i12);
                    }
                }
            } catch (Throwable th2) {
                a.C0856a.k(lg.a.f68962a, uGCStaggeredListBaseFragment.TAG, "DownloadRefreshEvent error", th2, false, 8, null);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View L0(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment) {
        return uGCStaggeredListBaseFragment.getEmptyView(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 1000L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        Intrinsics.f(item, "null cannot be cast to non-null type com.transsnet.downloader.ugc.adapter.UGCDownloadStaggeredItem");
        uGCStaggeredListBaseFragment.U0((com.transsnet.downloader.ugc.adapter.c) item, view, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 1000L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        Intrinsics.f(item, "null cannot be cast to non-null type com.transsnet.downloader.ugc.adapter.UGCDownloadStaggeredItem");
        uGCStaggeredListBaseFragment.T0((com.transsnet.downloader.ugc.adapter.c) item, view, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O0(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i11);
        Intrinsics.f(item, "null cannot be cast to non-null type com.transsnet.downloader.ugc.adapter.UGCDownloadStaggeredItem");
        uGCStaggeredListBaseFragment.V0((com.transsnet.downloader.ugc.adapter.c) item, view, i11);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment, UGCContentList uGCContentList) {
        List l11;
        Pager pager;
        Pager pager2;
        Boolean hasMore;
        List<UGCContent> items;
        hj.b logViewConfig = uGCStaggeredListBaseFragment.getLogViewConfig();
        boolean z10 = true;
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        if (uGCContentList == null || (items = uGCContentList.getItems()) == null) {
            l11 = CollectionsKt.l();
        } else {
            l11 = new ArrayList();
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                UGCVideo video = ((UGCContent) it.next()).getVideo();
                if (video != null) {
                    l11.add(video);
                }
            }
        }
        List list = l11;
        if (uGCContentList != null && (pager2 = uGCContentList.getPager()) != null && (hasMore = pager2.getHasMore()) != null) {
            z10 = hasMore.booleanValue();
        }
        boolean z11 = z10;
        String nextPage = (uGCContentList == null || (pager = uGCContentList.getPager()) == null) ? null : pager.getNextPage();
        String z02 = uGCStaggeredListBaseFragment.z0();
        if (uGCStaggeredListBaseFragment.forYouRequested && uGCStaggeredListBaseFragment.B0().h().f() != null) {
            if (uGCStaggeredListBaseFragment.A0().d(z02)) {
                uGCStaggeredListBaseFragment.A0().f(z02, list, nextPage, z11);
            } else {
                uGCStaggeredListBaseFragment.A0().g(z02, list, nextPage, z11);
            }
        }
        i1(uGCStaggeredListBaseFragment, z11, list, false, 4, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment, UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter) {
        String i11;
        if (uGCStaggeredListBaseFragment.isLoadingForYou) {
            a.C0856a.f(lg.a.f68962a, uGCStaggeredListBaseFragment.TAG, "foryou loadmore--- isLoadingForYou, skip", false, 4, null);
            return;
        }
        if (!nh.m.f70597a.e()) {
            r6.f.u(uGCDownloadStaggeredAdapter.h0(), false, 1, null);
            return;
        }
        String b11 = uGCStaggeredListBaseFragment.A0().b(uGCStaggeredListBaseFragment.z0());
        if (b11 != null && b11.length() > 0 && ((i11 = uGCStaggeredListBaseFragment.B0().i()) == null || i11.length() == 0)) {
            uGCStaggeredListBaseFragment.B0().k(b11);
        }
        uGCStaggeredListBaseFragment.isLoadingForYou = true;
        uGCStaggeredListBaseFragment.B0().g(false);
    }

    public static /* synthetic */ void i1(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment, boolean z10, List list, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateForYouList");
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        uGCStaggeredListBaseFragment.h1(z10, list, z11);
    }

    private final void initExposureHelper() {
        RecyclerView recyclerView;
        if (this.exposureHelper != null) {
            return;
        }
        sj.b bVar = new sj.b(0.6f, new c(), false, 4, null);
        bVar.n(2);
        this.exposureHelper = bVar;
        py.n0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f72980b) == null) {
            return;
        }
        sj.b bVar2 = this.exposureHelper;
        Intrinsics.e(bVar2);
        recyclerView.addOnScrollListener(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j1(com.transsnet.downloader.ugc.adapter.c it) {
        Intrinsics.h(it, "it");
        return (it instanceof c.e) || (it instanceof c.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(UGCStaggeredListBaseFragment uGCStaggeredListBaseFragment) {
        Navigator.x(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_HOME), uGCStaggeredListBaseFragment.requireContext(), null, 2, null);
        return Unit.f67184a;
    }

    private final String z0() {
        return E0();
    }

    protected final com.transsnet.downloader.ugc.viewmodel.b A0() {
        return (com.transsnet.downloader.ugc.viewmodel.b) this.forYouCacheViewModel.getValue();
    }

    protected final UGCForYouViewModel B0() {
        return (UGCForYouViewModel) this.forYouViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C0, reason: from getter */
    public final String getModeArg() {
        return this.modeArg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D0, reason: from getter */
    public final UGCDownloadStaggeredAdapter getStaggeredAdapter() {
        return this.staggeredAdapter;
    }

    public abstract String E0();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public py.n0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.n0 c11 = py.n0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    protected void J0() {
        RecyclerView recyclerView;
        py.n0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f72980b) == null) {
            return;
        }
        SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = new SafeStaggeredGridLayoutManager(2, 1);
        safeStaggeredGridLayoutManager.f0(2);
        recyclerView.setLayoutManager(safeStaggeredGridLayoutManager);
        recyclerView.setAdapter(this.staggeredAdapter);
        recyclerView.addItemDecoration(w0());
    }

    protected void K0() {
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = new UGCDownloadStaggeredAdapter(new Function0() { // from class: com.transsnet.downloader.ugc.fragment.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View L0;
                L0 = UGCStaggeredListBaseFragment.L0(UGCStaggeredListBaseFragment.this);
                return L0;
            }
        });
        uGCDownloadStaggeredAdapter.R0(v0());
        uGCDownloadStaggeredAdapter.w1(new p6.d() { // from class: com.transsnet.downloader.ugc.fragment.v0
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCStaggeredListBaseFragment.M0(UGCStaggeredListBaseFragment.this, baseQuickAdapter, view, i11);
            }
        });
        if (this instanceof UGCDownloadingListFragment) {
            uGCDownloadStaggeredAdapter.l(R$id.iv_more, R$id.iv_cover);
        } else {
            uGCDownloadStaggeredAdapter.l(R$id.iv_more);
        }
        uGCDownloadStaggeredAdapter.s1(new p6.b() { // from class: com.transsnet.downloader.ugc.fragment.w0
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCStaggeredListBaseFragment.N0(UGCStaggeredListBaseFragment.this, baseQuickAdapter, view, i11);
            }
        });
        uGCDownloadStaggeredAdapter.y1(new p6.e() { // from class: com.transsnet.downloader.ugc.fragment.x0
            @Override // p6.e
            public final boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                boolean O0;
                O0 = UGCStaggeredListBaseFragment.O0(UGCStaggeredListBaseFragment.this, baseQuickAdapter, view, i11);
                return O0;
            }
        });
        d1(uGCDownloadStaggeredAdapter);
        this.staggeredAdapter = uGCDownloadStaggeredAdapter;
    }

    protected void Q0(DownloadBean bean, View view, int position) {
        Intrinsics.h(bean, "bean");
        Intrinsics.h(view, "view");
        if (bean.getStatus() == 14) {
            return;
        }
        if (bean.getStatus() == 10) {
            W0(bean, position);
        } else {
            Y0(bean, view, position);
        }
    }

    protected void R0(DownloadBean bean, View view, int position) {
        Intrinsics.h(bean, "bean");
        Intrinsics.h(view, "view");
    }

    public abstract void S0(DownloadBean bean, View view, int position);

    protected void T0(com.transsnet.downloader.ugc.adapter.c item, View view, int position) {
        Intrinsics.h(item, "item");
        Intrinsics.h(view, "view");
        if (item instanceof c.C0717c) {
            int id2 = view.getId();
            if (id2 == R$id.iv_more) {
                S0(((c.C0717c) item).b(), view, position);
                return;
            } else {
                if (id2 == R$id.iv_cover) {
                    Y0(((c.C0717c) item).b(), view, position);
                    return;
                }
                return;
            }
        }
        if (item instanceof c.b) {
            int id3 = view.getId();
            if (id3 == R$id.iv_more) {
                S0(((c.b) item).b(), view, position);
            } else if (id3 == R$id.iv_cover) {
                Y0(((c.b) item).b(), view, position);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U0(com.transsnet.downloader.ugc.adapter.c item, View view, int position) {
        Intrinsics.h(item, "item");
        Intrinsics.h(view, "view");
        if (item instanceof c.C0717c) {
            c.C0717c c0717c = (c.C0717c) item;
            if (c0717c.b().getIsMore()) {
                Z0();
                return;
            } else {
                R0(c0717c.b(), view, position);
                return;
            }
        }
        if (item instanceof c.b) {
            Q0(((c.b) item).b(), view, position);
        } else if (item instanceof c.e) {
            X0(((c.e) item).a(), position);
        }
    }

    protected void V0(com.transsnet.downloader.ugc.adapter.c item, View view, int position) {
        Intrinsics.h(item, "item");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 1000L)) {
            return;
        }
        if (item instanceof c.C0717c) {
            S0(((c.C0717c) item).b(), view, position);
        } else if (item instanceof c.b) {
            S0(((c.b) item).b(), view, position);
        }
    }

    protected void W0(DownloadBean bean, int position) {
        Intrinsics.h(bean, "bean");
        View view = getView();
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        Navigator c11 = TheRouter.c("/download/ugc_collection_list");
        String ugcVideoCollectionId = bean.getUgcVideoCollectionId();
        if (ugcVideoCollectionId == null || ugcVideoCollectionId.length() == 0) {
            String subjectName = bean.getSubjectName();
            c11.K("name", subjectName != null ? subjectName : "Collection").K("subject_id", bean.getSubjectId());
        } else {
            String ugcVideoCollectionName = bean.getUgcVideoCollectionName();
            c11.K("name", ugcVideoCollectionName != null ? ugcVideoCollectionName : "Collection").K("collection_id", bean.getUgcVideoCollectionId());
        }
        Navigator.x(c11.F("parent_position", position), appCompatActivity, null, 2, null);
    }

    protected void X0(UGCVideo video, int position) {
        Intrinsics.h(video, "video");
        String ugcVideoId = video.getUgcVideoId();
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            return;
        }
        pv.b.b(video, null, 1, null);
        com.transsnet.downloader.ugc.util.e.f59970a.b(getPageName(), video, position);
    }

    protected void Y0(DownloadBean bean, View view, int position) {
        Intrinsics.h(bean, "bean");
        Intrinsics.h(view, "view");
        UGCDownloadOpenUtil.f59965a.r(view, getPageName(), position, bean);
    }

    protected void Z0() {
        Activity b11 = com.blankj.utilcode.util.a.b();
        AppCompatActivity appCompatActivity = b11 instanceof AppCompatActivity ? (AppCompatActivity) b11 : null;
        if (appCompatActivity == null) {
            return;
        }
        Navigator.x(TheRouter.c("/download/ugc_my_downloads"), appCompatActivity, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a1(List currentList) {
        Collection<com.transsnet.downloader.ugc.adapter.c> l11;
        String ugcVideoId;
        List<Object> data;
        Intrinsics.h(currentList, "currentList");
        if (Intrinsics.c(this.modeArg, "ugc_home")) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : currentList) {
                com.transsnet.downloader.ugc.adapter.c cVar = (com.transsnet.downloader.ugc.adapter.c) obj;
                if ((cVar instanceof c.e) || (cVar instanceof c.f)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (obj2 instanceof c.e) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String ugcVideoId2 = ((c.e) it.next()).a().getUgcVideoId();
                if (ugcVideoId2 != null) {
                    arrayList3.add(ugcVideoId2);
                }
            }
            Set W0 = CollectionsKt.W0(arrayList3);
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = this.staggeredAdapter;
            if (uGCDownloadStaggeredAdapter == null || (data = uGCDownloadStaggeredAdapter.getData()) == null) {
                l11 = CollectionsKt.l();
            } else {
                l11 = new ArrayList();
                for (Object obj3 : data) {
                    com.transsnet.downloader.ugc.adapter.c cVar2 = (com.transsnet.downloader.ugc.adapter.c) obj3;
                    if ((cVar2 instanceof c.e) || (cVar2 instanceof c.f)) {
                        l11.add(obj3);
                    }
                }
            }
            for (com.transsnet.downloader.ugc.adapter.c cVar3 : l11) {
                if (cVar3 instanceof c.f) {
                    if (!arrayList.isEmpty()) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            if (((com.transsnet.downloader.ugc.adapter.c) it2.next()) instanceof c.f) {
                                break;
                            }
                        }
                    }
                    currentList.add(cVar3);
                } else if ((cVar3 instanceof c.e) && (ugcVideoId = ((c.e) cVar3).a().getUgcVideoId()) != null && !W0.contains(ugcVideoId)) {
                    currentList.add(cVar3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b1() {
        if (Intrinsics.c(this.modeArg, "ugc_home")) {
            String z02 = z0();
            if (!A0().d(z02)) {
                if (!this.forYouRequested && B0().h().f() == null && nh.m.f70597a.e()) {
                    this.forYouRequested = true;
                    this.isLoadingForYou = true;
                    B0().g(true);
                    return;
                }
                return;
            }
            a.C0856a.f(lg.a.f68962a, this.TAG, "requestForYouIfNeeded: use cached data, cacheKey=" + z02 + ", size=" + A0().c(z02).size(), false, 4, null);
            h1(A0().e(z02), A0().c(z02), true);
            this.forYouRequested = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c1(String str) {
        Intrinsics.h(str, "<set-?>");
        this.modeArg = str;
    }

    protected void d1(UGCDownloadStaggeredAdapter adapter) {
        Intrinsics.h(adapter, "adapter");
    }

    protected void e1() {
        final UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = this.staggeredAdapter;
        if (uGCDownloadStaggeredAdapter != null) {
            uGCDownloadStaggeredAdapter.h0().z(true);
            uGCDownloadStaggeredAdapter.h0().y(true);
            uGCDownloadStaggeredAdapter.h0().E(3);
            uGCDownloadStaggeredAdapter.h0().C(new UGCForyouLoadMoreView());
            uGCDownloadStaggeredAdapter.h0().D(new p6.f() { // from class: com.transsnet.downloader.ugc.fragment.t0
                @Override // p6.f
                public final void a() {
                    UGCStaggeredListBaseFragment.f1(UGCStaggeredListBaseFragment.this, uGCDownloadStaggeredAdapter);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean g1(int position, long progress) {
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter;
        com.transsnet.downloader.ugc.adapter.c cVar;
        List<Object> data;
        if (position >= 0) {
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter2 = this.staggeredAdapter;
            if (position < (uGCDownloadStaggeredAdapter2 != null ? uGCDownloadStaggeredAdapter2.getItemCount() : 0) && (uGCDownloadStaggeredAdapter = this.staggeredAdapter) != null && (cVar = (com.transsnet.downloader.ugc.adapter.c) uGCDownloadStaggeredAdapter.getItem(position)) != null && (cVar instanceof c.b)) {
                c.b bVar = (c.b) cVar;
                DownloadBean b11 = bVar.b();
                b11.setReadProgress(progress);
                c.b a11 = bVar.a(b11);
                UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter3 = this.staggeredAdapter;
                if (uGCDownloadStaggeredAdapter3 != null && (data = uGCDownloadStaggeredAdapter3.getData()) != null) {
                }
                UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter4 = this.staggeredAdapter;
                if (uGCDownloadStaggeredAdapter4 == null) {
                    return true;
                }
                uGCDownloadStaggeredAdapter4.notifyItemChanged(position, b11);
                return true;
            }
        }
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View getEmptyView(boolean isShowTitleLayout) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        String string = stateView.getContext().getString(R$string.download_no_historical_tips);
        Intrinsics.g(string, "getString(...)");
        stateView.showData(4, 6, false, "", string);
        String string2 = stateView.getContext().getString(R$string.download_empty_find_free_source);
        Intrinsics.g(string2, "getString(...)");
        stateView.setReTryTxt(string2);
        stateView.retry(new Function0() { // from class: com.transsnet.downloader.ugc.fragment.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit y02;
                y02 = UGCStaggeredListBaseFragment.y0(UGCStaggeredListBaseFragment.this);
                return y02;
            }
        });
        return stateView;
    }

    public final String getPageName() {
        return Intrinsics.c(this.modeArg, "ugc_home") ? "/download/ugc_download" : "/download/ugc_my_download";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getTAG() {
        return this.TAG;
    }

    protected void h1(boolean hasMore, List videos, boolean isFromCache) {
        List arrayList;
        boolean z10;
        r6.f h02;
        r6.f h03;
        r6.f h04;
        r6.f h05;
        List<Object> data;
        this.isLoadingForYou = false;
        if (Intrinsics.c(this.modeArg, "ugc_home")) {
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = this.staggeredAdapter;
            if (uGCDownloadStaggeredAdapter == null || (data = uGCDownloadStaggeredAdapter.getData()) == null || (arrayList = CollectionsKt.U0(data)) == null) {
                arrayList = new ArrayList();
            }
            if (isFromCache) {
                CollectionsKt.I(arrayList, new Function1() { // from class: com.transsnet.downloader.ugc.fragment.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean j12;
                        j12 = UGCStaggeredListBaseFragment.j1((com.transsnet.downloader.ugc.adapter.c) obj);
                        return Boolean.valueOf(j12);
                    }
                });
            }
            List<com.transsnet.downloader.ugc.adapter.c> list = arrayList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (com.transsnet.downloader.ugc.adapter.c cVar : list) {
                    if ((cVar instanceof c.e) || (cVar instanceof c.f)) {
                        z10 = true;
                        break;
                    }
                }
            }
            z10 = false;
            List list2 = videos;
            if (list2 == null || list2.isEmpty()) {
                a.C0856a.z(lg.a.f68962a, this.TAG, "foryou list is empty，hasExistingForYou:" + z10 + ", hasMore:" + hasMore, false, 4, null);
                if (hasMore) {
                    UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter2 = this.staggeredAdapter;
                    if (uGCDownloadStaggeredAdapter2 == null || (h03 = uGCDownloadStaggeredAdapter2.h0()) == null) {
                        return;
                    }
                    h03.v();
                    return;
                }
                UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter3 = this.staggeredAdapter;
                if (uGCDownloadStaggeredAdapter3 == null || (h02 = uGCDownloadStaggeredAdapter3.h0()) == null) {
                    return;
                }
                r6.f.u(h02, false, 1, null);
                return;
            }
            if (z10) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof c.e) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String ugcVideoId = ((c.e) it.next()).a().getUgcVideoId();
                    if (ugcVideoId != null) {
                        arrayList3.add(ugcVideoId);
                    }
                }
                Set W0 = CollectionsKt.W0(arrayList3);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : videos) {
                    String ugcVideoId2 = ((UGCVideo) obj2).getUgcVideoId();
                    if (ugcVideoId2 != null && !W0.contains(ugcVideoId2)) {
                        arrayList4.add(obj2);
                    }
                }
                if (arrayList4.isEmpty()) {
                    a.C0856a.z(lg.a.f68962a, this.TAG, "updateForYouList: 所有视频都已存在，跳过添加", false, 4, null);
                } else {
                    a.C0856a.f(lg.a.f68962a, this.TAG, "updateForYouList: 过滤后新增 " + arrayList4.size() + " 个视频（原始 " + videos.size() + " 个）", false, 4, null);
                    Iterator it2 = arrayList4.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new c.e((UGCVideo) it2.next()));
                    }
                }
            } else {
                arrayList.add(c.f.f59742a);
                Iterator it3 = videos.iterator();
                while (it3.hasNext()) {
                    arrayList.add(new c.e((UGCVideo) it3.next()));
                }
                this.exposedForYouVideoIds.clear();
            }
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter4 = this.staggeredAdapter;
            if (uGCDownloadStaggeredAdapter4 != null) {
                uGCDownloadStaggeredAdapter4.n1(arrayList);
            }
            if (hasMore) {
                UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter5 = this.staggeredAdapter;
                if (uGCDownloadStaggeredAdapter5 == null || (h05 = uGCDownloadStaggeredAdapter5.h0()) == null) {
                    return;
                }
                h05.s();
                return;
            }
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter6 = this.staggeredAdapter;
            if (uGCDownloadStaggeredAdapter6 == null || (h04 = uGCDownloadStaggeredAdapter6.h0()) == null) {
                return;
            }
            r6.f.u(h04, false, 1, null);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        G0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        HashMap g11;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
        }
        K0();
        J0();
        if (Intrinsics.c(this.modeArg, "ugc_home")) {
            e1();
            initExposureHelper();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        if (Intrinsics.c(this.modeArg, "ugc_home")) {
            B0().h().j(this, new d(new Function1() { // from class: com.transsnet.downloader.ugc.fragment.q0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit P0;
                    P0 = UGCStaggeredListBaseFragment.P0(UGCStaggeredListBaseFragment.this, (UGCContentList) obj);
                    return P0;
                }
            }));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageLoadStartTime = System.currentTimeMillis();
        this.modeArg = getActivity() instanceof UGCMyDownloadsActivity ? "ugc_sub" : "ugc_home";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        sj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
        this.exposureHelper = null;
        this.exposedForYouVideoIds.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
                sj.b bVar = this.exposureHelper;
                if (bVar != null) {
                    bVar.f();
                }
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u0() {
        HashMap g11;
        if (this.pageLoadStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.pageLoadStartTime;
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
                return;
            }
        }
    }

    protected DiffUtil.e v0() {
        return new a();
    }

    protected RecyclerView.l w0() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DownloadViewModel x0() {
        return (DownloadViewModel) this.downloadViewModel.getValue();
    }
}
