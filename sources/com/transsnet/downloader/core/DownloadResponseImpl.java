package com.transsnet.downloader.core;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.downloader.notification.DownloadNotificationUtils;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes.dex */
public final class DownloadResponseImpl implements c {

    /* renamed from: j, reason: collision with root package name */
    public static final a f58689j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Set f58690a;

    /* renamed from: b, reason: collision with root package name */
    private final oy.c f58691b;

    /* renamed from: c, reason: collision with root package name */
    private int f58692c;

    /* renamed from: d, reason: collision with root package name */
    private String f58693d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f58694e;

    /* renamed from: f, reason: collision with root package name */
    private final int f58695f;

    /* renamed from: g, reason: collision with root package name */
    private com.transsnet.downloader.manager.g f58696g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f58697h;

    /* renamed from: i, reason: collision with root package name */
    private n0 f58698i;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            DownloadBean downloadBean;
            Intrinsics.h(msg, "msg");
            super.handleMessage(msg);
            Object obj = msg.obj;
            if (obj != null) {
                Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
                downloadBean = (DownloadBean) obj;
            } else {
                downloadBean = null;
            }
            if (downloadBean == null) {
                return;
            }
            DownloadResponseImpl.this.j(downloadBean, msg.what, msg.arg1 == 1);
        }
    }

    public DownloadResponseImpl(com.transsnet.downloader.manager.g downloadManager, Set downloadListeners, oy.c cVar) {
        Intrinsics.h(downloadManager, "downloadManager");
        Intrinsics.h(downloadListeners, "downloadListeners");
        this.f58690a = downloadListeners;
        this.f58691b = cVar;
        this.f58692c = -1;
        this.f58694e = new b(Looper.getMainLooper());
        this.f58695f = 40;
        this.f58697h = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                lj.n0 k11;
                k11 = DownloadResponseImpl.k();
                return k11;
            }
        });
        this.f58698i = o0.a(y0.b());
        this.f58696g = downloadManager;
    }

    private final void h(DownloadBean downloadBean) {
        if (downloadBean.getStatus() == 7) {
            return;
        }
        k.d(this.f58698i, null, null, new DownloadResponseImpl$createOrUpdateDownloadInfo$1(downloadBean, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final lj.n0 i() {
        return (lj.n0) this.f58697h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(com.transsion.baselib.db.download.DownloadBean r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.DownloadResponseImpl.j(com.transsion.baselib.db.download.DownloadBean, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lj.n0 k() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).q1();
    }

    private final void l(DownloadBean downloadBean) {
        Object obj;
        if (downloadBean.getIsPreDownload()) {
            return;
        }
        if (downloadBean.getStatus() == 6) {
            ConfigBean c11 = sm.f.f75530c.a().c("download_error_opt_off", true);
            if (c11 == null || (obj = c11.getValue()) == null) {
                obj = 0;
            }
            DownloadException exception = downloadBean.getException();
            if (exception != null && exception.getCode() == downloadBean.getPreErrorCode() && Intrinsics.c(obj, 0)) {
                return;
            }
            DownloadException exception2 = downloadBean.getException();
            downloadBean.setPreErrorCode(exception2 != null ? exception2.getCode() : DownloadException.INSTANCE.a());
        }
        k.d(this.f58698i, null, null, new DownloadResponseImpl$report$1(downloadBean, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0021. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(com.transsion.baselib.db.download.DownloadBean r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.DownloadResponseImpl.m(com.transsion.baselib.db.download.DownloadBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void n(DownloadBean downloadBean) {
        DownloadNotificationUtils.f59629a.I(downloadBean);
    }

    @Override // com.transsnet.downloader.core.c
    public void a(DownloadBean downloadBean) {
        int status = downloadBean != null ? downloadBean.getStatus() : -1;
        if (downloadBean != null && (!downloadBean.isDownloading()) && this.f58692c == status && Intrinsics.c(this.f58693d, downloadBean.getResourceId())) {
            lg.a.f68962a.x("DownloadImp-ResponseImpl", "onStatusChanged, intercept status = " + status + " resourceId= " + downloadBean.getResourceId(), true);
            return;
        }
        this.f58692c = status;
        this.f58693d = downloadBean != null ? downloadBean.getResourceId() : null;
        if (downloadBean != null) {
            h(downloadBean);
            if (ThreadUtils.j()) {
                j(downloadBean, downloadBean.getStatus(), downloadBean.getIsPreDownload());
            } else {
                Message obtainMessage = this.f58694e.obtainMessage(downloadBean.getStatus());
                Intrinsics.g(obtainMessage, "obtainMessage(...)");
                obtainMessage.obj = downloadBean;
                obtainMessage.arg1 = downloadBean.getIsPreDownload() ? 1 : 0;
                obtainMessage.sendToTarget();
            }
        }
        a.C0856a c0856a = lg.a.f68962a;
        String str = "onStatusChanged，name = " + (downloadBean != null ? downloadBean.getTotalTitleName() : null) + ",status =" + (downloadBean != null ? Integer.valueOf(downloadBean.getStatus()) : null) + ",  progress:" + (downloadBean != null ? Long.valueOf(downloadBean.getProgress()) : null) + ", size:" + (downloadBean != null ? downloadBean.getSize() : null) + ", " + downloadBean;
        boolean z10 = false;
        if (downloadBean != null && downloadBean.isDownloading()) {
            z10 = true;
        }
        c0856a.c("DownloadImp-ResponseImpl", str, !z10);
    }

    @Override // com.transsnet.downloader.core.c
    public void b(DownloadBean downloadBean, DownloadException downloadException) {
        com.transsnet.downloader.manager.g gVar;
        if (downloadBean != null) {
            downloadBean.setStatus(6);
        }
        if (this.f58692c == 6) {
            if (Intrinsics.c(this.f58693d, downloadBean != null ? downloadBean.getResourceId() : null)) {
                a.C0856a.f(lg.a.f68962a, "DownloadImp-ResponseImpl", "handleException, intercept", false, 4, null);
                return;
            }
        }
        this.f58692c = 6;
        this.f58693d = downloadBean != null ? downloadBean.getResourceId() : null;
        if (downloadBean != null) {
            downloadBean.setException(downloadException);
        }
        if (downloadBean != null) {
            h(downloadBean);
            if (ThreadUtils.j()) {
                j(downloadBean, downloadBean.getStatus(), downloadBean.getIsPreDownload());
            } else {
                Message obtainMessage = this.f58694e.obtainMessage(6);
                Intrinsics.g(obtainMessage, "obtainMessage(...)");
                obtainMessage.obj = downloadBean;
                obtainMessage.arg1 = downloadBean.getIsPreDownload() ? 1 : 0;
                obtainMessage.sendToTarget();
            }
        }
        lg.a.f68962a.x("download", "handleException: code = " + (downloadException != null ? Integer.valueOf(downloadException.getCode()) : null) + ",responseCode = " + (downloadException != null ? Integer.valueOf(downloadException.getResponseCode()) : null) + ", msg = " + (downloadException != null ? downloadException.getLocalizedMessage() : null), true);
        if (downloadBean == null || (gVar = this.f58696g) == null) {
            return;
        }
        gVar.v(downloadBean);
    }
}
