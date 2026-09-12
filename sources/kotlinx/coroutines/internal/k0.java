package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public class k0 {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f67987b = AtomicIntegerFieldUpdater.newUpdater(k0.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    private l0[] f67988a;

    private final l0[] g() {
        l0[] l0VarArr = this.f67988a;
        if (l0VarArr == null) {
            l0[] l0VarArr2 = new l0[4];
            this.f67988a = l0VarArr2;
            return l0VarArr2;
        }
        if (c() < l0VarArr.length) {
            return l0VarArr;
        }
        Object[] copyOf = Arrays.copyOf(l0VarArr, c() * 2);
        Intrinsics.g(copyOf, "copyOf(...)");
        l0[] l0VarArr3 = (l0[]) copyOf;
        this.f67988a = l0VarArr3;
        return l0VarArr3;
    }

    private final void k(int i11) {
        f67987b.set(this, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void l(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            return
        Lb:
            kotlinx.coroutines.internal.l0[] r2 = r5.f67988a
            kotlin.jvm.internal.Intrinsics.e(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            kotlin.jvm.internal.Intrinsics.e(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.Intrinsics.e(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            kotlin.jvm.internal.Intrinsics.e(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.Intrinsics.e(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
            return
        L3f:
            r5.n(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k0.l(int):void");
    }

    private final void m(int i11) {
        while (i11 > 0) {
            l0[] l0VarArr = this.f67988a;
            Intrinsics.e(l0VarArr);
            int i12 = (i11 - 1) / 2;
            l0 l0Var = l0VarArr[i12];
            Intrinsics.e(l0Var);
            l0 l0Var2 = l0VarArr[i11];
            Intrinsics.e(l0Var2);
            if (((Comparable) l0Var).compareTo(l0Var2) <= 0) {
                return;
            }
            n(i11, i12);
            i11 = i12;
        }
    }

    private final void n(int i11, int i12) {
        l0[] l0VarArr = this.f67988a;
        Intrinsics.e(l0VarArr);
        l0 l0Var = l0VarArr[i12];
        Intrinsics.e(l0Var);
        l0 l0Var2 = l0VarArr[i11];
        Intrinsics.e(l0Var2);
        l0VarArr[i11] = l0Var;
        l0VarArr[i12] = l0Var2;
        l0Var.setIndex(i11);
        l0Var2.setIndex(i12);
    }

    public final void a(l0 l0Var) {
        l0Var.setHeap(this);
        l0[] g11 = g();
        int c11 = c();
        k(c11 + 1);
        g11[c11] = l0Var;
        l0Var.setIndex(c11);
        m(c11);
    }

    public final l0 b() {
        l0[] l0VarArr = this.f67988a;
        if (l0VarArr != null) {
            return l0VarArr[0];
        }
        return null;
    }

    public final int c() {
        return f67987b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final l0 f() {
        l0 b11;
        synchronized (this) {
            b11 = b();
        }
        return b11;
    }

    public final boolean h(l0 l0Var) {
        boolean z10;
        synchronized (this) {
            if (l0Var.getHeap() == null) {
                z10 = false;
            } else {
                i(l0Var.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    public final l0 i(int i11) {
        l0[] l0VarArr = this.f67988a;
        Intrinsics.e(l0VarArr);
        k(c() - 1);
        if (i11 < c()) {
            n(i11, c());
            int i12 = (i11 - 1) / 2;
            if (i11 > 0) {
                l0 l0Var = l0VarArr[i11];
                Intrinsics.e(l0Var);
                l0 l0Var2 = l0VarArr[i12];
                Intrinsics.e(l0Var2);
                if (((Comparable) l0Var).compareTo(l0Var2) < 0) {
                    n(i11, i12);
                    m(i12);
                }
            }
            l(i11);
        }
        l0 l0Var3 = l0VarArr[c()];
        Intrinsics.e(l0Var3);
        l0Var3.setHeap(null);
        l0Var3.setIndex(-1);
        l0VarArr[c()] = null;
        return l0Var3;
    }

    public final l0 j() {
        l0 i11;
        synchronized (this) {
            i11 = c() > 0 ? i(0) : null;
        }
        return i11;
    }
}
