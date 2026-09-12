package com.cloud.h5update.download;

import android.content.Context;
import com.cloud.h5update.bean.DownloadEntity;
import com.cloud.h5update.utils.l;
import java.io.File;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class DownloadManager {

    /* renamed from: g */
    public static final a f21350g = new a(null);

    /* renamed from: h */
    private static final Lazy f21351h = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<DownloadManager>() { // from class: com.cloud.h5update.download.DownloadManager$Companion$instance$2
        @Override // kotlin.jvm.functions.Function0
        public final DownloadManager invoke() {
            return new DownloadManager(null);
        }
    });

    /* renamed from: a */
    private int f21352a;

    /* renamed from: b */
    private LinkedBlockingDeque f21353b;

    /* renamed from: c */
    private ThreadPoolExecutor f21354c;

    /* renamed from: d */
    private Map f21355d;

    /* renamed from: e */
    private OkHttpClient f21356e;

    /* renamed from: f */
    private Context f21357f;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadManager a() {
            return (DownloadManager) DownloadManager.f21351h.getValue();
        }
    }

    private DownloadManager() {
        this.f21352a = 1;
    }

    public /* synthetic */ DownloadManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void c(DownloadManager downloadManager, DownloadTask downloadTask, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        downloadManager.b(downloadTask, z10);
    }

    private final int e() {
        return (Runtime.getRuntime().availableProcessors() * 2) + 1;
    }

    private final OkHttpClient g() {
        OkHttpClient build = new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).build();
        Intrinsics.g(build, "Builder().connectTimeout…TimeUnit.SECONDS).build()");
        return build;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0009, code lost:
    
        if (r9 <= 15) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void j(android.content.Context r8, int r9, okhttp3.OkHttpClient r10) {
        /*
            r7 = this;
            r7.f21357f = r8
            r8 = 1
            if (r9 >= r8) goto L7
        L5:
            r9 = r8
            goto Lb
        L7:
            r8 = 15
            if (r9 > r8) goto L5
        Lb:
            r7.f21352a = r9
            java.util.concurrent.ThreadPoolExecutor r8 = new java.util.concurrent.ThreadPoolExecutor
            int r2 = r7.f21352a
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingDeque r6 = new java.util.concurrent.LinkedBlockingDeque
            r6.<init>()
            r3 = 20
            r0 = r8
            r1 = r2
            r0.<init>(r1, r2, r3, r5, r6)
            r7.f21354c = r8
            kotlin.jvm.internal.Intrinsics.e(r8)
            java.util.concurrent.BlockingQueue r8 = r8.getQueue()
            if (r8 == 0) goto L38
            java.util.concurrent.LinkedBlockingDeque r8 = (java.util.concurrent.LinkedBlockingDeque) r8
            r7.f21353b = r8
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r8.<init>()
            r7.f21355d = r8
            r7.f21356e = r10
            return
        L38:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type java.util.concurrent.LinkedBlockingDeque<java.lang.Runnable>"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.h5update.download.DownloadManager.j(android.content.Context, int, okhttp3.OkHttpClient):void");
    }

    public static /* synthetic */ void k(DownloadManager downloadManager, Context context, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = downloadManager.e();
        }
        downloadManager.i(context, i11);
    }

    public final void b(DownloadTask task, boolean z10) {
        String taskId;
        Map map;
        Intrinsics.h(task, "task");
        if (!z10 && (map = this.f21355d) != null) {
            DownloadEntity downloadEntity = task.getDownloadEntity();
            if (map.containsKey(downloadEntity != null ? downloadEntity.getTaskId() : null)) {
                return;
            }
        }
        DownloadEntity downloadEntity2 = task.getDownloadEntity();
        if (downloadEntity2 == null || (taskId = downloadEntity2.getTaskId()) == null || !(!StringsKt.q0(taskId))) {
            return;
        }
        task.setClient(this.f21356e);
        Map map2 = this.f21355d;
        Intrinsics.e(map2);
        String taskId2 = downloadEntity2.getTaskId();
        Intrinsics.e(taskId2);
        map2.put(taskId2, task);
        LinkedBlockingDeque linkedBlockingDeque = this.f21353b;
        Intrinsics.e(linkedBlockingDeque);
        if (linkedBlockingDeque.contains(task)) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = this.f21354c;
        Intrinsics.e(threadPoolExecutor);
        threadPoolExecutor.execute(task);
    }

    public final void d(String str) {
        Map map;
        if (str == null || StringsKt.q0(str) || (map = this.f21355d) == null || map == null) {
            return;
        }
    }

    public final ThreadPoolExecutor f() {
        return this.f21354c;
    }

    public final DownloadTask h(String str) {
        Map map;
        DownloadEntity h11;
        if (str == null || StringsKt.q0(str) || (map = this.f21355d) == null) {
            return null;
        }
        Intrinsics.e(map);
        DownloadTask downloadTask = (DownloadTask) map.get(str);
        return (downloadTask != null || (h11 = l.f21391a.h(str)) == null) ? downloadTask : new DownloadTask(h11);
    }

    public final void i(Context context, int i11) {
        Intrinsics.h(context, "context");
        j(context, i11, g());
    }

    public final boolean l(String str) {
        DownloadEntity h11 = l.f21391a.h(str);
        if (h11 == null) {
            return false;
        }
        String filePath = h11.getFilePath();
        String fileName = h11.getFileName();
        if (fileName == null) {
            fileName = "";
        }
        File file = new File(filePath, fileName);
        return file.exists() && file.length() == h11.getTotalSize();
    }

    public final void m(DownloadTask task) {
        Intrinsics.h(task, "task");
        c(this, task, false, 2, null);
    }
}
