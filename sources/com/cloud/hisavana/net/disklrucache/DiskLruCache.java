package com.cloud.hisavana.net.disklrucache;

import android.text.TextUtils;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.disklrucache.listener.LruCleanCallBack;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    static final Pattern f21436o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p, reason: collision with root package name */
    private static final OutputStream f21437p = new OutputStream() { // from class: com.cloud.hisavana.net.disklrucache.DiskLruCache.2
        @Override // java.io.OutputStream
        public void write(int i11) {
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final File f21438a;

    /* renamed from: b, reason: collision with root package name */
    private final File f21439b;

    /* renamed from: c, reason: collision with root package name */
    private final File f21440c;

    /* renamed from: d, reason: collision with root package name */
    private final File f21441d;

    /* renamed from: e, reason: collision with root package name */
    private final int f21442e;

    /* renamed from: f, reason: collision with root package name */
    private long f21443f;

    /* renamed from: g, reason: collision with root package name */
    private final int f21444g;

    /* renamed from: i, reason: collision with root package name */
    private Writer f21446i;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap f21447j;

    /* renamed from: k, reason: collision with root package name */
    private int f21448k;

    /* renamed from: h, reason: collision with root package name */
    private long f21445h = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f21449l = 0;

    /* renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f21450m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: n, reason: collision with root package name */
    private final Callable f21451n = new Callable<Void>() { // from class: com.cloud.hisavana.net.disklrucache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.f21446i == null) {
                        return null;
                    }
                    DiskLruCache.this.h0();
                    if (DiskLruCache.this.w()) {
                        DiskLruCache.this.c0();
                        DiskLruCache.this.f21448k = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public final class Editor {

        /* renamed from: a, reason: collision with root package name */
        private final Entry f21453a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f21454b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f21455c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f21456d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    Editor.this.f21455c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    Editor.this.f21455c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i11) {
                try {
                    ((FilterOutputStream) this).out.write(i11);
                } catch (IOException unused) {
                    Editor.this.f21455c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i11, int i12) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i11, i12);
                } catch (IOException unused) {
                    Editor.this.f21455c = true;
                }
            }
        }

        private Editor(Entry entry) {
            this.f21453a = entry;
            this.f21454b = entry.f21461c ? null : new boolean[DiskLruCache.this.f21444g];
        }

        public void a() {
            DiskLruCache.this.q(this, false);
        }

        public void b() {
            if (this.f21456d) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void f() {
            if (this.f21455c) {
                DiskLruCache.this.q(this, false);
                DiskLruCache.this.d0(this.f21453a.f21459a);
            } else {
                DiskLruCache.this.q(this, true);
            }
            this.f21456d = true;
        }

        public OutputStream g(int i11) {
            FileOutputStream fileOutputStream;
            FaultHidingOutputStream faultHidingOutputStream;
            if (i11 < 0 || i11 >= DiskLruCache.this.f21444g) {
                throw new IllegalArgumentException("Expected index " + i11 + " to be greater than 0 and less than the maximum value count of " + DiskLruCache.this.f21444g);
            }
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f21453a.f21462d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f21453a.f21461c) {
                        this.f21454b[i11] = true;
                    }
                    File k11 = this.f21453a.k(i11);
                    try {
                        fileOutputStream = new FileOutputStream(k11);
                    } catch (FileNotFoundException unused) {
                        DiskLruCache.this.f21438a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(k11);
                        } catch (FileNotFoundException unused2) {
                            return DiskLruCache.f21437p;
                        }
                    }
                    faultHidingOutputStream = new FaultHidingOutputStream(fileOutputStream);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return faultHidingOutputStream;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class Entry {

        /* renamed from: a, reason: collision with root package name */
        private final String f21459a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f21460b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f21461c;

        /* renamed from: d, reason: collision with root package name */
        private Editor f21462d;

        /* renamed from: e, reason: collision with root package name */
        private long f21463e;

        private Entry(String str) {
            this.f21459a = str;
            this.f21460b = new long[DiskLruCache.this.f21444g];
        }

        private IOException m(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) {
            if (strArr.length != DiskLruCache.this.f21444g) {
                throw m(strArr);
            }
            for (int i11 = 0; i11 < strArr.length; i11++) {
                try {
                    this.f21460b[i11] = Long.parseLong(strArr[i11]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i11) {
            return new File(DiskLruCache.this.f21438a, this.f21459a + "." + i11);
        }

        public File k(int i11) {
            return new File(DiskLruCache.this.f21438a, this.f21459a + "." + i11 + ".tmp");
        }

        public String l() {
            StringBuilder sb2 = new StringBuilder();
            for (long j11 : this.f21460b) {
                sb2.append(' ');
                sb2.append(j11);
            }
            return sb2.toString();
        }
    }

    /* loaded from: classes3.dex */
    public final class Snapshot implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private final String f21465a;

        /* renamed from: b, reason: collision with root package name */
        private final long f21466b;

        /* renamed from: c, reason: collision with root package name */
        private final InputStream[] f21467c;

        /* renamed from: d, reason: collision with root package name */
        private final long[] f21468d;

        private Snapshot(String str, long j11, InputStream[] inputStreamArr, long[] jArr) {
            this.f21465a = str;
            this.f21466b = j11;
            this.f21467c = inputStreamArr;
            this.f21468d = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f21467c) {
                DiskLruCacheUtil.b(inputStream);
            }
        }
    }

    private DiskLruCache(File file, int i11, int i12, long j11, boolean z10) {
        this.f21438a = file;
        this.f21442e = i11;
        this.f21439b = new File(file, "journal");
        this.f21440c = new File(file, "journal.tmp");
        this.f21441d = new File(file, "journal.bkp");
        this.f21444g = i12;
        this.f21443f = j11;
        this.f21447j = new LinkedHashMap(0, 0.75f, z10);
    }

    public static DiskLruCache T(File file, int i11, int i12, long j11) {
        return U(file, i11, i12, j11, true);
    }

    public static DiskLruCache U(File file, int i11, int i12, long j11, boolean z10) {
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
                g0(file2, file3, false);
            }
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, i11, i12, j11, z10);
        if (diskLruCache.f21439b.exists()) {
            try {
                diskLruCache.Z();
                diskLruCache.V();
                return diskLruCache;
            } catch (IOException e11) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e11.getMessage() + ", removing");
                diskLruCache.r();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i11, i12, j11, z10);
        diskLruCache2.c0();
        return diskLruCache2;
    }

    private void V() {
        s(this.f21440c);
        Iterator it = this.f21447j.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i11 = 0;
            if (entry.f21462d == null) {
                while (i11 < this.f21444g) {
                    this.f21445h += entry.f21460b[i11];
                    i11++;
                }
            } else {
                entry.f21462d = null;
                while (i11 < this.f21444g) {
                    s(entry.j(i11));
                    s(entry.k(i11));
                    i11++;
                }
                it.remove();
            }
        }
    }

    private void Z() {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.f21439b), DiskLruCacheUtil.f21490a);
        try {
            String k11 = strictLineReader.k();
            String k12 = strictLineReader.k();
            String k13 = strictLineReader.k();
            String k14 = strictLineReader.k();
            String k15 = strictLineReader.k();
            if (!"libcore.io.DiskLruCache".equals(k11) || !"1".equals(k12) || !Integer.toString(this.f21442e).equals(k13) || !Integer.toString(this.f21444g).equals(k14) || !"".equals(k15)) {
                throw new IOException("unexpected journal header: [" + k11 + ", " + k12 + ", " + k14 + ", " + k15 + "]");
            }
            int i11 = 0;
            while (true) {
                try {
                    a0(strictLineReader.k());
                    i11++;
                } catch (EOFException unused) {
                    this.f21448k = i11 - this.f21447j.size();
                    if (strictLineReader.h()) {
                        c0();
                    } else {
                        this.f21446i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f21439b, true), DiskLruCacheUtil.f21490a));
                    }
                    DiskLruCacheUtil.b(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th2) {
            DiskLruCacheUtil.b(strictLineReader);
            throw th2;
        }
    }

    private void a0(String str) {
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
                this.f21447j.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i11, indexOf2);
        }
        Entry entry = (Entry) this.f21447j.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.f21447j.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.f21461c = true;
            entry.f21462d = null;
            entry.n(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            entry.f21462d = new Editor(entry);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c0() {
        try {
            Writer writer = this.f21446i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f21440c), DiskLruCacheUtil.f21490a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f21442e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f21444g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.f21447j.values()) {
                    if (entry.f21462d != null) {
                        bufferedWriter.write("DIRTY " + entry.f21459a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + entry.f21459a + entry.l() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f21439b.exists()) {
                    g0(this.f21439b, this.f21441d, true);
                }
                g0(this.f21440c, this.f21439b, false);
                this.f21441d.delete();
                this.f21446i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f21439b, true), DiskLruCacheUtil.f21490a));
            } catch (Throwable th2) {
                bufferedWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    private static void g0(File file, File file2, boolean z10) {
        if (z10) {
            s(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        while (this.f21445h > this.f21443f) {
            Map.Entry entry = (Map.Entry) this.f21447j.entrySet().iterator().next();
            if (d0((String) entry.getKey())) {
                x((String) entry.getKey());
            }
        }
    }

    private void k0(String str) {
        if (f21436o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void p() {
        if (this.f21446i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(Editor editor, boolean z10) {
        Entry entry = editor.f21453a;
        if (entry.f21462d != editor) {
            throw new IllegalStateException();
        }
        if (z10 && !entry.f21461c) {
            for (int i11 = 0; i11 < this.f21444g; i11++) {
                if (!editor.f21454b[i11]) {
                    editor.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i11);
                }
                if (!entry.k(i11).exists()) {
                    editor.a();
                    return;
                }
            }
        }
        for (int i12 = 0; i12 < this.f21444g; i12++) {
            File k11 = entry.k(i12);
            if (!z10) {
                s(k11);
            } else if (k11.exists()) {
                File j11 = entry.j(i12);
                k11.renameTo(j11);
                long j12 = entry.f21460b[i12];
                long length = j11.length();
                entry.f21460b[i12] = length;
                this.f21445h = (this.f21445h - j12) + length;
            }
        }
        this.f21448k++;
        entry.f21462d = null;
        if (entry.f21461c || z10) {
            entry.f21461c = true;
            this.f21446i.write("CLEAN " + entry.f21459a + entry.l() + '\n');
            if (z10) {
                long j13 = this.f21449l;
                this.f21449l = 1 + j13;
                entry.f21463e = j13;
            }
        } else {
            this.f21447j.remove(entry.f21459a);
            this.f21446i.write("REMOVE " + entry.f21459a + '\n');
        }
        this.f21446i.flush();
        if (this.f21445h > this.f21443f || w()) {
            this.f21450m.submit(this.f21451n);
        }
    }

    private static void s(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized Editor u(String str, long j11) {
        p();
        k0(str);
        Entry entry = (Entry) this.f21447j.get(str);
        if (j11 != -1 && (entry == null || entry.f21463e != j11)) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(str);
            this.f21447j.put(str, entry);
        } else if (entry.f21462d != null) {
            return null;
        }
        Editor editor = new Editor(entry);
        entry.f21462d = editor;
        this.f21446i.write("DIRTY " + str + '\n');
        this.f21446i.flush();
        return editor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        int i11 = this.f21448k;
        return i11 >= 2000 && i11 >= this.f21447j.size();
    }

    private void x(String str) {
        HttpRequest httpRequest = HttpRequest.f21410a;
        if (httpRequest.g().isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator it = httpRequest.g().iterator();
        while (it.hasNext()) {
            LruCleanCallBack lruCleanCallBack = (LruCleanCallBack) it.next();
            if (lruCleanCallBack != null) {
                lruCleanCallBack.onCallBack(str);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f21446i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f21447j.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.f21462d != null) {
                    entry.f21462d.a();
                }
            }
            h0();
            this.f21446i.close();
            this.f21446i = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean d0(String str) {
        try {
            p();
            k0(str);
            Entry entry = (Entry) this.f21447j.get(str);
            if (entry != null && entry.f21462d == null) {
                for (int i11 = 0; i11 < this.f21444g; i11++) {
                    File j11 = entry.j(i11);
                    if (j11.exists() && !j11.delete()) {
                        throw new IOException("failed to delete " + j11);
                    }
                    this.f21445h -= entry.f21460b[i11];
                    entry.f21460b[i11] = 0;
                }
                this.f21448k++;
                this.f21446i.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f21447j.remove(str);
                if (w()) {
                    this.f21450m.submit(this.f21451n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public synchronized void flush() {
        p();
        h0();
        this.f21446i.flush();
    }

    public void r() {
        close();
        DiskLruCacheUtil.c(this.f21438a);
    }

    public Editor t(String str) {
        return u(str, -1L);
    }

    public synchronized Snapshot v(String str) {
        InputStream inputStream;
        p();
        k0(str);
        Entry entry = (Entry) this.f21447j.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.f21461c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f21444g];
        for (int i11 = 0; i11 < this.f21444g; i11++) {
            try {
                inputStreamArr[i11] = new FileInputStream(entry.j(i11));
            } catch (FileNotFoundException unused) {
                for (int i12 = 0; i12 < this.f21444g && (inputStream = inputStreamArr[i12]) != null; i12++) {
                    DiskLruCacheUtil.b(inputStream);
                }
                return null;
            }
        }
        this.f21448k++;
        this.f21446i.append((CharSequence) ("READ " + str + '\n'));
        if (w()) {
            this.f21450m.submit(this.f21451n);
        }
        return new Snapshot(str, entry.f21463e, inputStreamArr, entry.f21460b);
    }
}
