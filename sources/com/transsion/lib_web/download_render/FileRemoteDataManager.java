package com.transsion.lib_web.download_render;

import com.tencent.mmkv.MMKV;
import com.transsion.lib_web.download_render.timer.SyncDataTimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;

/* loaded from: classes5.dex */
public final class FileRemoteDataManager {

    /* renamed from: a, reason: collision with root package name */
    public static final FileRemoteDataManager f46212a = new FileRemoteDataManager();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f46213b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private static final nm.b f46214c = new nm.b();

    /* renamed from: d, reason: collision with root package name */
    private static final SyncDataTimerTask f46215d = new SyncDataTimerTask();

    /* renamed from: e, reason: collision with root package name */
    private static final n0 f46216e;

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f46217f;

    /* renamed from: g, reason: collision with root package name */
    private static final Lazy f46218g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f46219h;

    /* renamed from: i, reason: collision with root package name */
    private static String f46220i;

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.g(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        f46216e = o0.a(m1.c(newSingleThreadExecutor));
        f46217f = LazyKt.b(new Function0() { // from class: com.transsion.lib_web.download_render.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                g f11;
                f11 = FileRemoteDataManager.f();
                return f11;
            }
        });
        f46218g = LazyKt.b(new Function0() { // from class: com.transsion.lib_web.download_render.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MMKV j11;
                j11 = FileRemoteDataManager.j();
                return j11;
            }
        });
        f46219h = "requestTime";
        f46220i = "wefeed-mobile-bff";
    }

    private FileRemoteDataManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g f() {
        return (g) zg.c.f79537e.a().h(g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g g() {
        return (g) f46217f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MMKV h() {
        Object value = f46218g.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (MMKV) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV j() {
        return MMKV.I("web_file_download_with_render_request");
    }

    public final String i() {
        return f46220i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        if (r8 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            r9 = this;
            com.tencent.mmkv.MMKV r0 = r9.h()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = com.transsion.lib_web.download_render.FileRemoteDataManager.f46219h     // Catch: java.lang.Throwable -> L69
            r2 = 0
            long r0 = r0.getLong(r1, r2)     // Catch: java.lang.Throwable -> L69
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L69
            long r2 = r2 - r0
            r0 = 3600000(0x36ee80, double:1.7786363E-317)
            sm.f$a r4 = sm.f.f75530c     // Catch: java.lang.Throwable -> L62
            sm.f r4 = r4.a()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "dr_config"
            r6 = 0
            r7 = 2
            r8 = 0
            com.transsion.mb.config.manager.ConfigBean r4 = sm.f.d(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L34
            java.lang.String r4 = r4.getValue()     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L34
            boolean r5 = kotlin.text.StringsKt.q0(r4)     // Catch: java.lang.Throwable -> L62
            if (r5 != 0) goto L32
            r8 = r4
        L32:
            if (r8 != 0) goto L36
        L34:
            java.lang.String r8 = "{}"
        L36:
            java.lang.Class<com.transsion.lib_web.download_render.data.config.ConfigData> r4 = com.transsion.lib_web.download_render.data.config.ConfigData.class
            java.lang.Object r4 = com.blankj.utilcode.util.o.d(r8, r4)     // Catch: java.lang.Throwable -> L62
            com.transsion.lib_web.download_render.data.config.ConfigData r4 = (com.transsion.lib_web.download_render.data.config.ConfigData) r4     // Catch: java.lang.Throwable -> L62
            long r0 = r4.getRequestMinInterval()     // Catch: java.lang.Throwable -> L62
            gm.i r4 = gm.i.f64006a     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "DR_Config"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r6.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = "config:"
            r6.append(r7)     // Catch: java.lang.Throwable -> L62
            r6.append(r8)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = ", intervalTime:"
            r6.append(r7)     // Catch: java.lang.Throwable -> L62
            r6.append(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L62
            r4.a(r5, r6)     // Catch: java.lang.Throwable -> L62
        L62:
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L69
            r9.m()     // Catch: java.lang.Throwable -> L69
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.lib_web.download_render.FileRemoteDataManager.k():void");
    }

    public final void l(String str) {
        Intrinsics.h(str, "<set-?>");
        f46220i = str;
    }

    public final void m() {
        k.d(f46216e, null, null, new FileRemoteDataManager$syncData$1(null), 3, null);
    }
}
