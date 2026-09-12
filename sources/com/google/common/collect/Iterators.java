package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/* loaded from: classes.dex */
public abstract class Iterators {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            e2.e(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends r4 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f30529a;

        a(Iterator it) {
            this.f30529a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30529a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.f30529a.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends AbstractIterator {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f30530c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.n f30531d;

        b(Iterator it, com.google.common.base.n nVar) {
            this.f30530c = it;
            this.f30531d = nVar;
        }

        @Override // com.google.common.collect.AbstractIterator
        protected Object a() {
            while (this.f30530c.hasNext()) {
                Object next = this.f30530c.next();
                if (this.f30531d.apply(next)) {
                    return next;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends o4 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.f f30532b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Iterator it, com.google.common.base.f fVar) {
            super(it);
            this.f30532b = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.o4
        public Object a(Object obj) {
            return this.f30532b.apply(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d extends com.google.common.collect.a {

        /* renamed from: d, reason: collision with root package name */
        static final s4 f30533d = new d(new Object[0], 0);

        /* renamed from: c, reason: collision with root package name */
        private final Object[] f30534c;

        d(Object[] objArr, int i11) {
            super(objArr.length, i11);
            this.f30534c = objArr;
        }

        @Override // com.google.common.collect.a
        protected Object a(int i11) {
            return this.f30534c[i11];
        }
    }

    /* loaded from: classes4.dex */
    private static class e implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private Iterator f30535a;

        /* renamed from: b, reason: collision with root package name */
        private Iterator f30536b = Iterators.h();

        /* renamed from: c, reason: collision with root package name */
        private Iterator f30537c;

        /* renamed from: d, reason: collision with root package name */
        private Deque f30538d;

        e(Iterator it) {
            this.f30537c = (Iterator) com.google.common.base.m.o(it);
        }

        private Iterator a() {
            while (true) {
                Iterator it = this.f30537c;
                if (it != null && it.hasNext()) {
                    return this.f30537c;
                }
                Deque deque = this.f30538d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f30537c = (Iterator) this.f30538d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) com.google.common.base.m.o(this.f30536b)).hasNext()) {
                Iterator a11 = a();
                this.f30537c = a11;
                if (a11 == null) {
                    return false;
                }
                Iterator it = (Iterator) a11.next();
                this.f30536b = it;
                if (it instanceof e) {
                    e eVar = (e) it;
                    this.f30536b = eVar.f30536b;
                    if (this.f30538d == null) {
                        this.f30538d = new ArrayDeque();
                    }
                    this.f30538d.addFirst(this.f30537c);
                    if (eVar.f30538d != null) {
                        while (!eVar.f30538d.isEmpty()) {
                            this.f30538d.addFirst((Iterator) eVar.f30538d.removeLast());
                        }
                    }
                    this.f30537c = eVar.f30537c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator it = this.f30536b;
            this.f30535a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator it = this.f30535a;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.f30535a = null;
        }
    }

    /* loaded from: classes4.dex */
    private static class f extends r4 {

        /* renamed from: a, reason: collision with root package name */
        final Queue f30539a;

        public f(Iterable iterable, final Comparator comparator) {
            this.f30539a = new PriorityQueue(2, new Comparator() { // from class: com.google.common.collect.h3
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int b11;
                    b11 = Iterators.f.b(comparator, (q3) obj, (q3) obj2);
                    return b11;
                }
            });
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Iterator it2 = (Iterator) it.next();
                if (it2.hasNext()) {
                    this.f30539a.add(Iterators.s(it2));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int b(Comparator comparator, q3 q3Var, q3 q3Var2) {
            return comparator.compare(q3Var.peek(), q3Var2.peek());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f30539a.isEmpty();
        }

        @Override // java.util.Iterator
        public Object next() {
            q3 q3Var = (q3) this.f30539a.remove();
            Object next = q3Var.next();
            if (q3Var.hasNext()) {
                this.f30539a.add(q3Var);
            }
            return next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class g implements q3 {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator f30540a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f30541b;

        /* renamed from: c, reason: collision with root package name */
        private Object f30542c;

        public g(Iterator it) {
            this.f30540a = (Iterator) com.google.common.base.m.o(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30541b || this.f30540a.hasNext();
        }

        @Override // com.google.common.collect.q3, java.util.Iterator
        public Object next() {
            if (!this.f30541b) {
                return this.f30540a.next();
            }
            Object a11 = m3.a(this.f30542c);
            this.f30541b = false;
            this.f30542c = null;
            return a11;
        }

        @Override // com.google.common.collect.q3
        public Object peek() {
            if (!this.f30541b) {
                this.f30542c = this.f30540a.next();
                this.f30541b = true;
            }
            return m3.a(this.f30542c);
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.v(!this.f30541b, "Can't remove after you've peeked at next");
            this.f30540a.remove();
        }
    }

    /* loaded from: classes4.dex */
    private static final class h extends r4 {

        /* renamed from: a, reason: collision with root package name */
        private final Object f30543a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f30544b;

        h(Object obj) {
            this.f30543a = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f30544b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f30544b) {
                throw new NoSuchElementException();
            }
            this.f30544b = true;
            return this.f30543a;
        }
    }

    public static Iterator A(Iterator it, com.google.common.base.f fVar) {
        com.google.common.base.m.o(fVar);
        return new c(it, fVar);
    }

    public static r4 B(Iterator it) {
        com.google.common.base.m.o(it);
        return it instanceof r4 ? (r4) it : new a(it);
    }

    public static boolean a(Collection collection, Iterator it) {
        com.google.common.base.m.o(collection);
        com.google.common.base.m.o(it);
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= collection.add(it.next());
        }
        return z10;
    }

    public static int b(Iterator it, int i11) {
        com.google.common.base.m.o(it);
        int i12 = 0;
        com.google.common.base.m.e(i11 >= 0, "numberToAdvance must be nonnegative");
        while (i12 < i11 && it.hasNext()) {
            it.next();
            i12++;
        }
        return i12;
    }

    public static boolean c(Iterator it, com.google.common.base.n nVar) {
        return q(it, nVar) != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Iterator it) {
        com.google.common.base.m.o(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static Iterator e(Iterator it) {
        return new e(it);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:
    
        if (r2.hasNext() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
    
        if (r3.equals(r2.next()) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0020, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0001, code lost:
    
        if (r3 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
    
        if (r2.hasNext() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r2.next() != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f(java.util.Iterator r2, java.lang.Object r3) {
        /*
            r0 = 1
            if (r3 != 0) goto L10
        L3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L21
            java.lang.Object r3 = r2.next()
            if (r3 != 0) goto L3
            return r0
        L10:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L21
            java.lang.Object r1 = r2.next()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L10
            return r0
        L21:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.f(java.util.Iterator, java.lang.Object):boolean");
    }

    public static boolean g(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.j.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r4 h() {
        return i();
    }

    static s4 i() {
        return d.f30533d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator j() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static r4 k(Iterator it, com.google.common.base.n nVar) {
        com.google.common.base.m.o(it);
        com.google.common.base.m.o(nVar);
        return new b(it, nVar);
    }

    public static Object l(Iterator it, com.google.common.base.n nVar) {
        com.google.common.base.m.o(it);
        com.google.common.base.m.o(nVar);
        while (it.hasNext()) {
            Object next = it.next();
            if (nVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static Object m(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object n(Iterator it, Object obj) {
        return it.hasNext() ? m(it) : obj;
    }

    public static Object o(Iterator it, Object obj) {
        return it.hasNext() ? it.next() : obj;
    }

    public static Object p(Iterator it) {
        Object next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected one element but was: <");
        sb2.append(next);
        for (int i11 = 0; i11 < 4 && it.hasNext(); i11++) {
            sb2.append(", ");
            sb2.append(it.next());
        }
        if (it.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append('>');
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int q(Iterator it, com.google.common.base.n nVar) {
        com.google.common.base.m.p(nVar, "predicate");
        int i11 = 0;
        while (it.hasNext()) {
            if (nVar.apply(it.next())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static r4 r(Iterable iterable, Comparator comparator) {
        com.google.common.base.m.p(iterable, "iterators");
        com.google.common.base.m.p(comparator, "comparator");
        return new f(iterable, comparator);
    }

    public static q3 s(Iterator it) {
        return it instanceof g ? (g) it : new g(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object t(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static boolean u(Iterator it, Collection collection) {
        com.google.common.base.m.o(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean v(Iterator it, com.google.common.base.n nVar) {
        com.google.common.base.m.o(nVar);
        boolean z10 = false;
        while (it.hasNext()) {
            if (nVar.apply(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean w(Iterator it, Collection collection) {
        com.google.common.base.m.o(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static r4 x(Object obj) {
        return new h(obj);
    }

    public static int y(Iterator it) {
        long j11 = 0;
        while (it.hasNext()) {
            it.next();
            j11++;
        }
        return Ints.n(j11);
    }

    public static String z(Iterator it) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z10 = true;
        while (it.hasNext()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(it.next());
            z10 = false;
        }
        sb2.append(']');
        return sb2.toString();
    }
}
