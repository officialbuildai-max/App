package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class r0 implements g {

    /* renamed from: a, reason: collision with root package name */
    private final int f2565a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2566b;

    /* renamed from: c, reason: collision with root package name */
    private final z f2567c;

    public r0() {
        this(0, 0, null, 7, null);
    }

    public r0(int i11, int i12, z zVar) {
        this.f2565a = i11;
        this.f2566b = i12;
        this.f2567c = zVar;
    }

    public /* synthetic */ r0(int i11, int i12, z zVar, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 300 : i11, (i13 & 2) != 0 ? 0 : i12, (i13 & 4) != 0 ? b0.c() : zVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return r0Var.f2565a == this.f2565a && r0Var.f2566b == this.f2566b && Intrinsics.c(r0Var.f2567c, this.f2567c);
    }

    @Override // androidx.compose.animation.core.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public f1 a(s0 s0Var) {
        return new f1(this.f2565a, this.f2566b, this.f2567c);
    }

    public int hashCode() {
        return (((this.f2565a * 31) + this.f2567c.hashCode()) * 31) + this.f2566b;
    }
}
