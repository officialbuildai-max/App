package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class a0 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private double[] f68227a;

    /* renamed from: b, reason: collision with root package name */
    private int f68228b;

    public a0(double[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.f68227a = bufferWithData;
        this.f68228b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        double[] dArr = this.f68227a;
        if (dArr.length < i11) {
            double[] copyOf = Arrays.copyOf(dArr, RangesKt.f(i11, dArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68227a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68228b;
    }

    public final void e(double d11) {
        p1.c(this, 0, 1, null);
        double[] dArr = this.f68227a;
        int d12 = d();
        this.f68228b = d12 + 1;
        dArr[d12] = d11;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] copyOf = Arrays.copyOf(this.f68227a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
