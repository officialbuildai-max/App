package com.google.android.exoplayer2.upstream.cache;

import java.io.InterruptedIOException;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.cache.a f27397a;

    /* renamed from: b, reason: collision with root package name */
    private final Cache f27398b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.n f27399c;

    /* renamed from: d, reason: collision with root package name */
    private final String f27400d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f27401e;

    /* renamed from: f, reason: collision with root package name */
    private final a f27402f;

    /* renamed from: g, reason: collision with root package name */
    private long f27403g;

    /* renamed from: h, reason: collision with root package name */
    private long f27404h;

    /* renamed from: i, reason: collision with root package name */
    private long f27405i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f27406j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(long j11, long j12, long j13);
    }

    public i(com.google.android.exoplayer2.upstream.cache.a aVar, com.google.android.exoplayer2.upstream.n nVar, byte[] bArr, a aVar2) {
        this.f27397a = aVar;
        this.f27398b = aVar.h();
        this.f27399c = nVar;
        this.f27401e = bArr == null ? new byte[131072] : bArr;
        this.f27402f = aVar2;
        this.f27400d = aVar.i().a(nVar);
        this.f27403g = nVar.f27497g;
    }

    private long c() {
        long j11 = this.f27404h;
        if (j11 == -1) {
            return -1L;
        }
        return j11 - this.f27399c.f27497g;
    }

    private void d(long j11) {
        this.f27405i += j11;
        a aVar = this.f27402f;
        if (aVar != null) {
            aVar.a(c(), this.f27405i, j11);
        }
    }

    private void e(long j11) {
        if (this.f27404h == j11) {
            return;
        }
        this.f27404h = j11;
        a aVar = this.f27402f;
        if (aVar != null) {
            aVar.a(c(), this.f27405i, 0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[Catch: IOException -> 0x0068, TryCatch #0 {IOException -> 0x0068, blocks: (B:25:0x0064, B:33:0x006f, B:36:0x007d, B:42:0x0085), top: B:24:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: IOException -> 0x0068, TRY_LEAVE, TryCatch #0 {IOException -> 0x0068, blocks: (B:25:0x0064, B:33:0x006f, B:36:0x007d, B:42:0x0085), top: B:24:0x0064 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long f(long r7, long r9) {
        /*
            r6 = this;
            long r0 = r7 + r9
            long r2 = r6.f27404h
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 == 0) goto L13
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 != 0) goto L11
            goto L13
        L11:
            r0 = r2
            goto L14
        L13:
            r0 = r1
        L14:
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 == 0) goto L36
            com.google.android.exoplayer2.upstream.n r5 = r6.f27399c
            com.google.android.exoplayer2.upstream.n$b r5 = r5.a()
            com.google.android.exoplayer2.upstream.n$b r5 = r5.h(r7)
            com.google.android.exoplayer2.upstream.n$b r9 = r5.g(r9)
            com.google.android.exoplayer2.upstream.n r9 = r9.a()
            com.google.android.exoplayer2.upstream.cache.a r10 = r6.f27397a     // Catch: java.io.IOException -> L31
            long r9 = r10.a(r9)     // Catch: java.io.IOException -> L31
            goto L38
        L31:
            com.google.android.exoplayer2.upstream.cache.a r9 = r6.f27397a
            com.google.android.exoplayer2.upstream.m.a(r9)
        L36:
            r1 = r2
            r9 = r3
        L38:
            if (r1 != 0) goto L5d
            r6.g()
            com.google.android.exoplayer2.upstream.n r9 = r6.f27399c
            com.google.android.exoplayer2.upstream.n$b r9 = r9.a()
            com.google.android.exoplayer2.upstream.n$b r9 = r9.h(r7)
            com.google.android.exoplayer2.upstream.n$b r9 = r9.g(r3)
            com.google.android.exoplayer2.upstream.n r9 = r9.a()
            com.google.android.exoplayer2.upstream.cache.a r10 = r6.f27397a     // Catch: java.io.IOException -> L56
            long r9 = r10.a(r9)     // Catch: java.io.IOException -> L56
            goto L5d
        L56:
            r7 = move-exception
            com.google.android.exoplayer2.upstream.cache.a r8 = r6.f27397a
            com.google.android.exoplayer2.upstream.m.a(r8)
            throw r7
        L5d:
            if (r0 == 0) goto L6a
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L6a
            long r9 = r9 + r7
            r6.e(r9)     // Catch: java.io.IOException -> L68
            goto L6a
        L68:
            r7 = move-exception
            goto L8b
        L6a:
            r9 = r2
            r10 = r9
        L6c:
            r1 = -1
            if (r9 == r1) goto L83
            r6.g()     // Catch: java.io.IOException -> L68
            com.google.android.exoplayer2.upstream.cache.a r9 = r6.f27397a     // Catch: java.io.IOException -> L68
            byte[] r3 = r6.f27401e     // Catch: java.io.IOException -> L68
            int r4 = r3.length     // Catch: java.io.IOException -> L68
            int r9 = r9.read(r3, r2, r4)     // Catch: java.io.IOException -> L68
            if (r9 == r1) goto L6c
            long r3 = (long) r9     // Catch: java.io.IOException -> L68
            r6.d(r3)     // Catch: java.io.IOException -> L68
            int r10 = r10 + r9
            goto L6c
        L83:
            if (r0 == 0) goto L91
            long r0 = (long) r10     // Catch: java.io.IOException -> L68
            long r7 = r7 + r0
            r6.e(r7)     // Catch: java.io.IOException -> L68
            goto L91
        L8b:
            com.google.android.exoplayer2.upstream.cache.a r8 = r6.f27397a
            com.google.android.exoplayer2.upstream.m.a(r8)
            throw r7
        L91:
            com.google.android.exoplayer2.upstream.cache.a r7 = r6.f27397a
            r7.close()
            long r7 = (long) r10
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.i.f(long, long):long");
    }

    private void g() {
        if (this.f27406j) {
            throw new InterruptedIOException();
        }
    }

    public void a() {
        g();
        Cache cache = this.f27398b;
        String str = this.f27400d;
        com.google.android.exoplayer2.upstream.n nVar = this.f27399c;
        this.f27405i = cache.a(str, nVar.f27497g, nVar.f27498h);
        com.google.android.exoplayer2.upstream.n nVar2 = this.f27399c;
        long j11 = nVar2.f27498h;
        if (j11 != -1) {
            this.f27404h = nVar2.f27497g + j11;
        } else {
            long a11 = l.a(this.f27398b.getContentMetadata(this.f27400d));
            if (a11 == -1) {
                a11 = -1;
            }
            this.f27404h = a11;
        }
        a aVar = this.f27402f;
        if (aVar != null) {
            aVar.a(c(), this.f27405i, 0L);
        }
        while (true) {
            long j12 = this.f27404h;
            if (j12 != -1 && this.f27403g >= j12) {
                return;
            }
            g();
            long j13 = this.f27404h;
            long cachedLength = this.f27398b.getCachedLength(this.f27400d, this.f27403g, j13 == -1 ? Long.MAX_VALUE : j13 - this.f27403g);
            if (cachedLength > 0) {
                this.f27403g += cachedLength;
            } else {
                long j14 = -cachedLength;
                if (j14 == Long.MAX_VALUE) {
                    j14 = -1;
                }
                long j15 = this.f27403g;
                this.f27403g = j15 + f(j15, j14);
            }
        }
    }

    public void b() {
        this.f27406j = true;
    }
}
