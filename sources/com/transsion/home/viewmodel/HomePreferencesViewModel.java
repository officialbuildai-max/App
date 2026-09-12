package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesShowStyle;
import com.transsion.home.bean.HomePreferencesState;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.repository.HomePreferencesRepository;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes5.dex */
public final class HomePreferencesViewModel extends t0 {

    /* renamed from: q, reason: collision with root package name */
    public static final a f45846q = new a(null);

    /* renamed from: r, reason: collision with root package name */
    public static final int f45847r = 8;

    /* renamed from: h, reason: collision with root package name */
    private HomePreferencesState f45855h;

    /* renamed from: p, reason: collision with root package name */
    private boolean f45863p;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f45848a = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ol.b n11;
            n11 = HomePreferencesViewModel.n();
            return n11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f45849b = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HomePreferencesRepository I;
            I = HomePreferencesViewModel.I(HomePreferencesViewModel.this);
            return I;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f45850c = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 G;
            G = HomePreferencesViewModel.G();
            return G;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f45851d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 z10;
            z10 = HomePreferencesViewModel.z();
            return z10;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f45852e = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 F;
            F = HomePreferencesViewModel.F();
            return F;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f45853f = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 H;
            H = HomePreferencesViewModel.H();
            return H;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f45854g = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 q11;
            q11 = HomePreferencesViewModel.q();
            return q11;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private final Map f45856i = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    private final Set f45857j = new LinkedHashSet();

    /* renamed from: k, reason: collision with root package name */
    private final Set f45858k = new LinkedHashSet();

    /* renamed from: l, reason: collision with root package name */
    private final Set f45859l = new LinkedHashSet();

    /* renamed from: m, reason: collision with root package name */
    private final Set f45860m = new LinkedHashSet();

    /* renamed from: n, reason: collision with root package name */
    private final Map f45861n = new LinkedHashMap();

    /* renamed from: o, reason: collision with root package name */
    private final Map f45862o = new LinkedHashMap();

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 F() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 G() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 H() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomePreferencesRepository I(HomePreferencesViewModel homePreferencesViewModel) {
        Application a11 = Utils.a();
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Intrinsics.e(a11);
        return new HomePreferencesRepository(homePreferencesViewModel.r(), companion.b(a11));
    }

