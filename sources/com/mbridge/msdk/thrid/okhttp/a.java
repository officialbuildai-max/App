package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.q;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final q f37807a;

    /* renamed from: b, reason: collision with root package name */
    final m f37808b;

    /* renamed from: c, reason: collision with root package name */
    final SocketFactory f37809c;

    /* renamed from: d, reason: collision with root package name */
    final b f37810d;

    /* renamed from: e, reason: collision with root package name */
    final List<u> f37811e;

    /* renamed from: f, reason: collision with root package name */
    final List<i> f37812f;

    /* renamed from: g, reason: collision with root package name */
    final ProxySelector f37813g;

    /* renamed from: h, reason: collision with root package name */
    final Proxy f37814h;

    /* renamed from: i, reason: collision with root package name */
    final SSLSocketFactory f37815i;

    /* renamed from: j, reason: collision with root package name */
    final HostnameVerifier f37816j;

    /* renamed from: k, reason: collision with root package name */
    final e f37817k;

    public a(String str, int i11, m mVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, e eVar, b bVar, Proxy proxy, List<u> list, List<i> list2, ProxySelector proxySelector) {
        this.f37807a = new q.a().e(sSLSocketFactory != null ? "https" : "http").b(str).a(i11).a();
        if (mVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f37808b = mVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f37809c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f37810d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f37811e = com.mbridge.msdk.thrid.okhttp.internal.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f37812f = com.mbridge.msdk.thrid.okhttp.internal.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f37813g = proxySelector;
        this.f37814h = proxy;
        this.f37815i = sSLSocketFactory;
        this.f37816j = hostnameVerifier;
        this.f37817k = eVar;
    }

    public e a() {
        return this.f37817k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.f37808b.equals(aVar.f37808b) && this.f37810d.equals(aVar.f37810d) && this.f37811e.equals(aVar.f37811e) && this.f37812f.equals(aVar.f37812f) && this.f37813g.equals(aVar.f37813g) && com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37814h, aVar.f37814h) && com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37815i, aVar.f37815i) && com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37816j, aVar.f37816j) && com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37817k, aVar.f37817k) && k().j() == aVar.k().j();
    }

    public List<i> b() {
        return this.f37812f;
    }

    public m c() {
        return this.f37808b;
    }

    public HostnameVerifier d() {
        return this.f37816j;
    }

    public List<u> e() {
        return this.f37811e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f37807a.equals(aVar.f37807a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public Proxy f() {
        return this.f37814h;
    }

    public b g() {
        return this.f37810d;
    }

    public ProxySelector h() {
        return this.f37813g;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f37807a.hashCode() + 527) * 31) + this.f37808b.hashCode()) * 31) + this.f37810d.hashCode()) * 31) + this.f37811e.hashCode()) * 31) + this.f37812f.hashCode()) * 31) + this.f37813g.hashCode()) * 31;
        Proxy proxy = this.f37814h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f37815i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f37816j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        e eVar = this.f37817k;
        return hashCode4 + (eVar != null ? eVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f37809c;
    }

    public SSLSocketFactory j() {
        return this.f37815i;
    }

    public q k() {
        return this.f37807a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f37807a.g());
        sb2.append(":");
        sb2.append(this.f37807a.j());
        if (this.f37814h != null) {
            sb2.append(", proxy=");
            sb2.append(this.f37814h);
        } else {
            sb2.append(", proxySelector=");
            sb2.append(this.f37813g);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
