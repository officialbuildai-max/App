package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.l3;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
public final class TreeMultiset<E> extends h implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient e header;
    private final transient GeneralRange<E> range;
    private final transient f rootReference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(e eVar) {
                return eVar.f30772b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(e eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f30774d;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(e eVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(e eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f30773c;
            }
        };

        /* synthetic */ Aggregate(a aVar) {
            this();
        }

        abstract int nodeAggregate(e eVar);

        abstract long treeAggregate(e eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends Multisets.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f30762a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TreeMultiset f30763b;

        a(TreeMultiset treeMultiset, e eVar) {
            this.f30762a = eVar;
            this.f30763b = treeMultiset;
        }

        @Override // com.google.common.collect.l3.a
        public int getCount() {
            int w11 = this.f30762a.w();
            return w11 == 0 ? this.f30763b.count(getElement()) : w11;
        }

        @Override // com.google.common.collect.l3.a
        public Object getElement() {
            return this.f30762a.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        e f30764a;

        /* renamed from: b, reason: collision with root package name */
        l3.a f30765b;

        b() {
            this.f30764a = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l3.a next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeMultiset treeMultiset = TreeMultiset.this;
            e eVar = this.f30764a;
            Objects.requireNonNull(eVar);
            l3.a wrapEntry = treeMultiset.wrapEntry(eVar);
            this.f30765b = wrapEntry;
            if (this.f30764a.L() == TreeMultiset.this.header) {
                this.f30764a = null;
            } else {
                this.f30764a = this.f30764a.L();
            }
            return wrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f30764a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooHigh(this.f30764a.x())) {
                return true;
            }
            this.f30764a = null;
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.v(this.f30765b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f30765b.getElement(), 0);
            this.f30765b = null;
        }
    }

    /* loaded from: classes4.dex */
    class c implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        e f30767a;

        /* renamed from: b, reason: collision with root package name */
        l3.a f30768b = null;

        c() {
            this.f30767a = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l3.a next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Objects.requireNonNull(this.f30767a);
            l3.a wrapEntry = TreeMultiset.this.wrapEntry(this.f30767a);
            this.f30768b = wrapEntry;
            if (this.f30767a.z() == TreeMultiset.this.header) {
                this.f30767a = null;
            } else {
                this.f30767a = this.f30767a.z();
            }
            return wrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f30767a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooLow(this.f30767a.x())) {
                return true;
            }
            this.f30767a = null;
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.v(this.f30768b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f30768b.getElement(), 0);
            this.f30768b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30770a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f30770a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30770a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final Object f30771a;

        /* renamed from: b, reason: collision with root package name */
        private int f30772b;

        /* renamed from: c, reason: collision with root package name */
        private int f30773c;

        /* renamed from: d, reason: collision with root package name */
        private long f30774d;

        /* renamed from: e, reason: collision with root package name */
        private int f30775e;

        /* renamed from: f, reason: collision with root package name */
        private e f30776f;

        /* renamed from: g, reason: collision with root package name */
        private e f30777g;

        /* renamed from: h, reason: collision with root package name */
        private e f30778h;

        /* renamed from: i, reason: collision with root package name */
        private e f30779i;

        e() {
            this.f30771a = null;
            this.f30772b = 1;
        }

        e(Object obj, int i11) {
            com.google.common.base.m.d(i11 > 0);
            this.f30771a = obj;
            this.f30772b = i11;
            this.f30774d = i11;
            this.f30773c = 1;
            this.f30775e = 1;
            this.f30776f = null;
            this.f30777g = null;
        }

        private e A() {
            int r11 = r();
            if (r11 == -2) {
                Objects.requireNonNull(this.f30777g);
                if (this.f30777g.r() > 0) {
                    this.f30777g = this.f30777g.I();
                }
                return H();
            }
            if (r11 != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f30776f);
            if (this.f30776f.r() < 0) {
                this.f30776f = this.f30776f.H();
            }
            return I();
        }

        private void B() {
            D();
            C();
        }

        private void C() {
            this.f30775e = Math.max(y(this.f30776f), y(this.f30777g)) + 1;
        }

        private void D() {
            this.f30773c = TreeMultiset.distinctElements(this.f30776f) + 1 + TreeMultiset.distinctElements(this.f30777g);
            this.f30774d = this.f30772b + M(this.f30776f) + M(this.f30777g);
        }

        private e F(e eVar) {
            e eVar2 = this.f30777g;
            if (eVar2 == null) {
                return this.f30776f;
            }
            this.f30777g = eVar2.F(eVar);
            this.f30773c--;
            this.f30774d -= eVar.f30772b;
            return A();
        }

        private e G(e eVar) {
            e eVar2 = this.f30776f;
            if (eVar2 == null) {
                return this.f30777g;
            }
            this.f30776f = eVar2.G(eVar);
            this.f30773c--;
            this.f30774d -= eVar.f30772b;
            return A();
        }

        private e H() {
            com.google.common.base.m.u(this.f30777g != null);
            e eVar = this.f30777g;
            this.f30777g = eVar.f30776f;
            eVar.f30776f = this;
            eVar.f30774d = this.f30774d;
            eVar.f30773c = this.f30773c;
            B();
            eVar.C();
            return eVar;
        }

        private e I() {
            com.google.common.base.m.u(this.f30776f != null);
            e eVar = this.f30776f;
            this.f30776f = eVar.f30777g;
            eVar.f30777g = this;
            eVar.f30774d = this.f30774d;
            eVar.f30773c = this.f30773c;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e L() {
            e eVar = this.f30779i;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        private static long M(e eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f30774d;
        }

        private e p(Object obj, int i11) {
            this.f30776f = new e(obj, i11);
            TreeMultiset.successor(z(), this.f30776f, this);
            this.f30775e = Math.max(2, this.f30775e);
            this.f30773c++;
            this.f30774d += i11;
            return this;
        }

        private e q(Object obj, int i11) {
            e eVar = new e(obj, i11);
            this.f30777g = eVar;
            TreeMultiset.successor(this, eVar, L());
            this.f30775e = Math.max(2, this.f30775e);
            this.f30773c++;
            this.f30774d += i11;
            return this;
        }

        private int r() {
            return y(this.f30776f) - y(this.f30777g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e s(Comparator comparator, Object obj) {
            int compare = comparator.compare(obj, x());
            if (compare < 0) {
                e eVar = this.f30776f;
                return eVar == null ? this : (e) com.google.common.base.h.a(eVar.s(comparator, obj), this);
            }
            if (compare == 0) {
                return this;
            }
            e eVar2 = this.f30777g;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.s(comparator, obj);
        }

        private e u() {
            int i11 = this.f30772b;
            this.f30772b = 0;
            TreeMultiset.successor(z(), L());
            e eVar = this.f30776f;
            if (eVar == null) {
                return this.f30777g;
            }
            e eVar2 = this.f30777g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.f30775e >= eVar2.f30775e) {
                e z10 = z();
                z10.f30776f = this.f30776f.F(z10);
                z10.f30777g = this.f30777g;
                z10.f30773c = this.f30773c - 1;
                z10.f30774d = this.f30774d - i11;
                return z10.A();
            }
            e L = L();
            L.f30777g = this.f30777g.G(L);
            L.f30776f = this.f30776f;
            L.f30773c = this.f30773c - 1;
            L.f30774d = this.f30774d - i11;
            return L.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e v(Comparator comparator, Object obj) {
            int compare = comparator.compare(obj, x());
            if (compare > 0) {
                e eVar = this.f30777g;
                return eVar == null ? this : (e) com.google.common.base.h.a(eVar.v(comparator, obj), this);
            }
            if (compare == 0) {
                return this;
            }
            e eVar2 = this.f30776f;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.v(comparator, obj);
        }

        private static int y(e eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f30775e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e z() {
            e eVar = this.f30778h;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        e E(Comparator comparator, Object obj, int i11, int[] iArr) {
            int compare = comparator.compare(obj, x());
            if (compare < 0) {
                e eVar = this.f30776f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f30776f = eVar.E(comparator, obj, i11, iArr);
                int i12 = iArr[0];
                if (i12 > 0) {
                    if (i11 >= i12) {
                        this.f30773c--;
                        this.f30774d -= i12;
                    } else {
                        this.f30774d -= i11;
                    }
                }
                return i12 == 0 ? this : A();
            }
            if (compare <= 0) {
                int i13 = this.f30772b;
                iArr[0] = i13;
                if (i11 >= i13) {
                    return u();
                }
                this.f30772b = i13 - i11;
                this.f30774d -= i11;
                return this;
            }
            e eVar2 = this.f30777g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f30777g = eVar2.E(comparator, obj, i11, iArr);
            int i14 = iArr[0];
            if (i14 > 0) {
                if (i11 >= i14) {
                    this.f30773c--;
                    this.f30774d -= i14;
                } else {
                    this.f30774d -= i11;
                }
            }
            return A();
        }

        e J(Comparator comparator, Object obj, int i11, int i12, int[] iArr) {
            int compare = comparator.compare(obj, x());
            if (compare < 0) {
                e eVar = this.f30776f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return (i11 != 0 || i12 <= 0) ? this : p(obj, i12);
                }
                this.f30776f = eVar.J(comparator, obj, i11, i12, iArr);
                int i13 = iArr[0];
                if (i13 == i11) {
                    if (i12 == 0 && i13 != 0) {
                        this.f30773c--;
                    } else if (i12 > 0 && i13 == 0) {
                        this.f30773c++;
                    }
                    this.f30774d += i12 - i13;
                }
                return A();
            }
            if (compare <= 0) {
                int i14 = this.f30772b;
                iArr[0] = i14;
                if (i11 == i14) {
                    if (i12 == 0) {
                        return u();
                    }
                    this.f30774d += i12 - i14;
                    this.f30772b = i12;
                }
                return this;
            }
            e eVar2 = this.f30777g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return (i11 != 0 || i12 <= 0) ? this : q(obj, i12);
            }
            this.f30777g = eVar2.J(comparator, obj, i11, i12, iArr);
            int i15 = iArr[0];
            if (i15 == i11) {
                if (i12 == 0 && i15 != 0) {
                    this.f30773c--;
                } else if (i12 > 0 && i15 == 0) {
                    this.f30773c++;
                }
                this.f30774d += i12 - i15;
            }
            return A();
        }

        e K(Comparator comparator, Object obj, int i11, int[] iArr) {
            int compare = comparator.compare(obj, x());
            if (compare < 0) {
                e eVar = this.f30776f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return i11 > 0 ? p(obj, i11) : this;
                }
                this.f30776f = eVar.K(comparator, obj, i11, iArr);
                if (i11 == 0 && iArr[0] != 0) {
                    this.f30773c--;
                } else if (i11 > 0 && iArr[0] == 0) {
                    this.f30773c++;
                }
                this.f30774d += i11 - iArr[0];
                return A();
            }
            if (compare <= 0) {
                iArr[0] = this.f30772b;
                if (i11 == 0) {
                    return u();
                }
                this.f30774d += i11 - r3;
                this.f30772b = i11;
                return this;
            }
            e eVar2 = this.f30777g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return i11 > 0 ? q(obj, i11) : this;
            }
            this.f30777g = eVar2.K(comparator, obj, i11, iArr);
            if (i11 == 0 && iArr[0] != 0) {
                this.f30773c--;
            } else if (i11 > 0 && iArr[0] == 0) {
                this.f30773c++;
            }
            this.f30774d += i11 - iArr[0];
            return A();
        }

        e o(Comparator comparator, Object obj, int i11, int[] iArr) {
            int compare = comparator.compare(obj, x());
            if (compare < 0) {
                e eVar = this.f30776f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return p(obj, i11);
                }
                int i12 = eVar.f30775e;
                e o11 = eVar.o(comparator, obj, i11, iArr);
                this.f30776f = o11;
                if (iArr[0] == 0) {
                    this.f30773c++;
                }
                this.f30774d += i11;
                return o11.f30775e == i12 ? this : A();
            }
            if (compare <= 0) {
                int i13 = this.f30772b;
                iArr[0] = i13;
                long j11 = i11;
                com.google.common.base.m.d(((long) i13) + j11 <= 2147483647L);
                this.f30772b += i11;
                this.f30774d += j11;
                return this;
            }
            e eVar2 = this.f30777g;
            if (eVar2 == null) {
                iArr[0] = 0;
                return q(obj, i11);
            }
            int i14 = eVar2.f30775e;
            e o12 = eVar2.o(comparator, obj, i11, iArr);
            this.f30777g = o12;
            if (iArr[0] == 0) {
                this.f30773c++;
            }
            this.f30774d += i11;
            return o12.f30775e == i14 ? this : A();
        }

        int t(Comparator comparator, Object obj) {
            int compare = comparator.compare(obj, x());
            if (compare < 0) {
                e eVar = this.f30776f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.t(comparator, obj);
            }
            if (compare <= 0) {
                return this.f30772b;
            }
            e eVar2 = this.f30777g;
            if (eVar2 == null) {
                return 0;
            }
            return eVar2.t(comparator, obj);
        }

        public String toString() {
            return Multisets.g(x(), w()).toString();
        }

        int w() {
            return this.f30772b;
        }

        Object x() {
            return m3.a(this.f30771a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        private Object f30780a;

        private f() {
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        public void a(Object obj, Object obj2) {
            if (this.f30780a != obj) {
                throw new ConcurrentModificationException();
            }
            this.f30780a = obj2;
        }

        void b() {
            this.f30780a = null;
        }

        public Object c() {
            return this.f30780a;
        }
    }

    TreeMultiset(f fVar, GeneralRange<E> generalRange, e eVar) {
        super(generalRange.comparator());
        this.rootReference = fVar;
        this.range = generalRange;
        this.header = eVar;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        e eVar = new e();
        this.header = eVar;
        successor(eVar, eVar);
        this.rootReference = new f(null);
    }

    private long aggregateAboveRange(Aggregate aggregate, e eVar) {
        long treeAggregate;
        long aggregateAboveRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(m3.a(this.range.getUpperEndpoint()), eVar.x());
        if (compare > 0) {
            return aggregateAboveRange(aggregate, eVar.f30777g);
        }
        if (compare == 0) {
            int i11 = d.f30770a[this.range.getUpperBoundType().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    return aggregate.treeAggregate(eVar.f30777g);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregate.treeAggregate(eVar.f30777g);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f30777g) + aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregateAboveRange(aggregate, eVar.f30776f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, e eVar) {
        long treeAggregate;
        long aggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(m3.a(this.range.getLowerEndpoint()), eVar.x());
        if (compare < 0) {
            return aggregateBelowRange(aggregate, eVar.f30776f);
        }
        if (compare == 0) {
            int i11 = d.f30770a[this.range.getLowerBoundType().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    return aggregate.treeAggregate(eVar.f30776f);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregate.treeAggregate(eVar.f30776f);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f30776f) + aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregateBelowRange(aggregate, eVar.f30777g);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        e eVar = (e) this.rootReference.c();
        long treeAggregate = aggregate.treeAggregate(eVar);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, eVar);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, eVar) : treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        g3.a(create, iterable);
        return create;
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    static int distinctElements(e eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.f30773c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e firstNode() {
        e L;
        e eVar = (e) this.rootReference.c();
        if (eVar == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            Object a11 = m3.a(this.range.getLowerEndpoint());
            L = eVar.s(comparator(), a11);
            if (L == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(a11, L.x()) == 0) {
                L = L.L();
            }
        } else {
            L = this.header.L();
        }
        if (L == this.header || !this.range.contains(L.x())) {
            return null;
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e lastNode() {
        e z10;
        e eVar = (e) this.rootReference.c();
        if (eVar == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            Object a11 = m3.a(this.range.getUpperEndpoint());
            z10 = eVar.v(comparator(), a11);
            if (z10 == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(a11, z10.x()) == 0) {
                z10 = z10.z();
            }
        } else {
            z10 = this.header.z();
        }
        if (z10 == this.header || !this.range.contains(z10.x())) {
            return null;
        }
        return z10;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        Objects.requireNonNull(readObject);
        Comparator comparator = (Comparator) readObject;
        w3.a(h.class, "comparator").b(this, comparator);
        w3.a(TreeMultiset.class, "range").b(this, GeneralRange.all(comparator));
        w3.a(TreeMultiset.class, "rootReference").b(this, new f(null));
        e eVar = new e();
        w3.a(TreeMultiset.class, "header").b(this, eVar);
        successor(eVar, eVar);
        w3.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e eVar, e eVar2) {
        eVar.f30779i = eVar2;
        eVar2.f30778h = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e eVar, e eVar2, e eVar3) {
        successor(eVar, eVar2);
        successor(eVar2, eVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l3.a wrapEntry(e eVar) {
        return new a(this, eVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        w3.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public int add(E e11, int i11) {
        e2.b(i11, "occurrences");
        if (i11 == 0) {
            return count(e11);
        }
        com.google.common.base.m.d(this.range.contains(e11));
        e eVar = (e) this.rootReference.c();
        if (eVar != null) {
            int[] iArr = new int[1];
            this.rootReference.a(eVar, eVar.o(comparator(), e11, i11, iArr));
            return iArr[0];
        }
        comparator().compare(e11, e11);
        e eVar2 = new e(e11, i11);
        e eVar3 = this.header;
        successor(eVar3, eVar2, eVar3);
        this.rootReference.a(eVar, eVar2);
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.d(entryIterator());
            return;
        }
        e L = this.header.L();
        while (true) {
            e eVar = this.header;
            if (L == eVar) {
                successor(eVar, eVar);
                this.rootReference.b();
                return;
            }
            e L2 = L.L();
            L.f30772b = 0;
            L.f30776f = null;
            L.f30777g = null;
            L.f30778h = null;
            L.f30779i = null;
            L = L2;
        }
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a4, com.google.common.collect.y3
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.l3
    public int count(Object obj) {
        try {
            e eVar = (e) this.rootReference.c();
            if (this.range.contains(obj) && eVar != null) {
                return eVar.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.h
    Iterator<l3.a> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ a4 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.d
    int distinctElements() {
        return Ints.n(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.d
    Iterator<E> elementIterator() {
        return Multisets.e(entryIterator());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.d, com.google.common.collect.l3
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<l3.a> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ l3.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.a4
    public a4 headMultiset(E e11, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e11, boundType)), this.header);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ l3.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ l3.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ l3.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public int remove(Object obj, int i11) {
        e2.b(i11, "occurrences");
        if (i11 == 0) {
            return count(obj);
        }
        e eVar = (e) this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && eVar != null) {
                this.rootReference.a(eVar, eVar.E(comparator(), obj, i11, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public int setCount(E e11, int i11) {
        e2.b(i11, "count");
        if (!this.range.contains(e11)) {
            com.google.common.base.m.d(i11 == 0);
            return 0;
        }
        e eVar = (e) this.rootReference.c();
        if (eVar == null) {
            if (i11 > 0) {
                add(e11, i11);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(eVar, eVar.K(comparator(), e11, i11, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public boolean setCount(E e11, int i11, int i12) {
        e2.b(i12, "newCount");
        e2.b(i11, "oldCount");
        com.google.common.base.m.d(this.range.contains(e11));
        e eVar = (e) this.rootReference.c();
        if (eVar != null) {
            int[] iArr = new int[1];
            this.rootReference.a(eVar, eVar.J(comparator(), e11, i11, i12, iArr));
            return iArr[0] == i11;
        }
        if (i11 != 0) {
            return false;
        }
        if (i12 > 0) {
            add(e11, i12);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public int size() {
        return Ints.n(aggregateForEntries(Aggregate.SIZE));
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a4
    public /* bridge */ /* synthetic */ a4 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.a4
    public a4 tailMultiset(E e11, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e11, boundType)), this.header);
    }
}
