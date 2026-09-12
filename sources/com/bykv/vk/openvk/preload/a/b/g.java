package com.bykv.vk.openvk.preload.a.b;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes2.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static final Comparator<Comparable> f20523d = new Comparator<Comparable>() { // from class: com.bykv.vk.openvk.preload.a.b.g.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static /* synthetic */ boolean f20524i = true;

    /* renamed from: a, reason: collision with root package name */
    int f20525a;

    /* renamed from: b, reason: collision with root package name */
    int f20526b;

    /* renamed from: c, reason: collision with root package name */
    final d<K, V> f20527c;

    /* renamed from: e, reason: collision with root package name */
    private Comparator<? super K> f20528e;

    /* renamed from: f, reason: collision with root package name */
    private d<K, V> f20529f;

    /* renamed from: g, reason: collision with root package name */
    private g<K, V>.a f20530g;

    /* renamed from: h, reason: collision with root package name */
    private g<K, V>.b f20531h;

    /* loaded from: classes2.dex */
    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new c(this) { // from class: com.bykv.vk.openvk.preload.a.b.g.a.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public final /* synthetic */ Object next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            d<K, V> a11;
            if (!(obj instanceof Map.Entry) || (a11 = g.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            g.this.a((d) a11, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g.this.f20525a;
        }
    }

    /* loaded from: classes2.dex */
    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new c(this) { // from class: com.bykv.vk.openvk.preload.a.b.g.b.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public final K next() {
                    return a().f20543f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return g.this.a(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g.this.f20525a;
        }
    }

    /* loaded from: classes2.dex */
    abstract class c<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        private d<K, V> f20534a;

        /* renamed from: b, reason: collision with root package name */
        private d<K, V> f20535b = null;

        /* renamed from: c, reason: collision with root package name */
        private int f20536c;

        c() {
            this.f20534a = g.this.f20527c.f20541d;
            this.f20536c = g.this.f20526b;
        }

        final d<K, V> a() {
            d<K, V> dVar = this.f20534a;
            g gVar = g.this;
            if (dVar == gVar.f20527c) {
                throw new NoSuchElementException();
            }
            if (gVar.f20526b != this.f20536c) {
                throw new ConcurrentModificationException();
            }
            this.f20534a = dVar.f20541d;
            this.f20535b = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f20534a != g.this.f20527c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f20535b;
            if (dVar == null) {
                throw new IllegalStateException();
            }
            g.this.a((d) dVar, true);
            this.f20535b = null;
            this.f20536c = g.this.f20526b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        d<K, V> f20538a;

        /* renamed from: b, reason: collision with root package name */
        d<K, V> f20539b;

        /* renamed from: c, reason: collision with root package name */
        d<K, V> f20540c;

        /* renamed from: d, reason: collision with root package name */
        d<K, V> f20541d;

        /* renamed from: e, reason: collision with root package name */
        d<K, V> f20542e;

        /* renamed from: f, reason: collision with root package name */
        final K f20543f;

        /* renamed from: g, reason: collision with root package name */
        V f20544g;

        /* renamed from: h, reason: collision with root package name */
        int f20545h;

        d() {
            this.f20543f = null;
            this.f20542e = this;
            this.f20541d = this;
        }

        d(d<K, V> dVar, K k11, d<K, V> dVar2, d<K, V> dVar3) {
            this.f20538a = dVar;
            this.f20543f = k11;
            this.f20545h = 1;
            this.f20541d = dVar2;
            this.f20542e = dVar3;
            dVar3.f20541d = this;
            dVar2.f20542e = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k11 = this.f20543f;
                if (k11 != null ? k11.equals(entry.getKey()) : entry.getKey() == null) {
                    V v11 = this.f20544g;
                    if (v11 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v11.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f20543f;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f20544g;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k11 = this.f20543f;
            int hashCode = k11 == null ? 0 : k11.hashCode();
            V v11 = this.f20544g;
            return hashCode ^ (v11 != null ? v11.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v11) {
            V v12 = this.f20544g;
            this.f20544g = v11;
            return v12;
        }

        public final String toString() {
            return this.f20543f + UrlUtils.EQUAL_MARK + this.f20544g;
        }
    }

    public g() {
        this(f20523d);
    }

    private g(Comparator<? super K> comparator) {
        this.f20525a = 0;
        this.f20526b = 0;
        this.f20527c = new d<>();
        this.f20528e = comparator == null ? f20523d : comparator;
    }

    private d<K, V> a(K k11, boolean z10) {
        int i11;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f20528e;
        d<K, V> dVar2 = this.f20529f;
        if (dVar2 != null) {
            Comparable comparable = comparator == f20523d ? (Comparable) k11 : null;
            while (true) {
                i11 = comparable != null ? comparable.compareTo(dVar2.f20543f) : comparator.compare(k11, dVar2.f20543f);
                if (i11 != 0) {
                    d<K, V> dVar3 = i11 < 0 ? dVar2.f20539b : dVar2.f20540c;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar2 = dVar3;
                } else {
                    return dVar2;
                }
            }
        } else {
            i11 = 0;
        }
        if (!z10) {
            return null;
        }
        d<K, V> dVar4 = this.f20527c;
        if (dVar2 != null) {
            dVar = new d<>(dVar2, k11, dVar4, dVar4.f20542e);
            if (i11 < 0) {
                dVar2.f20539b = dVar;
            } else {
                dVar2.f20540c = dVar;
            }
            b(dVar2, true);
        } else {
            if (comparator == f20523d && !(k11 instanceof Comparable)) {
                throw new ClassCastException(k11.getClass().getName() + " is not Comparable");
            }
            dVar = new d<>(dVar2, k11, dVar4, dVar4.f20542e);
            this.f20529f = dVar;
        }
        this.f20525a++;
        this.f20526b++;
        return dVar;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f20539b;
        d<K, V> dVar3 = dVar.f20540c;
        d<K, V> dVar4 = dVar3.f20539b;
        d<K, V> dVar5 = dVar3.f20540c;
        dVar.f20540c = dVar4;
        if (dVar4 != null) {
            dVar4.f20538a = dVar;
        }
        a(dVar, dVar3);
        dVar3.f20539b = dVar;
        dVar.f20538a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.f20545h : 0, dVar4 != null ? dVar4.f20545h : 0) + 1;
        dVar.f20545h = max;
        dVar3.f20545h = Math.max(max, dVar5 != null ? dVar5.f20545h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f20538a;
        dVar.f20538a = null;
        if (dVar2 != null) {
            dVar2.f20538a = dVar3;
        }
        if (dVar3 == null) {
            this.f20529f = dVar2;
            return;
        }
        if (dVar3.f20539b == dVar) {
            dVar3.f20539b = dVar2;
        } else {
            if (!f20524i && dVar3.f20540c != dVar) {
                throw new AssertionError();
            }
            dVar3.f20540c = dVar2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d<K, V> b(Object obj) {
        if (obj != 0) {
            try {
                return a((g<K, V>) obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f20539b;
        d<K, V> dVar3 = dVar.f20540c;
        d<K, V> dVar4 = dVar2.f20539b;
        d<K, V> dVar5 = dVar2.f20540c;
        dVar.f20539b = dVar5;
        if (dVar5 != null) {
            dVar5.f20538a = dVar;
        }
        a(dVar, dVar2);
        dVar2.f20540c = dVar;
        dVar.f20538a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.f20545h : 0, dVar5 != null ? dVar5.f20545h : 0) + 1;
        dVar.f20545h = max;
        dVar2.f20545h = Math.max(max, dVar4 != null ? dVar4.f20545h : 0) + 1;
    }

    private void b(d<K, V> dVar, boolean z10) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f20539b;
            d<K, V> dVar3 = dVar.f20540c;
            int i11 = dVar2 != null ? dVar2.f20545h : 0;
            int i12 = dVar3 != null ? dVar3.f20545h : 0;
            int i13 = i11 - i12;
            if (i13 == -2) {
                d<K, V> dVar4 = dVar3.f20539b;
                d<K, V> dVar5 = dVar3.f20540c;
                int i14 = (dVar4 != null ? dVar4.f20545h : 0) - (dVar5 != null ? dVar5.f20545h : 0);
                if (i14 == -1 || (i14 == 0 && !z10)) {
                    a((d) dVar);
                } else {
                    if (!f20524i && i14 != 1) {
                        throw new AssertionError();
                    }
                    b((d) dVar3);
                    a((d) dVar);
                }
                if (z10) {
                    return;
                }
            } else if (i13 == 2) {
                d<K, V> dVar6 = dVar2.f20539b;
                d<K, V> dVar7 = dVar2.f20540c;
                int i15 = (dVar6 != null ? dVar6.f20545h : 0) - (dVar7 != null ? dVar7.f20545h : 0);
                if (i15 == 1 || (i15 == 0 && !z10)) {
                    b((d) dVar);
                } else {
                    if (!f20524i && i15 != -1) {
                        throw new AssertionError();
                    }
                    a((d) dVar2);
                    b((d) dVar);
                }
                if (z10) {
                    return;
                }
            } else if (i13 == 0) {
                dVar.f20545h = i11 + 1;
                if (z10) {
                    return;
                }
            } else {
                if (!f20524i && i13 != -1 && i13 != 1) {
                    throw new AssertionError();
                }
                dVar.f20545h = Math.max(i11, i12) + 1;
                if (!z10) {
                    return;
                }
            }
            dVar = dVar.f20538a;
        }
    }

    final d<K, V> a(Object obj) {
        d<K, V> b11 = b(obj);
        if (b11 != null) {
            a((d) b11, true);
        }
        return b11;
    }

    final d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> b11 = b(entry.getKey());
        if (b11 == null) {
            return null;
        }
        V v11 = b11.f20544g;
        Object value = entry.getValue();
        if (v11 == value || (v11 != null && v11.equals(value))) {
            return b11;
        }
        return null;
    }

    final void a(d<K, V> dVar, boolean z10) {
        int i11;
        if (z10) {
            d<K, V> dVar2 = dVar.f20542e;
            dVar2.f20541d = dVar.f20541d;
            dVar.f20541d.f20542e = dVar2;
        }
        d<K, V> dVar3 = dVar.f20539b;
        d<K, V> dVar4 = dVar.f20540c;
        d<K, V> dVar5 = dVar.f20538a;
        int i12 = 0;
        if (dVar3 == null || dVar4 == null) {
            if (dVar3 != null) {
                a(dVar, dVar3);
                dVar.f20539b = null;
            } else if (dVar4 != null) {
                a(dVar, dVar4);
                dVar.f20540c = null;
            } else {
                a(dVar, (d) null);
            }
            b(dVar5, false);
            this.f20525a--;
            this.f20526b++;
            return;
        }
        if (dVar3.f20545h > dVar4.f20545h) {
            d<K, V> dVar6 = dVar3.f20540c;
            while (true) {
                d<K, V> dVar7 = dVar6;
                dVar4 = dVar3;
                dVar3 = dVar7;
                if (dVar3 == null) {
                    break;
                } else {
                    dVar6 = dVar3.f20540c;
                }
            }
        } else {
            while (true) {
                d<K, V> dVar8 = dVar4.f20539b;
                if (dVar8 == null) {
                    break;
                } else {
                    dVar4 = dVar8;
                }
            }
        }
        a((d) dVar4, false);
        d<K, V> dVar9 = dVar.f20539b;
        if (dVar9 != null) {
            i11 = dVar9.f20545h;
            dVar4.f20539b = dVar9;
            dVar9.f20538a = dVar4;
            dVar.f20539b = null;
        } else {
            i11 = 0;
        }
        d<K, V> dVar10 = dVar.f20540c;
        if (dVar10 != null) {
            i12 = dVar10.f20545h;
            dVar4.f20540c = dVar10;
            dVar10.f20538a = dVar4;
            dVar.f20540c = null;
        }
        dVar4.f20545h = Math.max(i11, i12) + 1;
        a(dVar, dVar4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f20529f = null;
        this.f20525a = 0;
        this.f20526b++;
        d<K, V> dVar = this.f20527c;
        dVar.f20542e = dVar;
        dVar.f20541d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return b(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.a aVar = this.f20530g;
        if (aVar != null) {
            return aVar;
        }
        g<K, V>.a aVar2 = new a();
        this.f20530g = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        d<K, V> b11 = b(obj);
        if (b11 != null) {
            return b11.f20544g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        g<K, V>.b bVar = this.f20531h;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.f20531h = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k11, V v11) {
        if (k11 == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> a11 = a((g<K, V>) k11, true);
        V v12 = a11.f20544g;
        a11.f20544g = v11;
        return v12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        d<K, V> a11 = a(obj);
        if (a11 != null) {
            return a11.f20544g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f20525a;
    }
}
