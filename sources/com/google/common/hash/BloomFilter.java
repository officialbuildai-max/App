package com.google.common.hash;

import com.google.common.base.j;
import com.google.common.base.m;
import com.google.common.base.n;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.primitives.SignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;

/* loaded from: classes4.dex */
public final class BloomFilter<T> implements n, Serializable {
    private static final long serialVersionUID = 912559;
    private final BloomFilterStrategies.a bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* loaded from: classes4.dex */
    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.a.h(((BloomFilter) bloomFilter).bits.f30918a);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t11, Funnel<? super T> funnel, int i11, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(T t11, Funnel<? super T> funnel, int i11, BloomFilterStrategies.a aVar);
    }

    private BloomFilter(BloomFilterStrategies.a aVar, int i11, Funnel<? super T> funnel, Strategy strategy) {
        m.f(i11 > 0, "numHashFunctions (%s) must be > 0", i11);
        m.f(i11 <= 255, "numHashFunctions (%s) must be <= 255", i11);
        this.bits = (BloomFilterStrategies.a) m.o(aVar);
        this.numHashFunctions = i11;
        this.funnel = (Funnel) m.o(funnel);
        this.strategy = (Strategy) m.o(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i11) {
        return create(funnel, i11);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i11, double d11) {
        return create(funnel, i11, d11);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j11) {
        return create(funnel, j11, 0.03d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j11, double d11) {
        return create(funnel, j11, d11, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j11, double d11, Strategy strategy) {
        m.o(funnel);
        m.h(j11 >= 0, "Expected insertions (%s) must be >= 0", j11);
        m.j(d11 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d11));
        m.j(d11 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d11));
        m.o(strategy);
        if (j11 == 0) {
            j11 = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j11, d11);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.a(optimalNumOfBits), optimalNumOfHashFunctions(j11, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e11);
        }
    }

    static long optimalNumOfBits(long j11, double d11) {
        if (d11 == 0.0d) {
            d11 = Double.MIN_VALUE;
        }
        return (long) (((-j11) * Math.log(d11)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    static int optimalNumOfHashFunctions(long j11, long j12) {
        return Math.max(1, (int) Math.round((j12 / j11) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i11;
        int i12;
        m.p(inputStream, "InputStream");
        m.p(funnel, "Funnel");
        int i13 = -1;
        try {
            try {
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                byte readByte = dataInputStream.readByte();
                try {
                    i12 = com.google.common.primitives.e.c(dataInputStream.readByte());
                    try {
                        i13 = dataInputStream.readInt();
                        BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                        BloomFilterStrategies.a aVar = new BloomFilterStrategies.a(com.google.common.math.f.b(i13, 64L));
                        for (int i14 = 0; i14 < i13; i14++) {
                            aVar.f(i14, dataInputStream.readLong());
                        }
                        return new BloomFilter<>(aVar, i12, funnel, bloomFilterStrategies);
                    } catch (Exception e11) {
                        e = e11;
                        int i15 = i13;
                        i13 = readByte;
                        i11 = i15;
                        throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + i13 + " numHashFunctions: " + i12 + " dataLength: " + i11, e);
                    }
                } catch (Exception e12) {
                    e = e12;
                    i12 = -1;
                    i13 = readByte;
                    i11 = -1;
                }
            } catch (IOException e13) {
                throw e13;
            }
        } catch (Exception e14) {
            e = e14;
            i11 = -1;
            i12 = -1;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.n
    @Deprecated
    public boolean apply(T t11) {
        return mightContain(t11);
    }

    public long approximateElementCount() {
        double b11 = this.bits.b();
        return com.google.common.math.b.f(((-Math.log1p(-(this.bits.a() / b11))) * b11) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    long bitSize() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.n
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.a() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return j.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        m.o(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t11) {
        return this.strategy.mightContain(t11, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T t11) {
        return this.strategy.put(t11, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        m.o(bloomFilter);
        m.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i11 = this.numHashFunctions;
        int i12 = bloomFilter.numHashFunctions;
        m.g(i11 == i12, "BloomFilters must have the same number of hash functions (%s != %s)", i11, i12);
        m.i(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        m.k(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        m.k(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(com.google.common.primitives.e.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f30918a.length());
        for (int i11 = 0; i11 < this.bits.f30918a.length(); i11++) {
            dataOutputStream.writeLong(this.bits.f30918a.get(i11));
        }
    }
}
