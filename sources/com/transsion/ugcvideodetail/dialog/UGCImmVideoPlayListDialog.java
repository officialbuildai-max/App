package com.transsion.ugcvideodetail.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import androidx.view.x0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.transsion.baseui.dialog.BaseViewBindingDialog;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.fragment.UGCImmVideoDialogPlayListFragment;
import com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel;
import com.transsnet.downloader.R$style;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import lg.a;
import qv.k;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010'R\"\u00103\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010+\u001a\u0004\b3\u00104\"\u0004\b5\u00106R.\u0010<\u001a\u001c\u0012\u0004\u0012\u000208\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/transsion/ugcvideodetail/dialog/UGCImmVideoPlayListDialog;", "Lcom/transsion/baseui/dialog/BaseViewBindingDialog;", "Lqv/k;", "<init>", "()V", "", "u0", "()I", "", "w0", "initViewData", "totalCount", "B0", "(I)V", "tabIndex", "z0", "v0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/transsion/ugcvideodetail/viewmodel/UGCImmVideoDetailViewModel;", "d", "Lkotlin/Lazy;", "t0", "()Lcom/transsion/ugcvideodetail/viewmodel/UGCImmVideoDetailViewModel;", "detailViewModel", "Lcom/transsion/ugcvideodetail/adapter/h;", "e", "Lcom/transsion/ugcvideodetail/adapter/h;", "tabAdapter", "f", "I", "selectedTabIndex", "", be.g.f16474b, "Z", "isTabsInitialized", "Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;", "h", "Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;", "currentVideo", "i", j.f35620b, "isCollectionList", "()Z", "setCollectionList", "(Z)V", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "n0", "()Lkotlin/jvm/functions/Function3;", "bindingInflater", CampaignEx.JSON_KEY_AD_K, "a", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UGCImmVideoPlayListDialog extends BaseViewBindingDialog<k> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ugcvideodetail.adapter.h tabAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int selectedTabIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isTabsInitialized;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private UGCImmVideo currentVideo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int totalCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy detailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCImmVideoDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.ugcvideodetail.dialog.UGCImmVideoPlayListDialog$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.ugcvideodetail.dialog.UGCImmVideoPlayListDialog$special$$inlined$activityViewModels$default$2
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

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isCollectionList = true;

    /* renamed from: com.transsion.ugcvideodetail.dialog.UGCImmVideoPlayListDialog$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCImmVideoPlayListDialog a(boolean z10) {
            UGCImmVideoPlayListDialog uGCImmVideoPlayListDialog = new UGCImmVideoPlayListDialog();
            uGCImmVideoPlayListDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("ISC_COLLECTION_LIST", Boolean.valueOf(z10))));
            return uGCImmVideoPlayListDialog;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f56149a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f56150b;

        b(int i11, int i12) {
            this.f56149a = i11;
            this.f56150b = i12;
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
                outRect.left = this.f56149a;
                outRect.right = this.f56150b;
            } else if (childAdapterPosition == itemCount) {
                outRect.left = this.f56150b;
                outRect.right = this.f56149a;
            } else {
                int i11 = this.f56150b;
                outRect.left = i11;
                outRect.right = i11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A0(Ref.ObjectRef objectRef) {
        ((UGCImmVideoDialogPlayListFragment) objectRef.element).r0();
        ((UGCImmVideoDialogPlayListFragment) objectRef.element).G0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v29, types: [T, com.transsion.ugcvideodetail.fragment.UGCImmVideoDialogPlayListFragment] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, androidx.fragment.app.Fragment] */
    private final void B0(int totalCount) {
        int i11;
        UGCVideo ugcVideo;
        RecyclerView recyclerView;
        View view;
        RecyclerView recyclerView2;
        if (totalCount <= 0) {
            return;
        }
        if (totalCount <= 50) {
            k kVar = (k) getViewBinding();
            if (kVar != null && (recyclerView2 = kVar.f73916e) != null) {
                jg.c.g(recyclerView2);
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? k02 = getChildFragmentManager().k0("UGCImmPlayListTabFragment_0");
            objectRef.element = k02;
            if (k02 == 0) {
                objectRef.element = UGCImmVideoDialogPlayListFragment.INSTANCE.a(this.isCollectionList, 0, 1, totalCount);
            }
            if (((Fragment) objectRef.element).isAdded()) {
                getChildFragmentManager().p().y((Fragment) objectRef.element).l();
            } else {
                getChildFragmentManager().p().c(R$id.fragmentContainer, (Fragment) objectRef.element, "UGCImmPlayListTabFragment_0").l();
            }
            if (!(objectRef.element instanceof UGCImmVideoDialogPlayListFragment) || (view = getView()) == null) {
                return;
            }
            view.post(new Runnable() { // from class: com.transsion.ugcvideodetail.dialog.g
                @Override // java.lang.Runnable
                public final void run() {
                    UGCImmVideoPlayListDialog.C0(Ref.ObjectRef.this);
                }
            });
            return;
        }
        k kVar2 = (k) getViewBinding();
        if (kVar2 != null && (recyclerView = kVar2.f73916e) != null) {
            jg.c.k(recyclerView);
        }
        IntRange t11 = RangesKt.t(0, (totalCount + 49) / 50);
        ArrayList arrayList = new ArrayList(CollectionsKt.v(t11, 10));
        Iterator<Integer> it = t11.iterator();
        while (it.hasNext()) {
            int a11 = ((IntIterator) it).a();
            int i12 = (a11 * 50) + 1;
            int min = Math.min((a11 + 1) * 50, totalCount);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(Locale.US, "%d-%d", Arrays.copyOf(new Object[]{Integer.valueOf(i12), Integer.valueOf(min)}, 2));
            Intrinsics.g(format, "format(...)");
            arrayList.add(format);
        }
        com.transsion.ugcvideodetail.adapter.h hVar = this.tabAdapter;
        if (hVar != null) {
            hVar.n1(CollectionsKt.U0(arrayList));
        }
        if (this.isTabsInitialized) {
            int size = arrayList.size();
            int i13 = this.selectedTabIndex;
            if (i13 >= 0 && i13 < size) {
                com.transsion.ugcvideodetail.adapter.h hVar2 = this.tabAdapter;
                if (hVar2 != null) {
                    hVar2.D1(i13);
                    return;
                }
                return;
            }
        }
        UGCImmVideo uGCImmVideo = this.currentVideo;
        int videoUGCPosition = (uGCImmVideo == null || (ugcVideo = uGCImmVideo.getUgcVideo()) == null) ? -1 : ugcVideo.videoUGCPosition();
        if (videoUGCPosition > 0) {
            i11 = t0().S(videoUGCPosition);
        } else {
            int size2 = arrayList.size();
            int i14 = this.selectedTabIndex;
            i11 = (i14 < 0 || i14 >= size2) ? 0 : i14;
        }
        int m11 = RangesKt.m(i11, 0, arrayList.size() - 1);
        this.selectedTabIndex = m11;
        com.transsion.ugcvideodetail.adapter.h hVar3 = this.tabAdapter;
        if (hVar3 != null) {
            hVar3.D1(m11);
        }
        this.isTabsInitialized = true;
        z0(this.selectedTabIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void C0(Ref.ObjectRef objectRef) {
        ((UGCImmVideoDialogPlayListFragment) objectRef.element).r0();
        ((UGCImmVideoDialogPlayListFragment) objectRef.element).G0();
    }

    private final void initViewData() {
        int i11;
        UGCImmVideo uGCImmVideo;
        UGCVideo ugcVideo;
        UGCVideo ugcVideo2;
        UGCVideoBelongToCollection belongToCollection;
        this.currentVideo = (UGCImmVideo) t0().L0().f();
        Map map = (Map) t0().N0().f();
        Integer num = null;
        if (map != null) {
            UGCImmVideo uGCImmVideo2 = this.currentVideo;
            Integer num2 = (Integer) map.get((uGCImmVideo2 == null || (ugcVideo2 = uGCImmVideo2.getUgcVideo()) == null || (belongToCollection = ugcVideo2.getBelongToCollection()) == null) ? null : belongToCollection.getCollectionId());
            if (num2 != null) {
                i11 = num2.intValue();
                this.totalCount = i11;
                a.C0856a c0856a = lg.a.f68962a;
                uGCImmVideo = this.currentVideo;
                if (uGCImmVideo != null && (ugcVideo = uGCImmVideo.getUgcVideo()) != null) {
                    num = Integer.valueOf(ugcVideo.videoUGCPosition());
                }
                a.C0856a.f(c0856a, "UGCImmVideoPlayListDialog", "initViewData, " + num + ", totalCount:" + this.totalCount, false, 4, null);
                B0(this.totalCount);
            }
        }
        i11 = 0;
        this.totalCount = i11;
        a.C0856a c0856a2 = lg.a.f68962a;
        uGCImmVideo = this.currentVideo;
        if (uGCImmVideo != null) {
            num = Integer.valueOf(ugcVideo.videoUGCPosition());
        }
        a.C0856a.f(c0856a2, "UGCImmVideoPlayListDialog", "initViewData, " + num + ", totalCount:" + this.totalCount, false, 4, null);
        B0(this.totalCount);
    }

    private final UGCImmVideoDetailViewModel t0() {
        return (UGCImmVideoDetailViewModel) this.detailViewModel.getValue();
    }

    private final int u0() {
        return (y.c() * 7) / 10;
    }

    private final void v0() {
        List<Fragment> y02 = getChildFragmentManager().y0();
        Intrinsics.g(y02, "getFragments(...)");
        for (Fragment fragment : y02) {
            if (fragment instanceof UGCImmVideoDialogPlayListFragment) {
                getChildFragmentManager().p().p(fragment).l();
            }
        }
    }

    private final void w0() {
        RecyclerView recyclerView;
        com.transsion.ugcvideodetail.adapter.h hVar = new com.transsion.ugcvideodetail.adapter.h(null, 1, null);
        hVar.w1(new p6.d() { // from class: com.transsion.ugcvideodetail.dialog.f
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCImmVideoPlayListDialog.x0(UGCImmVideoPlayListDialog.this, baseQuickAdapter, view, i11);
            }
        });
        this.tabAdapter = hVar;
        k kVar = (k) getViewBinding();
        if (kVar == null || (recyclerView = kVar.f73916e) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(this.tabAdapter);
        recyclerView.addItemDecoration(new b(dk.a.b(12), dk.a.b(8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(UGCImmVideoPlayListDialog uGCImmVideoPlayListDialog, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L)) {
            return;
        }
        uGCImmVideoPlayListDialog.selectedTabIndex = i11;
        com.transsion.ugcvideodetail.adapter.h hVar = uGCImmVideoPlayListDialog.tabAdapter;
        if (hVar != null) {
            hVar.D1(i11);
        }
        uGCImmVideoPlayListDialog.z0(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(UGCImmVideoPlayListDialog uGCImmVideoPlayListDialog, View view) {
        uGCImmVideoPlayListDialog.dismissAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r7v13, types: [T, com.transsion.ugcvideodetail.fragment.UGCImmVideoDialogPlayListFragment] */
    private final void z0(int tabIndex) {
        View view;
        String str = "UGCImmPlayListTabFragment_" + tabIndex;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? k02 = getChildFragmentManager().k0(str);
        objectRef.element = k02;
        if (k02 == 0) {
            objectRef.element = UGCImmVideoDialogPlayListFragment.INSTANCE.a(this.isCollectionList, tabIndex, (tabIndex * 50) + 1, Math.min((tabIndex + 1) * 50, this.totalCount));
        }
        v0();
        if (((Fragment) objectRef.element).isAdded()) {
            getChildFragmentManager().p().y((Fragment) objectRef.element).l();
        } else {
            getChildFragmentManager().p().c(R$id.fragmentContainer, (Fragment) objectRef.element, str).l();
        }
        if (!(objectRef.element instanceof UGCImmVideoDialogPlayListFragment) || (view = getView()) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.transsion.ugcvideodetail.dialog.h
            @Override // java.lang.Runnable
            public final void run() {
                UGCImmVideoPlayListDialog.A0(Ref.ObjectRef.this);
            }
        });
    }

    @Override // com.transsion.baseui.dialog.BaseViewBindingDialog
    public Function3 n0() {
        return UGCImmVideoPlayListDialog$bindingInflater$1.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.DownloadBottomDialogTheme);
        Bundle arguments = getArguments();
        this.isCollectionList = arguments != null ? arguments.getBoolean("ISC_COLLECTION_LIST", true) : true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(com.transsion.baseui.R$style.BaseBottomDialogAnimation);
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = -1;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        ConstraintLayout constraintLayout;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        k kVar = (k) getViewBinding();
        if (kVar != null && (constraintLayout = kVar.f73913b) != null && (layoutParams = constraintLayout.getLayoutParams()) != null) {
            layoutParams.height = u0();
        }
        k kVar2 = (k) getViewBinding();
        if (kVar2 != null && (appCompatImageView = kVar2.f73915d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ugcvideodetail.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UGCImmVideoPlayListDialog.y0(UGCImmVideoPlayListDialog.this, view2);
                }
            });
        }
        w0();
        initViewData();
    }
}
