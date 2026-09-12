package com.bytedance.sdk.component.sP.Sj.sP;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class EjP implements Serializable, Comparable<EjP> {
    final byte[] EjP;
    transient int HiB;
    transient String vS;
    static final char[] Sj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset sP = Charset.forName("UTF-8");
    public static final EjP TKC = Sj(new byte[0]);

    /* JADX INFO: Access modifiers changed from: package-private */
    public EjP(byte[] bArr) {
        this.EjP = bArr;
    }

    static int Sj(String str, int i11) {
        int length = str.length();
        int i12 = 0;
        int i13 = 0;
        while (i12 < length) {
            if (i13 == i11) {
                return i12;
            }
            int codePointAt = str.codePointAt(i12);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i13++;
            i12 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static EjP Sj(byte... bArr) {
        if (bArr != null) {
            return new EjP((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public byte[] EjP() {
        return (byte[]) this.EjP.clone();
    }

    public byte Sj(int i11) {
        return this.EjP[i11];
    }

    @Override // java.lang.Comparable
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public int compareTo(EjP ejP) {
        int TKC2 = TKC();
        int TKC3 = ejP.TKC();
        int min = Math.min(TKC2, TKC3);
        for (int i11 = 0; i11 < min; i11++) {
            int Sj2 = Sj(i11) & 255;
            int Sj3 = ejP.Sj(i11) & 255;
            if (Sj2 != Sj3) {
                return Sj2 < Sj3 ? -1 : 1;
            }
        }
        if (TKC2 == TKC3) {
            return 0;
        }
        return TKC2 < TKC3 ? -1 : 1;
    }

    public EjP Sj(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.EjP;
        if (i12 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.EjP.length + ")");
        }
        int i13 = i12 - i11;
        if (i13 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i11 == 0 && i12 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i11, bArr2, 0, i13);
        return new EjP(bArr2);
    }

    public String Sj() {
        String str = this.vS;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.EjP, sP);
        this.vS = str2;
        return str2;
    }

    public boolean Sj(int i11, EjP ejP, int i12, int i13) {
        return ejP.Sj(i12, this.EjP, i11, i13);
    }

    public boolean Sj(int i11, byte[] bArr, int i12, int i13) {
        if (i11 < 0) {
            return false;
        }
        byte[] bArr2 = this.EjP;
        return i11 <= bArr2.length - i13 && i12 >= 0 && i12 <= bArr.length - i13 && uA.Sj(bArr2, i11, bArr, i12, i13);
    }

    public int TKC() {
        return this.EjP.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EjP) {
            EjP ejP = (EjP) obj;
            int TKC2 = ejP.TKC();
            byte[] bArr = this.EjP;
            if (TKC2 == bArr.length && ejP.Sj(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i11 = this.HiB;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.EjP);
        this.HiB = hashCode;
        return hashCode;
    }

    public String sP() {
        byte[] bArr = this.EjP;
        char[] cArr = new char[bArr.length * 2];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            char[] cArr2 = Sj;
            cArr[i11] = cArr2[(b11 >> 4) & 15];
            i11 += 2;
            cArr[i12] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    public String toString() {
        if (this.EjP.length == 0) {
            return "[size=0]";
        }
        String Sj2 = Sj();
        int Sj3 = Sj(Sj2, 64);
        if (Sj3 == -1) {
            if (this.EjP.length <= 64) {
                return "[hex=" + sP() + "]";
            }
            return "[size=" + this.EjP.length + " hex=" + Sj(0, 64).sP() + "…]";
        }
        String replace = Sj2.substring(0, Sj3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (Sj3 >= Sj2.length()) {
            return "[text=" + replace + "]";
        }
        return "[size=" + this.EjP.length + " text=" + replace + "…]";
    }
}
