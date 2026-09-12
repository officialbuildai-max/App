package com.transsion.shorttv.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.transsion.shorttv.bean.AppointSubject;
import com.transsion.shorttv.bean.BannerBean;
import com.transsion.shorttv.bean.BannerData;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.CustomData;
import com.transsion.shorttv.bean.ImmVideoRequestEntity;
import com.transsion.shorttv.bean.Media;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.OperatingResp;
import com.transsion.shorttv.bean.PlayListItem;
import com.transsion.shorttv.bean.RankingListData;
import com.transsion.shorttv.bean.RankingListItem;
import com.transsion.shorttv.bean.ShortTVFavInfo;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.ShortTvInnerPlayBean;
import com.transsion.shorttv.bean.ShortTvItemType;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.bean.Video;
import com.transsion.shorttv.constants.BannerType;
import com.transsion.shorttv.db.ShortTvAdUnlockDao;
import com.transsion.shorttv.db.ShortTvDatabase;
import com.transsion.shorttv.db.ShortTvFavoriteDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class ShortTvViewModel extends t0 {

    /* renamed from: d0, reason: collision with root package name */
    public static final a f53729d0 = new a(null);
    private final HashMap A;
    private final Set B;
    private final b0 C;
    private final b0 D;
    private final LiveData E;
    private final b0 F;
    private final LiveData G;
    private final b0 H;
    private final LiveData I;
    private final b0 J;
    private final LiveData K;
    private final b0 L;
    private LiveData M;
    private final Lazy N;
    private final Lazy O;
    private final Lazy P;
    private final rs.a Q;
    private final Lazy R;
    private final Lazy S;
    private final Lazy T;
    private final Lazy U;
    private final Lazy V;
    private final Lazy W;
    private final Lazy X;
    private final Lazy Y;
    private final Lazy Z;

    /* renamed from: a0, reason: collision with root package name */
    private final HashMap f53731a0;

    /* renamed from: b0, reason: collision with root package name */
    private t1 f53733b0;

    /* renamed from: c0, reason: collision with root package name */
    private final HashMap f53735c0;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f53739g;

    /* renamed from: h, reason: collision with root package name */
    private final LiveData f53740h;

    /* renamed from: i, reason: collision with root package name */
    private String f53741i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f53742j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f53743k;

    /* renamed from: l, reason: collision with root package name */
    private final b0 f53744l;

    /* renamed from: m, reason: collision with root package name */
    private final LiveData f53745m;

    /* renamed from: n, reason: collision with root package name */
    private final b0 f53746n;

    /* renamed from: o, reason: collision with root package name */
    private final b0 f53747o;

    /* renamed from: p, reason: collision with root package name */
    private final LiveData f53748p;

    /* renamed from: q, reason: collision with root package name */
    private final b0 f53749q;

    /* renamed from: r, reason: collision with root package name */
    private final LiveData f53750r;

    /* renamed from: s, reason: collision with root package name */
    private final b0 f53751s;

    /* renamed from: t, reason: collision with root package name */
    private final LiveData f53752t;

    /* renamed from: u, reason: collision with root package name */
    private List f53753u;

    /* renamed from: v, reason: collision with root package name */
    private ConcurrentHashMap f53754v;

    /* renamed from: w, reason: collision with root package name */
    private final b0 f53755w;

    /* renamed from: x, reason: collision with root package name */
    private final b0 f53756x;

    /* renamed from: y, reason: collision with root package name */
    private final b0 f53757y;

    /* renamed from: z, reason: collision with root package name */
    private final b0 f53758z;

    /* renamed from: a, reason: collision with root package name */
    private final os.a f53730a = (os.a) zg.c.f79537e.a().h(os.a.class);

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f53732b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f53734c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private final b0 f53736d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private final b0 f53737e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private final b0 f53738f = new b0();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShortTvViewModel() {
        b0 b0Var = new b0();
        this.f53739g = b0Var;
        this.f53740h = b0Var;
        b0 b0Var2 = new b0();
        this.f53744l = b0Var2;
        this.f53745m = b0Var2;
        this.f53746n = new b0();
        b0 b0Var3 = new b0();
        this.f53747o = b0Var3;
        this.f53748p = b0Var3;
        b0 b0Var4 = new b0();
        this.f53749q = b0Var4;
        this.f53750r = b0Var4;
        b0 b0Var5 = new b0();
        this.f53751s = b0Var5;
        this.f53752t = b0Var5;
        this.f53753u = new ArrayList();
        this.f53754v = new ConcurrentHashMap();
        this.f53755w = new b0();
        this.f53756x = new b0();
        this.f53757y = new b0();
        this.f53758z = new b0();
        this.A = new HashMap();
        this.B = new LinkedHashSet();
        this.C = new b0();
        b0 b0Var6 = new b0();
        this.D = b0Var6;
        this.E = b0Var6;
        b0 b0Var7 = new b0();
        this.F = b0Var7;
        this.G = b0Var7;
        b0 b0Var8 = new b0();
        this.H = b0Var8;
        this.I = b0Var8;
        b0 b0Var9 = new b0();
        this.J = b0Var9;
        this.K = b0Var9;
        b0 b0Var10 = new b0();
        this.L = b0Var10;
        this.M = b0Var10;
        this.N = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ps.a V0;
                V0 = ShortTvViewModel.V0();
                return V0;
            }
        });
        this.O = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortTvFavoriteDao Q;
                Q = ShortTvViewModel.Q(ShortTvViewModel.this);
                return Q;
            }
        });
        this.P = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortTvAdUnlockDao J;
                J = ShortTvViewModel.J(ShortTvViewModel.this);
                return J;
            }
        });
        this.Q = lr.c.f69154a.c();
        this.R = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qs.d h12;
                h12 = ShortTvViewModel.h1(ShortTvViewModel.this);
                return h12;
            }
        });
        this.S = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qs.g k12;
                k12 = ShortTvViewModel.k1(ShortTvViewModel.this);
                return k12;
            }
        });
        this.T = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qs.f j12;
                j12 = ShortTvViewModel.j1(ShortTvViewModel.this);
                return j12;
            }
        });
        this.U = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qs.a o12;
                o12 = ShortTvViewModel.o1(ShortTvViewModel.this);
                return o12;
            }
        });
        this.V = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qs.h l12;
                l12 = ShortTvViewModel.l1(ShortTvViewModel.this);
                return l12;
            }
        });
        this.W = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qs.l p12;
                p12 = ShortTvViewModel.p1(ShortTvViewModel.this);
                return p12;
            }
        });
        this.X = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qs.k n12;
                n12 = ShortTvViewModel.n1(ShortTvViewModel.this);
                return n12;
            }
        });
        this.Y = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortTvViewModel.g(ShortTvViewModel.this);
                return null;
            }
        });
        this.Z = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.viewmodel.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qs.i m12;
                m12 = ShortTvViewModel.m1(ShortTvViewModel.this);
                return m12;
            }
        });
        this.f53731a0 = new HashMap();
        this.f53735c0 = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I0(String str, Subject subject, Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new ShortTvViewModel$getTrailerItem$2(subject, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTvAdUnlockDao J(ShortTvViewModel shortTvViewModel) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ShortTvDatabase.Companion companion2 = ShortTvDatabase.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            m1185constructorimpl = Result.m1185constructorimpl(companion2.b(a11).j0());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "ShortTvViewModel", "adUnlockDao init failed: " + m1188exceptionOrNullimpl, false, 4, null);
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        return (ShortTvAdUnlockDao) m1185constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L0(List list) {
        int size = this.f53753u.size();
        List list2 = this.f53753u;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((ShortTVItem) it.next()).getEp()));
        }
        Set V0 = CollectionsKt.V0(arrayList);
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (!V0.contains(Integer.valueOf(((ShortTVItem) obj).getEp()))) {
                    arrayList2.add(obj);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                this.f53753u.add((ShortTVItem) it2.next());
            }
        }
        return this.f53753u.size() > size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(OperatingResp operatingResp) {
        List<OperateItem> items;
        List<RankingListItem> items2;
        List<BannerData> items3;
        List<BannerData> banners;
        if (operatingResp == null || (items = operatingResp.getItems()) == null) {
            return;
        }
        for (OperateItem operateItem : items) {
            operateItem.setOps(operatingResp.getOps());
            BannerBean banner = operateItem.getBanner();
            if (banner != null && (banners = banner.getBanners()) != null) {
                for (BannerData bannerData : banners) {
                    if (bannerData != null) {
                        bannerData.setOps(operatingResp.getOps());
                    }
                }
            }
            List<AppointSubject> subjects = operateItem.getSubjects();
            if (subjects != null) {
                Iterator<T> it = subjects.iterator();
                while (it.hasNext()) {
                    ((AppointSubject) it.next()).setOps(operatingResp.getOps());
                }
            }
            CustomData customData = operateItem.getCustomData();
            if (customData != null && (items3 = customData.getItems()) != null) {
                Iterator<T> it2 = items3.iterator();
                while (it2.hasNext()) {
                    ((BannerData) it2.next()).setOps(operatingResp.getOps());
                }
            }
            List<Subject> rankings = operateItem.getRankings();
            if (rankings != null) {
                Iterator<T> it3 = rankings.iterator();
                while (it3.hasNext()) {
                    ((Subject) it3.next()).setOps(operatingResp.getOps());
                }
            }
            RankingListData rankingListData = operateItem.getRankingListData();
            if (rankingListData != null && (items2 = rankingListData.getItems()) != null) {
                for (RankingListItem rankingListItem : items2) {
                    rankingListItem.setOps(operatingResp.getOps());
                    List<Subject> subjects2 = rankingListItem.getSubjects();
                    if (subjects2 != null) {
                        Iterator<T> it4 = subjects2.iterator();
                        while (it4.hasNext()) {
                            ((Subject) it4.next()).setOps(operatingResp.getOps());
                        }
                    }
                }
            }
            PlayListItem playListData = operateItem.getPlayListData();
            if (playListData != null) {
                playListData.setOps(operatingResp.getOps());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTvFavoriteDao Q(ShortTvViewModel shortTvViewModel) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ShortTvDatabase.Companion companion2 = ShortTvDatabase.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            m1185constructorimpl = Result.m1185constructorimpl(companion2.b(a11).k0());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "ShortTvViewModel", "favoriteDao init failed: " + m1188exceptionOrNullimpl, false, 4, null);
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        return (ShortTvFavoriteDao) m1185constructorimpl;
    }

    private final void R(OperatingResp operatingResp) {
        ArrayList arrayList;
        List<BannerData> banners;
        List U0;
        List<OperateItem> items = operatingResp.getItems();
        if (items != null) {
            for (OperateItem operateItem : items) {
                if (Intrinsics.c(operateItem.getType(), ShortTvItemType.BANNER.getValue())) {
                    BannerBean banner = operateItem.getBanner();
                    if (banner == null || (banners = banner.getBanners()) == null || (U0 = CollectionsKt.U0(banners)) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (Object obj : U0) {
                            BannerData bannerData = (BannerData) obj;
                            if (bannerData == null || bannerData.getType() != BannerType.GUIDE.ordinal()) {
                                if (bannerData == null || bannerData.getType() != BannerType.AD.ordinal()) {
                                    arrayList.add(obj);
                                }
                            }
                        }
                    }
                    BannerBean banner2 = operateItem.getBanner();
                    if (banner2 != null) {
                        banner2.setBanners(arrayList);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTvAdUnlockDao U() {
        return (ShortTvAdUnlockDao) this.P.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ps.a V0() {
        return new ps.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(String str, List list) {
        b0 b0Var;
        List list2;
        ShortTVItem shortTVItem;
        ShortTVItem shortTVItem2;
        ShortTVItem shortTVItem3;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "ShortTvViewModel", "--------putEpisodeMap subjectId" + str + "----ep:" + ((list == null || (shortTVItem3 = (ShortTVItem) CollectionsKt.k0(list)) == null) ? null : Integer.valueOf(shortTVItem3.getEp())) + "-" + ((list == null || (shortTVItem2 = (ShortTVItem) CollectionsKt.v0(list)) == null) ? null : Integer.valueOf(shortTVItem2.getEp())), false, 4, null);
        List list3 = list;
        if (list3 == null || list3.isEmpty()) {
            return;
        }
        if (this.f53754v.contains(str)) {
            b0Var = (b0) this.f53754v.get(str);
        } else {
            b0 b0Var2 = new b0();
            b0Var2.q(new ArrayList());
            this.f53754v.put(str, b0Var2);
            b0Var = b0Var2;
        }
        List list4 = b0Var != null ? (List) b0Var.f() : null;
        if (list4 == null) {
            list4 = new ArrayList();
            if (b0Var != null) {
                b0Var.q(list4);
            }
        }
        int ep2 = (b0Var == null || (list2 = (List) b0Var.f()) == null || (shortTVItem = (ShortTVItem) CollectionsKt.k0(list2)) == null) ? 0 : shortTVItem.getEp();
        ShortTVItem shortTVItem4 = (ShortTVItem) CollectionsKt.k0(list);
        int ep3 = shortTVItem4 != null ? shortTVItem4.getEp() : 0;
        Boolean bool = (Boolean) this.f53756x.f();
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        a.C0856a.f(c0856a, "ShortTvViewModel", "putEpisodeMap isNeedPlayCurEp" + booleanValue + ",playingEp: " + this.f53755w.f() + " ", false, 4, null);
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ShortTVItem shortTVItem5 = (ShortTVItem) it.next();
            if (booleanValue) {
                int ep4 = shortTVItem5.getEp();
                Integer num = (Integer) this.f53755w.f();
                if (num != null && ep4 == num.intValue()) {
                    a.C0856a.f(lg.a.f68962a, "ShortTvViewModel", "AudioTrack change----play  ep:" + shortTVItem5.getEp(), false, 4, null);
                    this.f53756x.q(Boolean.FALSE);
                    this.f53757y.q(shortTVItem5);
                    break;
                }
            }
        }
        if (ep2 > ep3) {
            list4.addAll(0, list);
        } else {
            list4.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTvFavoriteDao b0() {
        return (ShortTvFavoriteDao) this.O.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(OperatingResp operatingResp) {
        if (operatingResp.getItems() == null || !(!r0.isEmpty())) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        List<BannerData> banners = operatingResp.getBanners();
        a.C0856a.v(c0856a, "ShortTvViewModel", "Cache--保存运营位缓存 banner:" + (banners != null ? Integer.valueOf(banners.size()) : null), false, 4, null);
        R(operatingResp);
        com.transsion.shorttv.utils.h.f53707a.d().putString("short_tv_operating_data", new Gson().toJson(operatingResp));
    }

    public static /* synthetic */ qs.e g(ShortTvViewModel shortTvViewModel) {
        i1(shortTvViewModel);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.d h1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    private static final qs.e i1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar == null) {
            return null;
        }
        aVar.j();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.f j1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ps.a k0() {
        return (ps.a) this.N.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.g k1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.h l1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.i m1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar != null) {
            return aVar.l();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.k n1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.a o1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar != null) {
            return aVar.i();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.l p1(ShortTvViewModel shortTvViewModel) {
        rs.a aVar = shortTvViewModel.Q;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public static /* synthetic */ void q0(ShortTvViewModel shortTvViewModel, String str, int i11, boolean z10, String str2, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        shortTvViewModel.p0(str, i11, z10, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(String str, ShortTVFavInfo shortTVFavInfo) {
        if (shortTVFavInfo == null) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$updateFavorite$1(this, shortTVFavInfo, str, null), 3, null);
    }

    public final qs.h A0() {
        return (qs.h) this.V.getValue();
    }

    public final qs.i B0() {
        return (qs.i) this.Z.getValue();
    }

    public final qs.k C0() {
        return (qs.k) this.X.getValue();
    }

    public final qs.a D0() {
        return (qs.a) this.U.getValue();
    }

    public final qs.l E0() {
        return (qs.l) this.W.getValue();
    }

    public final LiveData F0() {
        return this.f53750r;
    }

    public final LiveData G0() {
        return this.I;
    }

    public final LiveData H0() {
        return this.f53740h;
    }

    public final LiveData J0() {
        return this.M;
    }

    public final void K(int i11, long j11) {
        if (i11 <= 0 || this.B.contains(Integer.valueOf(i11))) {
            return;
        }
        this.A.put(Integer.valueOf(i11), Long.valueOf(j11));
    }

    public final b0 K0() {
        return this.f53737e;
    }

    public final void L(int i11) {
        this.B.remove(Integer.valueOf(i11));
    }

    public final void M(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        Set keySet = this.f53735c0.keySet();
        Intrinsics.g(keySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : keySet) {
            String str = (String) obj;
            Intrinsics.e(str);
            if (StringsKt.W(str, subjectId, false, 2, null)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f53735c0.remove((String) it.next());
        }
    }

    public final void N() {
        this.F.q(null);
    }

    public final boolean N0() {
        return this.f53743k;
    }

    public final void O() {
        this.J.q(null);
    }

    public final boolean O0() {
        return this.f53742j;
    }

    public final void P(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        String subjectId;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$favorite$1(this, subject, subjectId, shortTVFavInfo.getHasFavorite(), shortTVFavInfo, null), 3, null);
    }

    public final void P0(Context context) {
        Intrinsics.h(context, "context");
        a.C0856a.r(lg.a.f68962a, "ShortTvViewModel", new String[]{"Cache---开始处理缓存"}, false, 4, null);
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new ShortTvViewModel$loadCache$1(this, context, null), 2, null);
    }

    public final void Q0(Set eps) {
        Subject subject;
        Set adUnlockedEps;
        Intrinsics.h(eps, "eps");
        if (eps.isEmpty() || (subject = (Subject) this.f53739g.f()) == null || (adUnlockedEps = subject.getAdUnlockedEps()) == null) {
            return;
        }
        adUnlockedEps.addAll(eps);
    }

    public final void R0(int i11) {
        Subject subject = (Subject) this.f53739g.f();
        if (subject != null) {
            subject.setPaid(i11);
        }
    }

    public final int S(int i11, ShortTvInnerPlayBean shortTvInnerPlayBean, Subject subject, int i12, boolean z10) {
        int i13;
        int ep2;
        lr.c cVar = lr.c.f69154a;
        boolean b11 = cVar.b().b();
        if (i11 >= 0) {
            if (i11 != 0 || b11) {
                return i11;
            }
            return 1;
        }
        Integer valueOf = (shortTvInnerPlayBean == null || ((ep2 = shortTvInnerPlayBean.getEp()) == 0 && !b11)) ? null : Integer.valueOf(ep2);
        if (valueOf != null) {
            i13 = valueOf.intValue();
        } else {
            i13 = ((subject != null ? subject.getTrailer() : null) == null || !cVar.b().b()) ? 1 : 0;
        }
        return i12 >= 0 ? (!z10 || valueOf == null || valueOf.intValue() == i12) ? i12 : i13 : i13;
    }

    public final void S0() {
        this.f53744l.q(Unit.f67184a);
    }

    public final void T(String subjectId, int i11) {
        Intrinsics.h(subjectId, "subjectId");
        this.f53731a0.remove(subjectId + i11);
        M(subjectId);
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new ShortTvViewModel$forceRefreshSubjectInfo$1(this, subjectId, null), 2, null);
    }

    public final void T0() {
        this.f53758z.q(this.f53755w.f());
    }

    public final void U0(String subjectId, int i11, lo.f fVar) {
        List<ShortTVItem> list;
        List<Video> addressList;
        Object obj;
        Map a11;
        Intrinsics.h(subjectId, "subjectId");
        b0 b0Var = (b0) this.f53754v.get(subjectId);
        if (b0Var == null || (list = (List) b0Var.f()) == null) {
            return;
        }
        for (ShortTVItem shortTVItem : list) {
            boolean z10 = false;
            int i12 = com.transsion.shorttv.utils.h.f53707a.d().getInt("k_short_tv_resolution", 0);
            Media video = shortTVItem.getVideo();
            if (video != null && (addressList = video.getAddressList()) != null) {
                Iterator<T> it = addressList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.c(((Video) obj).getResolution(), String.valueOf(i12))) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Video video2 = (Video) obj;
                if (video2 != null) {
                    if (fVar != null && (a11 = fVar.a()) != null) {
                        z10 = a11.containsKey(video2.getUrl());
                    }
                    if (!z10) {
                        int ep2 = (shortTVItem.getEp() - i11) + 1;
                        int ep3 = shortTVItem.getEp();
                        int i13 = ep2 > 0 ? (ep3 - i11) + 1 : ep3 + i11;
                        if (fVar != null) {
                            String url = video2.getUrl();
                            String url2 = video2.getUrl();
                            if (url2 == null) {
                                url2 = "";
                            }
                            fVar.addDataSource(new ao.e(url, url2, i13, null, null, 24, null));
                        }
                    }
                }
            }
        }
    }

    public final b0 V() {
        return this.f53757y;
    }

    public final long W(int i11) {
        Long l11 = (Long) this.A.get(Integer.valueOf(i11));
        if (l11 != null) {
            return l11.longValue();
        }
        return 0L;
    }

    public final void W0(String resolution, int i11, lo.f fVar) {
        String subjectId;
        b0 b0Var;
        List<ShortTVItem> list;
        List<Video> addressList;
        Object obj;
        Map a11;
        Intrinsics.h(resolution, "resolution");
        Subject subject = (Subject) this.f53740h.f();
        if (subject == null || (subjectId = subject.getSubjectId()) == null || (b0Var = (b0) this.f53754v.get(subjectId)) == null || (list = (List) b0Var.f()) == null) {
            return;
        }
        for (ShortTVItem shortTVItem : list) {
            Media video = shortTVItem.getVideo();
            if (video != null && (addressList = video.getAddressList()) != null) {
                Iterator<T> it = addressList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.c(((Video) obj).getResolution(), resolution)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Video video2 = (Video) obj;
                if (video2 != null) {
                    if (!((fVar == null || (a11 = fVar.a()) == null) ? false : a11.containsKey(video2.getUrl()))) {
                        int ep2 = (shortTVItem.getEp() - i11) + 1;
                        int ep3 = shortTVItem.getEp();
                        int i12 = ep2 > 0 ? (ep3 - i11) + 1 : ep3 + i11;
                        if (fVar != null) {
                            String url = video2.getUrl();
                            String url2 = video2.getUrl();
                            if (url2 == null) {
                                url2 = "";
                            }
                            fVar.addDataSource(new ao.e(url, url2, i12, null, null, 24, null));
                        }
                    }
                }
            }
        }
    }

    public final b0 X() {
        return this.f53756x;
    }

    public final String Y() {
        return this.f53741i;
    }

    public final void Y0() {
        t1 t1Var = this.f53733b0;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        this.f53733b0 = null;
        this.f53742j = true;
        this.f53741i = null;
        this.f53743k = false;
        this.f53732b.set(false);
        this.f53734c.set(false);
        this.f53739g.q(null);
        this.f53747o.q(null);
        this.f53749q.q(null);
        this.f53751s.q(null);
        b0 b0Var = this.D;
        Boolean bool = Boolean.FALSE;
        b0Var.q(bool);
        this.F.q(null);
        this.H.q(bool);
        this.J.q(null);
        this.L.q(bool);
        this.C.q(bool);
        this.f53756x.q(bool);
        this.f53753u.clear();
        this.f53754v.clear();
        this.f53731a0.clear();
        this.f53735c0.clear();
        this.A.clear();
        this.B.clear();
    }

    public final LiveData Z() {
        return this.f53748p;
    }

    public final void Z0(int i11) {
        this.A.remove(Integer.valueOf(i11));
        this.B.add(Integer.valueOf(i11));
    }

    public final b0 a0() {
        String subjectId;
        Subject subject = (Subject) this.f53740h.f();
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            return null;
        }
        return (b0) this.f53754v.get(subjectId);
    }

    public final void a1(String subjectId) {
        Set adUnlockedEps;
        Intrinsics.h(subjectId, "subjectId");
        a.C0856a c0856a = lg.a.f68962a;
        Subject subject = (Subject) this.f53740h.f();
        a.C0856a.r(c0856a, "ShortTvViewModel", new String[]{"will saveAdUnlockedEps, eps: " + (subject != null ? subject.getAdUnlockedEps() : null)}, false, 4, null);
        Subject subject2 = (Subject) this.f53740h.f();
        if (subject2 == null || (adUnlockedEps = subject2.getAdUnlockedEps()) == null || adUnlockedEps.isEmpty()) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$saveAdUnlockedEps$1(subjectId, adUnlockedEps, this, null), 3, null);
    }

    public final void b1(Subject subject, ShortTVItem shortTVItem, long j11) {
        if (subject == null || shortTVItem == null || zr.b.f79574a.c(subject, shortTVItem)) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new ShortTvViewModel$saveHistory$1(this, subject, shortTVItem, j11, null), 2, null);
    }

    public final b0 c0() {
        return this.f53738f;
    }

    public final LiveData d0() {
        return this.E;
    }

    public final void d1(int i11) {
        List list = (List) this.f53750r.f();
        if (list == null) {
            list = CollectionsKt.l();
        }
        Iterator it = list.iterator();
        int i12 = 0;
        while (true) {
            if (!it.hasNext()) {
                i12 = -1;
                break;
            }
            js.k kVar = (js.k) it.next();
            if ((kVar instanceof js.e) && ((js.e) kVar).c() == i11) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 >= 0) {
            Integer num = (Integer) this.f53755w.f();
            if (num != null && i11 == num.intValue()) {
                return;
            }
            this.f53755w.q(Integer.valueOf(i11));
            return;
        }
        a.C0856a.f(lg.a.f68962a, "ShortTvViewModel", "scrollToEp：" + i11 + " 当前不存在该集", false, 4, null);
    }

    public final LiveData e0() {
        return this.G;
    }

    public final void e1(boolean z10) {
        this.f53743k = z10;
    }

    public final LiveData f0() {
        return this.K;
    }

    public final void f1(String str) {
        this.f53741i = str;
    }

    public final b0 g0() {
        return this.f53758z;
    }

    public final void g1(boolean z10) {
        this.f53742j = z10;
    }

    public final void h0(int i11) {
        if (!nh.m.f70597a.e()) {
            this.f53736d.q(null);
        } else {
            com.transsion.shorttv.utils.h.f53707a.d().getString("key_short_tv_operation_version", "");
            kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$getOperatingList$1(this, i11, null), 3, null);
        }
    }

    public final b0 i0() {
        return this.f53736d;
    }

    public final b0 j0() {
        return this.f53755w;
    }

    public final b0 l0() {
        return this.f53746n;
    }

    public final LiveData m0() {
        return this.f53745m;
    }

    public final void n0(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        if (subjectId.length() == 0) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$getShortTVDubInfo$1(this, subjectId, null), 3, null);
    }

    public final void o0() {
        q0(this, "1", 8, false, null, 8, null);
    }

    public final void p0(String nextPage, int i11, boolean z10, String str) {
        Intrinsics.h(nextPage, "nextPage");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$getShortTVFavoriteList$1(this, nextPage, i11, z10, str, null), 3, null);
    }

    public final void q1(boolean z10) {
        this.H.q(Boolean.valueOf(z10));
    }

    public final void r0(String nextPage, int i11, boolean z10) {
        Intrinsics.h(nextPage, "nextPage");
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(nextPage);
        immVideoRequestEntity.setPerPage(i11);
        immVideoRequestEntity.setSessionId(yg.b.f79132a.h());
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$getShortTVTrending$1(immVideoRequestEntity, this, z10, null), 3, null);
    }

    public final qs.d s0() {
        return (qs.d) this.R.getValue();
    }

    public final void s1(Subject subject, js.e eVar, long j11) {
        String str;
        Media video;
        Video videoAddress;
        if (subject == null || eVar == null) {
            return;
        }
        String e11 = eVar.e();
        ShortTVItem d11 = eVar.d();
        if (d11 == null || (str = d11.getId()) == null) {
            str = "";
        }
        String str2 = str;
        int c11 = eVar.c();
        ShortTVItem d12 = eVar.d();
        int se2 = d12 != null ? d12.getSe() : 1;
        int totalEpisode = subject.getTotalEpisode();
        String title = subject.getTitle();
        String description = subject.getDescription();
        Cover cover = subject.getCover();
        String url = cover != null ? cover.getUrl() : null;
        Cover cover2 = subject.getCover();
        String thumbnail = cover2 != null ? cover2.getThumbnail() : null;
        ShortTVItem d13 = eVar.d();
        String videoId = d13 != null ? d13.getVideoId() : null;
        ShortTVItem d14 = eVar.d();
        ShortTvInnerPlayBean shortTvInnerPlayBean = new ShortTvInnerPlayBean(e11, str2, c11, se2, totalEpisode, j11, title, description, url, thumbnail, videoId, (d14 == null || (video = d14.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null) ? null : videoAddress.getUrl(), System.currentTimeMillis(), null, 8192, null);
        a.C0856a.f(lg.a.f68962a, "ShortTvViewModel", "updateLiveHistory:" + shortTvInnerPlayBean, false, 4, null);
        this.J.q(shortTvInnerPlayBean);
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new ShortTvViewModel$updateLiveHistory$1(this, subject, eVar, j11, null), 2, null);
    }

    public final LiveData t0() {
        return this.f53752t;
    }

    public final ConcurrentHashMap u0() {
        return this.f53754v;
    }

    public final void v0(String str, Subject subject, int i11, boolean z10) {
        t1 d11;
        String str2 = str;
        Integer num = (Integer) this.f53731a0.get(str2 + i11);
        if (num != null && num.intValue() == 2) {
            a.C0856a.f(lg.a.f68962a, "ShortTvViewModel", "getShortTvEpisodes 已经显示全部数据", false, 4, null);
            return;
        }
        t1 t1Var = this.f53733b0;
        if (t1Var == null || !t1Var.isActive()) {
            if (str2 == null) {
                str2 = subject != null ? subject.getSubjectId() : null;
                if (str2 == null) {
                    return;
                }
            }
            String str3 = str2;
            Subject subject2 = (Subject) this.f53739g.f();
            d11 = kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$getShortTvEpisodes$1(num, this, str3, subject2 != null ? subject2.getSubjectId() : null, subject, i11, z10, null), 3, null);
            this.f53733b0 = d11;
        }
    }

    public final void w0(String subjectId, int i11) {
        Intrinsics.h(subjectId, "subjectId");
        int i12 = i11 - 1;
        int i13 = ((i12 / 20) * 20) + 1;
        Integer num = (Integer) this.f53735c0.get(subjectId + i11);
        if (num == null || num.intValue() != 0) {
            if (num != null && num.intValue() == 1) {
                a.C0856a.f(lg.a.f68962a, "ShortTvViewModel", "getShortTvEpisodes start：" + i13 + "  loading", false, 4, null);
                return;
            }
            this.f53735c0.put(subjectId + i11, 1);
            kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$getShortTvEpisodesInfo$2(i13, this, subjectId, i11, null), 3, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "ShortTvViewModel", "getShortTvEpisodes start：" + i13 + " data not null", false, 4, null);
        List list = (List) this.f53750r.f();
        js.k kVar = list != null ? (js.k) CollectionsKt.l0(list, i12) : null;
        if (kVar instanceof js.e) {
            zr.b bVar = zr.b.f79574a;
            LiveData liveData = this.f53740h;
            js.e eVar = (js.e) kVar;
            if (bVar.c(liveData != null ? (Subject) liveData.f() : null, eVar.d()) || !js.l.b(eVar)) {
                return;
            }
            kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvViewModel$getShortTvEpisodesInfo$1(i13, i11, this, subjectId, null), 3, null);
        }
    }

    public final qs.e x0() {
        android.support.v4.media.session.c.a(this.Y.getValue());
        return null;
    }

    public final qs.f y0() {
        return (qs.f) this.T.getValue();
    }

    public final qs.g z0() {
        return (qs.g) this.S.getValue();
    }
}
