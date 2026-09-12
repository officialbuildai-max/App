package androidx.media3.datasource.cache;

import android.os.ConditionVariable;
import androidx.media3.common.util.u;
import androidx.media3.datasource.cache.Cache;
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

/* loaded from: classes2.dex */
public final class SimpleCache implements Cache {

    /* renamed from: l, reason: collision with root package name */
    private static final HashSet f10853l = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private final File f10854a;

    /* renamed from: b, reason: collision with root package name */
    private final b f10855b;

    /* renamed from: c, reason: collision with root package name */
    private final k f10856c;

    /* renamed from: d, reason: collision with root package name */
    private final d f10857d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f10858e;

    /* renamed from: f, reason: collision with root package name */
    private final Random f10859f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f10860g;

    /* renamed from: h, reason: collision with root package name */
    private long f10861h;

    /* renamed from: i, reason: collision with root package name */
    private long f10862i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10863j;

    /* renamed from: k, reason: collision with root package name */
    private Cache.CacheException f10864k;

    SimpleCache(File file, b bVar, k kVar, d dVar) {
        if (!t(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f10854a = file;
        this.f10855b = bVar;
        this.f10856c = kVar;
        this.f10857d = dVar;
        this.f10858e = new HashMap();
        this.f10859f = new Random();
        this.f10860g = bVar.a();
        this.f10861h = -1L;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread("ExoPlayer:SimpleCacheInit") { // from class: androidx.media3.datasource.cache.SimpleCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    SimpleCache.this.q();
                    SimpleCache.this.f10855b.onCacheInitialized();
                }
            }
        }.start();
        conditionVariable.block();
    }

    public SimpleCache(File file, b bVar, v1.a aVar) {
        this(file, bVar, aVar, null, false, false);
    }

    public SimpleCache(File file, b bVar, v1.a aVar, byte[] bArr, boolean z10, boolean z11) {
        this(file, bVar, new k(aVar, file, bArr, z10, z11), (aVar == null || z11) ? null : new d(aVar));
    }

