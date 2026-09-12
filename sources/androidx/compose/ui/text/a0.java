package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final x f6154a;

    /* renamed from: b, reason: collision with root package name */
    private final x f6155b;

    /* renamed from: c, reason: collision with root package name */
    private final x f6156c;

    /* renamed from: d, reason: collision with root package name */
    private final x f6157d;

    public a0() {
        this(null, null, null, null, 15, null);
    }

    public a0(x xVar, x xVar2, x xVar3, x xVar4) {
        this.f6154a = xVar;
        this.f6155b = xVar2;
        this.f6156c = xVar3;
        this.f6157d = xVar4;
    }

    public /* synthetic */ a0(x xVar, x xVar2, x xVar3, x xVar4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : xVar, (i11 & 2) != 0 ? null : xVar2, (i11 & 4) != 0 ? null : xVar3, (i11 & 8) != 0 ? null : xVar4);
    }

    public final x a() {
        return this.f6155b;
    }

    public final x b() {
        return this.f6156c;
    }

    public final x c() {
        return this.f6157d;
    }

    public final x d() {
        return this.f6154a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.c(this.f6154a, a0Var.f6154a) && Intrinsics.c(this.f6155b, a0Var.f6155b) && Intrinsics.c(this.f6156c, a0Var.f6156c) && Intrinsics.c(this.f6157d, a0Var.f6157d);
    }

    public int hashCode() {
        x xVar = this.f6154a;
        int hashCode = (xVar != null ? xVar.hashCode() : 0) * 31;
        x xVar2 = this.f6155b;
        int hashCode2 = (hashCode + (xVar2 != null ? xVar2.hashCode() : 0)) * 31;
        x xVar3 = this.f6156c;
        int hashCode3 = (hashCode2 + (xVar3 != null ? xVar3.hashCode() : 0)) * 31;
        x xVar4 = this.f6157d;
        return hashCode3 + (xVar4 != null ? xVar4.hashCode() : 0);
    }
}
