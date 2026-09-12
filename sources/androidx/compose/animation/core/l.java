package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class l extends o {

    /* renamed from: a, reason: collision with root package name */
    private float f2533a;

    /* renamed from: b, reason: collision with root package name */
    private float f2534b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2535c;

    public l(float f11, float f12) {
        super(null);
        this.f2533a = f11;
        this.f2534b = f12;
        this.f2535c = 2;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i11) {
        if (i11 == 0) {
            return this.f2533a;
        }
        if (i11 != 1) {
            return 0.0f;
        }
        return this.f2534b;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f2535c;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f2533a = 0.0f;
        this.f2534b = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i11, float f11) {
        if (i11 == 0) {
            this.f2533a = f11;
        } else {
            if (i11 != 1) {
                return;
            }
            this.f2534b = f11;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (lVar.f2533a == this.f2533a && lVar.f2534b == this.f2534b) {
                return true;
            }
        }
        return false;
    }

    public final float f() {
        return this.f2533a;
    }

    public final float g() {
        return this.f2534b;
    }

    @Override // androidx.compose.animation.core.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public l c() {
        return new l(0.0f, 0.0f);
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f2533a) * 31) + Float.floatToIntBits(this.f2534b);
    }

    public String toString() {
        return "AnimationVector2D: v1 = " + this.f2533a + ", v2 = " + this.f2534b;
    }
}
