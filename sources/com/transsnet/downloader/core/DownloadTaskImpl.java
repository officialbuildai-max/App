package com.transsnet.downloader.core;

import android.app.Application;
import androidx.collection.s;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.core.DownloadTaskImpl;
import com.transsnet.downloader.core.task.DownloadFileInfoTask;
import com.transsnet.downloader.core.thread.DownloadExecutor;
import com.transsnet.downloader.core.thread.DownloadRunnable;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import lj.n0;
import nh.m;

/* loaded from: classes7.dex */
public final class DownloadTaskImpl implements com.transsnet.downloader.core.task.b, com.transsnet.downloader.core.thread.d {

    /* renamed from: a, reason: collision with root package name */
    private final c f58700a;

    /* renamed from: b, reason: collision with root package name */
    private final com.transsnet.downloader.proxy.b f58701b;

    /* renamed from: c, reason: collision with root package name */
    private final DownloadBean f58702c;

    /* renamed from: d, reason: collision with root package name */
    private final oy.c f58703d;

    /* renamed from: e, reason: collision with root package name */
    private final List f58704e;

    /* renamed from: f, reason: collision with root package name */
    private final com.transsnet.downloader.core.task.c f58705f;

    /* renamed from: g, reason: collision with root package name */
    private long f58706g;

    /* renamed from: h, reason: collision with root package name */
    private n0 f58707h;

    /* renamed from: i, reason: collision with root package name */
    private final com.transsnet.downloader.proxy.c f58708i;

    /* renamed from: j, reason: collision with root package name */
    private AtomicInteger f58709j;

    /* renamed from: k, reason: collision with root package name */
    private kotlinx.coroutines.n0 f58710k;

    /* renamed from: l, reason: collision with root package name */
    private final String f58711l;

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f58712m;

    /* renamed from: n, reason: collision with root package name */
    private final AtomicInteger f58713n;

    /* loaded from: classes7.dex */
    public static final class a implements com.transsnet.downloader.proxy.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadBean f58714a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DownloadTaskImpl f58715b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ oy.c f58716c;

        a(DownloadBean downloadBean, DownloadTaskImpl downloadTaskImpl, oy.c cVar) {
            this.f58714a = downloadBean;
            this.f58715b = downloadTaskImpl;
            this.f58716c = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(com.transsnet.downloader.core.thread.f fVar, DownloadTaskImpl downloadTaskImpl, DownloadRange downloadRange, int i11, oy.c cVar, DownloadBean downloadBean, DownloadRange downloadRange2) {
            fVar.removeBreakCallback();
            ((ArrayList) downloadTaskImpl.f58704e).remove(fVar);
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.v(c0856a, "DownloadThread", "beak success, start new thread", false, 4, null);
            downloadRange.setDownloading(true);
            DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, downloadTaskImpl.f58701b, i11, downloadTaskImpl.f58700a, cVar, downloadBean, downloadTaskImpl);
            ((ArrayList) downloadTaskImpl.f58704e).add(downloadRunnable);
            Integer valueOf = downloadRange2 != null ? Integer.valueOf(downloadRange2.getRangeId()) : null;
            Long valueOf2 = downloadRange2 != null ? Long.valueOf(downloadRange2.getStart()) : null;
            Long valueOf3 = downloadRange2 != null ? Long.valueOf(downloadRange2.getEnd()) : null;
            c0856a.u("download", "download&play start new thread,oldRangeId:" + valueOf + ",start:" + valueOf2 + ",end:" + valueOf3 + ", rangeId: " + downloadRange.getRangeId() + ", start:" + downloadRange.getStart() + ",end:" + downloadRange.getEnd(), true);
            DownloadExecutor.f58756a.b().e(downloadRunnable);
            return Unit.f67184a;
        }

        @Override // com.transsnet.downloader.proxy.c
        public void a(String str, final int i11, final DownloadRange downloadRange, final DownloadRange range) {
            Intrinsics.h(range, "range");
            if (!Intrinsics.c(str, this.f58714a.getResourceId()) || range.isRangeDownloadSuccess() || ((ArrayList) this.f58715b.f58704e).isEmpty()) {
                return;
            }
            Object obj = ((ArrayList) this.f58715b.f58704e).get(((ArrayList) this.f58715b.f58704e).size() - 1);
            Intrinsics.g(obj, "get(...)");
            final com.transsnet.downloader.core.thread.f fVar = (com.transsnet.downloader.core.thread.f) obj;
            final DownloadTaskImpl downloadTaskImpl = this.f58715b;
            final oy.c cVar = this.f58716c;
            final DownloadBean downloadBean = this.f58714a;
            fVar.pause(new Function0() { // from class: com.transsnet.downloader.core.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit c11;
                    c11 = DownloadTaskImpl.a.c(com.transsnet.downloader.core.thread.f.this, downloadTaskImpl, range, i11, cVar, downloadBean, downloadRange);
                    return c11;
                }
            });
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements com.transsnet.downloader.core.task.a {
        b() {
        }

        @Override // com.transsnet.downloader.core.task.a
        public Object a(boolean z10, long j11, Continuation continuation) {
            DownloadTaskImpl.this.D();
            return Unit.f67184a;
        }
    }

