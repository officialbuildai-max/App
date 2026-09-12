package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.charset.StandardCharsets;
import okio.Utf8;

/* loaded from: classes5.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f35885a;

    /* renamed from: b, reason: collision with root package name */
    public int f35886b;

    /* renamed from: c, reason: collision with root package name */
    private char[] f35887c;

    public z(int i11) {
        this(new byte[i11], 0);
    }

    public z(byte[] bArr) {
        this(bArr, 0);
    }

    public z(byte[] bArr, int i11) {
        this.f35887c = null;
        this.f35885a = bArr;
        this.f35886b = i11;
    }

    private String a(int i11) {
        if (i11 > 2048) {
            return new String(this.f35885a, this.f35886b, i11, StandardCharsets.UTF_8);
        }
        char[] c11 = c(i11);
        byte[] bArr = this.f35885a;
        int i12 = this.f35886b;
        int i13 = i11 + i12;
        int i14 = 0;
        while (i12 < i13) {
            int i15 = i12 + 1;
            byte b11 = bArr[i12];
            if (b11 > 0) {
                c11[i14] = (char) b11;
                i14++;
                i12 = i15;
            } else if (b11 < -32) {
                i12 += 2;
                c11[i14] = (char) ((bArr[i15] & Utf8.REPLACEMENT_BYTE) | ((b11 & 31) << 6));
                i14++;
            } else if (b11 < -16) {
                int i16 = i12 + 2;
                i12 += 3;
                c11[i14] = (char) (((bArr[i15] & Utf8.REPLACEMENT_BYTE) << 6) | ((b11 & 15) << 12) | (bArr[i16] & Utf8.REPLACEMENT_BYTE));
                i14++;
            } else {
                byte b12 = bArr[i15];
                int i17 = i12 + 3;
                byte b13 = bArr[i12 + 2];
                i12 += 4;
                int i18 = ((b12 & Utf8.REPLACEMENT_BYTE) << 12) | ((b11 & 7) << 18) | ((b13 & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i17] & Utf8.REPLACEMENT_BYTE);
                int i19 = i14 + 1;
                c11[i14] = (char) ((i18 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i14 += 2;
                c11[i19] = (char) ((i18 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i12 <= i13) {
            return new String(c11, 0, i14);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private void a(String str) {
        byte[] bArr = this.f35885a;
        int i11 = this.f35886b;
        int length = str.length();
        int i12 = 0;
        while (i12 < length) {
            int i13 = i12 + 1;
            char charAt = str.charAt(i12);
            if (charAt < 128) {
                bArr[i11] = (byte) charAt;
                i11++;
            } else if (charAt < 2048) {
                int i14 = i11 + 1;
                bArr[i11] = (byte) ((charAt >>> 6) | PsExtractor.AUDIO_STREAM);
                i11 += 2;
                bArr[i14] = (byte) ((charAt & '?') | 128);
            } else if (charAt < 55296 || charAt > 57343) {
                bArr[i11] = (byte) ((charAt >>> '\f') | 224);
                int i15 = i11 + 2;
                bArr[i11 + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                i11 += 3;
                bArr[i15] = (byte) ((charAt & '?') | 128);
            } else {
                i12 += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i13)) - 56613888;
                bArr[i11] = (byte) ((charAt2 >>> 18) | 240);
                bArr[i11 + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i16 = i11 + 3;
                bArr[i11 + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i11 += 4;
                bArr[i16] = (byte) ((charAt2 & 63) | 128);
            }
            i12 = i13;
        }
        this.f35886b = i11;
    }

    public static int b(String str) {
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = i11 + 1;
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                i12++;
            } else if (charAt < 2048) {
                i12 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i12 += 3;
            } else {
                i11 += 2;
                i12 += 4;
            }
            i11 = i13;
        }
        return i12;
    }

    private char[] c(int i11) {
        char[] cArr = this.f35887c;
        if (cArr == null) {
            if (i11 <= 256) {
                this.f35887c = new char[256];
            } else {
                this.f35887c = new char[2048];
            }
        } else if (cArr.length < i11) {
            this.f35887c = new char[2048];
        }
        return this.f35887c;
    }

    public static int f(int i11) {
        if ((i11 >> 7) == 0) {
            return 1;
        }
        if ((i11 >> 14) == 0) {
            return 2;
        }
        if ((i11 >> 21) == 0) {
            return 3;
        }
        return (i11 >> 28) == 0 ? 4 : 5;
    }

    public byte a() {
        byte[] bArr = this.f35885a;
        int i11 = this.f35886b;
        this.f35886b = i11 + 1;
        return bArr[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a(int i11, int i12) {
        long j11 = 0;
        if (i12 <= 0) {
            return 0L;
        }
        int i13 = i12 >> 3;
        int i14 = i12 & 7;
        int i15 = 0;
        int i16 = i11;
        for (int i17 = 0; i17 < i13; i17++) {
            j11 ^= d(i16);
            i16 += 8;
        }
        while (i15 < (i14 << 3)) {
            j11 ^= (this.f35885a[i16] & 255) << i15;
            i15 += 8;
            i16++;
        }
        int i18 = (i11 & 7) << 3;
        return (j11 >>> (64 - i18)) | (j11 << i18);
    }

    public final void a(byte b11) {
        byte[] bArr = this.f35885a;
        int i11 = this.f35886b;
        this.f35886b = i11 + 1;
        bArr[i11] = b11;
    }

    public void a(int i11, long j11) {
        byte[] bArr = this.f35885a;
        bArr[i11] = (byte) j11;
        bArr[i11 + 1] = (byte) (j11 >> 8);
        bArr[i11 + 2] = (byte) (j11 >> 16);
        bArr[i11 + 3] = (byte) (j11 >> 24);
        bArr[i11 + 4] = (byte) (j11 >> 32);
        bArr[i11 + 5] = (byte) (j11 >> 40);
        bArr[i11 + 6] = (byte) (j11 >> 48);
        bArr[i11 + 7] = (byte) (j11 >> 56);
    }

    public void a(long j11) {
        a(this.f35886b, j11);
        this.f35886b += 8;
    }

    public void a(short s11) {
        byte[] bArr = this.f35885a;
        int i11 = this.f35886b;
        bArr[i11] = (byte) s11;
        this.f35886b = i11 + 2;
        bArr[i11 + 1] = (byte) (s11 >> 8);
    }

    public void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f35885a, this.f35886b, length);
            this.f35886b += length;
        }
    }

    public double b() {
        return Double.longBitsToDouble(e());
    }

    public void b(int i11, int i12) {
        byte[] bArr = this.f35885a;
        bArr[i11] = (byte) i12;
        bArr[i11 + 1] = (byte) (i12 >> 8);
        bArr[i11 + 2] = (byte) (i12 >> 16);
        bArr[i11 + 3] = (byte) (i12 >> 24);
    }

    public byte[] b(int i11) {
        byte[] bArr = new byte[i11];
        System.arraycopy(this.f35885a, this.f35886b, bArr, 0, i11);
        this.f35886b += i11;
        return bArr;
    }

    public float c() {
        return Float.intBitsToFloat(d());
    }

    public int c(int i11, int i12) {
        while ((i12 & (-128)) != 0) {
            this.f35885a[i11] = (byte) ((i12 & 127) | 128);
            i12 >>>= 7;
            i11++;
        }
        int i13 = i11 + 1;
        this.f35885a[i11] = (byte) i12;
        return i13;
    }

    public void c(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        a(str);
    }

    public int d() {
        byte[] bArr = this.f35885a;
        int i11 = this.f35886b;
        int i12 = ((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255);
        int i13 = i11 + 3;
        int i14 = i12 | ((bArr[i11 + 2] & 255) << 16);
        this.f35886b = i11 + 4;
        return (bArr[i13] << 24) | i14;
    }

    public long d(int i11) {
        byte[] bArr = this.f35885a;
        int i12 = i11 + 6;
        return (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i12] & 255) << 48) | (bArr[i11 + 7] << 56);
    }

    public long e() {
        long d11 = d(this.f35886b);
        this.f35886b += 8;
        return d11;
    }

    public String e(int i11) {
        if (i11 < 0) {
            return null;
        }
        if (i11 == 0) {
            return "";
        }
        String a11 = a(i11);
        this.f35886b += i11;
        return a11;
    }

    public short f() {
        byte[] bArr = this.f35885a;
        int i11 = this.f35886b;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.f35886b = i11 + 2;
        return (short) ((bArr[i12] << 8) | i13);
    }

    public int g() {
        byte[] bArr = this.f35885a;
        int i11 = this.f35886b;
        int i12 = i11 + 1;
        this.f35886b = i12;
        byte b11 = bArr[i11];
        if ((b11 >> 7) == 0) {
            return b11;
        }
        int i13 = i11 + 2;
        this.f35886b = i13;
        int i14 = (bArr[i12] << 7) | (b11 & Byte.MAX_VALUE);
        if ((i14 >> 14) == 0) {
            return i14;
        }
        int i15 = i11 + 3;
        this.f35886b = i15;
        int i16 = (i14 & 16383) | (bArr[i13] << 14);
        if ((i16 >> 21) == 0) {
            return i16;
        }
        int i17 = i11 + 4;
        this.f35886b = i17;
        int i18 = (i16 & 2097151) | (bArr[i15] << 21);
        if ((i18 >> 28) == 0) {
            return i18;
        }
        this.f35886b = i11 + 5;
        return (bArr[i17] << 28) | (i18 & 268435455);
    }

    public void g(int i11) {
        byte[] bArr = this.f35885a;
        int i12 = this.f35886b;
        bArr[i12] = (byte) i11;
        bArr[i12 + 1] = (byte) (i11 >> 8);
        bArr[i12 + 2] = (byte) (i11 >> 16);
        this.f35886b = i12 + 4;
        bArr[i12 + 3] = (byte) (i11 >> 24);
    }

    public void h(int i11) {
        this.f35886b = c(this.f35886b, i11);
    }
}
