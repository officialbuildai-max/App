package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.a;
import androidx.media3.datasource.cache.i;
import androidx.media3.exoplayer.offline.o;
import androidx.media3.exoplayer.upstream.q;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import w1.h;

/* loaded from: classes2.dex */
public abstract class SegmentDownloader implements o {

    /* renamed from: a, reason: collision with root package name */
    private final w1.h f12466a;

    /* renamed from: b, reason: collision with root package name */
    private final q.a f12467b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f12468c;

    /* renamed from: d, reason: collision with root package name */
    private final a.c f12469d;

    /* renamed from: e, reason: collision with root package name */
    private final Cache f12470e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.media3.datasource.cache.g f12471f;

    /* renamed from: g, reason: collision with root package name */
    private final PriorityTaskManager f12472g;

    /* renamed from: h, reason: collision with root package name */
    private final Executor f12473h;

    /* renamed from: i, reason: collision with root package name */
    private final long f12474i;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayList f12475j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f12476k;

    /* loaded from: classes2.dex */
    private static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        private final androidx.media3.datasource.cache.i cacheWriter;
        public final androidx.media3.datasource.cache.a dataSource;

        @Nullable
        private final a progressNotifier;
        public final b segment;
        public final byte[] temporaryBuffer;

        public SegmentDownloadRunnable(b bVar, androidx.media3.datasource.cache.a aVar, @Nullable a aVar2, byte[] bArr) {
            this.segment = bVar;
            this.dataSource = aVar;
            this.progressNotifier = aVar2;
            this.temporaryBuffer = bArr;
            this.cacheWriter = new androidx.media3.datasource.cache.i(aVar, bVar.f12483b, bArr, aVar2);
        }

