package com.transsion.shorttv_pugc.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import androidx.view.x0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.base.fragment.PageStatusFragment;
import com.transsion.shorttv_pugc.ui.dialog.ShortTvEpisodeListDialog;
import com.transsion.shorttv_pugc.ui.widget.UGCVideoDetailHorLoadMoreView;
import com.transsion.shorttv_pugc.utils.ShortTvExtKt;
import com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import ot.b;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R$\u00109\u001a\u0002052\u0006\u00106\u001a\u0002058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/transsion/shorttv_pugc/ui/fragment/ShotTvDialogListFragment;", "Lcom/transsion/shorttv_pugc/base/fragment/PageStatusFragment;", "Lms/w;", "<init>", "()V", "", "t0", "u0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "r0", "(Landroidx/recyclerview/widget/RecyclerView;)I", "Lcom/transsion/shorttv_pugc/ShorttvModel$UGCVideo;", WebConstants.FIELD_ITEM, "A0", "(Lcom/transsion/shorttv_pugc/ShorttvModel$UGCVideo;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "p0", "(Landroid/view/LayoutInflater;)Lms/w;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lcom/transsion/shorttv_pugc/viewmodel/ShortTvViewModel;", "i", "Lkotlin/Lazy;", "q0", "()Lcom/transsion/shorttv_pugc/viewmodel/ShortTvViewModel;", "viewModel", "Lcom/transsion/shorttv_pugc/ui/adapter/o;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/shorttv_pugc/ui/adapter/o;", "adapter", CampaignEx.JSON_KEY_AD_K, "I", "startEp", "l", "endEp", "", "m", "J", "lastClickTime", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "n", "Z", "isInit", "()Z", "Lbt/b;", "o", "Lbt/b;", "exposureHelper", TtmlNode.TAG_P, "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShotTvDialogListFragment extends PageStatusFragment<ms.w> {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private com.transsion.shorttv_pugc.ui.adapter.o adapter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int startEp;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int endEp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(ShortTvViewModel.class), new Function0<x0>() { // from class: com.transsion.shorttv_pugc.ui.fragment.ShotTvDialogListFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.shorttv_pugc.ui.fragment.ShotTvDialogListFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final bt.b exposureHelper = new bt.b(0.6f, new b(), false, 4, null);

    /* renamed from: com.transsion.shorttv_pugc.ui.fragment.ShotTvDialogListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShotTvDialogListFragment a(IntRange range) {
            Intrinsics.h(range, "range");
            ShotTvDialogListFragment shotTvDialogListFragment = new ShotTvDialogListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("start", range.getFirst());
            bundle.putInt(TtmlNode.END, range.getLast());
            shotTvDialogListFragment.setArguments(bundle);
            return shotTvDialogListFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements bt.a {
        b() {
        }

        @Override // bt.a
        public void a(int i11, long j11, View view) {
            List<Object> data;
            com.transsion.shorttv_pugc.ui.adapter.o oVar = ShotTvDialogListFragment.this.adapter;
            if (oVar == null || (data = oVar.getData()) == null) {
                return;
            }
            ShotTvDialogListFragment shotTvDialogListFragment = ShotTvDialogListFragment.this;
            if (data.size() < i11) {
                return;
            }
            ut.a aVar = ut.a.f77014a;
            ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) CollectionsKt.l0(data, i11);
            String I = shotTvDialogListFragment.q0().I();
            if (I == null) {
                I = "";
            }
            aVar.d(j11, uGCVideo, "up Next", I);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends RecyclerView.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f54246a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f54247b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f54248c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ShotTvDialogListFragment f54249d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f54250e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f54251f;

        c(LinearLayoutManager linearLayoutManager, Ref.BooleanRef booleanRef, int i11, ShotTvDialogListFragment shotTvDialogListFragment, Ref.BooleanRef booleanRef2, int i12) {
            this.f54246a = linearLayoutManager;
            this.f54247b = booleanRef;
            this.f54248c = i11;
            this.f54249d = shotTvDialogListFragment;
            this.f54250e = booleanRef2;
            this.f54251f = i12;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            int itemCount = this.f54246a.getItemCount();
            int findFirstVisibleItemPosition = this.f54246a.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.f54246a.findLastVisibleItemPosition();
            Ref.BooleanRef booleanRef = this.f54247b;
            if (!booleanRef.element && findFirstVisibleItemPosition <= this.f54248c) {
                booleanRef.element = true;
                this.f54249d.u0();
            }
            Ref.BooleanRef booleanRef2 = this.f54250e;
            if (booleanRef2.element || findLastVisibleItemPosition < (itemCount - 1) - this.f54251f) {
                return;
            }
            booleanRef2.element = true;
            this.f54249d.t0();
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f54252a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f54252a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f54252a;
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
            this.f54252a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTvViewModel q0() {
        return (ShortTvViewModel) this.viewModel.getValue();
    }

    private final int r0(RecyclerView recyclerView) {
        int a11 = yr.a.a(68);
        if (a11 > 0) {
            return recyclerView.getHeight() / a11;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(ShotTvDialogListFragment shotTvDialogListFragment, Pair pair) {
        ArrayList arrayList;
        r6.f h02;
        r6.g o02;
        r6.f h03;
        r6.f h04;
        r6.f h05;
        r6.g o03;
        List<Object> data;
        List i11;
        List list;
        FrameLayout frameLayout;
        Collection collection;
        r6.g o04;
        r6.f h06;
        r6.f h07;
        if (pair != null) {
            if ((pair.getFirst() instanceof b.C0904b) || !((collection = (Collection) pair.getSecond()) == null || collection.isEmpty())) {
                List list2 = (List) pair.getSecond();
                if (list2 != null) {
                    arrayList = new ArrayList();
                    for (Object obj : list2) {
                        int i12 = shotTvDialogListFragment.startEp;
                        int i13 = shotTvDialogListFragment.endEp;
                        int ep2 = ((ShorttvModel.UGCVideo) obj).getEp();
                        if (i12 <= ep2 && ep2 <= i13) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList == null || arrayList.isEmpty()) {
                    return Unit.f67184a;
                }
                ms.w wVar = (ms.w) shotTvDialogListFragment.getMViewBinding();
                if (wVar != null && (frameLayout = wVar.f70068b) != null) {
                    yr.b.b(frameLayout);
                }
                com.transsion.shorttv_pugc.ui.adapter.o oVar = shotTvDialogListFragment.adapter;
                if (oVar != null && (data = oVar.getData()) != null && (i11 = ShortTvExtKt.i(data, arrayList)) != null) {
                    if (i11.size() > 1) {
                        Iterator it = i11.iterator();
                        if (it.hasNext()) {
                            ArrayList arrayList2 = new ArrayList();
                            Object next = it.next();
                            while (it.hasNext()) {
                                Object next2 = it.next();
                                arrayList2.add(Integer.valueOf(((Number) next2).intValue() - ((Number) next).intValue()));
                                next = next2;
                            }
                            list = arrayList2;
                        } else {
                            list = CollectionsKt.l();
                        }
                        List list3 = list;
                        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                            Iterator it2 = list3.iterator();
                            while (it2.hasNext()) {
                                if (((Number) it2.next()).intValue() == 1) {
                                }
                            }
                        }
                        com.transsion.shorttv_pugc.ui.adapter.o oVar2 = shotTvDialogListFragment.adapter;
                        if (oVar2 != null) {
                            oVar2.notifyItemRangeInserted(((Number) CollectionsKt.i0(i11)).intValue(), i11.size());
                        }
                    }
                    Iterator it3 = i11.iterator();
                    while (it3.hasNext()) {
                        int intValue = ((Number) it3.next()).intValue();
                        com.transsion.shorttv_pugc.ui.adapter.o oVar3 = shotTvDialogListFragment.adapter;
                        if (oVar3 != null) {
                            oVar3.notifyItemInserted(intValue);
                        }
                    }
                }
                com.transsion.shorttv_pugc.ui.adapter.o oVar4 = shotTvDialogListFragment.adapter;
                if (oVar4 != null && (o03 = oVar4.o0()) != null) {
                    o03.e(false);
                }
                ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) CollectionsKt.v0(arrayList);
                Integer valueOf = uGCVideo != null ? Integer.valueOf(uGCVideo.getEp()) : null;
                ShorttvModel.UGCVideo uGCVideo2 = (ShorttvModel.UGCVideo) CollectionsKt.k0(arrayList);
                Integer valueOf2 = uGCVideo2 != null ? Integer.valueOf(uGCVideo2.getEp()) : null;
                ShorttvModel.UGCVideo uGCVideo3 = (ShorttvModel.UGCVideo) CollectionsKt.v0(shotTvDialogListFragment.q0().p());
                if (Intrinsics.c(valueOf, uGCVideo3 != null ? Integer.valueOf(uGCVideo3.getEp()) : null)) {
                    com.transsion.shorttv_pugc.ui.adapter.o oVar5 = shotTvDialogListFragment.adapter;
                    if (oVar5 != null && (h05 = oVar5.h0()) != null) {
                        r6.f.u(h05, false, 1, null);
                    }
                    com.transsion.shorttv_pugc.ui.adapter.o oVar6 = shotTvDialogListFragment.adapter;
                    if (oVar6 != null && (h04 = oVar6.h0()) != null) {
                        h04.z(false);
                    }
                } else {
                    int i14 = shotTvDialogListFragment.endEp;
                    if (valueOf != null && valueOf.intValue() == i14) {
                        com.transsion.shorttv_pugc.ui.adapter.o oVar7 = shotTvDialogListFragment.adapter;
                        if (oVar7 != null && (h03 = oVar7.h0()) != null) {
                            h03.z(false);
                        }
                    } else {
                        int i15 = shotTvDialogListFragment.startEp;
                        if (valueOf2 != null && valueOf2.intValue() == i15) {
                            com.transsion.shorttv_pugc.ui.adapter.o oVar8 = shotTvDialogListFragment.adapter;
                            if (oVar8 != null && (o02 = oVar8.o0()) != null) {
                                o02.d(false);
                            }
                        } else {
                            com.transsion.shorttv_pugc.ui.adapter.o oVar9 = shotTvDialogListFragment.adapter;
                            if (oVar9 != null && (h02 = oVar9.h0()) != null) {
                                h02.s();
                            }
                        }
                    }
                }
            } else {
                com.transsion.shorttv_pugc.ui.adapter.o oVar10 = shotTvDialogListFragment.adapter;
                if (oVar10 != null && (h07 = oVar10.h0()) != null) {
                    h07.v();
                }
                com.transsion.shorttv_pugc.ui.adapter.o oVar11 = shotTvDialogListFragment.adapter;
                if (oVar11 != null && (h06 = oVar11.h0()) != null) {
                    h06.z(false);
                }
                com.transsion.shorttv_pugc.ui.adapter.o oVar12 = shotTvDialogListFragment.adapter;
                if (oVar12 != null && (o04 = oVar12.o0()) != null) {
                    o04.e(false);
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0() {
        List<Object> data;
        ShorttvModel.UGCVideo uGCVideo;
        List<Object> data2;
        ShorttvModel.UGCVideo uGCVideo2;
        com.transsion.shorttv_pugc.ui.adapter.o oVar = this.adapter;
        if (oVar == null || (data2 = oVar.getData()) == null || (uGCVideo2 = (ShorttvModel.UGCVideo) CollectionsKt.v0(data2)) == null || uGCVideo2.getEp() != this.endEp) {
            String r11 = q0().r();
            com.transsion.shorttv_pugc.ui.adapter.o oVar2 = this.adapter;
            int ep2 = (oVar2 == null || (data = oVar2.getData()) == null || (uGCVideo = (ShorttvModel.UGCVideo) CollectionsKt.v0(data)) == null) ? this.startEp : uGCVideo.getEp();
            q0().Z(r11, ep2, Math.min(ep2 + 10, this.endEp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        int max;
        int max2;
        r6.g o02;
        List<Object> data;
        ShorttvModel.UGCVideo uGCVideo;
        com.transsion.shorttv_pugc.ui.adapter.o oVar = this.adapter;
        Integer valueOf = (oVar == null || (data = oVar.getData()) == null || (uGCVideo = (ShorttvModel.UGCVideo) CollectionsKt.k0(data)) == null) ? null : Integer.valueOf(uGCVideo.getEp());
        if (valueOf == null) {
            max2 = this.startEp;
            max = max2 + 10;
        } else {
            if (valueOf.intValue() == this.startEp) {
                return;
            }
            max = Math.max(valueOf.intValue() - 1, this.startEp);
            max2 = Math.max(max - 10, this.startEp);
        }
        com.transsion.shorttv_pugc.ui.adapter.o oVar2 = this.adapter;
        if (oVar2 != null && (o02 = oVar2.o0()) != null) {
            o02.e(true);
        }
        q0().Z(q0().r(), max2, max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(ShotTvDialogListFragment shotTvDialogListFragment, com.transsion.shorttv_pugc.ui.adapter.o oVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        if (shotTvDialogListFragment.lastClickTime == 0 || System.currentTimeMillis() - shotTvDialogListFragment.lastClickTime > 1000) {
            shotTvDialogListFragment.lastClickTime = System.currentTimeMillis();
            ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) oVar.getData().get(i11);
            ut.a aVar = ut.a.f77014a;
            String I = shotTvDialogListFragment.q0().I();
            if (I == null) {
                I = "";
            }
            aVar.a(WebConstants.FIELD_ITEM, uGCVideo, "up Next", I);
            shotTvDialogListFragment.A0(uGCVideo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(ShotTvDialogListFragment shotTvDialogListFragment) {
        shotTvDialogListFragment.t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(ShotTvDialogListFragment shotTvDialogListFragment) {
        shotTvDialogListFragment.u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(LinearLayoutManager linearLayoutManager, int i11) {
        linearLayoutManager.scrollToPositionWithOffset(i11, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(LinearLayoutManager linearLayoutManager, int i11) {
        linearLayoutManager.scrollToPositionWithOffset(i11, 0);
    }

    public final void A0(ShorttvModel.UGCVideo item) {
        Intrinsics.h(item, "item");
        if (getParentFragment() instanceof ShortTvEpisodeListDialog) {
            Fragment parentFragment = getParentFragment();
            Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.shorttv_pugc.ui.dialog.ShortTvEpisodeListDialog");
            ((ShortTvEpisodeListDialog) parentFragment).n0(item);
        }
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void initViewData() {
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void initViewModel() {
        q0().u().j(getViewLifecycleOwner(), new d(new Function1() { // from class: com.transsion.shorttv_pugc.ui.fragment.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s02;
                s02 = ShotTvDialogListFragment.s0(ShotTvDialogListFragment.this, (Pair) obj);
                return s02;
            }
        }));
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.startEp = arguments != null ? arguments.getInt("start") : this.startEp;
        Bundle arguments2 = getArguments();
        this.endEp = arguments2 != null ? arguments2.getInt(TtmlNode.END) : this.endEp;
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        ms.w wVar = (ms.w) getMViewBinding();
        if (wVar != null) {
            wVar.f70069c.setLayoutManager(linearLayoutManager);
            wVar.f70069c.addOnScrollListener(this.exposureHelper);
            RecyclerView recyclerView = wVar.f70069c;
            final com.transsion.shorttv_pugc.ui.adapter.o oVar = new com.transsion.shorttv_pugc.ui.adapter.o();
            List z10 = q0().z();
            ArrayList arrayList = new ArrayList();
            for (Object obj : z10) {
                int i11 = this.startEp;
                int i12 = this.endEp;
                int ep2 = ((ShorttvModel.UGCVideo) obj).getEp();
                if (i11 <= ep2 && ep2 <= i12) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                String r11 = q0().r();
                int i13 = this.startEp;
                q0().Z(r11, i13, Math.min(i13 + 10, this.endEp));
                FrameLayout loading = wVar.f70068b;
                Intrinsics.g(loading, "loading");
                yr.b.e(loading);
            }
            oVar.n1(arrayList);
            this.adapter = oVar;
            for (ShorttvModel.UGCVideo uGCVideo : q0().z()) {
                int ep3 = uGCVideo.getEp();
                Integer num = (Integer) q0().s().f();
                uGCVideo.setSelected(num != null && ep3 == num.intValue());
            }
            oVar.w1(new p6.d() { // from class: com.transsion.shorttv_pugc.ui.fragment.d0
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i14) {
                    ShotTvDialogListFragment.v0(ShotTvDialogListFragment.this, oVar, baseQuickAdapter, view2, i14);
                }
            });
            oVar.h0().C(new UGCVideoDetailHorLoadMoreView());
            oVar.h0().z(true);
            oVar.h0().y(true);
            oVar.h0().E(3);
            oVar.h0().D(new p6.f() { // from class: com.transsion.shorttv_pugc.ui.fragment.e0
                @Override // p6.f
                public final void a() {
                    ShotTvDialogListFragment.w0(ShotTvDialogListFragment.this);
                }
            });
            oVar.o0().d(true);
            oVar.o0().c(2);
            oVar.o0().b(new p6.g() { // from class: com.transsion.shorttv_pugc.ui.fragment.f0
                @Override // p6.g
                public final void a() {
                    ShotTvDialogListFragment.x0(ShotTvDialogListFragment.this);
                }
            });
            Integer num2 = (Integer) q0().s().f();
            int intValue = num2 != null ? num2.intValue() : 1;
            int i14 = this.startEp;
            final int i15 = intValue - i14;
            int i16 = this.endEp;
            if (intValue <= i16 && i14 <= intValue) {
                RecyclerView rv2 = wVar.f70069c;
                Intrinsics.g(rv2, "rv");
                final int r02 = ((i16 - i14) + 1) - r0(rv2);
                if (i15 <= r02) {
                    wVar.f70069c.post(new Runnable() { // from class: com.transsion.shorttv_pugc.ui.fragment.g0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ShotTvDialogListFragment.y0(LinearLayoutManager.this, i15);
                        }
                    });
                } else {
                    wVar.f70069c.post(new Runnable() { // from class: com.transsion.shorttv_pugc.ui.fragment.h0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ShotTvDialogListFragment.z0(LinearLayoutManager.this, r02);
                        }
                    });
                }
            }
            recyclerView.setAdapter(oVar);
            wVar.f70069c.addOnScrollListener(new c(linearLayoutManager, new Ref.BooleanRef(), 3, this, new Ref.BooleanRef(), 3));
            wVar.f70069c.getLayoutParams().height = com.blankj.utilcode.util.i.e(500.0f);
        }
        this.isInit = true;
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public ms.w getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        ms.w c11 = ms.w.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void retryLoadData() {
    }
}
