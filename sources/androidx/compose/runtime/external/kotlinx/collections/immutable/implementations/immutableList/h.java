package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t.f;

/* loaded from: classes.dex */
public final class h extends AbstractPersistentList implements t.d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3793b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f3794c = 8;

    /* renamed from: d, reason: collision with root package name */
    private static final h f3795d = new h(new Object[0]);

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f3796a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            return h.f3795d;
        }
    }

    public h(Object[] objArr) {
        this.f3796a = objArr;
        w.a.a(objArr.length <= 32);
    }

    private final Object[] h(int i11) {
        return new Object[i11];
    }

    @Override // java.util.List, t.f
    public t.f add(int i11, Object obj) {
        w.d.b(i11, size());
        if (i11 == size()) {
            return add(obj);
        }
        if (size() < 32) {
            Object[] h11 = h(size() + 1);
            ArraysKt.r(this.f3796a, h11, 0, 0, i11, 6, null);
            ArraysKt.n(this.f3796a, h11, i11 + 1, i11, size());
            h11[i11] = obj;
            return new h(h11);
        }
        Object[] objArr = this.f3796a;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        ArraysKt.n(this.f3796a, copyOf, i11 + 1, i11, size() - 1);
        copyOf[i11] = obj;
        return new d(copyOf, j.c(this.f3796a[31]), size() + 1, 0);
    }

    @Override // java.util.Collection, java.util.List, t.f
    public t.f add(Object obj) {
        if (size() >= 32) {
            return new d(this.f3796a, j.c(obj), size() + 1, 0);
        }
        Object[] copyOf = Arrays.copyOf(this.f3796a, size() + 1);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        copyOf[size()] = obj;
        return new h(copyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, t.f
    public t.f addAll(Collection collection) {
        if (size() + collection.size() > 32) {
            f.a builder = builder();
            builder.addAll(collection);
            return builder.build();
        }
        Object[] copyOf = Arrays.copyOf(this.f3796a, size() + collection.size());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            copyOf[size] = it.next();
            size++;
        }
        return new h(copyOf);
    }

    @Override // t.f
    public f.a builder() {
        return new PersistentVectorBuilder(this, null, this.f3796a, 0);
    }

    @Override // t.f
    public t.f d(int i11) {
        w.d.a(i11, size());
        if (size() == 1) {
            return f3795d;
        }
        Object[] copyOf = Arrays.copyOf(this.f3796a, size() - 1);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        ArraysKt.n(this.f3796a, copyOf, i11, i11 + 1, size());
        return new h(copyOf);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i11) {
        w.d.a(i11, size());
        return this.f3796a[i11];
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.f3796a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return ArraysKt.h0(this.f3796a, obj);
    }

    @Override // t.f
    public t.f k(Function1 function1) {
        Object[] objArr = this.f3796a;
        int size = size();
        int size2 = size();
        boolean z10 = false;
        for (int i11 = 0; i11 < size2; i11++) {
            Object obj = this.f3796a[i11];
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                if (!z10) {
                    Object[] objArr2 = this.f3796a;
                    objArr = Arrays.copyOf(objArr2, objArr2.length);
                    Intrinsics.g(objArr, "copyOf(this, size)");
                    z10 = true;
                    size = i11;
                }
            } else if (z10) {
                objArr[size] = obj;
                size++;
            }
        }
        return size == size() ? this : size == 0 ? f3795d : new h(ArraysKt.t(objArr, 0, size));
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return ArraysKt.v0(this.f3796a, obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i11) {
        w.d.b(i11, size());
        return new b(this.f3796a, i11, size());
    }

    @Override // kotlin.collections.AbstractList, java.util.List, t.f
    public t.f set(int i11, Object obj) {
        w.d.a(i11, size());
        Object[] objArr = this.f3796a;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        copyOf[i11] = obj;
        return new h(copyOf);
    }
}
