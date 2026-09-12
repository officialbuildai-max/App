package com.transsion.ugcvideodetail.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.hepler.UGCVideoPlayFrom;
import com.transsion.ugcvideodetail.viewmodel.UGCLocalVideoDetailViewModel;
import com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u000107068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/transsion/ugcvideodetail/fragment/UGCVideoDialogPlayListTabFragment;", "Lcom/transsion/play/detail/fragment/BaseBottomDialogFragment;", "Lqv/k;", "<init>", "()V", "", "B0", "", "totalCount", "I0", "(I)V", "tabIndex", "F0", "z0", "Landroid/view/LayoutInflater;", "inflater", "x0", "(Landroid/view/LayoutInflater;)Lqv/k;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "receiveArguments", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lcom/transsion/ugcvideodetail/viewmodel/UGCVideoDetailViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "y0", "()Lcom/transsion/ugcvideodetail/viewmodel/UGCVideoDetailViewModel;", "viewModel", "Lcom/transsion/ugcvideodetail/viewmodel/UGCLocalVideoDetailViewModel;", "c", "w0", "()Lcom/transsion/ugcvideodetail/viewmodel/UGCLocalVideoDetailViewModel;", "localViewModel", "Lcom/transsion/ugcvideodetail/adapter/h;", "d", "Lcom/transsion/ugcvideodetail/adapter/h;", "tabAdapter", "e", "I", "selectedTabIndex", "", "f", "Z", "isTabsInitialized", be.g.f16474b, "hasScrolledToCurrentVideo", "Lcom/transsion/ugcvideodetail/hepler/UGCVideoPlayFrom;", "h", "Lcom/transsion/ugcvideodetail/hepler/UGCVideoPlayFrom;", "videoPlayFrom", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "i", "Ljava/util/List;", "localPlayList", com.mbridge.msdk.foundation.same.report.j.f35620b, "a", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UGCVideoDialogPlayListTabFragment extends BaseBottomDialogFragment<qv.k> {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ugcvideodetail.adapter.h tabAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int selectedTabIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isTabsInitialized;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasScrolledToCurrentVideo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCVideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListTabFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListTabFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy localViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCLocalVideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListTabFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListTabFragment$special$$inlined$activityViewModels$default$4
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

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private UGCVideoPlayFrom videoPlayFrom = UGCVideoPlayFrom.ON_LINE_VIDEO;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List localPlayList = new ArrayList();

    /* renamed from: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListTabFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCVideoDialogPlayListTabFragment a() {
            return new UGCVideoDialogPlayListTabFragment();
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56317a;

        static {
            int[] iArr = new int[UGCVideoPlayFrom.values().length];
            try {
                iArr[UGCVideoPlayFrom.ON_LINE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UGCVideoPlayFrom.LOCAL_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f56317a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends RecyclerView.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f56318a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f56319b;

        c(int i11, int i12) {
            this.f56318a = i11;
            this.f56319b = i12;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            int itemCount = (adapter != null ? adapter.getItemCount() : 0) - 1;
            if (childAdapterPosition == 0) {
                outRect.left = this.f56318a;
                outRect.right = this.f56319b;
            } else if (childAdapterPosition == itemCount) {
                outRect.left = this.f56319b;
                outRect.right = this.f56318a;
            } else {
                int i11 = this.f56319b;
                outRect.left = i11;
                outRect.right = i11;
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f56320a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f56320a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f56320a;
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
            this.f56320a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(UGCVideoDialogPlayListTabFragment uGCVideoDialogPlayListTabFragment, View view) {
        BaseBottomDialogFragment.m0(uGCVideoDialogPlayListTabFragment, false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B0() {
        RecyclerView recyclerView;
        com.transsion.ugcvideodetail.adapter.h hVar = new com.transsion.ugcvideodetail.adapter.h(null, 1, null);
        hVar.w1(new p6.d() { // from class: com.transsion.ugcvideodetail.fragment.q1
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCVideoDialogPlayListTabFragment.C0(UGCVideoDialogPlayListTabFragment.this, baseQuickAdapter, view, i11);
            }
        });
        this.tabAdapter = hVar;
        qv.k kVar = (qv.k) getMViewBinding();
        if (kVar == null || (recyclerView = kVar.f73916e) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(this.tabAdapter);
        recyclerView.addItemDecoration(new c(dk.a.b(12), dk.a.b(8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(UGCVideoDialogPlayListTabFragment uGCVideoDialogPlayListTabFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L)) {
            return;
        }
        uGCVideoDialogPlayListTabFragment.selectedTabIndex = i11;
        com.transsion.ugcvideodetail.adapter.h hVar = uGCVideoDialogPlayListTabFragment.tabAdapter;
        if (hVar != null) {
            hVar.D1(i11);
        }
        uGCVideoDialogPlayListTabFragment.F0(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(UGCVideoDialogPlayListTabFragment uGCVideoDialogPlayListTabFragment, Integer num) {
        uGCVideoDialogPlayListTabFragment.I0(num != null ? num.intValue() : 0);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(UGCVideoDialogPlayListTabFragment uGCVideoDialogPlayListTabFragment, List list) {
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            uGCVideoDialogPlayListTabFragment.localPlayList = list;
            uGCVideoDialogPlayListTabFragment.I0(list.size());
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r7v17, types: [com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListFragment, T] */
    private final void F0(int tabIndex) {
        View view;
        int intValue;
        String str = "PlayListTabFragment_" + tabIndex;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? k02 = getChildFragmentManager().k0(str);
        objectRef.element = k02;
        if (k02 == 0) {
            int i11 = b.f56317a[this.videoPlayFrom.ordinal()];
            if (i11 == 1) {
                Integer num = (Integer) y0().N().f();
                intValue = num != null ? num.intValue() : 0;
            } else {
                if (i11 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                intValue = this.localPlayList.size();
            }
            objectRef.element = UGCVideoDialogPlayListFragment.INSTANCE.a(tabIndex, (tabIndex * 50) + 1, Math.min((tabIndex + 1) * 50, intValue), this.videoPlayFrom);
        }
        z0();
        if (((Fragment) objectRef.element).isAdded()) {
            getChildFragmentManager().p().y((Fragment) objectRef.element).l();
        } else {
            getChildFragmentManager().p().c(R$id.fragmentContainer, (Fragment) objectRef.element, str).l();
        }
        if (this.videoPlayFrom == UGCVideoPlayFrom.ON_LINE_VIDEO && (objectRef.element instanceof UGCVideoDialogPlayListFragment)) {
            View view2 = getView();
            if (view2 != null) {
                view2.post(new Runnable() { // from class: com.transsion.ugcvideodetail.fragment.v1
                    @Override // java.lang.Runnable
                    public final void run() {
                        UGCVideoDialogPlayListTabFragment.G0(Ref.ObjectRef.this);
                    }
                });
                return;
            }
            return;
        }
        if (!(objectRef.element instanceof UGCVideoDialogPlayListFragment) || (view = getView()) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.transsion.ugcvideodetail.fragment.w1
            @Override // java.lang.Runnable
            public final void run() {
                UGCVideoDialogPlayListTabFragment.H0(Ref.ObjectRef.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G0(Ref.ObjectRef objectRef) {
        ((UGCVideoDialogPlayListFragment) objectRef.element).s0();
        ((UGCVideoDialogPlayListFragment) objectRef.element).K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void H0(Ref.ObjectRef objectRef) {
        ((UGCVideoDialogPlayListFragment) objectRef.element).K0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0215, code lost:
    
        if ((r0 >= 0 && r0 < r11) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0198, code lost:
    
        if ((r0 >= 0 && r0 < r11) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x019a, code lost:
    
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x019d, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v61, types: [com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListFragment, T] */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, androidx.fragment.app.Fragment] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void I0(int r11) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.fragment.UGCVideoDialogPlayListTabFragment.I0(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void J0(Ref.ObjectRef objectRef) {
        ((UGCVideoDialogPlayListFragment) objectRef.element).s0();
        ((UGCVideoDialogPlayListFragment) objectRef.element).K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void K0(Ref.ObjectRef objectRef) {
        ((UGCVideoDialogPlayListFragment) objectRef.element).K0();
    }

    private final UGCLocalVideoDetailViewModel w0() {
        return (UGCLocalVideoDetailViewModel) this.localViewModel.getValue();
    }

    private final UGCVideoDetailViewModel y0() {
        return (UGCVideoDetailViewModel) this.viewModel.getValue();
    }

    private final void z0() {
        List<Fragment> y02 = getChildFragmentManager().y0();
        Intrinsics.g(y02, "getFragments(...)");
        for (Fragment fragment : y02) {
            if (fragment instanceof UGCVideoDialogPlayListFragment) {
                getChildFragmentManager().p().p(fragment).l();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        qv.k kVar = (qv.k) getMViewBinding();
        if (kVar == null || (appCompatImageView = kVar.f73915d) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ugcvideodetail.fragment.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCVideoDialogPlayListTabFragment.A0(UGCVideoDialogPlayListTabFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        B0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        int i11 = b.f56317a[this.videoPlayFrom.ordinal()];
        if (i11 == 1) {
            y0().N().j(this, new d(new Function1() { // from class: com.transsion.ugcvideodetail.fragment.r1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit D0;
                    D0 = UGCVideoDialogPlayListTabFragment.D0(UGCVideoDialogPlayListTabFragment.this, (Integer) obj);
                    return D0;
                }
            }));
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            w0().k().j(this, new d(new Function1() { // from class: com.transsion.ugcvideodetail.fragment.s1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit E0;
                    E0 = UGCVideoDialogPlayListTabFragment.E0(UGCVideoDialogPlayListTabFragment.this, (List) obj);
                    return E0;
                }
            }));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        super.receiveArguments();
        Bundle arguments = getArguments();
        int i11 = arguments != null ? arguments.getInt("VIDEO_FROM") : UGCVideoPlayFrom.ON_LINE_VIDEO.getValue();
        UGCVideoPlayFrom uGCVideoPlayFrom = UGCVideoPlayFrom.ON_LINE_VIDEO;
        if (i11 != uGCVideoPlayFrom.getValue()) {
            uGCVideoPlayFrom = UGCVideoPlayFrom.LOCAL_VIDEO;
        }
        this.videoPlayFrom = uGCVideoPlayFrom;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public qv.k getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qv.k c11 = qv.k.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
