package v;

import java.util.Iterator;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t.h;
import u.d;

/* loaded from: classes2.dex */
public final class b extends AbstractSet implements h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f77081e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final int f77082f = 8;

    /* renamed from: g, reason: collision with root package name */
    private static final b f77083g;

    /* renamed from: b, reason: collision with root package name */
    private final Object f77084b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f77085c;

    /* renamed from: d, reason: collision with root package name */
    private final d f77086d;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            return b.f77083g;
        }
    }

    static {
        w.c cVar = w.c.f77610a;
        f77083g = new b(cVar, cVar, d.f76614f.a());
    }

    public b(Object obj, Object obj2, d dVar) {
        this.f77084b = obj;
        this.f77085c = obj2;
        this.f77086d = dVar;
    }

    @Override // java.util.Collection, java.util.Set, t.h
    public h add(Object obj) {
        if (this.f77086d.containsKey(obj)) {
            return this;
        }
        if (isEmpty()) {
            return new b(obj, obj, this.f77086d.w(obj, new v.a()));
        }
        Object obj2 = this.f77085c;
        Object obj3 = this.f77086d.get(obj2);
        Intrinsics.e(obj3);
        return new b(this.f77084b, obj, this.f77086d.w(obj2, ((v.a) obj3).e(obj)).w(obj, new v.a(obj2)));
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f77086d.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.f77086d.size();
    }

    @Override // kotlin.collections.AbstractSet, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new c(this.f77084b, this.f77086d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set, t.h
    public h remove(Object obj) {
        v.a aVar = (v.a) this.f77086d.get(obj);
        if (aVar == null) {
            return this;
        }
        d x10 = this.f77086d.x(obj);
        if (aVar.b()) {
            V v11 = x10.get(aVar.d());
            Intrinsics.e(v11);
            x10 = x10.w(aVar.d(), ((v.a) v11).e(aVar.c()));
        }
        if (aVar.a()) {
            V v12 = x10.get(aVar.c());
            Intrinsics.e(v12);
            x10 = x10.w(aVar.c(), ((v.a) v12).f(aVar.d()));
        }
        return new b(!aVar.b() ? aVar.c() : this.f77084b, !aVar.a() ? aVar.d() : this.f77085c, x10);
    }
}
