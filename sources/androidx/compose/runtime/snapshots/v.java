package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.h3;
import kotlin.collections.ArraysKt;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private int f4101a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f4102b = new int[16];

    /* renamed from: c, reason: collision with root package name */
    private h3[] f4103c = new h3[16];

    private final int b(Object obj, int i11) {
        int i12 = this.f4101a - 1;
        int i13 = 0;
        while (i13 <= i12) {
            int i14 = (i13 + i12) >>> 1;
            int i15 = this.f4102b[i14];
            if (i15 < i11) {
                i13 = i14 + 1;
            } else {
                if (i15 <= i11) {
                    h3 h3Var = this.f4103c[i14];
                    return obj == (h3Var != null ? h3Var.get() : null) ? i14 : c(i14, obj, i11);
                }
                i12 = i14 - 1;
            }
        }
        return -(i13 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        return -(r4 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int c(int r4, java.lang.Object r5, int r6) {
        /*
            r3 = this;
            int r0 = r4 + (-1)
        L2:
            r1 = 0
            r2 = -1
            if (r2 >= r0) goto L1d
            int[] r2 = r3.f4102b
            r2 = r2[r0]
            if (r2 == r6) goto Ld
            goto L1d
        Ld:
            androidx.compose.runtime.h3[] r2 = r3.f4103c
            r2 = r2[r0]
            if (r2 == 0) goto L17
            java.lang.Object r1 = r2.get()
        L17:
            if (r1 != r5) goto L1a
            return r0
        L1a:
            int r0 = r0 + (-1)
            goto L2
        L1d:
            int r4 = r4 + 1
            int r0 = r3.f4101a
        L21:
            if (r4 >= r0) goto L3f
            int[] r2 = r3.f4102b
            r2 = r2[r4]
            if (r2 == r6) goto L2d
        L29:
            int r4 = r4 + 1
            int r4 = -r4
            return r4
        L2d:
            androidx.compose.runtime.h3[] r2 = r3.f4103c
            r2 = r2[r4]
            if (r2 == 0) goto L38
            java.lang.Object r2 = r2.get()
            goto L39
        L38:
            r2 = r1
        L39:
            if (r2 != r5) goto L3c
            return r4
        L3c:
            int r4 = r4 + 1
            goto L21
        L3f:
            int r4 = r3.f4101a
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.v.c(int, java.lang.Object, int):int");
    }

    public final boolean a(Object obj) {
        int i11;
        int i12 = this.f4101a;
        int c11 = androidx.compose.runtime.b.c(obj);
        if (i12 > 0) {
            i11 = b(obj, c11);
            if (i11 >= 0) {
                return false;
            }
        } else {
            i11 = -1;
        }
        int i13 = -(i11 + 1);
        h3[] h3VarArr = this.f4103c;
        int length = h3VarArr.length;
        if (i12 == length) {
            int i14 = length * 2;
            h3[] h3VarArr2 = new h3[i14];
            int[] iArr = new int[i14];
            int i15 = i13 + 1;
            ArraysKt.n(h3VarArr, h3VarArr2, i15, i13, i12);
            ArraysKt.r(this.f4103c, h3VarArr2, 0, 0, i13, 6, null);
            ArraysKt.l(this.f4102b, iArr, i15, i13, i12);
            ArraysKt.q(this.f4102b, iArr, 0, 0, i13, 6, null);
            this.f4103c = h3VarArr2;
            this.f4102b = iArr;
        } else {
            int i16 = i13 + 1;
            ArraysKt.n(h3VarArr, h3VarArr, i16, i13, i12);
            int[] iArr2 = this.f4102b;
            ArraysKt.l(iArr2, iArr2, i16, i13, i12);
        }
        this.f4103c[i13] = new h3(obj);
        this.f4102b[i13] = c11;
        this.f4101a++;
        return true;
    }

    public final int[] d() {
        return this.f4102b;
    }

    public final int e() {
        return this.f4101a;
    }

    public final h3[] f() {
        return this.f4103c;
    }

    public final void g(int i11) {
        this.f4101a = i11;
    }
}
