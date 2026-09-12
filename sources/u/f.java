package u;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;
import t.g;

/* loaded from: classes.dex */
public class f extends AbstractMutableMap implements g.a {

    /* renamed from: a, reason: collision with root package name */
    private d f76622a;

    /* renamed from: b, reason: collision with root package name */
    private w.e f76623b = new w.e();

    /* renamed from: c, reason: collision with root package name */
    private t f76624c;

    /* renamed from: d, reason: collision with root package name */
    private Object f76625d;

    /* renamed from: e, reason: collision with root package name */
    private int f76626e;

    /* renamed from: f, reason: collision with root package name */
    private int f76627f;

    public f(d dVar) {
        this.f76622a = dVar;
        this.f76624c = this.f76622a.u();
        this.f76627f = this.f76622a.size();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set a() {
        return new h(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set c() {
        return new j(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        t a11 = t.f76639e.a();
        Intrinsics.f(a11, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.f76624c = a11;
        p(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f76624c.k(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int e() {
        return this.f76627f;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection f() {
        return new l(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.f76624c.o(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // t.g.a, androidx.compose.runtime.n1.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public d build() {
        d dVar;
        if (this.f76624c == this.f76622a.u()) {
            dVar = this.f76622a;
        } else {
            this.f76623b = new w.e();
            dVar = new d(this.f76624c, size());
        }
        this.f76622a = dVar;
        return dVar;
    }

    public final int i() {
        return this.f76626e;
    }

    public final t j() {
        return this.f76624c;
    }

    public final w.e l() {
        return this.f76623b;
    }

    public final void m(int i11) {
        this.f76626e = i11;
    }

    public final void n(Object obj) {
        this.f76625d = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(w.e eVar) {
        this.f76623b = eVar;
    }

    public void p(int i11) {
        this.f76627f = i11;
        this.f76626e++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.f76625d = null;
        this.f76624c = this.f76624c.D(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        return this.f76625d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        d dVar = map instanceof d ? (d) map : null;
        if (dVar == null) {
            f fVar = map instanceof f ? (f) map : null;
            dVar = fVar != null ? fVar.build() : null;
        }
        if (dVar == null) {
            super.putAll(map);
            return;
        }
        w.b bVar = new w.b(0, 1, null);
        int size = size();
        t tVar = this.f76624c;
        t u11 = dVar.u();
        Intrinsics.f(u11, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.f76624c = tVar.E(u11, 0, bVar, this);
        int size2 = (dVar.size() + size) - bVar.a();
        if (size != size2) {
            p(size2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        this.f76625d = null;
        t G = this.f76624c.G(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (G == null) {
            G = t.f76639e.a();
            Intrinsics.f(G, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.f76624c = G;
        return this.f76625d;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int size = size();
        t H = this.f76624c.H(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (H == null) {
            H = t.f76639e.a();
            Intrinsics.f(H, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.f76624c = H;
        return size != size();
    }
}
