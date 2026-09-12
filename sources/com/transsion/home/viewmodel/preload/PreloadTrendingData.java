package com.transsion.home.viewmodel.preload;

import android.content.Context;
import androidx.view.b0;
import aq.h;
import com.blankj.utilcode.util.o;
import com.google.gson.Gson;
import com.therouter.TheRouter;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.HotSubjectEntity;
import com.transsion.home.bean.MainOperateData;
import com.transsion.home.p004enum.BottomTabType;
import com.transsion.home.p004enum.HomeTabType;
import com.transsion.memberapi.IMemberApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes.dex */
public final class PreloadTrendingData {

    /* renamed from: n, reason: collision with root package name */
    public static final a f45940n = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public static final int f45941o = 8;

    /* renamed from: p, reason: collision with root package name */
    private static final Lazy f45942p = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.home.viewmodel.preload.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PreloadTrendingData P;
            P = PreloadTrendingData.P();
            return P;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f45944b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f45945c;

    /* renamed from: k, reason: collision with root package name */
    private AppTab f45953k;

    /* renamed from: l, reason: collision with root package name */
    private List f45954l;

    /* renamed from: a, reason: collision with root package name */
    private int f45943a = 1;

    /* renamed from: d, reason: collision with root package name */
    private final ol.e f45946d = (ol.e) zg.c.f79537e.a().h(ol.e.class);

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f45947e = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PreloadTrendingBuiltInHelper w11;
            w11 = PreloadTrendingData.w();
            return w11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f45948f = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 S;
            S = PreloadTrendingData.S();
            return S;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f45949g = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 R;
            R = PreloadTrendingData.R();
            return R;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f45950h = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 v11;
            v11 = PreloadTrendingData.v();
            return v11;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f45951i = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 u11;
            u11 = PreloadTrendingData.u();
            return u11;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f45952j = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.preload.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 N;
            N = PreloadTrendingData.N();
            return N;
        }
    });

    /* renamed from: m, reason: collision with root package name */
    private final j0 f45955m = new b(j0.f68015k1);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PreloadTrendingData a() {
            return (PreloadTrendingData) PreloadTrendingData.f45942p.getValue();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends AbstractCoroutineContextElement implements j0 {
        public b(j0.a aVar) {
            super(aVar);
        }

        @Override // kotlinx.coroutines.j0
        public void o(CoroutineContext coroutineContext, Throwable th2) {
            lg.a.f68962a.i("PreloadTrending", "coroutineExceptionHandler " + th2.getMessage(), true);
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x000f, TRY_LEAVE, TryCatch #0 {all -> 0x000f, blocks: (B:3:0x0002, B:5:0x0008, B:8:0x0026, B:10:0x002c, B:15:0x0011), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.transsion.home.bean.AppTab B() {
        /*
            r6 = this;
            java.lang.String r0 = "app_tab"
            java.lang.String r1 = r6.Y(r0)     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto L11
            int r2 = r1.length()     // Catch: java.lang.Throwable -> Lf
            if (r2 != 0) goto L26
            goto L11
        Lf:
            r1 = move-exception
            goto L35
        L11:
            com.transsion.home.viewmodel.preload.PreloadTrendingBuiltInHelper r1 = r6.E()     // Catch: java.lang.Throwable -> Lf
            android.app.Application r2 = com.blankj.utilcode.util.Utils.a()     // Catch: java.lang.Throwable -> Lf
            java.lang.String r3 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r1 = r1.d(r2)     // Catch: java.lang.Throwable -> Lf
            if (r1 != 0) goto L26
            java.lang.String r1 = ""
        L26:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> Lf
            if (r2 <= 0) goto L5e
            java.lang.Class<com.transsion.home.bean.AppTab> r2 = com.transsion.home.bean.AppTab.class
            java.lang.Object r1 = com.blankj.utilcode.util.o.d(r1, r2)     // Catch: java.lang.Throwable -> Lf
            com.transsion.home.bean.AppTab r1 = (com.transsion.home.bean.AppTab) r1     // Catch: java.lang.Throwable -> Lf
            return r1
        L35:
            lg.a$a r2 = lg.a.f68962a
            java.lang.String r3 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getAppTabCache error: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r4 = 1
            java.lang.String r5 = "PreloadTrending"
            r2.i(r5, r3, r4)
            com.transsion.baselib.report.launch.b r2 = com.transsion.baselib.report.launch.b.f43424a
            com.tencent.mmkv.MMKV r2 = r2.b()
            r2.M(r0)
            r1.printStackTrace()
        L5e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.viewmodel.preload.PreloadTrendingData.B():com.transsion.home.bean.AppTab");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreloadTrendingBuiltInHelper E() {
        return (PreloadTrendingBuiltInHelper) this.f45947e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HotSubjectEntity I() {
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("hot_search_words", null);
        if (string != null) {
            return (HotSubjectEntity) o.d(string, HotSubjectEntity.class);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 N() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(AppTab appTab) {
        BottomTabItem bottomTabItem;
        BottomTabItem bottomTabItem2;
        List<BottomTabItem> bottomTabs;
        Object obj;
        List<BottomTabItem> bottomTabs2;
        Object obj2;
        Object obj3 = null;
        if (appTab == null || (bottomTabs2 = appTab.getBottomTabs()) == null) {
            bottomTabItem = null;
        } else {
            Iterator<T> it = bottomTabs2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it.next();
                    if (Intrinsics.c(((BottomTabItem) obj2).getBtTabCode(), BottomTabType.TAB_CODE_COMMUNITY)) {
                        break;
                    }
                }
            }
            bottomTabItem = (BottomTabItem) obj2;
        }
        if (bottomTabItem != null) {
            a.C0856a.f(lg.a.f68962a, "PreloadTrending", "has bottom room tab", false, 4, null);
            h.f16175a.l(true);
            return;
        }
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            bottomTabItem2 = null;
        } else {
            Iterator<T> it2 = bottomTabs.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (Intrinsics.c(((BottomTabItem) obj).getBtTabCode(), BottomTabType.TAB_CODE_HOME)) {
                        break;
                    }
                }
            }
            bottomTabItem2 = (BottomTabItem) obj;
        }
        if (bottomTabItem2 == null) {
            a.C0856a.f(lg.a.f68962a, "PreloadTrending", "has no room tab", false, 4, null);
            h.f16175a.l(false);
            return;
        }
        List<HomeTabItem> subTabs = bottomTabItem2.getSubTabs();
        if (subTabs != null) {
            Iterator<T> it3 = subTabs.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                HomeTabItem homeTabItem = (HomeTabItem) next;
                if (Intrinsics.c(homeTabItem != null ? homeTabItem.getTabCode() : null, "Community")) {
                    obj3 = next;
                    break;
                }
            }
            obj3 = (HomeTabItem) obj3;
        }
        a.C0856a.f(lg.a.f68962a, "PreloadTrending", "has top room tab:" + (obj3 != null), false, 4, null);
        h.f16175a.l(obj3 != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadTrendingData P() {
        return new PreloadTrendingData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 R() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 S() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(11:5|6|7|8|(1:(2:11|12)(2:40|41))(3:42|43|(1:45))|13|(1:39)(1:17)|18|(1:38)(3:22|(2:24|(1:33))|34)|35|36))|48|6|7|8|(0)(0)|13|(1:15)|39|18|(1:20)|38|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0032, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00de, code lost:
    
        lg.a.f68962a.i("PreloadTrending", "get Operating List msg=" + r13.getMessage() + " cause=" + r13.getCause(), true);
        K().n(null);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T(java.lang.String r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.viewmodel.preload.PreloadTrendingData.T(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void V(Context context) {
        k.d(o0.a(y0.b()), null, null, new PreloadTrendingData$preloadSkuDataCache$1(context, null), 3, null);
    }

    private final void W(Context context) {
        k.d(o0.a(y0.b()), null, null, new PreloadTrendingData$preloadVideoCache$1(this, context, null), 3, null);
    }

    private final String Y(String str) {
        try {
            byte[] e11 = com.transsion.baselib.report.launch.b.f43424a.b().e(str);
            if (e11 == null) {
                return null;
            }
            if (e11.length == 0) {
                return null;
            }
            return new String(e11, Charsets.UTF_8);
        } catch (Throwable th2) {
            lg.a.f68962a.i("PreloadTrending", "safeGetMmkvString failed for key: " + str + ", " + th2.getMessage(), true);
            return null;
        }
    }

    private final void Z(MainOperateData mainOperateData) {
        if (mainOperateData.getItems() == null || !(!r0.isEmpty())) {
            return;
        }
        com.transsion.baselib.report.launch.b.f43424a.b().putString("main_operating_data", new Gson().toJson(mainOperateData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(AppTab appTab) {
        List<BottomTabItem> bottomTabs = appTab != null ? appTab.getBottomTabs() : null;
        if (bottomTabs == null || bottomTabs.isEmpty()) {
            return;
        }
        com.transsion.baselib.report.launch.b.f43424a.b().putString("app_tab", o.j(appTab));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 u() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 v() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadTrendingBuiltInHelper w() {
        return new PreloadTrendingBuiltInHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List x(AppTab appTab) {
        List<BottomTabItem> bottomTabs;
        ArrayList arrayList = new ArrayList();
        for (BottomTabType bottomTabType : BottomTabType.values()) {
            CollectionsKt.B(arrayList, CollectionsKt.e(bottomTabType.getValue()));
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        boolean B = iMemberApi != null ? iMemberApi.B() : false;
        if (!B) {
            a.C0856a.f(lg.a.f68962a, "co_mem", "MainActivity --> getTabEntities() --> 当前没有开启会员功能 --> 不展示会员Tab", false, 4, null);
        }
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : bottomTabs) {
            BottomTabItem bottomTabItem = (BottomTabItem) obj;
            if (Intrinsics.c(bottomTabItem.getBtTabType(), BottomTabType.PREMIUM.getValue()) ? CollectionsKt.b0(arrayList, bottomTabItem.getBtTabType()) && B : CollectionsKt.b0(arrayList, bottomTabItem.getBtTabType())) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.U0(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List y(List list) {
        ArrayList arrayList = new ArrayList();
        for (HomeTabType homeTabType : HomeTabType.values()) {
            CollectionsKt.B(arrayList, CollectionsKt.e(homeTabType.getValue()));
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            HomeTabItem homeTabItem = (HomeTabItem) obj;
            if (homeTabItem != null && CollectionsKt.b0(arrayList, homeTabItem.getType())) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.U0(arrayList2);
    }

    public final AppTab A(Context context) {
        Intrinsics.h(context, "context");
        try {
            String d11 = E().d(context);
            if (d11 != null && d11.length() != 0) {
                return (AppTab) o.d(d11, AppTab.class);
            }
            return null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final b0 C() {
        return (b0) this.f45951i.getValue();
    }

    public final b0 D() {
        return (b0) this.f45950h.getValue();
    }

    public final AppTab F() {
        return this.f45953k;
    }

    public final void G() {
        k.d(o0.a(y0.b()), null, null, new PreloadTrendingData$getHotSearch$1(this, null), 3, null);
    }

    public final b0 H() {
        return (b0) this.f45952j.getValue();
    }

    public final b0 J() {
        return (b0) this.f45949g.getValue();
    }

    public final b0 K() {
        return (b0) this.f45948f.getValue();
    }

    public final List L() {
        List list = this.f45954l;
        this.f45954l = null;
        return list;
    }

    public final boolean M() {
        return this.f45945c;
    }

    public final boolean Q(String version) {
        Intrinsics.h(version, "version");
        if (this.f45944b) {
            return false;
        }
        this.f45944b = true;
        k.d(o0.a(y0.b()), this.f45955m, null, new PreloadTrendingData$loadOperatingDataFromNet$1(this, version, null), 2, null);
        return true;
    }

    public final void U(Context context) {
        Intrinsics.h(context, "context");
        lg.a.f68962a.c("PreloadTrending", "preloadOperatingCache() called", true);
        k.d(o0.a(y0.b()), null, null, new PreloadTrendingData$preloadOperating$1(this, context, null), 3, null);
        W(context);
        V(context);
    }

    public final boolean X(Context context, String operationVersion) {
        Intrinsics.h(context, "context");
        Intrinsics.h(operationVersion, "operationVersion");
        if (J().f() != null) {
            return Q(operationVersion);
        }
        U(context);
        return true;
    }

    public final void b0(List list) {
        Intrinsics.h(list, "list");
        this.f45954l = list;
    }

    public final void z() {
        this.f45945c = true;
        lg.a.f68962a.c("PreloadTrending", "getAppTab() called", true);
        k.d(o0.a(y0.b()), null, null, new PreloadTrendingData$getAppTab$1(this, null), 3, null);
    }
}
