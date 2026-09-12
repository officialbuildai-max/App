package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class n extends o {

    /* renamed from: a, reason: collision with root package name */
    private float f2547a;

    /* renamed from: b, reason: collision with root package name */
    private float f2548b;

    /* renamed from: c, reason: collision with root package name */
    private float f2549c;

    /* renamed from: d, reason: collision with root package name */
    private float f2550d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2551e;

    public n(float f11, float f12, float f13, float f14) {
        super(null);
        this.f2547a = f11;
        this.f2548b = f12;
        this.f2549c = f13;
        this.f2550d = f14;
        this.f2551e = 4;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i11) {
        if (i11 == 0) {
            return this.f2547a;
        }
        if (i11 == 1) {
            return this.f2548b;
        }
        if (i11 == 2) {
            return this.f2549c;
        }
        if (i11 != 3) {
            return 0.0f;
        }
        return this.f2550d;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f2551e;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f2547a = 0.0f;
        this.f2548b = 0.0f;
        this.f2549c = 0.0f;
        this.f2550d = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i11, float f11) {
        if (i11 == 0) {
            this.f2547a = f11;
            return;
        }
        if (i11 == 1) {
            this.f2548b = f11;
        } else if (i11 == 2) {
            this.f2549c = f11;
        } else {
            if (i11 != 3) {
                return;
            }
            this.f2550d = f11;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (nVar.f2547a == this.f2547a && nVar.f2548b == this.f2548b && nVar.f2549c == this.f2549c && nVar.f2550d == this.f2550d) {
                return true;
            }
        }
        return false;
    }

    public final float f() {
        return this.f2547a;
    }

    public final float g() {
        return this.f2548b;
    }

    public final float h() {
        return this.f2549c;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f2547a) * 31) + Float.floatToIntBits(this.f2548b)) * 31) + Float.floatToIntBits(this.f2549c)) * 31) + Float.floatToIntBits(this.f2550d);
    }

    public final float i() {
        return this.f2550d;
    }

    @Override // androidx.compose.animation.core.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public n c() {
        return new n(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "AnimationVector4D: v1 = " + this.f2547a + ", v2 = " + this.f2548b + ", v3 = " + this.f2549c + ", v4 = " + this.f2550d;
    }
}
