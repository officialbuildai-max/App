package com.transsnet.downloader.core;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.core.DownloadTaskImpl2;
import com.transsnet.downloader.core.task.DownloadFileInfoTask;
import com.transsnet.downloader.core.task.DownloadTaskUtil;
import com.transsnet.downloader.core.thread.DownloadExecutor;
import com.transsnet.downloader.core.thread.DownloadRunnable;
import com.transsnet.downloader.core.thread.d;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import nh.m;

/* loaded from: classes7.dex */
public final class DownloadTaskImpl2 implements com.transsnet.downloader.core.task.b, com.transsnet.downloader.core.thread.d {

    /* renamed from: n, reason: collision with root package name */
    public static final a f58718n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final com.transsnet.downloader.core.c f58719a;

    /* renamed from: b, reason: collision with root package name */
    private final com.transsnet.downloader.proxy.b f58720b;

    /* renamed from: c, reason: collision with root package name */
    private final DownloadBean f58721c;

    /* renamed from: d, reason: collision with root package name */
    private final oy.c f58722d;

    /* renamed from: e, reason: collision with root package name */
    private final com.transsnet.downloader.core.task.c f58723e;

    /* renamed from: f, reason: collision with root package name */
    private final long f58724f;

    /* renamed from: g, reason: collision with root package name */
    private AtomicInteger f58725g;

    /* renamed from: h, reason: collision with root package name */
    private final List f58726h;

    /* renamed from: i, reason: collision with root package name */
    private AtomicLong f58727i;

    /* renamed from: j, reason: collision with root package name */
    private n0 f58728j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f58729k;

    /* renamed from: l, reason: collision with root package name */
    private final AtomicInteger f58730l;

