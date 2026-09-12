package ab;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class l implements d {

    /* renamed from: a, reason: collision with root package name */
    private final float f599a;

    public l(float f11) {
        this.f599a = f11;
    }

    private static float b(RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // ab.d
    public float a(RectF rectF) {
        return this.f599a * b(rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.f599a == ((l) obj).f599a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f599a)});
    }
}
