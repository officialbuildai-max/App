package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class f0 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private float[] f68258a;

    /* renamed from: b, reason: collision with root package name */
    private int f68259b;

    public f0(float[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.f68258a = bufferWithData;
        this.f68259b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        float[] fArr = this.f68258a;
        if (fArr.length < i11) {
            float[] copyOf = Arrays.copyOf(fArr, RangesKt.f(i11, fArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68258a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68259b;
    }

    public final void e(float f11) {
        p1.c(this, 0, 1, null);
        float[] fArr = this.f68258a;
        int d11 = d();
        this.f68259b = d11 + 1;
        fArr[d11] = f11;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] copyOf = Arrays.copyOf(this.f68258a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
