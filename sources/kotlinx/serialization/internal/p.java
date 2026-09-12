package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class p extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private char[] f68302a;

    /* renamed from: b, reason: collision with root package name */
    private int f68303b;

    public p(char[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.f68302a = bufferWithData;
        this.f68303b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        char[] cArr = this.f68302a;
        if (cArr.length < i11) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.f(i11, cArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68302a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68303b;
    }

    public final void e(char c11) {
        p1.c(this, 0, 1, null);
        char[] cArr = this.f68302a;
        int d11 = d();
        this.f68303b = d11 + 1;
        cArr[d11] = c11;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] copyOf = Arrays.copyOf(this.f68302a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
