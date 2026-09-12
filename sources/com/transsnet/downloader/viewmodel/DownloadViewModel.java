package com.transsnet.downloader.viewmodel;

import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.y0;
import okhttp3.internal.http2.Settings;

/* loaded from: classes7.dex */
public final class DownloadViewModel extends t0 {

    /* renamed from: d, reason: collision with root package name */
    private boolean f60167d;

    /* renamed from: a, reason: collision with root package name */
    private final String f60164a = DownloadViewModel.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f60165b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a s02;
            s02 = DownloadViewModel.s0();
            return s02;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f60166c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.x
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 q02;
            q02 = DownloadViewModel.q0();
            return q02;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f60168e = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.y
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 F;
            F = DownloadViewModel.F();
            return F;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f60169f = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.z
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 E0;
            E0 = DownloadViewModel.E0();
            return E0;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f60170g = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 G;
            G = DownloadViewModel.G();
            return G;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f60171h = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 E;
            E = DownloadViewModel.E();
            return E;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f60172i = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 C0;
            C0 = DownloadViewModel.C0();
            return C0;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f60173j = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 D0;
            D0 = DownloadViewModel.D0();
            return D0;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f60174k = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 A0;
            A0 = DownloadViewModel.A0();
            return A0;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    private final Lazy f60175l = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 v02;
            v02 = DownloadViewModel.v0();
            return v02;
        }
    });

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f60176m = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 z02;
            z02 = DownloadViewModel.z0();
            return z02;
        }
    });

    /* renamed from: n, reason: collision with root package name */
    private final Map f60177n = new LinkedHashMap();

    /* renamed from: o, reason: collision with root package name */
    private final androidx.view.b0 f60178o = new androidx.view.b0();

    /* renamed from: p, reason: collision with root package name */
    private final androidx.view.b0 f60179p = new androidx.view.b0();

    /* renamed from: q, reason: collision with root package name */
    private final androidx.view.b0 f60180q = new androidx.view.b0();

    /* renamed from: r, reason: collision with root package name */
    private final androidx.view.b0 f60181r = new androidx.view.b0();

    /* renamed from: s, reason: collision with root package name */
    private final androidx.view.b0 f60182s = new androidx.view.b0();

    /* renamed from: t, reason: collision with root package name */
    private final Lazy f60183t = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 w02;
            w02 = DownloadViewModel.w0();
            return w02;
        }
    });

    /* renamed from: u, reason: collision with root package name */
    private final Lazy f60184u = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 x02;
            x02 = DownloadViewModel.x0();
            return x02;
        }
    });

    /* renamed from: v, reason: collision with root package name */
    private final Lazy f60185v = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.u
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 B0;
            B0 = DownloadViewModel.B0();
            return B0;
        }
    });

    /* renamed from: w, reason: collision with root package name */
    private final Lazy f60186w = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.v
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 y02;
            y02 = DownloadViewModel.y0();
            return y02;
        }
    });

    /* renamed from: x, reason: collision with root package name */
    private final Lazy f60187x = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.w
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            List u02;
            u02 = DownloadViewModel.u0();
            return u02;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 A0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 B0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 C0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map D(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return MapsKt.h();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it.next();
            String X = X(downloadBean);
            Object obj = linkedHashMap.get(X);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(X, obj);
            }
            ((List) obj).add(downloadBean);
        }
        return t0(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 D0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 E() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 E0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 F() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 G() {
        return new androidx.view.b0();
    }

    public static /* synthetic */ void N(DownloadViewModel downloadViewModel, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        downloadViewModel.M(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qy.a W() {
        return (qy.a) this.f60165b.getValue();
    }

    private final String X(DownloadBean downloadBean) {
        String ugcVideoType = downloadBean.getUgcVideoType();
        if (ugcVideoType != null && ugcVideoType.length() != 0) {
            return Y(downloadBean.getUgcVideoType());
        }
        int subjectType = downloadBean.getSubjectType();
        if (subjectType == SubjectType.MOVIE.getValue()) {
            String string = Utils.a().getString(R$string.ugc_tab_movie);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (subjectType == SubjectType.TV.getValue()) {
            String string2 = Utils.a().getString(R$string.ugc_tab_tv);
            Intrinsics.g(string2, "getString(...)");
            return string2;
        }
        if (subjectType == SubjectType.VSHOW.getValue()) {
            String string3 = Utils.a().getString(R$string.ugc_tab_video);
            Intrinsics.g(string3, "getString(...)");
            return string3;
        }
        if (subjectType == SubjectType.AUDIO.getValue() || subjectType == SubjectType.MUSIC.getValue()) {
            String string4 = Utils.a().getString(R$string.ugc_tab_music);
            Intrinsics.g(string4, "getString(...)");
            return string4;
        }
        if (subjectType == SubjectType.EDUCATION.getValue()) {
            String string5 = Utils.a().getString(R$string.ugc_tab_education);
            Intrinsics.g(string5, "getString(...)");
            return string5;
        }
        if (subjectType == SubjectType.SHORT_TV.getValue()) {
            String string6 = Utils.a().getString(R$string.ugc_tab_short_tv);
            Intrinsics.g(string6, "getString(...)");
            return string6;
        }
        if (subjectType == SubjectType.SPORT.getValue()) {
            String string7 = Utils.a().getString(R$string.ugc_tab_sport);
            Intrinsics.g(string7, "getString(...)");
            return string7;
        }
        String string8 = Utils.a().getString(R$string.ugc_tab_video);
        Intrinsics.g(string8, "getString(...)");
        return string8;
    }

    private final String Y(String str) {
        if (str == null || str.length() == 0) {
            String string = Utils.a().getString(R$string.ugc_tab_video);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (Intrinsics.c(str, UGCVideoType.MOVIE.getValue())) {
            String string2 = Utils.a().getString(R$string.ugc_tab_movie);
            Intrinsics.g(string2, "getString(...)");
            return string2;
        }
        if (Intrinsics.c(str, UGCVideoType.TV.getValue())) {
            String string3 = Utils.a().getString(R$string.ugc_tab_tv);
            Intrinsics.g(string3, "getString(...)");
            return string3;
        }
        if (Intrinsics.c(str, UGCVideoType.MUSIC.getValue())) {
            String string4 = Utils.a().getString(R$string.ugc_tab_music);
            Intrinsics.g(string4, "getString(...)");
            return string4;
        }
        if (Intrinsics.c(str, UGCVideoType.EDUCATION.getValue())) {
            String string5 = Utils.a().getString(R$string.ugc_tab_education);
            Intrinsics.g(string5, "getString(...)");
            return string5;
        }
        if (Intrinsics.c(str, UGCVideoType.SHORT_TV.getValue())) {
            String string6 = Utils.a().getString(R$string.ugc_tab_short_tv);
            Intrinsics.g(string6, "getString(...)");
            return string6;
        }
        if (Intrinsics.c(str, UGCVideoType.SPORT.getValue())) {
            String string7 = Utils.a().getString(R$string.ugc_tab_sport);
            Intrinsics.g(string7, "getString(...)");
            return string7;
        }
        if (Intrinsics.c(str, UGCVideoType.ROOM.getValue())) {
            String string8 = Utils.a().getString(R$string.ugc_tab_room);
            Intrinsics.g(string8, "getString(...)");
            return string8;
        }
        if (Intrinsics.c(str, UGCVideoType.NOVEL.getValue())) {
            String string9 = Utils.a().getString(R$string.ugc_tab_novel);
            Intrinsics.g(string9, "getString(...)");
            return string9;
        }
        if (Intrinsics.c(str, UGCVideoType.LIVE.getValue())) {
            String string10 = Utils.a().getString(R$string.ugc_tab_live);
            Intrinsics.g(string10, "getString(...)");
            return string10;
        }
        if (Intrinsics.c(str, UGCVideoType.KIDS.getValue())) {
            String string11 = Utils.a().getString(R$string.ugc_tab_kids);
            Intrinsics.g(string11, "getString(...)");
            return string11;
        }
        if (Intrinsics.c(str, UGCVideoType.RECREATION.getValue())) {
            String string12 = Utils.a().getString(R$string.ugc_tab_recreation);
            Intrinsics.g(string12, "getString(...)");
            return string12;
        }
        if (Intrinsics.c(str, UGCVideoType.POST.getValue())) {
            String string13 = Utils.a().getString(R$string.ugc_tab_post);
            Intrinsics.g(string13, "getString(...)");
            return string13;
        }
        String string14 = Utils.a().getString(R$string.ugc_tab_video);
        Intrinsics.g(string14, "getString(...)");
        return string14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List Z() {
        return (List) this.f60187x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DownloadBean o0(List list) {
        DownloadBean downloadBean = (DownloadBean) CollectionsKt.i0(list);
        DownloadBean downloadBean2 = new DownloadBean("series", "series", "", downloadBean.getCover(), 0L, null, null, null, null, downloadBean.getUpdateTimeStamp(), 0L, 0, 0, 0, 0L, downloadBean.getCreateAt(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -33312, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
        downloadBean2.setStatus(10);
        downloadBean2.getSeriesList().addAll(list);
        Iterator it = list.iterator();
        boolean z10 = false;
        DownloadBean downloadBean3 = downloadBean;
        int i11 = 0;
        boolean z11 = false;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        while (it.hasNext()) {
            DownloadBean downloadBean4 = (DownloadBean) it.next();
            if (downloadBean4.getStatus() == 14) {
                i11 = 1;
            } else {
                if (downloadBean4.getIsTransferFailed()) {
                    z10 = true;
                }
                if (!z11 && !downloadBean4.getIsTransferFailed() && downloadBean4.isFileExist()) {
                    downloadBean3 = downloadBean4;
                    z11 = true;
                }
                Long size = downloadBean4.getSize();
                j11 += size != null ? size.longValue() : 0L;
                Long duration = downloadBean4.getDuration();
                j12 += duration != null ? duration.longValue() : 0L;
                j13 += downloadBean4.getReadProgress();
            }
        }
        downloadBean2.setTransferFailed(z10);
        downloadBean2.setThumbnail(downloadBean.getThumbnail());
        downloadBean2.setCount(list.size() - i11);
        downloadBean2.setSize(Long.valueOf(j11));
        downloadBean2.setDuration(Long.valueOf(j12));
        downloadBean2.setOps(downloadBean.getOps());
        downloadBean2.setTotalEpisode(downloadBean.getTotalEpisode());
        downloadBean2.setSubjectId(downloadBean.getSubjectId());
        downloadBean2.setSubjectName(downloadBean.getSubjectName());
        downloadBean2.setReadProgress(j13);
        downloadBean2.setRootPath(downloadBean3.getRootPath());
        downloadBean2.setRootPathType(downloadBean3.getRootPathType());
        downloadBean2.setType(downloadBean.getType());
        downloadBean2.setSubjectType(downloadBean.getSubjectType());
        downloadBean2.setUgcVideoCollectionId(downloadBean.getUgcVideoCollectionId());
        downloadBean2.setUgcVideoId(downloadBean.getUgcVideoId());
        downloadBean2.setUgcVideoType(downloadBean.getUgcVideoType());
        downloadBean2.setUgcVideoCollectionName(downloadBean.getUgcVideoCollectionName());
        return downloadBean2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(List list) {
        DownloadBean downloadBean;
        List list2 = list;
        if (list2 == null || list2.isEmpty() || (downloadBean = (DownloadBean) CollectionsKt.k0(list)) == null || downloadBean.getTotalEpisode() <= list.size()) {
            return;
        }
        DownloadBean downloadBean2 = new DownloadBean("allEp", "allEp", downloadBean.getType() == 1 ? Utils.a().getResources().getString(R$string.download_series_all_chapters) : Utils.a().getResources().getString(R$string.download_series_all_episodes), "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
        downloadBean2.setStatus(14);
        list.add(downloadBean2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 q0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qy.a s0() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    private final Map t0(Map map) {
        List<Map.Entry> I0 = CollectionsKt.I0(map.entrySet(), new Comparator() { // from class: com.transsnet.downloader.viewmodel.DownloadViewModel$sortTabsByOrder$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                List Z;
                List Z2;
                Z = DownloadViewModel.this.Z();
                int indexOf = Z.indexOf(((Map.Entry) t11).getKey());
                if (indexOf < 0) {
                    indexOf = Integer.MAX_VALUE;
                }
                Integer valueOf = Integer.valueOf(indexOf);
                Z2 = DownloadViewModel.this.Z();
                int indexOf2 = Z2.indexOf(((Map.Entry) t12).getKey());
                return ComparisonsKt.d(valueOf, Integer.valueOf(indexOf2 >= 0 ? indexOf2 : Integer.MAX_VALUE));
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(I0, 10)), 16));
        for (Map.Entry entry : I0) {
            Pair a11 = TuplesKt.a(entry.getKey(), entry.getValue());
            linkedHashMap.put(a11.getFirst(), a11.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u0() {
        return CollectionsKt.o(Utils.a().getString(R$string.ugc_tab_movie), Utils.a().getString(R$string.ugc_tab_tv), Utils.a().getString(R$string.ugc_tab_music), Utils.a().getString(R$string.ugc_tab_education), Utils.a().getString(R$string.ugc_tab_short_tv), Utils.a().getString(R$string.ugc_tab_sport), Utils.a().getString(R$string.ugc_tab_kids), Utils.a().getString(R$string.ugc_tab_post), Utils.a().getString(R$string.ugc_tab_room), Utils.a().getString(R$string.ugc_tab_recreation), Utils.a().getString(R$string.ugc_tab_live), Utils.a().getString(R$string.ugc_tab_novel), Utils.a().getString(R$string.ugc_tab_video));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 v0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 w0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 x0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 y0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 z0() {
        return new androidx.view.b0();
    }

    public final void H() {
        N(this, false, 1, null);
        P();
    }

    public final androidx.view.b0 I() {
        return this.f60182s;
    }

    public final androidx.view.b0 J() {
        return (androidx.view.b0) this.f60171h.getValue();
    }

    public final androidx.view.b0 K() {
        return (androidx.view.b0) this.f60168e.getValue();
    }

    public final androidx.view.b0 L() {
        return this.f60180q;
    }

    public final void M(boolean z10) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new DownloadViewModel$getDownloadedList$1(z10, this, null), 2, null);
    }

    public final androidx.view.b0 O() {
        return this.f60179p;
    }

    public final void P() {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new DownloadViewModel$getDownloadingList$1(this, null), 2, null);
    }

    public final androidx.view.b0 Q() {
        return this.f60178o;
    }

    public final androidx.view.b0 R() {
        return (androidx.view.b0) this.f60170g.getValue();
    }

    public final void S(int i11, int i12) {
        if (this.f60167d) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new DownloadViewModel$getMovieRec$1(this, i11, i12, null), 2, null);
    }

    public final androidx.view.b0 T() {
        return (androidx.view.b0) this.f60166c.getValue();
    }

    public final void U(String str) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new DownloadViewModel$getSeriesList$1(str, this, null), 2, null);
    }

    public final androidx.view.b0 V() {
        return this.f60181r;
    }

    public final androidx.view.b0 a0() {
        return (androidx.view.b0) this.f60175l.getValue();
    }

    public final androidx.view.b0 b0() {
        return (androidx.view.b0) this.f60183t.getValue();
    }

    public final androidx.view.b0 c0() {
        return (androidx.view.b0) this.f60184u.getValue();
    }

    public final androidx.view.b0 d0() {
        return (androidx.view.b0) this.f60186w.getValue();
    }

    public final androidx.view.b0 e0() {
        return (androidx.view.b0) this.f60176m.getValue();
    }

    public final androidx.view.b0 f0(int i11) {
        if (this.f60177n.containsKey(Integer.valueOf(i11))) {
            return (androidx.view.b0) this.f60177n.get(Integer.valueOf(i11));
        }
        androidx.view.b0 b0Var = new androidx.view.b0();
        this.f60177n.put(Integer.valueOf(i11), b0Var);
        return b0Var;
    }

    public final Map g0() {
        return this.f60177n;
    }

    public final androidx.view.b0 h0() {
        return (androidx.view.b0) this.f60174k.getValue();
    }

    public final androidx.view.b0 i0() {
        return (androidx.view.b0) this.f60185v.getValue();
    }

    public final androidx.view.b0 j0() {
        return (androidx.view.b0) this.f60172i.getValue();
    }

    public final androidx.view.b0 k0() {
        return (androidx.view.b0) this.f60173j.getValue();
    }

    public final androidx.view.b0 l0() {
        return (androidx.view.b0) this.f60169f.getValue();
    }

    public final void m0(String str) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new DownloadViewModel$getUGCCollectionList$1(str, this, null), 2, null);
    }

    public final void n0(String str) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new DownloadViewModel$getUGCSubjectList$1(str, this, null), 2, null);
    }

    public final void r0(FileData data, Function0 callback) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callback, "callback");
        lg.a.f68962a.p(TransferBottomToolsView.TAG, new String[]{"传输完成，保存到数据库, data:" + data}, true);
        if (data.getDownloadBean() != null) {
            DownloadBean downloadBean = data.getDownloadBean();
            Intrinsics.e(downloadBean);
            downloadBean.setFileType(3);
            downloadBean.setCreateAt(System.currentTimeMillis());
            downloadBean.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
            downloadBean.setCover(data.getCoverFile().getAbsolutePath());
            downloadBean.setPath(data.getFileReceiveCachePath());
            downloadBean.setProgress(0L);
            downloadBean.setStatus(5);
            downloadBean.setSubjectType(SubjectType.OUTSIDE_FILE.getValue());
            kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new DownloadViewModel$saveTransferData2DB$1$1(downloadBean, callback, null), 2, null);
            return;
        }
        String absolutePath = data.getCoverFile().getAbsolutePath();
        String fileReceiveCachePath = data.getFileReceiveCachePath();
        String valueOf = String.valueOf(data.getFileReceiveCachePath().hashCode());
        String fileName = data.getFileName();
        long fileSize = data.getFileSize();
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new DownloadViewModel$saveTransferData2DB$2$1(new DownloadBean(fileReceiveCachePath, valueOf, fileName, absolutePath, Long.valueOf(fileSize), null, null, data.getFileReceiveCachePath(), null, Long.valueOf(System.currentTimeMillis()), data.getFileSize(), 0, 5, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 3, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, SubjectType.OUTSIDE_FILE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -5792, -65538, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null), callback, null), 2, null);
    }
}