    private final void K(HomePreferencesConfig homePreferencesConfig, List list, String str, boolean z10) {
        String labelId = homePreferencesConfig.getLabelId();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.q0((String) obj)) {
                arrayList.add(obj);
            }
        }
        List H0 = CollectionsKt.H0(CollectionsKt.c0(arrayList));
        if (H0.isEmpty()) {
            a.C0856a.f(lg.a.f68962a, "HomePreferencesViewModel", "submitPreferences skip: empty selection, labelId=" + labelId + ", scene=" + str, false, 4, null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List list2 = (List) this.f45861n.get(labelId);
        Long l11 = (Long) this.f45862o.get(labelId);
        long longValue = l11 != null ? l11.longValue() : 0L;
        if (!z10) {
            if (list2 != null && list2.size() == H0.size() && Intrinsics.c(CollectionsKt.W0(list2), CollectionsKt.W0(H0))) {
                a.C0856a.f(lg.a.f68962a, "HomePreferencesViewModel", "submitPreferences skip: same as last, labelId=" + labelId + ", scene=" + str, false, 4, null);
                return;
            }
            if (currentTimeMillis - longValue < 5000) {
                a.C0856a.f(lg.a.f68962a, "HomePreferencesViewModel", "submitPreferences skip: interval < 5000ms, labelId=" + labelId + ", scene=" + str, false, 4, null);
                return;
            }
        }
        this.f45861n.put(labelId, H0);
        this.f45862o.put(labelId, Long.valueOf(currentTimeMillis));
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new HomePreferencesViewModel$submitPreferencesInternal$1(this, labelId, H0, z10, homePreferencesConfig, str, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(HomePreferencesState homePreferencesState) {
        Object obj;
        if (this.f45863p) {
            return;
        }
        Iterator<T> it = homePreferencesState.getEnterPopConfigs().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) obj;
            if (!this.f45858k.contains(homePreferencesConfig.getLabelId()) && !this.f45859l.contains(homePreferencesConfig.getLabelId()) && !this.f45860m.contains(homePreferencesConfig.getLabelId())) {
                break;
            }
        }
        HomePreferencesConfig homePreferencesConfig2 = (HomePreferencesConfig) obj;
        if (homePreferencesConfig2 == null) {
            return;
        }
        this.f45863p = true;
        s().n(homePreferencesConfig2);
    }

    private final void O(String str) {
        HomePreferencesState homePreferencesState;
        Object obj;
        if (this.f45857j.contains(str) || (homePreferencesState = this.f45855h) == null) {
            return;
        }
        List<HomePreferencesConfig> allConfigs = homePreferencesState.getAllConfigs();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : allConfigs) {
            if (StringsKt.H(((HomePreferencesConfig) obj2).getTabCode(), str, true)) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) obj;
            if (Intrinsics.c(homePreferencesConfig.getShowStyle(), HomePreferencesShowStyle.POPUP.getValue()) && !this.f45858k.contains(homePreferencesConfig.getLabelId()) && !this.f45859l.contains(homePreferencesConfig.getLabelId()) && !this.f45860m.contains(homePreferencesConfig.getLabelId())) {
                break;
            }
        }
        HomePreferencesConfig homePreferencesConfig2 = (HomePreferencesConfig) obj;
        if (homePreferencesConfig2 != null && Intrinsics.c(homePreferencesConfig2.getShowStyle(), HomePreferencesShowStyle.POPUP.getValue())) {
            this.f45857j.add(str);
            v().n(TuplesKt.a(str, homePreferencesConfig2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ol.b n() {
        return (ol.b) zg.c.f79537e.a().h(ol.b.class);
    }

    private final List o(String str, List list, HomePreferencesState homePreferencesState) {
        List<HomePreferencesConfig> allConfigs = homePreferencesState.getAllConfigs();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allConfigs) {
            if (StringsKt.H(((HomePreferencesConfig) obj).getTabCode(), str, true)) {
                arrayList.add(obj);
            }
        }
        ArrayList<HomePreferencesConfig> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            HomePreferencesConfig homePreferencesConfig = (HomePreferencesConfig) obj2;
            if (Intrinsics.c(homePreferencesConfig.getShowStyle(), HomePreferencesShowStyle.OPT_INSERT.getValue()) && !this.f45858k.contains(homePreferencesConfig.getLabelId()) && !this.f45859l.contains(homePreferencesConfig.getLabelId()) && !this.f45860m.contains(homePreferencesConfig.getLabelId())) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.isEmpty()) {
            return CollectionsKt.l();
        }
        ArrayList arrayList3 = new ArrayList();
        for (HomePreferencesConfig homePreferencesConfig2 : arrayList2) {
            Integer pos = homePreferencesConfig2.getPos();
            Integer valueOf = Integer.valueOf(pos != null ? pos.intValue() : -1);
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            boolean z10 = false;
            int m11 = RangesKt.m(valueOf != null ? valueOf.intValue() : list.size(), 0, list.size());
            List list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    OperateItem operateItem = (OperateItem) it.next();
                    if (Intrinsics.c(operateItem.getType(), PostItemType.PREFERENCES.getValue())) {
                        HomePreferencesConfig homePreferencesConfig3 = operateItem.getHomePreferencesConfig();
                        if (Intrinsics.c(homePreferencesConfig3 != null ? homePreferencesConfig3.getLabelId() : null, homePreferencesConfig2.getLabelId())) {
                            z10 = true;
                            break;
                        }
                    }
                }
            }
            a.C0856a.f(lg.a.f68962a, "HomePreferencesViewModel", "运营位插入 有配置, tabCode:" + str + ", pos:" + homePreferencesConfig2.getPos() + "， alreadyExists：" + z10, false, 4, null);
            if (!z10) {
                arrayList3.add(new el.a(m11, homePreferencesConfig2));
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String str) {
        List list = (List) this.f45856i.get(str);
        if (list == null) {
            return;
        }
        HomePreferencesState homePreferencesState = this.f45855h;
        if (homePreferencesState == null) {
            u().n(TuplesKt.a(str, CollectionsKt.l()));
            return;
        }
        List o11 = o(str, list, homePreferencesState);
        a.C0856a.f(lg.a.f68962a, "HomePreferencesViewModel", "computeInsertForTab, tabCode:" + str + ", size:" + o11.size(), false, 4, null);
        u().n(TuplesKt.a(str, o11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 q() {
        return new androidx.view.b0();
    }

    private final ol.b r() {
        return (ol.b) this.f45848a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomePreferencesRepository y() {
        return (HomePreferencesRepository) this.f45849b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 z() {
        return new androidx.view.b0();
    }

    public final void A() {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new HomePreferencesViewModel$loadHomePreferencesConfig$1(this, null), 2, null);
    }

    public final void B(HomePreferencesConfig config) {
        Intrinsics.h(config, "config");
        this.f45860m.add(config.getLabelId());
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new HomePreferencesViewModel$markChosen$1(this, config, null), 2, null);
    }

    public final void C(HomePreferencesConfig config) {
        Intrinsics.h(config, "config");
        this.f45859l.add(config.getLabelId());
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new HomePreferencesViewModel$markClosed$1(this, config, null), 2, null);
    }

    public final void D(HomePreferencesConfig config) {
        Intrinsics.h(config, "config");
        String labelId = config.getLabelId();
        if (!this.f45858k.contains(labelId)) {
            this.f45858k.add(labelId);
            kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new HomePreferencesViewModel$markShown$1(this, config, null), 2, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "HomePreferencesViewModel", "markShown skip, already marked, labelId=" + labelId, false, 4, null);
    }

    public final void E(String tabCode, List list) {
        Intrinsics.h(tabCode, "tabCode");
        Intrinsics.h(list, "list");
        this.f45856i.put(tabCode, list);
        p(tabCode);
    }

    public final void J(String tabCode) {
        Intrinsics.h(tabCode, "tabCode");
        O(tabCode);
    }

    public final void L(HomePreferencesConfig config, List selectOptions) {
        Intrinsics.h(config, "config");
        Intrinsics.h(selectOptions, "selectOptions");
        K(config, selectOptions, "popup_confirm", true);
    }

    public final void M(HomePreferencesConfig config, List selectOptions, String scene) {
        Intrinsics.h(config, "config");
        Intrinsics.h(selectOptions, "selectOptions");
        Intrinsics.h(scene, "scene");
        K(config, selectOptions, scene, false);
    }

    public final androidx.view.b0 s() {
        return (androidx.view.b0) this.f45854g.getValue();
    }

    public final List t(String tabCode, List list) {
        Intrinsics.h(tabCode, "tabCode");
        Intrinsics.h(list, "list");
        HomePreferencesState homePreferencesState = this.f45855h;
        return homePreferencesState == null ? CollectionsKt.l() : o(tabCode, list, homePreferencesState);
    }

    public final androidx.view.b0 u() {
        return (androidx.view.b0) this.f45851d.getValue();
    }

    public final androidx.view.b0 v() {
        return (androidx.view.b0) this.f45852e.getValue();
    }

    public final androidx.view.b0 w() {
        return (androidx.view.b0) this.f45850c.getValue();
    }

    public final androidx.view.b0 x() {
        return (androidx.view.b0) this.f45853f.getValue();
    }
}
