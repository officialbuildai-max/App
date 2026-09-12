package com.transsion.http;

import am.f;
import androidx.annotation.NonNull;
import cm.a;
import com.transsion.http.impl.r;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import wl.b;
import wl.d;
import xl.h;
import xl.j;

/* loaded from: classes5.dex */
public class c implements Runnable, Comparable<c> {

    /* renamed from: a, reason: collision with root package name */
    private final r f45976a;

    /* renamed from: b, reason: collision with root package name */
    private final f f45977b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f45978c = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    private final h f45979d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f45980e;

    public c(b bVar, r rVar) {
        this.f45976a = rVar;
        f d11 = bVar.d();
        this.f45977b = d11;
        this.f45979d = bVar.b();
        new WeakReference(d11.e().m());
    }

    private void b() throws IOException {
        try {
            this.f45977b.g();
            if (a()) {
                this.f45977b.a();
                return;
            }
            byte[] d11 = a.d(a.b(this.f45977b.c()));
            r rVar = this.f45976a;
            if (rVar != null) {
                rVar.c(this.f45977b.f(), d11);
            }
            if (this.f45977b.e().o() && this.f45979d != null) {
                ((xl.b) this.f45979d).c(new d(this.f45977b.e().n()), new j(new xl.a(), ByteBuffer.wrap(d11)));
            }
            this.f45977b.a();
        } catch (Throwable th2) {
            this.f45977b.a();
            throw th2;
        }
    }

    private synchronized void c() {
        r rVar;
        if (!this.f45980e && this.f45978c.get() && (rVar = this.f45976a) != null) {
            rVar.e();
        }
    }

    public boolean a() {
        boolean z10 = this.f45978c.get();
        if (z10) {
            c();
        }
        return z10;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull c cVar) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e5, code lost:
    
        if (r0 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010e, code lost:
    
        if (a() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0110, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0111, code lost:
    
        r0 = r6.f45976a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0113, code lost:
    
        if (r0 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0115, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0118, code lost:
    
        r6.f45980e = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
    
        ((xl.b) r0).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0103, code lost:
    
        if (r0 == null) goto L55;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.http.c.run():void");
    }
}
