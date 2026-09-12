package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ULongArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class k2 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private long[] f68285a;

    /* renamed from: b, reason: collision with root package name */
    private int f68286b;

    private k2(long[] jArr) {
        this.f68285a = jArr;
        this.f68286b = ULongArray.o(jArr);
        b(10);
    }

    public /* synthetic */ k2(long[] jArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr);
    }

    @Override // kotlinx.serialization.internal.p1
    public /* bridge */ /* synthetic */ Object a() {
        return ULongArray.a(f());
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        if (ULongArray.o(this.f68285a) < i11) {
            long[] jArr = this.f68285a;
            long[] copyOf = Arrays.copyOf(jArr, RangesKt.f(i11, ULongArray.o(jArr) * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68285a = ULongArray.e(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68286b;
    }

    public final void e(long j11) {
        p1.c(this, 0, 1, null);
        long[] jArr = this.f68285a;
        int d11 = d();
        this.f68286b = d11 + 1;
        ULongArray.s(jArr, d11, j11);
    }

    public long[] f() {
        long[] copyOf = Arrays.copyOf(this.f68285a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return ULongArray.e(copyOf);
    }
}
