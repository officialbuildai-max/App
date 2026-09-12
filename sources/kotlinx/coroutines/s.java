package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class s extends w1 {

    /* renamed from: e, reason: collision with root package name */
    public final CancellableContinuationImpl f68039e;

    public s(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f68039e = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return true;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th2) {
        CancellableContinuationImpl cancellableContinuationImpl = this.f68039e;
        cancellableContinuationImpl.parentCancelled$kotlinx_coroutines_core(cancellableContinuationImpl.getContinuationCancellationCause(t()));
    }
}
