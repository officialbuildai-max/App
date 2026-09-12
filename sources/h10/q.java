package h10;

import org.mvel2.ast.ASTNode;

/* loaded from: classes7.dex */
public class q {

    /* renamed from: n, reason: collision with root package name */
    static final q f64284n = new q();

    /* renamed from: a, reason: collision with root package name */
    short f64285a;

    /* renamed from: b, reason: collision with root package name */
    private short f64286b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f64287c;

    /* renamed from: d, reason: collision with root package name */
    int f64288d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f64289e;

    /* renamed from: f, reason: collision with root package name */
    short f64290f;

    /* renamed from: g, reason: collision with root package name */
    short f64291g;

    /* renamed from: h, reason: collision with root package name */
    short f64292h;

    /* renamed from: i, reason: collision with root package name */
    short f64293i;

    /* renamed from: j, reason: collision with root package name */
    n f64294j;

    /* renamed from: k, reason: collision with root package name */
    q f64295k;

    /* renamed from: l, reason: collision with root package name */
    k f64296l;

    /* renamed from: m, reason: collision with root package name */
    q f64297m;

    private void b(int i11, int i12, int i13) {
        if (this.f64289e == null) {
            this.f64289e = new int[6];
        }
        int[] iArr = this.f64289e;
        int i14 = iArr[0];
        if (i14 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f64289e = iArr2;
        }
        int[] iArr3 = this.f64289e;
        iArr3[i14 + 1] = i11;
        int i15 = i14 + 2;
        iArr3[i15] = i12 | i13;
        iArr3[0] = i15;
    }

    private q g(q qVar) {
        for (k kVar = this.f64296l; kVar != null; kVar = kVar.f64250c) {
            if ((this.f64285a & 16) == 0 || kVar != this.f64296l.f64250c) {
                q qVar2 = kVar.f64249b;
                if (qVar2.f64297m == null) {
                    qVar2.f64297m = qVar;
                    qVar = qVar2;
                }
            }
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(r rVar, boolean z10) {
        short s11;
        rVar.o(this);
        if (!z10 || (s11 = this.f64286b) == 0) {
            return;
        }
        rVar.q(s11 & 65535, this);
        if (this.f64287c == null) {
            return;
        }
        int i11 = 1;
        while (true) {
            int[] iArr = this.f64287c;
            if (i11 > iArr[0]) {
                return;
            }
            rVar.q(iArr[i11], this);
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(int i11) {
        if (this.f64286b == 0) {
            this.f64286b = (short) i11;
            return;
        }
        if (this.f64287c == null) {
            this.f64287c = new int[4];
        }
        int[] iArr = this.f64287c;
        int i12 = iArr[0] + 1;
        iArr[0] = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f64287c = iArr2;
        }
        this.f64287c[i12] = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(q qVar) {
        q qVar2 = f64284n;
        this.f64297m = qVar2;
        q qVar3 = qVar2;
        q qVar4 = this;
        while (qVar4 != f64284n) {
            q qVar5 = qVar4.f64297m;
            qVar4.f64297m = qVar3;
            if ((qVar4.f64285a & 64) != 0 && qVar4.f64293i != qVar.f64293i) {
                qVar4.f64296l = new k(qVar4.f64291g, qVar.f64296l.f64249b, qVar4.f64296l);
            }
            qVar3 = qVar4;
            qVar4 = qVar4.g(qVar5);
        }
        while (qVar3 != f64284n) {
            q qVar6 = qVar3.f64297m;
            qVar3.f64297m = null;
            qVar3 = qVar6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final q e() {
        n nVar = this.f64294j;
        return nVar == null ? this : nVar.f64264a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(short s11) {
        this.f64297m = f64284n;
        q qVar = this;
        while (qVar != f64284n) {
            q qVar2 = qVar.f64297m;
            qVar.f64297m = null;
            if (qVar.f64293i == 0) {
                qVar.f64293i = s11;
                qVar = qVar.g(qVar2);
            } else {
                qVar = qVar2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(d dVar, int i11, boolean z10) {
        if ((this.f64285a & 4) != 0) {
            if (z10) {
                dVar.i(this.f64288d - i11);
                return;
            } else {
                dVar.k(this.f64288d - i11);
                return;
            }
        }
        if (z10) {
            b(i11, ASTNode.DISCARD, dVar.f64191b);
            dVar.i(-1);
        } else {
            b(i11, ASTNode.DEOP, dVar.f64191b);
            dVar.k(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i(byte[] bArr, int i11) {
        this.f64285a = (short) (this.f64285a | 4);
        this.f64288d = i11;
        int[] iArr = this.f64289e;
        boolean z10 = false;
        if (iArr == null) {
            return false;
        }
        for (int i12 = iArr[0]; i12 > 0; i12 -= 2) {
            int[] iArr2 = this.f64289e;
            int i13 = iArr2[i12 - 1];
            int i14 = iArr2[i12];
            int i15 = i11 - i13;
            int i16 = 268435455 & i14;
            if ((i14 & (-268435456)) == 268435456) {
                if (i15 < -32768 || i15 > 32767) {
                    int i17 = bArr[i13] & 255;
                    if (i17 < 198) {
                        bArr[i13] = (byte) (i17 + 49);
                    } else {
                        bArr[i13] = (byte) (i17 + 20);
                    }
                    z10 = true;
                }
                bArr[i16] = (byte) (i15 >>> 8);
                bArr[i16 + 1] = (byte) i15;
            } else {
                bArr[i16] = (byte) (i15 >>> 24);
                bArr[i16 + 1] = (byte) (i15 >>> 16);
                bArr[i16 + 2] = (byte) (i15 >>> 8);
                bArr[i16 + 3] = (byte) i15;
            }
        }
        return z10;
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}
