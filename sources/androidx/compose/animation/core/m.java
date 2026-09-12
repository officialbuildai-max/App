package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class m extends o {

    /* renamed from: a, reason: collision with root package name */
    private float f2536a;

    /* renamed from: b, reason: collision with root package name */
    private float f2537b;

    /* renamed from: c, reason: collision with root package name */
    private float f2538c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2539d;

    public m(float f11, float f12, float f13) {
        super(null);
        this.f2536a = f11;
        this.f2537b = f12;
        this.f2538c = f13;
        this.f2539d = 3;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i11) {
        if (i11 == 0) {
            return this.f2536a;
        }
        if (i11 == 1) {
            return this.f2537b;
        }
        if (i11 != 2) {
            return 0.0f;
        }
        return this.f2538c;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f2539d;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f2536a = 0.0f;
        this.f2537b = 0.0f;
        this.f2538c = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i11, float f11) {
        if (i11 == 0) {
            this.f2536a = f11;
        } else if (i11 == 1) {
            this.f2537b = f11;
        } else {
            if (i11 != 2) {
                return;
            }
            this.f2538c = f11;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (mVar.f2536a == this.f2536a && mVar.f2537b == this.f2537b && mVar.f2538c == this.f2538c) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.animation.core.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public m c() {
        return new m(0.0f, 0.0f, 0.0f);
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f2536a) * 31) + Float.floatToIntBits(this.f2537b)) * 31) + Float.floatToIntBits(this.f2538c);
    }

    public String toString() {
        return "AnimationVector3D: v1 = " + this.f2536a + ", v2 = " + this.f2537b + ", v3 = " + this.f2538c;
    }
}
