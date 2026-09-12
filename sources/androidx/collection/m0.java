package androidx.collection;

import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class m0 extends s0 {

    /* renamed from: f, reason: collision with root package name */
    private int f2375f;

    public m0() {
        this(0, 1, null);
    }

    public m0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        n(v0.g(i11));
    }

    public /* synthetic */ m0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    private final void h() {
        int compare;
        if (this.f2406d > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f2407e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f2406d) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                i();
                return;
            }
        }
        o(v0.e(this.f2406d));
    }

    private final void i() {
        Object[] objArr;
        int i11;
        int i12;
        long[] jArr = this.f2403a;
        int i13 = this.f2406d;
        Object[] objArr2 = this.f2404b;
        long[] jArr2 = this.f2405c;
        v0.a(jArr, i13);
        int i14 = 0;
        int i15 = 0;
        int i16 = -1;
        while (i15 != i13) {
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j11 = (jArr[i17] >> i18) & 255;
            if (j11 == 128) {
                i16 = i15;
                i15++;
            } else {
                if (j11 == 254) {
                    Object obj = objArr2[i15];
                    int hashCode = (obj != null ? obj.hashCode() : i14) * (-862048943);
                    int i19 = (hashCode ^ (hashCode << 16)) >>> 7;
                    int j12 = j(i19);
                    int i20 = i19 & i13;
                    if (((j12 - i20) & i13) / 8 == ((i15 - i20) & i13) / 8) {
                        jArr[i17] = ((r10 & 127) << i18) | ((~(255 << i18)) & jArr[i17]);
                        jArr[ArraysKt.a0(jArr)] = (jArr[i14] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i21 = j12 >> 3;
                        long j13 = jArr[i21];
                        int i22 = (j12 & 7) << 3;
                        if (((j13 >> i22) & 255) == 128) {
                            int i23 = i15;
                            objArr = objArr2;
                            jArr[i21] = (j13 & (~(255 << i22))) | ((r10 & 127) << i22);
                            jArr[i17] = (jArr[i17] & (~(255 << i18))) | (128 << i18);
                            objArr[j12] = objArr[i23];
                            objArr[i23] = null;
                            jArr2[j12] = jArr2[i23];
                            jArr2[i23] = 0;
                            i12 = i23;
                            i16 = i12;
                            i11 = i13;
                        } else {
                            int i24 = i13;
                            objArr = objArr2;
                            int i25 = i15;
                            jArr[i21] = ((r10 & 127) << i22) | (j13 & (~(255 << i22)));
                            if (i16 == -1) {
                                i11 = i24;
                                i16 = v0.b(jArr, i25 + 1, i11);
                            } else {
                                i11 = i24;
                            }
                            objArr[i16] = objArr[j12];
                            objArr[j12] = objArr[i25];
                            objArr[i25] = objArr[i16];
                            jArr2[i16] = jArr2[j12];
                            jArr2[j12] = jArr2[i25];
                            jArr2[i25] = jArr2[i16];
                            i12 = i25 - 1;
                        }
                        i14 = 0;
                        jArr[ArraysKt.a0(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i15 = i12 + 1;
                        i13 = i11;
                        objArr2 = objArr;
                    }
                }
                i15++;
            }
        }
        l();
    }

    private final int j(int i11) {
        int i12 = this.f2406d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f2403a;
            int i15 = i13 >> 3;
            int i16 = (i13 & 7) << 3;
            long j11 = ((jArr[i15 + 1] << (64 - i16)) & ((-i16) >> 63)) | (jArr[i15] >>> i16);
            long j12 = j11 & ((~j11) << 7) & (-9187201950435737472L);
            if (j12 != 0) {
                return (i13 + (Long.numberOfTrailingZeros(j12) >> 3)) & i12;
            }
            i14 += 8;
            i13 = (i13 + i14) & i12;
        }
    }

    private final int k(Object obj) {
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i11 = hashCode ^ (hashCode << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f2406d;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f2403a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = i13;
            int i19 = i13;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int numberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j14) >> 3)) & i14;
                if (Intrinsics.c(this.f2404b[numberOfTrailingZeros], obj)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int j15 = j(i12);
                if (this.f2375f == 0 && ((this.f2403a[j15 >> 3] >> ((j15 & 7) << 3)) & 255) != 254) {
                    h();
                    j15 = j(i12);
                }
                this.f2407e++;
                int i20 = this.f2375f;
                long[] jArr2 = this.f2403a;
                int i21 = j15 >> 3;
                long j16 = jArr2[i21];
                int i22 = (j15 & 7) << 3;
                this.f2375f = i20 - (((j16 >> i22) & 255) == 128 ? 1 : 0);
                int i23 = this.f2406d;
                long j17 = ((~(255 << i22)) & j16) | (j12 << i22);
                jArr2[i21] = j17;
                jArr2[(((j15 - 7) & i23) + (i23 & 7)) >> 3] = j17;
                return ~j15;
            }
            i16 += 8;
            i15 = (i15 + i16) & i14;
            i13 = i19;
        }
    }

    private final void l() {
        this.f2375f = v0.c(d()) - this.f2407e;
    }

    private final void m(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = v0.f2428a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f2403a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        l();
    }

    private final void n(int i11) {
        int max = i11 > 0 ? Math.max(7, v0.f(i11)) : 0;
        this.f2406d = max;
        m(max);
        this.f2404b = new Object[max];
        this.f2405c = new long[max];
    }

    private final void o(int i11) {
        int i12;
        long[] jArr = this.f2403a;
        Object[] objArr = this.f2404b;
        long[] jArr2 = this.f2405c;
        int i13 = this.f2406d;
        n(i11);
        long[] jArr3 = this.f2403a;
        Object[] objArr2 = this.f2404b;
        long[] jArr4 = this.f2405c;
        int i14 = this.f2406d;
        int i15 = 0;
        while (i15 < i13) {
            if (((jArr[i15 >> 3] >> ((i15 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i15];
                int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i16 = hashCode ^ (hashCode << 16);
                int j11 = j(i16 >>> 7);
                i12 = i15;
                long j12 = i16 & 127;
                int i17 = j11 >> 3;
                int i18 = (j11 & 7) << 3;
                long j13 = (j12 << i18) | (jArr3[i17] & (~(255 << i18)));
                jArr3[i17] = j13;
                jArr3[(((j11 - 7) & i14) + (i14 & 7)) >> 3] = j13;
                objArr2[j11] = obj;
                jArr4[j11] = jArr2[i12];
            } else {
                i12 = i15;
            }
            i15 = i12 + 1;
        }
    }

    public final void p(Object obj, long j11) {
        int k11 = k(obj);
        if (k11 < 0) {
            k11 = ~k11;
        }
        this.f2404b[k11] = obj;
        this.f2405c[k11] = j11;
    }
}
