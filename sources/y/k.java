package y;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: i, reason: collision with root package name */
    public static final a f78604i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static final k f78605j = l.c(0.0f, 0.0f, 0.0f, 0.0f, y.a.f78587a.a());

    /* renamed from: a, reason: collision with root package name */
    private final float f78606a;

    /* renamed from: b, reason: collision with root package name */
    private final float f78607b;

    /* renamed from: c, reason: collision with root package name */
    private final float f78608c;

    /* renamed from: d, reason: collision with root package name */
    private final float f78609d;

    /* renamed from: e, reason: collision with root package name */
    private final long f78610e;

    /* renamed from: f, reason: collision with root package name */
    private final long f78611f;

    /* renamed from: g, reason: collision with root package name */
    private final long f78612g;

    /* renamed from: h, reason: collision with root package name */
    private final long f78613h;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private k(float f11, float f12, float f13, float f14, long j11, long j12, long j13, long j14) {
        this.f78606a = f11;
        this.f78607b = f12;
        this.f78608c = f13;
        this.f78609d = f14;
        this.f78610e = j11;
        this.f78611f = j12;
        this.f78612g = j13;
        this.f78613h = j14;
    }

    public /* synthetic */ k(float f11, float f12, float f13, float f14, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, j11, j12, j13, j14);
    }

    public final float a() {
        return this.f78609d;
    }

    public final long b() {
        return this.f78613h;
    }

    public final long c() {
        return this.f78612g;
    }

    public final float d() {
        return this.f78609d - this.f78607b;
    }

    public final float e() {
        return this.f78606a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Float.compare(this.f78606a, kVar.f78606a) == 0 && Float.compare(this.f78607b, kVar.f78607b) == 0 && Float.compare(this.f78608c, kVar.f78608c) == 0 && Float.compare(this.f78609d, kVar.f78609d) == 0 && y.a.c(this.f78610e, kVar.f78610e) && y.a.c(this.f78611f, kVar.f78611f) && y.a.c(this.f78612g, kVar.f78612g) && y.a.c(this.f78613h, kVar.f78613h);
    }

    public final float f() {
        return this.f78608c;
    }

    public final float g() {
        return this.f78607b;
    }

    public final long h() {
        return this.f78610e;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.f78606a) * 31) + Float.floatToIntBits(this.f78607b)) * 31) + Float.floatToIntBits(this.f78608c)) * 31) + Float.floatToIntBits(this.f78609d)) * 31) + y.a.f(this.f78610e)) * 31) + y.a.f(this.f78611f)) * 31) + y.a.f(this.f78612g)) * 31) + y.a.f(this.f78613h);
    }

    public final long i() {
        return this.f78611f;
    }

    public final float j() {
        return this.f78608c - this.f78606a;
    }

    public String toString() {
        long j11 = this.f78610e;
        long j12 = this.f78611f;
        long j13 = this.f78612g;
        long j14 = this.f78613h;
        String str = c.a(this.f78606a, 1) + ", " + c.a(this.f78607b, 1) + ", " + c.a(this.f78608c, 1) + ", " + c.a(this.f78609d, 1);
        if (!y.a.c(j11, j12) || !y.a.c(j12, j13) || !y.a.c(j13, j14)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) y.a.g(j11)) + ", topRight=" + ((Object) y.a.g(j12)) + ", bottomRight=" + ((Object) y.a.g(j13)) + ", bottomLeft=" + ((Object) y.a.g(j14)) + ')';
        }
        if (y.a.d(j11) == y.a.e(j11)) {
            return "RoundRect(rect=" + str + ", radius=" + c.a(y.a.d(j11), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + c.a(y.a.d(j11), 1) + ", y=" + c.a(y.a.e(j11), 1) + ')';
    }
}
