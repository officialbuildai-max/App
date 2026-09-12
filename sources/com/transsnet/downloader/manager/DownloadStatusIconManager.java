package com.transsnet.downloader.manager;

import com.blankj.utilcode.util.Utils;
import com.transsnet.downloader.callback.DownloadTaskStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes.dex */
public final class DownloadStatusIconManager implements ny.b {

    /* renamed from: h, reason: collision with root package name */
    public static final a f59585h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f59586i = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadStatusIconManager s11;
            s11 = DownloadStatusIconManager.s();
            return s11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private int f59589c;

    /* renamed from: d, reason: collision with root package name */
    private int f59590d;

    /* renamed from: e, reason: collision with root package name */
    private int f59591e;

    /* renamed from: f, reason: collision with root package name */
    private int f59592f;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f59587a = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            g p11;
            p11 = DownloadStatusIconManager.p();
            return p11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final List f59588b = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f59593g = com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_download_done_status", true);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadStatusIconManager a() {
            return (DownloadStatusIconManager) DownloadStatusIconManager.f59586i.getValue();
        }
    }

    public DownloadStatusIconManager() {
        q().n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g p() {
        return p.f59623a.a(Utils.a());
    }

    private final g q() {
        return (g) this.f59587a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadStatusIconManager s() {
        return new DownloadStatusIconManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int i11, int i12) {
        Iterator it = this.f59588b.iterator();
        while (it.hasNext()) {
            ((ny.e) it.next()).a(i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void u(DownloadStatusIconManager downloadStatusIconManager, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = -1;
        }
        downloadStatusIconManager.t(i11, i12);
    }

    @Override // ny.b
    public void a(DownloadTaskStat downloadTaskStat) {
        Intrinsics.h(downloadTaskStat, "downloadTaskStat");
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new DownloadStatusIconManager$onChange$1(this, downloadTaskStat, null), 3, null);
    }

    public final void o(ny.e listener) {
        Intrinsics.h(listener, "listener");
        if (!this.f59588b.contains(listener)) {
            this.f59588b.add(listener);
        }
        q().E();
    }

    public final void r() {
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new DownloadStatusIconManager$initDownloadUnreadList$1(this, null), 3, null);
    }

    public final void v(ny.e listener) {
        Intrinsics.h(listener, "listener");
        this.f59588b.remove(listener);
    }

    public final void w(boolean z10) {
        com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("k_download_done_status", z10);
        this.f59593g = z10;
    }
}
