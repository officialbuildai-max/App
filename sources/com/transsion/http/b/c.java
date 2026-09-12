package com.transsion.http.b;

import am.f;
import android.os.Looper;
import androidx.annotation.NonNull;
import cm.d;
import com.transsion.http.impl.DownloadCallback;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import xl.e;

/* loaded from: classes5.dex */
public class c implements Runnable, Comparable<c> {

    /* renamed from: a, reason: collision with root package name */
    final wl.b f45961a;

    /* renamed from: b, reason: collision with root package name */
    final DownloadCallback f45962b;

    /* renamed from: c, reason: collision with root package name */
    private String f45963c;

    /* renamed from: d, reason: collision with root package name */
    private String f45964d;

    /* renamed from: g, reason: collision with root package name */
    private final Object f45967g;

    /* renamed from: h, reason: collision with root package name */
    private String f45968h;

    /* renamed from: i, reason: collision with root package name */
    private long f45969i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f45970j;

    /* renamed from: k, reason: collision with root package name */
    private f f45971k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f45972l;

    /* renamed from: m, reason: collision with root package name */
    private final wl.c f45973m;

    /* renamed from: n, reason: collision with root package name */
    private a f45974n;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f45965e = new AtomicBoolean();

    /* renamed from: f, reason: collision with root package name */
    private final e f45966f = new e();

    /* renamed from: o, reason: collision with root package name */
    private long f45975o = 0;

    public c(wl.b bVar, DownloadCallback downloadCallback) {
        this.f45961a = bVar;
        this.f45962b = downloadCallback;
        this.f45970j = bVar.c().k();
        this.f45967g = bVar.c().m();
        this.f45963c = bVar.c().i();
        String n11 = bVar.c().n();
        this.f45968h = n11;
        this.f45973m = new wl.c(n11);
    }

