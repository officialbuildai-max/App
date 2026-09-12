package ab;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private final float f544a;

    public c(float f11) {
        this.f544a = f11;
    }

    public static c b(a aVar) {
        return new c(aVar.b());
    }

    private static float c(RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // ab.d
    public float a(RectF rectF) {
        return Math.min(this.f544a, c(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f544a == ((c) obj).f544a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f544a)});
    }
}
