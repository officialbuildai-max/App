package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.h;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes4.dex */
public final class MapMaker {

    /* renamed from: a, reason: collision with root package name */
    boolean f30594a;

    /* renamed from: b, reason: collision with root package name */
    int f30595b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f30596c = -1;

    /* renamed from: d, reason: collision with root package name */
    MapMakerInternalMap.Strength f30597d;

    /* renamed from: e, reason: collision with root package name */
    MapMakerInternalMap.Strength f30598e;

    /* renamed from: f, reason: collision with root package name */
    Equivalence f30599f;

    /* loaded from: classes4.dex */
    enum Dummy {
        VALUE
    }

    public MapMaker a(int i11) {
        int i12 = this.f30596c;
        com.google.common.base.m.w(i12 == -1, "concurrency level was already set to %s", i12);
        com.google.common.base.m.d(i11 > 0);
        this.f30596c = i11;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i11 = this.f30596c;
        if (i11 == -1) {
            return 4;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        int i11 = this.f30595b;
        if (i11 == -1) {
            return 16;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence d() {
        return (Equivalence) com.google.common.base.h.a(this.f30599f, e().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) com.google.common.base.h.a(this.f30597d, MapMakerInternalMap.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) com.google.common.base.h.a(this.f30598e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i11) {
        int i12 = this.f30595b;
        com.google.common.base.m.w(i12 == -1, "initial capacity was already set to %s", i12);
        com.google.common.base.m.d(i11 >= 0);
        this.f30595b = i11;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker h(Equivalence equivalence) {
        Equivalence equivalence2 = this.f30599f;
        com.google.common.base.m.x(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f30599f = (Equivalence) com.google.common.base.m.o(equivalence);
        this.f30594a = true;
        return this;
    }

    public ConcurrentMap i() {
        return !this.f30594a ? new ConcurrentHashMap(c(), 0.75f, b()) : MapMakerInternalMap.create(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f30597d;
        com.google.common.base.m.x(strength2 == null, "Key strength was already set to %s", strength2);
        this.f30597d = (MapMakerInternalMap.Strength) com.google.common.base.m.o(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f30594a = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f30598e;
        com.google.common.base.m.x(strength2 == null, "Value strength was already set to %s", strength2);
        this.f30598e = (MapMakerInternalMap.Strength) com.google.common.base.m.o(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f30594a = true;
        }
        return this;
    }

    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        h.b b11 = com.google.common.base.h.b(this);
        int i11 = this.f30595b;
        if (i11 != -1) {
            b11.b("initialCapacity", i11);
        }
        int i12 = this.f30596c;
        if (i12 != -1) {
            b11.b("concurrencyLevel", i12);
        }
        MapMakerInternalMap.Strength strength = this.f30597d;
        if (strength != null) {
            b11.d("keyStrength", com.google.common.base.a.e(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f30598e;
        if (strength2 != null) {
            b11.d("valueStrength", com.google.common.base.a.e(strength2.toString()));
        }
        if (this.f30599f != null) {
            b11.j("keyEquivalence");
        }
        return b11.toString();
    }
}
