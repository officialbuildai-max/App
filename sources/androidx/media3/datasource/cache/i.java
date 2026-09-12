package androidx.media3.datasource.cache;

import java.io.InterruptedIOException;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.datasource.cache.a f10906a;

    /* renamed from: b, reason: collision with root package name */
    private final Cache f10907b;

    /* renamed from: c, reason: collision with root package name */
    private final w1.h f10908c;

    /* renamed from: d, reason: collision with root package name */
    private final String f10909d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f10910e;

    /* renamed from: f, reason: collision with root package name */
    private final a f10911f;

    /* renamed from: g, reason: collision with root package name */
    private long f10912g;

    /* renamed from: h, reason: collision with root package name */
    private long f10913h;

    /* renamed from: i, reason: collision with root package name */
    private long f10914i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f10915j;

    /* loaded from: classes2.dex */
    public interface a {
        void a(long j11, long j12, long j13);
    }

    public i(androidx.media3.datasource.cache.a aVar, w1.h hVar, byte[] bArr, a aVar2) {
        this.f10906a = aVar;
        this.f10907b = aVar.e();
        this.f10908c = hVar;
        this.f10910e = bArr == null ? new byte[131072] : bArr;
        this.f10911f = aVar2;
        this.f10909d = aVar.f().a(hVar);
        this.f10912g = hVar.f77640g;
    }

    private long c() {
        long j11 = this.f10913h;
        if (j11 == -1) {
            return -1L;
        }
        return j11 - this.f10908c.f77640g;
    }

    private void d(long j11) {
        this.f10914i += j11;
        a aVar = this.f10911f;
        if (aVar != null) {
            aVar.a(c(), this.f10914i, j11);
        }
    }

    private void e(long j11) {
        if (this.f10913h == j11) {
            return;
        }
        this.f10913h = j11;
        a aVar = this.f10911f;
        if (aVar != null) {
            aVar.a(c(), this.f10914i, 0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[Catch: Exception -> 0x0068, TryCatch #0 {Exception -> 0x0068, blocks: (B:25:0x0064, B:33:0x006f, B:36:0x007d, B:42:0x0085), top: B:24:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #0 {Exception -> 0x0068, blocks: (B:25:0x0064, B:33:0x006f, B:36:0x007d, B:42:0x0085), top: B:24:0x0064 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long f(long r7, long r9) {
        /*
            r6 = this;
            long r0 = r7 + r9
            long r2 = r6.f10913h
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
            w1.h r5 = r6.f10908c
            w1.h$b r5 = r5.a()
            w1.h$b r5 = r5.h(r7)
            w1.h$b r9 = r5.g(r9)
            w1.h r9 = r9.a()
            androidx.media3.datasource.cache.a r10 = r6.f10906a     // Catch: java.lang.Exception -> L31
            long r9 = r10.a(r9)     // Catch: java.lang.Exception -> L31
            goto L38
        L31:
            androidx.media3.datasource.cache.a r9 = r6.f10906a
            w1.g.a(r9)
        L36:
            r1 = r2
            r9 = r3
        L38:
            if (r1 != 0) goto L5d
            r6.g()
            w1.h r9 = r6.f10908c
            w1.h$b r9 = r9.a()
            w1.h$b r9 = r9.h(r7)
            w1.h$b r9 = r9.g(r3)
            w1.h r9 = r9.a()
            androidx.media3.datasource.cache.a r10 = r6.f10906a     // Catch: java.lang.Exception -> L56
            long r9 = r10.a(r9)     // Catch: java.lang.Exception -> L56
            goto L5d
        L56:
            r7 = move-exception
            androidx.media3.datasource.cache.a r8 = r6.f10906a
            w1.g.a(r8)
            throw r7
        L5d:
            if (r0 == 0) goto L6a
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L6a
            long r9 = r9 + r7
            r6.e(r9)     // Catch: java.lang.Exception -> L68
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
            r6.g()     // Catch: java.lang.Exception -> L68
            androidx.media3.datasource.cache.a r9 = r6.f10906a     // Catch: java.lang.Exception -> L68
            byte[] r3 = r6.f10910e     // Catch: java.lang.Exception -> L68
            int r4 = r3.length     // Catch: java.lang.Exception -> L68
            int r9 = r9.read(r3, r2, r4)     // Catch: java.lang.Exception -> L68
            if (r9 == r1) goto L6c
            long r3 = (long) r9     // Catch: java.lang.Exception -> L68
            r6.d(r3)     // Catch: java.lang.Exception -> L68
            int r10 = r10 + r9
            goto L6c
        L83:
            if (r0 == 0) goto L91
            long r0 = (long) r10     // Catch: java.lang.Exception -> L68
            long r7 = r7 + r0
            r6.e(r7)     // Catch: java.lang.Exception -> L68
            goto L91
        L8b:
            androidx.media3.datasource.cache.a r8 = r6.f10906a
            w1.g.a(r8)
            throw r7
        L91:
            androidx.media3.datasource.cache.a r7 = r6.f10906a
            r7.close()
            long r7 = (long) r10
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.i.f(long, long):long");
    }

    private void g() {
        if (this.f10915j) {
            throw new InterruptedIOException();
        }
    }

    public void a() {
        g();
        Cache cache = this.f10907b;
        String str = this.f10909d;
        w1.h hVar = this.f10908c;
        this.f10914i = cache.a(str, hVar.f77640g, hVar.f77641h);
        w1.h hVar2 = this.f10908c;
        long j11 = hVar2.f77641h;
        if (j11 != -1) {
            this.f10913h = hVar2.f77640g + j11;
        } else {
            long a11 = l.a(this.f10907b.getContentMetadata(this.f10909d));
            if (a11 == -1) {
                a11 = -1;
            }
            this.f10913h = a11;
        }
        a aVar = this.f10911f;
        if (aVar != null) {
            aVar.a(c(), this.f10914i, 0L);
        }
        while (true) {
            long j12 = this.f10913h;
            if (j12 != -1 && this.f10912g >= j12) {
                return;
            }
            g();
            long j13 = this.f10913h;
            long cachedLength = this.f10907b.getCachedLength(this.f10909d, this.f10912g, j13 == -1 ? Long.MAX_VALUE : j13 - this.f10912g);
            if (cachedLength > 0) {
                this.f10912g += cachedLength;
            } else {
                long j14 = -cachedLength;
                if (j14 == Long.MAX_VALUE) {
                    j14 = -1;
                }
                long j15 = this.f10912g;
                this.f10912g = j15 + f(j15, j14);
            }
        }
    }

    public void b() {
        this.f10915j = true;
    }
}
