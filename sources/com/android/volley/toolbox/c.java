package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class c implements com.android.volley.c {

    /* renamed from: a, reason: collision with root package name */
    private final Map f19368a;

    /* renamed from: b, reason: collision with root package name */
    private long f19369b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0185c f19370c;

    /* renamed from: d, reason: collision with root package name */
    private final int f19371d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f19372a;

        /* renamed from: b, reason: collision with root package name */
        final String f19373b;

        /* renamed from: c, reason: collision with root package name */
        final String f19374c;

        /* renamed from: d, reason: collision with root package name */
        final long f19375d;

        /* renamed from: e, reason: collision with root package name */
        final long f19376e;

        /* renamed from: f, reason: collision with root package name */
        final long f19377f;

        /* renamed from: g, reason: collision with root package name */
        final long f19378g;

        /* renamed from: h, reason: collision with root package name */
        final List f19379h;

        a(String str, c.a aVar) {
            this(str, aVar.f19303b, aVar.f19304c, aVar.f19305d, aVar.f19306e, aVar.f19307f, a(aVar));
        }

        private a(String str, String str2, long j11, long j12, long j13, long j14, List list) {
            this.f19373b = str;
            this.f19374c = "".equals(str2) ? null : str2;
            this.f19375d = j11;
            this.f19376e = j12;
            this.f19377f = j13;
            this.f19378g = j14;
            this.f19379h = list;
        }

        private static List a(c.a aVar) {
            List list = aVar.f19309h;
            return list != null ? list : d.h(aVar.f19308g);
        }

        static a b(b bVar) {
            if (c.m(bVar) == 538247942) {
                return new a(c.o(bVar), c.o(bVar), c.n(bVar), c.n(bVar), c.n(bVar), c.n(bVar), c.l(bVar));
            }
            throw new IOException();
        }

        c.a c(byte[] bArr) {
            c.a aVar = new c.a();
            aVar.f19302a = bArr;
            aVar.f19303b = this.f19374c;
            aVar.f19304c = this.f19375d;
            aVar.f19305d = this.f19376e;
            aVar.f19306e = this.f19377f;
            aVar.f19307f = this.f19378g;
            aVar.f19308g = d.i(this.f19379h);
            aVar.f19309h = Collections.unmodifiableList(this.f19379h);
            return aVar;
        }

        boolean d(OutputStream outputStream) {
            try {
                c.t(outputStream, 538247942);
                c.v(outputStream, this.f19373b);
                String str = this.f19374c;
                if (str == null) {
                    str = "";
                }
                c.v(outputStream, str);
                c.u(outputStream, this.f19375d);
                c.u(outputStream, this.f19376e);
                c.u(outputStream, this.f19377f);
                c.u(outputStream, this.f19378g);
                c.s(this.f19379h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e11) {
                com.android.volley.l.b("%s", e11.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private final long f19380a;

        /* renamed from: b, reason: collision with root package name */
        private long f19381b;

        b(InputStream inputStream, long j11) {
            super(inputStream);
            this.f19380a = j11;
        }

        long d() {
            return this.f19380a - this.f19381b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f19381b++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) {
            int read = super.read(bArr, i11, i12);
            if (read != -1) {
                this.f19381b += read;
            }
            return read;
        }
    }

    /* renamed from: com.android.volley.toolbox.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0185c {
        File get();
    }

    public c(InterfaceC0185c interfaceC0185c) {
        this(interfaceC0185c, 5242880);
    }

    public c(InterfaceC0185c interfaceC0185c, int i11) {
        this.f19368a = new LinkedHashMap(16, 0.75f, true);
        this.f19369b = 0L;
        this.f19370c = interfaceC0185c;
        this.f19371d = i11;
    }

    private String g(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void h() {
        if (this.f19370c.get().exists()) {
            return;
        }
        com.android.volley.l.b("Re-initializing cache after external clearing.", new Object[0]);
        this.f19368a.clear();
        this.f19369b = 0L;
        initialize();
    }

    private void i() {
        if (this.f19369b < this.f19371d) {
            return;
        }
        if (com.android.volley.l.f19338b) {
            com.android.volley.l.e("Pruning old cache entries.", new Object[0]);
        }
        long j11 = this.f19369b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.f19368a.entrySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            a aVar = (a) ((Map.Entry) it.next()).getValue();
            if (f(aVar.f19373b).delete()) {
                this.f19369b -= aVar.f19372a;
            } else {
                String str = aVar.f19373b;
                com.android.volley.l.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
            }
            it.remove();
            i11++;
            if (((float) this.f19369b) < this.f19371d * 0.9f) {
                break;
            }
        }
        if (com.android.volley.l.f19338b) {
            com.android.volley.l.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i11), Long.valueOf(this.f19369b - j11), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void j(String str, a aVar) {
        if (this.f19368a.containsKey(str)) {
            this.f19369b += aVar.f19372a - ((a) this.f19368a.get(str)).f19372a;
        } else {
            this.f19369b += aVar.f19372a;
        }
        this.f19368a.put(str, aVar);
    }

    private static int k(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static List l(b bVar) {
        int m11 = m(bVar);
        if (m11 < 0) {
            throw new IOException("readHeaderList size=" + m11);
        }
        List emptyList = m11 == 0 ? Collections.emptyList() : new ArrayList();
        for (int i11 = 0; i11 < m11; i11++) {
            emptyList.add(new com.android.volley.e(o(bVar).intern(), o(bVar).intern()));
        }
        return emptyList;
    }

    static int m(InputStream inputStream) {
        return (k(inputStream) << 24) | k(inputStream) | (k(inputStream) << 8) | (k(inputStream) << 16);
    }

    static long n(InputStream inputStream) {
        return (k(inputStream) & 255) | ((k(inputStream) & 255) << 8) | ((k(inputStream) & 255) << 16) | ((k(inputStream) & 255) << 24) | ((k(inputStream) & 255) << 32) | ((k(inputStream) & 255) << 40) | ((k(inputStream) & 255) << 48) | ((255 & k(inputStream)) << 56);
    }

    static String o(b bVar) {
        return new String(r(bVar, n(bVar)), "UTF-8");
    }

    private void q(String str) {
        a aVar = (a) this.f19368a.remove(str);
        if (aVar != null) {
            this.f19369b -= aVar.f19372a;
        }
    }

    static byte[] r(b bVar, long j11) {
        long d11 = bVar.d();
        if (j11 >= 0 && j11 <= d11) {
            int i11 = (int) j11;
            if (i11 == j11) {
                byte[] bArr = new byte[i11];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j11 + ", maxLength=" + d11);
    }

    static void s(List list, OutputStream outputStream) {
        if (list == null) {
            t(outputStream, 0);
            return;
        }
        t(outputStream, list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.android.volley.e eVar = (com.android.volley.e) it.next();
            v(outputStream, eVar.a());
            v(outputStream, eVar.b());
        }
    }

    static void t(OutputStream outputStream, int i11) {
        outputStream.write(i11 & 255);
        outputStream.write((i11 >> 8) & 255);
        outputStream.write((i11 >> 16) & 255);
        outputStream.write((i11 >> 24) & 255);
    }

    static void u(OutputStream outputStream, long j11) {
        outputStream.write((byte) j11);
        outputStream.write((byte) (j11 >>> 8));
        outputStream.write((byte) (j11 >>> 16));
        outputStream.write((byte) (j11 >>> 24));
        outputStream.write((byte) (j11 >>> 32));
        outputStream.write((byte) (j11 >>> 40));
        outputStream.write((byte) (j11 >>> 48));
        outputStream.write((byte) (j11 >>> 56));
    }

    static void v(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        u(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // com.android.volley.c
    public synchronized c.a a(String str) {
        a aVar = (a) this.f19368a.get(str);
        if (aVar == null) {
            return null;
        }
        File f11 = f(str);
        try {
            b bVar = new b(new BufferedInputStream(d(f11)), f11.length());
            try {
                a b11 = a.b(bVar);
                if (TextUtils.equals(str, b11.f19373b)) {
                    return aVar.c(r(bVar, bVar.d()));
                }
                com.android.volley.l.b("%s: key=%s, found=%s", f11.getAbsolutePath(), str, b11.f19373b);
                q(str);
                return null;
            } finally {
                bVar.close();
            }
        } catch (IOException e11) {
            com.android.volley.l.b("%s: %s", f11.getAbsolutePath(), e11.toString());
            p(str);
            return null;
        }
    }

    @Override // com.android.volley.c
    public synchronized void b(String str, boolean z10) {
        try {
            c.a a11 = a(str);
            if (a11 != null) {
                a11.f19307f = 0L;
                if (z10) {
                    a11.f19306e = 0L;
                }
                c(str, a11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.android.volley.c
    public synchronized void c(String str, c.a aVar) {
        BufferedOutputStream bufferedOutputStream;
        a aVar2;
        long j11 = this.f19369b;
        byte[] bArr = aVar.f19302a;
        long length = j11 + bArr.length;
        int i11 = this.f19371d;
        if (length <= i11 || bArr.length <= i11 * 0.9f) {
            File f11 = f(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(e(f11));
                aVar2 = new a(str, aVar);
            } catch (IOException unused) {
                if (!f11.delete()) {
                    com.android.volley.l.b("Could not clean up file %s", f11.getAbsolutePath());
                }
                h();
            }
            if (!aVar2.d(bufferedOutputStream)) {
                bufferedOutputStream.close();
                com.android.volley.l.b("Failed to write header for %s", f11.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(aVar.f19302a);
            bufferedOutputStream.close();
            aVar2.f19372a = f11.length();
            j(str, aVar2);
            i();
        }
    }

    InputStream d(File file) {
        return new FileInputStream(file);
    }

    OutputStream e(File file) {
        return new FileOutputStream(file);
    }

    public File f(String str) {
        return new File(this.f19370c.get(), g(str));
    }

    @Override // com.android.volley.c
    public synchronized void initialize() {
        long length;
        b bVar;
        synchronized (this) {
            File file = this.f19370c.get();
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    com.android.volley.l.c("Unable to create cache dir %s", file.getAbsolutePath());
                }
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                try {
                    length = file2.length();
                    bVar = new b(new BufferedInputStream(d(file2)), length);
                } catch (IOException unused) {
                    file2.delete();
                }
                try {
                    a b11 = a.b(bVar);
                    b11.f19372a = length;
                    j(b11.f19373b, b11);
                    bVar.close();
                } catch (Throwable th2) {
                    bVar.close();
                    throw th2;
                    break;
                }
            }
        }
    }

    public synchronized void p(String str) {
        boolean delete = f(str).delete();
        q(str);
        if (!delete) {
            com.android.volley.l.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
        }
    }
}
