package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static final d0 f3808a = new d0();

    public static final void a(Object obj, Function1 function1, i iVar, int i11) {
        if (k.H()) {
            k.Q(-1371986847, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:155)");
        }
        boolean O = iVar.O(obj);
        Object y10 = iVar.y();
        if (O || y10 == i.f3811a.a()) {
            y10 = new b0(function1);
            iVar.p(y10);
        }
        if (k.H()) {
            k.P();
        }
    }

    public static final void b(Object[] objArr, Function1 function1, i iVar, int i11) {
        if (k.H()) {
            k.Q(-1307627122, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:276)");
        }
        boolean z10 = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            z10 |= iVar.O(obj);
        }
        Object y10 = iVar.y();
        if (z10 || y10 == i.f3811a.a()) {
            iVar.p(new b0(function1));
        }
        if (k.H()) {
            k.P();
        }
    }

    public static final void c(Object obj, Object obj2, Function2 function2, i iVar, int i11) {
        if (k.H()) {
            k.Q(590241125, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:360)");
        }
        CoroutineContext m11 = iVar.m();
        boolean O = iVar.O(obj) | iVar.O(obj2);
        Object y10 = iVar.y();
        if (O || y10 == i.f3811a.a()) {
            y10 = new r0(m11, function2);
            iVar.p(y10);
        }
        if (k.H()) {
            k.P();
        }
    }

    public static final void d(Object obj, Function2 function2, i iVar, int i11) {
        if (k.H()) {
            k.Q(1179185413, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:337)");
        }
        CoroutineContext m11 = iVar.m();
        boolean O = iVar.O(obj);
        Object y10 = iVar.y();
        if (O || y10 == i.f3811a.a()) {
            y10 = new r0(m11, function2);
            iVar.p(y10);
        }
        if (k.H()) {
            k.P();
        }
    }

    public static final void e(Function0 function0, i iVar, int i11) {
        if (k.H()) {
            k.Q(-1288466761, i11, -1, "androidx.compose.runtime.SideEffect (Effects.kt:48)");
        }
        iVar.t(function0);
        if (k.H()) {
            k.P();
        }
    }

    public static final kotlinx.coroutines.n0 g(CoroutineContext coroutineContext, i iVar) {
        kotlinx.coroutines.z b11;
        t1.b bVar = kotlinx.coroutines.t1.f68119l1;
        if (coroutineContext.get(bVar) == null) {
            CoroutineContext m11 = iVar.m();
            return kotlinx.coroutines.o0.a(m11.plus(kotlinx.coroutines.v1.a((kotlinx.coroutines.t1) m11.get(bVar))).plus(coroutineContext));
        }
        b11 = JobKt__JobKt.b(null, 1, null);
        b11.b(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
        return kotlinx.coroutines.o0.a(b11);
    }
}
