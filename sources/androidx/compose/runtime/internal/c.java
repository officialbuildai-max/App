package androidx.compose.runtime.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private int f3838a;

    public c() {
        this(0, 1, null);
    }

    public c(int i11) {
        this.f3838a = i11;
    }

    public /* synthetic */ c(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public final int a() {
        return this.f3838a;
    }

    public final void b(int i11) {
        this.f3838a = i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("IntRef(element = ");
        sb2.append(this.f3838a);
        sb2.append(")@");
        String num = Integer.toString(hashCode(), CharsKt.a(16));
        Intrinsics.g(num, "toString(this, checkRadix(radix))");
        sb2.append(num);
        return sb2.toString();
    }
}
