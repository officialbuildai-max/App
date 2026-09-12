package androidx.view;

import androidx.view.Lifecycle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.o0;

/* loaded from: classes.dex */
public abstract class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        Object e11;
        if (state != Lifecycle.State.INITIALIZED) {
            return (lifecycle.b() != Lifecycle.State.DESTROYED && (e11 = o0.e(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, function2, null), continuation)) == IntrinsicsKt.f()) ? e11 : Unit.f67184a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }

    public static final Object b(u uVar, Lifecycle.State state, Function2 function2, Continuation continuation) {
        Object a11 = a(uVar.getLifecycle(), state, function2, continuation);
        return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
    }
}
