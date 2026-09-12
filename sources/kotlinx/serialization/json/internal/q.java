package kotlinx.serialization.json.internal;

import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class q extends j {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f68463c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(h0 writer, boolean z10) {
        super(writer);
        Intrinsics.h(writer, "writer");
        this.f68463c = z10;
    }

    @Override // kotlinx.serialization.json.internal.j
    public void d(byte b11) {
        boolean z10 = this.f68463c;
        String f11 = UByte.f(UByte.b(b11));
        if (z10) {
            m(f11);
        } else {
            j(f11);
        }
    }

    @Override // kotlinx.serialization.json.internal.j
    public void h(int i11) {
        boolean z10 = this.f68463c;
        int b11 = UInt.b(i11);
        if (z10) {
            m(m.a(b11));
        } else {
            j(n.a(b11));
        }
    }

    @Override // kotlinx.serialization.json.internal.j
    public void i(long j11) {
        String a11;
        String a12;
        boolean z10 = this.f68463c;
        long b11 = ULong.b(j11);
        if (z10) {
            a12 = o.a(b11, 10);
            m(a12);
        } else {
            a11 = p.a(b11, 10);
            j(a11);
        }
    }

    @Override // kotlinx.serialization.json.internal.j
    public void k(short s11) {
        boolean z10 = this.f68463c;
        String f11 = UShort.f(UShort.b(s11));
        if (z10) {
            m(f11);
        } else {
            j(f11);
        }
    }
}
