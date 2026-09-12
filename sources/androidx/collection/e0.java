package androidx.collection;

import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class e0 extends o {

    /* renamed from: f, reason: collision with root package name */
    private int f2347f;

    public e0() {
        this(0, 1, null);
    }

    public e0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        o(v0.g(i11));
    }

    public /* synthetic */ e0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    private final void h() {
        int compare;
        if (this.f2381d > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f2382e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f2381d) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                j();
                return;
            }
        }
        s(v0.e(this.f2381d));
    }

    private final void j() {
        int[] iArr;
        int i11;
        int i12;
        long[] jArr = this.f2378a;
        int i13 = this.f2381d;
        int[] iArr2 = this.f2379b;
        Object[] objArr = this.f2380c;
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
                    int l11 = l(i19);
                    int i20 = i19 & i13;
                    if (((l11 - i20) & i13) / 8 == ((i14 - i20) & i13) / 8) {
                        jArr[i16] = ((r10 & 127) << i17) | ((~(255 << i17)) & jArr[i16]);
                        jArr[ArraysKt.a0(jArr)] = (jArr[c11] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i21 = l11 >> 3;
                        long j12 = jArr[i21];
                        int i22 = (l11 & 7) << 3;
                        if (((j12 >> i22) & 255) == 128) {
                            int i23 = i14;
                            iArr = iArr2;
                            jArr[i21] = (j12 & (~(255 << i22))) | ((r10 & 127) << i22);
                            jArr[i16] = (jArr[i16] & (~(255 << i17))) | (128 << i17);
                            iArr[l11] = iArr[i23];
                            iArr[i23] = 0;
                            objArr[l11] = objArr[i23];
                            objArr[i23] = null;
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
                            iArr[i15] = iArr[l11];
                            iArr[l11] = iArr[i25];
                            iArr[i25] = iArr[i15];
                            objArr[i15] = objArr[l11];
                            objArr[l11] = objArr[i25];
                            objArr[i25] = objArr[i15];
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
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 >>> 7;
        int i15 = i13 & 127;
        int i16 = this.f2381d;
        int i17 = i14 & i16;
        int i18 = 0;
        while (true) {
            long[] jArr = this.f2378a;
            int i19 = i17 >> 3;
            int i20 = (i17 & 7) << 3;
            long j11 = ((jArr[i19 + 1] << (64 - i20)) & ((-i20) >> 63)) | (jArr[i19] >>> i20);
            long j12 = i15;
            int i21 = i18;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int numberOfTrailingZeros = (i17 + (Long.numberOfTrailingZeros(j14) >> 3)) & i16;
                if (this.f2379b[numberOfTrailingZeros] == i11) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int l11 = l(i14);
                if (this.f2347f == 0 && ((this.f2378a[l11 >> 3] >> ((l11 & 7) << 3)) & 255) != 254) {
                    h();
                    l11 = l(i14);
                }
                this.f2382e++;
                int i22 = this.f2347f;
                long[] jArr2 = this.f2378a;
                int i23 = l11 >> 3;
                long j15 = jArr2[i23];
                int i24 = (l11 & 7) << 3;
                this.f2347f = i22 - (((j15 >> i24) & 255) == 128 ? 1 : 0);
                int i25 = this.f2381d;
                long j16 = ((~(255 << i24)) & j15) | (j12 << i24);
                jArr2[i23] = j16;
                jArr2[(((l11 - 7) & i25) + (i25 & 7)) >> 3] = j16;
                return l11;
            }
            i18 = i21 + 8;
            i17 = (i17 + i18) & i16;
        }
    }

    private final int l(int i11) {
        int i12 = this.f2381d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f2378a;
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

    private final void m() {
        this.f2347f = v0.c(d()) - this.f2382e;
    }

    private final void n(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = v0.f2428a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f2378a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        m();
    }

    private final void o(int i11) {
        int max = i11 > 0 ? Math.max(7, v0.f(i11)) : 0;
        this.f2381d = max;
        n(max);
        this.f2379b = new int[max];
        this.f2380c = new Object[max];
    }

    private final void s(int i11) {
        long[] jArr;
        e0 e0Var = this;
        long[] jArr2 = e0Var.f2378a;
        int[] iArr = e0Var.f2379b;
        Object[] objArr = e0Var.f2380c;
        int i12 = e0Var.f2381d;
        o(i11);
        long[] jArr3 = e0Var.f2378a;
        int[] iArr2 = e0Var.f2379b;
        Object[] objArr2 = e0Var.f2380c;
        int i13 = e0Var.f2381d;
        int i14 = 0;
        while (i14 < i12) {
            if (((jArr2[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                int i15 = iArr[i14];
                int i16 = (-862048943) * i15;
                int i17 = i16 ^ (i16 << 16);
                int l11 = e0Var.l(i17 >>> 7);
                long j11 = i17 & 127;
                int i18 = l11 >> 3;
                int i19 = (l11 & 7) << 3;
                jArr = jArr2;
                long j12 = (jArr3[i18] & (~(255 << i19))) | (j11 << i19);
                jArr3[i18] = j12;
                jArr3[(((l11 - 7) & i13) + (i13 & 7)) >> 3] = j12;
                iArr2[l11] = i15;
                objArr2[l11] = objArr[i14];
            } else {
                jArr = jArr2;
            }
            i14++;
            e0Var = this;
            jArr2 = jArr;
        }
    }

    public final void i() {
        this.f2382e = 0;
        long[] jArr = this.f2378a;
        if (jArr != v0.f2428a) {
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f2378a;
            int i11 = this.f2381d;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        ArraysKt.w(this.f2380c, null, 0, this.f2381d);
        m();
    }

    public final Object p(int i11, Object obj) {
        int k11 = k(i11);
        Object[] objArr = this.f2380c;
        Object obj2 = objArr[k11];
        this.f2379b[k11] = i11;
        objArr[k11] = obj;
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(int r14) {
        /*
            r13 = this;
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r0 = r0 * r14
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13.f2381d
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        Lf:
            long[] r4 = r13.f2378a
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
            int[] r11 = r13.f2379b
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
            if (r4 == 0) goto L69
            r10 = -1
        L60:
            if (r10 < 0) goto L67
            java.lang.Object r14 = r13.r(r10)
            return r14
        L67:
            r14 = 0
            return r14
        L69:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.e0.q(int):java.lang.Object");
    }

    public final Object r(int i11) {
        this.f2382e--;
        long[] jArr = this.f2378a;
        int i12 = this.f2381d;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
        Object[] objArr = this.f2380c;
        Object obj = objArr[i11];
        objArr[i11] = null;
        return obj;
    }

    public final void t(int i11, Object obj) {
        int k11 = k(i11);
        this.f2379b[k11] = i11;
        this.f2380c[k11] = obj;
    }
}
