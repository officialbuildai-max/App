package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* loaded from: classes7.dex */
public final class e1 extends kotlinx.coroutines.flow.internal.c {

    /* renamed from: a, reason: collision with root package name */
    public long f67900a = -1;

    /* renamed from: b, reason: collision with root package name */
    public Continuation f67901b;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(SharedFlowImpl sharedFlowImpl) {
        if (this.f67900a >= 0) {
            return false;
        }
        this.f67900a = sharedFlowImpl.Y();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Continuation[] b(SharedFlowImpl sharedFlowImpl) {
        long j11 = this.f67900a;
        this.f67900a = -1L;
        this.f67901b = null;
        return sharedFlowImpl.X(j11);
    }
}
