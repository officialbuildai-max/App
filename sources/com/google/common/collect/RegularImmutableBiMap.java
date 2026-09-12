package com.google.common.collect;

import com.google.common.collect.RegularImmutableMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final transient Object f30683a;
    final transient Object[] alternatingKeysAndValues;

    /* renamed from: b, reason: collision with root package name */
    private final transient int f30684b;

    /* renamed from: c, reason: collision with root package name */
    private final transient int f30685c;

    /* renamed from: d, reason: collision with root package name */
    private final transient RegularImmutableBiMap f30686d;

    private RegularImmutableBiMap() {
        this.f30683a = null;
        this.alternatingKeysAndValues = new Object[0];
        this.f30684b = 0;
        this.f30685c = 0;
        this.f30686d = this;
    }

    private RegularImmutableBiMap(Object obj, Object[] objArr, int i11, RegularImmutableBiMap regularImmutableBiMap) {
        this.f30683a = obj;
        this.alternatingKeysAndValues = objArr;
        this.f30684b = 1;
        this.f30685c = i11;
        this.f30686d = regularImmutableBiMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableBiMap(Object[] objArr, int i11) {
        this.alternatingKeysAndValues = objArr;
        this.f30685c = i11;
        this.f30684b = 0;
        int chooseTableSize = i11 >= 2 ? ImmutableSet.chooseTableSize(i11) : 0;
        this.f30683a = RegularImmutableMap.createHashTableOrThrow(objArr, i11, chooseTableSize, 0);
        this.f30686d = new RegularImmutableBiMap(RegularImmutableMap.createHashTableOrThrow(objArr, i11, chooseTableSize, 1), objArr, i11, this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.f30684b, this.f30685c);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.f30684b, this.f30685c));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        V v11 = (V) RegularImmutableMap.get(this.f30683a, this.alternatingKeysAndValues, this.f30685c, this.f30684b, obj);
        if (v11 == null) {
            return null;
        }
        return v11;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
    public ImmutableBiMap<V, K> inverse() {
        return this.f30686d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f30685c;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return super.writeReplace();
    }
}
