package com.google.common.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Tables;
import com.google.common.collect.l4;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* loaded from: classes4.dex */
abstract class l4 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final List f30876a;

        /* renamed from: b, reason: collision with root package name */
        final c4 f30877b;

        private b() {
            this.f30876a = new ArrayList();
            this.f30877b = HashBasedTable.create();
        }

        b a(b bVar, BinaryOperator binaryOperator) {
            for (c cVar : bVar.f30876a) {
                b(cVar.getRowKey(), cVar.getColumnKey(), cVar.getValue(), binaryOperator);
            }
            return this;
        }

        void b(Object obj, Object obj2, Object obj3, BinaryOperator binaryOperator) {
            c cVar = (c) this.f30877b.get(obj, obj2);
            if (cVar != null) {
                cVar.a(obj3, binaryOperator);
                return;
            }
            c cVar2 = new c(obj, obj2, obj3);
            this.f30876a.add(cVar2);
            this.f30877b.put(obj, obj2, cVar2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ImmutableTable c() {
            return ImmutableTable.copyOf(this.f30876a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c extends Tables.b {

        /* renamed from: a, reason: collision with root package name */
        private final Object f30878a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f30879b;

        /* renamed from: c, reason: collision with root package name */
        private Object f30880c;

        c(Object obj, Object obj2, Object obj3) {
            this.f30878a = com.google.common.base.m.p(obj, "row");
            this.f30879b = com.google.common.base.m.p(obj2, "column");
            this.f30880c = com.google.common.base.m.p(obj3, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        }

        void a(Object obj, BinaryOperator binaryOperator) {
            Object apply;
            com.google.common.base.m.p(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            apply = binaryOperator.apply(this.f30880c, obj);
            this.f30880c = com.google.common.base.m.p(apply, "mergeFunction.apply");
        }

        @Override // com.google.common.collect.c4.a
        public Object getColumnKey() {
            return this.f30879b;
        }

        @Override // com.google.common.collect.c4.a
        public Object getRowKey() {
            return this.f30878a;
        }

        @Override // com.google.common.collect.c4.a
        public Object getValue() {
            return this.f30880c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Function function, Function function2, Function function3, ImmutableTable.a aVar, Object obj) {
        Object apply;
        Object apply2;
        Object apply3;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        apply3 = function3.apply(obj);
        aVar.e(apply, apply2, apply3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b g() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Function function, Function function2, Function function3, BinaryOperator binaryOperator, b bVar, Object obj) {
        Object apply;
        Object apply2;
        Object apply3;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        apply3 = function3.apply(obj);
        bVar.b(apply, apply2, apply3, binaryOperator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b i(BinaryOperator binaryOperator, b bVar, b bVar2) {
        return bVar.a(bVar2, binaryOperator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector k(final Function function, final Function function2, final Function function3) {
        Collector of2;
        com.google.common.base.m.p(function, "rowFunction");
        com.google.common.base.m.p(function2, "columnFunction");
        com.google.common.base.m.p(function3, "valueFunction");
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.h4
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableTable.a();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.i4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                l4.f(function, function2, function3, (ImmutableTable.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.j4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableTable.a) obj).c((ImmutableTable.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.k4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableTable.a) obj).a();
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collector l(final Function function, final Function function2, final Function function3, final BinaryOperator binaryOperator) {
        Collector of2;
        com.google.common.base.m.p(function, "rowFunction");
        com.google.common.base.m.p(function2, "columnFunction");
        com.google.common.base.m.p(function3, "valueFunction");
        com.google.common.base.m.p(binaryOperator, "mergeFunction");
        of2 = Collector.of(new Supplier() { // from class: com.google.common.collect.d4
            @Override // java.util.function.Supplier
            public final Object get() {
                l4.b g11;
                g11 = l4.g();
                return g11;
            }
        }, new BiConsumer() { // from class: com.google.common.collect.e4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                l4.h(function, function2, function3, binaryOperator, (l4.b) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.f4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                l4.b i11;
                i11 = l4.i(binaryOperator, (l4.b) obj, (l4.b) obj2);
                return i11;
            }
        }, new Function() { // from class: com.google.common.collect.g4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ImmutableTable c11;
                c11 = ((l4.b) obj).c();
                return c11;
            }
        }, new Collector.Characteristics[0]);
        return of2;
    }
}
