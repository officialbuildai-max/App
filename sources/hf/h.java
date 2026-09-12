package hf;

import java.io.EOFException;

/* loaded from: classes5.dex */
public final class h extends a {

    /* renamed from: c, reason: collision with root package name */
    private final short[] f64579c;

    public h(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.f64579c = sArr;
    }

    public boolean f() {
        return c() < this.f64579c.length;
    }

    public int g() {
        try {
            short s11 = this.f64579c[c()];
            a(1);
            return s11 & 65535;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new EOFException();
        }
    }

    public int h() {
        return g() | (g() << 16);
    }

    public long i() {
        return g() | (g() << 16) | (g() << 32) | (g() << 48);
    }
}
