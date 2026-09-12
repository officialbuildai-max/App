package com.transsion.transfer.androidasync;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f55297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements bv.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f55298a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ByteBufferList f55299b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ bv.a f55300c;

        a(s sVar, ByteBufferList byteBufferList, bv.a aVar) {
            this.f55298a = sVar;
            this.f55299b = byteBufferList;
            this.f55300c = aVar;
        }

        @Override // bv.j
        public void a() {
            this.f55298a.l(this.f55299b);
            if (this.f55299b.C() != 0 || this.f55300c == null) {
                return;
            }
            this.f55298a.o(null);
            this.f55300c.g(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        boolean f55301a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bv.a f55302b;

        b(bv.a aVar) {
            this.f55302b = aVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (this.f55301a) {
                return;
            }
            this.f55301a = true;
            this.f55302b.g(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements bv.j {

        /* renamed from: a, reason: collision with root package name */
        int f55303a = 0;

        /* renamed from: b, reason: collision with root package name */
        ByteBufferList f55304b = new ByteBufferList();

        /* renamed from: c, reason: collision with root package name */
        com.transsion.transfer.androidasync.util.a f55305c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s f55306d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InputStream f55307e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f55308f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ bv.a f55309g;

        c(s sVar, InputStream inputStream, long j11, bv.a aVar) {
            this.f55306d = sVar;
            this.f55307e = inputStream;
            this.f55308f = j11;
            this.f55309g = aVar;
            this.f55305c = new com.transsion.transfer.androidasync.util.a().d((int) Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, j11));
        }

        private void b() {
            this.f55306d.p(null);
            this.f55306d.o(null);
            this.f55304b.B();
            com.transsion.transfer.androidasync.util.d.a(this.f55307e);
        }

        @Override // bv.j
        public void a() {
            do {
                try {
                    if (!this.f55304b.r()) {
                        ByteBuffer a11 = this.f55305c.a();
                        int read = this.f55307e.read(a11.array(), 0, (int) Math.min(this.f55308f - this.f55303a, a11.capacity()));
                        if (read != -1 && this.f55303a != this.f55308f) {
                            this.f55305c.e(read);
                            this.f55303a += read;
                            a11.position(0);
                            a11.limit(read);
                            this.f55304b.a(a11);
                        }
                        b();
                        this.f55309g.g(null);
                        return;
                    }
                    this.f55306d.l(this.f55304b);
                } catch (Exception e11) {
                    b();
                    this.f55309g.g(e11);
                    return;
                }
            } while (!this.f55304b.r());
        }
    }

    /* loaded from: classes6.dex */
    class d implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        boolean f55310a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bv.a f55311b;

        d(bv.a aVar) {
            this.f55311b = aVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (this.f55310a) {
                return;
            }
            this.f55310a = true;
            this.f55311b.g(exc);
        }
    }

    /* loaded from: classes6.dex */
    class e implements bv.j {

        /* renamed from: a, reason: collision with root package name */
        int f55312a = 0;

        /* renamed from: b, reason: collision with root package name */
        ByteBufferList f55313b = new ByteBufferList();

        /* renamed from: c, reason: collision with root package name */
        com.transsion.transfer.androidasync.util.a f55314c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s f55315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InputStream f55316e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f55317f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ bv.a f55318g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ bv.e f55319h;

        e(s sVar, InputStream inputStream, long j11, bv.a aVar, bv.e eVar) {
            this.f55315d = sVar;
            this.f55316e = inputStream;
            this.f55317f = j11;
            this.f55318g = aVar;
            this.f55319h = eVar;
            this.f55314c = new com.transsion.transfer.androidasync.util.a().d((int) Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, j11));
        }

        private void b() {
            this.f55315d.p(null);
            this.f55315d.o(null);
            this.f55313b.B();
            com.transsion.transfer.androidasync.util.d.a(this.f55316e);
        }

        @Override // bv.j
        public void a() {
            do {
                try {
                    if (!this.f55313b.r()) {
                        ByteBuffer a11 = this.f55314c.a();
                        int read = this.f55316e.read(a11.array(), 0, (int) Math.min(this.f55317f - this.f55312a, a11.capacity()));
                        if (read != -1 && this.f55312a != this.f55317f) {
                            this.f55314c.e(read);
                            int i11 = this.f55312a + read;
                            this.f55312a = i11;
                            bv.e eVar = this.f55319h;
                            if (eVar != null) {
                                eVar.a(i11, this.f55317f);
                            }
                            a11.position(0);
                            a11.limit(read);
                            this.f55313b.a(a11);
                        }
                        b();
                        this.f55318g.g(null);
                        bv.e eVar2 = this.f55319h;
                        if (eVar2 != null) {
                            eVar2.b(null);
                            return;
                        }
                        return;
                    }
                    this.f55315d.l(this.f55313b);
                } catch (Exception e11) {
                    b();
                    this.f55318g.g(e11);
                    bv.e eVar3 = this.f55319h;
                    if (eVar3 != null) {
                        eVar3.b(e11);
                        return;
                    }
                    return;
                }
            } while (!this.f55313b.r());
        }
    }

    /* loaded from: classes6.dex */
    class f implements bv.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f55320a;

        f(s sVar) {
            this.f55320a = sVar;
        }

        @Override // bv.d
        public void F(p pVar, ByteBufferList byteBufferList) {
            this.f55320a.l(byteBufferList);
            if (byteBufferList.C() > 0) {
                pVar.pause();
            }
        }
    }

    /* loaded from: classes6.dex */
    class g implements bv.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f55321a;

        g(p pVar) {
            this.f55321a = pVar;
        }

        @Override // bv.j
        public void a() {
            this.f55321a.resume();
        }
    }

    /* loaded from: classes6.dex */
    class h implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        boolean f55322a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f55323b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ s f55324c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bv.a f55325d;

        h(p pVar, s sVar, bv.a aVar) {
            this.f55323b = pVar;
            this.f55324c = sVar;
            this.f55325d = aVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (this.f55322a) {
                return;
            }
            this.f55322a = true;
            this.f55323b.t(null);
            this.f55323b.s(null);
            this.f55324c.p(null);
            this.f55324c.o(null);
            this.f55325d.g(exc);
        }
    }

    /* loaded from: classes6.dex */
    class i implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bv.a f55326a;

        i(bv.a aVar) {
            this.f55326a = aVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (exc == null) {
                exc = new IOException("sink was closed before emitter ended");
            }
            this.f55326a.g(exc);
        }
    }

    public static void a(p pVar, ByteBufferList byteBufferList) {
        int C;
        bv.d dVar = null;
        while (!pVar.isPaused() && (dVar = pVar.I()) != null && (C = byteBufferList.C()) > 0) {
            dVar.F(pVar, byteBufferList);
            if (C == byteBufferList.C() && dVar == pVar.I() && !pVar.isPaused()) {
                System.out.println("handler: " + dVar);
                byteBufferList.B();
                if (!f55297a) {
                    throw new RuntimeException("mDataHandler failed to consume data, yet remains the mDataHandler.");
                }
                return;
            }
        }
        if (byteBufferList.C() == 0 || pVar.isPaused()) {
            return;
        }
        PrintStream printStream = System.out;
        printStream.println("handler: " + dVar);
        printStream.println("emitter: " + pVar);
        byteBufferList.B();
    }

    public static void b(bv.a aVar, Exception exc) {
        if (aVar != null) {
            aVar.g(exc);
        }
    }

    public static void c(p pVar, s sVar, bv.a aVar) {
        pVar.t(new f(sVar));
        sVar.o(new g(pVar));
        h hVar = new h(pVar, sVar, aVar);
        pVar.s(hVar);
        sVar.p(new i(hVar));
    }

    public static void d(InputStream inputStream, long j11, s sVar, bv.a aVar) {
        b bVar = new b(aVar);
        c cVar = new c(sVar, inputStream, j11, bVar);
        sVar.o(cVar);
        sVar.p(bVar);
        cVar.a();
    }

    public static void e(InputStream inputStream, long j11, s sVar, bv.a aVar, bv.e eVar) {
        d dVar = new d(aVar);
        e eVar2 = new e(sVar, inputStream, j11, dVar, eVar);
        sVar.o(eVar2);
        sVar.p(dVar);
        eVar2.a();
    }

    public static void f(InputStream inputStream, s sVar, bv.a aVar) {
        d(inputStream, 2147483647L, sVar, aVar);
    }

    public static void g(s sVar, ByteBufferList byteBufferList, bv.a aVar) {
        a aVar2 = new a(sVar, byteBufferList, aVar);
        sVar.o(aVar2);
        aVar2.a();
    }

    public static void h(s sVar, byte[] bArr, bv.a aVar) {
        ByteBuffer t11 = ByteBufferList.t(bArr.length);
        t11.put(bArr);
        t11.flip();
        ByteBufferList byteBufferList = new ByteBufferList();
        byteBufferList.a(t11);
        g(sVar, byteBufferList, aVar);
    }
}
