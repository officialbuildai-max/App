package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
public class LinkedListMultimap<K, V> extends com.google.common.collect.c implements i3, Serializable {
    private static final long serialVersionUID = 0;
    private transient g head;
    private transient Map<K, f> keyToKeyList;
    private transient int modCount;
    private transient int size;
    private transient g tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AbstractSequentialList {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f30559a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinkedListMultimap f30560b;

        a(LinkedListMultimap linkedListMultimap, Object obj) {
            this.f30559a = obj;
            this.f30560b = linkedListMultimap;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i11) {
            return new i(this.f30559a, i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) this.f30560b.keyToKeyList.get(this.f30559a);
            if (fVar == null) {
                return 0;
            }
            return fVar.f30573c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends AbstractSequentialList {
        b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i11) {
            return new h(i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: classes4.dex */
    class c extends Sets.e {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends AbstractSequentialList {

        /* loaded from: classes4.dex */
        class a extends p4 {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f30564b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f30565c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f30564b = hVar;
                this.f30565c = dVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.o4
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object a(Map.Entry entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.p4, java.util.ListIterator
            public void set(Object obj) {
                this.f30564b.f(obj);
            }
        }

        d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i11) {
            h hVar = new h(i11);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: classes4.dex */
    private class e implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        final Set f30566a;

        /* renamed from: b, reason: collision with root package name */
        g f30567b;

        /* renamed from: c, reason: collision with root package name */
        g f30568c;

        /* renamed from: d, reason: collision with root package name */
        int f30569d;

        private e() {
            this.f30566a = Sets.g(LinkedListMultimap.this.keySet().size());
            this.f30567b = LinkedListMultimap.this.head;
            this.f30569d = LinkedListMultimap.this.modCount;
        }

        /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }

        private void a() {
            if (LinkedListMultimap.this.modCount != this.f30569d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f30567b != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            g gVar;
            a();
            g gVar2 = this.f30567b;
            if (gVar2 == null) {
                throw new NoSuchElementException();
            }
            this.f30568c = gVar2;
            this.f30566a.add(gVar2.f30574a);
            do {
                gVar = this.f30567b.f30576c;
                this.f30567b = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f30566a.add(gVar.f30574a));
            return this.f30568c.f30574a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.base.m.v(this.f30568c != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.f30568c.f30574a);
            this.f30568c = null;
            this.f30569d = LinkedListMultimap.this.modCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        g f30571a;

        /* renamed from: b, reason: collision with root package name */
        g f30572b;

        /* renamed from: c, reason: collision with root package name */
        int f30573c;

        f(g gVar) {
            this.f30571a = gVar;
            this.f30572b = gVar;
            gVar.f30579f = null;
            gVar.f30578e = null;
            this.f30573c = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class g extends com.google.common.collect.b {

        /* renamed from: a, reason: collision with root package name */
        final Object f30574a;

        /* renamed from: b, reason: collision with root package name */
        Object f30575b;

        /* renamed from: c, reason: collision with root package name */
        g f30576c;

        /* renamed from: d, reason: collision with root package name */
        g f30577d;

        /* renamed from: e, reason: collision with root package name */
        g f30578e;

        /* renamed from: f, reason: collision with root package name */
        g f30579f;

        g(Object obj, Object obj2) {
            this.f30574a = obj;
            this.f30575b = obj2;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getKey() {
            return this.f30574a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getValue() {
            return this.f30575b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f30575b;
            this.f30575b = obj;
            return obj2;
        }
    }

    /* loaded from: classes4.dex */
    private class h implements ListIterator {

        /* renamed from: a, reason: collision with root package name */
        int f30580a;

        /* renamed from: b, reason: collision with root package name */
        g f30581b;

        /* renamed from: c, reason: collision with root package name */
        g f30582c;

        /* renamed from: d, reason: collision with root package name */
        g f30583d;

        /* renamed from: e, reason: collision with root package name */
        int f30584e;

        h(int i11) {
            this.f30584e = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            com.google.common.base.m.r(i11, size);
            if (i11 < size / 2) {
                this.f30581b = LinkedListMultimap.this.head;
                while (true) {
                    int i12 = i11 - 1;
                    if (i11 <= 0) {
                        break;
                    }
                    next();
                    i11 = i12;
                }
            } else {
                this.f30583d = LinkedListMultimap.this.tail;
                this.f30580a = size;
                while (true) {
                    int i13 = i11 + 1;
                    if (i11 >= size) {
                        break;
                    }
                    previous();
                    i11 = i13;
                }
            }
            this.f30582c = null;
        }

        private void b() {
            if (LinkedListMultimap.this.modCount != this.f30584e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public g next() {
            b();
            g gVar = this.f30581b;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f30582c = gVar;
            this.f30583d = gVar;
            this.f30581b = gVar.f30576c;
            this.f30580a++;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public g previous() {
            b();
            g gVar = this.f30583d;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f30582c = gVar;
            this.f30581b = gVar;
            this.f30583d = gVar.f30577d;
            this.f30580a--;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        void f(Object obj) {
            com.google.common.base.m.u(this.f30582c != null);
            this.f30582c.f30575b = obj;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f30581b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f30583d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f30580a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f30580a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            com.google.common.base.m.v(this.f30582c != null, "no calls to next() since the last call to remove()");
            g gVar = this.f30582c;
            if (gVar != this.f30581b) {
                this.f30583d = gVar.f30577d;
                this.f30580a--;
            } else {
                this.f30581b = gVar.f30576c;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f30582c = null;
            this.f30584e = LinkedListMultimap.this.modCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class i implements ListIterator {

        /* renamed from: a, reason: collision with root package name */
        final Object f30586a;

        /* renamed from: b, reason: collision with root package name */
        int f30587b;

        /* renamed from: c, reason: collision with root package name */
        g f30588c;

        /* renamed from: d, reason: collision with root package name */
        g f30589d;

        /* renamed from: e, reason: collision with root package name */
        g f30590e;

        i(Object obj) {
            this.f30586a = obj;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.f30588c = fVar == null ? null : fVar.f30571a;
        }

        public i(Object obj, int i11) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i12 = fVar == null ? 0 : fVar.f30573c;
            com.google.common.base.m.r(i11, i12);
            if (i11 < i12 / 2) {
                this.f30588c = fVar == null ? null : fVar.f30571a;
                while (true) {
                    int i13 = i11 - 1;
                    if (i11 <= 0) {
                        break;
                    }
                    next();
                    i11 = i13;
                }
            } else {
                this.f30590e = fVar == null ? null : fVar.f30572b;
                this.f30587b = i12;
                while (true) {
                    int i14 = i11 + 1;
                    if (i11 >= i12) {
                        break;
                    }
                    previous();
                    i11 = i14;
                }
            }
            this.f30586a = obj;
            this.f30589d = null;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.f30590e = LinkedListMultimap.this.addNode(this.f30586a, obj, this.f30588c);
            this.f30587b++;
            this.f30589d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f30588c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f30590e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            g gVar = this.f30588c;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f30589d = gVar;
            this.f30590e = gVar;
            this.f30588c = gVar.f30578e;
            this.f30587b++;
            return gVar.f30575b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f30587b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            g gVar = this.f30590e;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f30589d = gVar;
            this.f30588c = gVar;
            this.f30590e = gVar.f30579f;
            this.f30587b--;
            return gVar.f30575b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f30587b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            com.google.common.base.m.v(this.f30589d != null, "no calls to next() since the last call to remove()");
            g gVar = this.f30589d;
            if (gVar != this.f30588c) {
                this.f30590e = gVar.f30579f;
                this.f30587b--;
            } else {
                this.f30588c = gVar.f30578e;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f30589d = null;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            com.google.common.base.m.u(this.f30589d != null);
            this.f30589d.f30575b = obj;
        }
    }

    LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int i11) {
        this.keyToKeyList = r3.d(i11);
    }

    private LinkedListMultimap(j3 j3Var) {
        this(j3Var.keySet().size());
        putAll(j3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g addNode(K k11, V v11, g gVar) {
        g gVar2 = new g(k11, v11);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k11, new f(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g gVar3 = this.tail;
            Objects.requireNonNull(gVar3);
            gVar3.f30576c = gVar2;
            gVar2.f30577d = this.tail;
            this.tail = gVar2;
            f fVar = this.keyToKeyList.get(k11);
            if (fVar == null) {
                this.keyToKeyList.put(k11, new f(gVar2));
                this.modCount++;
            } else {
                fVar.f30573c++;
                g gVar4 = fVar.f30572b;
                gVar4.f30578e = gVar2;
                gVar2.f30579f = gVar4;
                fVar.f30572b = gVar2;
            }
        } else {
            f fVar2 = this.keyToKeyList.get(k11);
            Objects.requireNonNull(fVar2);
            fVar2.f30573c++;
            gVar2.f30577d = gVar.f30577d;
            gVar2.f30579f = gVar.f30579f;
            gVar2.f30576c = gVar;
            gVar2.f30578e = gVar;
            g gVar5 = gVar.f30579f;
            if (gVar5 == null) {
                fVar2.f30571a = gVar2;
            } else {
                gVar5.f30578e = gVar2;
            }
            g gVar6 = gVar.f30577d;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f30576c = gVar2;
            }
            gVar.f30577d = gVar2;
            gVar.f30579f = gVar2;
        }
        this.size++;
        return gVar2;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i11) {
        return new LinkedListMultimap<>(i11);
    }

    public static <K, V> LinkedListMultimap<K, V> create(j3 j3Var) {
        return new LinkedListMultimap<>(j3Var);
    }

    private List<V> getCopy(K k11) {
        return Collections.unmodifiableList(Lists.k(new i(k11)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(K k11) {
        Iterators.d(new i(k11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g gVar) {
        g gVar2 = gVar.f30577d;
        if (gVar2 != null) {
            gVar2.f30576c = gVar.f30576c;
        } else {
            this.head = gVar.f30576c;
        }
        g gVar3 = gVar.f30576c;
        if (gVar3 != null) {
            gVar3.f30577d = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.f30579f == null && gVar.f30578e == null) {
            f remove = this.keyToKeyList.remove(gVar.f30574a);
            Objects.requireNonNull(remove);
            remove.f30573c = 0;
            this.modCount++;
        } else {
            f fVar = this.keyToKeyList.get(gVar.f30574a);
            Objects.requireNonNull(fVar);
            fVar.f30573c--;
            g gVar4 = gVar.f30579f;
            if (gVar4 == null) {
                g gVar5 = gVar.f30578e;
                Objects.requireNonNull(gVar5);
                fVar.f30571a = gVar5;
            } else {
                gVar4.f30578e = gVar.f30578e;
            }
            g gVar6 = gVar.f30578e;
            if (gVar6 == null) {
                g gVar7 = gVar.f30579f;
                Objects.requireNonNull(gVar7);
                fVar.f30572b = gVar7;
            } else {
                gVar6.f30579f = gVar.f30579f;
            }
        }
        this.size--;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.j3
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.j3
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.c
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.c
    Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    @Override // com.google.common.collect.c
    Set<K> createKeySet() {
        return new c();
    }

    @Override // com.google.common.collect.c
    l3 createKeys() {
        return new Multimaps.c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public List<V> createValues() {
        return new d();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.c
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j3
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.j3
    public List<V> get(K k11) {
        return new a(this, k11);
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ l3 keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public boolean put(K k11, V v11) {
        addNode(k11, v11, null);
        return true;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public /* bridge */ /* synthetic */ boolean putAll(j3 j3Var) {
        return super.putAll(j3Var);
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j3
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return m839replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    /* renamed from: replaceValues, reason: collision with other method in class */
    public List<V> m839replaceValues(K k11, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k11);
        i iVar = new i(k11);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.j3
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j3
    public List<V> values() {
        return (List) super.values();
    }
}
