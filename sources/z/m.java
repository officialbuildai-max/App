package z;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.p4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class m extends h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f79238e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final int f79239f = c5.f4393a.a();

    /* renamed from: g, reason: collision with root package name */
    private static final int f79240g = d5.f4505a.b();

    /* renamed from: a, reason: collision with root package name */
    private final float f79241a;

    /* renamed from: b, reason: collision with root package name */
    private final float f79242b;

    /* renamed from: c, reason: collision with root package name */
    private final int f79243c;

    /* renamed from: d, reason: collision with root package name */
    private final int f79244d;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return m.f79239f;
        }
    }

    private m(float f11, float f12, int i11, int i12, p4 p4Var) {
        super(null);
        this.f79241a = f11;
        this.f79242b = f12;
        this.f79243c = i11;
        this.f79244d = i12;
    }

    public /* synthetic */ m(float f11, float f12, int i11, int i12, p4 p4Var, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0.0f : f11, (i13 & 2) != 0 ? 4.0f : f12, (i13 & 4) != 0 ? f79239f : i11, (i13 & 8) != 0 ? f79240g : i12, (i13 & 16) != 0 ? null : p4Var, null);
    }

    public /* synthetic */ m(float f11, float f12, int i11, int i12, p4 p4Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, i11, i12, p4Var);
    }

    public final int b() {
        return this.f79243c;
    }

    public final int c() {
        return this.f79244d;
    }

    public final float d() {
        return this.f79242b;
    }

    public final p4 e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f79241a != mVar.f79241a || this.f79242b != mVar.f79242b || !c5.e(this.f79243c, mVar.f79243c) || !d5.e(this.f79244d, mVar.f79244d)) {
            return false;
        }
        mVar.getClass();
        return Intrinsics.c(null, null);
    }

    public final float f() {
        return this.f79241a;
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.f79241a) * 31) + Float.floatToIntBits(this.f79242b)) * 31) + c5.f(this.f79243c)) * 31) + d5.f(this.f79244d)) * 31;
    }

    public String toString() {
        return "Stroke(width=" + this.f79241a + ", miter=" + this.f79242b + ", cap=" + ((Object) c5.g(this.f79243c)) + ", join=" + ((Object) d5.g(this.f79244d)) + ", pathEffect=" + ((Object) null) + ')';
    }
}
