package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.r;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z2 {

    /* renamed from: a, reason: collision with root package name */
    public final r.b f13470a;

    /* renamed from: b, reason: collision with root package name */
    public final long f13471b;

    /* renamed from: c, reason: collision with root package name */
    public final long f13472c;

    /* renamed from: d, reason: collision with root package name */
    public final long f13473d;

    /* renamed from: e, reason: collision with root package name */
    public final long f13474e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f13475f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f13476g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f13477h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f13478i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f13479j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z2(r.b bVar, long j11, long j12, long j13, long j14, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15 = true;
        androidx.media3.common.util.a.a(!z14 || z12);
        androidx.media3.common.util.a.a(!z13 || z12);
        if (z11 && (z12 || z13 || z14)) {
            z15 = false;
        }
        androidx.media3.common.util.a.a(z15);
        this.f13470a = bVar;
        this.f13471b = j11;
        this.f13472c = j12;
        this.f13473d = j13;
        this.f13474e = j14;
        this.f13475f = z10;
        this.f13476g = z11;
        this.f13477h = z12;
        this.f13478i = z13;
        this.f13479j = z14;
    }

    public z2 a(long j11) {
        return j11 == this.f13472c ? this : new z2(this.f13470a, this.f13471b, j11, this.f13473d, this.f13474e, this.f13475f, this.f13476g, this.f13477h, this.f13478i, this.f13479j);
    }

    public z2 b(long j11) {
        return j11 == this.f13471b ? this : new z2(this.f13470a, j11, this.f13472c, this.f13473d, this.f13474e, this.f13475f, this.f13476g, this.f13477h, this.f13478i, this.f13479j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z2.class != obj.getClass()) {
            return false;
        }
        z2 z2Var = (z2) obj;
        return this.f13471b == z2Var.f13471b && this.f13472c == z2Var.f13472c && this.f13473d == z2Var.f13473d && this.f13474e == z2Var.f13474e && this.f13475f == z2Var.f13475f && this.f13476g == z2Var.f13476g && this.f13477h == z2Var.f13477h && this.f13478i == z2Var.f13478i && this.f13479j == z2Var.f13479j && Objects.equals(this.f13470a, z2Var.f13470a);
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f13470a.hashCode()) * 31) + ((int) this.f13471b)) * 31) + ((int) this.f13472c)) * 31) + ((int) this.f13473d)) * 31) + ((int) this.f13474e)) * 31) + (this.f13475f ? 1 : 0)) * 31) + (this.f13476g ? 1 : 0)) * 31) + (this.f13477h ? 1 : 0)) * 31) + (this.f13478i ? 1 : 0)) * 31) + (this.f13479j ? 1 : 0);
    }
}
