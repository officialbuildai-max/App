package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class z1 extends i2 {

    /* renamed from: a, reason: collision with root package name */
    private final Continuation f68140a;

    public z1(CoroutineContext coroutineContext, Function2 function2) {
        super(coroutineContext, false);
        this.f68140a = IntrinsicsKt.a(function2, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void onStart() {
        b00.a.b(this.f68140a, this);
    }
}
