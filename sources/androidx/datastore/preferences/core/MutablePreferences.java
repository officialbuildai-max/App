package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class MutablePreferences extends c {

    /* renamed from: a, reason: collision with root package name */
    private final Map f8733a;

    /* renamed from: b, reason: collision with root package name */
    private final b f8734b;

    /* JADX WARN: Multi-variable type inference failed */
    public MutablePreferences() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public MutablePreferences(Map preferencesMap, boolean z10) {
        Intrinsics.h(preferencesMap, "preferencesMap");
        this.f8733a = preferencesMap;
        this.f8734b = new b(z10);
    }

    public /* synthetic */ MutablePreferences(Map map, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new LinkedHashMap() : map, (i11 & 2) != 0 ? true : z10);
    }

    @Override // androidx.datastore.preferences.core.c
    public Map a() {
        Pair pair;
        Set<Map.Entry> entrySet = this.f8733a.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.g(copyOf, "copyOf(this, size)");
                pair = new Pair(key, copyOf);
            } else {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return a.b(linkedHashMap);
    }

    @Override // androidx.datastore.preferences.core.c
    public Object b(c.a key) {
        Intrinsics.h(key, "key");
        Object obj = this.f8733a.get(key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final void e() {
        if (this.f8734b.a()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[LOOP:0: B:16:0x002f->B:31:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            androidx.datastore.preferences.core.MutablePreferences r6 = (androidx.datastore.preferences.core.MutablePreferences) r6
            java.util.Map r0 = r6.f8733a
            java.util.Map r2 = r5.f8733a
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map r2 = r5.f8733a
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map r6 = r6.f8733a
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L27
        L25:
            r1 = r3
            goto L67
        L27:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2f:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L25
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map r2 = r5.f8733a
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L64
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L5f
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L64
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L64
            r0 = r3
            goto L65
        L5f:
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r2)
            goto L65
        L64:
            r0 = r1
        L65:
            if (r0 != 0) goto L2f
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public final void f() {
        this.f8734b.b(true);
    }

    public final void g(c.b... pairs) {
        Intrinsics.h(pairs, "pairs");
        e();
        if (pairs.length <= 0) {
            return;
        }
        c.b bVar = pairs[0];
        throw null;
    }

    public final Object h(c.a key) {
        Intrinsics.h(key, "key");
        e();
        return this.f8733a.remove(key);
    }

    public int hashCode() {
        Iterator it = this.f8733a.entrySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            i11 += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return i11;
    }

    public final void i(c.a key, Object obj) {
        Intrinsics.h(key, "key");
        j(key, obj);
    }

    public final void j(c.a key, Object obj) {
        Intrinsics.h(key, "key");
        e();
        if (obj == null) {
            h(key);
            return;
        }
        if (obj instanceof Set) {
            this.f8733a.put(key, a.a((Set) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            this.f8733a.put(key, obj);
            return;
        }
        Map map = this.f8733a;
        byte[] bArr = (byte[]) obj;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        map.put(key, copyOf);
    }

    public String toString() {
        return CollectionsKt.s0(this.f8733a.entrySet(), ",\n", "{\n", "\n}", 0, null, new Function1<Map.Entry<c.a, Object>, CharSequence>() { // from class: androidx.datastore.preferences.core.MutablePreferences$toString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Map.Entry<c.a, Object> entry) {
                Intrinsics.h(entry, "entry");
                Object value = entry.getValue();
                return "  " + entry.getKey().a() + " = " + (value instanceof byte[] ? ArraysKt.o0((byte[]) value, ", ", "[", "]", 0, null, null, 56, null) : String.valueOf(entry.getValue()));
            }
        }, 24, null);
    }
}
