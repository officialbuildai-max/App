package com.transsion.publish.ui;

import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.adapter.SelectLocationAdapter;
import com.transsion.publish.viewmodel.LocationPlaceViewModel;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.bean.LocationPlace;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u0011\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010<\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001d\u0010O\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/transsion/publish/ui/SelectLocationFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lhp/i;", "<init>", "()V", "", "checkGPS", "t0", "requestCurrentLocation", "A0", "r0", "D0", "F0", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "z0", "(I)V", "", "Lcom/transsion/room/api/bean/LocationPlace;", "list", "G0", "(Ljava/util/List;)V", WebConstants.FIELD_ITEM, "B0", "(Lcom/transsion/room/api/bean/LocationPlace;)V", "Landroid/view/LayoutInflater;", "inflater", "s0", "(Landroid/view/LayoutInflater;)Lhp/i;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "getEmptyDescText", "initViewData", "initViewModel", "initListener", "retryLoadData", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "Lcom/transsion/publish/adapter/SelectLocationAdapter;", "a", "Lcom/transsion/publish/adapter/SelectLocationAdapter;", "mAdapter", "Lcom/transsion/publish/viewmodel/LocationPlaceViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/publish/viewmodel/LocationPlaceViewModel;", "mViewModel", "", "c", "Ljava/lang/Double;", "lat", "d", "lon", "e", "Ljava/lang/String;", "countryCode", "f", "Lcom/transsion/room/api/bean/LocationPlace;", "curLocationPlace", be.g.f16474b, "Landroid/view/View;", "mLoadingView", "h", "I", "placeType", "Laq/a;", "i", "Laq/a;", "mGpsServiceHelper", "Lcom/transsion/room/api/IRoomApi;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lkotlin/Lazy;", "getMRoomApi", "()Lcom/transsion/room/api/IRoomApi;", "mRoomApi", CampaignEx.JSON_KEY_AD_K, "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SelectLocationFragment extends PageStatusFragment<hp.i> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private SelectLocationAdapter mAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LocationPlaceViewModel mViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Double lat;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Double lon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String countryCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LocationPlace curLocationPlace;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private View mLoadingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int placeType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private aq.a mGpsServiceHelper;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy mRoomApi = LazyKt.b(new Function0() { // from class: com.transsion.publish.ui.r0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IRoomApi mRoomApi_delegate$lambda$0;
            mRoomApi_delegate$lambda$0 = SelectLocationFragment.mRoomApi_delegate$lambda$0();
            return mRoomApi_delegate$lambda$0;
        }
    });

    /* renamed from: com.transsion.publish.ui.SelectLocationFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SelectLocationFragment a(LocationPlace locationPlace) {
            SelectLocationFragment selectLocationFragment = new SelectLocationFragment();
            selectLocationFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("location_data", locationPlace)));
            return selectLocationFragment;
        }
    }

    /* loaded from: classes6.dex */
    static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f50578a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f50578a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f50578a;
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
            this.f50578a.invoke(obj);
        }
    }

    private final void A0() {
        SelectLocationAdapter selectLocationAdapter = this.mAdapter;
        if (selectLocationAdapter != null) {
            selectLocationAdapter.D1(this.lat, this.lon);
        }
        a.C0856a.f(lg.a.f68962a, "LocationS", "Select--- get location success, placeType:" + this.placeType + ", do next", false, 4, null);
        int i11 = this.placeType;
        if (i11 == 0) {
            r0();
        } else if (i11 == 1) {
            F0();
        } else if (i11 == 2) {
            z0(2);
        }
        if (this.lat == null || this.lon == null) {
            return;
        }
        com.transsion.baselib.report.launch.b.f43424a.b().putString("key_lo_last_lat_lon", this.lat + "," + this.lon);
    }

    private final void B0(LocationPlace item) {
        fp.a aVar = new fp.a();
        aVar.o(8);
        aVar.n(1);
        aVar.q(item);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = fp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, aVar, 0L);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(SelectLocationFragment selectLocationFragment, LocationPlace locationPlace) {
        if (locationPlace == null) {
            a.C0856a.f(lg.a.f68962a, "LocationS", "Select--- get location fail", false, 4, null);
            selectLocationFragment.showContentView();
            SelectLocationAdapter selectLocationAdapter = selectLocationFragment.mAdapter;
            if (selectLocationAdapter != null) {
                selectLocationAdapter.Y0(selectLocationFragment.getErrorView(false));
            }
            return Unit.f67184a;
        }
        selectLocationFragment.lat = locationPlace.getLat();
        selectLocationFragment.lon = locationPlace.getLon();
        Address locationAddress = locationPlace.getLocationAddress();
        selectLocationFragment.countryCode = locationAddress != null ? locationAddress.getCountryCode() : null;
        selectLocationFragment.curLocationPlace = locationPlace;
        selectLocationFragment.A0();
        return Unit.f67184a;
    }

    private final void D0() {
        Double d11 = this.lat;
        if (d11 != null) {
            double doubleValue = d11.doubleValue();
            Double d12 = this.lon;
            if (d12 != null) {
                double doubleValue2 = d12.doubleValue();
                IRoomApi mRoomApi = getMRoomApi();
                if (mRoomApi != null) {
                    mRoomApi.e(doubleValue, doubleValue2, new Function1() { // from class: com.transsion.publish.ui.y0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit E0;
                            E0 = SelectLocationFragment.E0(SelectLocationFragment.this, (List) obj);
                            return E0;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(SelectLocationFragment selectLocationFragment, List list) {
        String name;
        String distance;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            selectLocationFragment.z0(0);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((LocationPlace) it.next()).setCountryCode(selectLocationFragment.countryCode);
            }
            LocationPlaceViewModel locationPlaceViewModel = selectLocationFragment.mViewModel;
            if (locationPlaceViewModel != null) {
                locationPlaceViewModel.o(list);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list2);
            LocationPlace locationPlace = selectLocationFragment.curLocationPlace;
            if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                arrayList.add(locationPlace);
            }
            selectLocationFragment.G0(arrayList);
        }
        return Unit.f67184a;
    }

    private final void F0() {
        LocationPlaceViewModel locationPlaceViewModel = this.mViewModel;
        if (locationPlaceViewModel != null) {
            Double d11 = this.lat;
            Double valueOf = Double.valueOf(d11 != null ? d11.doubleValue() : 0.0d);
            Double d12 = this.lon;
            locationPlaceViewModel.k(valueOf, Double.valueOf(d12 != null ? d12.doubleValue() : 0.0d));
        }
    }

    private final void G0(List list) {
        showContentView();
        if (list.isEmpty()) {
            showEmptyView(false);
            return;
        }
        SelectLocationAdapter selectLocationAdapter = this.mAdapter;
        if (selectLocationAdapter != null) {
            selectLocationAdapter.n1(CollectionsKt.U0(list));
        }
    }

    private final void checkGPS() {
        LinearLayout linearLayout;
        aq.a aVar = this.mGpsServiceHelper;
        if (aVar == null || !aVar.b()) {
            hp.i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (linearLayout = mViewBinding.f64926b) == null) {
                return;
            }
            jg.c.k(linearLayout);
            return;
        }
        if (this.lon == null || this.lat == null) {
            a.C0856a.r(lg.a.f68962a, "LocationS", new String[]{"Select---GPS is open, location null, get location----"}, false, 4, null);
            requestCurrentLocation();
        } else {
            a.C0856a.r(lg.a.f68962a, "LocationS", new String[]{"Select---GPS is open, location not null"}, false, 4, null);
            A0();
        }
    }

    private final IRoomApi getMRoomApi() {
        return (IRoomApi) this.mRoomApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IRoomApi mRoomApi_delegate$lambda$0() {
        return (IRoomApi) TheRouter.d(IRoomApi.class, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
    
        if (r6.b(r7, r4.doubleValue(), r3.doubleValue(), r1.doubleValue()) > 30000.0f) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void r0() {
        /*
            r15 = this;
            lg.a$a r0 = lg.a.f68962a
            r4 = 4
            r5 = 0
            java.lang.String r1 = "LocationS"
            java.lang.String r2 = "Select--- client, getCache"
            r3 = 0
            lg.a.C0856a.f(r0, r1, r2, r3, r4, r5)
            com.transsion.baselib.report.launch.b r0 = com.transsion.baselib.report.launch.b.f43424a
            com.tencent.mmkv.MMKV r0 = r0.b()
            java.lang.String r1 = "key_lo_last_lat_lon"
            r2 = 0
            java.lang.String r3 = r0.getString(r1, r2)
            r0 = 1
            if (r3 == 0) goto L94
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L7b
            java.lang.String r1 = ","
            java.lang.String[] r4 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L7b
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            java.util.List r1 = kotlin.text.StringsKt.S0(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L7b
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L7b
            if (r2 == 0) goto L34
        L32:
            r2 = r0
            goto L7e
        L34:
            r2 = 0
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L7b
            java.lang.Double r3 = kotlin.text.StringsKt.s(r3)     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L7b
            java.lang.Double r1 = kotlin.text.StringsKt.s(r1)     // Catch: java.lang.Throwable -> L7b
            java.lang.Double r4 = r15.lat     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L32
            java.lang.Double r5 = r15.lon     // Catch: java.lang.Throwable -> L7b
            if (r5 == 0) goto L32
            if (r3 == 0) goto L32
            if (r1 == 0) goto L32
            ak.s r6 = ak.s.f726a     // Catch: java.lang.Throwable -> L7b
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Throwable -> L7b
            double r7 = r4.doubleValue()     // Catch: java.lang.Throwable -> L7b
            java.lang.Double r4 = r15.lon     // Catch: java.lang.Throwable -> L7b
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Throwable -> L7b
            double r9 = r4.doubleValue()     // Catch: java.lang.Throwable -> L7b
            double r11 = r3.doubleValue()     // Catch: java.lang.Throwable -> L7b
            double r13 = r1.doubleValue()     // Catch: java.lang.Throwable -> L7b
            float r1 = r6.b(r7, r9, r11, r13)     // Catch: java.lang.Throwable -> L7b
            r3 = 1189765120(0x46ea6000, float:30000.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L32
            goto L7e
        L7b:
            r1 = move-exception
            r2 = r0
            goto L86
        L7e:
            kotlin.Unit r1 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L85
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)     // Catch: java.lang.Throwable -> L85
            goto L90
        L85:
            r1 = move-exception
        L86:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.a(r1)
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)
        L90:
            kotlin.Result.m1184boximpl(r1)
            goto L95
        L94:
            r2 = r0
        L95:
            if (r2 == 0) goto L9f
            com.transsion.publish.viewmodel.LocationPlaceViewModel r0 = r15.mViewModel
            if (r0 == 0) goto Lb2
            r0.i()
            goto Lb2
        L9f:
            lg.a$a r1 = lg.a.f68962a
            java.lang.String r2 = "LocationS"
            java.lang.String r3 = "Select--- client 已超距离，清除缓存，使用 getNearbyPlaces"
            r1.c(r2, r3, r0)
            com.transsion.publish.viewmodel.LocationPlaceViewModel r0 = r15.mViewModel
            if (r0 == 0) goto Laf
            r0.h()
        Laf:
            r15.D0()
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.publish.ui.SelectLocationFragment.r0():void");
    }

    private final void requestCurrentLocation() {
        IRoomApi mRoomApi;
        showLoadingView();
        FragmentActivity activity = getActivity();
        if (activity == null || (mRoomApi = getMRoomApi()) == null) {
            return;
        }
        mRoomApi.b(activity, new Function1() { // from class: com.transsion.publish.ui.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = SelectLocationFragment.C0(SelectLocationFragment.this, (LocationPlace) obj);
                return C0;
            }
        });
    }

    private final void t0() {
        Integer v11;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_use_server_place", true);
        String value = c11 != null ? c11.getValue() : null;
        int i11 = 0;
        if (value != null && value.length() != 0 && (v11 = StringsKt.v(value)) != null) {
            i11 = v11.intValue();
        }
        this.placeType = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(final SelectLocationFragment selectLocationFragment, View view) {
        aq.a aVar;
        a.C0856a.f(lg.a.f68962a, "LocationS", "Select--- openGPS click", false, 4, null);
        if (selectLocationFragment.getActivity() == null || (aVar = selectLocationFragment.mGpsServiceHelper) == null) {
            return;
        }
        aVar.a(new Function1() { // from class: com.transsion.publish.ui.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v02;
                v02 = SelectLocationFragment.v0(SelectLocationFragment.this, ((Boolean) obj).booleanValue());
                return v02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(SelectLocationFragment selectLocationFragment, boolean z10) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (z10) {
            hp.i mViewBinding = selectLocationFragment.getMViewBinding();
            if (mViewBinding != null && (linearLayout2 = mViewBinding.f64926b) != null) {
                jg.c.g(linearLayout2);
            }
            selectLocationFragment.requestCurrentLocation();
        } else {
            hp.i mViewBinding2 = selectLocationFragment.getMViewBinding();
            if (mViewBinding2 != null && (linearLayout = mViewBinding2.f64926b) != null) {
                jg.c.k(linearLayout);
            }
        }
        a.C0856a.f(lg.a.f68962a, "LocationS", "Select--- openGPS result:" + z10, false, 4, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(SelectLocationFragment selectLocationFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        LocationPlace locationPlace = item instanceof LocationPlace ? (LocationPlace) item : null;
        if (locationPlace == null) {
            return;
        }
        selectLocationFragment.B0(locationPlace);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(SelectLocationFragment selectLocationFragment, List list) {
        String name;
        String distance;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            lg.a.f68962a.c("LocationS", "Select--- server, 无数据", true);
            selectLocationFragment.z0(1);
        } else {
            List U0 = CollectionsKt.U0(list2);
            lg.a.f68962a.c("LocationS", "Select--- server,有数据展示，count:" + list.size(), true);
            LocationPlace locationPlace = selectLocationFragment.curLocationPlace;
            if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                U0.add(0, locationPlace);
            }
            selectLocationFragment.G0(U0);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(SelectLocationFragment selectLocationFragment, List list) {
        String name;
        String distance;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            lg.a.f68962a.c("LocationS", "Select--- client 无缓存 getNearbyPlaces", true);
            selectLocationFragment.D0();
        } else {
            List U0 = CollectionsKt.U0(list2);
            lg.a.f68962a.c("LocationS", "Select--- client, 有缓存，使用缓存数据，count:" + list.size(), true);
            LocationPlace locationPlace = selectLocationFragment.curLocationPlace;
            if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                U0.add(0, locationPlace);
            }
            selectLocationFragment.G0(U0);
        }
        return Unit.f67184a;
    }

    private final void z0(int type) {
        String name;
        String distance;
        ArrayList arrayList = new ArrayList();
        LocationPlace locationPlace = this.curLocationPlace;
        if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
            arrayList.add(locationPlace);
        }
        G0(arrayList);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getEmptyDescText() {
        String string = Utils.a().getString(R$string.location_fail_tips);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View getLoadingView() {
        if (this.mLoadingView == null) {
            this.mLoadingView = LayoutInflater.from(requireContext()).inflate(R$layout.layout_select_location_loading, (ViewGroup) getFlStateView(), false);
        }
        return this.mLoadingView;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatTextView appCompatTextView;
        hp.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatTextView = mViewBinding.f64928d) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectLocationFragment.u0(SelectLocationFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        RecyclerView recyclerView;
        t0();
        SelectLocationAdapter selectLocationAdapter = new SelectLocationAdapter();
        selectLocationAdapter.w1(new p6.d() { // from class: com.transsion.publish.ui.s0
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SelectLocationFragment.w0(SelectLocationFragment.this, baseQuickAdapter, view, i11);
            }
        });
        this.mAdapter = selectLocationAdapter;
        hp.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f64927c) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.mAdapter);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        LocationPlaceViewModel locationPlaceViewModel = (LocationPlaceViewModel) new androidx.view.v0(this).a(LocationPlaceViewModel.class);
        locationPlaceViewModel.l().j(this, new b(new Function1() { // from class: com.transsion.publish.ui.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x02;
                x02 = SelectLocationFragment.x0(SelectLocationFragment.this, (List) obj);
                return x02;
            }
        }));
        locationPlaceViewModel.j().j(this, new b(new Function1() { // from class: com.transsion.publish.ui.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y02;
                y02 = SelectLocationFragment.y0(SelectLocationFragment.this, (List) obj);
                return y02;
            }
        }));
        this.mViewModel = locationPlaceViewModel;
        checkGPS();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        LocationPlace locationPlace;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("location_data") : null;
        LocationPlace locationPlace2 = serializable instanceof LocationPlace ? (LocationPlace) serializable : null;
        this.curLocationPlace = locationPlace2;
        a.C0856a c0856a = lg.a.f68962a;
        Double lat = locationPlace2 != null ? locationPlace2.getLat() : null;
        LocationPlace locationPlace3 = this.curLocationPlace;
        Double lon = locationPlace3 != null ? locationPlace3.getLon() : null;
        LocationPlace locationPlace4 = this.curLocationPlace;
        String name = locationPlace4 != null ? locationPlace4.getName() : null;
        LocationPlace locationPlace5 = this.curLocationPlace;
        a.C0856a.v(c0856a, "LocationS", "Select--- onCreate, lat:" + lat + ", lon：" + lon + " name:" + name + ",distance:" + (locationPlace5 != null ? locationPlace5.getDistance() : null), false, 4, null);
        LocationPlace locationPlace6 = this.curLocationPlace;
        if (locationPlace6 != null) {
            String distance = locationPlace6 != null ? locationPlace6.getDistance() : null;
            if ((distance == null || distance.length() == 0) && (locationPlace = this.curLocationPlace) != null) {
                locationPlace.setDistance("<1m");
            }
            LocationPlace locationPlace7 = this.curLocationPlace;
            this.lat = locationPlace7 != null ? locationPlace7.getLat() : null;
            LocationPlace locationPlace8 = this.curLocationPlace;
            this.lon = locationPlace8 != null ? locationPlace8.getLon() : null;
            LocationPlace locationPlace9 = this.curLocationPlace;
            this.countryCode = locationPlace9 != null ? locationPlace9.getCountryCode() : null;
        }
        IRoomApi mRoomApi = getMRoomApi();
        this.mGpsServiceHelper = mRoomApi != null ? mRoomApi.f(this) : null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        requestCurrentLocation();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public hp.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        hp.i c11 = hp.i.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
