package com.transsnet.downloader.viewmodel;

import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import lj.b;

/* loaded from: classes7.dex */
public final class DownloadResourcesDetectorViewModel extends t0 {

    /* renamed from: x, reason: collision with root package name */
    public static final a f60136x = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f60137a = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a J;
            J = DownloadResourcesDetectorViewModel.J();
            return J;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private n0 f60138b = o0.a(y0.b());

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f60139c = new androidx.view.b0();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.view.b0 f60140d = new androidx.view.b0();

    /* renamed from: e, reason: collision with root package name */
    private final androidx.view.b0 f60141e = new androidx.view.b0();

    /* renamed from: f, reason: collision with root package name */
    private final androidx.view.b0 f60142f = new androidx.view.b0();

    /* renamed from: g, reason: collision with root package name */
    private final androidx.view.b0 f60143g = new androidx.view.b0();

    /* renamed from: h, reason: collision with root package name */
    private final androidx.view.b0 f60144h = new androidx.view.b0();

    /* renamed from: i, reason: collision with root package name */
    private final androidx.view.b0 f60145i = new androidx.view.b0();

    /* renamed from: j, reason: collision with root package name */
    private final androidx.view.b0 f60146j = new androidx.view.b0();

    /* renamed from: k, reason: collision with root package name */
    private final androidx.view.b0 f60147k = new androidx.view.b0();

    /* renamed from: l, reason: collision with root package name */
    private final androidx.view.b0 f60148l = new androidx.view.b0();

    /* renamed from: m, reason: collision with root package name */
    private final androidx.view.b0 f60149m = new androidx.view.b0();

    /* renamed from: n, reason: collision with root package name */
    private final androidx.view.b0 f60150n = new androidx.view.b0();

    /* renamed from: o, reason: collision with root package name */
    private final androidx.view.b0 f60151o = new androidx.view.b0();

    /* renamed from: p, reason: collision with root package name */
    private final androidx.view.b0 f60152p = new androidx.view.b0();

    /* renamed from: q, reason: collision with root package name */
    private final androidx.view.b0 f60153q = new androidx.view.b0();

    /* renamed from: r, reason: collision with root package name */
    private final androidx.view.b0 f60154r = new androidx.view.b0();

    /* renamed from: s, reason: collision with root package name */
    private final androidx.view.b0 f60155s = new androidx.view.b0();

    /* renamed from: t, reason: collision with root package name */
    private final androidx.view.b0 f60156t = new androidx.view.b0();

    /* renamed from: u, reason: collision with root package name */
    private final androidx.view.b0 f60157u = new androidx.view.b0();

    /* renamed from: v, reason: collision with root package name */
    private final androidx.view.b0 f60158v = new androidx.view.b0();

