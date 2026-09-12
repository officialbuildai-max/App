package xl;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public final class f implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final File f78451a;

    /* renamed from: b, reason: collision with root package name */
    private final File f78452b;

    /* renamed from: c, reason: collision with root package name */
    private final File f78453c;

    /* renamed from: d, reason: collision with root package name */
    private final File f78454d;

    /* renamed from: e, reason: collision with root package name */
    private final int f78455e;

    /* renamed from: f, reason: collision with root package name */
    private long f78456f;

    /* renamed from: g, reason: collision with root package name */
    private final int f78457g;

    /* renamed from: i, reason: collision with root package name */
    private Writer f78459i;

    /* renamed from: k, reason: collision with root package name */
    private int f78461k;

    /* renamed from: o, reason: collision with root package name */
    private long f78465o;

    /* renamed from: h, reason: collision with root package name */
    private long f78458h = 0;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap f78460j = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    private long f78462l = 0;

    /* renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f78463m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n, reason: collision with root package name */
    private final Callable f78464n = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (f.this) {
                try {
                    if (f.this.f78459i == null) {
                        return null;
                    }
                    f.this.Z();
                    if (f.this.s()) {
                        f.this.U();
                        f.this.f78461k = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private static final class b implements ThreadFactory {
        /* synthetic */ b(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: classes6.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f78467a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f78468b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f78469c;

        /* synthetic */ c(d dVar, a aVar) {
            this.f78467a = dVar;
            this.f78468b = dVar.f78475e ? null : new boolean[f.this.f78457g];
        }

        public File a(int i11) {
            File file;
            synchronized (f.this) {
                try {
                    if (this.f78467a.f78476f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f78467a.f78475e) {
                        this.f78468b[i11] = true;
                    }
                    file = this.f78467a.f78474d[i11];
                    if (!f.this.f78451a.exists()) {
                        f.this.f78451a.mkdirs();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return file;
        }

        public void c() {
            f.this.o(this, false);
        }

        public void d() {
            if (this.f78469c) {
                return;
            }
            try {
                c();
            } catch (IOException unused) {
            }
        }

        public void f() {
            f.this.o(this, true);
            this.f78469c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f78471a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f78472b;

        /* renamed from: c, reason: collision with root package name */
        File[] f78473c;

        /* renamed from: d, reason: collision with root package name */
        File[] f78474d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f78475e;

        /* renamed from: f, reason: collision with root package name */
        private c f78476f;

        /* renamed from: g, reason: collision with root package name */
        private long f78477g;

        /* renamed from: h, reason: collision with root package name */
        private long f78478h;

        /* synthetic */ d(String str, a aVar) {
            this.f78471a = str;
            this.f78472b = new long[f.this.f78457g];
            this.f78473c = new File[f.this.f78457g];
            this.f78474d = new File[f.this.f78457g];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i11 = 0; i11 < f.this.f78457g; i11++) {
                sb2.append(i11);
                this.f78473c[i11] = new File(f.this.f78451a, sb2.toString());
                sb2.append(".tmp");
                this.f78474d[i11] = new File(f.this.f78451a, sb2.toString());
                sb2.setLength(length);
            }
        }

        private IOException d(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(String[] strArr) {
            if (strArr.length != f.this.f78457g) {
                d(strArr);
                throw null;
            }
            for (int i11 = 0; i11 < strArr.length; i11++) {
                try {
                    this.f78472b[i11] = Long.parseLong(strArr[i11]);
                } catch (NumberFormatException unused) {
                    d(strArr);
                    throw null;
                }
            }
        }

        public File c(int i11) {
            return this.f78473c[i11];
        }

        public String e() {
            StringBuilder sb2 = new StringBuilder();
            for (long j11 : this.f78472b) {
                sb2.append(' ');
                sb2.append(j11);
            }
            return sb2.toString();
        }

        public File j(int i11) {
            return this.f78474d[i11];
        }
    }

    /* loaded from: classes6.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final File[] f78480a;

        /* synthetic */ e(f fVar, String str, long j11, File[] fileArr, long[] jArr, a aVar) {
            this.f78480a = fileArr;
        }

        public File a(int i11) {
            return this.f78480a[i11];
        }
    }

    private f(File file, int i11, int i12, long j11, long j12) {
        this.f78451a = file;
        this.f78455e = i11;
        this.f78452b = new File(file, "journal");
        this.f78453c = new File(file, "journal.tmp");
        this.f78454d = new File(file, "journal.bkp");
        this.f78457g = i12;
        this.f78456f = j11;
        this.f78465o = j12;
    }

    private void T(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i11 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i11);
        if (indexOf2 == -1) {
            substring = str.substring(i11);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.f78460j.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i11, indexOf2);
        }
        d dVar = (d) this.f78460j.get(substring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(substring, aVar);
            this.f78460j.put(substring, dVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f78476f = new c(dVar, aVar);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        dVar.f78475e = true;
        dVar.f78476f = null;
        if (!split[split.length - 1].startsWith("STAMP_")) {
            dVar.f78478h = System.currentTimeMillis();
            dVar.k(split);
            return;
        }
        String[] strArr = new String[split.length - 1];
        for (int i12 = 0; i12 < split.length - 1; i12++) {
            strArr[i12] = split[i12];
        }
        dVar.k(strArr);
        dVar.f78478h = Long.parseLong(split[split.length - 1].substring(6));
        if (Math.abs(System.currentTimeMillis() - dVar.f78478h) > this.f78465o) {
            dVar.f78476f = new c(dVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void U() {
        try {
            Writer writer = this.f78459i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f78453c), xl.d.f78443a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f78455e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f78457g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f78460j.values()) {
                    if (dVar.f78476f != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("DIRTY ");
                        sb2.append(dVar.f78471a);
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("CLEAN ");
                        sb3.append(dVar.f78471a);
                        sb3.append(dVar.e());
                        sb3.append(' ');
                        sb3.append("STAMP_");
                        sb3.append(dVar.f78478h);
                        sb3.append('\n');
                        bufferedWriter.write(sb3.toString());
                    }
                }
                bufferedWriter.close();
                if (this.f78452b.exists()) {
                    n(this.f78452b, this.f78454d, true);
                }
                n(this.f78453c, this.f78452b, false);
                this.f78454d.delete();
                this.f78459i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f78452b, true), xl.d.f78443a));
            } catch (Throwable th2) {
                bufferedWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        while (this.f78458h > this.f78456f) {
            v((String) ((Map.Entry) this.f78460j.entrySet().iterator().next()).getKey());
        }
    }

    private synchronized c i(String str, long j11) {
        l();
        d dVar = (d) this.f78460j.get(str);
        a aVar = null;
        if (j11 != -1 && (dVar == null || dVar.f78477g != j11)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(str, aVar);
            this.f78460j.put(str, dVar);
        } else if (dVar.f78476f != null) {
            return null;
        }
        c cVar = new c(dVar, aVar);
        dVar.f78476f = cVar;
        this.f78459i.append((CharSequence) "DIRTY");
        this.f78459i.append(' ');
        this.f78459i.append((CharSequence) str);
        this.f78459i.append('\n');
        this.f78459i.flush();
        return cVar;
    }

    public static f k(File file, int i11, int i12, long j11, long j12) {
        if (j11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i12 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                n(file2, file3, false);
            }
        }
        f fVar = new f(file, i11, i12, j11, j12);
        if (fVar.f78452b.exists()) {
            try {
                fVar.x();
                fVar.u();
                return fVar;
            } catch (IOException e11) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e11.getMessage() + ", removing");
                fVar.close();
                xl.d.c(fVar.f78451a);
            }
        }
        file.mkdirs();
        f fVar2 = new f(file, i11, i12, j11, j12);
        fVar2.U();
        return fVar2;
    }

    private void l() {
        if (this.f78459i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void m(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void n(File file, File file2, boolean z10) {
        if (z10) {
            m(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(c cVar, boolean z10) {
        d dVar = cVar.f78467a;
        if (dVar.f78476f != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f78475e) {
            for (int i11 = 0; i11 < this.f78457g; i11++) {
                if (!cVar.f78468b[i11]) {
                    cVar.c();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i11);
                }
                if (!dVar.j(i11).exists()) {
                    cVar.c();
                    return;
                }
            }
        }
        for (int i12 = 0; i12 < this.f78457g; i12++) {
            File j11 = dVar.j(i12);
            if (!z10) {
                m(j11);
            } else if (j11.exists()) {
                File c11 = dVar.c(i12);
                j11.renameTo(c11);
                long j12 = dVar.f78472b[i12];
                long length = c11.length();
                dVar.f78472b[i12] = length;
                this.f78458h = (this.f78458h - j12) + length;
            }
        }
        this.f78461k++;
        dVar.f78476f = null;
        if (dVar.f78475e || z10) {
            dVar.f78475e = true;
            this.f78459i.append((CharSequence) "CLEAN");
            this.f78459i.append(' ');
            this.f78459i.append((CharSequence) dVar.f78471a);
            this.f78459i.append((CharSequence) dVar.e());
            this.f78459i.append(' ');
            this.f78459i.append((CharSequence) "STAMP_");
            this.f78459i.append((CharSequence) String.valueOf(System.currentTimeMillis()));
            this.f78459i.append('\n');
            if (z10) {
                long j13 = this.f78462l;
                this.f78462l = 1 + j13;
                dVar.f78477g = j13;
            }
        } else {
            this.f78460j.remove(dVar.f78471a);
            this.f78459i.append((CharSequence) "REMOVE");
            this.f78459i.append(' ');
            this.f78459i.append((CharSequence) dVar.f78471a);
            this.f78459i.append('\n');
        }
        this.f78459i.flush();
        if (this.f78458h > this.f78456f || s()) {
            this.f78463m.submit(this.f78464n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        int i11 = this.f78461k;
        return i11 >= 2000 && i11 >= this.f78460j.size();
    }

    private void u() {
        m(this.f78453c);
        Iterator it = this.f78460j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i11 = 0;
            if (dVar.f78476f == null) {
                while (i11 < this.f78457g) {
                    this.f78458h += dVar.f78472b[i11];
                    i11++;
                }
            } else {
                dVar.f78476f = null;
                while (i11 < this.f78457g) {
                    m(dVar.c(i11));
                    m(dVar.j(i11));
                    i11++;
                }
                it.remove();
            }
        }
    }

    private void x() {
        l lVar = new l(new FileInputStream(this.f78452b), xl.d.f78443a);
        try {
            String h11 = lVar.h();
            String h12 = lVar.h();
            String h13 = lVar.h();
            String h14 = lVar.h();
            String h15 = lVar.h();
            if (!"libcore.io.DiskLruCache".equals(h11) || !"1".equals(h12) || !Integer.toString(this.f78455e).equals(h13) || !Integer.toString(this.f78457g).equals(h14) || !"".equals(h15)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unexpected journal header: [");
                sb2.append(h11);
                sb2.append(", ");
                sb2.append(h12);
                sb2.append(", ");
                sb2.append(h14);
                sb2.append(", ");
                sb2.append(h15);
                sb2.append("]");
                throw new IOException(sb2.toString());
            }
            int i11 = 0;
            while (true) {
                try {
                    T(lVar.h());
                    i11++;
                } catch (EOFException unused) {
                    this.f78461k = i11 - this.f78460j.size();
                    if (lVar.d()) {
                        U();
                    } else {
                        this.f78459i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f78452b, true), xl.d.f78443a));
                    }
                    xl.d.b(lVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            xl.d.b(lVar);
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f78459i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f78460j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f78476f != null) {
                    dVar.f78476f.c();
                }
            }
            Z();
            this.f78459i.close();
            this.f78459i = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public c h(String str) {
        return i(str, -1L);
    }

    public synchronized e q(String str) {
        l();
        d dVar = (d) this.f78460j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f78475e) {
            return null;
        }
        for (File file : dVar.f78473c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f78461k++;
        this.f78459i.append((CharSequence) "READ");
        this.f78459i.append(' ');
        this.f78459i.append((CharSequence) str);
        this.f78459i.append('\n');
        if (s()) {
            this.f78463m.submit(this.f78464n);
        }
        return new e(this, str, dVar.f78477g, dVar.f78473c, dVar.f78472b, null);
    }

    public synchronized boolean v(String str) {
        try {
            l();
            d dVar = (d) this.f78460j.get(str);
            if (dVar != null && dVar.f78476f == null) {
                for (int i11 = 0; i11 < this.f78457g; i11++) {
                    File c11 = dVar.c(i11);
                    if (c11.exists() && !c11.delete()) {
                        throw new IOException("failed to delete " + c11);
                    }
                    this.f78458h -= dVar.f78472b[i11];
                    dVar.f78472b[i11] = 0;
                }
                this.f78461k++;
                this.f78459i.append((CharSequence) "REMOVE");
                this.f78459i.append(' ');
                this.f78459i.append((CharSequence) str);
                this.f78459i.append('\n');
                this.f78460j.remove(str);
                if (s()) {
                    this.f78463m.submit(this.f78464n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }
}
