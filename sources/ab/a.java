package ab;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final float f541a;

    public a(float f11) {
        this.f541a = f11;
    }

    @Override // ab.d
    public float a(RectF rectF) {
        return this.f541a;
    }

    public float b() {
        return this.f541a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f541a == ((a) obj).f541a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f541a)});
    }
}
