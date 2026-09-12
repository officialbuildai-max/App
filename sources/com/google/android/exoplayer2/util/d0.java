package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* loaded from: classes3.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f27618a;

    /* renamed from: b, reason: collision with root package name */
    private int f27619b;

    /* renamed from: c, reason: collision with root package name */
    private int f27620c;

    public d0() {
        this.f27618a = p0.f27685f;
    }

    public d0(int i11) {
        this.f27618a = new byte[i11];
        this.f27620c = i11;
    }

    public d0(byte[] bArr) {
        this.f27618a = bArr;
        this.f27620c = bArr.length;
    }

    public d0(byte[] bArr, int i11) {
        this.f27618a = bArr;
        this.f27620c = i11;
    }

    public String A(int i11) {
        return B(i11, com.google.common.base.c.f30282c);
    }

    public String B(int i11, Charset charset) {
        String str = new String(this.f27618a, this.f27619b, i11, charset);
        this.f27619b += i11;
        return str;
    }

    public int C() {
        return (D() << 21) | (D() << 14) | (D() << 7) | D();
    }

    public int D() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        this.f27619b = i11 + 1;
        return bArr[i11] & 255;
    }

    public int E() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = (bArr[i11] & 255) << 8;
        this.f27619b = i11 + 2;
        int i14 = (bArr[i12] & 255) | i13;
        this.f27619b = i11 + 4;
        return i14;
    }

    public long F() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        this.f27619b = i11 + 1;
        this.f27619b = i11 + 2;
        this.f27619b = i11 + 3;
        long j11 = ((bArr[i11] & 255) << 24) | ((bArr[r2] & 255) << 16) | ((bArr[r7] & 255) << 8);
        this.f27619b = i11 + 4;
        return (bArr[r4] & 255) | j11;
    }

    public int G() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = (bArr[i11] & 255) << 16;
        int i14 = i11 + 2;
        this.f27619b = i14;
        int i15 = ((bArr[i12] & 255) << 8) | i13;
        this.f27619b = i11 + 3;
        return (bArr[i14] & 255) | i15;
    }

    public int H() {
        int n11 = n();
        if (n11 >= 0) {
            return n11;
        }
        throw new IllegalStateException("Top bit not zero: " + n11);
    }

    public long I() {
        long w11 = w();
        if (w11 >= 0) {
            return w11;
        }
        throw new IllegalStateException("Top bit not zero: " + w11);
    }

    public int J() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = (bArr[i11] & 255) << 8;
        this.f27619b = i11 + 2;
        return (bArr[i12] & 255) | i13;
    }

    public long K() {
        int i11;
        int i12;
        long j11 = this.f27618a[this.f27619b];
        int i13 = 7;
        while (true) {
            if (i13 < 0) {
                break;
            }
            if (((1 << i13) & j11) != 0) {
                i13--;
            } else if (i13 < 6) {
                j11 &= r6 - 1;
                i12 = 7 - i13;
            } else if (i13 == 7) {
                i12 = 1;
            }
        }
        i12 = 0;
        if (i12 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j11);
        }
        for (i11 = 1; i11 < i12; i11++) {
            if ((this.f27618a[this.f27619b + i11] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j11);
            }
            j11 = (j11 << 6) | (r3 & Utf8.REPLACEMENT_BYTE);
        }
        this.f27619b += i12;
        return j11;
    }

    public void L(int i11) {
        N(b() < i11 ? new byte[i11] : this.f27618a, i11);
    }

    public void M(byte[] bArr) {
        N(bArr, bArr.length);
    }

    public void N(byte[] bArr, int i11) {
        this.f27618a = bArr;
        this.f27620c = i11;
        this.f27619b = 0;
    }

    public void O(int i11) {
        a.a(i11 >= 0 && i11 <= this.f27618a.length);
        this.f27620c = i11;
    }

    public void P(int i11) {
        a.a(i11 >= 0 && i11 <= this.f27620c);
        this.f27619b = i11;
    }

    public void Q(int i11) {
        P(this.f27619b + i11);
    }

    public int a() {
        return this.f27620c - this.f27619b;
    }

    public int b() {
        return this.f27618a.length;
    }

    public void c(int i11) {
        if (i11 > b()) {
            this.f27618a = Arrays.copyOf(this.f27618a, i11);
        }
    }

    public byte[] d() {
        return this.f27618a;
    }

    public int e() {
        return this.f27619b;
    }

    public int f() {
        return this.f27620c;
    }

    public char g() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        return (char) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public int h() {
        return this.f27618a[this.f27619b] & 255;
    }

    public void i(c0 c0Var, int i11) {
        j(c0Var.f27614a, 0, i11);
        c0Var.p(0);
    }

    public void j(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.f27618a, this.f27619b, bArr, i11, i12);
        this.f27619b += i12;
    }

    public String k(char c11) {
        if (a() == 0) {
            return null;
        }
        int i11 = this.f27619b;
        while (i11 < this.f27620c && this.f27618a[i11] != c11) {
            i11++;
        }
        byte[] bArr = this.f27618a;
        int i12 = this.f27619b;
        String E = p0.E(bArr, i12, i11 - i12);
        this.f27619b = i11;
        if (i11 < this.f27620c) {
            this.f27619b = i11 + 1;
        }
        return E;
    }

    public double l() {
        return Double.longBitsToDouble(w());
    }

    public float m() {
        return Float.intBitsToFloat(n());
    }

    public int n() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = (bArr[i11] & 255) << 24;
        int i14 = i11 + 2;
        this.f27619b = i14;
        int i15 = ((bArr[i12] & 255) << 16) | i13;
        int i16 = i11 + 3;
        this.f27619b = i16;
        int i17 = i15 | ((bArr[i14] & 255) << 8);
        this.f27619b = i11 + 4;
        return (bArr[i16] & 255) | i17;
    }

    public int o() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = ((bArr[i11] & 255) << 24) >> 8;
        int i14 = i11 + 2;
        this.f27619b = i14;
        int i15 = ((bArr[i12] & 255) << 8) | i13;
        this.f27619b = i11 + 3;
        return (bArr[i14] & 255) | i15;
    }

    public String p() {
        if (a() == 0) {
            return null;
        }
        int i11 = this.f27619b;
        while (i11 < this.f27620c && !p0.v0(this.f27618a[i11])) {
            i11++;
        }
        int i12 = this.f27619b;
        if (i11 - i12 >= 3) {
            byte[] bArr = this.f27618a;
            if (bArr[i12] == -17 && bArr[i12 + 1] == -69 && bArr[i12 + 2] == -65) {
                this.f27619b = i12 + 3;
            }
        }
        byte[] bArr2 = this.f27618a;
        int i13 = this.f27619b;
        String E = p0.E(bArr2, i13, i11 - i13);
        this.f27619b = i11;
        int i14 = this.f27620c;
        if (i11 == i14) {
            return E;
        }
        byte[] bArr3 = this.f27618a;
        if (bArr3[i11] == 13) {
            int i15 = i11 + 1;
            this.f27619b = i15;
            if (i15 == i14) {
                return E;
            }
        }
        int i16 = this.f27619b;
        if (bArr3[i16] == 10) {
            this.f27619b = i16 + 1;
        }
        return E;
    }

    public int q() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = bArr[i11] & 255;
        int i14 = i11 + 2;
        this.f27619b = i14;
        int i15 = ((bArr[i12] & 255) << 8) | i13;
        int i16 = i11 + 3;
        this.f27619b = i16;
        int i17 = i15 | ((bArr[i14] & 255) << 16);
        this.f27619b = i11 + 4;
        return ((bArr[i16] & 255) << 24) | i17;
    }

    public long r() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        this.f27619b = i11 + 1;
        this.f27619b = i11 + 2;
        this.f27619b = i11 + 3;
        long j11 = (bArr[i11] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f27619b = i11 + 4;
        long j12 = j11 | ((bArr[r8] & 255) << 24);
        this.f27619b = i11 + 5;
        long j13 = j12 | ((bArr[r7] & 255) << 32);
        this.f27619b = i11 + 6;
        long j14 = j13 | ((bArr[r8] & 255) << 40);
        this.f27619b = i11 + 7;
        long j15 = j14 | ((bArr[r7] & 255) << 48);
        this.f27619b = i11 + 8;
        return ((bArr[r8] & 255) << 56) | j15;
    }

    public short s() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = bArr[i11] & 255;
        this.f27619b = i11 + 2;
        return (short) (((bArr[i12] & 255) << 8) | i13);
    }

    public long t() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        this.f27619b = i11 + 1;
        this.f27619b = i11 + 2;
        this.f27619b = i11 + 3;
        long j11 = (bArr[i11] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f27619b = i11 + 4;
        return ((bArr[r4] & 255) << 24) | j11;
    }

    public int u() {
        int q11 = q();
        if (q11 >= 0) {
            return q11;
        }
        throw new IllegalStateException("Top bit not zero: " + q11);
    }

    public int v() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = bArr[i11] & 255;
        this.f27619b = i11 + 2;
        return ((bArr[i12] & 255) << 8) | i13;
    }

    public long w() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        this.f27619b = i11 + 1;
        this.f27619b = i11 + 2;
        this.f27619b = i11 + 3;
        long j11 = ((bArr[i11] & 255) << 56) | ((bArr[r2] & 255) << 48) | ((bArr[r7] & 255) << 40);
        this.f27619b = i11 + 4;
        long j12 = j11 | ((bArr[r4] & 255) << 32);
        this.f27619b = i11 + 5;
        long j13 = j12 | ((bArr[r7] & 255) << 24);
        this.f27619b = i11 + 6;
        long j14 = j13 | ((bArr[r4] & 255) << 16);
        this.f27619b = i11 + 7;
        long j15 = j14 | ((bArr[r7] & 255) << 8);
        this.f27619b = i11 + 8;
        return (bArr[r4] & 255) | j15;
    }

    public String x() {
        return k((char) 0);
    }

    public String y(int i11) {
        if (i11 == 0) {
            return "";
        }
        int i12 = this.f27619b;
        int i13 = (i12 + i11) - 1;
        String E = p0.E(this.f27618a, i12, (i13 >= this.f27620c || this.f27618a[i13] != 0) ? i11 : i11 - 1);
        this.f27619b += i11;
        return E;
    }

    public short z() {
        byte[] bArr = this.f27618a;
        int i11 = this.f27619b;
        int i12 = i11 + 1;
        this.f27619b = i12;
        int i13 = (bArr[i11] & 255) << 8;
        this.f27619b = i11 + 2;
        return (short) ((bArr[i12] & 255) | i13);
    }
}
