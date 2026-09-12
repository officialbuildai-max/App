package com.mbridge.msdk.tracker.network;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final int f38669a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f38670b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, String> f38671c;

    /* renamed from: d, reason: collision with root package name */
    public final List<g> f38672d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f38673e;

    /* renamed from: f, reason: collision with root package name */
    public final long f38674f;

    private q(int i11, byte[] bArr, Map<String, String> map, List<g> list, boolean z10, long j11) {
        this.f38669a = i11;
        this.f38670b = bArr;
        this.f38671c = map;
        if (list == null) {
            this.f38672d = null;
        } else {
            this.f38672d = Collections.unmodifiableList(list);
        }
        this.f38673e = z10;
        this.f38674f = j11;
    }

    public q(int i11, byte[] bArr, boolean z10, long j11, List<g> list) {
        this(i11, bArr, a(list), list, z10, j11);
    }

    private static Map<String, String> a(List<g> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g gVar : list) {
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }
}
