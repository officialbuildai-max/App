package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final long f5057a;

    /* renamed from: b, reason: collision with root package name */
    private final long f5058b;

    /* renamed from: c, reason: collision with root package name */
    private long f5059c;

    private e(long j11, long j12) {
        this.f5057a = j11;
        this.f5058b = j12;
        this.f5059c = y.g.f78593b.c();
    }

    private e(long j11, long j12, long j13) {
        this(j11, j12, (DefaultConstructorMarker) null);
        this.f5059c = j13;
    }

    public /* synthetic */ e(long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13);
    }

    public /* synthetic */ e(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    public final long a() {
        return this.f5059c;
    }

    public final long b() {
        return this.f5058b;
    }

    public final long c() {
        return this.f5057a;
    }

    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.f5057a + ", position=" + ((Object) y.g.t(this.f5058b)) + ')';
    }
}
