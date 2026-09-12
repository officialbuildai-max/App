package com.transsion.shorttv.ui.adapter.provider;

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
import com.transsion.shorttv.bean.BannerBean;
import com.transsion.shorttv.bean.BannerData;
import com.transsion.shorttv.bean.Image;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.ShortTvItemType;
import com.transsion.shorttv.ui.adapter.ShortTVBannerAdapter;
import com.transsion.shorttv.ui.widget.ShortTVBannerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final Fragment f53241e;

    /* renamed from: f, reason: collision with root package name */
    private final String f53242f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f53243g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f53244h;

    /* renamed from: i, reason: collision with root package name */
    private final int f53245i;

    /* renamed from: j, reason: collision with root package name */
    private ShortTVBannerAdapter f53246j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f53247k;

    /* renamed from: l, reason: collision with root package name */
    private int f53248l;

    /* renamed from: m, reason: collision with root package name */
    private long f53249m;

    /* loaded from: classes6.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f53251b;

        a(View view) {
            this.f53251b = view;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            m mVar = m.this;
            mVar.O(this.f53251b, i11, mVar.f53248l, f11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            if (m.this.f53241e.isResumed()) {
                m.this.M();
                m.this.f53249m = System.currentTimeMillis();
            }
            m.this.f53248l = i11;
        }
    }

    public m(Fragment fragment, String pageName, boolean z10, boolean z11) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(pageName, "pageName");
        this.f53241e = fragment;
        this.f53242f = pageName;
        this.f53243g = z10;
        this.f53244h = z11;
        this.f53245i = com.blankj.utilcode.util.d.c();
        this.f53247k = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.ui.adapter.provider.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsion.shorttv.utils.a H;
                H = m.H(m.this);
                return H;
            }
        });
        this.f53248l = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.shorttv.utils.a H(m mVar) {
        return new com.transsion.shorttv.utils.a(mVar.f53242f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(m mVar, View view, int i11, BannerData item) {
        Intrinsics.h(view, "<unused var>");
        Intrinsics.h(item, "item");
        mVar.N(i11, item);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(m mVar, View view) {
        mVar.O(view, 0, 0, 0.0f);
    }

    private final com.transsion.shorttv.utils.a L() {
        return (com.transsion.shorttv.utils.a) this.f53247k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M() {
        /*
            r22 = this;
            r0 = r22
            int r1 = r0.f53248l
            if (r1 < 0) goto L9d
            com.transsion.shorttv.ui.adapter.ShortTVBannerAdapter r2 = r0.f53246j
            if (r2 == 0) goto L15
            java.util.List r2 = r2.getData()
            if (r2 == 0) goto L15
            int r2 = r2.size()
            goto L16
        L15:
            r2 = 0
        L16:
            if (r1 < r2) goto L1a
            goto L9d
        L1a:
            long r1 = r0.f53249m
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L25
        L22:
            r16 = r3
            goto L2e
        L25:
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r0.f53249m
            long r3 = r1 - r3
            goto L22
        L2e:
            com.transsion.shorttv.ui.adapter.ShortTVBannerAdapter r1 = r0.f53246j
            if (r1 == 0) goto L9d
            java.util.List r1 = r1.getData()
            if (r1 == 0) goto L9d
            int r2 = r0.f53248l
            java.lang.Object r1 = r1.get(r2)
            com.transsion.shorttv.bean.BannerData r1 = (com.transsion.shorttv.bean.BannerData) r1
            if (r1 == 0) goto L9d
            com.transsion.shorttv.utils.a r5 = r22.L()
            java.lang.String r6 = r0.f53242f
            com.transsion.shorttv.bean.ShortTvItemType r2 = com.transsion.shorttv.bean.ShortTvItemType.BANNER
            java.lang.String r8 = r2.getValue()
            java.lang.String r9 = r1.getSubjectId()
            java.lang.String r3 = r1.getOps()
            r4 = 0
            if (r3 != 0) goto L6d
            com.transsion.shorttv.bean.Subject r3 = r1.getSubject()
            if (r3 == 0) goto L64
            java.lang.String r3 = r3.getOps()
            goto L65
        L64:
            r3 = r4
        L65:
            if (r3 != 0) goto L6d
            java.lang.String r2 = r2.getValue()
            r11 = r2
            goto L6e
        L6d:
            r11 = r3
        L6e:
            java.lang.Boolean r12 = r1.getHasResource()
            java.lang.String r13 = r1.getDeepLink()
            int r2 = r0.f53248l
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            com.transsion.shorttv.bean.Image r2 = r1.getImage()
            if (r2 == 0) goto L88
            java.lang.String r2 = r2.getUrl()
            r15 = r2
            goto L89
        L88:
            r15 = r4
        L89:
            boolean r1 = r1.getBuiltIn()
            java.lang.Boolean r18 = java.lang.Boolean.valueOf(r1)
            r20 = 4112(0x1010, float:5.762E-42)
            r21 = 0
            java.lang.String r7 = "opt"
            r10 = 0
            r19 = 0
            com.transsion.shorttv.utils.a.b(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.adapter.provider.m.M():void");
    }

    private final void N(int i11, BannerData bannerData) {
        com.transsion.shorttv.utils.a L = L();
        String str = this.f53242f;
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
            Uri a11 = zr.a.f79573a.a(Uri.parse(deepLink2 + "&ops=" + shortTvItemType.getValue()));
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
        ShortTVBannerAdapter shortTVBannerAdapter = this.f53246j;
        BannerData bannerData = null;
        BannerData bannerData2 = (shortTVBannerAdapter == null || (data2 = shortTVBannerAdapter.getData()) == null) ? null : (BannerData) data2.get(i11);
        ShortTVBannerAdapter shortTVBannerAdapter2 = this.f53246j;
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
        ((ViewGroup.MarginLayoutParams) bVar).height = this.f53245i + yr.a.a(this.f53244h ? 50 : 10);
        view2.setLayoutParams(bVar);
        ShortTVBannerView shortTVBannerView = (ShortTVBannerView) helper.getView(R$id.banner);
        ShortTVBannerAdapter shortTVBannerAdapter = new ShortTVBannerAdapter();
        shortTVBannerAdapter.k(new Function3() { // from class: com.transsion.shorttv.ui.adapter.provider.j
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit J;
                J = m.J(m.this, (View) obj, ((Integer) obj2).intValue(), (BannerData) obj3);
                return J;
            }
        });
        shortTVBannerView.setAutoTurningTime(4000L);
        shortTVBannerView.setPagerScrollDuration(1000L);
        shortTVBannerView.setPageMargin(a0.a((this.f53243g ? 3 : 1) * 44.0f), a0.a(16.0f));
        shortTVBannerView.addPageTransformer(new com.to.aboomy.pager2banner.b());
        shortTVBannerView.setOuterPageChangeListener(new a(view));
        shortTVBannerView.setAdapter(shortTVBannerAdapter);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(banners);
        shortTVBannerAdapter.setData(arrayList);
        shortTVBannerView.post(new Runnable() { // from class: com.transsion.shorttv.ui.adapter.provider.k
            @Override // java.lang.Runnable
            public final void run() {
                m.K(m.this, view);
            }
        });
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return ShortTvItemType.BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.short_tv_view_banner;
    }
}
