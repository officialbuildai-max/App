package com.facebook.biddingkit.logging;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
abstract class g {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final Collection f24184a;

        private b() {
            this.f24184a = new ArrayList();
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void a(String str) {
            this.f24184a.add(str);
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void flush() {
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Iterator it = this.f24184a.iterator();
            while (it.hasNext()) {
                sb2.append((String) it.next());
                sb2.append('\n');
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements d {

        /* renamed from: a, reason: collision with root package name */
        final d f24185a;

        /* renamed from: b, reason: collision with root package name */
        int f24186b;

        c(d dVar, int i11) {
            this.f24185a = dVar;
            this.f24186b = i11;
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void a(String str) {
            if (this.f24186b > 0) {
                this.f24185a.a(str);
                this.f24186b--;
            }
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void flush() {
            this.f24185a.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);

        void flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e extends Writer {

        /* renamed from: a, reason: collision with root package name */
        final d f24187a;

        /* renamed from: b, reason: collision with root package name */
        char[] f24188b = new char[1024];

        /* renamed from: c, reason: collision with root package name */
        int f24189c;

        e(d dVar) {
            this.f24187a = dVar;
        }

        private void d() {
            this.f24187a.a(new String(this.f24188b, 0, this.f24189c));
            this.f24189c = 0;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flush();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            if (this.f24189c > 0) {
                d();
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i11, int i12) {
            for (int i13 = i11; i13 < i11 + i12; i13++) {
                char c11 = cArr[i13];
                if (c11 != '\n') {
                    int i14 = this.f24189c;
                    char[] cArr2 = this.f24188b;
                    if (i14 != cArr2.length) {
                        cArr2[i14] = c11;
                        this.f24189c = i14 + 1;
                    }
                }
                d();
            }
        }
    }

    public static String a(Throwable th2) {
        return b(th2, 100);
    }

    public static String b(Throwable th2, int i11) {
        if (th2 == null) {
            return "";
        }
        try {
            b bVar = new b();
            d cVar = i11 >= 0 ? new c(bVar, i11) : bVar;
            th2.printStackTrace(new PrintWriter(new e(cVar)));
            cVar.flush();
            return bVar.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
