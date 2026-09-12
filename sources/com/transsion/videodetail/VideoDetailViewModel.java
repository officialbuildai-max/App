package com.transsion.videodetail;

import android.app.Application;
import androidx.view.LiveData;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.videodetail.bean.VideoDetailStream;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import lg.a;

/* loaded from: classes7.dex */
public final class VideoDetailViewModel extends androidx.view.t0 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.view.b0 f57763a = new androidx.view.b0();

    /* renamed from: b, reason: collision with root package name */
    private final androidx.view.b0 f57764b = new androidx.view.b0();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f57765c = new androidx.view.b0();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.view.b0 f57766d = new androidx.view.b0();

    /* renamed from: e, reason: collision with root package name */
    private final androidx.view.b0 f57767e = new androidx.view.b0();

    /* renamed from: f, reason: collision with root package name */
    private final androidx.view.b0 f57768f = new androidx.view.b0();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap f57769g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final androidx.view.b0 f57770h = new androidx.view.b0();

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f57771i = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.b1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoDetailPlayDao F;
            F = VideoDetailViewModel.F();
            return F;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f57772j = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.c1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b E;
            E = VideoDetailViewModel.E();
            return E;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    private String f57773k;

    /* renamed from: l, reason: collision with root package name */
    private t1 f57774l;

    /* JADX INFO: Access modifiers changed from: private */
    public final b A() {
        return (b) this.f57772j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao B() {
        return (VideoDetailPlayDao) this.f57771i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b E() {
        return (b) zg.c.f79537e.a().h(b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao F() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o(Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        if (1 > intValue || intValue >= 10) {
            return String.valueOf(intValue);
        }
        return "0" + intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String str, List list) {
        kotlinx.coroutines.k.d(androidx.view.u0.a(this), null, null, new VideoDetailViewModel$fetchEpisodeMediaList$1(this, list, str, null), 3, null);
    }

    public final void C(VideoDetailMediaSource videoDetailMediaSource) {
        if (Intrinsics.c(videoDetailMediaSource, this.f57768f.f())) {
            return;
        }
        this.f57768f.q(videoDetailMediaSource);
    }

    public final void D() {
        this.f57764b.q(null);
        this.f57765c.q(null);
        this.f57766d.q(new ArrayList());
        this.f57767e.q(new LinkedHashMap());
        this.f57768f.q(null);
    }

    public final void n() {
        this.f57770h.q(null);
    }

    public final void q(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        kotlinx.coroutines.k.d(androidx.view.u0.a(this), null, null, new VideoDetailViewModel$fetchHistory$1(this, subjectId, null), 3, null);
    }

    public final void r(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        if (this.f57764b.f() == null) {
            kotlinx.coroutines.k.d(androidx.view.u0.a(this), null, null, new VideoDetailViewModel$fetchSeason$1(subjectId, this, null), 3, null);
        }
    }

    public final LiveData s() {
        return this.f57766d;
    }

    public final LiveData t() {
        return this.f57767e;
    }

    public final LiveData u() {
        return this.f57770h;
    }

    public final void v(VideoDetailMediaSource videoDetailMediaSource) {
        t1 d11;
        String l11;
        String l12;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.v(c0856a, "VideoDetailEpisode", "--------getPlayInfo:" + videoDetailMediaSource, false, 4, null);
        if (videoDetailMediaSource == null) {
            return;
        }
        String subjectId = videoDetailMediaSource.getSubjectId();
        int se2 = videoDetailMediaSource.getSe();
        int ep2 = videoDetailMediaSource.getEp();
        String str = subjectId + "-" + se2 + "-" + ep2;
        t1 t1Var = this.f57774l;
        if (t1Var != null && t1Var.isActive()) {
            if (Intrinsics.c(this.f57773k, str)) {
                a.C0856a.f(c0856a, "CommonInfo", "正在请求中 key：" + str, false, 4, null);
                return;
            }
            t1 t1Var2 = this.f57774l;
            if (t1Var2 != null) {
                t1.a.b(t1Var2, null, 1, null);
            }
        }
        VideoDetailStreamList videoDetailStreamList = (VideoDetailStreamList) this.f57769g.get(str);
        if (videoDetailStreamList != null) {
            this.f57765c.q(videoDetailStreamList);
            return;
        }
        DownloadBean downloadBean = videoDetailMediaSource.getDownloadBean();
        if (downloadBean == null) {
            this.f57773k = str;
            d11 = kotlinx.coroutines.k.d(androidx.view.u0.a(this), null, null, new VideoDetailViewModel$getPlayInfo$2(this, subjectId, se2, ep2, videoDetailMediaSource, str, null), 3, null);
            this.f57774l = d11;
            return;
        }
        String resourceId = downloadBean.getResourceId();
        String str2 = resourceId == null ? "" : resourceId;
        String path = downloadBean.getPath();
        String str3 = path == null ? "" : path;
        String valueOf = String.valueOf(downloadBean.getResolution());
        Long size = downloadBean.getSize();
        String str4 = (size == null || (l12 = size.toString()) == null) ? "0" : l12;
        Long duration = downloadBean.getDuration();
        String str5 = (duration == null || (l11 = duration.toString()) == null) ? "0" : l11;
        List emptyList = Collections.emptyList();
        Intrinsics.g(emptyList, "emptyList(...)");
        VideoDetailStream videoDetailStream = new VideoDetailStream("DEFAULT", str2, str3, valueOf, str4, str5, "", emptyList);
        androidx.view.b0 b0Var = this.f57765c;
        VideoDetailStreamList videoDetailStreamList2 = new VideoDetailStreamList(CollectionsKt.h(videoDetailStream), 0, 0, null, 14, null);
        videoDetailStreamList2.setEp(ep2);
        videoDetailStreamList2.setSe(se2);
        b0Var.q(videoDetailStreamList2);
    }

    public final LiveData w() {
        return this.f57765c;
    }

    public final LiveData x() {
        return this.f57768f;
    }

    public final androidx.view.b0 y() {
        return this.f57763a;
    }

    public final LiveData z() {
        return this.f57764b;
    }
}
