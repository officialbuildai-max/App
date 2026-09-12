package com.bytedance.sdk.component.sP.Sj.sP;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class Sj implements TKC, sP, Cloneable, ByteChannel {
    private static final byte[] TKC = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    HiB Sj;
    long sP;

    public final EjP EjP(int i11) {
        return i11 == 0 ? EjP.TKC : new Jcg(this, i11);
    }

    /* renamed from: EjP, reason: merged with bridge method [inline-methods] */
    public Sj clone() {
        Sj sj2 = new Sj();
        if (this.sP == 0) {
            return sj2;
        }
        HiB Sj = this.Sj.Sj();
        sj2.Sj = Sj;
        Sj.Jcg = Sj;
        Sj.vS = Sj;
        HiB hiB = this.Sj;
        while (true) {
            hiB = hiB.vS;
            if (hiB == this.Sj) {
                sj2.sP = this.sP;
                return sj2;
            }
            sj2.Sj.Jcg.Sj(hiB.Sj());
        }
    }

    public final EjP HiB() {
        long j11 = this.sP;
        if (j11 <= 2147483647L) {
            return EjP((int) j11);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.sP);
    }

    public int Sj(byte[] bArr, int i11, int i12) {
        uA.Sj(bArr.length, i11, i12);
        HiB hiB = this.Sj;
        if (hiB == null) {
            return -1;
        }
        int min = Math.min(i12, hiB.TKC - hiB.sP);
        System.arraycopy(hiB.Sj, hiB.sP, bArr, i11, min);
        int i13 = hiB.sP + min;
        hiB.sP = i13;
        this.sP -= min;
        if (i13 == hiB.TKC) {
            this.Sj = hiB.sP();
            vS.Sj(hiB);
        }
        return min;
    }

    public Sj Sj(int i11) {
        if (i11 < 128) {
            sP(i11);
        } else if (i11 < 2048) {
            sP((i11 >> 6) | PsExtractor.AUDIO_STREAM);
            sP((i11 & 63) | 128);
        } else if (i11 < 65536) {
            if (i11 < 55296 || i11 > 57343) {
                sP((i11 >> 12) | 224);
                sP(((i11 >> 6) & 63) | 128);
                sP((i11 & 63) | 128);
            } else {
                sP(63);
            }
        } else {
            if (i11 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i11));
            }
            sP((i11 >> 18) | 240);
            sP(((i11 >> 12) & 63) | 128);
            sP(((i11 >> 6) & 63) | 128);
            sP((i11 & 63) | 128);
        }
        return this;
    }

    public Sj Sj(String str) {
        return Sj(str, 0, str.length());
    }

    public Sj Sj(String str, int i11, int i12) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i11)));
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < " + i11);
        }
        if (i12 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + str.length());
        }
        while (i11 < i12) {
            char charAt2 = str.charAt(i11);
            if (charAt2 < 128) {
                HiB TKC2 = TKC(1);
                byte[] bArr = TKC2.Sj;
                int i13 = TKC2.TKC - i11;
                int min = Math.min(i12, 8192 - i13);
                int i14 = i11 + 1;
                bArr[i11 + i13] = (byte) charAt2;
                while (true) {
                    i11 = i14;
                    if (i11 >= min || (charAt = str.charAt(i11)) >= 128) {
                        break;
                    }
                    i14 = i11 + 1;
                    bArr[i11 + i13] = (byte) charAt;
                }
                int i15 = TKC2.TKC;
                int i16 = (i13 + i11) - i15;
                TKC2.TKC = i15 + i16;
                this.sP += i16;
            } else {
                if (charAt2 < 2048) {
                    sP((charAt2 >> 6) | PsExtractor.AUDIO_STREAM);
                    sP((charAt2 & '?') | 128);
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    sP((charAt2 >> '\f') | 224);
                    sP(((charAt2 >> 6) & 63) | 128);
                    sP((charAt2 & '?') | 128);
                } else {
                    int i17 = i11 + 1;
                    char charAt3 = i17 < i12 ? str.charAt(i17) : (char) 0;
                    if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        sP(63);
                        i11 = i17;
                    } else {
                        int i18 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                        sP((i18 >> 18) | 240);
                        sP(((i18 >> 12) & 63) | 128);
                        sP(((i18 >> 6) & 63) | 128);
                        sP((i18 & 63) | 128);
                        i11 += 2;
                    }
                }
                i11++;
            }
        }
        return this;
    }

    public Sj Sj(String str, int i11, int i12, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i11)));
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < " + i11);
        }
        if (i12 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(uA.Sj)) {
            return Sj(str, i11, i12);
        }
        byte[] bytes = str.substring(i11, i12).getBytes(charset);
        return sP(bytes, 0, bytes.length);
    }

    public String Sj(long j11, Charset charset) throws EOFException {
        uA.Sj(this.sP, 0L, j11);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j11)));
        }
        if (j11 == 0) {
            return "";
        }
        HiB hiB = this.Sj;
        int i11 = hiB.sP;
        if (i11 + j11 > hiB.TKC) {
            return new String(Sj(j11), charset);
        }
        String str = new String(hiB.Sj, i11, (int) j11, charset);
        int i12 = (int) (hiB.sP + j11);
        hiB.sP = i12;
        this.sP -= j11;
        if (i12 == hiB.TKC) {
            this.Sj = hiB.sP();
            vS.Sj(hiB);
        }
        return str;
    }

    public void Sj(byte[] bArr) throws EOFException {
        int i11 = 0;
        while (i11 < bArr.length) {
            int Sj = Sj(bArr, i11, bArr.length - i11);
            if (Sj == -1) {
                throw new EOFException();
            }
            i11 += Sj;
        }
    }

    public boolean Sj() {
        return this.sP == 0;
    }

    public byte[] Sj(long j11) throws EOFException {
        uA.Sj(this.sP, 0L, j11);
        if (j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j11)));
        }
        byte[] bArr = new byte[(int) j11];
        Sj(bArr);
        return bArr;
    }

    HiB TKC(int i11) {
        if (i11 <= 0 || i11 > 8192) {
            throw new IllegalArgumentException();
        }
        HiB hiB = this.Sj;
        if (hiB != null) {
            HiB hiB2 = hiB.Jcg;
            return (hiB2.TKC + i11 > 8192 || !hiB2.HiB) ? hiB2.Sj(vS.Sj()) : hiB2;
        }
        HiB Sj = vS.Sj();
        this.Sj = Sj;
        Sj.Jcg = Sj;
        Sj.vS = Sj;
        return Sj;
    }

    public String TKC() {
        try {
            return Sj(this.sP, uA.Sj);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sj)) {
            return false;
        }
        Sj sj2 = (Sj) obj;
        long j11 = this.sP;
        if (j11 != sj2.sP) {
            return false;
        }
        long j12 = 0;
        if (j11 == 0) {
            return true;
        }
        HiB hiB = this.Sj;
        HiB hiB2 = sj2.Sj;
        int i11 = hiB.sP;
        int i12 = hiB2.sP;
        while (j12 < this.sP) {
            long min = Math.min(hiB.TKC - i11, hiB2.TKC - i12);
            int i13 = 0;
            while (i13 < min) {
                int i14 = i11 + 1;
                int i15 = i12 + 1;
                if (hiB.Sj[i11] != hiB2.Sj[i12]) {
                    return false;
                }
                i13++;
                i11 = i14;
                i12 = i15;
            }
            if (i11 == hiB.TKC) {
                hiB = hiB.vS;
                i11 = hiB.sP;
            }
            if (i12 == hiB2.TKC) {
                hiB2 = hiB2.vS;
                i12 = hiB2.sP;
            }
            j12 += min;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        HiB hiB = this.Sj;
        if (hiB == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = hiB.TKC;
            for (int i13 = hiB.sP; i13 < i12; i13++) {
                i11 = (i11 * 31) + hiB.Sj[i13];
            }
            hiB = hiB.vS;
        } while (hiB != this.Sj);
        return i11;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        HiB hiB = this.Sj;
        if (hiB == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), hiB.TKC - hiB.sP);
        byteBuffer.put(hiB.Sj, hiB.sP, min);
        int i11 = hiB.sP + min;
        hiB.sP = i11;
        this.sP -= min;
        if (i11 == hiB.TKC) {
            this.Sj = hiB.sP();
            vS.Sj(hiB);
        }
        return min;
    }

    public byte sP() {
        long j11 = this.sP;
        if (j11 == 0) {
            throw new IllegalStateException("size == 0");
        }
        HiB hiB = this.Sj;
        int i11 = hiB.sP;
        int i12 = hiB.TKC;
        int i13 = i11 + 1;
        byte b11 = hiB.Sj[i11];
        this.sP = j11 - 1;
        if (i13 == i12) {
            this.Sj = hiB.sP();
            vS.Sj(hiB);
        } else {
            hiB.sP = i13;
        }
        return b11;
    }

    public Sj sP(int i11) {
        HiB TKC2 = TKC(1);
        byte[] bArr = TKC2.Sj;
        int i12 = TKC2.TKC;
        TKC2.TKC = i12 + 1;
        bArr[i12] = (byte) i11;
        this.sP++;
        return this;
    }

    public Sj sP(long j11) {
        if (j11 == 0) {
            return sP(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j11)) / 4) + 1;
        HiB TKC2 = TKC(numberOfTrailingZeros);
        byte[] bArr = TKC2.Sj;
        int i11 = TKC2.TKC;
        for (int i12 = (i11 + numberOfTrailingZeros) - 1; i12 >= i11; i12--) {
            bArr[i12] = TKC[(int) (15 & j11)];
            j11 >>>= 4;
        }
        TKC2.TKC += numberOfTrailingZeros;
        this.sP += numberOfTrailingZeros;
        return this;
    }

    public Sj sP(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j11 = i12;
        uA.Sj(bArr.length, i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            HiB TKC2 = TKC(1);
            int min = Math.min(i13 - i11, 8192 - TKC2.TKC);
            System.arraycopy(bArr, i11, TKC2.Sj, TKC2.TKC, min);
            i11 += min;
            TKC2.TKC += min;
        }
        this.sP += j11;
        return this;
    }

    public String toString() {
        return HiB().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i11 = remaining;
        while (i11 > 0) {
            HiB TKC2 = TKC(1);
            int min = Math.min(i11, 8192 - TKC2.TKC);
            byteBuffer.get(TKC2.Sj, TKC2.TKC, min);
            i11 -= min;
            TKC2.TKC += min;
        }
        this.sP += remaining;
        return remaining;
    }
}
