package com.google.android.exoplayer2.upstream.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public final class q implements b {

    /* renamed from: a, reason: collision with root package name */
    private final long f27437a;

    /* renamed from: b, reason: collision with root package name */
    private final TreeSet f27438b = new TreeSet(new Comparator() { // from class: com.google.android.exoplayer2.upstream.cache.p
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g11;
            g11 = q.g((h) obj, (h) obj2);
            return g11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private long f27439c;

    public q(long j11) {
        this.f27437a = j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(h hVar, h hVar2) {
        long j11 = hVar.f27396f;
        long j12 = hVar2.f27396f;
        return j11 - j12 == 0 ? hVar.compareTo(hVar2) : j11 < j12 ? -1 : 1;
    }

    private void h(Cache cache, long j11) {
        while (this.f27439c + j11 > this.f27437a && !this.f27438b.isEmpty()) {
            cache.h((h) this.f27438b.first());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public boolean a() {
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void b(Cache cache, h hVar) {
        this.f27438b.add(hVar);
        this.f27439c += hVar.f27393c;
        h(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public void c(Cache cache, String str, long j11, long j12) {
        if (j12 != -1) {
            h(cache, j12);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void d(Cache cache, h hVar) {
        this.f27438b.remove(hVar);
        this.f27439c -= hVar.f27393c;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void e(Cache cache, h hVar, h hVar2) {
        d(cache, hVar);
        b(cache, hVar2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public void onCacheInitialized() {
    }
}
