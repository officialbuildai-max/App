package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes5.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: s, reason: collision with root package name */
    static final Pattern f40294s = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: t, reason: collision with root package name */
    private static final Sink f40295t = new c();

    /* renamed from: a, reason: collision with root package name */
    private final FileSystem f40296a;

    /* renamed from: b, reason: collision with root package name */
    private final File f40297b;

    /* renamed from: c, reason: collision with root package name */
    private final File f40298c;

    /* renamed from: d, reason: collision with root package name */
    private final File f40299d;

    /* renamed from: e, reason: collision with root package name */
    private final File f40300e;

    /* renamed from: f, reason: collision with root package name */
    private final int f40301f;

    /* renamed from: g, reason: collision with root package name */
    private long f40302g;

    /* renamed from: h, reason: collision with root package name */
    private final int f40303h;

    /* renamed from: j, reason: collision with root package name */
    private BufferedSink f40305j;

    /* renamed from: l, reason: collision with root package name */
    private int f40307l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f40308m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f40309n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f40310o;

    /* renamed from: q, reason: collision with root package name */
    private final Executor f40312q;

    /* renamed from: i, reason: collision with root package name */
    private long f40304i = 0;

    /* renamed from: k, reason: collision with root package name */
    private final LinkedHashMap f40306k = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: p, reason: collision with root package name */
    private long f40311p = 0;

    /* renamed from: r, reason: collision with root package name */
    private final Runnable f40313r = new Runnable() { // from class: com.squareup.okhttp.internal.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.this.f40309n) || DiskLruCache.this.f40310o) {
                    return;
                }
                try {
                    DiskLruCache.this.x0();
                    if (DiskLruCache.this.h0()) {
                        DiskLruCache.this.p0();
                        DiskLruCache.this.f40307l = 0;
                    }
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends com.squareup.okhttp.internal.b {
        a(Sink sink) {
            super(sink);
        }

        @Override // com.squareup.okhttp.internal.b
        protected void b(IOException iOException) {
            DiskLruCache.this.f40308m = true;
        }
    }

    /* loaded from: classes5.dex */
    class b implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        final Iterator f40315a;

        /* renamed from: b, reason: collision with root package name */
        f f40316b;

        /* renamed from: c, reason: collision with root package name */
        f f40317c;

        b() {
            this.f40315a = new ArrayList(DiskLruCache.this.f40306k.values()).iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            f fVar = this.f40316b;
            this.f40317c = fVar;
            this.f40316b = null;
            return fVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f40316b != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.f40310o) {
                        return false;
                    }
                    while (this.f40315a.hasNext()) {
                        f n11 = ((e) this.f40315a.next()).n();
                        if (n11 != null) {
                            this.f40316b = n11;
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            f fVar = this.f40317c;
            if (fVar == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                DiskLruCache.this.q0(fVar.f40333a);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                this.f40317c = null;
                throw th2;
            }
            this.f40317c = null;
        }
    }

    /* loaded from: classes5.dex */
    static class c implements Sink {
        c() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
        }

        @Override // okio.Sink
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j11) {
            buffer.skip(j11);
        }
    }

    /* loaded from: classes5.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        private final e f40319a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f40320b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f40321c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f40322d;

        /* loaded from: classes5.dex */
        class a extends com.squareup.okhttp.internal.b {
            a(Sink sink) {
                super(sink);
            }

            @Override // com.squareup.okhttp.internal.b
            protected void b(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    d.this.f40321c = true;
                }
            }
        }

        private d(e eVar) {
            this.f40319a = eVar;
            this.f40320b = eVar.f40329e ? null : new boolean[DiskLruCache.this.f40303h];
        }

        public void a() {
            synchronized (DiskLruCache.this) {
                DiskLruCache.this.w(this, false);
            }
        }

        public void e() {
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f40321c) {
                        DiskLruCache.this.w(this, false);
                        DiskLruCache.this.r0(this.f40319a);
                    } else {
                        DiskLruCache.this.w(this, true);
                    }
                    this.f40322d = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public Sink f(int i11) {
            a aVar;
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f40319a.f40330f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f40319a.f40329e) {
                        this.f40320b[i11] = true;
                    }
                    try {
                        aVar = new a(DiskLruCache.this.f40296a.sink(this.f40319a.f40328d[i11]));
                    } catch (FileNotFoundException unused) {
                        return DiskLruCache.f40295t;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f40325a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f40326b;

        /* renamed from: c, reason: collision with root package name */
        private final File[] f40327c;

        /* renamed from: d, reason: collision with root package name */
        private final File[] f40328d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f40329e;

        /* renamed from: f, reason: collision with root package name */
        private d f40330f;

        /* renamed from: g, reason: collision with root package name */
        private long f40331g;

        private e(String str) {
            this.f40325a = str;
            this.f40326b = new long[DiskLruCache.this.f40303h];
            this.f40327c = new File[DiskLruCache.this.f40303h];
            this.f40328d = new File[DiskLruCache.this.f40303h];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i11 = 0; i11 < DiskLruCache.this.f40303h; i11++) {
                sb2.append(i11);
                this.f40327c[i11] = new File(DiskLruCache.this.f40297b, sb2.toString());
                sb2.append(".tmp");
                this.f40328d[i11] = new File(DiskLruCache.this.f40297b, sb2.toString());
                sb2.setLength(length);
            }
        }

        private IOException l(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(String[] strArr) {
            if (strArr.length != DiskLruCache.this.f40303h) {
                throw l(strArr);
            }
            for (int i11 = 0; i11 < strArr.length; i11++) {
                try {
                    this.f40326b[i11] = Long.parseLong(strArr[i11]);
                } catch (NumberFormatException unused) {
                    throw l(strArr);
                }
            }
        }

        f n() {
            Source source;
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.f40303h];
            long[] jArr = (long[]) this.f40326b.clone();
            for (int i11 = 0; i11 < DiskLruCache.this.f40303h; i11++) {
                try {
                    sourceArr[i11] = DiskLruCache.this.f40296a.source(this.f40327c[i11]);
                } catch (FileNotFoundException unused) {
                    for (int i12 = 0; i12 < DiskLruCache.this.f40303h && (source = sourceArr[i12]) != null; i12++) {
                        g.c(source);
                    }
                    return null;
                }
            }
            return new f(this.f40325a, this.f40331g, sourceArr, jArr);
        }

        void o(BufferedSink bufferedSink) {
            for (long j11 : this.f40326b) {
                bufferedSink.writeByte(32).writeDecimalLong(j11);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class f implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private final String f40333a;

        /* renamed from: b, reason: collision with root package name */
        private final long f40334b;

        /* renamed from: c, reason: collision with root package name */
        private final Source[] f40335c;

        /* renamed from: d, reason: collision with root package name */
        private final long[] f40336d;

        private f(String str, long j11, Source[] sourceArr, long[] jArr) {
            this.f40333a = str;
            this.f40334b = j11;
            this.f40335c = sourceArr;
            this.f40336d = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.f40335c) {
                g.c(source);
            }
        }

        public d d() {
            return DiskLruCache.this.V(this.f40333a, this.f40334b);
        }

        public Source h(int i11) {
            return this.f40335c[i11];
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i11, int i12, long j11, Executor executor) {
        this.f40296a = fileSystem;
        this.f40297b = file;
        this.f40301f = i11;
        this.f40298c = new File(file, "journal");
        this.f40299d = new File(file, "journal.tmp");
        this.f40300e = new File(file, "journal.bkp");
        this.f40303h = i12;
        this.f40302g = j11;
        this.f40312q = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized d V(String str, long j11) {
        g0();
        v();
        y0(str);
        e eVar = (e) this.f40306k.get(str);
        if (j11 != -1 && (eVar == null || eVar.f40331g != j11)) {
            return null;
        }
        if (eVar != null && eVar.f40330f != null) {
            return null;
        }
        this.f40305j.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
        this.f40305j.flush();
        if (this.f40308m) {
            return null;
        }
        if (eVar == null) {
            eVar = new e(str);
            this.f40306k.put(str, eVar);
        }
        d dVar = new d(eVar);
        eVar.f40330f = dVar;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h0() {
        int i11 = this.f40307l;
        return i11 >= 2000 && i11 >= this.f40306k.size();
    }

    private BufferedSink k0() {
        return Okio.buffer(new a(this.f40296a.appendingSink(this.f40298c)));
    }

    private void l0() {
        this.f40296a.delete(this.f40299d);
        Iterator it = this.f40306k.values().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            int i11 = 0;
            if (eVar.f40330f == null) {
                while (i11 < this.f40303h) {
                    this.f40304i += eVar.f40326b[i11];
                    i11++;
                }
            } else {
                eVar.f40330f = null;
                while (i11 < this.f40303h) {
                    this.f40296a.delete(eVar.f40327c[i11]);
                    this.f40296a.delete(eVar.f40328d[i11]);
                    i11++;
                }
                it.remove();
            }
        }
    }

    private void m0() {
        BufferedSource buffer = Okio.buffer(this.f40296a.source(this.f40298c));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.f40301f).equals(readUtf8LineStrict3) || !Integer.toString(this.f40303h).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            int i11 = 0;
            while (true) {
                try {
                    o0(buffer.readUtf8LineStrict());
                    i11++;
                } catch (EOFException unused) {
                    this.f40307l = i11 - this.f40306k.size();
                    if (buffer.exhausted()) {
                        this.f40305j = k0();
                    } else {
                        p0();
                    }
                    g.c(buffer);
                    return;
                }
            }
        } catch (Throwable th2) {
            g.c(buffer);
            throw th2;
        }
    }

    private void o0(String str) {
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
                this.f40306k.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i11, indexOf2);
        }
        e eVar = (e) this.f40306k.get(substring);
        if (eVar == null) {
            eVar = new e(substring);
            this.f40306k.put(substring, eVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            eVar.f40329e = true;
            eVar.f40330f = null;
            eVar.m(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            eVar.f40330f = new d(eVar);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p0() {
        try {
            BufferedSink bufferedSink = this.f40305j;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink buffer = Okio.buffer(this.f40296a.sink(this.f40299d));
            try {
                buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                buffer.writeUtf8("1").writeByte(10);
                buffer.writeDecimalLong(this.f40301f).writeByte(10);
                buffer.writeDecimalLong(this.f40303h).writeByte(10);
                buffer.writeByte(10);
                for (e eVar : this.f40306k.values()) {
                    if (eVar.f40330f != null) {
                        buffer.writeUtf8("DIRTY").writeByte(32);
                        buffer.writeUtf8(eVar.f40325a);
                        buffer.writeByte(10);
                    } else {
                        buffer.writeUtf8("CLEAN").writeByte(32);
                        buffer.writeUtf8(eVar.f40325a);
                        eVar.o(buffer);
                        buffer.writeByte(10);
                    }
                }
                buffer.close();
                if (this.f40296a.exists(this.f40298c)) {
                    this.f40296a.rename(this.f40298c, this.f40300e);
                }
                this.f40296a.rename(this.f40299d, this.f40298c);
                this.f40296a.delete(this.f40300e);
                this.f40305j = k0();
                this.f40308m = false;
            } catch (Throwable th2) {
                buffer.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r0(e eVar) {
        if (eVar.f40330f != null) {
            eVar.f40330f.f40321c = true;
        }
        for (int i11 = 0; i11 < this.f40303h; i11++) {
            this.f40296a.delete(eVar.f40327c[i11]);
            this.f40304i -= eVar.f40326b[i11];
            eVar.f40326b[i11] = 0;
        }
        this.f40307l++;
        this.f40305j.writeUtf8("REMOVE").writeByte(32).writeUtf8(eVar.f40325a).writeByte(10);
        this.f40306k.remove(eVar.f40325a);
        if (h0()) {
            this.f40312q.execute(this.f40313r);
        }
        return true;
    }

    private synchronized void v() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void w(d dVar, boolean z10) {
        e eVar = dVar.f40319a;
        if (eVar.f40330f != dVar) {
            throw new IllegalStateException();
        }
        if (z10 && !eVar.f40329e) {
            for (int i11 = 0; i11 < this.f40303h; i11++) {
                if (!dVar.f40320b[i11]) {
                    dVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i11);
                }
                if (!this.f40296a.exists(eVar.f40328d[i11])) {
                    dVar.a();
                    return;
                }
            }
        }
        for (int i12 = 0; i12 < this.f40303h; i12++) {
            File file = eVar.f40328d[i12];
            if (!z10) {
                this.f40296a.delete(file);
            } else if (this.f40296a.exists(file)) {
                File file2 = eVar.f40327c[i12];
                this.f40296a.rename(file, file2);
                long j11 = eVar.f40326b[i12];
                long size = this.f40296a.size(file2);
                eVar.f40326b[i12] = size;
                this.f40304i = (this.f40304i - j11) + size;
            }
        }
        this.f40307l++;
        eVar.f40330f = null;
        if (eVar.f40329e || z10) {
            eVar.f40329e = true;
            this.f40305j.writeUtf8("CLEAN").writeByte(32);
            this.f40305j.writeUtf8(eVar.f40325a);
            eVar.o(this.f40305j);
            this.f40305j.writeByte(10);
            if (z10) {
                long j12 = this.f40311p;
                this.f40311p = 1 + j12;
                eVar.f40331g = j12;
            }
        } else {
            this.f40306k.remove(eVar.f40325a);
            this.f40305j.writeUtf8("REMOVE").writeByte(32);
            this.f40305j.writeUtf8(eVar.f40325a);
            this.f40305j.writeByte(10);
        }
        this.f40305j.flush();
        if (this.f40304i > this.f40302g || h0()) {
            this.f40312q.execute(this.f40313r);
        }
    }

    public static DiskLruCache x(FileSystem fileSystem, File file, int i11, int i12, long j11) {
        if (j11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i12 > 0) {
            return new DiskLruCache(fileSystem, file, i11, i12, j11, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), g.s("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        while (this.f40304i > this.f40302g) {
            r0((e) this.f40306k.values().iterator().next());
        }
    }

    private void y0(String str) {
        if (f40294s.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public void T() {
        close();
        this.f40296a.deleteContents(this.f40297b);
    }

    public d U(String str) {
        return V(str, -1L);
    }

    public synchronized void Z() {
        g0();
        for (e eVar : (e[]) this.f40306k.values().toArray(new e[this.f40306k.size()])) {
            r0(eVar);
        }
    }

    public synchronized f a0(String str) {
        g0();
        v();
        y0(str);
        e eVar = (e) this.f40306k.get(str);
        if (eVar != null && eVar.f40329e) {
            f n11 = eVar.n();
            if (n11 == null) {
                return null;
            }
            this.f40307l++;
            this.f40305j.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (h0()) {
                this.f40312q.execute(this.f40313r);
            }
            return n11;
        }
        return null;
    }

    public File c0() {
        return this.f40297b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f40309n && !this.f40310o) {
                for (e eVar : (e[]) this.f40306k.values().toArray(new e[this.f40306k.size()])) {
                    if (eVar.f40330f != null) {
                        eVar.f40330f.a();
                    }
                }
                x0();
                this.f40305j.close();
                this.f40305j = null;
                this.f40310o = true;
                return;
            }
            this.f40310o = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long d0() {
        return this.f40302g;
    }

    public synchronized void flush() {
        if (this.f40309n) {
            v();
            x0();
            this.f40305j.flush();
        }
    }

    public synchronized void g0() {
        try {
            if (this.f40309n) {
                return;
            }
            if (this.f40296a.exists(this.f40300e)) {
                if (this.f40296a.exists(this.f40298c)) {
                    this.f40296a.delete(this.f40300e);
                } else {
                    this.f40296a.rename(this.f40300e, this.f40298c);
                }
            }
            if (this.f40296a.exists(this.f40298c)) {
                try {
                    m0();
                    l0();
                    this.f40309n = true;
                    return;
                } catch (IOException e11) {
                    com.squareup.okhttp.internal.e.f().i("DiskLruCache " + this.f40297b + " is corrupt: " + e11.getMessage() + ", removing");
                    T();
                    this.f40310o = false;
                }
            }
            p0();
            this.f40309n = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean isClosed() {
        return this.f40310o;
    }

    public synchronized boolean q0(String str) {
        g0();
        v();
        y0(str);
        e eVar = (e) this.f40306k.get(str);
        if (eVar == null) {
            return false;
        }
        return r0(eVar);
    }

    public synchronized long u0() {
        g0();
        return this.f40304i;
    }

    public synchronized Iterator v0() {
        g0();
        return new b();
    }
}
