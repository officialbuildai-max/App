package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.j;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
public final class i implements j.a {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f3026a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f3027b;

    /* renamed from: c, reason: collision with root package name */
    private final Function4 f3028c;

    public i(Function1 function1, Function1 function12, Function4 function4) {
        this.f3026a = function1;
        this.f3027b = function12;
        this.f3028c = function4;
    }

    public final Function4 a() {
        return this.f3028c;
    }

    @Override // androidx.compose.foundation.lazy.layout.j.a
    public Function1 getKey() {
        return this.f3026a;
    }

    @Override // androidx.compose.foundation.lazy.layout.j.a
    public Function1 getType() {
        return this.f3027b;
    }
}
