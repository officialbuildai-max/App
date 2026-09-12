package com.mbridge.msdk.tracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final c f38765a;

    /* renamed from: b, reason: collision with root package name */
    private final int f38766b;

    /* renamed from: c, reason: collision with root package name */
    private final int f38767c;

    /* renamed from: d, reason: collision with root package name */
    private final int f38768d;

    /* renamed from: e, reason: collision with root package name */
    private final k f38769e;

    /* renamed from: i, reason: collision with root package name */
    private Handler f38773i;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f38770f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    private final AtomicInteger f38771g = new AtomicInteger(0);

    /* renamed from: h, reason: collision with root package name */
    private final Object f38772h = new Object();

    /* renamed from: j, reason: collision with root package name */
    private boolean f38774j = true;

    /* renamed from: k, reason: collision with root package name */
    private long f38775k = 0;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f38776l = false;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f38777m = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements r {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f38778a;

        /* renamed from: b, reason: collision with root package name */
        private final s f38779b;

        public a(Handler handler, s sVar) {
            this.f38778a = handler;
            this.f38779b = sVar;
        }

        @Override // com.mbridge.msdk.tracker.r
        public void a(t tVar) {
            this.f38779b.b(tVar.a());
            this.f38779b.i();
            this.f38779b.f38775k = 0L;
            if (this.f38779b.f()) {
                Handler handler = this.f38778a;
                handler.sendMessage(Message.obtain(handler, 2));
            }
            if (com.mbridge.msdk.tracker.a.f38550a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f38779b.f38769e.v());
                sb2.append(" report success ");
                sb2.append(tVar.a().size());
                sb2.append(" 剩余事件数：");
                sb2.append(this.f38779b.f38771g.addAndGet(0));
                sb2.append(" 个，数据库记录数：");
                sb2.append(this.f38779b.f38765a.b());
                sb2.append(" 个");
            }
        }

        @Override // com.mbridge.msdk.tracker.r
        public void a(t tVar, int i11, String str) {
            this.f38779b.a(tVar.a(), str);
            this.f38779b.f38775k = System.currentTimeMillis();
            int d11 = this.f38779b.d();
            if (d11 <= 10) {
                this.f38778a.removeMessages(3);
                Handler handler = this.f38778a;
                handler.sendMessageDelayed(Message.obtain(handler, 3), d11 * 1000);
            }
            if (com.mbridge.msdk.tracker.a.f38550a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f38779b.f38769e.v());
                sb2.append(" report failed ");
                sb2.append(tVar.a().size());
                sb2.append(" 剩余事件数：");
                sb2.append(this.f38779b.f38771g.addAndGet(0));
                sb2.append(" 个，数据库记录数：");
                sb2.append(this.f38779b.f38765a.b());
                sb2.append(" 个 连续失败次数： ");
                sb2.append(d11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final s f38780a;

        public b(Looper looper, s sVar) {
            super(looper);
            this.f38780a = sVar;
        }

        private synchronized void a() {
            try {
                this.f38780a.h();
            } catch (Exception e11) {
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    Log.e("TrackManager", this.f38780a.f38769e.v() + " report failed ", e11);
                }
            }
        }

        private void a(String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f38780a.f38769e.v());
            sb2.append(" ");
            sb2.append(str);
            sb2.append(this.f38780a.f38771g.addAndGet(0));
            sb2.append(" 数据库记录数：");
            sb2.append(this.f38780a.f38765a.b());
        }

        private void b() {
            try {
                removeMessages(1);
                removeMessages(6);
                removeMessages(2);
                removeMessages(3);
            } catch (Exception e11) {
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    Log.e("TrackManager", this.f38780a.f38769e.v() + " removeMessages failed ", e11);
                }
            }
            if (this.f38780a.g()) {
                return;
            }
            try {
                sendMessageDelayed(Message.obtain(this, 1), y.a(this.f38780a.f38770f.get(), this.f38780a.f38775k, this.f38780a.f38767c));
            } catch (Exception e12) {
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    Log.e("TrackManager", this.f38780a.f38769e.v() + " sendMessageDelayed failed ", e12);
                }
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            int i11 = message.what;
            if (i11 == 2 || i11 == 3) {
                b();
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    a("触发上报（report result）当前 Event 数量：");
                }
                a();
                return;
            }
            if (i11 == 5) {
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    a("触发删除 当前 Event 数量：");
                }
                this.f38780a.a();
                sendMessageDelayed(Message.obtain(this, 5), TmcConstants.DEBUG_REQUEST_TIME_INTERVAL);
                return;
            }
            if (i11 != 6) {
                if (i11 != 7) {
                    b();
                    if (com.mbridge.msdk.tracker.a.f38550a) {
                        a("触发上报（timer）当前 Event 数量：");
                    }
                    a();
                    return;
                }
                this.f38780a.k();
                b();
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    a("触发上报（flush）当前 Event 数量：");
                }
                a();
                return;
            }
            Object obj = message.obj;
            e eVar = obj instanceof e ? (e) obj : null;
            if (com.mbridge.msdk.tracker.a.f38550a && !y.b(eVar)) {
                a(String.format("收到 Event( %s )，当前 Event 数量：", eVar.b()));
            }
            if (y.a(eVar) || this.f38780a.f()) {
                b();
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    a("触发上报（notice check）当前 Event 数量：");
                }
                a();
            }
        }
    }

    public s(k kVar) {
        this.f38765a = kVar.d();
        this.f38766b = kVar.i();
        this.f38767c = kVar.l();
        this.f38768d = kVar.j();
        this.f38769e = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (com.mbridge.msdk.tracker.a.f38550a) {
            return;
        }
        int a11 = this.f38765a.a();
        if (com.mbridge.msdk.tracker.a.f38550a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f38769e.v());
            sb2.append(" 删除无效数据的数量 = ");
            sb2.append(a11);
            sb2.append(" 当前剩余事件数 = ");
            sb2.append(this.f38771g.addAndGet(0));
            sb2.append(" 数据库中剩余事件数 = ");
            sb2.append(this.f38765a.b());
        }
    }

    private void a(List<i> list) {
        this.f38765a.b(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<i> list, String str) {
        if (y.b((List<?>) list)) {
            return;
        }
        int i11 = 0;
        for (i iVar : list) {
            if (!y.b(iVar)) {
                boolean z10 = !iVar.g() && iVar.c() >= this.f38768d;
                boolean z11 = !iVar.h() && iVar.b() < System.currentTimeMillis();
                if (z10 || z11) {
                    iVar.b(-1);
                } else {
                    iVar.a(iVar.c() + 1);
                    iVar.b(3);
                    iVar.a(str);
                    i11++;
                }
            }
        }
        this.f38765a.a(list);
        this.f38771g.addAndGet(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<i> list) {
        if (y.b((List<?>) list)) {
            return;
        }
        this.f38765a.c(list);
    }

    private List<i> c() {
        return this.f38765a.a(this.f38766b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        return this.f38770f.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        List<i> c11 = c();
        if (y.b((List<?>) c11)) {
            if (com.mbridge.msdk.tracker.a.f38550a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f38769e.v());
                sb2.append(" report: 没有可以上报的数据");
                return;
            }
            return;
        }
        a(c11);
        int size = c11.size();
        this.f38771g.addAndGet(-size);
        boolean z10 = false;
        if (com.mbridge.msdk.tracker.a.f38550a) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f38769e.v());
            sb3.append(" report: 上报的数量 = ");
            sb3.append(size);
            sb3.append(" 当前剩余事件数 = ");
            sb3.append(this.f38771g.addAndGet(0));
            sb3.append(" 数据库中剩余事件数 = ");
            sb3.append(this.f38765a.b());
        }
        try {
            z10 = this.f38769e.a();
        } catch (IllegalStateException e11) {
            if (com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", this.f38769e.v() + " report environment check failed ", e11);
            }
        }
        if (!z10) {
            if (com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", this.f38769e.v() + " report 失败，请检查 TrackConfig 配置是否正确");
                return;
            }
            return;
        }
        o m11 = this.f38769e.m();
        m11.a(new a(this.f38773i, this));
        Map<String, String> hashMap = new HashMap<>();
        try {
            hashMap = this.f38769e.f().a(this.f38769e.u(), c11, this.f38769e.o());
        } catch (Exception e12) {
            if (com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", this.f38769e.v() + " report decorate request params failed ", e12);
            }
        }
        m11.b(new t(c11), hashMap, y.a(c11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f38770f.set(0);
    }

    private void l() {
        this.f38765a.c();
    }

    public void a(e eVar) {
        if (this.f38773i.hasMessages(6)) {
            return;
        }
        if (y.a(this.f38770f.get(), this.f38775k, this.f38767c) > this.f38767c) {
            Handler handler = this.f38773i;
            handler.sendMessageDelayed(Message.obtain(handler, 6, eVar), ((float) r2) * 0.1f);
        } else {
            Handler handler2 = this.f38773i;
            handler2.sendMessage(Message.obtain(handler2, 6, eVar));
        }
    }

    public void b() {
        this.f38773i.removeMessages(1);
        Handler handler = this.f38773i;
        handler.sendMessage(Message.obtain(handler, 7));
    }

    public void e() {
        this.f38771g.incrementAndGet();
    }

    protected boolean f() {
        return this.f38771g.addAndGet(0) >= this.f38766b;
    }

    boolean g() {
        return this.f38774j;
    }

    public void j() {
        HandlerThread handlerThread = new HandlerThread("report_timer");
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper(), this);
        this.f38773i = bVar;
        bVar.sendMessageDelayed(Message.obtain(bVar, 5), 5000L);
        Handler handler = this.f38773i;
        handler.sendMessageDelayed(Message.obtain(handler, 1), this.f38767c);
        this.f38774j = false;
    }

    public void k() {
        synchronized (this.f38772h) {
            try {
                if (!this.f38776l) {
                    this.f38776l = true;
                    l();
                }
                if (!this.f38777m) {
                    this.f38777m = true;
                    this.f38771g.addAndGet(this.f38765a.b());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
