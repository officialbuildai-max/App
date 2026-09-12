package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
public final class j2 implements androidx.compose.runtime.tooling.a, Iterable, KMappedMarker {

    /* renamed from: b, reason: collision with root package name */
    private int f3852b;

    /* renamed from: d, reason: collision with root package name */
    private int f3854d;

    /* renamed from: e, reason: collision with root package name */
    private int f3855e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3856f;

    /* renamed from: g, reason: collision with root package name */
    private int f3857g;

    /* renamed from: i, reason: collision with root package name */
    private HashMap f3859i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.collection.e0 f3860j;

    /* renamed from: a, reason: collision with root package name */
    private int[] f3851a = new int[0];

    /* renamed from: c, reason: collision with root package name */
    private Object[] f3853c = new Object[0];

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f3858h = new ArrayList();

    private final c B(int i11) {
        int i12;
        if (this.f3856f) {
            k.r("use active SlotWriter to crate an anchor for location instead");
        }
        if (i11 < 0 || i11 >= (i12 = this.f3852b)) {
            return null;
        }
        return l2.f(this.f3858h, i11, i12);
    }

    public final l0 A(int i11) {
        c B;
        HashMap hashMap = this.f3859i;
        if (hashMap == null || (B = B(i11)) == null) {
            return null;
        }
        return (l0) hashMap.get(B);
    }

    public final c a(int i11) {
        if (this.f3856f) {
            k.r("use active SlotWriter to create an anchor location instead");
        }
        boolean z10 = false;
        if (i11 >= 0 && i11 < this.f3852b) {
            z10 = true;
        }
        if (!z10) {
            o1.a("Parameter index is out of range");
        }
        ArrayList arrayList = this.f3858h;
        int t11 = l2.t(arrayList, i11, this.f3852b);
        if (t11 >= 0) {
            return (c) arrayList.get(t11);
        }
        c cVar = new c(i11);
        arrayList.add(-(t11 + 1), cVar);
        return cVar;
    }

    public final int c(c cVar) {
        if (this.f3856f) {
            k.r("Use active SlotWriter to determine anchor location instead");
        }
        if (!cVar.b()) {
            o1.a("Anchor refers to a group that was removed");
        }
        return cVar.a();
    }

    public final void e(i2 i2Var, HashMap hashMap) {
        if (!(i2Var.y() == this && this.f3855e > 0)) {
            k.r("Unexpected reader close()");
        }
        this.f3855e--;
        if (hashMap != null) {
            synchronized (this) {
                try {
                    HashMap hashMap2 = this.f3859i;
                    if (hashMap2 != null) {
                        hashMap2.putAll(hashMap);
                    } else {
                        this.f3859i = hashMap;
                    }
                    Unit unit = Unit.f67184a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void f(m2 m2Var, int[] iArr, int i11, Object[] objArr, int i12, ArrayList arrayList, HashMap hashMap, androidx.collection.e0 e0Var) {
        if (!(m2Var.f0() == this && this.f3856f)) {
            o1.a("Unexpected writer close()");
        }
        this.f3856f = false;
        z(iArr, i11, objArr, i12, arrayList, hashMap, e0Var);
    }

    public final void h() {
        this.f3860j = new androidx.collection.e0(0, 1, null);
    }

    public boolean isEmpty() {
        return this.f3852b == 0;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new j0(this, 0, this.f3852b);
    }

    public final void j() {
        this.f3859i = new HashMap();
    }

    public final boolean l() {
        return this.f3852b > 0 && l2.c(this.f3851a, 0);
    }

    public final ArrayList m() {
        return this.f3858h;
    }

    public final androidx.collection.e0 n() {
        return this.f3860j;
    }

    public final int[] o() {
        return this.f3851a;
    }

    public final int p() {
        return this.f3852b;
    }

    public final Object[] q() {
        return this.f3853c;
    }

    public final int r() {
        return this.f3854d;
    }

    public final HashMap s() {
        return this.f3859i;
    }

    public final int t() {
        return this.f3857g;
    }

    public final boolean u() {
        return this.f3856f;
    }

    public final boolean v(int i11, c cVar) {
        if (this.f3856f) {
            k.r("Writer is active");
        }
        if (!(i11 >= 0 && i11 < this.f3852b)) {
            k.r("Invalid group index");
        }
        if (y(cVar)) {
            int h11 = l2.h(this.f3851a, i11) + i11;
            int a11 = cVar.a();
            if (i11 <= a11 && a11 < h11) {
                return true;
            }
        }
        return false;
    }

    public final i2 w() {
        if (this.f3856f) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.f3855e++;
        return new i2(this);
    }

    public final m2 x() {
        if (this.f3856f) {
            k.r("Cannot start a writer when another writer is pending");
        }
        if (!(this.f3855e <= 0)) {
            k.r("Cannot start a writer when a reader is pending");
        }
        this.f3856f = true;
        this.f3857g++;
        return new m2(this);
    }

    public final boolean y(c cVar) {
        int t11;
        return cVar.b() && (t11 = l2.t(this.f3858h, cVar.a(), this.f3852b)) >= 0 && Intrinsics.c(this.f3858h.get(t11), cVar);
    }

    public final void z(int[] iArr, int i11, Object[] objArr, int i12, ArrayList arrayList, HashMap hashMap, androidx.collection.e0 e0Var) {
        this.f3851a = iArr;
        this.f3852b = i11;
        this.f3853c = objArr;
        this.f3854d = i12;
        this.f3858h = arrayList;
        this.f3859i = hashMap;
        this.f3860j = e0Var;
    }
}
