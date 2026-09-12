package androidx.collection;

import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class f0 extends q {

    /* renamed from: e, reason: collision with root package name */
    private int f2352e;

    public f0() {
        this(0, 1, null);
    }

    public f0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        n(v0.g(i11));
    }

    public /* synthetic */ f0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    private final void g() {
        int compare;
        if (this.f2396c > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f2397d) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f2396c) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                i();
                return;
            }
        }
        t(v0.e(this.f2396c));
    }

    private final void i() {
        int i11;
        long[] jArr = this.f2394a;
        int i12 = this.f2396c;
        int[] iArr = this.f2395b;
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
                    int i17 = iArr[i13] * (-862048943);
                    int i18 = (i17 ^ (i17 << 16)) >>> 7;
                    int k11 = k(i18);
                    int i19 = i18 & i12;
                    if (((k11 - i19) & i12) / 8 == ((i13 - i19) & i12) / 8) {
                        jArr[i15] = ((r9 & 127) << i16) | ((~(255 << i16)) & jArr[i15]);
                        jArr[ArraysKt.a0(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i20 = k11 >> 3;
                        long j12 = jArr[i20];
                        int i21 = (k11 & 7) << 3;
                        if (((j12 >> i21) & 255) == 128) {
                            int i22 = i13;
                            jArr[i20] = ((r9 & 127) << i21) | (j12 & (~(255 << i21)));
                            jArr[i15] = (jArr[i15] & (~(255 << i16))) | (128 << i16);
                            iArr[k11] = iArr[i22];
                            iArr[i22] = 0;
                            i11 = i22;
                            i14 = i11;
                        } else {
                            int i23 = i13;
                            jArr[i20] = ((r9 & 127) << i21) | (j12 & (~(255 << i21)));
                            if (i14 == -1) {
                                i14 = v0.b(jArr, i23 + 1, i12);
                            }
                            iArr[i14] = iArr[k11];
                            iArr[k11] = iArr[i23];
                            iArr[i23] = iArr[i14];
                            i11 = i23 - 1;
                        }
                        jArr[ArraysKt.a0(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i13 = i11 + 1;
                        c11 = 0;
                    }
                }
                i13++;
            }
        }
        l();
    }

    private final int j(int i11) {
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 >>> 7;
        int i15 = i13 & 127;
        int i16 = this.f2396c;
        int i17 = i14 & i16;
        int i18 = 0;
        while (true) {
            long[] jArr = this.f2394a;
            int i19 = i17 >> 3;
            int i20 = (i17 & 7) << 3;
            long j11 = ((jArr[i19 + 1] << (64 - i20)) & ((-i20) >> 63)) | (jArr[i19] >>> i20);
            long j12 = i15;
            int i21 = i18;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int numberOfTrailingZeros = (i17 + (Long.numberOfTrailingZeros(j14) >> 3)) & i16;
                if (this.f2395b[numberOfTrailingZeros] == i11) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int k11 = k(i14);
                if (this.f2352e == 0 && ((this.f2394a[k11 >> 3] >> ((k11 & 7) << 3)) & 255) != 254) {
                    g();
                    k11 = k(i14);
                }
                this.f2397d++;
                int i22 = this.f2352e;
                long[] jArr2 = this.f2394a;
                int i23 = k11 >> 3;
                long j15 = jArr2[i23];
                int i24 = (k11 & 7) << 3;
                this.f2352e = i22 - (((j15 >> i24) & 255) == 128 ? 1 : 0);
                int i25 = this.f2396c;
                long j16 = ((~(255 << i24)) & j15) | (j12 << i24);
                jArr2[i23] = j16;
                jArr2[(((k11 - 7) & i25) + (i25 & 7)) >> 3] = j16;
                return k11;
            }
            i18 = i21 + 8;
            i17 = (i17 + i18) & i16;
        }
    }

    private final int k(int i11) {
        int i12 = this.f2396c;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f2394a;
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

    private final void l() {
        this.f2352e = v0.c(b()) - this.f2397d;
    }

    private final void m(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = v0.f2428a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f2394a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        l();
    }

    private final void n(int i11) {
        int max = i11 > 0 ? Math.max(7, v0.f(i11)) : 0;
        this.f2396c = max;
        m(max);
        this.f2395b = new int[max];
    }

    private final void s(int i11) {
        this.f2397d--;
        long[] jArr = this.f2394a;
        int i12 = this.f2396c;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
    }

    private final void t(int i11) {
        long[] jArr = this.f2394a;
        int[] iArr = this.f2395b;
        int i12 = this.f2396c;
        n(i11);
        long[] jArr2 = this.f2394a;
        int[] iArr2 = this.f2395b;
        int i13 = this.f2396c;
        for (int i14 = 0; i14 < i12; i14++) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                int i15 = iArr[i14];
                int i16 = (-862048943) * i15;
                int i17 = i16 ^ (i16 << 16);
                int k11 = k(i17 >>> 7);
                long j11 = i17 & 127;
                int i18 = k11 >> 3;
                int i19 = (k11 & 7) << 3;
                long j12 = (jArr2[i18] & (~(255 << i19))) | (j11 << i19);
                jArr2[i18] = j12;
                jArr2[(((k11 - 7) & i13) + (i13 & 7)) >> 3] = j12;
                iArr2[k11] = i15;
            }
        }
    }

    public final boolean f(int i11) {
        int i12 = this.f2397d;
        this.f2395b[j(i11)] = i11;
        return this.f2397d != i12;
    }

    public final void h() {
        this.f2397d = 0;
        long[] jArr = this.f2394a;
        if (jArr != v0.f2428a) {
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f2394a;
            int i11 = this.f2396c;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(int r14) {
        /*
            r13 = this;
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r0 = r0 * r14
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13.f2396c
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        Lf:
            long[] r4 = r13.f2394a
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3b:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L56
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.f2395b
            r11 = r11[r10]
            if (r11 != r14) goto L50
            goto L60
        L50:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3b
        L56:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L66
            r10 = -1
        L60:
            if (r10 < 0) goto L65
            r13.s(r10)
        L65:
            return
        L66:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.f0.o(int):void");
    }

    public final void p(q elements) {
        Intrinsics.h(elements, "elements");
        int[] iArr = elements.f2395b;
        long[] jArr = elements.f2394a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        o(iArr[(i11 << 3) + i13]);
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r1
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0.f2396c
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = r5
        L14:
            long[] r7 = r0.f2394a
            int r8 = r2 >> 3
            r9 = r2 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L40:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L5b
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            int[] r15 = r0.f2395b
            r15 = r15[r11]
            if (r15 != r1) goto L55
            goto L65
        L55:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L40
        L5b:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L6e
            r11 = -1
        L65:
            if (r11 < 0) goto L68
            r5 = r12
        L68:
            if (r5 == 0) goto L6d
            r0.s(r11)
        L6d:
            return r5
        L6e:
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.f0.q(int):boolean");
    }

    public final boolean r(q elements) {
        Intrinsics.h(elements, "elements");
        int i11 = this.f2397d;
        p(elements);
        return i11 != this.f2397d;
    }
}
