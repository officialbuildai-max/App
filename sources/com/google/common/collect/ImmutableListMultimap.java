package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements i3 {
    private static final long serialVersionUID = 0;
    private transient ImmutableListMultimap<V, K> inverse;

    /* loaded from: classes4.dex */
    public static final class a extends ImmutableMultimap.c {
        public a() {
        }

        a(int i11) {
            super(i11);
        }

        public ImmutableListMultimap j() {
            return (ImmutableListMultimap) super.a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a k(ImmutableMultimap.c cVar) {
            super.b(cVar);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public a f(Object obj, Object obj2) {
            super.f(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public a g(Map.Entry entry) {
            super.g(entry);
            return this;
        }

        public a n(Iterable iterable) {
            super.h(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public a i(Object obj, Iterable iterable) {
            super.i(obj, iterable);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i11) {
        super(immutableMap, i11);
    }

    public static <K, V> a builder() {
        return new a();
    }

    public static <K, V> a builderWithExpectedKeys(int i11) {
        e2.b(i11, "expectedKeys");
        return new a(i11);
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(j3 j3Var) {
        if (j3Var.isEmpty()) {
            return of();
        }
        if (j3Var instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) j3Var;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(j3Var.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().n(iterable).j();
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends Stream<? extends V>> function2) {
        return d2.s(function, function2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableListMultimap<K, V> fromMapBuilderEntries(Collection<? extends Map.Entry<K, ImmutableCollection.b>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i11 = 0;
        for (Map.Entry<K, ImmutableCollection.b> entry : collection) {
            K key = entry.getKey();
            ImmutableList.a aVar = (ImmutableList.a) entry.getValue();
            ImmutableList e11 = comparator == null ? aVar.e() : aVar.o(comparator);
            bVar.h(key, e11);
            i11 += e11.size();
        }
        return new ImmutableListMultimap<>(bVar.d(), i11);
    }

    static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i11 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            ImmutableList copyOf = comparator == null ? ImmutableList.copyOf((Collection) value) : ImmutableList.sortedCopyOf(comparator, value);
            if (!copyOf.isEmpty()) {
                bVar.h(key, copyOf);
                i11 += copyOf.size();
            }
        }
        return new ImmutableListMultimap<>(bVar.d(), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        a builder = builder();
        r4 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.f(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> j11 = builder.j();
        j11.inverse = this;
        return j11;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11) {
        a builder = builder();
        builder.f(k11, v11);
        return builder.j();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12) {
        a builder = builder();
        builder.f(k11, v11);
        builder.f(k12, v12);
        return builder.j();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        a builder = builder();
        builder.f(k11, v11);
        builder.f(k12, v12);
        builder.f(k13, v13);
        return builder.j();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a builder = builder();
        builder.f(k11, v11);
        builder.f(k12, v12);
        builder.f(k13, v13);
        builder.f(k14, v14);
        return builder.j();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        a builder = builder();
        builder.f(k11, v11);
        builder.f(k12, v12);
        builder.f(k13, v13);
        builder.f(k14, v14);
        builder.f(k15, v15);
        return builder.j();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
        ImmutableMap.b builder = ImmutableMap.builder();
        int i11 = 0;
        for (int i12 = 0; i12 < readInt; i12++) {
            Object readObject = objectInputStream.readObject();
            Objects.requireNonNull(readObject);
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException("Invalid value count " + readInt2);
            }
            ImmutableList.a builder2 = ImmutableList.builder();
            for (int i13 = 0; i13 < readInt2; i13++) {
                Object readObject2 = objectInputStream.readObject();
                Objects.requireNonNull(readObject2);
                builder2.a(readObject2);
            }
            builder.h(readObject, builder2.e());
            i11 += readInt2;
        }
        try {
            ImmutableMultimap.d.f30495a.b(this, builder.d());
            ImmutableMultimap.d.f30496b.a(this, i11);
        } catch (IllegalArgumentException e11) {
            throw ((InvalidObjectException) new InvalidObjectException(e11.getMessage()).initCause(e11));
        }
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return d2.P(function, function2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        w3.j(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.j3
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.j3
    public ImmutableList<V> get(K k11) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k11);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.j3
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.j3
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> invert = invert();
        this.inverse = invert;
        return invert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.j3
    @Deprecated
    public final ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @Deprecated
    public final ImmutableList<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo832replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ List mo832replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }
}
