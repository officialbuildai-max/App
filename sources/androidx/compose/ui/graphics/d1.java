package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class d1 extends v1 {

    /* renamed from: c, reason: collision with root package name */
    private final long f4502c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4503d;

    private d1(long j11, int i11) {
        this(j11, i11, i0.a(j11, i11), null);
    }

    private d1(long j11, int i11, ColorFilter colorFilter) {
        super(colorFilter);
        this.f4502c = j11;
        this.f4503d = i11;
    }

    public /* synthetic */ d1(long j11, int i11, ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, i11, colorFilter);
    }

    public /* synthetic */ d1(long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, i11);
    }

    public final int b() {
        return this.f4503d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return u1.m(this.f4502c, d1Var.f4502c) && c1.E(this.f4503d, d1Var.f4503d);
    }

    public int hashCode() {
        return (u1.s(this.f4502c) * 31) + c1.F(this.f4503d);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + ((Object) u1.t(this.f4502c)) + ", blendMode=" + ((Object) c1.G(this.f4503d)) + ')';
    }
}
