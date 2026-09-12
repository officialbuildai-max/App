package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class j extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f68279a;

    /* renamed from: b, reason: collision with root package name */
    private int f68280b;

    public j(byte[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.f68279a = bufferWithData;
        this.f68280b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        byte[] bArr = this.f68279a;
        if (bArr.length < i11) {
            byte[] copyOf = Arrays.copyOf(bArr, RangesKt.f(i11, bArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68279a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68280b;
    }

    public final void e(byte b11) {
        p1.c(this, 0, 1, null);
        byte[] bArr = this.f68279a;
        int d11 = d();
        this.f68280b = d11 + 1;
        bArr[d11] = b11;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public byte[] a() {
        byte[] copyOf = Arrays.copyOf(this.f68279a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
