package y;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static final a f78598e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final i f78599f = new i(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    private final float f78600a;

    /* renamed from: b, reason: collision with root package name */
    private final float f78601b;

    /* renamed from: c, reason: collision with root package name */
    private final float f78602c;

    /* renamed from: d, reason: collision with root package name */
    private final float f78603d;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a() {
            return i.f78599f;
        }
    }

    public i(float f11, float f12, float f13, float f14) {
        this.f78600a = f11;
        this.f78601b = f12;
        this.f78602c = f13;
        this.f78603d = f14;
    }

    public final boolean b(long j11) {
        return g.m(j11) >= this.f78600a && g.m(j11) < this.f78602c && g.n(j11) >= this.f78601b && g.n(j11) < this.f78603d;
    }

    public final float c() {
        return this.f78603d;
    }

    public final long d() {
        return h.a(this.f78600a + (k() / 2.0f), this.f78601b + (e() / 2.0f));
    }

    public final float e() {
        return this.f78603d - this.f78601b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Float.compare(this.f78600a, iVar.f78600a) == 0 && Float.compare(this.f78601b, iVar.f78601b) == 0 && Float.compare(this.f78602c, iVar.f78602c) == 0 && Float.compare(this.f78603d, iVar.f78603d) == 0;
    }

    public final float f() {
        return this.f78600a;
    }

    public final float g() {
        return this.f78602c;
    }

    public final long h() {
        return n.a(k(), e());
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f78600a) * 31) + Float.floatToIntBits(this.f78601b)) * 31) + Float.floatToIntBits(this.f78602c)) * 31) + Float.floatToIntBits(this.f78603d);
    }

    public final float i() {
        return this.f78601b;
    }

    public final long j() {
        return h.a(this.f78600a, this.f78601b);
    }

    public final float k() {
        return this.f78602c - this.f78600a;
    }

    public final i l(float f11, float f12, float f13, float f14) {
        return new i(Math.max(this.f78600a, f11), Math.max(this.f78601b, f12), Math.min(this.f78602c, f13), Math.min(this.f78603d, f14));
    }

    public final i m(i iVar) {
        return new i(Math.max(this.f78600a, iVar.f78600a), Math.max(this.f78601b, iVar.f78601b), Math.min(this.f78602c, iVar.f78602c), Math.min(this.f78603d, iVar.f78603d));
    }

    public final boolean n() {
        return this.f78600a >= this.f78602c || this.f78601b >= this.f78603d;
    }

    public final boolean o(i iVar) {
        return this.f78602c > iVar.f78600a && iVar.f78602c > this.f78600a && this.f78603d > iVar.f78601b && iVar.f78603d > this.f78601b;
    }

    public final i p(float f11, float f12) {
        return new i(this.f78600a + f11, this.f78601b + f12, this.f78602c + f11, this.f78603d + f12);
    }

    public final i q(long j11) {
        return new i(this.f78600a + g.m(j11), this.f78601b + g.n(j11), this.f78602c + g.m(j11), this.f78603d + g.n(j11));
    }

    public String toString() {
        return "Rect.fromLTRB(" + c.a(this.f78600a, 1) + ", " + c.a(this.f78601b, 1) + ", " + c.a(this.f78602c, 1) + ", " + c.a(this.f78603d, 1) + ')';
    }
}