    public DownloadTaskImpl(c downloadResponse, com.transsnet.downloader.proxy.b proxyHelper, DownloadBean downloadInfo, oy.c config, com.transsnet.downloader.core.task.c cVar) {
        Intrinsics.h(downloadResponse, "downloadResponse");
        Intrinsics.h(proxyHelper, "proxyHelper");
        Intrinsics.h(downloadInfo, "downloadInfo");
        Intrinsics.h(config, "config");
        this.f58700a = downloadResponse;
        this.f58701b = proxyHelper;
        this.f58706g = System.currentTimeMillis();
        this.f58709j = new AtomicInteger(0);
        this.f58710k = o0.a(y0.b());
        this.f58711l = "DownloadThread_TaskImpl";
        this.f58712m = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n0 B;
                B = DownloadTaskImpl.B();
                return B;
            }
        });
        this.f58713n = new AtomicInteger(0);
        this.f58702c = downloadInfo;
        this.f58703d = config;
        this.f58705f = cVar;
        this.f58704e = new ArrayList();
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        this.f58707h = companion.b(a11).q1();
        a aVar = new a(downloadInfo, this, config);
        this.f58708i = aVar;
        String resourceId = downloadInfo.getResourceId();
        proxyHelper.a(resourceId == null ? downloadInfo.getUrl() : resourceId, aVar);
    }

    private final void A(int i11) {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.f58711l, "1---multithreadingDownload", false, 4, null);
        List<DownloadRange> v11 = v(i11, null);
        c0856a.c("download", "执行多线程下载, 需要启的线程数 =  " + v11.size(), true);
        int i12 = this.f58709j.get() - 1;
        this.f58709j.addAndGet(v11.size());
        for (DownloadRange downloadRange : v11) {
            int i13 = i12 + 1;
            DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f58701b, i13, this.f58700a, this.f58703d, this.f58702c, this);
            a.C0856a.f(lg.a.f68962a, this.f58711l, "----多线程下载开始, rangeId =  " + downloadRange.getRangeId() + "， index = " + i13 + "，status = " + this.f58702c.getStatus(), false, 4, null);
            downloadRange.setDownloading(true);
            this.f58704e.add(downloadRunnable);
            DownloadExecutor.f58756a.b().e(downloadRunnable);
            i12 = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 B() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).q1();
    }

    private final void C(int i11) {
        ArrayList<DownloadRange> arrayList = new ArrayList();
        arrayList.addAll(this.f58702c.getDownloadRanges());
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.getIsDownloading() && !downloadRange.isRangeDownloadSuccess()) {
                downloadRange.setDownloading(true);
                DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f58701b, i11, this.f58700a, this.f58703d, this.f58702c, this);
                lg.a.f68962a.c("download", "singleThread------onRangeSuccess , start new range~ rangeId = " + downloadRange.getRangeId() + ", range.start = " + downloadRange.getStart() + ",range.end = " + downloadRange.getEnd() + ",progress = " + downloadRange.getProgress(), true);
                this.f58704e.add(downloadRunnable);
                DownloadExecutor.f58756a.b().e(downloadRunnable);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        long g11 = this.f58703d.g();
        Long size = this.f58702c.getSize();
        boolean z10 = g11 < (size != null ? size.longValue() : 0L);
        this.f58702c.setStatus(2);
        this.f58700a.a(this.f58702c);
        this.f58702c.setSupportRanges(z10);
        int f11 = this.f58703d.f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isSupportRanges ");
        sb2.append(z10);
        sb2.append(" config.eachDownloadThread ");
        sb2.append(f11);
        com.transsnet.downloader.core.task.c cVar = this.f58705f;
        if (cVar != null) {
            cVar.c(this.f58702c, true);
        }
        if (z10) {
            long downloadHeaderSize = this.f58702c.getDownloadHeaderSize();
            int f12 = this.f58703d.f();
            long j11 = downloadHeaderSize / f12;
            int i11 = 0;
            while (i11 < f12) {
                long j12 = i11 * j11;
                long j13 = i11 == f12 + (-1) ? downloadHeaderSize - 1 : (j12 + j11) - 1;
                DownloadRange downloadRange = new DownloadRange();
                String resourceId = this.f58702c.getResourceId();
                downloadRange.setThreadId(resourceId != null ? resourceId.hashCode() : 0);
                downloadRange.setRangeId(s.a(j12 + j13));
                downloadRange.setResourceId(this.f58702c.getResourceId());
                downloadRange.setStart(j12);
                downloadRange.setEnd(j13);
                downloadRange.setDownloading(true);
                this.f58702c.getDownloadRanges().add(downloadRange);
                DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f58701b, i11, this.f58700a, this.f58703d, this.f58702c, this);
                DownloadExecutor.f58756a.b().e(downloadRunnable);
                this.f58704e.add(downloadRunnable);
                this.f58709j.getAndIncrement();
                i11++;
                f12 = f12;
            }
            Long size2 = this.f58702c.getSize();
            long longValue = (size2 != null ? size2.longValue() : 1L) - 1;
            DownloadRange downloadRange2 = new DownloadRange();
            String resourceId2 = this.f58702c.getResourceId();
            downloadRange2.setThreadId(resourceId2 != null ? resourceId2.hashCode() : 0);
            downloadRange2.setRangeId(s.a(downloadHeaderSize + longValue));
            downloadRange2.setResourceId(this.f58702c.getResourceId());
            downloadRange2.setStart(downloadHeaderSize);
            downloadRange2.setEnd(longValue);
            this.f58702c.getDownloadRanges().add(downloadRange2);
            lg.a.f68962a.p("download", new String[]{"首次多线程下载,  allSize= " + this.f58703d.f() + "，curThreadSize = " + this.f58709j + ", curThreadListSize = " + this.f58704e.size()}, true);
        } else {
            DownloadRange downloadRange3 = new DownloadRange();
            String resourceId3 = this.f58702c.getResourceId();
            downloadRange3.setThreadId(resourceId3 != null ? resourceId3.hashCode() : 0);
            Long size3 = this.f58702c.getSize();
            downloadRange3.setRangeId(s.a(size3 != null ? size3.longValue() : 1L));
            downloadRange3.setResourceId(this.f58702c.getResourceId());
            downloadRange3.setStart(0L);
            Long size4 = this.f58702c.getSize();
            downloadRange3.setEnd((size4 != null ? size4.longValue() : 1L) - 1);
            this.f58702c.getDownloadRanges().add(downloadRange3);
            DownloadRunnable downloadRunnable2 = new DownloadRunnable(downloadRange3, this.f58701b, 0, this.f58700a, this.f58703d, this.f58702c, this);
            downloadRange3.setDownloading(true);
            DownloadExecutor.f58756a.b().e(downloadRunnable2);
            this.f58704e.add(downloadRunnable2);
            this.f58709j.getAndIncrement();
        }
        this.f58702c.setStatus(2);
        this.f58700a.a(this.f58702c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        DownloadUtil downloadUtil = DownloadUtil.f60023a;
        if (downloadUtil.i(this.f58702c)) {
            ry.e.f74878c.a().k(this.f58702c, null);
            lg.a.f68962a.p("download", new String[]{"startDownload, 资源有问题，需要从头下载"}, true);
            downloadUtil.H(this.f58702c);
        }
        this.f58702c.setRestartDownloadCount(0);
        if (r()) {
            e();
            return;
        }
        if (!this.f58702c.getDownloadRanges().isEmpty()) {
            lg.a.f68962a.p("download", new String[]{"DownloadTaskImpl has task, do not check, name = " + this.f58702c.getName()}, true);
            com.transsnet.downloader.core.task.c cVar = this.f58705f;
            if (cVar != null) {
                cVar.c(this.f58702c, false);
            }
            if (this.f58702c.getIsDownloadingPlay()) {
                z();
            } else {
                x();
            }
            this.f58702c.setStatus(2);
            this.f58700a.a(this.f58702c);
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c("download", "stat new task, name = " + this.f58702c.getName(), true);
        String path = this.f58702c.getPath();
        if (path == null || path.length() == 0) {
            DownloadBean downloadBean = this.f58702c;
            downloadBean.setPath(downloadUtil.s(downloadBean));
            c0856a.p("download", new String[]{"DownloadTaskImpl 新任务, set download path, path = " + this.f58702c.getPath()}, true);
        }
        if (this.f58702c.getDownloadHeaderSize() <= 0) {
            DownloadBean downloadBean2 = this.f58702c;
            downloadBean2.setDownloadHeaderSize(downloadUtil.o(downloadBean2));
        }
        s();
    }

    private final void F(List list) {
        t(list);
        k.d(o0.a(y0.b()), null, null, new DownloadTaskImpl$updateDBRanges$1(this, list, null), 3, null);
    }

    private final synchronized boolean r() {
        if (this.f58702c.getDownloadRanges().isEmpty()) {
            return false;
        }
        Iterator<T> it = this.f58702c.getDownloadRanges().iterator();
        while (it.hasNext()) {
            if (!((DownloadRange) it.next()).isRangeDownloadSuccess()) {
                return false;
            }
        }
        return true;
    }

    private final void s() {
        new DownloadFileInfoTask().b(this.f58702c, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        if (arrayList.size() > 1) {
            CollectionsKt.A(arrayList, new Comparator() { // from class: com.transsnet.downloader.core.DownloadTaskImpl$checkLastRange$lambda$17$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return ComparisonsKt.d(Long.valueOf(((DownloadRange) t11).getStart()), Long.valueOf(((DownloadRange) t12).getStart()));
                }
            });
        }
        list.clear();
        list.addAll(arrayList);
        if (list.isEmpty()) {
            return;
        }
        DownloadRange downloadRange = (DownloadRange) CollectionsKt.u0(list);
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.f58711l, "----checkLastRange, lastEnd =  " + downloadRange.getEnd() + "， end = " + this.f58702c.getSize(), false, 4, null);
        long end = downloadRange.getEnd();
        Long size = this.f58702c.getSize();
        if (end < (size != null ? size.longValue() : 1L) - 1) {
            a.C0856a.f(c0856a, this.f58711l, "----checkLastRange, lost, add new range", false, 4, null);
            long end2 = downloadRange.getEnd() + 1;
            Long size2 = this.f58702c.getSize();
            long longValue = (size2 != null ? size2.longValue() : 1L) - 1;
            DownloadRange downloadRange2 = new DownloadRange();
            downloadRange2.setThreadId(downloadRange.getThreadId());
            downloadRange2.setRangeId(s.a(end2 + longValue));
            downloadRange2.setResourceId(downloadRange.getResourceId());
            downloadRange2.setStart(end2);
            downloadRange2.setEnd(longValue);
            downloadRange2.setProgress(0L);
            list.add(downloadRange2);
        }
    }

    private final long u() {
        com.transsnet.downloader.core.task.c cVar;
        ArrayList<DownloadRange> arrayList = new ArrayList();
        if (!this.f58702c.getDownloadRanges().isEmpty()) {
            arrayList.addAll(this.f58702c.getDownloadRanges());
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.getReDownload() && downloadRange.getProgress() > 0) {
                atomicLong.getAndAdd(downloadRange.getProgress());
            }
        }
        long j11 = atomicLong.get();
        synchronized (this) {
            try {
                this.f58702c.setProgress(j11);
                if (this.f58702c.getIsPreDownload() && j11 >= 5242880 && (cVar = this.f58705f) != null) {
                    cVar.I(this.f58702c);
                }
                a.C0856a.f(lg.a.f68962a, "DownloadThread", "------------total size =" + this.f58702c.getSize() + " progress " + j11 + ", isPreDownload = " + this.f58702c.getIsPreDownload(), false, 4, null);
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j11;
    }

    private final List v(int i11, List list) {
        ArrayList arrayList;
        DownloadRange downloadRange;
        long j11;
        long j12;
        boolean z10;
        long j13;
        boolean z11;
        String str;
        DownloadRange downloadRange2;
        ArrayList arrayList2;
        long j14;
        long j15;
        int i12;
        DownloadTaskImpl downloadTaskImpl = this;
        int i13 = i11;
        ArrayList arrayList3 = new ArrayList();
        ArrayList<DownloadRange> arrayList4 = new ArrayList();
        arrayList4.addAll(downloadTaskImpl.f58702c.getDownloadRanges());
        for (DownloadRange downloadRange3 : arrayList4) {
            if (!downloadRange3.isRangeDownloadSuccess() && !downloadRange3.getIsDownloading()) {
                if (list == null || !list.contains(downloadRange3)) {
                    if (downloadRange3.getEnd() > downloadTaskImpl.f58702c.getDownloadHeaderSize() && downloadRange3.getRangeSize() - downloadRange3.getProgress() > downloadTaskImpl.f58703d.g()) {
                        a.C0856a c0856a = lg.a.f68962a;
                        c0856a.c("download", "分片不够,切多个,count = " + i13 + "， rangeId = " + downloadRange3.getRangeId() + ",start =  " + downloadRange3.getStart() + ",end = " + downloadRange3.getEnd() + "，progress = " + downloadRange3.getProgress(), true);
                        long progress = downloadRange3.getProgress();
                        long start = downloadRange3.getStart() + progress;
                        ArrayList arrayList5 = new ArrayList();
                        String str2 = ", start = ";
                        if (progress > 0) {
                            long start2 = downloadRange3.getStart();
                            long j16 = start - 1;
                            DownloadRange downloadRange4 = new DownloadRange();
                            arrayList = arrayList3;
                            downloadRange4.setThreadId(downloadRange3.getThreadId());
                            downloadRange4.setRangeId(s.a(start2 + j16));
                            downloadRange4.setResourceId(downloadRange3.getResourceId());
                            downloadRange4.setStart(start2);
                            downloadRange4.setEnd(j16);
                            j11 = progress;
                            downloadRange4.setProgress(j11);
                            int rangeId = downloadRange4.getRangeId();
                            long start3 = downloadRange4.getStart();
                            j12 = start;
                            long end = downloadRange4.getEnd();
                            boolean isRangeDownloadSuccess = downloadRange4.isRangeDownloadSuccess();
                            StringBuilder sb2 = new StringBuilder();
                            downloadRange = downloadRange3;
                            sb2.append("当前分片已有下载内容 downloadedSize = ");
                            sb2.append(j11);
                            sb2.append(" 直接将已下载的生成一个独立分片，rangeId = ");
                            sb2.append(rangeId);
                            sb2.append(", start = ");
                            sb2.append(start3);
                            sb2.append(",end = ");
                            sb2.append(end);
                            sb2.append(",success = ");
                            sb2.append(isRangeDownloadSuccess);
                            c0856a.p("download", new String[]{sb2.toString()}, true);
                            arrayList5.add(downloadRange4);
                        } else {
                            arrayList = arrayList3;
                            downloadRange = downloadRange3;
                            j11 = progress;
                            j12 = start;
                        }
                        int i14 = i11;
                        long rangeSize = (downloadRange.getRangeSize() - j11) / i14;
                        DownloadTaskImpl downloadTaskImpl2 = this;
                        if (rangeSize > downloadTaskImpl2.f58703d.g()) {
                            rangeSize = downloadTaskImpl2.f58703d.g();
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        long end2 = downloadRange.getEnd();
                        int i15 = 0;
                        long j17 = 0;
                        while (i15 < i14) {
                            long j18 = j12 + (i15 * rangeSize);
                            long j19 = (j18 + rangeSize) - 1;
                            if (z10) {
                                j13 = rangeSize;
                                if (i15 == i14 - 1 && j19 < end2) {
                                    j19 = end2;
                                }
                            } else {
                                j13 = rangeSize;
                            }
                            Long size = downloadTaskImpl2.f58702c.getSize();
                            if (j19 >= (size != null ? size.longValue() : 1L)) {
                                Long size2 = downloadTaskImpl2.f58702c.getSize();
                                j19 = (size2 != null ? size2.longValue() : 1L) - 1;
                            }
                            if (!z10) {
                                z11 = z10;
                                str = str2;
                                downloadRange2 = downloadRange;
                                long j20 = end2;
                                arrayList2 = arrayList;
                                j14 = j12;
                                j15 = j20;
                                DownloadRange downloadRange5 = new DownloadRange();
                                downloadRange5.setThreadId(downloadRange2.getThreadId());
                                downloadRange5.setRangeId(s.a(j18 + j19));
                                downloadRange5.setResourceId(downloadRange2.getResourceId());
                                downloadRange5.setStart(j18);
                                downloadRange5.setEnd(j19);
                                i12 = i15;
                                downloadRange5.setProgress(0L);
                                lg.a.f68962a.c("download", "分片不够, 没瓜分完 新分片------rangeId = " + downloadRange5.getRangeId() + ",start = " + j18 + ",end = " + j19, true);
                                arrayList2.add(downloadRange5);
                                arrayList5.add(downloadRange5);
                            } else if (i15 == 0) {
                                a.C0856a c0856a2 = lg.a.f68962a;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("分片不够, 瓜分完了 第一个使用原始分片，更改 start = ");
                                long j21 = j12;
                                sb3.append(j21);
                                j15 = end2;
                                sb3.append(" end1 = ");
                                sb3.append(j19);
                                c0856a2.c("download", sb3.toString(), true);
                                downloadRange2 = downloadRange;
                                downloadRange2.setStart(j21);
                                downloadRange2.setEnd(j19);
                                downloadRange2.setProgress(0L);
                                downloadRange2.setDownloading(false);
                                arrayList2 = arrayList;
                                arrayList2.add(downloadRange2);
                                z11 = z10;
                                i12 = i15;
                                j14 = j21;
                                str = str2;
                            } else {
                                downloadRange2 = downloadRange;
                                long j22 = end2;
                                arrayList2 = arrayList;
                                j14 = j12;
                                j15 = j22;
                                DownloadRange downloadRange6 = new DownloadRange();
                                downloadRange6.setThreadId(downloadRange2.getThreadId());
                                downloadRange6.setRangeId(s.a(j18 + j19));
                                downloadRange6.setResourceId(downloadRange2.getResourceId());
                                downloadRange6.setStart(j18);
                                downloadRange6.setEnd(j19);
                                z11 = z10;
                                downloadRange6.setProgress(0L);
                                a.C0856a c0856a3 = lg.a.f68962a;
                                int rangeId2 = downloadRange6.getRangeId();
                                StringBuilder sb4 = new StringBuilder();
                                str = str2;
                                sb4.append("分片不够, 瓜分完了 新分片------rangeId = ");
                                sb4.append(rangeId2);
                                sb4.append(",start = ");
                                sb4.append(j18);
                                sb4.append(",end = ");
                                sb4.append(j19);
                                c0856a3.c("download", sb4.toString(), true);
                                arrayList2.add(downloadRange6);
                                arrayList5.add(downloadRange6);
                                i12 = i15;
                            }
                            i15 = i12 + 1;
                            downloadTaskImpl2 = this;
                            i14 = i11;
                            z10 = z11;
                            j17 = j19;
                            str2 = str;
                            long j23 = j14;
                            downloadRange = downloadRange2;
                            arrayList = arrayList2;
                            end2 = j15;
                            j12 = j23;
                            rangeSize = j13;
                        }
                        String str3 = str2;
                        ArrayList arrayList6 = arrayList;
                        DownloadRange downloadRange7 = downloadRange;
                        if (!z10) {
                            downloadRange7.setStart(j17 + 1);
                            downloadRange7.setDownloading(false);
                            downloadRange7.setProgress(0L);
                            lg.a.f68962a.c("download", "原始分片 =  id = " + downloadRange7.getRangeId() + str3 + downloadRange7.getStart(), true);
                        }
                        if (!arrayList5.isEmpty()) {
                            this.f58702c.getDownloadRanges().addAll(arrayList5);
                        }
                        F(this.f58702c.getDownloadRanges());
                        return arrayList6;
                    }
                    ArrayList arrayList7 = arrayList3;
                    DownloadTaskImpl downloadTaskImpl3 = downloadTaskImpl;
                    if (arrayList7.size() >= i11) {
                        return arrayList7;
                    }
                    lg.a.f68962a.c("download", "---多线程, 分片小于range大小， 头文件 = " + (downloadRange3.getEnd() <= downloadTaskImpl3.f58702c.getDownloadHeaderSize()), true);
                    arrayList7.add(downloadRange3);
                    downloadTaskImpl = downloadTaskImpl3;
                    arrayList3 = arrayList7;
                    i13 = i11;
                }
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n0 w() {
        return (n0) this.f58712m.getValue();
    }

    private final void x() {
        lg.a.f68962a.p("download", new String[]{"开始下载--多线程"}, true);
        ArrayList<DownloadRange> arrayList = new ArrayList();
        List<DownloadRange> downloadRanges = this.f58702c.getDownloadRanges();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(downloadRanges);
        if (arrayList2.size() > 1) {
            CollectionsKt.A(arrayList2, new Comparator() { // from class: com.transsnet.downloader.core.DownloadTaskImpl$handleMultithreadingDownloadOnly$lambda$3$lambda$2$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return ComparisonsKt.d(Long.valueOf(((DownloadRange) t11).getStart()), Long.valueOf(((DownloadRange) t12).getStart()));
                }
            });
        }
        downloadRanges.clear();
        downloadRanges.addAll(arrayList2);
        for (DownloadRange downloadRange : this.f58702c.getDownloadRanges()) {
            downloadRange.setDownloading(false);
            if (arrayList.size() < this.f58703d.f() && !downloadRange.isRangeDownloadSuccess() && downloadRange.getRangeSize() <= this.f58703d.g()) {
                lg.a.f68962a.p("download", new String[]{"添加下载分片,rangeId = " + downloadRange.getRangeId() + ",start =  " + downloadRange.getStart() + ",end = " + downloadRange.getEnd() + "， progress = " + downloadRange.getProgress() + " "}, true);
                arrayList.add(downloadRange);
            }
        }
        if (arrayList.size() < this.f58703d.f()) {
            arrayList.addAll(v(this.f58703d.f() - arrayList.size(), arrayList));
        }
        int i11 = this.f58709j.get() - 1;
        this.f58709j.addAndGet(arrayList.size());
        for (DownloadRange downloadRange2 : arrayList) {
            i11++;
            DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange2, this.f58701b, i11, this.f58700a, this.f58703d, this.f58702c, this);
            lg.a.f68962a.p(this.f58711l, new String[]{"----多线程下载开始, rangeId =  " + downloadRange2.getRangeId() + ", curSize= " + i11 + "，status = " + this.f58702c.getStatus()}, true);
            downloadRange2.setDownloading(true);
            DownloadExecutor.f58756a.b().e(downloadRunnable);
            this.f58704e.add(downloadRunnable);
        }
    }

    private final void y(int i11) {
        a.C0856a.f(lg.a.f68962a, this.f58711l, "2---handleNextRangeDownload", false, 4, null);
        ArrayList<DownloadRange> arrayList = new ArrayList();
        arrayList.addAll(this.f58702c.getDownloadRanges());
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.isRangeDownloadSuccess()) {
                a.C0856a.f(lg.a.f68962a, this.f58711l, "2---rangeId = " + downloadRange.getRangeId() + ", isDownloading = " + downloadRange.getIsDownloading(), false, 4, null);
            }
            if (!downloadRange.getIsDownloading() && !downloadRange.isRangeDownloadSuccess()) {
                if (!this.f58702c.getIsDownloadingPlay() && downloadRange.getRangeSize() - downloadRange.getProgress() > this.f58703d.g()) {
                    lg.a.f68962a.c(this.f58711l, "onRangeSuccess 这个分片太大，需要切成小分片", true);
                    long progress = downloadRange.getProgress() + downloadRange.getStart() + this.f58703d.g() + 1;
                    long end = downloadRange.getEnd();
                    DownloadRange downloadRange2 = new DownloadRange();
                    downloadRange2.setThreadId(downloadRange.getThreadId());
                    downloadRange2.setRangeId(s.a(progress + end));
                    downloadRange2.setResourceId(downloadRange.getResourceId());
                    downloadRange2.setStart(progress);
                    downloadRange2.setEnd(end);
                    downloadRange2.setProgress(0L);
                    downloadRange.setEnd(downloadRange2.getStart() - 1);
                    this.f58702c.getDownloadRanges().add(downloadRange2);
                    F(this.f58702c.getDownloadRanges());
                }
                DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f58701b, i11, this.f58700a, this.f58703d, this.f58702c, this);
                downloadRange.setDownloading(true);
                a.C0856a.f(lg.a.f68962a, this.f58711l, "2---start single new range tread~ rangeId = " + downloadRange.getRangeId() + ", range.start = " + downloadRange.getStart() + ",range.end = " + downloadRange.getEnd(), false, 4, null);
                this.f58704e.add(downloadRunnable);
                this.f58709j.getAndIncrement();
                DownloadExecutor.f58756a.b().e(downloadRunnable);
                return;
            }
        }
    }

    private final void z() {
        DownloadRange downloadRange;
        DownloadRange downloadRange2;
        long j11 = 0;
        if (this.f58702c.getCurrentOffset() > 0) {
            long currentOffset = this.f58702c.getCurrentOffset();
            Long size = this.f58702c.getSize();
            if (currentOffset < (size != null ? size.longValue() : 0L) - 1) {
                j11 = this.f58702c.getCurrentOffset();
            }
        }
        lg.a.f68962a.p("download", new String[]{"开始下载--边下边播，单线程 subjectId=" + this.f58702c.getSubjectId() + ",resourceId=" + this.f58702c.getResourceId() + ",name=" + this.f58702c.getName() + ",---readProgress = " + this.f58702c.getReadProgress() + ", currentOffset = " + j11 + ", ranges size = " + this.f58702c.getDownloadRanges().size()}, true);
        Iterator<DownloadRange> it = this.f58702c.getDownloadRanges().iterator();
        while (true) {
            if (!it.hasNext()) {
                downloadRange = null;
                break;
            }
            downloadRange = it.next();
            a.C0856a c0856a = lg.a.f68962a;
            String str = this.f58711l;
            int rangeId = downloadRange.getRangeId();
            long start = downloadRange.getStart();
            long end = downloadRange.getEnd();
            long progress = downloadRange.getProgress();
            StringBuilder sb2 = new StringBuilder();
            Iterator<DownloadRange> it2 = it;
            sb2.append("---rangeId = ");
            sb2.append(rangeId);
            sb2.append(", range.start = ");
            sb2.append(start);
            sb2.append(",range.end = ");
            sb2.append(end);
            sb2.append(", range.progress = ");
            sb2.append(progress);
            a.C0856a.f(c0856a, str, sb2.toString(), false, 4, null);
            downloadRange.setDownloading(false);
            long start2 = downloadRange.getStart();
            if (j11 <= downloadRange.getEnd() && start2 <= j11) {
                a.C0856a.f(c0856a, this.f58711l, "0-- get range , rangeId =  " + downloadRange.getRangeId(), false, 4, null);
                break;
            }
            it = it2;
        }
        if (downloadRange == null || downloadRange.isRangeDownloadSuccess()) {
            a.C0856a.f(lg.a.f68962a, this.f58711l, "1--  播放进度的分片已下载完成，则取一个问下载的分片执行下载", false, 4, null);
            for (DownloadRange downloadRange3 : this.f58702c.getDownloadRanges()) {
                if (!downloadRange3.isRangeDownloadSuccess()) {
                    a.C0856a.f(lg.a.f68962a, this.f58711l, "2--  取一个问下载的分片执行下载, get range", false, 4, null);
                    downloadRange2 = downloadRange3;
                    break;
                }
            }
        }
        downloadRange2 = downloadRange;
        if (downloadRange2 == null || downloadRange2.isRangeDownloadSuccess()) {
            return;
        }
        lg.a.f68962a.p("download", new String[]{"----------执行未下载的线程"}, true);
        DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange2, this.f58701b, 0, this.f58700a, this.f58703d, this.f58702c, this);
        downloadRange2.setDownloading(true);
        DownloadExecutor.f58756a.b().e(downloadRunnable);
        this.f58704e.add(downloadRunnable);
        this.f58709j.getAndIncrement();
    }

    @Override // com.transsnet.downloader.core.thread.d
    public synchronized void a(com.transsnet.downloader.core.thread.f runnable, int i11, DownloadRange curRange) {
        try {
            Intrinsics.h(runnable, "runnable");
            Intrinsics.h(curRange, "curRange");
            int decrementAndGet = this.f58709j.get() > 0 ? this.f58709j.decrementAndGet() : 0;
            curRange.setDownloading(false);
            boolean remove = this.f58704e.remove(runnable);
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, this.f58711l, "reDownload，result =" + remove, false, 4, null);
            if (decrementAndGet <= 0) {
                c0856a.p("download", new String[]{"重新下载所有线程已经暂停，开始执行新下载"}, true);
                k.d(this.f58710k, null, null, new DownloadTaskImpl$reDownload$1(this, null), 3, null);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.transsnet.downloader.core.task.b
    public DownloadBean b() {
        return this.f58702c;
    }

    @Override // com.transsnet.downloader.core.thread.d
    public synchronized void c(com.transsnet.downloader.core.thread.f runnable, int i11, DownloadRange curRange) {
        try {
            Intrinsics.h(runnable, "runnable");
            Intrinsics.h(curRange, "curRange");
            int decrementAndGet = this.f58709j.get() > 0 ? this.f58709j.decrementAndGet() : 0;
            curRange.setDownloading(false);
            this.f58704e.remove(runnable);
            int f11 = this.f58703d.f() - decrementAndGet;
            lg.a.f68962a.c("download", "边下边播 退出-------执行多线程， threadSize = " + f11, true);
            if (f11 > 0) {
                A(f11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.transsnet.downloader.core.thread.d
    public synchronized void d() {
        int status = this.f58702c.getStatus();
        if (status == 1 || status == 2 || this.f58713n.get() != status) {
            this.f58713n.set(status);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f58706g > 1000) {
                long u11 = u();
                Long size = this.f58702c.getSize();
                if (u11 > (size != null ? size.longValue() : 1L)) {
                    e();
                } else {
                    this.f58702c.setUpdateTimeStamp(Long.valueOf(currentTimeMillis));
                    this.f58700a.a(this.f58702c);
                    this.f58706g = currentTimeMillis;
                }
            }
        }
    }

    @Override // com.transsnet.downloader.core.thread.d
    public synchronized void e() {
        u();
        if (this.f58702c.getStatus() == 5) {
            a.C0856a.f(lg.a.f68962a, this.f58711l, "--------onDownloadSuccess---相同状态，无需重复回调-", false, 4, null);
            return;
        }
        long progress = this.f58702c.getProgress();
        Long size = this.f58702c.getSize();
        if (progress >= (size != null ? size.longValue() : 1L) || r()) {
            DownloadUtil downloadUtil = DownloadUtil.f60023a;
            if (downloadUtil.i(this.f58702c)) {
                ry.e.f74878c.a().k(this.f58702c, null);
                a.C0856a c0856a = lg.a.f68962a;
                c0856a.c("download", "onDownloadSuccess, 资源有问题，需要重新下载，  progress = " + this.f58702c.getProgress(), true);
                this.f58702c.setStatus(0);
                downloadUtil.H(this.f58702c);
                a.C0856a.f(c0856a, "ReDownload", "resetProgress， progress = " + this.f58702c.getProgress(), false, 4, null);
                com.transsnet.downloader.core.task.c cVar = this.f58705f;
                if (cVar != null) {
                    cVar.g(this.f58702c);
                }
                return;
            }
            lg.a.f68962a.c("download", "------------------------------onDownloadSuccess subjectId=" + this.f58702c.getResourceId() + ",resourceId=" + this.f58702c.getResourceId() + "------------------------------", true);
            this.f58702c.setStatus(5);
            this.f58702c.setReportStatus(5);
            this.f58702c.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
            this.f58700a.a(this.f58702c);
            com.transsnet.downloader.core.task.c cVar2 = this.f58705f;
            if (cVar2 != null) {
                cVar2.b(this.f58702c);
            }
            com.transsnet.downloader.proxy.b bVar = this.f58701b;
            String resourceId = this.f58702c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f58702c.getUrl();
            }
            bVar.i(resourceId);
        }
    }

    @Override // com.transsnet.downloader.core.thread.d
    public synchronized void f(com.transsnet.downloader.core.thread.f runnable, int i11, DownloadRange curRange) {
        try {
            Intrinsics.h(runnable, "runnable");
            Intrinsics.h(curRange, "curRange");
            long u11 = u();
            curRange.setDownloading(false);
            a.C0856a c0856a = lg.a.f68962a;
            c0856a.u("download", "======onRangeSuccess, thread = " + Thread.currentThread().getName() + ",rangeId = " + curRange.getRangeId() + ",progress = " + u11 + ", resourceId=" + this.f58702c.getResourceId() + ",HeaderSize= " + this.f58702c.getDownloadHeaderSize(), true);
            long currentTimeMillis = System.currentTimeMillis();
            Long size = this.f58702c.getSize();
            if (u11 > (size != null ? size.longValue() : 1L)) {
                e();
                return;
            }
            this.f58702c.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
            this.f58700a.a(this.f58702c);
            this.f58706g = currentTimeMillis;
            int decrementAndGet = this.f58709j.get() > 0 ? this.f58709j.decrementAndGet() : 0;
            this.f58704e.remove(runnable);
            if (u11 < this.f58702c.getDownloadHeaderSize() && decrementAndGet > 0) {
                c0856a.p("download", new String[]{"=======onRangeSuccess header not success, wait, downloadProgress = " + u11}, true);
                return;
            }
            if (Math.abs(u11 - this.f58702c.getDownloadHeaderSize()) < lj.b.f68989a.d()) {
                c0856a.c("download", "onRangeSuccess,  文件头下载完成，执行多线程", true);
            }
            int f11 = decrementAndGet < this.f58703d.f() ? this.f58703d.f() - decrementAndGet : 0;
            c0856a.c("download", "allSize= " + this.f58703d.f() + ",curThreadSize = " + decrementAndGet + ",resourceId=" + this.f58702c.getResourceId() + "," + this.f58704e.size() + ",threadSize = " + f11, true);
            if (f11 > 1 && !this.f58702c.getIsDownloadingPlay()) {
                A(f11);
            } else if (this.f58702c.getIsDownloadingPlay() && decrementAndGet > 2) {
                c0856a.c("download", "resourceId=" + this.f58702c.getResourceId() + " 当前边下边播 还是多线程，移除该线程，等待最后一个单线程下载", true);
            } else if (this.f58702c.getIsDownloadingPlay()) {
                c0856a.c("download", "resourceId=" + this.f58702c.getResourceId() + " 当前边下边播 ,单线程下载，不去切分片---", true);
                C(i11);
            } else {
                y(i11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.transsnet.downloader.core.task.b
    public void start() {
        if (!m.f70597a.e()) {
            this.f58700a.b(this.f58702c, new DownloadException(9, DownloadException.EXCEPTION_MESSAGE_NO_NET));
        } else if (this.f58702c.getDownloadRanges().isEmpty()) {
            k.d(this.f58710k, null, null, new DownloadTaskImpl$start$1(this, null), 3, null);
        } else {
            k.d(this.f58710k, null, null, new DownloadTaskImpl$start$2(this, null), 3, null);
        }
    }
}
