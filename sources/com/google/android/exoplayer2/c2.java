package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.o;

/* loaded from: classes3.dex */
final class c2 {

    /* renamed from: a, reason: collision with root package name */
    public final o.b f24875a;

    /* renamed from: b, reason: collision with root package name */
    public final long f24876b;

    /* renamed from: c, reason: collision with root package name */
    public final long f24877c;

    /* renamed from: d, reason: collision with root package name */
    public final long f24878d;

    /* renamed from: e, reason: collision with root package name */
    public final long f24879e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f24880f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f24881g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f24882h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f24883i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c2(o.b bVar, long j11, long j12, long j13, long j14, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14 = true;
        com.google.android.exoplayer2.util.a.a(!z13 || z11);
        com.google.android.exoplayer2.util.a.a(!z12 || z11);
        if (z10 && (z11 || z12 || z13)) {
            z14 = false;
        }
        com.google.android.exoplayer2.util.a.a(z14);
        this.f24875a = bVar;
        this.f24876b = j11;
        this.f24877c = j12;
        this.f24878d = j13;
        this.f24879e = j14;
        this.f24880f = z10;
        this.f24881g = z11;
        this.f24882h = z12;
        this.f24883i = z13;
    }

    public c2 a(long j11) {
        return j11 == this.f24877c ? this : new c2(this.f24875a, this.f24876b, j11, this.f24878d, this.f24879e, this.f24880f, this.f24881g, this.f24882h, this.f24883i);
    }

    public c2 b(long j11) {
        return j11 == this.f24876b ? this : new c2(this.f24875a, j11, this.f24877c, this.f24878d, this.f24879e, this.f24880f, this.f24881g, this.f24882h, this.f24883i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c2.class != obj.getClass()) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return this.f24876b == c2Var.f24876b && this.f24877c == c2Var.f24877c && this.f24878d == c2Var.f24878d && this.f24879e == c2Var.f24879e && this.f24880f == c2Var.f24880f && this.f24881g == c2Var.f24881g && this.f24882h == c2Var.f24882h && this.f24883i == c2Var.f24883i && com.google.android.exoplayer2.util.p0.c(this.f24875a, c2Var.f24875a);
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f24875a.hashCode()) * 31) + ((int) this.f24876b)) * 31) + ((int) this.f24877c)) * 31) + ((int) this.f24878d)) * 31) + ((int) this.f24879e)) * 31) + (this.f24880f ? 1 : 0)) * 31) + (this.f24881g ? 1 : 0)) * 31) + (this.f24882h ? 1 : 0)) * 31) + (this.f24883i ? 1 : 0);
    }
}
