package com.transsion.home.tv;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.view.b0;
import com.google.gson.Gson;
import com.transsion.home.R$string;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SubOperateData;
import com.transsion.home.tv.bean.CountryDataBean;
import com.transsion.home.tv.bean.CountryItem;
import com.transsion.home.tv.bean.Pager;
import com.transsion.home.tv.bean.PendingRefreshResult;
import com.transsion.home.tv.bean.TvChannelItem;
import com.transsion.home.tv.bean.TvChannelListDataBean;
import com.transsion.home.tv.bean.TvChannelLoadMoreResult;
import com.transsion.home.tv.bean.TvChannelRefreshResult;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import rl.h;

/* loaded from: classes5.dex */
public final class TVChannelHomeViewModel extends androidx.view.b {

    /* renamed from: p, reason: collision with root package name */
    public static final a f45606p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f45607q = 8;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f45608b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f45609c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f45610d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f45611e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f45612f;

    /* renamed from: g, reason: collision with root package name */
    private final Gson f45613g;

    /* renamed from: h, reason: collision with root package name */
    private String f45614h;

    /* renamed from: i, reason: collision with root package name */
    private Pager f45615i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f45616j;

    /* renamed from: k, reason: collision with root package name */
    private long f45617k;

    /* renamed from: l, reason: collision with root package name */
    private PendingRefreshResult f45618l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f45619m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f45620n;

    /* renamed from: o, reason: collision with root package name */
    private final TVChannelHomeViewModel$localeChangedReceiver$1 f45621o;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f45623e;