        @Override // androidx.media3.common.util.RunnableFutureTask
        protected void cancelWork() {
            this.cacheWriter.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.media3.common.util.RunnableFutureTask
        public Void doWork() throws IOException {
            this.cacheWriter.a();
            a aVar = this.progressNotifier;
            if (aVar == null) {
                return null;
            }
            aVar.c();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements i.a {

        /* renamed from: a, reason: collision with root package name */
        private final o.a f12477a;

        /* renamed from: b, reason: collision with root package name */
        private final long f12478b;

        /* renamed from: c, reason: collision with root package name */
        private final int f12479c;

        /* renamed from: d, reason: collision with root package name */
        private long f12480d;

        /* renamed from: e, reason: collision with root package name */
        private int f12481e;

        public a(o.a aVar, long j11, int i11, long j12, int i12) {
            this.f12477a = aVar;
            this.f12478b = j11;
            this.f12479c = i11;
            this.f12480d = j12;
            this.f12481e = i12;
        }

        private float b() {
            long j11 = this.f12478b;
            if (j11 != -1 && j11 != 0) {
                return (((float) this.f12480d) * 100.0f) / ((float) j11);
            }
            int i11 = this.f12479c;
            if (i11 != 0) {
                return (this.f12481e * 100.0f) / i11;
            }
            return -1.0f;
        }

        @Override // androidx.media3.datasource.cache.i.a
        public void a(long j11, long j12, long j13) {
            long j14 = this.f12480d + j13;
            this.f12480d = j14;
            this.f12477a.onProgress(this.f12478b, j14, b());
        }

        public void c() {
            this.f12481e++;
            this.f12477a.onProgress(this.f12478b, this.f12480d, b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class b implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final long f12482a;

        /* renamed from: b, reason: collision with root package name */
        public final w1.h f12483b;

        public b(long j11, w1.h hVar) {
            this.f12482a = j11;
            this.f12483b = hVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return a1.n(this.f12482a, bVar.f12482a);
        }
    }

    public SegmentDownloader(androidx.media3.common.t tVar, q.a aVar, a.c cVar, Executor executor, long j11) {
        androidx.media3.common.util.a.e(tVar.f10293b);
        this.f12466a = f(tVar.f10293b.f10385a);
        this.f12467b = aVar;
        this.f12468c = new ArrayList(tVar.f10293b.f10388d);
        this.f12469d = cVar;
        this.f12473h = executor;
        this.f12470e = (Cache) androidx.media3.common.util.a.e(cVar.f());
        this.f12471f = cVar.g();
        this.f12472g = cVar.h();
        this.f12475j = new ArrayList();
        this.f12474i = a1.R0(j11);
    }

    private void c(RunnableFutureTask runnableFutureTask) {
        synchronized (this.f12475j) {
            try {
                if (this.f12476k) {
                    throw new InterruptedException();
                }
                this.f12475j.add(runnableFutureTask);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean d(w1.h hVar, w1.h hVar2) {
        if (hVar.f77634a.equals(hVar2.f77634a)) {
            long j11 = hVar.f77641h;
            if (j11 != -1 && hVar.f77640g + j11 == hVar2.f77640g && Objects.equals(hVar.f77642i, hVar2.f77642i) && hVar.f77643j == hVar2.f77643j && hVar.f77636c == hVar2.f77636c && hVar.f77638e.equals(hVar2.f77638e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static w1.h f(Uri uri) {
        return new h.b().i(uri).b(1).a();
    }

    private static void i(List list, androidx.media3.datasource.cache.g gVar, long j11) {
        HashMap hashMap = new HashMap();
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            b bVar = (b) list.get(i12);
            String a11 = gVar.a(bVar.f12483b);
            Integer num = (Integer) hashMap.get(a11);
            b bVar2 = num == null ? null : (b) list.get(num.intValue());
            if (bVar2 == null || bVar.f12482a > bVar2.f12482a + j11 || !d(bVar2.f12483b, bVar.f12483b)) {
                hashMap.put(a11, Integer.valueOf(i11));
                list.set(i11, bVar);
                i11++;
            } else {
                long j12 = bVar.f12483b.f77641h;
                list.set(((Integer) androidx.media3.common.util.a.e(num)).intValue(), new b(bVar2.f12482a, bVar2.f12483b.f(0L, j12 != -1 ? bVar2.f12483b.f77641h + j12 : -1L)));
            }
        }
        a1.c1(list, i11, list.size());
    }

    private void j(int i11) {
        synchronized (this.f12475j) {
            this.f12475j.remove(i11);
        }
    }

    private void k(RunnableFutureTask runnableFutureTask) {
        synchronized (this.f12475j) {
            this.f12475j.remove(runnableFutureTask);
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public final void a(o.a aVar) {
        androidx.media3.datasource.cache.a c11;
        byte[] bArr;
        int i11;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager = this.f12472g;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-4000);
        }
        try {
            androidx.media3.datasource.cache.a c12 = this.f12469d.c();
            q g11 = g(c12, this.f12466a, false);
            if (!this.f12468c.isEmpty()) {
                g11 = (q) g11.copy(this.f12468c);
            }
            List h11 = h(c12, g11, false);
            Collections.sort(h11);
            i(h11, this.f12471f, this.f12474i);
            int size = h11.size();
            int i12 = 0;
            long j11 = 0;
            long j12 = 0;
            for (int size2 = h11.size() - 1; size2 >= 0; size2 = i11 - 1) {
                w1.h hVar = ((b) h11.get(size2)).f12483b;
                String a11 = this.f12471f.a(hVar);
                long j13 = hVar.f77641h;
                if (j13 == -1) {
                    long a12 = androidx.media3.datasource.cache.l.a(this.f12470e.getContentMetadata(a11));
                    if (a12 != -1) {
                        j13 = a12 - hVar.f77640g;
                    }
                }
                int i13 = size2;
                long a13 = this.f12470e.a(a11, hVar.f77640g, j13);
                j12 += a13;
                if (j13 != -1) {
                    if (j13 == a13) {
                        i12++;
                        i11 = i13;
                        h11.remove(i11);
                    } else {
                        i11 = i13;
                    }
                    if (j11 != -1) {
                        j11 += j13;
                    }
                } else {
                    i11 = i13;
                    j11 = -1;
                }
            }
            a aVar2 = aVar != null ? new a(aVar, j11, size, j12, i12) : null;
            arrayDeque.addAll(h11);
            while (!this.f12476k && !arrayDeque.isEmpty()) {
                PriorityTaskManager priorityTaskManager2 = this.f12472g;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-4000);
                }
                if (arrayDeque2.isEmpty()) {
                    c11 = this.f12469d.c();
                    bArr = new byte[131072];
                } else {
                    SegmentDownloadRunnable segmentDownloadRunnable = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                    c11 = segmentDownloadRunnable.dataSource;
                    bArr = segmentDownloadRunnable.temporaryBuffer;
                }
                SegmentDownloadRunnable segmentDownloadRunnable2 = new SegmentDownloadRunnable((b) arrayDeque.removeFirst(), c11, aVar2, bArr);
                c(segmentDownloadRunnable2);
                this.f12473h.execute(segmentDownloadRunnable2);
                for (int size3 = this.f12475j.size() - 1; size3 >= 0; size3--) {
                    SegmentDownloadRunnable segmentDownloadRunnable3 = (SegmentDownloadRunnable) this.f12475j.get(size3);
                    if (arrayDeque.isEmpty() || segmentDownloadRunnable3.isDone()) {
                        try {
                            segmentDownloadRunnable3.get();
                            j(size3);
                            arrayDeque2.addLast(segmentDownloadRunnable3);
                        } catch (ExecutionException e11) {
                            Throwable th2 = (Throwable) androidx.media3.common.util.a.e(e11.getCause());
                            if (th2 instanceof PriorityTaskManager.PriorityTooLowException) {
                                arrayDeque.addFirst(segmentDownloadRunnable3.segment);
                                j(size3);
                                arrayDeque2.addLast(segmentDownloadRunnable3);
                            } else {
                                if (th2 instanceof IOException) {
                                    throw ((IOException) th2);
                                }
                                a1.m1(th2);
                            }
                        }
                    }
                }
                segmentDownloadRunnable2.blockUntilStarted();
            }
            for (int i14 = 0; i14 < this.f12475j.size(); i14++) {
                ((RunnableFutureTask) this.f12475j.get(i14)).cancel(true);
            }
            for (int size4 = this.f12475j.size() - 1; size4 >= 0; size4--) {
                ((RunnableFutureTask) this.f12475j.get(size4)).blockUntilFinished();
                j(size4);
            }
            PriorityTaskManager priorityTaskManager3 = this.f12472g;
            if (priorityTaskManager3 != null) {
                priorityTaskManager3.d(-4000);
            }
        } catch (Throwable th3) {
            for (int i15 = 0; i15 < this.f12475j.size(); i15++) {
                ((RunnableFutureTask) this.f12475j.get(i15)).cancel(true);
            }
            for (int size5 = this.f12475j.size() - 1; size5 >= 0; size5--) {
                ((RunnableFutureTask) this.f12475j.get(size5)).blockUntilFinished();
                j(size5);
            }
            PriorityTaskManager priorityTaskManager4 = this.f12472g;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.d(-4000);
            }
            throw th3;
        }
    }

    @Override // androidx.media3.exoplayer.offline.o
    public void cancel() {
        synchronized (this.f12475j) {
            try {
                this.f12476k = true;
                for (int i11 = 0; i11 < this.f12475j.size(); i11++) {
                    ((RunnableFutureTask) this.f12475j.get(i11)).cancel(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(5:27|28|29|(2:34|(2:36|37)(3:38|39|40))(2:31|32)|33) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
    
        r0 = (java.lang.Throwable) androidx.media3.common.util.a.e(r4.getCause());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        if ((r0 instanceof androidx.media3.common.PriorityTaskManager.PriorityTooLowException) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
    
        if ((r0 instanceof java.io.IOException) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        androidx.media3.common.util.a1.m1(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0062, code lost:
    
        throw ((java.io.IOException) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0040, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0063, code lost:
    
        r3.blockUntilFinished();
        k(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(androidx.media3.common.util.RunnableFutureTask r3, boolean r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L20
            r3.run()
            java.lang.Object r3 = r3.get()     // Catch: java.util.concurrent.ExecutionException -> La
            return r3
        La:
            r4 = move-exception
            java.lang.Throwable r0 = r4.getCause()
            java.lang.Object r0 = androidx.media3.common.util.a.e(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            boolean r1 = r0 instanceof java.io.IOException
            if (r1 != 0) goto L1d
            androidx.media3.common.util.a1.m1(r4)
            goto L20
        L1d:
            java.io.IOException r0 = (java.io.IOException) r0
            throw r0
        L20:
            boolean r4 = r2.f12476k
            if (r4 != 0) goto L6a
            androidx.media3.common.PriorityTaskManager r4 = r2.f12472g
            if (r4 == 0) goto L2d
            r0 = -4000(0xfffffffffffff060, float:NaN)
            r4.b(r0)
        L2d:
            r2.c(r3)
            java.util.concurrent.Executor r4 = r2.f12473h
            r4.execute(r3)
            java.lang.Object r4 = r3.get()     // Catch: java.lang.Throwable -> L40 java.util.concurrent.ExecutionException -> L42
            r3.blockUntilFinished()
            r2.k(r3)
            return r4
        L40:
            r4 = move-exception
            goto L63
        L42:
            r4 = move-exception
            java.lang.Throwable r0 = r4.getCause()     // Catch: java.lang.Throwable -> L40
            java.lang.Object r0 = androidx.media3.common.util.a.e(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: java.lang.Throwable -> L40
            boolean r1 = r0 instanceof androidx.media3.common.PriorityTaskManager.PriorityTooLowException     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L52
            goto L59
        L52:
            boolean r1 = r0 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L60
            androidx.media3.common.util.a1.m1(r4)     // Catch: java.lang.Throwable -> L40
        L59:
            r3.blockUntilFinished()
            r2.k(r3)
            goto L20
        L60:
            java.io.IOException r0 = (java.io.IOException) r0     // Catch: java.lang.Throwable -> L40
            throw r0     // Catch: java.lang.Throwable -> L40
        L63:
            r3.blockUntilFinished()
            r2.k(r3)
            throw r4
        L6a:
            java.lang.InterruptedException r3 = new java.lang.InterruptedException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.offline.SegmentDownloader.e(androidx.media3.common.util.RunnableFutureTask, boolean):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final q g(final androidx.media3.datasource.a aVar, final w1.h hVar, boolean z10) {
        return (q) e(new RunnableFutureTask<q, IOException>() { // from class: androidx.media3.exoplayer.offline.SegmentDownloader.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media3.common.util.RunnableFutureTask
            public q doWork() throws IOException {
                return (q) androidx.media3.exoplayer.upstream.q.e(aVar, SegmentDownloader.this.f12467b, hVar, 4);
            }
        }, z10);
    }

    protected abstract List h(androidx.media3.datasource.a aVar, q qVar, boolean z10);

    @Override // androidx.media3.exoplayer.offline.o
    public final void remove() {
        androidx.media3.datasource.cache.a d11 = this.f12469d.d();
        try {
            try {
                List h11 = h(d11, g(d11, this.f12466a, true), true);
                for (int i11 = 0; i11 < h11.size(); i11++) {
                    this.f12470e.e(this.f12471f.a(((b) h11.get(i11)).f12483b));
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception unused2) {
            }
        } finally {
            this.f12470e.e(this.f12471f.a(this.f12466a));
        }
    }
}
