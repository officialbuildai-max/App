package com.transsnet.downloader.ugc.viewmodel;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDownload;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDownloadResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;

/* loaded from: classes7.dex */
public final class UGCDownloadViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f59973a = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.ugc.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            sy.a m11;
            m11 = UGCDownloadViewModel.m();
            return m11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final int f59974b = 480;

    /* renamed from: c, reason: collision with root package name */
    private final int f59975c = 50;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f59976d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private final b0 f59977e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private int f59978f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f59979g;

    /* renamed from: h, reason: collision with root package name */
    private final LiveData f59980h;

    /* renamed from: i, reason: collision with root package name */
    private final b0 f59981i;

    /* renamed from: j, reason: collision with root package name */
    private final LiveData f59982j;

    /* renamed from: k, reason: collision with root package name */
    private final b0 f59983k;

    /* renamed from: l, reason: collision with root package name */
    private final Map f59984l;

    /* renamed from: m, reason: collision with root package name */
    private final b0 f59985m;

    /* renamed from: n, reason: collision with root package name */
    private final LiveData f59986n;

    /* renamed from: o, reason: collision with root package name */
    private final b0 f59987o;

    /* renamed from: p, reason: collision with root package name */
    private final LiveData f59988p;

    /* renamed from: q, reason: collision with root package name */
    private final b0 f59989q;

    /* renamed from: r, reason: collision with root package name */
    private final b0 f59990r;

    /* renamed from: s, reason: collision with root package name */
    private final b0 f59991s;

    /* renamed from: t, reason: collision with root package name */
    private Map f59992t;

    public UGCDownloadViewModel() {
        b0 b0Var = new b0();
        this.f59979g = b0Var;
        this.f59980h = b0Var;
        b0 b0Var2 = new b0();
        this.f59981i = b0Var2;
        this.f59982j = b0Var2;
        this.f59983k = new b0();
        this.f59984l = new LinkedHashMap();
        b0 b0Var3 = new b0();
        this.f59985m = b0Var3;
        this.f59986n = b0Var3;
        b0 b0Var4 = new b0();
        this.f59987o = b0Var4;
        this.f59988p = b0Var4;
        this.f59989q = new b0();
        this.f59990r = new b0(CollectionsKt.l());
        this.f59991s = new b0();
        this.f59992t = new LinkedHashMap();
    }

    private final void J() {
        Long size;
        Set set = (Set) this.f59979g.f();
        if (set == null) {
            set = SetsKt.f();
        }
        Iterator it = set.iterator();
        long j11 = 0;
        while (it.hasNext()) {
            UGCVideoDownloadResource resource = ((UGCVideoDownload) it.next()).getResource();
            j11 += (resource == null || (size = resource.getSize()) == null) ? 0L : size.longValue();
        }
        if (j11 > 0) {
            this.f59987o.q(oh.b.a(j11, 1));
        } else {
            this.f59987o.q(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int i11, int i12) {
        Map linkedHashMap;
        Map linkedHashMap2;
        int i13 = this.f59975c;
        if (i12 <= i13) {
            Map map = (Map) this.f59989q.f();
            if (map == null || (linkedHashMap2 = MapsKt.w(map)) == null) {
                linkedHashMap2 = new LinkedHashMap();
            }
            linkedHashMap2.remove(Integer.valueOf(i11));
            this.f59989q.q(linkedHashMap2);
            Integer num = (Integer) this.f59977e.f();
            if (num == null || num.intValue() == i11) {
                this.f59990r.q(CollectionsKt.l());
                return;
            }
            return;
        }
        IntRange t11 = RangesKt.t(0, ((i12 + i13) - 1) / i13);
        ArrayList arrayList = new ArrayList(CollectionsKt.v(t11, 10));
        Iterator<Integer> it = t11.iterator();
        while (it.hasNext()) {
            int a11 = ((IntIterator) it).a();
            int i14 = this.f59975c;
            int i15 = (a11 * i14) + 1;
            int min = Math.min((a11 + 1) * i14, i12);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(Locale.US, "%d-%d", Arrays.copyOf(new Object[]{Integer.valueOf(i15), Integer.valueOf(min)}, 2));
            Intrinsics.g(format, "format(...)");
            arrayList.add(format);
        }
        Map map2 = (Map) this.f59989q.f();
        if (map2 == null || (linkedHashMap = MapsKt.w(map2)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        linkedHashMap.put(Integer.valueOf(i11), arrayList);
        this.f59989q.q(linkedHashMap);
        Integer num2 = (Integer) this.f59977e.f();
        if ((num2 == null || num2.intValue() == i11) && !Intrinsics.c(arrayList, (List) this.f59990r.f())) {
            this.f59990r.q(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l(String str, String str2, int i11) {
        List list;
        int intValue;
        MatchResult find$default;
        List a11;
        String str3;
        Integer v11;
        Integer v12;
        if (str != null && (v12 = StringsKt.v(str)) != null) {
            if (v12.intValue() <= 0) {
                v12 = null;
            }
            if (v12 != null) {
                return v12.intValue();
            }
        }
        if (str2 != null && (find$default = Regex.find$default(new Regex("^(\\d+)-\\d+$"), str2, 0, 2, null)) != null && (a11 = find$default.a()) != null && (str3 = (String) a11.get(1)) != null && (v11 = StringsKt.v(str3)) != null) {
            if (v11.intValue() <= 0) {
                v11 = null;
            }
            if (v11 != null) {
                intValue = (v11.intValue() - 1) / this.f59975c;
                return intValue + 1;
            }
        }
        Map map = (Map) this.f59989q.f();
        if (map != null && (list = (List) map.get(Integer.valueOf(i11))) != null) {
            Integer valueOf = Integer.valueOf(CollectionsKt.n0(list, str2));
            Integer num = valueOf.intValue() >= 0 ? valueOf : null;
            if (num != null) {
                intValue = num.intValue();
                return intValue + 1;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sy.a m() {
        return (sy.a) zg.c.f79537e.a().h(sy.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sy.a r() {
        return (sy.a) this.f59973a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 v(int i11) {
        b0 b0Var = (b0) this.f59984l.get(Integer.valueOf(i11));
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0();
        this.f59984l.put(Integer.valueOf(i11), b0Var2);
        return b0Var2;
    }

    public final int A() {
        return this.f59978f;
    }

    public final LiveData B() {
        return this.f59988p;
    }

    public final b0 C() {
        return this.f59976d;
    }

    public final boolean D() {
        List list = (List) this.f59983k.f();
        if (list == null || list.size() <= 1) {
            return false;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String ugcVideoId = ((UGCVideoDownload) it.next()).getUgcVideoId();
            if (ugcVideoId != null) {
                arrayList.add(ugcVideoId);
            }
        }
        if (CollectionsKt.W0(arrayList).size() > 1) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            UGCVideoDownloadResource resource = ((UGCVideoDownload) it2.next()).getResource();
            String id2 = resource != null ? resource.getId() : null;
            if (id2 != null) {
                arrayList2.add(id2);
            }
        }
        return CollectionsKt.W0(arrayList2).size() > 1;
    }

    public final void E(String collectionId) {
        Intrinsics.h(collectionId, "collectionId");
        k.d(u0.a(this), null, null, new UGCDownloadViewModel$loadResolutions$1(this, collectionId, null), 3, null);
    }

    public final void F(String collectionId, String str, String str2, Integer num) {
        int intValue;
        Intrinsics.h(collectionId, "collectionId");
        if (num != null) {
            intValue = num.intValue();
        } else {
            Integer num2 = (Integer) this.f59977e.f();
            intValue = num2 != null ? num2.intValue() : this.f59974b;
        }
        int i11 = intValue;
        k.d(u0.a(this), null, null, new UGCDownloadViewModel$loadUGCListData$1(this, collectionId, str2, i11, str, v(i11), null), 3, null);
    }

    public final void G(String ugcVideoId) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        k.d(u0.a(this), null, null, new UGCDownloadViewModel$loadUGCSingleVideoData$1(this, ugcVideoId, null), 3, null);
    }

    public final void H(String ugcVideoId) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        k.d(u0.a(this), null, null, new UGCDownloadViewModel$loadUGCSingleVideoDataForDownloadImmediately$1(this, ugcVideoId, null), 3, null);
    }

    public final void I(String collectionId, String tabName, String str) {
        Map map;
        Intrinsics.h(collectionId, "collectionId");
        Intrinsics.h(tabName, "tabName");
        Integer num = (Integer) this.f59977e.f();
        if (num != null) {
            b0 b0Var = (b0) this.f59984l.get(num);
            List list = (b0Var == null || (map = (Map) b0Var.f()) == null) ? null : (List) map.get(tabName);
            List list2 = list;
            if (list2 == null || list2.isEmpty()) {
                F(collectionId, tabName, str, num);
                return;
            }
            b0 b0Var2 = this.f59983k;
            Intrinsics.e(list);
            b0Var2.q(list);
            if (Intrinsics.c(this.f59976d.f(), Boolean.TRUE)) {
                K(true);
            }
        }
    }

    public final void K(boolean z10) {
        Object linkedHashSet;
        if (z10) {
            List list = (List) this.f59983k.f();
            if (list == null) {
                list = CollectionsKt.l();
            }
            linkedHashSet = CollectionsKt.V0(list);
        } else {
            linkedHashSet = new LinkedHashSet();
        }
        this.f59979g.q(linkedHashSet);
        J();
    }

    public final void L(Set items) {
        Intrinsics.h(items, "items");
        this.f59979g.q(CollectionsKt.V0(items));
        J();
    }

    public final void M(int i11) {
        this.f59978f = i11;
    }

    public final void N() {
        Set y10 = y();
        if (y10.isEmpty()) {
            this.f59979g.q(new LinkedHashSet());
            J();
            return;
        }
        List<UGCVideoDownload> list = (List) this.f59983k.f();
        if (list == null) {
            list = CollectionsKt.l();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UGCVideoDownload uGCVideoDownload : list) {
            String t11 = t(uGCVideoDownload);
            if (t11 != null && y10.contains(t11)) {
                linkedHashSet.add(uGCVideoDownload);
            }
        }
        this.f59979g.q(linkedHashSet);
        J();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        r2.remove();
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(com.transsion.ugcvideodetail.api.bean.UGCVideoDownload r9) {
        /*
            r8 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            java.lang.String r0 = r9.getUgcVideoId()
            if (r0 == 0) goto L96
            int r0 = r0.length()
            if (r0 != 0) goto L13
            goto L96
        L13:
            androidx.lifecycle.b0 r0 = r8.f59979g
            java.lang.Object r0 = r0.f()
            java.util.Set r0 = (java.util.Set) r0
            if (r0 != 0) goto L22
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
        L22:
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            java.util.Collection r0 = (java.util.Collection) r0
            r1.<init>(r0)
            boolean r0 = r8.D()
            java.util.Iterator r2 = r1.iterator()
            java.lang.String r3 = "iterator(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)
        L36:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L89
            java.lang.Object r3 = r2.next()
            com.transsion.ugcvideodetail.api.bean.UGCVideoDownload r3 = (com.transsion.ugcvideodetail.api.bean.UGCVideoDownload) r3
            r5 = 1
            if (r0 == 0) goto L77
            com.transsion.ugcvideodetail.api.bean.UGCVideoDownloadResource r3 = r3.getResource()
            r6 = 0
            if (r3 == 0) goto L52
            java.lang.String r3 = r3.getId()
            goto L53
        L52:
            r3 = r6
        L53:
            com.transsion.ugcvideodetail.api.bean.UGCVideoDownloadResource r7 = r9.getResource()
            if (r7 == 0) goto L5d
            java.lang.String r6 = r7.getId()
        L5d:
            if (r3 == 0) goto L83
            int r7 = r3.length()
            if (r7 != 0) goto L66
            goto L83
        L66:
            if (r6 == 0) goto L83
            int r7 = r6.length()
            if (r7 != 0) goto L6f
            goto L83
        L6f:
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r3, r6)
            if (r3 == 0) goto L83
            r4 = r5
            goto L83
        L77:
            java.lang.String r3 = r3.getUgcVideoId()
            java.lang.String r4 = r9.getUgcVideoId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r3, r4)
        L83:
            if (r4 == 0) goto L36
            r2.remove()
            r4 = r5
        L89:
            if (r4 != 0) goto L8e
            r1.add(r9)
        L8e:
            androidx.lifecycle.b0 r9 = r8.f59979g
            r9.q(r1)
            r8.J()
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.ugc.viewmodel.UGCDownloadViewModel.O(com.transsion.ugcvideodetail.api.bean.UGCVideoDownload):void");
    }

    public final b0 n() {
        return this.f59991s;
    }

    public final b0 o() {
        return this.f59990r;
    }

    public final b0 p() {
        return this.f59983k;
    }

    public final b0 q() {
        return this.f59977e;
    }

    public final b0 s() {
        return this.f59989q;
    }

    public final String t(UGCVideoDownload item) {
        Intrinsics.h(item, "item");
        if (!D()) {
            return item.getUgcVideoId();
        }
        UGCVideoDownloadResource resource = item.getResource();
        if (resource != null) {
            return resource.getId();
        }
        return null;
    }

    public final Map u() {
        return this.f59984l;
    }

    public final LiveData w() {
        return this.f59986n;
    }

    public final LiveData x() {
        return this.f59980h;
    }

    public final Set y() {
        Set set = (Set) this.f59979g.f();
        if (set == null) {
            return SetsKt.f();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String t11 = t((UGCVideoDownload) it.next());
            if (t11 != null) {
                arrayList.add(t11);
            }
        }
        return CollectionsKt.W0(arrayList);
    }

    public final LiveData z() {
        return this.f59982j;
    }
}
