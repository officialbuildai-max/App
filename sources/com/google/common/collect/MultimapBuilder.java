package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public abstract class MultimapBuilder {

    /* loaded from: classes4.dex */
    private static final class ArrayListSupplier<V> implements com.google.common.base.q, Serializable {
        private final int expectedValuesPerKey;

        ArrayListSupplier(int i11) {
            this.expectedValuesPerKey = e2.b(i11, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.q
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    /* loaded from: classes4.dex */
    private static final class LinkedHashSetSupplier<V> implements com.google.common.base.q, Serializable {
        private final int expectedValuesPerKey;

        LinkedHashSetSupplier(int i11) {
            this.expectedValuesPerKey = e2.b(i11, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.q
        public Set<V> get() {
            return r3.g(this.expectedValuesPerKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f30655a;

        a(int i11) {
            this.f30655a = i11;
        }

        @Override // com.google.common.collect.MultimapBuilder.e
        Map c() {
            return r3.d(this.f30655a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f30656a;

        b(int i11) {
            this.f30656a = i11;
        }

        @Override // com.google.common.collect.MultimapBuilder.e
        Map c() {
            return r3.f(this.f30656a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f30657a;

        c(Comparator comparator) {
            this.f30657a = comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.e
        Map c() {
            return new TreeMap(this.f30657a);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class d extends MultimapBuilder {
        d() {
            super(null);
        }

        public abstract i3 g();
    }

    /* loaded from: classes4.dex */
    public static abstract class e {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f30658a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f30659b;

            a(e eVar, int i11) {
                this.f30658a = i11;
                this.f30659b = eVar;
            }

            @Override // com.google.common.collect.MultimapBuilder.d
            public i3 g() {
                return Multimaps.b(this.f30659b.c(), new ArrayListSupplier(this.f30658a));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class b extends f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f30660a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f30661b;

            b(e eVar, int i11) {
                this.f30660a = i11;
                this.f30661b = eVar;
            }

            @Override // com.google.common.collect.MultimapBuilder.f
            public x3 g() {
                return Multimaps.c(this.f30661b.c(), new LinkedHashSetSupplier(this.f30660a));
            }
        }

        e() {
        }

        public d a() {
            return b(2);
        }

        public d b(int i11) {
            e2.b(i11, "expectedValuesPerKey");
            return new a(this, i11);
        }

        abstract Map c();

        public f d() {
            return e(2);
        }

        public f e(int i11) {
            e2.b(i11, "expectedValuesPerKey");
            return new b(this, i11);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f extends MultimapBuilder {
        f() {
            super(null);
        }

        public abstract x3 g();
    }

    private MultimapBuilder() {
    }

    /* synthetic */ MultimapBuilder(a aVar) {
        this();
    }

    public static e a() {
        return b(8);
    }

    public static e b(int i11) {
        e2.b(i11, "expectedKeys");
        return new a(i11);
    }

    public static e c() {
        return d(8);
    }

    public static e d(int i11) {
        e2.b(i11, "expectedKeys");
        return new b(i11);
    }

    public static e e() {
        return f(Ordering.natural());
    }

    public static e f(Comparator comparator) {
        com.google.common.base.m.o(comparator);
        return new c(comparator);
    }
}
