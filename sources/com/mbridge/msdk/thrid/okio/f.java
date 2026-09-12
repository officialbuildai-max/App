package com.mbridge.msdk.thrid.okio;

import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: d, reason: collision with root package name */
    static final char[] f38488d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e, reason: collision with root package name */
    public static final f f38489e = a(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    final byte[] f38490a;

    /* renamed from: b, reason: collision with root package name */
    transient int f38491b;

    /* renamed from: c, reason: collision with root package name */
    transient String f38492c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        this.f38490a = bArr;
    }

    private static int a(char c11) {
        if (c11 >= '0' && c11 <= '9') {
            return c11 - '0';
        }
        if (c11 >= 'a' && c11 <= 'f') {
            return c11 - 'W';
        }
        if (c11 >= 'A' && c11 <= 'F') {
            return c11 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c11);
    }

    static int a(String str, int i11) {
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

    public static f a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) ((a(str.charAt(i12)) << 4) + a(str.charAt(i12 + 1)));
        }
        return a(bArr);
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private f b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f38490a));
        } catch (NoSuchAlgorithmException e11) {
            throw new AssertionError(e11);
        }
    }

    public static f c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(u.f38533a));
        fVar.f38492c = str;
        return fVar;
    }

    public byte a(int i11) {
        return this.f38490a[i11];
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int e11 = e();
        int e12 = fVar.e();
        int min = Math.min(e11, e12);
        for (int i11 = 0; i11 < min; i11++) {
            int a11 = a(i11) & 255;
            int a12 = fVar.a(i11) & 255;
            if (a11 != a12) {
                return a11 < a12 ? -1 : 1;
            }
        }
        if (e11 == e12) {
            return 0;
        }
        return e11 < e12 ? -1 : 1;
    }

    public f a(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f38490a;
        if (i12 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f38490a.length + ")");
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
        return new f(bArr2);
    }

    public String a() {
        return b.a(this.f38490a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        byte[] bArr = this.f38490a;
        cVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i11, f fVar, int i12, int i13) {
        return fVar.a(i12, this.f38490a, i11, i13);
    }

    public boolean a(int i11, byte[] bArr, int i12, int i13) {
        if (i11 >= 0) {
            byte[] bArr2 = this.f38490a;
            if (i11 <= bArr2.length - i13 && i12 >= 0 && i12 <= bArr.length - i13 && u.a(bArr2, i11, bArr, i12, i13)) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        byte[] bArr = this.f38490a;
        char[] cArr = new char[bArr.length * 2];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            char[] cArr2 = f38488d;
            cArr[i11] = cArr2[(b11 >> 4) & 15];
            i11 += 2;
            cArr[i12] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    public final boolean b(f fVar) {
        return a(0, fVar, 0, fVar.e());
    }

    public f c() {
        return b(EncoderUtil.ALGORITHM_SHA_1);
    }

    public f d() {
        return b(EncoderUtil.ALGORITHM_SHA_256);
    }

    public int e() {
        return this.f38490a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int e11 = fVar.e();
            byte[] bArr = this.f38490a;
            if (e11 == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public f f() {
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f38490a;
            if (i11 >= bArr.length) {
                return this;
            }
            byte b11 = bArr[i11];
            if (b11 >= 65 && b11 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i11] = (byte) (b11 + 32);
                for (int i12 = i11 + 1; i12 < bArr2.length; i12++) {
                    byte b12 = bArr2[i12];
                    if (b12 >= 65 && b12 <= 90) {
                        bArr2[i12] = (byte) (b12 + 32);
                    }
                }
                return new f(bArr2);
            }
            i11++;
        }
    }

    public byte[] g() {
        return (byte[]) this.f38490a.clone();
    }

    public String h() {
        String str = this.f38492c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f38490a, u.f38533a);
        this.f38492c = str2;
        return str2;
    }

    public int hashCode() {
        int i11 = this.f38491b;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.f38490a);
        this.f38491b = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb2;
        if (this.f38490a.length == 0) {
            return "[size=0]";
        }
        String h11 = h();
        int a11 = a(h11, 64);
        if (a11 == -1) {
            if (this.f38490a.length <= 64) {
                return "[hex=" + b() + "]";
            }
            return "[size=" + this.f38490a.length + " hex=" + a(0, 64).b() + "…]";
        }
        String replace = h11.substring(0, a11).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a11 < h11.length()) {
            sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(this.f38490a.length);
            sb2.append(" text=");
            sb2.append(replace);
            sb2.append("…]");
        } else {
            sb2 = new StringBuilder();
            sb2.append("[text=");
            sb2.append(replace);
            sb2.append("]");
        }
        return sb2.toString();
    }
}
