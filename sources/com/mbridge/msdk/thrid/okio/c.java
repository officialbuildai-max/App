package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f38484c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    o f38485a;

    /* renamed from: b, reason: collision with root package name */
    long f38486b;

    /* loaded from: classes5.dex */
    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f38486b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f38486b > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) {
            return c.this.read(bArr, i11, i12);
        }

        public String toString() {
            return c.this + ".inputStream()";
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public long a(byte b11) {
        return a(b11, 0L, Long.MAX_VALUE);
    }

    public long a(byte b11, long j11, long j12) {
        o oVar;
        long j13 = 0;
        if (j11 < 0 || j12 < j11) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f38486b), Long.valueOf(j11), Long.valueOf(j12)));
        }
        long j14 = this.f38486b;
        long j15 = j12 > j14 ? j14 : j12;
        if (j11 == j15 || (oVar = this.f38485a) == null) {
            return -1L;
        }
        if (j14 - j11 < j11) {
            while (j14 > j11) {
                oVar = oVar.f38524g;
                j14 -= oVar.f38520c - oVar.f38519b;
            }
        } else {
            while (true) {
                long j16 = (oVar.f38520c - oVar.f38519b) + j13;
                if (j16 >= j11) {
                    break;
                }
                oVar = oVar.f38523f;
                j13 = j16;
            }
            j14 = j13;
        }
        long j17 = j11;
        while (j14 < j15) {
            byte[] bArr = oVar.f38518a;
            int min = (int) Math.min(oVar.f38520c, (oVar.f38519b + j15) - j14);
            for (int i11 = (int) ((oVar.f38519b + j17) - j14); i11 < min; i11++) {
                if (bArr[i11] == b11) {
                    return (i11 - oVar.f38519b) + j14;
                }
            }
            j14 += oVar.f38520c - oVar.f38519b;
            oVar = oVar.f38523f;
            j17 = j14;
        }
        return -1L;
    }

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j11 = 0;
        while (true) {
            long b11 = sVar.b(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (b11 == -1) {
                return j11;
            }
            j11 += b11;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.e, com.mbridge.msdk.thrid.okio.d
    public c a() {
        return this;
    }

    public final c a(c cVar, long j11, long j12) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.a(this.f38486b, j11, j12);
        if (j12 == 0) {
            return this;
        }
        cVar.f38486b += j12;
        o oVar = this.f38485a;
        while (true) {
            long j13 = oVar.f38520c - oVar.f38519b;
            if (j11 < j13) {
                break;
            }
            j11 -= j13;
            oVar = oVar.f38523f;
        }
        while (j12 > 0) {
            o c11 = oVar.c();
            int i11 = (int) (c11.f38519b + j11);
            c11.f38519b = i11;
            c11.f38520c = Math.min(i11 + ((int) j12), c11.f38520c);
            o oVar2 = cVar.f38485a;
            if (oVar2 == null) {
                c11.f38524g = c11;
                c11.f38523f = c11;
                cVar.f38485a = c11;
            } else {
                oVar2.f38524g.a(c11);
            }
            j12 -= c11.f38520c - c11.f38519b;
            oVar = oVar.f38523f;
            j11 = 0;
        }
        return this;
    }

    public c a(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.a(this);
        return this;
    }

    public c a(String str, int i11, int i12) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i11);
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
                o b11 = b(1);
                byte[] bArr = b11.f38518a;
                int i13 = b11.f38520c - i11;
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
                int i15 = b11.f38520c;
                int i16 = (i13 + i11) - i15;
                b11.f38520c = i15 + i16;
                this.f38486b += i16;
            } else {
                if (charAt2 < 2048) {
                    writeByte((charAt2 >> 6) | PsExtractor.AUDIO_STREAM);
                    writeByte((charAt2 & '?') | 128);
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    writeByte((charAt2 >> '\f') | 224);
                    writeByte(((charAt2 >> 6) & 63) | 128);
                    writeByte((charAt2 & '?') | 128);
                } else {
                    int i17 = i11 + 1;
                    char charAt3 = i17 < i12 ? str.charAt(i17) : (char) 0;
                    if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        writeByte(63);
                        i11 = i17;
                    } else {
                        int i18 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                        writeByte((i18 >> 18) | 240);
                        writeByte(((i18 >> 12) & 63) | 128);
                        writeByte(((i18 >> 6) & 63) | 128);
                        writeByte((i18 & 63) | 128);
                        i11 += 2;
                    }
                }
                i11++;
            }
        }
        return this;
    }

    public c a(String str, int i11, int i12, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i11);
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < " + i11);
        }
        if (i12 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(u.f38533a)) {
                return a(str, i11, i12);
            }
            byte[] bytes = str.substring(i11, i12).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + str.length());
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c write(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j11 = i12;
        u.a(bArr.length, i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            o b11 = b(1);
            int min = Math.min(i13 - i11, 8192 - b11.f38520c);
            System.arraycopy(bArr, i11, b11.f38518a, b11.f38520c, min);
            i11 += min;
            b11.f38520c += min;
        }
        this.f38486b += j11;
        return this;
    }

    public final f a(int i11) {
        return i11 == 0 ? f.f38489e : new q(this, i11);
    }

    public String a(long j11, Charset charset) throws EOFException {
        u.a(this.f38486b, 0L, j11);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j11);
        }
        if (j11 == 0) {
            return "";
        }
        o oVar = this.f38485a;
        int i11 = oVar.f38519b;
        if (i11 + j11 > oVar.f38520c) {
            return new String(c(j11), charset);
        }
        String str = new String(oVar.f38518a, i11, (int) j11, charset);
        int i12 = (int) (oVar.f38519b + j11);
        oVar.f38519b = i12;
        this.f38486b -= j11;
        if (i12 == oVar.f38520c) {
            this.f38485a = oVar.b();
            p.a(oVar);
        }
        return str;
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public void a(c cVar, long j11) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.a(cVar.f38486b, 0L, j11);
        while (j11 > 0) {
            o oVar = cVar.f38485a;
            if (j11 < oVar.f38520c - oVar.f38519b) {
                o oVar2 = this.f38485a;
                o oVar3 = oVar2 != null ? oVar2.f38524g : null;
                if (oVar3 != null && oVar3.f38522e) {
                    if ((oVar3.f38520c + j11) - (oVar3.f38521d ? 0 : oVar3.f38519b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        oVar.a(oVar3, (int) j11);
                        cVar.f38486b -= j11;
                        this.f38486b += j11;
                        return;
                    }
                }
                cVar.f38485a = oVar.a((int) j11);
            }
            o oVar4 = cVar.f38485a;
            long j12 = oVar4.f38520c - oVar4.f38519b;
            cVar.f38485a = oVar4.b();
            o oVar5 = this.f38485a;
            if (oVar5 == null) {
                this.f38485a = oVar4;
                oVar4.f38524g = oVar4;
                oVar4.f38523f = oVar4;
            } else {
                oVar5.f38524g.a(oVar4).a();
            }
            cVar.f38486b -= j12;
            this.f38486b += j12;
            j11 -= j12;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public long b(c cVar, long j11) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        long j12 = this.f38486b;
        if (j12 == 0) {
            return -1L;
        }
        if (j11 > j12) {
            j11 = j12;
        }
        cVar.a(this, j11);
        return j11;
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(String str) {
        return a(str, 0, str.length());
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public f b(long j11) throws EOFException {
        return new f(c(j11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o b(int i11) {
        if (i11 < 1 || i11 > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.f38485a;
        if (oVar != null) {
            o oVar2 = oVar.f38524g;
            return (oVar2.f38520c + i11 > 8192 || !oVar2.f38522e) ? oVar2.a(p.a()) : oVar2;
        }
        o a11 = p.a();
        this.f38485a = a11;
        a11.f38524g = a11;
        a11.f38523f = a11;
        return a11;
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public t b() {
        return t.f38529d;
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c writeByte(int i11) {
        o b11 = b(1);
        byte[] bArr = b11.f38518a;
        int i12 = b11.f38520c;
        b11.f38520c = i12 + 1;
        bArr[i12] = (byte) i11;
        this.f38486b++;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public String c() throws EOFException {
        return d(Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public byte[] c(long j11) throws EOFException {
        u.a(this.f38486b, 0L, j11);
        if (j11 <= 2147483647L) {
            byte[] bArr = new byte[(int) j11];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c writeInt(int i11) {
        o b11 = b(4);
        byte[] bArr = b11.f38518a;
        int i12 = b11.f38520c;
        bArr[i12] = (byte) ((i11 >>> 24) & 255);
        bArr[i12 + 1] = (byte) ((i11 >>> 16) & 255);
        bArr[i12 + 2] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 3] = (byte) (i11 & 255);
        b11.f38520c = i12 + 4;
        this.f38486b += 4;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public String d(long j11) throws EOFException {
        if (j11 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j11);
        }
        long j12 = j11 != Long.MAX_VALUE ? j11 + 1 : Long.MAX_VALUE;
        long a11 = a((byte) 10, 0L, j12);
        if (a11 != -1) {
            return h(a11);
        }
        if (j12 < size() && f(j12 - 1) == 13 && f(j12) == 10) {
            return h(j12);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j11) + " content=" + cVar.o().b() + (char) 8230);
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public int e() {
        return u.a(readInt());
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c writeShort(int i11) {
        o b11 = b(2);
        byte[] bArr = b11.f38518a;
        int i12 = b11.f38520c;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 1] = (byte) (i11 & 255);
        b11.f38520c = i12 + 2;
        this.f38486b += 2;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void e(long j11) throws EOFException {
        if (this.f38486b < j11) {
            throw new EOFException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j11 = this.f38486b;
        if (j11 != cVar.f38486b) {
            return false;
        }
        long j12 = 0;
        if (j11 == 0) {
            return true;
        }
        o oVar = this.f38485a;
        o oVar2 = cVar.f38485a;
        int i11 = oVar.f38519b;
        int i12 = oVar2.f38519b;
        while (j12 < this.f38486b) {
            long min = Math.min(oVar.f38520c - i11, oVar2.f38520c - i12);
            int i13 = 0;
            while (i13 < min) {
                int i14 = i11 + 1;
                int i15 = i12 + 1;
                if (oVar.f38518a[i11] != oVar2.f38518a[i12]) {
                    return false;
                }
                i13++;
                i11 = i14;
                i12 = i15;
            }
            if (i11 == oVar.f38520c) {
                oVar = oVar.f38523f;
                i11 = oVar.f38519b;
            }
            if (i12 == oVar2.f38520c) {
                oVar2 = oVar2.f38523f;
                i12 = oVar2.f38519b;
            }
            j12 += min;
        }
        return true;
    }

    public final byte f(long j11) {
        u.a(this.f38486b, j11, 1L);
        long j12 = this.f38486b;
        if (j12 - j11 > j11) {
            o oVar = this.f38485a;
            while (true) {
                int i11 = oVar.f38520c;
                int i12 = oVar.f38519b;
                long j13 = i11 - i12;
                if (j11 < j13) {
                    return oVar.f38518a[i12 + ((int) j11)];
                }
                j11 -= j13;
                oVar = oVar.f38523f;
            }
        } else {
            long j14 = j11 - j12;
            o oVar2 = this.f38485a.f38524g;
            while (true) {
                int i13 = oVar2.f38520c;
                int i14 = oVar2.f38519b;
                j14 += i13 - i14;
                if (j14 >= 0) {
                    return oVar2.f38518a[i14 + ((int) j14)];
                }
                oVar2 = oVar2.f38524g;
            }
        }
    }

    public c f(int i11) {
        if (i11 < 128) {
            writeByte(i11);
        } else if (i11 < 2048) {
            writeByte((i11 >> 6) | PsExtractor.AUDIO_STREAM);
            writeByte((i11 & 63) | 128);
        } else if (i11 < 65536) {
            if (i11 < 55296 || i11 > 57343) {
                writeByte((i11 >> 12) | 224);
                writeByte(((i11 >> 6) & 63) | 128);
                writeByte((i11 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else {
            if (i11 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i11));
            }
            writeByte((i11 >> 18) | 240);
            writeByte(((i11 >> 12) & 63) | 128);
            writeByte(((i11 >> 6) & 63) | 128);
            writeByte((i11 & 63) | 128);
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public boolean f() {
        return this.f38486b == 0;
    }

    @Override // com.mbridge.msdk.thrid.okio.d, com.mbridge.msdk.thrid.okio.r, java.io.Flushable
    public void flush() {
    }

    public String g(long j11) throws EOFException {
        return a(j11, u.f38533a);
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public short g() {
        return u.a(readShort());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h(long j11) throws EOFException {
        if (j11 > 0) {
            long j12 = j11 - 1;
            if (f(j12) == 13) {
                String g11 = g(j12);
                skip(2L);
                return g11;
            }
        }
        String g12 = g(j11);
        skip(1L);
        return g12;
    }

    public int hashCode() {
        o oVar = this.f38485a;
        if (oVar == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = oVar.f38520c;
            for (int i13 = oVar.f38519b; i13 < i12; i13++) {
                i11 = (i11 * 31) + oVar.f38518a[i13];
            }
            oVar = oVar.f38523f;
        } while (oVar != this.f38485a);
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[EDGE_INSN: B:40:0x00a2->B:37:0x00a2 BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    @Override // com.mbridge.msdk.thrid.okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long i() {
        /*
            r14 = this;
            long r0 = r14.f38486b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La9
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            com.mbridge.msdk.thrid.okio.o r6 = r14.f38485a
            byte[] r7 = r6.f38518a
            int r8 = r6.f38519b
            int r9 = r6.f38520c
        L13:
            if (r8 >= r9) goto L8e
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L37
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-87)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L6f
            r11 = 70
            if (r10 > r11) goto L6f
            int r11 = r10 + (-55)
        L37:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L47
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L47:
            com.mbridge.msdk.thrid.okio.c r0 = new com.mbridge.msdk.thrid.okio.c
            r0.<init>()
            com.mbridge.msdk.thrid.okio.c r0 = r0.a(r4)
            com.mbridge.msdk.thrid.okio.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.p()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L6f:
            if (r0 == 0) goto L73
            r1 = 1
            goto L8e
        L73:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8e:
            if (r8 != r9) goto L9a
            com.mbridge.msdk.thrid.okio.o r7 = r6.b()
            r14.f38485a = r7
            com.mbridge.msdk.thrid.okio.p.a(r6)
            goto L9c
        L9a:
            r6.f38519b = r8
        L9c:
            if (r1 != 0) goto La2
            com.mbridge.msdk.thrid.okio.o r6 = r14.f38485a
            if (r6 != 0) goto Lb
        La2:
            long r1 = r14.f38486b
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f38486b = r1
            return r4
        La9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.c.i():long");
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public c a(long j11) {
        if (j11 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j11)) / 4) + 1;
        o b11 = b(numberOfTrailingZeros);
        byte[] bArr = b11.f38518a;
        int i11 = b11.f38520c;
        for (int i12 = (i11 + numberOfTrailingZeros) - 1; i12 >= i11; i12--) {
            bArr[i12] = f38484c[(int) (15 & j11)];
            j11 >>>= 4;
        }
        b11.f38520c += numberOfTrailingZeros;
        this.f38486b += numberOfTrailingZeros;
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public InputStream j() {
        return new a();
    }

    public final void k() {
        try {
            skip(this.f38486b);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.f38486b == 0) {
            return cVar;
        }
        o c11 = this.f38485a.c();
        cVar.f38485a = c11;
        c11.f38524g = c11;
        c11.f38523f = c11;
        for (o oVar = this.f38485a.f38523f; oVar != this.f38485a; oVar = oVar.f38523f) {
            cVar.f38485a.f38524g.a(oVar.c());
        }
        cVar.f38486b = this.f38486b;
        return cVar;
    }

    public final long m() {
        long j11 = this.f38486b;
        if (j11 == 0) {
            return 0L;
        }
        o oVar = this.f38485a.f38524g;
        return (oVar.f38520c >= 8192 || !oVar.f38522e) ? j11 : j11 - (r3 - oVar.f38519b);
    }

    public byte[] n() {
        try {
            return c(this.f38486b);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }

    public f o() {
        return new f(n());
    }

    public String p() {
        try {
            return a(this.f38486b, u.f38533a);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }

    public final f q() {
        long j11 = this.f38486b;
        if (j11 <= 2147483647L) {
            return a((int) j11);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f38486b);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.f38485a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f38520c - oVar.f38519b);
        byteBuffer.put(oVar.f38518a, oVar.f38519b, min);
        int i11 = oVar.f38519b + min;
        oVar.f38519b = i11;
        this.f38486b -= min;
        if (i11 == oVar.f38520c) {
            this.f38485a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public int read(byte[] bArr, int i11, int i12) {
        u.a(bArr.length, i11, i12);
        o oVar = this.f38485a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i12, oVar.f38520c - oVar.f38519b);
        System.arraycopy(oVar.f38518a, oVar.f38519b, bArr, i11, min);
        int i13 = oVar.f38519b + min;
        oVar.f38519b = i13;
        this.f38486b -= min;
        if (i13 == oVar.f38520c) {
            this.f38485a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public byte readByte() {
        long j11 = this.f38486b;
        if (j11 == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.f38485a;
        int i11 = oVar.f38519b;
        int i12 = oVar.f38520c;
        int i13 = i11 + 1;
        byte b11 = oVar.f38518a[i11];
        this.f38486b = j11 - 1;
        if (i13 == i12) {
            this.f38485a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f38519b = i13;
        }
        return b11;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void readFully(byte[] bArr) throws EOFException {
        int i11 = 0;
        while (i11 < bArr.length) {
            int read = read(bArr, i11, bArr.length - i11);
            if (read == -1) {
                throw new EOFException();
            }
            i11 += read;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public int readInt() {
        long j11 = this.f38486b;
        if (j11 < 4) {
            throw new IllegalStateException("size < 4: " + this.f38486b);
        }
        o oVar = this.f38485a;
        int i11 = oVar.f38519b;
        int i12 = oVar.f38520c;
        if (i12 - i11 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = oVar.f38518a;
        int i13 = i11 + 3;
        int i14 = ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 2] & 255) << 8);
        int i15 = i11 + 4;
        int i16 = (bArr[i13] & 255) | i14;
        this.f38486b = j11 - 4;
        if (i15 == i12) {
            this.f38485a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f38519b = i15;
        }
        return i16;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public short readShort() {
        long j11 = this.f38486b;
        if (j11 < 2) {
            throw new IllegalStateException("size < 2: " + this.f38486b);
        }
        o oVar = this.f38485a;
        int i11 = oVar.f38519b;
        int i12 = oVar.f38520c;
        if (i12 - i11 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = oVar.f38518a;
        int i13 = i11 + 1;
        int i14 = (bArr[i11] & 255) << 8;
        int i15 = i11 + 2;
        int i16 = (bArr[i13] & 255) | i14;
        this.f38486b = j11 - 2;
        if (i15 == i12) {
            this.f38485a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f38519b = i15;
        }
        return (short) i16;
    }

    public final long size() {
        return this.f38486b;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void skip(long j11) throws EOFException {
        while (j11 > 0) {
            if (this.f38485a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j11, r0.f38520c - r0.f38519b);
            long j12 = min;
            this.f38486b -= j12;
            j11 -= j12;
            o oVar = this.f38485a;
            int i11 = oVar.f38519b + min;
            oVar.f38519b = i11;
            if (i11 == oVar.f38520c) {
                this.f38485a = oVar.b();
                p.a(oVar);
            }
        }
    }

    public String toString() {
        return q().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i11 = remaining;
        while (i11 > 0) {
            o b11 = b(1);
            int min = Math.min(i11, 8192 - b11.f38520c);
            byteBuffer.get(b11.f38518a, b11.f38520c, min);
            i11 -= min;
            b11.f38520c += min;
        }
        this.f38486b += remaining;
        return remaining;
    }
}
