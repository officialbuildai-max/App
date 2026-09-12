package com.mbridge.msdk.thrid.okhttp;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.p;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    final q f38431a;

    /* renamed from: b, reason: collision with root package name */
    final String f38432b;

    /* renamed from: c, reason: collision with root package name */
    final p f38433c;

    /* renamed from: d, reason: collision with root package name */
    final x f38434d;

    /* renamed from: e, reason: collision with root package name */
    final Map<Class<?>, Object> f38435e;

    /* renamed from: f, reason: collision with root package name */
    private volatile c f38436f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        q f38437a;

        /* renamed from: b, reason: collision with root package name */
        String f38438b;

        /* renamed from: c, reason: collision with root package name */
        p.a f38439c;

        /* renamed from: d, reason: collision with root package name */
        x f38440d;

        /* renamed from: e, reason: collision with root package name */
        Map<Class<?>, Object> f38441e;

        public a() {
            this.f38441e = Collections.emptyMap();
            this.f38438b = "GET";
            this.f38439c = new p.a();
        }

        a(w wVar) {
            this.f38441e = Collections.emptyMap();
            this.f38437a = wVar.f38431a;
            this.f38438b = wVar.f38432b;
            this.f38440d = wVar.f38434d;
            this.f38441e = wVar.f38435e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(wVar.f38435e);
            this.f38439c = wVar.f38433c.a();
        }

        public a a(c cVar) {
            String cVar2 = cVar.toString();
            return cVar2.isEmpty() ? a(HttpHeaders.CACHE_CONTROL) : b(HttpHeaders.CACHE_CONTROL, cVar2);
        }

        public a a(p pVar) {
            this.f38439c = pVar.a();
            return this;
        }

        public a a(q qVar) {
            if (qVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f38437a = qVar;
            return this;
        }

        public a a(x xVar) {
            return a("DELETE", xVar);
        }

        public a a(String str) {
            this.f38439c.b(str);
            return this;
        }

        public a a(String str, x xVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (xVar != null && !com.mbridge.msdk.thrid.okhttp.internal.http.f.a(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (xVar != null || !com.mbridge.msdk.thrid.okhttp.internal.http.f.d(str)) {
                this.f38438b = str;
                this.f38440d = xVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a a(String str, String str2) {
            this.f38439c.a(str, str2);
            return this;
        }

        public w a() {
            if (this.f38437a != null) {
                return new w(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b() {
            return a(com.mbridge.msdk.thrid.okhttp.internal.c.f37958d);
        }

        public a b(x xVar) {
            return a("PATCH", xVar);
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return a(q.b(str));
        }

        public a b(String str, String str2) {
            this.f38439c.c(str, str2);
            return this;
        }

        public a c() {
            return a("GET", (x) null);
        }

        public a c(x xVar) {
            return a("POST", xVar);
        }

        public a d() {
            return a("HEAD", (x) null);
        }

        public a d(x xVar) {
            return a("PUT", xVar);
        }
    }

    w(a aVar) {
        this.f38431a = aVar.f38437a;
        this.f38432b = aVar.f38438b;
        this.f38433c = aVar.f38439c.a();
        this.f38434d = aVar.f38440d;
        this.f38435e = com.mbridge.msdk.thrid.okhttp.internal.c.a(aVar.f38441e);
    }

    public x a() {
        return this.f38434d;
    }

    public String a(String str) {
        return this.f38433c.b(str);
    }

    public c b() {
        c cVar = this.f38436f;
        if (cVar != null) {
            return cVar;
        }
        c a11 = c.a(this.f38433c);
        this.f38436f = a11;
        return a11;
    }

    public p c() {
        return this.f38433c;
    }

    public boolean d() {
        return this.f38431a.h();
    }

    public String e() {
        return this.f38432b;
    }

    public a f() {
        return new a(this);
    }

    public q g() {
        return this.f38431a;
    }

    public String toString() {
        return "Request{method=" + this.f38432b + ", url=" + this.f38431a + ", tags=" + this.f38435e + '}';
    }
}
