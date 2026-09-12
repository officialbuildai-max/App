package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;
import o0.w;
import o0.x;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6504c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final n f6505d = new n(0, 0, 3, null);

    /* renamed from: a, reason: collision with root package name */
    private final long f6506a;

    /* renamed from: b, reason: collision with root package name */
    private final long f6507b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a() {
            return n.f6505d;
        }
    }

    private n(long j11, long j12) {
        this.f6506a = j11;
        this.f6507b = j12;
    }

    public /* synthetic */ n(long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? x.c(0) : j11, (i11 & 2) != 0 ? x.c(0) : j12, null);
    }

    public /* synthetic */ n(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    public final long b() {
        return this.f6506a;
    }

    public final long c() {
        return this.f6507b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return w.e(this.f6506a, nVar.f6506a) && w.e(this.f6507b, nVar.f6507b);
    }

    public int hashCode() {
        return (w.i(this.f6506a) * 31) + w.i(this.f6507b);
    }

    public String toString() {
        return "TextIndent(firstLine=" + ((Object) w.j(this.f6506a)) + ", restLine=" + ((Object) w.j(this.f6507b)) + ')';
    }
}
