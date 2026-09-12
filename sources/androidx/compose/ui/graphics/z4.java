package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class z4 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4996d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final z4 f4997e = new z4(0, 0, 0.0f, 7, null);

    /* renamed from: a, reason: collision with root package name */
    private final long f4998a;

    /* renamed from: b, reason: collision with root package name */
    private final long f4999b;

    /* renamed from: c, reason: collision with root package name */
    private final float f5000c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final z4 a() {
            return z4.f4997e;
        }
    }

    private z4(long j11, long j12, float f11) {
        this.f4998a = j11;
        this.f4999b = j12;
        this.f5000c = f11;
    }

    public /* synthetic */ z4(long j11, long j12, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? w1.d(4278190080L) : j11, (i11 & 2) != 0 ? y.g.f78593b.c() : j12, (i11 & 4) != 0 ? 0.0f : f11, null);
    }

    public /* synthetic */ z4(long j11, long j12, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, f11);
    }

    public final float b() {
        return this.f5000c;
    }

    public final long c() {
        return this.f4998a;
    }

    public final long d() {
        return this.f4999b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z4)) {
            return false;
        }
        z4 z4Var = (z4) obj;
        return u1.m(this.f4998a, z4Var.f4998a) && y.g.j(this.f4999b, z4Var.f4999b) && this.f5000c == z4Var.f5000c;
    }

    public int hashCode() {
        return (((u1.s(this.f4998a) * 31) + y.g.o(this.f4999b)) * 31) + Float.floatToIntBits(this.f5000c);
    }

    public String toString() {
        return "Shadow(color=" + ((Object) u1.t(this.f4998a)) + ", offset=" + ((Object) y.g.t(this.f4999b)) + ", blurRadius=" + this.f5000c + ')';
    }
}
