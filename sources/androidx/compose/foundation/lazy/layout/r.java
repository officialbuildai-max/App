package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.o0;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class r implements q, androidx.compose.ui.layout.x {

    /* renamed from: a, reason: collision with root package name */
    private final LazyLayoutItemContentFactory f3143a;

    /* renamed from: b, reason: collision with root package name */
    private final o0 f3144b;

    /* renamed from: c, reason: collision with root package name */
    private final m f3145c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap f3146d = new HashMap();

    public r(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, o0 o0Var) {
        this.f3143a = lazyLayoutItemContentFactory;
        this.f3144b = o0Var;
        this.f3145c = (m) lazyLayoutItemContentFactory.d().invoke();
    }

    @Override // o0.n
    public float C0() {
        return this.f3144b.C0();
    }

    @Override // o0.e
    public float E0(float f11) {
        return this.f3144b.E0(f11);
    }

    @Override // o0.n
    public long H(float f11) {
        return this.f3144b.H(f11);
    }

    @Override // o0.n
    public float J(long j11) {
        return this.f3144b.J(j11);
    }

    @Override // androidx.compose.ui.layout.x
    public androidx.compose.ui.layout.v M0(int i11, int i12, Map map, Function1 function1, Function1 function12) {
        return this.f3144b.M0(i11, i12, map, function1, function12);
    }

    @Override // o0.e
    public long Q(float f11) {
        return this.f3144b.Q(f11);
    }

    @Override // o0.e
    public long Q0(long j11) {
        return this.f3144b.Q0(j11);
    }

    @Override // androidx.compose.foundation.lazy.layout.q
    public List S(int i11, long j11) {
        List list = (List) this.f3146d.get(Integer.valueOf(i11));
        if (list != null) {
            return list;
        }
        Object b11 = this.f3145c.b(i11);
        List E = this.f3144b.E(b11, this.f3143a.b(i11, b11, this.f3145c.c(i11)));
        int size = E.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(((androidx.compose.ui.layout.s) E.get(i12)).P(j11));
        }
        this.f3146d.put(Integer.valueOf(i11), arrayList);
        return arrayList;
    }

    @Override // androidx.compose.ui.layout.j
    public boolean W() {
        return this.f3144b.W();
    }

    @Override // o0.e
    public int c0(float f11) {
        return this.f3144b.c0(f11);
    }

    @Override // o0.e
    public float getDensity() {
        return this.f3144b.getDensity();
    }

    @Override // androidx.compose.ui.layout.j
    public LayoutDirection getLayoutDirection() {
        return this.f3144b.getLayoutDirection();
    }

    @Override // o0.e
    public float h0(long j11) {
        return this.f3144b.h0(j11);
    }

    @Override // androidx.compose.ui.layout.x
    public androidx.compose.ui.layout.v p0(int i11, int i12, Map map, Function1 function1) {
        return this.f3144b.p0(i11, i12, map, function1);
    }

    @Override // o0.e
    public float x0(int i11) {
        return this.f3144b.x0(i11);
    }

    @Override // o0.e
    public float y0(float f11) {
        return this.f3144b.y0(f11);
    }
}
