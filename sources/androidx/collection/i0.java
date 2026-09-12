package androidx.collection;

import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class i0 extends v {

    /* renamed from: e, reason: collision with root package name */
    private int f2360e;

    public i0() {
        this(0, 1, null);
    }

    public i0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        k(v0.g(i11));
    }

    public /* synthetic */ i0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    private final void e() {
        int compare;
        if (this.f2426c > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f2427d) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f2426c) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                f();
                return;
            }
        }
        o(v0.e(this.f2426c));
    }

    private final void f() {
        int i11;
        long[] jArr = this.f2424a;
        int i12 = this.f2426c;
        long[] jArr2 = this.f2425b;
        v0.a(jArr, i12);
        char c11 = 0;
        int i13 = 0;
        int i14 = -1;
        while (i13 != i12) {
            int i15 = i13 >> 3;
            int i16 = (i13 & 7) << 3;
            long j11 = (jArr[i15] >> i16) & 255;
            if (j11 == 128) {
                i14 = i13;
                i13++;
            } else {
                if (j11 == 254) {
                    int a11 = s.a(jArr2[i13]) * (-862048943);
                    int i17 = (a11 ^ (a11 << 16)) >>> 7;
                    int h11 = h(i17);
                    int i18 = i17 & i12;
                    if (((h11 - i18) & i12) / 8 == ((i13 - i18) & i12) / 8) {
                        jArr[i15] = ((r9 & 127) << i16) | ((~(255 << i16)) & jArr[i15]);
                        jArr[ArraysKt.a0(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i19 = h11 >> 3;
                        long j12 = jArr[i19];
                        int i20 = (h11 & 7) << 3;
                        if (((j12 >> i20) & 255) == 128) {
                            int i21 = i13;
                            jArr[i19] = ((r9 & 127) << i20) | (j12 & (~(255 << i20)));
                            jArr[i15] = (jArr[i15] & (~(255 << i16))) | (128 << i16);
                            jArr2[h11] = jArr2[i21];
                            jArr2[i21] = 0;
                            i11 = i21;
                            i14 = i11;
                        } else {
                            int i22 = i13;
                            jArr[i19] = ((r9 & 127) << i20) | (j12 & (~(255 << i20)));
                            if (i14 == -1) {
                                i14 = v0.b(jArr, i22 + 1, i12);
                            }
                            jArr2[i14] = jArr2[h11];
                            jArr2[h11] = jArr2[i22];
                            jArr2[i22] = jArr2[i14];
                            i11 = i22 - 1;
                        }
                        jArr[ArraysKt.a0(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i13 = i11 + 1;
                        c11 = 0;
                    }
                }
                i13++;
            }
        }
        i();
    }

    private final int g(long j11) {
        int a11 = s.a(j11) * (-862048943);
        int i11 = a11 ^ (a11 << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f2426c;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f2424a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j12 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j13 = i13;
            int i19 = i16;
            long j14 = j12 ^ (j13 * 72340172838076673L);
            for (long j15 = (~j14) & (j14 - 72340172838076673L) & (-9187201950435737472L); j15 != 0; j15 &= j15 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j15) >> 3) + i15) & i14;
                if (this.f2425b[numberOfTrailingZeros] == j11) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j12) << 6) & j12 & (-9187201950435737472L)) != 0) {
                int h11 = h(i12);
                if (this.f2360e == 0 && ((this.f2424a[h11 >> 3] >> ((h11 & 7) << 3)) & 255) != 254) {
                    e();
                    h11 = h(i12);
                }
                this.f2427d++;
                int i20 = this.f2360e;
                long[] jArr2 = this.f2424a;
                int i21 = h11 >> 3;
                long j16 = jArr2[i21];
                int i22 = (h11 & 7) << 3;
                this.f2360e = i20 - (((j16 >> i22) & 255) == 128 ? 1 : 0);
                int i23 = this.f2426c;
                long j17 = ((~(255 << i22)) & j16) | (j13 << i22);
                jArr2[i21] = j17;
                jArr2[(((h11 - 7) & i23) + (i23 & 7)) >> 3] = j17;
                return h11;
            }
            i16 = i19 + 8;
            i15 = (i15 + i16) & i14;
        }
    }

    private final int h(int i11) {
        int i12 = this.f2426c;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f2424a;
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

    private final void i() {
        this.f2360e = v0.c(b()) - this.f2427d;
    }

    private final void j(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = v0.f2428a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f2424a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        i();
    }

    private final void k(int i11) {
        int max = i11 > 0 ? Math.max(7, v0.f(i11)) : 0;
        this.f2426c = max;
        j(max);
        this.f2425b = new long[max];
    }

    private final void n(int i11) {
        this.f2427d--;
        long[] jArr = this.f2424a;
        int i12 = this.f2426c;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
    }

    private final void o(int i11) {
        long[] jArr = this.f2424a;
        long[] jArr2 = this.f2425b;
        int i12 = this.f2426c;
        k(i11);
        long[] jArr3 = this.f2424a;
        long[] jArr4 = this.f2425b;
        int i13 = this.f2426c;
        for (int i14 = 0; i14 < i12; i14++) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                long j11 = jArr2[i14];
                int a11 = s.a(j11) * (-862048943);
                int i15 = a11 ^ (a11 << 16);
                int h11 = h(i15 >>> 7);
                long j12 = i15 & 127;
                int i16 = h11 >> 3;
                int i17 = (h11 & 7) << 3;
                long j13 = (jArr3[i16] & (~(255 << i17))) | (j12 << i17);
                jArr3[i16] = j13;
                jArr3[(((h11 - 7) & i13) + (i13 & 7)) >> 3] = j13;
                jArr4[h11] = j11;
            }
        }
    }

    public final void l(long j11) {
        this.f2425b[g(j11)] = j11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(long r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = androidx.collection.s.a(r18)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0.f2426c
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L16:
            long[] r6 = r0.f2424a
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r12 = r6[r7]
            int r6 = 64 - r8
            long r6 = r12 << r6
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L42:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L5f
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            long[] r14 = r0.f2425b
            r15 = r14[r10]
            int r14 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r14 != 0) goto L59
            goto L69
        L59:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L42
        L5f:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L72
            r10 = -1
        L69:
            if (r10 < 0) goto L6c
            r4 = r11
        L6c:
            if (r4 == 0) goto L71
            r0.n(r10)
        L71:
            return r4
        L72:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.i0.m(long):boolean");
    }
}
