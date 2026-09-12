package androidx.compose.ui.semantics;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f6034d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final e f6035e = new e(0.0f, RangesKt.b(0.0f, 0.0f), 0, 4, null);

    /* renamed from: a, reason: collision with root package name */
    private final float f6036a;

    /* renamed from: b, reason: collision with root package name */
    private final ClosedFloatingPointRange f6037b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6038c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return e.f6035e;
        }
    }

    public e(float f11, ClosedFloatingPointRange closedFloatingPointRange, int i11) {
        this.f6036a = f11;
        this.f6037b = closedFloatingPointRange;
        this.f6038c = i11;
        if (Float.isNaN(f11)) {
            throw new IllegalArgumentException("current must not be NaN");
        }
    }

    public /* synthetic */ e(float f11, ClosedFloatingPointRange closedFloatingPointRange, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, closedFloatingPointRange, (i12 & 4) != 0 ? 0 : i11);
    }

    public final float b() {
        return this.f6036a;
    }

    public final ClosedFloatingPointRange c() {
        return this.f6037b;
    }

    public final int d() {
        return this.f6038c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f6036a == eVar.f6036a && Intrinsics.c(this.f6037b, eVar.f6037b) && this.f6038c == eVar.f6038c;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f6036a) * 31) + this.f6037b.hashCode()) * 31) + this.f6038c;
    }

    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.f6036a + ", range=" + this.f6037b + ", steps=" + this.f6038c + ')';
    }
}
