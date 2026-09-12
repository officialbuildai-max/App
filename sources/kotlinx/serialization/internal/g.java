package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class g extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private boolean[] f68261a;

    /* renamed from: b, reason: collision with root package name */
    private int f68262b;

    public g(boolean[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.f68261a = bufferWithData;
        this.f68262b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        boolean[] zArr = this.f68261a;
        if (zArr.length < i11) {
            boolean[] copyOf = Arrays.copyOf(zArr, RangesKt.f(i11, zArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68261a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68262b;
    }

    public final void e(boolean z10) {
        p1.c(this, 0, 1, null);
        boolean[] zArr = this.f68261a;
        int d11 = d();
        this.f68262b = d11 + 1;
        zArr[d11] = z10;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] copyOf = Arrays.copyOf(this.f68261a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
