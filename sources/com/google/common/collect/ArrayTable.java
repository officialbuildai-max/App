package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Tables;
import com.google.common.collect.c4;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class ArrayTable<R, C, V> extends i implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ArrayTable<R, C, V>.f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient ArrayTable<R, C, V>.h rowMap;

    /* loaded from: classes4.dex */
    class a extends com.google.common.collect.a {
        a(int i11) {
            super(i11);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c4.a a(int i11) {
            return ArrayTable.this.getCell(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends Tables.b {

        /* renamed from: a, reason: collision with root package name */
        final int f30367a;

        /* renamed from: b, reason: collision with root package name */
        final int f30368b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f30369c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayTable f30370d;

        b(ArrayTable arrayTable, int i11) {
            this.f30369c = i11;
            this.f30370d = arrayTable;
            this.f30367a = i11 / arrayTable.columnList.size();
            this.f30368b = i11 % arrayTable.columnList.size();
        }

        @Override // com.google.common.collect.c4.a
        public Object getColumnKey() {
            return this.f30370d.columnList.get(this.f30368b);
        }

        @Override // com.google.common.collect.c4.a
        public Object getRowKey() {
            return this.f30370d.rowList.get(this.f30367a);
        }

        @Override // com.google.common.collect.c4.a
        public Object getValue() {
            return this.f30370d.at(this.f30367a, this.f30368b);
        }
    }

    /* loaded from: classes4.dex */
    class c extends com.google.common.collect.a {
        c(int i11) {
            super(i11);
        }

        @Override // com.google.common.collect.a
        protected Object a(int i11) {
            return ArrayTable.this.getValue(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class d extends Maps.k {

        /* renamed from: a, reason: collision with root package name */
        private final ImmutableMap f30372a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends com.google.common.collect.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f30373a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f30374b;

            a(d dVar, int i11) {
                this.f30373a = i11;
                this.f30374b = dVar;
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public Object getKey() {
                return this.f30374b.d(this.f30373a);
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public Object getValue() {
                return this.f30374b.f(this.f30373a);
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public Object setValue(Object obj) {
                return this.f30374b.h(this.f30373a, obj);
            }
        }

        /* loaded from: classes4.dex */
        class b extends com.google.common.collect.a {
            b(int i11) {
                super(i11);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry a(int i11) {
                return d.this.c(i11);
            }
        }

        private d(ImmutableMap immutableMap) {
            this.f30372a = immutableMap;
        }

        /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator a() {
            return new b(size());
        }

        Map.Entry c(int i11) {
            com.google.common.base.m.m(i11, size());
            return new a(this, i11);
        }

        @Override // com.google.common.collect.Maps.k, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f30372a.containsKey(obj);
        }

        Object d(int i11) {
            return this.f30372a.keySet().asList().get(i11);
        }

        abstract String e();

        abstract Object f(int i11);

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Integer num = (Integer) this.f30372a.get(obj);
            if (num == null) {
                return null;
            }
            return f(num.intValue());
        }

        abstract Object h(int i11, Object obj);

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f30372a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return this.f30372a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Integer num = (Integer) this.f30372a.get(obj);
            if (num != null) {
                return h(num.intValue(), obj2);
            }
            throw new IllegalArgumentException(e() + " " + obj + " not in " + this.f30372a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f30372a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class e extends d {

        /* renamed from: b, reason: collision with root package name */
        final int f30376b;

        e(int i11) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f30376b = i11;
        }

        @Override // com.google.common.collect.ArrayTable.d
        String e() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        Object f(int i11) {
            return ArrayTable.this.at(i11, this.f30376b);
        }

        @Override // com.google.common.collect.ArrayTable.d
        Object h(int i11, Object obj) {
            return ArrayTable.this.set(i11, this.f30376b, obj);
        }
    }

    /* loaded from: classes4.dex */
    private class f extends d {
        private f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }

        /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        String e() {
            return "Column";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map f(int i11) {
            return new e(i11);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Map put(Object obj, Map map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Map h(int i11, Map map) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class g extends d {

        /* renamed from: b, reason: collision with root package name */
        final int f30379b;

        g(int i11) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f30379b = i11;
        }

        @Override // com.google.common.collect.ArrayTable.d
        String e() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        Object f(int i11) {
            return ArrayTable.this.at(this.f30379b, i11);
        }

        @Override // com.google.common.collect.ArrayTable.d
        Object h(int i11, Object obj) {
            return ArrayTable.this.set(this.f30379b, i11, obj);
        }
    }

    /* loaded from: classes4.dex */
    private class h extends d {
        private h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }

        /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        String e() {
            return "Row";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map f(int i11) {
            return new g(i11);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Map put(Object obj, Map map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Map h(int i11, Map map) {
            throw new UnsupportedOperationException();
        }
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i11 = 0; i11 < this.rowList.size(); i11++) {
            V[] vArr2 = arrayTable.array[i11];
            System.arraycopy(vArr2, 0, vArr[i11], 0, vArr2.length);
        }
    }

    private ArrayTable(c4 c4Var) {
        this(c4Var.rowKeySet(), c4Var.columnKeySet());
        putAll(c4Var);
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        com.google.common.base.m.d(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = Maps.j(copyOf);
        this.columnKeyToIndex = Maps.j(copyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, copyOf.size(), copyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(c4 c4Var) {
        return c4Var instanceof ArrayTable ? new ArrayTable<>((ArrayTable) c4Var) : new ArrayTable<>(c4Var);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c4.a getCell(int i11) {
        return new b(this, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i11) {
        return at(i11 / this.columnList.size(), i11 % this.columnList.size());
    }

    public V at(int i11, int i12) {
        com.google.common.base.m.m(i11, this.rowList.size());
        com.google.common.base.m.m(i12, this.columnList.size());
        return this.array[i11][i12];
    }

    @Override // com.google.common.collect.i
    Iterator<c4.a> cellIterator() {
        return new a(size());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.c4
    public Set<c4.a> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Map<R, V> column(C c11) {
        com.google.common.base.m.o(c11);
        Integer num = this.columnKeyToIndex.get(c11);
        return num == null ? Collections.emptyMap() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.c4
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.c4
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f(this, null);
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.i
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.i
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.i
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.i
    public boolean containsValue(Object obj) {
        for (V[] vArr : this.array) {
            for (V v11 : vArr) {
                if (com.google.common.base.j.a(obj, v11)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public V erase(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.i, com.google.common.collect.c4
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.c4
    public V put(R r11, C c11, V v11) {
        com.google.common.base.m.o(r11);
        com.google.common.base.m.o(c11);
        Integer num = this.rowKeyToIndex.get(r11);
        com.google.common.base.m.k(num != null, "Row %s not in %s", r11, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c11);
        com.google.common.base.m.k(num2 != null, "Column %s not in %s", c11, this.columnList);
        return set(num.intValue(), num2.intValue(), v11);
    }

    @Override // com.google.common.collect.i
    public void putAll(c4 c4Var) {
        super.putAll(c4Var);
    }

    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public Map<C, V> row(R r11) {
        com.google.common.base.m.o(r11);
        Integer num = this.rowKeyToIndex.get(r11);
        return num == null ? Collections.emptyMap() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.c4
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.c4
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar != null) {
            return hVar;
        }
        ArrayTable<R, C, V>.h hVar2 = new h(this, null);
        this.rowMap = hVar2;
        return hVar2;
    }

    public V set(int i11, int i12, V v11) {
        com.google.common.base.m.m(i11, this.rowList.size());
        com.google.common.base.m.m(i12, this.columnList.size());
        V[] vArr = this.array[i11];
        V v12 = vArr[i12];
        vArr[i12] = v11;
        return v12;
    }

    @Override // com.google.common.collect.c4
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i11 = 0; i11 < this.rowList.size(); i11++) {
            V[] vArr2 = this.array[i11];
            System.arraycopy(vArr2, 0, vArr[i11], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.i
    Iterator<V> valuesIterator() {
        return new c(size());
    }
}
