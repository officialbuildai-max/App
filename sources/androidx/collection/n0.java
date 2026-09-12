package androidx.collection;

import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class n0 extends u0 {

    /* renamed from: f, reason: collision with root package name */
    private int f2377f;

    public n0() {
        this(0, 1, null);
    }

    public n0(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        n(v0.g(i11));
    }

    public /* synthetic */ n0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    private final void g() {
        int compare;
        if (this.f2422d > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f2423e) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f2422d) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                i();
                return;
            }
        }
        q(v0.e(this.f2422d));
    }

    private final void i() {
        Object[] objArr;
        int i11;
        int i12;
        long[] jArr = this.f2419a;
        int i13 = this.f2422d;
        Object[] objArr2 = this.f2420b;
        Object[] objArr3 = this.f2421c;
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
                        jArr[ArraysKt.a0(jArr)] = jArr[i14];
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
                            objArr3[j12] = objArr3[i23];
                            objArr3[i23] = null;
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
                            objArr3[i16] = objArr3[j12];
                            objArr3[j12] = objArr3[i25];
                            objArr3[i25] = objArr3[i16];
                            i12 = i25 - 1;
                        }
                        i14 = 0;
                        jArr[ArraysKt.a0(jArr)] = jArr[0];
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
        int i12 = this.f2422d;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f2419a;
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
        this.f2377f = v0.c(c()) - this.f2423e;
    }

    private final void m(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = v0.f2428a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f2419a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        l();
    }

    private final void n(int i11) {
        int max = i11 > 0 ? Math.max(7, v0.f(i11)) : 0;
        this.f2422d = max;
        m(max);
        this.f2420b = new Object[max];
        this.f2421c = new Object[max];
    }

    private final void q(int i11) {
        int i12;
        long[] jArr = this.f2419a;
        Object[] objArr = this.f2420b;
        Object[] objArr2 = this.f2421c;
        int i13 = this.f2422d;
        n(i11);
        long[] jArr2 = this.f2419a;
        Object[] objArr3 = this.f2420b;
        Object[] objArr4 = this.f2421c;
        int i14 = this.f2422d;
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
                long j13 = (j12 << i18) | (jArr2[i17] & (~(255 << i18)));
                jArr2[i17] = j13;
                jArr2[(((j11 - 7) & i14) + (i14 & 7)) >> 3] = j13;
                objArr3[j11] = obj;
                objArr4[j11] = objArr2[i12];
            } else {
                i12 = i15;
            }
            i15 = i12 + 1;
        }
    }

    public final void h() {
        this.f2423e = 0;
        long[] jArr = this.f2419a;
        if (jArr != v0.f2428a) {
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f2419a;
            int i11 = this.f2422d;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        ArraysKt.w(this.f2421c, null, 0, this.f2422d);
        ArraysKt.w(this.f2420b, null, 0, this.f2422d);
        l();
    }

    public final int k(Object obj) {
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i11 = hashCode ^ (hashCode << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f2422d;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f2419a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = i13;
            int i19 = i13;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int numberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j14) >> 3)) & i14;
                if (Intrinsics.c(this.f2420b[numberOfTrailingZeros], obj)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int j15 = j(i12);
                if (this.f2377f == 0 && ((this.f2419a[j15 >> 3] >> ((j15 & 7) << 3)) & 255) != 254) {
                    g();
                    j15 = j(i12);
                }
                this.f2423e++;
                int i20 = this.f2377f;
                long[] jArr2 = this.f2419a;
                int i21 = j15 >> 3;
                long j16 = jArr2[i21];
                int i22 = (j15 & 7) << 3;
                this.f2377f = i20 - (((j16 >> i22) & 255) == 128 ? 1 : 0);
                int i23 = this.f2422d;
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = r0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13.f2422d
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.f2419a
            int r5 = r1 >> 3
            r6 = r1 & 7
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
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L43:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L62
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.f2420b
            r11 = r11[r10]
            boolean r11 = kotlin.jvm.internal.Intrinsics.c(r11, r14)
            if (r11 == 0) goto L5c
            goto L6c
        L5c:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L43
        L62:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L75
            r10 = -1
        L6c:
            if (r10 < 0) goto L73
            java.lang.Object r14 = r13.p(r10)
            return r14
        L73:
            r14 = 0
            return r14
        L75:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.n0.o(java.lang.Object):java.lang.Object");
    }

    public final Object p(int i11) {
        this.f2423e--;
        long[] jArr = this.f2419a;
        int i12 = this.f2422d;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
        this.f2420b[i11] = null;
        Object[] objArr = this.f2421c;
        Object obj = objArr[i11];
        objArr[i11] = null;
        return obj;
    }

    public final void r(Object obj, Object obj2) {
        int k11 = k(obj);
        if (k11 < 0) {
            k11 = ~k11;
        }
        this.f2420b[k11] = obj;
        this.f2421c[k11] = obj2;
    }
}
