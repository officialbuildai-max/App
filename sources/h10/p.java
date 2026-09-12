package h10;

/* loaded from: classes7.dex */
final class p {

    /* renamed from: a, reason: collision with root package name */
    final q f64278a;

    /* renamed from: b, reason: collision with root package name */
    final q f64279b;

    /* renamed from: c, reason: collision with root package name */
    final q f64280c;

    /* renamed from: d, reason: collision with root package name */
    final int f64281d;

    /* renamed from: e, reason: collision with root package name */
    final String f64282e;

    /* renamed from: f, reason: collision with root package name */
    p f64283f;

    p(p pVar, q qVar, q qVar2) {
        this(qVar, qVar2, pVar.f64280c, pVar.f64281d, pVar.f64282e);
        this.f64283f = pVar.f64283f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(q qVar, q qVar2, q qVar3, int i11, String str) {
        this.f64278a = qVar;
        this.f64279b = qVar2;
        this.f64280c = qVar3;
        this.f64281d = i11;
        this.f64282e = str;
    }

    static int a(p pVar) {
        int i11 = 0;
        while (pVar != null) {
            i11++;
            pVar = pVar.f64283f;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(p pVar) {
        return (a(pVar) * 8) + 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(p pVar, d dVar) {
        dVar.k(a(pVar));
        while (pVar != null) {
            dVar.k(pVar.f64278a.f64288d).k(pVar.f64279b.f64288d).k(pVar.f64280c.f64288d).k(pVar.f64281d);
            pVar = pVar.f64283f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p d(p pVar, q qVar, q qVar2) {
        if (pVar == null) {
            return null;
        }
        p d11 = d(pVar.f64283f, qVar, qVar2);
        pVar.f64283f = d11;
        q qVar3 = pVar.f64278a;
        int i11 = qVar3.f64288d;
        q qVar4 = pVar.f64279b;
        int i12 = qVar4.f64288d;
        int i13 = qVar.f64288d;
        int i14 = qVar2 == null ? Integer.MAX_VALUE : qVar2.f64288d;
        if (i13 >= i12 || i14 <= i11) {
            return pVar;
        }
        if (i13 <= i11) {
            return i14 >= i12 ? d11 : new p(pVar, qVar2, qVar4);
        }
        if (i14 >= i12) {
            return new p(pVar, qVar3, qVar);
        }
        pVar.f64283f = new p(pVar, qVar2, qVar4);
        return new p(pVar, pVar.f64278a, qVar);
    }
}
