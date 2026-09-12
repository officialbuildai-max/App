package com.transsion.ugcvideodetail.viewmodel;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.UGCCollectionVideoGroupDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import lg.a;

/* loaded from: classes6.dex */
public class UGCVideoDetailViewModel extends t0 {
    public static final a H = new a(null);
    private String A;
    private int B;
    private int C;
    private final b0 D;
    private final LiveData E;
    private final b0 F;
    private final LiveData G;

    /* renamed from: a, reason: collision with root package name */
    private String f56562a;

    /* renamed from: f, reason: collision with root package name */
    private String f56567f;

    /* renamed from: g, reason: collision with root package name */
    private String f56568g;

    /* renamed from: k, reason: collision with root package name */
    private final b0 f56572k;

    /* renamed from: l, reason: collision with root package name */
    private final LiveData f56573l;

    /* renamed from: m, reason: collision with root package name */
    private final b0 f56574m;

    /* renamed from: n, reason: collision with root package name */
    private final b0 f56575n;

    /* renamed from: o, reason: collision with root package name */
    private final LiveData f56576o;

    /* renamed from: p, reason: collision with root package name */
    private final b0 f56577p;

    /* renamed from: q, reason: collision with root package name */
    private final LiveData f56578q;

    /* renamed from: r, reason: collision with root package name */
    private final b0 f56579r;

    /* renamed from: s, reason: collision with root package name */
    private final b0 f56580s;

    /* renamed from: t, reason: collision with root package name */
    private final LiveData f56581t;

    /* renamed from: u, reason: collision with root package name */
    private final b0 f56582u;

    /* renamed from: v, reason: collision with root package name */
    private final LiveData f56583v;

    /* renamed from: w, reason: collision with root package name */
    private final b0 f56584w;

    /* renamed from: x, reason: collision with root package name */
    private final LiveData f56585x;

    /* renamed from: y, reason: collision with root package name */
    private String f56586y;

