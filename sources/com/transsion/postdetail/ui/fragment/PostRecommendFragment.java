package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.viewmodel.PostRecommendFragmentViewModel;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u001b\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0004J/\u0010(\u001a\u00020\u00072\u000e\u0010#\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00142\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\rJ\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\u0004J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u0004R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/PostRecommendFragment;", "Lcom/transsion/baseui/fragment/BaseListFragment;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "", "s0", "()Ljava/lang/String;", "getPageStateLayoutTitle", "", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "isShowPageStateLayoutTitle", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "m0", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "initViewData", "initListener", "initViewModel", "x0", "G0", "lazyLoadData", "retryLoadData", "loadMore", "loadDefaultData", "onDestroy", "e1", "adapter", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", RequestParameters.POSITION, "W0", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V", "getPageName", "initExposureHelper", WebConstants.FIELD_ITEM, "g1", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "initAd", "Lsj/b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lsj/b;", "exposureHelper", "Lto/a;", "c", "Lto/a;", "postListReport", "d", "I", "mTabId", "e", "mNextPage", "f", "mPerPage", be.g.f16474b, "Ljava/lang/String;", "mPostId", "Lcom/transsion/postdetail/viewmodel/PostRecommendFragmentViewModel;", "h", "Lkotlin/Lazy;", "X0", "()Lcom/transsion/postdetail/viewmodel/PostRecommendFragmentViewModel;", "mViewModel", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "i", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "middleListManager", com.mbridge.msdk.foundation.same.report.j.f35620b, "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PostRecommendFragment extends BaseListFragment<PostSubjectItem> {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private sj.b exposureHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private to.a postListReport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mTabId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mNextPage = 1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mPerPage = 8;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String mPostId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mViewModel = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.p3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PostRecommendFragmentViewModel d12;
            d12 = PostRecommendFragment.d1();
            return d12;
        }
    });

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private BiddingListManager middleListManager;

    /* renamed from: com.transsion.postdetail.ui.fragment.PostRecommendFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostRecommendFragment a(String str) {
            PostRecommendFragment postRecommendFragment = new PostRecommendFragment();
            Bundle bundle = new Bundle();
            bundle.putString("post_subject_id", str);
            postRecommendFragment.setArguments(bundle);
            return postRecommendFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements sj.a {
        b() {
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            PostRecommendFragment postRecommendFragment = PostRecommendFragment.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                if (postRecommendFragment.getMBaseAdapter() instanceof com.transsion.postdetail.ui.adapter.f) {
                    a.C0856a.f(lg.a.f68962a, sj.b.f75485j.a(), "exposure position  " + i11, false, 4, null);
                    to.a aVar = postRecommendFragment.postListReport;
                    if (aVar != null) {
                        BaseQuickAdapter mBaseAdapter = postRecommendFragment.getMBaseAdapter();
                        Intrinsics.f(mBaseAdapter, "null cannot be cast to non-null type com.transsion.postdetail.ui.adapter.PostRecommendAdapter");
                        aVar.a((com.transsion.postdetail.ui.adapter.f) mBaseAdapter, i11, j11);
                    }
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f49655a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f49655a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f49655a;
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
            this.f49655a.invoke(obj);
        }
    }

    private final void W0(BaseQuickAdapter adapter, View view, int position) {
        String str;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        Group group;
        Subject subject2;
        Subject subject3;
        String subjectId;
        Context context;
        Subject subject4;
        Subject subject5;
        ResourceDetectors resourceDetector2;
        Subject subject6;
        Object item = adapter.getItem(position);
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        DownloadManagerApi.a aVar = DownloadManagerApi.f58521j;
        DownloadManagerApi a11 = aVar.a();
        String subjectId2 = (postSubjectItem == null || (subject6 = postSubjectItem.getSubject()) == null) ? null : subject6.getSubjectId();
        String resourceId = (postSubjectItem == null || (subject5 = postSubjectItem.getSubject()) == null || (resourceDetector2 = subject5.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
        boolean z10 = false;
        if (postSubjectItem != null && (subject4 = postSubjectItem.getSubject()) != null && subject4.isSeries()) {
            z10 = true;
        }
        if (DownloadManagerApi.x0(a11, subjectId2, resourceId, z10, false, 8, null)) {
            if (postSubjectItem == null || (subject3 = postSubjectItem.getSubject()) == null || (subjectId = subject3.getSubjectId()) == null || (context = getContext()) == null) {
                return;
            }
            DownloadManagerApi.z0(aVar.a(), subjectId, context, getPageName(), null, 8, null);
            return;
        }
        if (postSubjectItem != null && (subject2 = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi a12 = aVar.a();
                Context context2 = getContext();
                Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context2;
                String pageName = getPageName();
                Group group2 = postSubjectItem.getGroup();
                a12.d0(fragmentActivity, pageName, (r22 & 4) != 0 ? "" : group2 != null ? group2.getGroupId() : null, postSubjectItem.getOps(), (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : true, (r22 & 64) != 0 ? null : postSubjectItem.getSubject(), (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        DownloadManagerApi a13 = aVar.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        Subject subject7 = postSubjectItem != null ? postSubjectItem.getSubject() : null;
        String pageName2 = getPageName();
        String groupId = (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId();
        String ops = postSubjectItem != null ? postSubjectItem.getOps() : null;
        if (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (str = resourceDetector.getResourceLink()) == null) {
            str = "";
        }
        String str2 = str;
        if (postSubjectItem != null && (user = postSubjectItem.getUser()) != null) {
            r2 = user.getNickname();
        }
        a13.K(requireActivity, subject7, pageName2, (r25 & 8) != 0 ? "" : groupId, ops, str2, (r25 & 64) != 0 ? "" : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : r2, (r25 & 512) != 0 ? false : false);
    }

    private final PostRecommendFragmentViewModel X0() {
        return (PostRecommendFragmentViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(PostRecommendFragment postRecommendFragment, int i11, BiddingNativeManager current) {
        List<Object> data;
        Intrinsics.h(current, "current");
        if (current != null) {
            PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, null, false, null, false, false, false, false, null, -1, 1, null);
            postSubjectItem.setNonAdDelegate(current);
            BaseQuickAdapter mBaseAdapter = postRecommendFragment.getMBaseAdapter();
            int size = (mBaseAdapter == null || (data = mBaseAdapter.getData()) == null) ? 0 : data.size();
            if (i11 <= size) {
                BaseQuickAdapter mBaseAdapter2 = postRecommendFragment.getMBaseAdapter();
                if (mBaseAdapter2 != null) {
                    mBaseAdapter2.n(i11, postSubjectItem);
                }
            } else {
                BaseQuickAdapter mBaseAdapter3 = postRecommendFragment.getMBaseAdapter();
                if (mBaseAdapter3 != null) {
                    mBaseAdapter3.n(size, postSubjectItem);
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(PostRecommendFragment postRecommendFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        a.C0856a.f(lg.a.f68962a, sj.b.f75485j.a(), "position " + i11, false, 4, null);
        Object item = adapter.getItem(i11);
        if (item instanceof PostSubjectItem) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) item;
            postRecommendFragment.g1(postSubjectItem);
            to.a aVar = postRecommendFragment.postListReport;
            if (aVar != null) {
                aVar.b(i11, postSubjectItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(PostRecommendFragment postRecommendFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (view.getId() == R$id.llDownload) {
            postRecommendFragment.W0(adapter, view, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        if (r3 == null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit b1(final com.transsion.postdetail.ui.fragment.PostRecommendFragment r4, com.transsion.moviedetailapi.bean.PostSubjectBean r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L14
            com.transsion.moviedetailapi.bean.Pager r1 = r5.getPager()
            if (r1 == 0) goto L14
            java.lang.Boolean r1 = r1.getHasMore()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)
            goto L15
        L14:
            r1 = r0
        L15:
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1c
            com.transsion.baseui.fragment.BaseListFragment.D0(r4, r0, r2, r3)
        L1c:
            if (r5 == 0) goto L63
            java.util.List r5 = r5.getItems()
            if (r5 == 0) goto L63
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L39
            com.transsion.baseui.fragment.BaseListFragment.D0(r4, r0, r2, r3)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L36
            com.transsion.baseui.fragment.PageStatusFragment.showEmptyView$default(r4, r0, r2, r3)
        L36:
            kotlin.Unit r4 = kotlin.Unit.f67184a
            return r4
        L39:
            com.chad.library.adapter.base.BaseQuickAdapter r0 = r4.getMBaseAdapter()
            if (r0 == 0) goto L44
            java.util.Collection r5 = (java.util.Collection) r5
            r0.q(r5)
        L44:
            g4.a r5 = r4.getMViewBinding()
            bk.b r5 = (bk.b) r5
            if (r5 == 0) goto L61
            androidx.constraintlayout.widget.ConstraintLayout r5 = r5.getRoot()
            if (r5 == 0) goto L61
            com.transsion.postdetail.ui.fragment.t3 r0 = new com.transsion.postdetail.ui.fragment.t3
            r0.<init>()
            r1 = 300(0x12c, double:1.48E-321)
            boolean r5 = r5.postDelayed(r0, r1)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)
        L61:
            if (r3 != 0) goto L68
        L63:
            r4.N0()
            kotlin.Unit r4 = kotlin.Unit.f67184a
        L68:
            kotlin.Unit r4 = kotlin.Unit.f67184a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.PostRecommendFragment.b1(com.transsion.postdetail.ui.fragment.PostRecommendFragment, com.transsion.moviedetailapi.bean.PostSubjectBean):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(PostRecommendFragment postRecommendFragment) {
        postRecommendFragment.B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostRecommendFragmentViewModel d1() {
        return new PostRecommendFragmentViewModel();
    }

    private final void e1() {
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.o3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit f12;
                    f12 = PostRecommendFragment.f1(PostRecommendFragment.this, (AddToDownloadEvent) obj);
                    return f12;
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = AddToDownloadEvent.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.observeEvent(appCompatActivity, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(PostRecommendFragment postRecommendFragment, AddToDownloadEvent value) {
        BaseQuickAdapter mBaseAdapter;
        List<Object> data;
        Intrinsics.h(value, "value");
        try {
            BaseQuickAdapter mBaseAdapter2 = postRecommendFragment.getMBaseAdapter();
            int i11 = -1;
            if (mBaseAdapter2 != null && (data = mBaseAdapter2.getData()) != null) {
                Iterator<Object> it = data.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Subject subject = ((PostSubjectItem) it.next()).getSubject();
                    if (Intrinsics.c(subject != null ? subject.getSubjectId() : null, value.getSubjectId())) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                }
            }
            if (i11 >= 0 && (mBaseAdapter = postRecommendFragment.getMBaseAdapter()) != null) {
                mBaseAdapter.notifyItemChanged(i11 + 1);
            }
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        return Unit.f67184a;
    }

    private final void g1(PostSubjectItem item) {
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_tips);
            return;
        }
        IPostDetailApi iPostDetailApi = (IPostDetailApi) TheRouter.d(IPostDetailApi.class, new Object[0]);
        if (iPostDetailApi != null) {
            iPostDetailApi.i(item);
        }
        Media media = item.getMedia();
        Navigator K = TheRouter.c(Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue()) ? "/post/detailVideo" : "/post/detail").K(WebConstants.PAGE_FROM, getPageName()).K("id", item.getPostId()).K("item_type", item.getItemType());
        Media media2 = item.getMedia();
        Navigator.x(K.K("media_type", media2 != null ? media2.getMediaType() : null).z("from_comment", false), requireContext(), null, 2, null);
    }

    private final String getPageName() {
        return "post_detail_recommend";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAd() {
        BiddingListManager biddingListManager = new BiddingListManager();
        this.middleListManager = biddingListManager;
        bk.b bVar = (bk.b) getMViewBinding();
        biddingListManager.F(bVar != null ? bVar.f16662d : null);
        BiddingListManager biddingListManager2 = this.middleListManager;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.view.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.middleListManager;
        if (biddingListManager3 != null) {
            biddingListManager3.G("PostDetailRecommendScene");
        }
        BiddingListManager biddingListManager4 = this.middleListManager;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2() { // from class: com.transsion.postdetail.ui.fragment.q3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Y0;
                    Y0 = PostRecommendFragment.Y0(PostRecommendFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                    return Y0;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initExposureHelper() {
        bk.b bVar;
        RecyclerView recyclerView;
        this.postListReport = new to.a("post_recommend", this.mPostId);
        sj.b bVar2 = new sj.b(0.6f, new b(), false, 4, null);
        this.exposureHelper = bVar2;
        bVar2.n(2);
        sj.b bVar3 = this.exposureHelper;
        if (bVar3 == null || (bVar = (bk.b) getMViewBinding()) == null || (recyclerView = bVar.f16662d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(bVar3);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void G0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        e1();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        super.initViewData();
        n0();
        u0();
        initAd();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        X0().h().j(this, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.n3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit b12;
                b12 = PostRecommendFragment.b1(PostRecommendFragment.this, (PostSubjectBean) obj);
                return b12;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        X0().g(this.mPostId, this.mTabId, this.mNextPage, this.mPerPage);
        this.mNextPage++;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void loadMore() {
        loadDefaultData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter m0() {
        return new com.transsion.postdetail.ui.adapter.f(new ArrayList(), this.exposureHelper);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Object m1185constructorimpl;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                String string = arguments.getString("post_subject_id");
                if (string == null) {
                    string = "";
                }
                this.mPostId = string;
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
        initExposureHelper();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.middleListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
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
    public void retryLoadData() {
        F0();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String s0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void x0() {
        RecyclerView recyclerView;
        super.x0();
        BaseQuickAdapter mBaseAdapter = getMBaseAdapter();
        if (mBaseAdapter != null) {
            View inflate = LayoutInflater.from(requireActivity()).inflate(R$layout.item_provider_post_recommend_for_you, (ViewGroup) null);
            Intrinsics.e(inflate);
            BaseQuickAdapter.y(mBaseAdapter, inflate, 0, 0, 6, null);
            mBaseAdapter.X0(R$layout.item_recommend_empty_layout);
            mBaseAdapter.w1(new p6.d() { // from class: com.transsion.postdetail.ui.fragment.r3
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    PostRecommendFragment.Z0(PostRecommendFragment.this, baseQuickAdapter, view, i11);
                }
            });
            mBaseAdapter.l(R$id.llDownload);
            mBaseAdapter.s1(new p6.b() { // from class: com.transsion.postdetail.ui.fragment.s3
                @Override // p6.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    PostRecommendFragment.a1(PostRecommendFragment.this, baseQuickAdapter, view, i11);
                }
            });
        }
        bk.b bVar = (bk.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.f16662d) == null) {
            return;
        }
        recyclerView.addItemDecoration(new ig.i(com.blankj.utilcode.util.a0.a(16.0f), 0, 2, null));
    }
}
