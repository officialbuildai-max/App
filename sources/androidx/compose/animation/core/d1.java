package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class d1 implements x0 {

    /* renamed from: a, reason: collision with root package name */
    private final e0 f2491a;

    /* renamed from: b, reason: collision with root package name */
    private o f2492b;

    /* renamed from: c, reason: collision with root package name */
    private o f2493c;

    /* renamed from: d, reason: collision with root package name */
    private o f2494d;

    /* renamed from: e, reason: collision with root package name */
    private final float f2495e;

    public d1(e0 e0Var) {
        this.f2491a = e0Var;
        this.f2495e = e0Var.a();
    }

    @Override // androidx.compose.animation.core.x0
    public float a() {
        return this.f2495e;
    }

    @Override // androidx.compose.animation.core.x0
    public o b(long j11, o oVar, o oVar2) {
        if (this.f2493c == null) {
            this.f2493c = p.g(oVar);
        }
        o oVar3 = this.f2493c;
        if (oVar3 == null) {
            Intrinsics.z("velocityVector");
            oVar3 = null;
        }
        int b11 = oVar3.b();
        for (int i11 = 0; i11 < b11; i11++) {
            o oVar4 = this.f2493c;
            if (oVar4 == null) {
                Intrinsics.z("velocityVector");
                oVar4 = null;
            }
            oVar4.e(i11, this.f2491a.b(j11, oVar.a(i11), oVar2.a(i11)));
        }
        o oVar5 = this.f2493c;
        if (oVar5 != null) {
            return oVar5;
        }
        Intrinsics.z("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.x0
    public long c(o oVar, o oVar2) {
        if (this.f2493c == null) {
            this.f2493c = p.g(oVar);
        }
        o oVar3 = this.f2493c;
        if (oVar3 == null) {
            Intrinsics.z("velocityVector");
            oVar3 = null;
        }
        int b11 = oVar3.b();
        long j11 = 0;
        for (int i11 = 0; i11 < b11; i11++) {
            j11 = Math.max(j11, this.f2491a.c(oVar.a(i11), oVar2.a(i11)));
        }
        return j11;
    }

    @Override // androidx.compose.animation.core.x0
    public o d(o oVar, o oVar2) {
        if (this.f2494d == null) {
            this.f2494d = p.g(oVar);
        }
        o oVar3 = this.f2494d;
        if (oVar3 == null) {
            Intrinsics.z("targetVector");
            oVar3 = null;
        }
        int b11 = oVar3.b();
        for (int i11 = 0; i11 < b11; i11++) {
            o oVar4 = this.f2494d;
            if (oVar4 == null) {
                Intrinsics.z("targetVector");
                oVar4 = null;
            }
            oVar4.e(i11, this.f2491a.d(oVar.a(i11), oVar2.a(i11)));
        }
        o oVar5 = this.f2494d;
        if (oVar5 != null) {
            return oVar5;
        }
        Intrinsics.z("targetVector");
        return null;
    }

    @Override // androidx.compose.animation.core.x0
    public o e(long j11, o oVar, o oVar2) {
        if (this.f2492b == null) {
            this.f2492b = p.g(oVar);
        }
        o oVar3 = this.f2492b;
        if (oVar3 == null) {
            Intrinsics.z("valueVector");
            oVar3 = null;
        }
        int b11 = oVar3.b();
        for (int i11 = 0; i11 < b11; i11++) {
            o oVar4 = this.f2492b;
            if (oVar4 == null) {
                Intrinsics.z("valueVector");
                oVar4 = null;
            }
            oVar4.e(i11, this.f2491a.e(j11, oVar.a(i11), oVar2.a(i11)));
        }
        o oVar5 = this.f2492b;
        if (oVar5 != null) {
            return oVar5;
        }
        Intrinsics.z("valueVector");
        return null;
    }
}
