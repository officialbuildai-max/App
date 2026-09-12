package com.transsion.player.shorttv.preload;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.scheduler.Requirements;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.player.exo.DemoDownloadService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oo.d;

/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f48593a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f48594b;

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f48595c;

    /* renamed from: d, reason: collision with root package name */
    private static final HandlerThread f48596d;

    /* renamed from: e, reason: collision with root package name */
    private static final Handler f48597e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f48598f;

    /* renamed from: g, reason: collision with root package name */
    private static final Function0 f48599g;

    /* renamed from: h, reason: collision with root package name */
    private static final b f48600h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f48601i;

    /* loaded from: classes6.dex */
    public static final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message msg) {
            Intrinsics.h(msg, "msg");
            try {
                super.dispatchMessage(msg);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements DownloadManager.d {
        b() {
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void a(DownloadManager downloadManager, boolean z10) {
            Intrinsics.h(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onWaitingForRequirementsChanged:");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c download) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(download, "download");
            Log.e("VideoPreloadUtil", "onDownloadRemoved:");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void c(DownloadManager downloadManager, boolean z10) {
            Intrinsics.h(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onDownloadsPausedChanged:");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void d(DownloadManager downloadManager) {
            Intrinsics.h(downloadManager, "downloadManager");
            Log.e("VideoPreloadUtil", "onIdle:");
            q.f48593a.B();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void e(DownloadManager downloadManager, Requirements requirements, int i11) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(requirements, "requirements");
            Log.e("VideoPreloadUtil", "onRequirementsStateChanged:");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c download, Exception exc) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(download, "download");
            Log.e("VideoPreloadUtil", "onDownloadChanged:  download.requestId:" + download.f12495a.f12425id + "     bytesDownloaded:" + download.a() + "  contentLength:" + download.f12499e + "  percentDownloaded:" + download.b());
            com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) q.f48594b.get(download.f12495a.f12425id);
            if (aVar != null) {
                aVar.h(download.a());
                aVar.g(download.f12499e);
                int i11 = download.f12496b;
                if (i11 == 2) {
                    long b11 = aVar.b();
                    long d11 = aVar.d();
                    if (1 <= d11 && d11 < b11) {
                        q qVar = q.f48593a;
                        String id2 = aVar.e().f12425id;
                        Intrinsics.g(id2, "id");
                        qVar.D(id2);
                    }
                } else if (i11 == 1 || i11 == 3) {
                    q qVar2 = q.f48593a;
                    String id3 = aVar.e().f12425id;
                    Intrinsics.g(id3, "id");
                    qVar2.x(id3);
                }
            }
            q.f48593a.A();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void g(DownloadManager downloadManager) {
            Intrinsics.h(downloadManager, "downloadManager");
        }
    }

    static {
        q qVar = new q();
        f48593a = qVar;
        f48594b = new ConcurrentHashMap();
        f48595c = LazyKt.b(new Function0() { // from class: com.transsion.player.shorttv.preload.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Application m11;
                m11 = q.m();
                return m11;
            }
        });
        HandlerThread handlerThread = new HandlerThread("VideoPreloadUtil");
        f48596d = handlerThread;
        f48598f = 100L;
        f48599g = new Function0() { // from class: com.transsion.player.shorttv.preload.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit F;
                F = q.F();
                return F;
            }
        };
        b bVar = new b();
        f48600h = bVar;
        handlerThread.start();
        f48597e = new a(handlerThread.getLooper());
        co.a.h(qVar.o()).d(bVar);
    }

    private q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        if (f48601i) {
            return;
        }
        f48601i = true;
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        f48601i = false;
        Handler handler = f48597e;
        final Function0 function0 = f48599g;
        handler.removeCallbacks(new Runnable() { // from class: com.transsion.player.shorttv.preload.k
            @Override // java.lang.Runnable
            public final void run() {
                q.C(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(String str) {
        oo.e.d(oo.e.f71197a, "VideoPreloadUtil", "stopPreload   key:" + str, false, 4, null);
        DownloadService.z(f48593a.o(), DemoDownloadService.class, str, 10086, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F() {
        for (Object obj : co.a.h(f48593a.o()).e()) {
            Intrinsics.g(obj, "next(...)");
            androidx.media3.exoplayer.offline.c cVar = (androidx.media3.exoplayer.offline.c) obj;
            if (cVar.f12496b == 2) {
                String str = cVar.f12495a.f12425id;
                long a11 = cVar.a();
                long j11 = cVar.f12499e;
                float b11 = cVar.b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("progress 111:  download.requestId:");
                sb2.append(str);
                sb2.append("     bytesDownloaded:");
                sb2.append(a11);
                sb2.append("  contentLength:");
                sb2.append(j11);
                sb2.append("  percentDownloaded:");
                sb2.append(b11);
                com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) f48594b.get(cVar.f12495a.f12425id);
                if (aVar != null) {
                    aVar.h(cVar.a());
                    aVar.g(cVar.f12499e);
                    long b12 = aVar.b();
                    long d11 = aVar.d();
                    if (1 <= d11 && d11 < b12) {
                        q qVar = f48593a;
                        String id2 = aVar.e().f12425id;
                        Intrinsics.g(id2, "id");
                        qVar.x(id2);
                    }
                }
            }
        }
        if (f48601i) {
            f48593a.p();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Application m() {
        return Utils.a();
    }

    private final Context o() {
        Object value = f48595c.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (Context) value;
    }

    private final void p() {
        Handler handler = f48597e;
        final Function0 function0 = f48599g;
        handler.removeCallbacks(new Runnable() { // from class: com.transsion.player.shorttv.preload.n
            @Override // java.lang.Runnable
            public final void run() {
                q.q(Function0.this);
            }
        });
        handler.postDelayed(new Runnable() { // from class: com.transsion.player.shorttv.preload.o
            @Override // java.lang.Runnable
            public final void run() {
                q.r(Function0.this);
            }
        }, f48598f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ao.e eVar) {
        q qVar = f48593a;
        qVar.s(qVar.n(eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(com.transsion.player.shorttv.preload.a aVar) {
        Log.e("VideoPreloadUtil", "preloadVideo id:" + aVar.c() + " downloadLength:" + aVar.b() + "  maxLength:" + aVar.d() + " contentLength:" + aVar.a());
        if (aVar.d() == -1 || aVar.b() < aVar.d()) {
            if (aVar.f()) {
                DownloadService.z(f48593a.o(), DemoDownloadService.class, aVar.c(), 0, false);
                Log.e("VideoPreloadUtil", "checkToStart restart  shortTVItem:" + aVar);
                return;
            }
            DownloadService.x(f48593a.o(), DemoDownloadService.class, aVar.e(), false);
            Log.e("VideoPreloadUtil", "checkToStart add    shortTVItem:" + aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(String str) {
        oo.e.d(oo.e.f71197a, "VideoPreloadUtil", "removePreload   key:" + str, false, 4, null);
        DownloadService.y(f48593a.o(), DemoDownloadService.class, str, false);
    }

    public final void D(final String key) {
        Intrinsics.h(key, "key");
        z(new Runnable() { // from class: com.transsion.player.shorttv.preload.m
            @Override // java.lang.Runnable
            public final void run() {
                q.E(key);
            }
        });
    }

    public final String G(String str) {
        int o02 = str != null ? StringsKt.o0(str, UrlUtils.QUESTION_MARK, 0, false, 6, null) : -1;
        if (str != null && o02 >= 0) {
            return oo.d.f71195a.a((String) StringsKt.S0(str, new String[]{UrlUtils.QUESTION_MARK}, false, 0, 6, null).get(0));
        }
        d.a aVar = oo.d.f71195a;
        if (str == null) {
            str = "";
        }
        return aVar.a(str);
    }

    public final com.transsion.player.shorttv.preload.a n(ao.e shortTVItem) {
        DownloadRequest downloadRequest;
        Intrinsics.h(shortTVItem, "shortTVItem");
        ConcurrentHashMap concurrentHashMap = f48594b;
        com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) concurrentHashMap.get(shortTVItem.g());
        if (aVar != null) {
            oo.e.b(oo.e.f71197a, "VideoPreloadUtil", "createDownloadRequest [from map]  shortTVItem:" + shortTVItem, false, 4, null);
            return aVar;
        }
        androidx.media3.exoplayer.offline.c h11 = co.a.h(Utils.a()).f().h(shortTVItem.g());
        if (Intrinsics.c((h11 == null || (downloadRequest = h11.f12495a) == null) ? null : downloadRequest.f12425id, shortTVItem.g())) {
            oo.e.b(oo.e.f71197a, "VideoPreloadUtil", "createDownloadRequest [from currentDownloads]   shortTVItem:" + shortTVItem, false, 4, null);
            String g11 = shortTVItem.g();
            String k11 = shortTVItem.k();
            DownloadRequest request = h11.f12495a;
            Intrinsics.g(request, "request");
            return new com.transsion.player.shorttv.preload.a(g11, k11, request, h11.f12499e, h11.a(), 307200L, true);
        }
        String g12 = shortTVItem.g();
        String k12 = shortTVItem.k();
        DownloadRequest a11 = new DownloadRequest.b(g12, Uri.parse(k12)).b(g12).a();
        Intrinsics.g(a11, "build(...)");
        com.transsion.player.shorttv.preload.a aVar2 = new com.transsion.player.shorttv.preload.a(g12, k12, a11, -1L, 0L, 307200L, false);
        concurrentHashMap.put(g12, aVar2);
        oo.e.b(oo.e.f71197a, "VideoPreloadUtil", "createDownloadRequest [from new]  shortTVItem:" + shortTVItem, false, 4, null);
        return aVar2;
    }

    public final com.transsion.player.shorttv.preload.a s(final com.transsion.player.shorttv.preload.a shortTVDownloadBean) {
        Intrinsics.h(shortTVDownloadBean, "shortTVDownloadBean");
        z(new Runnable() { // from class: com.transsion.player.shorttv.preload.p
            @Override // java.lang.Runnable
            public final void run() {
                q.v(a.this);
            }
        });
        return shortTVDownloadBean;
    }

    public final void t(final ao.e shortTVItem) {
        Intrinsics.h(shortTVItem, "shortTVItem");
        z(new Runnable() { // from class: com.transsion.player.shorttv.preload.j
            @Override // java.lang.Runnable
            public final void run() {
                q.u(ao.e.this);
            }
        });
    }

    public final com.transsion.player.shorttv.preload.a w(ao.e shortTVItem) {
        Intrinsics.h(shortTVItem, "shortTVItem");
        com.transsion.player.shorttv.preload.a n11 = n(shortTVItem);
        s(n11);
        return n11;
    }

    public final void x(final String key) {
        Intrinsics.h(key, "key");
        f48594b.remove(key);
        z(new Runnable() { // from class: com.transsion.player.shorttv.preload.l
            @Override // java.lang.Runnable
            public final void run() {
                q.y(key);
            }
        });
    }

    public final void z(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        f48597e.post(runnable);
    }
}
