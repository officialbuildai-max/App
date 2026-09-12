package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UShortArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class n2 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private short[] f68296a;

    /* renamed from: b, reason: collision with root package name */
    private int f68297b;

    private n2(short[] sArr) {
        this.f68296a = sArr;
        this.f68297b = UShortArray.o(sArr);
        b(10);
    }

    public /* synthetic */ n2(short[] sArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(sArr);
    }

    @Override // kotlinx.serialization.internal.p1
    public /* bridge */ /* synthetic */ Object a() {
        return UShortArray.a(f());
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        if (UShortArray.o(this.f68296a) < i11) {
            short[] sArr = this.f68296a;
            short[] copyOf = Arrays.copyOf(sArr, RangesKt.f(i11, UShortArray.o(sArr) * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68296a = UShortArray.e(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68297b;
    }

    public final void e(short s11) {
        p1.c(this, 0, 1, null);
        short[] sArr = this.f68296a;
        int d11 = d();
        this.f68297b = d11 + 1;
        UShortArray.s(sArr, d11, s11);
    }

    public short[] f() {
        short[] copyOf = Arrays.copyOf(this.f68296a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return UShortArray.e(copyOf);
    }
}
