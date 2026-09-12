package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.b;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.cache.g;
import com.google.android.exoplayer2.upstream.cache.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public abstract class SegmentDownloader implements com.google.android.exoplayer2.offline.b {

    /* renamed from: a, reason: collision with root package name */
    private final n f25619a;

    /* renamed from: b, reason: collision with root package name */
    private final b0.a f25620b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f25621c;

    /* renamed from: d, reason: collision with root package name */
    private final a.c f25622d;

    /* renamed from: e, reason: collision with root package name */
    private final Cache f25623e;

    /* renamed from: f, reason: collision with root package name */
    private final g f25624f;

    /* renamed from: g, reason: collision with root package name */
    private final PriorityTaskManager f25625g;

    /* renamed from: h, reason: collision with root package name */
    private final Executor f25626h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList f25627i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f25628j;

    /* loaded from: classes3.dex */
    private static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        private final i cacheWriter;
        public final com.google.android.exoplayer2.upstream.cache.a dataSource;

        @Nullable
        private final a progressNotifier;
        public final b segment;
        public final byte[] temporaryBuffer;

        public SegmentDownloadRunnable(b bVar, com.google.android.exoplayer2.upstream.cache.a aVar, @Nullable a aVar2, byte[] bArr) {
            this.segment = bVar;
            this.dataSource = aVar;
            this.progressNotifier = aVar2;
            this.temporaryBuffer = bArr;
            this.cacheWriter = new i(aVar, bVar.f25635b, bArr, aVar2);
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        protected void cancelWork() {
            this.cacheWriter.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
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
    /* loaded from: classes3.dex */
    public static final class a implements i.a {

        /* renamed from: a, reason: collision with root package name */
        private final b.a f25629a;

        /* renamed from: b, reason: collision with root package name */
        private final long f25630b;

        /* renamed from: c, reason: collision with root package name */
        private final int f25631c;

        /* renamed from: d, reason: collision with root package name */
        private long f25632d;

        /* renamed from: e, reason: collision with root package name */
        private int f25633e;

        public a(b.a aVar, long j11, int i11, long j12, int i12) {
            this.f25629a = aVar;
            this.f25630b = j11;
            this.f25631c = i11;
            this.f25632d = j12;
            this.f25633e = i12;
        }

        private float b() {
            long j11 = this.f25630b;
            if (j11 != -1 && j11 != 0) {
                return (((float) this.f25632d) * 100.0f) / ((float) j11);
            }
            int i11 = this.f25631c;
            if (i11 != 0) {
                return (this.f25633e * 100.0f) / i11;
            }
            return -1.0f;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.i.a
        public void a(long j11, long j12, long j13) {
            long j14 = this.f25632d + j13;
            this.f25632d = j14;
            this.f25629a.onProgress(this.f25630b, j14, b());
        }

        public void c() {
            this.f25633e++;
            this.f25629a.onProgress(this.f25630b, this.f25632d, b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class b implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final long f25634a;

        /* renamed from: b, reason: collision with root package name */
        public final n f25635b;

        public b(long j11, n nVar) {
            this.f25634a = j11;
            this.f25635b = nVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return p0.o(this.f25634a, bVar.f25634a);
        }
    }

    public SegmentDownloader(v1 v1Var, b0.a aVar, a.c cVar, Executor executor) {
        com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
        this.f25619a = f(v1Var.f27763b.f27826a);
        this.f25620b = aVar;
        this.f25621c = new ArrayList(v1Var.f27763b.f27829d);
        this.f25622d = cVar;
        this.f25626h = executor;
        this.f25623e = (Cache) com.google.android.exoplayer2.util.a.e(cVar.e());
        this.f25624f = cVar.f();
        this.f25625g = cVar.g();
        this.f25627i = new ArrayList();
    }

    private void c(RunnableFutureTask runnableFutureTask) {
        synchronized (this.f25627i) {
            try {
                if (this.f25628j) {
                    throw new InterruptedException();
                }
                this.f25627i.add(runnableFutureTask);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean d(n nVar, n nVar2) {
        if (nVar.f27491a.equals(nVar2.f27491a)) {
            long j11 = nVar.f27498h;
            if (j11 != -1 && nVar.f27497g + j11 == nVar2.f27497g && p0.c(nVar.f27499i, nVar2.f27499i) && nVar.f27500j == nVar2.f27500j && nVar.f27493c == nVar2.f27493c && nVar.f27495e.equals(nVar2.f27495e)) {
                return true;
            }
        }
        return false;
    }

    protected static n f(Uri uri) {
        return new n.b().i(uri).b(1).a();
    }

    private static void i(List list, g gVar) {
        HashMap hashMap = new HashMap();
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            b bVar = (b) list.get(i12);
            String a11 = gVar.a(bVar.f25635b);
            Integer num = (Integer) hashMap.get(a11);
            b bVar2 = num == null ? null : (b) list.get(num.intValue());
            if (bVar2 == null || bVar.f25634a > bVar2.f25634a + 20000000 || !d(bVar2.f25635b, bVar.f25635b)) {
                hashMap.put(a11, Integer.valueOf(i11));
                list.set(i11, bVar);
                i11++;
            } else {
                long j11 = bVar.f25635b.f27498h;
                list.set(((Integer) com.google.android.exoplayer2.util.a.e(num)).intValue(), new b(bVar2.f25634a, bVar2.f25635b.f(0L, j11 != -1 ? bVar2.f25635b.f27498h + j11 : -1L)));
            }
        }
        p0.M0(list, i11, list.size());
    }

    private void j(int i11) {
        synchronized (this.f25627i) {
            this.f25627i.remove(i11);
        }
    }

    private void k(RunnableFutureTask runnableFutureTask) {
        synchronized (this.f25627i) {
            this.f25627i.remove(runnableFutureTask);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01ad A[LOOP:1: B:37:0x01a5->B:39:0x01ad, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c6 A[LOOP:2: B:42:0x01c4->B:43:0x01c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01db  */
    @Override // com.google.android.exoplayer2.offline.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.exoplayer2.offline.b.a r26) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.SegmentDownloader.a(com.google.android.exoplayer2.offline.b$a):void");
    }

    @Override // com.google.android.exoplayer2.offline.b
    public void cancel() {
        synchronized (this.f25627i) {
            try {
                this.f25628j = true;
                for (int i11 = 0; i11 < this.f25627i.size(); i11++) {
                    ((RunnableFutureTask) this.f25627i.get(i11)).cancel(true);
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
    
        r0 = (java.lang.Throwable) com.google.android.exoplayer2.util.a.e(r4.getCause());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        if ((r0 instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
    
        if ((r0 instanceof java.io.IOException) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        com.google.android.exoplayer2.util.p0.Q0(r4);
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
    public final java.lang.Object e(com.google.android.exoplayer2.util.RunnableFutureTask r3, boolean r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L20
            r3.run()
            java.lang.Object r3 = r3.get()     // Catch: java.util.concurrent.ExecutionException -> La
            return r3
        La:
            r4 = move-exception
            java.lang.Throwable r0 = r4.getCause()
            java.lang.Object r0 = com.google.android.exoplayer2.util.a.e(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            boolean r1 = r0 instanceof java.io.IOException
            if (r1 != 0) goto L1d
            com.google.android.exoplayer2.util.p0.Q0(r4)
            goto L20
        L1d:
            java.io.IOException r0 = (java.io.IOException) r0
            throw r0
        L20:
            boolean r4 = r2.f25628j
            if (r4 != 0) goto L6a
            com.google.android.exoplayer2.util.PriorityTaskManager r4 = r2.f25625g
            if (r4 == 0) goto L2d
            r0 = -1000(0xfffffffffffffc18, float:NaN)
            r4.b(r0)
        L2d:
            r2.c(r3)
            java.util.concurrent.Executor r4 = r2.f25626h
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
            java.lang.Object r0 = com.google.android.exoplayer2.util.a.e(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: java.lang.Throwable -> L40
            boolean r1 = r0 instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L52
            goto L59
        L52:
            boolean r1 = r0 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L60
            com.google.android.exoplayer2.util.p0.Q0(r4)     // Catch: java.lang.Throwable -> L40
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.SegmentDownloader.e(com.google.android.exoplayer2.util.RunnableFutureTask, boolean):java.lang.Object");
    }

    protected final c g(final k kVar, final n nVar, boolean z10) {
        return (c) e(new RunnableFutureTask<c, IOException>() { // from class: com.google.android.exoplayer2.offline.SegmentDownloader.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.exoplayer2.util.RunnableFutureTask
            public c doWork() throws IOException {
                return (c) b0.e(kVar, SegmentDownloader.this.f25620b, nVar, 4);
            }
        }, z10);
    }

    protected abstract List h(k kVar, c cVar, boolean z10);

    @Override // com.google.android.exoplayer2.offline.b
    public final void remove() {
        com.google.android.exoplayer2.upstream.cache.a c11 = this.f25622d.c();
        try {
            try {
                List h11 = h(c11, g(c11, this.f25619a, true), true);
                for (int i11 = 0; i11 < h11.size(); i11++) {
                    this.f25623e.e(this.f25624f.a(((b) h11.get(i11)).f25635b));
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception unused2) {
            }
        } finally {
            this.f25623e.e(this.f25624f.a(this.f25619a));
        }
    }
}
