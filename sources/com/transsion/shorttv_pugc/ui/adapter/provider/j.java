package com.transsion.shorttv_pugc.ui.adapter.provider;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv_pugc.bean.BannerBean;
import com.transsion.shorttv_pugc.bean.BannerData;
import com.transsion.shorttv_pugc.bean.Image;
import com.transsion.shorttv_pugc.bean.OperateItem;
import com.transsion.shorttv_pugc.bean.ShortTvItemType;
import com.transsion.shorttv_pugc.ui.adapter.ShortTVBannerAdapter;
import com.transsion.shorttv_pugc.ui.widget.ShortTVBannerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class j extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final Fragment f54126e;

    /* renamed from: f, reason: collision with root package name */
    private final String f54127f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f54128g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f54129h;

    /* renamed from: i, reason: collision with root package name */
    private final int f54130i;

    /* renamed from: j, reason: collision with root package name */
    private ShortTVBannerAdapter f54131j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f54132k;

    /* renamed from: l, reason: collision with root package name */
    private int f54133l;

    /* renamed from: m, reason: collision with root package name */
    private long f54134m;

    /* loaded from: classes6.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f54136b;

        a(View view) {
            this.f54136b = view;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            j jVar = j.this;
            jVar.O(this.f54136b, i11, jVar.f54133l, f11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            if (j.this.f54126e.isResumed()) {
                j.this.M();
                j.this.f54134m = System.currentTimeMillis();
            }
            j.this.f54133l = i11;
        }
    }

    public j(Fragment fragment, String pageName, boolean z10, boolean z11) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(pageName, "pageName");
        this.f54126e = fragment;
        this.f54127f = pageName;
        this.f54128g = z10;
        this.f54129h = z11;
        this.f54130i = com.blankj.utilcode.util.d.c();
        this.f54132k = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.ui.adapter.provider.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsion.shorttv_pugc.utils.a H;
                H = j.H(j.this);
                return H;
            }
        });
        this.f54133l = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.shorttv_pugc.utils.a H(j jVar) {
        return new com.transsion.shorttv_pugc.utils.a(jVar.f54127f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(j jVar, View view, int i11, BannerData item) {
        Intrinsics.h(view, "<unused var>");
        Intrinsics.h(item, "item");
        jVar.N(i11, item);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(j jVar, View view) {
        jVar.O(view, 0, 0, 0.0f);
    }

    private final com.transsion.shorttv_pugc.utils.a L() {
        return (com.transsion.shorttv_pugc.utils.a) this.f54132k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        List data;
        BannerData bannerData;
        List data2;
        int i11 = this.f54133l;
        if (i11 >= 0) {
            ShortTVBannerAdapter shortTVBannerAdapter = this.f54131j;
            if (i11 >= ((shortTVBannerAdapter == null || (data2 = shortTVBannerAdapter.getData()) == null) ? 0 : data2.size())) {
                return;
            }
            long currentTimeMillis = this.f54134m > 0 ? System.currentTimeMillis() - this.f54134m : 0L;
            ShortTVBannerAdapter shortTVBannerAdapter2 = this.f54131j;
            if (shortTVBannerAdapter2 == null || (data = shortTVBannerAdapter2.getData()) == null || (bannerData = (BannerData) data.get(this.f54133l)) == null) {
                return;
            }
            com.transsion.shorttv_pugc.utils.a L = L();
            String str = this.f54127f;
            String value = ShortTvItemType.BANNER.getValue();
            String subjectId = bannerData.getSubjectId();
            Boolean hasResource = bannerData.getHasResource();
            String deepLink = bannerData.getDeepLink();
            Integer valueOf = Integer.valueOf(this.f54133l);
            Image image = bannerData.getImage();
            L.a((r30 & 1) != 0 ? null : str, (r30 & 2) != 0 ? null : "opt", (r30 & 4) != 0 ? null : value, (r30 & 8) != 0 ? null : subjectId, (r30 & 16) != 0 ? null : null, (r30 & 32) != 0 ? null : null, (r30 & 64) != 0 ? null : hasResource, (r30 & 128) != 0 ? null : deepLink, (r30 & 256) != 0 ? null : valueOf, (r30 & 512) != 0 ? null : image != null ? image.getUrl() : null, (r30 & 1024) != 0 ? 0L : currentTimeMillis, (r30 & 2048) != 0 ? Boolean.FALSE : Boolean.valueOf(bannerData.getBuiltIn()), (r30 & 4096) == 0 ? null : null);
        }
    }

    private final void N(int i11, BannerData bannerData) {
        com.transsion.shorttv_pugc.utils.a L = L();
        String str = this.f54127f;
        ShortTvItemType shortTvItemType = ShortTvItemType.BANNER;
        String value = shortTvItemType.getValue();
        String subjectId = bannerData.getSubjectId();
        Boolean hasResource = bannerData.getHasResource();
        String deepLink = bannerData.getDeepLink();
        Integer valueOf = Integer.valueOf(i11);
        Image image = bannerData.getImage();
        L.c(str, "opt", value, (r31 & 8) != 0 ? null : subjectId, (r31 & 16) != 0 ? null : null, (r31 & 32) != 0 ? null : null, (r31 & 64) != 0 ? null : hasResource, (r31 & 128) != 0 ? null : null, (r31 & 256) != 0 ? null : deepLink, (r31 & 512) != 0 ? null : valueOf, (r31 & 1024) != 0 ? null : image != null ? image.getUrl() : null, (r31 & 2048) != 0 ? Boolean.FALSE : Boolean.valueOf(bannerData.getBuiltIn()), (r31 & 4096) != 0 ? null : null);
        String deepLink2 = bannerData.getDeepLink();
        if (deepLink2 != null) {
            Uri a11 = dt.a.f61555a.a(Uri.parse(deepLink2 + "&ops=" + shortTvItemType.getValue()));
            if (a11 != null) {
                ds.c.j(a11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(View view, int i11, int i12, float f11) {
        Image image;
        String averageHueDark;
        Image image2;
        String averageHueDark2;
        List data;
        List data2;
        ShortTVBannerAdapter shortTVBannerAdapter = this.f54131j;
        BannerData bannerData = null;
        BannerData bannerData2 = (shortTVBannerAdapter == null || (data2 = shortTVBannerAdapter.getData()) == null) ? null : (BannerData) data2.get(i11);
        ShortTVBannerAdapter shortTVBannerAdapter2 = this.f54131j;
        if (shortTVBannerAdapter2 != null && (data = shortTVBannerAdapter2.getData()) != null) {
            bannerData = (BannerData) data.get(i12);
        }
        if (bannerData2 == null || (image = bannerData2.getImage()) == null || (averageHueDark = image.getAverageHueDark()) == null || bannerData == null || (image2 = bannerData.getImage()) == null || (averageHueDark2 = image2.getAverageHueDark()) == null) {
            return;
        }
        view.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i11 == i12 ? Color.parseColor(averageHueDark) : i00.a.a(f11, Color.parseColor(averageHueDark), Color.parseColor(averageHueDark2)), 0}));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, OperateItem item) {
        List<BannerData> banners;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        BannerBean banner = item.getBanner();
        if (banner == null || (banners = banner.getBanners()) == null) {
            return;
        }
        final View view = helper.getView(R$id.v_banner_bg);
        helper.getView(R$id.v_top_space);
        View view2 = helper.getView(R$id.v_bar_space);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = this.f54130i + ct.a.a(this.f54129h ? 50 : 10);
        view2.setLayoutParams(bVar);
        ShortTVBannerView shortTVBannerView = (ShortTVBannerView) helper.getView(R$id.banner);
        ShortTVBannerAdapter shortTVBannerAdapter = new ShortTVBannerAdapter();
        shortTVBannerAdapter.k(new Function3() { // from class: com.transsion.shorttv_pugc.ui.adapter.provider.h
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit J;
                J = j.J(j.this, (View) obj, ((Integer) obj2).intValue(), (BannerData) obj3);
                return J;
            }
        });
        shortTVBannerView.setAutoTurningTime(4000L);
        shortTVBannerView.setPagerScrollDuration(1000L);
        shortTVBannerView.setPageMargin(a0.a((this.f54128g ? 3 : 1) * 44.0f), a0.a(16.0f));
        shortTVBannerView.addPageTransformer(new com.to.aboomy.pager2banner.b());
        shortTVBannerView.setOuterPageChangeListener(new a(view));
        shortTVBannerView.setAdapter(shortTVBannerAdapter);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(banners);
        shortTVBannerAdapter.setData(arrayList);
        shortTVBannerView.post(new Runnable() { // from class: com.transsion.shorttv_pugc.ui.adapter.provider.i
            @Override // java.lang.Runnable
            public final void run() {
                j.K(j.this, view);
            }
        });
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return ShortTvItemType.BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.pugc_short_tv_view_banner;
    }
}
