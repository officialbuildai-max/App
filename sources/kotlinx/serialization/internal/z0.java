package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class z0 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private long[] f68344a;

    /* renamed from: b, reason: collision with root package name */
    private int f68345b;

    public z0(long[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.f68344a = bufferWithData;
        this.f68345b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        long[] jArr = this.f68344a;
        if (jArr.length < i11) {
            long[] copyOf = Arrays.copyOf(jArr, RangesKt.f(i11, jArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68344a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68345b;
    }

    public final void e(long j11) {
        p1.c(this, 0, 1, null);
        long[] jArr = this.f68344a;
        int d11 = d();
        this.f68345b = d11 + 1;
        jArr[d11] = j11;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public long[] a() {
        long[] copyOf = Arrays.copyOf(this.f68344a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
