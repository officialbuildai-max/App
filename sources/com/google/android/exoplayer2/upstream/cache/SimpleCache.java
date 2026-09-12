package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public final class SimpleCache implements Cache {

    /* renamed from: l, reason: collision with root package name */
    private static final HashSet f27344l = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private final File f27345a;

    /* renamed from: b, reason: collision with root package name */
    private final b f27346b;

    /* renamed from: c, reason: collision with root package name */
    private final k f27347c;

    /* renamed from: d, reason: collision with root package name */
    private final d f27348d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f27349e;

    /* renamed from: f, reason: collision with root package name */
    private final Random f27350f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f27351g;

    /* renamed from: h, reason: collision with root package name */
    private long f27352h;

    /* renamed from: i, reason: collision with root package name */
    private long f27353i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f27354j;

    /* renamed from: k, reason: collision with root package name */
    private Cache.CacheException f27355k;

    SimpleCache(File file, b bVar, k kVar, d dVar) {
        if (!t(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f27345a = file;
        this.f27346b = bVar;
        this.f27347c = kVar;
        this.f27348d = dVar;
        this.f27349e = new HashMap();
        this.f27350f = new Random();
        this.f27351g = bVar.a();
        this.f27352h = -1L;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread("ExoPlayer:SimpleCacheInit") { // from class: com.google.android.exoplayer2.upstream.cache.SimpleCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    SimpleCache.this.q();
                    SimpleCache.this.f27346b.onCacheInitialized();
                }
            }
        }.start();
        conditionVariable.block();
    }

    public SimpleCache(File file, b bVar, f9.a aVar) {
        this(file, bVar, aVar, null, false, false);
    }

    public SimpleCache(File file, b bVar, f9.a aVar, byte[] bArr, boolean z10, boolean z11) {
        this(file, bVar, new k(aVar, file, bArr, z10, z11), (aVar == null || z11) ? null : new d(aVar));
    }

    private s A(String str, s sVar) {
        boolean z10;
        if (!this.f27351g) {
            return sVar;
        }
        String name = ((File) com.google.android.exoplayer2.util.a.e(sVar.f27395e)).getName();
        long j11 = sVar.f27393c;
        long currentTimeMillis = System.currentTimeMillis();
        d dVar = this.f27348d;
        if (dVar != null) {
            try {
                dVar.h(name, j11, currentTimeMillis);
            } catch (IOException unused) {
                com.google.android.exoplayer2.util.s.i("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z10 = false;
        } else {
            z10 = true;
        }
        s l11 = this.f27347c.g(str).l(sVar, currentTimeMillis, z10);
        w(sVar, l11);
        return l11;
    }

    private void k(s sVar) {
        this.f27347c.m(sVar.f27391a).a(sVar);
        this.f27353i += sVar.f27393c;
        u(sVar);
    }

    private static void m(File file) {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        com.google.android.exoplayer2.util.s.c("SimpleCache", str);
        throw new Cache.CacheException(str);
    }

    private static long n(File file) {
        long nextLong = new SecureRandom().nextLong();
        long abs = nextLong == Long.MIN_VALUE ? 0L : Math.abs(nextLong);
        File file2 = new File(file, Long.toString(abs, 16) + ".uid");
        if (file2.createNewFile()) {
            return abs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    private s p(String str, long j11, long j12) {
        s e11;
        j g11 = this.f27347c.g(str);
        if (g11 == null) {
            return s.h(str, j11, j12);
        }
        while (true) {
            e11 = g11.e(j11, j12);
            if (!e11.f27394d || e11.f27395e.length() == e11.f27393c) {
                break;
            }
            z();
        }
        return e11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (!this.f27345a.exists()) {
            try {
                m(this.f27345a);
            } catch (Cache.CacheException e11) {
                this.f27355k = e11;
                return;
            }
        }
        File[] listFiles = this.f27345a.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + this.f27345a;
            com.google.android.exoplayer2.util.s.c("SimpleCache", str);
            this.f27355k = new Cache.CacheException(str);
            return;
        }
        long s11 = s(listFiles);
        this.f27352h = s11;
        if (s11 == -1) {
            try {
                this.f27352h = n(this.f27345a);
            } catch (IOException e12) {
                String str2 = "Failed to create cache UID: " + this.f27345a;
                com.google.android.exoplayer2.util.s.d("SimpleCache", str2, e12);
                this.f27355k = new Cache.CacheException(str2, e12);
                return;
            }
        }
        try {
            this.f27347c.n(this.f27352h);
            d dVar = this.f27348d;
            if (dVar != null) {
                dVar.e(this.f27352h);
                Map b11 = this.f27348d.b();
                r(this.f27345a, true, listFiles, b11);
                this.f27348d.g(b11.keySet());
            } else {
                r(this.f27345a, true, listFiles, null);
            }
            this.f27347c.r();
            try {
                this.f27347c.s();
            } catch (IOException e13) {
                com.google.android.exoplayer2.util.s.d("SimpleCache", "Storing index file failed", e13);
            }
        } catch (IOException e14) {
            String str3 = "Failed to initialize cache indices: " + this.f27345a;
            com.google.android.exoplayer2.util.s.d("SimpleCache", str3, e14);
            this.f27355k = new Cache.CacheException(str3, e14);
        }
    }

    private void r(File file, boolean z10, File[] fileArr, Map map) {
        long j11;
        long j12;
        if (fileArr == null || fileArr.length == 0) {
            if (z10) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z10 && name.indexOf(46) == -1) {
                r(file2, false, file2.listFiles(), map);
            } else if (!z10 || (!k.o(name) && !name.endsWith(".uid"))) {
                c cVar = map != null ? (c) map.remove(name) : null;
                if (cVar != null) {
                    j12 = cVar.f27385a;
                    j11 = cVar.f27386b;
                } else {
                    j11 = -9223372036854775807L;
                    j12 = -1;
                }
                s f11 = s.f(file2, j12, j11, this.f27347c);
                if (f11 != null) {
                    k(f11);
                } else {
                    file2.delete();
                }
            }
        }
    }

    private static long s(File[] fileArr) {
        int length = fileArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            File file = fileArr[i11];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return x(name);
                } catch (NumberFormatException unused) {
                    com.google.android.exoplayer2.util.s.c("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private static synchronized boolean t(File file) {
        boolean add;
        synchronized (SimpleCache.class) {
            add = f27344l.add(file.getAbsoluteFile());
        }
        return add;
    }

    private void u(s sVar) {
        ArrayList arrayList = (ArrayList) this.f27349e.get(sVar.f27391a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).b(this, sVar);
            }
        }
        this.f27346b.b(this, sVar);
    }

    private void v(h hVar) {
        ArrayList arrayList = (ArrayList) this.f27349e.get(hVar.f27391a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).d(this, hVar);
            }
        }
        this.f27346b.d(this, hVar);
    }

    private void w(s sVar, h hVar) {
        ArrayList arrayList = (ArrayList) this.f27349e.get(sVar.f27391a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).e(this, sVar, hVar);
            }
        }
        this.f27346b.e(this, sVar, hVar);
    }

    private static long x(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void y(h hVar) {
        j g11 = this.f27347c.g(hVar.f27391a);
        if (g11 == null || !g11.k(hVar)) {
            return;
        }
        this.f27353i -= hVar.f27393c;
        if (this.f27348d != null) {
            String name = hVar.f27395e.getName();
            try {
                this.f27348d.f(name);
            } catch (IOException unused) {
                com.google.android.exoplayer2.util.s.i("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.f27347c.p(g11.f27408b);
        v(hVar);
    }

    private void z() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f27347c.h().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((j) it.next()).f().iterator();
            while (it2.hasNext()) {
                h hVar = (h) it2.next();
                if (hVar.f27395e.length() != hVar.f27393c) {
                    arrayList.add(hVar);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            y((h) arrayList.get(i11));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long a(String str, long j11, long j12) {
        long j13;
        long j14 = j12 == -1 ? Long.MAX_VALUE : j11 + j12;
        long j15 = j14 >= 0 ? j14 : Long.MAX_VALUE;
        long j16 = j11;
        j13 = 0;
        while (j16 < j15) {
            long cachedLength = getCachedLength(str, j16, j15 - j16);
            if (cachedLength > 0) {
                j13 += cachedLength;
            } else {
                cachedLength = -cachedLength;
            }
            j16 += cachedLength;
        }
        return j13;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized h b(String str, long j11, long j12) {
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        l();
        s p11 = p(str, j11, j12);
        if (p11.f27394d) {
            return A(str, p11);
        }
        if (this.f27347c.m(str).j(j11, p11.f27393c)) {
            return p11;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized h c(String str, long j11, long j12) {
        h b11;
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        l();
        while (true) {
            b11 = b(str, j11, j12);
            if (b11 == null) {
                wait();
            }
        }
        return b11;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void d(File file, long j11) {
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        if (file.exists()) {
            if (j11 == 0) {
                file.delete();
                return;
            }
            s sVar = (s) com.google.android.exoplayer2.util.a.e(s.g(file, j11, this.f27347c));
            j jVar = (j) com.google.android.exoplayer2.util.a.e(this.f27347c.g(sVar.f27391a));
            com.google.android.exoplayer2.util.a.g(jVar.h(sVar.f27392b, sVar.f27393c));
            long a11 = l.a(jVar.d());
            if (a11 != -1) {
                com.google.android.exoplayer2.util.a.g(sVar.f27392b + sVar.f27393c <= a11);
            }
            if (this.f27348d != null) {
                try {
                    this.f27348d.h(file.getName(), sVar.f27393c, sVar.f27396f);
                } catch (IOException e11) {
                    throw new Cache.CacheException(e11);
                }
            }
            k(sVar);
            try {
                this.f27347c.s();
                notifyAll();
            } catch (IOException e12) {
                throw new Cache.CacheException(e12);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void e(String str) {
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        Iterator it = o(str).iterator();
        while (it.hasNext()) {
            y((h) it.next());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void f(String str, n nVar) {
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        l();
        this.f27347c.e(str, nVar);
        try {
            this.f27347c.s();
        } catch (IOException e11) {
            throw new Cache.CacheException(e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void g(h hVar) {
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        j jVar = (j) com.google.android.exoplayer2.util.a.e(this.f27347c.g(hVar.f27391a));
        jVar.m(hVar.f27392b);
        this.f27347c.p(jVar.f27408b);
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedLength(String str, long j11, long j12) {
        j g11;
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        if (j12 == -1) {
            j12 = Long.MAX_VALUE;
        }
        g11 = this.f27347c.g(str);
        return g11 != null ? g11.c(j11, j12) : -j12;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized m getContentMetadata(String str) {
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        return this.f27347c.j(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void h(h hVar) {
        com.google.android.exoplayer2.util.a.g(!this.f27354j);
        y(hVar);
    }

    public synchronized void l() {
        Cache.CacheException cacheException = this.f27355k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public synchronized NavigableSet o(String str) {
        TreeSet treeSet;
        try {
            com.google.android.exoplayer2.util.a.g(!this.f27354j);
            j g11 = this.f27347c.g(str);
            if (g11 != null && !g11.g()) {
                treeSet = new TreeSet((Collection) g11.f());
            }
            treeSet = new TreeSet();
        } catch (Throwable th2) {
            throw th2;
        }
        return treeSet;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File startFile(String str, long j11, long j12) {
        j g11;
        File file;
        try {
            com.google.android.exoplayer2.util.a.g(!this.f27354j);
            l();
            g11 = this.f27347c.g(str);
            com.google.android.exoplayer2.util.a.e(g11);
            com.google.android.exoplayer2.util.a.g(g11.h(j11, j12));
            if (!this.f27345a.exists()) {
                m(this.f27345a);
                z();
            }
            this.f27346b.c(this, str, j11, j12);
            file = new File(this.f27345a, Integer.toString(this.f27350f.nextInt(10)));
            if (!file.exists()) {
                m(file);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return s.j(file, g11.f27407a, j11, System.currentTimeMillis());
    }
}
