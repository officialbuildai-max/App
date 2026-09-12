package com.transsion.home.adapter.operateUGC.provider;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.indicator.BannerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.widget.OperateScrollableHost;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.operateUGC.adapter.BannerUGCAdapter;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class c extends BaseItemProvider implements androidx.view.f {

    /* renamed from: e, reason: collision with root package name */
    private final int f44387e;

    /* renamed from: f, reason: collision with root package name */
    private final BaseHomeSubFragment f44388f;

    /* renamed from: g, reason: collision with root package name */
    private final Set f44389g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f44390h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager2 f44391i;

    /* renamed from: j, reason: collision with root package name */
    private BannerIndicator f44392j;

    /* renamed from: k, reason: collision with root package name */
    private int f44393k;

    /* renamed from: l, reason: collision with root package name */
    private long f44394l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f44395m;

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f44396n;

    /* loaded from: classes5.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OperateItem f44397a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f44398b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f44399c;

        a(OperateItem operateItem, c cVar, List list) {
            this.f44397a = operateItem;
            this.f44398b = cVar;
            this.f44399c = list;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            BannerBean banner = this.f44397a.getBanner();
            if (banner != null ? Intrinsics.c(banner.getAutoPlay(), Boolean.TRUE) : false) {
                Handler handler = this.f44398b.f44390h;
                if (handler != null) {
                    handler.removeCallbacks(this.f44398b.f44396n);
                }
                Handler handler2 = this.f44398b.f44390h;
                if (handler2 != null) {
                    handler2.postDelayed(this.f44398b.f44396n, this.f44398b.f44394l);
                }
            }
            this.f44398b.f44393k = i11;
            BannerIndicator bannerIndicator = this.f44398b.f44392j;
            if (bannerIndicator == null) {
                Intrinsics.z("circleIndicator");
                bannerIndicator = null;
            }
            bannerIndicator.onPageSelected(i11 % this.f44399c.size());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f44400a;

        b(BaseViewHolder baseViewHolder) {
            this.f44400a = baseViewHolder;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = this.f44400a.itemView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            AppStartReport.f54571a.f(new AppStartDotState(AppStartDotState.TRENDING_END, 0L, 2, null));
            return true;
        }
    }

    public c(int i11, BaseHomeSubFragment fragment) {
        Intrinsics.h(fragment, "fragment");
        this.f44387e = i11;
        this.f44388f = fragment;
        this.f44389g = new LinkedHashSet();
        this.f44393k = -1;
        this.f44394l = 5000L;
        this.f44396n = new Runnable() { // from class: com.transsion.home.adapter.operateUGC.provider.b
            @Override // java.lang.Runnable
            public final void run() {
                c.J(c.this);
            }
        };
    }

    private final void F() {
        Handler handler = this.f44390h;
        if (handler != null) {
            handler.postDelayed(this.f44396n, this.f44394l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(c cVar) {
        BannerIndicator bannerIndicator = cVar.f44392j;
        if (bannerIndicator == null) {
            Intrinsics.z("circleIndicator");
            bannerIndicator = null;
        }
        bannerIndicator.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(c cVar) {
        if (!cVar.f44388f.isVisible()) {
            if (cVar.f44388f.isAdded()) {
                cVar.F();
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = cVar.f44391i;
        if (viewPager2 == null) {
            Intrinsics.z("viewPager2");
            viewPager2 = null;
        }
        ViewPager2 viewPager22 = cVar.f44391i;
        if (viewPager22 == null) {
            Intrinsics.z("viewPager2");
            viewPager22 = null;
        }
        int currentItem = viewPager22.getCurrentItem() + 1;
        ViewPager2 viewPager23 = cVar.f44391i;
        if (viewPager23 == null) {
            Intrinsics.z("viewPager2");
            viewPager23 = null;
        }
        RecyclerView.Adapter adapter = viewPager23.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.e(valueOf);
        viewPager2.setCurrentItem(currentItem % valueOf.intValue());
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, OperateItem item) {
        List<BannerData> arrayList;
        String interval;
        Integer v11;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        this.f44391i = (ViewPager2) helper.itemView.findViewById(R$id.provider_ugc_banner_view_pager);
        ((OperateScrollableHost) helper.itemView.findViewById(R$id.provider_ugc_banner_view_scroll_helper)).interceptAllEvent(true);
        this.f44392j = (BannerIndicator) helper.itemView.findViewById(R$id.provider_ugc_banner_view_pager_indicator);
        BannerBean banner = item.getBanner();
        if (banner == null || (arrayList = banner.getBanners()) == null) {
            arrayList = new ArrayList<>();
        }
        ViewPager2 viewPager2 = this.f44391i;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.z("viewPager2");
            viewPager2 = null;
        }
        viewPager2.setAdapter(new BannerUGCAdapter(arrayList, this.f44387e, this, item));
        if (arrayList.isEmpty()) {
            return;
        }
        Handler handler = this.f44390h;
        if (handler != null) {
            handler.removeCallbacks(this.f44396n);
        }
        this.f44390h = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager23 = this.f44391i;
        if (viewPager23 == null) {
            Intrinsics.z("viewPager2");
            viewPager23 = null;
        }
        viewPager23.registerOnPageChangeCallback(new a(item, this, arrayList));
        BannerIndicator bannerIndicator = this.f44392j;
        if (bannerIndicator == null) {
            Intrinsics.z("circleIndicator");
            bannerIndicator = null;
        }
        com.tn.lib.view.indicator.a indicatorConfig = bannerIndicator.getIndicatorConfig();
        indicatorConfig.s(-1);
        indicatorConfig.q(androidx.core.content.b.getColor(k(), R$color.white_20));
        indicatorConfig.r(com.blankj.utilcode.util.a0.a(4.0f));
        indicatorConfig.t(com.blankj.utilcode.util.a0.a(8.0f));
        indicatorConfig.o(com.blankj.utilcode.util.a0.a(4.0f));
        indicatorConfig.n(arrayList.size());
        BannerIndicator bannerIndicator2 = this.f44392j;
        if (bannerIndicator2 == null) {
            Intrinsics.z("circleIndicator");
            bannerIndicator2 = null;
        }
        bannerIndicator2.post(new Runnable() { // from class: com.transsion.home.adapter.operateUGC.provider.a
            @Override // java.lang.Runnable
            public final void run() {
                c.H(c.this);
            }
        });
        BannerBean banner2 = item.getBanner();
        long intValue = ((banner2 == null || (interval = banner2.getInterval()) == null || (v11 = StringsKt.v(interval)) == null) ? 0 : v11.intValue()) * 1000;
        if (intValue <= 0) {
            intValue = this.f44394l;
        }
        this.f44394l = intValue;
        int i11 = this.f44393k;
        if (i11 < 0) {
            i11 = 1073741823 - (1073741823 % arrayList.size());
        }
        ViewPager2 viewPager24 = this.f44391i;
        if (viewPager24 == null) {
            Intrinsics.z("viewPager2");
        } else {
            viewPager22 = viewPager24;
        }
        viewPager22.setCurrentItem(i11, false);
    }

    public final boolean I(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.f44389g.add(str);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.UGC_BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.provider_ugc_item_banner;
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
        if (!this.f44395m || (handler = this.f44390h) == null) {
            return;
        }
        handler.removeCallbacks(this.f44396n);
    }

    @Override // androidx.view.f
    public void onResume(androidx.view.u owner) {
        Handler handler;
        Intrinsics.h(owner, "owner");
        androidx.view.e.d(this, owner);
        if (!this.f44395m || (handler = this.f44390h) == null) {
            return;
        }
        handler.postDelayed(this.f44396n, this.f44394l);
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
        this.f44395m = true;
        Handler handler = this.f44390h;
        if (handler != null) {
            handler.postDelayed(this.f44396n, this.f44394l);
        }
        holder.itemView.getViewTreeObserver().addOnPreDrawListener(new b(holder));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void u(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.u(holder);
        this.f44395m = false;
        Handler handler = this.f44390h;
        if (handler != null) {
            handler.removeCallbacks(this.f44396n);
        }
    }
}
