package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.p;
import java.io.Closeable;

/* loaded from: classes5.dex */
public final class y implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    final w f38445a;

    /* renamed from: b, reason: collision with root package name */
    final u f38446b;

    /* renamed from: c, reason: collision with root package name */
    final int f38447c;

    /* renamed from: d, reason: collision with root package name */
    final String f38448d;

    /* renamed from: e, reason: collision with root package name */
    final o f38449e;

    /* renamed from: f, reason: collision with root package name */
    final p f38450f;

    /* renamed from: g, reason: collision with root package name */
    final z f38451g;

    /* renamed from: h, reason: collision with root package name */
    final y f38452h;

    /* renamed from: i, reason: collision with root package name */
    final y f38453i;

    /* renamed from: j, reason: collision with root package name */
    final y f38454j;

    /* renamed from: k, reason: collision with root package name */
    final long f38455k;

    /* renamed from: l, reason: collision with root package name */
    final long f38456l;

    /* renamed from: m, reason: collision with root package name */
    private volatile c f38457m;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        w f38458a;

        /* renamed from: b, reason: collision with root package name */
        u f38459b;

        /* renamed from: c, reason: collision with root package name */
        int f38460c;

        /* renamed from: d, reason: collision with root package name */
        String f38461d;

        /* renamed from: e, reason: collision with root package name */
        o f38462e;

        /* renamed from: f, reason: collision with root package name */
        p.a f38463f;

        /* renamed from: g, reason: collision with root package name */
        z f38464g;

        /* renamed from: h, reason: collision with root package name */
        y f38465h;

        /* renamed from: i, reason: collision with root package name */
        y f38466i;

        /* renamed from: j, reason: collision with root package name */
        y f38467j;

        /* renamed from: k, reason: collision with root package name */
        long f38468k;

        /* renamed from: l, reason: collision with root package name */
        long f38469l;

        public a() {
            this.f38460c = -1;
            this.f38463f = new p.a();
        }

        a(y yVar) {
            this.f38460c = -1;
            this.f38458a = yVar.f38445a;
            this.f38459b = yVar.f38446b;
            this.f38460c = yVar.f38447c;
            this.f38461d = yVar.f38448d;
            this.f38462e = yVar.f38449e;
            this.f38463f = yVar.f38450f.a();
            this.f38464g = yVar.f38451g;
            this.f38465h = yVar.f38452h;
            this.f38466i = yVar.f38453i;
            this.f38467j = yVar.f38454j;
            this.f38468k = yVar.f38455k;
            this.f38469l = yVar.f38456l;
        }

        private void a(String str, y yVar) {
            if (yVar.f38451g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (yVar.f38452h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (yVar.f38453i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (yVar.f38454j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        private void b(y yVar) {
            if (yVar.f38451g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(int i11) {
            this.f38460c = i11;
            return this;
        }

        public a a(long j11) {
            this.f38469l = j11;
            return this;
        }

        public a a(o oVar) {
            this.f38462e = oVar;
            return this;
        }

        public a a(p pVar) {
            this.f38463f = pVar.a();
            return this;
        }

        public a a(u uVar) {
            this.f38459b = uVar;
            return this;
        }

        public a a(w wVar) {
            this.f38458a = wVar;
            return this;
        }

        public a a(y yVar) {
            if (yVar != null) {
                a("cacheResponse", yVar);
            }
            this.f38466i = yVar;
            return this;
        }

        public a a(z zVar) {
            this.f38464g = zVar;
            return this;
        }

        public a a(String str) {
            this.f38461d = str;
            return this;
        }

        public a a(String str, String str2) {
            this.f38463f.a(str, str2);
            return this;
        }

        public y a() {
            if (this.f38458a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f38459b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f38460c >= 0) {
                if (this.f38461d != null) {
                    return new y(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f38460c);
        }

        public a b(long j11) {
            this.f38468k = j11;
            return this;
        }

        public a b(String str, String str2) {
            this.f38463f.c(str, str2);
            return this;
        }

        public a c(y yVar) {
            if (yVar != null) {
                a("networkResponse", yVar);
            }
            this.f38465h = yVar;
            return this;
        }

        public a d(y yVar) {
            if (yVar != null) {
                b(yVar);
            }
            this.f38467j = yVar;
            return this;
        }
    }

    y(a aVar) {
        this.f38445a = aVar.f38458a;
        this.f38446b = aVar.f38459b;
        this.f38447c = aVar.f38460c;
        this.f38448d = aVar.f38461d;
        this.f38449e = aVar.f38462e;
        this.f38450f = aVar.f38463f.a();
        this.f38451g = aVar.f38464g;
        this.f38452h = aVar.f38465h;
        this.f38453i = aVar.f38466i;
        this.f38454j = aVar.f38467j;
        this.f38455k = aVar.f38468k;
        this.f38456l = aVar.f38469l;
    }

    public String a(String str, String str2) {
        String b11 = this.f38450f.b(str);
        return b11 != null ? b11 : str2;
    }

    public String b(String str) {
        return a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        z zVar = this.f38451g;
        if (zVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        zVar.close();
    }

    public z d() {
        return this.f38451g;
    }

    public c h() {
        c cVar = this.f38457m;
        if (cVar != null) {
            return cVar;
        }
        c a11 = c.a(this.f38450f);
        this.f38457m = a11;
        return a11;
    }

    public int k() {
        return this.f38447c;
    }

    public o l() {
        return this.f38449e;
    }

    public p m() {
        return this.f38450f;
    }

    public boolean n() {
        int i11 = this.f38447c;
        return i11 >= 200 && i11 < 300;
    }

    public a o() {
        return new a(this);
    }

    public y p() {
        return this.f38454j;
    }

    public long q() {
        return this.f38456l;
    }

    public w r() {
        return this.f38445a;
    }

    public long s() {
        return this.f38455k;
    }

    public String toString() {
        return "Response{protocol=" + this.f38446b + ", code=" + this.f38447c + ", message=" + this.f38448d + ", url=" + this.f38445a.g() + '}';
    }
}
