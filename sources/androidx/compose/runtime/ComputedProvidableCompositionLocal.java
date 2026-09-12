package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class ComputedProvidableCompositionLocal extends s1 {

    /* renamed from: b, reason: collision with root package name */
    private final x f3672b;

    public ComputedProvidableCompositionLocal(Function1 function1) {
        super(new Function0<Object>() { // from class: androidx.compose.runtime.ComputedProvidableCompositionLocal.1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                k.s("Unexpected call to default provider");
                throw new KotlinNothingValueException();
            }
        });
        this.f3672b = new x(function1);
    }

    @Override // androidx.compose.runtime.s1
    public t1 c(Object obj) {
        return new t1(this, obj, obj == null, null, null, null, true);
    }

    @Override // androidx.compose.runtime.q
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public x a() {
        return this.f3672b;
    }
}