    private File a(f fVar) throws Throwable {
        FileOutputStream fileOutputStream;
        long j11;
        BufferedInputStream bufferedInputStream;
        this.f45966f.a(this.f45973m);
        this.f45964d = this.f45963c + ".tmp";
        File file = new File(this.f45964d);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("can not create dir: " + parentFile.getAbsolutePath());
            }
        } else if (this.f45970j) {
            this.f45975o = file.length();
        }
        this.f45961a.c().f().put("RANGE", "bytes=" + this.f45975o + "-");
        if (c()) {
            return null;
        }
        fVar.g();
        this.f45969i = fVar.b();
        InputStream c11 = fVar.c();
        File file2 = new File(this.f45964d);
        if (this.f45970j) {
            j11 = this.f45975o;
            fileOutputStream = new FileOutputStream(file2, true);
        } else {
            fileOutputStream = new FileOutputStream(file2);
            j11 = 0;
        }
        long j12 = this.f45969i + j11;
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(c11);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        if (c()) {
            return null;
        }
        DownloadCallback downloadCallback = this.f45962b;
        if (downloadCallback != null) {
            downloadCallback.y(this.f45971k.f(), this.f45968h, j11, j12);
        }
        byte[] bArr = new byte[4096];
        while (true) {
            int read = bufferedInputStream2.read(bArr);
            if (read == -1) {
                bufferedOutputStream.flush();
                d.a(bufferedInputStream2);
                d.a(bufferedOutputStream);
                this.f45966f.b(this.f45973m);
                if (!this.f45963c.equals(this.f45964d)) {
                    File file3 = new File(this.f45963c);
                    if (file2.renameTo(file3)) {
                        return file3;
                    }
                }
                return file2;
            }
            if (!file2.getParentFile().exists()) {
                d.a(bufferedInputStream2);
                d.a(bufferedOutputStream);
                d.a(fileOutputStream);
                this.f45966f.b(this.f45973m);
                throw new IOException("parent be deleted!");
            }
            bufferedOutputStream.write(bArr, 0, read);
            j11 += read;
            if (c()) {
                return null;
            }
            DownloadCallback downloadCallback2 = this.f45962b;
            if (downloadCallback2 != null) {
                bufferedInputStream = bufferedInputStream2;
                downloadCallback2.y(this.f45971k.f(), this.f45968h, j11, j12);
            } else {
                bufferedInputStream = bufferedInputStream2;
            }
            bufferedInputStream2 = bufferedInputStream;
        }
    }

    private void e() {
        if (this.f45971k != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new b(this)).start();
            } else {
                this.f45971k.a();
            }
        }
    }

    private synchronized void f() {
        DownloadCallback downloadCallback;
        if (!this.f45972l && this.f45965e.get() && (downloadCallback = this.f45962b) != null) {
            downloadCallback.e();
        }
    }

    private synchronized void g() {
        DownloadCallback downloadCallback;
        if (!this.f45972l && this.f45965e.get() && (downloadCallback = this.f45962b) != null) {
            downloadCallback.u();
        }
    }

    public void a(a aVar) {
    }

    public boolean a() {
        bm.a.f16706a.d("book", "cancel by tag");
        this.f45965e.set(true);
        f();
        e();
        return c();
    }

    public Object b() {
        return this.f45967g;
    }

    public boolean c() {
        return this.f45965e.get();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull c cVar) {
        return 0;
    }

    public boolean d() {
        this.f45965e.set(true);
        e();
        boolean z10 = this.f45965e.get();
        if (z10) {
            g();
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r7 = this;
            boolean r0 = r7.c()
            if (r0 == 0) goto L8
            goto Lb4
        L8:
            com.transsion.http.impl.DownloadCallback r0 = r7.f45962b
            if (r0 == 0) goto Lf
            r0.a()
        Lf:
            wl.b r0 = r7.f45961a
            am.f r0 = r0.d()
            r7.f45971k = r0
            r1 = 0
            java.io.File r3 = r7.a(r0)     // Catch: java.lang.Throwable -> L43
            if (r3 == 0) goto L45
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L45
            long r4 = r3.length()     // Catch: java.lang.Throwable -> L43
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L45
            boolean r4 = r7.c()     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L35
            goto La0
        L35:
            com.transsion.http.impl.DownloadCallback r4 = r7.f45962b     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto La0
            int r5 = r0.f()     // Catch: java.lang.Throwable -> L43
            java.lang.String r6 = r7.f45968h     // Catch: java.lang.Throwable -> L43
            r4.A(r5, r6, r3)     // Catch: java.lang.Throwable -> L43
            goto La0
        L43:
            r3 = move-exception
            goto L5c
        L45:
            boolean r3 = r7.c()     // Catch: java.lang.Throwable -> L43
            if (r3 == 0) goto L4c
            goto La0
        L4c:
            com.transsion.http.impl.DownloadCallback r3 = r7.f45962b     // Catch: java.lang.Throwable -> L43
            if (r3 == 0) goto La0
            int r4 = r0.f()     // Catch: java.lang.Throwable -> L43
            java.lang.String r5 = r7.f45968h     // Catch: java.lang.Throwable -> L43
            java.lang.String r6 = "file is null"
            r3.w(r4, r5, r6)     // Catch: java.lang.Throwable -> L43
            goto La0
        L5c:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = r7.f45963c     // Catch: java.lang.Throwable -> L86
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.exists()     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L88
            long r5 = r4.length()     // Catch: java.lang.Throwable -> L86
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 <= 0) goto L88
            boolean r1 = r7.c()     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto L78
            goto La0
        L78:
            com.transsion.http.impl.DownloadCallback r1 = r7.f45962b     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto La0
            int r2 = r0.f()     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = r7.f45968h     // Catch: java.lang.Throwable -> L86
            r1.A(r2, r3, r4)     // Catch: java.lang.Throwable -> L86
            goto La0
        L86:
            r1 = move-exception
            goto Lb5
        L88:
            boolean r1 = r7.c()     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto L8f
            goto La0
        L8f:
            com.transsion.http.impl.DownloadCallback r1 = r7.f45962b     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto La0
            int r2 = r0.f()     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = r7.f45968h     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L86
            r1.w(r2, r4, r3)     // Catch: java.lang.Throwable -> L86
        La0:
            r0.a()
            boolean r0 = r7.c()
            if (r0 == 0) goto Laa
            goto Lb4
        Laa:
            com.transsion.http.impl.DownloadCallback r0 = r7.f45962b
            if (r0 == 0) goto Lb1
            r0.b()
        Lb1:
            r0 = 1
            r7.f45972l = r0
        Lb4:
            return
        Lb5:
            r0.a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.http.b.c.run():void");
    }
}
