package com.transsion.home.adapter.suboperate.provider;

import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.widget.OperateScrollableHost;
import com.transsion.gslb.Utils;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class SubHorizontalBannerProvider extends BaseItemProvider implements androidx.view.f {

    /* renamed from: e, reason: collision with root package name */
    private final int f44576e;

    /* renamed from: f, reason: collision with root package name */
    private final BaseHomeSubFragment f44577f;

    /* renamed from: g, reason: collision with root package name */
    private final Set f44578g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f44579h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager2 f44580i;

    /* renamed from: j, reason: collision with root package name */
    private int f44581j;

    /* renamed from: k, reason: collision with root package name */
    private long f44582k;

    /* renamed from: l, reason: collision with root package name */
    private View f44583l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f44584m;

    /* renamed from: n, reason: collision with root package name */
    private t1 f44585n;

    /* renamed from: o, reason: collision with root package name */
    private OperateItem f44586o;

    /* renamed from: p, reason: collision with root package name */
    private SubHorizontalViewPagerAdapter f44587p;

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f44588q;

    /* loaded from: classes5.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OperateItem f44589a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SubHorizontalBannerProvider f44590b;

        a(OperateItem operateItem, SubHorizontalBannerProvider subHorizontalBannerProvider) {
            this.f44589a = operateItem;
            this.f44590b = subHorizontalBannerProvider;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            List<BannerData> banners;
            BannerData bannerData;
            Image image;
            String averageHueLight;
            List<BannerData> banners2;
            BannerBean banner = this.f44589a.getBanner();
            if (banner != null ? Intrinsics.c(banner.getAutoPlay(), Boolean.TRUE) : false) {
                Handler handler = this.f44590b.f44579h;
                if (handler != null) {
                    handler.removeCallbacks(this.f44590b.f44588q);
                }
                Handler handler2 = this.f44590b.f44579h;
                if (handler2 != null) {
                    handler2.postDelayed(this.f44590b.f44588q, this.f44590b.f44582k);
                }
            }
            this.f44590b.f44581j = i11;
            BannerBean banner2 = this.f44589a.getBanner();
            int size = i11 % ((banner2 == null || (banners2 = banner2.getBanners()) == null) ? 1 : banners2.size());
            BannerBean banner3 = this.f44589a.getBanner();
            if (banner3 != null && (banners = banner3.getBanners()) != null && (bannerData = banners.get(size)) != null && (image = bannerData.getImage()) != null && (averageHueLight = image.getAverageHueLight()) != null) {
                SubHorizontalBannerProvider subHorizontalBannerProvider = this.f44590b;
                View view = null;
                GradientDrawable c11 = il.a.c(StringsKt.Q(averageHueLight, Utils.SEPARATOR, "#ff", false, 4, null), StringsKt.Q(averageHueLight, Utils.SEPARATOR, "#00", false, 4, null), null, 4, null);
                View view2 = subHorizontalBannerProvider.f44583l;
                if (view2 == null) {
                    Intrinsics.z("bgColorView");
                } else {
                    view = view2;
                }
                view.setBackground(c11);
            }
            this.f44590b.L(this.f44589a, size);
        }
    }

    public SubHorizontalBannerProvider(int i11, BaseHomeSubFragment fragment) {
        Intrinsics.h(fragment, "fragment");
        this.f44576e = i11;
        this.f44577f = fragment;
        this.f44578g = new LinkedHashSet();
        this.f44581j = -1;
        this.f44582k = 5000L;
        this.f44588q = new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.x
            @Override // java.lang.Runnable
            public final void run() {
                SubHorizontalBannerProvider.M(SubHorizontalBannerProvider.this);
            }
        };
    }

    private final void H() {
        Handler handler = this.f44579h;
        if (handler != null) {
            handler.postDelayed(this.f44588q, this.f44582k);
        }
    }

    private final boolean J(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.f44578g.add(str);
    }

    private final void K() {
        t1 d11;
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.f44576e), true)) {
            d11 = kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(y0.b()), null, null, new SubHorizontalBannerProvider$registerCourse$1(this, null), 3, null);
            this.f44585n = d11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(OperateItem operateItem, int i11) {
        List<BannerData> banners;
        BannerBean banner = operateItem.getBanner();
        BannerData bannerData = (banner == null || (banners = banner.getBanners()) == null) ? null : banners.get(i11);
        if (J(bannerData != null ? bannerData.getSubjectId() : null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "browse_banner");
            hashMap.put("sequence", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(this.f44576e));
            if (bannerData != null) {
                il.b.c(bannerData, hashMap);
            }
            il.b.a(operateItem, hashMap);
            com.transsion.baselib.helper.a.f43316a.e(SubTabFragment.INSTANCE.a(this.f44576e), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(SubHorizontalBannerProvider subHorizontalBannerProvider) {
        if (!subHorizontalBannerProvider.f44577f.isVisible()) {
            if (subHorizontalBannerProvider.f44577f.isAdded()) {
                subHorizontalBannerProvider.H();
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = subHorizontalBannerProvider.f44580i;
        if (viewPager2 == null) {
            Intrinsics.z("viewPager2");
            viewPager2 = null;
        }
        ViewPager2 viewPager22 = subHorizontalBannerProvider.f44580i;
        if (viewPager22 == null) {
            Intrinsics.z("viewPager2");
            viewPager22 = null;
        }
        int currentItem = viewPager22.getCurrentItem() + 1;
        ViewPager2 viewPager23 = subHorizontalBannerProvider.f44580i;
        if (viewPager23 == null) {
            Intrinsics.z("viewPager2");
            viewPager23 = null;
        }
        RecyclerView.Adapter adapter = viewPager23.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.e(valueOf);
        viewPager2.setCurrentItem(currentItem % valueOf.intValue());
    }

    private final void N() {
        t1 t1Var = this.f44585n;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        this.f44585n = null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, OperateItem item) {
        List<BannerData> arrayList;
        String interval;
        Integer v11;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        this.f44580i = (ViewPager2) helper.getView(R$id.sub_operation_horizontal_view_pager);
        this.f44583l = helper.getView(R$id.sub_operation_banner_bg);
        int min = Math.min(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c()) - com.blankj.utilcode.util.a0.a(112.0f);
        int i11 = (int) ((min * 9.0f) / 16);
        ViewPager2 viewPager2 = this.f44580i;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.z("viewPager2");
            viewPager2 = null;
        }
        viewPager2.getLayoutParams().height = i11;
        ((OperateScrollableHost) helper.getView(R$id.sub_operation_view_scroll_helper)).interceptAllEvent(true);
        int h02 = this.f44577f.h0();
        helper.getView(R$id.sub_operation_banner_space).getLayoutParams().height = h02;
        View view = this.f44583l;
        if (view == null) {
            Intrinsics.z("bgColorView");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewPager2 viewPager23 = this.f44580i;
        if (viewPager23 == null) {
            Intrinsics.z("viewPager2");
            viewPager23 = null;
        }
        layoutParams.height = h02 + viewPager23.getLayoutParams().height;
        BannerBean banner = item.getBanner();
        if (banner == null || (arrayList = banner.getBanners()) == null) {
            arrayList = new ArrayList<>();
        }
        ViewPager2 viewPager24 = this.f44580i;
        if (viewPager24 == null) {
            Intrinsics.z("viewPager2");
            viewPager24 = null;
        }
        viewPager24.setPageTransformer(new CompositePageTransformer());
        ViewPager2 viewPager25 = this.f44580i;
        if (viewPager25 == null) {
            Intrinsics.z("viewPager2");
            viewPager25 = null;
        }
        viewPager25.setOffscreenPageLimit(3);
        ViewPager2 viewPager26 = this.f44580i;
        if (viewPager26 == null) {
            Intrinsics.z("viewPager2");
            viewPager26 = null;
        }
        viewPager26.setAdapter(new SubHorizontalViewPagerAdapter(arrayList, this.f44576e, item, min, i11));
        if (arrayList.isEmpty()) {
            return;
        }
        Handler handler = this.f44579h;
        if (handler != null) {
            handler.removeCallbacks(this.f44588q);
        }
        this.f44579h = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager27 = this.f44580i;
        if (viewPager27 == null) {
            Intrinsics.z("viewPager2");
            viewPager27 = null;
        }
        viewPager27.registerOnPageChangeCallback(new a(item, this));
        BannerBean banner2 = item.getBanner();
        long intValue = ((banner2 == null || (interval = banner2.getInterval()) == null || (v11 = StringsKt.v(interval)) == null) ? 0 : v11.intValue()) * 1000;
        if (intValue <= 0) {
            intValue = this.f44582k;
        }
        this.f44582k = intValue;
        int i12 = this.f44581j;
        if (i12 < 0) {
            i12 = 1073741823 - (1073741823 % arrayList.size());
        }
        ViewPager2 viewPager28 = this.f44580i;
        if (viewPager28 == null) {
            Intrinsics.z("viewPager2");
            viewPager28 = null;
        }
        viewPager28.setCurrentItem(i12, false);
        ViewPager2 viewPager29 = this.f44580i;
        if (viewPager29 == null) {
            Intrinsics.z("viewPager2");
        } else {
            viewPager22 = viewPager29;
        }
        RecyclerView.Adapter adapter = viewPager22.getAdapter();
        Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter");
        this.f44587p = (SubHorizontalViewPagerAdapter) adapter;
        this.f44586o = item;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.HORIZONTAL_BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_sub_operation_horizontal_banner;
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
        if (!this.f44584m || (handler = this.f44579h) == null) {
            return;
        }
        handler.removeCallbacks(this.f44588q);
    }

    @Override // androidx.view.f
    public void onResume(androidx.view.u owner) {
        Handler handler;
        Intrinsics.h(owner, "owner");
        androidx.view.e.d(this, owner);
        if (!this.f44584m || (handler = this.f44579h) == null) {
            return;
        }
        handler.postDelayed(this.f44588q, this.f44582k);
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
        this.f44584m = true;
        Handler handler = this.f44579h;
        if (handler != null) {
            handler.postDelayed(this.f44588q, this.f44582k);
        }
        K();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void u(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.u(holder);
        this.f44584m = false;
        Handler handler = this.f44579h;
        if (handler != null) {
            handler.removeCallbacks(this.f44588q);
        }
        N();
    }
}
