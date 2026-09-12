package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterSet;
import androidx.collection.n0;
import androidx.collection.v0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final n0 f3765a = v0.d();

    public final void a(Object obj, Object obj2) {
        n0 n0Var = this.f3765a;
        int k11 = n0Var.k(obj);
        boolean z10 = k11 < 0;
        Object obj3 = z10 ? null : n0Var.f2421c[k11];
        if (obj3 != null) {
            if (obj3 instanceof MutableScatterSet) {
                Intrinsics.f(obj3, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                ((MutableScatterSet) obj3).h(obj2);
            } else if (obj3 != obj2) {
                MutableScatterSet mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.f(obj3, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet.h(obj3);
                mutableScatterSet.h(obj2);
                obj2 = mutableScatterSet;
            }
            obj2 = obj3;
        }
        if (!z10) {
            n0Var.f2421c[k11] = obj2;
            return;
        }
        int i11 = ~k11;
        n0Var.f2420b[i11] = obj;
        n0Var.f2421c[i11] = obj2;
    }

    public final void b() {
        this.f3765a.h();
    }

    public final boolean c(Object obj) {
        return this.f3765a.a(obj);
    }

    public final n0 d() {
        return this.f3765a;
    }

    public final int e() {
        return this.f3765a.d();
    }

    public final boolean f(Object obj, Object obj2) {
        Object b11 = this.f3765a.b(obj);
        if (b11 == null) {
            return false;
        }
        if (!(b11 instanceof MutableScatterSet)) {
            if (!Intrinsics.c(b11, obj2)) {
                return false;
            }
            this.f3765a.o(obj);
            return true;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) b11;
        boolean x10 = mutableScatterSet.x(obj2);
        if (x10 && mutableScatterSet.d()) {
            this.f3765a.o(obj);
        }
        return x10;
    }

    public final void g(Object obj) {
        boolean z10;
        n0 n0Var = this.f3765a;
        long[] jArr = n0Var.f2419a;
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
                        int i14 = (i11 << 3) + i13;
                        Object obj2 = n0Var.f2420b[i14];
                        Object obj3 = n0Var.f2421c[i14];
                        if (obj3 instanceof MutableScatterSet) {
                            Intrinsics.f(obj3, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScope$lambda$3>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
                            mutableScatterSet.x(obj);
                            z10 = mutableScatterSet.d();
                        } else {
                            z10 = obj3 == obj;
                        }
                        if (z10) {
                            n0Var.p(i14);
                        }
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

    public final void h(Object obj, Object obj2) {
        this.f3765a.r(obj, obj2);
    }
}
