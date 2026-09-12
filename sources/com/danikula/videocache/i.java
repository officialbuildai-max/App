package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
class i extends ProxySelector {

    /* renamed from: d, reason: collision with root package name */
    private static final List f24101d = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: a, reason: collision with root package name */
    private final ProxySelector f24102a;

    /* renamed from: b, reason: collision with root package name */
    private final String f24103b;

    /* renamed from: c, reason: collision with root package name */
    private final int f24104c;

    i(ProxySelector proxySelector, String str, int i11) {
        this.f24102a = (ProxySelector) l.c(proxySelector);
        this.f24103b = (String) l.c(str);
        this.f24104c = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i11) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i11));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f24102a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List select(URI uri) {
        if (this.f24103b.equals(uri.getHost()) && this.f24104c == uri.getPort()) {
            return f24101d;
        }
        try {
            List<Proxy> select = this.f24102a.select(uri);
            return select != null ? select : f24101d;
        } catch (Throwable unused) {
            return f24101d;
        }
    }
}
