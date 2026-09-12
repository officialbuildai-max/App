package androidx.compose.ui.input.pointer;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private final long f5152a;

    /* renamed from: b, reason: collision with root package name */
    private final long f5153b;

    /* renamed from: c, reason: collision with root package name */
    private final long f5154c;

    /* renamed from: d, reason: collision with root package name */
    private final long f5155d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f5156e;

    /* renamed from: f, reason: collision with root package name */
    private final float f5157f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5158g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f5159h;

    /* renamed from: i, reason: collision with root package name */
    private final List f5160i;

    /* renamed from: j, reason: collision with root package name */
    private final long f5161j;

    /* renamed from: k, reason: collision with root package name */
    private final long f5162k;

    private z(long j11, long j12, long j13, long j14, boolean z10, float f11, int i11, boolean z11, List list, long j15, long j16) {
        this.f5152a = j11;
        this.f5153b = j12;
        this.f5154c = j13;
        this.f5155d = j14;
        this.f5156e = z10;
        this.f5157f = f11;
        this.f5158g = i11;
        this.f5159h = z11;
        this.f5160i = list;
        this.f5161j = j15;
        this.f5162k = j16;
    }

    public /* synthetic */ z(long j11, long j12, long j13, long j14, boolean z10, float f11, int i11, boolean z11, List list, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, z10, f11, i11, z11, list, j15, j16);
    }

    public final boolean a() {
        return this.f5159h;
    }

    public final boolean b() {
        return this.f5156e;
    }

    public final List c() {
        return this.f5160i;
    }

    public final long d() {
        return this.f5152a;
    }

    public final long e() {
        return this.f5162k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return v.d(this.f5152a, zVar.f5152a) && this.f5153b == zVar.f5153b && y.g.j(this.f5154c, zVar.f5154c) && y.g.j(this.f5155d, zVar.f5155d) && this.f5156e == zVar.f5156e && Float.compare(this.f5157f, zVar.f5157f) == 0 && h0.g(this.f5158g, zVar.f5158g) && this.f5159h == zVar.f5159h && Intrinsics.c(this.f5160i, zVar.f5160i) && y.g.j(this.f5161j, zVar.f5161j) && y.g.j(this.f5162k, zVar.f5162k);
    }

    public final long f() {
        return this.f5155d;
    }

    public final long g() {
        return this.f5154c;
    }

    public final float h() {
        return this.f5157f;
    }

    public int hashCode() {
        return (((((((((((((((((((v.e(this.f5152a) * 31) + androidx.collection.s.a(this.f5153b)) * 31) + y.g.o(this.f5154c)) * 31) + y.g.o(this.f5155d)) * 31) + androidx.compose.foundation.e.a(this.f5156e)) * 31) + Float.floatToIntBits(this.f5157f)) * 31) + h0.h(this.f5158g)) * 31) + androidx.compose.foundation.e.a(this.f5159h)) * 31) + this.f5160i.hashCode()) * 31) + y.g.o(this.f5161j)) * 31) + y.g.o(this.f5162k);
    }

    public final long i() {
        return this.f5161j;
    }

    public final int j() {
        return this.f5158g;
    }

    public final long k() {
        return this.f5153b;
    }

    public String toString() {
        return "PointerInputEventData(id=" + ((Object) v.f(this.f5152a)) + ", uptime=" + this.f5153b + ", positionOnScreen=" + ((Object) y.g.t(this.f5154c)) + ", position=" + ((Object) y.g.t(this.f5155d)) + ", down=" + this.f5156e + ", pressure=" + this.f5157f + ", type=" + ((Object) h0.i(this.f5158g)) + ", activeHover=" + this.f5159h + ", historical=" + this.f5160i + ", scrollDelta=" + ((Object) y.g.t(this.f5161j)) + ", originalEventPosition=" + ((Object) y.g.t(this.f5162k)) + ')';
    }
}
