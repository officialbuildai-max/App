package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.o1;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
final class f0 implements List, KMutableList {

    /* renamed from: a, reason: collision with root package name */
    private final SnapshotStateList f4056a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4057b;

    /* renamed from: c, reason: collision with root package name */
    private int f4058c;

    /* renamed from: d, reason: collision with root package name */
    private int f4059d;

    /* loaded from: classes.dex */
    public static final class a implements ListIterator, KMutableListIterator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f4060a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f0 f4061b;

        a(Ref.IntRef intRef, f0 f0Var) {
            this.f4060a = intRef;
            this.f4061b = f0Var;
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void add(Object obj) {
            s.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            s.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Void set(Object obj) {
            s.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f4060a.element < this.f4061b.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f4060a.element >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            int i11 = this.f4060a.element + 1;
            s.g(i11, this.f4061b.size());
            this.f4060a.element = i11;
            return this.f4061b.get(i11);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f4060a.element + 1;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i11 = this.f4060a.element;
            s.g(i11, this.f4061b.size());
            this.f4060a.element = i11 - 1;
            return this.f4061b.get(i11);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f4060a.element;
        }
    }

    public f0(SnapshotStateList snapshotStateList, int i11, int i12) {
        this.f4056a = snapshotStateList;
        this.f4057b = i11;
        this.f4058c = snapshotStateList.e();
        this.f4059d = i12 - i11;
    }

    private final void e() {
        if (this.f4056a.e() != this.f4058c) {
            throw new ConcurrentModificationException();
        }
    }

    public int a() {
        return this.f4059d;
    }

    @Override // java.util.List
    public void add(int i11, Object obj) {
        e();
        this.f4056a.add(this.f4057b + i11, obj);
        this.f4059d = size() + 1;
        this.f4058c = this.f4056a.e();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        e();
        this.f4056a.add(this.f4057b + size(), obj);
        this.f4059d = size() + 1;
        this.f4058c = this.f4056a.e();
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i11, Collection collection) {
        e();
        boolean addAll = this.f4056a.addAll(i11 + this.f4057b, collection);
        if (addAll) {
            this.f4059d = size() + collection.size();
            this.f4058c = this.f4056a.e();
        }
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    public Object c(int i11) {
        e();
        Object remove = this.f4056a.remove(this.f4057b + i11);
        this.f4059d = size() - 1;
        this.f4058c = this.f4056a.e();
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            e();
            SnapshotStateList snapshotStateList = this.f4056a;
            int i11 = this.f4057b;
            snapshotStateList.j(i11, size() + i11);
            this.f4059d = 0;
            this.f4058c = this.f4056a.e();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public Object get(int i11) {
        e();
        s.g(i11, size());
        return this.f4056a.get(this.f4057b + i11);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        e();
        int i11 = this.f4057b;
        Iterator<Integer> it = RangesKt.t(i11, size() + i11).iterator();
        while (it.hasNext()) {
            int a11 = ((IntIterator) it).a();
            if (Intrinsics.c(obj, this.f4056a.get(a11))) {
                return a11 - this.f4057b;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        e();
        int size = this.f4057b + size();
        do {
            size--;
            if (size < this.f4057b) {
                return -1;
            }
        } while (!Intrinsics.c(obj, this.f4056a.get(size)));
        return size - this.f4057b;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i11) {
        e();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i11 - 1;
        return new a(intRef, this);
    }

    @Override // java.util.List
    public final /* bridge */ Object remove(int i11) {
        return c(i11);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        e();
        SnapshotStateList snapshotStateList = this.f4056a;
        int i11 = this.f4057b;
        int l11 = snapshotStateList.l(collection, i11, size() + i11);
        if (l11 > 0) {
            this.f4058c = this.f4056a.e();
            this.f4059d = size() - l11;
        }
        return l11 > 0;
    }

    @Override // java.util.List
    public Object set(int i11, Object obj) {
        s.g(i11, size());
        e();
        Object obj2 = this.f4056a.set(i11 + this.f4057b, obj);
        this.f4058c = this.f4056a.e();
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.List
    public List subList(int i11, int i12) {
        if (!(i11 >= 0 && i11 <= i12 && i12 <= size())) {
            o1.a("fromIndex or toIndex are out of bounds");
        }
        e();
        SnapshotStateList snapshotStateList = this.f4056a;
        int i13 = this.f4057b;
        return new f0(snapshotStateList, i11 + i13, i12 + i13);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }
}
