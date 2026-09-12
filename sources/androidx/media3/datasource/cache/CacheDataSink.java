package androidx.media3.datasource.cache;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.u;
import androidx.media3.datasource.cache.Cache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import w1.d;

/* loaded from: classes2.dex */
public final class CacheDataSink implements w1.d {

    /* renamed from: a, reason: collision with root package name */
    private final Cache f10840a;

    /* renamed from: b, reason: collision with root package name */
    private final long f10841b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10842c;

    /* renamed from: d, reason: collision with root package name */
    private w1.h f10843d;

    /* renamed from: e, reason: collision with root package name */
    private long f10844e;

    /* renamed from: f, reason: collision with root package name */
    private File f10845f;

    /* renamed from: g, reason: collision with root package name */
    private OutputStream f10846g;

    /* renamed from: h, reason: collision with root package name */
    private long f10847h;

    /* renamed from: i, reason: collision with root package name */
    private long f10848i;

    /* renamed from: j, reason: collision with root package name */
    private r f10849j;

    /* loaded from: classes2.dex */
    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private Cache f10850a;

        /* renamed from: b, reason: collision with root package name */
        private long f10851b = 5242880;

        /* renamed from: c, reason: collision with root package name */
        private int f10852c = com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_BUFFER_SIZE;

        public a a(Cache cache) {
            this.f10850a = cache;
            return this;
        }

        @Override // w1.d.a
        public w1.d createDataSink() {
            return new CacheDataSink((Cache) androidx.media3.common.util.a.e(this.f10850a), this.f10851b, this.f10852c);
        }
    }

    public CacheDataSink(Cache cache, long j11, int i11) {
        androidx.media3.common.util.a.h(j11 > 0 || j11 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j11 != -1 && j11 < 2097152) {
            u.h("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f10840a = (Cache) androidx.media3.common.util.a.e(cache);
        this.f10841b = j11 == -1 ? Long.MAX_VALUE : j11;
        this.f10842c = i11;
    }

    private void b() {
        OutputStream outputStream = this.f10846g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            a1.m(this.f10846g);
            this.f10846g = null;
            File file = (File) a1.i(this.f10845f);
            this.f10845f = null;
            this.f10840a.d(file, this.f10847h);
        } catch (Throwable th2) {
            a1.m(this.f10846g);
            this.f10846g = null;
            File file2 = (File) a1.i(this.f10845f);
            this.f10845f = null;
            file2.delete();
            throw th2;
        }
    }

    private void c(w1.h hVar) {
        long j11 = hVar.f77641h;
        this.f10845f = this.f10840a.startFile((String) a1.i(hVar.f77642i), hVar.f77640g + this.f10848i, j11 != -1 ? Math.min(j11 - this.f10848i, this.f10844e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f10845f);
        if (this.f10842c > 0) {
            r rVar = this.f10849j;
            if (rVar == null) {
                this.f10849j = new r(fileOutputStream, this.f10842c);
            } else {
                rVar.b(fileOutputStream);
            }
            this.f10846g = this.f10849j;
        } else {
            this.f10846g = fileOutputStream;
        }
        this.f10847h = 0L;
    }

    @Override // w1.d
    public void a(w1.h hVar) {
        androidx.media3.common.util.a.e(hVar.f77642i);
        if (hVar.f77641h == -1 && hVar.d(2)) {
            this.f10843d = null;
            return;
        }
        this.f10843d = hVar;
        this.f10844e = hVar.d(4) ? this.f10841b : Long.MAX_VALUE;
        this.f10848i = 0L;
        try {
            c(hVar);
        } catch (IOException e11) {
            throw new CacheDataSinkException(e11);
        }
    }

    @Override // w1.d
    public void close() {
        if (this.f10843d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e11) {
            throw new CacheDataSinkException(e11);
        }
    }

    @Override // w1.d
    public void write(byte[] bArr, int i11, int i12) {
        w1.h hVar = this.f10843d;
        if (hVar == null) {
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            try {
                if (this.f10847h == this.f10844e) {
                    b();
                    c(hVar);
                }
                int min = (int) Math.min(i12 - i13, this.f10844e - this.f10847h);
                ((OutputStream) a1.i(this.f10846g)).write(bArr, i11 + i13, min);
                i13 += min;
                long j11 = min;
                this.f10847h += j11;
                this.f10848i += j11;
            } catch (IOException e11) {
                throw new CacheDataSinkException(e11);
            }
        }
    }
}
