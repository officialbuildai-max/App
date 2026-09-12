package xf;

import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public final class d extends c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f78382a;

    /* renamed from: b, reason: collision with root package name */
    private final int f78383b;

    /* renamed from: c, reason: collision with root package name */
    private final int f78384c;

    /* renamed from: d, reason: collision with root package name */
    private final ByteOrder f78385d;

    /* renamed from: e, reason: collision with root package name */
    private int f78386e;

    d(byte[] bArr, int i11, int i12, ByteOrder byteOrder) {
        this.f78382a = bArr;
        this.f78383b = i11;
        this.f78384c = i12;
        this.f78385d = byteOrder;
    }

    public static c e(byte[] bArr, int i11, int i12, ByteOrder byteOrder) {
        return new d(bArr, i11, i12, byteOrder);
    }

    @Override // xf.c
    public int a() {
        int a11 = e.a(this.f78382a, this.f78383b + this.f78386e, this.f78385d);
        this.f78386e += 4;
        return a11;
    }

    @Override // xf.c
    public short b() {
        short b11 = e.b(this.f78382a, this.f78383b + this.f78386e, this.f78385d);
        this.f78386e += 2;
        return b11;
    }

    @Override // xf.c
    public void c(int i11) {
        this.f78386e = i11;
    }

    @Override // xf.c
    public void d(int i11) {
        this.f78386e += i11;
    }
}
