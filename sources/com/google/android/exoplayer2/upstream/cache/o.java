package com.google.android.exoplayer2.upstream.cache;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class o implements m {

    /* renamed from: c, reason: collision with root package name */
    public static final o f27434c = new o(Collections.emptyMap());

    /* renamed from: a, reason: collision with root package name */
    private int f27435a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f27436b;

    public o() {
        this(Collections.emptyMap());
    }

    public o(Map map) {
        this.f27436b = Collections.unmodifiableMap(map);
    }

    private static void a(HashMap hashMap, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), e(entry.getValue()));
        }
    }

    private static Map b(Map map, n nVar) {
        HashMap hashMap = new HashMap(map);
        g(hashMap, nVar.c());
        a(hashMap, nVar.b());
        return hashMap;
    }

    private static byte[] e(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(com.google.common.base.c.f30282c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private static boolean f(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static void g(HashMap hashMap, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            hashMap.remove(list.get(i11));
        }
    }

    public o c(n nVar) {
        Map b11 = b(this.f27436b, nVar);
        return f(this.f27436b, b11) ? this : new o(b11);
    }

    public Set d() {
        return this.f27436b.entrySet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return f(this.f27436b, ((o) obj).f27436b);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.m
    public final long get(String str, long j11) {
        byte[] bArr = (byte[]) this.f27436b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j11;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.m
    public final String get(String str, String str2) {
        byte[] bArr = (byte[]) this.f27436b.get(str);
        return bArr != null ? new String(bArr, com.google.common.base.c.f30282c) : str2;
    }

    public int hashCode() {
        if (this.f27435a == 0) {
            int i11 = 0;
            for (Map.Entry entry : this.f27436b.entrySet()) {
                i11 += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.f27435a = i11;
        }
        return this.f27435a;
    }
}
