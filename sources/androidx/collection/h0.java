package androidx.collection;

import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class h0 extends u {

    /* renamed from: f, reason: collision with root package name */
    private int f2355f;

    public h0() {
        this(0, 1, null);
    }

    public h0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        m(v0.g(i11));
    }

    public /* synthetic */ h0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    private final void f() {
        int compare;
        if (this.f2417d > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f2418e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f2417d) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                h();
                return;
            }
        }
        n(v0.e(this.f2417d));
    }

    private final void h() {
        long[] jArr;
        int i11;
        int i12;
        long[] jArr2 = this.f2414a;
        int i13 = this.f2417d;
        long[] jArr3 = this.f2415b;
        Object[] objArr = this.f2416c;
        v0.a(jArr2, i13);
        char c11 = 0;
        int i14 = 0;
        int i15 = -1;
        while (i14 != i13) {
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j11 = (jArr2[i16] >> i17) & 255;
            if (j11 == 128) {
                i15 = i14;
                i14++;
            } else {
                if (j11 == 254) {
                    int a11 = s.a(jArr3[i14]) * (-862048943);
                    int i18 = (a11 ^ (a11 << 16)) >>> 7;
                    int j12 = j(i18);
                    int i19 = i18 & i13;
                    if (((j12 - i19) & i13) / 8 == ((i14 - i19) & i13) / 8) {
                        jArr2[i16] = ((r10 & 127) << i17) | ((~(255 << i17)) & jArr2[i16]);
                        jArr2[ArraysKt.a0(jArr2)] = (jArr2[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i20 = j12 >> 3;
                        long j13 = jArr2[i20];
                        int i21 = (j12 & 7) << 3;
                        if (((j13 >> i21) & 255) == 128) {
                            int i22 = i14;
                            jArr = jArr3;
                            jArr2[i20] = (j13 & (~(255 << i21))) | ((r10 & 127) << i21);
                            jArr2[i16] = (jArr2[i16] & (~(255 << i17))) | (128 << i17);
                            jArr[j12] = jArr[i22];
                            jArr[i22] = 0;
                            objArr[j12] = objArr[i22];
                            objArr[i22] = null;
                            i12 = i22;
                            i15 = i12;
                            i11 = i13;
                        } else {
                            int i23 = i13;
                            jArr = jArr3;
                            int i24 = i14;
                            jArr2[i20] = ((r10 & 127) << i21) | (j13 & (~(255 << i21)));
                            if (i15 == -1) {
                                i11 = i23;
                                i15 = v0.b(jArr2, i24 + 1, i11);
                            } else {
                                i11 = i23;
                            }
                            jArr[i15] = jArr[j12];
                            jArr[j12] = jArr[i24];
                            jArr[i24] = jArr[i15];
                            objArr[i15] = objArr[j12];
                            objArr[j12] = objArr[i24];
                            objArr[i24] = objArr[i15];
                            i12 = i24 - 1;
                        }
                        c11 = 0;
                        jArr2[ArraysKt.a0(jArr2)] = (jArr2[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i14 = i12 + 1;
                        i13 = i11;
                        jArr3 = jArr;
                    }
                }
                i14++;
            }
        }
        k();
    }

    private final int i(long j11) {
        int a11 = s.a(j11) * (-862048943);
        int i11 = a11 ^ (a11 << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f2417d;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f2414a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j12 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j13 = i13;
            int i19 = i16;
            long j14 = j12 ^ (j13 * 72340172838076673L);
            for (long j15 = (~j14) & (j14 - 72340172838076673L) & (-9187201950435737472L); j15 != 0; j15 &= j15 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j15) >> 3) + i15) & i14;
                if (this.f2415b[numberOfTrailingZeros] == j11) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j12) << 6) & j12 & (-9187201950435737472L)) != 0) {
                int j16 = j(i12);
                if (this.f2355f == 0 && ((this.f2414a[j16 >> 3] >> ((j16 & 7) << 3)) & 255) != 254) {
                    f();
                    j16 = j(i12);
                }
                this.f2418e++;
                int i20 = this.f2355f;
                long[] jArr2 = this.f2414a;
                int i21 = j16 >> 3;
                long j17 = jArr2[i21];
                int i22 = (j16 & 7) << 3;
                this.f2355f = i20 - (((j17 >> i22) & 255) == 128 ? 1 : 0);
                int i23 = this.f2417d;
                long j18 = ((~(255 << i22)) & j17) | (j13 << i22);
                jArr2[i21] = j18;
                jArr2[(((j16 - 7) & i23) + (i23 & 7)) >> 3] = j18;
                return j16;
            }
            i16 = i19 + 8;
            i15 = (i15 + i16) & i14;
        }
    }

    private final int j(int i11) {
        int i12 = this.f2417d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f2414a;
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

    private final void k() {
        this.f2355f = v0.c(c()) - this.f2418e;
    }

    private final void l(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = v0.f2428a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f2414a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        k();
    }

    private final void m(int i11) {
        int max = i11 > 0 ? Math.max(7, v0.f(i11)) : 0;
        this.f2417d = max;
        l(max);
        this.f2415b = new long[max];
        this.f2416c = new Object[max];
    }

    private final void n(int i11) {
        long[] jArr;
        h0 h0Var = this;
        long[] jArr2 = h0Var.f2414a;
        long[] jArr3 = h0Var.f2415b;
        Object[] objArr = h0Var.f2416c;
        int i12 = h0Var.f2417d;
        m(i11);
        long[] jArr4 = h0Var.f2414a;
        long[] jArr5 = h0Var.f2415b;
        Object[] objArr2 = h0Var.f2416c;
        int i13 = h0Var.f2417d;
        int i14 = 0;
        while (i14 < i12) {
            if (((jArr2[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                long j11 = jArr3[i14];
                int a11 = s.a(j11) * (-862048943);
                int i15 = a11 ^ (a11 << 16);
                int j12 = h0Var.j(i15 >>> 7);
                long j13 = i15 & 127;
                int i16 = j12 >> 3;
                int i17 = (j12 & 7) << 3;
                jArr = jArr2;
                long j14 = (jArr4[i16] & (~(255 << i17))) | (j13 << i17);
                jArr4[i16] = j14;
                jArr4[(((j12 - 7) & i13) + (i13 & 7)) >> 3] = j14;
                jArr5[j12] = j11;
                objArr2[j12] = objArr[i14];
            } else {
                jArr = jArr2;
            }
            i14++;
            h0Var = this;
            jArr2 = jArr;
        }
    }

    public final void g() {
        this.f2418e = 0;
        long[] jArr = this.f2414a;
        if (jArr != v0.f2428a) {
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f2414a;
            int i11 = this.f2417d;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        ArraysKt.w(this.f2416c, null, 0, this.f2417d);
        k();
    }

    public final void o(long j11, Object obj) {
        int i11 = i(j11);
        this.f2415b[i11] = j11;
        this.f2416c[i11] = obj;
    }
}
