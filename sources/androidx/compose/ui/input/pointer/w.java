package androidx.compose.ui.input.pointer;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final long f5131a;

    /* renamed from: b, reason: collision with root package name */
    private final long f5132b;

    /* renamed from: c, reason: collision with root package name */
    private final long f5133c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f5134d;

    /* renamed from: e, reason: collision with root package name */
    private final float f5135e;

    /* renamed from: f, reason: collision with root package name */
    private final long f5136f;

    /* renamed from: g, reason: collision with root package name */
    private final long f5137g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f5138h;

    /* renamed from: i, reason: collision with root package name */
    private final int f5139i;

    /* renamed from: j, reason: collision with root package name */
    private final long f5140j;

    /* renamed from: k, reason: collision with root package name */
    private List f5141k;

    /* renamed from: l, reason: collision with root package name */
    private long f5142l;

    /* renamed from: m, reason: collision with root package name */
    private d f5143m;

    private w(long j11, long j12, long j13, boolean z10, float f11, long j14, long j15, boolean z11, boolean z12, int i11, long j16) {
        this.f5131a = j11;
        this.f5132b = j12;
        this.f5133c = j13;
        this.f5134d = z10;
        this.f5135e = f11;
        this.f5136f = j14;
        this.f5137g = j15;
        this.f5138h = z11;
        this.f5139i = i11;
        this.f5140j = j16;
        this.f5142l = y.g.f78593b.c();
        this.f5143m = new d(z12, z12);
    }

    public /* synthetic */ w(long j11, long j12, long j13, boolean z10, float f11, long j14, long j15, boolean z11, boolean z12, int i11, long j16, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z10, f11, j14, j15, z11, z12, (i12 & 512) != 0 ? h0.f5073a.d() : i11, (i12 & 1024) != 0 ? y.g.f78593b.c() : j16, null);
    }

    public /* synthetic */ w(long j11, long j12, long j13, boolean z10, float f11, long j14, long j15, boolean z11, boolean z12, int i11, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z10, f11, j14, j15, z11, z12, i11, j16);
    }

    private w(long j11, long j12, long j13, boolean z10, float f11, long j14, long j15, boolean z11, boolean z12, int i11, List list, long j16, long j17) {
        this(j11, j12, j13, z10, f11, j14, j15, z11, z12, i11, j16, null);
        this.f5141k = list;
        this.f5142l = j17;
    }

    public /* synthetic */ w(long j11, long j12, long j13, boolean z10, float f11, long j14, long j15, boolean z11, boolean z12, int i11, List list, long j16, long j17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z10, f11, j14, j15, z11, z12, i11, list, j16, j17);
    }

    public final void a() {
        this.f5143m.c(true);
        this.f5143m.d(true);
    }

    public final w b(long j11, long j12, long j13, boolean z10, long j14, long j15, boolean z11, int i11, List list, long j16) {
        return d(j11, j12, j13, z10, this.f5135e, j14, j15, z11, i11, list, j16);
    }

    public final w d(long j11, long j12, long j13, boolean z10, float f11, long j14, long j15, boolean z11, int i11, List list, long j16) {
        w wVar = new w(j11, j12, j13, z10, f11, j14, j15, z11, false, i11, list, j16, this.f5142l, null);
        wVar.f5143m = this.f5143m;
        return wVar;
    }

    public final List e() {
        List list = this.f5141k;
        return list == null ? CollectionsKt.l() : list;
    }

    public final long f() {
        return this.f5131a;
    }

    public final long g() {
        return this.f5142l;
    }

    public final long h() {
        return this.f5133c;
    }

    public final boolean i() {
        return this.f5134d;
    }

    public final float j() {
        return this.f5135e;
    }

    public final long k() {
        return this.f5137g;
    }

    public final boolean l() {
        return this.f5138h;
    }

    public final long m() {
        return this.f5140j;
    }

    public final int n() {
        return this.f5139i;
    }

    public final long o() {
        return this.f5132b;
    }

    public final boolean p() {
        return this.f5143m.a() || this.f5143m.b();
    }

    public String toString() {
        return "PointerInputChange(id=" + ((Object) v.f(this.f5131a)) + ", uptimeMillis=" + this.f5132b + ", position=" + ((Object) y.g.t(this.f5133c)) + ", pressed=" + this.f5134d + ", pressure=" + this.f5135e + ", previousUptimeMillis=" + this.f5136f + ", previousPosition=" + ((Object) y.g.t(this.f5137g)) + ", previousPressed=" + this.f5138h + ", isConsumed=" + p() + ", type=" + ((Object) h0.i(this.f5139i)) + ", historical=" + e() + ",scrollDelta=" + ((Object) y.g.t(this.f5140j)) + ')';
    }
}
