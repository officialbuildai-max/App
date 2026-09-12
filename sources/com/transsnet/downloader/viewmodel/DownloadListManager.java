package com.transsnet.downloader.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.ad.utils.CommonLogUtil;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public final class DownloadListManager {

    /* renamed from: m */
    public static final a f60117m = new a(null);

    /* renamed from: n */
    private static final Lazy f60118n = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.downloader.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadListManager U;
            U = DownloadListManager.U();
            return U;
        }
    });

    /* renamed from: g */
    private androidx.view.b0 f60125g;

    /* renamed from: h */
    private androidx.view.b0 f60126h;

    /* renamed from: j */
    private androidx.view.b0 f60128j;

    /* renamed from: a */
    private final Lazy f60119a = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a X;
            X = DownloadListManager.X();
            return X;
        }
    });

    /* renamed from: b */
    private final Lazy f60120b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            lj.c t11;
            t11 = DownloadListManager.t();
            return t11;
        }
    });

    /* renamed from: c */
    private final Lazy f60121c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 u11;
            u11 = DownloadListManager.u();
            return u11;
        }
    });

    /* renamed from: d */
    private final Lazy f60122d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 w11;
            w11 = DownloadListManager.w();
            return w11;
        }
    });

    /* renamed from: e */
    private final Lazy f60123e = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 y10;
            y10 = DownloadListManager.y();
            return y10;
        }
    });

    /* renamed from: f */
    private final Lazy f60124f = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 W;
            W = DownloadListManager.W();
            return W;
        }
    });

    /* renamed from: i */
    private ConcurrentHashMap f60127i = new ConcurrentHashMap();

    /* renamed from: k */
    private boolean f60129k = true;

    /* renamed from: l */
    private Map f60130l = new LinkedHashMap();

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadListManager a() {
            return (DownloadListManager) DownloadListManager.f60118n.getValue();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            a.C0856a.f(lg.a.f68962a, "downloadAna", "url download, get config failure, liveData is null = " + (DownloadListManager.this.Q() == null), false, 4, null);
            androidx.view.b0 Q = DownloadListManager.this.Q();
            if (Q != null) {
                Q.n(null);
            }
        }

        @Override // sg.a
        /* renamed from: e */
        public void c(DownloadUrlBean downloadUrlBean) {
            a.C0856a.v(lg.a.f68962a, "downloadAna", "url download, get config success, liveData is null = " + (DownloadListManager.this.Q() == null), false, 4, null);
            androidx.view.b0 Q = DownloadListManager.this.Q();
            if (Q != null) {
                Q.n(downloadUrlBean);
            }
        }
    }

    public static /* synthetic */ void I(DownloadListManager downloadListManager, boolean z10, boolean z11, BiddingNativeManager biddingNativeManager, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            biddingNativeManager = null;
        }
        downloadListManager.H(z10, z11, biddingNativeManager);
    }

    public final qy.a L() {
        return (qy.a) this.f60119a.getValue();
    }

    public static /* synthetic */ void N(DownloadListManager downloadListManager, String str, int i11, int i12, String str2, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 1;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            i12 = 20;
        }
        int i16 = i12;
        if ((i14 & 8) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i14 & 16) != 0) {
            i13 = com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0);
        }
        downloadListManager.M(str, i15, i16, str3, i13);
    }

    private final List R(List list) {
        Iterator it;
        int i11 = 0;
        int i12 = 1;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it2.next();
            if (linkedHashMap.containsKey(downloadBean.getSubjectId())) {
                if (downloadBean.isVideo() && Intrinsics.c(downloadBean.getResourceId(), downloadBean.getUrl())) {
                    arrayList.add(downloadBean);
                } else {
                    List list2 = (List) linkedHashMap.get(downloadBean.getSubjectId());
                    if (list2 != null) {
                        list2.add(downloadBean);
                    }
                }
            } else if (downloadBean.getSubjectId() != null) {
                String subjectId = downloadBean.getSubjectId();
                Intrinsics.e(subjectId);
                linkedHashMap.put(subjectId, CollectionsKt.q(downloadBean));
            } else {
                arrayList.add(downloadBean);
            }
        }
        Iterator it3 = linkedHashMap.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            if (((List) entry.getValue()).size() == i12) {
                arrayList.add(((List) entry.getValue()).get(i11));
            } else if (((List) entry.getValue()).size() > i12) {
                DownloadBean downloadBean2 = (DownloadBean) ((List) entry.getValue()).get(i11);
                DownloadBean downloadBean3 = new DownloadBean("series", "series", "", downloadBean2.getCover(), 0L, null, null, null, null, downloadBean2.getUpdateTimeStamp(), 0L, 0, 0, 0, 0L, downloadBean2.getCreateAt(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -33312, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
                downloadBean3.setStatus(10);
                List list3 = (List) entry.getValue();
                if (list3.size() > i12) {
                    CollectionsKt.A(list3, new Comparator() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$handleDownloaded$lambda$14$$inlined$sortBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t11, T t12) {
                            return ComparisonsKt.d(Integer.valueOf(((DownloadBean) t11).getEpse()), Integer.valueOf(((DownloadBean) t12).getEpse()));
                        }
                    });
                }
                downloadBean3.getSeriesList().addAll((Collection) entry.getValue());
                DownloadBean downloadBean4 = downloadBean2;
                long j11 = 0;
                long j12 = 0;
                long j13 = 0;
                boolean z10 = false;
                int i13 = 0;
                boolean z11 = false;
                for (DownloadBean downloadBean5 : (List) entry.getValue()) {
                    Iterator it4 = it3;
                    if (downloadBean5.getStatus() == 14) {
                        it3 = it4;
                        i13 = 1;
                    } else {
                        if (downloadBean5.getIsTransferFailed()) {
                            z10 = true;
                        }
                        if (!z11 && !downloadBean5.getIsTransferFailed() && downloadBean5.isFileExist()) {
                            downloadBean4 = downloadBean5;
                            z11 = true;
                        }
                        Long size = downloadBean5.getSize();
                        j11 += size != null ? size.longValue() : 0L;
                        Long duration = downloadBean5.getDuration();
                        j12 += duration != null ? duration.longValue() : 0L;
                        j13 += downloadBean5.getReadProgress();
                        it3 = it4;
                    }
                }
                it = it3;
                downloadBean3.setTransferFailed(z10);
                downloadBean3.setThumbnail(downloadBean2.getThumbnail());
                downloadBean3.setCount(((List) entry.getValue()).size() - i13);
                downloadBean3.setSize(Long.valueOf(j11));
                downloadBean3.setDuration(Long.valueOf(j12));
                downloadBean3.setOps(downloadBean2.getOps());
                downloadBean3.setTotalEpisode(downloadBean2.getTotalEpisode());
                downloadBean3.setSubjectId(downloadBean2.getSubjectId());
                downloadBean3.setSubjectName(downloadBean2.getSubjectName());
                downloadBean3.setReadProgress(j13);
                downloadBean3.setRootPath(downloadBean4.getRootPath());
                downloadBean3.setRootPathType(downloadBean4.getRootPathType());
                downloadBean3.setType(downloadBean2.getType());
                downloadBean3.setSubjectType(downloadBean2.getSubjectType());
                c0(downloadBean3);
                arrayList.add(downloadBean3);
                it3 = it;
                i11 = 0;
                i12 = 1;
            }
            it = it3;
            it3 = it;
            i11 = 0;
            i12 = 1;
        }
        if (arrayList.size() > 1) {
            CollectionsKt.A(arrayList, new Comparator() { // from class: com.transsnet.downloader.viewmodel.DownloadListManager$handleDownloaded$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return ComparisonsKt.d(Long.valueOf(((DownloadBean) t12).getCreateAt()), Long.valueOf(((DownloadBean) t11).getCreateAt()));
                }
            });
        }
        return arrayList;
    }

    public final void S(List list) {
        if (this.f60130l == null) {
            this.f60130l = new LinkedHashMap();
        }
        this.f60130l.clear();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            String resourceId = ((DownloadBean) list.get(i11)).getResourceId();
            if (resourceId != null && resourceId.length() > 0) {
                this.f60130l.put(resourceId, Integer.valueOf(i11));
            }
        }
    }

    public final void T(List list, BiddingNativeManager biddingNativeManager) {
        Object m1185constructorimpl;
        DownloadBean downloadBean;
        Object obj;
        if (biddingNativeManager == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            downloadBean = new DownloadBean(CommonLogUtil.TAG_AD, CommonLogUtil.TAG_AD, CommonLogUtil.TAG_AD, "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            downloadBean.setStatus(13);
            downloadBean.setWrapNativeManager(biddingNativeManager);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (biddingNativeManager.V0()) {
            if (2 >= list.size()) {
                obj = Boolean.valueOf(list.add(downloadBean));
            } else {
                list.add(2, downloadBean);
                obj = Unit.f67184a;
            }
            m1185constructorimpl = Result.m1185constructorimpl(obj);
            Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        }
    }

    public static final DownloadListManager U() {
        return new DownloadListManager();
    }

    public static final androidx.view.b0 W() {
        return new androidx.view.b0();
    }

    public static final qy.a X() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    private final void c0(DownloadBean downloadBean) {
        if (K().f() == null) {
            return;
        }
        DownloadBean downloadBean2 = (DownloadBean) K().f();
        if (Intrinsics.c(downloadBean2 != null ? downloadBean2.getSubjectId() : null, downloadBean.getSubjectId())) {
            K().n(downloadBean);
        }
    }

    public final void q(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                if (!TextUtils.isEmpty(downloadBean.getSubjectId()) && !TextUtils.isEmpty(downloadBean.getResourceId()) && !downloadBean.isShotTV()) {
                    DownloadManagerApi.f58521j.a().T(downloadBean.getSubjectId(), downloadBean.getResourceId(), downloadBean.isSeries(), downloadBean.getTotalEpisode(), false, downloadBean.getResolution() > 0);
                }
            }
        }
    }

    public final void s(List list) {
        File[] listFiles;
        if (list.isEmpty()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                File s11 = DownloadEsHelper.f59542m.a().s();
                if (s11.exists() && s11.isDirectory() && (listFiles = s11.listFiles()) != null && listFiles.length != 0) {
                    hj.i.f64628a.s("download", "app_perf", MapsKt.f(TuplesKt.a("download_ops", "delete_download_file")));
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    public static final lj.c t() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).p1();
        }
        return null;
    }

    public static final androidx.view.b0 u() {
        return new androidx.view.b0();
    }

    public final Object v(List list, Continuation continuation) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(R(list));
        }
        a.C0856a.f(lg.a.f68962a, "DownloadPanel", "2-  get getDownloadedList success = " + arrayList.size(), false, 4, null);
        return arrayList;
    }

    public static final androidx.view.b0 w() {
        return new androidx.view.b0();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1
            if (r0 == 0) goto L13
            r0 = r12
            com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1 r0 = (com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1 r0 = new com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r12)
            goto L43
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L31:
            kotlin.ResultKt.b(r12)
            com.transsnet.downloader.manager.DownloadEsHelper$a r12 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r12 = r12.a()
            r0.label = r3
            java.lang.Object r12 = r12.C(r0)
            if (r12 != r1) goto L43
            return r1
        L43:
            java.util.List r12 = (java.util.List) r12
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r12 == 0) goto L7c
            r1 = r12
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L7c
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        L5b:
            if (r4 >= r2) goto L73
            java.lang.Object r5 = r12.get(r4)
            com.transsion.baselib.db.download.DownloadBean r5 = (com.transsion.baselib.db.download.DownloadBean) r5
            boolean r6 = r5.isDownloading()
            if (r6 == 0) goto L70
            boolean r5 = r5.getIsPreDownload()
            if (r5 != 0) goto L70
            goto L74
        L70:
            int r4 = r4 + 1
            goto L5b
        L73:
            r4 = -1
        L74:
            if (r4 <= 0) goto L79
            java.util.Collections.swap(r12, r4, r3)
        L79:
            r0.addAll(r1)
        L7c:
            lg.a$a r5 = lg.a.f68962a
            int r12 = r0.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "1 -- get getDownloadingList success = "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r7 = r1.toString()
            r9 = 4
            r10 = 0
            java.lang.String r6 = "DownloadPanel"
            r8 = 0
            lg.a.C0856a.f(r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.DownloadListManager.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final androidx.view.b0 y() {
        return new androidx.view.b0();
    }

    public final ConcurrentHashMap A() {
        return this.f60127i;
    }

    public final androidx.view.b0 B() {
        return (androidx.view.b0) this.f60121c.getValue();
    }

    public final Map C() {
        return this.f60130l;
    }

    public final androidx.view.b0 D() {
        return this.f60126h;
    }

    public final void E() {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadListManager$getDownloadedList$1(this, null), 3, null);
    }

    public final androidx.view.b0 F() {
        return (androidx.view.b0) this.f60122d.getValue();
    }

    public final androidx.view.b0 G() {
        return (androidx.view.b0) this.f60123e.getValue();
    }

    public final void H(boolean z10, boolean z11, BiddingNativeManager biddingNativeManager) {
        E();
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadListManager$getList$1(z11, this, z10, biddingNativeManager, null), 3, null);
    }

    public final Object J(int i11, Continuation continuation) {
        return DownloadEsHelper.f59542m.a().G(i11, continuation);
    }

    public final androidx.view.b0 K() {
        return (androidx.view.b0) this.f60124f.getValue();
    }

    public final void M(String str, int i11, int i12, String str2, int i13) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadListManager$getShortTVList$1(i13, this, str, i11, i12, str2, null), 3, null);
    }

    public final Object O(Continuation continuation) {
        return DownloadEsHelper.f59542m.a().M(continuation);
    }

    public final void P(String str, String linkUrl) {
        Intrinsics.h(linkUrl, "linkUrl");
        if (this.f60128j == null) {
            this.f60128j = new androidx.view.b0();
        }
        L().e(vg.a.f77447a.a(), linkUrl, str).f(sg.d.f75472a.c()).subscribe(new b());
    }

    public final androidx.view.b0 Q() {
        return this.f60128j;
    }

    public final boolean V() {
        return this.f60129k;
    }

    public final void Y(androidx.view.b0 b0Var) {
        this.f60125g = b0Var;
    }

    public final void Z(androidx.view.b0 b0Var) {
        this.f60126h = b0Var;
    }

    public final void a0(boolean z10) {
        this.f60129k = z10;
    }

    public final void b0(androidx.view.b0 b0Var) {
        this.f60128j = b0Var;
    }

    public final void p(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadBean");
        if (this.f60126h == null) {
            this.f60126h = new androidx.view.b0();
        }
        androidx.view.b0 b0Var = this.f60126h;
        if (b0Var != null) {
            b0Var.q(downloadBean);
        }
    }

    public final void r(int i11) {
        if (this.f60127i.containsKey(Integer.valueOf(i11))) {
            return;
        }
        this.f60127i.put(Integer.valueOf(i11), new androidx.view.b0());
    }

    public final androidx.view.b0 z() {
        return this.f60125g;
    }
}
