package kotlinx.coroutines.channels;

import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.s2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class p implements s2 {

    /* renamed from: a, reason: collision with root package name */
    public final CancellableContinuationImpl f67821a;

    public p(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f67821a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.s2
    public void invokeOnCancellation(w wVar, int i11) {
        this.f67821a.invokeOnCancellation(wVar, i11);
    }
}
