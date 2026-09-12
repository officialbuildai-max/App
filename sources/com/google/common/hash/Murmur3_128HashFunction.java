package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class Murmur3_128HashFunction extends com.google.common.hash.a implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final d MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final d GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(f.f30934a);

    /* loaded from: classes4.dex */
    private static final class a extends c {

        /* renamed from: d, reason: collision with root package name */
        private long f30922d;

        /* renamed from: e, reason: collision with root package name */
        private long f30923e;

        /* renamed from: f, reason: collision with root package name */
        private int f30924f;

        a(int i11) {
            super(16);
            long j11 = i11;
            this.f30922d = j11;
            this.f30923e = j11;
            this.f30924f = 0;
        }

        private void q(long j11, long j12) {
            long s11 = s(j11) ^ this.f30922d;
            this.f30922d = s11;
            long rotateLeft = Long.rotateLeft(s11, 27);
            long j13 = this.f30923e;
            this.f30922d = ((rotateLeft + j13) * 5) + 1390208809;
            long t11 = t(j12) ^ j13;
            this.f30923e = t11;
            this.f30923e = ((Long.rotateLeft(t11, 31) + this.f30922d) * 5) + 944331445;
        }

        private static long r(long j11) {
            long j12 = (j11 ^ (j11 >>> 33)) * (-49064778989728563L);
            long j13 = (j12 ^ (j12 >>> 33)) * (-4265267296055464877L);
            return j13 ^ (j13 >>> 33);
        }

        private static long s(long j11) {
            return Long.rotateLeft(j11 * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        private static long t(long j11) {
            return Long.rotateLeft(j11 * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.c
        protected HashCode k() {
            long j11 = this.f30922d;
            int i11 = this.f30924f;
            long j12 = j11 ^ i11;
            long j13 = this.f30923e ^ i11;
            long j14 = j12 + j13;
            this.f30922d = j14;
            this.f30923e = j13 + j14;
            this.f30922d = r(j14);
            long r11 = r(this.f30923e);
            long j15 = this.f30922d + r11;
            this.f30922d = j15;
            this.f30923e = r11 + j15;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f30922d).putLong(this.f30923e).array());
        }

        @Override // com.google.common.hash.c
        protected void n(ByteBuffer byteBuffer) {
            q(byteBuffer.getLong(), byteBuffer.getLong());
            this.f30924f += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001b. Please report as an issue. */
        @Override // com.google.common.hash.c
        protected void o(ByteBuffer byteBuffer) {
            long j11;
            long j12;
            long j13;
            long j14;
            long j15;
            long j16;
            long c11;
            this.f30924f += byteBuffer.remaining();
            long j17 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j11 = 0;
                    c11 = j11 ^ com.google.common.primitives.e.c(byteBuffer.get(0));
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 2:
                    j12 = 0;
                    j11 = j12 ^ (com.google.common.primitives.e.c(byteBuffer.get(1)) << 8);
                    c11 = j11 ^ com.google.common.primitives.e.c(byteBuffer.get(0));
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 3:
                    j13 = 0;
                    j12 = (com.google.common.primitives.e.c(byteBuffer.get(2)) << 16) ^ j13;
                    j11 = j12 ^ (com.google.common.primitives.e.c(byteBuffer.get(1)) << 8);
                    c11 = j11 ^ com.google.common.primitives.e.c(byteBuffer.get(0));
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 4:
                    j14 = 0;
                    j13 = j14 ^ (com.google.common.primitives.e.c(byteBuffer.get(3)) << 24);
                    j12 = (com.google.common.primitives.e.c(byteBuffer.get(2)) << 16) ^ j13;
                    j11 = j12 ^ (com.google.common.primitives.e.c(byteBuffer.get(1)) << 8);
                    c11 = j11 ^ com.google.common.primitives.e.c(byteBuffer.get(0));
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 5:
                    j15 = 0;
                    j14 = j15 ^ (com.google.common.primitives.e.c(byteBuffer.get(4)) << 32);
                    j13 = j14 ^ (com.google.common.primitives.e.c(byteBuffer.get(3)) << 24);
                    j12 = (com.google.common.primitives.e.c(byteBuffer.get(2)) << 16) ^ j13;
                    j11 = j12 ^ (com.google.common.primitives.e.c(byteBuffer.get(1)) << 8);
                    c11 = j11 ^ com.google.common.primitives.e.c(byteBuffer.get(0));
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 6:
                    j16 = 0;
                    j15 = (com.google.common.primitives.e.c(byteBuffer.get(5)) << 40) ^ j16;
                    j14 = j15 ^ (com.google.common.primitives.e.c(byteBuffer.get(4)) << 32);
                    j13 = j14 ^ (com.google.common.primitives.e.c(byteBuffer.get(3)) << 24);
                    j12 = (com.google.common.primitives.e.c(byteBuffer.get(2)) << 16) ^ j13;
                    j11 = j12 ^ (com.google.common.primitives.e.c(byteBuffer.get(1)) << 8);
                    c11 = j11 ^ com.google.common.primitives.e.c(byteBuffer.get(0));
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 7:
                    j16 = com.google.common.primitives.e.c(byteBuffer.get(6)) << 48;
                    j15 = (com.google.common.primitives.e.c(byteBuffer.get(5)) << 40) ^ j16;
                    j14 = j15 ^ (com.google.common.primitives.e.c(byteBuffer.get(4)) << 32);
                    j13 = j14 ^ (com.google.common.primitives.e.c(byteBuffer.get(3)) << 24);
                    j12 = (com.google.common.primitives.e.c(byteBuffer.get(2)) << 16) ^ j13;
                    j11 = j12 ^ (com.google.common.primitives.e.c(byteBuffer.get(1)) << 8);
                    c11 = j11 ^ com.google.common.primitives.e.c(byteBuffer.get(0));
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 8:
                    c11 = byteBuffer.getLong();
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 9:
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(8));
                    c11 = byteBuffer.getLong();
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 10:
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(9)) << 8;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(8));
                    c11 = byteBuffer.getLong();
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 11:
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(10)) << 16;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(9)) << 8;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(8));
                    c11 = byteBuffer.getLong();
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 12:
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(11)) << 24;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(10)) << 16;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(9)) << 8;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(8));
                    c11 = byteBuffer.getLong();
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 13:
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(12)) << 32;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(11)) << 24;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(10)) << 16;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(9)) << 8;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(8));
                    c11 = byteBuffer.getLong();
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 14:
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(13)) << 40;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(12)) << 32;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(11)) << 24;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(10)) << 16;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(9)) << 8;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(8));
                    c11 = byteBuffer.getLong();
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                case 15:
                    j17 = com.google.common.primitives.e.c(byteBuffer.get(14)) << 48;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(13)) << 40;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(12)) << 32;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(11)) << 24;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(10)) << 16;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(9)) << 8;
                    j17 ^= com.google.common.primitives.e.c(byteBuffer.get(8));
                    c11 = byteBuffer.getLong();
                    this.f30922d = s(c11) ^ this.f30922d;
                    this.f30923e ^= t(j17);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Murmur3_128HashFunction(int i11) {
        this.seed = i11;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.d
    public e newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }
}
