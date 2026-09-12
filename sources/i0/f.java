package i0;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.collection.e0;
import kotlin.Unit;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final e0 f64979a = new e0(0, 1, null);

    public final void a() {
        synchronized (this) {
            this.f64979a.i();
            Unit unit = Unit.f67184a;
        }
    }

    public final TypedValue b(Resources resources, int i11) {
        TypedValue typedValue;
        synchronized (this) {
            typedValue = (TypedValue) this.f64979a.c(i11);
            if (typedValue == null) {
                typedValue = new TypedValue();
                resources.getValue(i11, typedValue, true);
                this.f64979a.p(i11, typedValue);
            }
        }
        return typedValue;
    }
}
