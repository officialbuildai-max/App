package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.a;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSink;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.File;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;
import w1.d;

/* loaded from: classes2.dex */
public final class a implements androidx.media3.datasource.a {

    /* renamed from: a, reason: collision with root package name */
    private final Cache f10865a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.datasource.a f10866b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.datasource.a f10867c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.datasource.a f10868d;

    /* renamed from: e, reason: collision with root package name */
    private final g f10869e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f10870f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f10871g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f10872h;

    /* renamed from: i, reason: collision with root package name */
    private Uri f10873i;

    /* renamed from: j, reason: collision with root package name */
    private w1.h f10874j;

    /* renamed from: k, reason: collision with root package name */
    private w1.h f10875k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.media3.datasource.a f10876l;

    /* renamed from: m, reason: collision with root package name */
    private long f10877m;

    /* renamed from: n, reason: collision with root package name */
    private long f10878n;

    /* renamed from: o, reason: collision with root package name */
    private long f10879o;

    /* renamed from: p, reason: collision with root package name */
    private h f10880p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f10881q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f10882r;

    /* renamed from: s, reason: collision with root package name */
    private long f10883s;

    /* renamed from: t, reason: collision with root package name */
    private long f10884t;

    /* loaded from: classes2.dex */
    public interface b {
    }

    /* loaded from: classes2.dex */
    public static final class c implements a.InterfaceC0099a {

        /* renamed from: a, reason: collision with root package name */
        private Cache f10885a;

        /* renamed from: c, reason: collision with root package name */
        private d.a f10887c;

        /* renamed from: e, reason: collision with root package name */
        private boolean f10889e;

        /* renamed from: f, reason: collision with root package name */
        private a.InterfaceC0099a f10890f;

        /* renamed from: g, reason: collision with root package name */
        private PriorityTaskManager f10891g;

        /* renamed from: h, reason: collision with root package name */
        private int f10892h;

        /* renamed from: i, reason: collision with root package name */
        private int f10893i;

        /* renamed from: b, reason: collision with root package name */
        private a.InterfaceC0099a f10886b = new FileDataSource.a();

        /* renamed from: d, reason: collision with root package name */
        private g f10888d = g.f10899a;

        private a e(androidx.media3.datasource.a aVar, int i11, int i12) {
            w1.d dVar;
            Cache cache = (Cache) androidx.media3.common.util.a.e(this.f10885a);
            if (this.f10889e || aVar == null) {
                dVar = null;
            } else {
                d.a aVar2 = this.f10887c;
                dVar = aVar2 != null ? aVar2.createDataSink() : new CacheDataSink.a().a(cache).createDataSink();
            }
            return new a(cache, aVar, this.f10886b.createDataSource(), dVar, this.f10888d, i11, this.f10891g, i12, null);
        }

        @Override // androidx.media3.datasource.a.InterfaceC0099a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createDataSource() {
            a.InterfaceC0099a interfaceC0099a = this.f10890f;
            return e(interfaceC0099a != null ? interfaceC0099a.createDataSource() : null, this.f10893i, this.f10892h);
        }

        public a c() {
            a.InterfaceC0099a interfaceC0099a = this.f10890f;
            return e(interfaceC0099a != null ? interfaceC0099a.createDataSource() : null, this.f10893i | 1, -4000);
        }

        public a d() {
            return e(null, this.f10893i | 1, -4000);
        }

        public Cache f() {
            return this.f10885a;
        }

        public g g() {
            return this.f10888d;
        }

        public PriorityTaskManager h() {
            return this.f10891g;
        }

        public c i(Cache cache) {
            this.f10885a = cache;
            return this;
        }

