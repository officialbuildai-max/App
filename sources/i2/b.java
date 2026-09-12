package i2;

import i3.j;
import i3.k;
import i3.s;

/* loaded from: classes2.dex */
final class b extends j {

    /* renamed from: p, reason: collision with root package name */
    private final s f65004p;

    public b(String str, s sVar) {
        super(str);
        this.f65004p = sVar;
    }

    @Override // i3.j
    protected k y(byte[] bArr, int i11, boolean z10) {
        if (z10) {
            this.f65004p.reset();
        }
        return this.f65004p.b(bArr, 0, i11);
    }
}