    /* renamed from: m, reason: collision with root package name */
    private final c f58731m;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements com.transsnet.downloader.core.task.a {
        b() {
        }

        @Override // com.transsnet.downloader.core.task.a
        public Object a(boolean z10, long j11, Continuation continuation) {
            Object z11 = DownloadTaskImpl2.this.z(continuation);
            return z11 == IntrinsicsKt.f() ? z11 : Unit.f67184a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements com.transsnet.downloader.proxy.c {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(com.transsnet.downloader.core.thread.f fVar, DownloadTaskImpl2 downloadTaskImpl2, DownloadRange downloadRange, DownloadRange downloadRange2, int i11) {
            fVar.removeBreakCallback();
            downloadTaskImpl2.f58726h.remove(fVar);
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.v(c0856a, "DownloadThread", "beak success, start new thread", false, 4, null);
            long progress = downloadTaskImpl2.f58721c.getProgress();
            Integer valueOf = downloadRange != null ? Integer.valueOf(downloadRange.getRangeId()) : null;
            Long valueOf2 = downloadRange != null ? Long.valueOf(downloadRange.getStart()) : null;
            Long valueOf3 = downloadRange != null ? Long.valueOf(downloadRange.getEnd()) : null;
            Long valueOf4 = downloadRange != null ? Long.valueOf(downloadRange.getProgress()) : null;
            c0856a.u("download", StringsKt.n("download&play start new thread, totalProgress = " + progress + "\n                        oldRangeId:" + valueOf + ", start:" + valueOf2 + ", end:" + valueOf3 + ", progress:" + valueOf4 + " \n                        newRangeId:" + downloadRange2.getRangeId() + ", start:" + downloadRange2.getStart() + ", end:" + downloadRange2.getEnd() + ", progress:" + downloadRange2.getProgress() + " \n                    "), true);
            downloadTaskImpl2.y(downloadRange2, i11);
            return Unit.f67184a;
        }

        @Override // com.transsnet.downloader.proxy.c
        public void a(String str, final int i11, final DownloadRange downloadRange, final DownloadRange range) {
            Intrinsics.h(range, "range");
            if (Intrinsics.c(str, DownloadTaskImpl2.this.f58721c.getResourceId())) {
                if (range.isRangeDownloadSuccess()) {
                    lg.a.f68962a.u("download", "download&play, range download success， do nothing", true);
                } else {
                    if (DownloadTaskImpl2.this.f58726h.isEmpty()) {
                        a.C0856a.v(lg.a.f68962a, "DownloadThread", "download&play, thread null", false, 4, null);
                        return;
                    }
                    final com.transsnet.downloader.core.thread.f fVar = (com.transsnet.downloader.core.thread.f) DownloadTaskImpl2.this.f58726h.get(DownloadTaskImpl2.this.f58726h.size() - 1);
                    final DownloadTaskImpl2 downloadTaskImpl2 = DownloadTaskImpl2.this;
                    fVar.pause(new Function0() { // from class: com.transsnet.downloader.core.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c11;
                            c11 = DownloadTaskImpl2.c.c(com.transsnet.downloader.core.thread.f.this, downloadTaskImpl2, downloadRange, range, i11);
                            return c11;
                        }
                    });
                }
            }
        }
    }

    public DownloadTaskImpl2(com.transsnet.downloader.core.c downloadResponse, com.transsnet.downloader.proxy.b proxyHelper, DownloadBean downloadBean, oy.c config, com.transsnet.downloader.core.task.c cVar) {
        Intrinsics.h(downloadResponse, "downloadResponse");
        Intrinsics.h(proxyHelper, "proxyHelper");
        Intrinsics.h(downloadBean, "downloadBean");
        Intrinsics.h(config, "config");
        this.f58719a = downloadResponse;
        this.f58720b = proxyHelper;
        this.f58721c = downloadBean;
        this.f58722d = config;
        this.f58723e = cVar;
        this.f58724f = config.g();
        this.f58725g = new AtomicInteger(0);
        this.f58726h = new ArrayList();
        this.f58727i = new AtomicLong(System.currentTimeMillis());
        this.f58728j = o0.a(y0.b());
        this.f58729k = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                lj.n0 x10;
                x10 = DownloadTaskImpl2.x();
                return x10;
            }
        });
        this.f58730l = new AtomicInteger(0);
        c cVar2 = new c();
        this.f58731m = cVar2;
        String resourceId = downloadBean.getResourceId();
        proxyHelper.a(resourceId == null ? downloadBean.getUrl() : resourceId, cVar2);
    }

    private final synchronized boolean r() {
        if (this.f58721c.getDownloadRanges().isEmpty()) {
            return false;
        }
        Iterator<T> it = this.f58721c.getDownloadRanges().iterator();
        while (it.hasNext()) {
            if (!((DownloadRange) it.next()).isRangeDownloadSuccess()) {
                return false;
            }
        }
        lg.a.f68962a.c("download", "checkAllThreadStatus success", true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(Continuation continuation) {
        new DownloadFileInfoTask().b(this.f58721c, new b());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final lj.n0 t() {
        return (lj.n0) this.f58729k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        int i11;
        DownloadTaskUtil.f58752a.e(this.f58721c);
        if (this.f58721c.getDownloadHeaderSize() <= 0) {
            DownloadBean downloadBean = this.f58721c;
            downloadBean.setDownloadHeaderSize(DownloadUtil.f60023a.o(downloadBean));
        }
        int i12 = 1;
        lg.a.f68962a.p("download", new String[]{"已有任务 开始下载--多线程, isPreDownload:" + this.f58721c.getIsPreDownload()}, true);
        this.f58721c.setStatus(2);
        ArrayList<DownloadRange> arrayList = new ArrayList();
        int f11 = this.f58721c.getIsDownloadingPlay() ? 2 : this.f58722d.f();
        Iterator<DownloadRange> it = this.f58721c.getDownloadRanges().iterator();
        while (true) {
            if (!it.hasNext()) {
                i11 = i12;
                break;
            }
            DownloadRange next = it.next();
            next.setDownloading(false);
            if (!next.isRangeDownloadSuccess()) {
                a.C0856a c0856a = lg.a.f68962a;
                int rangeId = next.getRangeId();
                long start = next.getStart();
                long end = next.getEnd();
                long progress = next.getProgress();
                boolean isDownloadingPlay = this.f58721c.getIsDownloadingPlay();
                StringBuilder sb2 = new StringBuilder();
                Iterator<DownloadRange> it2 = it;
                sb2.append("添加下载分片,rangeId:");
                sb2.append(rangeId);
                sb2.append(", start:");
                sb2.append(start);
                sb2.append(", end:");
                sb2.append(end);
                sb2.append(", progress:");
                sb2.append(progress);
                sb2.append(", dp:");
                sb2.append(isDownloadingPlay);
                sb2.append(" ");
                i11 = 1;
                c0856a.p("download", new String[]{sb2.toString()}, true);
                arrayList.add(next);
                if (arrayList.size() >= f11) {
                    break;
                }
                i12 = 1;
                it = it2;
            }
        }
        int i13 = this.f58725g.get() - i11;
        this.f58725g.addAndGet(arrayList.size());
        for (DownloadRange downloadRange : arrayList) {
            lg.a.f68962a.p("download", new String[]{"----多线程下载开始, rangeId:" + downloadRange.getRangeId() + ", curSize:" + i13 + "，status:" + this.f58721c.getStatus()}, true);
            i13++;
            y(downloadRange, i13);
        }
    }

    private final void v(int i11) {
        ArrayList arrayList;
        boolean z10;
        Object obj;
        Iterator it;
        int i12 = i11;
        lg.a.f68962a.c("download", "2---handleNextRangeDownload,name:" + this.f58721c.getName() + ", RangesSize:" + this.f58721c.getDownloadRanges().size(), true);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.f58721c.getDownloadRanges());
        long j11 = 0;
        if (this.f58721c.getCurrentOffset() > 0) {
            long currentOffset = this.f58721c.getCurrentOffset();
            Long size = this.f58721c.getSize();
            if (currentOffset < (size != null ? size.longValue() : 0L)) {
                j11 = this.f58721c.getCurrentOffset();
            }
        }
        Iterator it2 = arrayList2.iterator();
        boolean z11 = false;
        while (true) {
            if (!it2.hasNext()) {
                arrayList = arrayList2;
                z10 = false;
                break;
            }
            DownloadRange downloadRange = (DownloadRange) it2.next();
            if (downloadRange.isRangeDownloadSuccess()) {
                it = it2;
            } else {
                a.C0856a c0856a = lg.a.f68962a;
                int rangeId = downloadRange.getRangeId();
                boolean isDownloading = downloadRange.getIsDownloading();
                StringBuilder sb2 = new StringBuilder();
                it = it2;
                sb2.append("2---rangeId:");
                sb2.append(rangeId);
                sb2.append(", isDownloading:");
                sb2.append(isDownloading);
                sb2.append(",currentOffset:");
                sb2.append(j11);
                a.C0856a.f(c0856a, "download", sb2.toString(), false, 4, null);
            }
            if (!downloadRange.isRangeDownloadSuccess() && !downloadRange.getIsDownloading()) {
                if (downloadRange.getEnd() >= j11) {
                    y(downloadRange, i12);
                    a.C0856a c0856a2 = lg.a.f68962a;
                    int rangeId2 = downloadRange.getRangeId();
                    long start = downloadRange.getStart();
                    long end = downloadRange.getEnd();
                    long progress = downloadRange.getProgress();
                    StringBuilder sb3 = new StringBuilder();
                    arrayList = arrayList2;
                    sb3.append("2---执行下一个task~ rangeId:");
                    sb3.append(rangeId2);
                    sb3.append(", start:");
                    sb3.append(start);
                    sb3.append(",range:");
                    sb3.append(end);
                    sb3.append(",progress:");
                    sb3.append(progress);
                    c0856a2.c("download", sb3.toString(), true);
                    this.f58725g.getAndIncrement();
                    z10 = true;
                    break;
                }
                it2 = it;
                z11 = true;
            } else {
                i12 = i11;
                arrayList2 = arrayList2;
                it2 = it;
            }
        }
        if (!z11 || z10) {
            return;
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj = null;
                break;
            }
            obj = it3.next();
            DownloadRange downloadRange2 = (DownloadRange) obj;
            if (!downloadRange2.isRangeDownloadSuccess() && !downloadRange2.getIsDownloading()) {
                break;
            }
        }
        DownloadRange downloadRange3 = (DownloadRange) obj;
        if (downloadRange3 != null) {
            lg.a.f68962a.c("download", "2-2---执行下一个task~ rangeId:" + downloadRange3.getRangeId() + ", start:" + downloadRange3.getStart() + ",range:" + downloadRange3.getEnd() + ",progress:" + downloadRange3.getProgress(), true);
            this.f58725g.getAndIncrement();
            y(downloadRange3, i11);
        }
    }

    private final void w(int i11) {
        List<DownloadRange> k11 = DownloadTaskUtil.f58752a.k(i11, this.f58721c);
        lg.a.f68962a.c("download", "1---multithreadingDownload,name:" + this.f58721c.getName() + ", RangesSize:" + this.f58721c.getDownloadRanges().size() + " 需要启的线程数 =  " + k11.size(), true);
        int i12 = this.f58725g.get() - 1;
        this.f58725g.addAndGet(k11.size());
        for (DownloadRange downloadRange : k11) {
            a.C0856a.f(lg.a.f68962a, "download", "----多线程下载开始, rangeId =  " + downloadRange.getRangeId() + "， index = " + i12 + "，status = " + this.f58721c.getStatus(), false, 4, null);
            i12++;
            y(downloadRange, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lj.n0 x() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(DownloadRange downloadRange, int i11) {
        long end = downloadRange.getEnd();
        Long size = this.f58721c.getSize();
        if (end <= (size != null ? size.longValue() : 0L)) {
            downloadRange.setDownloading(true);
            if (DownloadTaskUtil.f58752a.i()) {
                com.transsnet.downloader.core.thread.e eVar = new com.transsnet.downloader.core.thread.e(downloadRange, this.f58720b, i11, this.f58719a, this.f58722d, this.f58721c, this);
                this.f58726h.add(eVar);
                k.d(this.f58728j, null, null, new DownloadTaskImpl2$startDownloadInIO$2(eVar, null), 3, null);
                return;
            } else {
                DownloadRunnable downloadRunnable = new DownloadRunnable(downloadRange, this.f58720b, i11, this.f58719a, this.f58722d, this.f58721c, this);
                this.f58726h.add(downloadRunnable);
                DownloadExecutor.f58756a.b().e(downloadRunnable);
                return;
            }
        }
        lg.a.f68962a.i("download", "startDownloadInIO error range ,contentLength:" + this.f58721c.getSize() + ",range:" + downloadRange.getStart() + "-" + downloadRange.getEnd(), true);
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.m1185constructorimpl(Boolean.valueOf(this.f58721c.getDownloadRanges().remove(downloadRange)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.DownloadTaskImpl2.z(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsnet.downloader.core.thread.d
    public void a(com.transsnet.downloader.core.thread.f runnable, int i11, DownloadRange curRange) {
        Intrinsics.h(runnable, "runnable");
        Intrinsics.h(curRange, "curRange");
        int decrementAndGet = this.f58725g.get() > 0 ? this.f58725g.decrementAndGet() : 0;
        curRange.setDownloading(false);
        boolean remove = this.f58726h.remove(runnable);
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "download", "reDownload，result =" + remove, false, 4, null);
        if (decrementAndGet <= 0) {
            c0856a.p("download", new String[]{"重新下载所有线程已经暂停，开始执行新下载"}, true);
            k.d(this.f58728j, null, null, new DownloadTaskImpl2$reDownload$1(this, null), 3, null);
        }
    }

    @Override // com.transsnet.downloader.core.task.b
    public DownloadBean b() {
        return this.f58721c;
    }

    @Override // com.transsnet.downloader.core.thread.d
    public void c(com.transsnet.downloader.core.thread.f fVar, int i11, DownloadRange downloadRange) {
        d.a.a(this, fVar, i11, downloadRange);
    }

    @Override // com.transsnet.downloader.core.thread.d
    public synchronized void d() {
        int status = this.f58721c.getStatus();
        if (status == 1 || status == 2 || this.f58730l.get() != status) {
            this.f58730l.set(status);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f58727i.get() > 1000) {
                long f11 = DownloadTaskUtil.f58752a.f(this.f58721c, this, this.f58723e);
                Long size = this.f58721c.getSize();
                if (f11 > (size != null ? size.longValue() : 1L)) {
                    e();
                } else {
                    this.f58721c.setUpdateTimeStamp(Long.valueOf(currentTimeMillis));
                    this.f58719a.a(this.f58721c);
                    this.f58727i.set(currentTimeMillis);
                }
            }
        }
    }

    @Override // com.transsnet.downloader.core.thread.d
    public synchronized void e() {
        DownloadTaskUtil.f58752a.f(this.f58721c, this, this.f58723e);
        if (this.f58721c.getStatus() == 5) {
            a.C0856a.f(lg.a.f68962a, "download", "--------onDownloadSuccess---相同状态，无需重复回调-", false, 4, null);
            return;
        }
        long progress = this.f58721c.getProgress();
        Long size = this.f58721c.getSize();
        if (progress >= (size != null ? size.longValue() : 1L) || r()) {
            DownloadUtil downloadUtil = DownloadUtil.f60023a;
            if (downloadUtil.i(this.f58721c)) {
                ry.e.f74878c.a().k(this.f58721c, null);
                a.C0856a c0856a = lg.a.f68962a;
                c0856a.c("download", "onDownloadSuccess, 资源有问题，需要重新下载，  progress = " + this.f58721c.getProgress(), true);
                this.f58721c.setStatus(0);
                downloadUtil.H(this.f58721c);
                a.C0856a.f(c0856a, "ReDownload", "resetProgress， progress = " + this.f58721c.getProgress(), false, 4, null);
                com.transsnet.downloader.core.task.c cVar = this.f58723e;
                if (cVar != null) {
                    cVar.g(this.f58721c);
                }
                return;
            }
            lg.a.f68962a.c("download", "------------------------------onDownloadSuccess subjectId=" + this.f58721c.getSubjectId() + ",resourceId=" + this.f58721c.getResourceId() + ", size:" + this.f58721c.getSize() + ", progress:" + this.f58721c.getProgress() + "------------------------------", true);
            this.f58721c.setStatus(5);
            this.f58721c.setReportStatus(5);
            this.f58721c.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
            this.f58719a.a(this.f58721c);
            com.transsnet.downloader.core.task.c cVar2 = this.f58723e;
            if (cVar2 != null) {
                cVar2.b(this.f58721c);
            }
            com.transsnet.downloader.proxy.b bVar = this.f58720b;
            String resourceId = this.f58721c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f58721c.getUrl();
            }
            bVar.i(resourceId);
        }
    }

    @Override // com.transsnet.downloader.core.thread.d
    public synchronized void f(com.transsnet.downloader.core.thread.f runnable, int i11, DownloadRange curRange) {
        try {
            Intrinsics.h(runnable, "runnable");
            Intrinsics.h(curRange, "curRange");
            long f11 = DownloadTaskUtil.f58752a.f(this.f58721c, this, this.f58723e);
            curRange.setDownloading(false);
            a.C0856a c0856a = lg.a.f68962a;
            c0856a.u("download", "======onRangeSuccess, name:" + this.f58721c.getTitleName() + ",thread = " + Thread.currentThread().getName() + ",rangeId = " + curRange.getRangeId() + ",progress = " + f11 + ", resourceId=" + this.f58721c.getResourceId() + ",status:" + this.f58721c.getStatus() + "}", true);
            long currentTimeMillis = System.currentTimeMillis();
            Long size = this.f58721c.getSize();
            if (f11 > (size != null ? size.longValue() : 1L)) {
                e();
                return;
            }
            this.f58721c.setUpdateTimeStamp(Long.valueOf(currentTimeMillis));
            if (currentTimeMillis - this.f58727i.get() > 1000) {
                this.f58719a.a(this.f58721c);
                this.f58727i.set(currentTimeMillis);
            }
            int decrementAndGet = this.f58725g.get() > 0 ? this.f58725g.decrementAndGet() : 0;
            this.f58726h.remove(runnable);
            if (f11 < this.f58721c.getDownloadHeaderSize() && decrementAndGet > 0) {
                c0856a.p("download", new String[]{"=======onRangeSuccess header not success, wait, downloadProgress = " + f11}, true);
                return;
            }
            int f12 = decrementAndGet < this.f58722d.f() ? this.f58722d.f() - decrementAndGet : 0;
            c0856a.c("download", "allSize:" + this.f58722d.f() + ",curThreadSize: " + decrementAndGet + ", threadCount：" + this.f58726h.size() + ",newThreadCount = " + f12, true);
            if (f12 > 1 && !this.f58721c.getIsDownloadingPlay()) {
                w(f12);
            } else if (!this.f58721c.getIsDownloadingPlay() || decrementAndGet < 2) {
                v(i11);
            } else {
                c0856a.c("download", "resourceId=" + this.f58721c.getResourceId() + " 当前边下边播 还是多线程，移除该线程，等待最后还有2个线程下载", true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.transsnet.downloader.core.task.b
    public void start() {
        if (!m.f70597a.e()) {
            this.f58719a.b(this.f58721c, new DownloadException(9, DownloadException.EXCEPTION_MESSAGE_NO_NET));
            return;
        }
        DownloadUtil downloadUtil = DownloadUtil.f60023a;
        if (downloadUtil.i(this.f58721c)) {
            ry.e.f74878c.a().k(this.f58721c, null);
            lg.a.f68962a.p("download", new String[]{"startDownload, 资源有问题，需要从头下载"}, true);
            downloadUtil.H(this.f58721c);
        }
        this.f58721c.setRestartDownloadCount(0);
        if (r()) {
            e();
            return;
        }
        this.f58721c.setStatus(2);
        if (this.f58721c.getDownloadRanges().isEmpty()) {
            k.d(this.f58728j, null, null, new DownloadTaskImpl2$start$1(this, null), 3, null);
        } else {
            k.d(this.f58728j, null, null, new DownloadTaskImpl2$start$2(this, null), 3, null);
        }
    }
}
