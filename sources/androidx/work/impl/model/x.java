package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final String f15953a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15954b;

    public x(String workSpecId, int i11) {
        Intrinsics.h(workSpecId, "workSpecId");
        this.f15953a = workSpecId;
        this.f15954b = i11;
    }

    public final int a() {
        return this.f15954b;
    }

    public final String b() {
        return this.f15953a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Intrinsics.c(this.f15953a, xVar.f15953a) && this.f15954b == xVar.f15954b;
    }

    public int hashCode() {
        return (this.f15953a.hashCode() * 31) + this.f15954b;
    }

    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.f15953a + ", generation=" + this.f15954b + ')';
    }
}
