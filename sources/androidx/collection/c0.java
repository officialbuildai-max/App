package androidx.collection;

import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class c0 extends l {

    /* renamed from: f, reason: collision with root package name */
    private int f2342f;

    public c0() {
        this(0, 1, null);
    }

    public c0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        o(v0.g(i11));
    }

    public /* synthetic */ c0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    private final void h() {
        int compare;
        if (this.f2371d > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f2372e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f2371d) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                j();
                return;
            }
        }
        p(v0.e(this.f2371d));
    }

    private final void j() {
        int[] iArr;
        int i11;
        int i12;
        long[] jArr = this.f2368a;
        int i13 = this.f2371d;
        int[] iArr2 = this.f2369b;
        int[] iArr3 = this.f2370c;
        v0.a(jArr, i13);
        char c11 = 0;
        int i14 = 0;
        int i15 = -1;
        while (i14 != i13) {
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j11 = (jArr[i16] >> i17) & 255;
            if (j11 == 128) {
                i15 = i14;
                i14++;
            } else {
                if (j11 == 254) {
                    int i18 = iArr2[i14] * (-862048943);
                    int i19 = (i18 ^ (i18 << 16)) >>> 7;
                    int k11 = k(i19);
                    int i20 = i19 & i13;
                    if (((k11 - i20) & i13) / 8 == ((i14 - i20) & i13) / 8) {
                        jArr[i16] = ((r10 & 127) << i17) | ((~(255 << i17)) & jArr[i16]);
                        jArr[ArraysKt.a0(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i21 = k11 >> 3;
                        long j12 = jArr[i21];
                        int i22 = (k11 & 7) << 3;
                        if (((j12 >> i22) & 255) == 128) {
                            int i23 = i14;
                            iArr = iArr2;
                            jArr[i21] = (j12 & (~(255 << i22))) | ((r10 & 127) << i22);
                            jArr[i16] = (jArr[i16] & (~(255 << i17))) | (128 << i17);
                            iArr[k11] = iArr[i23];
                            iArr[i23] = 0;
                            iArr3[k11] = iArr3[i23];
                            iArr3[i23] = 0;
                            i12 = i23;
                            i15 = i12;
                            i11 = i13;
                        } else {
                            int i24 = i13;
                            iArr = iArr2;
                            int i25 = i14;
                            jArr[i21] = ((r10 & 127) << i22) | (j12 & (~(255 << i22)));
                            if (i15 == -1) {
                                i11 = i24;
                                i15 = v0.b(jArr, i25 + 1, i11);
                            } else {
                                i11 = i24;
                            }
                            iArr[i15] = iArr[k11];
                            iArr[k11] = iArr[i25];
                            iArr[i25] = iArr[i15];
                            iArr3[i15] = iArr3[k11];
                            iArr3[k11] = iArr3[i25];
                            iArr3[i25] = iArr3[i15];
                            i12 = i25 - 1;
                        }
                        c11 = 0;
                        jArr[ArraysKt.a0(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i14 = i12 + 1;
                        i13 = i11;
                        iArr2 = iArr;
                    }
                }
                i14++;
            }
        }
        m();
    }

    private final int k(int i11) {
        int i12 = this.f2371d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f2368a;
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

    private final int l(int i11) {
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 >>> 7;
        int i15 = i13 & 127;
        int i16 = this.f2371d;
        int i17 = i14 & i16;
        int i18 = 0;
        while (true) {
            long[] jArr = this.f2368a;
            int i19 = i17 >> 3;
            int i20 = (i17 & 7) << 3;
            long j11 = ((jArr[i19 + 1] << (64 - i20)) & ((-i20) >> 63)) | (jArr[i19] >>> i20);
            long j12 = i15;
            int i21 = i18;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int numberOfTrailingZeros = (i17 + (Long.numberOfTrailingZeros(j14) >> 3)) & i16;
                if (this.f2369b[numberOfTrailingZeros] == i11) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int k11 = k(i14);
                if (this.f2342f == 0 && ((this.f2368a[k11 >> 3] >> ((k11 & 7) << 3)) & 255) != 254) {
                    h();
                    k11 = k(i14);
                }
                this.f2372e++;
                int i22 = this.f2342f;
                long[] jArr2 = this.f2368a;
                int i23 = k11 >> 3;
                long j15 = jArr2[i23];
                int i24 = (k11 & 7) << 3;
                this.f2342f = i22 - (((j15 >> i24) & 255) == 128 ? 1 : 0);
                int i25 = this.f2371d;
                long j16 = ((~(255 << i24)) & j15) | (j12 << i24);
                jArr2[i23] = j16;
                jArr2[(((k11 - 7) & i25) + (i25 & 7)) >> 3] = j16;
                return ~k11;
            }
            i18 = i21 + 8;
            i17 = (i17 + i18) & i16;
        }
    }

    private final void m() {
        this.f2342f = v0.c(d()) - this.f2372e;
    }

    private final void n(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = v0.f2428a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f2368a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        m();
    }

    private final void o(int i11) {
        int max = i11 > 0 ? Math.max(7, v0.f(i11)) : 0;
        this.f2371d = max;
        n(max);
        this.f2369b = new int[max];
        this.f2370c = new int[max];
    }

    private final void p(int i11) {
        long[] jArr;
        c0 c0Var = this;
        long[] jArr2 = c0Var.f2368a;
        int[] iArr = c0Var.f2369b;
        int[] iArr2 = c0Var.f2370c;
        int i12 = c0Var.f2371d;
        o(i11);
        long[] jArr3 = c0Var.f2368a;
        int[] iArr3 = c0Var.f2369b;
        int[] iArr4 = c0Var.f2370c;
        int i13 = c0Var.f2371d;
        int i14 = 0;
        while (i14 < i12) {
            if (((jArr2[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                int i15 = iArr[i14];
                int i16 = (-862048943) * i15;
                int i17 = i16 ^ (i16 << 16);
                int k11 = c0Var.k(i17 >>> 7);
                long j11 = i17 & 127;
                int i18 = k11 >> 3;
                int i19 = (k11 & 7) << 3;
                jArr = jArr2;
                long j12 = (jArr3[i18] & (~(255 << i19))) | (j11 << i19);
                jArr3[i18] = j12;
                jArr3[(((k11 - 7) & i13) + (i13 & 7)) >> 3] = j12;
                iArr3[k11] = i15;
                iArr4[k11] = iArr2[i14];
            } else {
                jArr = jArr2;
            }
            i14++;
            c0Var = this;
            jArr2 = jArr;
        }
    }

    public final void i() {
        this.f2372e = 0;
        long[] jArr = this.f2368a;
        if (jArr != v0.f2428a) {
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f2368a;
            int i11 = this.f2371d;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        m();
    }

    public final void q(int i11, int i12) {
        int l11 = l(i11);
        if (l11 < 0) {
            l11 = ~l11;
        }
        this.f2369b[l11] = i11;
        this.f2370c[l11] = i12;
    }
}
