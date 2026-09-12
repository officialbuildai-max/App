package com.transsion.room.fragment;

import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.Lifecycle;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.adapter.RoomListAdapter;
import com.transsion.room.adapter.RoomListFrom;
import com.transsion.room.api.bean.LocationPlace;
import com.transsion.room.helper.LocationPlaceHelper;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00103\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010.R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/transsion/room/fragment/RoomListFragment;", "Lcom/transsion/room/fragment/RoomListBaseFragment;", "<init>", "()V", "", "checkGPS", "W0", "addLocationHeaderView", "requestLocationPermission", "getCurrentLocation", "removeLocationHeaderView", "removeEmptyView", "c1", "initListener", "initViewData", "initViewModel", "lazyLoadData", "checkToShowEmptyView", "Lcom/transsion/room/adapter/RoomListFrom;", "w0", "()Lcom/transsion/room/adapter/RoomListFrom;", "", "isRefresh", "E0", "(Z)V", "hidden", "onHiddenChanged", "", "pageName", "()Ljava/lang/String;", "", "n", "Ljava/lang/Integer;", "mCid", "", "o", "Ljava/lang/Double;", "mLat", TtmlNode.TAG_P, "mLon", "Landroid/location/Address;", CampaignEx.JSON_KEY_AD_Q, "Landroid/location/Address;", "mAddress", "Landroid/view/View;", CampaignEx.JSON_KEY_AD_R, "Landroid/view/View;", "locationPermissionHeaderView", "s", "mEmptyView", "t", "mNoNetView", "Lcom/transsion/room/helper/e;", TmcStartParams.KEY_URL_SHORT, "Lkotlin/Lazy;", "Z0", "()Lcom/transsion/room/helper/e;", "mGpsServiceHelper", "v", "a", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RoomListFragment extends RoomListBaseFragment {

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Integer mCid;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Double mLat;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Double mLon;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private Address mAddress;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private View locationPermissionHeaderView;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private View mEmptyView;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private View mNoNetView;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Lazy mGpsServiceHelper = LazyKt.b(new Function0() { // from class: com.transsion.room.fragment.q1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.room.helper.e b12;
            b12 = RoomListFragment.b1(RoomListFragment.this);
            return b12;
        }
    });

    /* renamed from: com.transsion.room.fragment.RoomListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomListFragment a(Integer num, boolean z10) {
            RoomListFragment roomListFragment = new RoomListFragment();
            roomListFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("id", num), TuplesKt.a("is_select_room", Boolean.valueOf(z10))));
            return roomListFragment;
        }
    }

    /* loaded from: classes6.dex */
    static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f51567a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f51567a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f51567a;
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
            this.f51567a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(RoomListFragment roomListFragment, View view) {
        roomListFragment.requestLocationPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit U0(final RoomListFragment roomListFragment, boolean z10) {
        SwipeRefreshLayout root;
        a.C0856a.f(lg.a.f68962a, "RoomLocation", "openGPS result:" + z10, false, 4, null);
        bq.r rVar = (bq.r) roomListFragment.getMViewBinding();
        if (rVar != null && (root = rVar.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.transsion.room.fragment.u1
                @Override // java.lang.Runnable
                public final void run() {
                    RoomListFragment.V0(RoomListFragment.this);
                }
            });
        }
        roomListFragment.showLoadingView();
        RoomListBaseFragment.F0(roomListFragment, false, 1, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(RoomListFragment roomListFragment) {
        roomListFragment.W0();
    }

    private final void W0() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (ye.c.f79116a.f(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            getCurrentLocation();
            return;
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        if (bVar.b().getBoolean("key_list_lo_per_requested", false)) {
            addLocationHeaderView();
        } else {
            bVar.b().putBoolean("key_list_lo_per_requested", true);
            requestLocationPermission();
        }
        showLoadingView();
        RoomListBaseFragment.F0(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(RoomListFragment roomListFragment, View view) {
        RoomListAdapter mAdapter = roomListFragment.getMAdapter();
        if (mAdapter != null) {
            BaseQuickAdapter.y(mAdapter, view, 1, 0, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(RoomListFragment roomListFragment, LocationPlace locationPlace) {
        roomListFragment.mLat = locationPlace != null ? locationPlace.getLat() : null;
        roomListFragment.mLon = locationPlace != null ? locationPlace.getLon() : null;
        roomListFragment.mAddress = locationPlace != null ? locationPlace.getLocationAddress() : null;
        roomListFragment.showLoadingView();
        RoomListBaseFragment.F0(roomListFragment, false, 1, null);
        return Unit.f67184a;
    }

    private final com.transsion.room.helper.e Z0() {
        return (com.transsion.room.helper.e) this.mGpsServiceHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(RoomListFragment roomListFragment, RoomBean roomBean) {
        roomListFragment.removeEmptyView();
        roomListFragment.J0(roomBean);
        return Unit.f67184a;
    }

    private final void addLocationHeaderView() {
        if (this.locationPermissionHeaderView == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_location_permission_header, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_allow)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.t1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomListFragment.T0(RoomListFragment.this, view);
                }
            });
            RoomListAdapter mAdapter = getMAdapter();
            if (mAdapter != null) {
                Intrinsics.e(inflate);
                BaseQuickAdapter.y(mAdapter, inflate, 0, 0, 4, null);
            }
            this.locationPermissionHeaderView = inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.room.helper.e b1(RoomListFragment roomListFragment) {
        return new com.transsion.room.helper.e(roomListFragment);
    }

    private final void c1() {
        Function1 function1 = new Function1() { // from class: com.transsion.room.fragment.o1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d12;
                d12 = RoomListFragment.d1(RoomListFragment.this, (JoinRoomEvent) obj);
                return d12;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    private final void checkGPS() {
        if (Z0().b()) {
            a.C0856a.f(lg.a.f68962a, "RoomLocation", "GPS is open, checkPermission", false, 4, null);
            W0();
        } else if (getActivity() != null) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            if (bVar.b().getBoolean("key_list_lo_per_requested", false)) {
                addLocationHeaderView();
            } else {
                bVar.b().putBoolean("key_list_lo_per_requested", true);
                Z0().a(new Function1() { // from class: com.transsion.room.fragment.p1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit U0;
                        U0 = RoomListFragment.U0(RoomListFragment.this, ((Boolean) obj).booleanValue());
                        return U0;
                    }
                });
            }
            showLoadingView();
            RoomListBaseFragment.F0(this, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(RoomListFragment roomListFragment, JoinRoomEvent value) {
        RoomItem roomItem;
        List<Object> data;
        Intrinsics.h(value, "value");
        RoomListAdapter mAdapter = roomListFragment.getMAdapter();
        int i11 = -1;
        if (mAdapter != null && (data = mAdapter.getData()) != null) {
            Iterator<Object> it = data.iterator();
            int i12 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(value.getGroupId(), ((RoomItem) it.next()).getGroupId())) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
        }
        if (i11 >= 0) {
            RoomListAdapter mAdapter2 = roomListFragment.getMAdapter();
            if (mAdapter2 != null && (roomItem = (RoomItem) mAdapter2.f0(i11)) != null) {
                roomItem.setHasJoin(Boolean.valueOf(value.getJoin()));
            }
            RoomListAdapter mAdapter3 = roomListFragment.getMAdapter();
            if (mAdapter3 != null) {
                mAdapter3.notifyItemChanged(i11, Boolean.valueOf(value.getJoin()));
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(RoomListFragment roomListFragment, boolean z10) {
        if (z10) {
            roomListFragment.removeLocationHeaderView();
            roomListFragment.getCurrentLocation();
        } else {
            roomListFragment.addLocationHeaderView();
        }
        return Unit.f67184a;
    }

    private final void getCurrentLocation() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        LocationPlaceHelper.f51664a.n(activity, new Function1() { // from class: com.transsion.room.fragment.s1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = RoomListFragment.Y0(RoomListFragment.this, (LocationPlace) obj);
                return Y0;
            }
        });
    }

    private final void removeEmptyView() {
        View view = this.mNoNetView;
        if (view != null) {
            RoomListAdapter mAdapter = getMAdapter();
            if (mAdapter != null) {
                mAdapter.J0(view);
            }
            this.mNoNetView = null;
        }
        View view2 = this.mEmptyView;
        if (view2 != null) {
            RoomListAdapter mAdapter2 = getMAdapter();
            if (mAdapter2 != null) {
                mAdapter2.J0(view2);
            }
            this.mEmptyView = null;
        }
    }

    private final void removeLocationHeaderView() {
        View view = this.locationPermissionHeaderView;
        if (view != null) {
            RoomListAdapter mAdapter = getMAdapter();
            if (mAdapter != null) {
                mAdapter.J0(view);
            }
            this.locationPermissionHeaderView = null;
        }
    }

    private final void requestLocationPermission() {
        FragmentActivity activity = getActivity();
        if (activity == null || !isAdded() || isDetached() || isRemoving()) {
            return;
        }
        LocationPlaceHelper.f51664a.t(activity, false, new Function1() { // from class: com.transsion.room.fragment.v1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e12;
                e12 = RoomListFragment.e1(RoomListFragment.this, ((Boolean) obj).booleanValue());
                return e12;
            }
        });
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public void E0(boolean isRefresh) {
        Integer num = this.mCid;
        if (num != null) {
            int intValue = num.intValue();
            RoomViewModel mViewModel = getMViewModel();
            if (mViewModel != null) {
                String mPage = getMPage();
                if (mPage == null) {
                    mPage = "1";
                }
                mViewModel.F(isRefresh, intValue, mPage, getMPerPage(), this.mLat, this.mLon, this.mAddress);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public void checkToShowEmptyView() {
        final View emptyView;
        SwipeRefreshLayout root;
        Integer num = this.mCid;
        if (num == null || num.intValue() != -2) {
            super.checkToShowEmptyView();
            return;
        }
        if (nh.m.f70597a.e()) {
            emptyView = getEmptyView(false);
            this.mEmptyView = emptyView;
        } else {
            emptyView = getLocalNoNetworkView(false);
            this.mNoNetView = emptyView;
        }
        bq.r rVar = (bq.r) getMViewBinding();
        if (rVar == null || (root = rVar.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.room.fragment.r1
            @Override // java.lang.Runnable
            public final void run() {
                RoomListFragment.X0(RoomListFragment.this, emptyView);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        c1();
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        super.initViewData();
        Bundle arguments = getArguments();
        Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("id", -1)) : null;
        this.mCid = valueOf;
        if (valueOf != null && valueOf.intValue() == -2) {
            checkGPS();
        }
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.view.b0 J;
        super.initViewModel();
        RoomViewModel mViewModel = getMViewModel();
        if (mViewModel == null || (J = mViewModel.J()) == null) {
            return;
        }
        J.j(this, new b(new Function1() { // from class: com.transsion.room.fragment.n1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit a12;
                a12 = RoomListFragment.a1(RoomListFragment.this, (RoomBean) obj);
                return a12;
            }
        }));
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        Integer num = this.mCid;
        if (num != null && num.intValue() == -2) {
            return;
        }
        super.lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, androidx.fragment.app.Fragment
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

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public String pageName() {
        return "room_list";
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public RoomListFrom w0() {
        return RoomListFrom.ROOM_LIST;
    }
}
