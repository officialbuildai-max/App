package com.transsion.transfer.androidasync;

import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/* loaded from: classes6.dex */
public class AsyncNetworkSocket implements j {

    /* renamed from: a, reason: collision with root package name */
    InetSocketAddress f55215a;

    /* renamed from: b, reason: collision with root package name */
    private o f55216b;

    /* renamed from: c, reason: collision with root package name */
    private SelectionKey f55217c;

    /* renamed from: d, reason: collision with root package name */
    private AsyncServer f55218d;

    /* renamed from: f, reason: collision with root package name */
    com.transsion.transfer.androidasync.util.a f55220f;

    /* renamed from: g, reason: collision with root package name */
    boolean f55221g;

    /* renamed from: h, reason: collision with root package name */
    bv.j f55222h;

    /* renamed from: i, reason: collision with root package name */
    bv.d f55223i;

    /* renamed from: j, reason: collision with root package name */
    bv.a f55224j;

    /* renamed from: k, reason: collision with root package name */
    boolean f55225k;

    /* renamed from: l, reason: collision with root package name */
    Exception f55226l;

    /* renamed from: m, reason: collision with root package name */
    private bv.a f55227m;

    /* renamed from: e, reason: collision with root package name */
    private ByteBufferList f55219e = new ByteBufferList();

    /* renamed from: n, reason: collision with root package name */
    boolean f55228n = false;

    private void C() {
        if (this.f55219e.r()) {
            a0.a(this, this.f55219e);
        }
    }

    private void g() {
        this.f55217c.cancel();
        try {
            this.f55216b.close();
        } catch (IOException unused) {
        }
    }

    private void k(int i11) {
        if (!this.f55217c.isValid()) {
            throw new IOException(new CancelledKeyException());
        }
        if (i11 > 0) {
            SelectionKey selectionKey = this.f55217c;
            selectionKey.interestOps(selectionKey.interestOps() | 4);
        } else {
            SelectionKey selectionKey2 = this.f55217c;
            selectionKey2.interestOps(selectionKey2.interestOps() & (-5));
        }
    }

    @Override // com.transsion.transfer.androidasync.p
    public bv.d I() {
        return this.f55223i;
    }

    @Override // com.transsion.transfer.androidasync.j, com.transsion.transfer.androidasync.p, com.transsion.transfer.androidasync.s
    public AsyncServer a() {
        return this.f55218d;
    }

    @Override // com.transsion.transfer.androidasync.p
    public void close() {
        g();
        r(null);
    }

    @Override // com.transsion.transfer.androidasync.s
    public void d() {
        this.f55216b.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(SocketChannel socketChannel, InetSocketAddress inetSocketAddress) {
        this.f55215a = inetSocketAddress;
        this.f55220f = new com.transsion.transfer.androidasync.util.a();
        this.f55216b = new z(socketChannel);
    }

    @Override // com.transsion.transfer.androidasync.s
    public bv.j i() {
        return this.f55222h;
    }

    @Override // com.transsion.transfer.androidasync.s
    public boolean isOpen() {
        return this.f55216b.h() && this.f55217c.isValid();
    }

    @Override // com.transsion.transfer.androidasync.p
    public boolean isPaused() {
        return this.f55228n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o j() {
        return this.f55216b;
    }

    @Override // com.transsion.transfer.androidasync.s
    public void l(final ByteBufferList byteBufferList) {
        if (this.f55218d.o() != Thread.currentThread()) {
            this.f55218d.H(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncNetworkSocket.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncNetworkSocket.this.l(byteBufferList);
                }
            });
            return;
        }
        if (this.f55216b.h()) {
            try {
                int C = byteBufferList.C();
                ByteBuffer[] k11 = byteBufferList.k();
                this.f55216b.m(k11);
                byteBufferList.b(k11);
                k(byteBufferList.C());
                this.f55218d.C(C - byteBufferList.C());
            } catch (IOException e11) {
                g();
                w(e11);
                r(e11);
            }
        }
    }

    public void m() {
        if (!this.f55216b.d()) {
            SelectionKey selectionKey = this.f55217c;
            selectionKey.interestOps(selectionKey.interestOps() & (-5));
        }
        bv.j jVar = this.f55222h;
        if (jVar != null) {
            jVar.a();
        }
    }

    @Override // com.transsion.transfer.androidasync.s
    public void o(bv.j jVar) {
        this.f55222h = jVar;
    }

    @Override // com.transsion.transfer.androidasync.s
    public void p(bv.a aVar) {
        this.f55224j = aVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public void pause() {
        if (this.f55218d.o() != Thread.currentThread()) {
            this.f55218d.H(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncNetworkSocket.2
                @Override // java.lang.Runnable
                public void run() {
                    AsyncNetworkSocket.this.pause();
                }
            });
        } else {
            if (this.f55228n) {
                return;
            }
            this.f55228n = true;
            try {
                SelectionKey selectionKey = this.f55217c;
                selectionKey.interestOps(selectionKey.interestOps() & (-2));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        long j11;
        int i11;
        C();
        boolean z10 = false;
        if (this.f55228n) {
            return 0;
        }
        ByteBuffer a11 = this.f55220f.a();
        try {
            j11 = this.f55216b.read(a11);
        } catch (Exception e11) {
            g();
            w(e11);
            r(e11);
            j11 = -1;
        }
        if (j11 < 0) {
            g();
            i11 = 0;
            z10 = true;
        } else {
            i11 = (int) (0 + j11);
        }
        if (j11 > 0) {
            this.f55220f.e(j11);
            a11.flip();
            this.f55219e.a(a11);
            a0.a(this, this.f55219e);
        } else {
            ByteBufferList.A(a11);
        }
        if (z10) {
            w(null);
            r(null);
        }
        return i11;
    }

    protected void r(Exception exc) {
        if (this.f55221g) {
            return;
        }
        this.f55221g = true;
        bv.a aVar = this.f55224j;
        if (aVar != null) {
            aVar.g(exc);
            this.f55224j = null;
        }
    }

    @Override // com.transsion.transfer.androidasync.p
    public void resume() {
        if (this.f55218d.o() != Thread.currentThread()) {
            this.f55218d.H(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncNetworkSocket.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncNetworkSocket.this.resume();
                }
            });
            return;
        }
        if (this.f55228n) {
            this.f55228n = false;
            try {
                SelectionKey selectionKey = this.f55217c;
                selectionKey.interestOps(selectionKey.interestOps() | 1);
            } catch (Exception unused) {
            }
            C();
            if (isOpen()) {
                return;
            }
            w(this.f55226l);
        }
    }

    @Override // com.transsion.transfer.androidasync.p
    public void s(bv.a aVar) {
        this.f55227m = aVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public void t(bv.d dVar) {
        this.f55223i = dVar;
    }

    void u(Exception exc) {
        if (this.f55225k) {
            return;
        }
        this.f55225k = true;
        bv.a aVar = this.f55227m;
        if (aVar != null) {
            aVar.g(exc);
        } else if (exc != null) {
            Log.e("NIO", "Unhandled exception", exc);
        }
    }

    @Override // com.transsion.transfer.androidasync.p
    public String v() {
        return null;
    }

    void w(Exception exc) {
        if (this.f55219e.r()) {
            this.f55226l = exc;
        } else {
            u(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(AsyncServer asyncServer, SelectionKey selectionKey) {
        this.f55218d = asyncServer;
        this.f55217c = selectionKey;
    }
}
