package com.android.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f19316a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f19317b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f19318c;

    /* renamed from: d, reason: collision with root package name */
    public final List f19319d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f19320e;

    /* renamed from: f, reason: collision with root package name */
    public final long f19321f;

    private g(int i11, byte[] bArr, Map map, List list, boolean z10, long j11) {
        this.f19316a = i11;
        this.f19317b = bArr;
        this.f19318c = map;
        if (list == null) {
            this.f19319d = null;
        } else {
            this.f19319d = Collections.unmodifiableList(list);
        }
        this.f19320e = z10;
        this.f19321f = j11;
    }

    public g(int i11, byte[] bArr, Map map, boolean z10, long j11) {
        this(i11, bArr, map, a(map), z10, j11);
    }

    public g(int i11, byte[] bArr, boolean z10, long j11, List list) {
        this(i11, bArr, b(list), list, z10, j11);
    }

    public g(byte[] bArr, Map map) {
        this(200, bArr, map, false, 0L);
    }

    private static List a(Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new e((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    private static Map b(List list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            treeMap.put(eVar.a(), eVar.b());
        }
        return treeMap;
    }
}
