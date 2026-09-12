package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;

/* loaded from: classes4.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final id.b f33035a;

    /* renamed from: b, reason: collision with root package name */
    private g f33036b;

    /* renamed from: c, reason: collision with root package name */
    private e f33037c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33038d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(id.b bVar) {
        int k11 = bVar.k();
        if (k11 < 21 || (k11 & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f33035a = bVar;
    }

    private int a(int i11, int i12, int i13) {
        return this.f33038d ? this.f33035a.g(i12, i11) : this.f33035a.g(i11, i12) ? (i13 << 1) | 1 : i13 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i11 = 0;
        while (i11 < this.f33035a.n()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.f33035a.k(); i13++) {
                if (this.f33035a.g(i11, i13) != this.f33035a.g(i13, i11)) {
                    this.f33035a.f(i13, i11);
                    this.f33035a.f(i11, i13);
                }
            }
            i11 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() {
        e d11 = d();
        g e11 = e();
        DataMask dataMask = DataMask.values()[d11.c()];
        int k11 = this.f33035a.k();
        dataMask.unmaskBitMatrix(this.f33035a, k11);
        id.b a11 = e11.a();
        byte[] bArr = new byte[e11.h()];
        int i11 = k11 - 1;
        boolean z10 = true;
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 > 0) {
            if (i12 == 6) {
                i12--;
            }
            for (int i16 = 0; i16 < k11; i16++) {
                int i17 = z10 ? i11 - i16 : i16;
                for (int i18 = 0; i18 < 2; i18++) {
                    int i19 = i12 - i18;
                    if (!a11.g(i19, i17)) {
                        i14++;
                        i15 <<= 1;
                        if (this.f33035a.g(i19, i17)) {
                            i15 |= 1;
                        }
                        if (i14 == 8) {
                            bArr[i13] = (byte) i15;
                            i13++;
                            i14 = 0;
                            i15 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i12 -= 2;
        }
        if (i13 == e11.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e d() {
        e eVar = this.f33037c;
        if (eVar != null) {
            return eVar;
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 6; i13++) {
            i12 = a(i13, 8, i12);
        }
        int a11 = a(8, 7, a(8, 8, a(7, 8, i12)));
        for (int i14 = 5; i14 >= 0; i14--) {
            a11 = a(8, i14, a11);
        }
        int k11 = this.f33035a.k();
        int i15 = k11 - 7;
        for (int i16 = k11 - 1; i16 >= i15; i16--) {
            i11 = a(8, i16, i11);
        }
        for (int i17 = k11 - 8; i17 < k11; i17++) {
            i11 = a(i17, 8, i11);
        }
        e a12 = e.a(a11, i11);
        this.f33037c = a12;
        if (a12 != null) {
            return a12;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g e() {
        g gVar = this.f33036b;
        if (gVar != null) {
            return gVar;
        }
        int k11 = this.f33035a.k();
        int i11 = (k11 - 17) / 4;
        if (i11 <= 6) {
            return g.i(i11);
        }
        int i12 = k11 - 11;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 5; i15 >= 0; i15--) {
            for (int i16 = k11 - 9; i16 >= i12; i16--) {
                i14 = a(i16, i15, i14);
            }
        }
        g c11 = g.c(i14);
        if (c11 != null && c11.e() == k11) {
            this.f33036b = c11;
            return c11;
        }
        for (int i17 = 5; i17 >= 0; i17--) {
            for (int i18 = k11 - 9; i18 >= i12; i18--) {
                i13 = a(i17, i18, i13);
            }
        }
        g c12 = g.c(i13);
        if (c12 == null || c12.e() != k11) {
            throw FormatException.getFormatInstance();
        }
        this.f33036b = c12;
        return c12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f33037c == null) {
            return;
        }
        DataMask.values()[this.f33037c.c()].unmaskBitMatrix(this.f33035a, this.f33035a.k());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z10) {
        this.f33036b = null;
        this.f33037c = null;
        this.f33038d = z10;
    }
}
