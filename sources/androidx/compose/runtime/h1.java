package androidx.compose.runtime;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.collection.n0 f3809a;

    private /* synthetic */ h1(androidx.collection.n0 n0Var) {
        this.f3809a = n0Var;
    }

    public static final /* synthetic */ h1 a(androidx.collection.n0 n0Var) {
        return new h1(n0Var);
    }

    public static androidx.collection.n0 b(androidx.collection.n0 n0Var) {
        return n0Var;
    }

    public static boolean c(androidx.collection.n0 n0Var, Object obj) {
        return (obj instanceof h1) && Intrinsics.c(n0Var, ((h1) obj).h());
    }

    public static int d(androidx.collection.n0 n0Var) {
        return n0Var.hashCode();
    }

    public static final Object e(androidx.collection.n0 n0Var, Object obj) {
        Object b11 = n0Var.b(obj);
        if (b11 == null) {
            return null;
        }
        if (TypeIntrinsics.l(b11)) {
            List c11 = TypeIntrinsics.c(b11);
            Object remove = c11.remove(0);
            if (c11.isEmpty()) {
                n0Var.o(obj);
            }
            b11 = remove;
        } else {
            n0Var.o(obj);
        }
        Intrinsics.f(b11, "null cannot be cast to non-null type V of androidx.compose.runtime.MutableScatterMultiMap.pop_impl$lambda$1");
        return b11;
    }

    public static final void f(androidx.collection.n0 n0Var, Object obj, Object obj2) {
        int k11 = n0Var.k(obj);
        boolean z10 = k11 < 0;
        Object obj3 = z10 ? null : n0Var.f2421c[k11];
        if (obj3 != null) {
            if (TypeIntrinsics.l(obj3)) {
                Intrinsics.f(obj3, "null cannot be cast to non-null type kotlin.collections.MutableList<V of androidx.compose.runtime.MutableScatterMultiMap.put_impl$lambda$0>");
                List c11 = TypeIntrinsics.c(obj3);
                c11.add(obj2);
                obj2 = c11;
            } else {
                obj2 = CollectionsKt.q(obj3, obj2);
            }
        }
        if (!z10) {
            n0Var.f2421c[k11] = obj2;
            return;
        }
        int i11 = ~k11;
        n0Var.f2420b[i11] = obj;
        n0Var.f2421c[i11] = obj2;
    }

    public static String g(androidx.collection.n0 n0Var) {
        return "MutableScatterMultiMap(map=" + n0Var + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f3809a, obj);
    }

    public final /* synthetic */ androidx.collection.n0 h() {
        return this.f3809a;
    }

    public int hashCode() {
        return d(this.f3809a);
    }

    public String toString() {
        return g(this.f3809a);
    }
}
