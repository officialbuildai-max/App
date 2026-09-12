package com.transsnet.downloader.proxy;

import android.app.Application;
import androidx.collection.s;
import com.blankj.utilcode.util.Utils;
import com.danikula.videocache.m;
import com.danikula.videocache.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.core.task.DownloadTaskUtil;
import com.transsnet.downloader.util.DownloadUtil;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import lj.n0;
import ny.d;

/* loaded from: classes.dex */
public final class DownloadFileCache implements com.danikula.videocache.a {

    /* renamed from: d, reason: collision with root package name */
    private RandomAccessFile f59695d;

    /* renamed from: e, reason: collision with root package name */
    private DownloadBean f59696e;

    /* renamed from: f, reason: collision with root package name */
    private String f59697f;

    /* renamed from: g, reason: collision with root package name */
    private c f59698g;

    /* renamed from: i, reason: collision with root package name */
    private DownloadRange f59700i;

    /* renamed from: j, reason: collision with root package name */
    private int f59701j;

    /* renamed from: l, reason: collision with root package name */
    private long f59703l;

    /* renamed from: m, reason: collision with root package name */
    private m f59704m;

    /* renamed from: a, reason: collision with root package name */
    private final long f59692a = 3145728;

    /* renamed from: b, reason: collision with root package name */
    private long f59693b = 3145728;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f59694c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.proxy.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            n0 m11;
            m11 = DownloadFileCache.m();
            return m11;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap f59699h = new ConcurrentHashMap();

    /* renamed from: k, reason: collision with root package name */
    private String f59702k = "";

    /* renamed from: n, reason: collision with root package name */
    private boolean f59705n = true;

    /* renamed from: o, reason: collision with root package name */
    private final d f59706o = new a();

    /* loaded from: classes7.dex */
    public static final class a extends d {
        a() {
        }

        @Override // ny.d
        public void h(DownloadBean bean, int i11) {
            m mVar;
            m mVar2;
            Intrinsics.h(bean, "bean");
            if (DownloadFileCache.this.f59700i == null || (mVar = DownloadFileCache.this.f59704m) == null || !mVar.b()) {
                return;
            }
            long j11 = DownloadFileCache.this.f59703l + 8192;
            DownloadRange downloadRange = DownloadFileCache.this.f59700i;
            Intrinsics.e(downloadRange);
            if (j11 > downloadRange.totalProgress() || (mVar2 = DownloadFileCache.this.f59704m) == null) {
                return;
            }
            mVar2.c();
        }
    }

