package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class g0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f2518a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2519b;

    /* renamed from: c, reason: collision with root package name */
    private final z f2520c;

    /* renamed from: d, reason: collision with root package name */
    private final long f2521d;

    /* renamed from: e, reason: collision with root package name */
    private final long f2522e;

    public g0() {
        this(0, 0, null, 7, null);
    }

    public g0(int i11, int i12, z zVar) {
        this.f2518a = i11;
        this.f2519b = i12;
        this.f2520c = zVar;
        this.f2521d = i11 * 1000000;
        this.f2522e = i12 * 1000000;
    }

    public /* synthetic */ g0(int i11, int i12, z zVar, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 300 : i11, (i13 & 2) != 0 ? 0 : i12, (i13 & 4) != 0 ? b0.c() : zVar);
    }

    private final long f(long j11) {
        return RangesKt.n(j11 - this.f2522e, 0L, this.f2521d);
    }

    @Override // androidx.compose.animation.core.d0, androidx.compose.animation.core.g
    public /* synthetic */ c1 a(s0 s0Var) {
        return c0.c(this, s0Var);
    }

    @Override // androidx.compose.animation.core.g
    public /* bridge */ /* synthetic */ v0 a(s0 s0Var) {
        v0 a11;
        a11 = a(s0Var);
        return a11;
    }

    @Override // androidx.compose.animation.core.d0
    public /* synthetic */ float b(float f11, float f12, float f13) {
        return c0.a(this, f11, f12, f13);
    }

    @Override // androidx.compose.animation.core.d0
    public float c(long j11, float f11, float f12, float f13) {
        float f14 = this.f2518a == 0 ? 1.0f : ((float) f(j11)) / ((float) this.f2521d);
        z zVar = this.f2520c;
        if (f14 < 0.0f) {
            f14 = 0.0f;
        }
        return VectorConvertersKt.k(f11, f12, zVar.a(f14 <= 1.0f ? f14 : 1.0f));
    }

    @Override // androidx.compose.animation.core.d0
    public float d(long j11, float f11, float f12, float f13) {
        long f14 = f(j11);
        if (f14 < 0) {
            return 0.0f;
        }
        if (f14 == 0) {
            return f13;
        }
        return (c(f14, f11, f12, f13) - c(f14 - 1000000, f11, f12, f13)) * 1000.0f;
    }

    @Override // androidx.compose.animation.core.d0
    public long e(float f11, float f12, float f13) {
        return (this.f2519b + this.f2518a) * 1000000;
    }
}
