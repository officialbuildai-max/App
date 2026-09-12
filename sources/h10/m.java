package h10;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import h10.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class m extends l {

    /* renamed from: c, reason: collision with root package name */
    private final x f64253c;

    /* renamed from: d, reason: collision with root package name */
    private final int f64254d;

    /* renamed from: e, reason: collision with root package name */
    private final int f64255e;

    /* renamed from: f, reason: collision with root package name */
    private final int f64256f;

    /* renamed from: g, reason: collision with root package name */
    private int f64257g;

    /* renamed from: h, reason: collision with root package name */
    private int f64258h;

    /* renamed from: i, reason: collision with root package name */
    private b f64259i;

    /* renamed from: j, reason: collision with root package name */
    private b f64260j;

    /* renamed from: k, reason: collision with root package name */
    private b f64261k;

    /* renamed from: l, reason: collision with root package name */
    private b f64262l;

    /* renamed from: m, reason: collision with root package name */
    private c f64263m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(x xVar, int i11, String str, String str2, String str3, Object obj) {
        super(458752);
        this.f64253c = xVar;
        this.f64254d = i11;
        this.f64255e = xVar.D(str);
        this.f64256f = xVar.D(str2);
        if (str3 != null) {
            this.f64257g = xVar.D(str3);
        }
        if (obj != null) {
            this.f64258h = xVar.d(obj).f64353a;
        }
    }

    @Override // h10.l
    public a a(String str, boolean z10) {
        d dVar = new d();
        dVar.k(this.f64253c.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64253c, dVar, this.f64259i);
            this.f64259i = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64253c, dVar, this.f64260j);
        this.f64260j = bVar2;
        return bVar2;
    }

    @Override // h10.l
    public void b(c cVar) {
        cVar.f64187c = this.f64263m;
        this.f64263m = cVar;
    }

    @Override // h10.l
    public void c() {
    }

    @Override // h10.l
    public a d(int i11, z zVar, String str, boolean z10) {
        d dVar = new d();
        a0.a(i11, dVar);
        z.d(zVar, dVar);
        dVar.k(this.f64253c.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64253c, dVar, this.f64261k);
            this.f64261k = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64253c, dVar, this.f64262l);
        this.f64262l = bVar2;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(c.a aVar) {
        aVar.b(this.f64263m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        int i11;
        if (this.f64258h != 0) {
            this.f64253c.D("ConstantValue");
            i11 = 16;
        } else {
            i11 = 8;
        }
        if ((this.f64254d & 4096) != 0 && this.f64253c.R() < 49) {
            this.f64253c.D("Synthetic");
            i11 += 6;
        }
        if (this.f64257g != 0) {
            this.f64253c.D(RequestParameters.SIGNATURE);
            i11 += 8;
        }
        if ((this.f64254d & 131072) != 0) {
            this.f64253c.D("Deprecated");
            i11 += 6;
        }
        b bVar = this.f64259i;
        if (bVar != null) {
            i11 += bVar.f("RuntimeVisibleAnnotations");
        }
        b bVar2 = this.f64260j;
        if (bVar2 != null) {
            i11 += bVar2.f("RuntimeInvisibleAnnotations");
        }
        b bVar3 = this.f64261k;
        if (bVar3 != null) {
            i11 += bVar3.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar4 = this.f64262l;
        if (bVar4 != null) {
            i11 += bVar4.f("RuntimeInvisibleTypeAnnotations");
        }
        c cVar = this.f64263m;
        return cVar != null ? i11 + cVar.a(this.f64253c) : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(d dVar) {
        boolean z10 = this.f64253c.R() < 49;
        dVar.k((~(z10 ? 4096 : 0)) & this.f64254d).k(this.f64255e).k(this.f64256f);
        int i11 = this.f64258h == 0 ? 0 : 1;
        int i12 = this.f64254d;
        if ((i12 & 4096) != 0 && z10) {
            i11++;
        }
        if (this.f64257g != 0) {
            i11++;
        }
        if ((i12 & 131072) != 0) {
            i11++;
        }
        if (this.f64259i != null) {
            i11++;
        }
        if (this.f64260j != null) {
            i11++;
        }
        if (this.f64261k != null) {
            i11++;
        }
        if (this.f64262l != null) {
            i11++;
        }
        c cVar = this.f64263m;
        if (cVar != null) {
            i11 += cVar.c();
        }
        dVar.k(i11);
        if (this.f64258h != 0) {
            dVar.k(this.f64253c.D("ConstantValue")).i(2).k(this.f64258h);
        }
        if ((4096 & this.f64254d) != 0 && z10) {
            dVar.k(this.f64253c.D("Synthetic")).i(0);
        }
        if (this.f64257g != 0) {
            dVar.k(this.f64253c.D(RequestParameters.SIGNATURE)).i(2).k(this.f64257g);
        }
        if ((this.f64254d & 131072) != 0) {
            dVar.k(this.f64253c.D("Deprecated")).i(0);
        }
        b bVar = this.f64259i;
        if (bVar != null) {
            bVar.h(this.f64253c.D("RuntimeVisibleAnnotations"), dVar);
        }
        b bVar2 = this.f64260j;
        if (bVar2 != null) {
            bVar2.h(this.f64253c.D("RuntimeInvisibleAnnotations"), dVar);
        }
        b bVar3 = this.f64261k;
        if (bVar3 != null) {
            bVar3.h(this.f64253c.D("RuntimeVisibleTypeAnnotations"), dVar);
        }
        b bVar4 = this.f64262l;
        if (bVar4 != null) {
            bVar4.h(this.f64253c.D("RuntimeInvisibleTypeAnnotations"), dVar);
        }
        c cVar2 = this.f64263m;
        if (cVar2 != null) {
            cVar2.e(this.f64253c, dVar);
        }
    }
}
