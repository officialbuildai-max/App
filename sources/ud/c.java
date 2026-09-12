package ud;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f76858a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f76859b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f76858a = bVar;
        int length = iArr.length;
        int i11 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f76859b = iArr;
            return;
        }
        while (i11 < length && iArr[i11] == 0) {
            i11++;
        }
        if (i11 == length) {
            this.f76859b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i11];
        this.f76859b = iArr2;
        System.arraycopy(iArr, i11, iArr2, 0, iArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(c cVar) {
        if (!this.f76858a.equals(cVar.f76858a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return cVar;
        }
        if (cVar.e()) {
            return this;
        }
        int[] iArr = this.f76859b;
        int[] iArr2 = cVar.f76859b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i11 = length; i11 < iArr.length; i11++) {
            iArr3[i11] = this.f76858a.a(iArr2[i11 - length], iArr[i11]);
        }
        return new c(this.f76858a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i11) {
        if (i11 == 0) {
            return c(0);
        }
        if (i11 == 1) {
            int i12 = 0;
            for (int i13 : this.f76859b) {
                i12 = this.f76858a.a(i12, i13);
            }
            return i12;
        }
        int[] iArr = this.f76859b;
        int i14 = iArr[0];
        int length = iArr.length;
        for (int i15 = 1; i15 < length; i15++) {
            b bVar = this.f76858a;
            i14 = bVar.a(bVar.i(i11, i14), this.f76859b[i15]);
        }
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i11) {
        return this.f76859b[(r0.length - 1) - i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f76859b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f76859b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f(int i11) {
        if (i11 == 0) {
            return this.f76858a.f();
        }
        if (i11 == 1) {
            return this;
        }
        int length = this.f76859b.length;
        int[] iArr = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f76858a.i(this.f76859b[i12], i11);
        }
        return new c(this.f76858a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c g(c cVar) {
        if (!this.f76858a.equals(cVar.f76858a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || cVar.e()) {
            return this.f76858a.f();
        }
        int[] iArr = this.f76859b;
        int length = iArr.length;
        int[] iArr2 = cVar.f76859b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = iArr[i11];
            for (int i13 = 0; i13 < length2; i13++) {
                int i14 = i11 + i13;
                b bVar = this.f76858a;
                iArr3[i14] = bVar.a(iArr3[i14], bVar.i(i12, iArr2[i13]));
            }
        }
        return new c(this.f76858a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException();
        }
        if (i12 == 0) {
            return this.f76858a.f();
        }
        int length = this.f76859b.length;
        int[] iArr = new int[i11 + length];
        for (int i13 = 0; i13 < length; i13++) {
            iArr[i13] = this.f76858a.i(this.f76859b[i13], i12);
        }
        return new c(this.f76858a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c i() {
        int length = this.f76859b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f76858a.j(0, this.f76859b[i11]);
        }
        return new c(this.f76858a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j(c cVar) {
        if (this.f76858a.equals(cVar.f76858a)) {
            return cVar.e() ? this : a(cVar.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(d() * 8);
        for (int d11 = d(); d11 >= 0; d11--) {
            int c11 = c(d11);
            if (c11 != 0) {
                if (c11 < 0) {
                    sb2.append(" - ");
                    c11 = -c11;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (d11 == 0 || c11 != 1) {
                    sb2.append(c11);
                }
                if (d11 != 0) {
                    if (d11 == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(d11);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