    /* renamed from: z, reason: collision with root package name */
    private final Set f56587z;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f56563b = LazyKt.b(new Function0() { // from class: com.transsion.ugcvideodetail.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            rv.a x10;
            x10 = UGCVideoDetailViewModel.x();
            return x10;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f56564c = LazyKt.b(new Function0() { // from class: com.transsion.ugcvideodetail.viewmodel.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UGCVideoDetailPlayDao Z;
            Z = UGCVideoDetailViewModel.Z();
            return Z;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f56565d = LazyKt.b(new Function0() { // from class: com.transsion.ugcvideodetail.viewmodel.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UGCCollectionVideoGroupDao w11;
            w11 = UGCVideoDetailViewModel.w();
            return w11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private String f56566e = "";

    /* renamed from: h, reason: collision with root package name */
    private final b0 f56569h = new b0();

    /* renamed from: i, reason: collision with root package name */
    private final b0 f56570i = new b0();

    /* renamed from: j, reason: collision with root package name */
    private final b0 f56571j = new b0();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List f56588a;

        /* renamed from: b, reason: collision with root package name */
        private final String f56589b;

        public b(List videos, String str) {
            Intrinsics.h(videos, "videos");
            this.f56588a = videos;
            this.f56589b = str;
        }

        public final String a() {
            return this.f56589b;
        }

        public final List b() {
            return this.f56588a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.f56588a, bVar.f56588a) && Intrinsics.c(this.f56589b, bVar.f56589b);
        }

        public int hashCode() {
            int hashCode = this.f56588a.hashCode() * 31;
            String str = this.f56589b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ReplacePlayListData(videos=" + this.f56588a + ", clickedVideoId=" + this.f56589b + ")";
        }
    }

    public UGCVideoDetailViewModel() {
        b0 b0Var = new b0();
        this.f56572k = b0Var;
        this.f56573l = b0Var;
        this.f56574m = new b0();
        b0 b0Var2 = new b0();
        this.f56575n = b0Var2;
        this.f56576o = b0Var2;
        b0 b0Var3 = new b0();
        this.f56577p = b0Var3;
        this.f56578q = b0Var3;
        this.f56579r = new b0();
        b0 b0Var4 = new b0();
        this.f56580s = b0Var4;
        this.f56581t = b0Var4;
        b0 b0Var5 = new b0();
        this.f56582u = b0Var5;
        this.f56583v = b0Var5;
        b0 b0Var6 = new b0();
        this.f56584w = b0Var6;
        this.f56585x = b0Var6;
        this.f56587z = new LinkedHashSet();
        b0 b0Var7 = new b0();
        this.D = b0Var7;
        this.E = b0Var7;
        b0 b0Var8 = new b0();
        this.F = b0Var8;
        this.G = b0Var8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rv.a F() {
        return (rv.a) this.f56563b.getValue();
    }

    private final void V(String str, String str2) {
        k.d(u0.a(this), null, null, new UGCVideoDetailViewModel$getVideoDetail$1(this, str, str2, null), 3, null);
    }

    private final void W(String str) {
        k.d(u0.a(this), null, null, new UGCVideoDetailViewModel$getVideoDetailBySubject$1(this, str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideoDetailPlayDao Z() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k0(String str, int i11, int i12) {
        int i13;
        int i14;
        if (!Intrinsics.c(str, this.A) || (i13 = this.B) <= 0 || (i14 = this.C) <= 0 || i11 < i13 || i12 > i14) {
            return true;
        }
        a.C0856a.f(lg.a.f68962a, "UGCVideoDetailViewModel", "PlayList range already covered: requested[" + i11 + "-" + i12 + "], loaded[" + i13 + "-" + i14 + "]", false, 4, null);
        return false;
    }

    private final void v() {
        this.f56587z.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCCollectionVideoGroupDao w() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).B1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rv.a x() {
        return (rv.a) zg.c.f79537e.a().h(rv.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:13:0x002f, B:14:0x0072, B:16:0x0076, B:18:0x007c, B:21:0x0083, B:23:0x008b, B:25:0x0091, B:27:0x0099, B:28:0x00a8, B:33:0x00b5, B:40:0x0042, B:41:0x005a, B:46:0x0049), top: B:8:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(java.lang.String r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel.y(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final b0 A() {
        return this.f56571j;
    }

    public final b0 B() {
        return this.f56570i;
    }

    public final b0 C() {
        return this.f56579r;
    }

    public final b0 D() {
        return this.f56569h;
    }

    public final String E() {
        return this.f56586y;
    }

    public final LiveData G() {
        return this.f56576o;
    }

    public final b0 H() {
        return this.f56574m;
    }

    public final LiveData I() {
        return this.E;
    }

    public final LiveData J() {
        return this.f56573l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final UGCVideoDetailPlayDao K() {
        return (UGCVideoDetailPlayDao) this.f56564c.getValue();
    }

    public final LiveData L() {
        return this.f56578q;
    }

    public final LiveData M() {
        return this.f56581t;
    }

    public final LiveData N() {
        return this.f56583v;
    }

    public String O() {
        return this.f56568g;
    }

    public String P() {
        return this.f56567f;
    }

    public final LiveData Q() {
        return this.f56585x;
    }

    public final LiveData R() {
        return this.G;
    }

    public final int S(int i11) {
        return (i11 - 1) / 50;
    }

    public String T() {
        return this.f56566e;
    }

    public final void U(boolean z10, String str, String str2) {
        k.d(u0.a(this), null, null, new UGCVideoDetailViewModel$getUGCDetailForYouList$1(z10, this, str, str2, null), 3, null);
    }

    public final void X(String collectionId, int i11, int i12, boolean z10) {
        Intrinsics.h(collectionId, "collectionId");
        k.d(u0.a(this), null, null, new UGCVideoDetailViewModel$getVideoPlayList$1(this, collectionId, i11, i12, z10, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b0 Y() {
        return this.f56572k;
    }

    public final boolean a0(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.f56587z.contains(str);
    }

    public final void b0(String ugcVideoId) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        k.d(u0.a(this), null, null, new UGCVideoDetailViewModel$loadHistory$1(this, ugcVideoId, null), 3, null);
    }

    public final void c0(String ugcVideoId, String str) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        v();
        if (!Intrinsics.c(str, this.A)) {
            this.A = null;
            this.B = 0;
            this.C = 0;
        }
        V(ugcVideoId, str);
    }

    public final void d0(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        v();
        W(subjectId);
    }

    public final void e0(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.f56587z.add(str);
    }

    public final void f0(String str) {
        this.f56586y = str;
    }

    public void g0(String str) {
        this.f56568g = str;
    }

    public void h0(String str) {
        this.f56567f = str;
    }

    public final void i0(List list, String str) {
        List list2 = list;
        if (list2 == null || list2.isEmpty() || str == null || str.length() == 0) {
            return;
        }
        this.f56584w.q(new b(list, str));
    }

    public void j0(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f56566e = str;
    }

    public final void l0(String ugcVideoId, boolean z10) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        k.d(u0.a(this), null, null, new UGCVideoDetailViewModel$toggleFavorite$1(this, ugcVideoId, z10, null), 3, null);
    }

    public final void m0(String ugcVideoId, boolean z10) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        k.d(u0.a(this), null, null, new UGCVideoDetailViewModel$toggleLike$1(this, ugcVideoId, z10, null), 3, null);
    }

    public final void n0(String targetUID, boolean z10) {
        Intrinsics.h(targetUID, "targetUID");
        k.d(u0.a(this), null, null, new UGCVideoDetailViewModel$toggleSubscription$1(this, targetUID, z10, null), 3, null);
    }

    public final void u(List list, boolean z10) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Iterable<UGCVideo> iterable = (List) this.f56579r.f();
        if (iterable == null) {
            iterable = new ArrayList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (UGCVideo uGCVideo : iterable) {
            String ugcVideoId = uGCVideo.getUgcVideoId();
            if (ugcVideoId != null) {
                linkedHashMap.put(ugcVideoId, uGCVideo);
            }
        }
        if (z10) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                UGCVideo uGCVideo2 = (UGCVideo) it.next();
                String ugcVideoId2 = uGCVideo2.getUgcVideoId();
                if (ugcVideoId2 != null) {
                    linkedHashMap.put(ugcVideoId2, uGCVideo2);
                }
            }
        } else {
            for (UGCVideo uGCVideo3 : CollectionsKt.T(list)) {
                String ugcVideoId3 = uGCVideo3.getUgcVideoId();
                if (ugcVideoId3 != null && !linkedHashMap.containsKey(ugcVideoId3)) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put(ugcVideoId3, uGCVideo3);
                    linkedHashMap2.putAll(linkedHashMap);
                    linkedHashMap.clear();
                    linkedHashMap.putAll(linkedHashMap2);
                }
            }
        }
        b0 b0Var = this.f56579r;
        Collection values = linkedHashMap.values();
        Intrinsics.g(values, "<get-values>(...)");
        b0Var.q(CollectionsKt.U0(values));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final UGCCollectionVideoGroupDao z() {
        return (UGCCollectionVideoGroupDao) this.f56565d.getValue();
    }
}
