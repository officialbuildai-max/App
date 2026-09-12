package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class p0 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private int[] f68304a;

    /* renamed from: b, reason: collision with root package name */
    private int f68305b;

    public p0(int[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.f68304a = bufferWithData;
        this.f68305b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        int[] iArr = this.f68304a;
        if (iArr.length < i11) {
            int[] copyOf = Arrays.copyOf(iArr, RangesKt.f(i11, iArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68304a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68305b;
    }

    public final void e(int i11) {
        p1.c(this, 0, 1, null);
        int[] iArr = this.f68304a;
        int d11 = d();
        this.f68305b = d11 + 1;
        iArr[d11] = i11;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] copyOf = Arrays.copyOf(this.f68304a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
