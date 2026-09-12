package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.p0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class CacheDataSink implements com.google.android.exoplayer2.upstream.i {

    /* renamed from: a, reason: collision with root package name */
    private final Cache f27331a;

    /* renamed from: b, reason: collision with root package name */
    private final long f27332b;

    /* renamed from: c, reason: collision with root package name */
    private final int f27333c;

    /* renamed from: d, reason: collision with root package name */
    private com.google.android.exoplayer2.upstream.n f27334d;

    /* renamed from: e, reason: collision with root package name */
    private long f27335e;

    /* renamed from: f, reason: collision with root package name */
    private File f27336f;

    /* renamed from: g, reason: collision with root package name */
    private OutputStream f27337g;

    /* renamed from: h, reason: collision with root package name */
    private long f27338h;

    /* renamed from: i, reason: collision with root package name */
    private long f27339i;

    /* renamed from: j, reason: collision with root package name */
    private r f27340j;

    /* loaded from: classes3.dex */
    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a implements i.a {

        /* renamed from: a, reason: collision with root package name */
        private Cache f27341a;

        /* renamed from: b, reason: collision with root package name */
        private long f27342b = 5242880;

        /* renamed from: c, reason: collision with root package name */
        private int f27343c = com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_BUFFER_SIZE;

        public a a(Cache cache) {
            this.f27341a = cache;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.i.a
        public com.google.android.exoplayer2.upstream.i createDataSink() {
            return new CacheDataSink((Cache) com.google.android.exoplayer2.util.a.e(this.f27341a), this.f27342b, this.f27343c);
        }
    }

    public CacheDataSink(Cache cache, long j11, int i11) {
        com.google.android.exoplayer2.util.a.h(j11 > 0 || j11 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j11 != -1 && j11 < 2097152) {
            com.google.android.exoplayer2.util.s.i("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f27331a = (Cache) com.google.android.exoplayer2.util.a.e(cache);
        this.f27332b = j11 == -1 ? Long.MAX_VALUE : j11;
        this.f27333c = i11;
    }

    private void b() {
        OutputStream outputStream = this.f27337g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            p0.n(this.f27337g);
            this.f27337g = null;
            File file = (File) p0.j(this.f27336f);
            this.f27336f = null;
            this.f27331a.d(file, this.f27338h);
        } catch (Throwable th2) {
            p0.n(this.f27337g);
            this.f27337g = null;
            File file2 = (File) p0.j(this.f27336f);
            this.f27336f = null;
            file2.delete();
            throw th2;
        }
    }

    private void c(com.google.android.exoplayer2.upstream.n nVar) {
        long j11 = nVar.f27498h;
        this.f27336f = this.f27331a.startFile((String) p0.j(nVar.f27499i), nVar.f27497g + this.f27339i, j11 != -1 ? Math.min(j11 - this.f27339i, this.f27335e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f27336f);
        if (this.f27333c > 0) {
            r rVar = this.f27340j;
            if (rVar == null) {
                this.f27340j = new r(fileOutputStream, this.f27333c);
            } else {
                rVar.b(fileOutputStream);
            }
            this.f27337g = this.f27340j;
        } else {
            this.f27337g = fileOutputStream;
        }
        this.f27338h = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void a(com.google.android.exoplayer2.upstream.n nVar) {
        com.google.android.exoplayer2.util.a.e(nVar.f27499i);
        if (nVar.f27498h == -1 && nVar.d(2)) {
            this.f27334d = null;
            return;
        }
        this.f27334d = nVar;
        this.f27335e = nVar.d(4) ? this.f27332b : Long.MAX_VALUE;
        this.f27339i = 0L;
        try {
            c(nVar);
        } catch (IOException e11) {
            throw new CacheDataSinkException(e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        if (this.f27334d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e11) {
            throw new CacheDataSinkException(e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void write(byte[] bArr, int i11, int i12) {
        com.google.android.exoplayer2.upstream.n nVar = this.f27334d;
        if (nVar == null) {
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            try {
                if (this.f27338h == this.f27335e) {
                    b();
                    c(nVar);
                }
                int min = (int) Math.min(i12 - i13, this.f27335e - this.f27338h);
                ((OutputStream) p0.j(this.f27337g)).write(bArr, i11 + i13, min);
                i13 += min;
                long j11 = min;
                this.f27338h += j11;
                this.f27339i += j11;
            } catch (IOException e11) {
                throw new CacheDataSinkException(e11);
            }
        }
    }
}
