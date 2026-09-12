package androidx.media3.common;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f10049a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10050b;

    public f(int i11, float f11) {
        this.f10049a = i11;
        this.f10050b = f11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f10049a == fVar.f10049a && Float.compare(fVar.f10050b, this.f10050b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f10049a) * 31) + Float.floatToIntBits(this.f10050b);
    }
}
