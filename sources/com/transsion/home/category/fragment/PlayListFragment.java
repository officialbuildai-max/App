package com.transsion.home.category.fragment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.d;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.c0;
import androidx.view.v;
import androidx.view.v0;
import be.g;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.appbar.AppBarLayout;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.home.R$id;
import com.transsion.home.bean.PlayListResp;
import com.transsion.home.category.PlayListActivity;
import com.transsion.home.category.fragment.PlayListFragment;
import com.transsion.home.viewmodel.PlayListViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PlayListType;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import gl.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import lg.a;
import nh.m;
import org.json.JSONObject;
import p6.f;
import rl.h;
import rl.i;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010\u0018J\u000f\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\u0004J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0012H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0012H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0012H\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0007J\u000f\u0010.\u001a\u00020\u0012H\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0012H\u0016¢\u0006\u0004\b/\u0010\u0004J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0012H\u0016¢\u0006\u0004\b3\u0010\u0004R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R\u0018\u0010@\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010C\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010S\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lcom/transsion/home/category/fragment/PlayListFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lgl/t;", "<init>", "()V", "", "U0", "()Z", "Lcom/transsion/home/category/adapter/b;", "I0", "()Lcom/transsion/home/category/adapter/b;", "Lcom/transsion/home/category/adapter/j;", "M0", "()Lcom/transsion/home/category/adapter/j;", "Lcom/transsion/moviedetailapi/bean/Subject;", "subjectItem", "", RequestParameters.POSITION, "", "E0", "(Lcom/transsion/moviedetailapi/bean/Subject;I)V", "Lcom/transsion/home/bean/PlayListResp;", "playListResp", "Y0", "(Lcom/transsion/home/bean/PlayListResp;)V", "reload", "loadData", "loadMore", "isExpand", "D0", "(Z)V", "Z0", "W0", "initAd", "Landroid/view/LayoutInflater;", "inflater", "G0", "(Landroid/view/LayoutInflater;)Lgl/t;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "receiveArguments", "initViewData", "initViewModel", "initListener", "isMonitorNetworkState", "retryLoadData", "loadDefaultData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "onDestroy", "Lcom/transsion/home/viewmodel/PlayListViewModel;", "a", "Lcom/transsion/home/viewmodel/PlayListViewModel;", "viewModel", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "mLabel", "c", "mCategory", "d", "mRecType", "e", "mTopIds", "f", "I", "mTabId", "Lhl/b;", g.f16474b, "Lhl/b;", "mExposureHelper", "h", "Lcom/transsion/home/category/adapter/j;", "mSubjectAdapter", "i", "Lcom/transsion/home/category/adapter/b;", "mCastAdapter", "Lrl/i;", j.f35620b, "Lkotlin/Lazy;", "F0", "()Lrl/i;", "mPlayListDotHelper", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "l", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class PlayListFragment extends PageStatusFragment<t> {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    public static final int f44916m = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PlayListViewModel viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mLabel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String mCategory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mRecType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mTopIds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mTabId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private hl.b mExposureHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.transsion.home.category.adapter.j mSubjectAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.transsion.home.category.adapter.b mCastAdapter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy mPlayListDotHelper = LazyKt.b(new Function0() { // from class: fl.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            rl.i V0;
            V0 = PlayListFragment.V0();
            return V0;
        }
    });

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private BiddingListManager v3ListManager;

    /* renamed from: com.transsion.home.category.fragment.PlayListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayListFragment a(String str, String str2, String str3, String str4, int i11) {
            PlayListFragment playListFragment = new PlayListFragment();
            playListFragment.setArguments(d.b(TuplesKt.a("label", str), TuplesKt.a("category", str2), TuplesKt.a("recType", str3), TuplesKt.a("topIds", str4), TuplesKt.a("tabId", Integer.valueOf(i11))));
            return playListFragment;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements hl.a {
        b() {
        }

        @Override // hl.a
        public void a(int i11, long j11, View view) {
            Boolean hasResource;
            List<Object> data;
            List<Object> data2;
            boolean z10 = false;
            r13 = 0;
            int i12 = 0;
            z10 = false;
            if (PlayListFragment.this.U0()) {
                com.transsion.home.category.adapter.b bVar = PlayListFragment.this.mCastAdapter;
                if (bVar != null && (data2 = bVar.getData()) != null) {
                    i12 = data2.size();
                }
                if (i11 >= i12) {
                    return;
                }
                com.transsion.home.category.adapter.b bVar2 = PlayListFragment.this.mCastAdapter;
                Staff staff = bVar2 != null ? (Staff) bVar2.getItem(i11) : null;
                PlayListFragment.this.F0().b("playlist", staff != null ? staff.getStaffId() : null, staff != null ? staff.getOps() : null, Integer.valueOf(i11), PlayListFragment.this.mCategory, PlayListFragment.this.mRecType, PlayListFragment.this.mLabel);
                return;
            }
            com.transsion.home.category.adapter.j jVar = PlayListFragment.this.mSubjectAdapter;
            if (i11 >= ((jVar == null || (data = jVar.getData()) == null) ? 0 : data.size())) {
                return;
            }
            com.transsion.home.category.adapter.j jVar2 = PlayListFragment.this.mSubjectAdapter;
            Subject subject = jVar2 != null ? (Subject) jVar2.getItem(i11) : null;
            i F0 = PlayListFragment.this.F0();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            String ops = subject != null ? subject.getOps() : null;
            Integer valueOf = Integer.valueOf(i11);
            if (subject != null && (hasResource = subject.getHasResource()) != null) {
                z10 = hasResource.booleanValue();
            }
            F0.d("playlist", subjectId, ops, valueOf, z10, PlayListFragment.this.mCategory, PlayListFragment.this.mRecType, PlayListFragment.this.mLabel);
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f44929a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f44929a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f44929a;
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
            this.f44929a.invoke(obj);
        }
    }

    private final void D0(boolean isExpand) {
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            if (activity instanceof PlayListActivity) {
                ((PlayListActivity) activity).e0(isExpand);
            }
        }
    }

    private final void E0(Subject subjectItem, int position) {
        Boolean hasResource;
        if (getContext() != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            F0().a("playlist", h.g(subjectItem, "playlist", requireContext, "play_list_page"), subjectItem != null ? subjectItem.getSubjectId() : null, subjectItem != null ? subjectItem.getOps() : null, Integer.valueOf(position), (subjectItem == null || (hasResource = subjectItem.getHasResource()) == null) ? false : hasResource.booleanValue(), this.mCategory, this.mRecType, this.mLabel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i F0() {
        return (i) this.mPlayListDotHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(PlayListFragment playListFragment, int i11, BiddingNativeManager current) {
        List<Object> data;
        List<Object> data2;
        Intrinsics.h(current, "current");
        if (current != null) {
            int i12 = 0;
            if (playListFragment.U0()) {
                Staff staff = new Staff();
                staff.setNonAdDelegate(current);
                com.transsion.home.category.adapter.b bVar = playListFragment.mCastAdapter;
                if (bVar != null && (data2 = bVar.getData()) != null) {
                    i12 = data2.size();
                }
                if (i11 < i12) {
                    com.transsion.home.category.adapter.b bVar2 = playListFragment.mCastAdapter;
                    if (bVar2 != null) {
                        bVar2.n(i11, staff);
                    }
                } else {
                    com.transsion.home.category.adapter.b bVar3 = playListFragment.mCastAdapter;
                    if (bVar3 != null) {
                        bVar3.p(staff);
                    }
                }
            } else {
                Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -1, 134217727, null);
                subject.setNonAdDelegate(current);
                com.transsion.home.category.adapter.j jVar = playListFragment.mSubjectAdapter;
                if (jVar != null && (data = jVar.getData()) != null) {
                    i12 = data.size();
                }
                if (i11 < i12) {
                    com.transsion.home.category.adapter.j jVar2 = playListFragment.mSubjectAdapter;
                    if (jVar2 != null) {
                        jVar2.n(i11, subject);
                    }
                } else {
                    com.transsion.home.category.adapter.j jVar3 = playListFragment.mSubjectAdapter;
                    if (jVar3 != null) {
                        jVar3.p(subject);
                    }
                }
            }
        }
        return Unit.f67184a;
    }

    private final com.transsion.home.category.adapter.b I0() {
        final com.transsion.home.category.adapter.b bVar = new com.transsion.home.category.adapter.b(new ArrayList(), this.mExposureHelper);
        bVar.h0().z(true);
        bVar.h0().y(true);
        bVar.h0().D(new f() { // from class: fl.w
            @Override // p6.f
            public final void a() {
                PlayListFragment.J0(PlayListFragment.this);
            }
        });
        bVar.w1(new p6.d() { // from class: fl.l
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                PlayListFragment.L0(com.transsion.home.category.adapter.b.this, this, baseQuickAdapter, view, i11);
            }
        });
        this.mCastAdapter = bVar;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(final PlayListFragment playListFragment) {
        RecyclerView recyclerView;
        if (m.f70597a.e()) {
            playListFragment.loadMore();
            return;
        }
        uh.b.f76876a.d(R$string.no_network);
        t mViewBinding = playListFragment.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f63968e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: fl.m
            @Override // java.lang.Runnable
            public final void run() {
                PlayListFragment.K0(PlayListFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(PlayListFragment playListFragment) {
        r6.f h02;
        com.transsion.home.category.adapter.b bVar = playListFragment.mCastAdapter;
        if (bVar == null || (h02 = bVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(com.transsion.home.category.adapter.b bVar, PlayListFragment playListFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof Staff) {
            Staff staff = (Staff) item;
            Navigator.x(TheRouter.c("/movie/staff").K("id", staff.getStaffId()).J("staff", (Serializable) item), bVar.getContext(), null, 2, null);
            playListFragment.F0().c("playlist", staff.getStaffId(), staff.getOps(), Integer.valueOf(i11), playListFragment.mCategory, playListFragment.mRecType, playListFragment.mLabel);
        }
    }

    private final com.transsion.home.category.adapter.j M0() {
        com.transsion.home.category.adapter.j jVar = new com.transsion.home.category.adapter.j(new ArrayList(), this.mExposureHelper);
        jVar.h0().z(true);
        jVar.h0().y(true);
        jVar.h0().D(new f() { // from class: fl.t
            @Override // p6.f
            public final void a() {
                PlayListFragment.N0(PlayListFragment.this);
            }
        });
        jVar.w1(new p6.d() { // from class: fl.u
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                PlayListFragment.P0(PlayListFragment.this, baseQuickAdapter, view, i11);
            }
        });
        jVar.l(R$id.ll_download);
        jVar.s1(new p6.b() { // from class: fl.v
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                PlayListFragment.Q0(PlayListFragment.this, baseQuickAdapter, view, i11);
            }
        });
        this.mSubjectAdapter = jVar;
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(final PlayListFragment playListFragment) {
        RecyclerView recyclerView;
        if (m.f70597a.e()) {
            playListFragment.loadMore();
            return;
        }
        uh.b.f76876a.d(R$string.no_network);
        t mViewBinding = playListFragment.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f63968e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: fl.n
            @Override // java.lang.Runnable
            public final void run() {
                PlayListFragment.O0(PlayListFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(PlayListFragment playListFragment) {
        r6.f h02;
        com.transsion.home.category.adapter.j jVar = playListFragment.mSubjectAdapter;
        if (jVar == null || (h02 = jVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(PlayListFragment playListFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            h.f(subject, "play_list_page");
            i F0 = playListFragment.F0();
            String subjectId = subject.getSubjectId();
            String ops = subject.getOps();
            Integer valueOf = Integer.valueOf(i11);
            Boolean hasResource = subject.getHasResource();
            F0.e("playlist", subjectId, ops, valueOf, hasResource != null ? hasResource.booleanValue() : false, playListFragment.mCategory, playListFragment.mRecType, playListFragment.mLabel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(PlayListFragment playListFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        Subject subject = item instanceof Subject ? (Subject) item : null;
        if (view.getId() == R$id.ll_download) {
            playListFragment.E0(subject, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(PlayListFragment playListFragment, View view) {
        FragmentActivity activity = playListFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(PlayListFragment playListFragment, t tVar, AppBarLayout appBarLayout, int i11) {
        if (playListFragment.getContext() == null) {
            return;
        }
        if (Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
            tVar.f63969f.setBackgroundColor(androidx.core.content.b.getColor(playListFragment.requireContext(), R$color.bg_01));
            tVar.f63966c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(playListFragment.requireContext(), R$color.btn_back)));
            AppCompatTextView tvTitle = tVar.f63970g;
            Intrinsics.g(tvTitle, "tvTitle");
            jg.c.k(tvTitle);
            AppCompatTextView tvTitleExpand = tVar.f63971h;
            Intrinsics.g(tvTitleExpand, "tvTitleExpand");
            jg.c.g(tvTitleExpand);
            playListFragment.D0(true);
            return;
        }
        tVar.f63969f.setBackgroundColor(androidx.core.content.b.getColor(playListFragment.requireContext(), R$color.transparent));
        tVar.f63966c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(playListFragment.requireContext(), R$color.common_white)));
        AppCompatTextView tvTitle2 = tVar.f63970g;
        Intrinsics.g(tvTitle2, "tvTitle");
        jg.c.g(tvTitle2);
        AppCompatTextView tvTitleExpand2 = tVar.f63971h;
        Intrinsics.g(tvTitleExpand2, "tvTitleExpand");
        jg.c.k(tvTitleExpand2);
        playListFragment.D0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(PlayListFragment playListFragment, PlayListResp playListResp) {
        List<Object> data;
        List<Object> data2;
        com.transsion.home.category.adapter.j jVar;
        r6.f h02;
        r6.f h03;
        com.transsion.home.category.adapter.j jVar2;
        r6.f h04;
        List<Object> data3;
        List<Object> data4;
        com.transsion.home.category.adapter.b bVar;
        r6.f h05;
        r6.f h06;
        com.transsion.home.category.adapter.b bVar2;
        r6.f h07;
        playListFragment.showContentView();
        playListFragment.Y0(playListResp);
        if (playListFragment.U0()) {
            com.transsion.home.category.adapter.b bVar3 = playListFragment.mCastAdapter;
            if (bVar3 != null && (h06 = bVar3.h0()) != null && h06.r() && (bVar2 = playListFragment.mCastAdapter) != null && (h07 = bVar2.h0()) != null) {
                h07.s();
            }
            if (playListResp != null) {
                List<Staff> staffs = playListResp.getStaffs();
                int size = staffs != null ? staffs.size() : 0;
                if (size < 4 && (bVar = playListFragment.mCastAdapter) != null && (h05 = bVar.h0()) != null) {
                    r6.f.u(h05, false, 1, null);
                }
                com.transsion.home.category.adapter.b bVar4 = playListFragment.mCastAdapter;
                if (bVar4 == null || (data4 = bVar4.getData()) == null || data4.size() != 0 || size != 0) {
                    playListFragment.Z0(playListResp);
                } else {
                    PageStatusFragment.showEmptyView$default(playListFragment, false, 1, null);
                }
                hj.b logViewConfig = playListFragment.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
            } else {
                com.transsion.home.category.adapter.b bVar5 = playListFragment.mCastAdapter;
                if (bVar5 != null && (data3 = bVar5.getData()) != null && data3.size() == 0) {
                    PageStatusFragment.showEmptyView$default(playListFragment, false, 1, null);
                }
            }
        } else {
            com.transsion.home.category.adapter.j jVar3 = playListFragment.mSubjectAdapter;
            if (jVar3 != null && (h03 = jVar3.h0()) != null && h03.r() && (jVar2 = playListFragment.mSubjectAdapter) != null && (h04 = jVar2.h0()) != null) {
                h04.s();
            }
            if (playListResp != null) {
                List<Subject> subjects = playListResp.getSubjects();
                int size2 = subjects != null ? subjects.size() : 0;
                if (size2 < 4 && (jVar = playListFragment.mSubjectAdapter) != null && (h02 = jVar.h0()) != null) {
                    r6.f.u(h02, false, 1, null);
                }
                com.transsion.home.category.adapter.j jVar4 = playListFragment.mSubjectAdapter;
                if (jVar4 == null || (data2 = jVar4.getData()) == null || data2.size() != 0 || size2 != 0) {
                    playListFragment.Z0(playListResp);
                } else {
                    PageStatusFragment.showEmptyView$default(playListFragment, false, 1, null);
                }
                hj.b logViewConfig2 = playListFragment.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.k(true);
                }
            } else {
                com.transsion.home.category.adapter.j jVar5 = playListFragment.mSubjectAdapter;
                if (jVar5 != null && (data = jVar5.getData()) != null && data.size() == 0) {
                    PageStatusFragment.showEmptyView$default(playListFragment, false, 1, null);
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U0() {
        return Intrinsics.c(this.mCategory, PlayListType.CAST.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i V0() {
        return new i();
    }

    private final void W0() {
        Function1 function1 = new Function1() { // from class: fl.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = PlayListFragment.X0(PlayListFragment.this, (AddToDownloadEvent) obj);
                return X0;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(PlayListFragment playListFragment, AddToDownloadEvent value) {
        com.transsion.home.category.adapter.j jVar;
        List<Object> data;
        Intrinsics.h(value, "value");
        try {
            com.transsion.home.category.adapter.j jVar2 = playListFragment.mSubjectAdapter;
            int i11 = -1;
            if (jVar2 != null && (data = jVar2.getData()) != null) {
                Iterator<Object> it = data.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((Subject) it.next()).getSubjectId(), value.getSubjectId())) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                }
            }
            if (i11 >= 0 && (jVar = playListFragment.mSubjectAdapter) != null) {
                jVar.notifyItemChanged(i11);
            }
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        return Unit.f67184a;
    }

    private final void Y0(PlayListResp playListResp) {
        List<Subject> subjects;
        List<Staff> staffs;
        String ops = playListResp != null ? playListResp.getOps() : null;
        JSONObject jSONObject = (ops == null || ops.length() == 0) ? new JSONObject() : new JSONObject(ops);
        jSONObject.put("rec_type", this.mRecType);
        jSONObject.put("label", this.mLabel);
        String jSONObject2 = jSONObject.toString();
        if (playListResp != null && (staffs = playListResp.getStaffs()) != null) {
            for (Staff staff : staffs) {
                String ops2 = staff.getOps();
                if (ops2 == null || ops2.length() == 0) {
                    staff.setOps(jSONObject2);
                }
            }
        }
        if (playListResp == null || (subjects = playListResp.getSubjects()) == null) {
            return;
        }
        for (Subject subject : subjects) {
            String ops3 = subject.getOps();
            if (ops3 == null || ops3.length() == 0) {
                subject.setOps(jSONObject2);
            }
        }
    }

    private final void Z0(PlayListResp playListResp) {
        t mViewBinding;
        List<Object> data;
        String str;
        Cover cover;
        String thumbnail;
        Cover cover2;
        List<Object> data2;
        List<Object> data3;
        com.transsion.home.category.adapter.j jVar;
        List<Object> data4;
        String avatarUrl;
        List<Object> data5;
        com.transsion.home.category.adapter.b bVar;
        if (getContext() == null || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        String title = playListResp.getTitle();
        if (title != null && title.length() > 0) {
            mViewBinding.f63970g.setText(playListResp.getTitle());
            mViewBinding.f63971h.setText(playListResp.getTitle());
        }
        Subject subject = null;
        r4 = null;
        Staff staff = null;
        subject = null;
        String str2 = "";
        if (U0()) {
            List<Staff> staffs = playListResp.getStaffs();
            if (staffs != null && (bVar = this.mCastAdapter) != null) {
                bVar.q(staffs);
            }
            com.transsion.home.category.adapter.b bVar2 = this.mCastAdapter;
            if (bVar2 == null || (data4 = bVar2.getData()) == null || !(!data4.isEmpty())) {
                return;
            }
            com.transsion.home.category.adapter.b bVar3 = this.mCastAdapter;
            if (bVar3 != null && (data5 = bVar3.getData()) != null) {
                staff = (Staff) data5.get(0);
            }
            f.a aVar = ej.f.f62005a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            f.b m11 = aVar.m(requireContext);
            if (staff != null && (avatarUrl = staff.getAvatarUrl()) != null) {
                str2 = avatarUrl;
            }
            f.b g11 = m11.g(str2);
            AppCompatImageView ivCover = mViewBinding.f63967d;
            Intrinsics.g(ivCover, "ivCover");
            g11.d(ivCover);
            return;
        }
        List<Subject> subjects = playListResp.getSubjects();
        if (subjects != null) {
            Boolean showRank = playListResp.getShowRank();
            com.transsion.home.category.adapter.j jVar2 = this.mSubjectAdapter;
            if (jVar2 != null && (data3 = jVar2.getData()) != null && data3.isEmpty() && showRank != null && (jVar = this.mSubjectAdapter) != null) {
                jVar.T1(showRank.booleanValue());
            }
            com.transsion.home.category.adapter.j jVar3 = this.mSubjectAdapter;
            if (jVar3 != null) {
                jVar3.q(subjects);
            }
        }
        com.transsion.home.category.adapter.j jVar4 = this.mSubjectAdapter;
        if (jVar4 == null || (data = jVar4.getData()) == null || !(!data.isEmpty())) {
            return;
        }
        com.transsion.home.category.adapter.j jVar5 = this.mSubjectAdapter;
        if (jVar5 != null && (data2 = jVar5.getData()) != null) {
            subject = (Subject) data2.get(0);
        }
        f.a aVar2 = ej.f.f62005a;
        Context requireContext2 = requireContext();
        Intrinsics.g(requireContext2, "requireContext(...)");
        f.b m12 = aVar2.m(requireContext2);
        if (subject == null || (cover2 = subject.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = "";
        }
        f.b g12 = m12.g(str);
        if (subject != null && (cover = subject.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        f.b l11 = g12.l(str2);
        AppCompatImageView ivCover2 = mViewBinding.f63967d;
        Intrinsics.g(ivCover2, "ivCover");
        l11.d(ivCover2);
    }

    private final void initAd() {
        Map a11 = com.transsion.ad.strategy.d.f42285a.a("");
        String str = this.mCategory;
        if (str != null) {
            a11.put("category", str);
        }
        BiddingListManager biddingListManager = new BiddingListManager();
        t mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f63968e : null);
        biddingListManager.A(v.a(this));
        biddingListManager.G("PlayListScene");
        biddingListManager.B(a11);
        biddingListManager.z(new Function2() { // from class: fl.s
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit H0;
                H0 = PlayListFragment.H0(PlayListFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                return H0;
            }
        });
        this.v3ListManager = biddingListManager;
    }

    private final void loadData() {
        PlayListViewModel playListViewModel = this.viewModel;
        if (playListViewModel == null) {
            Intrinsics.z("viewModel");
            playListViewModel = null;
        }
        PlayListViewModel playListViewModel2 = playListViewModel;
        String str = this.mLabel;
        if (str == null) {
            str = "";
        }
        String str2 = this.mCategory;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.mRecType;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.mTopIds;
        if (str4 == null) {
            str4 = "";
        }
        playListViewModel2.f(str, str2, str3, str4, this.mTabId);
    }

    private final void loadMore() {
        loadData();
    }

    private final void reload() {
        if (m.f70597a.e()) {
            loadDefaultData();
        } else {
            showLoadingView();
            showNoNetworkViewDelayed();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public t getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        t c11 = t.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        W0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        Toolbar toolbar;
        t mViewBinding = getMViewBinding();
        if (mViewBinding != null && (toolbar = mViewBinding.f63969f) != null) {
            jg.c.e(toolbar);
        }
        pageStateFitStatusBar();
        initAd();
        final t mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null) {
            mViewBinding2.f63966c.setOnClickListener(new View.OnClickListener() { // from class: fl.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayListFragment.R0(PlayListFragment.this, view);
                }
            });
            RecyclerView recyclerView = mViewBinding2.f63968e;
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
            hl.b bVar = new hl.b(0.6f, new b(), false, 4, null);
            bVar.l(2);
            recyclerView.addOnScrollListener(bVar);
            this.mExposureHelper = bVar;
            recyclerView.setAdapter(U0() ? I0() : M0());
            mViewBinding2.f63965b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: fl.p
                @Override // com.google.android.material.appbar.AppBarLayout.b
                public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
                    PlayListFragment.S0(PlayListFragment.this, mViewBinding2, appBarLayout, i11);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        PlayListViewModel playListViewModel = (PlayListViewModel) new v0(this).a(PlayListViewModel.class);
        this.viewModel = playListViewModel;
        PlayListViewModel playListViewModel2 = null;
        if (playListViewModel == null) {
            Intrinsics.z("viewModel");
            playListViewModel = null;
        }
        playListViewModel.i(1);
        PlayListViewModel playListViewModel3 = this.viewModel;
        if (playListViewModel3 == null) {
            Intrinsics.z("viewModel");
        } else {
            playListViewModel2 = playListViewModel3;
        }
        playListViewModel2.g().j(this, new c(new Function1() { // from class: fl.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = PlayListFragment.T0(PlayListFragment.this, (PlayListResp) obj);
                return T0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        if (m.f70597a.e()) {
            showLoadingView();
            loadData();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("playlist", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        HashMap g11;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mLabel = arguments.getString("label");
            this.mCategory = arguments.getString("category");
            this.mRecType = arguments.getString("recType");
            this.mTopIds = arguments.getString("topIds");
            this.mTabId = arguments.getInt("tabId", 0);
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
        g11.put("label", this.mLabel);
        g11.put("category", this.mCategory);
        g11.put("rec_type", this.mRecType);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        List<Object> data;
        List<Object> data2;
        if (U0()) {
            com.transsion.home.category.adapter.b bVar = this.mCastAdapter;
            if (bVar != null && (data2 = bVar.getData()) != null && data2.size() == 0) {
                reload();
                return;
            }
            com.transsion.home.category.adapter.b bVar2 = this.mCastAdapter;
            if (bVar2 == null || bVar2.h0().i() != LoadMoreStatus.Fail) {
                return;
            }
            bVar2.h0().w();
            return;
        }
        com.transsion.home.category.adapter.j jVar = this.mSubjectAdapter;
        if (jVar != null && (data = jVar.getData()) != null && data.size() == 0) {
            reload();
            return;
        }
        com.transsion.home.category.adapter.j jVar2 = this.mSubjectAdapter;
        if (jVar2 == null || jVar2.h0().i() != LoadMoreStatus.Fail) {
            return;
        }
        jVar2.h0().w();
    }
}
