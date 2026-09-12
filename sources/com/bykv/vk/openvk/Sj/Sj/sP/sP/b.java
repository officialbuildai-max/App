package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
class b extends ProxySelector {

    /* renamed from: d, reason: collision with root package name */
    private static final List f20325d = Collections.singletonList(Proxy.NO_PROXY);

    /* renamed from: a, reason: collision with root package name */
    private final ProxySelector f20326a = ProxySelector.getDefault();

    /* renamed from: b, reason: collision with root package name */
    private final String f20327b;

    /* renamed from: c, reason: collision with root package name */
    private final int f20328c;

    private b(String str, int i11) {
        this.f20327b = str;
        this.f20328c = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i11) {
        ProxySelector.setDefault(new b(str, i11));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f20326a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List select(URI uri) {
        if (uri != null) {
            return (this.f20327b.equalsIgnoreCase(uri.getHost()) && this.f20328c == uri.getPort()) ? f20325d : this.f20326a.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
