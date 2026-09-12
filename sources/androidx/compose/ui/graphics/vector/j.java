package androidx.compose.ui.graphics.vector;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
public final class j extends l implements Iterable, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final String f4918a;

    /* renamed from: b, reason: collision with root package name */
    private final float f4919b;

    /* renamed from: c, reason: collision with root package name */
    private final float f4920c;

    /* renamed from: d, reason: collision with root package name */
    private final float f4921d;

    /* renamed from: e, reason: collision with root package name */
    private final float f4922e;

    /* renamed from: f, reason: collision with root package name */
    private final float f4923f;

    /* renamed from: g, reason: collision with root package name */
    private final float f4924g;

    /* renamed from: h, reason: collision with root package name */
    private final float f4925h;

    /* renamed from: i, reason: collision with root package name */
    private final List f4926i;

    /* renamed from: j, reason: collision with root package name */
    private final List f4927j;

    /* loaded from: classes.dex */
    public static final class a implements Iterator, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator f4928a;

        a(j jVar) {
            this.f4928a = jVar.f4927j.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l next() {
            return (l) this.f4928a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4928a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public j() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
    }

    public j(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list, List list2) {
        super(null);
        this.f4918a = str;
        this.f4919b = f11;
        this.f4920c = f12;
        this.f4921d = f13;
        this.f4922e = f14;
        this.f4923f = f15;
        this.f4924g = f16;
        this.f4925h = f17;
        this.f4926i = list;
        this.f4927j = list2;
    }

    public /* synthetic */ j(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0.0f : f11, (i11 & 4) != 0 ? 0.0f : f12, (i11 & 8) != 0 ? 0.0f : f13, (i11 & 16) != 0 ? 1.0f : f14, (i11 & 32) == 0 ? f15 : 1.0f, (i11 & 64) != 0 ? 0.0f : f16, (i11 & 128) == 0 ? f17 : 0.0f, (i11 & 256) != 0 ? k.d() : list, (i11 & 512) != 0 ? CollectionsKt.l() : list2);
    }

    public final l c(int i11) {
        return (l) this.f4927j.get(i11);
    }

    public final List e() {
        return this.f4926i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof j)) {
            j jVar = (j) obj;
            return Intrinsics.c(this.f4918a, jVar.f4918a) && this.f4919b == jVar.f4919b && this.f4920c == jVar.f4920c && this.f4921d == jVar.f4921d && this.f4922e == jVar.f4922e && this.f4923f == jVar.f4923f && this.f4924g == jVar.f4924g && this.f4925h == jVar.f4925h && Intrinsics.c(this.f4926i, jVar.f4926i) && Intrinsics.c(this.f4927j, jVar.f4927j);
        }
        return false;
    }

    public final String f() {
        return this.f4918a;
    }

    public final float h() {
        return this.f4920c;
    }

    public int hashCode() {
        return (((((((((((((((((this.f4918a.hashCode() * 31) + Float.floatToIntBits(this.f4919b)) * 31) + Float.floatToIntBits(this.f4920c)) * 31) + Float.floatToIntBits(this.f4921d)) * 31) + Float.floatToIntBits(this.f4922e)) * 31) + Float.floatToIntBits(this.f4923f)) * 31) + Float.floatToIntBits(this.f4924g)) * 31) + Float.floatToIntBits(this.f4925h)) * 31) + this.f4926i.hashCode()) * 31) + this.f4927j.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a(this);
    }

    public final float j() {
        return this.f4921d;
    }

    public final float l() {
        return this.f4919b;
    }

    public final float m() {
        return this.f4922e;
    }

    public final float n() {
        return this.f4923f;
    }

    public final int o() {
        return this.f4927j.size();
    }

    public final float p() {
        return this.f4924g;
    }

    public final float q() {
        return this.f4925h;
    }
}
