package androidx.media3.datasource.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public final class q implements b {

    /* renamed from: a, reason: collision with root package name */
    private final long f10946a;

    /* renamed from: b, reason: collision with root package name */
    private final TreeSet f10947b = new TreeSet(new Comparator() { // from class: androidx.media3.datasource.cache.p
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g11;
            g11 = q.g((h) obj, (h) obj2);
            return g11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private long f10948c;

    public q(long j11) {
        this.f10946a = j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(h hVar, h hVar2) {
        long j11 = hVar.f10905f;
        long j12 = hVar2.f10905f;
        return j11 - j12 == 0 ? hVar.compareTo(hVar2) : j11 < j12 ? -1 : 1;
    }

    private void h(Cache cache, long j11) {
        while (this.f10948c + j11 > this.f10946a && !this.f10947b.isEmpty()) {
            cache.f((h) this.f10947b.first());
        }
    }

    @Override // androidx.media3.datasource.cache.b
    public boolean a() {
        return true;
    }

    @Override // androidx.media3.datasource.cache.Cache.a
    public void b(Cache cache, h hVar, h hVar2) {
        e(cache, hVar);
        c(cache, hVar2);
    }

    @Override // androidx.media3.datasource.cache.Cache.a
    public void c(Cache cache, h hVar) {
        this.f10947b.add(hVar);
        this.f10948c += hVar.f10902c;
        h(cache, 0L);
    }

    @Override // androidx.media3.datasource.cache.b
    public void d(Cache cache, String str, long j11, long j12) {
        if (j12 != -1) {
            h(cache, j12);
        }
    }

    @Override // androidx.media3.datasource.cache.Cache.a
    public void e(Cache cache, h hVar) {
        this.f10947b.remove(hVar);
        this.f10948c -= hVar.f10902c;
    }

    @Override // androidx.media3.datasource.cache.b
    public void onCacheInitialized() {
    }
}
