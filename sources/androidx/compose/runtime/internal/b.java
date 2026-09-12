package androidx.compose.runtime.internal;

import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.u1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3837a = new Object();

    public static final int a(int i11, int i12) {
        return i11 << (((i12 % 10) * 3) + 1);
    }

    public static final a b(int i11, boolean z10, Object obj) {
        return new ComposableLambdaImpl(i11, z10, obj);
    }

    public static final int c(int i11) {
        return a(2, i11);
    }

    public static final a d(int i11, boolean z10, Object obj, i iVar, int i12) {
        if (k.H()) {
            k.Q(-1573003438, i12, -1, "androidx.compose.runtime.internal.rememberComposableLambda (ComposableLambda.kt:628)");
        }
        Object y10 = iVar.y();
        if (y10 == i.f3811a.a()) {
            y10 = new ComposableLambdaImpl(i11, z10, obj);
            iVar.p(y10);
        }
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) y10;
        composableLambdaImpl.i(obj);
        if (k.H()) {
            k.P();
        }
        return composableLambdaImpl;
    }

    public static final boolean e(u1 u1Var, u1 u1Var2) {
        if (u1Var != null) {
            if ((u1Var instanceof RecomposeScopeImpl) && (u1Var2 instanceof RecomposeScopeImpl)) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) u1Var;
                if (!recomposeScopeImpl.r() || Intrinsics.c(u1Var, u1Var2) || Intrinsics.c(recomposeScopeImpl.i(), ((RecomposeScopeImpl) u1Var2).i())) {
                }
            }
            return false;
        }
        return true;
    }

    public static final int f(int i11) {
        return a(1, i11);
    }
}
