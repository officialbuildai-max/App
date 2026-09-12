package androidx.view;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements n0 {
    public abstract Lifecycle a();

    public final t1 b(Function2 block) {
        t1 d11;
        Intrinsics.h(block, "block");
        d11 = k.d(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, block, null), 3, null);
        return d11;
    }
}
