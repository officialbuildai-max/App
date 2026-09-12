package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes5.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f38337a;

    /* renamed from: b, reason: collision with root package name */
    private final f f38338b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Certificate> f38339c;

    /* renamed from: d, reason: collision with root package name */
    private final List<Certificate> f38340d;

    private o(b0 b0Var, f fVar, List<Certificate> list, List<Certificate> list2) {
        this.f38337a = b0Var;
        this.f38338b = fVar;
        this.f38339c = list;
        this.f38340d = list2;
    }

    public static o a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        f a11 = f.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        b0 a12 = b0.a(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List a13 = certificateArr != null ? com.mbridge.msdk.thrid.okhttp.internal.c.a(certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new o(a12, a11, a13, localCertificates != null ? com.mbridge.msdk.thrid.okhttp.internal.c.a(localCertificates) : Collections.emptyList());
    }

    public f a() {
        return this.f38338b;
    }

    public List<Certificate> b() {
        return this.f38339c;
    }

    public b0 c() {
        return this.f38337a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f38337a.equals(oVar.f38337a) && this.f38338b.equals(oVar.f38338b) && this.f38339c.equals(oVar.f38339c) && this.f38340d.equals(oVar.f38340d);
    }

    public int hashCode() {
        return ((((((this.f38337a.hashCode() + 527) * 31) + this.f38338b.hashCode()) * 31) + this.f38339c.hashCode()) * 31) + this.f38340d.hashCode();
    }
}
