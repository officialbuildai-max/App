package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class i0 implements CoroutineContext.Key {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal f67985a;

    public i0(ThreadLocal threadLocal) {
        this.f67985a = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i0) && Intrinsics.c(this.f67985a, ((i0) obj).f67985a);
    }

    public int hashCode() {
        return this.f67985a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f67985a + ')';
    }
}
