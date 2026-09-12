package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UByteArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public final class e2 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f68255a;

    /* renamed from: b, reason: collision with root package name */
    private int f68256b;

    private e2(byte[] bArr) {
        this.f68255a = bArr;
        this.f68256b = UByteArray.o(bArr);
        b(10);
    }

    public /* synthetic */ e2(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    @Override // kotlinx.serialization.internal.p1
    public /* bridge */ /* synthetic */ Object a() {
        return UByteArray.a(f());
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i11) {
        if (UByteArray.o(this.f68255a) < i11) {
            byte[] bArr = this.f68255a;
            byte[] copyOf = Arrays.copyOf(bArr, RangesKt.f(i11, UByteArray.o(bArr) * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f68255a = UByteArray.e(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.f68256b;
    }

    public final void e(byte b11) {
        p1.c(this, 0, 1, null);
        byte[] bArr = this.f68255a;
        int d11 = d();
        this.f68256b = d11 + 1;
        UByteArray.s(bArr, d11, b11);
    }

    public byte[] f() {
        byte[] copyOf = Arrays.copyOf(this.f68255a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return UByteArray.e(copyOf);
    }
}
