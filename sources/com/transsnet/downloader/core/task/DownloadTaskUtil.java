package com.transsnet.downloader.core.task;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.downloader.core.DownloadTaskImpl2;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;
import lj.n0;

/* loaded from: classes7.dex */
public final class DownloadTaskUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadTaskUtil f58752a = new DownloadTaskUtil();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f58753b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.task.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            n0 m11;
            m11 = DownloadTaskUtil.m();
            return m11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f58754c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.task.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean h11;
            h11 = DownloadTaskUtil.h();
            return Boolean.valueOf(h11);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f58755d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.task.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean g11;
            g11 = DownloadTaskUtil.g();
            return Boolean.valueOf(g11);
        }
    });

    private DownloadTaskUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g() {
        Boolean m12;
        ConfigBean c11 = sm.f.f75530c.a().c("downloadInCoroutine", false);
        String value = c11 != null ? c11.getValue() : null;
        if (value == null || value.length() == 0 || (m12 = StringsKt.m1(value)) == null) {
            return true;
        }
        return m12.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h() {
        Boolean m12;
        ConfigBean c11 = sm.f.f75530c.a().c("downloadNewRange", false);
        String value = c11 != null ? c11.getValue() : null;
        if (value == null || value.length() == 0 || (m12 = StringsKt.m1(value)) == null) {
            return true;
        }
        return m12.booleanValue();
    }

    private final n0 l() {
        return (n0) f58753b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 m() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).q1();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(long r26, com.transsion.baselib.db.download.DownloadBean r28, java.util.List r29, kotlin.coroutines.Continuation r30) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.task.DownloadTaskUtil.d(long, com.transsion.baselib.db.download.DownloadBean, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void e(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadBean");
        String path = downloadBean.getPath();
        if (path == null || path.length() == 0) {
            downloadBean.setPath(DownloadUtil.f60023a.s(downloadBean));
            lg.a.f68962a.p("download", new String[]{"DownloadTaskImpl 新任务, set download path, path = " + downloadBean.getPath()}, true);
        }
    }

    public final long f(DownloadBean downloadBean, DownloadTaskImpl2 downloadTask, c cVar) {
        Intrinsics.h(downloadBean, "downloadBean");
        Intrinsics.h(downloadTask, "downloadTask");
        ArrayList<DownloadRange> arrayList = new ArrayList();
        arrayList.addAll(downloadBean.getDownloadRanges());
        AtomicLong atomicLong = new AtomicLong(0L);
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.getReDownload() && downloadRange.getProgress() > 0) {
                atomicLong.getAndAdd(downloadRange.getProgress());
            }
        }
        long j11 = atomicLong.get();
        synchronized (downloadTask) {
            try {
                downloadBean.setProgress(j11);
                if (downloadBean.getIsPreDownload() && j11 >= 5242880 && cVar != null) {
                    cVar.I(downloadBean);
                }
                a.C0856a.f(lg.a.f68962a, "DownloadThread", "------------total size:" + downloadBean.getSize() + " progress:" + j11 + ", isPreDownload: " + downloadBean.getIsPreDownload(), false, 4, null);
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j11;
    }

    public final boolean i() {
        return ((Boolean) f58755d.getValue()).booleanValue();
    }

    public final boolean j() {
        return ((Boolean) f58754c.getValue()).booleanValue();
    }

    public final List k(int i11, DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadBean");
        long j11 = 0;
        if (downloadBean.getCurrentOffset() > 0) {
            long currentOffset = downloadBean.getCurrentOffset();
            Long size = downloadBean.getSize();
            if (currentOffset < (size != null ? size.longValue() : 0L)) {
                j11 = downloadBean.getCurrentOffset();
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<DownloadRange> arrayList2 = new ArrayList();
        arrayList2.addAll(downloadBean.getDownloadRanges());
        for (DownloadRange downloadRange : arrayList2) {
            if (!downloadRange.isRangeDownloadSuccess() && !downloadRange.getIsDownloading() && (!downloadBean.getIsDownloadingPlay() || downloadRange.getEnd() >= j11)) {
                arrayList.add(downloadRange);
                if (arrayList.size() >= i11) {
                    break;
                }
            }
        }
        if (arrayList.size() < i11) {
            for (DownloadRange downloadRange2 : arrayList2) {
                if (!downloadRange2.isRangeDownloadSuccess() && !downloadRange2.getIsDownloading() && !arrayList.contains(downloadRange2)) {
                    arrayList.add(downloadRange2);
                    if (arrayList.size() >= i11) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(5:10|11|12|13|(5:15|(1:17)|12|13|(3:19|20|21)(0))(0))(2:23|24))(4:25|26|13|(0)(0))))|28|6|7|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:11:0x0039, B:12:0x009e, B:13:0x007c, B:15:0x0082, B:19:0x00eb, B:26:0x0054), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00eb A[Catch: all -> 0x0110, TRY_LEAVE, TryCatch #0 {all -> 0x0110, blocks: (B:11:0x0039, B:12:0x009e, B:13:0x007c, B:15:0x0082, B:19:0x00eb, B:26:0x0054), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x009b -> B:12:0x009e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.util.List r22, kotlin.coroutines.Continuation r23) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.task.DownloadTaskUtil.n(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
