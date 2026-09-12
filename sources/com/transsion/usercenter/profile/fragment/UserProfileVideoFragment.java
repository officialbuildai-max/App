package com.transsion.usercenter.profile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.c0;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.profile.viewmodel.UserProfileVideoViewModel;
import com.transsion.web.api.WebConstants;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import fw.s0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
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

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010(R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/transsion/usercenter/profile/fragment/UserProfileVideoFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lfw/s0;", "<init>", "()V", "", "u0", "r0", "n0", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "video", "l0", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "Landroid/view/View;", "j0", "()Landroid/view/View;", "Landroid/view/LayoutInflater;", "inflater", "k0", "(Landroid/view/LayoutInflater;)Lfw/s0;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "onPause", "Lcom/transsion/usercenter/profile/adapter/c;", "a", "Lcom/transsion/usercenter/profile/adapter/c;", "mAdapter", "Lcom/transsion/usercenter/profile/viewmodel/UserProfileVideoViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "i0", "()Lcom/transsion/usercenter/profile/viewmodel/UserProfileVideoViewModel;", "mViewModel", "", "c", "Z", "isPendingRefresh", "", "d", "J", "firstLoadStartTimeMillis", "e", "hasRecordedFirstLoadDuration", "Lcom/transsion/usercenter/profile/fragment/UserProfileVideoFragment$b;", "f", "Lcom/transsion/usercenter/profile/fragment/UserProfileVideoFragment$b;", "getLoadDurationCallback", "()Lcom/transsion/usercenter/profile/fragment/UserProfileVideoFragment$b;", "m0", "(Lcom/transsion/usercenter/profile/fragment/UserProfileVideoFragment$b;)V", "loadDurationCallback", "Lsj/b;", be.g.f16474b, "Lsj/b;", "exposureHelper", "", "h", "Ljava/lang/String;", "targetUserId", "i", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UserProfileVideoFragment extends BaseFragment<s0> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.transsion.usercenter.profile.adapter.c mAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy mViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isPendingRefresh;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasRecordedFirstLoadDuration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b loadDurationCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private sj.b exposureHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String targetUserId;

    /* renamed from: com.transsion.usercenter.profile.fragment.UserProfileVideoFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserProfileVideoFragment a(String str) {
            UserProfileVideoFragment userProfileVideoFragment = new UserProfileVideoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("userId", str);
            userProfileVideoFragment.setArguments(bundle);
            return userProfileVideoFragment;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(Long l11, String str, UGCVideo uGCVideo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57309a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57309a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57309a;
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
            this.f57309a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements sj.a {
        d() {
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            UGCVideo uGCVideo;
            String str;
            UserInfo i12;
            com.transsion.usercenter.profile.adapter.c cVar = UserProfileVideoFragment.this.mAdapter;
            if (cVar == null || (uGCVideo = (UGCVideo) CollectionsKt.l0(cVar.getData(), i11)) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("browse_duration", String.valueOf(j11));
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            hashMap.put("page_tab_name", UserProfileVideoFragment.this.getString(R$string.profile_video));
            UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
            if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
                str = "";
            }
            hashMap.put("belong_to_collection_id", str);
            String ugcVideoId = uGCVideo.getUgcVideoId();
            if (ugcVideoId == null) {
                ugcVideoId = "";
            }
            hashMap.put("content_id", ugcVideoId);
            String subjectId = uGCVideo.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            hashMap.put("refer_subject_id", subjectId);
            hashMap.put("content_type", "ugc_video");
            String ops = uGCVideo.getOps();
            hashMap.put("ops", ops != null ? ops : "");
            String str2 = UserProfileVideoFragment.this.targetUserId;
            ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
            hashMap.put("uploader_type", Intrinsics.c(str2, (iLoginApi == null || (i12 = iLoginApi.i()) == null) ? null : i12.getUserId()) ? "me" : "others");
            com.transsion.baselib.helper.a.f43316a.e("Userpage", hashMap);
        }
    }

    public UserProfileVideoFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.profile.fragment.UserProfileVideoFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UserProfileVideoViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.profile.fragment.UserProfileVideoFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.profile.fragment.UserProfileVideoFragment$special$$inlined$viewModels$default$3
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
        this.targetUserId = "";
    }

    private final UserProfileVideoViewModel i0() {
        return (UserProfileVideoViewModel) this.mViewModel.getValue();
    }

    private final View j0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(2, 1, false, "", "");
        return stateView;
    }

    private final void l0(UGCVideo video) {
        lg.a.f68962a.c("Userpage", "click item id=" + video.getUgcVideoId(), false);
        ov.c.i(video, null, null, 3, null);
    }

    private final void n0() {
        i0().q().j(this, new c(new Function1() { // from class: com.transsion.usercenter.profile.fragment.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q02;
                q02 = UserProfileVideoFragment.q0(UserProfileVideoFragment.this, (UGCVideoList) obj);
                return q02;
            }
        }));
        i0().s().j(this, new c(new Function1() { // from class: com.transsion.usercenter.profile.fragment.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o02;
                o02 = UserProfileVideoFragment.o0(UserProfileVideoFragment.this, (Boolean) obj);
                return o02;
            }
        }));
        i0().p().j(this, new c(new Function1() { // from class: com.transsion.usercenter.profile.fragment.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p02;
                p02 = UserProfileVideoFragment.p0(UserProfileVideoFragment.this, (String) obj);
                return p02;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(UserProfileVideoFragment userProfileVideoFragment, Boolean bool) {
        SwipeRefreshLayout swipeRefreshLayout;
        s0 mViewBinding = userProfileVideoFragment.getMViewBinding();
        if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f63024c) != null) {
            swipeRefreshLayout.setRefreshing(Intrinsics.c(bool, Boolean.TRUE));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(UserProfileVideoFragment userProfileVideoFragment, String str) {
        com.transsion.usercenter.profile.adapter.c cVar;
        r6.f h02;
        if (str != null && (cVar = userProfileVideoFragment.mAdapter) != null && (h02 = cVar.h0()) != null) {
            h02.v();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(UserProfileVideoFragment userProfileVideoFragment, UGCVideoList uGCVideoList) {
        List<UGCVideo> l11;
        String str;
        List<UGCVideo> items;
        List<UGCVideo> items2;
        UGCVideo uGCVideo;
        Pager pager;
        com.transsion.usercenter.profile.adapter.c cVar = userProfileVideoFragment.mAdapter;
        if (cVar == null) {
            return Unit.f67184a;
        }
        if (uGCVideoList == null || (l11 = uGCVideoList.getItems()) == null) {
            l11 = CollectionsKt.l();
        }
        boolean c11 = (uGCVideoList == null || (pager = uGCVideoList.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.TRUE);
        boolean isEmpty = cVar.getData().isEmpty();
        if (userProfileVideoFragment.isPendingRefresh && isEmpty && !userProfileVideoFragment.hasRecordedFirstLoadDuration && userProfileVideoFragment.firstLoadStartTimeMillis > 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis() - userProfileVideoFragment.firstLoadStartTimeMillis);
            userProfileVideoFragment.hasRecordedFirstLoadDuration = true;
            userProfileVideoFragment.firstLoadStartTimeMillis = 0L;
            if (uGCVideoList == null || (items2 = uGCVideoList.getItems()) == null || (uGCVideo = (UGCVideo) CollectionsKt.k0(items2)) == null || (str = uGCVideo.getOps()) == null) {
                str = "";
            }
            b bVar = userProfileVideoFragment.loadDurationCallback;
            if (bVar != null) {
                bVar.a(valueOf, str, (uGCVideoList == null || (items = uGCVideoList.getItems()) == null) ? null : (UGCVideo) CollectionsKt.k0(items));
            }
        }
        if (userProfileVideoFragment.isPendingRefresh) {
            if (!l11.isEmpty()) {
                cVar.n1(l11);
            } else if (cVar.getData().isEmpty()) {
                cVar.n1(null);
                cVar.Y0(userProfileVideoFragment.j0());
            }
            userProfileVideoFragment.isPendingRefresh = false;
        } else {
            List<UGCVideo> list = l11;
            if (!list.isEmpty()) {
                cVar.q(list);
            }
        }
        if (c11) {
            cVar.h0().s();
        } else {
            r6.f.u(cVar.h0(), false, 1, null);
        }
        return Unit.f67184a;
    }

    private final void r0() {
        RecyclerView recyclerView;
        s0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f63023b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 1, false));
        sj.b bVar = new sj.b(0.6f, new d(), false, 4, null);
        bVar.n(2);
        this.exposureHelper = bVar;
        final com.transsion.usercenter.profile.adapter.c cVar = new com.transsion.usercenter.profile.adapter.c(new ArrayList(), this.exposureHelper);
        cVar.w1(new p6.d() { // from class: com.transsion.usercenter.profile.fragment.w
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UserProfileVideoFragment.s0(com.transsion.usercenter.profile.adapter.c.this, this, baseQuickAdapter, view, i11);
            }
        });
        cVar.h0().y(true);
        cVar.h0().E(2);
        cVar.h0().D(new p6.f() { // from class: com.transsion.usercenter.profile.fragment.x
            @Override // p6.f
            public final void a() {
                UserProfileVideoFragment.t0(UserProfileVideoFragment.this);
            }
        });
        this.mAdapter = cVar;
        recyclerView.setAdapter(cVar);
        sj.b bVar2 = this.exposureHelper;
        if (bVar2 != null) {
            recyclerView.addOnScrollListener(bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(com.transsion.usercenter.profile.adapter.c cVar, UserProfileVideoFragment userProfileVideoFragment, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        String str;
        UserInfo i12;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        UGCVideo uGCVideo = (UGCVideo) CollectionsKt.l0(cVar.getData(), i11);
        if (uGCVideo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            hashMap.put("page_tab_name", userProfileVideoFragment.getString(R$string.profile_video));
            UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
            if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
                str = "";
            }
            hashMap.put("belong_to_collection_id", str);
            String ugcVideoId = uGCVideo.getUgcVideoId();
            if (ugcVideoId == null) {
                ugcVideoId = "";
            }
            hashMap.put("content_id", ugcVideoId);
            String subjectId = uGCVideo.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            hashMap.put("refer_subject_id", subjectId);
            hashMap.put("content_type", "ugc_video");
            String ops = uGCVideo.getOps();
            hashMap.put("ops", ops != null ? ops : "");
            hashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            String str2 = userProfileVideoFragment.targetUserId;
            ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
            hashMap.put("uploader_type", Intrinsics.c(str2, (iLoginApi == null || (i12 = iLoginApi.i()) == null) ? null : i12.getUserId()) ? "me" : "others");
            com.transsion.baselib.helper.a.f43316a.f("Userpage", hashMap);
            userProfileVideoFragment.l0(uGCVideo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(UserProfileVideoFragment userProfileVideoFragment) {
        lg.a.f68962a.c("Userpage", "onLoadMore", false);
        userProfileVideoFragment.isPendingRefresh = false;
        userProfileVideoFragment.i0().u();
    }

    private final void u0() {
        SwipeRefreshLayout swipeRefreshLayout;
        s0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (swipeRefreshLayout = mViewBinding.f63024c) == null) {
            return;
        }
        Context context = swipeRefreshLayout.getContext();
        if (context != null) {
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(context, R$color.bg_01));
            swipeRefreshLayout.setColorSchemeColors(androidx.core.content.b.getColor(context, R$color.main_gradient_center), androidx.core.content.b.getColor(context, R$color.main_gradient_start));
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.usercenter.profile.fragment.y
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                UserProfileVideoFragment.v0(UserProfileVideoFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(UserProfileVideoFragment userProfileVideoFragment) {
        lg.a.f68962a.c("Userpage", "onRefresh", false);
        if (!userProfileVideoFragment.hasRecordedFirstLoadDuration && userProfileVideoFragment.firstLoadStartTimeMillis == 0) {
            userProfileVideoFragment.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        sj.b bVar = userProfileVideoFragment.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
        userProfileVideoFragment.isPendingRefresh = true;
        userProfileVideoFragment.i0().w();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        String str;
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("userId")) == null) {
            str = "";
        }
        this.targetUserId = str;
        i0().t(this.targetUserId);
        n0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        u0();
        r0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public s0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        s0 c11 = s0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        lg.a.f68962a.c("Userpage", "lazyLoadData -> refresh", false);
        if (!this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        sj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
        this.isPendingRefresh = true;
        i0().w();
    }

    public final void m0(b bVar) {
        this.loadDurationCallback = bVar;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }
}
