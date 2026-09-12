package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private final g3 f3946a;

    private q(Function0 function0) {
        this.f3946a = new s0(function0);
    }

    public /* synthetic */ q(Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0);
    }

    public g3 a() {
        return this.f3946a;
    }

    public abstract g3 b(t1 t1Var, g3 g3Var);
}
