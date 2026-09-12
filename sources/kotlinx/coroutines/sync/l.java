package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class l extends w {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f68118e;

    public l(long j11, l lVar, int i11) {
        super(j11, lVar, i11);
        int i12;
        i12 = k.f68117f;
        this.f68118e = new AtomicReferenceArray(i12);
    }

    @Override // kotlinx.coroutines.internal.w
    public int r() {
        int i11;
        i11 = k.f68117f;
        return i11;
    }

    @Override // kotlinx.coroutines.internal.w
    public void s(int i11, Throwable th2, CoroutineContext coroutineContext) {
        z zVar;
        zVar = k.f68116e;
        v().set(i11, zVar);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f68010c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.f68118e;
    }
}
