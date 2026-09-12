package androidx.datastore.preferences.protobuf;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e1 extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    private List f8834a;

    /* renamed from: b, reason: collision with root package name */
    private Map f8835b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8836c;

    /* renamed from: d, reason: collision with root package name */
    private volatile f f8837d;

    /* renamed from: e, reason: collision with root package name */
    private Map f8838e;

    /* renamed from: f, reason: collision with root package name */
    private volatile c f8839f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends e1 {
        a() {
            super(null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.t((Comparable) obj, obj2);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void r() {
            if (!q()) {
                if (m() > 0) {
                    android.support.v4.media.session.c.a(l(0).getKey());
                    throw null;
                }
                Iterator it = o().iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.c.a(((Map.Entry) it.next()).getKey());
                    throw null;
                }
            }
            super.r();
        }
    }

    /* loaded from: classes.dex */
    private class b implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f8840a;

        /* renamed from: b, reason: collision with root package name */
        private Iterator f8841b;

        private b() {
            this.f8840a = e1.this.f8834a.size();
        }

        /* synthetic */ b(e1 e1Var, a aVar) {
            this();
        }

        private Iterator a() {
            if (this.f8841b == null) {
                this.f8841b = e1.this.f8838e.entrySet().iterator();
            }
            return this.f8841b;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List list = e1.this.f8834a;
            int i11 = this.f8840a - 1;
            this.f8840a = i11;
            return (Map.Entry) list.get(i11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i11 = this.f8840a;
            return (i11 > 0 && i11 <= e1.this.f8834a.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    private class c extends f {
        private c() {
            super(e1.this, null);
        }

        /* synthetic */ c(e1 e1Var, a aVar) {
            this();
        }

        @Override // androidx.datastore.preferences.protobuf.e1.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(e1.this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Map.Entry, Comparable {

        /* renamed from: a, reason: collision with root package name */
        private final Comparable f8844a;

        /* renamed from: b, reason: collision with root package name */
        private Object f8845b;

        d(Comparable comparable, Object obj) {
            this.f8844a = comparable;
            this.f8845b = obj;
        }

        d(e1 e1Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return getKey().compareTo(dVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f8844a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f8844a, entry.getKey()) && b(this.f8845b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f8845b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f8844a;
            int hashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f8845b;
            return hashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            e1.this.i();
            Object obj2 = this.f8845b;
            this.f8845b = obj;
            return obj2;
        }

        public String toString() {
            return this.f8844a + UrlUtils.EQUAL_MARK + this.f8845b;
        }
    }

    /* loaded from: classes.dex */
    private class e implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f8847a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f8848b;

        /* renamed from: c, reason: collision with root package name */
        private Iterator f8849c;

        private e() {
            this.f8847a = -1;
        }

        /* synthetic */ e(e1 e1Var, a aVar) {
            this();
        }

        private Iterator a() {
            if (this.f8849c == null) {
                this.f8849c = e1.this.f8835b.entrySet().iterator();
            }
            return this.f8849c;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f8848b = true;
            int i11 = this.f8847a + 1;
            this.f8847a = i11;
            return i11 < e1.this.f8834a.size() ? (Map.Entry) e1.this.f8834a.get(this.f8847a) : (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8847a + 1 >= e1.this.f8834a.size()) {
                return !e1.this.f8835b.isEmpty() && a().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f8848b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f8848b = false;
            e1.this.i();
            if (this.f8847a >= e1.this.f8834a.size()) {
                a().remove();
                return;
            }
            e1 e1Var = e1.this;
            int i11 = this.f8847a;
            this.f8847a = i11 - 1;
            e1Var.u(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends AbstractSet {
        private f() {
        }

        /* synthetic */ f(e1 e1Var, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            e1.this.t((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = e1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e(e1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            e1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e1.this.size();
        }
    }

    private e1() {
        this.f8834a = Collections.emptyList();
        this.f8835b = Collections.emptyMap();
        this.f8838e = Collections.emptyMap();
    }

    /* synthetic */ e1(a aVar) {
        this();
    }

    private int h(Comparable comparable) {
        int i11;
        int size = this.f8834a.size();
        int i12 = size - 1;
        if (i12 >= 0) {
            int compareTo = comparable.compareTo(((d) this.f8834a.get(i12)).getKey());
            if (compareTo > 0) {
                i11 = size + 1;
                return -i11;
            }
            if (compareTo == 0) {
                return i12;
            }
        }
        int i13 = 0;
        while (i13 <= i12) {
            int i14 = (i13 + i12) / 2;
            int compareTo2 = comparable.compareTo(((d) this.f8834a.get(i14)).getKey());
            if (compareTo2 < 0) {
                i12 = i14 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i14;
                }
                i13 = i14 + 1;
            }
        }
        i11 = i13 + 1;
        return -i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f8836c) {
            throw new UnsupportedOperationException();
        }
    }

    private void k() {
        i();
        if (!this.f8834a.isEmpty() || (this.f8834a instanceof ArrayList)) {
            return;
        }
        this.f8834a = new ArrayList(16);
    }

    private SortedMap p() {
        i();
        if (this.f8835b.isEmpty() && !(this.f8835b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f8835b = treeMap;
            this.f8838e = treeMap.descendingMap();
        }
        return (SortedMap) this.f8835b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e1 s() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object u(int i11) {
        i();
        Object value = ((d) this.f8834a.remove(i11)).getValue();
        if (!this.f8835b.isEmpty()) {
            Iterator it = p().entrySet().iterator();
            this.f8834a.add(new d(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        i();
        if (!this.f8834a.isEmpty()) {
            this.f8834a.clear();
        }
        if (this.f8835b.isEmpty()) {
            return;
        }
        this.f8835b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return h(comparable) >= 0 || this.f8835b.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f8837d == null) {
            this.f8837d = new f(this, null);
        }
        return this.f8837d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return super.equals(obj);
        }
        e1 e1Var = (e1) obj;
        int size = size();
        if (size != e1Var.size()) {
            return false;
        }
        int m11 = m();
        if (m11 != e1Var.m()) {
            return entrySet().equals(e1Var.entrySet());
        }
        for (int i11 = 0; i11 < m11; i11++) {
            if (!l(i11).equals(e1Var.l(i11))) {
                return false;
            }
        }
        if (m11 != size) {
            return this.f8835b.equals(e1Var.f8835b);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int h11 = h(comparable);
        return h11 >= 0 ? ((d) this.f8834a.get(h11)).getValue() : this.f8835b.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int m11 = m();
        int i11 = 0;
        for (int i12 = 0; i12 < m11; i12++) {
            i11 += ((d) this.f8834a.get(i12)).hashCode();
        }
        return n() > 0 ? i11 + this.f8835b.hashCode() : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set j() {
        if (this.f8839f == null) {
            this.f8839f = new c(this, null);
        }
        return this.f8839f;
    }

    public Map.Entry l(int i11) {
        return (Map.Entry) this.f8834a.get(i11);
    }

    public int m() {
        return this.f8834a.size();
    }

    public int n() {
        return this.f8835b.size();
    }

    public Iterable o() {
        return this.f8835b.isEmpty() ? Collections.emptySet() : this.f8835b.entrySet();
    }

    public boolean q() {
        return this.f8836c;
    }

    public void r() {
        if (this.f8836c) {
            return;
        }
        this.f8835b = this.f8835b.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f8835b);
        this.f8838e = this.f8838e.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f8838e);
        this.f8836c = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        i();
        Comparable comparable = (Comparable) obj;
        int h11 = h(comparable);
        if (h11 >= 0) {
            return u(h11);
        }
        if (this.f8835b.isEmpty()) {
            return null;
        }
        return this.f8835b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f8834a.size() + this.f8835b.size();
    }

    public Object t(Comparable comparable, Object obj) {
        i();
        int h11 = h(comparable);
        if (h11 >= 0) {
            return ((d) this.f8834a.get(h11)).setValue(obj);
        }
        k();
        int i11 = -(h11 + 1);
        if (i11 >= 16) {
            return p().put(comparable, obj);
        }
        if (this.f8834a.size() == 16) {
            d dVar = (d) this.f8834a.remove(15);
            p().put(dVar.getKey(), dVar.getValue());
        }
        this.f8834a.add(i11, new d(comparable, obj));
        return null;
    }
}
