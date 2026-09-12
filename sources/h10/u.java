package h10;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class u extends t {

    /* renamed from: c, reason: collision with root package name */
    private final x f64329c;

    /* renamed from: d, reason: collision with root package name */
    private final int f64330d;

    /* renamed from: e, reason: collision with root package name */
    private final int f64331e;

    /* renamed from: f, reason: collision with root package name */
    private final int f64332f;

    /* renamed from: g, reason: collision with root package name */
    private int f64333g;

    /* renamed from: h, reason: collision with root package name */
    private final d f64334h;

    /* renamed from: i, reason: collision with root package name */
    private int f64335i;

    /* renamed from: j, reason: collision with root package name */
    private final d f64336j;

    /* renamed from: k, reason: collision with root package name */
    private int f64337k;

    /* renamed from: l, reason: collision with root package name */
    private final d f64338l;

    /* renamed from: m, reason: collision with root package name */
    private int f64339m;

    /* renamed from: n, reason: collision with root package name */
    private final d f64340n;

    /* renamed from: o, reason: collision with root package name */
    private int f64341o;

    /* renamed from: p, reason: collision with root package name */
    private final d f64342p;

    /* renamed from: q, reason: collision with root package name */
    private int f64343q;

    /* renamed from: r, reason: collision with root package name */
    private final d f64344r;

    /* renamed from: s, reason: collision with root package name */
    private int f64345s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(x xVar, int i11, int i12, int i13) {
        super(458752);
        this.f64329c = xVar;
        this.f64330d = i11;
        this.f64331e = i12;
        this.f64332f = i13;
        this.f64334h = new d();
        this.f64336j = new d();
        this.f64338l = new d();
        this.f64340n = new d();
        this.f64342p = new d();
        this.f64344r = new d();
    }

    @Override // h10.t
    public void a() {
    }

    @Override // h10.t
    public void b(String str, int i11, String... strArr) {
        this.f64336j.k(this.f64329c.B(str).f64353a).k(i11);
        if (strArr == null) {
            this.f64336j.k(0);
        } else {
            this.f64336j.k(strArr.length);
            for (String str2 : strArr) {
                this.f64336j.k(this.f64329c.y(str2).f64353a);
            }
        }
        this.f64335i++;
    }

    @Override // h10.t
    public void c(String str) {
        this.f64345s = this.f64329c.e(str).f64353a;
    }

    @Override // h10.t
    public void d(String str, int i11, String... strArr) {
        this.f64338l.k(this.f64329c.B(str).f64353a).k(i11);
        if (strArr == null) {
            this.f64338l.k(0);
        } else {
            this.f64338l.k(strArr.length);
            for (String str2 : strArr) {
                this.f64338l.k(this.f64329c.y(str2).f64353a);
            }
        }
        this.f64337k++;
    }

    @Override // h10.t
    public void e(String str) {
        this.f64344r.k(this.f64329c.B(str).f64353a);
        this.f64343q++;
    }

    @Override // h10.t
    public void f(String str, String... strArr) {
        this.f64342p.k(this.f64329c.e(str).f64353a);
        this.f64342p.k(strArr.length);
        for (String str2 : strArr) {
            this.f64342p.k(this.f64329c.e(str2).f64353a);
        }
        this.f64341o++;
    }

    @Override // h10.t
    public void g(String str, int i11, String str2) {
        this.f64334h.k(this.f64329c.y(str).f64353a).k(i11).k(str2 == null ? 0 : this.f64329c.D(str2));
        this.f64333g++;
    }

    @Override // h10.t
    public void h(String str) {
        this.f64340n.k(this.f64329c.e(str).f64353a);
        this.f64339m++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        this.f64329c.D("Module");
        int i11 = this.f64334h.f64191b + 22 + this.f64336j.f64191b + this.f64338l.f64191b + this.f64340n.f64191b + this.f64342p.f64191b;
        if (this.f64343q > 0) {
            this.f64329c.D("ModulePackages");
            i11 += this.f64344r.f64191b + 8;
        }
        if (this.f64345s <= 0) {
            return i11;
        }
        this.f64329c.D("ModuleMainClass");
        return i11 + 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return (this.f64343q > 0 ? 1 : 0) + 1 + (this.f64345s > 0 ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(d dVar) {
        d k11 = dVar.k(this.f64329c.D("Module")).i(this.f64334h.f64191b + 16 + this.f64336j.f64191b + this.f64338l.f64191b + this.f64340n.f64191b + this.f64342p.f64191b).k(this.f64330d).k(this.f64331e).k(this.f64332f).k(this.f64333g);
        d dVar2 = this.f64334h;
        d k12 = k11.h(dVar2.f64190a, 0, dVar2.f64191b).k(this.f64335i);
        d dVar3 = this.f64336j;
        d k13 = k12.h(dVar3.f64190a, 0, dVar3.f64191b).k(this.f64337k);
        d dVar4 = this.f64338l;
        d k14 = k13.h(dVar4.f64190a, 0, dVar4.f64191b).k(this.f64339m);
        d dVar5 = this.f64340n;
        d k15 = k14.h(dVar5.f64190a, 0, dVar5.f64191b).k(this.f64341o);
        d dVar6 = this.f64342p;
        k15.h(dVar6.f64190a, 0, dVar6.f64191b);
        if (this.f64343q > 0) {
            d k16 = dVar.k(this.f64329c.D("ModulePackages")).i(this.f64344r.f64191b + 2).k(this.f64343q);
            d dVar7 = this.f64344r;
            k16.h(dVar7.f64190a, 0, dVar7.f64191b);
        }
        if (this.f64345s > 0) {
            dVar.k(this.f64329c.D("ModuleMainClass")).i(2).k(this.f64345s);
        }
    }
}
