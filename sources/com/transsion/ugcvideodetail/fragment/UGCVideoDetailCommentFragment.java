package com.transsion.ugcvideodetail.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.InterfaceC1015e;
import androidx.view.v0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.postdetailapi.CommentTopicType;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDetailParams;
import com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010(R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\r¨\u00069"}, d2 = {"Lcom/transsion/ugcvideodetail/fragment/UGCVideoDetailCommentFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lqv/d;", "<init>", "()V", "", "m0", "Landroid/view/LayoutInflater;", "inflater", "p0", "(Landroid/view/LayoutInflater;)Lqv/d;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "", "isShowPageStateLayoutTitle", "()Z", "receiveArguments", "initViewData", "initViewModel", "initListener", "retryLoadData", "onDestroyView", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "hidden", "onHiddenChanged", "(Z)V", "Lcom/transsion/ugcvideodetail/viewmodel/UGCVideoDetailViewModel;", "a", "Lkotlin/Lazy;", "n0", "()Lcom/transsion/ugcvideodetail/viewmodel/UGCVideoDetailViewModel;", "mViewModel", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoDetailParams;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoDetailParams;", "videoParams", "c", "Ljava/lang/String;", "pageName", "d", "pageFrom", "e", "fromOptId", "Landroidx/fragment/app/Fragment;", "f", "Landroidx/fragment/app/Fragment;", "commentFragment", "", be.g.f16474b, "J", "pageLoadStartTime", "o0", "ugcVideoId", "h", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UGCVideoDetailCommentFragment extends PageStatusFragment<qv.d> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCVideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDetailCommentFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDetailCommentFragment$special$$inlined$activityViewModels$default$2
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
    private UGCVideoDetailParams videoParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String pageFrom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String fromOptId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Fragment commentFragment;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long pageLoadStartTime;

    /* renamed from: com.transsion.ugcvideodetail.fragment.UGCVideoDetailCommentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCVideoDetailCommentFragment a() {
            return new UGCVideoDetailCommentFragment();
        }
    }

    /* loaded from: classes6.dex */
    static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f56263a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f56263a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f56263a;
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
            this.f56263a.invoke(obj);
        }
    }

    private final void m0() {
        HashMap g11;
        if (this.pageLoadStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.pageLoadStartTime;
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
                return;
            }
        }
    }

    private final UGCVideoDetailViewModel n0() {
        return (UGCVideoDetailViewModel) this.mViewModel.getValue();
    }

    private final String o0() {
        UGCVideoDetailParams uGCVideoDetailParams = this.videoParams;
        if (uGCVideoDetailParams != null) {
            return uGCVideoDetailParams.getUgcVideoId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(UGCVideoDetailCommentFragment uGCVideoDetailCommentFragment, View view) {
        InterfaceC1015e interfaceC1015e = uGCVideoDetailCommentFragment.commentFragment;
        ep.a aVar = interfaceC1015e instanceof ep.a ? (ep.a) interfaceC1015e : null;
        if (aVar != null) {
            aVar.s(view);
            aVar.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(UGCVideoDetailCommentFragment uGCVideoDetailCommentFragment, Long l11) {
        InterfaceC1015e interfaceC1015e = uGCVideoDetailCommentFragment.commentFragment;
        ep.a aVar = interfaceC1015e instanceof ep.a ? (ep.a) interfaceC1015e : null;
        if (aVar != null) {
            Intrinsics.e(l11);
            aVar.updateCommentCount(l11.longValue());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(UGCVideoDetailCommentFragment uGCVideoDetailCommentFragment, boolean z10) {
        if (z10) {
            uGCVideoDetailCommentFragment.m0();
            hj.b logViewConfig = uGCVideoDetailCommentFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
        }
        return Unit.f67184a;
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
        Fragment fragment;
        hj.b logViewConfig;
        HashMap g11;
        hj.b logViewConfig2;
        HashMap g12;
        HashMap g13;
        hj.b logViewConfig3;
        HashMap g14;
        HashMap g15;
        HashMap g16;
        String subjectId;
        HashMap g17;
        String str;
        HashMap g18;
        HashMap g19;
        HashMap g20;
        AppCompatTextView appCompatTextView;
        String o02 = o0();
        if (o02 == null) {
            o02 = (String) n0().D().f();
        }
        String str2 = o02;
        Fragment parentFragment = getParentFragment();
        UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment = parentFragment instanceof UGCVideoDetailBaseFragment ? (UGCVideoDetailBaseFragment) parentFragment : null;
        IPostDetailApi iPostDetailApi = (IPostDetailApi) TheRouter.d(IPostDetailApi.class, new Object[0]);
        if (iPostDetailApi != null) {
            String value = CommentTopicType.UGC_VIDEO.getValue();
            Long l11 = (Long) n0().A().f();
            long longValue = l11 != null ? l11.longValue() : 0L;
            String trackId = uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getTrackId() : null;
            String previousTrackId = uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getPreviousTrackId() : null;
            String previousPageVideoId = uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getPreviousPageVideoId() : null;
            String str3 = this.pageName;
            UGCVideoDetailParams uGCVideoDetailParams = this.videoParams;
            fragment = iPostDetailApi.f(str2, value, longValue, true, true, "", null, trackId, previousTrackId, previousPageVideoId, str2, str3, uGCVideoDetailParams != null ? uGCVideoDetailParams.getCollectionId() : null);
        } else {
            fragment = null;
        }
        this.commentFragment = fragment;
        if (fragment != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            androidx.fragment.app.w p11 = childFragmentManager.p();
            Intrinsics.g(p11, "beginTransaction()");
            p11.s(R$id.fl_comment_container, fragment);
            p11.i();
        }
        qv.d mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.f73844c) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ugcvideodetail.fragment.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UGCVideoDetailCommentFragment.q0(UGCVideoDetailCommentFragment.this, view);
                }
            });
        }
        n0().A().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.ugcvideodetail.fragment.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r02;
                r02 = UGCVideoDetailCommentFragment.r0(UGCVideoDetailCommentFragment.this, (Long) obj);
                return r02;
            }
        }));
        InterfaceC1015e interfaceC1015e = this.commentFragment;
        ep.a aVar = interfaceC1015e instanceof ep.a ? (ep.a) interfaceC1015e : null;
        if (aVar != null) {
            aVar.f(new Function1() { // from class: com.transsion.ugcvideodetail.fragment.m0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s02;
                    s02 = UGCVideoDetailCommentFragment.s0(UGCVideoDetailCommentFragment.this, ((Boolean) obj).booleanValue());
                    return s02;
                }
            });
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g20 = logViewConfig4.g()) != null) {
        }
        hj.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null && (g19 = logViewConfig5.g()) != null) {
            UGCVideoDetailParams uGCVideoDetailParams2 = this.videoParams;
        }
        hj.b logViewConfig6 = getLogViewConfig();
        String str4 = "";
        if (logViewConfig6 != null && (g18 = logViewConfig6.g()) != null) {
            String o03 = o0();
            if (o03 == null) {
                o03 = "";
            }
        }
        hj.b logViewConfig7 = getLogViewConfig();
        if (logViewConfig7 != null && (g17 = logViewConfig7.g()) != null) {
            UGCVideoDetailParams uGCVideoDetailParams3 = this.videoParams;
            if (uGCVideoDetailParams3 == null || (str = uGCVideoDetailParams3.getCollectionId()) == null) {
                str = "";
            }
        }
        hj.b logViewConfig8 = getLogViewConfig();
        if (logViewConfig8 != null && (g16 = logViewConfig8.g()) != null) {
            UGCVideoDetailParams uGCVideoDetailParams4 = this.videoParams;
            if (uGCVideoDetailParams4 != null && (subjectId = uGCVideoDetailParams4.getSubjectId()) != null) {
                str4 = subjectId;
            }
        }
        hj.b logViewConfig9 = getLogViewConfig();
        if (logViewConfig9 != null && (g15 = logViewConfig9.g()) != null) {
        }
        String str5 = this.fromOptId;
        if (str5 != null && (logViewConfig3 = getLogViewConfig()) != null && (g14 = logViewConfig3.g()) != null) {
        }
        UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment2 = uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment : null;
        if (uGCVideoDetailBaseFragment2 != null) {
            hj.b logViewConfig10 = getLogViewConfig();
            if (logViewConfig10 != null && (g13 = logViewConfig10.g()) != null) {
            }
            String previousTrackId2 = uGCVideoDetailBaseFragment2.getPreviousTrackId();
            if (previousTrackId2 != null && (logViewConfig2 = getLogViewConfig()) != null && (g12 = logViewConfig2.g()) != null) {
            }
            String previousPageVideoId2 = uGCVideoDetailBaseFragment2.getPreviousPageVideoId();
            if (previousPageVideoId2 == null || (logViewConfig = getLogViewConfig()) == null || (g11 = logViewConfig.g()) == null) {
                return;
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        String str = this.pageName;
        if (str == null) {
            str = "/ugc_video/detail";
        }
        return new hj.b(str, false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.commentFragment = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public qv.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qv.d c11 = qv.d.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        this.pageLoadStartTime = System.currentTimeMillis();
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("video_params") : null;
        this.videoParams = serializable instanceof UGCVideoDetailParams ? (UGCVideoDetailParams) serializable : null;
        Bundle arguments2 = getArguments();
        this.pageName = arguments2 != null ? arguments2.getString("page_name") : null;
        Bundle arguments3 = getArguments();
        this.pageFrom = arguments3 != null ? arguments3.getString(WebConstants.PAGE_FROM) : null;
        Bundle arguments4 = getArguments();
        this.fromOptId = arguments4 != null ? arguments4.getString("from_opt_id") : null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }
}
