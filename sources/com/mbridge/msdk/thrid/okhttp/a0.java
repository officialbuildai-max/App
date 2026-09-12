package com.mbridge.msdk.thrid.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes5.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    final a f37818a;

    /* renamed from: b, reason: collision with root package name */
    final Proxy f37819b;

    /* renamed from: c, reason: collision with root package name */
    final InetSocketAddress f37820c;

    public a0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f37818a = aVar;
        this.f37819b = proxy;
        this.f37820c = inetSocketAddress;
    }

    public a a() {
        return this.f37818a;
    }

    public Proxy b() {
        return this.f37819b;
    }

    public boolean c() {
        return this.f37818a.f37815i != null && this.f37819b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f37820c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            if (a0Var.f37818a.equals(this.f37818a) && a0Var.f37819b.equals(this.f37819b) && a0Var.f37820c.equals(this.f37820c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f37818a.hashCode() + 527) * 31) + this.f37819b.hashCode()) * 31) + this.f37820c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f37820c + "}";
    }
}
