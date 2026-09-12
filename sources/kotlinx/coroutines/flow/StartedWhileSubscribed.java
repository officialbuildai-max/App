package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class StartedWhileSubscribed implements g1 {

    /* renamed from: b, reason: collision with root package name */
    private final long f67891b;

    /* renamed from: c, reason: collision with root package name */
    private final long f67892c;

    public StartedWhileSubscribed(long j11, long j12) {
        this.f67891b = j11;
        this.f67892c = j12;
        if (j11 < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j11 + " ms) cannot be negative").toString());
        }
        if (j12 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j12 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.g1
    public b a(i1 i1Var) {
        return d.k(d.l(d.H(i1Var, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.f67891b == startedWhileSubscribed.f67891b && this.f67892c == startedWhileSubscribed.f67892c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (androidx.collection.s.a(this.f67891b) * 31) + androidx.collection.s.a(this.f67892c);
    }

    public String toString() {
        List d11 = CollectionsKt.d(2);
        if (this.f67891b > 0) {
            d11.add("stopTimeout=" + this.f67891b + "ms");
        }
        if (this.f67892c < Long.MAX_VALUE) {
            d11.add("replayExpiration=" + this.f67892c + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.s0(CollectionsKt.a(d11), null, null, null, 0, null, null, 63, null) + ')';
    }
}
