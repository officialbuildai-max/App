package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.MultimapBuilder;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
abstract class d2 {

    /* renamed from: a, reason: collision with root package name */
    private static final Collector f30827a;

    /* renamed from: b, reason: collision with root package name */
    private static final Collector f30828b;

    /* renamed from: c, reason: collision with root package name */
    private static final Collector f30829c;

    static {
        Collector of2;
        Collector of3;
        Collector of4;
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.h0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableList.builder();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.m0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableList.a) obj).a(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.n0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableList.a) obj).p((ImmutableList.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.o0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableList.a) obj).e();
            }
        }, new Collector.Characteristics[0]);
        f30827a = of2;
        of3 = Collector.of(new Supplier() { // from class: com.google.common.collect.p0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableSet.builder();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.q0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableSet.a) obj).a(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.r0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSet.a) obj).p((ImmutableSet.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.s0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSet.a) obj).e();
            }
        }, new Collector.Characteristics[0]);
        f30828b = of3;
        of4 = Collector.of(new Supplier() { // from class: com.google.common.collect.i0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableRangeSet.builder();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.j0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableRangeSet.a) obj).a((Range) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.k0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableRangeSet.a) obj).d((ImmutableRangeSet.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.l0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableRangeSet.a) obj).c();
            }
        }, new Collector.Characteristics[0]);
        f30829c = of4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j3 A(j3 j3Var, j3 j3Var2) {
        j3Var.putAll(j3Var2);
        return j3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(Function function, Function function2, ImmutableBiMap.a aVar, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        aVar.h(apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(Function function, Function function2, ImmutableListMultimap.a aVar, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        aVar.f(apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(Function function, Function function2, ImmutableMap.b bVar, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        bVar.h(apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Function function, ToIntFunction toIntFunction, l3 l3Var, Object obj) {
        Object apply;
        int applyAsInt;
        apply = function.apply(obj);
        Object o11 = com.google.common.base.m.o(apply);
        applyAsInt = toIntFunction.applyAsInt(obj);
        l3Var.add(o11, applyAsInt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l3 F(l3 l3Var, l3 l3Var2) {
        l3Var.addAll(l3Var2);
        return l3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableMultiset G(l3 l3Var) {
        return ImmutableMultiset.copyFromEntries(l3Var.entrySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(Function function, Function function2, ImmutableRangeMap.a aVar, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        aVar.c((Range) apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(Function function, Function function2, ImmutableSetMultimap.a aVar, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        aVar.f(apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TreeMap J(Comparator comparator) {
        return new TreeMap(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedMap.a K(Comparator comparator) {
        return new ImmutableSortedMap.a(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(Function function, Function function2, ImmutableSortedMap.a aVar, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        aVar.h(apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedSet.a M(Comparator comparator) {
        return new ImmutableSortedSet.a(comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector N(final Function function, final Function function2) {
        Collector of2;
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableBiMap.a();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.e0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                d2.B(function, function2, (ImmutableBiMap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.f0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableBiMap.a) obj).e((ImmutableBiMap.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.g0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableBiMap.a) obj).d();
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector O() {
        return f30827a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector P(final Function function, final Function function2) {
        Collector of2;
        com.google.common.base.m.p(function, "keyFunction");
        com.google.common.base.m.p(function2, "valueFunction");
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.p1
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableListMultimap.builder();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.q1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                d2.C(function, function2, (ImmutableListMultimap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.r1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableListMultimap.a) obj).k((ImmutableListMultimap.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.s1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableListMultimap.a) obj).j();
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector Q(final Function function, final Function function2) {
        Collector of2;
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.h1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableMap.b();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.i1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                d2.D(function, function2, (ImmutableMap.b) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.j1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableMap.b) obj).e((ImmutableMap.b) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.k1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableMap.b) obj).d();
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector R(Function function, Function function2, BinaryOperator binaryOperator) {
        Collector map;
        Collector collectingAndThen;
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        com.google.common.base.m.o(binaryOperator);
        map = Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: com.google.common.collect.x1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new LinkedHashMap();
            }
        });
        collectingAndThen = Collectors.collectingAndThen(map, new Function() { // from class: com.google.common.collect.y1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableMap.copyOf((Map) obj);
            }
        });
        return collectingAndThen;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector S(final Function function, final ToIntFunction toIntFunction) {
        Collector of2;
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(toIntFunction);
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.x0
            @Override // java.util.function.Supplier
            public final Object get() {
                return LinkedHashMultiset.create();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.y0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                d2.E(function, toIntFunction, (l3) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.z0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                l3 F;
                F = d2.F((l3) obj, (l3) obj2);
                return F;
            }
        }, new Function() { // from class: com.google.common.collect.a1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ImmutableMultiset G;
                G = d2.G((l3) obj);
                return G;
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector T(final Function function, final Function function2) {
        Collector of2;
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.v
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableRangeMap.builder();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.w
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                d2.H(function, function2, (ImmutableRangeMap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.x
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableRangeMap.a) obj).b((ImmutableRangeMap.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableRangeMap.a) obj).a();
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector U() {
        return f30829c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector V() {
        return f30828b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector W(final Function function, final Function function2) {
        Collector of2;
        com.google.common.base.m.p(function, "keyFunction");
        com.google.common.base.m.p(function2, "valueFunction");
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.t1
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableSetMultimap.builder();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.u1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                d2.I(function, function2, (ImmutableSetMultimap.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.v1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSetMultimap.a) obj).k((ImmutableSetMultimap.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.w1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSetMultimap.a) obj).j();
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector X(final Comparator comparator, final Function function, final Function function2) {
        Collector.Characteristics characteristics;
        Collector of2;
        com.google.common.base.m.o(comparator);
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        Supplier supplier = new Supplier() { // from class: com.google.common.collect.z
            @Override // java.util.function.Supplier
            public final Object get() {
                ImmutableSortedMap.a K;
                K = d2.K(comparator);
                return K;
            }
        };
        BiConsumer biConsumer = new BiConsumer() { // from class: com.google.common.collect.a0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                d2.L(function, function2, (ImmutableSortedMap.a) obj, obj2);
            }
        };
        BinaryOperator binaryOperator = new BinaryOperator() { // from class: com.google.common.collect.b0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSortedMap.a) obj).p((ImmutableSortedMap.a) obj2);
            }
        };
        Function function3 = new Function() { // from class: com.google.common.collect.c0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSortedMap.a) obj).d();
            }
        };
        characteristics = Collector.Characteristics.UNORDERED;
        of2 = Collector.of(supplier, biConsumer, binaryOperator, function3, characteristics);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector Y(final Comparator comparator, Function function, Function function2, BinaryOperator binaryOperator) {
        Collector map;
        Collector collectingAndThen;
        com.google.common.base.m.o(comparator);
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        com.google.common.base.m.o(binaryOperator);
        map = Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: com.google.common.collect.f1
            @Override // java.util.function.Supplier
            public final Object get() {
                TreeMap J;
                J = d2.J(comparator);
                return J;
            }
        });
        collectingAndThen = Collectors.collectingAndThen(map, new Function() { // from class: com.google.common.collect.g1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSortedMap.copyOfSorted((TreeMap) obj);
            }
        });
        return collectingAndThen;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector Z(final Comparator comparator) {
        Collector of2;
        com.google.common.base.m.o(comparator);
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.l1
            @Override // java.util.function.Supplier
            public final Object get() {
                ImmutableSortedSet.a M;
                M = d2.M(comparator);
                return M;
            }
        }, new BiConsumer() { // from class: com.google.common.collect.m1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableSortedSet.a) obj).a(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.n1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSortedSet.a) obj).p((ImmutableSortedSet.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.o1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSortedSet.a) obj).e();
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector s(final Function function, final Function function2) {
        Collector collectingAndThen;
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        Function function3 = new Function() { // from class: com.google.common.collect.t0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object v11;
                v11 = d2.v(function, obj);
                return v11;
            }
        };
        Function function4 = new Function() { // from class: com.google.common.collect.u0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Stream w11;
                w11 = d2.w(function2, obj);
                return w11;
            }
        };
        final MultimapBuilder.d a11 = MultimapBuilder.c().a();
        Objects.requireNonNull(a11);
        collectingAndThen = Collectors.collectingAndThen(u(function3, function4, new Supplier() { // from class: com.google.common.collect.v0
            @Override // java.util.function.Supplier
            public final Object get() {
                return MultimapBuilder.d.this.g();
            }
        }), new Function() { // from class: com.google.common.collect.w0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableListMultimap.copyOf((j3) obj);
            }
        });
        return collectingAndThen;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector t(final Function function, final Function function2) {
        Collector collectingAndThen;
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        Function function3 = new Function() { // from class: com.google.common.collect.b1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object x10;
                x10 = d2.x(function, obj);
                return x10;
            }
        };
        Function function4 = new Function() { // from class: com.google.common.collect.c1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Stream y10;
                y10 = d2.y(function2, obj);
                return y10;
            }
        };
        final MultimapBuilder.f d11 = MultimapBuilder.c().d();
        Objects.requireNonNull(d11);
        collectingAndThen = Collectors.collectingAndThen(u(function3, function4, new Supplier() { // from class: com.google.common.collect.d1
            @Override // java.util.function.Supplier
            public final Object get() {
                return MultimapBuilder.f.this.g();
            }
        }), new Function() { // from class: com.google.common.collect.e1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImmutableSetMultimap.copyOf((j3) obj);
            }
        });
        return collectingAndThen;
    }

    static Collector u(final Function function, final Function function2, Supplier supplier) {
        Collector of2;
        com.google.common.base.m.o(function);
        com.google.common.base.m.o(function2);
        com.google.common.base.m.o(supplier);
        of2 = Collector.of(supplier, new BiConsumer() { // from class: com.google.common.collect.z1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                d2.z(function, function2, (j3) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.a2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                j3 A;
                A = d2.A((j3) obj, (j3) obj2);
                return A;
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object v(Function function, Object obj) {
        Object apply;
        apply = function.apply(obj);
        return com.google.common.base.m.o(apply);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream w(Function function, Object obj) {
        Object apply;
        Stream peek;
        apply = function.apply(obj);
        peek = r.a(apply).peek(new b2());
        return peek;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object x(Function function, Object obj) {
        Object apply;
        apply = function.apply(obj);
        return com.google.common.base.m.o(apply);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream y(Function function, Object obj) {
        Object apply;
        Stream peek;
        apply = function.apply(obj);
        peek = r.a(apply).peek(new b2());
        return peek;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(Function function, Function function2, j3 j3Var, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        final Collection collection = j3Var.get(apply);
        apply2 = function2.apply(obj);
        Stream a11 = r.a(apply2);
        Objects.requireNonNull(collection);
        a11.forEachOrdered(new Consumer() { // from class: com.google.common.collect.c2
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                collection.add(obj2);
            }
        });
    }
}
