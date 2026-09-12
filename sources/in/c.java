package in;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f65394a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f65395b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.c.<init>():void");
    }

    public c(boolean z10, boolean z11) {
        this.f65394a = z10;
        this.f65395b = z11;
    }

    public /* synthetic */ c(boolean z10, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? false : z11);
    }

    public final boolean a() {
        return this.f65394a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f65394a == cVar.f65394a && this.f65395b == cVar.f65395b;
    }

    public int hashCode() {
        return (e.a(this.f65394a) * 31) + e.a(this.f65395b);
    }

    public String toString() {
        return "LocalParam(isSubMoreTipBean=" + this.f65394a + ", isSubMoreLoading=" + this.f65395b + ")";
    }
}
