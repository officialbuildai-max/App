package com.transsion.player.shorttv.preload;

import android.content.Context;
import android.util.Log;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.scheduler.Requirements;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: g, reason: collision with root package name */
    public static final a f48578g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Context f48579a;

    /* renamed from: b, reason: collision with root package name */
    private final List f48580b;

    /* renamed from: c, reason: collision with root package name */
    private int f48581c;

    /* renamed from: d, reason: collision with root package name */
    private String f48582d;

    /* renamed from: e, reason: collision with root package name */
    private final b f48583e;

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap f48584f;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements DownloadManager.d {
        b() {
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void a(DownloadManager downloadManager, boolean z10) {
            Intrinsics.h(downloadManager, "downloadManager");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c download) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(download, "download");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void c(DownloadManager downloadManager, boolean z10) {
            Intrinsics.h(downloadManager, "downloadManager");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void d(DownloadManager downloadManager) {
            Intrinsics.h(downloadManager, "downloadManager");
            Log.e("VideoPreloadHelper", "onIdle:");
            g.this.m();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void e(DownloadManager downloadManager, Requirements requirements, int i11) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(requirements, "requirements");
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c download, Exception exc) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(download, "download");
            Log.e("VideoPreloadHelper", "onDownloadChanged:  download.requestId:" + download.f12495a.f12425id + "     bytesDownloaded:" + download.a() + "  contentLength:" + download.f12499e + "  percentDownloaded:" + download.b());
            com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) g.this.f48584f.get(download.f12495a.f12425id);
            if (aVar != null) {
                aVar.h(download.a());
                aVar.g(download.f12499e);
            }
            if (Intrinsics.c(download.f12495a.f12425id, g.this.f48582d)) {
                int i11 = download.f12496b;
                if (i11 == 1 || i11 == 3 || i11 == 4) {
                    g.this.f48582d = null;
                    g.this.m();
                }
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void g(DownloadManager downloadManager) {
            Intrinsics.h(downloadManager, "downloadManager");
        }
    }

    public g(Context context) {
        Intrinsics.h(context, "context");
        this.f48579a = context;
        this.f48580b = new CopyOnWriteArrayList();
        b bVar = new b();
        this.f48583e = bVar;
        this.f48584f = new ConcurrentHashMap();
        co.a.h(context).d(bVar);
    }

    private final void i(int i11) {
        ao.e eVar;
        if (i11 < 0 || i11 >= this.f48580b.size() || (eVar = (ao.e) this.f48580b.get(i11)) == null) {
            return;
        }
        Log.e("VideoPreloadHelper", "checkToPause   position:" + i11 + "  shortTVItem:" + eVar);
        q.f48593a.D(eVar.g());
    }

    private final void j(int i11) {
        final ao.e eVar;
        if (i11 < 0 || i11 >= this.f48580b.size() || (eVar = (ao.e) this.f48580b.get(i11)) == null) {
            return;
        }
        q.f48593a.z(new Runnable() { // from class: com.transsion.player.shorttv.preload.f
            @Override // java.lang.Runnable
            public final void run() {
                g.k(ao.e.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ao.e eVar, g gVar) {
        gVar.f48584f.put(eVar.g(), q.f48593a.w(eVar));
    }

    private final com.transsion.player.shorttv.preload.a l(int i11, ao.e eVar) {
        com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) this.f48584f.get(eVar.g());
        if (aVar != null) {
            Log.e("VideoPreloadHelper", "createDownloadRequest [from map] position:" + i11 + "  shortTVItem:" + eVar);
            return aVar;
        }
        String g11 = eVar.g();
        com.transsion.player.shorttv.preload.a n11 = q.f48593a.n(eVar);
        this.f48584f.put(g11, n11);
        Log.e("VideoPreloadHelper", "createDownloadRequest [from new] position:" + i11 + "  shortTVItem:" + eVar);
        return n11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(g gVar, int i11) {
        int size = gVar.f48580b.size();
        Log.e("VideoPreloadHelper", "loadNext， position:" + i11 + "   size:" + size);
        int i12 = RangesKt.i(i11 + 6, size);
        for (int i13 = i11 + 1; i13 < i12; i13++) {
            ao.e eVar = (ao.e) gVar.f48580b.get(i13);
            if (eVar != null) {
                com.transsion.player.shorttv.preload.a l11 = gVar.l(i13, eVar);
                l11.i(307200L);
                if (l11.b() < l11.d()) {
                    Log.e("VideoPreloadHelper", "非当前选中  下载大小 downloadLength:" + l11.b() + "  index:" + i13);
                    gVar.f48582d = l11.c();
                    q.f48593a.s(l11);
                    return;
                }
                l11.b();
                l11.a();
                Log.e("VideoPreloadHelper", "非当前选中  下载大小 downloadLength:" + l11.b() + " 大于最小下载，跳过 index:" + i13);
            }
        }
        Log.e("VideoPreloadHelper", "不用全量下载");
    }

    public final void f(int i11, ao.e mediaSource) {
        Intrinsics.h(mediaSource, "mediaSource");
        if (i11 <= this.f48580b.size()) {
            this.f48580b.add(i11, mediaSource);
        }
        m();
    }

    public final void g(ao.e mediaSource) {
        Intrinsics.h(mediaSource, "mediaSource");
        this.f48580b.add(mediaSource);
        m();
    }

    public final void h(int i11) {
        Log.e("VideoPreloadHelper", "changeSelect  position:" + i11);
        if (this.f48581c == i11) {
            return;
        }
        this.f48582d = null;
        this.f48581c = i11;
        i(i11);
        j(this.f48581c + 1);
    }

    public final void m() {
        final int i11 = this.f48581c;
        if (i11 >= 0 && this.f48582d == null) {
            q.f48593a.z(new Runnable() { // from class: com.transsion.player.shorttv.preload.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.n(g.this, i11);
                }
            });
        }
    }

    public final void o() {
        i(this.f48581c);
        this.f48581c = -1;
    }

    public final void p() {
        co.a.h(this.f48579a).w(this.f48583e);
        o();
    }

    public final void q(String key) {
        Intrinsics.h(key, "key");
        this.f48584f.remove(key);
        q.f48593a.x(key);
    }
}
