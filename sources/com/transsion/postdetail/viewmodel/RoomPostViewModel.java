package com.transsion.postdetail.viewmodel;

import android.content.Context;
import android.location.Address;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class RoomPostViewModel extends t0 {

    /* renamed from: p, reason: collision with root package name */
    public static final a f50282p = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f50283a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xo.c l02;
            l02 = RoomPostViewModel.l0();
            return l02;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f50284b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.postdetail.viewmodel.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            kn.a y10;
            y10 = RoomPostViewModel.y();
            return y10;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f50285c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            yo.a x10;
            x10 = RoomPostViewModel.x();
            return x10;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f50286d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean Y;
            Y = RoomPostViewModel.Y();
            return Boolean.valueOf(Y);
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private final b0 f50287e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private final b0 f50288f = new b0();

    /* renamed from: g, reason: collision with root package name */
    private final b0 f50289g = new b0();

    /* renamed from: h, reason: collision with root package name */
    private final b0 f50290h = new b0();

    /* renamed from: i, reason: collision with root package name */
    private final b0 f50291i = new b0();

    /* renamed from: j, reason: collision with root package name */
    private final b0 f50292j = new b0();

    /* renamed from: k, reason: collision with root package name */
    private final b0 f50293k = new b0();

    /* renamed from: l, reason: collision with root package name */
    private final b0 f50294l = new b0();

    /* renamed from: m, reason: collision with root package name */
    private final b0 f50295m = new b0();

    /* renamed from: n, reason: collision with root package name */
    private final b0 f50296n = new b0();

    /* renamed from: o, reason: collision with root package name */
    private long f50297o;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yo.a A() {
        return (yo.a) this.f50285c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kn.a B() {
        return (kn.a) this.f50284b.getValue();
    }

    public static /* synthetic */ void P(RoomPostViewModel roomPostViewModel, boolean z10, boolean z11, String str, String str2, String str3, int i11, int i12, Object obj) {
        if ((i12 & 32) != 0) {
            i11 = 9;
        }
        roomPostViewModel.O(z10, z11, str, str2, str3, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.c S() {
        return (xo.c) this.f50283a.getValue();
    }

    public static /* synthetic */ void V(RoomPostViewModel roomPostViewModel, boolean z10, boolean z11, String str, String str2, String str3, int i11, int i12, Object obj) {
        if ((i12 & 32) != 0) {
            i11 = 9;
        }
        roomPostViewModel.U(z10, z11, str, str2, str3, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y() {
        String value;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_room_post_cache", true);
        if (c11 == null || (value = c11.getValue()) == null) {
            return false;
        }
        return Intrinsics.c(StringsKt.m1(value), Boolean.TRUE);
    }

    private final List a0(String str) {
        List<PostSubjectItem> items;
        PostSubjectBean postSubjectBean = (PostSubjectBean) com.blankj.utilcode.util.o.d(str, PostSubjectBean.class);
        return (postSubjectBean == null || (items = postSubjectBean.getItems()) == null) ? CollectionsKt.l() : items;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List b0() {
        /*
            r8 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3d
            com.transsion.baselib.report.launch.b r0 = com.transsion.baselib.report.launch.b.f43424a     // Catch: java.lang.Throwable -> L3d
            com.tencent.mmkv.MMKV r0 = r0.b()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r1 = "post_explore_exposed_cache"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Throwable -> L3d
            if (r0 == 0) goto L3f
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L3d
            if (r1 != 0) goto L19
            goto L3f
        L19:
            java.util.List r0 = r8.a0(r0)     // Catch: java.lang.Throwable -> L3d
            lg.a$a r1 = lg.a.f68962a     // Catch: java.lang.Throwable -> L3d
            java.lang.String r2 = "RoomPostVM"
            int r3 = r0.size()     // Catch: java.lang.Throwable -> L3d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d
            r4.<init>()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r5 = "loadExposedCacheItems, size:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L3d
            r4.append(r3)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L3d
            r5 = 4
            r6 = 0
            r4 = 0
            lg.a.C0856a.f(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3d
            goto L43
        L3d:
            r0 = move-exception
            goto L48
        L3f:
            java.util.List r0 = kotlin.collections.CollectionsKt.l()     // Catch: java.lang.Throwable -> L3d
        L43:
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L3d
            goto L52
        L48:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L52:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 == 0) goto L77
            lg.a$a r2 = lg.a.f68962a
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "loadExposedCacheItems failed: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = r3.toString()
            r6 = 4
            r7 = 0
            java.lang.String r3 = "RoomPostVM"
            r5 = 0
            lg.a.C0856a.l(r2, r3, r4, r5, r6, r7)
        L77:
            java.util.List r1 = kotlin.collections.CollectionsKt.l()
            boolean r2 = kotlin.Result.m1191isFailureimpl(r0)
            if (r2 == 0) goto L82
            r0 = r1
        L82:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.viewmodel.RoomPostViewModel.b0():java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List c0() {
        /*
            r8 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3d
            com.transsion.baselib.report.launch.b r0 = com.transsion.baselib.report.launch.b.f43424a     // Catch: java.lang.Throwable -> L3d
            com.tencent.mmkv.MMKV r0 = r0.b()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r1 = "room_cache_data"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Throwable -> L3d
            if (r0 == 0) goto L3f
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L3d
            if (r1 != 0) goto L19
            goto L3f
        L19:
            java.util.List r0 = r8.a0(r0)     // Catch: java.lang.Throwable -> L3d
            lg.a$a r1 = lg.a.f68962a     // Catch: java.lang.Throwable -> L3d
            java.lang.String r2 = "RoomPostVM"
            int r3 = r0.size()     // Catch: java.lang.Throwable -> L3d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d
            r4.<init>()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r5 = "loadManualCacheItems, size:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L3d
            r4.append(r3)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L3d
            r5 = 4
            r6 = 0
            r4 = 0
            lg.a.C0856a.f(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3d
            goto L43
        L3d:
            r0 = move-exception
            goto L48
        L3f:
            java.util.List r0 = kotlin.collections.CollectionsKt.l()     // Catch: java.lang.Throwable -> L3d
        L43:
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L3d
            goto L52
        L48:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L52:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 == 0) goto L77
            lg.a$a r2 = lg.a.f68962a
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "loadManualCacheItems failed: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = r3.toString()
            r6 = 4
            r7 = 0
            java.lang.String r3 = "RoomPostVM"
            r5 = 0
            lg.a.C0856a.l(r2, r3, r4, r5, r6, r7)
        L77:
            java.util.List r1 = kotlin.collections.CollectionsKt.l()
            boolean r2 = kotlin.Result.m1191isFailureimpl(r0)
            if (r2 == 0) goto L82
            r0 = r1
        L82:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.viewmodel.RoomPostViewModel.c0():java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List d0(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3e
            com.transsion.baselib.report.launch.b r0 = com.transsion.baselib.report.launch.b.f43424a     // Catch: java.lang.Throwable -> L3e
            com.tencent.mmkv.MMKV r0 = r0.b()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = ""
            java.lang.String r8 = r0.getString(r8, r1)     // Catch: java.lang.Throwable -> L3e
            if (r8 == 0) goto L40
            int r0 = r8.length()     // Catch: java.lang.Throwable -> L3e
            if (r0 != 0) goto L17
            goto L40
        L17:
            java.util.List r8 = r7.a0(r8)     // Catch: java.lang.Throwable -> L3e
            lg.a$a r0 = lg.a.f68962a     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = "RoomPostVM"
            int r2 = r8.size()     // Catch: java.lang.Throwable -> L3e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r3.<init>()     // Catch: java.lang.Throwable -> L3e
            r3.append(r9)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = ", size:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L3e
            r3.append(r2)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L3e
            r4 = 4
            r5 = 0
            r3 = 0
            lg.a.C0856a.f(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3e
            goto L44
        L3e:
            r8 = move-exception
            goto L49
        L40:
            java.util.List r8 = kotlin.collections.CollectionsKt.l()     // Catch: java.lang.Throwable -> L3e
        L44:
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)     // Catch: java.lang.Throwable -> L3e
            goto L53
        L49:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
        L53:
            java.lang.Throwable r0 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r0 == 0) goto L7b
            lg.a$a r1 = lg.a.f68962a
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            java.lang.String r9 = " failed: "
            r2.append(r9)
            r2.append(r0)
            java.lang.String r3 = r2.toString()
            r5 = 4
            r6 = 0
            java.lang.String r2 = "RoomPostVM"
            r4 = 0
            lg.a.C0856a.l(r1, r2, r3, r4, r5, r6)
        L7b:
            java.util.List r9 = kotlin.collections.CollectionsKt.l()
            boolean r0 = kotlin.Result.m1191isFailureimpl(r8)
            if (r0 == 0) goto L86
            r8 = r9
        L86:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.viewmodel.RoomPostViewModel.d0(java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostSubjectBean k0(List list, List list2, List list3) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list3) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
            if (!postSubjectItem.isRoomCacheListStart() && !postSubjectItem.isRoomCacheListEnd()) {
                arrayList.add(obj);
            }
        }
        if (list.isEmpty() && list2.isEmpty() && arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PostSubjectItem postSubjectItem2 = (PostSubjectItem) it.next();
            String postId = postSubjectItem2.getPostId();
            if (postId != null) {
                linkedHashSet.add(postId);
            }
            arrayList2.add(postSubjectItem2);
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            PostSubjectItem postSubjectItem3 = (PostSubjectItem) it2.next();
            if (postSubjectItem3.getPostId() != null) {
                String postId2 = postSubjectItem3.getPostId();
                Intrinsics.e(postId2);
                if (linkedHashSet.add(postId2)) {
                }
            }
            arrayList2.add(postSubjectItem3);
        }
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList) {
                PostSubjectItem postSubjectItem4 = (PostSubjectItem) obj2;
                if (postSubjectItem4.getPostId() != null) {
                    String postId3 = postSubjectItem4.getPostId();
                    Intrinsics.e(postId3);
                    if (linkedHashSet.add(postId3)) {
                    }
                }
                arrayList3.add(obj2);
            }
            if (!arrayList3.isEmpty()) {
                PostSubjectItem postSubjectItem5 = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, null, false, null, false, false, false, false, null, -1, 1, null);
                postSubjectItem5.setRoomCacheListStart(true);
                postSubjectItem5.setRoomCache(true);
                arrayList2.add(postSubjectItem5);
                arrayList2.addAll(arrayList3);
                PostSubjectItem postSubjectItem6 = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, null, false, null, false, false, false, false, null, -1, 1, null);
                postSubjectItem6.setRoomCacheListEnd(true);
                postSubjectItem6.setRoomCache(true);
                arrayList2.add(postSubjectItem6);
            }
        }
        PostSubjectBean postSubjectBean = new PostSubjectBean(arrayList2, null, null, null);
        postSubjectBean.setRefresh(true);
        return postSubjectBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.c l0() {
        return (xo.c) zg.c.f79537e.a().h(xo.c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yo.a x() {
        return new yo.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kn.a y() {
        return (kn.a) zg.c.f79537e.a().h(kn.a.class);
    }

    public final b0 C() {
        return this.f50292j;
    }

    public final b0 D() {
        return this.f50287e;
    }

    public final b0 E() {
        return this.f50288f;
    }

    public final int F() {
        ConfigBean c11 = sm.f.f75530c.a().c("sa_room_post_cache_count", true);
        String value = c11 != null ? c11.getValue() : null;
        Integer v11 = value != null ? StringsKt.v(value) : null;
        if (v11 != null) {
            return v11.intValue();
        }
        return 24;
    }

    public final b0 G() {
        return this.f50289g;
    }

    public final b0 H() {
        return this.f50291i;
    }

    public final b0 I() {
        return this.f50290h;
    }

    public final void J(Context context, boolean z10, boolean z11, String str, int i11, String str2) {
        Intrinsics.h(context, "context");
        if (!X()) {
            e0();
        }
        if (z10) {
            a.C0856a.f(lg.a.f68962a, "RoomPostVM", "getPostExplore [AB:" + (X() ? "实验组-新缓存策略" : "对照组-旧缓存策略") + "]", false, 4, null);
            if (X()) {
                g0();
            } else {
                h0();
            }
            f0();
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomPostViewModel$getPostExplore$1(z10, this, z11, str, i11, str2, null), 3, null);
    }

    public final void K(boolean z10, String str, int i11, String str2) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomPostViewModel$getPostExploreMoreCache$1(this, str, i11, str2, z10, null), 2, null);
    }

    public final void L(boolean z10, String str, int i11, double d11, double d12) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomPostViewModel$getPostNearby$1(this, str, i11, d12, d11, z10, null), 2, null);
    }

    public final void M(boolean z10, String str, String str2, int i11, String sortType, boolean z11) {
        Intrinsics.h(sortType, "sortType");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomPostViewModel$getPostNewest$1(this, str, str2, i11, sortType, z11, z10, null), 3, null);
    }

    public final void N(boolean z10, String groupId, String str, int i11, boolean z11) {
        Intrinsics.h(groupId, "groupId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomPostViewModel$getPostPopular$1(this, groupId, str, i11, z11, z10, null), 3, null);
    }

    public final void O(boolean z10, boolean z11, String tabId, String str, String str2, int i11) {
        Intrinsics.h(tabId, "tabId");
        if (z10) {
            i0(tabId);
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomPostViewModel$getPostSubPageList$1(z10, tabId, z11, this, str, i11, str2, null), 3, null);
    }

    public final void Q(double d11, double d12, Address address) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomPostViewModel$getRecommendRooms$1(this, d11, d12, address, null), 3, null);
    }

    public final b0 R() {
        return this.f50293k;
    }

    public final b0 T() {
        return this.f50296n;
    }

    public final void U(boolean z10, boolean z11, String tabId, String str, String str2, int i11) {
        Intrinsics.h(tabId, "tabId");
        if (z10) {
            j0(tabId);
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomPostViewModel$getStaggeredPostPageList$1(z10, tabId, z11, this, str, i11, str2, null), 3, null);
    }

    public final b0 W() {
        return this.f50295m;
    }

    public final boolean X() {
        return ((Boolean) this.f50286d.getValue()).booleanValue();
    }

    public final void Z(String str, int i11) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomPostViewModel$like$1(str, i11, this, null), 3, null);
    }

    public final void e0() {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomPostViewModel$loadPostExploreActiveSaveCache$1(this, null), 2, null);
    }

    public final void f0() {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomPostViewModel$loadPostExploreBuiltInCache$1(this, null), 2, null);
    }

    public final void g0() {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomPostViewModel$loadPostExploreCombinedCache$1(this, null), 2, null);
    }

    public final void h0() {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomPostViewModel$loadPostExploreNetCache$1(this, null), 2, null);
    }

    public final void i0(String tabId) {
        Intrinsics.h(tabId, "tabId");
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomPostViewModel$loadPostSubPageCache$1(tabId, this, null), 2, null);
    }

    public final void j0(String tabId) {
        Intrinsics.h(tabId, "tabId");
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomPostViewModel$loadStaggeredPostPageCache$1(tabId, this, null), 2, null);
    }

    public final void z(String str) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomPostViewModel$deletePost$1(str, this, null), 3, null);
    }
}
