package co;

import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final long f17722a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f17723b;

    public m(long j11, Integer num) {
        this.f17722a = j11;
        this.f17723b = num;
    }

    public final Integer a() {
        return this.f17723b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f17722a == mVar.f17722a && Intrinsics.c(this.f17723b, mVar.f17723b);
    }

    public int hashCode() {
        int a11 = s.a(this.f17722a) * 31;
        Integer num = this.f17723b;
        return a11 + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "VideoConfig(cacheByte=" + this.f17722a + ", maxBufferMsConfig=" + this.f17723b + ")";
    }
}
