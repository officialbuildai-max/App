package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class DiscreteDomain {
    final boolean supportsFastOffset;

    /* loaded from: classes4.dex */
    private static final class BigIntegerDomain extends DiscreteDomain implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final BigIntegerDomain f30432a = new BigIntegerDomain();

        /* renamed from: b, reason: collision with root package name */
        private static final BigInteger f30433b = BigInteger.valueOf(Long.MIN_VALUE);

        /* renamed from: c, reason: collision with root package name */
        private static final BigInteger f30434c = BigInteger.valueOf(Long.MAX_VALUE);
        private static final long serialVersionUID = 0;

        BigIntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f30432a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(f30433b).min(f30434c).longValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger next(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger offset(BigInteger bigInteger, long j11) {
            e2.c(j11, "distance");
            return bigInteger.add(BigInteger.valueOf(j11));
        }

        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger previous(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    /* loaded from: classes4.dex */
    private static final class IntegerDomain extends DiscreteDomain implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final IntegerDomain f30435a = new IntegerDomain();
        private static final long serialVersionUID = 0;

        IntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f30435a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public long distance(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer next(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer offset(Integer num, long j11) {
            e2.c(j11, "distance");
            return Integer.valueOf(Ints.d(num.longValue() + j11));
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer previous(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    /* loaded from: classes4.dex */
    private static final class LongDomain extends DiscreteDomain implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final LongDomain f30436a = new LongDomain();
        private static final long serialVersionUID = 0;

        LongDomain() {
            super(true);
        }

        private Object readResolve() {
            return f30436a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public long distance(Long l11, Long l12) {
            long longValue = l12.longValue() - l11.longValue();
            if (l12.longValue() > l11.longValue() && longValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l12.longValue() >= l11.longValue() || longValue <= 0) {
                return longValue;
            }
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long next(Long l11) {
            long longValue = l11.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(longValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        public Long offset(Long l11, long j11) {
            e2.c(j11, "distance");
            long longValue = l11.longValue() + j11;
            if (longValue < 0) {
                com.google.common.base.m.e(l11.longValue() < 0, "overflow");
            }
            return Long.valueOf(longValue);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long previous(Long l11) {
            long longValue = l11.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(longValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    protected DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean z10) {
        this.supportsFastOffset = z10;
    }

    public static DiscreteDomain bigIntegers() {
        return BigIntegerDomain.f30432a;
    }

    public static DiscreteDomain integers() {
        return IntegerDomain.f30435a;
    }

    public static DiscreteDomain longs() {
        return LongDomain.f30436a;
    }

    public abstract long distance(Comparable comparable, Comparable comparable2);

    public Comparable maxValue() {
        throw new NoSuchElementException();
    }

    public Comparable minValue() {
        throw new NoSuchElementException();
    }

    public abstract Comparable next(Comparable comparable);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Comparable offset(Comparable comparable, long j11);

    public abstract Comparable previous(Comparable comparable);
}