        b(boolean z10) {
            this.f45623e = z10;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            lg.a.f68962a.i("TVChannelHomeViewModel", "loadCountryList failed code=" + str + " msg=" + str2, true);
            if (this.f45623e) {
                return;
            }
            TVChannelHomeViewModel.this.q().q(null);
            TVChannelHomeViewModel.this.p().q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(CountryDataBean countryDataBean) {
            List<CountryItem> l11;
            String countryCode;
            if (countryDataBean == null || (l11 = countryDataBean.getItems()) == null) {
                l11 = CollectionsKt.l();
            }
            TVChannelHomeViewModel.this.m().q(l11);
            if (this.f45623e) {
                lg.a.f68962a.c("TVChannelHomeViewModel", "loadCountryList success, country list updated, cache hit skip refresh", false);
                return;
            }
            CountryItem currentCountry = countryDataBean != null ? countryDataBean.getCurrentCountry() : null;
            TVChannelHomeViewModel.this.q().q(currentCountry);
            lg.a.f68962a.c("TVChannelHomeViewModel", "loadCountryList success, first=" + (currentCountry != null ? currentCountry.getCountryName() : null), false);
            if (currentCountry == null || (countryCode = currentCountry.getCountryCode()) == null) {
                return;
            }
            TVChannelHomeViewModel.this.y(countryCode);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45625e;

        c(String str) {
            this.f45625e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            TVChannelHomeViewModel.this.f45620n = false;
            lg.a.f68962a.i("TVChannelHomeViewModel", "loadMore failed code=" + str + " msg=" + str2, true);
            TVChannelHomeViewModel.this.o().q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(TvChannelListDataBean tvChannelListDataBean) {
            List<TvChannelItem> l11;
            TVChannelHomeViewModel.this.f45620n = false;
            TVChannelHomeViewModel.this.f45615i = tvChannelListDataBean != null ? tvChannelListDataBean.getPager() : null;
            TVChannelHomeViewModel tVChannelHomeViewModel = TVChannelHomeViewModel.this;
            if (tvChannelListDataBean == null || (l11 = tvChannelListDataBean.getItems()) == null) {
                l11 = CollectionsKt.l();
            }
            List k11 = tVChannelHomeViewModel.k(l11, false);
            a.C0856a c0856a = lg.a.f68962a;
            String str = this.f45625e;
            int size = k11.size();
            Pager pager = TVChannelHomeViewModel.this.f45615i;
            c0856a.c("TVChannelHomeViewModel", "loadMore success page=" + str + " size=" + size + " hasMore=" + (pager != null ? pager.getHasMore() : null), false);
            TVChannelHomeViewModel.this.o().q(new TvChannelLoadMoreResult(k11, TVChannelHomeViewModel.this.s()));
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f45627e;

        d(long j11) {
            this.f45627e = j11;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            lg.a.f68962a.i("TVChannelHomeViewModel", "requestFirstPageChannels failed code=" + str + " msg=" + str2, true);
            TVChannelHomeViewModel.this.v(this.f45627e, null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(TvChannelListDataBean tvChannelListDataBean) {
            TVChannelHomeViewModel.this.v(this.f45627e, tvChannelListDataBean);
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f45629e;

        e(long j11) {
            this.f45629e = j11;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            lg.a.f68962a.i("TVChannelHomeViewModel", "requestOperateData failed code=" + str + " msg=" + str2, true);
            TVChannelHomeViewModel.this.w(this.f45629e, null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(SubOperateData subOperateData) {
            SubOperateData subOperateData2 = null;
            if (subOperateData != null) {
                List<OperateItem> items = subOperateData.getItems();
                subOperateData2 = SubOperateData.copy$default(subOperateData, items != null ? CollectionsKt.U0(items) : null, null, null, null, 14, null);
            }
            TVChannelHomeViewModel.this.w(this.f45629e, subOperateData2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [android.content.BroadcastReceiver, com.transsion.home.tv.TVChannelHomeViewModel$localeChangedReceiver$1] */
    public TVChannelHomeViewModel(Application app) {
        super(app);
        Intrinsics.h(app, "app");
        this.f45608b = new b0();
        this.f45609c = new b0();
        this.f45610d = new b0();
        this.f45611e = new b0();
        this.f45612f = LazyKt.b(new Function0() { // from class: com.transsion.home.tv.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ql.a C;
                C = TVChannelHomeViewModel.C();
                return C;
            }
        });
        this.f45613g = new Gson();
        this.f45614h = "";
        this.f45616j = true;
        ?? r42 = new BroadcastReceiver() { // from class: com.transsion.home.tv.TVChannelHomeViewModel$localeChangedReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.h(context, "context");
                Intrinsics.h(intent, "intent");
                rl.e.f74676a.b().remove("default_tv_country");
                TVChannelHomeViewModel.this.q().n(null);
                lg.a.f68962a.c("TVChannelHomeViewModel", "locale changed, clear cached tv country", false);
            }
        };
        this.f45621o = r42;
        IntentFilter intentFilter = new IntentFilter(b().getPackageName() + "_LOCALE_CHANGED_ACTION");
        if (Build.VERSION.SDK_INT >= 33) {
            b().registerReceiver(r42, intentFilter, 2);
        } else {
            b().registerReceiver(r42, intentFilter);
        }
    }

    private final void A(long j11, String str) {
        r().c(str).f(sg.d.f75472a.c()).subscribe(new e(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ql.a C() {
        return (ql.a) zg.c.f79537e.a().h(ql.a.class);
    }

    private final void D(long j11) {
        PendingRefreshResult pendingRefreshResult;
        List<TvChannelItem> l11;
        if (j11 == this.f45617k && (pendingRefreshResult = this.f45618l) != null && pendingRefreshResult.getChannelDone() && pendingRefreshResult.getOperateDone()) {
            this.f45619m = false;
            if (pendingRefreshResult.getChannelFailed() || pendingRefreshResult.getChannelData() == null) {
                this.f45610d.q(null);
                return;
            }
            TvChannelListDataBean channelData = pendingRefreshResult.getChannelData();
            this.f45615i = channelData != null ? channelData.getPager() : null;
            List l12 = l(pendingRefreshResult.getOperateData());
            TvChannelListDataBean channelData2 = pendingRefreshResult.getChannelData();
            if (channelData2 == null || (l11 = channelData2.getItems()) == null) {
                l11 = CollectionsKt.l();
            }
            List k11 = k(l11, true);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(l12);
            arrayList.addAll(k11);
            a.C0856a c0856a = lg.a.f68962a;
            int size = l12.size();
            int size2 = k11.size();
            Pager pager = this.f45615i;
            c0856a.c("TVChannelHomeViewModel", "refresh merge success operate=" + size + " channels=" + size2 + " hasMore=" + (pager != null ? pager.getHasMore() : null), false);
            this.f45610d.q(new TvChannelRefreshResult(arrayList, s()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List k(List list, boolean z10) {
        if (list.isEmpty()) {
            return CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        if (z10) {
            String string = b().getString(R$string.home_tv_all_channels);
            Intrinsics.g(string, "getString(...)");
            arrayList.add(new OperateItem(string, PostItemType.TV_CHANNEL_HEADER.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483644, null));
        }
        List list2 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(new OperateItem(null, PostItemType.TV_CHANNEL_ITEM.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (TvChannelItem) it.next(), 1073741821, null));
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private final List l(SubOperateData subOperateData) {
        List arrayList;
        List<OperateItem> items;
        List I0;
        if (subOperateData == null || (items = subOperateData.getItems()) == null || (I0 = CollectionsKt.I0(items, new Comparator() { // from class: com.transsion.home.tv.TVChannelHomeViewModel$convertOperateDataToList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(((OperateItem) t11).getPosition(), ((OperateItem) t12).getPosition());
            }
        })) == null || (arrayList = CollectionsKt.U0(I0)) == null) {
            arrayList = new ArrayList();
        }
        String trendingTitle = subOperateData != null ? subOperateData.getTrendingTitle() : null;
        if (trendingTitle != null && trendingTitle.length() != 0) {
            arrayList.add(new OperateItem(subOperateData != null ? subOperateData.getTrendingTitle() : null, PostItemType.FEEDS_TITLE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483644, null));
        }
        h.c(arrayList, subOperateData != null ? subOperateData.getOps() : null);
        return arrayList;
    }

    private final ql.a r() {
        return (ql.a) this.f45612f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(long j11, TvChannelListDataBean tvChannelListDataBean) {
        PendingRefreshResult pendingRefreshResult;
        if (j11 == this.f45617k && (pendingRefreshResult = this.f45618l) != null) {
            pendingRefreshResult.setChannelDone(true);
            pendingRefreshResult.setChannelData(tvChannelListDataBean);
            pendingRefreshResult.setChannelFailed(tvChannelListDataBean == null);
            D(j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(long j11, SubOperateData subOperateData) {
        PendingRefreshResult pendingRefreshResult;
        if (j11 == this.f45617k && (pendingRefreshResult = this.f45618l) != null) {
            pendingRefreshResult.setOperateDone(true);
            pendingRefreshResult.setOperateData(subOperateData);
            D(j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String str) {
        if (this.f45619m) {
            return;
        }
        this.f45619m = true;
        this.f45614h = str;
        this.f45615i = null;
        this.f45616j = true;
        long j11 = this.f45617k + 1;
        this.f45617k = j11;
        this.f45618l = new PendingRefreshResult(str, false, false, false, null, null, 62, null);
        A(j11, str);
        z(j11, str);
    }

    private final void z(long j11, String str) {
        r().d("1", 10, str).f(sg.d.f75472a.c()).subscribe(new d(j11));
    }

    public final void B(CountryItem country) {
        Intrinsics.h(country, "country");
        this.f45608b.q(country);
        rl.e.f74676a.b().putString("default_tv_country", this.f45613g.toJson(country));
        String countryCode = country.getCountryCode();
        if (countryCode != null) {
            y(countryCode);
        }
    }

    public final b0 m() {
        return this.f45609c;
    }

    public final String n() {
        TvChannelListDataBean channelData;
        List<TvChannelItem> items;
        TvChannelItem tvChannelItem;
        PendingRefreshResult pendingRefreshResult = this.f45618l;
        if (pendingRefreshResult == null || (channelData = pendingRefreshResult.getChannelData()) == null || (items = channelData.getItems()) == null || (tvChannelItem = (TvChannelItem) CollectionsKt.k0(items)) == null) {
            return null;
        }
        return tvChannelItem.getChannelId();
    }

    public final b0 o() {
        return this.f45611e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        super.onCleared();
        b().unregisterReceiver(this.f45621o);
    }

    public final b0 p() {
        return this.f45610d;
    }

    public final b0 q() {
        return this.f45608b;
    }

    public final boolean s() {
        Pager pager = this.f45615i;
        if (pager != null) {
            return Intrinsics.c(pager.getHasMore(), Boolean.TRUE);
        }
        return false;
    }

    public final void t() {
        String string = rl.e.f74676a.b().getString("default_tv_country", "");
        boolean z10 = string == null || string.length() == 0;
        boolean z11 = !z10;
        if (!z10) {
            try {
                CountryItem countryItem = (CountryItem) this.f45613g.fromJson(string, CountryItem.class);
                if (countryItem != null) {
                    this.f45608b.q(countryItem);
                    lg.a.f68962a.c("TVChannelHomeViewModel", "loadCountryList use cache country=" + countryItem.getCountryName(), false);
                    String countryCode = countryItem.getCountryCode();
                    if (countryCode != null) {
                        y(countryCode);
                    }
                }
            } catch (Exception e11) {
                lg.a.f68962a.i("TVChannelHomeViewModel", "restore country from cache failed: " + e11.getMessage(), false);
            }
        }
        r().a().f(sg.d.f75472a.c()).subscribe(new b(z11));
    }

    public final void u() {
        if (this.f45619m || this.f45620n) {
            return;
        }
        Pager pager = this.f45615i;
        String nextPage = pager != null ? pager.getNextPage() : null;
        if (nextPage == null || nextPage.length() == 0) {
            lg.a.f68962a.x("TVChannelHomeViewModel", "loadMoreChannels: nextPage is null, ignore", false);
            return;
        }
        this.f45620n = true;
        this.f45616j = false;
        r().d(nextPage, 10, this.f45614h).f(sg.d.f75472a.c()).subscribe(new c(nextPage));
    }

    public final void x() {
        if (this.f45614h.length() == 0 || this.f45619m) {
            return;
        }
        y(this.f45614h);
    }
}
