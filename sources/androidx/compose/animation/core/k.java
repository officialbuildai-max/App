package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class k extends o {

    /* renamed from: a, reason: collision with root package name */
    private float f2531a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2532b;

    public k(float f11) {
        super(null);
        this.f2531a = f11;
        this.f2532b = 1;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i11) {
        if (i11 == 0) {
            return this.f2531a;
        }
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f2532b;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f2531a = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i11, float f11) {
        if (i11 == 0) {
            this.f2531a = f11;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && ((k) obj).f2531a == this.f2531a;
    }

    public final float f() {
        return this.f2531a;
    }

    @Override // androidx.compose.animation.core.o
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public k c() {
        return new k(0.0f);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f2531a);
    }

    public String toString() {
        return "AnimationVector1D: value = " + this.f2531a;
    }
}
