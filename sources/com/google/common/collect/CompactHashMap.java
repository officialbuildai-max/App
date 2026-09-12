package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* renamed from: g, reason: collision with root package name */
    private static final Object f30382g = new Object();

    /* renamed from: a, reason: collision with root package name */
    private transient Object f30383a;

    /* renamed from: b, reason: collision with root package name */
    private transient int f30384b;

    /* renamed from: c, reason: collision with root package name */
    private transient int f30385c;

    /* renamed from: d, reason: collision with root package name */
    private transient Set f30386d;

    /* renamed from: e, reason: collision with root package name */
    private transient Set f30387e;
    transient int[] entries;

    /* renamed from: f, reason: collision with root package name */
    private transient Collection f30388f;
    transient Object[] keys;
    transient Object[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends e {
        a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        Object b(int i11) {
            return CompactHashMap.this.e(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends e {
        b() {
            super(CompactHashMap.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.CompactHashMap.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry b(int i11) {
            return new g(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends e {
        c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        Object b(int i11) {
            return CompactHashMap.this.r(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends AbstractSet {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int d11 = CompactHashMap.this.d(entry.getKey());
            return d11 != -1 && com.google.common.base.j.a(CompactHashMap.this.r(d11), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int c11 = CompactHashMap.this.c();
            int f11 = g2.f(entry.getKey(), entry.getValue(), c11, CompactHashMap.this.j(), CompactHashMap.this.h(), CompactHashMap.this.i(), CompactHashMap.this.k());
            if (f11 == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(f11, c11);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* loaded from: classes4.dex */
    private abstract class e implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        int f30393a;

        /* renamed from: b, reason: collision with root package name */
        int f30394b;

        /* renamed from: c, reason: collision with root package name */
        int f30395c;

        private e() {
            this.f30393a = CompactHashMap.this.f30384b;
            this.f30394b = CompactHashMap.this.firstEntryIndex();
            this.f30395c = -1;
        }

        /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }

        private void a() {
            if (CompactHashMap.this.f30384b != this.f30393a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i11);

        void c() {
            this.f30393a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30394b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i11 = this.f30394b;
            this.f30395c = i11;
            Object b11 = b(i11);
            this.f30394b = CompactHashMap.this.getSuccessor(this.f30394b);
            return b11;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e2.e(this.f30395c >= 0);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.e(this.f30395c));
            this.f30394b = CompactHashMap.this.adjustAfterRemove(this.f30394b, this.f30395c);
            this.f30395c = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends AbstractSet {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            return delegateOrNull != null ? delegateOrNull.keySet().remove(obj) : CompactHashMap.this.f(obj) != CompactHashMap.f30382g;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class g extends com.google.common.collect.b {

        /* renamed from: a, reason: collision with root package name */
        private final Object f30398a;

        /* renamed from: b, reason: collision with root package name */
        private int f30399b;

        g(int i11) {
            this.f30398a = CompactHashMap.this.e(i11);
            this.f30399b = i11;
        }

        private void a() {
            int i11 = this.f30399b;
            if (i11 == -1 || i11 >= CompactHashMap.this.size() || !com.google.common.base.j.a(this.f30398a, CompactHashMap.this.e(this.f30399b))) {
                this.f30399b = CompactHashMap.this.d(this.f30398a);
            }
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getKey() {
            return this.f30398a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getValue() {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return m3.a(delegateOrNull.get(this.f30398a));
            }
            a();
            int i11 = this.f30399b;
            return i11 == -1 ? m3.b() : CompactHashMap.this.r(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object setValue(Object obj) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != 0) {
                return m3.a(delegateOrNull.put(this.f30398a, obj));
            }
            a();
            int i11 = this.f30399b;
            if (i11 == -1) {
                CompactHashMap.this.put(this.f30398a, obj);
                return m3.b();
            }
            Object r11 = CompactHashMap.this.r(i11);
            CompactHashMap.this.q(this.f30399b, obj);
            return r11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends AbstractCollection {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    CompactHashMap() {
        init(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashMap(int i11) {
        init(i11);
    }

    private int a(int i11) {
        return h()[i11];
    }

    static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i11 = compactHashMap.f30385c;
        compactHashMap.f30385c = i11 - 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        return (1 << (this.f30384b & 31)) - 1;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i11) {
        return new CompactHashMap<>(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int d11 = v2.d(obj);
        int c11 = c();
        int h11 = g2.h(j(), d11 & c11);
        if (h11 == 0) {
            return -1;
        }
        int b11 = g2.b(d11, c11);
        do {
            int i11 = h11 - 1;
            int a11 = a(i11);
            if (g2.b(a11, c11) == b11 && com.google.common.base.j.a(obj, e(i11))) {
                return i11;
            }
            h11 = g2.c(a11, c11);
        } while (h11 != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object e(int i11) {
        return i()[i11];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object f(Object obj) {
        if (needsAllocArrays()) {
            return f30382g;
        }
        int c11 = c();
        int f11 = g2.f(obj, null, c11, j(), h(), i(), null);
        if (f11 == -1) {
            return f30382g;
        }
        Object r11 = r(f11);
        moveLastEntry(f11, c11);
        this.f30385c--;
        incrementModCount();
        return r11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] h() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] i() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object j() {
        Object obj = this.f30383a;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] k() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void l(int i11) {
        int min;
        int length = h().length;
        if (i11 <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    private int m(int i11, int i12, int i13, int i14) {
        Object a11 = g2.a(i12);
        int i15 = i12 - 1;
        if (i14 != 0) {
            g2.i(a11, i13 & i15, i14 + 1);
        }
        Object j11 = j();
        int[] h11 = h();
        for (int i16 = 0; i16 <= i11; i16++) {
            int h12 = g2.h(j11, i16);
            while (h12 != 0) {
                int i17 = h12 - 1;
                int i18 = h11[i17];
                int b11 = g2.b(i18, i11) | i16;
                int i19 = b11 & i15;
                int h13 = g2.h(a11, i19);
                g2.i(a11, i19, h12);
                h11[i17] = g2.d(b11, h13, i15);
                h12 = g2.c(i18, i11);
            }
        }
        this.f30383a = a11;
        o(i15);
        return i15;
    }

    private void n(int i11, int i12) {
        h()[i11] = i12;
    }

    private void o(int i11) {
        this.f30384b = g2.d(this.f30384b, 32 - Integer.numberOfLeadingZeros(i11), 31);
    }

    private void p(int i11, Object obj) {
        i()[i11] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i11, Object obj) {
        k()[i11] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object r(int i11) {
        return k()[i11];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid size: " + readInt);
        }
        init(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> entrySetIterator = entrySetIterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry<K, V> next = entrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    void accessEntry(int i11) {
    }

    int adjustAfterRemove(int i11, int i12) {
        return i11 - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int allocArrays() {
        com.google.common.base.m.v(needsAllocArrays(), "Arrays already allocated");
        int i11 = this.f30384b;
        int j11 = g2.j(i11);
        this.f30383a = g2.a(j11);
        o(j11 - 1);
        this.entries = new int[i11];
        this.keys = new Object[i11];
        this.values = new Object[i11];
        return i11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.f30384b = Ints.f(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.f30383a = null;
            this.f30385c = 0;
            return;
        }
        Arrays.fill(i(), 0, this.f30385c, (Object) null);
        Arrays.fill(k(), 0, this.f30385c, (Object) null);
        g2.g(j());
        Arrays.fill(h(), 0, this.f30385c, 0);
        this.f30385c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.containsKey(obj) : d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i11 = 0; i11 < this.f30385c; i11++) {
            if (com.google.common.base.j.a(obj, r(i11))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(c() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.put(e(firstEntryIndex), r(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.f30383a = createHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    Map<K, V> createHashFloodingResistantDelegate(int i11) {
        return new LinkedHashMap(i11, 1.0f);
    }

    Set<K> createKeySet() {
        return new f();
    }

    Collection<V> createValues() {
        return new h();
    }

    Map<K, V> delegateOrNull() {
        Object obj = this.f30383a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f30387e;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.f30387e = createEntrySet;
        return createEntrySet;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.entrySet().iterator() : new b();
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int d11 = d(obj);
        if (d11 == -1) {
            return null;
        }
        accessEntry(d11);
        return (V) r(d11);
    }

    int getSuccessor(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.f30385c) {
            return i12;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void incrementModCount() {
        this.f30384b += 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(int i11) {
        com.google.common.base.m.e(i11 >= 0, "Expected size must be >= 0");
        this.f30384b = Ints.f(i11, 1, 1073741823);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertEntry(int i11, K k11, V v11, int i12, int i13) {
        n(i11, g2.d(i12, 0, i13));
        p(i11, k11);
        q(i11, v11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f30386d;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.f30386d = createKeySet;
        return createKeySet;
    }

    Iterator<K> keySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.keySet().iterator() : new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void moveLastEntry(int i11, int i12) {
        Object j11 = j();
        int[] h11 = h();
        Object[] i13 = i();
        Object[] k11 = k();
        int size = size();
        int i14 = size - 1;
        if (i11 >= i14) {
            i13[i11] = null;
            k11[i11] = null;
            h11[i11] = 0;
            return;
        }
        Object obj = i13[i14];
        i13[i11] = obj;
        k11[i11] = k11[i14];
        i13[i14] = null;
        k11[i14] = null;
        h11[i11] = h11[i14];
        h11[i14] = 0;
        int d11 = v2.d(obj) & i12;
        int h12 = g2.h(j11, d11);
        if (h12 == size) {
            g2.i(j11, d11, i11 + 1);
            return;
        }
        while (true) {
            int i15 = h12 - 1;
            int i16 = h11[i15];
            int c11 = g2.c(i16, i12);
            if (c11 == size) {
                h11[i15] = g2.d(i16, i11 + 1, i12);
                return;
            }
            h12 = c11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needsAllocArrays() {
        return this.f30383a == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        int m11;
        int i11;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k11, v11);
        }
        int[] h11 = h();
        Object[] i12 = i();
        Object[] k12 = k();
        int i13 = this.f30385c;
        int i14 = i13 + 1;
        int d11 = v2.d(k11);
        int c11 = c();
        int i15 = d11 & c11;
        int h12 = g2.h(j(), i15);
        if (h12 != 0) {
            int b11 = g2.b(d11, c11);
            int i16 = 0;
            while (true) {
                int i17 = h12 - 1;
                int i18 = h11[i17];
                if (g2.b(i18, c11) == b11 && com.google.common.base.j.a(k11, i12[i17])) {
                    V v12 = (V) k12[i17];
                    k12[i17] = v11;
                    accessEntry(i17);
                    return v12;
                }
                int c12 = g2.c(i18, c11);
                i16++;
                if (c12 != 0) {
                    h12 = c12;
                } else {
                    if (i16 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k11, v11);
                    }
                    if (i14 > c11) {
                        m11 = m(c11, g2.e(c11), d11, i13);
                    } else {
                        h11[i17] = g2.d(i18, i14, c11);
                    }
                }
            }
        } else if (i14 > c11) {
            m11 = m(c11, g2.e(c11), d11, i13);
            i11 = m11;
        } else {
            g2.i(j(), i15, i14);
            i11 = c11;
        }
        l(i14);
        insertEntry(i13, k11, v11, d11, i11);
        this.f30385c = i14;
        incrementModCount();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V v11 = (V) f(obj);
        if (v11 == f30382g) {
            return null;
        }
        return v11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resizeEntries(int i11) {
        this.entries = Arrays.copyOf(h(), i11);
        this.keys = Arrays.copyOf(i(), i11);
        this.values = Arrays.copyOf(k(), i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.f30385c;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            createHashFloodingResistantDelegate.putAll(delegateOrNull);
            this.f30383a = createHashFloodingResistantDelegate;
            return;
        }
        int i11 = this.f30385c;
        if (i11 < h().length) {
            resizeEntries(i11);
        }
        int j11 = g2.j(i11);
        int c11 = c();
        if (j11 < c11) {
            m(c11, j11, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f30388f;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.f30388f = createValues;
        return createValues;
    }

    Iterator<V> valuesIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.values().iterator() : new c();
    }
}
