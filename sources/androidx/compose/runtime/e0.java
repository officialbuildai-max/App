package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class e0 extends s1 {

    /* renamed from: b, reason: collision with root package name */
    private final q2 f3768b;

    public e0(q2 q2Var, Function0 function0) {
        super(function0);
        this.f3768b = q2Var;
    }

    @Override // androidx.compose.runtime.s1
    public t1 c(Object obj) {
        return new t1(this, obj, obj == null, this.f3768b, null, null, true);
    }
}
