package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* renamed from: a, reason: collision with root package name */
    private transient Object f30402a;

    /* renamed from: b, reason: collision with root package name */
    private transient int[] f30403b;

    /* renamed from: c, reason: collision with root package name */
    private transient int f30404c;

    /* renamed from: d, reason: collision with root package name */
    private transient int f30405d;
    transient Object[] elements;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        int f30406a;

        /* renamed from: b, reason: collision with root package name */
        int f30407b;

        /* renamed from: c, reason: collision with root package name */
        int f30408c = -1;

        a() {
            this.f30406a = CompactHashSet.this.f30404c;
            this.f30407b = CompactHashSet.this.firstEntryIndex();
        }

        private void a() {
            if (CompactHashSet.this.f30404c != this.f30406a) {
                throw new ConcurrentModificationException();
            }
        }

        void b() {
            this.f30406a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30407b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i11 = this.f30407b;
            this.f30408c = i11;
            Object b11 = CompactHashSet.this.b(i11);
            this.f30407b = CompactHashSet.this.getSuccessor(this.f30407b);
            return b11;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e2.e(this.f30408c >= 0);
            b();
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.remove(compactHashSet.b(this.f30408c));
            this.f30407b = CompactHashSet.this.adjustAfterRemove(this.f30407b, this.f30408c);
            this.f30408c = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashSet() {
        init(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashSet(int i11) {
        init(i11);
    }

    private Set a(int i11) {
        return new LinkedHashSet(i11, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object b(int i11) {
        return f()[i11];
    }

    private int c(int i11) {
        return g()[i11];
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i11) {
        return new CompactHashSet<>(i11);
    }

    private int e() {
        return (1 << (this.f30404c & 31)) - 1;
    }

    private Object[] f() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] g() {
        int[] iArr = this.f30403b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private Object h() {
        Object obj = this.f30402a;
        Objects.requireNonNull(obj);
        return obj;
    }

    private void j(int i11) {
        int min;
        int length = g().length;
        if (i11 <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    private int l(int i11, int i12, int i13, int i14) {
        Object a11 = g2.a(i12);
        int i15 = i12 - 1;
        if (i14 != 0) {
            g2.i(a11, i13 & i15, i14 + 1);
        }
        Object h11 = h();
        int[] g11 = g();
        for (int i16 = 0; i16 <= i11; i16++) {
            int h12 = g2.h(h11, i16);
            while (h12 != 0) {
                int i17 = h12 - 1;
                int i18 = g11[i17];
                int b11 = g2.b(i18, i11) | i16;
                int i19 = b11 & i15;
                int h13 = g2.h(a11, i19);
                g2.i(a11, i19, h12);
                g11[i17] = g2.d(b11, h13, i15);
                h12 = g2.c(i18, i11);
            }
        }
        this.f30402a = a11;
        o(i15);
        return i15;
    }

    private void m(int i11, Object obj) {
        f()[i11] = obj;
    }

    private void n(int i11, int i12) {
        g()[i11] = i12;
    }

    private void o(int i11) {
        this.f30404c = g2.d(this.f30404c, 32 - Integer.numberOfLeadingZeros(i11), 31);
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
            add(objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e11) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.add(e11);
        }
        int[] g11 = g();
        Object[] f11 = f();
        int i11 = this.f30405d;
        int i12 = i11 + 1;
        int d11 = v2.d(e11);
        int e12 = e();
        int i13 = d11 & e12;
        int h11 = g2.h(h(), i13);
        if (h11 != 0) {
            int b11 = g2.b(d11, e12);
            int i14 = 0;
            while (true) {
                int i15 = h11 - 1;
                int i16 = g11[i15];
                if (g2.b(i16, e12) == b11 && com.google.common.base.j.a(e11, f11[i15])) {
                    return false;
                }
                int c11 = g2.c(i16, e12);
                i14++;
                if (c11 != 0) {
                    h11 = c11;
                } else {
                    if (i14 >= 9) {
                        return convertToHashFloodingResistantImplementation().add(e11);
                    }
                    if (i12 > e12) {
                        e12 = l(e12, g2.e(e12), d11, i11);
                    } else {
                        g11[i15] = g2.d(i16, i12, e12);
                    }
                }
            }
        } else if (i12 > e12) {
            e12 = l(e12, g2.e(e12), d11, i11);
        } else {
            g2.i(h(), i13, i12);
        }
        j(i12);
        insertEntry(i11, e11, d11, e12);
        this.f30405d = i12;
        incrementModCount();
        return true;
    }

    int adjustAfterRemove(int i11, int i12) {
        return i11 - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int allocArrays() {
        com.google.common.base.m.v(needsAllocArrays(), "Arrays already allocated");
        int i11 = this.f30404c;
        int j11 = g2.j(i11);
        this.f30402a = g2.a(j11);
        o(j11 - 1);
        this.f30403b = new int[i11];
        this.elements = new Object[i11];
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.f30404c = Ints.f(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.f30402a = null;
            this.f30405d = 0;
            return;
        }
        Arrays.fill(f(), 0, this.f30405d, (Object) null);
        g2.g(h());
        Arrays.fill(g(), 0, this.f30405d, 0);
        this.f30405d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.contains(obj);
        }
        int d11 = v2.d(obj);
        int e11 = e();
        int h11 = g2.h(h(), d11 & e11);
        if (h11 == 0) {
            return false;
        }
        int b11 = g2.b(d11, e11);
        do {
            int i11 = h11 - 1;
            int c11 = c(i11);
            if (g2.b(c11, e11) == b11 && com.google.common.base.j.a(obj, b(i11))) {
                return true;
            }
            h11 = g2.c(c11, e11);
        } while (h11 != 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public Set<E> convertToHashFloodingResistantImplementation() {
        androidx.compose.runtime.snapshots.o oVar = (Set<E>) a(e() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            oVar.add(b(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.f30402a = oVar;
        this.f30403b = null;
        this.elements = null;
        incrementModCount();
        return oVar;
    }

    Set<E> delegateOrNull() {
        Object obj = this.f30402a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    int getSuccessor(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.f30405d) {
            return i12;
        }
        return -1;
    }

    void incrementModCount() {
        this.f30404c += 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(int i11) {
        com.google.common.base.m.e(i11 >= 0, "Expected size must be >= 0");
        this.f30404c = Ints.f(i11, 1, 1073741823);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertEntry(int i11, E e11, int i12, int i13) {
        n(i11, g2.d(i12, 0, i13));
        m(i11, e11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.iterator() : new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void moveLastEntry(int i11, int i12) {
        Object h11 = h();
        int[] g11 = g();
        Object[] f11 = f();
        int size = size();
        int i13 = size - 1;
        if (i11 >= i13) {
            f11[i11] = null;
            g11[i11] = 0;
            return;
        }
        Object obj = f11[i13];
        f11[i11] = obj;
        f11[i13] = null;
        g11[i11] = g11[i13];
        g11[i13] = 0;
        int d11 = v2.d(obj) & i12;
        int h12 = g2.h(h11, d11);
        if (h12 == size) {
            g2.i(h11, d11, i11 + 1);
            return;
        }
        while (true) {
            int i14 = h12 - 1;
            int i15 = g11[i14];
            int c11 = g2.c(i15, i12);
            if (c11 == size) {
                g11[i14] = g2.d(i15, i11 + 1, i12);
                return;
            }
            h12 = c11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needsAllocArrays() {
        return this.f30402a == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        int e11 = e();
        int f11 = g2.f(obj, null, e11, h(), g(), f(), null);
        if (f11 == -1) {
            return false;
        }
        moveLastEntry(f11, e11);
        this.f30405d--;
        incrementModCount();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resizeEntries(int i11) {
        this.f30403b = Arrays.copyOf(g(), i11);
        this.elements = Arrays.copyOf(f(), i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.f30405d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.toArray() : Arrays.copyOf(f(), this.f30405d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (!needsAllocArrays()) {
            Set<E> delegateOrNull = delegateOrNull();
            return delegateOrNull != null ? (T[]) delegateOrNull.toArray(tArr) : (T[]) n3.h(f(), 0, this.f30405d, tArr);
        }
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Set a11 = a(size());
            a11.addAll(delegateOrNull);
            this.f30402a = a11;
            return;
        }
        int i11 = this.f30405d;
        if (i11 < g().length) {
            resizeEntries(i11);
        }
        int j11 = g2.j(i11);
        int e11 = e();
        if (j11 < e11) {
            l(e11, j11, 0, 0);
        }
    }
}
