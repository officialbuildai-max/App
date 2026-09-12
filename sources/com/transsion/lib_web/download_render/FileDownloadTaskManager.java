package com.transsion.lib_web.download_render;

import android.app.Application;
import com.tn.lib.logger.xlog.LogType;
import gm.i;
import hj.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import mg.c;

/* loaded from: classes5.dex */
public final class FileDownloadTaskManager {

    /* renamed from: a, reason: collision with root package name */
    public static final FileDownloadTaskManager f46201a = new FileDownloadTaskManager();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f46202b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private static AtomicLong f46203c = new AtomicLong(1);

    /* renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.sync.a f46204d = kotlinx.coroutines.sync.g.b(false, 1, null);

    /* renamed from: e, reason: collision with root package name */
    private static final n0 f46205e;

    /* renamed from: f, reason: collision with root package name */
    private static final n0 f46206f;

    /* renamed from: g, reason: collision with root package name */
    private static final LinkedHashMap f46207g;

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicBoolean f46208h;

    /* renamed from: i, reason: collision with root package name */
    private static String f46209i;

    /* renamed from: j, reason: collision with root package name */
    private static d f46210j;

    /* renamed from: k, reason: collision with root package name */
    private static final List f46211k;

    /* loaded from: classes5.dex */
    public static final class a implements d {
        a() {
        }

        @Override // com.transsion.lib_web.download_render.d
        public void a(String url) {
            Intrinsics.h(url, "url");
            FileDownloadTaskManager.f46209i = url;
        }

        @Override // com.transsion.lib_web.download_render.d
        public void b() {
            FileDownloadTaskManager.f46209i = null;
        }
    }

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.g(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        f46205e = o0.a(m1.c(newSingleThreadExecutor));
        f46206f = o0.a(y0.b());
        f46207g = new LinkedHashMap();
        f46208h = new AtomicBoolean(false);
        f46210j = new a();
        f46211k = new ArrayList();
    }

    private FileDownloadTaskManager() {
    }

    private final void k() {
        i iVar = i.f64006a;
        AtomicBoolean atomicBoolean = f46208h;
        iVar.a("DR_FileDownloadTaskManager", "<startDownloadExecution> isDownloadRunning value: " + atomicBoolean.get() + ", if value is true -> can't load download");
        if (atomicBoolean.compareAndSet(false, true)) {
            k.d(f46206f, null, null, new FileDownloadTaskManager$startDownloadExecution$1(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b4 A[Catch: all -> 0x00e3, LOOP:5: B:102:0x02ae->B:104:0x02b4, LOOP_END, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080 A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0158 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018c A[Catch: all -> 0x00e3, TRY_ENTER, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0224 A[Catch: all -> 0x00e3, LOOP:4: B:97:0x021e->B:99:0x0224, LOOP_END, TryCatch #0 {all -> 0x00e3, blocks: (B:11:0x0063, B:12:0x007a, B:14:0x0080, B:17:0x0090, B:18:0x00ac, B:20:0x00b2, B:22:0x00de, B:27:0x00ef, B:29:0x00f9, B:33:0x0103, B:35:0x010d, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:41:0x0130, B:53:0x0145, B:54:0x0152, B:56:0x0158, B:59:0x0172, B:64:0x017a, B:65:0x017e, B:68:0x018c, B:70:0x01a6, B:72:0x01b2, B:74:0x01b8, B:76:0x01c0, B:78:0x01c6, B:80:0x01ce, B:82:0x01d4, B:84:0x01dc, B:86:0x01e2, B:88:0x01e8, B:96:0x021a, B:97:0x021e, B:99:0x0224, B:101:0x0291, B:102:0x02ae, B:104:0x02b4, B:106:0x02cd), top: B:10:0x0063 }] */
    /* JADX WARN: Type inference failed for: r2v19, types: [T, jm.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.util.List r22, kotlin.coroutines.Continuation r23) {
        /*
            Method dump skipped, instructions count: 733
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.lib_web.download_render.FileDownloadTaskManager.m(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void g(List list) {
        t1 d11;
        if (!f46202b.get()) {
            i.f64006a.b("DR_FileDownloadTaskManager", "<executeTask> fail, plz init first");
            return;
        }
        if (list != null) {
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null) {
                d11 = k.d(f46205e, null, null, new FileDownloadTaskManager$executeTask$2$1(list, null), 3, null);
                if (d11 != null) {
                    return;
                }
            }
        }
        i.f64006a.f("DR_FileDownloadTaskManager", "<executeTask> fail: h5Pages is null or empty");
        Unit unit = Unit.f67184a;
    }

    public final d h() {
        return f46210j;
    }

    public final String i() {
        return f46209i;
    }

    public final void j(Application context, boolean z10, boolean z11, boolean z12, j api, String path) {
        Intrinsics.h(context, "context");
        Intrinsics.h(api, "api");
        Intrinsics.h(path, "path");
        if (z11) {
            c.a.g(mg.c.f69683a, context, LogType.TYPE_LOGCAT, z12, null, 0L, 24, null);
        }
        if (!f46202b.compareAndSet(false, true)) {
            i.f64006a.f("DR_FileDownloadTaskManager", "<init> already done");
        } else {
            i.f64006a.a("DR_FileDownloadTaskManager", "<init> start");
            k.d(f46205e, null, null, new FileDownloadTaskManager$init$1(path, context, z10, api, null), 3, null);
        }
    }

    public final void l() {
        new com.transsion.lib_web.download_render.init.b().invoke();
    }
}
