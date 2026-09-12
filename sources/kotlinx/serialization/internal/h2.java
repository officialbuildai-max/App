package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UIntArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class h2 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private int[] f68273a;

    /* renamed from: b, reason: collision with root package name */
    private int f68274b;

    private h2(int[] iArr) {
        this.f68273a = iArr;
        this.f68274b = UIntArray.o(iArr);
        b(10);
    }

    public /* synthetic */ h2(int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr);
    }

    @Override // kotlinx.serialization.internal.p1
    public /* bridge */ /* synthetic */ Object a() {
        return UIntArray.a(f());
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        if (UIntArray.o(this.f68273a) < i11) {
            int[] iArr = this.f68273a;
            int[] copyOf = Arrays.copyOf(iArr, RangesKt.f(i11, UIntArray.o(iArr) * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68273a = UIntArray.e(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68274b;
    }

    public final void e(int i11) {
        p1.c(this, 0, 1, null);
        int[] iArr = this.f68273a;
        int d11 = d();
        this.f68274b = d11 + 1;
        UIntArray.s(iArr, d11, i11);
    }

    public int[] f() {
        int[] copyOf = Arrays.copyOf(this.f68273a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return UIntArray.e(copyOf);
    }
}