    private final void g(long j11) {
        DownloadRange downloadRange;
        DownloadRange downloadRange2 = this.f59700i;
        if (downloadRange2 != null) {
            Intrinsics.e(downloadRange2);
            if (downloadRange2.contains(j11)) {
                return;
            }
        }
        q.a("checkDownloadNewV2Ranges = " + (this.f59696e == null));
        DownloadBean downloadBean = this.f59696e;
        if (downloadBean != null) {
            DownloadRange downloadRange3 = this.f59700i;
            Iterator<DownloadRange> it = downloadBean.getDownloadRanges().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadRange next = it.next();
                if (next.contains(j11)) {
                    this.f59701j = next.getThreadIndex();
                    this.f59700i = next;
                    break;
                }
            }
            a.C0856a c0856a = lg.a.f68962a;
            int i11 = this.f59701j;
            DownloadRange downloadRange4 = this.f59700i;
            Boolean valueOf = downloadRange4 != null ? Boolean.valueOf(downloadRange4.getIsDownloading()) : null;
            DownloadRange downloadRange5 = this.f59700i;
            Boolean valueOf2 = downloadRange5 != null ? Boolean.valueOf(downloadRange5.isRangeDownloadSuccess()) : null;
            DownloadRange downloadRange6 = this.f59700i;
            String valueOf3 = downloadRange6 != null ? Integer.valueOf(downloadRange6.getRangeId()) : "range is null";
            DownloadRange downloadRange7 = this.f59700i;
            Long valueOf4 = downloadRange7 != null ? Long.valueOf(downloadRange7.getStart()) : null;
            DownloadRange downloadRange8 = this.f59700i;
            Long valueOf5 = downloadRange8 != null ? Long.valueOf(downloadRange8.getEnd()) : null;
            DownloadRange downloadRange9 = this.f59700i;
            Long valueOf6 = downloadRange9 != null ? Long.valueOf(downloadRange9.getProgress()) : null;
            c0856a.c("download", StringsKt.n("download&play checkDownloadNewV2Ranges, offset=" + j11 + ",index = " + i11 + " \n                  currentRange, isDownloading: " + valueOf + ", downloadSuccess: " + valueOf2 + "\n                  rangeId: " + valueOf3 + ", start: " + valueOf4 + ", end: " + valueOf5 + ",progress: " + valueOf6 + "\n                  resourceId:" + downloadBean.getResourceId() + ",name:" + downloadBean.getName() + "\n                "), true);
            DownloadRange downloadRange10 = this.f59700i;
            if (downloadRange10 != null) {
                Intrinsics.e(downloadRange10);
                if (downloadRange10.getIsDownloading()) {
                    return;
                }
                DownloadRange downloadRange11 = this.f59700i;
                Intrinsics.e(downloadRange11);
                if (downloadRange11.isRangeDownloadSuccess() || !nh.m.f70597a.e()) {
                    return;
                }
                c cVar = this.f59698g;
                if (cVar != null) {
                    String resourceId = downloadBean.getResourceId();
                    int i12 = this.f59701j;
                    DownloadRange downloadRange12 = this.f59700i;
                    Intrinsics.e(downloadRange12);
                    downloadRange = downloadRange3;
                    cVar.a(resourceId, i12, downloadRange, downloadRange12);
                } else {
                    downloadRange = downloadRange3;
                }
                for (Map.Entry entry : this.f59699h.entrySet()) {
                    Object key = entry.getKey();
                    String resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    if (Intrinsics.c(key, resourceId2)) {
                        c cVar2 = (c) entry.getValue();
                        String resourceId3 = downloadBean.getResourceId();
                        int i13 = this.f59701j;
                        DownloadRange downloadRange13 = this.f59700i;
                        Intrinsics.e(downloadRange13);
                        cVar2.a(resourceId3, i13, downloadRange, downloadRange13);
                    }
                }
            }
        }
    }

    private final void h(String str, long j11) {
        Object obj;
        List<DownloadRange> downloadRanges;
        String url;
        DownloadBean downloadBean = this.f59696e;
        List<DownloadRange> downloadRanges2 = downloadBean != null ? downloadBean.getDownloadRanges() : null;
        if (downloadRanges2 == null || downloadRanges2.isEmpty()) {
            return;
        }
        DownloadBean downloadBean2 = this.f59696e;
        Intrinsics.e(downloadBean2);
        for (DownloadRange downloadRange : downloadBean2.getDownloadRanges()) {
            if (downloadRange.contains(j11)) {
                DownloadRange downloadRange2 = this.f59700i;
                long start = downloadRange.getStart();
                if (j11 <= downloadRange.totalProgress() && start <= j11) {
                    this.f59700i = downloadRange;
                    r(str + "_range1", str + " 暂停当前线程，启动新线程下载, 已经下载，直接返回, offset = " + j11 + ", rangeId = " + downloadRange.getRangeId());
                } else if (j11 < downloadRange.getStart() + downloadRange.getProgress() + this.f59693b) {
                    this.f59700i = downloadRange;
                    r(str + "_range2", str + " 暂停当前线程，启动新线程下载, 小于阈值，等待下载,只的启动线程，不处理range, offset = " + j11);
                } else {
                    if (downloadRange.getEnd() - j11 < this.f59693b) {
                        r(str + "_range3", str + " 暂停当前线程，启动新线程下载, 新增分片小于阈值，使用阈值大小, offset = " + j11);
                        j11 = downloadRange.getEnd() - this.f59693b;
                    } else {
                        r(str + "_range4", str + " 暂停当前线程，启动新线程下载, 新增分片大于阈值, offset = " + j11);
                    }
                    if (nh.m.f70597a.e()) {
                        DownloadRange downloadRange3 = new DownloadRange();
                        DownloadBean downloadBean3 = this.f59696e;
                        if (downloadBean3 == null || (obj = downloadBean3.getResourceId()) == null) {
                            obj = 0;
                        }
                        downloadRange3.setThreadId(obj.hashCode());
                        downloadRange3.setRangeId(s.a(downloadRange.getEnd() + j11));
                        downloadRange3.setResourceId(downloadRange.getResourceId());
                        downloadRange3.setStart(j11);
                        downloadRange3.setEnd(downloadRange.getEnd());
                        downloadRange3.setProgress(0L);
                        downloadRange.setEnd(downloadRange3.getStart() - 1);
                        DownloadBean downloadBean4 = this.f59696e;
                        if (downloadBean4 != null && (downloadRanges = downloadBean4.getDownloadRanges()) != null) {
                            downloadRanges.add(downloadRange3);
                        }
                        this.f59700i = downloadRange3;
                        DownloadBean downloadBean5 = this.f59696e;
                        s(downloadBean5 != null ? downloadBean5.getDownloadRanges() : null);
                    }
                }
                DownloadRange downloadRange4 = this.f59700i;
                if (downloadRange4 != null) {
                    Intrinsics.e(downloadRange4);
                    if (downloadRange4.isRangeDownloadSuccess()) {
                        return;
                    }
                    DownloadRange downloadRange5 = this.f59700i;
                    Intrinsics.e(downloadRange5);
                    if (downloadRange5.getIsDownloading() || !nh.m.f70597a.e()) {
                        return;
                    }
                    c cVar = this.f59698g;
                    if (cVar != null) {
                        DownloadBean downloadBean6 = this.f59696e;
                        String resourceId = downloadBean6 != null ? downloadBean6.getResourceId() : null;
                        int i11 = this.f59701j;
                        DownloadRange downloadRange6 = this.f59700i;
                        Intrinsics.e(downloadRange6);
                        cVar.a(resourceId, i11, downloadRange2, downloadRange6);
                    }
                    for (Map.Entry entry : this.f59699h.entrySet()) {
                        Object key = entry.getKey();
                        DownloadBean downloadBean7 = this.f59696e;
                        if (downloadBean7 == null || (url = downloadBean7.getResourceId()) == null) {
                            DownloadBean downloadBean8 = this.f59696e;
                            url = downloadBean8 != null ? downloadBean8.getUrl() : null;
                        }
                        if (Intrinsics.c(key, url)) {
                            c cVar2 = (c) entry.getValue();
                            DownloadBean downloadBean9 = this.f59696e;
                            String resourceId2 = downloadBean9 != null ? downloadBean9.getResourceId() : null;
                            int i12 = this.f59701j;
                            DownloadRange downloadRange7 = this.f59700i;
                            Intrinsics.e(downloadRange7);
                            cVar2.a(resourceId2, i12, downloadRange2, downloadRange7);
                        }
                    }
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n0 k() {
        return (n0) this.f59694c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 m() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).q1();
    }

    private final void r(String str, String str2) {
        if (Intrinsics.c(this.f59702k, str)) {
            return;
        }
        this.f59702k = str;
        q.a("================range,  " + str2);
    }

    private final void s(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (arrayList.size() > 1) {
            CollectionsKt.A(arrayList, new Comparator() { // from class: com.transsnet.downloader.proxy.DownloadFileCache$updateDBRanges$lambda$6$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return ComparisonsKt.d(Long.valueOf(((DownloadRange) t11).getStart()), Long.valueOf(((DownloadRange) t12).getStart()));
                }
            });
        }
        list.clear();
        list.addAll(arrayList);
        k.d(o0.a(y0.b()), null, null, new DownloadFileCache$updateDBRanges$1(list, this, null), 3, null);
    }

    @Override // com.danikula.videocache.a
    public long A() {
        Long size;
        DownloadBean downloadBean = this.f59696e;
        if (downloadBean == null || (size = downloadBean.getSize()) == null) {
            return 0L;
        }
        return size.longValue();
    }

    @Override // com.danikula.videocache.a
    public void B() {
        try {
            DownloadBean downloadBean = this.f59696e;
            String path = downloadBean != null ? downloadBean.getPath() : null;
            if (path != null && path.length() != 0) {
                q.b("1-path create");
                DownloadBean downloadBean2 = this.f59696e;
                this.f59695d = new RandomAccessFile(downloadBean2 != null ? downloadBean2.getPath() : null, CampaignEx.JSON_KEY_AD_R);
                return;
            }
            q.b("path is null, is not downloading");
        } catch (Throwable th2) {
            DownloadBean downloadBean3 = this.f59696e;
            q.b("1--path = " + (downloadBean3 != null ? downloadBean3.getPath() : null) + ",error = " + th2);
            try {
                q.b("2-path create");
                DownloadBean downloadBean4 = this.f59696e;
                this.f59695d = new RandomAccessFile(downloadBean4 != null ? downloadBean4.getPath() : null, "rwd");
            } catch (Throwable th3) {
                DownloadBean downloadBean5 = this.f59696e;
                q.b("2--path = " + (downloadBean5 != null ? downloadBean5.getPath() : null) + ",error = " + th3);
            }
        }
    }

    @Override // com.danikula.videocache.a
    public void C(long j11) {
        Object obj;
        String url;
        List<DownloadRange> downloadRanges;
        if (DownloadTaskUtil.f58752a.j()) {
            g(j11);
            return;
        }
        DownloadRange downloadRange = this.f59700i;
        if (downloadRange == null) {
            a.C0856a c0856a = lg.a.f68962a;
            DownloadBean downloadBean = this.f59696e;
            String resourceId = downloadBean != null ? downloadBean.getResourceId() : null;
            DownloadBean downloadBean2 = this.f59696e;
            c0856a.i("download", "download&play currentRangeNull currentRange is null, offset = " + j11 + ",resourceId=" + resourceId + ",,name=" + (downloadBean2 != null ? downloadBean2.getName() : null), true);
            return;
        }
        Intrinsics.e(downloadRange);
        long start = downloadRange.getStart();
        DownloadRange downloadRange2 = this.f59700i;
        Intrinsics.e(downloadRange2);
        if (j11 <= downloadRange2.totalProgress() && start <= j11) {
            r("currentRange1", "当前分片已下载进度内，不做任何处理，直接返回, offset = " + j11);
            return;
        }
        DownloadRange downloadRange3 = this.f59700i;
        Intrinsics.e(downloadRange3);
        if (j11 < downloadRange3.getStart()) {
            h("beforeRange", j11);
            return;
        }
        DownloadRange downloadRange4 = this.f59700i;
        Intrinsics.e(downloadRange4);
        if (j11 >= downloadRange4.getEnd()) {
            h("afterRange", j11);
            return;
        }
        DownloadRange downloadRange5 = this.f59700i;
        Intrinsics.e(downloadRange5);
        long start2 = downloadRange5.getStart();
        DownloadRange downloadRange6 = this.f59700i;
        Intrinsics.e(downloadRange6);
        if (j11 < start2 + downloadRange6.getProgress() + this.f59693b) {
            r("currentRange21", "当前分片内，快进小于阈值，等待下载, offset = " + j11);
            return;
        }
        DownloadRange downloadRange7 = this.f59700i;
        Intrinsics.e(downloadRange7);
        if (downloadRange7.getEnd() - j11 < this.f59693b) {
            r("currentRange22", "当前分片内，（暂停当前线程，启动新线程下载）快进 新增分片小于阈值，使用阈值大小, offset = " + j11);
            DownloadRange downloadRange8 = this.f59700i;
            Intrinsics.e(downloadRange8);
            j11 = downloadRange8.getEnd() - this.f59693b;
        } else {
            r("currentRange23", "当前分片内，（暂停当前线程，启动新线程下载）快进 新增分片大于阈值, offset = " + j11);
        }
        if (nh.m.f70597a.e()) {
            DownloadRange downloadRange9 = new DownloadRange();
            DownloadBean downloadBean3 = this.f59696e;
            if (downloadBean3 == null || (obj = downloadBean3.getResourceId()) == null) {
                obj = 0;
            }
            downloadRange9.setThreadId(obj.hashCode());
            DownloadRange downloadRange10 = this.f59700i;
            Intrinsics.e(downloadRange10);
            downloadRange9.setRangeId(s.a(downloadRange10.getEnd() + j11));
            DownloadRange downloadRange11 = this.f59700i;
            Intrinsics.e(downloadRange11);
            downloadRange9.setResourceId(downloadRange11.getResourceId());
            downloadRange9.setStart(j11);
            DownloadRange downloadRange12 = this.f59700i;
            Intrinsics.e(downloadRange12);
            downloadRange9.setEnd(downloadRange12.getEnd());
            downloadRange9.setProgress(0L);
            DownloadRange downloadRange13 = this.f59700i;
            Intrinsics.e(downloadRange13);
            downloadRange13.setEnd(downloadRange9.getStart() - 1);
            DownloadBean downloadBean4 = this.f59696e;
            if (downloadBean4 != null && (downloadRanges = downloadBean4.getDownloadRanges()) != null) {
                downloadRanges.add(downloadRange9);
            }
            DownloadRange downloadRange14 = this.f59700i;
            this.f59700i = downloadRange9;
            DownloadBean downloadBean5 = this.f59696e;
            s(downloadBean5 != null ? downloadBean5.getDownloadRanges() : null);
            c cVar = this.f59698g;
            if (cVar != null) {
                DownloadBean downloadBean6 = this.f59696e;
                cVar.a(downloadBean6 != null ? downloadBean6.getResourceId() : null, this.f59701j, downloadRange14, downloadRange9);
            }
            for (Map.Entry entry : this.f59699h.entrySet()) {
                Object key = entry.getKey();
                DownloadBean downloadBean7 = this.f59696e;
                if (downloadBean7 == null || (url = downloadBean7.getResourceId()) == null) {
                    DownloadBean downloadBean8 = this.f59696e;
                    url = downloadBean8 != null ? downloadBean8.getUrl() : null;
                }
                if (Intrinsics.c(key, url)) {
                    c cVar2 = (c) entry.getValue();
                    DownloadBean downloadBean9 = this.f59696e;
                    cVar2.a(downloadBean9 != null ? downloadBean9.getResourceId() : null, this.f59701j, downloadRange14, downloadRange9);
                }
            }
        }
    }

    @Override // com.danikula.videocache.a
    public int D(byte[] buffer, long j11, int i11, String url) {
        RandomAccessFile randomAccessFile;
        Intrinsics.h(buffer, "buffer");
        Intrinsics.h(url, "url");
        if (this.f59695d == null) {
            B();
        }
        RandomAccessFile randomAccessFile2 = this.f59695d;
        if ((randomAccessFile2 != null ? randomAccessFile2.length() : 0L) == 0) {
            DownloadRange downloadRange = this.f59700i;
            if ((downloadRange != null ? downloadRange.getProgress() : 0L) > 0) {
                q.f("read error, create new data file");
                B();
            }
        }
        RandomAccessFile randomAccessFile3 = this.f59695d;
        if (randomAccessFile3 != null) {
            randomAccessFile3.seek(j11);
        }
        DownloadRange downloadRange2 = this.f59700i;
        Intrinsics.e(downloadRange2);
        int read = (j11 <= downloadRange2.totalProgress() && (randomAccessFile = this.f59695d) != null) ? randomAccessFile.read(buffer, 0, i11) : -1;
        if (read == -1) {
            RandomAccessFile randomAccessFile4 = this.f59695d;
            Long valueOf = randomAccessFile4 != null ? Long.valueOf(randomAccessFile4.length()) : null;
            DownloadRange downloadRange3 = this.f59700i;
            Integer valueOf2 = downloadRange3 != null ? Integer.valueOf(downloadRange3.getRangeId()) : null;
            DownloadRange downloadRange4 = this.f59700i;
            Long valueOf3 = downloadRange4 != null ? Long.valueOf(downloadRange4.getStart()) : null;
            DownloadRange downloadRange5 = this.f59700i;
            Long valueOf4 = downloadRange5 != null ? Long.valueOf(downloadRange5.getEnd()) : null;
            DownloadRange downloadRange6 = this.f59700i;
            q.b("read -1, dataFile created & length= " + valueOf + ", rangeId = " + valueOf2 + ", offset = " + j11 + " , start =  " + valueOf3 + ",end =  " + valueOf4 + ", totalProgress = " + (downloadRange6 != null ? Long.valueOf(downloadRange6.totalProgress()) : null));
        }
        return read;
    }

    @Override // com.danikula.videocache.a
    public void E(long j11) {
        if (DownloadTaskUtil.f58752a.j()) {
            return;
        }
        DownloadRange downloadRange = this.f59700i;
        if (downloadRange != null) {
            Intrinsics.e(downloadRange);
            long start = downloadRange.getStart();
            DownloadRange downloadRange2 = this.f59700i;
            Intrinsics.e(downloadRange2);
            if (j11 <= downloadRange2.getEnd() && start <= j11) {
                return;
            }
        }
        q.a("check  downloadBean = " + (this.f59696e == null));
        DownloadBean downloadBean = this.f59696e;
        if (downloadBean != null) {
            Iterator<DownloadRange> it = downloadBean.getDownloadRanges().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadRange next = it.next();
                if (next.contains(j11)) {
                    this.f59701j = next.getThreadIndex();
                    this.f59700i = next;
                    break;
                }
            }
            a.C0856a c0856a = lg.a.f68962a;
            int i11 = this.f59701j;
            DownloadRange downloadRange3 = this.f59700i;
            String valueOf = downloadRange3 != null ? Integer.valueOf(downloadRange3.getRangeId()) : "range is null";
            DownloadRange downloadRange4 = this.f59700i;
            Long valueOf2 = downloadRange4 != null ? Long.valueOf(downloadRange4.getStart()) : null;
            DownloadRange downloadRange5 = this.f59700i;
            Long valueOf3 = downloadRange5 != null ? Long.valueOf(downloadRange5.getEnd()) : null;
            DownloadRange downloadRange6 = this.f59700i;
            Long valueOf4 = downloadRange6 != null ? Long.valueOf(downloadRange6.getProgress()) : null;
            DownloadBean downloadBean2 = this.f59696e;
            String resourceId = downloadBean2 != null ? downloadBean2.getResourceId() : null;
            DownloadBean downloadBean3 = this.f59696e;
            c0856a.c("download", StringsKt.n("download&play set new download thread, offset=" + j11 + ",index = " + i11 + " \n                           currentRange.rangeId = " + valueOf + ", start = " + valueOf2 + ", end = " + valueOf3 + ",\n                           progress = " + valueOf4 + ",resourceId=" + resourceId + ",name=" + (downloadBean3 != null ? downloadBean3.getName() : null) + "\n                    "), true);
        }
    }

    @Override // com.danikula.videocache.a
    public void F(m proxyCache) {
        Intrinsics.h(proxyCache, "proxyCache");
        this.f59704m = proxyCache;
    }

    @Override // com.danikula.videocache.a
    public long G() {
        DownloadRange downloadRange = this.f59700i;
        return downloadRange != null ? downloadRange.getEnd() : A();
    }

    @Override // com.danikula.videocache.a
    public boolean H(long j11, int i11, String url) {
        Intrinsics.h(url, "url");
        this.f59703l = j11;
        DownloadBean downloadBean = this.f59696e;
        if (downloadBean != null) {
            downloadBean.setCurrentOffset(j11);
        }
        if (this.f59700i == null) {
            return false;
        }
        RandomAccessFile randomAccessFile = this.f59695d;
        if ((randomAccessFile != null ? randomAccessFile.length() : 0L) < j11) {
            return false;
        }
        DownloadRange downloadRange = this.f59700i;
        Intrinsics.e(downloadRange);
        if (downloadRange.isRangeDownloadSuccess()) {
            return true;
        }
        long j12 = j11 + i11;
        DownloadRange downloadRange2 = this.f59700i;
        Intrinsics.e(downloadRange2);
        return j12 <= downloadRange2.totalProgress();
    }

    @Override // com.danikula.videocache.a
    public void close() {
        try {
            RandomAccessFile randomAccessFile = this.f59695d;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f59702k = "";
        } catch (Throwable unused) {
        }
    }

    public final void f(String resourceId, c callback) {
        Intrinsics.h(resourceId, "resourceId");
        Intrinsics.h(callback, "callback");
        this.f59699h.put(resourceId, callback);
    }

    public final DownloadBean i() {
        return this.f59696e;
    }

    @Override // com.danikula.videocache.a
    public boolean isCompleted() {
        DownloadBean downloadBean = this.f59696e;
        return downloadBean != null && downloadBean.getStatus() == 5;
    }

    public final d j() {
        return this.f59706o;
    }

    public final boolean l() {
        return this.f59705n;
    }

    public final void n(String resourceId) {
        Intrinsics.h(resourceId, "resourceId");
        this.f59699h.remove(resourceId);
    }

    public final void o() {
        this.f59700i = null;
        this.f59701j = 0;
        this.f59702k = "";
        close();
        this.f59695d = null;
        this.f59704m = null;
        this.f59705n = true;
    }

    public final void p(String str) {
        this.f59697f = str;
    }

    public final void q(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadBean");
        this.f59705n = false;
        q.e("set new video =  " + downloadBean.getName());
        this.f59696e = downloadBean;
        Long size = downloadBean.getSize();
        long longValue = size != null ? size.longValue() / 120 : this.f59692a;
        long j11 = this.f59692a;
        if (longValue > j11) {
            longValue = j11;
        }
        this.f59693b = longValue;
        DownloadUtil.f60023a.B(downloadBean);
    }

    @Override // com.danikula.videocache.a
    public String z() {
        String str = this.f59697f;
        if (str != null) {
            return str;
        }
        DownloadBean downloadBean = this.f59696e;
        return (downloadBean == null || downloadBean.getType() != 1) ? MimeTypes.VIDEO_MP4 : MimeTypes.AUDIO_MPEG;
    }
}
