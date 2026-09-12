package ab;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private final d f542a;

    /* renamed from: b, reason: collision with root package name */
    private final float f543b;

    public b(float f11, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f542a;
            f11 += ((b) dVar).f543b;
        }
        this.f542a = dVar;
        this.f543b = f11;
    }

    @Override // ab.d
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f542a.a(rectF) + this.f543b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f542a.equals(bVar.f542a) && this.f543b == bVar.f543b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f542a, Float.valueOf(this.f543b)});
    }
}
