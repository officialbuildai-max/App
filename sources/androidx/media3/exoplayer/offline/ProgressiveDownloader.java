package androidx.media3.exoplayer.offline;

import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.cache.a;
import androidx.media3.datasource.cache.i;
import androidx.media3.exoplayer.offline.o;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import w1.h;

/* loaded from: classes2.dex */
public final class ProgressiveDownloader implements o {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f12458a;

    /* renamed from: b, reason: collision with root package name */
    private final w1.h f12459b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.datasource.cache.a f12460c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.datasource.cache.i f12461d;

    /* renamed from: e, reason: collision with root package name */
    private final PriorityTaskManager f12462e;

    /* renamed from: f, reason: collision with root package name */
    private o.a f12463f;

    /* renamed from: g, reason: collision with root package name */
    private volatile RunnableFutureTask f12464g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f12465h;

    public ProgressiveDownloader(androidx.media3.common.t tVar, a.c cVar, Executor executor) {
        this.f12458a = (Executor) androidx.media3.common.util.a.e(executor);
        androidx.media3.common.util.a.e(tVar.f10293b);
        w1.h a11 = new h.b().i(tVar.f10293b.f10385a).f(tVar.f10293b.f10389e).b(4).a();
        this.f12459b = a11;
        androidx.media3.datasource.cache.a c11 = cVar.c();
        this.f12460c = c11;
        this.f12461d = new androidx.media3.datasource.cache.i(c11, a11, null, new i.a() { // from class: androidx.media3.exoplayer.offline.s
            @Override // androidx.media3.datasource.cache.i.a
            public final void a(long j11, long j12, long j13) {
                ProgressiveDownloader.this.d(j11, j12, j13);
            }
        });
        this.f12462e = cVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j11, long j12, long j13) {
        o.a aVar = this.f12463f;
        if (aVar == null) {
            return;
        }
        aVar.onProgress(j11, j12, (j11 == -1 || j11 == 0) ? -1.0f : (((float) j12) * 100.0f) / ((float) j11));
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void a(o.a aVar) {
        this.f12463f = aVar;
        PriorityTaskManager priorityTaskManager = this.f12462e;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-4000);
        }
        boolean z10 = false;
        while (!z10) {
            try {
                if (this.f12465h) {
                    break;
                }
                this.f12464g = new RunnableFutureTask<Void, IOException>() { // from class: androidx.media3.exoplayer.offline.ProgressiveDownloader.1
                    @Override // androidx.media3.common.util.RunnableFutureTask
                    protected void cancelWork() {
                        ProgressiveDownloader.this.f12461d.b();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // androidx.media3.common.util.RunnableFutureTask
                    public Void doWork() throws IOException {
                        ProgressiveDownloader.this.f12461d.a();
                        return null;
                    }
                };
                PriorityTaskManager priorityTaskManager2 = this.f12462e;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-4000);
                }
                this.f12458a.execute(this.f12464g);
                try {
                    this.f12464g.get();
                    z10 = true;
                } catch (ExecutionException e11) {
                    Throwable th2 = (Throwable) androidx.media3.common.util.a.e(e11.getCause());
                    if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th2 instanceof IOException) {
                            throw ((IOException) th2);
                        }
                        a1.m1(th2);
                    }
                }
            } catch (Throwable th3) {
                ((RunnableFutureTask) androidx.media3.common.util.a.e(this.f12464g)).blockUntilFinished();
                PriorityTaskManager priorityTaskManager3 = this.f12462e;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.d(-4000);
                }
                throw th3;
            }
        }
        ((RunnableFutureTask) androidx.media3.common.util.a.e(this.f12464g)).blockUntilFinished();
        PriorityTaskManager priorityTaskManager4 = this.f12462e;
        if (priorityTaskManager4 != null) {
            priorityTaskManager4.d(-4000);
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void cancel() {
        this.f12465h = true;
        RunnableFutureTask runnableFutureTask = this.f12464g;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void remove() {
        this.f12460c.e().e(this.f12460c.f().a(this.f12459b));
    }
}
