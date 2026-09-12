package com.transsion.home.adapter.suboperate.provider;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.baseui.recycler.InterceptView;
import com.transsion.baseui.widget.OperateScrollableHost;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubBannerChildPagerAdapter;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadDialogShowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class i extends BaseItemProvider implements androidx.view.f {

    /* renamed from: e, reason: collision with root package name */
    private final int f44641e;

    /* renamed from: f, reason: collision with root package name */
    private final BaseHomeSubFragment f44642f;

    /* renamed from: g, reason: collision with root package name */
    private final Set f44643g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f44644h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager2 f44645i;

    /* renamed from: j, reason: collision with root package name */
    private ViewPager2 f44646j;

    /* renamed from: k, reason: collision with root package name */
    private InterceptView f44647k;

    /* renamed from: l, reason: collision with root package name */
    private int f44648l;

    /* renamed from: m, reason: collision with root package name */
    private long f44649m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f44650n;

    /* renamed from: o, reason: collision with root package name */
    private com.transsion.home.adapter.suboperate.adapter.u f44651o;

    /* renamed from: p, reason: collision with root package name */
    private SubBannerChildPagerAdapter f44652p;

    /* renamed from: q, reason: collision with root package name */
    private com.transsion.home.adapter.suboperate.adapter.u f44653q;

    /* renamed from: r, reason: collision with root package name */
    private final Runnable f44654r;

    /* loaded from: classes5.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OperateItem f44655a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f44656b;

        a(OperateItem operateItem, i iVar) {
            this.f44655a = operateItem;
            this.f44656b = iVar;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            BannerBean banner = this.f44655a.getBanner();
            if (banner != null ? Intrinsics.c(banner.getAutoPlay(), Boolean.TRUE) : false) {
                Handler handler = this.f44656b.f44644h;
                if (handler != null) {
                    handler.removeCallbacks(this.f44656b.f44654r);
                }
                Handler handler2 = this.f44656b.f44644h;
                if (handler2 != null) {
                    handler2.postDelayed(this.f44656b.f44654r, this.f44656b.f44649m);
                }
            }
            boolean z10 = this.f44656b.f44648l != -1;
            this.f44656b.f44648l = i11;
            this.f44656b.a0(i11, z10);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            int Q = i.this.Q();
            if (Q != -1) {
                i.this.W(Q);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f44658a;

        c(BaseViewHolder baseViewHolder) {
            this.f44658a = baseViewHolder;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = this.f44658a.itemView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            AppStartReport.f54571a.f(new AppStartDotState(AppStartDotState.TRENDING_END, 0L, 2, null));
            return true;
        }
    }

    public i(int i11, BaseHomeSubFragment fragment) {
        Intrinsics.h(fragment, "fragment");
        this.f44641e = i11;
        this.f44642f = fragment;
        this.f44643g = new LinkedHashSet();
        this.f44648l = -1;
        this.f44649m = 5000L;
        U();
        this.f44654r = new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.e
            @Override // java.lang.Runnable
            public final void run() {
                i.Z(i.this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List, T] */
    private final List L(List list, final Function1 function1) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = list;
        boolean m11 = BannerADDataHelper.f44708a.m();
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            BannerData bannerData = (BannerData) next;
            if ((bannerData != null ? bannerData.getBiddingAdData() : null) != null) {
                arrayList.add(next);
            }
        }
        List U0 = CollectionsKt.U0(arrayList);
        if (m11 || U0.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                BannerData bannerData2 = (BannerData) obj;
                if ((bannerData2 != null ? bannerData2.getBiddingAdData() : null) == null) {
                    arrayList2.add(obj);
                }
            }
            ?? U02 = CollectionsKt.U0(arrayList2);
            objectRef.element = U02;
            if (((List) U02).isEmpty()) {
                return (List) objectRef.element;
            }
            BannerADDataHelper.f44708a.k(new Function2() { // from class: com.transsion.home.adapter.suboperate.provider.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit M;
                    M = i.M(Ref.ObjectRef.this, function1, (BiddingIntermediateMaterialBean) obj2, ((Integer) obj3).intValue());
                    return M;
                }
            });
        }
        return (List) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Ref.ObjectRef objectRef, Function1 function1, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, int i11) {
        if (biddingIntermediateMaterialBean == null) {
            return Unit.f67184a;
        }
        if (((List) objectRef.element).size() > i11) {
            ((List) objectRef.element).add(i11, new BannerData(null, null, null, false, null, null, null, null, 0, null, null, biddingIntermediateMaterialBean, 2047, null));
        } else {
            ((List) objectRef.element).add(new BannerData(null, null, null, false, null, null, null, null, 0, null, null, biddingIntermediateMaterialBean, 2047, null));
        }
        function1.invoke(objectRef.element);
        return Unit.f67184a;
    }

    private final void N() {
        Handler handler = this.f44644h;
        if (handler != null) {
            handler.postDelayed(this.f44654r, this.f44649m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(i iVar, List data) {
        Intrinsics.h(data, "data");
        iVar.b0(data);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Q() {
        ViewPager2 viewPager2 = this.f44646j;
        if (viewPager2 == null) {
            Intrinsics.z("cardPager");
            viewPager2 = null;
        }
        return viewPager2.getCurrentItem();
    }

    private final int R(int i11) {
        return 1073741823 - (1073741823 % i11);
    }

    private final void S(List list, OperateItem operateItem) {
        ViewPager2 viewPager2 = this.f44646j;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.z("cardPager");
            viewPager2 = null;
        }
        viewPager2.setPageTransformer(new CompositePageTransformer());
        ViewPager2 viewPager23 = this.f44646j;
        if (viewPager23 == null) {
            Intrinsics.z("cardPager");
            viewPager23 = null;
        }
        viewPager23.setOffscreenPageLimit(3);
        this.f44652p = new SubBannerChildPagerAdapter(list, this.f44641e, operateItem);
        ViewPager2 viewPager24 = this.f44646j;
        if (viewPager24 == null) {
            Intrinsics.z("cardPager");
            viewPager24 = null;
        }
        viewPager24.setAdapter(this.f44652p);
        ViewPager2 viewPager25 = this.f44646j;
        if (viewPager25 == null) {
            Intrinsics.z("cardPager");
        } else {
            viewPager22 = viewPager25;
        }
        viewPager22.registerOnPageChangeCallback(new b());
    }

    private final void U() {
        BaseHomeSubFragment baseHomeSubFragment = this.f44642f;
        Function1 function1 = new Function1() { // from class: com.transsion.home.adapter.suboperate.provider.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit V;
                V = i.V(i.this, (DownloadDialogShowEvent) obj);
                return V;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(baseHomeSubFragment, name, Lifecycle.State.CREATED, y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(i iVar, DownloadDialogShowEvent value) {
        Intrinsics.h(value, "value");
        if (iVar.f44650n) {
            if (value.getShow()) {
                Handler handler = iVar.f44644h;
                if (handler != null) {
                    handler.removeCallbacks(iVar.f44654r);
                }
            } else {
                Handler handler2 = iVar.f44644h;
                if (handler2 != null) {
                    handler2.postDelayed(iVar.f44654r, iVar.f44649m);
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(int i11) {
        ViewPager2 viewPager2 = this.f44645i;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.z("viewPager2");
            viewPager2 = null;
        }
        if (i11 != viewPager2.getCurrentItem()) {
            ViewPager2 viewPager23 = this.f44645i;
            if (viewPager23 == null) {
                Intrinsics.z("viewPager2");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setCurrentItem(i11, true);
        }
    }

    private final void X() {
        List arrayList;
        List g11;
        if (this.f44642f.isAdded() && this.f44642f.isVisible()) {
            ViewPager2 viewPager2 = this.f44645i;
            if (viewPager2 == null) {
                Intrinsics.z("viewPager2");
                viewPager2 = null;
            }
            if (viewPager2.isShown()) {
                com.transsion.home.adapter.suboperate.adapter.u uVar = this.f44653q;
                if (uVar == null || (g11 = uVar.g()) == null || (arrayList = CollectionsKt.U0(g11)) == null) {
                    arrayList = new ArrayList();
                }
                L(arrayList, new Function1() { // from class: com.transsion.home.adapter.suboperate.provider.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Y;
                        Y = i.Y(i.this, (List) obj);
                        return Y;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(i iVar, List data) {
        Intrinsics.h(data, "data");
        iVar.b0(data);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(i iVar) {
        if (!iVar.f44642f.isVisible()) {
            if (iVar.f44642f.isAdded()) {
                iVar.N();
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = iVar.f44645i;
        if (viewPager2 == null) {
            Intrinsics.z("viewPager2");
            viewPager2 = null;
        }
        ViewPager2 viewPager22 = iVar.f44645i;
        if (viewPager22 == null) {
            Intrinsics.z("viewPager2");
            viewPager22 = null;
        }
        int currentItem = viewPager22.getCurrentItem() + 1;
        ViewPager2 viewPager23 = iVar.f44645i;
        if (viewPager23 == null) {
            Intrinsics.z("viewPager2");
            viewPager23 = null;
        }
        RecyclerView.Adapter adapter = viewPager23.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.e(valueOf);
        viewPager2.setCurrentItem(currentItem % valueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(int i11, boolean z10) {
        if (i11 != Q()) {
            ViewPager2 viewPager2 = this.f44646j;
            if (viewPager2 == null) {
                Intrinsics.z("cardPager");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(i11, z10);
        }
    }

    private final void b0(List list) {
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsion.home.adapter.suboperate.adapter.u uVar = this.f44653q;
            if (uVar != null) {
                uVar.i(list);
            }
            com.transsion.home.adapter.suboperate.adapter.u uVar2 = this.f44653q;
            if (uVar2 != null) {
                uVar2.notifyDataSetChanged();
            }
            SubBannerChildPagerAdapter subBannerChildPagerAdapter = this.f44652p;
            if (subBannerChildPagerAdapter != null) {
                subBannerChildPagerAdapter.h(list);
            }
            SubBannerChildPagerAdapter subBannerChildPagerAdapter2 = this.f44652p;
            if (subBannerChildPagerAdapter2 != null) {
                subBannerChildPagerAdapter2.notifyDataSetChanged();
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, OperateItem item) {
        List arrayList;
        String interval;
        Integer v11;
        List<BannerData> banners;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        this.f44645i = (ViewPager2) helper.itemView.findViewById(R$id.sub_operation_view_pager);
        this.f44646j = (ViewPager2) helper.getView(R$id.cardPager);
        InterceptView interceptView = (InterceptView) helper.getView(R$id.interestLayout);
        this.f44647k = interceptView;
        ViewPager2 viewPager2 = null;
        if (interceptView == null) {
            Intrinsics.z("interestLayout");
            interceptView = null;
        }
        ViewPager2 viewPager22 = this.f44646j;
        if (viewPager22 == null) {
            Intrinsics.z("cardPager");
            viewPager22 = null;
        }
        interceptView.setPostView(viewPager22);
        ((OperateScrollableHost) helper.getView(R$id.sub_operation_view_scroll_helper)).interceptAllEvent(true);
        ((OperateScrollableHost) helper.getView(R$id.sub_operation_card_helper)).interceptAllEvent(true);
        BannerBean banner = item.getBanner();
        if (banner == null || (banners = banner.getBanners()) == null || (arrayList = CollectionsKt.U0(banners)) == null) {
            arrayList = new ArrayList();
        }
        List<BannerData> L = L(arrayList, new Function1() { // from class: com.transsion.home.adapter.suboperate.provider.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit P;
                P = i.P(i.this, (List) obj);
                return P;
            }
        });
        BannerBean banner2 = item.getBanner();
        if (banner2 != null) {
            banner2.setBanners(L);
        }
        if (L.isEmpty()) {
            return;
        }
        com.transsion.home.adapter.suboperate.adapter.u uVar = this.f44653q;
        if (uVar == null) {
            this.f44653q = new com.transsion.home.adapter.suboperate.adapter.u(L, this.f44641e, this, item);
        } else if (uVar != null) {
            uVar.i(L);
        }
        this.f44651o = this.f44653q;
        ViewPager2 viewPager23 = this.f44645i;
        if (viewPager23 == null) {
            Intrinsics.z("viewPager2");
            viewPager23 = null;
        }
        viewPager23.setAdapter(this.f44651o);
        S(L, item);
        Handler handler = this.f44644h;
        if (handler != null) {
            handler.removeCallbacks(this.f44654r);
        }
        this.f44644h = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager24 = this.f44645i;
        if (viewPager24 == null) {
            Intrinsics.z("viewPager2");
            viewPager24 = null;
        }
        viewPager24.registerOnPageChangeCallback(new a(item, this));
        BannerBean banner3 = item.getBanner();
        long intValue = ((banner3 == null || (interval = banner3.getInterval()) == null || (v11 = StringsKt.v(interval)) == null) ? 0 : v11.intValue()) * 1000;
        if (intValue <= 0) {
            intValue = this.f44649m;
        }
        this.f44649m = intValue;
        int i11 = this.f44648l;
        if (i11 < 0) {
            i11 = R(L.size());
        }
        ViewPager2 viewPager25 = this.f44645i;
        if (viewPager25 == null) {
            Intrinsics.z("viewPager2");
            viewPager25 = null;
        }
        viewPager25.setCurrentItem(i11, false);
        ViewPager2 viewPager26 = this.f44646j;
        if (viewPager26 == null) {
            Intrinsics.z("cardPager");
        } else {
            viewPager2 = viewPager26;
        }
        viewPager2.setCurrentItem(i11, false);
    }

    public final boolean T(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.f44643g.add(str);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_sub_operation_banner;
    }

    @Override // androidx.view.f
    public /* synthetic */ void onCreate(androidx.view.u uVar) {
        androidx.view.e.a(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onDestroy(androidx.view.u uVar) {
        androidx.view.e.b(this, uVar);
    }

    @Override // androidx.view.f
    public void onPause(androidx.view.u owner) {
        Handler handler;
        Intrinsics.h(owner, "owner");
        androidx.view.e.c(this, owner);
        if (!this.f44650n || (handler = this.f44644h) == null) {
            return;
        }
        handler.removeCallbacks(this.f44654r);
    }

    @Override // androidx.view.f
    public void onResume(androidx.view.u owner) {
        Intrinsics.h(owner, "owner");
        androidx.view.e.d(this, owner);
        if (this.f44650n) {
            Handler handler = this.f44644h;
            if (handler != null) {
                handler.postDelayed(this.f44654r, this.f44649m);
            }
            X();
        }
    }

    @Override // androidx.view.f
    public /* synthetic */ void onStart(androidx.view.u uVar) {
        androidx.view.e.e(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onStop(androidx.view.u uVar) {
        androidx.view.e.f(this, uVar);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void t(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.t(holder);
        this.f44650n = true;
        Handler handler = this.f44644h;
        if (handler != null) {
            handler.postDelayed(this.f44654r, this.f44649m);
        }
        holder.itemView.getViewTreeObserver().addOnPreDrawListener(new c(holder));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void u(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.u(holder);
        this.f44650n = false;
        Handler handler = this.f44644h;
        if (handler != null) {
            handler.removeCallbacks(this.f44654r);
        }
    }
}