        public c j(a.InterfaceC0099a interfaceC0099a) {
            this.f10890f = interfaceC0099a;
            return this;
        }
    }

    private a(Cache cache, androidx.media3.datasource.a aVar, androidx.media3.datasource.a aVar2, w1.d dVar, g gVar, int i11, PriorityTaskManager priorityTaskManager, int i12, b bVar) {
        this.f10865a = cache;
        this.f10866b = aVar2;
        this.f10869e = gVar == null ? g.f10899a : gVar;
        this.f10870f = (i11 & 1) != 0;
        this.f10871g = (i11 & 2) != 0;
        this.f10872h = (i11 & 4) != 0;
        if (aVar == null) {
            this.f10868d = androidx.media3.datasource.f.f10996a;
            this.f10867c = null;
        } else {
            aVar = priorityTaskManager != null ? new w1.k(aVar, priorityTaskManager, i12) : aVar;
            this.f10868d = aVar;
            this.f10867c = dVar != null ? new w1.m(aVar, dVar) : null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        androidx.media3.datasource.a aVar = this.f10876l;
        if (aVar == null) {
            return;
        }
        try {
            aVar.close();
        } finally {
            this.f10875k = null;
            this.f10876l = null;
            h hVar = this.f10880p;
            if (hVar != null) {
                this.f10865a.g(hVar);
                this.f10880p = null;
            }
        }
    }

    private static Uri g(Cache cache, String str, Uri uri) {
        Uri b11 = l.b(cache.getContentMetadata(str));
        return b11 != null ? b11 : uri;
    }

    private void h(Throwable th2) {
        if (j() || (th2 instanceof Cache.CacheException)) {
            this.f10881q = true;
        }
    }

    private boolean i() {
        return this.f10876l == this.f10868d;
    }

    private boolean j() {
        return this.f10876l == this.f10866b;
    }

    private boolean k() {
        return !j();
    }

    private boolean l() {
        return this.f10876l == this.f10867c;
    }

    private void m() {
    }

    private void n(int i11) {
    }

    private void o(w1.h hVar, boolean z10) {
        h c11;
        long j11;
        w1.h a11;
        androidx.media3.datasource.a aVar;
        String str = (String) a1.i(hVar.f77642i);
        if (this.f10882r) {
            c11 = null;
        } else if (this.f10870f) {
            try {
                c11 = this.f10865a.c(str, this.f10878n, this.f10879o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            c11 = this.f10865a.b(str, this.f10878n, this.f10879o);
        }
        if (c11 == null) {
            aVar = this.f10868d;
            a11 = hVar.a().h(this.f10878n).g(this.f10879o).a();
        } else if (c11.f10903d) {
            Uri fromFile = Uri.fromFile((File) a1.i(c11.f10904e));
            long j12 = c11.f10901b;
            long j13 = this.f10878n - j12;
            long j14 = c11.f10902c - j13;
            long j15 = this.f10879o;
            if (j15 != -1) {
                j14 = Math.min(j14, j15);
            }
            a11 = hVar.a().i(fromFile).k(j12).h(j13).g(j14).a();
            aVar = this.f10866b;
        } else {
            if (c11.d()) {
                j11 = this.f10879o;
            } else {
                j11 = c11.f10902c;
                long j16 = this.f10879o;
                if (j16 != -1) {
                    j11 = Math.min(j11, j16);
                }
            }
            a11 = hVar.a().h(this.f10878n).g(j11).a();
            aVar = this.f10867c;
            if (aVar == null) {
                aVar = this.f10868d;
                this.f10865a.g(c11);
                c11 = null;
            }
        }
        this.f10884t = (this.f10882r || aVar != this.f10868d) ? Long.MAX_VALUE : this.f10878n + OSSConstants.MIN_PART_SIZE_LIMIT;
        if (z10) {
            androidx.media3.common.util.a.g(i());
            if (aVar == this.f10868d) {
                return;
            }
            try {
                d();
            } finally {
            }
        }
        if (c11 != null && c11.b()) {
            this.f10880p = c11;
        }
        this.f10876l = aVar;
        this.f10875k = a11;
        this.f10877m = 0L;
        long a12 = aVar.a(a11);
        n nVar = new n();
        if (a11.f77641h == -1 && a12 != -1) {
            this.f10879o = a12;
            n.g(nVar, this.f10878n + a12);
        }
        if (k()) {
            Uri uri = aVar.getUri();
            this.f10873i = uri;
            n.h(nVar, hVar.f77634a.equals(uri) ? null : this.f10873i);
        }
        if (l()) {
            this.f10865a.h(str, nVar);
        }
    }

    private void p(String str) {
        this.f10879o = 0L;
        if (l()) {
            n nVar = new n();
            n.g(nVar, this.f10878n);
            this.f10865a.h(str, nVar);
        }
    }

    private int q(w1.h hVar) {
        if (this.f10871g && this.f10881q) {
            return 0;
        }
        return (this.f10872h && hVar.f77641h == -1) ? 1 : -1;
    }

    @Override // androidx.media3.datasource.a
    public long a(w1.h hVar) {
        try {
            String a11 = this.f10869e.a(hVar);
            w1.h a12 = hVar.a().f(a11).a();
            this.f10874j = a12;
            this.f10873i = g(this.f10865a, a11, a12.f77634a);
            this.f10878n = hVar.f77640g;
            int q11 = q(hVar);
            boolean z10 = q11 != -1;
            this.f10882r = z10;
            if (z10) {
                n(q11);
            }
            if (this.f10882r) {
                this.f10879o = -1L;
            } else {
                long a13 = l.a(this.f10865a.getContentMetadata(a11));
                this.f10879o = a13;
                if (a13 != -1) {
                    long j11 = a13 - hVar.f77640g;
                    this.f10879o = j11;
                    if (j11 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long j12 = hVar.f77641h;
            if (j12 != -1) {
                long j13 = this.f10879o;
                if (j13 != -1) {
                    j12 = Math.min(j13, j12);
                }
                this.f10879o = j12;
            }
            long j14 = this.f10879o;
            if (j14 > 0 || j14 == -1) {
                o(a12, false);
            }
            long j15 = hVar.f77641h;
            return j15 != -1 ? j15 : this.f10879o;
        } catch (Throwable th2) {
            h(th2);
            throw th2;
        }
    }

    @Override // androidx.media3.datasource.a
    public void c(w1.n nVar) {
        androidx.media3.common.util.a.e(nVar);
        this.f10866b.c(nVar);
        this.f10868d.c(nVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        this.f10874j = null;
        this.f10873i = null;
        this.f10878n = 0L;
        m();
        try {
            d();
        } catch (Throwable th2) {
            h(th2);
            throw th2;
        }
    }

    public Cache e() {
        return this.f10865a;
    }

    public g f() {
        return this.f10869e;
    }

    @Override // androidx.media3.datasource.a
    public Map getResponseHeaders() {
        return k() ? this.f10868d.getResponseHeaders() : Collections.emptyMap();
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        return this.f10873i;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (this.f10879o == 0) {
            return -1;
        }
        w1.h hVar = (w1.h) androidx.media3.common.util.a.e(this.f10874j);
        w1.h hVar2 = (w1.h) androidx.media3.common.util.a.e(this.f10875k);
        try {
            if (this.f10878n >= this.f10884t) {
                o(hVar, true);
            }
            int read = ((androidx.media3.datasource.a) androidx.media3.common.util.a.e(this.f10876l)).read(bArr, i11, i12);
            if (read == -1) {
                if (k()) {
                    long j11 = hVar2.f77641h;
                    if (j11 == -1 || this.f10877m < j11) {
                        p((String) a1.i(hVar.f77642i));
                    }
                }
                long j12 = this.f10879o;
                if (j12 <= 0) {
                    if (j12 == -1) {
                    }
                }
                d();
                o(hVar, false);
                return read(bArr, i11, i12);
            }
            if (j()) {
                this.f10883s += read;
            }
            long j13 = read;
            this.f10878n += j13;
            this.f10877m += j13;
            long j14 = this.f10879o;
            if (j14 != -1) {
                this.f10879o = j14 - j13;
            }
            return read;
        } catch (Throwable th2) {
            h(th2);
            throw th2;
        }
    }
}
