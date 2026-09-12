package com.transsion.home.viewmodel;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.view.u0;
import androidx.view.v0;
import com.google.gson.Gson;
import com.transsion.baselib.net.LaunchWithErrorHandlerKt;
import com.transsion.home.adapter.trending.adapter.SportLiveAdapter;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.DisplayMeta;
import com.transsion.home.bean.FeedsLayoutType;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.MainOperateData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.viewmodel.preload.PreloadTrendingBuiltInHelper;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes5.dex */
public final class TrendingUGCViewModel extends androidx.view.b {

    /* renamed from: l, reason: collision with root package name */
    public static final a f45889l = new a(null);

    /* renamed from: m, reason: collision with root package name */
    public static final int f45890m = 8;

    /* renamed from: n, reason: collision with root package name */
    private static TrendingUGCViewModel f45891n;

    /* renamed from: b, reason: collision with root package name */
    private String f45892b;

    /* renamed from: c, reason: collision with root package name */
    private int f45893c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f45894d;

    /* renamed from: e, reason: collision with root package name */
    private List f45895e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f45896f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f45897g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f45898h;

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f45899i;

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f45900j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f45901k;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrendingUGCViewModel a(Application application) {
            Intrinsics.h(application, "application");
            if (TrendingUGCViewModel.f45891n == null) {
                TrendingUGCViewModel.f45891n = (TrendingUGCViewModel) v0.a.f9734e.a(application).create(TrendingUGCViewModel.class);
            }
            return TrendingUGCViewModel.f45891n;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingUGCViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f45892b = "1";
        this.f45893c = 14;
        this.f45896f = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 H;
                H = TrendingUGCViewModel.H();
                return H;
            }
        });
        this.f45897g = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 G;
                G = TrendingUGCViewModel.G();
                return G;
            }
        });
        this.f45898h = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 P;
                P = TrendingUGCViewModel.P();
                return P;
            }
        });
        this.f45899i = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ol.e O;
                O = TrendingUGCViewModel.O();
                return O;
            }
        });
        this.f45900j = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 L;
                L = TrendingUGCViewModel.L();
                return L;
            }
        });
        this.f45901k = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PreloadTrendingBuiltInHelper s11;
                s11 = TrendingUGCViewModel.s();
                return s11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ol.e C() {
        return (ol.e) this.f45899i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(MainOperateData mainOperateData) {
        List<OperateItem> items;
        ArrayList arrayList;
        List<BannerData> banners;
        List<BannerData> banners2;
        List I0;
        if (mainOperateData == null || (items = mainOperateData.getItems()) == null) {
            return;
        }
        List<OperateItem> items2 = mainOperateData.getItems();
        mainOperateData.setItems((items2 == null || (I0 = CollectionsKt.I0(items2, new Comparator() { // from class: com.transsion.home.viewmodel.TrendingUGCViewModel$handlerOperateData$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(((OperateItem) t11).getPosition(), ((OperateItem) t12).getPosition());
            }
        })) == null) ? null : CollectionsKt.U0(I0));
        ArrayList<OperateItem> arrayList2 = new ArrayList();
        for (OperateItem operateItem : items) {
            if (Intrinsics.c(operateItem.getType(), PostItemType.SPORT_LIVE.getValue())) {
                List<LiveListItem> liveList = operateItem.getLiveList();
                if (liveList != null) {
                    arrayList = new ArrayList();
                    for (Object obj : liveList) {
                        if (!Intrinsics.c(((LiveListItem) obj).getStatus(), SportLiveAdapter.P)) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    arrayList2.add(operateItem);
                }
            } else if (Intrinsics.c(operateItem.getType(), PostItemType.UGC_MOVIE_RANK.getValue())) {
                List<UGCContent> contentList = operateItem.getContentList();
                if ((contentList != null ? contentList.size() : 0) >= 3) {
                    arrayList2.add(operateItem);
                }
            } else if (Intrinsics.c(operateItem.getType(), PostItemType.CUSTOM_DATA.getValue())) {
                BannerBean banner = operateItem.getBanner();
                if (((banner == null || (banners = banner.getBanners()) == null) ? 0 : banners.size()) >= 3) {
                    arrayList2.add(operateItem);
                }
            } else {
                if (Intrinsics.c(operateItem.getType(), PostItemType.UGC_BANNER.getValue())) {
                    BannerBean banner2 = operateItem.getBanner();
                    if (((banner2 == null || (banners2 = banner2.getBanners()) == null) ? 0 : banners2.size()) != 0) {
                    }
                }
                arrayList2.add(operateItem);
            }
        }
        Integer groupPos = mainOperateData.getGroupPos();
        if ((groupPos != null ? groupPos.intValue() : 0) > 0) {
            aq.h.f16175a.m(true);
            Integer groupPos2 = mainOperateData.getGroupPos();
            int intValue = groupPos2 != null ? groupPos2.intValue() : 0;
            if (intValue >= items.size()) {
                arrayList2.add(new OperateItem(null, PostItemType.ROOM.getValue(), null, null, "TrendingRoom", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483629, null));
            } else {
                arrayList2.add(intValue, new OperateItem(null, PostItemType.ROOM.getValue(), null, null, "TrendingRoom", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483629, null));
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (OperateItem operateItem2 : arrayList2) {
            String type = operateItem2.getType();
            PostItemType postItemType = PostItemType.UGC_SUBJECT_LIST;
            if (Intrinsics.c(type, postItemType.getValue()) && Intrinsics.c(operateItem2.getStyleTemplate(), com.transsion.home.adapter.operateUGC.b.M)) {
                List<UGCContent> contentList2 = operateItem2.getContentList();
                boolean z10 = (contentList2 != null ? contentList2.size() : 0) % 2 == 0;
                String title = operateItem2.getTitle();
                if (!(title == null || title.length() == 0)) {
                    arrayList3.add(new OperateItem(operateItem2.getTitle(), PostItemType.FEEDS_TITLE.getValue(), null, operateItem2.getDeepLink(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483636, null));
                }
                List<UGCContent> contentList3 = operateItem2.getContentList();
                if (contentList3 != null) {
                    int i11 = 0;
                    for (Object obj2 : contentList3) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt.u();
                        }
                        UGCContent uGCContent = (UGCContent) obj2;
                        if (i11 == 0) {
                            arrayList3.add(new OperateItem(null, PostItemType.TRENDING_FEES_BIG.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, uGCContent.getVideo(), null, null, null, null, null, null, null, operateItem2, null, null, 1877999613, null));
                        } else {
                            if (z10) {
                                List<UGCContent> contentList4 = operateItem2.getContentList();
                                if (contentList4 != null && i11 == contentList4.size() - 1) {
                                }
                            }
                            arrayList3.add(new OperateItem(null, PostItemType.TRENDING_FEES_GRID.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, uGCContent.getVideo(), null, null, null, null, null, null, null, operateItem2, null, null, 1877999613, null));
                        }
                        i11 = i12;
                    }
                }
                arrayList3.add(new OperateItem(null, PostItemType.TRENDING_MARGIN.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483645, null));
            } else {
                if (Intrinsics.c(operateItem2.getType(), postItemType.getValue()) && Intrinsics.c(operateItem2.getStyleTemplate(), com.transsion.home.adapter.operateUGC.b.N)) {
                    operateItem2.setType(PostItemType.UGC_PORTRAIT_GRID.getValue());
                }
                arrayList3.add(operateItem2);
            }
        }
        if (y().f() == null && !nh.m.f70597a.e()) {
            int x10 = x(arrayList3);
            if (x10 >= 0 && x10 < arrayList3.size()) {
                arrayList3.add(x10, new OperateItem(null, PostItemType.NO_NETWORK.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483645, null));
            }
        }
        if (mainOperateData.getTrendingTitle() != null) {
            arrayList3.add(new OperateItem(mainOperateData.getTrendingTitle(), PostItemType.FEEDS_TITLE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483644, null));
        }
        mainOperateData.setItems(arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 G() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 H() {
        return new androidx.view.b0();
    }

    private final void K() {
        LaunchWithErrorHandlerKt.b(this, new TrendingUGCViewModel$requestOperateData$1(this, null), new TrendingUGCViewModel$requestOperateData$2(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 L() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(MainOperateData mainOperateData) {
        List<OperateItem> items;
        if (mainOperateData == null || (items = mainOperateData.getItems()) == null || !(!items.isEmpty())) {
            return;
        }
        String json = new Gson().toJson(mainOperateData);
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        bVar.b().putString("trending_operating_version", mainOperateData.getVersion());
        bVar.b().putString("trending_operating_data", json);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ol.e O() {
        return (ol.e) zg.c.f79537e.a().h(ol.e.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 P() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadTrendingBuiltInHelper s() {
        return new PreloadTrendingBuiltInHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List t(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TrendingRespItem trendingRespItem = (TrendingRespItem) it.next();
            UGCContent content = trendingRespItem.getContent();
            if ((content != null ? content.getVideo() : null) != null) {
                DisplayMeta displayMeta = trendingRespItem.getDisplayMeta();
                if (Intrinsics.c(displayMeta != null ? displayMeta.getLayoutType() : null, FeedsLayoutType.FULL.getValue())) {
                    String value = PostItemType.TRENDING_FEES_BIG.getValue();
                    UGCContent content2 = trendingRespItem.getContent();
                    arrayList.add(new OperateItem(null, value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, content2 != null ? content2.getVideo() : null, null, null, null, null, null, null, null, null, null, null, 2146435069, null));
                } else {
                    DisplayMeta displayMeta2 = trendingRespItem.getDisplayMeta();
                    if (Intrinsics.c(displayMeta2 != null ? displayMeta2.getLayoutType() : null, FeedsLayoutType.HALF.getValue())) {
                        String value2 = PostItemType.TRENDING_FEES_GRID.getValue();
                        UGCContent content3 = trendingRespItem.getContent();
                        arrayList.add(new OperateItem(null, value2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, content3 != null ? content3.getVideo() : null, null, null, null, null, null, null, null, null, null, null, 2146435069, null));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(TrendingUGCViewModel trendingUGCViewModel) {
        String string = rl.e.f74676a.b().getString("trending_room_entrance_cache_v2", "");
        if (string == null || string.length() == 0) {
            lg.a.f68962a.c("TrendingUGCFragment", "fetchGroupInfo failed without cache", true);
        } else {
            trendingUGCViewModel.B().n((RoomEntranceResponse) com.blankj.utilcode.util.o.d(string, RoomEntranceResponse.class));
            lg.a.f68962a.c("TrendingUGCFragment", "fetchGroupInfo use cache", true);
        }
        return Unit.f67184a;
    }

    private final PreloadTrendingBuiltInHelper w() {
        return (PreloadTrendingBuiltInHelper) this.f45901k.getValue();
    }

    public final void A(Context context) {
        Intrinsics.h(context, "context");
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("trending_operating_data", "");
        if (string == null || string.length() == 0) {
            string = w().g(context);
        }
        if (string != null) {
            try {
            } catch (Exception e11) {
                lg.a.f68962a.c("PreloadTrending", "exception when from json " + e11.getMessage(), true);
            }
            if (string.length() != 0) {
                MainOperateData mainOperateData = (MainOperateData) com.blankj.utilcode.util.o.d(string, MainOperateData.class);
                if (mainOperateData != null) {
                    a.C0856a c0856a = lg.a.f68962a;
                    List<OperateItem> items = mainOperateData.getItems();
                    c0856a.c("PreloadTrending", "load operating cache size=" + (items != null ? Integer.valueOf(items.size()) : null) + "}", true);
                    F(mainOperateData);
                    y().n(mainOperateData);
                }
                K();
            }
        }
        lg.a.f68962a.c("PreloadTrending", "preloadOperatingCache json is null", true);
        K();
    }

    public final androidx.view.b0 B() {
        return (androidx.view.b0) this.f45900j.getValue();
    }

    public final List D() {
        return this.f45895e;
    }

    public final androidx.view.b0 E() {
        return (androidx.view.b0) this.f45898h.getValue();
    }

    public final void I() {
        this.f45892b = "1";
        this.f45893c = 14;
        K();
    }

    public final void J() {
        String str;
        if (this.f45894d) {
            return;
        }
        this.f45894d = true;
        TrendingRequestEntity trendingRequestEntity = new TrendingRequestEntity();
        trendingRequestEntity.setPage(this.f45892b);
        trendingRequestEntity.setPerPage(this.f45893c);
        trendingRequestEntity.setSessionId(yg.b.f79132a.h());
        Uri c11 = com.transsion.baselib.report.h.f43402a.c();
        if (c11 == null || (str = c11.toString()) == null) {
            str = "";
        }
        trendingRequestEntity.setDeepLink(str);
        trendingRequestEntity.setLatest_events(new wj.a(wj.b.f77816a.e()));
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new TrendingUGCViewModel$requestFeedsList$1(trendingRequestEntity, this, null), 2, null);
    }

    public final void N(List list) {
        this.f45895e = list;
    }

    public final void u(boolean z10) {
        Function0 function0 = new Function0() { // from class: com.transsion.home.viewmodel.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit v11;
                v11 = TrendingUGCViewModel.v(TrendingUGCViewModel.this);
                return v11;
            }
        };
        if (z10) {
            function0.invoke();
        } else {
            kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new TrendingUGCViewModel$fetchGroupInfo$1(this, function0, null), 2, null);
        }
    }

    public final int x(List operateItems) {
        Intrinsics.h(operateItems, "operateItems");
        OperateItem operateItem = (OperateItem) CollectionsKt.l0(operateItems, 0);
        return Intrinsics.c(operateItem != null ? operateItem.getType() : null, PostItemType.TRENDING_FEES_GRID.getValue()) ? 2 : 1;
    }

    public final androidx.view.b0 y() {
        return (androidx.view.b0) this.f45897g.getValue();
    }

    public final androidx.view.b0 z() {
        return (androidx.view.b0) this.f45896f.getValue();
    }
}
