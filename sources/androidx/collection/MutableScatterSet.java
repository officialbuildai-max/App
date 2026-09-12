package androidx.collection;

import androidx.collection.ScatterSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* loaded from: classes.dex */
public final class MutableScatterSet extends ScatterSet {

    /* renamed from: e, reason: collision with root package name */
    private int f2314e;

    /* loaded from: classes.dex */
    private final class MutableSetWrapper extends ScatterSet.a implements Set, KMutableSet {
        public MutableSetWrapper() {
            super();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            return MutableScatterSet.this.h(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection elements) {
            Intrinsics.h(elements, "elements");
            return MutableScatterSet.this.j(elements);
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MutableScatterSet.this.m();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet.this);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            return MutableScatterSet.this.x(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection elements) {
            Intrinsics.h(elements, "elements");
            int c11 = MutableScatterSet.this.c();
            Iterator it = elements.iterator();
            while (it.hasNext()) {
                MutableScatterSet.this.t(it.next());
            }
            return c11 != MutableScatterSet.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection elements) {
            Intrinsics.h(elements, "elements");
            MutableScatterSet mutableScatterSet = MutableScatterSet.this;
            long[] jArr = mutableScatterSet.f2321a;
            int length = jArr.length - 2;
            boolean z10 = false;
            if (length >= 0) {
                int i11 = 0;
                boolean z11 = false;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                int i14 = (i11 << 3) + i13;
                                if (!elements.contains(mutableScatterSet.f2322b[i14])) {
                                    mutableScatterSet.y(i14);
                                    z11 = true;
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            return z11;
                        }
                    }
                    if (i11 == length) {
                        z10 = z11;
                        break;
                    }
                    i11++;
                }
            }
            return z10;
        }
    }

    public MutableScatterSet() {
        this(0, 1, null);
    }

    public MutableScatterSet(int i11) {
        super(null);
        if (!(i11 >= 0)) {
            n.d.a("Capacity must be a positive value.");
        }
        s(v0.g(i11));
    }

    public /* synthetic */ MutableScatterSet(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 6 : i11);
    }

    private final int o(Object obj) {
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i11 = hashCode ^ (hashCode << 16);
        int i12 = i11 >>> 7;
        int i13 = i11 & 127;
        int i14 = this.f2323c;
        int i15 = i12 & i14;
        int i16 = 0;
        while (true) {
            long[] jArr = this.f2321a;
            int i17 = i15 >> 3;
            int i18 = (i15 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = i13;
            int i19 = i13;
            long j13 = j11 ^ (j12 * 72340172838076673L);
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int numberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j14) >> 3)) & i14;
                if (Intrinsics.c(this.f2322b[numberOfTrailingZeros], obj)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j11) << 6) & j11 & (-9187201950435737472L)) != 0) {
                int p11 = p(i12);
                if (this.f2314e == 0 && ((this.f2321a[p11 >> 3] >> ((p11 & 7) << 3)) & 255) != 254) {
                    k();
                    p11 = p(i12);
                }
                this.f2324d++;
                int i20 = this.f2314e;
                long[] jArr2 = this.f2321a;
                int i21 = p11 >> 3;
                long j15 = jArr2[i21];
                int i22 = (p11 & 7) << 3;
                this.f2314e = i20 - (((j15 >> i22) & 255) == 128 ? 1 : 0);
                int i23 = this.f2323c;
                long j16 = ((~(255 << i22)) & j15) | (j12 << i22);
                jArr2[i21] = j16;
                jArr2[(((p11 - 7) & i23) + (i23 & 7)) >> 3] = j16;
                return p11;
            }
            i16 += 8;
            i15 = (i15 + i16) & i14;
            i13 = i19;
        }
    }

    private final int p(int i11) {
        int i12 = this.f2323c;
        int i13 = i11 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.f2321a;
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

    private final void q() {
        this.f2314e = v0.c(b()) - this.f2324d;
    }

    private final void r(int i11) {
        long[] jArr;
        if (i11 == 0) {
            jArr = v0.f2428a;
        } else {
            jArr = new long[((i11 + 15) & (-8)) >> 3];
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.f2321a = jArr;
        int i12 = i11 >> 3;
        long j11 = 255 << ((i11 & 7) << 3);
        jArr[i12] = (jArr[i12] & (~j11)) | j11;
        q();
    }

    private final void s(int i11) {
        int max = i11 > 0 ? Math.max(7, v0.f(i11)) : 0;
        this.f2323c = max;
        r(max);
        this.f2322b = new Object[max];
    }

    public final boolean h(Object obj) {
        int c11 = c();
        this.f2322b[o(obj)] = obj;
        return c() != c11;
    }

    public final boolean i(ScatterSet elements) {
        Intrinsics.h(elements, "elements");
        int c11 = c();
        u(elements);
        return c11 != c();
    }

    public final boolean j(Iterable elements) {
        Intrinsics.h(elements, "elements");
        int c11 = c();
        v(elements);
        return c11 != c();
    }

    public final void k() {
        int compare;
        if (this.f2323c > 8) {
            compare = Long.compare(ULong.b(ULong.b(this.f2324d) * 32) ^ Long.MIN_VALUE, ULong.b(ULong.b(this.f2323c) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                n();
                return;
            }
        }
        z(v0.e(this.f2323c));
    }

    public final Set l() {
        return new MutableSetWrapper();
    }

    public final void m() {
        this.f2324d = 0;
        long[] jArr = this.f2321a;
        if (jArr != v0.f2428a) {
            ArraysKt.z(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.f2321a;
            int i11 = this.f2323c;
            int i12 = i11 >> 3;
            long j11 = 255 << ((i11 & 7) << 3);
            jArr2[i12] = (jArr2[i12] & (~j11)) | j11;
        }
        ArraysKt.w(this.f2322b, null, 0, this.f2323c);
        q();
    }

    public final void n() {
        int i11;
        long[] jArr = this.f2321a;
        int i12 = this.f2323c;
        Object[] objArr = this.f2322b;
        v0.a(jArr, i12);
        int i13 = 0;
        int i14 = 0;
        int i15 = -1;
        while (i14 != i12) {
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j11 = (jArr[i16] >> i17) & 255;
            if (j11 == 128) {
                i15 = i14;
                i14++;
            } else {
                if (j11 == 254) {
                    Object obj = objArr[i14];
                    int hashCode = (obj != null ? obj.hashCode() : i13) * (-862048943);
                    int i18 = (hashCode ^ (hashCode << 16)) >>> 7;
                    int p11 = p(i18);
                    int i19 = i18 & i12;
                    if (((p11 - i19) & i12) / 8 == ((i14 - i19) & i12) / 8) {
                        jArr[i16] = ((r9 & 127) << i17) | ((~(255 << i17)) & jArr[i16]);
                        jArr[ArraysKt.a0(jArr)] = (jArr[i13] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i20 = p11 >> 3;
                        long j12 = jArr[i20];
                        int i21 = (p11 & 7) << 3;
                        if (((j12 >> i21) & 255) == 128) {
                            int i22 = i14;
                            jArr[i20] = ((r9 & 127) << i21) | (j12 & (~(255 << i21)));
                            jArr[i16] = (jArr[i16] & (~(255 << i17))) | (128 << i17);
                            objArr[p11] = objArr[i22];
                            objArr[i22] = null;
                            i11 = i22;
                            i15 = i11;
                        } else {
                            int i23 = i14;
                            jArr[i20] = ((r9 & 127) << i21) | (j12 & (~(255 << i21)));
                            if (i15 == -1) {
                                i15 = v0.b(jArr, i23 + 1, i12);
                            }
                            objArr[i15] = objArr[p11];
                            objArr[p11] = objArr[i23];
                            objArr[i23] = objArr[i15];
                            i11 = i23 - 1;
                        }
                        jArr[ArraysKt.a0(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i14 = i11 + 1;
                        i13 = 0;
                    }
                }
                i14++;
            }
        }
        q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(java.lang.Object r14) {
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
            int r3 = r13.f2323c
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.f2321a
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
            java.lang.Object[] r11 = r13.f2322b
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
            if (r4 == 0) goto L72
            r10 = -1
        L6c:
            if (r10 < 0) goto L71
            r13.y(r10)
        L71:
            return
        L72:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.t(java.lang.Object):void");
    }

    public final void u(ScatterSet elements) {
        Intrinsics.h(elements, "elements");
        Object[] objArr = elements.f2322b;
        long[] jArr = elements.f2321a;
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
                        w(objArr[(i11 << 3) + i13]);
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

    public final void v(Iterable elements) {
        Intrinsics.h(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            w(it.next());
        }
    }

    public final void w(Object obj) {
        this.f2322b[o(obj)] = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r18.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0.f2323c
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f2321a
            int r8 = r3 >> 3
            r9 = r3 & 7
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
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L48:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L67
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.f2322b
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.Intrinsics.c(r15, r1)
            if (r15 == 0) goto L61
            goto L71
        L61:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L48
        L67:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L7a
            r11 = -1
        L71:
            if (r11 < 0) goto L74
            r2 = r12
        L74:
            if (r2 == 0) goto L79
            r0.y(r11)
        L79:
            return r2
        L7a:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.x(java.lang.Object):boolean");
    }

    public final void y(int i11) {
        this.f2324d--;
        long[] jArr = this.f2321a;
        int i12 = this.f2323c;
        int i13 = i11 >> 3;
        int i14 = (i11 & 7) << 3;
        long j11 = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        jArr[i13] = j11;
        jArr[(((i11 - 7) & i12) + (i12 & 7)) >> 3] = j11;
        this.f2322b[i11] = null;
    }

    public final void z(int i11) {
        long[] jArr = this.f2321a;
        Object[] objArr = this.f2322b;
        int i12 = this.f2323c;
        s(i11);
        long[] jArr2 = this.f2321a;
        Object[] objArr2 = this.f2322b;
        int i13 = this.f2323c;
        for (int i14 = 0; i14 < i12; i14++) {
            if (((jArr[i14 >> 3] >> ((i14 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i14];
                int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i15 = hashCode ^ (hashCode << 16);
                int p11 = p(i15 >>> 7);
                long j11 = i15 & 127;
                int i16 = p11 >> 3;
                int i17 = (p11 & 7) << 3;
                long j12 = (jArr2[i16] & (~(255 << i17))) | (j11 << i17);
                jArr2[i16] = j12;
                jArr2[(((p11 - 7) & i13) + (i13 & 7)) >> 3] = j12;
                objArr2[p11] = obj;
            }
        }
    }
}
