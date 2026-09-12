package com.transsion.startup.pref.consume;

import androidx.collection.s;
import androidx.compose.foundation.e;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final long f54577a;

    /* renamed from: b, reason: collision with root package name */
    private final long f54578b;

    /* renamed from: c, reason: collision with root package name */
    private final long f54579c;

    /* renamed from: d, reason: collision with root package name */
    private final long f54580d;

    /* renamed from: e, reason: collision with root package name */
    private final long f54581e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f54582f;

    public b(long j11, long j12, long j13, long j14, long j15, boolean z10) {
        this.f54577a = j11;
        this.f54578b = j12;
        this.f54579c = j13;
        this.f54580d = j14;
        this.f54581e = j15;
        this.f54582f = z10;
    }

    public final long a() {
        return this.f54578b;
    }

    public final boolean b() {
        return this.f54582f;
    }

    public final long c() {
        return this.f54579c;
    }

    public final long d() {
        return this.f54581e;
    }

    public final long e() {
        return this.f54577a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f54577a == bVar.f54577a && this.f54578b == bVar.f54578b && this.f54579c == bVar.f54579c && this.f54580d == bVar.f54580d && this.f54581e == bVar.f54581e && this.f54582f == bVar.f54582f;
    }

    public final long f() {
        return this.f54580d;
    }

    public int hashCode() {
        return (((((((((s.a(this.f54577a) * 31) + s.a(this.f54578b)) * 31) + s.a(this.f54579c)) * 31) + s.a(this.f54580d)) * 31) + s.a(this.f54581e)) * 31) + e.a(this.f54582f);
    }

    public String toString() {
        return "StartupMetrics(splashTTID=" + this.f54577a + ", adWaitDuration=" + this.f54578b + ", mainActivityTTID=" + this.f54579c + ", totalTTFD=" + this.f54580d + ", realTTFD=" + this.f54581e + ", hasAd=" + this.f54582f + ")";
    }
}
