package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.q;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.a f38012a;

    /* renamed from: b, reason: collision with root package name */
    private final d f38013b;

    /* renamed from: c, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.d f38014c;

    /* renamed from: d, reason: collision with root package name */
    private final n f38015d;

    /* renamed from: f, reason: collision with root package name */
    private int f38017f;

    /* renamed from: e, reason: collision with root package name */
    private List<Proxy> f38016e = Collections.emptyList();

    /* renamed from: g, reason: collision with root package name */
    private List<InetSocketAddress> f38018g = Collections.emptyList();

    /* renamed from: h, reason: collision with root package name */
    private final List<a0> f38019h = new ArrayList();

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<a0> f38020a;

        /* renamed from: b, reason: collision with root package name */
        private int f38021b = 0;

        a(List<a0> list) {
            this.f38020a = list;
        }

        public List<a0> a() {
            return new ArrayList(this.f38020a);
        }

        public boolean b() {
            return this.f38021b < this.f38020a.size();
        }

        public a0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<a0> list = this.f38020a;
            int i11 = this.f38021b;
            this.f38021b = i11 + 1;
            return list.get(i11);
        }
    }

    public f(com.mbridge.msdk.thrid.okhttp.a aVar, d dVar, com.mbridge.msdk.thrid.okhttp.d dVar2, n nVar) {
        this.f38012a = aVar;
        this.f38013b = dVar;
        this.f38014c = dVar2;
        this.f38015d = nVar;
        a(aVar.k(), aVar.f());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(q qVar, Proxy proxy) {
        if (proxy != null) {
            this.f38016e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f38012a.h().select(qVar.m());
            this.f38016e = (select == null || select.isEmpty()) ? com.mbridge.msdk.thrid.okhttp.internal.c.a(Proxy.NO_PROXY) : com.mbridge.msdk.thrid.okhttp.internal.c.a(select);
        }
        this.f38017f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String g11;
        int j11;
        this.f38018g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            g11 = this.f38012a.k().g();
            j11 = this.f38012a.k().j();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            g11 = a(inetSocketAddress);
            j11 = inetSocketAddress.getPort();
        }
        if (j11 < 1 || j11 > 65535) {
            throw new SocketException("No route to " + g11 + ":" + j11 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f38018g.add(InetSocketAddress.createUnresolved(g11, j11));
            return;
        }
        this.f38015d.dnsStart(this.f38014c, g11);
        List<InetAddress> a11 = this.f38012a.c().a(g11);
        if (a11.isEmpty()) {
            throw new UnknownHostException(this.f38012a.c() + " returned no addresses for " + g11);
        }
        this.f38015d.dnsEnd(this.f38014c, g11, a11);
        int size = a11.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f38018g.add(new InetSocketAddress(a11.get(i11), j11));
        }
    }

    private boolean b() {
        return this.f38017f < this.f38016e.size();
    }

    private Proxy d() throws IOException {
        if (b()) {
            List<Proxy> list = this.f38016e;
            int i11 = this.f38017f;
            this.f38017f = i11 + 1;
            Proxy proxy = list.get(i11);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f38012a.k().g() + "; exhausted proxy configurations: " + this.f38016e);
    }

    public void a(a0 a0Var, IOException iOException) {
        if (a0Var.b().type() != Proxy.Type.DIRECT && this.f38012a.h() != null) {
            this.f38012a.h().connectFailed(this.f38012a.k().m(), a0Var.b().address(), iOException);
        }
        this.f38013b.b(a0Var);
    }

    public boolean a() {
        return b() || !this.f38019h.isEmpty();
    }

    public a c() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy d11 = d();
            int size = this.f38018g.size();
            for (int i11 = 0; i11 < size; i11++) {
                a0 a0Var = new a0(this.f38012a, d11, this.f38018g.get(i11));
                if (this.f38013b.c(a0Var)) {
                    this.f38019h.add(a0Var);
                } else {
                    arrayList.add(a0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f38019h);
            this.f38019h.clear();
        }
        return new a(arrayList);
    }
}
