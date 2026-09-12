package lf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.v;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import mf.d;
import mf.e;
import mf.f;
import mf.g;
import mf.h;
import mf.i;
import mf.k;
import mf.l;
import mf.m;
import mf.n;
import mf.o;
import mf.p;
import mf.q;
import mf.r;
import of.c;
import pf.b;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final j f68941a;

    /* renamed from: b, reason: collision with root package name */
    private final j f68942b;

    /* renamed from: c, reason: collision with root package name */
    private final nf.a f68943c;

    /* renamed from: d, reason: collision with root package name */
    private final c f68944d;

    /* renamed from: e, reason: collision with root package name */
    private mf.j f68945e;

    /* renamed from: f, reason: collision with root package name */
    private mf.j f68946f;

    /* renamed from: g, reason: collision with root package name */
    private mf.j f68947g;

    /* renamed from: h, reason: collision with root package name */
    private mf.j f68948h;

    /* renamed from: i, reason: collision with root package name */
    private mf.j f68949i;

    /* renamed from: j, reason: collision with root package name */
    private mf.j f68950j;

    /* renamed from: k, reason: collision with root package name */
    private mf.j f68951k;

    /* renamed from: l, reason: collision with root package name */
    private mf.j f68952l;

    /* renamed from: m, reason: collision with root package name */
    private mf.j f68953m;

    /* renamed from: n, reason: collision with root package name */
    private mf.j f68954n;

    /* renamed from: o, reason: collision with root package name */
    private mf.j f68955o;

    /* renamed from: p, reason: collision with root package name */
    private mf.j f68956p;

    /* renamed from: q, reason: collision with root package name */
    private mf.j f68957q;

    /* renamed from: r, reason: collision with root package name */
    private mf.j f68958r;

    /* renamed from: s, reason: collision with root package name */
    private mf.j f68959s;

    /* renamed from: t, reason: collision with root package name */
    private mf.j f68960t;

    /* renamed from: u, reason: collision with root package name */
    private mf.j f68961u;

    public a(j jVar, nf.a aVar) {
        this.f68941a = jVar;
        this.f68943c = aVar;
        this.f68942b = new j(aVar.n());
        this.f68944d = new c();
    }

    public a(InputStream inputStream, InputStream inputStream2) {
        this(new j(inputStream), new nf.a(inputStream2));
    }

    public void a(File file) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                b(bufferedOutputStream2);
                b.a(bufferedOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                b.a(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void b(OutputStream outputStream) {
        int i11;
        int b11;
        nf.a aVar = this.f68943c;
        if (aVar == null) {
            throw new IllegalArgumentException("patch file is null.");
        }
        if (aVar.y() > 2 && (i11 = this.f68941a.h().f40729v) != (b11 = this.f68943c.b())) {
            throw new IOException("old dex version mismatch! expetced: " + b11 + ", actual: " + i11);
        }
        byte[] f11 = this.f68941a.f(false);
        if (f11 == null) {
            throw new IOException("failed to compute old dex's signature.");
        }
        byte[] c11 = this.f68943c.c();
        if (gf.c.d(f11, c11) != 0) {
            throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", Arrays.toString(f11), Arrays.toString(c11)));
        }
        v h11 = this.f68942b.h();
        h11.f40729v = this.f68943c.m();
        v.a aVar2 = h11.f40708a;
        aVar2.f40737d = 0;
        aVar2.f40736c = 1;
        h11.f40717j.f40736c = 1;
        h11.f40709b.f40737d = this.f68943c.v();
        h11.f40710c.f40737d = this.f68943c.w();
        h11.f40718k.f40737d = this.f68943c.x();
        h11.f40711d.f40737d = this.f68943c.t();
        h11.f40712e.f40737d = this.f68943c.p();
        h11.f40713f.f40737d = this.f68943c.s();
        if (this.f68943c.y() > 2) {
            h11.f40715h.f40737d = this.f68943c.h();
            h11.f40716i.f40737d = this.f68943c.r();
        }
        h11.f40714g.f40737d = this.f68943c.j();
        h11.f40717j.f40737d = this.f68943c.q();
        h11.f40723p.f40737d = this.f68943c.u();
        h11.f40725r.f40737d = this.f68943c.d();
        h11.f40720m.f40737d = this.f68943c.f();
        h11.f40719l.f40737d = this.f68943c.e();
        h11.f40727t.f40737d = this.f68943c.g();
        h11.f40726s.f40737d = this.f68943c.o();
        h11.f40724q.f40737d = this.f68943c.l();
        h11.f40722o.f40737d = this.f68943c.k();
        h11.f40721n.f40737d = this.f68943c.i();
        h11.f40732y = this.f68943c.n();
        Arrays.sort(h11.f40728u);
        h11.a();
        this.f68945e = new p(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68946f = new q(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68947g = new n(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68948h = new k(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68949i = new m(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        if (this.f68943c.y() > 2) {
            this.f68950j = new e(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
            this.f68951k = new l(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        }
        this.f68952l = new g(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68953m = new r(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68954n = new mf.b(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68955o = new mf.c(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68956p = new f(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68957q = new h(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68958r = new i(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68959s = new mf.a(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68960t = new o(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68961u = new d(this.f68943c, this.f68941a, this.f68942b, this.f68944d);
        this.f68945e.c();
        this.f68946f.c();
        this.f68953m.c();
        this.f68947g.c();
        this.f68948h.c();
        this.f68949i.c();
        if (this.f68943c.y() > 2) {
            this.f68951k.c();
        }
        this.f68959s.c();
        this.f68955o.c();
        this.f68954n.c();
        this.f68961u.c();
        this.f68958r.c();
        this.f68957q.c();
        this.f68956p.c();
        this.f68960t.c();
        if (this.f68943c.y() > 2) {
            this.f68950j.c();
        }
        this.f68952l.c();
        h11.f(this.f68942b.l(h11.f40708a.f40737d));
        h11.g(this.f68942b.l(h11.f40717j.f40737d));
        this.f68942b.n();
        this.f68942b.o(outputStream);
    }
}
