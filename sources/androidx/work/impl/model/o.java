package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f15907a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15908b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15909c;

    public o(String workSpecId, int i11, int i12) {
        Intrinsics.h(workSpecId, "workSpecId");
        this.f15907a = workSpecId;
        this.f15908b = i11;
        this.f15909c = i12;
    }

    public final int a() {
        return this.f15908b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return Intrinsics.c(this.f15907a, oVar.f15907a) && this.f15908b == oVar.f15908b && this.f15909c == oVar.f15909c;
    }

    public int hashCode() {
        return (((this.f15907a.hashCode() * 31) + this.f15908b) * 31) + this.f15909c;
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.f15907a + ", generation=" + this.f15908b + ", systemId=" + this.f15909c + ')';
    }
}
