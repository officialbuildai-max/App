package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class h2 extends w1 {

    /* renamed from: e, reason: collision with root package name */
    private final Continuation f67959e;

    public h2(Continuation continuation) {
        this.f67959e = continuation;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th2) {
        Continuation continuation = this.f67959e;
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
    }
}
