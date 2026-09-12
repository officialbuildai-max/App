package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private final transient Object f30688a;
    final transient Object[] alternatingKeysAndValues;

    /* renamed from: b, reason: collision with root package name */
    private final transient int f30689b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final transient ImmutableMap f30690a;

        /* renamed from: b, reason: collision with root package name */
        private final transient Object[] f30691b;

        /* renamed from: c, reason: collision with root package name */
        private final transient int f30692c;

        /* renamed from: d, reason: collision with root package name */
        private final transient int f30693d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i11, int i12) {
            this.f30690a = immutableMap;
            this.f30691b = objArr;
            this.f30692c = i11;
            this.f30693d = i12;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f30690a.get(key));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i11) {
            return asList().copyIntoArray(objArr, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                public Map.Entry<K, V> get(int i11) {
                    com.google.common.base.m.m(i11, EntrySet.this.f30693d);
                    int i12 = i11 * 2;
                    Object obj = EntrySet.this.f30691b[EntrySet.this.f30692c + i12];
                    Objects.requireNonNull(obj);
                    Object obj2 = EntrySet.this.f30691b[i12 + (EntrySet.this.f30692c ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f30693d;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
                public Object writeReplace() {
                    return super.writeReplace();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public r4 iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f30693d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* loaded from: classes4.dex */
    static final class KeySet<K> extends ImmutableSet<K> {

        /* renamed from: a, reason: collision with root package name */
        private final transient ImmutableMap f30694a;

        /* renamed from: b, reason: collision with root package name */
        private final transient ImmutableList f30695b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f30694a = immutableMap;
            this.f30695b = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f30695b;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f30694a.get(obj) != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i11) {
            return asList().copyIntoArray(objArr, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public r4 iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f30694a.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* loaded from: classes4.dex */
    static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final transient Object[] f30696a;

        /* renamed from: b, reason: collision with root package name */
        private final transient int f30697b;

        /* renamed from: c, reason: collision with root package name */
        private final transient int f30698c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeysOrValuesAsList(Object[] objArr, int i11, int i12) {
            this.f30696a = objArr;
            this.f30697b = i11;
            this.f30698c = i12;
        }

        @Override // java.util.List
        public Object get(int i11) {
            com.google.common.base.m.m(i11, this.f30698c);
            Object obj = this.f30696a[(i11 * 2) + this.f30697b];
            Objects.requireNonNull(obj);
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f30698c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return super.writeReplace();
        }
    }

    private RegularImmutableMap(Object obj, Object[] objArr, int i11) {
        this.f30688a = obj;
        this.alternatingKeysAndValues = objArr;
        this.f30689b = i11;
    }

    private static Object a(Object[] objArr, int i11, int i12, int i13) {
        ImmutableMap.b.a aVar = null;
        if (i11 == 1) {
            Object obj = objArr[i13];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i13 ^ 1];
            Objects.requireNonNull(obj2);
            e2.a(obj, obj2);
            return null;
        }
        int i14 = i12 - 1;
        int i15 = -1;
        if (i12 <= 128) {
            byte[] bArr = new byte[i12];
            Arrays.fill(bArr, (byte) -1);
            int i16 = 0;
            for (int i17 = 0; i17 < i11; i17++) {
                int i18 = (i17 * 2) + i13;
                int i19 = (i16 * 2) + i13;
                Object obj3 = objArr[i18];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i18 ^ 1];
                Objects.requireNonNull(obj4);
                e2.a(obj3, obj4);
                int c11 = v2.c(obj3.hashCode());
                while (true) {
                    int i20 = c11 & i14;
                    int i21 = bArr[i20] & 255;
                    if (i21 == 255) {
                        bArr[i20] = (byte) i19;
                        if (i16 < i17) {
                            objArr[i19] = obj3;
                            objArr[i19 ^ 1] = obj4;
                        }
                        i16++;
                    } else {
                        if (obj3.equals(objArr[i21])) {
                            int i22 = i21 ^ 1;
                            Object obj5 = objArr[i22];
                            Objects.requireNonNull(obj5);
                            aVar = new ImmutableMap.b.a(obj3, obj4, obj5);
                            objArr[i22] = obj4;
                            break;
                        }
                        c11 = i20 + 1;
                    }
                }
            }
            return i16 == i11 ? bArr : new Object[]{bArr, Integer.valueOf(i16), aVar};
        }
        if (i12 <= 32768) {
            short[] sArr = new short[i12];
            Arrays.fill(sArr, (short) -1);
            int i23 = 0;
            for (int i24 = 0; i24 < i11; i24++) {
                int i25 = (i24 * 2) + i13;
                int i26 = (i23 * 2) + i13;
                Object obj6 = objArr[i25];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i25 ^ 1];
                Objects.requireNonNull(obj7);
                e2.a(obj6, obj7);
                int c12 = v2.c(obj6.hashCode());
                while (true) {
                    int i27 = c12 & i14;
                    int i28 = sArr[i27] & 65535;
                    if (i28 == 65535) {
                        sArr[i27] = (short) i26;
                        if (i23 < i24) {
                            objArr[i26] = obj6;
                            objArr[i26 ^ 1] = obj7;
                        }
                        i23++;
                    } else {
                        if (obj6.equals(objArr[i28])) {
                            int i29 = i28 ^ 1;
                            Object obj8 = objArr[i29];
                            Objects.requireNonNull(obj8);
                            aVar = new ImmutableMap.b.a(obj6, obj7, obj8);
                            objArr[i29] = obj7;
                            break;
                        }
                        c12 = i27 + 1;
                    }
                }
            }
            return i23 == i11 ? sArr : new Object[]{sArr, Integer.valueOf(i23), aVar};
        }
        int[] iArr = new int[i12];
        Arrays.fill(iArr, -1);
        int i30 = 0;
        int i31 = 0;
        while (i30 < i11) {
            int i32 = (i30 * 2) + i13;
            int i33 = (i31 * 2) + i13;
            Object obj9 = objArr[i32];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i32 ^ 1];
            Objects.requireNonNull(obj10);
            e2.a(obj9, obj10);
            int c13 = v2.c(obj9.hashCode());
            while (true) {
                int i34 = c13 & i14;
                int i35 = iArr[i34];
                if (i35 == i15) {
                    iArr[i34] = i33;
                    if (i31 < i30) {
                        objArr[i33] = obj9;
                        objArr[i33 ^ 1] = obj10;
                    }
                    i31++;
                } else {
                    if (obj9.equals(objArr[i35])) {
                        int i36 = i35 ^ 1;
                        Object obj11 = objArr[i36];
                        Objects.requireNonNull(obj11);
                        aVar = new ImmutableMap.b.a(obj9, obj10, obj11);
                        objArr[i36] = obj10;
                        break;
                    }
                    c13 = i34 + 1;
                    i15 = -1;
                }
            }
            i30++;
            i15 = -1;
        }
        return i31 == i11 ? iArr : new Object[]{iArr, Integer.valueOf(i31), aVar};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> create(int i11, Object[] objArr) {
        return create(i11, objArr, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> create(int i11, Object[] objArr, ImmutableMap.b bVar) {
        if (i11 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i11 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            e2.a(obj, obj2);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        com.google.common.base.m.r(i11, objArr.length >> 1);
        Object a11 = a(objArr, i11, ImmutableSet.chooseTableSize(i11), 0);
        if (a11 instanceof Object[]) {
            Object[] objArr2 = (Object[]) a11;
            ImmutableMap.b.a aVar = (ImmutableMap.b.a) objArr2[2];
            if (bVar == null) {
                throw aVar.a();
            }
            bVar.f30477e = aVar;
            Object obj3 = objArr2[0];
            int intValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, intValue * 2);
            a11 = obj3;
            i11 = intValue;
        }
        return new RegularImmutableMap<>(a11, objArr, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object createHashTableOrThrow(Object[] objArr, int i11, int i12, int i13) {
        Object a11 = a(objArr, i11, i12, i13);
        if (a11 instanceof Object[]) {
            throw ((ImmutableMap.b.a) ((Object[]) a11)[2]).a();
        }
        return a11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object get(Object obj, Object[] objArr, int i11, int i12, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i11 == 1) {
            Object obj3 = objArr[i12];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i12 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int c11 = v2.c(obj2.hashCode());
            while (true) {
                int i13 = c11 & length;
                int i14 = bArr[i13] & 255;
                if (i14 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i14])) {
                    return objArr[i14 ^ 1];
                }
                c11 = i13 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int c12 = v2.c(obj2.hashCode());
            while (true) {
                int i15 = c12 & length2;
                int i16 = sArr[i15] & 65535;
                if (i16 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i16])) {
                    return objArr[i16 ^ 1];
                }
                c12 = i15 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int c13 = v2.c(obj2.hashCode());
            while (true) {
                int i17 = c13 & length3;
                int i18 = iArr[i17];
                if (i18 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i18])) {
                    return objArr[i18 ^ 1];
                }
                c13 = i17 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.f30689b);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.f30689b));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.f30689b);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        V v11 = (V) get(this.f30688a, this.alternatingKeysAndValues, this.f30689b, 0, obj);
        if (v11 == null) {
            return null;
        }
        return v11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f30689b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return super.writeReplace();
    }
}