    private s A(String str, s sVar) {
        boolean z10;
        if (!this.f10860g) {
            return sVar;
        }
        String name = ((File) androidx.media3.common.util.a.e(sVar.f10904e)).getName();
        long j11 = sVar.f10902c;
        long currentTimeMillis = System.currentTimeMillis();
        d dVar = this.f10857d;
        if (dVar != null) {
            try {
                dVar.h(name, j11, currentTimeMillis);
            } catch (IOException unused) {
                u.h("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z10 = false;
        } else {
            z10 = true;
        }
        s l11 = ((j) androidx.media3.common.util.a.e(this.f10856c.f(str))).l(sVar, currentTimeMillis, z10);
        w(sVar, l11);
        return l11;
    }

    private void k(s sVar) {
        this.f10856c.k(sVar.f10900a).a(sVar);
        this.f10862i += sVar.f10902c;
        u(sVar);
    }

    private static void m(File file) {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        u.c("SimpleCache", str);
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
        j f11 = this.f10856c.f(str);
        if (f11 == null) {
            return s.h(str, j11, j12);
        }
        while (true) {
            e11 = f11.e(j11, j12);
            if (!e11.f10903d || ((File) androidx.media3.common.util.a.e(e11.f10904e)).length() == e11.f10902c) {
                break;
            }
            z();
        }
        return e11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (!this.f10854a.exists()) {
            try {
                m(this.f10854a);
            } catch (Cache.CacheException e11) {
                this.f10864k = e11;
                return;
            }
        }
        File[] listFiles = this.f10854a.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + this.f10854a;
            u.c("SimpleCache", str);
            this.f10864k = new Cache.CacheException(str);
            return;
        }
        long s11 = s(listFiles);
        this.f10861h = s11;
        if (s11 == -1) {
            try {
                this.f10861h = n(this.f10854a);
            } catch (IOException e12) {
                String str2 = "Failed to create cache UID: " + this.f10854a;
                u.d("SimpleCache", str2, e12);
                this.f10864k = new Cache.CacheException(str2, e12);
                return;
            }
        }
        try {
            this.f10856c.l(this.f10861h);
            d dVar = this.f10857d;
            if (dVar != null) {
                dVar.e(this.f10861h);
                Map b11 = this.f10857d.b();
                r(this.f10854a, true, listFiles, b11);
                this.f10857d.g(b11.keySet());
            } else {
                r(this.f10854a, true, listFiles, null);
            }
            this.f10856c.p();
            try {
                this.f10856c.q();
            } catch (IOException e13) {
                u.d("SimpleCache", "Storing index file failed", e13);
            }
        } catch (IOException e14) {
            String str3 = "Failed to initialize cache indices: " + this.f10854a;
            u.d("SimpleCache", str3, e14);
            this.f10864k = new Cache.CacheException(str3, e14);
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
            } else if (!z10 || (!k.m(name) && !name.endsWith(".uid"))) {
                c cVar = map != null ? (c) map.remove(name) : null;
                if (cVar != null) {
                    j12 = cVar.f10894a;
                    j11 = cVar.f10895b;
                } else {
                    j11 = -9223372036854775807L;
                    j12 = -1;
                }
                s f11 = s.f(file2, j12, j11, this.f10856c);
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
                    u.c("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private static synchronized boolean t(File file) {
        boolean add;
        synchronized (SimpleCache.class) {
            add = f10853l.add(file.getAbsoluteFile());
        }
        return add;
    }

    private void u(s sVar) {
        ArrayList arrayList = (ArrayList) this.f10858e.get(sVar.f10900a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).c(this, sVar);
            }
        }
        this.f10855b.c(this, sVar);
    }

    private void v(h hVar) {
        ArrayList arrayList = (ArrayList) this.f10858e.get(hVar.f10900a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).e(this, hVar);
            }
        }
        this.f10855b.e(this, hVar);
    }

    private void w(s sVar, h hVar) {
        ArrayList arrayList = (ArrayList) this.f10858e.get(sVar.f10900a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.a) arrayList.get(size)).b(this, sVar, hVar);
            }
        }
        this.f10855b.b(this, sVar, hVar);
    }

    private static long x(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void y(h hVar) {
        j f11 = this.f10856c.f(hVar.f10900a);
        if (f11 == null || !f11.k(hVar)) {
            return;
        }
        this.f10862i -= hVar.f10902c;
        if (this.f10857d != null) {
            String name = ((File) androidx.media3.common.util.a.e(hVar.f10904e)).getName();
            try {
                this.f10857d.f(name);
            } catch (IOException unused) {
                u.h("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.f10856c.n(f11.f10917b);
        v(hVar);
    }

    private void z() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f10856c.g().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((j) it.next()).f().iterator();
            while (it2.hasNext()) {
                h hVar = (h) it2.next();
                if (((File) androidx.media3.common.util.a.e(hVar.f10904e)).length() != hVar.f10902c) {
                    arrayList.add(hVar);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            y((h) arrayList.get(i11));
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
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

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized h b(String str, long j11, long j12) {
        androidx.media3.common.util.a.g(!this.f10863j);
        l();
        s p11 = p(str, j11, j12);
        if (p11.f10903d) {
            return A(str, p11);
        }
        if (this.f10856c.k(str).j(j11, p11.f10902c)) {
            return p11;
        }
        return null;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized h c(String str, long j11, long j12) {
        h b11;
        androidx.media3.common.util.a.g(!this.f10863j);
        l();
        while (true) {
            b11 = b(str, j11, j12);
            if (b11 == null) {
                wait();
            }
        }
        return b11;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void d(File file, long j11) {
        androidx.media3.common.util.a.g(!this.f10863j);
        if (file.exists()) {
            if (j11 == 0) {
                file.delete();
                return;
            }
            s sVar = (s) androidx.media3.common.util.a.e(s.g(file, j11, this.f10856c));
            j jVar = (j) androidx.media3.common.util.a.e(this.f10856c.f(sVar.f10900a));
            androidx.media3.common.util.a.g(jVar.h(sVar.f10901b, sVar.f10902c));
            long a11 = l.a(jVar.d());
            if (a11 != -1) {
                androidx.media3.common.util.a.g(sVar.f10901b + sVar.f10902c <= a11);
            }
            if (this.f10857d != null) {
                try {
                    this.f10857d.h(file.getName(), sVar.f10902c, sVar.f10905f);
                } catch (IOException e11) {
                    throw new Cache.CacheException(e11);
                }
            }
            k(sVar);
            try {
                this.f10856c.q();
                notifyAll();
            } catch (IOException e12) {
                throw new Cache.CacheException(e12);
            }
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void e(String str) {
        androidx.media3.common.util.a.g(!this.f10863j);
        Iterator it = o(str).iterator();
        while (it.hasNext()) {
            y((h) it.next());
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void f(h hVar) {
        androidx.media3.common.util.a.g(!this.f10863j);
        y(hVar);
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void g(h hVar) {
        androidx.media3.common.util.a.g(!this.f10863j);
        j jVar = (j) androidx.media3.common.util.a.e(this.f10856c.f(hVar.f10900a));
        jVar.m(hVar.f10901b);
        this.f10856c.n(jVar.f10917b);
        notifyAll();
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long getCachedLength(String str, long j11, long j12) {
        j f11;
        androidx.media3.common.util.a.g(!this.f10863j);
        if (j12 == -1) {
            j12 = Long.MAX_VALUE;
        }
        f11 = this.f10856c.f(str);
        return f11 != null ? f11.c(j11, j12) : -j12;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized m getContentMetadata(String str) {
        androidx.media3.common.util.a.g(!this.f10863j);
        return this.f10856c.h(str);
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void h(String str, n nVar) {
        androidx.media3.common.util.a.g(!this.f10863j);
        l();
        this.f10856c.d(str, nVar);
        try {
            this.f10856c.q();
        } catch (IOException e11) {
            throw new Cache.CacheException(e11);
        }
    }

    public synchronized void l() {
        Cache.CacheException cacheException = this.f10864k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public synchronized NavigableSet o(String str) {
        TreeSet treeSet;
        try {
            androidx.media3.common.util.a.g(!this.f10863j);
            j f11 = this.f10856c.f(str);
            if (f11 != null && !f11.g()) {
                treeSet = new TreeSet((Collection) f11.f());
            }
            treeSet = new TreeSet();
        } catch (Throwable th2) {
            throw th2;
        }
        return treeSet;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized File startFile(String str, long j11, long j12) {
        j f11;
        File file;
        try {
            androidx.media3.common.util.a.g(!this.f10863j);
            l();
            f11 = this.f10856c.f(str);
            androidx.media3.common.util.a.e(f11);
            androidx.media3.common.util.a.g(f11.h(j11, j12));
            if (!this.f10854a.exists()) {
                m(this.f10854a);
                z();
            }
            this.f10855b.d(this, str, j11, j12);
            file = new File(this.f10854a, Integer.toString(this.f10859f.nextInt(10)));
            if (!file.exists()) {
                m(file);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return s.j(file, f11.f10916a, j11, System.currentTimeMillis());
    }
}
