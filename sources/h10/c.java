package h10;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f64185a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f64186b;

    /* renamed from: c, reason: collision with root package name */
    c f64187c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f64188a;

        /* renamed from: b, reason: collision with root package name */
        private c[] f64189b = new c[6];

        private void a(c cVar) {
            int i11 = this.f64188a;
            c[] cVarArr = this.f64189b;
            if (i11 >= cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length + 6];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i11);
                this.f64189b = cVarArr2;
            }
            c[] cVarArr3 = this.f64189b;
            int i12 = this.f64188a;
            this.f64188a = i12 + 1;
            cVarArr3[i12] = cVar;
        }

        private boolean c(c cVar) {
            for (int i11 = 0; i11 < this.f64188a; i11++) {
                if (this.f64189b[i11].f64185a.equals(cVar.f64185a)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(c cVar) {
            while (cVar != null) {
                if (!c(cVar)) {
                    a(cVar);
                }
                cVar = cVar.f64187c;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c[] d() {
            int i11 = this.f64188a;
            c[] cVarArr = new c[i11];
            System.arraycopy(this.f64189b, 0, cVarArr, 0, i11);
            return cVarArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(String str) {
        this.f64185a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(x xVar) {
        return b(xVar, null, 0, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b(x xVar, byte[] bArr, int i11, int i12, int i13) {
        g gVar = xVar.f64360a;
        int i14 = 0;
        for (c cVar = this; cVar != null; cVar = cVar.f64187c) {
            xVar.D(cVar.f64185a);
            i14 += cVar.h(gVar, bArr, i11, i12, i13).f64191b + 6;
        }
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c() {
        int i11 = 0;
        for (c cVar = this; cVar != null; cVar = cVar.f64187c) {
            i11++;
        }
        return i11;
    }

    public boolean d() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(x xVar, d dVar) {
        f(xVar, null, 0, -1, -1, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(x xVar, byte[] bArr, int i11, int i12, int i13, d dVar) {
        g gVar = xVar.f64360a;
        for (c cVar = this; cVar != null; cVar = cVar.f64187c) {
            d h11 = cVar.h(gVar, bArr, i11, i12, i13);
            dVar.k(xVar.D(cVar.f64185a)).i(h11.f64191b);
            dVar.h(h11.f64190a, 0, h11.f64191b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c g(e eVar, int i11, int i12, char[] cArr, int i13, q[] qVarArr) {
        c cVar = new c(this.f64185a);
        byte[] bArr = new byte[i12];
        cVar.f64186b = bArr;
        System.arraycopy(eVar.f64192a, i11, bArr, 0, i12);
        return cVar;
    }

    protected d h(g gVar, byte[] bArr, int i11, int i12, int i13) {
        return new d(this.f64186b);
    }
}
