package com.transsion.player.shorttv.preload;

import androidx.collection.s;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f48572a;

    /* renamed from: b, reason: collision with root package name */
    private final long f48573b;

    public c(boolean z10, long j11) {
        this.f48572a = z10;
        this.f48573b = j11;
    }

    public final boolean a() {
        return this.f48572a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f48572a == cVar.f48572a && this.f48573b == cVar.f48573b;
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.f48572a) * 31) + s.a(this.f48573b);
    }

    public String toString() {
        return "VideoPreloadConfig(enable=" + this.f48572a + ", cacheByte=" + this.f48573b + ")";
    }
}
