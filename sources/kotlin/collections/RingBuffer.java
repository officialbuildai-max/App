package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class RingBuffer extends AbstractList implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f67258a;

    /* renamed from: b, reason: collision with root package name */
    private final int f67259b;

    /* renamed from: c, reason: collision with root package name */
    private int f67260c;

    /* renamed from: d, reason: collision with root package name */
    private int f67261d;

    public RingBuffer(int i11) {
        this(new Object[i11], 0);
    }

    public RingBuffer(Object[] buffer, int i11) {
        Intrinsics.h(buffer, "buffer");
        this.f67258a = buffer;
        if (i11 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i11).toString());
        }
        if (i11 <= buffer.length) {
            this.f67259b = buffer.length;
            this.f67261d = i11;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i11 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // java.util.Collection, java.util.List
    public final void add(Object obj) {
        if (l()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f67258a[(this.f67260c + size()) % this.f67259b] = obj;
        this.f67261d = size() + 1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i11) {
        AbstractList.INSTANCE.b(i11, size());
        return this.f67258a[(this.f67260c + i11) % this.f67259b];
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.f67261d;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new AbstractIterator<Object>() { // from class: kotlin.collections.RingBuffer$iterator$1

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private int count;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private int index;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i11;
                this.count = RingBuffer.this.size();
                i11 = RingBuffer.this.f67260c;
                this.index = i11;
            }

            @Override // kotlin.collections.AbstractIterator
            protected void a() {
                Object[] objArr;
                if (this.count == 0) {
                    c();
                    return;
                }
                objArr = RingBuffer.this.f67258a;
                e(objArr[this.index]);
                this.index = (this.index + 1) % RingBuffer.this.f67259b;
                this.count--;
            }
        };
    }

    public final RingBuffer j(int i11) {
        Object[] array;
        int i12 = this.f67259b;
        int i13 = RangesKt.i(i12 + (i12 >> 1) + 1, i11);
        if (this.f67260c == 0) {
            array = Arrays.copyOf(this.f67258a, i13);
            Intrinsics.g(array, "copyOf(...)");
        } else {
            array = toArray(new Object[i13]);
        }
        return new RingBuffer(array, size());
    }

    public final boolean l() {
        return size() == this.f67259b;
    }

    public final void m(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i11).toString());
        }
        if (i11 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i11 + ", size = " + size()).toString());
        }
        if (i11 > 0) {
            int i12 = this.f67260c;
            int i13 = (i12 + i11) % this.f67259b;
            if (i12 > i13) {
                ArraysKt.w(this.f67258a, null, i12, this.f67259b);
                ArraysKt.w(this.f67258a, null, 0, i13);
            } else {
                ArraysKt.w(this.f67258a, null, i12, i13);
            }
            this.f67260c = i13;
            this.f67261d = size() - i11;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.h(array, "array");
        if (array.length < size()) {
            array = Arrays.copyOf(array, size());
            Intrinsics.g(array, "copyOf(...)");
        }
        int size = size();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = this.f67260c; i12 < size && i13 < this.f67259b; i13++) {
            array[i12] = this.f67258a[i13];
            i12++;
        }
        while (i12 < size) {
            array[i12] = this.f67258a[i11];
            i12++;
            i11++;
        }
        return CollectionsKt.g(size, array);
    }
}
