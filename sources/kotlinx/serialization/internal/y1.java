package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class y1 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private short[] f68340a;

    /* renamed from: b, reason: collision with root package name */
    private int f68341b;

    public y1(short[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.f68340a = bufferWithData;
        this.f68341b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        short[] sArr = this.f68340a;
        if (sArr.length < i11) {
            short[] copyOf = Arrays.copyOf(sArr, RangesKt.f(i11, sArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68340a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68341b;
    }

    public final void e(short s11) {
        p1.c(this, 0, 1, null);
        short[] sArr = this.f68340a;
        int d11 = d();
        this.f68341b = d11 + 1;
        sArr[d11] = s11;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] copyOf = Arrays.copyOf(this.f68340a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
