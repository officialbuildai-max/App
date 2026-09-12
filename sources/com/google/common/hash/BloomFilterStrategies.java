package com.google.common.hash;

import com.google.common.base.m;
import com.google.common.hash.BloomFilter;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilterStrategies, com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t11, Funnel<? super T> funnel, int i11, a aVar) {
            long b11 = aVar.b();
            long asLong = f.a().hashObject(t11, funnel).asLong();
            int i12 = (int) asLong;
            int i13 = (int) (asLong >>> 32);
            for (int i14 = 1; i14 <= i11; i14++) {
                int i15 = (i14 * i13) + i12;
                if (i15 < 0) {
                    i15 = ~i15;
                }
                if (!aVar.d(i15 % b11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilterStrategies, com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t11, Funnel<? super T> funnel, int i11, a aVar) {
            long b11 = aVar.b();
            long asLong = f.a().hashObject(t11, funnel).asLong();
            int i12 = (int) asLong;
            int i13 = (int) (asLong >>> 32);
            boolean z10 = false;
            for (int i14 = 1; i14 <= i11; i14++) {
                int i15 = (i14 * i13) + i12;
                if (i15 < 0) {
                    i15 = ~i15;
                }
                z10 |= aVar.g(i15 % b11);
            }
            return z10;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.d(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.d(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilterStrategies, com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t11, Funnel<? super T> funnel, int i11, a aVar) {
            long b11 = aVar.b();
            byte[] bytesInternal = f.a().hashObject(t11, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i12 = 0; i12 < i11; i12++) {
                if (!aVar.d((Long.MAX_VALUE & lowerEight) % b11)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilterStrategies, com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t11, Funnel<? super T> funnel, int i11, a aVar) {
            long b11 = aVar.b();
            byte[] bytesInternal = f.a().hashObject(t11, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z10 = false;
            for (int i12 = 0; i12 < i11; i12++) {
                z10 |= aVar.g((Long.MAX_VALUE & lowerEight) % b11);
                lowerEight += upperEight;
            }
            return z10;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final AtomicLongArray f30918a;

        /* renamed from: b, reason: collision with root package name */
        private final h f30919b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(long j11) {
            m.e(j11 > 0, "data length is zero!");
            this.f30918a = new AtomicLongArray(Ints.d(com.google.common.math.f.c(j11, 64L, RoundingMode.CEILING)));
            this.f30919b = LongAddables.a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(long[] jArr) {
            m.e(jArr.length > 0, "data length is zero!");
            this.f30918a = new AtomicLongArray(jArr);
            this.f30919b = LongAddables.a();
            long j11 = 0;
            for (long j12 : jArr) {
                j11 += Long.bitCount(j12);
            }
            this.f30919b.add(j11);
        }

        public static long[] h(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i11 = 0; i11 < length; i11++) {
                jArr[i11] = atomicLongArray.get(i11);
            }
            return jArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long a() {
            return this.f30919b.sum();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long b() {
            return this.f30918a.length() * 64;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a c() {
            return new a(h(this.f30918a));
        }

        boolean d(long j11) {
            return ((1 << ((int) j11)) & this.f30918a.get((int) (j11 >>> 6))) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(a aVar) {
            m.g(this.f30918a.length() == aVar.f30918a.length(), "BitArrays must be of equal length (%s != %s)", this.f30918a.length(), aVar.f30918a.length());
            for (int i11 = 0; i11 < this.f30918a.length(); i11++) {
                f(i11, aVar.f30918a.get(i11));
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(h(this.f30918a), h(((a) obj).f30918a));
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(int i11, long j11) {
            long j12;
            long j13;
            do {
                j12 = this.f30918a.get(i11);
                j13 = j12 | j11;
                if (j12 == j13) {
                    return;
                }
            } while (!this.f30918a.compareAndSet(i11, j12, j13));
            this.f30919b.add(Long.bitCount(j13) - Long.bitCount(j12));
        }

        boolean g(long j11) {
            long j12;
            long j13;
            if (d(j11)) {
                return false;
            }
            int i11 = (int) (j11 >>> 6);
            long j14 = 1 << ((int) j11);
            do {
                j12 = this.f30918a.get(i11);
                j13 = j12 | j14;
                if (j12 == j13) {
                    return false;
                }
            } while (!this.f30918a.compareAndSet(i11, j12, j13));
            this.f30919b.increment();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(h(this.f30918a));
        }
    }

    @Override // com.google.common.hash.BloomFilter.Strategy
    public abstract /* synthetic */ boolean mightContain(Object obj, Funnel funnel, int i11, a aVar);

    @Override // com.google.common.hash.BloomFilter.Strategy
    public abstract /* synthetic */ boolean put(Object obj, Funnel funnel, int i11, a aVar);
}
