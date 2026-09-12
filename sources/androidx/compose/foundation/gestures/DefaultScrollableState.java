package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.o0;

/* loaded from: classes.dex */
final class DefaultScrollableState implements o {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f2727a;

    /* renamed from: b, reason: collision with root package name */
    private final k f2728b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final MutatorMutex f2729c = new MutatorMutex();

    /* renamed from: d, reason: collision with root package name */
    private final i1 f2730d;

    /* renamed from: e, reason: collision with root package name */
    private final i1 f2731e;

    /* renamed from: f, reason: collision with root package name */
    private final i1 f2732f;

    /* loaded from: classes.dex */
    public static final class a implements k {
        a() {
        }

        @Override // androidx.compose.foundation.gestures.k
        public float a(float f11) {
            if (Float.isNaN(f11)) {
                return 0.0f;
            }
            float floatValue = ((Number) DefaultScrollableState.this.k().invoke(Float.valueOf(f11))).floatValue();
            DefaultScrollableState.this.f2731e.setValue(Boolean.valueOf(floatValue > 0.0f));
            DefaultScrollableState.this.f2732f.setValue(Boolean.valueOf(floatValue < 0.0f));
            return floatValue;
        }
    }

    public DefaultScrollableState(Function1 function1) {
        i1 c11;
        i1 c12;
        i1 c13;
        this.f2727a = function1;
        Boolean bool = Boolean.FALSE;
        c11 = u2.c(bool, null, 2, null);
        this.f2730d = c11;
        c12 = u2.c(bool, null, 2, null);
        this.f2731e = c12;
        c13 = u2.c(bool, null, 2, null);
        this.f2732f = c13;
    }

    @Override // androidx.compose.foundation.gestures.o
    public boolean a() {
        return ((Boolean) this.f2730d.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.o
    public /* synthetic */ boolean b() {
        return n.a(this);
    }

    @Override // androidx.compose.foundation.gestures.o
    public Object c(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object e11 = o0.e(new DefaultScrollableState$scroll$2(this, mutatePriority, function2, null), continuation);
        return e11 == IntrinsicsKt.f() ? e11 : Unit.f67184a;
    }

    @Override // androidx.compose.foundation.gestures.o
    public /* synthetic */ boolean d() {
        return n.b(this);
    }

    @Override // androidx.compose.foundation.gestures.o
    public float e(float f11) {
        return ((Number) this.f2727a.invoke(Float.valueOf(f11))).floatValue();
    }

    public final Function1 k() {
        return this.f2727a;
    }
}
