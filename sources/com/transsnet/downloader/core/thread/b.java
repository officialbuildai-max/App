package com.transsnet.downloader.core.thread;

import android.util.Log;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.exception.DownloadPauseException;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.util.h;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public abstract class b implements f {
    public static final a Companion = new a(null);
    private static final long MAX_SPEED_LIMIT_SLEEP_MS = 200;
    private static final double MIN_TARGET_SPEED_RATIO = 0.01d;
    private static final long NANOS_PER_MILLISECOND = 1000000;
    public static final int SPEED_THRESHOLD = 51200;
    public static final String TAG = "download";
    private Function0<Unit> breakCallback;
    private int bufferSize;
    private final oy.c config;
    private final DownloadBean downloadInfo;
    private final d downloadProgressListener;
    private final DownloadRange downloadRange;
    private final com.transsnet.downloader.core.c downloadResponse;
    private boolean isBreak;
    private final com.transsnet.downloader.proxy.b proxyHelper;
    private int retryDownloadCount;
    private final int threadIndex;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(DownloadRange downloadRange, com.transsnet.downloader.proxy.b proxyHelper, int i11, com.transsnet.downloader.core.c downloadResponse, oy.c config, DownloadBean downloadInfo, d downloadProgressListener) {
        Intrinsics.h(downloadRange, "downloadRange");
        Intrinsics.h(proxyHelper, "proxyHelper");
        Intrinsics.h(downloadResponse, "downloadResponse");
        Intrinsics.h(config, "config");
        Intrinsics.h(downloadInfo, "downloadInfo");
        Intrinsics.h(downloadProgressListener, "downloadProgressListener");
        this.downloadRange = downloadRange;
        this.proxyHelper = proxyHelper;
        this.threadIndex = i11;
        this.downloadResponse = downloadResponse;
        this.config = config;
        this.downloadInfo = downloadInfo;
        this.downloadProgressListener = downloadProgressListener;
        this.bufferSize = lj.b.f68989a.d();
    }

    private final void b() {
        if (DownloadUtil.f60023a.i(this.downloadInfo)) {
            int h11 = this.config.h();
            if (h11 <= 0) {
                ry.e.f74878c.a().k(this.downloadInfo, null);
                j();
            } else if (new Random().nextInt(h11) + 1 == 1) {
                ry.e.f74878c.a().k(this.downloadInfo, new Function0() { // from class: com.transsnet.downloader.core.thread.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit c11;
                        c11 = b.c(b.this);
                        return c11;
                    }
                });
            } else {
                ry.e.f74878c.a().k(this.downloadInfo, null);
                j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(b bVar) {
        bVar.j();
        return Unit.f67184a;
    }

    private final void d() {
        if (this.downloadInfo.isPause()) {
            throw new DownloadPauseException(7);
        }
    }

    private final void e() {
        Long size = this.downloadInfo.getSize();
        long longValue = size != null ? size.longValue() : 0L;
        if (this.downloadRange.getEnd() >= longValue) {
            this.downloadRange.setEnd(longValue - 1);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x145a: MOVE (r17 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:889:0x1458 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x145c: MOVE (r45 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:889:0x1458 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    private final void f() {
        /*
            Method dump skipped, instructions count: 5934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.thread.b.f():void");
    }

    private final long g() {
        Double h11 = h();
        if (h11 == null) {
            return 51200L;
        }
        return RangesKt.g((long) (SPEED_THRESHOLD * h11.doubleValue()), 1L);
    }

    private final Double h() {
        if (h.f60061a.a()) {
            return null;
        }
        double k11 = RangesKt.k(this.config.d(), 0.0d, 1.0d);
        if (k11 <= 0.0d) {
            return null;
        }
        return Double.valueOf(RangesKt.d(1.0d - k11, MIN_TARGET_SPEED_RATIO));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.transsion.baselib.db.download.DownloadException i(java.lang.Exception r8, int r9, int r10, java.lang.Integer r11, java.lang.String r12, java.lang.String r13) {
        /*
            r7 = this;
            com.transsion.baselib.db.download.DownloadException$a r0 = com.transsion.baselib.db.download.DownloadException.INSTANCE
            int r0 = r0.b(r8, r9)
            java.lang.String r1 = r8.getMessage()
            if (r1 != 0) goto Ld
            goto Le
        Ld:
            r12 = r1
        Le:
            r1 = 5
            if (r9 != r1) goto L1d
            nh.m r2 = nh.m.f70597a
            boolean r2 = r2.e()
            if (r2 != 0) goto L1d
            r0 = 9
            java.lang.String r12 = "noNetWork"
        L1d:
            r2 = 0
            if (r9 != r1) goto L4a
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r1 = r12.toLowerCase(r9)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r3)
            java.lang.String r4 = "ssl"
            r5 = 2
            r6 = 0
            boolean r1 = kotlin.text.StringsKt.c0(r1, r4, r2, r5, r6)
            if (r1 == 0) goto L38
            java.lang.String r9 = "ssl_error"
            goto L4b
        L38:
            java.lang.String r9 = r12.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.g(r9, r3)
            java.lang.String r1 = "failed to connect to"
            boolean r9 = kotlin.text.StringsKt.c0(r9, r1, r2, r5, r6)
            if (r9 == 0) goto L4a
            java.lang.String r9 = "failed to connect to host"
            goto L4b
        L4a:
            r9 = r12
        L4b:
            com.transsion.baselib.db.download.DownloadException r1 = new com.transsion.baselib.db.download.DownloadException
            r1.<init>(r0, r12, r8)
            if (r11 == 0) goto L58
            int r8 = r11.intValue()     // Catch: java.lang.Throwable -> L59
            r10 = r8
            goto L59
        L58:
            r10 = r2
        L59:
            r1.setResponseCode(r10)
            r1.setFormatMessage(r9)
            r1.setRange(r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.thread.b.i(java.lang.Exception, int, int, java.lang.Integer, java.lang.String, java.lang.String):com.transsion.baselib.db.download.DownloadException");
    }

    private final void j() {
        this.downloadInfo.setProgress(0L);
        for (DownloadRange downloadRange : this.downloadInfo.getDownloadRanges()) {
            downloadRange.setProgress(0L);
            if (downloadRange.getRangeId() != this.downloadRange.getRangeId() && downloadRange.getIsDownloading()) {
                downloadRange.setReDownload(true);
            }
        }
        throw new ReDownloadException();
    }

    private final void k(long j11) {
        Double h11 = h();
        if (h11 == null) {
            return;
        }
        double doubleValue = h11.doubleValue();
        long nanoTime = System.nanoTime() - j11;
        if (nanoTime <= 0) {
            return;
        }
        long j12 = (long) (nanoTime / doubleValue);
        while (true) {
            j12 -= nanoTime;
            if (j12 <= 0 || this.isBreak) {
                return;
            }
            d();
            nanoTime = RangesKt.j(j12, 200000000L);
            long j13 = nanoTime / 1000000;
            int i11 = (int) (nanoTime % 1000000);
            if (j13 <= 0 && i11 <= 0) {
                return;
            }
            try {
                Thread.sleep(j13, i11);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                this.isBreak = true;
                return;
            }
        }
    }

    @Override // com.transsnet.downloader.core.thread.f
    public void pause(Function0<Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.isBreak = true;
        this.breakCallback = callback;
    }

    @Override // com.transsnet.downloader.core.thread.f
    public void removeBreakCallback() {
        this.breakCallback = null;
    }

    public void startDownload() {
        lg.a.f68962a.c("download", "start thread: threadId = " + this.downloadRange.getThreadId() + ", rangeId = " + this.downloadRange.getRangeId() + ", isPause =  " + this.downloadInfo.isPause() + "   name =  " + this.downloadInfo.getName() + " , progress = " + this.downloadInfo.getProgress() + ", range.start = " + this.downloadRange.getStart() + ", range.progress = " + this.downloadRange.getProgress() + ",range.end = " + this.downloadRange.getEnd() + ", isBreak = " + this.isBreak + ", status = " + this.downloadInfo.getStatus(), true);
        this.downloadRange.setThreadIndex(this.threadIndex);
        this.isBreak = false;
        while (!this.downloadInfo.isPause() && !this.downloadRange.isRangeDownloadSuccess() && !this.isBreak) {
            try {
                d();
                f();
            } catch (DownloadPathException e11) {
                this.downloadRange.setDownloading(false);
                this.downloadResponse.b(this.downloadInfo, e11);
            } catch (DownloadException e12) {
                if (this.retryDownloadCount >= this.config.j()) {
                    this.downloadRange.setDownloading(false);
                    this.downloadResponse.b(this.downloadInfo, e12);
                    lg.a.f68962a.i("download", "失败重试已满 retry thread: name = " + this.downloadInfo.getName() + ", isPause =  " + this.downloadInfo.isPause() + ", isRangeDownloadSuccess=  " + this.downloadRange.isRangeDownloadSuccess() + ", isBreak = " + this.isBreak + ", progress:  " + this.downloadInfo.getProgress() + " ,rangeId = " + this.downloadRange.getRangeId() + "  ", true);
                    return;
                }
                this.retryDownloadCount++;
            } catch (QuitDPRestartException unused) {
                this.downloadRange.setDownloading(false);
                this.downloadProgressListener.c(this, this.threadIndex, this.downloadRange);
                return;
            } catch (ReDownloadException unused2) {
                this.downloadProgressListener.a(this, this.threadIndex, this.downloadRange);
                return;
            } catch (RestartException unused3) {
                Log.e("download", "restart download thread, rangeId = " + this.downloadRange.getRangeId());
            } catch (DownloadPauseException unused4) {
                this.downloadRange.setDownloading(false);
            }
        }
    }
}
