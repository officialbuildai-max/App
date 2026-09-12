package androidx.media3.exoplayer.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.u;
import androidx.media3.exoplayer.offline.o;
import androidx.media3.exoplayer.scheduler.Requirements;
import f2.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class DownloadManager {

    /* renamed from: q */
    public static final Requirements f12391q = new Requirements(1);

    /* renamed from: a */
    private final Context f12392a;

    /* renamed from: b */
    private final t f12393b;

    /* renamed from: c */
    private final Handler f12394c;

    /* renamed from: d */
    private final c f12395d;

    /* renamed from: e */
    private final c.InterfaceC0778c f12396e;

    /* renamed from: g */
    private int f12398g;

    /* renamed from: h */
    private int f12399h;

    /* renamed from: i */
    private boolean f12400i;

    /* renamed from: m */
    private int f12404m;

    /* renamed from: n */
    private boolean f12405n;

    /* renamed from: p */
    private f2.c f12407p;

    /* renamed from: k */
    private int f12402k = 3;

    /* renamed from: l */
    private int f12403l = 5;

    /* renamed from: j */
    private boolean f12401j = true;

    /* renamed from: o */
    private List f12406o = Collections.emptyList();

    /* renamed from: f */
    private final CopyOnWriteArraySet f12397f = new CopyOnWriteArraySet();

    /* loaded from: classes2.dex */
    public static class Task extends Thread implements o.a {
        private long contentLength;
        private final l downloadProgress;
        private final o downloader;

        @Nullable
        private Exception finalException;

        @Nullable
        private volatile c internalHandler;
        private volatile boolean isCanceled;
        private final boolean isRemove;
        private final int minRetryCount;
        private final DownloadRequest request;

        private Task(DownloadRequest downloadRequest, o oVar, l lVar, boolean z10, int i11, c cVar) {
            this.request = downloadRequest;
            this.downloader = oVar;
            this.downloadProgress = lVar;
            this.isRemove = z10;
            this.minRetryCount = i11;
            this.internalHandler = cVar;
            this.contentLength = -1L;
        }

        /* synthetic */ Task(DownloadRequest downloadRequest, o oVar, l lVar, boolean z10, int i11, c cVar, a aVar) {
            this(downloadRequest, oVar, lVar, z10, i11, cVar);
        }

        private static int getRetryDelayMillis(int i11) {
            return Math.min((i11 - 1) * 1000, 5000);
        }

        public void cancel(boolean z10) {
            if (z10) {
                this.internalHandler = null;
            }
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            this.downloader.cancel();
            interrupt();
        }

        @Override // androidx.media3.exoplayer.offline.o.a
        public void onProgress(long j11, long j12, float f11) {
            this.downloadProgress.f12506a = j12;
            this.downloadProgress.f12507b = f11;
            if (j11 != this.contentLength) {
                this.contentLength = j11;
                c cVar = this.internalHandler;
                if (cVar != null) {
                    cVar.obtainMessage(11, (int) (j11 >> 32), (int) j11, this).sendToTarget();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.isRemove) {
                    this.downloader.remove();
                } else {
                    long j11 = -1;
                    int i11 = 0;
                    while (!this.isCanceled) {
                        try {
                            this.downloader.a(this);
                            break;
                        } catch (IOException e11) {
                            if (!this.isCanceled) {
                                long j12 = this.downloadProgress.f12506a;
                                if (j12 != j11) {
                                    i11 = 0;
                                    j11 = j12;
                                }
                                i11++;
                                if (i11 > this.minRetryCount) {
                                    throw e11;
                                }
                                Thread.sleep(getRetryDelayMillis(i11));
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e12) {
                this.finalException = e12;
            }
            c cVar = this.internalHandler;
            if (cVar != null) {
                cVar.obtainMessage(10, this).sendToTarget();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a */
        public final androidx.media3.exoplayer.offline.c f12408a;

        /* renamed from: b */
        public final boolean f12409b;

        /* renamed from: c */
        public final List f12410c;

        /* renamed from: d */
        public final Exception f12411d;

        public b(androidx.media3.exoplayer.offline.c cVar, boolean z10, List list, Exception exc) {
            this.f12408a = cVar;
            this.f12409b = z10;
            this.f12410c = list;
            this.f12411d = exc;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends Handler {

        /* renamed from: a */
        public boolean f12412a;

        /* renamed from: b */
        private final HandlerThread f12413b;

        /* renamed from: c */
        private final t f12414c;

        /* renamed from: d */
        private final p f12415d;

        /* renamed from: e */
        private final Handler f12416e;

        /* renamed from: f */
        private final ArrayList f12417f;

        /* renamed from: g */
        private final HashMap f12418g;

        /* renamed from: h */
        private int f12419h;

        /* renamed from: i */
        private boolean f12420i;

        /* renamed from: j */
        private int f12421j;

        /* renamed from: k */
        private int f12422k;

        /* renamed from: l */
        private int f12423l;

        /* renamed from: m */
        private boolean f12424m;

        public c(HandlerThread handlerThread, t tVar, p pVar, Handler handler, int i11, int i12, boolean z10) {
            super(handlerThread.getLooper());
            this.f12413b = handlerThread;
            this.f12414c = tVar;
            this.f12415d = pVar;
            this.f12416e = handler;
            this.f12421j = i11;
            this.f12422k = i12;
            this.f12420i = z10;
            this.f12417f = new ArrayList();
            this.f12418g = new HashMap();
        }

        private void A(Task task) {
            if (task != null) {
                androidx.media3.common.util.a.g(!task.isRemove);
                task.cancel(false);
            }
        }

        private void B() {
            int i11 = 0;
            for (int i12 = 0; i12 < this.f12417f.size(); i12++) {
                androidx.media3.exoplayer.offline.c cVar = (androidx.media3.exoplayer.offline.c) this.f12417f.get(i12);
                Task task = (Task) this.f12418g.get(cVar.f12495a.f12425id);
                int i13 = cVar.f12496b;
                if (i13 == 0) {
                    task = y(task, cVar);
                } else if (i13 == 1) {
                    A(task);
                } else if (i13 == 2) {
                    androidx.media3.common.util.a.e(task);
                    x(task, cVar, i11);
                } else {
                    if (i13 != 5 && i13 != 7) {
                        throw new IllegalStateException();
                    }
                    z(task, cVar);
                }
                if (task != null && !task.isRemove) {
                    i11++;
                }
            }
        }

        private void C() {
            for (int i11 = 0; i11 < this.f12417f.size(); i11++) {
                androidx.media3.exoplayer.offline.c cVar = (androidx.media3.exoplayer.offline.c) this.f12417f.get(i11);
                if (cVar.f12496b == 2) {
                    try {
                        this.f12414c.b(cVar);
                    } catch (IOException e11) {
                        u.d("DownloadManager", "Failed to update index.", e11);
                    }
                }
            }
            sendEmptyMessageDelayed(12, 5000L);
        }

        private void b(DownloadRequest downloadRequest, int i11) {
            androidx.media3.exoplayer.offline.c f11 = f(downloadRequest.f12425id, true);
            long currentTimeMillis = System.currentTimeMillis();
            if (f11 != null) {
                m(DownloadManager.n(f11, downloadRequest, i11, currentTimeMillis));
            } else {
                m(new androidx.media3.exoplayer.offline.c(downloadRequest, i11 == 0 ? 0 : 1, currentTimeMillis, currentTimeMillis, -1L, i11, 0));
            }
            B();
        }

        private boolean c() {
            return !this.f12420i && this.f12419h == 0;
        }

        public static int d(androidx.media3.exoplayer.offline.c cVar, androidx.media3.exoplayer.offline.c cVar2) {
            return a1.n(cVar.f12497c, cVar2.f12497c);
        }

        private static androidx.media3.exoplayer.offline.c e(androidx.media3.exoplayer.offline.c cVar, int i11, int i12) {
            return new androidx.media3.exoplayer.offline.c(cVar.f12495a, i11, cVar.f12497c, System.currentTimeMillis(), cVar.f12499e, i12, 0, cVar.f12502h);
        }

        private androidx.media3.exoplayer.offline.c f(String str, boolean z10) {
            int g11 = g(str);
            if (g11 != -1) {
                return (androidx.media3.exoplayer.offline.c) this.f12417f.get(g11);
            }
            if (!z10) {
                return null;
            }
            try {
                return this.f12414c.h(str);
            } catch (IOException e11) {
                u.d("DownloadManager", "Failed to load download: " + str, e11);
                return null;
            }
        }

        private int g(String str) {
            for (int i11 = 0; i11 < this.f12417f.size(); i11++) {
                if (((androidx.media3.exoplayer.offline.c) this.f12417f.get(i11)).f12495a.f12425id.equals(str)) {
                    return i11;
                }
            }
            return -1;
        }

        private void h(int i11) {
            this.f12419h = i11;
            e eVar = null;
            try {
                try {
                    this.f12414c.g();
                    eVar = this.f12414c.e(0, 1, 2, 5, 7);
                    while (eVar.moveToNext()) {
                        this.f12417f.add(eVar.N());
                    }
                } catch (IOException e11) {
                    u.d("DownloadManager", "Failed to load index.", e11);
                    this.f12417f.clear();
                }
                this.f12416e.obtainMessage(1, new ArrayList(this.f12417f)).sendToTarget();
                B();
            } finally {
                a1.m(eVar);
            }
        }

        private void i(Task task, long j11) {
            androidx.media3.exoplayer.offline.c cVar = (androidx.media3.exoplayer.offline.c) androidx.media3.common.util.a.e(f(task.request.f12425id, false));
            if (j11 == cVar.f12499e || j11 == -1) {
                return;
            }
            m(new androidx.media3.exoplayer.offline.c(cVar.f12495a, cVar.f12496b, cVar.f12497c, System.currentTimeMillis(), j11, cVar.f12500f, cVar.f12501g, cVar.f12502h));
        }

        private void j(androidx.media3.exoplayer.offline.c cVar, Exception exc) {
            androidx.media3.exoplayer.offline.c cVar2 = new androidx.media3.exoplayer.offline.c(cVar.f12495a, exc == null ? 3 : 4, cVar.f12497c, System.currentTimeMillis(), cVar.f12499e, cVar.f12500f, exc == null ? 0 : 1, cVar.f12502h);
            this.f12417f.remove(g(cVar2.f12495a.f12425id));
            try {
                this.f12414c.b(cVar2);
            } catch (IOException e11) {
                u.d("DownloadManager", "Failed to update index.", e11);
            }
            this.f12416e.obtainMessage(3, new b(cVar2, false, new ArrayList(this.f12417f), exc)).sendToTarget();
        }

        private void k(androidx.media3.exoplayer.offline.c cVar) {
            if (cVar.f12496b == 7) {
                int i11 = cVar.f12500f;
                n(cVar, i11 == 0 ? 0 : 1, i11);
                B();
            } else {
                this.f12417f.remove(g(cVar.f12495a.f12425id));
                try {
                    this.f12414c.c(cVar.f12495a.f12425id);
                } catch (IOException unused) {
                    u.c("DownloadManager", "Failed to remove from database");
                }
                this.f12416e.obtainMessage(3, new b(cVar, true, new ArrayList(this.f12417f), null)).sendToTarget();
            }
        }

        private void l(Task task) {
            String str = task.request.f12425id;
            this.f12418g.remove(str);
            boolean z10 = task.isRemove;
            if (z10) {
                this.f12424m = false;
            } else {
                int i11 = this.f12423l - 1;
                this.f12423l = i11;
                if (i11 == 0) {
                    removeMessages(12);
                }
            }
            if (task.isCanceled) {
                B();
                return;
            }
            Exception exc = task.finalException;
            if (exc != null) {
                u.d("DownloadManager", "Task failed: " + task.request + ", " + z10, exc);
            }
            androidx.media3.exoplayer.offline.c cVar = (androidx.media3.exoplayer.offline.c) androidx.media3.common.util.a.e(f(str, false));
            int i12 = cVar.f12496b;
            if (i12 == 2) {
                androidx.media3.common.util.a.g(!z10);
                j(cVar, exc);
            } else {
                if (i12 != 5 && i12 != 7) {
                    throw new IllegalStateException();
                }
                androidx.media3.common.util.a.g(z10);
                k(cVar);
            }
            B();
        }

        private androidx.media3.exoplayer.offline.c m(androidx.media3.exoplayer.offline.c cVar) {
            int i11 = cVar.f12496b;
            androidx.media3.common.util.a.g((i11 == 3 || i11 == 4) ? false : true);
            int g11 = g(cVar.f12495a.f12425id);
            if (g11 == -1) {
                this.f12417f.add(cVar);
                Collections.sort(this.f12417f, new i());
            } else {
                boolean z10 = cVar.f12497c != ((androidx.media3.exoplayer.offline.c) this.f12417f.get(g11)).f12497c;
                this.f12417f.set(g11, cVar);
                if (z10) {
                    Collections.sort(this.f12417f, new i());
                }
            }
            try {
                this.f12414c.b(cVar);
            } catch (IOException e11) {
                u.d("DownloadManager", "Failed to update index.", e11);
            }
            this.f12416e.obtainMessage(3, new b(cVar, false, new ArrayList(this.f12417f), null)).sendToTarget();
            return cVar;
        }

        private androidx.media3.exoplayer.offline.c n(androidx.media3.exoplayer.offline.c cVar, int i11, int i12) {
            androidx.media3.common.util.a.g((i11 == 3 || i11 == 4) ? false : true);
            return m(e(cVar, i11, i12));
        }

        private void o() {
            Iterator it = this.f12418g.values().iterator();
            while (it.hasNext()) {
                ((Task) it.next()).cancel(true);
            }
            try {
                this.f12414c.g();
            } catch (IOException e11) {
                u.d("DownloadManager", "Failed to update index.", e11);
            }
            this.f12417f.clear();
            this.f12413b.quit();
            synchronized (this) {
                this.f12412a = true;
                notifyAll();
            }
        }

        private void p() {
            ArrayList arrayList = new ArrayList();
            try {
                e e11 = this.f12414c.e(3, 4);
                while (e11.moveToNext()) {
                    try {
                        arrayList.add(e11.N());
                    } finally {
                    }
                }
                e11.close();
            } catch (IOException unused) {
                u.c("DownloadManager", "Failed to load downloads.");
            }
            for (int i11 = 0; i11 < this.f12417f.size(); i11++) {
                ArrayList arrayList2 = this.f12417f;
                arrayList2.set(i11, e((androidx.media3.exoplayer.offline.c) arrayList2.get(i11), 5, 0));
            }
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                this.f12417f.add(e((androidx.media3.exoplayer.offline.c) arrayList.get(i12), 5, 0));
            }
            Collections.sort(this.f12417f, new i());
            try {
                this.f12414c.f();
            } catch (IOException e12) {
                u.d("DownloadManager", "Failed to update index.", e12);
            }
            ArrayList arrayList3 = new ArrayList(this.f12417f);
            for (int i13 = 0; i13 < this.f12417f.size(); i13++) {
                this.f12416e.obtainMessage(3, new b((androidx.media3.exoplayer.offline.c) this.f12417f.get(i13), false, arrayList3, null)).sendToTarget();
            }
            B();
        }

        private void q(String str) {
            androidx.media3.exoplayer.offline.c f11 = f(str, true);
            if (f11 != null) {
                n(f11, 5, 0);
                B();
            } else {
                u.c("DownloadManager", "Failed to remove nonexistent download: " + str);
            }
        }

        private void r(boolean z10) {
            this.f12420i = z10;
            B();
        }

        private void s(int i11) {
            this.f12421j = i11;
            B();
        }

        private void t(int i11) {
            this.f12422k = i11;
        }

        private void u(int i11) {
            this.f12419h = i11;
            B();
        }

        private void v(androidx.media3.exoplayer.offline.c cVar, int i11) {
            if (i11 == 0) {
                if (cVar.f12496b == 1) {
                    n(cVar, 0, 0);
                }
            } else if (i11 != cVar.f12500f) {
                int i12 = cVar.f12496b;
                if (i12 == 0 || i12 == 2) {
                    i12 = 1;
                }
                m(new androidx.media3.exoplayer.offline.c(cVar.f12495a, i12, cVar.f12497c, System.currentTimeMillis(), cVar.f12499e, i11, 0, cVar.f12502h));
            }
        }

        private void w(String str, int i11) {
            if (str == null) {
                for (int i12 = 0; i12 < this.f12417f.size(); i12++) {
                    v((androidx.media3.exoplayer.offline.c) this.f12417f.get(i12), i11);
                }
                try {
                    this.f12414c.d(i11);
                } catch (IOException e11) {
                    u.d("DownloadManager", "Failed to set manual stop reason", e11);
                }
            } else {
                androidx.media3.exoplayer.offline.c f11 = f(str, false);
                if (f11 != null) {
                    v(f11, i11);
                } else {
                    try {
                        this.f12414c.a(str, i11);
                    } catch (IOException e12) {
                        u.d("DownloadManager", "Failed to set manual stop reason: " + str, e12);
                    }
                }
            }
            B();
        }

        private void x(Task task, androidx.media3.exoplayer.offline.c cVar, int i11) {
            androidx.media3.common.util.a.g(!task.isRemove);
            if (!c() || i11 >= this.f12421j) {
                n(cVar, 0, 0);
                task.cancel(false);
            }
        }

        private Task y(Task task, androidx.media3.exoplayer.offline.c cVar) {
            if (task != null) {
                androidx.media3.common.util.a.g(!task.isRemove);
                task.cancel(false);
                return task;
            }
            if (!c() || this.f12423l >= this.f12421j) {
                return null;
            }
            androidx.media3.exoplayer.offline.c n11 = n(cVar, 2, 0);
            Task task2 = new Task(n11.f12495a, this.f12415d.a(n11.f12495a), n11.f12502h, false, this.f12422k, this);
            this.f12418g.put(n11.f12495a.f12425id, task2);
            int i11 = this.f12423l;
            this.f12423l = i11 + 1;
            if (i11 == 0) {
                sendEmptyMessageDelayed(12, 5000L);
            }
            task2.start();
            return task2;
        }

        private void z(Task task, androidx.media3.exoplayer.offline.c cVar) {
            if (task != null) {
                if (task.isRemove) {
                    return;
                }
                task.cancel(false);
            } else {
                if (this.f12424m) {
                    return;
                }
                Task task2 = new Task(cVar.f12495a, this.f12415d.a(cVar.f12495a), cVar.f12502h, true, this.f12422k, this);
                this.f12418g.put(cVar.f12495a.f12425id, task2);
                this.f12424m = true;
                task2.start();
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i11 = 0;
            switch (message.what) {
                case 1:
                    h(message.arg1);
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 2:
                    r(message.arg1 != 0);
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 3:
                    u(message.arg1);
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 4:
                    w((String) message.obj, message.arg1);
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 5:
                    s(message.arg1);
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 6:
                    t(message.arg1);
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 7:
                    b((DownloadRequest) message.obj, message.arg1);
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 8:
                    q((String) message.obj);
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 9:
                    p();
                    i11 = 1;
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 10:
                    l((Task) message.obj);
                    this.f12416e.obtainMessage(2, i11, this.f12418g.size()).sendToTarget();
                    return;
                case 11:
                    i((Task) message.obj, a1.v1(message.arg1, message.arg2));
                    return;
                case 12:
                    C();
                    return;
                case 13:
                    o();
                    return;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(DownloadManager downloadManager, boolean z10);

        void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar);

        void c(DownloadManager downloadManager, boolean z10);

        void d(DownloadManager downloadManager);

        void e(DownloadManager downloadManager, Requirements requirements, int i11);

        void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar, Exception exc);

        void g(DownloadManager downloadManager);
    }

    public DownloadManager(Context context, t tVar, p pVar) {
        this.f12392a = context.getApplicationContext();
        this.f12393b = tVar;
        Handler D = a1.D(new Handler.Callback() { // from class: androidx.media3.exoplayer.offline.g
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean j11;
                j11 = DownloadManager.this.j(message);
                return j11;
            }
        });
        this.f12394c = D;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        c cVar = new c(handlerThread, tVar, pVar, D, this.f12402k, this.f12403l, this.f12401j);
        this.f12395d = cVar;
        c.InterfaceC0778c interfaceC0778c = new c.InterfaceC0778c() { // from class: androidx.media3.exoplayer.offline.h
            @Override // f2.c.InterfaceC0778c
            public final void a(f2.c cVar2, int i11) {
                DownloadManager.this.s(cVar2, i11);
            }
        };
        this.f12396e = interfaceC0778c;
        f2.c cVar2 = new f2.c(context, interfaceC0778c, f12391q);
        this.f12407p = cVar2;
        int i11 = cVar2.i();
        this.f12404m = i11;
        this.f12398g = 1;
        cVar.obtainMessage(1, i11, 0).sendToTarget();
    }

    private boolean B() {
        boolean z10;
        if (!this.f12401j && this.f12404m != 0) {
            for (int i11 = 0; i11 < this.f12406o.size(); i11++) {
                if (((androidx.media3.exoplayer.offline.c) this.f12406o.get(i11)).f12496b == 0) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        boolean z11 = this.f12405n != z10;
        this.f12405n = z10;
        return z11;
    }

    public boolean j(Message message) {
        int i11 = message.what;
        if (i11 == 1) {
            q((List) message.obj);
        } else if (i11 == 2) {
            r(message.arg1, message.arg2);
        } else {
            if (i11 != 3) {
                throw new IllegalStateException();
            }
            p((b) message.obj);
        }
        return true;
    }

    static androidx.media3.exoplayer.offline.c n(androidx.media3.exoplayer.offline.c cVar, DownloadRequest downloadRequest, int i11, long j11) {
        int i12;
        int i13 = cVar.f12496b;
        long j12 = (i13 == 5 || cVar.c()) ? j11 : cVar.f12497c;
        if (i13 == 5 || i13 == 7) {
            i12 = 7;
        } else {
            i12 = i11 != 0 ? 1 : 0;
        }
        return new androidx.media3.exoplayer.offline.c(cVar.f12495a.copyWithMergedRequest(downloadRequest), i12, j12, j11, -1L, i11, 0);
    }

    private void o() {
        Iterator it = this.f12397f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(this, this.f12405n);
        }
    }

    private void p(b bVar) {
        this.f12406o = Collections.unmodifiableList(bVar.f12410c);
        androidx.media3.exoplayer.offline.c cVar = bVar.f12408a;
        boolean B = B();
        if (bVar.f12409b) {
            Iterator it = this.f12397f.iterator();
            while (it.hasNext()) {
                ((d) it.next()).b(this, cVar);
            }
        } else {
            Iterator it2 = this.f12397f.iterator();
            while (it2.hasNext()) {
                ((d) it2.next()).f(this, cVar, bVar.f12411d);
            }
        }
        if (B) {
            o();
        }
    }

    private void q(List list) {
        this.f12400i = true;
        this.f12406o = Collections.unmodifiableList(list);
        boolean B = B();
        Iterator it = this.f12397f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).g(this);
        }
        if (B) {
            o();
        }
    }

    private void r(int i11, int i12) {
        this.f12398g -= i11;
        this.f12399h = i12;
        if (k()) {
            Iterator it = this.f12397f.iterator();
            while (it.hasNext()) {
                ((d) it.next()).d(this);
            }
        }
    }

    public void s(f2.c cVar, int i11) {
        Requirements f11 = cVar.f();
        if (this.f12404m != i11) {
            this.f12404m = i11;
            this.f12398g++;
            this.f12395d.obtainMessage(3, i11, 0).sendToTarget();
        }
        boolean B = B();
        Iterator it = this.f12397f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).e(this, f11, i11);
        }
        if (B) {
            o();
        }
    }

    private void y(boolean z10) {
        if (this.f12401j == z10) {
            return;
        }
        this.f12401j = z10;
        this.f12398g++;
        this.f12395d.obtainMessage(2, z10 ? 1 : 0, 0).sendToTarget();
        boolean B = B();
        Iterator it = this.f12397f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).c(this, z10);
        }
        if (B) {
            o();
        }
    }

    public void A(String str, int i11) {
        this.f12398g++;
        this.f12395d.obtainMessage(4, i11, 0, str).sendToTarget();
    }

    public void c(DownloadRequest downloadRequest, int i11) {
        this.f12398g++;
        this.f12395d.obtainMessage(7, i11, 0, downloadRequest).sendToTarget();
    }

    public void d(d dVar) {
        androidx.media3.common.util.a.e(dVar);
        this.f12397f.add(dVar);
    }

    public List e() {
        return this.f12406o;
    }

    public f f() {
        return this.f12393b;
    }

    public boolean g() {
        return this.f12401j;
    }

    public int h() {
        return this.f12404m;
    }

    public Requirements i() {
        return this.f12407p.f();
    }

    public boolean k() {
        return this.f12399h == 0 && this.f12398g == 0;
    }

    public boolean l() {
        return this.f12400i;
    }

    public boolean m() {
        return this.f12405n;
    }

    public void t() {
        y(true);
    }

    public void u() {
        this.f12398g++;
        this.f12395d.obtainMessage(9).sendToTarget();
    }

    public void v(String str) {
        this.f12398g++;
        this.f12395d.obtainMessage(8, str).sendToTarget();
    }

    public void w(d dVar) {
        this.f12397f.remove(dVar);
    }

    public void x() {
        y(false);
    }

    public void z(Requirements requirements) {
        if (requirements.equals(this.f12407p.f())) {
            return;
        }
        this.f12407p.j();
        f2.c cVar = new f2.c(this.f12392a, this.f12396e, requirements);
        this.f12407p = cVar;
        s(this.f12407p, cVar.i());
    }
}
