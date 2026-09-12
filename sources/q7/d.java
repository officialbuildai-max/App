package q7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import q7.a;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private q7.a f73271a;

    /* renamed from: b, reason: collision with root package name */
    private e8.c f73272b;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f73273a;

        /* renamed from: b, reason: collision with root package name */
        private String f73274b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f73275c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f73276d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f73277e;

        /* renamed from: f, reason: collision with root package name */
        private String f73278f;

        /* renamed from: g, reason: collision with root package name */
        private int f73279g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f73280h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f73281i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f73282j;

        /* renamed from: k, reason: collision with root package name */
        private u7.b f73283k;

        /* renamed from: l, reason: collision with root package name */
        private x7.b f73284l;

        /* renamed from: m, reason: collision with root package name */
        private w7.b f73285m;

        /* renamed from: n, reason: collision with root package name */
        private z7.b f73286n;

        /* renamed from: o, reason: collision with root package name */
        private y7.b f73287o;

        /* renamed from: p, reason: collision with root package name */
        private t7.a f73288p;

        /* renamed from: q, reason: collision with root package name */
        private Map f73289q;

        /* renamed from: r, reason: collision with root package name */
        private List f73290r;

        /* renamed from: s, reason: collision with root package name */
        private e8.c f73291s;

        public a() {
            e.a();
        }

        public d t() {
            return new d(this);
        }

        public void u(Object[] objArr) {
            t().b(objArr);
        }

        public void v(Object[] objArr) {
            t().d(objArr);
        }

        public void w(Object[] objArr) {
            t().f(objArr);
        }

        public a x(String str) {
            this.f73274b = str;
            return this;
        }

        public void y(Object[] objArr) {
            t().j(objArr);
        }

        public void z(Object[] objArr) {
            t().k(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(q7.a aVar, e8.c cVar) {
        this.f73271a = aVar;
        this.f73272b = cVar;
    }

    d(a aVar) {
        a.C0920a c0920a = new a.C0920a(e.f73293b);
        if (aVar.f73273a != 0) {
            c0920a.B(aVar.f73273a);
        }
        if (aVar.f73274b != null) {
            c0920a.E(aVar.f73274b);
        }
        if (aVar.f73276d) {
            if (aVar.f73275c) {
                c0920a.x();
            } else {
                c0920a.u();
            }
        }
        if (aVar.f73280h) {
            if (aVar.f73277e) {
                c0920a.w(aVar.f73278f, aVar.f73279g);
            } else {
                c0920a.t();
            }
        }
        if (aVar.f73282j) {
            if (aVar.f73281i) {
                c0920a.v();
            } else {
                c0920a.s();
            }
        }
        if (aVar.f73283k != null) {
            c0920a.A(aVar.f73283k);
        }
        if (aVar.f73284l != null) {
            c0920a.H(aVar.f73284l);
        }
        if (aVar.f73285m != null) {
            c0920a.G(aVar.f73285m);
        }
        if (aVar.f73286n != null) {
            c0920a.F(aVar.f73286n);
        }
        if (aVar.f73287o != null) {
            c0920a.D(aVar.f73287o);
        }
        if (aVar.f73288p != null) {
            c0920a.q(aVar.f73288p);
        }
        if (aVar.f73289q != null) {
            c0920a.C(aVar.f73289q);
        }
        if (aVar.f73290r != null) {
            c0920a.z(aVar.f73290r);
        }
        this.f73271a = c0920a.r();
        if (aVar.f73291s != null) {
            this.f73272b = aVar.f73291s;
        } else {
            this.f73272b = e.f73294c;
        }
    }

    private void h(int i11, Object[] objArr) {
        if (i11 < this.f73271a.f73236a) {
            return;
        }
        i(i11, Arrays.deepToString(objArr));
    }

    private void i(int i11, String str) {
        String str2;
        String sb2;
        q7.a aVar = this.f73271a;
        String str3 = aVar.f73237b;
        String a11 = aVar.f73238c ? aVar.f73246k.a(Thread.currentThread()) : null;
        q7.a aVar2 = this.f73271a;
        if (aVar2.f73239d) {
            y7.b bVar = aVar2.f73247l;
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            q7.a aVar3 = this.f73271a;
            str2 = bVar.a(d8.a.b(stackTrace, aVar3.f73240e, aVar3.f73241f));
        } else {
            str2 = null;
        }
        if (this.f73271a.f73250o != null) {
            b bVar2 = new b(i11, str3, a11, str2, str);
            for (a8.a aVar4 : this.f73271a.f73250o) {
                bVar2 = aVar4.a(bVar2);
                if (bVar2 == null) {
                    return;
                }
                if (bVar2.f73267b == null || bVar2.f73268c == null) {
                    b8.b.e().c("Interceptor " + aVar4 + " should not remove the tag or message of a log, if you don't want to print this log, just return a null when intercept.");
                    return;
                }
            }
            i11 = bVar2.f73266a;
            str3 = bVar2.f73267b;
            a11 = bVar2.f73269d;
            str2 = bVar2.f73270e;
            str = bVar2.f73268c;
        }
        e8.c cVar = this.f73272b;
        q7.a aVar5 = this.f73271a;
        if (aVar5.f73242g) {
            sb2 = aVar5.f73248m.a(new String[]{a11, str2, str});
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(a11 != null ? a11 + b8.c.f16330a : "");
            sb3.append(str2 != null ? str2 + b8.c.f16330a : "");
            sb3.append(str);
            sb2 = sb3.toString();
        }
        cVar.a(i11, str3, sb2);
    }

    public void a(String str) {
        g(3, str);
    }

    public void b(Object[] objArr) {
        h(3, objArr);
    }

    public void c(String str) {
        g(6, str);
    }

    public void d(Object[] objArr) {
        h(6, objArr);
    }

    public void e(String str) {
        g(4, str);
    }

    public void f(Object[] objArr) {
        h(4, objArr);
    }

    void g(int i11, String str) {
        if (i11 < this.f73271a.f73236a) {
            return;
        }
        if (str == null) {
            str = "";
        }
        i(i11, str);
    }

    public void j(Object[] objArr) {
        h(2, objArr);
    }

    public void k(Object[] objArr) {
        h(5, objArr);
    }
}
