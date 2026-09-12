package k;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class b implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    c f66579a;

    /* renamed from: b, reason: collision with root package name */
    private c f66580b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakHashMap f66581c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    private int f66582d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.b.e
        c b(c cVar) {
            return cVar.f66586d;
        }

        @Override // k.b.e
        c c(c cVar) {
            return cVar.f66585c;
        }
    }

    /* renamed from: k.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0833b extends e {
        C0833b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.b.e
        c b(c cVar) {
            return cVar.f66585c;
        }

        @Override // k.b.e
        c c(c cVar) {
            return cVar.f66586d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        final Object f66583a;

        /* renamed from: b, reason: collision with root package name */
        final Object f66584b;

        /* renamed from: c, reason: collision with root package name */
        c f66585c;

        /* renamed from: d, reason: collision with root package name */
        c f66586d;

        c(Object obj, Object obj2) {
            this.f66583a = obj;
            this.f66584b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f66583a.equals(cVar.f66583a) && this.f66584b.equals(cVar.f66584b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f66583a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f66584b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f66583a.hashCode() ^ this.f66584b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f66583a + UrlUtils.EQUAL_MARK + this.f66584b;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends f implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private c f66587a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f66588b = true;

        d() {
        }

        @Override // k.b.f
        void a(c cVar) {
            c cVar2 = this.f66587a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f66586d;
                this.f66587a = cVar3;
                this.f66588b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f66588b) {
                this.f66588b = false;
                this.f66587a = b.this.f66579a;
            } else {
                c cVar = this.f66587a;
                this.f66587a = cVar != null ? cVar.f66585c : null;
            }
            return this.f66587a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f66588b) {
                return b.this.f66579a != null;
            }
            c cVar = this.f66587a;
            return (cVar == null || cVar.f66585c == null) ? false : true;
        }
    }

    /* loaded from: classes2.dex */
    private static abstract class e extends f implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        c f66590a;

        /* renamed from: b, reason: collision with root package name */
        c f66591b;

        e(c cVar, c cVar2) {
            this.f66590a = cVar2;
            this.f66591b = cVar;
        }

        private c e() {
            c cVar = this.f66591b;
            c cVar2 = this.f66590a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // k.b.f
        public void a(c cVar) {
            if (this.f66590a == cVar && cVar == this.f66591b) {
                this.f66591b = null;
                this.f66590a = null;
            }
            c cVar2 = this.f66590a;
            if (cVar2 == cVar) {
                this.f66590a = b(cVar2);
            }
            if (this.f66591b == cVar) {
                this.f66591b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f66591b;
            this.f66591b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f66591b != null;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class f {
        abstract void a(c cVar);
    }

    public Map.Entry a() {
        return this.f66579a;
    }

    protected c b(Object obj) {
        c cVar = this.f66579a;
        while (cVar != null && !cVar.f66583a.equals(obj)) {
            cVar = cVar.f66585c;
        }
        return cVar;
    }

    public d c() {
        d dVar = new d();
        this.f66581c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Iterator descendingIterator() {
        C0833b c0833b = new C0833b(this.f66580b, this.f66579a);
        this.f66581c.put(c0833b, Boolean.FALSE);
        return c0833b;
    }

    public Map.Entry e() {
        return this.f66580b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f66582d++;
        c cVar2 = this.f66580b;
        if (cVar2 == null) {
            this.f66579a = cVar;
            this.f66580b = cVar;
            return cVar;
        }
        cVar2.f66585c = cVar;
        cVar.f66586d = cVar2;
        this.f66580b = cVar;
        return cVar;
    }

    public Object g(Object obj, Object obj2) {
        c b11 = b(obj);
        if (b11 != null) {
            return b11.f66584b;
        }
        f(obj, obj2);
        return null;
    }

    public Object h(Object obj) {
        c b11 = b(obj);
        if (b11 == null) {
            return null;
        }
        this.f66582d--;
        if (!this.f66581c.isEmpty()) {
            Iterator it = this.f66581c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(b11);
            }
        }
        c cVar = b11.f66586d;
        if (cVar != null) {
            cVar.f66585c = b11.f66585c;
        } else {
            this.f66579a = b11.f66585c;
        }
        c cVar2 = b11.f66585c;
        if (cVar2 != null) {
            cVar2.f66586d = cVar;
        } else {
            this.f66580b = cVar;
        }
        b11.f66585c = null;
        b11.f66586d = null;
        return b11.f66584b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 += ((Map.Entry) it.next()).hashCode();
        }
        return i11;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f66579a, this.f66580b);
        this.f66581c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f66582d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb2.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
