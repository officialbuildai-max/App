package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Route;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final Address f40586a;

    /* renamed from: b, reason: collision with root package name */
    private final com.squareup.okhttp.internal.f f40587b;

    /* renamed from: c, reason: collision with root package name */
    private Proxy f40588c;

    /* renamed from: d, reason: collision with root package name */
    private InetSocketAddress f40589d;

    /* renamed from: f, reason: collision with root package name */
    private int f40591f;

    /* renamed from: h, reason: collision with root package name */
    private int f40593h;

    /* renamed from: e, reason: collision with root package name */
    private List f40590e = Collections.emptyList();

    /* renamed from: g, reason: collision with root package name */
    private List f40592g = Collections.emptyList();

    /* renamed from: i, reason: collision with root package name */
    private final List f40594i = new ArrayList();

    public l(Address address, com.squareup.okhttp.internal.f fVar) {
        this.f40586a = address;
        this.f40587b = fVar;
        l(address.url(), address.getProxy());
    }

    static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean d() {
        return this.f40593h < this.f40592g.size();
    }

    private boolean e() {
        return !this.f40594i.isEmpty();
    }

    private boolean f() {
        return this.f40591f < this.f40590e.size();
    }

    private InetSocketAddress h() {
        if (d()) {
            List list = this.f40592g;
            int i11 = this.f40593h;
            this.f40593h = i11 + 1;
            return (InetSocketAddress) list.get(i11);
        }
        throw new SocketException("No route to " + this.f40586a.getUriHost() + "; exhausted inet socket addresses: " + this.f40592g);
    }

    private Route i() {
        return (Route) this.f40594i.remove(0);
    }

    private Proxy j() {
        if (f()) {
            List list = this.f40590e;
            int i11 = this.f40591f;
            this.f40591f = i11 + 1;
            Proxy proxy = (Proxy) list.get(i11);
            k(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f40586a.getUriHost() + "; exhausted proxy configurations: " + this.f40590e);
    }

    private void k(Proxy proxy) {
        String uriHost;
        int uriPort;
        this.f40592g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            uriHost = this.f40586a.getUriHost();
            uriPort = this.f40586a.getUriPort();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            uriHost = b(inetSocketAddress);
            uriPort = inetSocketAddress.getPort();
        }
        if (uriPort < 1 || uriPort > 65535) {
            throw new SocketException("No route to " + uriHost + ":" + uriPort + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f40592g.add(InetSocketAddress.createUnresolved(uriHost, uriPort));
        } else {
            List<InetAddress> lookup = this.f40586a.getDns().lookup(uriHost);
            int size = lookup.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f40592g.add(new InetSocketAddress(lookup.get(i11), uriPort));
            }
        }
        this.f40593h = 0;
    }

    private void l(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f40590e = Collections.singletonList(proxy);
        } else {
            this.f40590e = new ArrayList();
            List<Proxy> select = this.f40586a.getProxySelector().select(httpUrl.uri());
            if (select != null) {
                this.f40590e.addAll(select);
            }
            List list = this.f40590e;
            Proxy proxy2 = Proxy.NO_PROXY;
            list.removeAll(Collections.singleton(proxy2));
            this.f40590e.add(proxy2);
        }
        this.f40591f = 0;
    }

    public void a(Route route, IOException iOException) {
        if (route.getProxy().type() != Proxy.Type.DIRECT && this.f40586a.getProxySelector() != null) {
            this.f40586a.getProxySelector().connectFailed(this.f40586a.url().uri(), route.getProxy().address(), iOException);
        }
        this.f40587b.b(route);
    }

    public boolean c() {
        return d() || f() || e();
    }

    public Route g() {
        if (!d()) {
            if (!f()) {
                if (e()) {
                    return i();
                }
                throw new NoSuchElementException();
            }
            this.f40588c = j();
        }
        InetSocketAddress h11 = h();
        this.f40589d = h11;
        Route route = new Route(this.f40586a, this.f40588c, h11);
        if (!this.f40587b.c(route)) {
            return route;
        }
        this.f40594i.add(route);
        return g();
    }
}
