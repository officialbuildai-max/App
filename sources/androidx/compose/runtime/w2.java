package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
final class w2 implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final j2 f4133a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4134b;

    /* renamed from: c, reason: collision with root package name */
    private final l0 f4135c;

    /* renamed from: d, reason: collision with root package name */
    private final x2 f4136d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4137e;

    /* renamed from: f, reason: collision with root package name */
    private int f4138f;

    public w2(j2 j2Var, int i11, l0 l0Var, x2 x2Var) {
        this.f4133a = j2Var;
        this.f4134b = i11;
        this.f4136d = x2Var;
        this.f4137e = j2Var.t();
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.compose.runtime.tooling.b next() {
        Object obj;
        ArrayList b11 = this.f4135c.b();
        if (b11 != null) {
            int i11 = this.f4138f;
            this.f4138f = i11 + 1;
            obj = b11.get(i11);
        } else {
            obj = null;
        }
        if (obj instanceof c) {
            return new k2(this.f4133a, ((c) obj).a(), this.f4137e);
        }
        if (obj instanceof l0) {
            return new y2(this.f4133a, this.f4134b, (l0) obj, new z1(this.f4136d, this.f4138f - 1));
        }
        k.s("Unexpected group information structure");
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        ArrayList b11 = this.f4135c.b();
        return b11 != null && this.f4138f < b11.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