    /* renamed from: w, reason: collision with root package name */
    private final androidx.view.b0 f60159w = new androidx.view.b0();

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qy.a C() {
        return (qy.a) this.f60137a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qy.a J() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        boolean z10;
        my.b bVar;
        boolean z11;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "DownloadReDetector", "--- getPathInfo", false, 4, null);
        ArrayList arrayList = new ArrayList();
        List a11 = DownloadSDCardUtil.f60017a.a();
        DownloadEsHelper.a aVar = DownloadEsHelper.f59542m;
        aVar.a().i();
        String e11 = lj.b.f68989a.e();
        String t11 = aVar.a().t();
        a.C0856a.v(c0856a, "DownloadReDetector", "--- savedPath = " + t11, false, 4, null);
        Iterator it = a11.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            my.b bVar2 = (my.b) it.next();
            if (Intrinsics.c(bVar2.b(), t11)) {
                bVar2.g(true);
                z10 = true;
                break;
            }
        }
        long a12 = com.blankj.utilcode.util.w.a();
        b.a aVar2 = lj.b.f68989a;
        String a13 = aVar2.a();
        char c11 = (Intrinsics.c(t11, e11) || (a11.isEmpty() && !Intrinsics.c(t11, a13))) ? (char) 1 : z10 ? (char) 2 : (char) 3;
        String string = Utils.a().getString(R$string.str_download_dialog_path_moviebox_folder);
        Intrinsics.g(string, "getString(...)");
        my.b bVar3 = new my.b(e11, "", string, 1, a12, 1);
        if (c11 == 1) {
            z11 = true;
            bVar = bVar3;
        } else {
            bVar = bVar3;
            z11 = false;
        }
        bVar.g(z11);
        String b11 = aVar2.b();
        String string2 = Utils.a().getString(R$string.str_download_dialog_path_albums);
        Intrinsics.g(string2, "getString(...)");
        my.b bVar4 = new my.b(a13, b11, string2, 3, a12, 2);
        bVar4.g(c11 == 3);
        arrayList.add(bVar);
        arrayList.add(bVar4);
        arrayList.addAll(a11);
        this.f60143g.n(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String str) {
        a.C0856a.f(lg.a.f68962a, "DownloadReDetector", "--- getDownloadSavePathInfo, savedRootPath = " + str, false, 4, null);
        ArrayList arrayList = new ArrayList();
        long a11 = com.blankj.utilcode.util.w.a();
        b.a aVar = lj.b.f68989a;
        aVar.e();
        String a12 = aVar.a();
        String b11 = aVar.b();
        String string = Utils.a().getString(R$string.str_download_dialog_path_albums);
        Intrinsics.g(string, "getString(...)");
        my.b bVar = new my.b(a12, b11, string, 3, a11, 2);
        bVar.g(Intrinsics.c(a12, str));
        List a13 = DownloadSDCardUtil.f60017a.a();
        DownloadEsHelper.f59542m.a().i();
        Iterator it = a13.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            my.b bVar2 = (my.b) it.next();
            if (Intrinsics.c(bVar2.b(), str)) {
                bVar2.g(true);
                break;
            }
        }
        arrayList.add(bVar);
        arrayList.addAll(a13);
        this.f60144h.n(arrayList);
    }

    public final androidx.view.b0 A() {
        return this.f60145i;
    }

    public final androidx.view.b0 B() {
        return this.f60142f;
    }

    public final androidx.view.b0 D() {
        return this.f60156t;
    }

    public final androidx.view.b0 E() {
        return this.f60158v;
    }

    public final androidx.view.b0 F() {
        return this.f60153q;
    }

    public final androidx.view.b0 G() {
        return this.f60154r;
    }

    public final androidx.view.b0 H() {
        return this.f60157u;
    }

    public final androidx.view.b0 I() {
        return this.f60155s;
    }

    public final void K(String type) {
        Intrinsics.h(type, "type");
        this.f60155s.q(type);
    }

    public final void L(my.c item) {
        Intrinsics.h(item, "item");
        Map map = (Map) this.f60153q.f();
        if (map == null) {
            map = new LinkedHashMap();
        }
        if (item.d()) {
            map.remove(Integer.valueOf(item.a()));
        } else {
            map.put(Integer.valueOf(item.a()), item);
        }
        this.f60153q.q(map);
    }

    public final void f(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new DownloadResourcesDetectorViewModel$favorite$1(subject, shortTVFavInfo.getHasFavorite(), this, shortTVFavInfo, null), 3, null);
    }

    public final androidx.view.b0 g() {
        return this.f60150n;
    }

    public final androidx.view.b0 h() {
        return this.f60147k;
    }

    public final androidx.view.b0 i() {
        return this.f60141e;
    }

    public final void j(String str, String str2, int i11, String nextPage, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        Intrinsics.h(nextPage, "nextPage");
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadResourcesDetectorViewModel$getDownloadList$1(i18, str, i13, i14, i11, this, nextPage, i12, i15, i16, i17, str2, null), 3, null);
    }

    public final void l(String savedRootPath) {
        Intrinsics.h(savedRootPath, "savedRootPath");
        kotlinx.coroutines.k.d(this.f60138b, null, null, new DownloadResourcesDetectorViewModel$getDownloadSavePathInfo$1(this, savedRootPath, null), 3, null);
    }

    public final androidx.view.b0 m() {
        return this.f60140d;
    }

    public final androidx.view.b0 n() {
        return this.f60149m;
    }

    public final androidx.view.b0 o() {
        return this.f60151o;
    }

    public final androidx.view.b0 p() {
        return this.f60139c;
    }

    public final androidx.view.b0 r() {
        return this.f60143g;
    }

    public final androidx.view.b0 s() {
        return this.f60152p;
    }

    public final void t(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new DownloadResourcesDetectorViewModel$getResourceAllLangInfo$1(this, subjectId, null), 3, null);
    }

    public final void u(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new DownloadResourcesDetectorViewModel$getResourcesSeasonInfo$1(this, subjectId, null), 3, null);
    }

    public final void v() {
        kotlinx.coroutines.k.d(this.f60138b, null, null, new DownloadResourcesDetectorViewModel$getSDCardPathInfo$1(this, null), 3, null);
    }

    public final androidx.view.b0 x() {
        return this.f60144h;
    }

    public final androidx.view.b0 y() {
        return this.f60146j;
    }

    public final androidx.view.b0 z() {
        return this.f60148l;
    }
}
